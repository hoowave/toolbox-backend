package com.tools.toolbox.boardcategory.application.out;

import com.tools.toolbox.boardcategory.core.BoardCategory;
import com.tools.toolbox.boardcategory.core.enums.CategoryType;

import java.util.Optional;

public interface BoardCategoryRepositoryPort {

    void initialize();

    Optional<BoardCategory> findByCategoryType(CategoryType categoryType);
}
