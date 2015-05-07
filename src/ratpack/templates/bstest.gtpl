package templates

layout 'bslayout.gtpl' ,
        'title': title ?: 'Poidlongls Testpage',
        'msg': msg ?: [text: 'Hello, there', 'level': 'info'],
        bodyContents: contents {

            div ('class': 'jumbotron') {
                h2('Ratpack Groovy Gradle Bootstrap Template')
                strong  {
                    yield  'Based on bootstrap-template '
                    a ( href: 'https://bootswatch.com/simplex/', 'simplex')
                    yield ' from '
                    a ( href: 'https://bootswatch.com/', 'bootstrap.com')
                }
            }
        }
