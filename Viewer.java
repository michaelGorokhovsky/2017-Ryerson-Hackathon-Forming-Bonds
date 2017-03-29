import java.awt.BorderLayout;
import javax.swing.*;

public class Viewer{
    private static JFrame mainframe;
    private static JFrame sideframe;

    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mainframe = new JFrame();
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setSize(900,900);
        BorderLayout layout = new BorderLayout();
        mainframe.setLayout(layout);
        final GraphComp comp = new GraphComp();
        comp.setSize(900,900);

        mainframe.add(comp.optionBar, BorderLayout.NORTH);
        mainframe.add(comp,BorderLayout.CENTER);
        mainframe.setVisible(true);
        mainframe.setTitle("Forming Bonds");
        mainframe.add(comp.textPanel, BorderLayout.SOUTH);

        sideframe = new JFrame();
        sideframe.setSize(100,500);
        sideframe.add(comp.sidePanel);
        sideframe.setVisible(true);
        sideframe.setTitle("Elements");
    }
}