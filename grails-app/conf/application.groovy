//-------------------------------------------- Data Source Configuration ---------------------------------------------//

com{
    neovision{
        bank{
            exchangeURL =  "https://www.amdoren.com/api/currency.php?api_key=nqmTGexcExrDm7szWaVp7c6zgUrCRr&from={from}&to={to}"
            scheme = "https"
            host = "currency-exchange.p.rapidapi.com"
            path = "/exchange"
            q = "1.0"
            key = "cf5d93cab7msh1f34aa4b8f891efp1a604djsn62be307e4eea"
        }
    }
}
environments {
    development {
        dataSources {
            dataSource {
                dbCreate = "create"
                url = "jdbc:mysql://localhost:3306/neovision?useSSL=true"
                pooled = true
                logSql = true
                dialect = "org.hibernate.dialect.MySQL5Dialect"
                driverClassName = "com.mysql.cj.jdbc.Driver"
                username = "root"
                password = "root"
            }
        }
    }
}

grails {
    logoutURL = "http://localhost:8080/"
    plugin {
        springsecurity {

            successHandler {
                defaultTargetUrl = '/profile'
            }

            password {
                algorithm = 'bcrypt'
            }

            logout {
                postOnly = false
            }

            userLookup {
                userDomainClassName = 'com.neovision.bank.security.User'
                authorityJoinClassName = 'com.neovision.bank.security.UserRole'
                authority.className = 'com.neovision.bank.security.Role'
            }

            controllerAnnotations {
                staticRules = [
                        [pattern: '/', access: ['permitAll']],
                        [pattern: '/error', access: ['permitAll']],
                        [pattern: '/index', access: ['permitAll']],
                        [pattern: '/index.gsp', access: ['permitAll']],
                        [pattern: '/login/**', access: ['permitAll']],
                        [pattern: '/shutdown', access: ['permitAll']],

                        [pattern: '/assets/**', access: ['permitAll']],
                        [pattern: '/**/js/**', access: ['permitAll']],
                        [pattern: '/**/service-worker.js/**', access: ['permitAll']],
                        [pattern: '/**/json/**', access: ['permitAll']],
                        [pattern: '/**/css/**', access: ['permitAll']],
                        [pattern: '/**/fonts/**', access: ['permitAll']],
                        [pattern: '/**/images/**', access: ['permitAll']],
                        [pattern: '/**/video/**', access: ['permitAll']],
                        [pattern: '/**/img/**', access: ['permitAll']],
                        [pattern: '/**/facebook/**', access: ['permitAll']],
                        [pattern: '/**/favicon.ico', access: ['permitAll']]
                ]
            }

            filterChain {
                chainMap = [
                        [pattern: '/assets/**', filters: 'none'],
                        [pattern: '/**/js/**', filters: 'none'],
                        [pattern: '/**/.mp4/**', filters: 'none'],
                        [pattern: '/**/service-worker.js/**', filters: 'none'],
                        [pattern: '/**/json/**', filters: 'none'],
                        [pattern: '/**/css/**', filters: 'none'],
                        [pattern: '/**/images/**', filters: 'none'],
                        [pattern: '/**/video/**', filters: 'none'],
                        [pattern: '/**/img/**', filters: 'none'],
                        [pattern: '/**/facebook/**', filters: 'none'],
                        [pattern: '/**/fonts/**', filters: 'none'],
                        [pattern: '/**/favicon.ico', filters: 'none'],
                        [pattern: '/dbconsole/**', filters: 'none'],
                        [pattern: '/**', filters: 'JOINED_FILTERS']
                ]
            }
        }
    }
}
