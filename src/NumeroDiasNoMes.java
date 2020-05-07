import java.util.Scanner;
import com.md.tools.*;

public class NumeroDiasNoMes 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Introduza uma data no formato: 07/2020");
		
		String data = scanner.nextLine();
		
		dataObject dataObj = new dataObject(data);

	}

}
