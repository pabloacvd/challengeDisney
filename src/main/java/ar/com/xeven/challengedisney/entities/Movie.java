package ar.com.xeven.challengedisney.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="movies")
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movie_id;
    private String title;
    private String image_url;
    private Integer year;
    private Integer score;
    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY)
    private List<Character> characters;
    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY)
    private List<Genre> genres;

    public Movie() {
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public Integer getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Integer idMovie) {
        this.movie_id = idMovie;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String imageURL) {
        this.image_url = imageURL;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
