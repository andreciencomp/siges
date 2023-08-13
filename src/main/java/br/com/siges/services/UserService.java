package br.com.siges.services;

import br.com.siges.enums.RoleName;
import br.com.siges.exceptions.BDException;
import br.com.siges.exceptions.RoleException;
import br.com.siges.models.Role;
import br.com.siges.models.User;
import br.com.siges.repositories.RoleRepository;
import br.com.siges.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    public User saveAdmins(User user, RoleName roleName) throws Exception{
        if(roleName == RoleName.ROLE_SPONSOR || roleName == RoleName.ROLE_TEACHER || roleName == RoleName.ROLE_STUDENT){
            throw new RoleException();
        }
        Role role = roleRepository.findByRoleName(roleName).orElseThrow(()->new BDException());
        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(role);
        user.setRoles(roles);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }
}
