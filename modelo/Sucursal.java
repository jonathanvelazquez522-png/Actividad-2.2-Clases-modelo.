package edu.utj.dsm.vehiculos.modelo;

import java.util.Objects;

/**
 * Representa una sucursal física de la arrendadora.
 *
 * @author Velazquez Aviña Jonathan
 */
public final class Sucursal {
    private Integer idSucursal;
    private String nombreSucursal;
    private String direccion;
    private String telefono;
    private int capacidadVehiculos;
    private String estadoSucursal;

    /** Constructor vacío para instanciación por defecto. */
    public Sucursal() { }

    /**
     * Crea una sucursal con datos de identificación, contacto y capacidad.
     * @param idSucursal identificador primario positivo o null
     * @param nombreSucursal nombre de sucursal
     * @param direccion dirección física
     * @param telefono teléfono
     * @param capacidadVehiculos capacidad no negativa
     * @param estadoSucursal estado operativo
     */
    public Sucursal(Integer idSucursal, String nombreSucursal, String direccion, String telefono,
                    int capacidadVehiculos, String estadoSucursal) {
        setIdSucursal(idSucursal); setNombreSucursal(nombreSucursal); setDireccion(direccion);
        setTelefono(telefono); setCapacidadVehiculos(capacidadVehiculos); setEstadoSucursal(estadoSucursal);
    }

    /** @return id de sucursal */
    public Integer getIdSucursal() { return idSucursal; }
    /** @param idSucursal id positivo o null */
    public void setIdSucursal(Integer idSucursal) {
        if (idSucursal != null && idSucursal <= 0) throw new IllegalArgumentException("idSucursal debe ser positivo o null.");
        this.idSucursal = idSucursal;
    }
    /** @return nombre */
    public String getNombreSucursal() { return nombreSucursal; }
    /** @param nombreSucursal nombre obligatorio */
    public void setNombreSucursal(String nombreSucursal) { this.nombreSucursal = requerido(nombreSucursal, "nombreSucursal"); }
    /** @return dirección */
    public String getDireccion() { return direccion; }
    /** @param direccion dirección obligatoria */
    public void setDireccion(String direccion) { this.direccion = requerido(direccion, "direccion"); }
    /** @return teléfono */
    public String getTelefono() { return telefono; }
    /** @param telefono teléfono obligatorio */
    public void setTelefono(String telefono) { this.telefono = requerido(telefono, "telefono"); }
    /** @return capacidad */
    public int getCapacidadVehiculos() { return capacidadVehiculos; }
    /** @param capacidadVehiculos capacidad no negativa */
    public void setCapacidadVehiculos(int capacidadVehiculos) {
        if (capacidadVehiculos < 0) throw new IllegalArgumentException("La capacidad no puede ser negativa.");
        this.capacidadVehiculos = capacidadVehiculos;
    }
    /** @return estado operativo */
    public String getEstadoSucursal() { return estadoSucursal; }
    /** @param estadoSucursal estado obligatorio */
    public void setEstadoSucursal(String estadoSucursal) { this.estadoSucursal = requerido(estadoSucursal, "estadoSucursal"); }

    private static String requerido(String valor, String campo) {
        if (valor == null || valor.isBlank()) throw new IllegalArgumentException(campo + " es obligatorio.");
        return valor.trim();
    }

    /** @return todos los atributos de la sucursal */
    @Override
    public String toString() {
        return "Sucursal{idSucursal=" + idSucursal + ", nombreSucursal='" + nombreSucursal + "', direccion='" + direccion
                + "', telefono='" + telefono + "', capacidadVehiculos=" + capacidadVehiculos
                + ", estadoSucursal='" + estadoSucursal + "'}";
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

    if (!(objeto instanceof Sucursal)) {
        return false;
    }

    Sucursal otro = (Sucursal) objeto;

    return idSucursal != null && idSucursal.equals(otro.idSucursal);
}
    
    /** @return hash basado exclusivamente en idSucursal */
    @Override
    public int hashCode() { return Objects.hashCode(idSucursal); }
}
