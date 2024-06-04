package com.example.frealsb.Util;

import com.example.frealsb.Entities.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Utility class for encryption operations.
 */
public class EncryptionUtils {

    /**
     * Encrypt a string using MD5 algorithm.
     * @param input the string to encrypt
     * @return the encrypted string
     */
    public static String PasswordEncoder(String input) {
        return new BCryptPasswordEncoder().encode(input);
    }

    public static boolean PasswordMatch(String match, User user){
        return new BCryptPasswordEncoder().matches(match, user.getPassword());
    }
}
