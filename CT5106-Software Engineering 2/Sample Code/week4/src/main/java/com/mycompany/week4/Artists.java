/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week4;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author o_molloy
 */
@Entity
@Table(name = "artists")
@NamedQueries(
{
    @NamedQuery(name = "Artists.findAll", query = "SELECT a FROM Artists a"),
    @NamedQuery(name = "Artists.findByArtistid", query = "SELECT a FROM Artists a WHERE a.artistid = :artistid"),
    @NamedQuery(name = "Artists.findBySurname", query = "SELECT a FROM Artists a WHERE a.surname = :surname"),
    @NamedQuery(name = "Artists.findByFirstName", query = "SELECT a FROM Artists a WHERE a.firstName = :firstName"),
    @NamedQuery(name = "Artists.findByGender", query = "SELECT a FROM Artists a WHERE a.gender = :gender"),
    @NamedQuery(name = "Artists.findByBirthyear", query = "SELECT a FROM Artists a WHERE a.birthyear = :birthyear"),
    @NamedQuery(name = "Artists.findByNationality", query = "SELECT a FROM Artists a WHERE a.nationality = :nationality"),
    @NamedQuery(name = "Artists.findByEmailaddress", query = "SELECT a FROM Artists a WHERE a.emailaddress = :emailaddress"),
    @NamedQuery(name = "Artists.findByWebsiteaddress", query = "SELECT a FROM Artists a WHERE a.websiteaddress = :websiteaddress")
})
public class Artists implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "artistid")
    private Integer artistid;
    @Column(name = "surname")
    private String surname;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "birthyear")
    private Short birthyear;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "emailaddress")
    private String emailaddress;
    @Column(name = "websiteaddress")
    private String websiteaddress;
    @Lob
    @Column(name = "biography")
    private String biography;
    @Lob
    @Column(name = "photograph")
    private String photograph;
    @OneToMany(mappedBy = "artistid")
    private Collection<Artworks> artworksCollection;

    public Artists()
    {
    }

    public Artists(Integer artistid)
    {
        this.artistid = artistid;
    }

    public Integer getArtistid()
    {
        return artistid;
    }

    public void setArtistid(Integer artistid)
    {
        this.artistid = artistid;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public Short getBirthyear()
    {
        return birthyear;
    }

    public void setBirthyear(Short birthyear)
    {
        this.birthyear = birthyear;
    }

    public String getNationality()
    {
        return nationality;
    }

    public void setNationality(String nationality)
    {
        this.nationality = nationality;
    }

    public String getEmailaddress()
    {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress)
    {
        this.emailaddress = emailaddress;
    }

    public String getWebsiteaddress()
    {
        return websiteaddress;
    }

    public void setWebsiteaddress(String websiteaddress)
    {
        this.websiteaddress = websiteaddress;
    }

    public String getBiography()
    {
        return biography;
    }

    public void setBiography(String biography)
    {
        this.biography = biography;
    }

    public String getPhotograph()
    {
        return photograph;
    }

    public void setPhotograph(String photograph)
    {
        this.photograph = photograph;
    }

    public Collection<Artworks> getArtworksCollection()
    {
        return artworksCollection;
    }

    public void setArtworksCollection(Collection<Artworks> artworksCollection)
    {
        this.artworksCollection = artworksCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (artistid != null ? artistid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artists))
        {
            return false;
        }
        Artists other = (Artists) object;
        if ((this.artistid == null && other.artistid != null) || (this.artistid != null && !this.artistid.equals(other.artistid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.mycompany.week4.Artists[ artistid=" + artistid + " ]";
    }
    
}
