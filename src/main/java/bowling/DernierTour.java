package bowling;

public class DernierTour extends Tour {
	Lancer lancer3;

	public DernierTour() {
		lancer3 = new Lancer();
	}

	@Override
	public int getScoreTour(Lancer l1, Lancer l2) {

		return Math.max(0, getLancer1().getNbQuille()) + Math.max(0, getLancer2().getNbQuille()) + Math.max(0, lancer3.getNbQuille());
	}

	public void addScoreLancer(int nbQuille) {
		if (this.getNumLancer() == 3) {
			super.addScoreLancer(nbQuille, lancer3);
		} else {
			super.addScoreLancer(nbQuille);
		}
	}


	@Override
	public int getNumLancer() {
		if (this.getLancer1().getNbQuille() == -1) {
			return 1;
		} else if (this.getLancer2().getNbQuille() == -1) {
			return 2;
		} else if (this.lancer3.getNbQuille() == -1 && (this.getLancer1().getNbQuille() + this.getLancer2().getNbQuille()) >= 10) {
			return 3;
		} else {
			return 0;
		}
	}

}
