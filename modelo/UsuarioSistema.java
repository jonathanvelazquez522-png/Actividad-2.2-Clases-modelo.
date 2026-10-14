package edu.utj.dsm.vehiculos.modelo;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Representa las credenciales y el estado de acceso de una persona al sistema.
 *
 * @author Velazquez Aviña Jonathan
 */
public final class UsuarioSistema {
    private Integer idUsuario;
    private String username;
    private String passwordHash;
    private Integer idPersona;
    private Integer idRol;
    private LocalDateTime ultimoAcceso;
    private String estadoCuenta;

    /** Constructor vacío para instanciación por defecto. */
    public UsuarioSistema() { }

    /**
     * Crea un usuario del sistema con los datos mínimos de acceso.
     * @param idUsuario identificador primario
     * @param username nombre de usuario
     * @param passwordHash hash de contraseña, nunca texto plano
     * @param idPersona id de persona relacionada
     * @param idRol id del rol asignado
     * @param ultimoAcceso fecha y hora del último acceso; puede ser null
     * @param estadoCuenta estado de la cuenta
     */
    public UsuarioSistema(Integer idUsuario, String username, String passwordHash, Integer idPersona,
                          Integer idRol, LocalDateTime ultimoAcceso, String estadoCuenta) {
        setIdUsuario(idUsuario);
        setUsername(username);
        setPasswordHash(passwordHash);
        setIdPersona(idPersona);
        setIdRol(idRol);
        setUltimoAcceso(ultimoAcceso);
        setEstadoCuenta(estadoCuenta);
    }

    /** @return identificador del usuario */
    public Integer getIdUsuario() { return idUsuario; }
    /** @param idUsuario id positivo o null */
    public void setIdUsuario(Integer idUsuario) {
        if (idUsuario != null && idUsuario <= 0) throw new IllegalArgumentException("idUsuario debe ser positivo o null.");
        this.idUsuario = idUsuario;
    }
    /** @return username */
    public String getUsername() { return username; }
    /** @param username nombre de usuario obligatorio */
    public void setUsername(String username) { this.username = requerido(username, "username"); }
    /** @return hash de contraseña */
    public String getPasswordHash() { return passwordHash; }
    /** @param passwordHash hash no vacío, no contraseña en texto plano */
    public void setPasswordHash(String passwordHash) { this.passwordHash = requerido(passwordHash, "passwordHash"); }
    /** @return id de persona asociada */
    public Integer getIdPersona() { return idPersona; }
    /** @param idPersona identificador positivo de persona */
    public void setIdPersona(Integer idPersona) {
        if (idPersona == null || idPersona <= 0) throw new IllegalArgumentException("idPersona debe ser positivo.");
        this.idPersona = idPersona;
    }
    /** @return id de rol */
    public Integer getIdRol() { return idRol; }
    /** @param idRol identificador positivo del rol */
    public void setIdRol(Integer idRol) {
        if (idRol == null || idRol <= 0) throw new IllegalArgumentException("idRol debe ser positivo.");
        this.idRol = idRol;
    }
    /** @return último acceso */
    public LocalDateTime getUltimoAcceso() { return ultimoAcceso; }
    /** @param ultimoAcceso fecha de acceso, puede ser null si nunca ha ingresado */
    public void setUltimoAcceso(LocalDateTime ultimoAcceso) { this.ultimoAcceso = ultimoAcceso; }
    /** @return estado de cuenta */
    public String getEstadoCuenta() { return estadoCuenta; }
    /** @param estadoCuenta estado de la cuenta */
    public void setEstadoCuenta(String estadoCuenta) { this.estadoCuenta = requerido(estadoCuenta, "estadoCuenta"); }

    private static String requerido(String valor, String campo) {
        if (valor == null || valor.isBlank()) throw new IllegalArgumentException(campo + " es obligatorio.");
        return valor.trim();
    }

    /** @return todos los atributos; el hash se enmascara para no divulgar credenciales */
    @Override
    public String toString() {
        return "UsuarioSistema{idUsuario=" + idUsuario + ", username='" + username + "', passwordHash='[PROTEGIDO]'"
                + ", idPersona=" + idPersona + ", idRol=" + idRol + ", ultimoAcceso=" + ultimoAcceso
                + ", estadoCuenta='" + estadoCuenta + "'}";
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

    if (!(objeto instanceof UsuarioSistema)) {
        return false;
    }

    UsuarioSistema otro = (UsuarioSistema) objeto;

    return idUsuario != null && idUsuario.equals(otro.idUsuario);
}

    /** @return hash basado exclusivamente en idUsuario */
    @Override
    public int hashCode() { return Objects.hashCode(idUsuario); }
}
