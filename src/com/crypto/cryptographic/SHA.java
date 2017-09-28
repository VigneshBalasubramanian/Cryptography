package com.crypto.cryptographic;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA extends RSA {

    public SHA(boolean isBuiltIn) {
        super(isBuiltIn);
    }

    /**
     * Hash function with SHA
     *
     * @param message
     * @return hash message
     * @throws Exception
     */
    public String generateSHA(String message, String hashType) {
        if (message != null && message.length() > 0) {
            try {
                byte[] hash = generateSHA(message.getBytes(), hashType);
                return binToHex(hash);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * Hash function with SHA
     *
     * @param file
     * @return hash message
     * @throws Exception
     */
    public String generateSHA(File file, String hashType) {
        if (file != null && file.exists() && file.isFile()) {
	        byte[] msgIn = new byte[(int) file.length()];
	        BufferedInputStream bis = null;
	        try {
	            bis = new BufferedInputStream(new FileInputStream(file));
	            bis.read(msgIn, 0, msgIn.length);
                byte[] hash = generateSHA(msgIn, hashType);
                return binToHex(hash);
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
     * Hash function with SHA
     *
     * @param message
     * @return hash message
     * @throws NoSuchAlgorithmException 
     * @throws Exception
     */
    protected byte[] generateSHA(byte[] message, String hashType) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(hashType);
        byte[] hash = messageDigest.digest(message);
        return hash;
    }
}
