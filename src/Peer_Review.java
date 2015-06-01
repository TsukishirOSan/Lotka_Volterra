


 

/**
 * Computes, given an initial number of hares(H) and lynxes(L)the growth of the predators 
   and preys' populations regarding a period of time n
 * @author faiza harbi
 * @version 1.1
 * @since 06/01/2017 
 *
 */
public class Peer_Review {
	/**
	 * Computes, given an initial number of hares(H) and lynxes(L) with respect to the
	 * Lotka-Volterra formula for the growth of the predators and preys' populations
	 * regarding a period of time n represented by the number of turns in the computing loop
	 * @param preyPred :array of double containing L and H population
	 * @param a :array of double containing hares' constants
	 * @param b :array of double containing lynxes' constants
	 * @param n :period of time aka num turns in loop
	 * @return array of double containing the new H and L populations
	 */
	public static double[] preyPredLV(double[] preyPred, double[] a, double[] b, int n){
		
		
		
		double hare = preyPred[0]; // number of hares
		double lynx = preyPred[1]; // number of lynxes
		// array a handles the constants regarding the hares' population's growth
		double a1 = a[0];
		double a2 = a[1];
		// array b handles the constants regarding the lynxes' population's growth
		double b1 = b[0];
		double b2 = b[1];
		
		// needed to use the right number of hare(H[n-1] and not H[n]) to compute the number of lynxes
		double tmp_hare = 0; 
		// n is the period of time.
		for(int i = 0; i < n; i++){
			tmp_hare = hare;
			hare = hare * (1 + a1 - a2 * lynx);
			lynx = lynx * (1 - b1 + b2 * tmp_hare);
		}
		preyPred[0] = hare;
		preyPred[1] = lynx;
		return preyPred;
	}


	/**
	 * @param args none
	 */
	public static void main(String[] args) {
		/**
		 * assign values to preyPredLV 's arguments
		 */
		double [] preyPred = {300, 20};
		double [] a = {0.1, 0.01};
		double [] b = {0.01, 0.00002};
		
		int n = 20;
		
		double [] result = preyPredLV(preyPred, a, b, n);
		System.out.println("After "+n+" periods\n"+"Population of hares: "+result[0]+"\nPopulation of lynxes: "+result[1]);
		}
}