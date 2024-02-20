package hotel.booking.config;

import com.mysql.cj.protocol.AuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(e->e.disable());
        http.authorizeHttpRequests(auth->auth.requestMatchers(HttpMethod.GET,"/booking").permitAll().anyRequest().authenticated());
        http.httpBasic(Customizer.withDefaults());
        return http.build();//builds an object and gives it
    }

    @Bean
    public UserDetailsService userDetailsService()
    {
        UserDetails userDetails= User.builder().username("abi").password(passwordEncoder().encode("abirami")).roles("admin").build();
        UserDetails userDetails1= User.builder().username("muni").password(passwordEncoder().encode("muneesh")).roles("admin").build();
        return new InMemoryUserDetailsManager(userDetails,userDetails1);
    }
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }



}
