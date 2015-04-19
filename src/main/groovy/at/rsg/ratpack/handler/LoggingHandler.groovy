package at.rsg.ratpack.handler

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import ratpack.groovy.handling.GroovyContext
import ratpack.groovy.handling.GroovyHandler

/**
 * Created by leo on 17.04.15.
 */
class LoggingHandler extends GroovyHandler {
    static final Logger LOG = LoggerFactory.getLogger('ratpack.request')
    @Override
    protected void handle(GroovyContext context) {
        context.with {
            LOG.info("request: " + request.uri)
            next()
        }
    }
}
