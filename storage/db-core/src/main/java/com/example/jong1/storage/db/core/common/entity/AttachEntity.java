package com.example.jong1.storage.db.core.common.entity;

import com.example.jong1.core.enums.common.DataStatus;
import com.example.jong1.storage.db.core.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_ATTACH")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AttachEntity extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DataStatus status;

    @Column(nullable = false)
    private String originalFileName;

    @Column(nullable = false)
    private String savedFileName;

    @Column(nullable = false)
    private String path;

    @Column(nullable = false)
    private String extension;

}
