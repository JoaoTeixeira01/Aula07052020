package com.md;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.md.tools.*;

class toolsTest 
{
	@Test
	void dataObjectTest() 
	{
		//null
		assertThrows(IllegalArgumentException.class, ()->{new dataObject(null);},"O tipo de erro devolvido não foi o esperado. "
				+ "IllegalArgumentException");
		//""
		assertThrows(IllegalArgumentException.class, ()->{new dataObject("");},"O tipo de erro devolvido não foi o esperado. "
				+ "IllegalArgumentException");
		//1t/2020
		assertThrows(IllegalArgumentException.class, ()->{new dataObject("1t/2020");},"O tipo de erro devolvido não foi o esperado. "
				+ "IllegalArgumentException");
		//kdsfjk
		assertThrows(IllegalArgumentException.class, ()->{new dataObject("kdsfjk");},"O tipo de erro devolvido não foi o esperado. "
				+ "IllegalArgumentException");
		dataObject data = new dataObject("07/2020");
		
		assertEquals(7,data.getMes(), "Falhou a obtenção do mês correcto");
		assertEquals(2020,data.getAno());
	}
	@Test
	void mesesBoundariesTest()
	{
		assertThrows(ForaDeParametrosException.class, ()->{meses.getNomeMes(0);},"Devolveu tipo de erro errado");
		assertThrows(ForaDeParametrosException.class, ()->{meses.getNomeMes(13);},"Devolveu tipo de erro errado");
	}
	
	@ParameterizedTest
	@CsvSource({"1,JANEIRO", "2,FEVEREIRO", "3,MARCO", "4,ABRIL", "5,MAIO", "6,JUNHO", "7,JULHO",
			"8,AGOSTO", "9,SETEMBRO", "10,OUTUBRO", "11,NOVEMBRO", "12,DEZEMBRO"})
	void mesesBoundariesTest(int nMes,String resultadoEsperado) throws ForaDeParametrosException
	{
		assertEquals(resultadoEsperado,meses.getNomeMes(nMes), "Mês não corresponde");		
	}
	
	@Test
	void NumeroDias_DevolveNumDiasTest()
	{
		assertThrows(ForaDeParametrosException.class,()->{ NumeroDias.devolveNumDias(-1, 2020);}, "Devolveu o erro errado");
		assertThrows(ForaDeParametrosException.class,()->{ NumeroDias.devolveNumDias(13, 2020);}, "Devolveu o erro errado");
	}
	@ParameterizedTest
	@CsvSource({"1,31","3,31","4,30","5,31", "6,30", "7,31", "8,31", "9,30", "10,31", "11,30", "12,31"})
	void NumeroDias_DevolveNumDiasTest(int nMes, int resultadoEsperado) throws ForaDeParametrosException
	{
		assertEquals(resultadoEsperado, NumeroDias.devolveNumDias(nMes, 2020));
	}
	@Test 
	void NumeroDias_DevolveNumDiasTest_Fevereiro() throws ForaDeParametrosException
	{
		assertEquals(28,NumeroDias.devolveNumDias(2, 2019));
		assertEquals(29,NumeroDias.devolveNumDias(2, 2020));
	}
	@Test
	void bissextoTest_naoBissextos()
	{
		//2019 não é divisível por 4
		boolean resultado = NumeroDias.bissexto(2019); 
		assertFalse(resultado);
	}
	@Test
	void bissextoTest_naoBissextosDivisiveis100()
	{
		//divisiveis por 4 e por 100, mas não por 400
		boolean resultado = NumeroDias.bissexto(1900); 
		assertFalse(resultado);
	}
	@Test
	void bissexto_Divisiveis400Test()
	{
		//divisivel por 4, divisivel por 100 e divisivel por 400 
		boolean resultado = NumeroDias.bissexto(2000); 
		assertTrue(resultado);
	}
	@Test
	void bissexto_divisiveis4test()
	{
		//divisivel por 4, mas não por 100
		boolean resultado = NumeroDias.bissexto(2004); 
		assertTrue(resultado);
	}

}
