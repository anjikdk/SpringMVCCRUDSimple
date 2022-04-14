package com.journaldev.spring.controller;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

public class EncryptDecryptPwd {

	private static final String DB_USERNAME = "sa";
	private static final String DB_PWD = "";
	
    public static void main(String[] args) {
        encryptKey(DB_USERNAME);
        encryptKey(DB_PWD);
        
        decryptKey("lA1yWFSEeGAYB5RJhZ2L7hlkcyFhR+Wz");
        decryptKey("9Y6SF/ht5/CaU7v8o1WyQQ==");
    }

    //encrypt the plan text
    private static void encryptKey(final String plainKey) {
        final SimpleStringPBEConfig pbeConfig = getSimpleStringPBEConfig();
        final PooledPBEStringEncryptor pbeStringEncryptor = new PooledPBEStringEncryptor();
        pbeStringEncryptor.setConfig(pbeConfig);

//        log.info("Encrypted key = {}", pbeStringEncryptor.encrypt(plainKey));
        System.out.println("Encrypted: "+pbeStringEncryptor.encrypt(plainKey));
    }
    
    //decrypt the encrypted text
	private static void decryptKey(final String encryptedKey) {
    	final SimpleStringPBEConfig pbeConfig = getSimpleStringPBEConfig();
        final PooledPBEStringEncryptor pbeStringEncryptor = new PooledPBEStringEncryptor();
        pbeStringEncryptor.setConfig(pbeConfig);

//        log.info("Decrypted key = {}", pbeStringEncryptor.decrypt(encryptedKey));
        System.out.println("Decrypted: "+pbeStringEncryptor.decrypt(encryptedKey));
    }
	
	private static SimpleStringPBEConfig getSimpleStringPBEConfig()
	{
		final SimpleStringPBEConfig pbeConfig = new SimpleStringPBEConfig();
        //can be picked via the environment variablee
        //TODO - hardcoding to be removed
        pbeConfig.setPassword("javacodegeek");  //encryptor private key
        pbeConfig.setAlgorithm("PBEWithMD5AndDES");
        pbeConfig.setKeyObtentionIterations("1000");
        pbeConfig.setPoolSize("1");
        pbeConfig.setProviderName("SunJCE");
        pbeConfig.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        pbeConfig.setStringOutputType("base64");

        return pbeConfig;
	}
}