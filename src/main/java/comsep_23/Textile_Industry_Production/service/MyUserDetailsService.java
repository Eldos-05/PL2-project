package comsep_23.Textile_Industry_Production.service;

import comsep_23.Textile_Industry_Production.config.MyUserDetails;
import comsep_23.Textile_Industry_Production.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import comsep_23.Textile_Industry_Production.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByLogin(login);
        return user.map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(login + " not found"));
    }
}
