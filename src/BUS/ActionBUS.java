/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ActionDAO;
import DTO.entities.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author WIN 10
 */
public class ActionBUS {
    protected static ArrayList<Action> list;
    protected static ActionDAO actionDAO;
    private static int quantity = 0;

    public ActionBUS() throws ClassNotFoundException, SQLException, IOException {
        actionDAO = new ActionDAO();
        list = new ArrayList<>(actionDAO.getList());
        quantity = list.size();
    }

    public ArrayList<Action> getList() {
        return list;
    }
    public boolean createNewAction(Action action) throws ClassNotFoundException, SQLException{
        return actionDAO.create(action);
    }
    public boolean updateAction(Action action) throws ClassNotFoundException, SQLException{
        return actionDAO.update(action);
    }
    public boolean deleteAction(Action action) throws ClassNotFoundException, SQLException{
        return actionDAO.delete(action);
    }
}
