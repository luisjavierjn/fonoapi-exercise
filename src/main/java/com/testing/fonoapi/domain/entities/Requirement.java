package com.testing.fonoapi.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "REQUIREMENT")
@Getter
@NoArgsConstructor
public class Requirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REQ_ID")
    private Long reqId;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "DEVICE_ID", nullable = false)
    private Device device;

    @ManyToOne
    @JoinColumn(name = "REQ_TYPE_ID", nullable = false)
    private ReqType reqType;

    @Column(name = "AVAILABILITY", nullable = false)
    private Boolean availability;

    @Column(name = "DATETIME", nullable = false)
    private LocalDateTime dateTime;
}
