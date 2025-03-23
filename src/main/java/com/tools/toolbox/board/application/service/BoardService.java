package com.tools.toolbox.board.application.service;

import com.tools.toolbox.account.application.port.out.AccountRepositoryPort;
import com.tools.toolbox.account.core.Account;
import com.tools.toolbox.account.core.enums.AccountRole;
import com.tools.toolbox.board.application.port.in.BoardPort;
import com.tools.toolbox.board.application.port.out.BoardRepositoryPort;
import com.tools.toolbox.board.core.Board;
import com.tools.toolbox.board.core.command.*;
import com.tools.toolbox.board.core.enums.BoardStatus;
import com.tools.toolbox.board.core.info.BoardDetailsInfo;
import com.tools.toolbox.board.core.info.BoardListInfo;
import com.tools.toolbox.board.core.info.BoardIdInfo;
import com.tools.toolbox.boardcategory.application.out.BoardCategoryRepositoryPort;
import com.tools.toolbox.boardcategory.core.BoardCategory;
import com.tools.toolbox.boardcategory.core.enums.CategoryType;
import com.tools.toolbox.common.exception.BaseException;
import com.tools.toolbox.common.response.MessageCode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService implements BoardPort {

    private final AccountRepositoryPort accountRepositoryPort;
    private final BoardRepositoryPort boardRepositoryPort;
    private final BoardCategoryRepositoryPort boardCategoryRepositoryPort;

    @Override
    @Transactional
    public BoardListInfo readList(BoardListCmd boardListCmd) {
        Pageable pageable = PageRequest.of(boardListCmd.getPage(), 5, Sort.by(Sort.Order.desc("createdAt")));
        Page<Board> boardList = boardRepositoryPort.findAllByCategoryId(boardListCmd.getCategoryType().getValue(), pageable);
        var info = new BoardListInfo(boardList);
        return info;
    }

    @Override
    @Transactional
    public BoardDetailsInfo readDetails(BoardDetailsCmd boardDetailsCmd) {
        Board boardEntity = boardRepositoryPort.findById(boardDetailsCmd.getId())
                .orElseThrow(() -> new BaseException(MessageCode.BOARD_DETAILS_ERROR.getMessage()));
        boardEntity.increaseHit();
        var info = new BoardDetailsInfo(boardEntity);
        return info;
    }

    @Override
    @Transactional
    public BoardIdInfo create(BoardPostCmd boardPostCmd) {
        Account author = accountRepositoryPort.findByUserId(boardPostCmd.getUserId())
                .orElseThrow(() -> new BaseException(MessageCode.USER_NOT_FOUND.getMessage()));
        BoardCategory boardCategory = boardCategoryRepositoryPort.findByCategoryType(boardPostCmd.getCategory())
                .orElseThrow(() -> new BaseException(MessageCode.CATEGORY_NOT_FOUND.getMessage()));
        validateNoticePermission(boardPostCmd.getCategory(), author);
        var initCmd = boardPostCmd.toEntity(author, boardCategory);
        Board savedBoard = boardRepositoryPort.save(initCmd);
        var info = new BoardIdInfo(savedBoard);
        return info;
    }

    @Override
    @Transactional
    public BoardIdInfo modify(BoardPutCmd boardPutCmd) {
        Board boardEntity = boardRepositoryPort.findById(boardPutCmd.getId())
                .orElseThrow(() -> new BaseException(MessageCode.BOARD_DETAILS_ERROR.getMessage()));
        if (!boardEntity.isOwned(boardPutCmd.getUserId()))
            throw new BaseException(MessageCode.COMMON_FORBIDDEN.getMessage());
        boardEntity.modify(boardPutCmd);
        Board savedBoard = boardRepositoryPort.save(boardEntity);
        var info = new BoardIdInfo(savedBoard);
        return info;
    }

    @Override
    @Transactional
    public BoardIdInfo delete(BoardDeleteCmd boardDeleteCmd){
        Board boardEntity = boardRepositoryPort.findById(boardDeleteCmd.getId())
                .orElseThrow(() -> new BaseException(MessageCode.BOARD_DETAILS_ERROR.getMessage()));
        if (!boardEntity.isOwned(boardDeleteCmd.getUserId()))
            throw new BaseException(MessageCode.COMMON_FORBIDDEN.getMessage());
        boardEntity.setStatus(BoardStatus.DELETED);
        Board savedBoard = boardRepositoryPort.save(boardEntity);
        var info = new BoardIdInfo(savedBoard);
        return info;
    }

    @Override
    public void validateNoticePermission(CategoryType category, Account author) {
        if (category.equals(CategoryType.NOTICE) && !author.getRole().equals(AccountRole.ADMIN)) {
            throw new BaseException(MessageCode.COMMON_FORBIDDEN.getMessage());
        }
    }


}
