/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot;

import java.sql.Time;

/**
 *
 * @author prado
 */
public class Accion
{
    //Constantes de Tipo
    public static final String TIPO_ABRIR_APP = "Abrir una Aplicación";
    public static final String TIPO_ABRIR_LINK = "Abrir un Link";
    public static final String TIPO_ACCION_MOUSE = "Acción con el mouse";
    public static final String TIPO_ACCION_TECLADO = "Acción con el teclado";
    
    //Constante de Accion Abrir App
    public static final String ACCION_A_APP = "Abrir";
    
    //Constante de Accion Abrir Link
    public static final String ACCION_A_LINK = "Abrir";
        
    //Constantes Acciones Mouse
    public static final String ACCION_M_MOVER_CURSOR = "Mover Cursor";
    public static final String ACCION_M_CLICK_I_S = "Click Izquierdo y Soltar";
    public static final String ACCION_M_CLICK_R_S = "Click Rueda y Soltar";
    public static final String ACCION_M_CLICK_D_S = "Click Derecho y Soltar";
    public static final String ACCION_M_CLICK_I = "Click Izquierdo";
    public static final String ACCION_M_CLICK_R = "Click Rueda";
    public static final String ACCION_M_CLICK_D = "Click Derecho";
    public static final String ACCION_M_SOLTAR = "Soltar";
    
    //Constantes Acciones Teclado
    public static final String ACCION_T_PRESS_R = "Presionar y Soltar";
    public static final String ACCION_T_HOLD_PRESS = "Mantener Presionado";
    public static final String ACCION_T_RELEASE = "Soltar";
    public static final String ACCION_T_WRITE = "Escribir Frase";
            
    private int num_accion;
    private String tipo;
    private String accion;
    private Object informacion;
    private int tiempoMs;
    
    public Accion(int num, String tipo, String accion, Object información, int tiempo)
    {
        this.num_accion = num;
        this.tipo = tipo;
        this.accion = accion;
        this.informacion = información;
        this.tiempoMs = tiempo;
    }

    public int getNum_accion() {
        return num_accion;
    }

    public String getTipo() {
        return tipo;
    }

    public String getAccion() {
        return accion;
    }

    public Object getInformacion() {
        return informacion;
    }

    public int getTiempoMs() {
        return tiempoMs;
    }

    public void setNum_accion(int num_accion) {
        this.num_accion = num_accion;
    }
    
    
    
}
