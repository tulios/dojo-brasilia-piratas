package br.dojobrasilia.pirata;

import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

public class TestePirata {

	@Test
	public void testExistePirata(){
		String[] args= {"2"};
		Loot loot = new Loot(args);
		Assert.assertNotNull(loot.qtdPirata);
	}
	
	@Test
	public void testIsPirataNumero(){
		String[] args= {"n"};
		Loot loot = new Loot(args);
		Assert.assertNull(loot.qtdPirata);			
		
	}
	
	@Test
	public void testExisteRubis(){
		String[] args= {"3", "2"};
		Loot loot = new Loot(args);
		
		Assert.assertNotNull(loot.listaDeTodosRubis);			
		
	}
	
	@Test
	public void testNumeroDeRubis(){
		String[] args= {"3", "2", "3", "32"};
		Loot loot = new Loot(args);
		
		Assert.assertEquals(3, loot.listaDeTodosRubis.size());
	}
	

	@Test
	public void testNaoConsegueDividir(){
		String[] args= {"3", "1"};
		Loot loot = new Loot(args);
		Assert.assertNull(loot.partilhaRubis());
	}

	@Test
	public void testConseguePartilhar(){
		String[] args= {"3", "1", "1", "1"};
		
		Loot loot = new Loot(args);
		Map<Integer, List<Integer>> m = loot.partilhaRubis();
		
		Assert.assertEquals(3 , m.size());
		
		Assert.assertEquals(1 , m.get(1).size());
		Assert.assertEquals(1 , m.get(1).get(0).intValue());
		
		Assert.assertEquals(1 , m.get(2).size());
		Assert.assertEquals(1 , m.get(2).get(0).intValue());
		
		Assert.assertEquals(1 , m.get(3).size());
		Assert.assertEquals(1 , m.get(3).get(0).intValue());
		
	}

	@Test
	public void testConseguePartilharOutrosValores(){
		String[] args= {"3", "2", "2", "2"};
		
		Loot loot = new Loot(args);
		Map<Integer, List<Integer>> m = loot.partilhaRubis();
		
		Assert.assertEquals(3 , m.size());
		
		Assert.assertEquals(1 , m.get(1).size());
		Assert.assertEquals(2 , m.get(1).get(0).intValue());
		
		Assert.assertEquals(1 , m.get(2).size());
		Assert.assertEquals(2 , m.get(2).get(0).intValue());
		
		Assert.assertEquals(1 , m.get(3).size());
		Assert.assertEquals(2 , m.get(3).get(0).intValue());
	}
	
	@Test
	public void testConseguePartilharMaisDeUmRuby(){
		String[] args= {"3", "1", "1", "1", "1", "1", "1"};
		
		Loot loot = new Loot(args);
		Map<Integer, List<Integer>> m = loot.partilhaRubis();
		
		Assert.assertEquals(3 , m.size());
		
		Assert.assertEquals(2 , m.get(1).size());
		Assert.assertEquals(1 , m.get(1).get(0).intValue());
		Assert.assertEquals(1 , m.get(1).get(1).intValue());
		
		Assert.assertEquals(2 , m.get(2).size());
		Assert.assertEquals(1 , m.get(2).get(0).intValue());
		Assert.assertEquals(1 , m.get(2).get(1).intValue());
		
		Assert.assertEquals(2 , m.get(3).size());
		Assert.assertEquals(1 , m.get(3).get(0).intValue());
		Assert.assertEquals(1 , m.get(3).get(1).intValue());
	}
	
	@Test
	public void testConseguePartilharMaisDeUmRubyComValoresDiferentes(){
		String[] args= {"3", "1", "2", "1", "2", "1", "2"};
		
		Loot loot = new Loot(args);
		Map<Integer, List<Integer>> m = loot.partilhaRubis();
		
		Assert.assertEquals(3 , m.size());
		
		Assert.assertEquals(2 , m.get(1).size());
		Assert.assertTrue(m.get(1).contains(1));
		Assert.assertTrue(m.get(1).contains(2));
		
		Assert.assertEquals(2 , m.get(2).size());
		Assert.assertTrue(m.get(2).contains(1));
		Assert.assertTrue(m.get(2).contains(2));
		
		Assert.assertEquals(2 , m.get(3).size());
		Assert.assertTrue(m.get(3).contains(1));
		Assert.assertTrue(m.get(3).contains(2));
	}
	
	@Test
	public void testConseguePartilharMaisDeUmRubyComValoresDiferentesForaDeOrdem(){
		String[] args= {"2", "1", "1", "2", "2"};
		
		Loot loot = new Loot(args);
		Map<Integer, List<Integer>> m = loot.partilhaRubis();
		
		Assert.assertEquals(2 , m.size());
		
		Assert.assertEquals(2 , m.get(1).size());
		Assert.assertTrue(m.get(1).contains(1));
		Assert.assertTrue(m.get(1).contains(2));
		
		Assert.assertEquals(2 , m.get(2).size());
		Assert.assertTrue(m.get(2).contains(1));
		Assert.assertTrue(m.get(2).contains(2));
	}
	
	@Test
	public void testConseguePartilharMaisDeUmRubyComValoresDiferentesForaDeOrdemMesmo(){
		String[] args= {"2", "1", "2", "1", "2"};
		
		Loot loot = new Loot(args);
		Map<Integer, List<Integer>> m = loot.partilhaRubis();
		
		Assert.assertEquals(2 , m.size());
		
		Assert.assertEquals(2 , m.get(1).size());
		Assert.assertTrue(m.get(1).contains(1));
		Assert.assertTrue(m.get(1).contains(2));
		
		Assert.assertEquals(2 , m.get(2).size());
		Assert.assertTrue(m.get(2).contains(1));
		Assert.assertTrue(m.get(2).contains(2));
	}
	
	@Test
	public void testConseguePartilharUmCasoMenosEstupido(){
		String[] args= {"2", "1", "1", "2"};
		
		Loot loot = new Loot(args);
		Map<Integer, List<Integer>> m = loot.partilhaRubis();
		
		Assert.assertEquals(2 , m.size());
		
		Assert.assertEquals(1 , m.get(1).size());
		Assert.assertTrue(m.get(1).contains(2));
		
		Assert.assertEquals(2 , m.get(2).size());
		Assert.assertEquals(1, m.get(2).get(0).intValue());
		Assert.assertEquals(1, m.get(2).get(1).intValue());
	}
	
	@Test
	public void testConseguePartilharUmCasoSerio(){
		String[] args= {"2", "3", "5", "8", "2", "2"};
		
		Loot loot = new Loot(args);
		Map<Integer, List<Integer>> m = loot.partilhaRubis();
		
		Assert.assertEquals(2 , m.size());
		
		Assert.assertEquals(2 , m.get(1).size());
		Assert.assertTrue(m.get(1).contains(8));
		Assert.assertTrue(m.get(1).contains(2));
		
		Assert.assertEquals(3 , m.get(2).size());
		Assert.assertTrue(m.get(2).contains(5));
		Assert.assertTrue(m.get(2).contains(3));
		Assert.assertTrue(m.get(2).contains(2));
	}
	
	/*@Test
	public void testConseguePartilharUmCasoSite(){
		String[] args= {"2", "9", "12", "14", "17", "23", "32", "34", "40", "42", "49"};
		
		Loot loot = new Loot(args);
		Map<Integer, List<Integer>> m = loot.partilhaRubis();
		
		Assert.assertEquals(2 , m.size());
		
		Assert.assertEquals(5 , m.get(1).size());
		Assert.assertTrue(m.get(1).contains(9));
		Assert.assertTrue(m.get(1).contains(12));
		Assert.assertTrue(m.get(1).contains(32));
		Assert.assertTrue(m.get(1).contains(34));
		Assert.assertTrue(m.get(1).contains(49));
		
		Assert.assertEquals(5 , m.get(2).size());
		Assert.assertTrue(m.get(2).contains(14));
		Assert.assertTrue(m.get(2).contains(17));
		Assert.assertTrue(m.get(2).contains(23));
		Assert.assertTrue(m.get(2).contains(40));
		Assert.assertTrue(m.get(2).contains(42));
	}*/
	
	@Test
	public void testConseguePartilharUmCasoTenso(){
		String[] args= {"2", "5", "4", "3", "2", "2", "2", "2"};
		
		Loot loot = new Loot(args);
		Map<Integer, List<Integer>> m = loot.partilhaRubis();
		
		Assert.assertEquals(2 , m.size());
		
		Assert.assertEquals(m.get(1).toString(), 3 , m.get(1).size());
		Assert.assertTrue(m.get(1).contains(5));
		Assert.assertTrue(m.get(1).contains(3));
		Assert.assertTrue(m.get(1).contains(2));
		
		Assert.assertEquals(m.get(2).toString(), 4 , m.get(2).size());
		Assert.assertTrue(m.get(2).contains(4));
		Assert.assertTrue(m.get(2).contains(2));
		m.get(2).remove(1);
		Assert.assertTrue(m.get(2).contains(2));
		m.get(2).remove(1);
		Assert.assertTrue(m.get(2).contains(2));
		m.get(2).remove(1);
	}
	
}
















