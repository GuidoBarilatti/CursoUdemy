package com.curso.udemy.controllers;

import com.curso.udemy.models.entities.Role;
import com.curso.udemy.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> getAll(){
        return new ResponseEntity<List<Role>>(roleService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Role> create(@RequestBody Role role){
        return new ResponseEntity<Role>(roleService.creatRole(role),HttpStatus.CREATED);
    }

    @PutMapping("/{roleId}")
    public ResponseEntity<Role> update(@PathVariable ("roleId") int roleId, @RequestBody Role role){
        return new ResponseEntity<Role>(roleService.updateRole(roleId,role),HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{roleId}")
    public ResponseEntity<Void> deleteRole(@PathVariable ("roleId") int roleId){
        roleService.deleteRole(roleId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<Role> findById(@PathVariable("roleId") int roleId){
        return new ResponseEntity<Role>(roleService.findById(roleId),HttpStatus.OK);
    }
}