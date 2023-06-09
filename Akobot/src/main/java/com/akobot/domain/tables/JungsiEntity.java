package com.akobot.domain.tables;

import lombok.*;

import jakarta.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="jungsi")
public class JungsiEntity {
    @EmbeddedId
    private PushLogPK pks;

    @Column(name="condition_text", length=1000)
    private String condition_text;

    @Column(name="point", length=1000)
    private String point;

    @Column(name="elseData", length=1000)
    private String elseData;

    @Column(name="level")
    private int level;
}
