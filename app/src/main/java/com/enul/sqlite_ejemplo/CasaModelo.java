package com.enul.sqlite_ejemplo;

public class CasaModelo {
    private String codigo,descripcion;
    private int imgCasa;

    public CasaModelo() {
    }

    public CasaModelo(String codigo, String descripcion, int imgCasa) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.imgCasa = imgCasa;
    }

    public CasaModelo(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImgCasa() {
        return imgCasa;
    }

    public void setImgCasa(int imgCasa) {
        this.imgCasa = imgCasa;
    }
}
