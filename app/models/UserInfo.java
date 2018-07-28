package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

public class UserInfo extends Model {

    @Id
    @Min(4)
    @Max(16)
    private String userid;

    @Constraints.Required
    private String kenpos_id;

    @Constraints.Required
    private String kenpos_password;

    @Constraints.Required
    @Min(0)
    private Integer min_step;

    @Constraints.Required
    private  Integer max_step;

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
}