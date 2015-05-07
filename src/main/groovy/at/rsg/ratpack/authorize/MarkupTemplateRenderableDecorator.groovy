package at.rsg.ratpack.authorize

import groovy.util.logging.Slf4j

/**
 * Created by leo on 23.04.15.
 */

import org.pac4j.core.profile.UserProfile
import ratpack.groovy.template.MarkupTemplate
import ratpack.handling.Context
import ratpack.render.RenderableDecoratorSupport
import ratpack.session.store.SessionStorage

import static ratpack.pac4j.internal.SessionConstants.USER_PROFILE

@Slf4j
class MarkupTemplateRenderableDecorator extends RenderableDecoratorSupport<MarkupTemplate> {

    @Override
    MarkupTemplate decorate(Context context, MarkupTemplate template) {
        log.debug('Decorating!')
        UserProfile profile = context.request.get(SessionStorage).get(USER_PROFILE)
        def username = profile?.getAttribute("username")

        new MarkupTemplate(template.name, template.contentType, template.model + ['username': username ?: ""])
    }
}