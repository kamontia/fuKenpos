package controllers;

import models.Login;
import models.SecuredModel;
import models.UserModel;
import play.Logger;
import play.data.Form;
import play.db.ebean.Model;
import play.filters.csrf.AddCSRFToken;
import play.filters.csrf.RequireCSRFCheck;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.index;
import views.html.login;

import static play.data.Form.form;

public class LoginController extends Controller {

    /**
     * ログイン完了？
     * @return
     */
    @Security.Authenticated(SecuredModel.class)
    public Result index() {
        Form<Login> form = new Form<Login>(Login.class);
        return ok(login.render(form));
    }

    /**
     * ログイン画面の表示
     * @return
     */
    @AddCSRFToken
    public Result login() {
        Form<Login> form = new Form<>(Login.class);
        return ok(login.render(form));
    }

    /**
     * 認証機能
     * @return
     */
    @RequireCSRFCheck
    public Result authenticate() {
        Form<Login> loginForm = new Form<Login>(Login.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            Logger.error("bind error");
            return badRequest(login.render(loginForm));
        } else {
           session("username",loginForm.get().getUsername());
           String returnUrl = ctx().session().get("returnUrl");
           if(returnUrl == null || returnUrl.equals("")|| returnUrl.equals(routes.LoginController.index().absoluteURL(request()))) {
               returnUrl = routes.LoginController.index().url();
           }
           return redirect(returnUrl);
        }
    }

    /**
     * ログアウト機能
     * @return
     */
    @Security.Authenticated(SecuredModel.class)
    public Result logout(){
        session().clear();
        return redirect(routes.HomeController.index());
    }
}
