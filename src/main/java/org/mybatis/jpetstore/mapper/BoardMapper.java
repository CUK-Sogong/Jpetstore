package org.mybatis.jpetstore.mapper;

import org.mybatis.jpetstore.domain.Board;

import java.util.List;

public interface BoardMapper {
    List<Board> getBoardList();

    List<Board> getBoardListByPage(int page);

    Board getBoardByBnum(int boardId);

    void insertBoard(Board board);

    Board getNewBoard(String userId);

    void deleteBoard(int boardId);

    void updateBoard(Board board);

    Board getUpdateBoard(int boardId);
}