package com.elizabethnicolaus.inventory_management_system.entity;
import jakarta.persistence.*;

@Entity 
public class Role {
   @Id
   @GeneratedValue (strategy=GenerationType.IDENTITY)
   @Column(name="role_id")
   private Long roleId;

}
