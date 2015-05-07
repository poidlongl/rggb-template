package templates

layout 'bslayout.gtpl' ,
        'title': title ?: 'Login',
        'msg': error ? ['text': error, 'level': 'error']: [:],
        'username': username,
        bodyContents: contents {
            includeGroovy '_loginform.gtpl'
        }
