package main;

import java.util.Observable;
import java.util.Observer;

public class Usuario implements Observer {
    private String nome;
    private String notificacao;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getNotificacao() {
        return notificacao;
    }

    public void inscrever(Distribuidora distribuidora){
        distribuidora.addObserver(this);
    }

    @Override
    public void update(Observable distribuidora, Object arg) {
        this.notificacao = "Sr.(a) temos uma novidade confira abaixo " + distribuidora.toString();
    }
}
