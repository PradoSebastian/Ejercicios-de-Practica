/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot;

import java.awt.List;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author prado
 */
public class RobotP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        RobotP r = new RobotP();
    }
    
    public RobotP ()
    {
        iniciar();
    }
    
    private PrincipalGUI GUI;
    private ImageIcon imageIcon;
    private Robot robot;
    private int clickNoTerminado = 1000;
    private ArrayList<Integer> teclasNoSoltadas = new ArrayList<>();
    private boolean detenido = false;
    
    public void iniciar()
    {
        imageIcon = new ImageIcon(this.getClass().getResource("/images/icono.png"));
        this.GUI = new PrincipalGUI();
        colocarIcono();
        new_ActionListener_Empezar();
        new_ActionListener_volver();
        new_ActionListener_Detener();
        new_ActionListener_Empezar_Basica();
        new_ActionListener_volverBI();
    }
    
    public void colocarIcono()
    {
        this.GUI.setIconImage(imageIcon.getImage());
        this.GUI.getRobotGUI().setIconImage(imageIcon.getImage());
        this.GUI.getRobotGUI().getaGUI().setIconImage(imageIcon.getImage());
        
    }
    
    public void new_ActionListener_Empezar()
    {
        this.GUI.getRobotGUI().getaGUI().getBtn_Start().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                GUI.getRobotGUI().getaGUI().getBtn_detener().setVisible(true);
                ArrayList<Accion> acciones = GUI.getRobotGUI().getaGUI().getLista();
                try 
                {
                    robot = new Robot();

                    for (Accion accion : acciones) 
                    {
                        if(detenido)
                        {
                            break;
                        }
                        robot.delay(accion.getTiempoMs());
                        if(accion.getTipo().equals(Accion.TIPO_ABRIR_APP))
                        {
                            Runtime objrun = Runtime.getRuntime();
                            try 
                            {
                                String direccion = accion.getInformacion().toString();
                                objrun.exec(direccion);
                            } 
                            catch (Exception e) 
                            {
                                JOptionPane.showMessageDialog(null, e,  "ERROR", JOptionPane.ERROR_MESSAGE);
                                JOptionPane.showMessageDialog(null, "Se canceló la ejecución debido a un error",  "ERROR", JOptionPane.ERROR_MESSAGE);
                                break;
                            }
                        }
                        else if(accion.getTipo().equals(Accion.TIPO_ABRIR_LINK))
                        {
                            if(java.awt.Desktop.isDesktopSupported())
                            {
                                java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

                                if(desktop.isSupported(java.awt.Desktop.Action.BROWSE))
                                {
                                    try 
                                    {
                                        String direccion = accion.getInformacion().toString();
                                        java.net.URI url = new java.net.URI(direccion);
                                        desktop.browse(url);
                                    } 
                                    catch (Exception e) 
                                    {
                                        JOptionPane.showMessageDialog(null, e,  "ERROR", JOptionPane.ERROR_MESSAGE);
                                        JOptionPane.showMessageDialog(null, "Se canceló la ejecución debido a un error",  "ERROR", JOptionPane.ERROR_MESSAGE);
                                        break;
                                    }
                                }

                            }
                        }
                        else if(accion.getTipo().equals(Accion.TIPO_ACCION_MOUSE))
                        {
                            if(clickNoTerminado == 1000)
                            {
                                if(accion.getAccion().equals(Accion.ACCION_M_CLICK_I_S))
                                {
                                    ArrayList<Integer> c = (ArrayList<Integer>) accion.getInformacion();
                                    robot.mouseMove(c.get(0), c.get(1));
                                    robot.mousePress(InputEvent.BUTTON1_MASK);
                                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
                                }
                                else if(accion.getAccion().equals(Accion.ACCION_M_CLICK_R_S))
                                {
                                    ArrayList<Integer> c = (ArrayList<Integer>) accion.getInformacion();
                                    robot.mouseMove(c.get(0), c.get(1));
                                    robot.mousePress(InputEvent.BUTTON2_MASK);
                                    robot.mouseRelease(InputEvent.BUTTON2_MASK);
                                }
                                else if(accion.getAccion().equals(Accion.ACCION_M_CLICK_D_S))
                                {
                                    ArrayList<Integer> c = (ArrayList<Integer>) accion.getInformacion();
                                    robot.mouseMove(c.get(0), c.get(1));
                                    robot.mousePress(InputEvent.BUTTON3_MASK);
                                    robot.mouseRelease(InputEvent.BUTTON3_MASK);
                                }
                                else if(accion.getAccion().equals(Accion.ACCION_M_CLICK_I))
                                {
                                    ArrayList<Integer> c = (ArrayList<Integer>) accion.getInformacion();
                                    robot.mouseMove(c.get(0), c.get(1));
                                    robot.mousePress(InputEvent.BUTTON1_MASK);
                                    clickNoTerminado = InputEvent.BUTTON1_MASK;

                                }
                                else if(accion.getAccion().equals(Accion.ACCION_M_CLICK_R))
                                {
                                    ArrayList<Integer> c = (ArrayList<Integer>) accion.getInformacion();
                                    robot.mouseMove(c.get(0), c.get(1));
                                    robot.mousePress(InputEvent.BUTTON2_MASK);
                                    clickNoTerminado = InputEvent.BUTTON2_MASK;

                                }
                                else if(accion.getAccion().equals(Accion.ACCION_M_CLICK_D))
                                {
                                    ArrayList<Integer> c = (ArrayList<Integer>) accion.getInformacion();
                                    robot.mouseMove(c.get(0), c.get(1));
                                    robot.mousePress(InputEvent.BUTTON3_MASK);
                                    clickNoTerminado = InputEvent.BUTTON3_MASK;

                                }
                                else if(accion.getAccion().equals(Accion.ACCION_M_MOVER_CURSOR))
                                {
                                    ArrayList<Integer> c = (ArrayList<Integer>) accion.getInformacion();
                                    robot.mouseMove(c.get(0), c.get(1));
                                }
                            }
                            else if(accion.getAccion().equals(Accion.ACCION_M_SOLTAR))
                            {
                                if(clickNoTerminado == InputEvent.BUTTON1_MASK)
                                {
                                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
                                }
                                else if(clickNoTerminado == InputEvent.BUTTON2_MASK)
                                {
                                    robot.mouseRelease(InputEvent.BUTTON2_MASK);
                                }
                                else if(clickNoTerminado == InputEvent.BUTTON3_MASK)
                                {
                                    robot.mouseRelease(InputEvent.BUTTON3_MASK);
                                }
                                clickNoTerminado = 1000;
                            }
                        }
                        else if(accion.getTipo().equals(Accion.TIPO_ACCION_TECLADO))
                        {
                            ArrayList<Integer> teclas = (ArrayList<Integer>) accion.getInformacion();
                            if(accion.getAccion().equals(Accion.ACCION_T_PRESS_R))
                            {
                                robot.keyPress(teclas.get(0));
                                robot.keyRelease(teclas.get(0));
                            }
                            else if(accion.getAccion().equals(Accion.ACCION_T_HOLD_PRESS))
                            {
                                robot.keyPress(teclas.get(0));
                                teclasNoSoltadas.add(teclas.get(0));
                            }
                            else if(accion.getAccion().equals(Accion.ACCION_T_RELEASE))
                            {
                                for (Integer t : teclasNoSoltadas) 
                                {
                                    if(t == teclas.get(0))
                                    {
                                        robot.keyRelease(teclas.get(0));
                                        teclasNoSoltadas.remove(t);
                                        break;
                                    }
                                }
                            }
                            else if(accion.getAccion().equals(Accion.ACCION_T_WRITE))
                            {
                                for (Integer tecla : teclas) 
                                {
                                    robot.keyPress(tecla);
                                    robot.keyRelease(tecla);
                                }
                            }
                        }
                    }
                
                } 
                catch (Exception e) 
                {
                    JOptionPane.showMessageDialog(null, e,  "ERROR", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, "Se canceló la ejecución debido a un error",  "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                detener();
                GUI.getRobotGUI().getaGUI().getBtn_detener().setVisible(false);
                detenido = false;
                GUI.getRobotGUI().getaGUI().getBtn_Start().setSelected(false);
            }
        });
        
    }
    
    public void detener()
    {
        this.detenido = true;
        if(clickNoTerminado == InputEvent.BUTTON1_MASK)
        {
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
        }
        else if(clickNoTerminado == InputEvent.BUTTON2_MASK)
        {
            robot.mouseRelease(InputEvent.BUTTON2_MASK);
        }
        else if(clickNoTerminado == InputEvent.BUTTON3_MASK)
        {
            robot.mouseRelease(InputEvent.BUTTON3_MASK);
        }
        clickNoTerminado = 1000;
        
        for (Integer t : teclasNoSoltadas) 
        {
            robot.keyRelease(t);
        }
        teclasNoSoltadas = new ArrayList<>();
        
        
    }
    
    public void new_ActionListener_volver()
    {
        this.GUI.getRobotGUI().getaGUI().getBtn_volver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                GUI.getRobotGUI().getaGUI().reiniciarFrame();
                GUI.getRobotGUI().setVisible(true);
                GUI.getRobotGUI().getaGUI().setVisible(false);
                GUI.getRobotGUI().getaGUI().getBtn_volver().setSelected(false);
            }
        });
        

    }
    
    public void new_ActionListener_volverBI()
    {
        this.GUI.getRobotGUI().getbIGUI().getBtn_volver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                GUI.getRobotGUI().setVisible(true);
                GUI.getRobotGUI().getbIGUI().setVisible(false);
                GUI.getRobotGUI().getaGUI().getBtn_volver().setSelected(false);
            }
        });
        

    }
    
    public void new_ActionListener_Detener()
    {
        this.GUI.getRobotGUI().getaGUI().getBtn_detener().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                detener();
                GUI.getRobotGUI().getaGUI().getBtn_detener().setVisible(false);
                GUI.getRobotGUI().getaGUI().getBtn_detener().setSelected(false);
            }
        });


    }
    
    public void new_ActionListener_Empezar_Basica()
    {
        this.GUI.getRobotGUI().getbIGUI().getBtn_empezar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                GUI.getRobotGUI().getbIGUI().setDetener(false);
                crearHilo();
                
                
            }
        });
    }
    
    public void crearHilo()
    {
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try 
                {
                    robot = new Robot();
                    int cont = 1;
                    while(true)
                    {
                        if(cont == 5)
                        {
                            robot.delay(2500);
                            cont = 1;
                        }
                        if(GUI.getRobotGUI().getbIGUI().getDetener() == true)
                        {
                            break;
                        }

                        int x1 = 649;          //Completar CC
                        int y1 = 767;

                        int x2 = 673;          //Completar CC
                        int y2 = 670;
                        
                        int x3 = 647;          // Completar CC
                        int y3 = 655;

                        robot.delay(2500);
                        
                        robot.mouseMove(x1, y1);              
                        robot.mousePress(InputEvent.BUTTON1_MASK);
                        robot.mouseRelease(InputEvent.BUTTON1_MASK);

                        robot.delay(2500);

                        robot.mouseMove(x2, y2);              
                        robot.mousePress(InputEvent.BUTTON1_MASK);
                        robot.mouseRelease(InputEvent.BUTTON1_MASK);

                        robot.delay(2500);
                        robot.mouseMove(x3, y3);              
                        robot.mousePress(InputEvent.BUTTON1_MASK);
                        robot.mouseRelease(InputEvent.BUTTON1_MASK);
                        cont++;
                    }      
                } 
                catch (Exception e) 
                {

                }
            }
        });
        hilo.start();
    }
    
}
