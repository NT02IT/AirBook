/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assets;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.AbstractBorder;

/**
 *
 * @author agond
 */
public class TextBubbleBorder extends AbstractBorder {
    private Color color;
    private int thickness;
    private int radius = 8;
    private int pointerSize;
    private Insets insets = null;
    private BasicStroke stroke = null;
    private int strokePad;
    private int pointerPad = 4;
    private boolean left = true;
    RenderingHints hints;

//        TextBubbleBorder(Color color) {
//            new TextBubbleBorder(color, 4, 8, 7);
//        }

    public TextBubbleBorder(Color color, int thickness, int radius, int pointerSize) {
        this.thickness = thickness;
        this.radius = radius;
        this.pointerSize = pointerSize;
        this.color = color;

        stroke = new BasicStroke(thickness);
        strokePad = thickness / 2;

        hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        int pad = radius + strokePad;
        int bottomPad = pad + pointerSize + strokePad;
        insets = new Insets(pad, pad, bottomPad, pad);
//        insets = new Insets(0, 0, 0, 0);
    }
    
    public TextBubbleBorder(Color color, int thickness, int radius, int pointerSize, boolean left) {
        this(color, thickness, radius, pointerSize);
        this.left = left;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return insets;
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        return getBorderInsets(c);
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g;

        int bottomLineY = height - thickness - pointerSize;

        RoundRectangle2D.Double bubble = new RoundRectangle2D.Double(0 + strokePad, 0 + strokePad, width - thickness, bottomLineY, radius, radius);

        Polygon pointer = new Polygon();

        // left point
        pointer.addPoint(strokePad + radius + pointerPad, bottomLineY);
        // right point
        pointer.addPoint(strokePad + radius + pointerPad + pointerSize, bottomLineY);
        // bottom point
        pointer.addPoint(strokePad + radius + pointerPad + (pointerSize / 2), height - strokePad);

        Area area = new Area(bubble);
        area.add(new Area(pointer));

        g2.setRenderingHints(hints);
        
        
        // Paint the BG color of the parent, everywhere outside the clip
        // of the text bubble.
        Component parent  = c.getParent();
        if (parent!=null) {
            Color bg = parent.getBackground();
            Rectangle rect = new Rectangle(0,0,width, height);
            Area borderRegion = new Area(rect);
            borderRegion.subtract(area);
            g2.setClip(borderRegion);
            g2.setColor(bg);
            g2.fillRect(0, 0, width, height);
            g2.setClip(null);
        } 
        else {
            Area spareSpace = new Area(new Rectangle(0, 0, width, height));
            spareSpace.subtract(area);
            g2.setClip(spareSpace);
            g2.clearRect(0, 0, width, height);
            g2.setClip(null);
        }        

        g2.setColor(color);
        g2.setStroke(stroke);
        g2.draw(area);
    }
}
