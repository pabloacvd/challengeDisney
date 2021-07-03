package ar.com.xeven.challengedisney.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="characters")
public class Character {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer character_id;
    @Column(nullable = false)
    private String name;
    private String image_url;
    private Integer age;
    private Integer weight;
    private String story;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "characters_x_movies",
        joinColumns = @JoinColumn(name="character_id"),
        inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Movie> movies;

    public Character() {
    }

    public boolean estoyBienFormado(){
        return (name!=null && age!=null && image_url!=null && story!=null && weight!=null);
    }

    public Character(String name, String image_url, Integer age, Integer weight, String story) {
        this.name = name;
        this.image_url = image_url;
        this.age = age;
        this.weight = weight;
        this.story = story;
    }

    public Character(Integer character_id, String name, String image_url, Integer age, Integer weight, String story, List<Movie> movies) {
        this.character_id = character_id;
        this.name = name;
        this.image_url = image_url;
        this.age = age;
        this.weight = weight;
        this.story = story;
        this.movies = movies;
    }

    public Integer getCharacter_id() {
        return character_id;
    }

    public void setCharacter_id(Integer id) {
        this.character_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String imageURL) {
        this.image_url = imageURL;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Character{" +
                "character_id=" + character_id +
                ", name='" + name + '\'' +
                ", image_url='" + image_url + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", story='" + story + '\'' +
                '}';
    }
}
