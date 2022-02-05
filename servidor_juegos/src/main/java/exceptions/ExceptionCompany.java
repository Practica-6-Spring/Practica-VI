package exceptions;

public class ExceptionCompany {

	private String mensaje;
	int code;

	public ExceptionCompany(String mensaje, int code) {
		super();
		this.mensaje = mensaje;
		this.code = code;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}

	

