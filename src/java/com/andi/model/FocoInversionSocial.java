package com.andi.model;
// Generated 7/05/2016 07:34:50 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * FocoInversionSocial generated by hbm2java
 */
public class FocoInversionSocial  implements java.io.Serializable {


     private long foinsoId;
     private String foinsoNombre;
     private Set subsectorFocos = new HashSet(0);

    public FocoInversionSocial() {
    }

	
    public FocoInversionSocial(long foinsoId) {
        this.foinsoId = foinsoId;
    }
    public FocoInversionSocial(long foinsoId, String foinsoNombre, Set subsectorFocos) {
       this.foinsoId = foinsoId;
       this.foinsoNombre = foinsoNombre;
       this.subsectorFocos = subsectorFocos;
    }
   
    public long getFoinsoId() {
        return this.foinsoId;
    }
    
    public void setFoinsoId(long foinsoId) {
        this.foinsoId = foinsoId;
    }
    public String getFoinsoNombre() {
        return this.foinsoNombre;
    }
    
    public void setFoinsoNombre(String foinsoNombre) {
        this.foinsoNombre = foinsoNombre;
    }
    public Set getSubsectorFocos() {
        return this.subsectorFocos;
    }
    
    public void setSubsectorFocos(Set subsectorFocos) {
        this.subsectorFocos = subsectorFocos;
    }




}


