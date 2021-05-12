package demo

import groovy.transform.GrailsCompileStatic

@GrailsCompileStatic
class SecurityCoordinate {
    String position
    String value
    static belongsTo = [user:User]
}