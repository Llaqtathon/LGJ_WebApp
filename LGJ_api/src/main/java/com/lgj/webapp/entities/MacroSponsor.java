package com.lgj.webapp.entities;
import lombok.Data;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MacroSponsor")
public class MacroSponsor {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "sponsor_id")
    private Sponsor sponsor;
}
