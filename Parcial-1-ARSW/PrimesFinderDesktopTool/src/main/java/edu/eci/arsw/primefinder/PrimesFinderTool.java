package edu.eci.arsw.primefinder;

import edu.eci.arsw.mouseutils.MouseMovementMonitor;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class PrimesFinderTool {
    // public static AtomicLong tolm = new AtomicLong();
    public static void main(String[] args) {
        System.out.println("Entre al metodo");

        int maxPrim = 1000;

        PrimesResultSet prs = new PrimesResultSet("john");

        /*
         * PrimeFinder.findPrimes(new BigInteger("1"), new BigInteger("100"), prs);
         * 
         * System.out.println("Prime numbers found:");
         * 
         * System.out.println(prs.getPrimes());
         */
        // tolm.set(System.currentTimeMillis());
        // MouseMovementMonitor.setTimeOfLastMovement(tolm);
        prs = new PrimesResultSet("olaktal");
        PrimeFinderWithThreads.findPrimesWithThreads(new BigInteger("1"), new BigInteger("10"), prs/* , tolm */);
        System.out.println("Prime numbers found: ");
        System.out.println(prs.getPrimes());

        /*
         * while(task_not_finished){ try { //check every 10ms if the idle status (10
         * seconds without mouse //activity) was reached. Thread.sleep(10); if
         * (MouseMovementMonitor.getInstance().getTimeSinceLastMouseMovement()>10000){
         * System.out.println("Idle CPU "); } else{
         * System.out.println("User working again!"); } } catch (InterruptedException
         * ex) { Logger.getLogger(PrimesFinderTool.class.getName()).log(Level.SEVERE,
         * null, ex); } }
         */

    }

}
