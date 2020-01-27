
import javax.xml.parsers.*; 
import org.w3c.dom.*; 
import org.xml.sax.*; 
import java.io.*; 

public class DOMTest {

	public static void main(String[] args) {
		System.out.print("flux.xml");
		String fichier = lireString();
		Document dom = parseDom("flux.xml");
		if(dom != null){
			Node racine = dom.getDocumentElement();
			
			//Calcul résultat
			//!ADAPTER au type de résultat et à la liste de paramètres
			int resultat = explorer(racine);

			//Affichage résultat
			//!ADAPTER à l'affichage souhaité
			System.out.println("Le résultat est " + resultat);
		}
	}
	
	private static String lireString(){
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
   	    try {
	    	return in.readLine();
	    } catch (IOException e){
	    	return null;
	    }
	}
	
	/**
	 * @param fichier
	 * @return
	 */
	private static Document parseDom(String fichier){
		try{
			  // création d'une fabrique de parseurs
			  DocumentBuilderFactory fabrique = 
					DocumentBuilderFactory.newInstance();
			  //fabrique.setValidating(true); //si l’on veut vérifier une DTD

			  // création d'un parseur
			  DocumentBuilder parseur = fabrique.newDocumentBuilder();
			            
			  // transformation d'un fichier XML en DOM
			  File xml = new File(fichier);
			  Document document = parseur.parse(xml);
			  return document;
			  
			} catch(ParserConfigurationException pce){
			     System.out.println("Erreur de configuration du parseur DOM");
			} catch(SAXException se){
			     System.out.println("Erreur lors du parsing du document");
			} catch(IOException ioe){
			     System.out.println("Erreur d'entrée/sortie");
			}
        return null;
	}
	
	//!ADAPTER au type de résultat et à la liste de paramètres
	private static int  explorer(Node noeud){
		//initialisation
		//!ADAPTER
		int resultat = 0;

		//traitement noeud courant
		//!ADAPTER
		if (noeud.getNodeType() == Node.TEXT_NODE){
			resultat++;
		} else if (noeud.getNodeType() == Node.ELEMENT_NODE){
			//action pour les noeuds élément
		} 
		
		//parcours récursif
		if (noeud.hasChildNodes()){
			NodeList enfants = noeud.getChildNodes();
			for(int i=0; i<enfants.getLength(); i++){
				//appel récursif
				//!ADAPTER
				int  resenf = explorer(enfants.item(i));
			   
				//combiner resenf avec resultat
				//!ADAPTER
				resultat += resenf;
			}
		}
		
	
		return resultat;
	}
	}

