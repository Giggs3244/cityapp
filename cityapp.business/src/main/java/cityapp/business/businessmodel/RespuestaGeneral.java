package cityapp.business.businessmodel;

import java.util.ArrayList;
import java.util.List;

public class RespuestaGeneral {

	private int codigo;
	private List<String> mensajes = new ArrayList<>();;

	public RespuestaGeneral() {

	}

	public RespuestaGeneral(int codigo, String mensaje) {
		super();
		this.codigo = codigo;
		this.mensajes.add(mensaje);
	}

	public void addErrorMessage(String mensaje) {
		this.mensajes.add(mensaje);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public List<String> getMensaje() {
		return mensajes;
	}

	public void setMensaje(List<String> mensajes) {
		this.mensajes = mensajes;
	}

}
