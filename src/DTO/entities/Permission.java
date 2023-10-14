/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.entities;

/**
 *
 * @author agond
 */
public class Permission {
    protected String perID;
    protected String roleID;
    protected String actionID;
    protected int perAccess;
    protected int perCreate;
    protected int perView;
    protected int perEdit;
    protected int perDelete;

    public Permission() {
    }

    public Permission(String perID, String roleID, String actionID, int perAccess, int perCreate, int perView, int perEdit, int perDelete) {
        this.perID = perID;
        this.roleID = roleID;
        this.actionID = actionID;
        this.perAccess = perAccess;
        this.perCreate = perCreate;
        this.perView = perView;
        this.perEdit = perEdit;
        this.perDelete = perDelete;
    }

    public String getPerID() {
        return perID;
    }

    public String getRoleID() {
        return roleID;
    }

    public String getActionID() {
        return actionID;
    }

    public int getPerAccess() {
        return perAccess;
    }

    public int getPerCreate() {
        return perCreate;
    }

    public int getPerView() {
        return perView;
    }

    public int getPerEdit() {
        return perEdit;
    }

    public int getPerDelete() {
        return perDelete;
    }

    public void setPerID(String perID) {
        this.perID = perID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public void setActionID(String actionID) {
        this.actionID = actionID;
    }

    public void setPerAccess(int perAccess) {
        this.perAccess = perAccess;
    }

    public void setPerCreate(int perCreate) {
        this.perCreate = perCreate;
    }

    public void setPerView(int perView) {
        this.perView = perView;
    }

    public void setPerEdit(int perEdit) {
        this.perEdit = perEdit;
    }

    public void setPerDelete(int perDelete) {
        this.perDelete = perDelete;
    }
    
}
