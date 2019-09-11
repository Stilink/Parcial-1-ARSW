package edu.eci.arsw.api.primesrepo.service;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @author Santiago Carrillo 2/22/18.
 */
@Component
public class PrimeServiceStub implements PrimeService {
    private Map<String, FoundPrime> foundPrimes = new HashMap<String, FoundPrime>();

    @Override
    public void addFoundPrime( FoundPrime foundPrime ) throws Exception
    {   
        if(foundPrimes.containsKey(foundPrime.getPrime())){
            throw new Exception("Error");
        }else{
            foundPrimes.put(foundPrime.getPrime(),foundPrime);
        }
    }

    @Override
    public List<FoundPrime> getFoundPrimes() {
        List<FoundPrime> pf = new ArrayList<>();
        pf.addAll(foundPrimes.values());
        return pf;
    }

    @Override
    public FoundPrime getPrime(String prime) {
        return foundPrimes.get(prime);
    }
}
