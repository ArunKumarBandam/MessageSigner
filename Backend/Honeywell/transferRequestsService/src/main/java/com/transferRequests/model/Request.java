package com.transferRequests.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "request")
public class Request {

	@Transient
    public static final String SEQUENCE_NAME = "transfer_sequence";
	
	
	@Id
	private int requestId;
	private int patientId;
	private int fromRoomId;
	private int toRoomId;
	private String dateOfReq;
	private String reqStatus;
	
	public Request() {
		super();
	}
	public Request(int requestId, int patientId, int fromRoomId, int toRoomId, String dateOfReq, String reqStatus) {
		super();
		this.requestId = requestId;
		this.patientId = patientId;
		this.fromRoomId = fromRoomId;
		this.toRoomId = toRoomId;
		this.dateOfReq = dateOfReq;
		this.reqStatus = reqStatus;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getFromRoomId() {
		return fromRoomId;
	}
	public void setFromRoomId(int fromRoomId) {
		this.fromRoomId = fromRoomId;
	}
	public int getToRoomId() {
		return toRoomId;
	}
	public void setToRoomId(int toRoomId) {
		this.toRoomId = toRoomId;
	}
	public String getDateOfReq() {
		return dateOfReq;
	}
	public void setDateOfReq(String dateOfReq) {
		this.dateOfReq = dateOfReq;
	}
	public String getReqStatus() {
		return reqStatus;
	}
	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}
	
}
