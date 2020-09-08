package ro.utcn.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.utcn.project.entities.User;

import javax.transaction.Transactional;
import java.util.List;

/**
 * User repository interface.
 * Please read Spring JPA documentation or take a look at some examples to understand the mechanism it uses.
 *
 *  Generally, the query creation mechanism for JPA works as described in “Query methods”.
 *  The following example shows what a JPA query method translates into:
 *
 * List<User> findByEmailAddressAndLastname(String emailAddress, String lastname);
 * User findById(String id);
 *
 *  We create a query using the JPA criteria API from this, but,
 *  essentially, this translates into the following query:
 *  "SELECT u FROM User u WHERE u.emailAddress = ?1 AND u.lastname = ?2" (JPQL Querry)
 *
 * Please read the following links:
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation.
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.named-queries.
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT u FROM User u WHERE u.role = 'regular'")
    List< User> findAllRegularUsers();

    @Query("SELECT u.user_id FROM User u WHERE u.role = 'regular'")
    List<String> getAllUsersIds();
    @Query("select u from User u where u.user_id = :id")
     User findUsersByUser_id(@Param("id") String id);

    @Query("select u from User u where u.user_name = :username")
     User findUserByUsername(@Param("username")String username);

    @Query("select u from User u where u.email = :email")
     User findUserByEmail(@Param("email")String email);

    @Transactional
    @Modifying
    @Query("Update User u set u.user_name = :new_username where u.user_name = :username")
    void updateUserUsername(@Param("new_username") String new_username, @Param("username") String username);

    @Transactional
    @Modifying
    @Query("Update User u set u.name = :new_name where u.user_name = :username")
    void updateUserName(@Param("new_name") String new_name, @Param("username") String username);

    @Transactional
    @Modifying
    @Query("Update User u set u.surname = :new_surname where u.user_name = :username")
    void updateUserSurname(@Param("new_surname") String new_surname, @Param("username") String username);

    @Transactional
    @Modifying
    @Query("Update User u set u.email = :new_email where u.user_name = :username")
    void updateUserEmail(@Param("new_email") String new_email, @Param("username") String username);

    @Transactional
    @Modifying
    @Query("Update User u set u.password = :new_password where u.user_name = :username")
    void updateUserPassword(@Param("new_password") String new_password, @Param("username") String username);

    @Transactional
    @Modifying
    @Query("delete from User u where u.user_name = :username")
    void deleteUserByUsername(@Param("username") String username);
}
