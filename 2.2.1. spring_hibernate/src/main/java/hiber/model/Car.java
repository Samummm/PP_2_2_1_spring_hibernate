package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private Integer series;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private User user;

    public Car() {
    }

    public Car(String model, Integer series) {
        this.model = model;
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model= '" + model + '\'' +
                ", series= " + series +
                '}';
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}