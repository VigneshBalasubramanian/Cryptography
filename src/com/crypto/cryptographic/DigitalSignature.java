/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crypto.cryptographic;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class DigitalSignature extends RSA {

    public DigitalSignature(boolean isBuiltIn) {
        super(isBuiltIn);
    }

    /**
	 * Signature SHA with RSA
	 *
	 * @param msg is string of input
	 * @param key is hex of key
	 * @param hashType is type of SHA
	 * @return the signature hex string of the signing operation's result.
	 */
	public String sign(String msg, String key, String hashType) {
		return binToHex(sign(msg.getBytes(), hexToBin(key), hashType));
	}

	/**
	 * Signature SHA with RSA
	 *
	 * @param file is input file
	 * @param key is hex of key
	 * @param hashType is type of SHA
	 * @return the signature hex string of the signing operation's result.
	 */
	public String sign(File file, String key, String hashType) {
	    if (file != null && file.exists() && file.isFile()) {
	        byte[] msgIn = new byte[(int) file.length()];
	        BufferedInputStream bis = null;
	        try {
	            bis = new BufferedInputStream(new FileInputStream(file));
	            bis.read(msgIn, 0, msgIn.length);
	            return binToHex(sign(msgIn, hexToBin(key), hashType));
	        } catch (Exception e) {
	            e.printStackTrace();
			} finally {
	            if (bis != null) {
	                try {
	                    bis.close();
	                } catch (IOException ex) {
	                }
	            }
			}
	    }
	    return null;
	}

	/**
	 * Signature SHA with RSA
	 *
	 * @param msg is bytes of input
	 * @param key is bytes of key
	 * @param hashType is type of SHA
	 * @return the signature bytes of the signing operation's result.
	 */
	private byte[] sign(byte[] msg, byte[] key, String hashType) {
	    try {
	        KeyFactory kf = KeyFactory.getInstance(Crypto.RSA);
	        PrivateKey privateKey = null;
	        privateKey = kf.generatePrivate(new PKCS8EncodedKeySpec(key));
	
	        // Compute signature
	        String signAlgo = hashType + "withRSA";
	        Signature instance = Signature.getInstance(signAlgo);
	        instance.initSign(privateKey);
	        instance.update(msg);
	        return instance.sign();
	    } catch (InvalidKeySpecException | NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
	    }
	
	    return null;
	}

	/**
     * Verifies the passed-in signature SHA with RSA
     *
     * @param msg is string of input
     * @param key is string of key
     * @param sign is hex of sign
     * @param hashType is type of SHA
     * @return true if the signature was verified, false if not.
     */
    public boolean verify(String msg, String key, String sign, String hashType) {
        return verify(msg.getBytes(), hexToBin(key), hexToBin(sign), hashType);
    }
    
    /**
     * Verifies the passed-in signature SHA with RSA
     *
     * @param msg is file of input
     * @param key is string of key
     * @param sign is hex of sign
     * @param hashType is type of SHA
     * @return true if the signature was verified, false if not.
     */
    public boolean verify(File file, String key, String sign, String hashType) {
        if (file != null && file.exists() && file.isFile()) {
	        byte[] msgIn = new byte[(int) file.length()];
	        BufferedInputStream bis = null;
	        try {
	            bis = new BufferedInputStream(new FileInputStream(file));
	            bis.read(msgIn, 0, msgIn.length);
                return verify(msgIn, hexToBin(key), hexToBin(sign), hashType);
            } catch (Exception e) {
                e.printStackTrace();
			} finally {
	            if (bis != null) {
	                try {
	                    bis.close();
	                } catch (IOException ex) {
	                }
	            }
			}
        }
        return false;
    }

    /**
     * Verifies the passed-in signature SHA with RSA
     *
     * @param msg is bytes of input
     * @param key is bytes of key
     * @param sign is bytes of sign
     * @param hashType is type of SHA
     * @return true if the signature was verified, false if not.
     */
    private boolean verify(byte[] msg, byte[] key, byte[] sign, String hashType) {
        try {
            KeyFactory kf = KeyFactory.getInstance(Crypto.RSA);
            PublicKey publicKey = null;
            publicKey = kf.generatePublic(new X509EncodedKeySpec(key));

            // Compute signature
            String signAlgo = hashType + "withRSA";
            Signature instance = Signature.getInstance(signAlgo);
            instance.initVerify(publicKey);
            instance.update(msg);
            return instance.verify(sign);
        } catch (InvalidKeySpecException | NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
        }

        return false;
    }
}
