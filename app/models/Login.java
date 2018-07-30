package models;

import play.Logger;
import play.db.ebean.Model;
import play.data.validation.Constraints;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login {

    @Constraints.Required
    private String username;
    @Constraints.Required
    private String password;


    public String validate() throws NoSuchAlgorithmException {
        if (authenticate(username, password) == null) {
            return "Invalid user or password";
        }
        return null;
    }

    private UserModel authenticate(String username, String password) throws NoSuchAlgorithmException {
        Model.Finder<Long, UserModel> find = new Model.Finder<Long, UserModel>(Long.class,UserModel.class);
        String hashedPassword = "";

        if (password != null) {
            hashedPassword = sha512(password);
            Logger.info("Created Hashed Password");
            System.out.println(hashedPassword);
        }

        return find.where().eq("username", username).eq("password", hashedPassword).findUnique();

    }

    private String sha512(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        StringBuilder sb = new StringBuilder();
        md.update(password.getBytes());
        byte[] mb = md.digest();
        for (int i = 0;i<mb.length;i++) {
            String hex = String.format("%02x", mb[i]);
            sb.append(hex);
        }
        return sb.toString();
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
