package dao;

import java.text.ParseException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entite.Aidant;
import entite.Organisateur;

//singleton ----------------------------------------
public class BaseDAO {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;

	private static BaseDAO instance;

	/**
	 * Le DAO fonctionne en singleton
	 * 
	 * @return l'instance unique du DAO
	 */
	public static BaseDAO getInstance() {
		if (instance == null) {
			instance = new BaseDAO();
		}
		return instance;
	}
	//pour rien

	// -------------------------------------------------
	/**
	 * Constructeur du DAO Il initialise le contexte de persistance
	 */
	public BaseDAO() {
		emf = Persistence.createEntityManagerFactory("jpa");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
	}

	/**
	 * Synchronise le context de persistance avec la base de donnee.
	 * En fait un commit est effectue et une nouvelle transaction d�but�e
	 */
	public void commit(){
		tx.commit();
		tx.begin();
	}
	
	/**
	 * Ferme la factory d'entity manager et l'entity manager
	 */
	public void closeAll() {
		em.close();
		emf.close();
	}

	/**
	 * La fonction renvoie true si la personne a bien entre un nom et un mot de
	 * passe valides
	 * 
	 * @return true si c'est ok et false si erreur de connection
	 */
	public Boolean verifConnection(String mail, String mdp, String nomTable) {
		Boolean resultat = true;
		if (nomTable.equals("aidant")) {
			if (em.createQuery("select nomAidant from Aidant where mailAidant = '" + mail + "'"
					+ "AND mdpAidant = MD5('" + mdp + "')").getResultList().isEmpty()) {
				resultat = false;
			} else {
				return resultat;
			}	
		} 
		else if (nomTable.equals("aide")) {
			if (em.createQuery("select nom from Aide where mail = '" + mail + "'"
					+ "AND mdp = MD5('" + mdp + "')").getResultList().isEmpty()) {
				resultat = false;
			} else {
				return resultat;
			}	
		}
		else {
			if (em.createQuery("select mailMedecin from Medecin where mailMedecin = '" + mail + "'"
					+ "AND mdpMedecin = MD5('" + mdp + "')").getResultList().isEmpty()) {
				resultat = false;
			} else {
				return resultat;
			}	
		}
	}
	
	/**
	 * Ajoute un médecin dans la base de donnees
	 */
	public void ajouterMedecin(String nom, String prenom, String mdpMedecin, String mailMedecin, String adressePro, String telMedecin) throws ParseException {
		 medecin = new Medecin(nom, prenom, mdpMedecin, mailMedecin, adressePro, telMedecin);
		em.persist(medecin);
	}
	
	/**
	 * Ajoute un aide dans la base de donnees
	 */
	public void ajouterAide(String adresse, String date, String mail, String nom, String prenom, String tel, String mdpAide, String nomMedecin) throws ParseException {
		 aide = new Aide(adresse, date, mail,nom, prenom, tel,mdpAide,trouverMedecin.idMedecin(nomMedecin));
		em.persist(aide);
	}
	
	/**
	 * Ajoute un aidant dans la base de donnees
	 */
	public void ajouterAidant(String mailAidant, String adresseAidant, String ddnAidant, String telAidant, String mdpAidant, String type, Boolean referent, String nomAidant, String prenomAidant) throws ParseException {
		 aidant = new Aidant(mailAidant, adresseAidant, ddnAidant, telAidant, mdpAidant, type, referent, nomAidant, prenomAidant);
		em.persist(aidant);
	}
	
	public Medecin chercherMedecin(String nom){
		Iterator medecin = session.iterate("from Medecin ");
		while (medecin.hasNext()) {
		Medecin medecin = (Medecin) medecin.next();
		if (medecin.nom.equals(nom)) {
			return Medecin;
		}
		} 
	}

}