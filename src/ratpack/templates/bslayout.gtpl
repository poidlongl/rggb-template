package templates

yieldUnescaped '<!DOCTYPE html>'

html ( 'lang': 'de' ) {
    head {
        meta    ('charset': 'utf-8')
        title   ( title ?: 'Poidlongls Template' )
        meta    ('name': 'viewport', 'content': 'width=device-width, initial-scale=1')
        meta    ('http-equiv': 'X-UA-Compatible', 'content' : 'IE=edge')
        link    ('href': 'css/bootstrap.css', 'rel': 'stylesheet', 'media': 'screen' )
        link    ('href': '/favicon.ico', 'rel': 'icon', 'type': 'image/ico')
    }

    body {
        div ( 'class': 'navbar navbar-default navbar-fixed-top') {
            div ( 'class': 'container') {
                div ( 'class': 'navbar-header')  {
                    a ( 'href': '#', 'class': 'navbar-brand', appname ?: 'Appname')
                    button ( 'class': 'navbar-toggle', 'type': 'button',
                            'data-toggle': 'collapse', 'data-target': '#navbar-main') {
                        span('class': 'icon-bar')
                        span('class': 'icon-bar')
                        span('class': 'icon-bar')
                    }
                }
                div ('class': 'navbar-collapse collapse', 'id': 'navbar-main' ) {
                    ul('class': 'nav navbar-nav') {
                        li {
                            a (href: '#', 'Do nothing')
                        }
                    }
                }

            }
            div ( 'class': 'container') {
                if ( msg ) {
                    div(class: "alert alert-${msg.level} alert-dismissible") {
                        button(type: 'button', class: 'close', 'data-dismiss': 'alert',  '&times;')
                        yield "${msg.text}"
                    }
                }
                bodyContents()
            }
        }

        script  ('src': 'js/jquery-1.11.2.min.js') {}

        script  ('src': '/js/bootstrap.js') {}
    }
}
