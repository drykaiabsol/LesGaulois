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
		this.forcePotion = force;
		chaudron.remplir(quantite);
		parler("J'ai concocté " + quantite + " doses de potion magique. Elle a une force de " + force + ".");
	}

	public void boosterGaulois(Gaulois gaulois) {
		if (!chaudron.resterPotion()) {
			parler("Désolé " + gaulois.getNom() + ", il n'y a plus de potion !");
			return;
		}

		if (gaulois.getNom().equals("Obélix")) {
			parler("Non, " + gaulois.getNom() + " Non !... Et tu le sais très bien !");
		} else {
			parler("Tiens " + gaulois.getNom() + " un peu de potion magique.");
			if (chaudron.utiliserPotion()) {
				gaulois.boirePotion(this);
			} else {
				parler("Oups, plus de potion au moment de servir " + gaulois.getNom() + " !");
			}
		}
	}

	@Override
	public String toString() {
		return "Druide [nom=" + nom + ", forcePotion=" + forcePotion + "]";
	}
}
