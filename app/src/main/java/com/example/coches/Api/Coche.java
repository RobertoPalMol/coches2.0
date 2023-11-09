package com.example.coches.Api;

public class Coche {
    private int id;
    private String Coche;
    private String tienda;
    private String precio;
    private int velocidad;
    private String imagen;

    public Coche(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  String getCoche() {
        return Coche;
    }

    public void setCoche(String nombre) {
        this.Coche = nombre;
    }

    public  String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    public  String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public  int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public  String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Coche(int id, String Coche, String tienda, String precio, int velocidad, String imagen) {
        this.id = id;
        this.Coche = Coche;
        this.tienda = tienda;
        this.precio = precio;
        this.velocidad = velocidad;
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Coche: #" + id + ": " + Coche + " - Tienda: " + tienda + ", Precio: " + precio + ", Velocidad: " + velocidad + " km/h";
    }
}

