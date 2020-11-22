package com.dkstudio.happyhomerepair.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"adminUser"})
@EntityListeners(AuditingEntityListener.class)
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    private String title;

    @NotNull
    private String thumbnailImageUrl;

    @NotNull
    private String targetUrl;

    @NotNull
    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    // private Long adminUserId;
    @ManyToOne
    private AdminUser adminUser;
}
