package com.example.demo.dao;

import com.example.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
public interface Role_DAO extends JpaRepository<Role,Integer> {

    @Query(value ="select * from role  where nic = :nic ", nativeQuery = true)
    Role findByNic(@Param("nic") String nic);

    @Query(value ="select * from role  where organizatoin = :org and role_type=:roleType ", nativeQuery = true)
    List<Role> findRolesForOrgAndType(@Param("org") String org,@Param("roleType") String roleType);
}
