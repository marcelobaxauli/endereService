/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbax.hackerrank;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbax.hackerrank.exception.JSONInvalidoException;
import com.mbax.hackerrank.exception.PathInvalidoException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import spark.Spark;

/**
 *
 * Representa o servico CRUD de endereco
 * 
 * @author Marcelo Lima Baxauli <mlb122@hotmail.com>
 */
public class EnderecoService {
    
    private static final Logger LOGGER = LogManager.getLogger(EnderecoService.class);
    
    private static EnderecoService _enderecoService;
    private ObjectMapper mapper = new ObjectMapper();
    
    private static final String REQ_INVALIDA_MSG_JSON = "{\"erro\":\"requisicao invalida\"}";
    private static final String ERRO_INTERNO_MSG_JSON = "{\"erro\":\"erro interno. Tente mais tarde.\"}";
    
    
    public static EnderecoService getInstance() {
        
        if (EnderecoService._enderecoService == null) {
            EnderecoService._enderecoService = new EnderecoService();
        }
     
        return EnderecoService._enderecoService;
    }
    
    public void registraRotas() {
        
        Spark.post("/endereco/criar", 
                        (request, response) -> {
                    
                            String payload = request.body();
                            
                            LOGGER.debug("Nova requisicao de criacao recebida: " + payload);
                            
                            Endereco novoEndereco = null;
                            try {
                                novoEndereco = mapper.readValue(payload, Endereco.class);
                            } catch (Exception e) {
                                
                                throw new JSONInvalidoException(payload);
                                
                            }
                            
                            LOGGER.debug("Endereco convertido: " + novoEndereco);
                            
                            return "sup bro";
                
                        }
        );
        
        Spark.post("/*", 
                (request, response) -> {
                    
                    String pathInvalido = request.pathInfo();
                    String metodoHTTP = request.requestMethod();
                    
                    throw new PathInvalidoException(metodoHTTP, pathInvalido);
                    
                }
        );
        
        Spark.exception(JSONInvalidoException.class, 
                (exception, request, response) -> {
                    
                    String jsonInvalido = ((JSONInvalidoException) exception).getJsonInvalido();
                    LOGGER.error("Erro ao converter o json da requisicao do usuario: " + jsonInvalido, exception);
                    
                    response.status(400);
                    response.header("Content-Type", "application/json");
                    response.body(REQ_INVALIDA_MSG_JSON);
                    
                }
        );
        
        Spark.exception(PathInvalidoException.class, 
                (exception, request, response) -> {
                    
                    String pathInvalido = ((PathInvalidoException) exception).getPathInvalido();
                    String metodoHTTP = ((PathInvalidoException) exception).getMetodoHTTP();
                    LOGGER.error("Path invalido: " + pathInvalido);
                    
                    response.status(404);
                    response.header("Content-Type", "application/json");
                    response.body(String.format("{\"erro\":\"path invalido: (%s) (%s)\"}", metodoHTTP, pathInvalido));
                });
        
        Spark.exception(Exception.class, 
                (exception, request, response) -> {
                    
                    LOGGER.error("Erro nao esperado", exception);
                    
                    response.status(500);
                    response.header("Content-Type", "application/json");
                    response.body(ERRO_INTERNO_MSG_JSON);
                    
                }
        );
        
        
    }
    
}
