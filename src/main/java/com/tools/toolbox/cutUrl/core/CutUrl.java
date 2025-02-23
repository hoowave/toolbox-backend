package com.tools.toolbox.cutUrl.core;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class CutUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "URL은 필수값입니다.")
    private String originalUrl;

    private String transUrl;

    @Builder
    public CutUrl(String originalUrl, String transUrl) {
        this.originalUrl = originalUrl;
        this.transUrl = transUrl;
    }

}
