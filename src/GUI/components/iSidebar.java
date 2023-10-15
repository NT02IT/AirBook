/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package GUI.components;

import assets.Site.Order;

/**
 *
 * @author agond
 */
public interface iSidebar {
    void style();
    void siteOrder(Order siteOrder);
    void resetNavItemBG();
    void navigateTo(Order siteOrder);
}
