package com.imoviedb.webapp.models;


import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Movie implements Serializable {



    @Id
    @GeneratedValue(generator = "movie_id_generator")
    @SequenceGenerator(
            name = "movid_id_generator",
            sequenceName = "movie_sequence",
            initialValue = 400
    )
    private int id;
    private String name;
    private String description;
    private Date release_date;

    public int getId() { return id;  }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
