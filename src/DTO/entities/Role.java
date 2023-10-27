/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.entities;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author agond
 */
public class Role {
    protected String roleID;
    protected String roleName;  
    protected int isDelete = 0;

    public Role() {
    }

    public Role(String roleID, String roleName) {
        this.roleID = roleID;
        this.roleName = roleName;
    }

    public String getRoleID() {
        return roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
    
}
