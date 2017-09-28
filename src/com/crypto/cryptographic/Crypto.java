package com.crypto.cryptographic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.DatatypeConverter;

public class Crypto {

    public static int KEY_SIZE = 512;
    protected static final String AES = "AES";
    protected static final String RSA = "RSA";
    protected String algo;
    private boolean isBuiltIn;
    private String publicKey = "";
    private String privateKey = "";

    /**
     * Encrypt / Decrypt File
     *
     * @param file is file input
     * @param key is hex string
     * @param isEncrypt if true process encrypt otherwise decrypt
     */
    public void encryptDecrypt(File file, String key, boolean isEncrypt) {
        if (file != null && file.exists() && file.isFile() && key != null && key.length() > 0) {
            byte[] msgIn = new byte[(int) file.length()];
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
            try {
                bis = new BufferedInputStream(new FileInputStream(file));
                bis.read(msgIn, 0, msgIn.length);
                byte[] msgOut = null;
                String ext = "";
                msgOut = encryptDecrypt(msgIn, key, isEncrypt);
                if (isEncrypt) {
                    ext = ".enc";
                } else {
                    ext = ".dec";
                }

                if (msgOut != null) {
                    File fo = new File(file.getAbsolutePath() + ext);
                    bos = new BufferedOutputStream(new FileOutputStream(fo));
                    bos.write(msgOut, 0, msgOut.length);
                    bos.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException ex) {
                    }
                }
                if (bos != null) {
                    try {
                        bos.close();
                    } catch (IOException ex) {
                    }
                }
            }
        }
    }

    private byte[] encryptDecrypt(byte[] msg, String key, boolean isEncrypt) throws Exception {
        if (isEncrypt) {
            return encrypt(msg, hexToBin(key));
        } else {
            return decrypt(msg, hexToBin(key));
        }
    }

    protected byte[] encrypt(byte[] msg, byte[] key) {
        return null;
    }

    protected byte[] decrypt(byte[] encMsgtoDec, byte[] key) {
        return null;
    }

    protected static String binToHex(byte[] bytes) {
        return DatatypeConverter.printHexBinary(bytes);
    }

    protected static byte[] hexToBin(String str) {
        return DatatypeConverter.parseHexBinary(str);
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

	public boolean isBuiltIn() {
		return isBuiltIn;
	}

	public void setBuiltIn(boolean isBuiltIn) {
		this.isBuiltIn = isBuiltIn;
	}

}
