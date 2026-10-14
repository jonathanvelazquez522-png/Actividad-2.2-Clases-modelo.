package edu.utj.dsm.vehiculos.modelo;

import java.util.Objects;

/**
 * Clase base abstracta que representa los datos generales y el estado de una persona.
 * No se instancia directamente; sirve como base de Cliente y Empleado.
 *
 * @author Velazquez Aviña Jonathan
 */
public abstract class Persona {
    private Integer idPersona;
    private String nombre;
    private String identificacion;
    private String correo;
    private String telefono;
    private String direccion;
    private String estadoPersona;

    /** Constructor vacío para instanciación por defecto. */
    public Persona() {
    }

    /**
     * Crea una persona con los datos mínimos de identidad y contacto.
     * @param idPersona identificador primario positivo o null si aún no se asigna
     * @param nombre nombre completo
     * @param identificacion documento de identificación
     * @param correo correo electrónico
     * @param telefono teléfono
     * @param direccion dirección
     * @param estadoPersona estado de la persona
     */
    public Persona(Integer idPersona, String nombre, String identificacion, String correo,
                   String telefono, String direccion, String estadoPersona) {
        setIdPersona(idPersona);
        setNombre(nombre);
        setIdentificacion(identificacion);
        setCorreo(correo);
        setTelefono(telefono);
        setDireccion(direccion);
        setEstadoPersona(estadoPersona);
    }

    /** @return identificador de la persona */
    public Integer getIdPersona() { return idPersona; }
    /** @param idPersona identificador positivo o null */
    public void setIdPersona(Integer idPersona) {
        if (idPersona != null && idPersona <= 0) throw new IllegalArgumentException("idPersona debe ser positivo o null.");
        this.idPersona = idPersona;
    }

    /** @return nombre */
    public String getNombre() { return nombre; }
    /** @param nombre nombre obligatorio */
    public void setNombre(String nombre) { this.nombre = textoObligatorio(nombre, "nombre"); }

    /** @return identificación */
    public String getIdentificacion() { return identificacion; }
    /** @param identificacion identificación obligatoria */
    public void setIdentificacion(String identificacion) { this.identificacion = textoObligatorio(identificacion, "identificación"); }

    /** @return correo */
    public String getCorreo() { return correo; }
    /** @param correo correo electrónico con formato básico */
    public void setCorreo(String correo) {
        if (correo == null || !correo.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$"))
            throw new IllegalArgumentException("El correo no tiene un formato válido.");
        this.correo = correo.trim();
    }

    /** @return teléfono */
    public String getTelefono() { return telefono; }
    /** @param telefono teléfono obligatorio */
    public void setTelefono(String telefono) { this.telefono = textoObligatorio(telefono, "teléfono"); }

    /** @return dirección */
    public String getDireccion() { return direccion; }
    /** @param direccion dirección obligatoria */
    public void setDireccion(String direccion) { this.direccion = textoObligatorio(direccion, "dirección"); }

    /** @return estado de la persona */
    public String getEstadoPersona() { return estadoPersona; }
    /** @param estadoPersona estado, por ejemplo Activo, Inactivo o Bloqueado */
    public void setEstadoPersona(String estadoPersona) { this.estadoPersona = textoObligatorio(estadoPersona, "estadoPersona"); }

    private static String textoObligatorio(String valor, String campo) {
        if (valor == null || valor.isBlank()) throw new IllegalArgumentException(campo + " es obligatorio.");
        return valor.trim();
    }

    /** @return representación de todos los atributos de Persona */
    @Override
    public String toString() {
        return "Persona{idPersona=" + idPersona + ", nombre='" + nombre + "', identificacion='" + identificacion
                + "', correo='" + correo + "', telefono='" + telefono + "', direccion='" + direccion
                + "', estadoPersona='" + estadoPersona + "'}";
    }

    /**
     * Compara personas por el identificador primario idPersona.
     * @param objeto objeto que se comparará
     * @return true si es la misma instancia o si el idPersona no nulo coincide
     */
    @Override
public boolean equals(Object objeto) {
    if (this == objeto) {
        return true;
    }

    if (!(objeto instanceof Persona)) {
        return false;
    }

    Persona otro = (Persona) objeto;

    return idPersona  != null && idPersona.equals(otro.idPersona);
}
    

    /** @return hash calculado exclusivamente con idPersona */
    @Override
    public int hashCode() { return Objects.hashCode(idPersona); }
}
