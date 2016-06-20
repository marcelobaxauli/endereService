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
public class PathInvalidoException extends Exception {
    
    private String pathInvalido;
    private String metodoHTTP;
    
    public PathInvalidoException(String metodoHTTP, String pathInvalido) {
        this.pathInvalido = pathInvalido;
        this.metodoHTTP = metodoHTTP;
    }

    public String getPathInvalido() {
        return pathInvalido;
    }

    public void setPathInvalido(String pathInvalido) {
        this.pathInvalido = pathInvalido;
    }

    public String getMetodoHTTP() {
        return metodoHTTP;
    }

    public void setMetodoHTTP(String metodoHTTP) {
        this.metodoHTTP = metodoHTTP;
    }

}
