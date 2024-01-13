package com.erbaris.app.flightsearch.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@Profile("dev")
public class UsersInMemorySecurityConfig {
    private UserDetails createUser(String username, String password, String...roles)
    {
        return User.withDefaultPasswordEncoder()
                .username(username)
                .password(password)
                .roles(roles)
                .build();
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
        var admin = createUser("admin", "password", "ADMIN");
        var user = createUser("baris", "12345", "USER", "VIEWER");
        var teamLeader = createUser("ber", "54321", "TEAM_LEADER");

        return new InMemoryUserDetailsManager(admin, user, teamLeader);
    }
}
