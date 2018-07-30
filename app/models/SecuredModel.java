package models;


import controllers.routes;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;

public class SecuredModel extends Security.Authenticator {
    /**
     * Retrieves the username from the HTTP context; the default is to read from the session cookie.
     *
     * @param ctx the current request context
     * @return null if the user is not authenticated.
     */
    @Override
    public String getUsername(Http.Context ctx) {
        return super.getUsername(ctx);
    }

    /**
     * Generates an alternative result if the user is not authenticated; the default a simple '401 Not Authorized' page.
     *
     * @param ctx the current request context
     * @return a <code>401 Not Authorized</code> result
     */
    @Override
    public Result onUnauthorized(Http.Context ctx) {
        String returnUrl = ctx.request().uri();
        if(returnUrl== null){
            returnUrl="/";
        }
        ctx.session().put("returnUrl",returnUrl);
        return redirect(controllers.routes.LoginController.login());
//        return super.onUnauthorized(ctx);
    }
}
