package models;


import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;


@Entity
@Table
public class User extends Model {

    @Id
    private Long id;

    @Min(4)
    @Max(16)
    private String userid;

    @Constraints.Required
    @Min(4)

    @Max(8)
    private String password;

    @Constraints.Required
    @Max(16)
    private String nickname;

    @Constraints.Email
    private String email;

    @Formats.DateTime(pattern = "yyyy/MM/dd/mm:ss")
    private Date created;

    @Formats.DateTime(pattern = "yyyy/MM/dd/mm:ss")
    private Date updated;



    /* Getter and Setter */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public static Finder<Long, User> find = new Finder<Long, User>(Long.class, User.class);

    public static User findByName(String input) {
        return User.find.where().eq("id", input).findList().get(0);
    }

}
