package org.example.model;

import javax.persistence.*;

@Entity
public class Resultado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String parametroNumero;
    private int parametroMultiplicador;
    private int resultado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Resultado(String number, int i, int i1) {
    }

    public Resultado() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParametroNumero() {
        return parametroNumero;
    }

    public void setParametroNumero(String parametroNumero) {
        this.parametroNumero = parametroNumero;
    }

    public int getParametroMultiplicador() {
        return parametroMultiplicador;
    }

    public void setParametroMultiplicador(int parametroMultiplicador) {
        this.parametroMultiplicador = parametroMultiplicador;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}


