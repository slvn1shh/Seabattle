import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Drawer extends JFrame {
    JScrollPane battlefield;
    JTable field;
    JPanel controls;
    JButton take,exit;
    TextField choise;

    private void buildInterface() throws IOException {
        setTitle("ROYAL SEABATTLE");
        setAlwaysOnTop(true);
        //controls
        take = new JButton("SHOT!");
        exit = new JButton("Exit game");
        choise = new TextField(null,2);
        choise.setPreferredSize(new Dimension(40,20));


        //battlefield
        field = new JTable(10,10);
        field.setEnabled(false);
        field.setDragEnabled(false);
        field.setRowHeight(75);
        BufferedImage img = ImageIO.read(new File("D:\\Code\\Seabattle\\src\\testIcon.png"));
        ImageIcon icon=new ImageIcon(img);
        for(int i = 0; i<10;++i){
            for(int j = 0; j<10;++j){
                field.setValueAt(icon,i,j);
                ImageIcon myIcon =
                        (ImageIcon) field.getModel().getValueAt(2, 3);
                field.setValueAt(myIcon,i,j);
            }
        }

        battlefield = new JScrollPane(field);
        battlefield.setRowHeaderView(field);
        battlefield.setViewportView(field);
        battlefield.setPreferredSize(new Dimension(500,500));

        add(field,BorderLayout.CENTER);

        //controls
        controls = new JPanel(new FlowLayout());
        controls.add(choise);
        controls.add(take);
        controls.add(exit);

        //limit TF to 2 characters
        choise.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (choise.getText().length() >= 2 )
                    e.consume();
            }
        });

        add(controls,BorderLayout.SOUTH);
        //pref
        setSize(500,500); //ничего пока что не будет, тк нет элементов
        setVisible(true);
        pack();
    }

    public static void main(String...ignore)throws Exception{
        new Drawer().buildInterface();
    }
}
