package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.village = null;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "" + nom + " : ";

	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + "]";
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 16);

		System.out.println(asterix.getNom());
		System.out.println(obelix.getNom());
	}

	public void frapper(Romain romain) {
		int forceCoup = (force * effetPotion) / 3;
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom() + " !");
		romain.recevoirCoup(forceCoup);
		effetPotion--;
		if (effetPotion < 1) {
			effetPotion = 1;
		}
	}

	public void boirePotion(Druide druide) {
		System.out.println(nom + " boit la potion préparée par " + druide.getNom());
		effetPotion = druide.getForcePotion();
	}

	public void sePresenter() {
		if (village != null && village.getChef() == this) {
			System.out.println("Le Gaulois " + nom + " : \"Bonjour, je m'appelle " + nom
					+ ". Je suis le chef du village " + village.getNom() + ".\"");
		} else if (village != null) {
			System.out.println("Le Gaulois " + nom + " : \"Bonjour, je m'appelle " + nom + ". J'habite le village "
					+ village.getNom() + ".\"");
		} else {
			System.out.println("Le Gaulois " + nom + " : \"Bonjour, je m'appelle " + nom
					+ ". Je voyage de villages en villages.\"");
		}
	}

	public void setVillage(Village village) {
		this.village = village;
	}

}
