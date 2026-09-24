package com.elizabethnicolaus.inventory_management_system.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table (name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;

    @Column(nullable=false, unique=true, length=50)
    private String username;

    @Column(nullable=false,length=50)
    private String name;

    @Column(name="password_hash", nullable=false, length=255)
    private String passwordHash;

    @ManyToOne
    @JoinColumn(name="role_id", nullable=false)
    private Role role;

    @Column(name="is_active", nullable=false)
    private Boolean isActive= true;

    @Column (name="created_at", nullable=false, updatable=false)
    @CreationTimestamp //fills this field with the current date/time automatically
    private LocalDateTime createdAt;
    
    public User(){

    }
    public User(String username,String name,String passwordHash,Role role,Boolean isActive){
        this.username=username;
        this.name=name;
        this.passwordHash=passwordHash;
        this.role=role;
        this.isActive=isActive;
    }

    public Long getUserId(){
        return userId;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getPasswordHash(){
        return passwordHash;
    }
    public void setPasswordHash(String passwordHash){
        this.passwordHash=passwordHash;
    }
    public Role getRole(){
        return role;
    }
    public void setRole(Role role){
        this.role=role;
    }
    public Boolean getIsActive(){
        return isActive;
    }
    public void setIsActive(Boolean isActive){
        this.isActive=isActive;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

}
