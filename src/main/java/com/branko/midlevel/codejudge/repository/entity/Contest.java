package com.branko.midlevel.codejudge.repository.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "contests")
public class Contest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 5000)
    private String description;

    private Date startTime;

    private Date endTime;

    private String status;

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private User creator;
}