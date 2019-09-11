package edu.eci.arsw.primefinder;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * PrimeFinderWithThreads
 */
public class PrimeFinderWithThreads extends Thread {

    private PrimesResultSet prs;
    private BigInteger _a, _b;
    //public static AtomicLong timeOfLastMovement;

    public PrimeFinderWithThreads(PrimesResultSet prs, BigInteger _a, BigInteger _b) {
        this.prs = prs;
        this._a = _a;
        this._b = _b;
    }

    private void findPrimesWithThreads() {
        PrimeFinder.findPrimes(this._a, this._b, this.prs);
    }

    @Override
    public void run() {
        findPrimesWithThreads();
        //Prueba del segundo punto del parcial -- FALLIDA
        /*while (true) {
            // Esto lo intento para el tiempo de movimiento del mouse. -- TEST
            synchronized (timeOfLastMovement) {
                while ((timeOfLastMovement.get()-System.currentTimeMillis()) < 10000) {
                    try {
                        System.out.println("Mouse quieto");
                        timeOfLastMovement.wait();
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
            System.out.println("Mouse en movimiento");
            
        }*/

    }

    public static void findPrimesWithThreads(BigInteger _a, BigInteger _b, PrimesResultSet prs/*, AtomicLong tolm*/) {
        //timeOfLastMovement= tolm;
        BigInteger dif = _b.subtract(_a);
        BigInteger inter = dif.divide(BigInteger.valueOf(4));
        BigInteger start = _a;
        List<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < 3; i++) {
            PrimeFinderWithThreads threadPrimeFinder = new PrimeFinderWithThreads(prs, start, start.add(inter));
            threadPrimeFinder.start();
            threads.add(threadPrimeFinder);
            start = start.add(inter);
            start = start.add(BigInteger.ONE);
        }
        PrimeFinderWithThreads threadPrimeFinder = new PrimeFinderWithThreads(prs, start, _b);
        threadPrimeFinder.start();
        threads.add(threadPrimeFinder);
        for (Thread th : threads) {
            try {
                th.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}