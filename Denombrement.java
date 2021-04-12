/**
	* Classe Denombrement
	* @author : -
	* @version : 1.0
*/

public class Denombrement
{
	// L'attribut de classe renseigne sur l'entier à renvoyer en cas d'erreur(s) sur le(s) paramètre(s) d'une méthode.
	private static final int ERREUR_PARAMETRE = -1;

	/**
		* @return Retourne la factorielle d'un nombre.
		* Notation de la factorielle : x!
		* @param n : le nombre dont il faut calculer la factorielle.
	*/
	public static int factorielle(int n)
	{
		// La factorielle est définit que pour les entiers positifs
		if ( n < 0 )
		{
			return Denombrement.ERREUR_PARAMETRE;
		}

		// Vérification : 0! = 1		
		if ( n == 0 )
		{
			return 1;
		}
		
		return n * factorielle( n-1 );
		
	}
	

	/**
		* @return Retourne l'arrangement
		* Formule : Akn = n! / (n-k)!
	*/
	public static int aknFactorielle(int k, int n)
	{
		// La factorielle est définit que pour les entiers positifs
		if ( n < 0 || k < 0 || n < k  )
		{
			return Denombrement.ERREUR_PARAMETRE;
		}
		
		// Par convention, 0 parmi 0 vaut 1 
		if ( k == 0 && n == 0 )
		{
			return 1;
		}

		// Si k = 0, il y qu'un unique résultat vide
		if ( k == 0 )
		{
			return 1;
		}

		// Si n = 0, il n'y a pas résultat 
		if ( n == 0 )
		{
			return 0;
		}

		int numerateur 		= ( n*factorielle( n-1 ) );
		int denominateur 	= ( factorielle( n-k ) );
		
		if ( numerateur == 0 || denominateur == 0 )
		{
			return 0;
		}

		return numerateur  / denominateur;
	}

	/**
		* @return Retourne le nombre de combinaison(s) de K parmi N.
		* Formule : Ckn = n! / k! * (n-k)!
		* @param n : le nombre total d'élement(s).
		* @param k : le nombre d'élément(s) précis parmi le nombre total d'élément(s).
	*/
	public static int cnkFactorielle(int k, int n)
	{
		// La factorielle est définit que pour les entiers positifs
		if ( n < 0 || k < 0 || n < k  )
		{
			return Denombrement.ERREUR_PARAMETRE;
		}
		
		// Par convention, 0 parmi 0 vaut 1 
		if ( k == 0 && n == 0 )
		{
			return 1;
		}

		// Si k = 0, il y qu'un unique résultat vide
		if ( k == 0 )
		{
			return 1;
		}

		// Si n = 0, il n'y a pas résultat 
		if ( n == 0 )
		{
			return 0;
		}

		int numerateur 		= ( n*factorielle( n-1 ) );
		int denominateur 	= ( ( k*factorielle( k-1 ) ) * ( factorielle( n-k ) ) );
		
		if ( numerateur == 0 || denominateur == 0 )
		{
			return 0;
		}

		return numerateur  / denominateur;
	}
	
	/**
		* Calcul Pascal les combinaisons de K parmi N. 
		* Formule : Ckn = C k-1 n + + C k n-1
		* @param n : le nombre total d'élements.
		* @param k : le nombre d'éléments précis parmi le nombre total d'éléments.
	*/
	public static int cnkPascal(int k, int n)
	{
		// La factorielle est définit que pour les entiers positifs
		if ( n < 0 || k < 0 || n < k  )
		{
			return Denombrement.ERREUR_PARAMETRE;
		}
		
		// Par convention, 0 parmi 0 vaut 1 
		if ( k == 0 && n == 0 )
		{
			return 1;
		}

		// Si k = 0, il y qu'un unique résultat vide
		if ( k == 0 )
		{
			return 1;
		}

		// Si n = 0, il n'y a pas résultat 
		if ( n == 0 )
		{
			return 0;
		}

		return ( cnkFactorielle(k-1, n-1) + cnkFactorielle(k, n-1) );
	}

	/**
		* Calcul récursif les combinaisons de K parmi N.
		* Formule : Ckn = (n/k) * (C k-1 n-1) <==> ( ( n * (C k-1 n-1) ) / k ).
		* @param n : le nombre total d'élements.
		* @param k : le nombre d'éléments précis parmi le nombre total d'éléments.
	*/
	public static int cnkRecursif(int k, int n)
	{
		// La factorielle est définit que pour les entiers positifs
		if ( n < 0 || k < 0 || n < k  )
		{
			return Denombrement.ERREUR_PARAMETRE;
		}
		
		// Par convention, 0 parmi 0 vaut 1 
		if ( k == 0 && n == 0 )
		{
			return 1;
		}

		// Si k = 0, il y qu'un unique résultat vide
		if ( k == 0 )
		{
			return 1;
		}

		// Si n = 0, il n'y a pas résultat 
		if ( n == 0 )
		{
			return 0;
		}

		return ( (n * cnkRecursif(k-1, n-1) ) / k );
	}

	/**
		* Calcul récursif les arrangements de K parmi N.
		* Formule : Akn = ( ( n * (A k n-1) ) / k )  <==> Akn = (n *  / (n-k)!
		* @param n : le nombre total d'élements.
		* @param k : le nombre d'éléments précis parmi le nombre total d'éléments.
	*/
	private static int aknRecursif(int k, int n)
	{
		// La factorielle est définit que pour les entiers positifs
		if ( n < 0 || k < 0 || n < k  )
		{
			return Denombrement.ERREUR_PARAMETRE;
		}
		
		// Par convention, 0 parmi 0 vaut 1 
		if ( k == 0 && n == 0 )
		{
			return 1;
		}

		// Si k = 0, il y qu'un unique résultat vide
		if ( k == 0 )
		{
			return 1;
		}

		// Si n = 0, il n'y a pas résultat 
		if ( n == 0 )
		{
			return 0;
		}

		return ( (n * aknRecursif(k-1, n-1) ) / k );
	}

	private static int aknRecursifFactorielle(int k, int n)
	{
		// Vérification des paramètres
		if ( n < 0 || k < 0 || n < k  )
		{
			return Denombrement.ERREUR_PARAMETRE;
		}

		int aknRecursif 	= 0;
		int kFactorielle 	= 0;

		aknRecursif = aknRecursif(k, n);
		kFactorielle = factorielle(k);

		return aknRecursif * kFactorielle;
		
	}
	
	public static void main(String[] args)
	{
		System.out.println("===================");
		System.out.println("Classe Denombrement");
		System.out.println("===================");
		
		System.out.print("Test de la méthode factorielle(int n) : ");
		System.out.println(factorielle(5));
		
		final int k = 3;
		final int n = 5;
		System.out.println("K : " + k);
		System.out.println("N : " + n);

		// Méthode ne fonctionne que avec des petits nombres
		System.out.print("Test de la méthode Combinaison K parmi N => cnkFactorielle(int k, int n) : ");
		System.out.println(cnkFactorielle(k, n));

		// Méthode ne fonctionne que avec des petits nombres
		System.out.print("Test de la méthode Combinaison K parmi N => cnkPascal(int k, int n) : ");
		System.out.println(cnkPascal(k, n));

		// Méthode fonctionne avec de grands nombres
		System.out.print("Test de la méthode Combinaison K parmi N => cnkRecursif(int k, int n) : ");
		System.out.println(cnkRecursif(k, n));

		// Méthode ne fonctionne que avec des petits nombres
		System.out.print("Test de la méthode Arrangement K parmi N => aknFactorielle(int k, int n) : ");
		System.out.println(aknFactorielle(k, n));

		System.out.print("Test de la méthode Arrangement K parmi N => aknRecursif(int k, int n) : ");
		System.out.println(aknRecursifFactorielle(k, n));
		
	}
}
