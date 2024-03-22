package com.testing.fonoapi.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "REQUIREMENT_TYPE")
@Getter
@NoArgsConstructor
public class ReqType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REQ_TYPE_ID")
    private Long reqTypeId;

    @Column(name = "NAME", nullable = false)
    private String name;
}
