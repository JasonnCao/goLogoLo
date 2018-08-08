/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gologolo.transactions;

import gologolo.GoLogoLo;
import gologolo.data.LogoData;
import gologolo.data.LogoPrototype;
import static gologolo.goLogoLoPropertyType.TEXT_FIELD_COMPONENT;
import javafx.scene.control.TextField;
import jtps.jTPS_Transaction;

/**
 *
 * @author jasoncao
 */
public class EditText_Transaction implements jTPS_Transaction{
    GoLogoLo app;
    LogoPrototype logoComponent;
    String newText;
    String oldText;
    TextField text;
    LogoData data;
    
    public EditText_Transaction(LogoPrototype oldComponent,String newUserText,GoLogoLo appLogo,LogoData logoData){
        logoComponent=oldComponent;
        oldText=logoComponent.getText();
        newText=newUserText;
        app=appLogo;
        data=logoData;
        //text=(TextField) app.getGUIModule().getGUINode(TEXT_FIELD_COMPONENT);
    }
    
    @Override
    public void doTransaction() {
        data.changeTextField(logoComponent, newText);       
    }

    @Override
    public void undoTransaction() {
        data.changeTextField(logoComponent, oldText);
    }
    
}
