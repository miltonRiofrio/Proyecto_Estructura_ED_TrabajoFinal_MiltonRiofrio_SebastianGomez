/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

/**
 *
 * @author Milton Riofrio, Sebastian Gomez
 */
public class Conexion {
    private final String REPO = "datos";
    private XStream xtrStream; 
    
    /**
     * Metodo para conectar la carpeta datos al programa
     */
    public Conexion() {
        xtrStream = new XStream(new JettisonMappedXmlDriver());
        xtrStream.setMode(XStream.XPATH_RELATIVE_REFERENCES);
    }
    /**
     * 
     * @return String
     */
    public String getREPO() {
        return REPO;
    }
    /**
     * 
     * @return XSream
     */
    public XStream getXtrStream() {
        return xtrStream;
    }
}
