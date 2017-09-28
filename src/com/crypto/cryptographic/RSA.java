package com.crypto.cryptographic;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

public class RSA extends Crypto {

    private BigInteger modulus;

    public RSA(boolean isBuiltIn) {
        this.algo = Crypto.RSA;
        this.setBuiltIn(isBuiltIn);
    }

    public RSA() {
    }

    public void generateKeyPair() throws NoSuchAlgorithmException {
        if (isBuiltIn()) {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance(algo);
            kpg.initialize(Crypto.KEY_SIZE);
            KeyPair kp = kpg.genKeyPair();

            PublicKey publicKey = kp.getPublic();
            PrivateKey privateKey = kp.getPrivate();

            this.setPublicKey(binToHex(publicKey.getEncoded()));
            this.setPrivateKey(binToHex(privateKey.getEncoded()));
        } else {
            SimpleRSA sRSA = new SimpleRSA(Crypto.KEY_SIZE);
            this.setPublicKey(sRSA.getPublicKey());
            this.setPrivateKey(sRSA.getPrivateKey());
            this.modulus = new BigInteger(sRSA.getN());
        }
    }

    protected byte[] encrypt(byte[] msg, byte[] key) {
        byte[] encryptedBytes = null;
        if (isBuiltIn()) {
            try {
                KeyFactory kf = KeyFactory.getInstance(algo);
                PublicKey publicKey = null;
                publicKey = kf.generatePublic(new X509EncodedKeySpec(key));

                Cipher cipher = Cipher.getInstance(algo);
                cipher.init(Cipher.ENCRYPT_MODE, publicKey);
                encryptedBytes = cipher.doFinal(msg);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            SimpleRSA sRSA = new SimpleRSA(this.modulus);
            encryptedBytes = sRSA.encrypt(msg, key, Crypto.KEY_SIZE);
        }
        return encryptedBytes;
    }

    protected byte[] decrypt(byte[] msg, byte[] key) {
        byte[] decryptedBytes = null;

        if (isBuiltIn()) {
            try {
                KeyFactory kf = KeyFactory.getInstance(algo);
                PrivateKey privateKey = null;
                privateKey = kf.generatePrivate(new PKCS8EncodedKeySpec(key));
                Cipher cipher = Cipher.getInstance(algo);
                cipher.init(Cipher.DECRYPT_MODE, privateKey);
                decryptedBytes = cipher.doFinal(msg);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            SimpleRSA sRSA = new SimpleRSA(this.modulus);
            decryptedBytes = sRSA.decrypt(msg, key, Crypto.KEY_SIZE);
        }
        return decryptedBytes;
    }

    public String getModulus() {
        return binToHex(modulus.toByteArray());
    }

    public void setModulus(String n) {
        this.modulus = new BigInteger(hexToBin(n));
    }
}
