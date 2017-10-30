package py.edu.ucsa.rest.api.util;

public class ErrorDTO {
	public String mensajeError;
	
	
	public ErrorDTO(String mensajeError) {
		this.mensajeError = mensajeError;
	}


	public String getMensajeError() {
		return mensajeError;
	}
	
	
}
