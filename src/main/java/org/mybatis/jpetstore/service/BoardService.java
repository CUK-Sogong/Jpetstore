/*
 *    Copyright 2010-2021 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.jpetstore.service;

import java.util.List;

import org.mybatis.jpetstore.domain.Board;
import org.mybatis.jpetstore.mapper.BoardMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Class CatalogService.
 *
 * @author Eduardo Macarron
 */
@Service
public class BoardService {

    private final BoardMapper boardMapper;

    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public List<Board> getBoardList() {
        return boardMapper.getBoardList();
    }

    public List<Board> getBoardListByPage(int page) { return boardMapper.getBoardListByPage(page); };

    public Board getBoardByBnum(int boardId) { return boardMapper.getBoardByBnum(boardId);
    }
    @Transactional
    public void insertBoard(Board board) {
        boardMapper.insertBoard(board);
    }

    public Board getNewBoard(String userId) { return boardMapper.getNewBoard(userId); }

    public void deleteBoard(int boardId) { boardMapper.deleteBoard(boardId); }

    public void updateBoard(Board board) { boardMapper.updateBoard(board); }

    public Board getUpdateBoard(int boardId) { return boardMapper.getUpdateBoard(boardId); }
}