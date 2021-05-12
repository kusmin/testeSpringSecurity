import demo.UserPasswordEncoderListener
// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener, ref('hibernateDatastore'))
    coordinateValidator(CoordinateValidatorService)
    twoFactorAuthenticationProvider(TwoFactorAuthenticationProvider) {
        coordinateValidator = ref('coordinateValidator')
        userDetailsService = ref('userDetailsService')
        passwordEncoder = ref('passwordEncoder')
        userCache = ref('userCache')
        saltSource = ref('saltSource')
        preAuthenticationChecks = ref('preAuthenticationChecks')
        postAuthenticationChecks = ref('postAuthenticationChecks')
        authoritiesMapper = ref('authoritiesMapper')
        hideUserNotFoundExceptions = true
    }
    authenticationDetailsSource(TwoFactorAuthenticationDetailsSource)
}
