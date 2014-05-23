package br.com.caelum.vraptor.blank;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Resource;

@Resource
public class Mundo {
	
	public String boasVindas() {
		return "Olá mundo!";
	}
	
	public List<String> paises(){
		List<String> result = new ArrayList<String>();
		result.add("Brasil");
		result.add("Portugal");
		result.add("Japão");
		result.add("Canadá");
		result.add("Paraguai");
		
		return result;
	}
	
	public List<Integer> numero(){
		List<Integer> num = new ArrayList<Integer>();
		
		for (int j = 0; j < 5; j++) {
			int numero = j;
			num.add(numero);
		}
		
		return num;
	}

}
