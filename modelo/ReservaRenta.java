package edu.utj.dsm.vehiculos.modelo;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Representa la reserva o renta de un vehículo entre fechas y sucursales.
 *
 * @author Velazquez Aviña Jonathan
 */
public final class ReservaRenta {
    private Integer idReserva;
    private Integer idCliente;
    private Integer idEmpleado;
    private String vinVehiculo;
    private Integer idSucursalRetiro;
    private Integer idSucursalDevolucion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double montoTotal;
    private String estadoReserva;

    /** Constructor vacío para instanciación por defecto. */
    public ReservaRenta() { }

    /**
     * Crea una reserva con referencias, periodo, importe y estado.
     * @param idReserva identificador primario positivo o null
     * @param idCliente cliente asociado
     * @param idEmpleado empleado responsable
     * @param vinVehiculo VIN del vehículo
     * @param idSucursalRetiro sucursal de retiro
     * @param idSucursalDevolucion sucursal de devolución
     * @param fechaInicio fecha inicial
     * @param fechaFin fecha final posterior o igual a la inicial
     * @param montoTotal importe no negativo
     * @param estadoReserva estado de la reserva
     */
    public ReservaRenta(Integer idReserva, Integer idCliente, Integer idEmpleado, String vinVehiculo,
                        Integer idSucursalRetiro, Integer idSucursalDevolucion, LocalDate fechaInicio,
                        LocalDate fechaFin, double montoTotal, String estadoReserva) {
        setIdReserva(idReserva); setIdCliente(idCliente); setIdEmpleado(idEmpleado); setVinVehiculo(vinVehiculo);
        setIdSucursalRetiro(idSucursalRetiro); setIdSucursalDevolucion(idSucursalDevolucion);
        setFechaInicio(fechaInicio); setFechaFin(fechaFin); setMontoTotal(montoTotal); setEstadoReserva(estadoReserva);
    }

    /** @return id de reserva */
    public Integer getIdReserva() { return idReserva; }
    /** @param idReserva id positivo o null */
    public void setIdReserva(Integer idReserva) {
        if (idReserva != null && idReserva <= 0) throw new IllegalArgumentException("idReserva debe ser positivo o null.");
        this.idReserva = idReserva;
    }
    /** @return id del cliente */
    public Integer getIdCliente() { return idCliente; }
    /** @param idCliente id positivo */
    public void setIdCliente(Integer idCliente) { this.idCliente = positivo(idCliente, "idCliente"); }
    /** @return id del empleado */
    public Integer getIdEmpleado() { return idEmpleado; }
    /** @param idEmpleado id positivo */
    public void setIdEmpleado(Integer idEmpleado) { this.idEmpleado = positivo(idEmpleado, "idEmpleado"); }
    /** @return VIN del vehículo */
    public String getVinVehiculo() { return vinVehiculo; }
    /** @param vinVehiculo VIN obligatorio */
    public void setVinVehiculo(String vinVehiculo) { this.vinVehiculo = requerido(vinVehiculo, "vinVehiculo"); }
    /** @return id de sucursal de retiro */
    public Integer getIdSucursalRetiro() { return idSucursalRetiro; }
    /** @param idSucursalRetiro id positivo */
    public void setIdSucursalRetiro(Integer idSucursalRetiro) { this.idSucursalRetiro = positivo(idSucursalRetiro, "idSucursalRetiro"); }
    /** @return id de sucursal de devolución */
    public Integer getIdSucursalDevolucion() { return idSucursalDevolucion; }
    /** @param idSucursalDevolucion id positivo */
    public void setIdSucursalDevolucion(Integer idSucursalDevolucion) { this.idSucursalDevolucion = positivo(idSucursalDevolucion, "idSucursalDevolucion"); }
    /** @return fecha de inicio */
    public LocalDate getFechaInicio() { return fechaInicio; }
    /** @param fechaInicio fecha inicial obligatoria */
    public void setFechaInicio(LocalDate fechaInicio) {
        if (fechaInicio == null) throw new IllegalArgumentException("La fecha de inicio es obligatoria.");
        if (fechaFin != null && fechaFin.isBefore(fechaInicio)) throw new IllegalArgumentException("La fecha de inicio no puede superar la fecha final.");
        this.fechaInicio = fechaInicio;
    }
    /** @return fecha final */
    public LocalDate getFechaFin() { return fechaFin; }
    /** @param fechaFin fecha final obligatoria y no anterior al inicio */
    public void setFechaFin(LocalDate fechaFin) {
        if (fechaFin == null) throw new IllegalArgumentException("La fecha final es obligatoria.");
        if (fechaInicio != null && fechaFin.isBefore(fechaInicio)) throw new IllegalArgumentException("La fecha final no puede ser anterior al inicio.");
        this.fechaFin = fechaFin;
    }
    /** @return monto total */
    public double getMontoTotal() { return montoTotal; }
    /** @param montoTotal monto no negativo */
    public void setMontoTotal(double montoTotal) {
        if (!Double.isFinite(montoTotal) || montoTotal < 0) throw new IllegalArgumentException("El monto debe ser no negativo.");
        this.montoTotal = montoTotal;
    }
    /** @return estado de reserva */
    public String getEstadoReserva() { return estadoReserva; }
    /** @param estadoReserva estado obligatorio */
    public void setEstadoReserva(String estadoReserva) { this.estadoReserva = requerido(estadoReserva, "estadoReserva"); }

    private static Integer positivo(Integer valor, String campo) {
        if (valor == null || valor <= 0) throw new IllegalArgumentException(campo + " debe ser positivo.");
        return valor;
    }
    private static String requerido(String valor, String campo) {
        if (valor == null || valor.isBlank()) throw new IllegalArgumentException(campo + " es obligatorio.");
        return valor.trim();
    }

    /** @return todos los atributos de la reserva */
    @Override
    public String toString() {
        return "ReservaRenta{idReserva=" + idReserva + ", idCliente=" + idCliente + ", idEmpleado=" + idEmpleado
                + ", vinVehiculo='" + vinVehiculo + "', idSucursalRetiro=" + idSucursalRetiro
                + ", idSucursalDevolucion=" + idSucursalDevolucion + ", fechaInicio=" + fechaInicio
                + ", fechaFin=" + fechaFin + ", montoTotal=" + montoTotal + ", estadoReserva='" + estadoReserva + "'}";
    }
    /** @param objeto objeto que se comparará @return true si coincide idReserva */
    @Override
public boolean equals(Object objeto) {
    if (this == objeto) {
        return true;
    }

    if (!(objeto instanceof ReservaRenta)) {
        return false;
    }

    ReservaRenta otro = (ReservaRenta) objeto;

    return idReserva != null && idReserva.equals(otro.idReserva);
}
    /** @return hash basado exclusivamente en idReserva */
    @Override
    public int hashCode() { return Objects.hashCode(idReserva); }
}
