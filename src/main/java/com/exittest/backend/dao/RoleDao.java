package com.exittest.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exittest.backend.model.Role;

/**
 * @author aryanverma
 * RoleDao is a repository interface for performing CRUD operations on Role entities.
 */
public interface RoleDao extends JpaRepository<Role, Long> {

}
