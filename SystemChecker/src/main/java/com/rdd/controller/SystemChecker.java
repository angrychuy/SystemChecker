/**
 * 
 */
package com.rdd.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.rdd.engine.SiteChecker;
import com.rdd.model.Site;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@SuppressWarnings("serial")
@Named
@SessionScoped
public class SystemChecker implements Serializable {
	
	private final static String CHEERDDEXT = "http://rddpacs.grupoimagenradiologica.com:8080/dcm4chee-web3";
	private final static String CHEETKTEXT = "http://iddtpacs.grupoimagenradiologica.com:8080/dcm4chee-web3";
	private final static String CHEEMXLEXT = "http://iddpacs.grupoimagenradiologica.com:8080/dcm4chee-web3";
	
	private final static String JASPRDDEXT = "http://rddpacs.grupoimagenradiologica.com:8181/rddreportes";
	private final static String JASPTKTEXT = "http://iddtpacs.grupoimagenradiologica.com:8181/iddtreportes";
	private final static String JASPMXLEXT = "http://iddpacs.grupoimagenradiologica.com:8181/iddreportes";
	
	private final static String CHEERDDNAM = "Rdd chee";
	private final static String JASPRDDNAM = "Rdd jasper reportes";
	private final static String CHEETKTNAM = "Idd tecate chee";
	private final static String JASPTKTNAM = "Idd tecate jasper reportes";
	private final static String CHEEMXLNAM = "Idd mexicali chee";
	private final static String JASPMXLNAM = "idd mexicali jasper reportes";
	
	@Inject
	private SiteChecker checker;
	
	private List<Site> model;
	
	private int progress;
	
	public int getProgress() {
		return progress;
	}
	
	public void setProgress(int progress) {
		this.progress = progress;
	}
	
	public List<Site> getModel() {
		return model;
	}
	
	public void setModel(List<Site> model) {
		this.model = model;
	}
	
	private int increment(int value, int step){
		int newValue = 0;
		newValue = value + step;
		return newValue;
	}
	
	public void handleComplete(){
		final FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.addMessage(null, new FacesMessage("La busqueda a termiando"));
		this.progress = 0;
	}
	
	public void scan(ActionEvent e){
		
		int oldValue = 0;
		this.progress = oldValue;
		Site site = new Site();
		this.model = new ArrayList<Site>();
		
		//Scan tijuana chee
		site.setUrl(CHEERDDEXT);
		site.setName(CHEERDDNAM);
		checker.checkSite(site);
		model.add(site);
		
		oldValue = this.progress;
		this.progress = increment(oldValue, 16);
		
		//Scan tecate  chee
		site = new Site();
		site.setUrl(CHEETKTEXT);
		site.setName(CHEETKTNAM);
		checker.checkSite(site);
		model.add(site);
		
		oldValue = this.progress;
		this.progress = increment(oldValue, 16);
		
		//Scan mexicali chee
		site = new Site();
		site.setUrl(CHEEMXLEXT);
		site.setName(CHEEMXLNAM);
		checker.checkSite(site);
		model.add(site);
		
		oldValue = this.progress;
		this.progress = increment(oldValue, 16);
		
		//Scan tijuana jasper
		site = new Site();
		site.setUrl(JASPRDDEXT);
		site.setName(JASPRDDNAM);
		checker.checkSite(site);
		model.add(site);
		
		oldValue = this.progress;
		this.progress = increment(oldValue, 16);
		
		//Scan tecate jasper
		site = new Site();
		site.setUrl(JASPTKTEXT);
		site.setName(JASPTKTNAM);
		checker.checkSite(site);
		model.add(site);
		
		oldValue = this.progress;
		this.progress = increment(oldValue, 16);
		
		//Scan mexicali internal jasper
		site = new Site();
		site.setUrl(JASPMXLEXT);
		site.setName(JASPMXLNAM);
		checker.checkSite(site);
		model.add(site);
		
		oldValue = this.progress;
		this.progress = increment(oldValue, 20);
	}

}
