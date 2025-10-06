package personnages;

public class Chaudron {
	private int quantitePotion;

	public Chaudron() {
		this.quantitePotion = 0;
	}

	public void remplir(int quantite) {
		this.quantitePotion += quantite;
	}

	public void vider() {
		this.quantitePotion = 0;
	}

	public int getQuantitePotion() {
		return quantitePotion;
	}

	public boolean resterPotion() {
		return quantitePotion > 0;
	}

	@Override
	public String toString() {
		return "Chaudron [quantitePotion=" + quantitePotion + "]";
	}

}
