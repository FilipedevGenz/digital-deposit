package com.filipedevgenz.mssecurity.notUsing;

import com.filipedevgenz.mssecurity.model.Users;
import com.filipedevgenz.mssecurity.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Getter
@RequiredArgsConstructor
@Component
public class CustomAuthenticatorProvider implements AuthenticationProvider {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String mail = authentication.getName();
        String password = authentication.getCredentials().toString();
        Users user = userService.findByUsername(mail);

        if (user == null) {
            throw getWrongUsernameOrPassword();
        }

        if (passwordEncoder.matches(password,user.getPassword())){
            return new CustomAutentication(user);
        }
        throw getWrongUsernameOrPassword();
    }

    private static UsernameNotFoundException getWrongUsernameOrPassword() {
        return new UsernameNotFoundException("Wrong username or password");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}
