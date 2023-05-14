package Sales.Sales.Sotrudniki;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public S_Sotrudniki Ssotrudniki() {
        return new S_Sotrudniki();
    }

    @Bean

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(Ssotrudniki())
                .passwordEncoder(passwordEncoder());
        http.formLogin()
                .loginPage("/sign-in")
                .loginProcessingUrl("/to-enter")
                .failureUrl("/sign-in")
                .defaultSuccessUrl("/profile")
                .usernameParameter("user_name")
                .passwordParameter("user_password");
        http.logout()
                .logoutUrl("/to-exit")
                .logoutSuccessUrl("/sign-in");
        http.csrf().disable();
        return http.build();
    }
}
