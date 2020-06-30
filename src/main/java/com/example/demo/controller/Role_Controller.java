package com.example.demo.controller;

import com.example.demo.dao.Role_DAO;
import com.example.demo.dto.Role_DTO;
import com.example.demo.model.Role;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Roles")
@Api(value="roleoperations", description="Operations related to the microserive which is developed for Haulmatic")
public class Role_Controller {

    @Autowired
    private Role_DAO role_table;

    @ApiOperation(value = "Add roles to the database",response = String.class)
    @PostMapping("/addRoles")
    public String add_Role(@RequestBody Role role){
        role_table.save(role);
        return "All the Roles have been added to the database";
    }


    @ApiOperation(value = "View a list of available roles",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/getAllRoles")
    public Iterable<Role_DTO> get_All_Roles(){
        List<Role> all_roles = role_table.findAll();
        List<Role_DTO> results=new ArrayList<>();

        for(int i=0;i<all_roles.size();i++){
            Role_DTO role=new Role_DTO();
            role.setFirstName(all_roles.get(i).getFirstName());
            role.setLastName(all_roles.get(i).getLastName());
            role.setNic(all_roles.get(i).getNic());
            results.add(role);
        }

        return results ;
    }

    @ApiOperation(value = "Search a role with a organization and a role_type",response = Iterable.class)
    @GetMapping("/getAllRolesForOrgAndType/{organization}/{role_type}")
    public Iterable<Role_DTO> Role_list_for_org_type(@PathVariable String organization, @PathVariable String role_type){
        List<Role> all_roles = role_table.findRolesForOrgAndType(organization,role_type);
        List<Role_DTO> results=new ArrayList<>();

        for(int i=0;i<all_roles.size();i++){
            Role_DTO role=new Role_DTO();
            role.setFirstName(all_roles.get(i).getFirstName());
            role.setLastName(all_roles.get(i).getLastName());
            role.setNic(all_roles.get(i).getNic());
            results.add(role);
        }

        return results ;
    }

    @ApiOperation(value = "Search a role with a nic",response = Role_DTO.class)
    @GetMapping("/getRoles/{nic}")
    public Role_DTO get_Role(@PathVariable("nic") String nic){
        System.out.printf("id: "+nic);

        Role_DTO role=new Role_DTO();
        role.setFirstName(role_table.findByNic(nic).getFirstName());
        role.setLastName(role_table.findByNic(nic).getLastName());
        role.setNic(role_table.findByNic(nic).getNic());

        return role;
    }

    @ApiOperation(value = "Update a role",response = String.class)
    @PutMapping("/updateRole")
    public String update_Role(@RequestBody Role role ){
        Role existing_role = role_table.getOne(role.getId());
        existing_role.setFirstName(role.getFirstName());
        existing_role.setLastName(role.getLastName());
        existing_role.setNic(role.getNic());
        existing_role.setOrganizatoin(role.getOrganizatoin());
        existing_role.setRole_type(role.getRole_type());
        Date modified_date=new Date();
        existing_role.setLast_modified_date(modified_date);
        role_table.save(existing_role);
        return "The update has been done.";
    }

  @ApiOperation(value = "Delete a role by an id",response = String.class)
  @DeleteMapping("/deleteRole/{id}")
  public String delete_Role(@PathVariable("id") Integer id){
       role_table.deleteById(id);
       return "The request roll has been delelted by the user";
    }

}
