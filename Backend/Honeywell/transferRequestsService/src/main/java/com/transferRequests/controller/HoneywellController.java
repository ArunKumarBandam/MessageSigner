package com.transferRequests.controller;
import org.springframework.web.bind.annotation.*;

import com.transferRequests.model.MessageRequest;
import com.transferRequests.model.VerificationRequest;

import java.security.*;
import java.util.Base64;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HoneywellController {

    private final KeyPair keyPair;

    public HoneywellController() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        this.keyPair = keyGen.generateKeyPair();
    }

    @PostMapping("/sign")
    public String signMessage(@RequestBody MessageRequest request) throws Exception {
        Signature privateSignature = Signature.getInstance("SHA256withRSA");
        privateSignature.initSign(keyPair.getPrivate());
        privateSignature.update(request.getMessage().getBytes("UTF-8"));

        byte[] signature = privateSignature.sign();
        return Base64.getEncoder().encodeToString(signature);
    }
    
    @PostMapping("/verify")
    public boolean verifySignature(@RequestBody VerificationRequest request) throws Exception {
        Signature publicSignature = Signature.getInstance("SHA256withRSA");
        publicSignature.initVerify(keyPair.getPublic());
        publicSignature.update(request.getMessage().getBytes("UTF-8"));

        byte[] signatureBytes = Base64.getDecoder().decode(request.getSignature());
        return publicSignature.verify(signatureBytes);
    }
}
