package com.crypto.cryptographic;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Simple RSA public key encryption algorithm implementation.
 */
public class SimpleRSA extends RSA {

    private BigInteger n;
    private BigInteger privateKey;
    private BigInteger publicKey;

    private int keySize = 1024;

    /**
     * Create an instance that can encrypt using someone else public key.
     */
    public SimpleRSA(BigInteger n) {
        this.n = n;
    }

    /**
     * Create an instance that can both encrypt and decrypt.
     */
    public SimpleRSA(int bits) {
        keySize = bits;
        SecureRandom r = new SecureRandom();
        BigInteger p = new BigInteger(keySize / 2, 100, r);
        BigInteger q = new BigInteger(keySize / 2, 100, r);
        n = p.multiply(q);
        BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        publicKey = new BigInteger("3");
        while (m.gcd(publicKey).intValue() > 1) {
            publicKey = publicKey.add(new BigInteger("2"));
        }
        privateKey = publicKey.modInverse(m);
    }

    /**
     * Encrypt the given plaintext message.
     */
    private BigInteger encrypt(BigInteger message) {
        return message.modPow(publicKey, n);
    }

    /**
     * Decrypt the given ciphertext message.
     */
    private BigInteger decrypt(BigInteger message) {
        return message.modPow(privateKey, n);
    }

    /**
     * Generate a new public and private key set.
     */
    public void generateKeys() {
        SecureRandom r = new SecureRandom();
        BigInteger p = new BigInteger(keySize / 2, 100, r);
        BigInteger q = new BigInteger(keySize / 2, 100, r);
        n = p.multiply(q);
        BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        publicKey = new BigInteger("3");
        while (m.gcd(publicKey).intValue() > 1) {
            publicKey = publicKey.add(new BigInteger("2"));
        }
        privateKey = publicKey.modInverse(m);
    }

    public String getPublicKey() {
        return binToHex(publicKey.toByteArray());
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = new BigInteger(publicKey);
    }

    /**
     * Return the private key.
     */
    public String getPrivateKey() {
        return binToHex(privateKey.toByteArray());
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = new BigInteger(privateKey);
    }
    
    public byte[] getN() {
        return n.toByteArray();
    }

    public byte[] encrypt(byte[] msg, byte[] key, int keySize) {
        BigInteger plaintext = new BigInteger(msg);
        this.publicKey = new BigInteger(key);
        return encrypt(plaintext).toByteArray();
    }

    public byte[] decrypt(byte[] msg, byte[] key, int keySize) {
        BigInteger ct = new BigInteger(msg);
        this.privateKey = new BigInteger(key);
        return decrypt(ct).toByteArray();
    }

    /**
     * Trivial test program.
     */
    public static void main(String[] args) {
        SimpleRSA rsa = new SimpleRSA(1024);

        String text1 = "Yellow and Black Border Collies";
        System.out.println("Plaintext: " + text1);
        BigInteger plaintext = new BigInteger(text1.getBytes());

        BigInteger ciphertext = rsa.encrypt(plaintext);
        System.out.println("Ciphertext: " + ciphertext);
        plaintext = rsa.decrypt(ciphertext);

        String text2 = new String(plaintext.toByteArray());
        System.out.println("Plaintext: " + text2);
    }
}
