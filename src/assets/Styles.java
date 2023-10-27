/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assets;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.JTableHeader;

/**
 *
 * @author agond
 */
public class Styles {
    public static final Color PRI_LIGHTER = new Color(230,243,246);
    public static final Color PRI_LIGHT = new Color(156, 230, 247);
    public static final Color PRI_NORMAL = new Color(1, 138, 165);
    public static final Color PRI_DARKER = new Color(0, 48, 58);
    public static final Color PRI_DARK = new Color(1, 104, 124);
    public static final Color WHITE = new Color(255, 255, 255);
    public static final Color GRAY_100 = new Color(246, 246, 246);
    public static final Color GRAY_200 = new Color(173, 173, 173);
    public static final Color GRAY_300 = new Color(138, 138, 138);
    public static final Color GRAY_400 = new Color(115, 115, 115);
    public static final Color GRAY_500 = new Color(79, 79, 79);
    public static final Color GRAY_600 = new Color(71, 71, 71);
    public static final Color GRAY_700 = new Color(56, 56, 56);
    public static final Color GRAY_800 = new Color(43, 43, 43);
    public static final Color GRAY_900 = new Color(33, 33, 33);
    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color FUNC_DANGER_LIGHT = new Color(255, 229, 211);
    public static final Color FUNC_DANGER = new Color(255, 58, 40);
    public static final Color FUNC_WARNING_LIGHT = new Color(255, 246, 214);
    public static final Color FUNC_WARNING = new Color(255, 187, 50);
    public static final Color FUNC_INFO_LIGHT = new Color(216, 245, 254);
    public static final Color FUNC_INFO = new Color(63, 14, 252);
    public static final Color FUNC_SUCCESS_LIGHT = new Color(228, 252, 214);
    public static final Color FUNC_SUCCESS = new Color(56, 196, 51);
    
    public static final Font H1 = new java.awt.Font("Segoe UI", 1, 20);
    public static final Font H2 = new java.awt.Font("Segoe UI", 1, 16);
    public static final Font Body = new java.awt.Font("Segoe UI", 0, 14);
    public static final Font Label = new java.awt.Font("Segoe UI", 1, 14);
    public static final Font Micro = new java.awt.Font("Segoe UI", 0, 12);  
    
    public static void SidebarNavItem(JButton button){
        button.setBackground(PRI_NORMAL);
        button.setForeground(WHITE);
        button.setFont(Styles.Label);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setIconTextGap(6);
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        button.setIconTextGap(12);
        button.setMargin(new java.awt.Insets(2, 16, 2, 16));
    }
    
    public static void ButtonPrimary(JButton button){
        button.setBackground(PRI_NORMAL);
        button.setForeground(WHITE);
        button.setFont(Body);        
        button.setFocusPainted(false);
        button.setIconTextGap(6);
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button.setMargin(new java.awt.Insets(2, 16, 2, 16));      
        button.setBorderPainted(true);
        AbstractBorder border = new TextBubbleBorder(button.getBackground(),0,12,0, true);
        button.setBorder(border);
    }
    
    public static void ButtonSecondary(JButton button){
        button.setBackground(PRI_LIGHTER);
        button.setForeground(PRI_NORMAL);
        button.setFont(Body);        
        button.setFocusPainted(false);
        button.setIconTextGap(6);
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button.setMargin(new java.awt.Insets(2, 16, 2, 16));
        button.setBorderPainted(true);
        AbstractBorder border = new TextBubbleBorder(button.getBackground(),0,12,0, true);
        button.setBorder(border);
    }
    
    public static void ButtonNeutral(JButton button){
        button.setBackground(GRAY_100);
        button.setForeground(GRAY_600);
        button.setFont(Body);        
        button.setFocusPainted(false);
        button.setIconTextGap(6);
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button.setMargin(new java.awt.Insets(2, 16, 2, 16));
        button.setBorderPainted(true);
        AbstractBorder border = new TextBubbleBorder(button.getBackground(),0,12,0, true);
        button.setBorder(border);
    }
    
    public static void ButtonDanger(JButton button){
        button.setBackground(FUNC_DANGER_LIGHT);
        button.setForeground(FUNC_DANGER);
        button.setFont(Body);        
        button.setFocusPainted(false);
        button.setIconTextGap(6);
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button.setMargin(new java.awt.Insets(2, 16, 2, 16));
        button.setBorderPainted(true);
        AbstractBorder border = new TextBubbleBorder(button.getBackground(),0,12,0, true);
        button.setBorder(border);
    }
    
    public static void Table(JTable table, JScrollPane scrollPane){
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setReorderingAllowed(false);
        tableHeader.setPreferredSize(new Dimension(64, 36));
        tableHeader.setOpaque(false);
        tableHeader.setBackground(PRI_LIGHTER);
        tableHeader.setBorder(new TextBubbleBorder(GRAY_100, 1, 0, 0, true));
        tableHeader.setFont(Label);
        
        table.setGridColor(GRAY_100);
        table.setRowHeight(36);
        table.setSelectionBackground(PRI_LIGHTER);
        table.setSelectionForeground(PRI_NORMAL);
        table.setFont(Styles.Body);      
        table.setBackground(WHITE);
        scrollPane.setBorder(new TextBubbleBorder(Styles.GRAY_200,1,12,0, true));
        scrollPane.setBackground(WHITE);
        
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            protected void configureScrollBarColors() {
                this.thumbColor = GRAY_200;
                this.scrollBarWidth = 6;
                this.trackColor = GRAY_100;
            }
        });
    }
    
    public static void TopbarHeader(JLabel text){
        text.setFont(H1);
        text.setForeground(PRI_NORMAL);
    }
    
    public static void PopupHeader(JLabel text){
        text.setFont(H1);
        text.setForeground(WHITE);
        text.setIconTextGap(8);
    }
    
    public static void FormLabel(JLabel text){
        text.setForeground(GRAY_600);
        text.setFont(Styles.Label);
        text.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
    
    public static void FormTextFeild(JTextField text){
        text.setBackground(WHITE);
        text.setFont(Body);
        AbstractBorder border = new TextBubbleBorder(GRAY_200,1,6,0, true);
        text.setBorder(border);
        text.setMargin(new java.awt.Insets(0, 8, 0, 8));        
    }
    
    public static void FormDateFeild(JTextField text){
        text.setBackground(WHITE);
        text.setFont(Body);
        AbstractBorder border = new TextBubbleBorder(GRAY_200,1,6,0, true);
        text.setBorder(border);
        text.setMargin(new java.awt.Insets(0, 8, 0, 8));           
    }
    
    public static void FormRadio(JRadioButton radio, ButtonGroup group){
        radio.setFont(Body);
        radio.setForeground(GRAY_600);
        radio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        try {
            group.add(radio);
        } catch (java.lang.NullPointerException e) {
        }        
        radio.setBorderPainted(false);
        radio.setFocusPainted(false);
        radio.setBackground(WHITE);
    }
    
    public static void ComboBox(JComboBox comboBox){
        comboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboBox.setBackground(WHITE);
        comboBox.setBorder(new EmptyBorder(1, 1, 1, 1));
        comboBox.setFont(Body);
        comboBox.setForeground(GRAY_600);
    }
    
//    private static class RoundedBorder implements Border {
//        private int radius;
//        RoundedBorder(int radius) {
//            this.radius = radius;
//        }
//        public Insets getBorderInsets(Component c) {
//            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
//        }
//        public boolean isBorderOpaque() {
//            return true;
//        }
//        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
//            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
//        }
//    }
    
    public static class RoundedBorder extends LineBorder {
        private int radius;
        public RoundedBorder(Color c, int thickness, int radius) {
            super(c, thickness, true);
            this.radius = radius;
        }
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height, boolean hasInner) {
            // adapted code of LineBorder class
            if ((this.thickness > 0) && (g instanceof Graphics2D)) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                Color oldColor = g2d.getColor();
                g2d.setColor(this.lineColor);

                Shape outer;
                Shape inner;

                int offs = this.thickness;
                int size = offs + offs;
                outer = new RoundRectangle2D.Float(x, y, width, height, 0, 0);
                Path2D path = new Path2D.Float(Path2D.WIND_EVEN_ODD);
                if (hasInner) {
                    inner = new RoundRectangle2D.Float(x + offs, y + offs, width - size, height - size, radius, radius);
                    path.append(inner, false);
                }                  
                path.append(outer, false);
                
                g2d.fill(path);
                g2d.setColor(oldColor);
            }
        }
    }
}
