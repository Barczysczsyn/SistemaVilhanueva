/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;//nao entendi pq tem q importar

/**
 *
 * @author jmbvi
 */
public class Util {

    public static void habilitar(boolean valor, JComponent... vetComp) {//vetcomp e um varargs
        for (int i = 0; i < vetComp.length; i++) {
            vetComp[i].setEnabled(valor);
        }
    }

    public static void limparCampos(JComponent... vetComp) {//metodo estatico pode ser usado sem atribuir a um objeto
        for (int i = 0; i < vetComp.length; i++) {
            if (vetComp[i] instanceof JTextField) {
                //JTextField texto = vetComp[i];
                //texto = vetComp[i];
                //vetComp[i].setText("");
                JTextField texto;
                texto = (JTextField) vetComp[i];
                texto.setText("");
                //System.out.println("vetcomp: " + vetComp[i]);
            } else if (vetComp[i] instanceof JComboBox) {
                JComboBox combo;
                combo = (JComboBox) vetComp[i];
                combo.setSelectedIndex(-1);
            } else if (vetComp[i] instanceof JCheckBox) {
                JCheckBox check;
                check = (JCheckBox) vetComp[i];
                check.setSelected(false);
            }
        }
    }

    public static void mensagem(String texto) {
        JOptionPane.showMessageDialog(null, texto, "Alerta", 2);
    }

    public static boolean perguntar(String texto) {
        int resp = JOptionPane.showConfirmDialog(null, texto, "Confirmar", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            return true;
        }else{
    return false;
    }
    }
    //////////////////////////////////////////////////////////////////////////////////___________________////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////|                   |/////////////////////////////////////////////////////////////////////////////////// 
    /////////////////////////////////////////////////////////////////////////////////|  As conversões    |/////////////////////////////////////////////////////////////////////////////////// 
    /////////////////////////////////////////////////////////////////////////////////|___________________|/////////////////////////////////////////////////////////////////////////////////// 

    public static int strInt(String cad) {
        return Integer.parseInt(cad);
    }

    public static String intStr(int num) {
        return String.valueOf(num);
    }

    public static double strDouble(String cad) {
        return Double.parseDouble(cad);
    }

    public static String doubleStr(double num) {
        return String.valueOf(num);
    }

    public static Date strDate(String cad) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;
        try {
            data = formato.parse(cad);
        } catch (ParseException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro: " + ex.getMessage());
        }
        return data;
    }

    public static String dateStr(Date data) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String cad = formato.format(data);
    
        return cad;
        
    }
}
