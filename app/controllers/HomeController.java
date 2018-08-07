package controllers;

import models.SecuredModel;
import models.UserModel;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.home;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a top message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */

    @Security.Authenticated(SecuredModel.class)
    public Result index() {
        System.out.println( UserModel.find.where().eq("username",request().username()).findUnique());
        return ok(home.render(
                UserModel.find.where().eq("username",request().username()).findList().get(0)
        ));
    }

}
