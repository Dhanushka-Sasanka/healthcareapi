package com.healthcare.healthcareapi.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "disease")
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diseaseID;
    private String diseaseName;
    private String diseaseDescription;

    @OneToMany(mappedBy = "disease", cascade = {CascadeType.ALL})
    @JsonIgnore
    private List<Treatment> treatmentList;

}
