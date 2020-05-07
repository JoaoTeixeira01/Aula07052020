package com.md;

public class tools 
{
	public static class dataObject
	{
		private int mes;
		private int ano;
		
		public dataObject(String data)
		{
			if(data == null)
			{
				System.out.print("empty");
				throw new IllegalArgumentException();
			}
			else
			{
				//"07/2020"
				String[] mesAno = data.split("/");
				if(mesAno.length != 2)
				{
					throw new IllegalArgumentException();
				}
				else if(Integer.valueOf(mesAno[0]) == null || Integer.valueOf(mesAno[1]) == null)
				{
					throw new IllegalArgumentException();
				}
				else
				{
					this.mes = Integer.parseInt(mesAno[0]);
					this.ano = Integer.parseInt(mesAno[1]);
				}
			}
		}
		
		public int getMes()
		{
			return this.mes;
		}
		
		public int getAno()
		{
			return this.ano;
		}
	}
	
	public enum meses
	{
		JANEIRO(1), FEVEREIRO(2), MARCO(3), ABRIL(4), MAIO(5), 
		JUNHO(6), JULHO(7),AGOSTO(8), SETEMBRO(9), OUTUBRO(10),
		NOVEMBRO(11),DEZEMBRO(12);
		
		int nMes;
		meses(int mes)
		{
			nMes = mes;
		}
		public static String getNomeMes(int mes) throws ForaDeParametrosException 
		{
			int indice = mes - 1;
			
			if(indice < 0 || indice > 11)
			{
				throw new ForaDeParametrosException("Mês não válido");
			}
			meses[] ms = meses.values();
					
			return ms[indice].name();
		}
	}
	
	public static class NumeroDias
	{
		public static int devolveNumDias(int mes,int ano) throws ForaDeParametrosException
		{
			int numDiasMes;
			int[] meses31 = {1,3,5,7,8,10,12};
			int[] meses30 = {4,6,9,11};
			
			if(mesInArray(mes,meses31))
			{
				numDiasMes = 31;
			}
			else if(mesInArray(mes,meses30))
			{
				numDiasMes = 30;
			}
			else if(mes == 2 && bissexto(ano))
			{
				numDiasMes = 29;
			}
			else if(mes == 2 && !bissexto(ano))
			{
				numDiasMes = 28;
			}
			else
			{
				throw new ForaDeParametrosException("Mês não válido");
			}
			return numDiasMes;
		}
		
		public static boolean bissexto(int ano)
		{
			// ano divisivel por 4 -> bissexto
			// ano divisivel por 4 e por 100 -> ñ bissexto
			// ano divisivel por 4, 100 e 400 -> bissexto
			boolean anoDivisivel4 = divisivel(ano, 4);
			boolean anoDivisivel100 = divisivel(ano, 100);
			boolean anoDivisivel400 = divisivel(ano, 400);
			
			if(anoDivisivel4)
			{
				if(anoDivisivel100)
				{
					if(anoDivisivel400)
					{
						return true;
					}
					else
					{
						return false;
					}
				}
				else
				{
					return true;
				}
			}
			else
			{
				return false;
			}
		}
		
		private static boolean divisivel(int ano, int divisor)
		{
			int restoDivisaoInteira = ano % divisor;
			if(restoDivisaoInteira == 0)
			{
				return true;
			}
			return false;
		}
		
		private static boolean mesInArray(int mes, int[]arrayMeses)
		{
			for(int c=0; c<arrayMeses.length; c++)
			{
				if(mes == arrayMeses[c])
				{
					return true;
				}
			}
			return false;
		}
	}
	public static class ForaDeParametrosException extends Exception
	{
		ForaDeParametrosException(String mensagem)
		{
			super(mensagem);
		}
	}
}
