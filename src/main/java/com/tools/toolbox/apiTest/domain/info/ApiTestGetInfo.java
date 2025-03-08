package com.tools.toolbox.apiTest.domain.info;

import com.tools.toolbox.apiTest.infrastructure.MemoryRepository;
import lombok.Getter;

@Getter
public class ApiTestGetInfo {
    private int id;
    private String name;
    private int age;
    private String gender;

    public ApiTestGetInfo(MemoryRepository.Character character) {
        this.id = character.getId();
        this.name = character.getName();
        this.age = character.getAge();
        this.gender = character.getGender();
    }
}
