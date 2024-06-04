package com.example.frealsb.Repositories;

import com.example.frealsb.Entities.Role;
import com.example.frealsb.Entities.User;
import com.example.frealsb.Enums.EnumRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<User, String> {
    @Query("SELECT r FROM Role r where r.roleName=?1 ")
    Role findOneByName(EnumRole enumRole);
}
