import java.math.BigInteger;
public class Test {
    public static void main(String[] args) {
        long startTime, endTime, totalTime;
        startTime = System.nanoTime();
        CompSecRSA rsa = new CompSecRSA();
        BigInteger a = BigInteger.valueOf(39);
        System.out.println("Original BigInteger: " + a);
        BigInteger text = rsa.encrypt(a);
        System.out.println("Encrypted BigInteger: " + text);
        text = rsa.decrypt(text);
        System.out.println("Decrypted Big Integer: " + text);
        endTime = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("Total runtime: " + totalTime + " nanoseconds");
    }
}
