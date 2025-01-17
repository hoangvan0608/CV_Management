package com.bezkoder.cv_management.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name = "departments")
public class DepEntity extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dep_id")
    private int depId;

    @Column(name = "dep_name", length = 100, unique = true)
    @NotNull
    private String depName;

    @OneToMany(mappedBy = "depEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserEntity> userEntityList;

    @OneToMany(mappedBy = "depEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TicketDepRelationEntity>  ticketDepRelationEntities;
}
