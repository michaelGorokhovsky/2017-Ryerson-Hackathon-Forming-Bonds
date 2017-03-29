
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.*;

public class GraphComp extends JComponent{
    JPanel sidePanel;
    JButton hButt;
    GridLayout experimentLayout;
    JButton liButt;
    JButton beButt;
    JButton naButt;
    JButton mgButt;
    JButton kButt;
    JButton caButt;
    JButton rbButt;
    JButton oButt;
    JButton sButt;
    JButton seButt;
    JButton fButt;
    JButton clButt;
    JButton brButt;
    JLabel flavour;
    JPanel textPanel;
    JMenuBar optionBar;
    JMenu options;
    JMenuItem clearElement;
    JMenuItem RemovePrevious;
    JMenuItem Help;
    ArrayList<Element> elements;
    MouseListener draw;
    ArrayList<Ellipse2D.Double> outerElec;
    Line2D edge;
    Ellipse2D.Double closestValanceElectron;
    Ellipse2D.Double closestValanceElectron2;
    Ellipse2D.Double closestValanceElectron3;
    Ellipse2D.Double closestValanceElectron4;
    ArrayList<Ellipse2D.Double> oneValance;
    ArrayList<Ellipse2D.Double> twoValance;

    int drawElem;
    //integer to keep track of how many elements are in the panel
    int numcircles = 0;

    public GraphComp(){
        experimentLayout = new GridLayout(0,2);
        textPanel = new JPanel();
        elements = new ArrayList<Element>();
        optionBar = new JMenuBar();
        options = new JMenu("Options");
        optionBar.add(options);
        clearElement = new JMenuItem("Clear All Elements");
        RemovePrevious = new JMenuItem("Remove Previous Element");
        Help = new JMenuItem("Help");

        options.add(clearElement);
        options.add(RemovePrevious);
        options.add(Help);
        textPanel.setLayout(new BorderLayout());

        flavour = new JLabel("<html> Fun Fact!:  <br> <br>  ");
        flavour.setBorder(BorderFactory.createLineBorder(Color.black));
        textPanel.add(flavour);

        hButt = new JButton("H");
        liButt = new JButton("Li");
        beButt = new JButton("Be");
        naButt = new JButton("Na");
        mgButt = new JButton("Mg");
        kButt = new JButton("K");
        caButt = new JButton("Ca");
        rbButt = new JButton("Rb");
        oButt = new JButton("O");
        sButt = new JButton("S");
        seButt = new JButton("Se");
        fButt = new JButton("F");
        clButt = new JButton("Cl");
        brButt = new JButton("Br");
        sidePanel = new JPanel();

        sidePanel.setSize(100,500);
        sidePanel.setLayout(experimentLayout);

        sidePanel.add(liButt);
        sidePanel.add(beButt);
        sidePanel.add(naButt);
        sidePanel.add(mgButt);
        sidePanel.add(kButt);
        sidePanel.add(caButt);
        sidePanel.add(rbButt);
        sidePanel.add(oButt);
        sidePanel.add(sButt);
        sidePanel.add(seButt);
        sidePanel.add(fButt);
        sidePanel.add(clButt);
        sidePanel.add(brButt);
        sidePanel.add(hButt);

        draw = new mpressListener();
        addMouseListener(draw);
        hButt.addActionListener(new makeHydrogen());
        clButt.addActionListener(new makeChlorine());
        liButt.addActionListener(new makeLithium());
        naButt.addActionListener(new makeSodium());
        kButt.addActionListener(new makePotassium());
        beButt.addActionListener(new makeBeryllium());
        mgButt.addActionListener(new makeMagnesium());
        caButt.addActionListener(new makeCalcium());
        oButt.addActionListener(new makeOxygen());
        sButt.addActionListener(new makeSulfur());
        seButt.addActionListener(new makeSelenium());
        fButt.addActionListener(new makeFlourine());
        brButt.addActionListener(new makeBromine());

        RemovePrevious.addActionListener(new MenuActionListener2());
        clearElement.addActionListener(new MenuActionListener());
        Help.addActionListener(new MenuActionListener());

    }

    class mpressListener implements MouseListener{
        int x = 0;
        int y = 0;

        public void mousePressed(MouseEvent e){
            x = e.getX();
            y = e.getY();

            if (drawElem == 1){
                Element hydrogen = new Element(1, "Hydrogen", "H", "Other nonmetals", false, new Ellipse2D.Double(x - 50, y - 50, 100, 100));
                flavour.setText("Fun Facts!: Hydrogen is the most common element and is also the lightest element!");
                elements.add(hydrogen);
                countCircles();
                repaint();
            }

            if (drawElem == 17){
                Element chlorine = new Element(17, "Chlorine", "Cl", "Halogens", false, new Ellipse2D.Double(x - 50, y - 50, 100, 100));
                flavour.setText("Fun Facts!: Chlorine is often used to keep water safe to drink!");
                elements.add(chlorine);
                countCircles();
                repaint();
            }
            if (drawElem == 3) {
                Element lithium = new Element(3, "Lithium", "Li", "Alkali Metals", true, new Ellipse2D.Double(x - 50, y - 50, 100, 100));
                flavour.setText("Fun Facts!: Lithium is a Metal, but it is very soft.");
                elements.add(lithium);
                countCircles();
                repaint();
            }
            if (drawElem == 11) {
                Element sodium = new Element(11, "Sodium", "Na", "Alkali Metals", true, new Ellipse2D.Double(x - 50, y - 50, 100, 100));
                flavour.setText("Fun Facts!: Sodium is an essential element for living organisms on Earth!");
                elements.add(sodium);
                countCircles();
                repaint();
            }
            if (drawElem == 19) {
                Element potassium = new Element (19, "Potassium", "K", "Alkali Metals", true, new Ellipse2D.Double(x - 50, y - 50, 100, 100));
                flavour.setText("Fun Facts!: Potassium is found in Bananas! It reacts when in contact with Water!");
                elements.add(potassium);
                countCircles();
                repaint();
            }
            if (drawElem == 4) {
                Element beryllium = new Element (4, "Beryllium", "Be", "Alkaline Earth Metals", true, new Ellipse2D.Double(x - 50, y - 50, 100, 100));
                flavour.setText("Fun Facts!: Berylium is hard metal, but it is very brittle at room temperature!");
                elements.add(beryllium);
                countCircles();
                repaint();
            }
            if (drawElem == 12) {
                Element magnesium = new Element (12, "Magnesium", "Mg", "Alkaline Earth Metals", true, new Ellipse2D.Double(x - 50, y - 50, 100, 100));
                flavour.setText("Fun Facts!: Magnesium is a flammable element, don't light it!");
                elements.add(magnesium);
                countCircles();
                repaint();
            }
            if (drawElem == 20) {
                Element calcium = new Element (20, "Calcium", "Ca", "Alkaline Earth Metals", true, new Ellipse2D.Double(x - 50, y - 50, 100, 100));
                flavour.setText("Fun Facts!: Calcium is the fifth most abundant element by mass on Earth! It is an essential component for living organisms!");
                elements.add(calcium);
                countCircles();
                repaint();
            }
            if (drawElem == 8) {
                Element oxygen = new Element (8, "Oxygen", "O", "Other nonmetals", false, new Ellipse2D.Double(x - 50, y - 50, 100, 100));
                flavour.setText("Fun Facts!: Oxygen needs to take a breather");
                elements.add(oxygen);
                countCircles();
                repaint();
            }
            if (drawElem == 16) {
                Element sulfur = new Element (16, "Sulfur", "S", "Other nonmetals", false, new Ellipse2D.Double(x - 50, y - 50, 100, 100));
                flavour.setText("Fun Facts!: Sulfur is often associated with the smell of Rotten Eggs!");
                elements.add(sulfur);
                countCircles();
                repaint();
            }
            if (drawElem == 34) {
                Element selenium = new Element (34, "Selenium", "Se", "Other nonmetals", false, new Ellipse2D.Double(x - 50, y - 50, 100, 100));
                flavour.setText("Fun Facts!: Selenium Can be found in many colors, such as Red, Black, metallic gray. And so on!");
                elements.add(selenium);
                countCircles();
                repaint();
            }
            if (drawElem == 35) {
                Element bromine = new Element (35, "Bromine", "Br", "Halogens", false, new Ellipse2D.Double(x - 50, y - 50, 100, 100));
                flavour.setText("Fun Facts!: Bromine is a fuming brown liquid in room temperature that evaporates quickly!");
                elements.add(bromine);
                countCircles();
                repaint();
            }
            if (drawElem == 9) {
                Element flourine = new Element (9, "Fluorine", "F", "Halogens", false, new Ellipse2D.Double(x - 50, y - 50, 100, 100));
                flavour.setText("Fun Facts!: " +  "Fluorine is in Toronto Tap Water and Toothpaste! ");
                elements.add(flourine);
                countCircles();
                repaint();
            }
        }
        public void mouseReleased(MouseEvent e){
            drawElem = 0;
        }
        public void mouseEntered(MouseEvent e){}
        public void mouseExited(MouseEvent e){}
        public void mouseClicked(MouseEvent e){}

    }

    public void countCircles()
    {
        numcircles += 1;
        if (numcircles % 2 == 0)
        {
            compareBond(elements.get(elements.size() - 2), elements.get(elements.size() - 1));
        }
    }

    class makeHydrogen implements ActionListener {
        public void actionPerformed(ActionEvent event){
            drawElem = 1;
        }
    }

    class makeChlorine implements ActionListener {
        public void actionPerformed(ActionEvent event){
            drawElem = 17;
        }
    }

    class makeLithium implements ActionListener {
        public void actionPerformed(ActionEvent event){
            drawElem = 3;
        }
    }

    class makeSodium implements ActionListener {
        public void actionPerformed(ActionEvent event){
            drawElem = 11;
        }
    }

    class makePotassium implements ActionListener {
        public void actionPerformed(ActionEvent event){
            drawElem = 19;
        }
    }
    class makeBeryllium implements ActionListener {
        public void actionPerformed(ActionEvent event){
            drawElem = 4;
        }
    }
    class makeMagnesium implements ActionListener {
        public void actionPerformed(ActionEvent event){
            drawElem = 12;
        }
    }
    class makeCalcium implements ActionListener {
        public void actionPerformed(ActionEvent event){
            drawElem = 20;
        }
    }
    class makeOxygen implements ActionListener {
        public void actionPerformed(ActionEvent event){
            drawElem = 8;
        }
    }
    class makeSulfur implements ActionListener {
        public void actionPerformed(ActionEvent event){
            drawElem = 16;
        }
    }
    class makeSelenium implements ActionListener {
        public void actionPerformed(ActionEvent event){
            drawElem = 34;
        }
    }
    class makeBromine implements ActionListener {
        public void actionPerformed(ActionEvent event){
            drawElem = 35;
        }
    }
    class makeFlourine implements ActionListener {
        public void actionPerformed(ActionEvent event){
            drawElem = 9;
        }
    }

    class MenuActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            numcircles = 0;
            elements.clear();
            repaint();
        }
    }

    class MenuActionListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            numcircles -= 1;
            elements.remove(elements.size()-1);
            repaint();
        }
    }

    public void paintComponent( Graphics g )
    {
        Graphics2D g2 = (Graphics2D) g;
        for(Element i : elements) {
            i.draw(g2);
        }
    }

    //this method will compare the given elements and call the appropriate bond method (if one exists)
    public void compareBond(Element e1, Element e2)
    {
        //if one element is a non-metal, and the other is a metal, call the ionic bond function
        if (e1.isMetal() == true && e2.isMetal() == false )
            ionicBond(true,e1, e2);
        else if (e1.isMetal() == false && e2.isMetal() == true)
             ionicBond(false,e1, e2);
        //if both elements are non-metals, call the covalent bond function.
        else if (e1.isMetal() == false && e2.isMetal() == false)
        {
            covalentBond(e1, e2);
        }
        //For the current stage of this project, no other combinations of elements will be considered
        else {JOptionPane.showMessageDialog(null, "Does not form a bond", "FormingBonds", JOptionPane.INFORMATION_MESSAGE);};
    }

    //if the two elements can theoretically form an ionic bond, this method will determine of one is possible
    public void ionicBond(boolean d, Element first, Element second){
        //variables to hold the electrons in the outer rings of each element
        int firstOuterElectrons, secondOuterElectrons;
        firstOuterElectrons = first.getOuterElectrons();
        secondOuterElectrons = second.getOuterElectrons();
        boolean two = false;

        //if both electrons can give up or take in electrons so that they both have complete outer layers, then an ionic bond is formed
        if (firstOuterElectrons + secondOuterElectrons == 8){
            if (d){
                if (firstOuterElectrons == 2){
                    two=true;
                    first.setElectrons(first.getElectrons() - 2, true);
                    second.setElectrons(second.getElectrons() + 2, false);
                    
                }
                else{
                    first.setElectrons(first.getElectrons() - 1, true);
                    second.setElectrons(second.getElectrons() + 1, false);
                }
                createEdgeIonic(first, second, two);
            }
            else{
                if (secondOuterElectrons == 2){
                    two = true;
                    second.setElectrons(second.getElectrons() - 2, true);
                    first.setElectrons(first.getElectrons() +2, false);
                }
                else{
                    second.setElectrons(second.getElectrons() - 1, true);
                    first.setElectrons(first.getElectrons() +1, false);
                }
                createEdgeIonic(second, first, two);
            }
            JOptionPane.showMessageDialog(null, "Ionic bond formed!", "FormingBonds", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (first.getName() == "Hydrogen" && secondOuterElectrons == 1 ) 
        {
            second.setElectrons(second.getElectrons() - 1, true);
            first.setElectrons(first.getElectrons() +1, false);
            createEdgeIonic(first, second, false);
            JOptionPane.showMessageDialog(null, "Ionic bond formed!",  "FormingBonds", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (second.getName() == "Hydrogen" && firstOuterElectrons == 1){
            second.setElectrons(second.getElectrons() + 1, false);
            first.setElectrons(first.getElectrons() -1, true);
            createEdgeIonic(second, first, false);
            JOptionPane.showMessageDialog(null, "Ionic bond formed!",  "FormingBonds", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Requirements not met from Ionic bond formation!",  "FormingBonds", JOptionPane.INFORMATION_MESSAGE);
        }
        repaint();
    }

    //if the two elements can theoretically form an covalent bond, this method will determine of one is possible
    public void covalentBond(Element e1, Element e2) {
        //variables to hold the electrons in the outer rings of each element
        int firstOuterElectrons, secondOuterElectrons;
        firstOuterElectrons = e1.getOuterElectrons();
        secondOuterElectrons = e2.getOuterElectrons();
        //boolean to remember if a bond has been formed
        boolean bond = false;
        boolean unfinished = false;
        boolean two = false;

        //variables for electrons that each element needs to complete. its outer ring
        int eNeededE1 = 8 - firstOuterElectrons;
        int eNeededE2 = 8 - secondOuterElectrons;

        //special case for Hydrogen, which only needs 2 electrons to fill up its outer layer
        if (e1.getName() == "Hydrogen")
        {
            eNeededE1 = 1;
        }
        if (e2.getName() == "Hydrogen")
        {
            eNeededE2 = 1;
        }

        //if both elements need the same amount of electrons, a bond can be formed
        if (eNeededE1 == eNeededE2) {
            if (eNeededE1 == 2){
                two = true;
            }
            e1.setElectrons(e1.getElectrons() + eNeededE1, false);
            e2.setElectrons(e2.getElectrons() + eNeededE2, false);
            JOptionPane.showMessageDialog(null, "Covalent bond formed, brah",  "FormingBonds", JOptionPane.INFORMATION_MESSAGE);
            bond = true;
        }

        //checking if doubles of one element is needed to bond with another element
        if (eNeededE1 == 2 * eNeededE2)
        {
            JOptionPane.showMessageDialog(null, "Bond is only possible with 2 " + e2.getName() + " atoms And 1 " + e1.getName() + " atom", "FormingBonds", JOptionPane.INFORMATION_MESSAGE);
            bond = true;
            unfinished = true;
        }
        if (eNeededE2 == 2 * eNeededE1)
        {
            JOptionPane.showMessageDialog(null,"Bond is only possible with 2 " + e1.getName() + " atoms And 1 " + e2.getName() + " atom", "FormingBonds", JOptionPane.INFORMATION_MESSAGE);
            bond = true;
            unfinished = true;
        }

        //If no bond has been found yet, then no bond exists
        if (!bond && !unfinished )
        {
            JOptionPane.showMessageDialog(null,"No bonds here, brah", "FormingBonds", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (bond && !unfinished && !two)
            createEdgeCovalent(e1,e2, false);
        else if (bond && !unfinished && two)
            createEdgeCovalent(e1,e2, true);
    }

    public void createEdgeIonic(Element empty, Element full, boolean two){
        double x1,x2,y1,y2;
        double length, prevLength, minLength=10000069;
        Ellipse2D.Double emptyRing = empty.getOuterRing();
        outerElec = full.getOuterArray();
        x2 = emptyRing.getCenterX();
        y2 = emptyRing.getCenterY();
        for(Ellipse2D.Double i : outerElec){
            x1 = i.getX();
            y1 = i.getY();
            length = Math.sqrt( ( ( x2 - x1 ) * ( x2 - x1 ) ) + ( ( y2 - y1 ) * ( y2 - y1 ) ) );
            if (length< minLength){
                minLength = length;
                closestValanceElectron2 = closestValanceElectron;
                closestValanceElectron = i;

            }
            
        }
        edge= new Line2D.Double(x2, y2, closestValanceElectron.getCenterX(), closestValanceElectron.getCenterY());
        full.setEdge(edge);
        if(two){
            edge= new Line2D.Double(x2, y2, closestValanceElectron2.getCenterX(), closestValanceElectron2.getCenterY());
            empty.setEdge(edge);
        }

    }

    public void createEdgeCovalent(Element one, Element two, boolean twotrue){
        double x1,x2,y1,y2;
        double length, minLength=10000069;
        oneValance = one.getOuterArray();
        twoValance = two.getOuterArray();

        for (Ellipse2D.Double i : oneValance){
            x1 = i.getX();
            y1 = i.getY();
            for (Ellipse2D.Double j : twoValance){
                x2 = j.getX();
                y2 = j.getY();
                length = Math.sqrt( ( ( x2 - x1 ) * ( x2 - x1 ) ) + ( ( y2 - y1 ) * ( y2 - y1 ) ) );
                if (length< minLength){
                    minLength = length;
                    closestValanceElectron3 = closestValanceElectron;
                    closestValanceElectron4 = closestValanceElectron2;
                    closestValanceElectron = i;
                    closestValanceElectron2 = j;
                }

            }
        }
        edge= new Line2D.Double(closestValanceElectron2.getCenterX(), closestValanceElectron2.getCenterY(), closestValanceElectron.getCenterX(), closestValanceElectron.getCenterY());
        one.setEdge(edge);
        if (twotrue){
            edge= new Line2D.Double(closestValanceElectron4.getCenterX(), closestValanceElectron4.getCenterY(), closestValanceElectron3.getCenterX(), closestValanceElectron3.getCenterY());
            two.setEdge(edge);
        }

    }
}