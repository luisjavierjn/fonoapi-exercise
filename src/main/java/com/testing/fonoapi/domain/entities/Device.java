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
    @Column(name = "DEVICE_ID")
    private Long device_id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "BRAND", nullable = false)
    private String brand;

    @Column(name = "TECHNOLOGY", nullable = false)
    private String technology;

    @Column(name = "_2G_BANDS", nullable = false)
    private String _2g_bands;

    @Column(name = "_3G_BANDS", nullable = false)
    private String _3g_bands;

    @Column(name = "_4G_BANDS", nullable = false, length = 512)
    private String _4g_bands;
}
