package com.ultimate.demo.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
//@Table(name="user")
//@EntityListeners(AuditingEntityListener.class)
public class User {
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String username;
    
    @Column
    private String password;
    
    @Column
    private boolean enabled;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "authority_user", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private Set<Authority> authority;

    public User() {
        
    }

    public User(String userID, String userPassword, boolean isAdmin) {
        this.username = userID;
        this.password = userPassword;
        this.enabled = isAdmin;
    }

    public User(Long id, String userID, String userPassword, boolean isAdmin, Set<Authority> authority) {
        this.id = id;
        this.username = userID;
        this.password = userPassword;
        this.enabled = isAdmin;
        this.authority = authority;
    }

    public User(Long id, String userID, String userPassword, boolean enabled) {
        this.id = id;
        this.username = userID;
        this.password = userPassword;
        this.enabled = enabled;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserID() {
        return username;
    }

    public void setUserID(String userID) {
        this.username = userID;
    }

    public String getUserPassword() {
        return password;
    }

    public void setUserPassword(String userPassword) {
        this.password = userPassword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean isAdmin) {
        this.enabled = isAdmin;
    }
    
    public Set<Authority> getAuthority() {
        return authority;
    }

    public void setAuthority(Set<Authority> authority) {
        this.authority = authority;
    }
    
    @Override
    public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((id == null) ? 0 : id.hashCode());
            return result;
    }

    @Override
    public boolean equals(Object obj) {
            if (this == obj)
                    return true;
            if (obj == null)
                    return false;
            if (getClass() != obj.getClass())
                    return false;
            User other = (User) obj;
            if (id == null) {
                    if (other.id != null)
                            return false;
            } else if (!id.equals(other.id))
                    return false;
            return true;
    }

    @Override
    public String toString() {
            return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
    }
}
