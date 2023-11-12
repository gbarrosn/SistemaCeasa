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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login {
    private String username;
    private String password;

    // Constructor
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public boolean authenticateUser() {
        
        String databasePath = "DB/Banco.db"; // Caminho para o banco de dados
        String url = "jdbc:sqlite:" + databasePath;

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement statement = connection.prepareStatement("SELECT senha FROM Users WHERE login = ?")) {

            statement.setString(1, getUsername());

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String storedHash = resultSet.getString("senha");
                    String enteredHash = getPasswordHash();
                    
                    // Comparar os hashes
                    return storedHash.equals(enteredHash);
                }
            }
        } catch (SQLException e) {
            // Tratar a exceção de forma adequada, como log ou relançar uma exceção personalizada
            e.printStackTrace();
        }
        return false;
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
            // Tratar a exceção de forma adequada, como log ou relançar uma exceção personalizada
            e.printStackTrace();
            return null;
        }
    }
}
