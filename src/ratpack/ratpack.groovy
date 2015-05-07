// package ratpack


import at.rsg.ratpack.authorize.AuthorizeChecker
import at.rsg.ratpack.authorize.MarkupTemplateRenderableDecorator
import at.rsg.ratpack.authorize.PasswordChecker
import at.rsg.ratpack.handler.LoggingHandler
import com.fasterxml.jackson.datatype.jsr310.JSR310Module
import ratpack.groovy.template.MarkupTemplateModule
import ratpack.config.ConfigData
import ratpack.server.ReloadInformant
import org.pac4j.http.client.FormClient
import ratpack.pac4j.Pac4jModule
import ratpack.session.SessionModule
import ratpack.session.store.MapSessionsModule


import static ratpack.groovy.Groovy.ratpack
import static ratpack.groovy.Groovy.groovyMarkupTemplate



ratpack {

    bindings {
        ConfigData appconfig = ConfigData.of(new JSR310Module())
                .props("$serverConfig.baseDir.file/application.properties")
                .env()
                .sysProps()
                .build()

        bindInstance(ReloadInformant, appconfig) // Add to the registry to enable development time config reloading

        add SessionModule
        add new MapSessionsModule(10, 5)
        add new Pac4jModule<>(new FormClient("/login", new PasswordChecker()), new AuthorizeChecker())

        bind MarkupTemplateRenderableDecorator

        // Whyever i need this ..
        add new MarkupTemplateModule()
    }
    handlers {
       handler(new LoggingHandler())

        get {
            render  groovyMarkupTemplate('bstest.gtpl',
                    'title':'Ratpack Groovy Gradle Bootstrap Template'
            )
        }

        handler('needsauth1') {
            println("needsauth 1!!!")
            render  groovyMarkupTemplate('bstest.gtpl',
                    'title':'needsauth1',
                    'msg': ['text': 'needs auth 1', 'level': 'info']
            )
        }

        handler('needsauth2') {
            render  groovyMarkupTemplate('bstest.gtpl',
                    'title':'needsauth2',
                    'msg': ['text': 'needs auth 2', 'level': 'info']
            )
        }


        handler("login") {
            render groovyMarkupTemplate("login.gtpl",
                    title: "Login",
                    action: '/pac4j-callback',
                    method: 'get',
                    buttonText: 'Login',
                    error: request.queryParams.error ?: "")
        }


        assets "public"
    }
}