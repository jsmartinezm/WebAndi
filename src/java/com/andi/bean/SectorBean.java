/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andi.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author juanse0529
 */
@Named(value = "sectorBean")
@SessionScoped
public class SectorBean implements Serializable {

    /**
     * Creates a new instance of SectorBean
     */
    public SectorBean() {
    }
    
    public void returnUsuarioById(){
        
    }
    
}
