import React, { useState } from 'react';
import axios from 'axios';

function App() {
  const [message, setMessage] = useState('');
  const [signature, setSignature] = useState('');
  const [verificationResult, setVerificationResult] = useState(null);

  const handleSubmit = async () => {
    try {
      const response = await axios.post('http://localhost:9089/sign', { message });
      setSignature(response.data);
      setVerificationResult(null); // Clear previous result
    } catch (error) {
      console.error('Error signing message:', error);
    }
  };

  const handleVerify = async () => {
    try {
      const response = await axios.post('http://localhost:9089/verify', {
        message,
        signature
      });
      setVerificationResult(response.data);
    } catch (error) {
      console.error('Error verifying signature:', error);
    }
  };

  return (
    <div style={{ padding: '20px' }}>
      <h2>Message Signer & Verifier</h2>
      <input
        type="text"
        value={message}
        onChange={(e) => setMessage(e.target.value)}
        placeholder="Enter message"
        style={{ width: '300px', marginRight: '10px' }}
      />
      <button onClick={handleSubmit}>Sign</button>

      {signature && (
        <>
          <div style={{ marginTop: '20px' }}>
            <h3>Signature (Base64):</h3>
            <textarea rows={6} style={{ width: '100%' }} readOnly value={signature} />
          </div>
          <button onClick={handleVerify} style={{ marginTop: '10px' }}>
            Verify
          </button>
        </>
      )}

      {verificationResult !== null && (
        <div style={{ marginTop: '20px', color: verificationResult ? 'green' : 'red' }}>
          <h3>Verification Result: {verificationResult ? '✅ Valid' : '❌ Invalid'}</h3>
        </div>
      )}
    </div>
  );
}

export default App;
