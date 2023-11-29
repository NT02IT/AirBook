/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ActionDAO;
import DAO.PermissionDAO;
import DTO.entities.Action;
import DTO.entities.Permission;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author WIN 10
 */
public class PermissionBUS {
    protected static ArrayList<Permission> list;
    protected static ArrayList<Permission> canAccess;
    protected static ArrayList<Action> actionList;
    protected static PermissionDAO permissionDAO;
    protected static ActionDAO actionDAO;
    private static int quantity = 0;
    
    public PermissionBUS() throws ClassNotFoundException, SQLException, IOException {
        permissionDAO = new PermissionDAO();
        list = new ArrayList<>(permissionDAO.getList());
        quantity = list.size();
    }

    public ArrayList<Permission> getList() {
        return list;
    }
    
    public int getQuantity() {
        quantity = list.size();
        return quantity;
    }          
    public void savePermissions(List<List<Object>> dataList, String role_ID) throws ClassNotFoundException, SQLException, IOException {
        ArrayList<String> perID = new ArrayList<>();
        actionDAO = new ActionDAO();
        actionList = actionDAO.getList();
        int stt =0;
        for(Action action : actionList){
            String id = role_ID +"-"+ action.getActionID();
            perID.add(id);
        }
        for (List<Object> rowData : dataList) {
            Permission permission = new Permission();
            permission.setIsDelete(0);
            permission.setRoleID(role_ID);
            permission.setPerID(perID.get(stt));
            permission.setActionID(actionList.get(stt).getActionID());
            permission.setPerAccess((boolean) rowData.get(0) ? 1 : 0);
            permission.setPerCreate((boolean) rowData.get(1) ? 1 : 0);
            permission.setPerView((boolean) rowData.get(2) ? 1 : 0);
            permission.setPerEdit((boolean) rowData.get(3) ? 1 : 0);
            permission.setPerDelete((boolean) rowData.get(4) ? 1 : 0);
            permissionDAO.create(permission);
            stt++;
        }
    }
    public void updatePermissions(List<List<Object>> dataList, String role_ID) throws ClassNotFoundException, SQLException, IOException {
        ArrayList<String> perID = new ArrayList<>();
        actionDAO = new ActionDAO();
        actionList = actionDAO.getList();
        int stt =0;
        for (List<Object> rowData : dataList) {
            Permission permission = new Permission();
            permission.setRoleID(role_ID);
            permission.setActionID(actionList.get(stt).getActionID());
            permission.setPerAccess((boolean) rowData.get(0) ? 1 : 0);
            permission.setPerCreate((boolean) rowData.get(1) ? 1 : 0);
            permission.setPerView((boolean) rowData.get(2) ? 1 : 0);
            permission.setPerEdit((boolean) rowData.get(3) ? 1 : 0);
            permission.setPerDelete((boolean) rowData.get(4) ? 1 : 0);
            permissionDAO.update(permission);
            stt++;
        }
    }
    public ArrayList<Integer> hasPermission(String roleID,String action_ID , ArrayList<Permission> canAccess) throws ClassNotFoundException, SQLException, IOException, NoSuchAlgorithmException{
        ArrayList<Integer> listpermission = new ArrayList<>();
        for (Permission permission : canAccess) {
            if (permission.getActionID().equals(action_ID)){ 
                listpermission.add(permission.getPerAccess());
                listpermission.add(permission.getPerCreate());                
                listpermission.add(permission.getPerView());
                listpermission.add(permission.getPerEdit());
                listpermission.add(permission.getPerDelete());
            }
        }
        return listpermission;
    }
    public boolean hasPerAccess(String roleID, String action_ID){
        for(Permission permission : list){
            if(permission.getRoleID().equals(roleID) && permission.getActionID().equals(action_ID)){
                System.out.println("Done");
                return permission.getPerAccess() == 1;
            }
        }
        return false;
    }
    public boolean hasPerCreate(String roleID, String action_ID){
        for(Permission permission : list){
            if(permission.getRoleID().equals(roleID) && permission.getActionID().equals(action_ID)){
                return permission.getPerCreate() == 1;
            }
        }
        return false;
    }
    public boolean hasPerView(String roleID, String action_ID){
        for(Permission permission : list){
            if(permission.getRoleID().equals(roleID) && permission.getActionID().equals(action_ID)){
                return permission.getPerView() == 1;
            }
        }
        return false;
    }
    public boolean hasPerEdit(String roleID, String action_ID){
        for(Permission permission : list){
            if(permission.getRoleID().equals(roleID) && permission.getActionID().equals(action_ID)){
                return permission.getPerEdit() == 1;
            }
        }
        return false;
    }
    public boolean hasPerDelete(String roleID, String action_ID){
        for(Permission permission : list){
            if(permission.getRoleID().equals(roleID) && permission.getActionID().equals(action_ID)){
                return permission.getPerDelete()== 1;
            }
        }
        return false;
    }
    public static ArrayList<Permission> canAccessForm(String roleID) throws IOException, ClassNotFoundException, SQLException {
        canAccess =  permissionDAO.getPermissonByRoleID(roleID);
        return canAccess;
    }
}
