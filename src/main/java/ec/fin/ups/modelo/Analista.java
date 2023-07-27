package ec.fin.ups.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Analista")
public class Analista {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String especialidad;

    @OneToMany
    @JoinColumn(name="AnalistaId")
    private List<Creditos> creditos;

    public Analista() {

    }

    public Analista(int id, String especialidad, List<Creditos> creditos) {
        super();
        this.id = id;
        this.especialidad = especialidad;
        this.creditos = creditos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Creditos> getCreditos() {
        return creditos;
    }

    public void setCreditos(List<Creditos> creditos) {
        this.creditos = creditos;
    }

}
