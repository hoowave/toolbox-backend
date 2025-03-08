package com.tools.toolbox.apiTest.infrastructure;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryRepository {

    @Getter
    @AllArgsConstructor
    public static class Character {
        private int id;
        private String name;
        private int age;
        private String gender;
    }

    private List<Character> characterList;

    @PostConstruct
    public void init() {
        characterList = new ArrayList<>();
        characterList.add(new MemoryRepository.Character(1, "bbororo", 20, "male"));
        characterList.add(new MemoryRepository.Character(2, "charmander", 15, "male"));
        characterList.add(new MemoryRepository.Character(3, "pikachu", 10, "female"));
        characterList.add(new MemoryRepository.Character(4, "bulbasaur", 12, "male"));
        characterList.add(new MemoryRepository.Character(5, "squirtle", 18, "female"));
        characterList.add(new MemoryRepository.Character(6, "jigglypuff", 22, "female"));
        characterList.add(new MemoryRepository.Character(7, "eevee", 16, "female"));
        characterList.add(new MemoryRepository.Character(8, "mewtwo", 25, "male"));
        characterList.add(new MemoryRepository.Character(9, "snorlax", 30, "male"));
        characterList.add(new MemoryRepository.Character(10, "loopy", 11, "female"));
    }

    public MemoryRepository.Character getCharacterById(int id) {
        return characterList.stream()
                .filter(character -> character.getId() == id)
                .findFirst()
                .orElse(null);
    }

}