package com.insat.bibliotheque.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Livre.
 */
@Entity
@Table(name = "book")
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Livre implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "auteur")
    private String auteur;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;


    @Column(name = "prix")
    private Long prix;

    @Column(name = "genre")
    private String genre;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public Livre titre(String titre) {
        this.titre = titre;
        return this;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public Livre auteur(String auteur) {
        this.auteur = auteur;
        return this;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getDescription() {
        return description;
    }

    public Livre description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrix() {
        return prix;
    }

    public Livre prix(Long prix) {
        this.prix = prix;
        return this;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrix(Long prix) {
        this.prix = prix;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Livre livre = (Livre) o;
        if (livre.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), livre.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Livre{" +
            "id=" + getId() +
            ", titre='" + getTitre() + "'" +
            ", auteur='" + getAuteur() + "'" +
            ", description='" + getDescription() + "'" +
            ", image='" + getImage() + "'" +
            ", prix=" + getPrix() +
            "}";
    }
}
