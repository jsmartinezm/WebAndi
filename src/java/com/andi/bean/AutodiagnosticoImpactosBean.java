/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andi.bean;

import com.andi.dao.AutodiagnosticoImpactoDAO;
import com.andi.model.Pregunta;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author juanse0529
 */
@Named(value = "autodiagnosticoImpactosBean")
@SessionScoped
public class AutodiagnosticoImpactosBean implements Serializable {

    /**
     * Creates a new instance of AutodiagnosticoImpactosBean
     */
    public AutodiagnosticoImpactosBean() {
    }
    
    private ArrayList<Pregunta> preguntas;
    private ArrayList<Pregunta> todasPreguntas;
    private String continua;
    private String continuaDos;
    private String continuaTres;
    private String continuaCuatro;
    private String finaliza;
    
    private String primeraPagina;
    private String segundaPagina;
    private String terceraPagina;
    private String cuartaPagina;
    private String quintaPagina;
    
    
    private Pregunta pregunta1;
    private Pregunta pregunta2;
    private Pregunta pregunta3;
    private Pregunta pregunta4;
    private Pregunta pregunta5;
    private Pregunta pregunta51;
    private Pregunta pregunta52;
    private Pregunta pregunta521;
    private Pregunta pregunta53;
    private Pregunta pregunta54;
    private Pregunta pregunta55;
    private Pregunta pregunta56;
    private Pregunta pregunta561;
    private Pregunta pregunta562;
    private Pregunta pregunta563;
    
    @PostConstruct
    public void init() {
        setContinua("pointer-events: none;opacity: 0.5;");
        
        setPrimeraPagina("");
        FacesContext context = FacesContext.getCurrentInstance();
        AutodiagnosticoImpactoDAO autoDAO = new AutodiagnosticoImpactoDAO();
        setPreguntas(autoDAO.getPreguntas());
        setPregunta1(getPreguntas().get(0));
        getPregunta1().setClase("");
        getPregunta1().setRespuesta("0");
        setPregunta2(getPreguntas().get(1));
        setPregunta3(getPreguntas().get(2));
        setPregunta4(getPreguntas().get(3));
        setPregunta5(getPreguntas().get(4));
        setPregunta51(getPreguntas().get(5));
        setPregunta52(getPreguntas().get(6));
        setPregunta521(getPreguntas().get(7));
        setPregunta53(getPreguntas().get(8));
        setPregunta54(getPreguntas().get(9));
        setPregunta55(getPreguntas().get(10));
        setPregunta56(getPreguntas().get(11));
        setPregunta561(getPreguntas().get(12));
        setPregunta562(getPreguntas().get(13));
        setPregunta563(getPreguntas().get(14));
        
    }

    /**
     * @return the preguntas
     */
    
    public String respondePregunta() {
       if(getPregunta1().getRespuesta().equals("1")){
            cambiarEstadoDependeUno("");
        }else{
            cambiarEstadoDependeUno("display:none !important;");
            getPregunta2().setRespuesta("0");
        }
        if(getPregunta5().getRespuesta().equals("1")){
            cambiarEstadoDependeCinco("");
        }else{
            cambiarEstadoDependeCinco("display:none !important;"); 
            getPregunta52().setRespuesta("0");
            getPregunta56().setRespuesta("0");
        }
        if(getPregunta52().getRespuesta().equals("1")){
            cambiarEstadoDependeCincoDos("");
        }else{
            cambiarEstadoDependeCincoDos("display:none !important;");
        }
        if(getPregunta56().getRespuesta().equals("1")){
            cambiarEstadoDependeCincoSeis("");
        }else{
            cambiarEstadoDependeCincoSeis("display:none !important;");
        }
        
        desbloqueaSiguiente();
        FacesContext fctx = FacesContext.getCurrentInstance();  
        String pageToRefresh = fctx.getViewRoot().getViewId();   //getting View Id of current page  
        ViewHandler viewHandler = fctx.getApplication().getViewHandler();      
        UIViewRoot viewRoot = viewHandler.createView(fctx, pageToRefresh);   //ViewRoot for current page  
        viewRoot.setViewId(pageToRefresh);  
        fctx.setViewRoot(viewRoot);     //set the viewroot in facesContext to reload  
        return null;  
        
    } 
    public ArrayList<Pregunta> getPreguntas() {
        return preguntas;
    }
    public void cambiarEstadoDependeUno(String accion){
        getPregunta2().setClase(accion);
        getPregunta3().setClase(accion);
        getPregunta4().setClase(accion);
        getPregunta5().setClase(accion);
    }
    
    public void cambiarEstadoDependeCinco(String accion){
        getPregunta51().setClase(accion);
        getPregunta52().setClase(accion);
        getPregunta53().setClase(accion);
        getPregunta54().setClase(accion);
        getPregunta55().setClase(accion);
        getPregunta56().setClase(accion);
        
    }
    public void cambiarEstadoDependeCincoDos(String accion){
        getPregunta521().setClase(accion);
    }
    public void cambiarEstadoDependeCincoSeis(String accion){
        getPregunta561().setClase(accion);
        getPregunta562().setClase(accion);
        getPregunta563().setClase(accion);
    }
    
    
    
    /**
     * @param preguntas the preguntas to set
     */
    public void setPreguntas(ArrayList<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    /**
     * @return the todasPreguntas
     */
    public ArrayList<Pregunta> getTodasPreguntas() {
        return todasPreguntas;
    }

    /**
     * @param todasPreguntas the todasPreguntas to set
     */
    public void setTodasPreguntas(ArrayList<Pregunta> todasPreguntas) {
        this.todasPreguntas = todasPreguntas;
    }

    /**
     * @return the pregunta1
     */
    public Pregunta getPregunta1() {
        return pregunta1;
    }

    /**
     * @param pregunta1 the pregunta1 to set
     */
    public void setPregunta1(Pregunta pregunta1) {
        this.pregunta1 = pregunta1;
    }

    /**
     * @return the pregunta2
     */
    public Pregunta getPregunta2() {
        return pregunta2;
    }

    /**
     * @param pregunta2 the pregunta2 to set
     */
    public void setPregunta2(Pregunta pregunta2) {
        this.pregunta2 = pregunta2;
    }

    /**
     * @return the pregunta3
     */
    public Pregunta getPregunta3() {
        return pregunta3;
    }

    /**
     * @param pregunta3 the pregunta3 to set
     */
    public void setPregunta3(Pregunta pregunta3) {
        this.pregunta3 = pregunta3;
    }

    /**
     * @return the pregunta4
     */
    public Pregunta getPregunta4() {
        return pregunta4;
    }

    /**
     * @param pregunta4 the pregunta4 to set
     */
    public void setPregunta4(Pregunta pregunta4) {
        this.pregunta4 = pregunta4;
    }

    /**
     * @return the pregunta5
     */
    public Pregunta getPregunta5() {
        return pregunta5;
    }

    /**
     * @param pregunta5 the pregunta5 to set
     */
    public void setPregunta5(Pregunta pregunta5) {
        this.pregunta5 = pregunta5;
    }

    

    /**
     * @return the continua
     */
    public String getContinua() {
        return continua;
    }

    /**
     * @param continua the continua to set
     */
    public void setContinua(String continua) {
        this.continua = continua;
    }
    public void desbloqueaSiguiente(){
        if(getPrimeraPagina().equals("")){    
            if( !pregunta1.getRespuesta().equals("0") 
                && (!pregunta2.getClase().equals("")|(getPregunta2().getClase().equals("")&&!pregunta2.getRespuesta().equals("0")))
                && (!pregunta3.getClase().equals("")|(getPregunta3().getClase().equals("")&&!pregunta3.getRespuesta().equals("0")))
                && (!pregunta4.getClase().equals("")|(getPregunta4().getClase().equals("")&&!pregunta4.getRespuesta().equals("0")))
                && (!pregunta5.getClase().equals("")|(getPregunta5().getClase().equals("")&&!pregunta5.getRespuesta().equals("0")))
                && (!pregunta51.getClase().equals("")|(pregunta51.getClase().equals("")&&!pregunta51.getRespuesta().equals("0")))
                && (!pregunta52.getClase().equals("")|(pregunta52.getClase().equals("")&&!pregunta52.getRespuesta().equals("0")))
                && (!pregunta521.getClase().equals("")|(pregunta521.getClase().equals("")&&!pregunta521.getRespuesta().equals("0")))
                && (!pregunta53.getClase().equals("")|(pregunta53.getClase().equals("")&&!pregunta53.getRespuesta().equals("0")))
                && (!pregunta54.getClase().equals("")|(pregunta54.getClase().equals("")&&!pregunta54.getRespuesta().equals("0")))
                && (!pregunta55.getClase().equals("")|(pregunta55.getClase().equals("")&&!pregunta55.getRespuesta().equals("0")))
                && (!pregunta56.getClase().equals("")|(pregunta56.getClase().equals("")&&!pregunta56.getRespuesta().equals("0")))
                && (!pregunta561.getClase().equals("")|(pregunta561.getClase().equals("")&&!pregunta561.getRespuesta().equals("0")))
                && (!pregunta562.getClase().equals("")|(pregunta562.getClase().equals("")&&!pregunta562.getRespuesta().equals("0")))
                && (!pregunta563.getClase().equals("")|(pregunta563.getClase().equals("")&&!pregunta563.getRespuesta().equals("0")))
                                                                    )
                    {
                setContinua("");
            }else{
                setContinua("pointer-events: none;opacity: 0.5;");
            }
        }
        
        
    }
    
    /**
     * @return the primeraPagina
     */
    public String getPrimeraPagina() {
        return primeraPagina;
    }

    /**
     * @param primeraPagina the primeraPagina to set
     */
    public void setPrimeraPagina(String primeraPagina) {
        this.primeraPagina = primeraPagina;
    }

    /**
     * @return the segundaPagina
     */
    public String getSegundaPagina() {
        return segundaPagina;
    }

    /**
     * @param segundaPagina the segundaPagina to set
     */
    public void setSegundaPagina(String segundaPagina) {
        this.segundaPagina = segundaPagina;
    }

    /**
     * @return the terceraPagina
     */
    public String getTerceraPagina() {
        return terceraPagina;
    }

    /**
     * @param terceraPagina the terceraPagina to set
     */
    public void setTerceraPagina(String terceraPagina) {
        this.terceraPagina = terceraPagina;
    }

    /**
     * @return the continuaDos
     */
    public String getContinuaDos() {
        return continuaDos;
    }

    /**
     * @param continuaDos the continuaDos to set
     */
    public void setContinuaDos(String continuaDos) {
        this.continuaDos = continuaDos;
    }

    /**
     * @return the continuaTres
     */
    public String getContinuaTres() {
        return continuaTres;
    }

    /**
     * @param continuaTres the continuaTres to set
     */
    public void setContinuaTres(String continuaTres) {
        this.continuaTres = continuaTres;
    }

    /**
     * @return the finaliza
     */
    public String getFinaliza() {
        return finaliza;
    }

    /**
     * @param finaliza the finaliza to set
     */
    public void setFinaliza(String finaliza) {
        this.finaliza = finaliza;
    }

    /**
     * @return the continuaCuatro
     */
    public String getContinuaCuatro() {
        return continuaCuatro;
    }

    /**
     * @param continuaCuatro the continuaCuatro to set
     */
    public void setContinuaCuatro(String continuaCuatro) {
        this.continuaCuatro = continuaCuatro;
    }

    /**
     * @return the cuartaPagina
     */
    public String getCuartaPagina() {
        return cuartaPagina;
    }

    /**
     * @param cuartaPagina the cuartaPagina to set
     */
    public void setCuartaPagina(String cuartaPagina) {
        this.cuartaPagina = cuartaPagina;
    }

    /**
     * @return the quintaPagina
     */
    public String getQuintaPagina() {
        return quintaPagina;
    }

    /**
     * @param quintaPagina the quintaPagina to set
     */
    public void setQuintaPagina(String quintaPagina) {
        this.quintaPagina = quintaPagina;
    }

    /**
     * @return the pregunta51
     */
    public Pregunta getPregunta51() {
        return pregunta51;
    }

    /**
     * @param pregunta51 the pregunta51 to set
     */
    public void setPregunta51(Pregunta pregunta51) {
        this.pregunta51 = pregunta51;
    }

    /**
     * @return the pregunta52
     */
    public Pregunta getPregunta52() {
        return pregunta52;
    }

    /**
     * @param pregunta52 the pregunta52 to set
     */
    public void setPregunta52(Pregunta pregunta52) {
        this.pregunta52 = pregunta52;
    }

    /**
     * @return the pregunta521
     */
    public Pregunta getPregunta521() {
        return pregunta521;
    }

    /**
     * @param pregunta521 the pregunta521 to set
     */
    public void setPregunta521(Pregunta pregunta521) {
        this.pregunta521 = pregunta521;
    }

    /**
     * @return the pregunta53
     */
    public Pregunta getPregunta53() {
        return pregunta53;
    }

    /**
     * @param pregunta53 the pregunta53 to set
     */
    public void setPregunta53(Pregunta pregunta53) {
        this.pregunta53 = pregunta53;
    }

    /**
     * @return the pregunta54
     */
    public Pregunta getPregunta54() {
        return pregunta54;
    }

    /**
     * @param pregunta54 the pregunta54 to set
     */
    public void setPregunta54(Pregunta pregunta54) {
        this.pregunta54 = pregunta54;
    }

    /**
     * @return the pregunta55
     */
    public Pregunta getPregunta55() {
        return pregunta55;
    }

    /**
     * @param pregunta55 the pregunta55 to set
     */
    public void setPregunta55(Pregunta pregunta55) {
        this.pregunta55 = pregunta55;
    }

    /**
     * @return the pregunta56
     */
    public Pregunta getPregunta56() {
        return pregunta56;
    }

    /**
     * @param pregunta56 the pregunta56 to set
     */
    public void setPregunta56(Pregunta pregunta56) {
        this.pregunta56 = pregunta56;
    }

    /**
     * @return the pregunta561
     */
    public Pregunta getPregunta561() {
        return pregunta561;
    }

    /**
     * @param pregunta561 the pregunta561 to set
     */
    public void setPregunta561(Pregunta pregunta561) {
        this.pregunta561 = pregunta561;
    }

    /**
     * @return the pregunta562
     */
    public Pregunta getPregunta562() {
        return pregunta562;
    }

    /**
     * @param pregunta562 the pregunta562 to set
     */
    public void setPregunta562(Pregunta pregunta562) {
        this.pregunta562 = pregunta562;
    }

    /**
     * @return the pregunta563
     */
    public Pregunta getPregunta563() {
        return pregunta563;
    }

    /**
     * @param pregunta563 the pregunta563 to set
     */
    public void setPregunta563(Pregunta pregunta563) {
        this.pregunta563 = pregunta563;
    }
}
