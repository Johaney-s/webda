package cz.muni.fi.webda.impl;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * UBV ccd photometry
 */
@Entity
@Data
public class UBVccd {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private int clusterId;
    private int starId;
    private Integer refId;
    private Double vMag;
    private Double bvMag;
    private Double ubMag;

    public UBVccd() {}

    public UBVccd(int clusterId, int starId, Integer refId, Double vMag, Double bvMag, Double ubMag) {
        this.clusterId = clusterId;
        this.starId = starId;
        this.refId = refId;
        this.vMag = vMag;
        this.bvMag = bvMag;
        this.ubMag = ubMag;
    }
}
