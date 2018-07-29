package models;


import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;
import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table
public class UserModel extends Model {

    @Id
    private Long id;

    public static Finder<Long, UserModel> find = new Finder<Long, UserModel>(Long.class, UserModel.class);
    @Constraints.MinLength(4)
    @Constraints.MaxLength(16)
    private String userid;
    @Constraints.Required
    @Constraints.MinLength(4)
    @Constraints.MaxLength(16)
    private String password;

    @Constraints.Email
    private String email;
    @Constraints.Required
    @Constraints.MaxLength(16)
    private String nickname;
    @Formats.DateTime(pattern = "yyyy/MM/dd/mm:ss")
    @CreatedTimestamp
    private Date created;


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

    @Formats.DateTime(pattern = "yyyy/MM/dd/mm:ss")
    @UpdatedTimestamp
    private Date updated;

    public static UserModel findByName(String input) {
        return UserModel.find.where().eq("id", input).findList().get(0);
    }

}
