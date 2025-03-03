package com.tools.toolbox.cutUrl.core;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class CutUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Pattern(regexp = "^(https?://|www\\.)[\\w.-]+(?:\\.[\\w.-]+)+[/\\w\\-._~:/?#\\[\\]@!$&'()*+,;=]*$")
    @Column(nullable = false, unique = true)
    private String originalUrl;

    @Column(nullable = false, unique = true)
    private String uuid;

    private String createAt;

    @Builder
    public CutUrl(String originalUrl, String uuid) {
        SimpleDateFormat format = new SimpleDateFormat("YYYYMMddHHmmss");
        this.originalUrl = originalUrl;
        this.uuid = uuid;
        this.createAt = format.format(new Date());
    }

}
