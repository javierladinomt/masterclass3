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
@Table(name = "client")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
    @Column(length = 250, nullable = false, unique = true)
    private String email;
    @Column(length = 45)
    private String password;
    @Column(length = 45)
    private String name;
    private Integer age;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties({"client"})
    public List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties({"client"})
    public List<Reservation> reservations;
}
