package edu.utj.dsm.vehiculos.modelo;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Representa a una persona que puede reservar y rentar vehículos.
 *
 * @author Velazquez Aviña Jonathan
 */
public final class Cliente extends Persona {
    private String licenciaConducir;
    private LocalDate fechaVencimientoLicencia;
    private String metodoPagoPreferido;
    private String estadoCliente;

    /** Constructor vacío para instanciación por defecto. */
    public Cliente() { super(); }

    /**
     * Crea un cliente con sus datos de persona y licencia.
     * @param idPersona identificador de la persona
     * @param nombre nombre
     * @param identificacion identificación
     * @param correo correo
     * @param telefono teléfono
     * @param direccion dirección
     * @param estadoPersona estado general de persona
     * @param licenciaConducir licencia de conducir
     * @param fechaVencimientoLicencia fecha de vencimiento de licencia
     * @param metodoPagoPreferido método de pago preferido
     * @param estadoCliente estado del cliente
     */
    public Cliente(Integer idPersona, String nombre, String identificacion, String correo, String telefono,
                   String direccion, String estadoPersona, String licenciaConducir,
                   LocalDate fechaVencimientoLicencia, String metodoPagoPreferido, String estadoCliente) {
        super(idPersona, nombre, identificacion, correo, telefono, direccion, estadoPersona);
        setLicenciaConducir(licenciaConducir);
        setFechaVencimientoLicencia(fechaVencimientoLicencia);
        setMetodoPagoPreferido(metodoPagoPreferido);
        setEstadoCliente(estadoCliente);
    }

    /** @return licencia de conducir */
    public String getLicenciaConducir() { return licenciaConducir; }
    /** @param licenciaConducir licencia obligatoria */
    public void setLicenciaConducir(String licenciaConducir) {
        if (licenciaConducir == null || licenciaConducir.isBlank()) throw new IllegalArgumentException("La licencia es obligatoria.");
        this.licenciaConducir = licenciaConducir.trim();
    }
    /** @return vencimiento de licencia */
    public LocalDate getFechaVencimientoLicencia() { return fechaVencimientoLicencia; }
    /** @param fechaVencimientoLicencia fecha futura o actual */
    public void setFechaVencimientoLicencia(LocalDate fechaVencimientoLicencia) {
        if (fechaVencimientoLicencia == null) throw new IllegalArgumentException("La fecha de vencimiento es obligatoria.");
        this.fechaVencimientoLicencia = fechaVencimientoLicencia;
    }
    /** @return método de pago preferido */
    public String getMetodoPagoPreferido() { return metodoPagoPreferido; }
    /** @param metodoPagoPreferido método de pago */
    public void setMetodoPagoPreferido(String metodoPagoPreferido) {
        if (metodoPagoPreferido == null || metodoPagoPreferido.isBlank()) throw new IllegalArgumentException("El método de pago es obligatorio.");
        this.metodoPagoPreferido = metodoPagoPreferido.trim();
    }
    /** @return estado del cliente */
    public String getEstadoCliente() { return estadoCliente; }
    /** @param estadoCliente estado de negocio del cliente */
    public void setEstadoCliente(String estadoCliente) {
        if (estadoCliente == null || estadoCliente.isBlank()) throw new IllegalArgumentException("El estado del cliente es obligatorio.");
        this.estadoCliente = estadoCliente.trim();
    }

    /** @return estado heredado y atributos propios del cliente */
    @Override
    public String toString() {
        return "Cliente{" + super.toString() + ", licenciaConducir='" + licenciaConducir
                + "', fechaVencimientoLicencia=" + fechaVencimientoLicencia
                + ", metodoPagoPreferido='" + metodoPagoPreferido + "', estadoCliente='" + estadoCliente + "'}";
    }

    /** @param objeto objeto que se comparará @return true si coincide el idPersona */
    @Override
public boolean equals(Object objeto) {
    if (this == objeto) {
        return true;
    }

    if (!(objeto instanceof Cliente)) {
        return false;
    }

    Cliente otro = (Cliente) objeto;

    return getIdPersona()  != null && getIdPersona().equals(otro.getIdPersona());
}
   
    /** @return hash basado exclusivamente en idPersona */
    @Override
    public int hashCode() { return Objects.hashCode(getIdPersona()); }
}
