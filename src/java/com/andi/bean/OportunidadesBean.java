/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andi.bean;

import com.andi.dao.AsuntosDAO;
import com.andi.dao.OportunidadesDAO;
import com.andi.model.Oportunidad;
import com.andi.model.Subsector;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

/**
 *
 * @author juanse0529
 */
@Named(value = "oportunidadesBean")
@SessionScoped
public class OportunidadesBean implements Serializable {

    /**
     * Creates a new instance of FocosBean
     */
    private String sector;
    private String subSector;
    private String empresa;
    private ArrayList<Oportunidad> oportunidades;
    public OportunidadesBean() {
        
    }
    @PostConstruct
    public void init() {
        
        FacesContext context = FacesContext.getCurrentInstance();
        setSector((String) context.getExternalContext().getSessionMap().get("sector"));
        setSubSector((String) context.getExternalContext().getSessionMap().get("subsector"));
        setEmpresa((String) context.getExternalContext().getSessionMap().get("empresa"));
        
        OportunidadesDAO oportunidadDAO = new OportunidadesDAO();
        Subsector subSectorTmp = new Subsector(getSubSector());
        setOportunidades(oportunidadDAO.getAllOportunidadesBySubSector(subSectorTmp));
        
        
        
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
    public ArrayList<Oportunidad> getOportunidades() {
        return oportunidades;
    }

    /**
     * @param asuntos the focos to set
     */
    public void setOportunidades(ArrayList<Oportunidad> oportunidades) {
        this.oportunidades = oportunidades;
    }
}
