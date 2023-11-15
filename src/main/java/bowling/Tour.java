package bowling;

public class Tour {
	private Lancer lancer1;
	private Lancer lancer2;
	private TourType tourType;
	private int scoreTour = 0;

	public Tour() {
		lancer1 = new Lancer();
		lancer2 = new Lancer();
		tourType = TourType.NORMAL;
	}
	
	public int getScoreTour(Lancer l1, Lancer l2) {
		int l1Val =  Math.max(0, l1.getNbQuille());
		int l2Val =  Math.max(0, l2.getNbQuille());

		if (lancer1.getNbQuille() == 10 ){
			this.scoreTour = lancer1.getNbQuille() + l1Val + l2Val;
		}else if (lancer1.getNbQuille() + lancer2.getNbQuille() == 10) {
			this.scoreTour = lancer1.getNbQuille() + lancer2.getNbQuille() + l1Val;
		} else {
			this.scoreTour = Math.max(0, lancer1.getNbQuille()) +  Math.max(0, lancer2.getNbQuille());
		}
		return (this.scoreTour);
	}

	public void addScoreLancer(int nbQuille) {
		if (nbQuille < 0 || nbQuille > 10){
			throw new IllegalArgumentException("nbQuille must be between 0 and 10");
		}
		if (this.getNumLancer() == 1) {
			addScoreLancer(nbQuille, lancer1);
			if (nbQuille == 10) {
				tourType = TourType.STRIKE;
			}
		} else if (this.getNumLancer() == 2) {
			//TODO : implement throw declaration with working 10th lancer
			/*
			if (lancer1.getNbQuille() + nbQuille >10){
				throw new IllegalArgumentException("Lancers make more than 10 quilles");
			}
			 */
			addScoreLancer(nbQuille, lancer2);
			if (lancer1.getNbQuille() + lancer2.getNbQuille() == 10){
				tourType = TourType.SPARE;
			}
		}
	}
	
	public void addScoreLancer(int nbQuille, Lancer lancer) {
		lancer.setNbQuille(nbQuille);
	}
	
	public int getNbQuilleTour() {
		int score = 0;
		if (lancer1.getNbQuille() != -1) {
			score += lancer1.getNbQuille();
		}
		if (lancer2.getNbQuille() != -1) {
			score += lancer2.getNbQuille();
		}
		return score;
	}
	
	public int getScoreQuilleLancer(Lancer l) {
		/*
		if (l.getNbQuille() < 0) {
			return 0;
		}
		
		 */
		return l.getNbQuille();
	}
	public int getScoreQuilleLancer1(){
		return getScoreQuilleLancer(lancer1);
	}

	public int getScoreQuilleLancer2(){
		return getScoreQuilleLancer(lancer2);	
	}

	public int getNumLancer() {
		if (lancer1.getNbQuille() == -1) {
			return 1;
		} else if (lancer2.getNbQuille() == -1 && lancer1.getNbQuille() != 10) {
			return 2;
		} else {
			return 0;
		}
	}

	public Lancer getLancer1() {
		return lancer1;
	}

	public Lancer getLancer2() {
		return lancer2;
	}
}
