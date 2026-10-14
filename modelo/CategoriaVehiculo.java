package edu.utj.dsm.vehiculos.modelo;

import java.util.Objects;

/**
 * Representa una categoría de vehículos y sus importes de renta y garantía.
 *
 * @author Velazquez Aviña Jonathan
 */
public final class CategoriaVehiculo {
    private Integer idCategoria;
    private String nombreCategoria;
    private double tarifaDiaria;
    private double depositoGarantia;
    private String estadoCategoria;

    /** Constructor vacío para instanciación por defecto. */
    public CategoriaVehiculo() { }

    /**
     * Crea una categoría con nombre, tarifa y depósito.
     * @param idCategoria identificador primario positivo o null
     * @param nombreCategoria nombre de categoría
     * @param tarifaDiaria tarifa diaria no negativa
     * @param depositoGarantia depósito no negativo
     * @param estadoCategoria estado de la categoría
     */
    public CategoriaVehiculo(Integer idCategoria, String nombreCategoria, double tarifaDiaria,
                             double depositoGarantia, String estadoCategoria) {
        setIdCategoria(idCategoria); setNombreCategoria(nombreCategoria);
        setTarifaDiaria(tarifaDiaria); setDepositoGarantia(depositoGarantia);
        setEstadoCategoria(estadoCategoria);
    }

    /** @return id de categoría */
    public Integer getIdCategoria() { return idCategoria; }
    /** @param idCategoria id positivo o null */
    public void setIdCategoria(Integer idCategoria) {
        if (idCategoria != null && idCategoria <= 0) throw new IllegalArgumentException("idCategoria debe ser positivo o null.");
        this.idCategoria = idCategoria;
    }
    /** @return nombre de categoría */
    public String getNombreCategoria() { return nombreCategoria; }
    /** @param nombreCategoria nombre obligatorio */
    public void setNombreCategoria(String nombreCategoria) { this.nombreCategoria = requerido(nombreCategoria, "nombreCategoria"); }
    /** @return tarifa diaria */
    public double getTarifaDiaria() { return tarifaDiaria; }
    /** @param tarifaDiaria tarifa no negativa */
    public void setTarifaDiaria(double tarifaDiaria) {
        if (!Double.isFinite(tarifaDiaria) || tarifaDiaria < 0) throw new IllegalArgumentException("La tarifa debe ser no negativa.");
        this.tarifaDiaria = tarifaDiaria;
    }
    /** @return depósito de garantía */
    public double getDepositoGarantia() { return depositoGarantia; }
    /** @param depositoGarantia depósito no negativo */
    public void setDepositoGarantia(double depositoGarantia) {
        if (!Double.isFinite(depositoGarantia) || depositoGarantia < 0) throw new IllegalArgumentException("El depósito debe ser no negativo.");
        this.depositoGarantia = depositoGarantia;
    }
    /** @return estado de categoría */
    public String getEstadoCategoria() { return estadoCategoria; }
    /** @param estadoCategoria estado obligatorio */
    public void setEstadoCategoria(String estadoCategoria) { this.estadoCategoria = requerido(estadoCategoria, "estadoCategoria"); }

    private static String requerido(String valor, String campo) {
        if (valor == null || valor.isBlank()) throw new IllegalArgumentException(campo + " es obligatorio.");
        return valor.trim();
    }

    /** @return todos los atributos de la categoría */
    @Override
    public String toString() {
        return "CategoriaVehiculo{idCategoria=" + idCategoria + ", nombreCategoria='" + nombreCategoria
                + "', tarifaDiaria=" + tarifaDiaria + ", depositoGarantia=" + depositoGarantia
                + ", estadoCategoria='" + estadoCategoria + "'}";
    }
    /** @param objeto objeto que se comparará @return true si coincide idCategoria */
    @Override
public boolean equals(Object objeto) {
    if (this == objeto) {
        return true;
    }

    if (!(objeto instanceof CategoriaVehiculo)) {
        return false;
    }

    CategoriaVehiculo otro = (CategoriaVehiculo) objeto;

    return idCategoria  != null && idCategoria.equals(otro.idCategoria);
}
    
    /** @return hash basado exclusivamente en idCategoria */
    @Override
    public int hashCode() { return Objects.hashCode(idCategoria); }
}
