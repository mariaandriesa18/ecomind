package ro.utcn.project.entities;

import ro.utcn.project.entities.Community;
import javax.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    private  String user_id;

    @Column
    private String role;

    @Column
    private String user_name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String surname;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "community_id")
    private Community community;

    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn(name = "household_profile_id")
    private HouseholdProfile householdProfile;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private RecyclingInformation recyclingInformation;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public HouseholdProfile getHouseholdProfile() {
        return householdProfile;
    }

    public void setHouseholdProfile(HouseholdProfile householdProfile) {
        this.householdProfile = householdProfile;
    }

    public RecyclingInformation getRecyclingInformation() {
        return recyclingInformation;
    }

    public void setRecyclingInformation(RecyclingInformation recyclingInformation) {
        this.recyclingInformation = recyclingInformation;
    }


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }
}






/*
package ro.utcn.project.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

*/
/**
 * The user entity extends the UserDetails interface.
 * Please check this link:
 * https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/core/userdetails/UserDetails.html.
 *//*

@Entity
public class User implements UserDetails {

    @Id
    private String id;

    @Column
    private String username;

    @Column
    private String password;

    */
/**
     * Use TemporalType.DATE if you just need the specific day (ex: 2020-02-04).
     * Use TemporalType.TIMESTAMP if you just need both the day and hour time (ex: 2020-02-04 T20:03:04)
     *//*

    @Column
    @Temporal(TemporalType.DATE)
    //   @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    */
/**
     * Return the roles here.
     *//*

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        */
/**
         * Add each role as a SimpleGrantedAuthority.
         * If you got only OneToOne relation, then return the list with only one element.
         *//*

        GrantedAuthority auth_example = new SimpleGrantedAuthority("YOUR_ROLE_AS_STRING");
        authorities.add(auth_example);
        return authorities;
    }

    */
/**
     * All this fields are from UserDetails.
     *//*



    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    */
/**
     * This is used to retrieve the session user username.
     * Please do not remove or change it.
     * @return - the authenticated user username.
     *//*


    @Override
    public String toString() {
        return username;
    }
}
*/
