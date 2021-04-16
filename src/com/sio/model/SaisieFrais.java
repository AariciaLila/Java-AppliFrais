package com.sio.model;


import java.sql.Date;
import java.time.LocalDate;

/**
 * Todo.java
 * This is a model class represents a Todo entity
 * @author Ramesh Fadatare
 *
 */
public class SaisieFrais {

	private Long id;
	private String description;
	private LocalDate targetDate;
	private String status;
	private int kilometre;
	private int quantite;
	private int nuité;
	private float montant;
	private float etape;
	private float repas;
	private int justificatifs;
	private Date dateHorsForfait;
	private String libelle;
	private int montantHorsForfait;
	
	
	protected SaisieFrais() {
		
	}
	
	public SaisieFrais(long id, String description, LocalDate targetDate, String status, int km, float montant, float etape, int nuité, float repas, Date dateHorsForfait,String libelle,int montantHorsForfait, int quantite) {
		super();
		this.id = id;
		this.description = description;
		this.targetDate = targetDate;
		this.status = status;
		this.kilometre = km;
		this.etape = etape;
		this.nuité = nuité;
		this.montant = montant;
		this.repas = repas;
		this.dateHorsForfait = dateHorsForfait;
		this.libelle = libelle;
		this.montantHorsForfait = montantHorsForfait;
		this.quantite = quantite;
		
	}

	public SaisieFrais( String description, LocalDate targetDate, String status, int km, float montant, float etape, int nuité, float repas, Date dateHorsForfait,String libelle,int montantHorsForfait, int quantite) {
		super();
		this.description = description;
		this.targetDate = targetDate;
		this.status = status;
		this.kilometre = km;
		this.etape = etape;
		this.nuité = nuité;
		this.montant = montant;
		this.repas = repas;
		this.dateHorsForfait = dateHorsForfait;
		this.libelle = libelle;
		this.montantHorsForfait = montantHorsForfait;
		this.quantite = quantite;
		
	}
	
	
	
	
	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getJustificatifs() {
		return justificatifs;
	}

	public Date getDateHorsForfait() {
		return dateHorsForfait;
	}

	public void setDateHorsForfait(Date dateHorsForfait) {
		this.dateHorsForfait = dateHorsForfait;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getMontantHorsForfait() {
		return montantHorsForfait;
	}

	public void setMontantHorsForfait(int montantHorsForfait) {
		this.montantHorsForfait = montantHorsForfait;
	}

	public void setJustificatifs(int justificatifs) {
		this.justificatifs = justificatifs;
	}

	public int getKilometre() {
		return kilometre;
	}

	public void setKilometre(int kilometre) {
		this.kilometre = kilometre;
	}

	public int getNuité() {
		return nuité;
	}

	public void setNuité(int nuité) {
		this.nuité = nuité;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public float getEtape() {
		return etape;
	}

	public void setEtape(float etape) {
		this.etape = etape;
	}

	public float getRepas() {
		return repas;
	}

	public void setRepas(float repas) {
		this.repas = repas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaisieFrais other = (SaisieFrais) obj;
		//Todo other = (Todo) obj;
		if (id != other.id)
			return false;
		return true;
	}
}


