package ro.utcn.project.entities;
import javax.persistence.*;

@Entity
@Table(name = "recycling_information")
public class RecyclingInformation {

    @Id
    @GeneratedValue
    private Integer info_id;

    @Column
    private String type;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public RecyclingInformation() {
    }

    public Integer getInfo_id() {

        return info_id;
    }

    public void setInfo_id(Integer info_id) {
        this.info_id = info_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
