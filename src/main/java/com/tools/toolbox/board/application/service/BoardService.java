package com.tools.toolbox.board.application.service;

import com.tools.toolbox.account.application.port.out.AccountRepositoryPort;
import com.tools.toolbox.account.core.Account;
import com.tools.toolbox.account.core.enums.AccountRole;
import com.tools.toolbox.board.application.port.in.BoardPort;
import com.tools.toolbox.board.application.port.out.BoardRepositoryPort;
import com.tools.toolbox.board.core.Board;
import com.tools.toolbox.board.core.command.BoardDetailsCmd;
import com.tools.toolbox.board.core.command.BoardListCmd;
import com.tools.toolbox.board.core.command.BoardPostCmd;
import com.tools.toolbox.board.core.info.BoardDetailsInfo;
import com.tools.toolbox.board.core.info.BoardListInfo;
import com.tools.toolbox.board.core.info.BoardPostInfo;
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

import java.util.Optional;

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
        Optional<Board> existBoard = boardRepositoryPort.findById(boardDetailsCmd.getId());
        if (existBoard.isEmpty()) throw new BaseException(MessageCode.BOARD_DETAILS_ERROR.getMessage());
        var info = new BoardDetailsInfo(existBoard.get());
        return info;
    }

    @Override
    @Transactional
    public BoardPostInfo create(BoardPostCmd boardPostCmd) {
        Optional<Account> author = accountRepositoryPort.findByUserId(boardPostCmd.getUserId());
        Optional<BoardCategory> boardCategory = boardCategoryRepositoryPort.findByCategoryType(boardPostCmd.getCategory());
        if (boardPostCmd.getCategory().equals(CategoryType.NOTICE) && !author.get().getRole().equals(AccountRole.ADMIN)) {
            throw new BaseException(MessageCode.COMMON_FORBIDDEN.getMessage());
        }
        var initCmd = boardPostCmd.toEntity(author.get(), boardCategory.get());
        Board savedBoard = boardRepositoryPort.save(initCmd);
        var info = new BoardPostInfo(savedBoard);
        return info;
    }
}
