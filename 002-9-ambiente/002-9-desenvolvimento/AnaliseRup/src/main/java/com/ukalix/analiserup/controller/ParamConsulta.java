package com.ukalix.analiserup.controller;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/* Singleton - Essa classe acessa os parametros da consulta
 * 
 */

public class ParamConsulta{

   private static String PROPERTIES_FILE = null; // "src/main/resources/EstruturaPastas.properties";
   private static ParamConsulta instance = null;
   private static FileInputStream file = null;
   private static Properties props = null;

   
   private ParamConsulta() throws FileNotFoundException, IOException {
	  
	   carregaFileProperties();
   }


public static void carregaFileProperties() throws FileNotFoundException, IOException, NullPointerException {
	
	props = new Properties();
	file = null;
	 
	 try {
		 
	   	 file = new FileInputStream(getPathfileProperties());
	   	
	   	 if(file != null)
		 props.load(file);
		 
		 
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		throw e;
		
	} catch (IOException e) {
		e.printStackTrace();
		throw e;
		
	} catch (NullPointerException e){
		e.printStackTrace();
		throw e;
	}
	 
	 
}
   

   public static synchronized ParamConsulta getInstance() throws FileNotFoundException, IOException{
       if (instance == null)
           instance = new ParamConsulta();
           return instance;
   }

   
   public String getValue(String propKey){
       return this.props.getProperty(propKey);
   }
   
   public static synchronized ParamConsulta reset() throws FileNotFoundException, IOException {
	   return instance = new ParamConsulta();
	}
   
   public static void setPathfileProperties(String path){
	   PROPERTIES_FILE = path;
   }
   
   public static String getPathfileProperties (){
	   return PROPERTIES_FILE;
   }
}

