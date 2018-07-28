package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;


@Entity
@Table
public class User extends Model {

    @Id
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
    @Constraints.Required
    private String email;

    @Formats.DateTime(pattern = "yyyy/MM/dd/mm:ss")
    private Date created;

    @Formats.DateTime(pattern = "yyyy/MM/dd/mm:ss")
    private Date updated;


    /* Getter and Setter */
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

}
