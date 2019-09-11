package edu.eci.arsw.api.primesrepo.service;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @author Santiago Carrillo
 * 2/22/18.
 */
@Service
public interface PrimeService
{

    void addFoundPrime( FoundPrime foundPrime ) throws Exception;

    List<FoundPrime> getFoundPrimes();

    FoundPrime getPrime( String prime );

}