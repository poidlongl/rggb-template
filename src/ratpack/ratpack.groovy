// package ratpack


import at.rsg.ratpack.handler.LoggingHandler
import ratpack.groovy.template.MarkupTemplateModule

import static ratpack.groovy.Groovy.ratpack
import static ratpack.groovy.Groovy.groovyMarkupTemplate

// final Logger LOG = LoggerFactory.getLogger('ratpack')

ratpack {
    bindings {
        add new MarkupTemplateModule()
    }
    handlers {
       handler(new LoggingHandler())

        get {
            render  groovyMarkupTemplate('bstest.gtpl',
                    'title':'Ratpack Groovy Gradle Bootstrap Template'
            )
        }

        assets "public"
    }
}