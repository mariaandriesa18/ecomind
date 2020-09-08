package ro.utcn.project.entities;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "community")
public class Community {

    @Id
    @GeneratedValue
    private Integer community_id;

    @Column
    private String community_name;

    @Column
    private String zone;

    @Column
    private String organization_name;


    @OneToMany(mappedBy = "community")
    private List<CommunityStatistics> communityStatisticsList;

    public List<CommunityStatistics> getCommunityStatisticsList() {

        return communityStatisticsList;
    }

    public void setCommunityStatisticsList(List<CommunityStatistics> communityStatisticsList) {
        this.communityStatisticsList = communityStatisticsList;
    }

    public Community() {
    }

    public Integer getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(Integer community_id) {
        this.community_id = community_id;
    }

    public String getCommunity_name() {
        return community_name;
    }

    public void setCommunity_name(String community_name) {
        this.community_name = community_name;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getOrganization_name() {
        return organization_name;
    }

    public void setOrganization_name(String organization_name) {
        this.organization_name = organization_name;
    }
}
