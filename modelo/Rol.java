package edu.utj.dsm.vehiculos.modelo;

import java.util.Objects;

/**
 * Representa un conjunto de permisos asignable a una cuenta del sistema.
 *
 * @author Velazquez Aviña Jonathan
 */
public final class Rol {
    private Integer idRol;
    private String nombreRol;
    private String descripcion;
    private int nivelPermisos;
    private String estadoRol;

    /** Constructor vacío para instanciación por defecto. */
    public Rol() { }

    /**
     * Crea un rol con nombre, descripción, nivel y estado.
     * @param idRol identificador primario positivo o null
     * @param nombreRol nombre del rol
     * @param descripcion descripción del rol
     * @param nivelPermisos nivel entero no negativo
     * @param estadoRol estado del rol
     */
    public Rol(Integer idRol, String nombreRol, String descripcion, int nivelPermisos, String estadoRol) {
        setIdRol(idRol);
        setNombreRol(nombreRol);
        setDescripcion(descripcion);
        setNivelPermisos(nivelPermisos);
        setEstadoRol(estadoRol);
    }

    /** @return id del rol */
    public Integer getIdRol() { return idRol; }
    /** @param idRol identificador positivo o null */
    public void setIdRol(Integer idRol) {
        if (idRol != null && idRol <= 0) throw new IllegalArgumentException("idRol debe ser positivo o null.");
        this.idRol = idRol;
    }
    /** @return nombre del rol */
    public String getNombreRol() { return nombreRol; }
    /** @param nombreRol nombre obligatorio */
    public void setNombreRol(String nombreRol) { this.nombreRol = requerido(nombreRol, "nombreRol"); }
    /** @return descripción */
    public String getDescripcion() { return descripcion; }
    /** @param descripcion descripción obligatoria */
    public void setDescripcion(String descripcion) { this.descripcion = requerido(descripcion, "descripcion"); }
    /** @return nivel de permisos */
    public int getNivelPermisos() { return nivelPermisos; }
    /** @param nivelPermisos nivel no negativo */
    public void setNivelPermisos(int nivelPermisos) {
        if (nivelPermisos < 0) throw new IllegalArgumentException("nivelPermisos no puede ser negativo.");
        this.nivelPermisos = nivelPermisos;
    }
    /** @return estado del rol */
    public String getEstadoRol() { return estadoRol; }
    /** @param estadoRol estado obligatorio */
    public void setEstadoRol(String estadoRol) { this.estadoRol = requerido(estadoRol, "estadoRol"); }

    private static String requerido(String valor, String campo) {
        if (valor == null || valor.isBlank()) throw new IllegalArgumentException(campo + " es obligatorio.");
        return valor.trim();
    }

    /** @return todos los atributos del rol */
    @Override
    public String toString() {
        return "Rol{idRol=" + idRol + ", nombreRol='" + nombreRol + "', descripcion='" + descripcion
                + "', nivelPermisos=" + nivelPermisos + ", estadoRol='" + estadoRol + "'}";
    }
    /** @param objeto objeto que se comparará @return true si coincide idRol */
    @Override
public boolean equals(Object objeto) {
    if (this == objeto) {
        return true;
    }

    if (!(objeto instanceof Rol)) {
        return false;
    }

    Rol otro = (Rol) objeto;

    return idRol != null && idRol.equals(otro.idRol);
}
    
    /** @return hash basado exclusivamente en idRol */
    @Override
    public int hashCode() { return Objects.hashCode(idRol); }
}
