package com.cinemaservices.cinema.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cinema")
public class Cinema {
    @Id
    @GeneratedValue(
            generator = "cinemaid-sequence"
    )
    @GenericGenerator(
            name = "cinemaid-sequence",
            parameters =@org.hibernate.annotations.Parameter(name="prefix",value="cinema"),
            strategy = "com.cinemaservices.cinema.IdGenerator.CinemaIdGenerator"

    )
    private String MovieId;
    @Column(name = "Moviename")
    private String MovieName;
    @Column(name = "AvailableSeats")
    private int AvailabeSeats;
    @Column(name = "Price")
    private float Price;

//    public String getMovieName() {
//        return MovieName;
//    }
//
//    public void setMovieName(String movieName) {
//        MovieName = movieName;
//    }
//
//    public int getAvailabeSeats() {
//        return AvailabeSeats;
//    }
//
//    public void setAvailabeSeats(int availabeSeats) {
//        AvailabeSeats = availabeSeats;
//    }
//
//    public int getPrice() {
//        return Price;
//    }
//
//    public void setPrice(int price) {
//        Price = price;
//    }
//
//    public Cinema(String movieId, String movieName, int availabeSeats, int price) {
//        MovieId = movieId;
//        MovieName = movieName;
//        AvailabeSeats = availabeSeats;
//        Price = price;
//    }
//
//    public String getMovieId() {
//        return MovieId;
//    }
//
//    public void setMovieId(String movieId) {
//        MovieId = movieId;
//    }
//
//    public Cinema() {
//    }

    @Override
    public String toString() {
        return "Cinema{" +
                "MovieId='" + MovieId + '\'' +
                ", MovieName='" + MovieName + '\'' +
                ", AvailabeSeats=" + AvailabeSeats +
                ", Price=" + Price +
                '}';
    }
}
