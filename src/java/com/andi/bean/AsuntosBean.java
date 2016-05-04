/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andi.bean;

import com.andi.dao.AsuntosDAO;
import com.andi.model.AsuntoRelevante;
import com.andi.model.Subsector;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;

/**
 *
 * @author juanse0529
 */
@Named(value = "asuntosBean")
@Dependent
public class AsuntosBean implements Serializable {

    /**
     * Creates a new instance of FocosBean
     */
    private String sector;
    private String subSector;
    private String empresa;
    private ArrayList<AsuntoRelevante> asuntos;
    public AsuntosBean() {
        
    }
    @PostConstruct
    public void init() {
        
        FacesContext context = FacesContext.getCurrentInstance();
        setSector((String) context.getExternalContext().getSessionMap().get("sector"));
        setSubSector((String) context.getExternalContext().getSessionMap().get("subsector"));
        setEmpresa((String) context.getExternalContext().getSessionMap().get("empresa"));
        
        AsuntosDAO asuntoDAO = new AsuntosDAO();
        Subsector subSectorTmp = new Subsector(getSubSector());
        setAsuntos(asuntoDAO.getAllAsuntosBySubSector(subSectorTmp));
        
        
        
    }

    /**
     * @return the sector
     */
    public String getSector() {
        return sector;
    }

    /**
     * @param sector the sector to set
     */
    public void setSector(String sector) {
        this.sector = sector;
    }

    /**
     * @return the subSector
     */
    public String getSubSector() {
        return subSector;
    }

    /**
     * @param subSector the subSector to set
     */
    public void setSubSector(String subSector) {
        this.subSector = subSector;
    }

    /**
     * @return the empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the focos
     */
    public ArrayList<AsuntoRelevante> getAsuntos() {
        return asuntos;
    }

    /**
     * @param asuntos the focos to set
     */
    public void setAsuntos(ArrayList<AsuntoRelevante> asuntos) {
        this.asuntos = asuntos;
    }
    
}
