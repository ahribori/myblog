package com.aribori.blog.exception;

public class AuthenticateFailureException extends Exception {

	private static final long serialVersionUID = 536456782377520639L;

	public AuthenticateFailureException() {
		super();
	}

	public AuthenticateFailureException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AuthenticateFailureException(String message, Throwable cause) {
		super(message, cause);
	}

	public AuthenticateFailureException(String message) {
		super(message);
	}

	public AuthenticateFailureException(Throwable cause) {
		super(cause);
	}

	
}
