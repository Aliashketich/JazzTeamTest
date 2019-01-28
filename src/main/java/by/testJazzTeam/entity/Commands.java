package by.testJazzTeam.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@Data
@ToString(of = {"id","target","type","status"})
@EqualsAndHashCode(of = "id")
public class Commands {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String target;
    private String type;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private boolean status;
}
