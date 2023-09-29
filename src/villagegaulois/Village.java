package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private Marche marche;
	
	private static class Marche {
	    private int nbEtal;
	    private Etal[] etals;

	    private Marche(int nbEtal) {
	        this.nbEtal = nbEtal;
	        this.etals = new Etal[nbEtal];
	        for(int i = 0; i < nbEtal; i++) {
	        	etals[i] = new Etal();
	        }
	    }
	    
	    private void utiliserEtal(int indiceEtal, Gaulois vendeur, String produit, int nbProduit) {
	        if (indiceEtal >= 0 && indiceEtal < nbEtal) {
	            Etal etal = etals[indiceEtal];
	            if (etal == null) {
	                etal = new Etal();
	                etals[indiceEtal] = etal;
	            }
	            etal.occuperEtal(vendeur, produit, nbProduit);
	        } else {
	            System.out.println("Indice d'étal invalide.");
	        }
	    }
	    private int trouverEtalLibre() {
	        for (int i = 0; i < nbEtal; i++) {
	            if (!etals[i].isEtalOccupe()) {
	                return i;
	            }
	        }
	        return -1;
	    }
	    
		
		private Etal[] trouverEtals(String produit) {
	        Etal[] etalsAvecProduit = new Etal[nbEtal];
	        int i = 0;
	        
	        for (Etal etal : etals) {
	            if (etal != null && etal.contientProduit(produit)) {
	                etalsAvecProduit[i] = etal;
	                i+=1;
	            }
	        }
	        return etalsAvecProduit;
	    }
		private Etal trouverVendeur(Gaulois gaulois) {
			for (Etal etal : etals) {
	            if (etal != null && etal.getVendeur()==gaulois) {
	                return etal;
	            }
	        }
			return null;
		}
		
		private String afficherMarche() {
	        StringBuilder resultat = new StringBuilder();
	        int nbEtalVide = 0;

	        for (int i = 0; i < nbEtal; i++) {
	            Etal etal = etals[i];
	            if (etal.isEtalOccupe()) {
	                resultat.append("Étal ").append(i).append(" : ");
	                resultat.append(etal.afficherEtal());
	                resultat.append("\n");
	            } else {
	                nbEtalVide++;
	            }
	        }

	        if (nbEtalVide > 0) {
	            resultat.append("Il reste ").append(nbEtalVide).append(" étals non utilisés dans le marché.\n");
	        }

	        return resultat.toString();
	    }
	}


	public Village(String nom, int nbVillageoisMaximum, int nbEtal) {
		this.nom = nom;
		this.marche = new Marche(nbEtal);
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}
	
	public String installerVendeur(Gaulois vendeur, String produit,int nbProduit) {
		StringBuilder chaine = new StringBuilder();
		chaine.append(vendeur.getNom()+" cherche un endroit pour vendre "+nbProduit+" "+produit+".");
		int etalLibre = marche.trouverEtalLibre();
		if(etalLibre == -1) {
			chaine.append("Il n'y a pas d'etal libre dans le marche !");
		}else {
			chaine.append("Le vendeur "+vendeur.getNom()+" vend des "+ produit + " à l'étal n°"+ etalLibre);
		}
		return chaine.toString();
	}
	public String rechercherVendeursProduit(String produit) {
		StringBuilder chaine = new StringBuilder();
		chaine.append("Les vendeurs qui proposent des "+produit+" sont : ");
		
		return chaine.toString();
	}

	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef "
					+ chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom()
					+ " vivent les légendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}
}