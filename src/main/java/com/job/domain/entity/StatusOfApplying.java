package com.job.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity(name = "status_of_applying")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StatusOfApplying {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rn_id", nullable = false)
    private RecruitmentNotice recruitmentNotice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", nullable = false)
    private Users users;

    public StatusOfApplying(RecruitmentNotice recruitmentNotice, Users users) {
        this.recruitmentNotice = recruitmentNotice;
        this.users = users;
    }
}
