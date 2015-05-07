package at.rsg.ratpack.authorize

/**
 * Created by leo on 22.04.15.
 */
import ratpack.handling.Context
import ratpack.pac4j.AbstractAuthorizer

class AuthorizeChecker extends AbstractAuthorizer {

    @Override
    boolean isAuthenticationRequired(Context context) {
        return context.request.path.startsWith("needsauth")
    }

}