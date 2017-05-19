package entite;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@SuppressWarnings("unused")
@Entity
@Table(name = "aidant")
public class Aidant implements Cloneable {
	
	@Id
	@Column(name = "IDAIDANT", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idAidant;

	@Column(name = "MAILAIDANT", length = 50, nullable = true)
	private String mailAidant;

	@Column(name = "ADRESSEAIDANT", length = 50, nullable = true)
	private String adresseAidant;

	@Column(name = "DDNAIDANT", nullable = true)
	private Date ddnAidant;

	@Column(name = "TELAIDANT", length = 50, nullable = true)
	private String telAidant;
	
	@Column(name = "MDPAIDANT", length = 50, nullable = true)
	private String mdpAidant;
	
	@Column(name = "TYPE", length = 32, nullable = true)
	private String type;
	
	@Column(name = "REFERENT", nullable = true)
	private Boolean referent;
	
	@Column(name = "NOMAIDANT", length = 32, nullable = true)
	private String nomAidant;
	
	@Column(name = "PRENOMAIDANT", length = 32, nullable = true)
	private String prenomAidant;
	
	@OneToMany(mappedBy="aidant", cascade={CascadeType.ALL})
	private Set<CompteRendu> cr= new HashSet<CompteRendu>();

	// constructeurs
	public Aidant() {
		
	}	

	
	public Aidant(String mailAidant, String adresseAidant, Date ddnAidant, String telAidant,
			String mdpAidant, String type, Boolean referent, String nomAidant, String prenomAidant) {
		
		setMailAidant(mailAidant);
		setAdresseAidant(adresseAidant);
		setDdnAidant(ddnAidant);
		setTelAidant(telAidant);
		setMdpAidant(mdpAidant);
		setType(type);
		setReferent(referent);
		setNomAidant(nomAidant);
		setPrenomAidant(prenomAidant);
	}




	

	// accesseurs


	public Integer getIdAidant() {
		return idAidant;
	}




	public void setIdAidant(Integer idAidant) {
		this.idAidant = idAidant;
	}




	public String getMailAidant() {
		return mailAidant;
	}




	public void setMailAidant(String mailAidant) {
		this.mailAidant = mailAidant;
	}




	public String getAdresseAidant() {
		return adresseAidant;
	}




	public void setAdresseAidant(String adresseAidant) {
		this.adresseAidant = adresseAidant;
	}




	public Date getDdnAidant() {
		return ddnAidant;
	}




	public void setDdnAidant(Date ddnAidant) {
		this.ddnAidant = ddnAidant;
	}




	public String getTelAidant() {
		return telAidant;
	}




	public void setTelAidant(String telAidant) {
		this.telAidant = telAidant;
	}




	public String getMdpAidant() {
		return mdpAidant;
	}




	public void setMdpAidant(String mdpAidant) {
		this.mdpAidant = mdpAidant;
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public Boolean getReferent() {
		return referent;
	}




	public void setReferent(Boolean referent) {
		this.referent = referent;
	}




	public String getNomAidant() {
		return nomAidant;
	}




	public void setNomAidant(String nomAidant) {
		this.nomAidant = nomAidant;
	}




	public String getPrenomAidant() {
		return prenomAidant;
	}




	public void setPrenomAidant(String prenomAidant) {
		this.prenomAidant = prenomAidant;
	}



	//ToString
	
	@Override
	public String toString() {
		return "Aidant [idAidant=" + idAidant + ", mailAidant=" + mailAidant + ", adresseAidant=" + adresseAidant
				+ ", ddnAidant=" + ddnAidant + ", telAidant=" + telAidant + ", mdpAidant=" + mdpAidant + ", type="
				+ type + ", referent=" + referent + ", nomAidant=" + nomAidant + ", prenomAidant=" + prenomAidant + "]";
	}



	
}


	