package edu.eci.arsw.api.primesrepo;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import edu.eci.arsw.api.primesrepo.service.PrimeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author Santiago Carrillo
 * 2/22/18.
 */
@RestController
@RequestMapping(value = "/primes")
public class PrimesController
{
    @Autowired
    @Qualifier("primeServiceStub")
    PrimeService primeService;


    @RequestMapping( method = GET )
    public List<FoundPrime> getPrimes()
    {
        return primeService.getFoundPrimes();
    }


    @RequestMapping( method = POST)
    public ResponseEntity<?> manejadorPostPrimes(@RequestBody FoundPrime fp){
        try{
            primeService.addFoundPrime(fp);
            return new ResponseEntity<>("Created", HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>("Not created" , HttpStatus.FORBIDDEN);
        }
    }
    @RequestMapping( value="/{prime}" , method = GET )
    public FoundPrime getPrimes(@PathVariable String prime)
    {
        return primeService.getPrime(prime);
       
    }



    //TODO implement additional methods provided by PrimeService



}
