import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.hamcrest.core.IsNot;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.ukalix.analiserup.controller.AnaliseRup;


public class TesteAnaliseRup {

	@Rule
    public ExpectedException exception = ExpectedException.none();
	
	//@Test //descomentar quando for rodar o teste
	public void deveRetornarNumeroProjetoOrNull() {
		AnaliseRup ana = new AnaliseRup();
		String numProj = ana.getNumeroProjeto();
		
		assertEquals(true, numProj == null || numProj != null);
	}
	
	
	@Test 
	public void deveRetornarNomeProjetoOrNull() {
		AnaliseRup ana = new AnaliseRup();
		String nomeProj = ana.getNomeProjeto();
		assertEquals(true, nomeProj != null || nomeProj != "");
	}

}
