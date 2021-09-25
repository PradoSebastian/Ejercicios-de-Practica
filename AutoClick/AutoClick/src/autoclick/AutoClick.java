/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoclick;

import com.sun.javafx.fxml.expression.KeyPath;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author prado
 */
public class AutoClick {
    
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) 
    {
       AutoClick a = new AutoClick();
    }
    
    private AutoClickGUI GUI = null;
    private AutoClickGUIMinimizada GUIm = null;
    private int x;
    private int y;
    private Timer timer1 = null;
    private Timer timer2 = null;
    private boolean oprimida = false;
    
    //Segundo Plano
    private ImageIcon imageIcon;
    private TrayIcon trayIcon;
    private SystemTray systemTray;
    
    public AutoClick()
    {
        GUI = new AutoClickGUI();
        GUIm = new AutoClickGUIMinimizada();
        GUIm.setVisible(false);
        iniciar();
        
//        Object o;
//        ArrayList<String> array = new ArrayList<>();
//        array.add("hola");
//        array.add("como estas");
//        o = array;
//        array = new ArrayList<>();
//        array = (ArrayList<String>) o;
//        System.out.println(array.get(0) + "\n" + array.get(1));
        
//        Object o = "Hola";
//        String s = o.toString();
//        System.out.println(s);
      
        
    }
    
    public void iniciar()
    {
        //Icono
        imageIcon = new ImageIcon(this.getClass().getResource("/icono/icono.png"));
        GUI.setIconImage(imageIcon.getImage());
        GUIm.setIconImage(imageIcon.getImage());
        
        //abrirActionPerformer
        abrirActionPerformer();
        
        //instanciar Tray
        instanciarTray();
        
        //KeyPressedListener
        keyPressed_new();
        
        //WindowListener
        windowListener_new();
        
        //btnListener
        btn_pressedListener();
        
        //Captura de Posición con timer
        iniciarCapturarPosicion();
        
        //Movimiento de Cursor con timer
        iniciarMoverCursor();
        
    }
    
    public void iniciarCapturarPosicion()
    {
        timer1 = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                Point cursor = MouseInfo.getPointerInfo().getLocation();
                
                if(GUI.isVisible())
                {
                    GUI.getX_label().setText(cursor.x +"");
                    GUI.getY_label().setText(cursor.y +"");
                    x = Integer.parseInt(GUI.getX_label().getText());
                    y = Integer.parseInt(GUI.getY_label().getText());
                }
                else
                {
                    GUIm.getX_label().setText(cursor.x +"");
                    GUIm.getY_label().setText(cursor.y +"");
                    x = Integer.parseInt(GUIm.getX_label().getText());
                    y = Integer.parseInt(GUIm.getY_label().getText());
                }
            }
        });
        timer1.start();
    }
    
    public void iniciarMoverCursor ()    
    {
        timer2 = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(GUI.isVisible())
                {
                    x = Integer.parseInt(GUI.getCampo_X().getText());
                    y = Integer.parseInt(GUI.getCampo_Y().getText());
                }
                else
                {
                    x = Integer.parseInt(GUIm.getCampo_X().getText());
                    y = Integer.parseInt(GUIm.getCampo_Y().getText());
                }
                
                try 
                {
                    Robot robot = new Robot();
                    robot.mouseMove(x, y);
                    robot.mousePress(InputEvent.BUTTON1_MASK);          //BUTTON1_MASK: Click Izquierdo
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);        //BUTTON2_MASK: Click en la rueda
                    timer2.stop();                                      //BUTTON3_MASK: Click Derecho
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
        });
    }

    public void minimizar()
    {
        try 
        {
            if(SystemTray.isSupported())
            {
                systemTray.add(trayIcon);
                GUI.setVisible(false);
                GUIm.setVisible(true);
                GUIm.setExtendedState(JFrame.NORMAL);
                GUIm.getCampo_X().setText(x+"");
                GUIm.getCampo_Y().setText(y+"");
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public void keyPressed_new()
    {
        GUI.addKeyListener(new java.awt.event.KeyAdapter() 
        {
            public void keyPressed(java.awt.event.KeyEvent evt) 
            {

                if(evt.getKeyCode() == KeyEvent.VK_F8)
                {
                    GUI.getCampo_X().setText(x+"");
                    GUI.getCampo_Y().setText(y+"");
                    oprimida = true;
                }
                if(evt.getKeyCode() == KeyEvent.VK_F9 && oprimida)
                {
                    timer2.start();
                }
                
            }
        });
        
        GUIm.addKeyListener(new java.awt.event.KeyAdapter() 
        {
            public void keyPressed(java.awt.event.KeyEvent evt) 
            {
                if(evt.getKeyCode() == KeyEvent.VK_F8)
                {
                    GUIm.getCampo_X().setText(x+"");
                    GUIm.getCampo_Y().setText(y+"");
                    oprimida = true;
                }
                if(evt.getKeyCode() == KeyEvent.VK_F9 && oprimida)
                {
                    timer2.start();
                }
                
            }
        }); 
        
    }
    
    public void windowListener_new()
    {
        GUI.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent we) {
            }

            @Override
            public void windowClosing(WindowEvent we) {
                
            }

            @Override
            public void windowClosed(WindowEvent we) {
                
            }

            @Override
            public void windowIconified(WindowEvent we) {
                
            }

            @Override
            public void windowDeiconified(WindowEvent we) {
                
            }

            @Override
            public void windowActivated(WindowEvent we) {
                GUIm.setVisible(false);
            }

            @Override
            public void windowDeactivated(WindowEvent we) {
                minimizar();
            }
        });
        
        GUIm.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent we) {
            }

            @Override
            public void windowClosing(WindowEvent we) {
                
            }

            @Override
            public void windowClosed(WindowEvent we) {
                
            }

            @Override
            public void windowIconified(WindowEvent we) 
            {
                GUIm.setVisible(true);
                GUIm.setExtendedState(JFrame.NORMAL);
            }

            @Override
            public void windowDeiconified(WindowEvent we) {
            }

            @Override
            public void windowActivated(WindowEvent we) {
                
            }

            @Override
            public void windowDeactivated(WindowEvent we) {
                GUIm.setVisible(true);
                GUIm.setExtendedState(JFrame.NORMAL);
                
            }
        });
    }
    
    public void btn_pressedListener()
    {
        GUI.getBtn_instrucciones().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                JOptionPane.showMessageDialog(null, "F8 Captura las coordenadas" + 
                "\nF9 Ejecuta el autoClick", "Instrucciones", JOptionPane.INFORMATION_MESSAGE);
                GUIm.setVisible(false);
                GUI.setVisible(true);
                GUI.setExtendedState(JFrame.NORMAL);
                systemTray.remove(trayIcon);
            }
        });
    }
    
    public void abrirActionPerformer()
    {
        GUI.getAbrir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                systemTray.remove(trayIcon);
                GUI.setVisible(true);
                GUI.setExtendedState(JFrame.NORMAL);
            }
        });
    }
    
    public void instanciarTray()
    {
        trayIcon = new TrayIcon(imageIcon.getImage(), "AutoClick", GUI.getPopup());
        trayIcon.setImageAutoSize(true);
        systemTray = SystemTray.getSystemTray();
        
    }
    
}
