package edu.utj.dsm.vehiculos.modelo;

import java.util.Objects;

/**
 * Representa un vehículo administrado por la arrendadora.
 *
 * @author Velazquez Aviña Jonathan
 */
public final class Vehiculo {
    private Integer idVehiculo;
    private String vin;
    private String placa;
    private String marca;
    private String modelo;
    private int anio;
    private double kilometraje;
    private Integer idCategoria;
    private Integer idSucursal;
    private String estadoVehiculo;

    /** Constructor vacío para instanciación por defecto. */
    public Vehiculo() { }

    /**
     * Crea un vehículo con los datos indispensables de identificación y ubicación.
     * @param idVehiculo identificador primario positivo o null
     * @param vin número VIN único
     * @param placa placa del vehículo
     * @param marca marca
     * @param modelo modelo
     * @param anio año de fabricación
     * @param kilometraje kilometraje actual no negativo
     * @param idCategoria categoría asignada
     * @param idSucursal sucursal donde se encuentra
     * @param estadoVehiculo estado operativo
     */
    public Vehiculo(Integer idVehiculo, String vin, String placa, String marca, String modelo,
                    int anio, double kilometraje, Integer idCategoria, Integer idSucursal, String estadoVehiculo) {
        setIdVehiculo(idVehiculo);
        setVin(vin); setPlaca(placa); setMarca(marca); setModelo(modelo);
        setAnio(anio); setKilometraje(kilometraje); setIdCategoria(idCategoria);
        setIdSucursal(idSucursal); setEstadoVehiculo(estadoVehiculo);
    }

    /** @return id del vehículo */
    public Integer getIdVehiculo() { return idVehiculo; }
    /** @param idVehiculo id positivo o null */
    public void setIdVehiculo(Integer idVehiculo) {
        if (idVehiculo != null && idVehiculo <= 0) throw new IllegalArgumentException("idVehiculo debe ser positivo o null.");
        this.idVehiculo = idVehiculo;
    }
    /** @return VIN */
    public String getVin() { return vin; }
    /** @param vin VIN no vacío */
    public void setVin(String vin) { this.vin = requerido(vin, "vin"); }
    /** @return placa */
    public String getPlaca() { return placa; }
    /** @param placa placa no vacía */
    public void setPlaca(String placa) { this.placa = requerido(placa, "placa"); }
    /** @return marca */
    public String getMarca() { return marca; }
    /** @param marca marca no vacía */
    public void setMarca(String marca) { this.marca = requerido(marca, "marca"); }
    /** @return modelo */
    public String getModelo() { return modelo; }
    /** @param modelo modelo no vacío */
    public void setModelo(String modelo) { this.modelo = requerido(modelo, "modelo"); }
    /** @return año */
    public int getAnio() { return anio; }
    /** @param anio año razonable de fabricación */
    public void setAnio(int anio) {
        if (anio < 1886 || anio > 2100) throw new IllegalArgumentException("El año del vehículo no es válido.");
        this.anio = anio;
    }
    /** @return kilometraje */
    public double getKilometraje() { return kilometraje; }
    /** @param kilometraje kilometraje no negativo */
    public void setKilometraje(double kilometraje) {
        if (!Double.isFinite(kilometraje) || kilometraje < 0) throw new IllegalArgumentException("El kilometraje debe ser no negativo.");
        this.kilometraje = kilometraje;
    }
    /** @return id de categoría */
    public Integer getIdCategoria() { return idCategoria; }
    /** @param idCategoria id positivo */
    public void setIdCategoria(Integer idCategoria) {
        if (idCategoria == null || idCategoria <= 0) throw new IllegalArgumentException("idCategoria debe ser positivo.");
        this.idCategoria = idCategoria;
    }
    /** @return id de sucursal */
    public Integer getIdSucursal() { return idSucursal; }
    /** @param idSucursal id positivo */
    public void setIdSucursal(Integer idSucursal) {
        if (idSucursal == null || idSucursal <= 0) throw new IllegalArgumentException("idSucursal debe ser positivo.");
        this.idSucursal = idSucursal;
    }
    /** @return estado operativo */
    public String getEstadoVehiculo() { return estadoVehiculo; }
    /** @param estadoVehiculo estado obligatorio */
    public void setEstadoVehiculo(String estadoVehiculo) { this.estadoVehiculo = requerido(estadoVehiculo, "estadoVehiculo"); }

    private static String requerido(String valor, String campo) {
        if (valor == null || valor.isBlank()) throw new IllegalArgumentException(campo + " es obligatorio.");
        return valor.trim();
    }

    /** @return todos los atributos del vehículo */
    @Override
    public String toString() {
        return "Vehiculo{idVehiculo=" + idVehiculo + ", vin='" + vin + "', placa='" + placa + "', marca='" + marca
                + "', modelo='" + modelo + "', anio=" + anio + ", kilometraje=" + kilometraje
                + ", idCategoria=" + idCategoria + ", idSucursal=" + idSucursal
                + ", estadoVehiculo='" + estadoVehiculo + "'}";
    }
    
/**
 * Compara este usuario con otro mediante su identificador.
 * @param objeto objeto que se comparará
 * @return true si ambos usuarios tienen el mismo idUsuario
 */
@Override
public boolean equals(Object objeto) {
    if (this == objeto) {
        return true;
    }

    if (!(objeto instanceof Vehiculo)) {
        return false;
    }

    Vehiculo otro = (Vehiculo) objeto;

    return idVehiculo != null && idVehiculo.equals(otro.idVehiculo);
}

    /** @return hash basado exclusivamente en idVehiculo */
    @Override
    public int hashCode() { return Objects.hashCode(idVehiculo); }
}
