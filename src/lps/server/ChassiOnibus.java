package lps.server;

public class ChassiOnibus extends Chassi {

	/*
	 * Aqui � a classe que reune apenas as caracter�sticas presente nos �nibus
	 */

	private String posicaoMotor;
	private int suspensao;

	public ChassiOnibus() {
		super();
	}

	public int getSuspensao() {
		return suspensao;
	}

	public void setSuspensao(int suspensao) {
		if (suspensao == 0) {
			// System.out.println("Suspens�o a ar");
		} else {
			// System.out.println("Suspens�o Comum");
		}
	}

	public void setPosicaoMotor(int motor) {
		if (motor < 280) {
			this.posicaoMotor = "Dianteiro";
		} else {
			this.posicaoMotor = "Traseiro";
		}
	}

	public String getPosicaoMotor() {
		return posicaoMotor;
	}

	public String textoTipoSuspensao(int suspensao) {
		String textoTipo;
		if (suspensao == 0)
			textoTipo = "Suspens�o a Ar";
		else
			textoTipo = "Suspens�o Met�lica";
		return textoTipo;
	}

}
