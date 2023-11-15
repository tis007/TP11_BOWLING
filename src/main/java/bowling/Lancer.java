package bowling;

public class Lancer {
	private int nbQuille;

	public Lancer(int nbQuille) {
		if (nbQuille > 10 || nbQuille < -1) {
			throw new IllegalArgumentException("nb de quilles non correct");
		}
		this.nbQuille = nbQuille;
	}
	
	public Lancer() {
		this(-1);
	}

	public int getNbQuille() {
		return nbQuille;
	}
	
	public void setNbQuille(int nbQuille) {
		if (nbQuille > 10 || nbQuille < 0){
			throw new IllegalArgumentException("nb quille incorrect");
		}
		this.nbQuille = nbQuille;
	}
}
