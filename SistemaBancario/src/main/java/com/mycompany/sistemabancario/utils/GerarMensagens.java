
package com.mycompany.sistemabancario.utils;

import java.awt.Component;
import javax.swing.JOptionPane;


public class GerarMensagens {
    
    public static void alerta(Component parent, Object mensagem){
        JOptionPane.showMessageDialog(parent, mensagem);
    }
    
    public static void erro(Component parent, Object mensagem){
        JOptionPane.showMessageDialog(parent, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
}
