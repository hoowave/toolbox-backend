package com.tools.toolbox.boardcategory.core;

import com.tools.toolbox.boardcategory.core.enums.CategoryType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class BoardCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private CategoryType category;

    public BoardCategory(CategoryType categoryType){
        this.category = categoryType;
    }

}
