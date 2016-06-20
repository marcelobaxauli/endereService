/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbax.hackerrank.exception;

/**
 *
 * @author Marcelo Lima Baxauli <mlb122@hotmail.com>
 */
public class JSONInvalidoException extends Exception {
    
    private String jsonInvalido;

    public JSONInvalidoException(String jsonInvalido) {
        this.jsonInvalido = jsonInvalido;
    }

    public String getJsonInvalido() {
        return jsonInvalido;
    }

    public void setJsonInvalido(String jsonInvalido) {
        this.jsonInvalido = jsonInvalido;
    }
    
    
}
