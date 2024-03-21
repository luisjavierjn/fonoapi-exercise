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
@Table(name = "DEVICES")
@Getter
@NoArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String deviceName;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "technology")
    private String technology;

    @Column(name = "_2g_bands")
    private String _2g_bands;

    @Column(name = "_3g_bands")
    private String _3g_bands;

    @Column(name = "_4g_bands")
    private String _4g_bands;
}
