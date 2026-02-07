@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
            .cors()
            .and()
            .csrf().disable()
            .authorizeHttpRequests()
            .anyRequest().permitAll();

    return http.build();
}
