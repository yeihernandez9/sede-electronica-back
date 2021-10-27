package com.sede.electronica.security.dto;

public class MessageJwt {
    private String mensaje;
    private String status;
    private String code;
    private String data;

    public MessageJwt(String mensaje, String status, String code, String data) {
        this.mensaje = mensaje;
        this.status = status;
        this.code = code;
        this.data = data;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
