

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

import com.ukalix.analiserup.controller.ParamConsulta;



public class TesteParamConsulta {
	@Rule
    public ExpectedException exception = ExpectedException.none();
	

	// Passa, se FileNotFoundException for lancada com esperado, Arquivo não existe 
    @Test (expected = FileNotFoundException.class) 
	public void deveRetornarFileNotFoundException() throws FileNotFoundException, IOException {
    	String PROPERTIES_FILE = "src/main/resources/EstruturaPastasXX.properties";
     	ParamConsulta.setPathfileProperties(PROPERTIES_FILE);      	
   		ParamConsulta.carregaFileProperties();
	}

//    // Passa no testes se a exception for lancada com um IOException
//    @Test (expected = IOException.class) 
//	public void deveriaRetornarIOException() throws FileNotFoundException, IOException, NullPointerException  {
//    	ParamConsulta.setPathfileProperties(null);
//    	ParamConsulta.carregaFileProperties();
//	}
    
    
    // Passa, se NullPointerException for lancada, path do arquivo properties null 
    @Test (expected = NullPointerException.class) 
	public void deveRetornarNullPointerException() throws IOException, NullPointerException {
    	ParamConsulta.setPathfileProperties(null);
  		ParamConsulta.carregaFileProperties();
	}
    
    
    // Passa, se retornar a estancia de ParamConsulta diferente de nullo
    @Test 
    public void deveRetornarEstanciaParamConsulta() throws FileNotFoundException, IOException, NullPointerException{
    	String PROPERTIES_FILE = "src/main/resources/EstruturaPastas.properties";
     	ParamConsulta.setPathfileProperties(PROPERTIES_FILE); 
    	assertNotNull(ParamConsulta.getInstance());
    }
}
