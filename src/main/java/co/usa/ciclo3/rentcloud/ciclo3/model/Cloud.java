package co.usa.ciclo3.rentcloud.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author JALP
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cloud")
public class Cloud implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String brand;
    private Integer year;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name="categoryId")
    @JsonIgnoreProperties("clouds")
    private Category category;
    /**
     *
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cloud")
    @JsonIgnoreProperties({"cloud","client"})
    private List<Message> messages;
    /**
     *
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "cloud")
    @JsonIgnoreProperties({"cloud","messages"})
    public List<Reservation> reservations;
}
