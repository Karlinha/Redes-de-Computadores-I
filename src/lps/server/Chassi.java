package lps.server;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import lps.database.Features;
import lps.database.Produtos;

import org.json.simple.JSONValue;

/*
 Aqui � a classe que define um chassi (um produto).
 Tal projeto foi inicialmente apresentado na disciplina de Linhas de Produtos de Software, ministrada pelo Prof. Arturo Hernandez:
 Para maiores detalhes sobre este projeto, acesse o relat�rio completo atrav�s do link abaixo: 
 https://drive.google.com/file/d/0B1dyo0OuV6fEQ1BuaEhQNGJMLWI5Vzl5NmM3V2p5UlRTLVZz/view?usp=sharing
 */

public abstract class Chassi {

	public Chassi() {

	}

	public String definirProduto(String codigo) {
		Produtos produtos = new Produtos(null, null, 0, 0, null, null);
		return produtos.consultaBanco(codigo);
	}

	public String definirFeature(String codigo) {
		Features feature = new Features(null, null, null);
		return feature.consultaBanco(codigo);
	}

	public String listarProduto(int tipoChassi) {

		ArrayList<Produtos> produto = new ArrayList<Produtos>();
		Produtos produtos = new Produtos(null, null, 0, 0, null, null);
		boolean eValido = true;
		switch (tipoChassi) {
		case 0:
			// Caminh�es convencionais leves
			produto = produtos.listarProdutos("caminhao", 3, 120, 10, 160);
			break;
		case 1:
			// Caminh�es convencionais semi-pesados
			produto = produtos.listarProdutos("caminhao", 13, 190, 17, 280);
			break;
		case 2:
			// Caminh�es cavalo
			produto = produtos.listarProdutos("caminhao", 17, 330, 25, 390);
			break;
		case 3:
			// Micros
			produto = produtos.listarProdutos("onibus", 5, 150, 9, 160);
			break;
		case 4:
			// Midis
			produto = produtos.listarProdutos("onibus", 12, 180, 16, 190);
			break;
		case 5:
			// 17t
			produto = produtos.listarProdutos("onibus", 17, 180, 17, 300);
			break;
		case 6:
			// rodovi�rios
			produto = produtos.listarProdutos("onibus", 18, 180, 27, 410);
			break;
		case 7:
			// articulados
			produto = produtos.listarProdutos("onibus", 26, 360, 41, 360);
			break;
		default:
			eValido = false;
		}

		if (eValido) {
			// Convertendo para um objeto Json
			Map<Integer, String> data = new LinkedHashMap<Integer, String>();
			String jsonText = "";
			// Defina essa resposta no nosso documento que o servidor sempre vai
			// responder uma listagem de caminha nessa ordem ai
			// codigo: [ motor, eixo, descri�ao]
			for (int i = 0; i < produto.size(); i++) {
				String lista = produto.get(i).toString();
				data.put(i, lista);
			}
			jsonText = JSONValue.toJSONString(data);

			return jsonText;
		}

		return "ERRO";
	}

	public String listarFeature(int tipoFeature) {

		ArrayList<Features> feature = new ArrayList<Features>();
		Features features = new Features(null, null, null);
		boolean eValido = true;
		switch (tipoFeature) {
		case 0:
			feature = features.listarFeatures("Freios");
			break;
		case 1:
			feature = features.listarFeatures("Transmiss�o");
			break;
		case 2:
			feature = features.listarFeatures("Dire��o");
			break;
		case 3:
			feature = features.listarFeatures("Adicionais de Cabine");
			break;
		case 4:
			feature = features.listarFeatures("Carroceria");
			break;
		case 5:
			feature = features.listarFeatures("Suspens�o");
			break;
		default:
			eValido = false;
		}

		if (eValido) {
			// Convertendo para um objeto Json
			Map<Integer, String> data = new LinkedHashMap<Integer, String>();
			String jsonText = "";
			// Defina essa resposta no nosso documento que o servidor sempre vai
			// responder uma listagem de caminha nessa ordem ai
			// codigo: [ motor, eixo, descri�ao]
			for (int i = 0; i < feature.size(); i++) {
				String lista = feature.get(i).toString();
				data.put(i, lista);
			}
			jsonText = JSONValue.toJSONString(data);

			return jsonText;
		}
		
		return "ERRO";
	}

}
