package com.verbena.testeAPI.model;

public enum  PermissaoUsuario {
    ADMIN("admin"),
    USUARIO("usuario");

    private String permissao;

    PermissaoUsuario(String permissao){
        this.permissao = permissao;
    }

    public String getPermissao(){
        return permissao;
    }
}
