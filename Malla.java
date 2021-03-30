import java.util.Random;



public class Malla {
	
	private static Random rnd;
	private int numfilas;
	private int numColumnas;
	private int numObstaculos;
	private int [][] matriz;
	private int posInii;
	private int posInij;
	private int posFini;
	private int posFinj;
	
	
	public Malla (int seed, int nf,int  nc, int nObs) {
		
		rnd = new Random(seed);
		numfilas = nf;
		numColumnas = nc;
		numObstaculos = nObs;
		
		int matriz[][] = new int [nf][nc];
		iniciaracero(matriz, nf, nc);
		meterObstaculos(matriz, rnd);

        this.matriz = matriz;
		
	}	

	protected void iniciaracero(int matriz[][], int nf, int nc){
		for(int i=0; i<nf; i++){
			for(int j=0; j<nc; i++){
				matriz[i][j] = 0;
			}
		}
	}
	
	
	protected void meterObstaculos(int [][] matriz, Random rnd){
 		int counter = 0;
    	int posIi, posIj, posFi, posFj;
	
		while (counter < numObstaculos){
			 int lugarfila = rnd.nextInt(numfilas);
			 int lugarcolumna = rnd.nextInt(numColumnas);

			 if(matriz[lugarfila][lugarcolumna]!=1){
        	    matriz[lugarfila][lugarcolumna]=1;
				counter++;
			 }
		}


		int ii, ij, fi, fj;
		do{
			ii = rnd.nextInt(numfilas);
			ij = rnd.nextInt(numColumnas);
			fi = rnd.nextInt(numfilas);
			fj = rnd.nextInt(numColumnas);
			if ((matriz[ii][ij] != 1) && (matriz[fi][fj] != 1)){
				posInii = ii;
				posInij = ij;
				posFini = fi;
				posFinj = fj;
			}
		}while((matriz[ii][ij] == 1) || (matriz[fi][fj] == 1));

        
	}

    public void ver (Malla a) {
		System.out.println("Posicion inicial: (" + a.posInii + ", " + a.posInij + ")");
		System.out.println("Posicion final: (" + a.posFini + ", " + a.posFinj + ")");
		
		System.out.println("Malla: ");
		System.out.println();
		for(int i=0; i < a.numfilas; i++){
			for(int j=0; j < a.numColumnas; j++){
				
				System.out.println(a.matriz[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int[][] getMalla(){
		return matriz;
	}

    public int[] getposIni() {
		int[] posIni = new int[2];
		posIni[0] = posInii;
		posIni[1] = posInij;
		return posIni;
	}

	public int[] getposFin() {
		int[] posFin = new int[2];
		posFin[0] = posFini;
		posFin[1] = posFinj;
		return posFin;
	}

}