package com.testing.fonoapi.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "INVENTORY")
@Getter
@NoArgsConstructor
public class Inventory {

    @Id
    @Column(name = "DEVICE_ID")
    private Long deviceId;

    @OneToOne
    @JoinColumn(name = "DEVICE_ID", nullable = false)
    private Device device;

    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;
}
