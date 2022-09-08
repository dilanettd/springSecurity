package com.autourducode.demo.service;

import com.autourducode.demo.entity.Role;
import com.autourducode.demo.entity.User;
import com.autourducode.demo.model.UserForm;
import com.autourducode.demo.repository.IRoleRepository;
import com.autourducode.demo.repository.IUserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Service
@Setter
@Getter
@AllArgsConstructor
@Transactional
public class UserService implements IUserService, UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user==null) throw new UsernameNotFoundException("User not found in the database");
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
    }

    private final IUserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final IRoleRepository roleRepository;

    @Override
    public User create(UserForm userForm) {
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(passwordEncoder.encode(userForm.getPassword()));
        user = userRepository.save(user);
        if(userForm.getRole()=="ADMIN"){
            addRoleToUser(userForm.getEmail(),"USER");
            addRoleToUser(userForm.getEmail(),"ADMIN");

        }else{
            addRoleToUser(userForm.getEmail(),userForm.getRole());
        }
        return user;
    }

    @Override
    public Iterable<User> gets() {
        return userRepository.findAll();
    }

    @Override
    public User update(Long id, User user) {
       return userRepository.findById(id).map(u->{
            u.setPassword(user.getPassword());
            u.setName(user.getName());
            u.setEmail(user.getEmail());
            return userRepository.save(u);
        }).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public String delete(Long id) {
        userRepository.deleteById(id);
        return "success";
    }

    @Override
    public User get(Long id) {
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public User check_password(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void createRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        User user = userRepository.findByEmail(email);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

}
