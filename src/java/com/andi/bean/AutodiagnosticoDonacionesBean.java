/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andi.bean;

import com.andi.dao.AutodiagnosticoDonacionDAO;
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
@Named(value = "autodiagnosticoDonacionesBean")
@SessionScoped
public class AutodiagnosticoDonacionesBean implements Serializable {

    /**
     * Creates a new instance of AutodiagnosticoDonacionesBean
     */
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
    private Pregunta pregunta6;
    private Pregunta pregunta7;
    private Pregunta pregunta71;
    private Pregunta pregunta72;
    private Pregunta pregunta8;
    private Pregunta pregunta9;
    private Pregunta pregunta91;
    private Pregunta pregunta911;
    private Pregunta pregunta912;
    private Pregunta pregunta10;
    private Pregunta pregunta11;
    private Pregunta pregunta111;
    private Pregunta pregunta12;
    private Pregunta pregunta121;
    private Pregunta pregunta122;
    private Pregunta pregunta123;
    private Pregunta pregunta124;
    private Pregunta pregunta125;
    private Pregunta pregunta126;
    private Pregunta pregunta127;
    private Pregunta pregunta13;
    private Pregunta pregunta131;
    private Pregunta pregunta14;
    private Pregunta pregunta15;
    private Pregunta pregunta16;
    private Pregunta pregunta17;
    private Pregunta pregunta18;
    private Pregunta pregunta19;
    private Pregunta pregunta191;
    private Pregunta pregunta192;
    
    public AutodiagnosticoDonacionesBean() {
    }
    
    @PostConstruct
    public void init() {
        setContinua("pointer-events: none;opacity: 0.5;");
        setContinuaDos("display:none;");
        setContinuaTres("display:none;");
        setFinaliza("display:none;");
        setContinuaCuatro("display:none;");
        
        primeraPagina = "";
        segundaPagina = "display:none !important;";
        terceraPagina = "display:none !important;";
        cuartaPagina = "display:none !important";
        quintaPagina = "display:none !important";
        FacesContext context = FacesContext.getCurrentInstance();
        AutodiagnosticoDonacionDAO autoDAO = new AutodiagnosticoDonacionDAO();
        setPreguntas(autoDAO.getPreguntas());
        setPregunta1(getPreguntas().get(0));
        pregunta1.setClase("");
        pregunta1.setRespuesta("");
        setPregunta2(getPreguntas().get(1));
        setPregunta3(getPreguntas().get(2));
        setPregunta4(getPreguntas().get(3));
        setPregunta5(getPreguntas().get(4));
        setPregunta6(getPreguntas().get(5));
        setPregunta7(getPreguntas().get(6));
        setPregunta71(getPreguntas().get(7));
        setPregunta72(getPreguntas().get(8));
        setPregunta8(getPreguntas().get(9));
        setPregunta9(getPreguntas().get(10));
        setPregunta91(getPreguntas().get(11));
        setPregunta911(getPreguntas().get(12));
        setPregunta912(getPreguntas().get(13));
        setPregunta10(getPreguntas().get(14));
        setPregunta11(getPreguntas().get(15));
   
        setPregunta111(getPreguntas().get(16));
        setPregunta12(getPreguntas().get(17));
        setPregunta121(getPreguntas().get(18));
        setPregunta122(getPreguntas().get(19));
        setPregunta123(getPreguntas().get(20));
        setPregunta124(getPreguntas().get(21));
        setPregunta125(getPreguntas().get(22));
        setPregunta126(getPreguntas().get(23));
        setPregunta127(getPreguntas().get(24));
        setPregunta13(getPreguntas().get(25));
        setPregunta131(getPreguntas().get(26));
        setPregunta14(getPreguntas().get(27));
        setPregunta15(getPreguntas().get(28));
        setPregunta16(getPreguntas().get(29));
        setPregunta17(getPreguntas().get(30));
        setPregunta18(getPreguntas().get(31));
        setPregunta19(getPreguntas().get(32));
        setPregunta191(getPreguntas().get(33));
        setPregunta192(getPreguntas().get(34));
        
    }

    /**
     * @return the preguntas
     */
    
    public String respondePregunta() {
       if(pregunta1.getRespuesta().equals("1")){
            cambiarEstadoDependeUno("");
        }else{
            cambiarEstadoDependeUno("display:none !important;");
            pregunta2.setRespuesta("0");
        }
        if(pregunta2.getRespuesta().equals("1")){
            cambiarEstadoDependeDos("");
        }else{
            cambiarEstadoDependeDos("display:none !important;"); 
            
        }
        if(pregunta6.getRespuesta().equals("1") || pregunta6.getRespuesta().equals("2")){
            cambiarEstadoDependeSeis("");
        }else{
            cambiarEstadoDependeSeis("display:none !important;"); 
        }
        if(pregunta9.getRespuesta().equals("1")){
            cambiarEstadoDependeNueve("");
        }else{
            cambiarEstadoDependeNueve("display:none !important;"); 
        }
        
        if(pregunta7 != null){
            if(pregunta7.getRespuesta().equals("1")){
            cambiarEstadoDependeSiete("");
            }else{
                cambiarEstadoDependeSiete("display:none !important;"); 
            }
        }
        if(pregunta91 != null){
            if(pregunta91.getRespuesta().equals("1")){
                cambiarEstadoDependeNueveUno("");
            }else{
                cambiarEstadoDependeNueveUno("display:none !important;"); 
            }
        }
        if(pregunta13 != null){
            if(pregunta13.getRespuesta().equals("1")){
                cambiarEstadoDependeTrece("");
            }else{
                cambiarEstadoDependeTrece("display:none !important;"); 
            }
        }
        if(pregunta11 != null){
            if(pregunta11.getRespuesta().equals("1")){
                cambiarEstadoDependeOnce("");
            }else{
                cambiarEstadoDependeOnce("display:none !important;"); 
            }
        }
        if(pregunta12 != null){
            if(pregunta12.getRespuesta().equals("1")){
                cambiarEstadoDependeDoce("");
            }else{
                cambiarEstadoDependeDoce("display:none !important;"); 
            }
        }
        
        if(pregunta13 != null){
            if(pregunta13.getRespuesta().equals("1")){
                cambiarEstadoDependeTrece("");
            }else{
                cambiarEstadoDependeTrece("display:none !important;"); 
            }
        }
        
        if(pregunta19 != null){
            if(pregunta19.getRespuesta().equals("1")){
                cambiarEstadoDependeDiecinueve("");
            }else{
                cambiarEstadoDependeDiecinueve("display:none !important;"); 
            }
        }
        
        /**
        if(pregunta6.getRespuesta().equals("1")| pregunta6.getRespuesta().equals("2")){
            cambiarEstadoDependeSeis("");
        }else{
            cambiarEstadoDependeSeis("display:none !important;"); 
        }
        if(pregunta9.getRespuesta().equals("1")|pregunta9.getRespuesta().equals("2")){
            cambiarEstadoDependeNueve("");
        }else{
            cambiarEstadoDependeNueve("display:none !important;"); 
        }
        if(pregunta7.getRespuesta().equals("1")){
            cambiarEstadoDependeSiete("");
        }else{
            cambiarEstadoDependeSiete("display:none !important;"); 
        }
        if(pregunta91.getRespuesta().equals("1")){
            cambiarEstadoDependeNueveUno("");
        }else{
            cambiarEstadoDependeNueveUno("display:none !important;"); 
        }
        **/
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
        pregunta2.setClase(accion);
    }
    public void cambiarEstadoDependeDiecinueve(String accion){
        pregunta191.setClase(accion);
        pregunta192.setClase(accion);
        
    }
    public void cambiarEstadoDependeTrece(String accion){
        pregunta131.setClase(accion);
    }
    public void cambiarEstadoDependeOnce(String accion){
        pregunta111.setClase(accion);
        pregunta12.setClase(accion);
        
    }
    public void cambiarEstadoDependeDoce(String accion){
        pregunta121.setClase(accion);
        pregunta122.setClase(accion);
        pregunta123.setClase(accion);
        pregunta124.setClase(accion);
        pregunta125.setClase(accion);
        pregunta126.setClase(accion);
        pregunta127.setClase(accion);
        
    }
    public void cambiarEstadoDependeDos(String accion){
        pregunta3.setClase(accion);
        pregunta4.setClase(accion);
        pregunta5.setClase(accion);
        pregunta6.setClase(accion);
        pregunta9.setClase(accion);
        if(!accion.equals("")){
            pregunta6.setRespuesta("0");
            pregunta9.setRespuesta("0");
        }
    }
    public void cambiarEstadoDependeSeis(String accion){
        pregunta7.setClase(accion);
        pregunta8.setClase(accion);
    }
    public void cambiarEstadoDependeSiete(String accion){
        pregunta71.setClase(accion);
        pregunta72.setClase(accion);
    }
    public void cambiarEstadoDependeNueve(String accion){
        pregunta91.setClase(accion);
        pregunta10.setClase(accion);
     
    }
    public void cambiarEstadoDependeNueveUno(String accion){
        pregunta911.setClase(accion);
        pregunta912.setClase(accion);
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
     * @return the pregunta6
     */
    public Pregunta getPregunta6() {
        return pregunta6;
    }

    /**
     * @param pregunta6 the pregunta6 to set
     */
    public void setPregunta6(Pregunta pregunta6) {
        this.pregunta6 = pregunta6;
    }

    /**
     * @return the pregunta7
     */
    public Pregunta getPregunta7() {
        return pregunta7;
    }

    /**
     * @param pregunta7 the pregunta7 to set
     */
    public void setPregunta7(Pregunta pregunta7) {
        this.pregunta7 = pregunta7;
    }

    /**
     * @return the pregunta71
     */
    public Pregunta getPregunta71() {
        return pregunta71;
    }

    /**
     * @param pregunta71 the pregunta71 to set
     */
    public void setPregunta71(Pregunta pregunta71) {
        this.pregunta71 = pregunta71;
    }

    /**
     * @return the pregunta72
     */
    public Pregunta getPregunta72() {
        return pregunta72;
    }

    /**
     * @param pregunta72 the pregunta72 to set
     */
    public void setPregunta72(Pregunta pregunta72) {
        this.pregunta72 = pregunta72;
    }

    /**
     * @return the pregunta8
     */
    public Pregunta getPregunta8() {
        return pregunta8;
    }

    /**
     * @param pregunta8 the pregunta8 to set
     */
    public void setPregunta8(Pregunta pregunta8) {
        this.pregunta8 = pregunta8;
    }

    /**
     * @return the pregunta9
     */
    public Pregunta getPregunta9() {
        return pregunta9;
    }

    /**
     * @param pregunta9 the pregunta9 to set
     */
    public void setPregunta9(Pregunta pregunta9) {
        this.pregunta9 = pregunta9;
    }

    /**
     * @return the pregunta91
     */
    public Pregunta getPregunta91() {
        return pregunta91;
    }

    /**
     * @param pregunta91 the pregunta91 to set
     */
    public void setPregunta91(Pregunta pregunta91) {
        this.pregunta91 = pregunta91;
    }

    /**
     * @return the pregunta911
     */
    public Pregunta getPregunta911() {
        return pregunta911;
    }

    /**
     * @param pregunta911 the pregunta911 to set
     */
    public void setPregunta911(Pregunta pregunta911) {
        this.pregunta911 = pregunta911;
    }

    /**
     * @return the pregunta912
     */
    public Pregunta getPregunta912() {
        return pregunta912;
    }

    /**
     * @param pregunta912 the pregunta912 to set
     */
    public void setPregunta912(Pregunta pregunta912) {
        this.pregunta912 = pregunta912;
    }

    /**
     * @return the pregunta10
     */
    public Pregunta getPregunta10() {
        return pregunta10;
    }

    /**
     * @param pregunta10 the pregunta10 to set
     */
    public void setPregunta10(Pregunta pregunta10) {
        this.pregunta10 = pregunta10;
    }

    /**
     * @return the pregunta11
     */
    public Pregunta getPregunta11() {
        return pregunta11;
    }

    /**
     * @param pregunta11 the pregunta11 to set
     */
    public void setPregunta11(Pregunta pregunta11) {
        this.pregunta11 = pregunta11;
    }

    /**
     * @return the pregunta111
     */
    public Pregunta getPregunta111() {
        return pregunta111;
    }

    /**
     * @param pregunta111 the pregunta111 to set
     */
    public void setPregunta111(Pregunta pregunta111) {
        this.pregunta111 = pregunta111;
    }

    /**
     * @return the pregunta12
     */
    public Pregunta getPregunta12() {
        return pregunta12;
    }

    /**
     * @param pregunta12 the pregunta12 to set
     */
    public void setPregunta12(Pregunta pregunta12) {
        this.pregunta12 = pregunta12;
    }

    /**
     * @return the pregunta121
     */
    public Pregunta getPregunta121() {
        return pregunta121;
    }

    /**
     * @param pregunta121 the pregunta121 to set
     */
    public void setPregunta121(Pregunta pregunta121) {
        this.pregunta121 = pregunta121;
    }

    /**
     * @return the pregunta122
     */
    public Pregunta getPregunta122() {
        return pregunta122;
    }

    /**
     * @param pregunta122 the pregunta122 to set
     */
    public void setPregunta122(Pregunta pregunta122) {
        this.pregunta122 = pregunta122;
    }

    /**
     * @return the pregunta123
     */
    public Pregunta getPregunta123() {
        return pregunta123;
    }

    /**
     * @param pregunta123 the pregunta123 to set
     */
    public void setPregunta123(Pregunta pregunta123) {
        this.pregunta123 = pregunta123;
    }

    /**
     * @return the pregunta124
     */
    public Pregunta getPregunta124() {
        return pregunta124;
    }

    /**
     * @param pregunta124 the pregunta124 to set
     */
    public void setPregunta124(Pregunta pregunta124) {
        this.pregunta124 = pregunta124;
    }

    /**
     * @return the pregunta125
     */
    public Pregunta getPregunta125() {
        return pregunta125;
    }

    /**
     * @param pregunta125 the pregunta125 to set
     */
    public void setPregunta125(Pregunta pregunta125) {
        this.pregunta125 = pregunta125;
    }

    /**
     * @return the pregunta126
     */
    public Pregunta getPregunta126() {
        return pregunta126;
    }

    /**
     * @param pregunta126 the pregunta126 to set
     */
    public void setPregunta126(Pregunta pregunta126) {
        this.pregunta126 = pregunta126;
    }

    /**
     * @return the pregunta127
     */
    public Pregunta getPregunta127() {
        return pregunta127;
    }

    /**
     * @param pregunta127 the pregunta127 to set
     */
    public void setPregunta127(Pregunta pregunta127) {
        this.pregunta127 = pregunta127;
    }

    /**
     * @return the pregunta13
     */
    public Pregunta getPregunta13() {
        return pregunta13;
    }

    /**
     * @param pregunta13 the pregunta13 to set
     */
    public void setPregunta13(Pregunta pregunta13) {
        this.pregunta13 = pregunta13;
    }

    /**
     * @return the pregunta131
     */
    public Pregunta getPregunta131() {
        return pregunta131;
    }

    /**
     * @param pregunta131 the pregunta131 to set
     */
    public void setPregunta131(Pregunta pregunta131) {
        this.pregunta131 = pregunta131;
    }

    /**
     * @return the pregunta14
     */
    public Pregunta getPregunta14() {
        return pregunta14;
    }

    /**
     * @param pregunta14 the pregunta14 to set
     */
    public void setPregunta14(Pregunta pregunta14) {
        this.pregunta14 = pregunta14;
    }

    /**
     * @return the pregunta15
     */
    public Pregunta getPregunta15() {
        return pregunta15;
    }

    /**
     * @param pregunta15 the pregunta15 to set
     */
    public void setPregunta15(Pregunta pregunta15) {
        this.pregunta15 = pregunta15;
    }

    /**
     * @return the pregunta16
     */
    public Pregunta getPregunta16() {
        return pregunta16;
    }

    /**
     * @param pregunta16 the pregunta16 to set
     */
    public void setPregunta16(Pregunta pregunta16) {
        this.pregunta16 = pregunta16;
    }

    /**
     * @return the pregunta17
     */
    public Pregunta getPregunta17() {
        return pregunta17;
    }

    /**
     * @param pregunta17 the pregunta17 to set
     */
    public void setPregunta17(Pregunta pregunta17) {
        this.pregunta17 = pregunta17;
    }

    /**
     * @return the pregunta18
     */
    public Pregunta getPregunta18() {
        return pregunta18;
    }

    /**
     * @param pregunta18 the pregunta18 to set
     */
    public void setPregunta18(Pregunta pregunta18) {
        this.pregunta18 = pregunta18;
    }

    /**
     * @return the pregunta19
     */
    public Pregunta getPregunta19() {
        return pregunta19;
    }

    /**
     * @param pregunta19 the pregunta19 to set
     */
    public void setPregunta19(Pregunta pregunta19) {
        this.pregunta19 = pregunta19;
    }

    /**
     * @return the pregunta191
     */
    public Pregunta getPregunta191() {
        return pregunta191;
    }

    /**
     * @param pregunta191 the pregunta191 to set
     */
    public void setPregunta191(Pregunta pregunta191) {
        this.pregunta191 = pregunta191;
    }

    /**
     * @return the pregunta192
     */
    public Pregunta getPregunta192() {
        return pregunta192;
    }

    /**
     * @param pregunta192 the pregunta192 to set
     */
    public void setPregunta192(Pregunta pregunta192) {
        this.pregunta192 = pregunta192;
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
        if(primeraPagina.equals("")){    
            if( !pregunta1.getRespuesta().equals("0") 
                && (!pregunta2.getClase().equals("")|(pregunta2.getClase().equals("")&&!pregunta2.getRespuesta().equals("0")))
                && (!pregunta3.getClase().equals("")|(pregunta3.getClase().equals("")&&!pregunta3.getRespuesta().equals("0")))
                && (!pregunta4.getClase().equals("")|(pregunta4.getClase().equals("")&&!pregunta4.getRespuesta().equals("0")))
                && (!pregunta5.getClase().equals("")|(pregunta5.getClase().equals("")&&!pregunta5.getRespuesta().equals("0")))
                && (!pregunta6.getClase().equals("")|(pregunta6.getClase().equals("")&&!pregunta6.getRespuesta().equals("0")))
                && (!pregunta7.getClase().equals("")|(pregunta7.getClase().equals("")&&!pregunta7.getRespuesta().equals("0")))
                && (!pregunta71.getClase().equals("")|(pregunta71.getClase().equals("")&&!pregunta71.getRespuesta().equals("0")))
                && (!pregunta72.getClase().equals("")|(pregunta72.getClase().equals("")&&!pregunta72.getRespuesta().equals("0")))
                && (!pregunta8.getClase().equals("")|(pregunta8.getClase().equals("")&&!pregunta8.getRespuesta().equals("0")))
                && (!pregunta9.getClase().equals("")|(pregunta9.getClase().equals("")&&!pregunta9.getRespuesta().equals("0")))
                && (!pregunta91.getClase().equals("")|(pregunta91.getClase().equals("")&&!pregunta91.getRespuesta().equals("0")))
                && (!pregunta911.getClase().equals("")|(pregunta911.getClase().equals("")&&!pregunta911.getRespuesta().equals("0")))
                && (!pregunta912.getClase().equals("")|(pregunta912.getClase().equals("")&&!pregunta912.getRespuesta().equals("0")))
                && (!pregunta10.getClase().equals("")|(pregunta10.getClase().equals("")&&!pregunta10.getRespuesta().equals("0")))
                                                                    )
                    {
                setContinua("");
            }else{
                setContinua("pointer-events: none;opacity: 0.5;");
            }
        }
        if(segundaPagina.equals("")){
            if(!pregunta11.getRespuesta().equals("0") 
            && (!pregunta111.getClase().equals("")|(pregunta111.getClase().equals("")&&!pregunta111.getRespuesta().equals("0")))
            && (!pregunta12.getClase().equals("")|(pregunta12.getClase().equals("")&&!pregunta12.getRespuesta().equals("0")))
            && (!pregunta121.getClase().equals("")|(pregunta121.getClase().equals("")&&!pregunta121.getRespuesta().equals("0")))
            && (!pregunta122.getClase().equals("")|(pregunta122.getClase().equals("")&&!pregunta122.getRespuesta().equals("0")))
            && (!pregunta123.getClase().equals("")|(pregunta123.getClase().equals("")&&!pregunta123.getRespuesta().equals("0")))
            && (!pregunta124.getClase().equals("")|(pregunta124.getClase().equals("")&&!pregunta124.getRespuesta().equals("0")))
            && (!pregunta125.getClase().equals("")|(pregunta125.getClase().equals("")&&!pregunta125.getRespuesta().equals("0")))
            && (!pregunta126.getClase().equals("")|(pregunta125.getClase().equals("")&&!pregunta126.getRespuesta().equals("0")))
            && (!pregunta127.getClase().equals("")|(pregunta127.getClase().equals("")&&!pregunta127.getRespuesta().equals("0")))
                                                              )
                {
            setContinuaDos("");
            }else{
                setContinuaDos("pointer-events: none;opacity: 0.5;");
            }
        }
        if(terceraPagina.equals("")){
            if(!pregunta13.getRespuesta().equals("0") 
            && (!pregunta131.getClase().equals("")|(pregunta131.getClase().equals("")&&!pregunta131.getRespuesta().equals("0")))
            && (!pregunta14.getClase().equals("")|(pregunta14.getClase().equals("")&&!pregunta14.getRespuesta().equals("0")))
            && (!pregunta15.getClase().equals("")|(pregunta15.getClase().equals("")&&!pregunta15.getRespuesta().equals("0")))
            && (!pregunta16.getClase().equals("")|(pregunta16.getClase().equals("")&&!pregunta16.getRespuesta().equals("0")))
            && (!pregunta17.getClase().equals("")|(pregunta17.getClase().equals("")&&!pregunta17.getRespuesta().equals("0")))
                                                             )
                {
            setContinuaTres("");
            }else{
                setContinuaTres("pointer-events: none;opacity: 0.5;");
            }
        }
        
        if(cuartaPagina.equals("")){
            if(!pregunta18.getRespuesta().equals("0"))
                {
            setContinuaCuatro("");
            }else{
                setContinuaCuatro("pointer-events: none;opacity: 0.5;");
            }
        }
        
        if(quintaPagina.equals("")){
            if(!pregunta19.getRespuesta().equals("0")
                && (!pregunta191.getClase().equals("")|(pregunta191.getClase().equals("")&&!pregunta191.getRespuesta().equals("0")))
                && (!pregunta192.getClase().equals("")|(pregunta192.getClase().equals("")&&!pregunta192.getRespuesta().equals("0")))
           )
                {
                setFinaliza("");
            }else{
                setFinaliza("pointer-events: none;opacity: 0.5;");
            }
        }
    }
    public void segundaPagina(){
        setContinua("display:none;");
        setContinuaDos("pointer-events: none;opacity: 0.5;");
        pregunta11.setClase("");
        pregunta11.setRespuesta("0");
        segundaPagina = "";
        primeraPagina = "display:none !important";
    }
    public void terceraPagina(){
        setContinuaDos("display:none;");
        setContinuaTres("pointer-events: none;opacity: 0.5;");
        pregunta13.setClase("");
        pregunta13.setRespuesta("0");
        pregunta14.setClase("");
        pregunta14.setRespuesta("0");
        pregunta15.setClase("");
        pregunta15.setRespuesta("0");
        pregunta16.setClase("");
        pregunta16.setRespuesta("0");
        pregunta17.setClase("");
        pregunta17.setRespuesta("0");
        terceraPagina = "";
        segundaPagina = "display:none !important";
    }
    public void cuartaPagina(){
        setContinuaTres("display:none;");
        setContinuaCuatro("pointer-events: none;opacity: 0.5;");
        pregunta18.setClase("");
        pregunta18.setRespuesta("0");
        
        setCuartaPagina("");
        terceraPagina = "display:none !important";
    }
    public void quintaPagina(){
        setContinuaCuatro("display:none;");
        setFinaliza("pointer-events: none;opacity: 0.5;");
        pregunta19.setClase("");
        pregunta19.setRespuesta("0");
        
        setQuintaPagina("");
        setCuartaPagina("display:none !important");
    }
    public void finaliza(){
        
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
}
