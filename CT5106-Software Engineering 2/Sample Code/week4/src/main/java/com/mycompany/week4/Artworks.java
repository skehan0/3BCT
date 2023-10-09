/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week4;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author o_molloy
 */
@Entity
@Table(name = "artworks")
@NamedQueries(
{
    @NamedQuery(name = "Artworks.findAll", query = "SELECT a FROM Artworks a"),
    @NamedQuery(name = "Artworks.findByArtworkid", query = "SELECT a FROM Artworks a WHERE a.artworkid = :artworkid"),
    @NamedQuery(name = "Artworks.findByCategory", query = "SELECT a FROM Artworks a WHERE a.category = :category"),
    @NamedQuery(name = "Artworks.findByTitle", query = "SELECT a FROM Artworks a WHERE a.title = :title"),
    @NamedQuery(name = "Artworks.findByMedium", query = "SELECT a FROM Artworks a WHERE a.medium = :medium"),
    @NamedQuery(name = "Artworks.findByImage", query = "SELECT a FROM Artworks a WHERE a.image = :image"),
    @NamedQuery(name = "Artworks.findByValuation", query = "SELECT a FROM Artworks a WHERE a.valuation = :valuation")
})
public class Artworks implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "artworkid")
    private Integer artworkid;
    @Column(name = "category")
    private String category;
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "medium")
    private String medium;
    @Column(name = "image")
    private String image;
    @Lob
    @Column(name = "notes")
    private String notes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valuation")
    private Double valuation;
    @JoinColumn(name = "artistid", referencedColumnName = "artistid")
    @ManyToOne
    private Artists artistid;

    public Artworks()
    {
    }

    public Artworks(Integer artworkid)
    {
        this.artworkid = artworkid;
    }

    public Integer getArtworkid()
    {
        return artworkid;
    }

    public void setArtworkid(Integer artworkid)
    {
        this.artworkid = artworkid;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getMedium()
    {
        return medium;
    }

    public void setMedium(String medium)
    {
        this.medium = medium;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public String getNotes()
    {
        return notes;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    public Double getValuation()
    {
        return valuation;
    }

    public void setValuation(Double valuation)
    {
        this.valuation = valuation;
    }

    public Artists getArtistid()
    {
        return artistid;
    }

    public void setArtistid(Artists artistid)
    {
        this.artistid = artistid;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (artworkid != null ? artworkid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artworks))
        {
            return false;
        }
        Artworks other = (Artworks) object;
        if ((this.artworkid == null && other.artworkid != null) || (this.artworkid != null && !this.artworkid.equals(other.artworkid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.mycompany.week4.Artworks[ artworkid=" + artworkid + " ]";
    }
    
}
