package edu.utj.dsm.vehiculos.modelo;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Representa un servicio de mantenimiento asociado a un vehículo.
 *
 * @author Velazquez Aviña Jonathan
 */
public final class Mantenimiento {
    private Integer idMantenimiento;
    private String vinVehiculo;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalidaPrevista;
    private String descripcionServicio;
    private double costoTotal;
    private String tallerResponsable;
    private String estadoMantenimiento;

    /** Constructor vacío para instanciación por defecto. */
    public Mantenimiento() { }

    /**
     * Crea un registro de mantenimiento con vehículo, fechas y servicio.
     * @param idMantenimiento identificador primario positivo o null
     * @param vinVehiculo VIN del vehículo
     * @param fechaIngreso fecha de ingreso
     * @param fechaSalidaPrevista fecha prevista de salida
     * @param descripcionServicio descripción del servicio
     * @param costoTotal costo no negativo
     * @param tallerResponsable taller responsable
     * @param estadoMantenimiento estado del mantenimiento
     */
    public Mantenimiento(Integer idMantenimiento, String vinVehiculo, LocalDate fechaIngreso,
                         LocalDate fechaSalidaPrevista, String descripcionServicio, double costoTotal,
                         String tallerResponsable, String estadoMantenimiento) {
        setIdMantenimiento(idMantenimiento); setVinVehiculo(vinVehiculo); setFechaIngreso(fechaIngreso);
        setFechaSalidaPrevista(fechaSalidaPrevista); setDescripcionServicio(descripcionServicio);
        setCostoTotal(costoTotal); setTallerResponsable(tallerResponsable); setEstadoMantenimiento(estadoMantenimiento);
    }

    /** @return id de mantenimiento */
    public Integer getIdMantenimiento() { return idMantenimiento; }
    /** @param idMantenimiento id positivo o null */
    public void setIdMantenimiento(Integer idMantenimiento) {
        if (idMantenimiento != null && idMantenimiento <= 0) throw new IllegalArgumentException("idMantenimiento debe ser positivo o null.");
        this.idMantenimiento = idMantenimiento;
    }
    /** @return VIN del vehículo */
    public String getVinVehiculo() { return vinVehiculo; }
    /** @param vinVehiculo VIN obligatorio */
    public void setVinVehiculo(String vinVehiculo) { this.vinVehiculo = requerido(vinVehiculo, "vinVehiculo"); }
    /** @return fecha de ingreso */
    public LocalDate getFechaIngreso() { return fechaIngreso; }
    /** @param fechaIngreso fecha obligatoria */
    public void setFechaIngreso(LocalDate fechaIngreso) {
        if (fechaIngreso == null) throw new IllegalArgumentException("La fecha de ingreso es obligatoria.");
        if (fechaSalidaPrevista != null && fechaSalidaPrevista.isBefore(fechaIngreso)) throw new IllegalArgumentException("La salida prevista no puede ser anterior al ingreso.");
        this.fechaIngreso = fechaIngreso;
    }
    /** @return fecha prevista de salida */
    public LocalDate getFechaSalidaPrevista() { return fechaSalidaPrevista; }
    /** @param fechaSalidaPrevista fecha no anterior al ingreso */
    public void setFechaSalidaPrevista(LocalDate fechaSalidaPrevista) {
        if (fechaSalidaPrevista == null) throw new IllegalArgumentException("La fecha prevista de salida es obligatoria.");
        if (fechaIngreso != null && fechaSalidaPrevista.isBefore(fechaIngreso)) throw new IllegalArgumentException("La salida prevista no puede ser anterior al ingreso.");
        this.fechaSalidaPrevista = fechaSalidaPrevista;
    }
    /** @return descripción del servicio */
    public String getDescripcionServicio() { return descripcionServicio; }
    /** @param descripcionServicio descripción obligatoria */
    public void setDescripcionServicio(String descripcionServicio) { this.descripcionServicio = requerido(descripcionServicio, "descripcionServicio"); }
    /** @return costo total */
    public double getCostoTotal() { return costoTotal; }
    /** @param costoTotal costo no negativo */
    public void setCostoTotal(double costoTotal) {
        if (!Double.isFinite(costoTotal) || costoTotal < 0) throw new IllegalArgumentException("El costo debe ser no negativo.");
        this.costoTotal = costoTotal;
    }
    /** @return taller responsable */
    public String getTallerResponsable() { return tallerResponsable; }
    /** @param tallerResponsable taller obligatorio */
    public void setTallerResponsable(String tallerResponsable) { this.tallerResponsable = requerido(tallerResponsable, "tallerResponsable"); }
    /** @return estado del mantenimiento */
    public String getEstadoMantenimiento() { return estadoMantenimiento; }
    /** @param estadoMantenimiento estado obligatorio */
    public void setEstadoMantenimiento(String estadoMantenimiento) { this.estadoMantenimiento = requerido(estadoMantenimiento, "estadoMantenimiento"); }

    private static String requerido(String valor, String campo) {
        if (valor == null || valor.isBlank()) throw new IllegalArgumentException(campo + " es obligatorio.");
        return valor.trim();
    }

    /** @return todos los atributos del mantenimiento */
    @Override
    public String toString() {
        return "Mantenimiento{idMantenimiento=" + idMantenimiento + ", vinVehiculo='" + vinVehiculo
                + "', fechaIngreso=" + fechaIngreso + ", fechaSalidaPrevista=" + fechaSalidaPrevista
                + ", descripcionServicio='" + descripcionServicio + "', costoTotal=" + costoTotal
                + ", tallerResponsable='" + tallerResponsable + "', estadoMantenimiento='" + estadoMantenimiento + "'}";
    }
    /** @param objeto objeto que se comparará @return true si coincide idMantenimiento */
    @Override
public boolean equals(Object objeto) {
    if (this == objeto) {
        return true;
    }

    if (!(objeto instanceof Mantenimiento)) {
        return false;
    }

    Mantenimiento otro = (Mantenimiento) objeto;

    return idMantenimiento != null && idMantenimiento.equals(otro.idMantenimiento);
}
   
    /** @return hash basado exclusivamente en idMantenimiento */
    @Override
    public int hashCode() { return Objects.hashCode(idMantenimiento); }
}
