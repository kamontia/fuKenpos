package controllers;


import models.Login;
import models.UserModel;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.template.create;

import java.security.NoSuchAlgorithmException;

public class UserController extends Controller {

    /**
     * ユーザ作成(データ入力)
     *
     * @return
     */
    public Result add() {
        Form<UserModel> f = new Form<UserModel>(UserModel.class);
        return ok(create.render("入力フォーム", f));
    }

    /**
     * ユーザ作成(データベースに反映させる)
     *
     * @return
     */
    public Result create() throws NoSuchAlgorithmException {
        Form<UserModel> f = new Form<UserModel>(UserModel.class).bindFromRequest();
        if (!f.hasErrors()) {
            UserModel data = f.get();
            Login hashedPassword= new Login();
            String password = data.getPassword();
            data.setPassword(hashedPassword.sha512(password));
            try{
                data.save();
            } catch (Exception e){
                System.out.println(e);

            }
            System.out.println(data.getUsername());
            return redirect("/");
        } else {
            return badRequest(create.render("ERROR", f));
        }
    }

    /**
     * ユーザ登録フォーム管理クラス
     */
    public static class userForm {
        public String input;
        public String userid;
        public String password;
        public String nickname;
        public String email;

    }
}
