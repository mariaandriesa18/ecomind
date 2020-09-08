package ro.utcn.project.entities;
import javax.persistence.*;

@Entity
@Table(name = "community_statistics")
public class CommunityStatistics {

    @Id
    @GeneratedValue
    private Integer statistics_id;

    @Column
    private String household_name;

    @Column
    private String recycled_amount_per_week;

    @ManyToOne
    @JoinColumn(name = "community_id")
    private Community community;

    public CommunityStatistics() {
    }

    public Integer getStatistics_id() {
        return statistics_id;
    }

    public void setStatistics_id(Integer statistics_id) {
        this.statistics_id = statistics_id;
    }

    public String getHousehold_name() {
        return household_name;
    }

    public void setHousehold_name(String household_name) {
        this.household_name = household_name;
    }

    public String getAmount_recycled_per_week() {
        return recycled_amount_per_week;
    }

    public void setAmount_recycled_per_week(String amount_recycled_per_week) {
        this.recycled_amount_per_week = amount_recycled_per_week;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }
}

