package lps.database;

import java.util.ArrayList;
import java.util.List;

/*
 * Um pequeno banco de dados simples de features numa ArrayList comum
 */

public class Features {

	public String codigo;
	public String tipo;
	public String opcao;
	private List<Features> arrayFeatures;

	public Features(String codigo, String tipo, String opcao) {
		this.codigo = codigo;
		this.tipo = tipo; 
		this.opcao = opcao;	}

	private void iniciarBanco() {

		List<Features> arrayFeatures = new ArrayList<Features>();

		arrayFeatures.add(new Features("F001","Freios","Hidr�ulico"));
		arrayFeatures.add(new Features("F002","Freios","a Ar"));
		arrayFeatures.add(new Features("F003","Freios","Hidrov�cuo"));
		arrayFeatures.add(new Features("F004","Freios","ABS"));
		
		arrayFeatures.add(new Features("T001","Transmiss�o","Eaton FS 2305 C"));
		arrayFeatures.add(new Features("T002","Transmiss�o","Eaton FSO 4405 C"));
		arrayFeatures.add(new Features("T003","Transmiss�o","ZF S5420 HD"));
		arrayFeatures.add(new Features("T004","Transmiss�o","ZF 6S 1010 BO"));
		arrayFeatures.add(new Features("T006","Transmiss�o","Eaton FS 6406 B"));
		arrayFeatures.add(new Features("T007","Transmiss�o","Eaton FSB0 9406 AE"));
		
		arrayFeatures.add(new Features("D001","Dire��o","El�trica"));
		arrayFeatures.add(new Features("D002","Dire��o","Hidr�ulica"));
		
		arrayFeatures.add(new Features("A001","Adicionais de Cabine","Ar Condicionado"));
		arrayFeatures.add(new Features("A002","Adicionais de Cabine","Vidros El�tricos"));
		arrayFeatures.add(new Features("A003","Adicionais de Cabine","Travas El�tricas"));
		arrayFeatures.add(new Features("A004","Adicionais de Cabine","Alarme de seguran�a"));
		arrayFeatures.add(new Features("A005","Adicionais de Cabine","Sistema de som"));
		arrayFeatures.add(new Features("A006","Adicionais de Cabine","GPS"));
		
		arrayFeatures.add(new Features("K001","Carroceria","Ba� tradicional"));
		arrayFeatures.add(new Features("K002","Carroceria","Ba� frigorifico"));
		arrayFeatures.add(new Features("K003","Carroceria","Ca�amba comum"));
		arrayFeatures.add(new Features("K004","Carroceria","Ca�amba graneleira"));
		arrayFeatures.add(new Features("K005","Carroceria","Poliguindaste"));
		arrayFeatures.add(new Features("K006","Carroceria","Basculante"));
		arrayFeatures.add(new Features("K007","Carroceria","Transporte de gado"));
		arrayFeatures.add(new Features("K008","Carroceria","Transporte de madeira"));
		arrayFeatures.add(new Features("K009","Carroceria","Transporte canavieiro"));
		arrayFeatures.add(new Features("K010","Carroceria","Tanque Pipa"));
		arrayFeatures.add(new Features("K011","Carroceria","Coletor de lixo"));
		arrayFeatures.add(new Features("K012","Carroceria","Carreta Agricola"));
		arrayFeatures.add(new Features("K013","Carroceria","Furg�o Lonado"));
		arrayFeatures.add(new Features("K014","Carroceria","Cegonheira"));
		
		arrayFeatures.add(new Features("S001","Suspens�o","Met�lica"));
		arrayFeatures.add(new Features("S002","Suspens�o","a Ar"));

		this.arrayFeatures = arrayFeatures;

	}

	public String consultaBanco(String codigo) {

		iniciarBanco();
		int i;
		boolean eValido = false;
		Features checker = null;

		for (i = 0; i < arrayFeatures.size(); i++) {
			if (codigo.equals(arrayFeatures.get(i).codigo)) {
				checker = arrayFeatures.get(i);
				eValido = true;
			}
		}		
		
		if (eValido) return checker.toString();

		return "ERRO";
	}

	public ArrayList<Features> listarFeatures(String tipo) {

		iniciarBanco();
		int i;
		ArrayList<Features> checker = new ArrayList<Features>();

		for (i = 0; i < arrayFeatures.size(); i++) {
			if (tipo.equals(arrayFeatures.get(i).tipo)) {
				checker.add(arrayFeatures.get(i));
			}
		}
		return checker;
	}

	public String toString() {
		return codigo + ";" + tipo + ";" + opcao;
	}

}
