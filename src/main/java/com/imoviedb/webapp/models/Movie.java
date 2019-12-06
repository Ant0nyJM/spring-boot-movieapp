package com.imoviedb.webapp.models;


import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="movieapp_motionpicture")
public class Movie{




//    @GeneratedValue(generator = "movie_id_generator")
//    @SequenceGenerator(
//            name = "movid_id_generator",
//            sequenceName = "movie_sequence",
//            initialValue = 400
//    )
    @Id
    @Column(name="movie_id")
    private String id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="release_date")
    private Date release_date;

    public String getId() { return id;  }

    public void setId(String id) {
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
