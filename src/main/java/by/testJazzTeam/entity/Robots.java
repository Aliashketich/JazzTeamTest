package by.testJazzTeam.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@Data
@ToString(of = {"id","name","type","status"})
@EqualsAndHashCode(of = "id")
public class Robots {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String type;
    private String status;
}
