package com.tools.toolbox.apiTest.domain;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Getter
@NoArgsConstructor
@Entity
public class ApiTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private int getData;

    @Transient
    private Map<String, Object> postData;

    private String createdAt;

    @Builder
    public ApiTest(int getData, Map<String, Object> postData) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        this.createdAt = format.format(new Date());
        this.getData = getData;
        this.postData = postData;
    }
}
