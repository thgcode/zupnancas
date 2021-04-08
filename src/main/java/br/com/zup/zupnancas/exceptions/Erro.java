package br.com.zup.zupnancas.exceptions;

public class Erro {
    private String campo;
    private String mensagem;

    public Erro(String mensagem) {
        this(null, mensagem);
    }

    public Erro(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
