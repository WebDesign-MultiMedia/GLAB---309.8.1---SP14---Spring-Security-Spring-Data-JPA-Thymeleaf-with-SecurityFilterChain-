package com.glab30981.Sp14;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findRoleByName(String role);

    @Query(value = "SELECT * FROM role WHERE role.id= (SELECT role_id FROM users_roles WHERE user_id = :id)", nativeQuery = true)
    public List<Role> findRoleByUser(@Param("id") long id);

}
