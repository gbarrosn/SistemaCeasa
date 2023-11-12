/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

/**
 *
 * @author gbarrosn
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login {
    private String username;
    private String password;

    // Constructor
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter method for username
    public String getUsername() {
        return username;
    }

    // Getter method for password hash
    public String getPasswordHash() {
        return encryptPassword(password);
    }

    // Method to encrypt the password using SHA-256 hash
    private String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());

            // Convert the byte array to a hexadecimal string
            StringBuilder sb = new StringBuilder();
            for (byte hashedByte : hashedBytes) {
                sb.append(String.format("%02x", hashedByte));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception appropriately (e.g., log it)
            e.printStackTrace();
            return null;
        }
    }

}
