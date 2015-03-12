package com.stellarcodes.websockets.bean;

public class ResponseWrapper {

	private String responseSuccess;
	private String responseError;
	private String responseInfo;
	private String responseWarning;
	private Object result;

	public String getResponseSuccess() {
		return responseSuccess;
	}

	public void setResponseSuccess(String responseSuccess) {
		this.responseSuccess = responseSuccess;
	}

	public String getResponseError() {
		return responseError;
	}

	public void setResponseError(String responseError) {
		this.responseError = responseError;
	}

	public String getResponseInfo() {
		return responseInfo;
	}

	public void setResponseInfo(String responseInfo) {
		this.responseInfo = responseInfo;
	}

	public String getResponseWarning() {
		return responseWarning;
	}

	public void setResponseWarning(String responseWarning) {
		this.responseWarning = responseWarning;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
