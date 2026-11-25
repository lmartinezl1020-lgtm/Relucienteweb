package com.reluciente.model;

public class Servicio {
    private int idServicio;
    private String nombre;
    private String descripcion;
    private double precioBase;
    private String estado;

    public Servicio() {
    }

    public Servicio(String nombre, String descripcion, double precioBase, String estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.estado = estado;
    }

    public Servicio(int idServicio, String nombre, String descripcion, double precioBase, String estado) {
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.estado = estado;
    }

    // Getters y Setters
    public int getIdServicio() { return idServicio; }
    public void setIdServicio(int idServicio) { this.idServicio = idServicio; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecioBase() { return precioBase; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}