package org.tech4.vackrugerns.ws.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModeloNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8812794528738039301L;

	public ModeloNotFoundException(String mensaje) {
		super(mensaje);
	}

}
