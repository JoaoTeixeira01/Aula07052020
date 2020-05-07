import java.util.Scanner;
import com.md.tools.*;

public class NumeroDiasNoMes 
{
	public static void main(String[] args) 
	{
		try
		{
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Introduza uma data no formato: 07/2020");
			
			String data = scanner.nextLine();
			
			dataObject dataObj = new dataObject(data);
			
			int numDias = NumeroDias.devolveNumDias(dataObj.getMes(), dataObj.getAno());
			
			String mes = meses.getNomeMes(dataObj.getMes());
			String ano = String.valueOf(dataObj.getAno());
			
			String mensagem= "O mês de " + mes + " do ano " + ano + " tem " + numDias + " dias.";
	
			System.out.println(mensagem);
		}
		catch(ForaDeParametrosException foraEx)
		{
			System.out.println(foraEx.getMessage());
		}
		catch(IllegalArgumentException illEx)
		{
			System.out.println("Argumento do tipo errado.");
		}
	}

}
