/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.entities;

/**
 *
 * @author agond
 */
public class Action {
    protected String actionID;
    protected String actionName;
    protected String info;
    protected int isDelete = 0;

    public Action() {
    }

    public Action(String actionID, String actionName, String info) {
        this.actionID = actionID;
        this.actionName = actionName;
        this.info = info;
    }

    public String getActionID() {
        return actionID;
    }

    public String getActionName() {
        return actionName;
    }

    public String getInfo() {
        return info;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setActionID(String actionID) {
        this.actionID = actionID;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
    
}
