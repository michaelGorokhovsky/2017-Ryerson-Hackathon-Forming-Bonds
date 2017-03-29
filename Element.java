import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.awt.geom.*;

public class Element {

    int electrons;
    String name;
    String symbol;
    String group;
    boolean metal;
    boolean hasEdge = false;
    boolean lostLayer = false;
    Ellipse2D.Double outerring;
    Ellipse2D.Double temp;
    Ellipse2D.Double oelec;
    Line2D edge;
    ArrayList<Ellipse2D.Double> outerElec;

    public Element(int electrons, String name, String symbol, String group, boolean metal, Ellipse2D.Double outerring){
        this.electrons = electrons;
        this.name = name;
        this.symbol = symbol;
        this.group = group;
        this.metal = metal;
        this.outerring = outerring;
        outerElec = new ArrayList<Ellipse2D.Double>();
        addOuterElectrons();
    }
    public void addOuterElectrons(){
        outerElec.clear();
        int holdOuter = getOuterElectrons();
        System.out.println(holdOuter);
        for (int i=0; i<holdOuter; i++){
            switch (i){
                case 0: 
                    temp = new Ellipse2D.Double(outerring.getCenterX(), outerring.getMinY() - 5, 10, 10);
                    outerElec.add(temp);
                    break;
                case 1: 
                    temp = new Ellipse2D.Double(outerring.getCenterX()-10, outerring.getMinY() - 5, 10, 10);
                    outerElec.add(temp);
                    break;

                case 2:
                    temp = new Ellipse2D.Double(outerring.getMaxX()-5, outerring.getCenterY(), 10, 10);
                    outerElec.add(temp);
                    break;

                case 3:
                    temp = new Ellipse2D.Double(outerring.getMaxX()-5, outerring.getCenterY()-10, 10, 10);
                    outerElec.add(temp);
                    break;

                case 4:
                    temp = new Ellipse2D.Double(outerring.getCenterX(), outerring.getMaxY()-5, 10, 10);
                    outerElec.add(temp);
                    break;

                case 5:
                    temp = new Ellipse2D.Double(outerring.getCenterX()-10, outerring.getMaxY()-5, 10, 10);
                    outerElec.add(temp);
                    break;

                case 6:
                    temp = new Ellipse2D.Double(outerring.getMinX()-5, outerring.getCenterY(), 10, 10);
                    outerElec.add(temp);
                    break;

                case 7:
                    temp = new Ellipse2D.Double(outerring.getMinX()-5, outerring.getCenterY()-10, 10, 10);
                    outerElec.add(temp);
                    break;


            }
        }

    }

    public String getName() {
        return name;
    }
    public int getElectrons(){
        return electrons;
    }
    public void setElectrons(int electrons, boolean extra){
        this.electrons=electrons;
        if (extra){
            oelec = new Ellipse2D.Double(outerring.getX()+10, outerring.getY()+10, 80, 80);
            temp = outerring;
            outerring = oelec;
            oelec = temp;
            lostLayer = true;
        }

        addOuterElectrons();
    }

    public String getGroup(){
        return group;
    }

    public boolean isMetal() {
        return metal;
    }

    public String getSymbol(){
        return symbol;
    }

    public ArrayList<Ellipse2D.Double> getOuterArray(){
        return outerElec;
    }

    public Ellipse2D.Double getOuterRing(){
        return outerring;
    }

    public void setEdge(Line2D edge){
        this.edge = edge;
        hasEdge = true;
    }


    public int getOuterElectrons(){
        if (electrons <= 2)
        {
            return electrons;
        }
        else if (electrons > 2 && electrons <= 10)
        {
            return electrons - 2;
        }
        int e = electrons - 2;
        while (e > 8)
        {
            e = e - 8;
        }
        return e;
    }


    public String toString(){
        return "Element: " + name + " ; Symbol: " + symbol + " ; Group: " + group + " ; Electrons: " + electrons;
    }

    void draw(Graphics2D g2) {
        g2.draw(outerring);
        //g2.draw(oelec);
        for(Ellipse2D.Double i : outerElec){
            g2.draw(i);
            g2.fill(i);
        }
        if(hasEdge){
            g2.draw(edge);
            System.out.println("here");
        }
        if (lostLayer)
            g2.draw(oelec);
        String text = symbol;
        FontMetrics fm = g2.getFontMetrics();
        double textWidth = fm.getStringBounds(text, g2).getWidth();
        g2.setColor(Color.BLACK);
        g2.drawString(text, (int) (outerring.getCenterX() - textWidth / 2),
                (int) (outerring.getCenterY() + fm.getMaxAscent() / 2));

    }

}


