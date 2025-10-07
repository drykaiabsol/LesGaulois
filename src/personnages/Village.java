public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageoisMax;
	private int nbVillageois;

	public Village(String nom, int nbVillageoisMax) {
		this.nom = nom;
		this.nbVillageoisMax = nbVillageoisMax;
		this.villageois = new Gaulois[nbVillageoisMax];
		this.nbVillageois = 0;
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
		ajouterHabitant(chef);
		chef.setVillage(this);
	}

	public Chef getChef() {
		return chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < nbVillageoisMax) {
			villageois[nbVillageois] = gaulois;
			gaulois.setVillage(this);
			nbVillageois++;
		}
	}

	public Gaulois trouverVillageois(int numero) {
		if (numero >= 0 && numero < nbVillageois) {
			return villageois[numero];
		} else {
			System.out.println("Il n’y a pas autant d'habitants dans notre village !");
			return null;
		}
	}

	public void afficherVillageois() {
		System.out.println("Dans le village \"" + nom + "\" du chef " + chef.getNom());
		System.out.println("vivent les légendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {

			if (villageois[i] != chef) {
				System.out.println("- " + villageois[i].getNom());
			}
		}
	}

	public static void main(String[] args) {

		Chef abraracourcix = new Chef("Abraracourcix", 6);

		Village village = new Village("Village des Irréductibles", 30);
		village.setChef(abraracourcix);

		Gaulois gaulois = village.trouverVillageois(30);

		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);

		gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);

		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);

		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);

		village.afficherVillageois();

		Gaulois doublePolemix = new Gaulois("Doublepolémix", 4);

		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublePolemix.sePresenter();
	}
}
