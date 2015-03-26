/**
 * 
 */
package com.amstatz.education.restapi.entity;

/**
 * @author jeremycurran
 *
 */
public class ServiceResponse {
	private String responseMsg;
	private String responseStatus;
	
	public String getResponseMsg() {
		return responseMsg;
	}
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	public String getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
}
