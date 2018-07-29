package models;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;
import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class UserInfoModel extends Model {
    @Id
    private Long id;

    public static Finder<Long, UserInfoModel> find = new Finder<Long, UserInfoModel>(Long.class, UserInfoModel.class);

    @Constraints.Required
    private String kenpos_id;

    @Constraints.Required
    private String kenpos_password;
    @OneToOne(cascade = CascadeType.ALL)
    public UserModel user;

    @Constraints.Required
    private Integer max_step;
    @Constraints.MinLength(4)
    @Constraints.MaxLength(16)

    private String userid;
    @Constraints.Required
    @Constraints.MinLength(0)
    private Integer min_step;
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

    public String getKenpos_id() {
        return kenpos_id;
    }

    public void setKenpos_id(String kenpos_id) {
        this.kenpos_id = kenpos_id;
    }

    public String getKenpos_password() {
        return kenpos_password;
    }

    public void setKenpos_password(String kenpos_password) {
        this.kenpos_password = kenpos_password;
    }

    public Integer getMin_step() {
        return min_step;
    }

    public void setMin_step(Integer min_step) {
        this.min_step = min_step;
    }

    public Integer getMax_step() {
        return max_step;
    }

    public void setMax_step(Integer max_step) {
        this.max_step = max_step;
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

    public static UserInfoModel findByName(String input) {
        return UserInfoModel.find.where().eq("id", input).findList().get(0);
    }
}