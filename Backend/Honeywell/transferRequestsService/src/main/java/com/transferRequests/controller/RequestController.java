package com.transferRequests.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.transferRequests.model.Request;
import com.transferRequests.repository.RequestRepository;
import com.transferRequests.service.RequestService;

@RestController
@RequestMapping("/transfers")
@CrossOrigin(origins="http://localhost:4200")
public class RequestController {

	@Autowired
	private RequestService requestService;
	
	@PostMapping("/addRequest")
	public Request requestFromRoomToRoom(@RequestBody Request request) {
		return requestService.saveReqFromRoomToRoom(request);
	}
	
	@GetMapping("/viewAllReq")
	public List<Request> getAllReq() {
		return requestService.viewAllReq();
	}
	
	@GetMapping("/viewReqByReqId/{requestId}")
	public Request getReqByRequestId(@PathVariable int requestId) {
		return requestService.viewReqByReqId(requestId);
	}
	@GetMapping("/viewReqByPatientId/{patientId}")
	public Request getReqByPatientId(@PathVariable int patientId) {
		return requestService.viewReqByPatientId(patientId);
	}
	@PutMapping("/updateReqStatusPatientId/{patientId}")
	public Request getUpdateReqStatus(@PathVariable int patientId,@RequestBody Request request){
		  return requestService.updateReqStatus(patientId,request);
	}
	@DeleteMapping("/rejectByReqId/{requestId}")
	public String rejectByReqId(@PathVariable int requestId) {
		return requestService.deleteByReqId(requestId);
		
	}
	
	@PutMapping("/approveReqByReqId/{requestId}")
	public Request getApproveByReqId(@PathVariable int requestId,@RequestBody Request request) {
		return requestService.approveByReqId(requestId,request);
	}

}
