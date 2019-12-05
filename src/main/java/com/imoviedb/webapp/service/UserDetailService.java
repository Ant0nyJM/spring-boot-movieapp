package com.imoviedb.webapp.service;

import com.imoviedb.webapp.models.User;
import com.imoviedb.webapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userRepository.findById()

        UserItem userItem =  new UserItem(user.getUsername(),user.getPassword(),true,true,true,true, new ArrayList<GrantedAuthority>());;

        userItem.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER"));
        return userItem;
    }
}