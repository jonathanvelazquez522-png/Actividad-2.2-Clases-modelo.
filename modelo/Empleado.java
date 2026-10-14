package edu.utj.dsm.vehiculos.modelo;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Representa a una persona contratada por la arrendadora.
 *
 * @author Velazquez Aviña Jonathan
 */
public class Empleado extends Persona {
    private String codigoEmpleado;
    private String puesto;
    private LocalDate fechaContratacion;
    private Integer idSucursal;
    private String estadoEmpleado;

    /** Constructor vacío para instanciación por defecto. */
    public Empleado() { super(); }

    /**
     * Crea un empleado con sus datos personales y laborales mínimos.
     * @param idPersona identificador de persona
     * @param nombre nombre
     * @param identificacion identificación
     * @param correo correo
     * @param telefono teléfono
     * @param direccion dirección
     * @param estadoPersona estado general de persona
     * @param codigoEmpleado código laboral
     * @param puesto puesto
     * @param fechaContratacion fecha de contratación
     * @param idSucursal sucursal asignada
     * @param estadoEmpleado estado laboral
     */
    public Empleado(Integer idPersona, String nombre, String identificacion, String correo, String telefono,
                    String direccion, String estadoPersona, String codigoEmpleado, String puesto,
                    LocalDate fechaContratacion, Integer idSucursal, String estadoEmpleado) {
        super(idPersona, nombre, identificacion, correo, telefono, direccion, estadoPersona);
        setCodigoEmpleado(codigoEmpleado);
        setPuesto(puesto);
        setFechaContratacion(fechaContratacion);
        setIdSucursal(idSucursal);
        setEstadoEmpleado(estadoEmpleado);
    }

    /** @return código de empleado */
    public String getCodigoEmpleado() { return codigoEmpleado; }
    /** @param codigoEmpleado código obligatorio */
    public void setCodigoEmpleado(String codigoEmpleado) {
        if (codigoEmpleado == null || codigoEmpleado.isBlank()) throw new IllegalArgumentException("El código de empleado es obligatorio.");
        this.codigoEmpleado = codigoEmpleado.trim();
    }
    /** @return puesto laboral */
    public String getPuesto() { return puesto; }
    /** @param puesto puesto obligatorio */
    public void setPuesto(String puesto) {
        if (puesto == null || puesto.isBlank()) throw new IllegalArgumentException("El puesto es obligatorio.");
        this.puesto = puesto.trim();
    }
    /** @return fecha de contratación */
    public LocalDate getFechaContratacion() { return fechaContratacion; }
    /** @param fechaContratacion fecha de contratación */
    public void setFechaContratacion(LocalDate fechaContratacion) {
        if (fechaContratacion == null) throw new IllegalArgumentException("La fecha de contratación es obligatoria.");
        this.fechaContratacion = fechaContratacion;
    }
    /** @return id de sucursal */
    public Integer getIdSucursal() { return idSucursal; }
    /** @param idSucursal identificador positivo de sucursal */
    public void setIdSucursal(Integer idSucursal) {
        if (idSucursal == null || idSucursal <= 0) throw new IllegalArgumentException("idSucursal debe ser positivo.");
        this.idSucursal = idSucursal;
    }
    /** @return estado laboral */
    public String getEstadoEmpleado() { return estadoEmpleado; }
    /** @param estadoEmpleado estado laboral */
    public void setEstadoEmpleado(String estadoEmpleado) {
        if (estadoEmpleado == null || estadoEmpleado.isBlank()) throw new IllegalArgumentException("El estado del empleado es obligatorio.");
        this.estadoEmpleado = estadoEmpleado.trim();
    }

    /** @return atributos heredados y propios del empleado */
    @Override
    public String toString() {
        return "Empleado{" + super.toString() + ", codigoEmpleado='" + codigoEmpleado + "', puesto='" + puesto
                + "', fechaContratacion=" + fechaContratacion + ", idSucursal=" + idSucursal
                + ", estadoEmpleado='" + estadoEmpleado + "'}";
    }
    /** @param objeto objeto que se comparará @return true si coincide el idPersona */
   @Override
public boolean equals(Object objeto) {
    if (this == objeto) {
        return true;
    }

    if (!(objeto instanceof Empleado)) {
        return false;
    }

    Empleado otro = (Empleado) objeto;

    return getIdPersona() != null && getIdPersona().equals(otro.getIdPersona());
}
    
    /** @return hash basado exclusivamente en idPersona */
    @Override
    public int hashCode() { return Objects.hashCode(getIdPersona()); }
}
