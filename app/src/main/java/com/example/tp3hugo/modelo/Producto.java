package com.example.tp3hugo.modelo;

public class Producto implements Comparable<Producto> {
    private String codigo;
    private String descripcion;
    private double precio;

    public Producto(String codigo, String descripcion, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    @Override
    public int compareTo(Producto p){
        if (p == null) return 1;
        String a = descripcion ==null? "": descripcion;
        String b = p.descripcion == null? "": p.descripcion;
        return a.compareToIgnoreCase(b);
    }

}
