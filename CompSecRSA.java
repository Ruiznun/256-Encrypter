import java.math.BigInteger;
import java.security.SecureRandom;

public class CompSecRSA {

    private BigInteger e,p,q,n,d,totient;

    public CompSecRSA(){JavaRSA();}

    public void JavaRSA(){
     /*
    Setup: Alice chooses two large prime numbers p, q ( 21024) and
    (a) computes n = p * q;
    (b) chooses 0 < e < φ(n) such that gcd(e; φ(n)) = 1;
    (note that Alice KNOWS (n) = (p - 1)(q - 1)).
    (c) finds 0 < d < φ(n) such that e*d = 1 (mod φ(n)).
     */
        SecureRandom random = new SecureRandom();
        e = BigInteger.valueOf(35537);
        p = BigInteger.probablePrime(3079/2,random);
        q = BigInteger.probablePrime(3079/2,random);
        // n = p*q
        n = p.multiply(q);
        // φ(n) = (p-1)(q-1)
        totient = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        //gcd(e,φ(n)) = 1
        while(totient.gcd(e).compareTo(BigInteger.ONE) > 1){
            p = BigInteger.probablePrime(3079/2,random);
            q = BigInteger.probablePrime(3079/2,random);
            n = p.multiply(q);
            totient = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        }
        // compute d using mod inverse;
        d = e.modInverse(totient);
    }

    public BigInteger encrypt(BigInteger plaintext){
        // c = m^e (mod n)
        return plaintext.modPow(e,n);
    }

    public BigInteger decrypt(BigInteger cyphertext){
        //m = c^d(mod n)
        return cyphertext.modPow(d,n);
    }
}
