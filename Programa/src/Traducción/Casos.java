package Traducción;

public class Casos {

	// son las ecuaciones de cada uno de los 22 casos diferentes de circuitos de 4 resistencias
	public static float Resistencia(){
		float resistencia_total = 0;
		
		if (Menu_de_resistencias.ecuacion.equals("[1,2,3,4]")) {
			resistencia_total = Introduccion_de_datos.valor_de_resistencia_1 + Introduccion_de_datos.valor_de_resistencia_2 + Introduccion_de_datos.valor_de_resistencia_3 + Introduccion_de_datos.valor_de_resistencia_4;
			
		}

		else if (Menu_de_resistencias.ecuacion.equals("[(1,2),3,4]")) {
			resistencia_total = (1/((1/Introduccion_de_datos.valor_de_resistencia_1) + (1/Introduccion_de_datos.valor_de_resistencia_2))) + Introduccion_de_datos.valor_de_resistencia_3 + Introduccion_de_datos.valor_de_resistencia_4;
			
		}

		else if (Menu_de_resistencias.ecuacion.equals("[1,(2,3),4]")) {
			resistencia_total = Introduccion_de_datos.valor_de_resistencia_1 + (1/((1/Introduccion_de_datos.valor_de_resistencia_2) + (1/Introduccion_de_datos.valor_de_resistencia_3)))  + Introduccion_de_datos.valor_de_resistencia_4;
			
		}

		else if (Menu_de_resistencias.ecuacion.equals("[1,2,(3,4)]")) {
			resistencia_total = Introduccion_de_datos.valor_de_resistencia_1 + Introduccion_de_datos.valor_de_resistencia_2 + (1/((1/Introduccion_de_datos.valor_de_resistencia_3) + (1/Introduccion_de_datos.valor_de_resistencia_4)));
			
		}

		else if (Menu_de_resistencias.ecuacion.equals("[(1,2,3),4]")) {
			resistencia_total = (1/((1/Introduccion_de_datos.valor_de_resistencia_1) + (1/Introduccion_de_datos.valor_de_resistencia_2) + (1/Introduccion_de_datos.valor_de_resistencia_3)))  + Introduccion_de_datos.valor_de_resistencia_4;
			
		}

		else if (Menu_de_resistencias.ecuacion.equals("[1,(2,3,4)]")) {	
			resistencia_total =  Introduccion_de_datos.valor_de_resistencia_1 + (1/((1/ Introduccion_de_datos.valor_de_resistencia_2) + (1/ Introduccion_de_datos.valor_de_resistencia_3) + (1/ Introduccion_de_datos.valor_de_resistencia_4)));
			
		}

		else if (Menu_de_resistencias.ecuacion.equals("(1,2,3,4)")) {
			resistencia_total =  (1/((1/Introduccion_de_datos.valor_de_resistencia_1) + (1/Introduccion_de_datos.valor_de_resistencia_2) + (1/Introduccion_de_datos.valor_de_resistencia_3) + (1/Introduccion_de_datos.valor_de_resistencia_4)));
			
		}

		else if (Menu_de_resistencias.ecuacion.equals("[(1,2),(3,4)]")) {
			resistencia_total = (1/((1/Introduccion_de_datos.valor_de_resistencia_1) + (1/Introduccion_de_datos.valor_de_resistencia_2))) + (1/((1/Introduccion_de_datos.valor_de_resistencia_3) + (1/Introduccion_de_datos.valor_de_resistencia_4)));
			
		}

		else if (Menu_de_resistencias.ecuacion.equals("([1,2],[3,4])")) {
			resistencia_total = (1/((1/(Introduccion_de_datos.valor_de_resistencia_1 + Introduccion_de_datos.valor_de_resistencia_2)) + (1/(Introduccion_de_datos.valor_de_resistencia_3 + Introduccion_de_datos.valor_de_resistencia_4))));
			
		}

		else if (Menu_de_resistencias.ecuacion.equals("([1,2,3],4)")) {
			resistencia_total = (1/((1/(Introduccion_de_datos.valor_de_resistencia_1 + Introduccion_de_datos.valor_de_resistencia_2 + Introduccion_de_datos.valor_de_resistencia_3)) + (1/Introduccion_de_datos.valor_de_resistencia_4)));
			
		}

		else if (Menu_de_resistencias.ecuacion.equals("(1,[2,3,4])")) {
			resistencia_total = (1/((1/Introduccion_de_datos.valor_de_resistencia_1) + (1/(Introduccion_de_datos.valor_de_resistencia_2 + Introduccion_de_datos.valor_de_resistencia_3 + Introduccion_de_datos.valor_de_resistencia_4))));
			
		}

		else if (Menu_de_resistencias.ecuacion.equals("([(1,2),3],4)")) {
			resistencia_total = (1/(1/((1/((1/Introduccion_de_datos.valor_de_resistencia_1) + (1/Introduccion_de_datos.valor_de_resistencia_2))) + Introduccion_de_datos.valor_de_resistencia_3) + (1/Introduccion_de_datos.valor_de_resistencia_4)));
			
		}

		else if (Menu_de_resistencias.ecuacion.equals("([1,(2,3)],4)")) {
			resistencia_total = (1/((1/((Introduccion_de_datos.valor_de_resistencia_1) + (1/((1/Introduccion_de_datos.valor_de_resistencia_2) + (1/Introduccion_de_datos.valor_de_resistencia_3))))) + (1/Introduccion_de_datos.valor_de_resistencia_4)));
			
		}

		else if (Menu_de_resistencias.ecuacion.equals("(1,[(2,3),4])")) {
			resistencia_total = (1/((1/Introduccion_de_datos.valor_de_resistencia_1) + (1/((1/((1/Introduccion_de_datos.valor_de_resistencia_2) + (1/Introduccion_de_datos.valor_de_resistencia_3))) + Introduccion_de_datos.valor_de_resistencia_4))));
			
		}

		else if (Menu_de_resistencias.ecuacion.equals("(1,[2,(3,4)])")) {
			resistencia_total = (1/((1/Introduccion_de_datos.valor_de_resistencia_1) + (1/((Introduccion_de_datos.valor_de_resistencia_2 + (1/((1/Introduccion_de_datos.valor_de_resistencia_3) + (Introduccion_de_datos.valor_de_resistencia_4))))))));
			
		}

		else if (Menu_de_resistencias.ecuacion.equals("(1,[2,3],4)")) {
			resistencia_total = (1/((1/Introduccion_de_datos.valor_de_resistencia_1) + (1/(Introduccion_de_datos.valor_de_resistencia_2 + Introduccion_de_datos.valor_de_resistencia_3)) + (1/Introduccion_de_datos.valor_de_resistencia_4)));
			
		}

		else if (Menu_de_resistencias.ecuacion.equals("([1,2],3,4)")) {
			resistencia_total = (1/((1/(Introduccion_de_datos.valor_de_resistencia_1 + Introduccion_de_datos.valor_de_resistencia_2)) + (1/Introduccion_de_datos.valor_de_resistencia_3) + (1/Introduccion_de_datos.valor_de_resistencia_4)));
			
		}

		else if (Menu_de_resistencias.ecuacion.equals("(1,2,[3,4])")) {
			resistencia_total = (1/((1/Introduccion_de_datos.valor_de_resistencia_1) + (1/Introduccion_de_datos.valor_de_resistencia_2)  + (1/(Introduccion_de_datos.valor_de_resistencia_3 + Introduccion_de_datos.valor_de_resistencia_4))));
			
		}

		else if (Menu_de_resistencias.ecuacion.equals("[([1,2],3),4]")) {
			resistencia_total = (1/((1/(Introduccion_de_datos.valor_de_resistencia_1 + Introduccion_de_datos.valor_de_resistencia_2)) + (1/Introduccion_de_datos.valor_de_resistencia_3))) + Introduccion_de_datos.valor_de_resistencia_4;
			
		}

		else if (Menu_de_resistencias.ecuacion.equals("[(1,[2,3]),4]")) {
			resistencia_total = (1/((1/Introduccion_de_datos.valor_de_resistencia_1) + (1/(Introduccion_de_datos.valor_de_resistencia_2 + Introduccion_de_datos.valor_de_resistencia_3)))) + Introduccion_de_datos.valor_de_resistencia_4;
			
		}

		else if (Menu_de_resistencias.ecuacion.equals("[1,(2,[3,4])]")) {
			resistencia_total = Introduccion_de_datos.valor_de_resistencia_1 + (1/((1/Introduccion_de_datos.valor_de_resistencia_2) + (1/(Introduccion_de_datos.valor_de_resistencia_3 + Introduccion_de_datos.valor_de_resistencia_4))));
			
		}

		else if (Menu_de_resistencias.ecuacion.equals("[1,([2,3],4)]")) {
			resistencia_total = Introduccion_de_datos.valor_de_resistencia_1 + (1/((1/(Introduccion_de_datos.valor_de_resistencia_2 + Introduccion_de_datos.valor_de_resistencia_3)) + (1/Introduccion_de_datos.valor_de_resistencia_4)));
			
		}
		return resistencia_total;
	}

}
