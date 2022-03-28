package br.com.labqa.mvc.dto;

import javax.persistence.Entity;

import br.com.labqa.mvc.model.Usuario;

public class ResponseSucess {
	
	private String mensagemSucesso;
	private Usuario pedido;
	
	public String getMensagemSucesso() {
		return mensagemSucesso;
	}
	public void setMensagemSucesso(String mensagemSucesso) {
		this.mensagemSucesso = mensagemSucesso;
	}
	public Usuario getPedido() {
		return pedido;
	}
	public void setPedido(Usuario pedido) {
		this.pedido = pedido;
	}


}
