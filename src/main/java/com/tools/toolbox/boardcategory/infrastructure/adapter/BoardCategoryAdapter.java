package com.tools.toolbox.boardcategory.infrastructure.adapter;

import com.tools.toolbox.board.core.Board;
import com.tools.toolbox.boardcategory.application.out.BoardCategoryRepositoryPort;
import com.tools.toolbox.boardcategory.core.BoardCategory;
import com.tools.toolbox.boardcategory.core.enums.CategoryType;
import com.tools.toolbox.boardcategory.infrastructure.repository.BoardCategoryJpaRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BoardCategoryAdapter implements BoardCategoryRepositoryPort {

    private final BoardCategoryJpaRepository boardCategoryRepository;

    @Override
    @PostConstruct
    @Transactional
    public void initialize() {
        for (CategoryType categoryType : CategoryType.values()) {
            if (!boardCategoryRepository.existsByCategory(categoryType)) {
                var entity = new BoardCategory(categoryType);
                boardCategoryRepository.save(entity);
            }
        }
    }

    @Override
    public Optional<BoardCategory> findByCategoryType(CategoryType categoryType) {
        Optional<BoardCategory> existBoardCategory = boardCategoryRepository.findByCategory(categoryType);
        return existBoardCategory;
    }
}
