/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Classe responsavel por aplicar restricao de digitacao nos campos de entrada 
 * de texto da inteface grafica. Com esta classe aplicada ao campo nao e 
 * possivel digitar letras e somente possivel numeros.
 * 
 * @author Walter
 */
public class ApenasNumeros extends PlainDocument{

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        super.insertString(offs, str.replaceAll("[^0-9]", ""), a); 
    }
    
}
