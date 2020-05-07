package com.md;

public class tools 
{
	public static class dataObject
	{
		private int mes;
		private int ano;
		
		public dataObject(String data)
		{
			//"07/2020"
			String[] mesAno = data.split("/");
			this.mes = Integer.parseInt(mesAno[0]);
			this.ano = Integer.parseInt(mesAno[1]);
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
	public static class NumeroDias
	{
		public int devolveNumDias(int mes,int ano)
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
				throw new IllegalArgumentException();
			}
			return numDiasMes;
		}
		
		private boolean bissexto(int ano)
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
		
		private boolean divisivel(int ano, int divisor)
		{
			int restoDivisaoInteira = ano % divisor;
			if(restoDivisaoInteira == 0)
			{
				return true;
			}
			return false;
		}
		
		private boolean mesInArray(int mes, int[]arrayMeses)
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
}
