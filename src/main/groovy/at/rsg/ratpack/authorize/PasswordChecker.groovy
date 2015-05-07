package at.rsg.ratpack.authorize

import groovy.util.logging.Slf4j
import org.pac4j.core.exception.CredentialsException
import org.pac4j.core.util.CommonHelper
import org.pac4j.http.credentials.UsernamePasswordAuthenticator
import org.pac4j.http.credentials.UsernamePasswordCredentials
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Created by leo on 23.04.15.
 */
@Slf4j
public class PasswordChecker implements UsernamePasswordAuthenticator {

    public void validate(final UsernamePasswordCredentials credentials) {
        if (credentials == null) {
            throwsException("No credential");
        }
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        log.debug("Here we are: $username $password")
        if (CommonHelper.isBlank(username)) {
            throwsException("Username cannot be blank");
        }
        if (CommonHelper.isBlank(password)) {
            throwsException("Password cannot be blank");
        }
        if (CommonHelper.areNotEquals(username, password)) {
            throwsException("Username : '" + username + "' does not match password");
        }
    }

    protected void throwsException(final String message) {
        log.error(message);
        throw new CredentialsException(message);
    }
}

