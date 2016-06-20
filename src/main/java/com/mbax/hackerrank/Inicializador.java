package com.mbax.hackerrank;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class Inicializador 
{
    public static void main( String[] args )
    {
        
        EnderecoService.getInstance().registraRotas();
        
        /*
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("enderecos");
        
        EntityManager em = emf.createEntityManager();
     
        Endereco endereco = new Endereco();
        endereco.setBairro("Liberdade");
        endereco.setCep("01511001");
        endereco.setCidade("São Paulo");
        endereco.setEstado("SP");
        endereco.setNumero(1114);
        endereco.setRua("Rua Conselheiro Furtado");
        endereco.setComplemento("Apto. 96");
        
        em.getTransaction().begin();
        em.persist(endereco);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
        */
        
    }
}
