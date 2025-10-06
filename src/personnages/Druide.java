package personnages;

public class Druide {
	private String nom;
	private int forcePotion;
	private Chaudron chaudron;

	public Druide(String nom, int forcePotion) {
		this.nom = nom;
		this.forcePotion = forcePotion;
		this.chaudron = new Chaudron();
	}

	public String getNom() {
		return nom;
	}

	public int getForcePotion() {
		return forcePotion;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le Druide " + nom + " : ";
	}

	public void preparerPotion(int quantite, int force) {
		parler("J'ai concocté " + quantite + " doses de potion magique. Elle a une force de " + force + ".");
		for (int i = 0; i < quantite; i++) {
			chaudron.remplir(force);
		}
		this.forcePotion = force;
	}

	public void boosterGaulois(Gaulois gaulois) {
		if (gaulois.getNom().equals("Obélix")) {
			parler("Non, " + gaulois.getNom() + " Non !... Et tu le sais très bien !");
		} else {
			parler("Tiens " + gaulois.getNom() + " un peu de potion magique.");
			gaulois.boirePotion(this);
		}
	}

	public void donnerPotion(Gaulois gaulois) {

	}

	@Override
	public String toString() {
		return "Druide [nom=" + nom + ", forcePotion=" + forcePotion + "]";
	}
}
