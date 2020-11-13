package com.dkstudio.happyhomerepair.model.entity;

import com.dkstudio.happyhomerepair.model.enums.EstimateLocalState;
import com.dkstudio.happyhomerepair.model.enums.EstimateState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Estimate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Boolean agreement;

    @NotNull
    private EstimateLocalState locate;

    @NotNull
    private EstimateState type;

    private String detail;

    @NotNull
    private String phoneNumber;

    @NotNull
    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    private Long fileId;
}
