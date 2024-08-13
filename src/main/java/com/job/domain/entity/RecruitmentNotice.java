package com.job.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;

@Entity(name = "recruitment_notice")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class RecruitmentNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Column(nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String position;

    @Column(nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer compensation;

    @Column(nullable = false, columnDefinition = "text")
    private String contents;

    @Column(nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String skill;

    @Column(name = "created_at", columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "timestamp on update current_timestamp")
    private LocalDateTime updatedAt;
}
