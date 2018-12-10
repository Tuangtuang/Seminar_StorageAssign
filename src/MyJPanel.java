import javax.swing.*;
import java.awt.*;

public class MyJPanel extends JPanel{
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.BLACK);//设置第一条线的颜色
        g.drawLine(245, 50, 245, 650);//画第一条线 点(245,50) 到点  (245,650)
        g.setColor(Color.BLACK);
        g.drawLine(315, 50, 315, 650);
        g.setColor(Color.BLACK);
        g.drawLine(245,50,315,50);
        g.setColor(Color.BLACK);
        g.drawLine(245,650,315,650);

        g.setColor(Color.BLACK);
        g.drawLine(565, 50, 565, 650);
        g.setColor(Color.BLACK);
        g.drawLine(635, 50, 635, 650);
        g.setColor(Color.BLACK);
        g.drawLine(565,50,635,50);
        g.setColor(Color.BLACK);
        g.drawLine(565,650,635,650);

        g.setColor(Color.BLACK);
        g.drawLine(885, 50, 885, 650);
        g.setColor(Color.BLACK);
        g.drawLine(955, 50, 955, 650);
        g.setColor(Color.BLACK);
        g.drawLine(885,50,955,50);
        g.setColor(Color.BLACK);
        g.drawLine(885,650,955,650);

        g.setColor(Color.BLACK);
        g.drawLine(1205, 50, 1205, 650);
        g.setColor(Color.BLACK);
        g.drawLine(1275, 50, 1275, 650);
        g.setColor(Color.BLACK);
        g.drawLine(1205,50,1275,50);
        g.setColor(Color.BLACK);
        g.drawLine(1205,650,1275,650);


    }



}
