package demo

import grails.comppiler.GrailsCompileStatic

@GrailsCompileStatic
class BootStrap {
    static Map<String, String> BANKCARD =
            ['A1': '10', 'A2': '84', 'A3': '93', 'A4': '12', 'A5': '92',
             'A6': '58', 'A7': '38', 'A8': '28', 'A9': '36', 'A10': '02',
             'B1': '99', 'B2': '29', 'B3': '10', 'B4': '23', 'B5': '33',
             'B6': '47', 'B7': '58', 'B8': '39', 'B9': '34', 'B10': '18',
             'C1': '28', 'C2': '05', 'C3': '29', 'C4': '03', 'C5': '94',
             'C6': '14', 'C7': '41', 'C8': '33', 'C9': '11', 'C10': '39',
             'D1': '01', 'D2': '49', 'D3': '39', 'D4': '79', 'D5': '53',
             'D6': '38', 'D7': '17', 'D8': '88', 'D9': '70', 'D10': '12'
            ]


    def init = {servletContext ->
        def authorities = ['ROLE_CLIENT']
        authorities.each {
            if(!Role.findByAuthority(it)){
                new Role(authority: it).save()
            }
        }

        if(!User.findByUsername('sherlock')){
            def u = new User(username: 'sherlock', password:'elementary')
            BANKCARD.each{k, v ->
                u.addToCoordinates(new SecuriryCoordinate(position: k, value: v, user: u))
            }

            u.save()
            def ur = new UserRole(user: u, role: Role.findByAuthority(ROLE_CLIENT))
        }
    }
    
}