package com.crypto.cryptographic;

import java.io.File;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

/**
 *
 * @author developer
 *
 */
public class AES extends Crypto {

    long time1 = System.currentTimeMillis();
    long time2 = time1;

    //timing("Start");
    public AES(boolean isBuiltIn) {
        this.algo = Crypto.AES;
        this.setBuiltIn(isBuiltIn);
    }

    private SHA sha1 = new SHA(true);

    /**
     * Encrypt / Decrypt File
     * <br> Step produce symmetric key
     * <br> 1. key will be hash
     * <br> 2. hash key truncate to specific key size
     *
     * @param file is file input
     * @param key is string
     * @param isEncrypt if true process encrypt otherwise decrypt
     */
    public void encryptDecrypt(File file, String key, boolean isEncrypt) {
        if (file != null && file.exists() && file.isFile() && key != null && key.length() > 0) {
            long time1 = System.currentTimeMillis();
            long time2 = time1;
            try {
                byte[] hash = sha1.generateSHA(key.getBytes(), "SHA-1");
                byte[] keys = Arrays.copyOf(hash, Crypto.KEY_SIZE);
                key = binToHex(keys);
                super.encryptDecrypt(file, key, isEncrypt);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * encrypt message
     *
     * @param msg
     * @param key
     * @return chiper message
     * @throws Exception
     */
    protected byte[] encrypt(byte[] msg, byte[] key) {
        byte[] encMessage = null;
        if (isBuiltIn()) {
            try {
                //prepare key
                SecretKeySpec secretKeySpec = new SecretKeySpec(key, algo);
                //prepare cipher
                Cipher cipher = Cipher.getInstance(algo);

                cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

                encMessage = cipher.doFinal(msg);
                System.out.println("Built-in encryption enabled");
            } catch (Exception e) {
            }
        } else {
            Rijndael aes = new Rijndael();
            encMessage = aes.encrypt(msg, key, Crypto.KEY_SIZE * 8);
            System.out.println("Built-in encryption disabled");
        }

        time2 = System.currentTimeMillis();
        System.out.println("IsEncrypt");
        System.out.println("Start Time:   " + time1 + "  ms \n");
        System.out.println("Time taken for Encryption:   " + (time2 - time1) + "  ms \n");
        //timing("After Encrypt");
        return encMessage;
    }

    /**
     * decrypt chiper message
     *
     * @param chiperMessage
     * @param key
     * @return readable message
     * @throws Exception
     */
    public byte[] decrypt(byte[] chiperMessage, byte[] key) {
        byte[] decMsg = null;

        if (isBuiltIn()) {
            try {
                System.out.println("Built-in decryption enabled");
                //prepare key
                SecretKeySpec secretKeySpec = new SecretKeySpec(key, algo);

                //prepare cipher
                Cipher cipher = Cipher.getInstance(algo);

                cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

                decMsg = cipher.doFinal(chiperMessage);
            } catch (Exception e) {
                // TODO: handle exception
            }
        } else {
            Rijndael aes = new Rijndael();
            decMsg = aes.decrypt(chiperMessage, key, Crypto.KEY_SIZE * 8);
            System.out.println("Built-in decryption disabled");
        }
        time2 = System.currentTimeMillis();
        System.out.println("IsDecrypt");
        System.out.println("Start Time:   " + time1 + "  ms \n");
        System.out.println("Time taken for Decryption:   " + (time2 - time1) + "  ms \n");
        //timing("After Decrypt");
        return decMsg;
    }

}
