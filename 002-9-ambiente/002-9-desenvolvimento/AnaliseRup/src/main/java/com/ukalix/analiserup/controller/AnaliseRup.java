package com.ukalix.analiserup.controller;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class AnaliseRup {

	/*Path do arquivo de propriedades, que armazena a estrutura de pastas do RUP */
	private static String path ="src/main/resources/EstruturaPastas.properties";
	private static File diretorio;
	private static String caminho;
	private static String pastaRaiz;
	private static String nomeProj;
	private static String numProj;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		File dirProj; 
		String nomePastaProj;
		String nomePastaModNeg1; 
		String nomePastaReq2;
		String nomePastaAnaProj3;
		String nomePastaImple4;
		String nomePastaTest5;
		String nomePastaImplan6;
		String nomePastaGerenConfMud7;
		String nomePastaGerenProj8;
		String nomePastaAmb9;
		ParamConsulta paramConsulta = null; //ParamConsulta.getInstance();
		 
		ParamConsulta.setPathfileProperties(path);       
		paramConsulta = ParamConsulta.getInstance();
		 
		//ParamConsulta.getInstance();
		   
		  JFileChooser chooser = selecionaPastaCriarProjeto();
		    		    		    
		//numProj= JOptionPane.showInputDialog("Informe o numero do projeto :");
		//nomeProj= JOptionPane.showInputDialog("Informe o nome do projeto : ");

		  numProj = getNumeroProjeto(); //Input Numero do projeto 
		  nomeProj= getNomeProjeto(); //Input Nome do projeto
	     
	     nomePastaProj = "\\"+numProj+"-"+nomeProj;
	     pastaRaiz = chooser.getSelectedFile().toString();	     
	     nomePastaProj = chooser.getSelectedFile().toString().concat(nomePastaProj);
	     
        if(!validaDiretorioExiste(nomePastaProj)){
	     
   	        nomePastaModNeg1 = paramConsulta.getValue("nome.PastaModNeg1");
   	        nomePastaReq2 = paramConsulta.getValue("nome.PastaReq2");
            nomePastaAnaProj3 =paramConsulta.getValue("nome.PastaAnaProj3");
            nomePastaImple4 = paramConsulta.getValue("nome.PastaImple4");
            nomePastaTest5 = paramConsulta.getValue("nome.PastaTest5");
            nomePastaImplan6 = paramConsulta.getValue("nome.PastaImplan6");
            nomePastaGerenConfMud7 = paramConsulta.getValue("nome.PastaGerenConfMud7");
            nomePastaGerenProj8 = paramConsulta.getValue("nome.PastaGerenProj8");
            nomePastaAmb9 = paramConsulta.getValue("nome.PastaAmb9");

//	     nomePastaModNeg1 = "-1-modelagem_de_negocios";
//	     nomePastaReq2 = "-2-requisitos";
//         nomePastaAnaProj3 ="-3-analise_e_projeto";
//         nomePastaImple4 = "-4-implementacao";
//         nomePastaTest5 = "-5-teste";
//         nomePastaImplan6 = "-6-implantacao";
//         nomePastaGerenConfMud7 = "-7-gerenciamento_de_configuracao_e_mudanca";
//         nomePastaGerenProj8 = "-8-gerenciamento_de_projeto";
//         nomePastaAmb9 = "-9-ambiente";

	     System.err.println(nomePastaProj);
	     
		 try {
			 
			 //seleciona o caminho do diretorio atual
			 JFileChooser arquivo = new JFileChooser();  
			 arquivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);  
			 
	            //cria pasta de projeto 
			    //dirProj = new File(chooser.getSelectedFile() + nomePastaProj);
			    dirProj = new File(nomePastaProj);
	            boolean success = dirProj.mkdir();
	            	                    
	            if (success) {
	            	System.out.println("Pasta de projeto : "+ dirProj +" Criado com sucesso!");
	            	
		            criaPastasDisciplinasRUP(dirProj, numProj, nomePastaProj,
							nomePastaModNeg1, nomePastaReq2, nomePastaAnaProj3,
							nomePastaImple4, nomePastaTest5, nomePastaImplan6,
							nomePastaGerenConfMud7, nomePastaGerenProj8,
							nomePastaAmb9, chooser);
	            }


	            
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, "Erro ao criar o diretorio");
	            System.out.println(ex);
	        }
		 
        }else{
        	
            JOptionPane.showMessageDialog(null, "Diretorio nessa pasta: " + pastaRaiz + numProj + "-" + nomeProj + " já existe, tente outro nome");
            
           //retornando ao metodo main
            String[] vetor = {};
            main(vetor);

        }
	}



	public static boolean validaDiretorioExiste(String caminho) {
		diretorio = new File(caminho);
	         if (diretorio.exists()){
	             return true;
	         }else{
	             return false;
	         }
	}



	public static JFileChooser selecionaPastaCriarProjeto() {
		JFileChooser chooser = new JFileChooser();
		    chooser.setCurrentDirectory(new java.io.File("C:\\"));
		    chooser.setDialogTitle("choosertitle");
		    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		    chooser.setAcceptAllFileFilterUsed(false);

		    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		      System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
		      System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
		        
		    } else {  
		       System.out.println("No Selection ");
		       System.exit(1);
		      
		    }
		    
		return chooser;
	}

	
	
	private static void criaPastasDisciplinasRUP(File dirProj, String numProj,
			String nomePastaProj, String nomePastaModNeg1,
			String nomePastaReq2, String nomePastaAnaProj3,
			String nomePastaImple4, String nomePastaTest5,
			String nomePastaImplan6, String nomePastaGerenConfMud7,
			String nomePastaGerenProj8, String nomePastaAmb9,
			JFileChooser chooser) {
		

		//------criando PASTA de modelagem de negocio
				dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaModNeg1);
				dirProj.mkdir();
				
				    //criando SUBPASTAS da modelagem de negocio
				    dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaModNeg1 +"\\"+ numProj + "-1-business_case");
				    dirProj.mkdir();
				    dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaModNeg1 +"\\"+ numProj +"-1-de");
				    dirProj.mkdir();
				//------
				dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaReq2);
				dirProj.mkdir();
				dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaReq2 +"\\"+ numProj +"-2-documentos_fonte");
				dirProj.mkdir();
				dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaReq2 +"\\"+ numProj +"-2-gerencia_requisitos");
				dirProj.mkdir();
				dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaReq2 +"\\"+ numProj +"-2-prototipos");
				//------
				dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaAnaProj3);
				dirProj.mkdir();
					dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaAnaProj3     +"\\"+ numProj +"-3-projeto");
					dirProj.mkdir();
						dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaAnaProj3 +"\\"+ numProj +"-3-projeto"+ "\\" + numProj +"-3-casos_de_uso");
						dirProj.mkdir();
						System.out.println(dirProj);
						dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaAnaProj3 +"\\"+ numProj +"-3-projeto"+ "\\" + numProj +"-3-prototipos");
						System.out.println(dirProj);
						dirProj.mkdir();
						dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaAnaProj3 +"\\"+ numProj +"-3-analise");
						dirProj.mkdir();
						dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaAnaProj3 +"\\"+ numProj + "-3-analise"+ "\\" + numProj +"-3-mapa_de_contexto");
						System.out.println(dirProj);
						dirProj.mkdir();
				//------
				dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaImple4);
				dirProj.mkdir();
				dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaImple4 +"\\"+ numProj +"-4-apps");
				dirProj.mkdir();
				dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaImple4 +"\\"+ numProj +"-4-dist");
				dirProj.mkdir();
				//------
				dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaTest5);
				dirProj.mkdir();
				//------
				dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaImplan6);
				dirProj.mkdir();
				dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaImplan6 +"\\"+ numProj +"-6-diagramas");
				dirProj.mkdir();
				dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaImplan6 +"\\"+ numProj +"-6-hardware");
				dirProj.mkdir();
				//------
				dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaGerenConfMud7);
				dirProj.mkdir();
				dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaGerenConfMud7 +"\\"+ numProj +"-7-bd");
				dirProj.mkdir();
				dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaGerenConfMud7 +"\\"+ numProj +"-7-cadastros_necessarios");
				dirProj.mkdir();
				dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaGerenConfMud7 +"\\"+ numProj +"-7-configuracoes");
				dirProj.mkdir();
				dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaGerenConfMud7 +"\\"+ numProj +"-7-manutencao");
				dirProj.mkdir();
				//------
				dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaGerenProj8);
				dirProj.mkdir();
				dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaGerenProj8 +"\\"+ numProj +"-8-apresentacao");
				dirProj.mkdir();
				dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaGerenProj8 +"\\"+ numProj +"-8-atas_de_reuniao");
				dirProj.mkdir();
				dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaGerenProj8 +"\\"+ numProj +"-8-cronograma");
				dirProj.mkdir();
				//------
				dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaAmb9);
				dirProj.mkdir();
				dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaAmb9 +"\\"+ numProj +"-9-acessos_ambiente");
				dirProj.mkdir();
				dirProj = new File(nomePastaProj + "\\" + numProj + nomePastaAmb9 +"\\"+ numProj +"-9-diagramas");
				dirProj.mkdir();
	}



	public ParamConsulta validaFileProperties() throws IOException {

        ParamConsulta paramConsulta = null;   
		ParamConsulta.setPathfileProperties(path);
		paramConsulta = ParamConsulta.getInstance();
		return paramConsulta;	
		
		
	}



	public static String getNumeroProjeto() {
	
		numProj= JOptionPane.showInputDialog("Informe o numero do projeto :");
			
		if(numProj != null && numProj != ""){
			if(!matchesOnlyText(numProj)) {
			    JOptionPane.showMessageDialog(null, "Insira um numero para o projeto.");
			    getNumeroProjeto();
			}
		}
		return numProj;
	}
	
	
	
	public static String getNomeProjeto() {
 
		nomeProj= JOptionPane.showInputDialog("Informe o nome do projeto :");
	
		if(nomeProj == null){
			 System.exit(1);
			  
		}else if (nomeProj.equals("")){
			  JOptionPane.showMessageDialog(null, "Insira um nome para o projeto.");
	          getNomeProjeto();
		}
		
		return nomeProj;

	}
	
	
	public static boolean matchesOnlyText(String text) {
	    return text.matches("[0-9]+"); //somente numero de 0 a 9 
	}
}
