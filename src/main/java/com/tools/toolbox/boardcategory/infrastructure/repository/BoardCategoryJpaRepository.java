package com.tools.toolbox.boardcategory.infrastructure.repository;

import com.tools.toolbox.boardcategory.core.BoardCategory;
import com.tools.toolbox.boardcategory.core.enums.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardCategoryJpaRepository extends JpaRepository<BoardCategory, Long> {
    boolean existsByCategory(CategoryType categoryType);
}
