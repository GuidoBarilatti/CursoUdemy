package com.curso.udemy.services;

import com.curso.udemy.models.entities.Role;
import com.curso.udemy.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAll(){
        return roleRepository.findAll();
    }

    public Role creatRole(Role role){
        return  roleRepository.save(role);
    }

    public Role updateRole (int roleId,Role role) {
        Optional<Role> result = roleRepository.findById(roleId);

        if (result.isPresent()) {
            return roleRepository.save(role);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role id %d doesn't exist", roleId));
        }
    }

    public void deleteRole(int roleId){
        Optional<Role> result = roleRepository.findById(roleId);
        if (result.isPresent()){
            roleRepository.delete(result.get());
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role id %d doesn't exist", roleId));
        }
    }

    public Role findById(int roleId) {

        Optional<Role> result = roleRepository.findById(roleId);
        if (result.isPresent()){
            return result.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role id %d doesn't exist", roleId));
        }
    }
}
