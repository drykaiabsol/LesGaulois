package personnages;

public class Village {
	private String nom;
	private Gaulois chef;
	private Gaulois[] villageois;
	private int nbVillageois;

	public Village(String nom, Gaulois chef, int nbMaxVillageois) {
		this.nom = nom;
		this.chef = chef;
		this.villageois = new Gaulois[nbMaxVillageois];
		this.nbVillageois = 0;
		chef.setVillage(this);
	}

	public String getNom() {
		return nom;
	}

	public Gaulois getChef() {
		return chef;
	}

	public void ajouterVillageois(Gaulois gaulois) {
		if (gaulois != chef) {
			if (nbVillageois < villageois.length) {
				villageois[nbVillageois] = gaulois;
				nbVillageois++;
				gaulois.setVillage(this);
			} else {
				System.out.println("Le village est déjà plein !");
			}
		} else {
			System.out.println("Le chef ne peut pas être ajouté comme villageois !");
		}
	}

	public Gaulois trouverVillageois(int numero) {
		if (numero >= 1 && numero <= nbVillageois) {
			return villageois[numero - 1];
		} else {
			System.out.println("Il n’y a pas autant d'habitants dans notre village !");
			return null;
		}
	}

	public void afficherVillageois() {
		System.out.println("Dans le village \"" + nom + "\" du chef " + chef.getNom());
		System.out.println("vivent les légendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			if (villageois[i] != null) {
				System.out.println("- " + villageois[i].getNom());
			}
		}
	}

	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductibles", abraracourcix, 30);

		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterVillageois(asterix);

		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);

		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);

		village.afficherVillageois();
	}
}
