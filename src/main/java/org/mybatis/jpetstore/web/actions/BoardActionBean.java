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
package org.mybatis.jpetstore.web.actions;

import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.integration.spring.SpringBean;

import org.mybatis.jpetstore.domain.Account;
import org.mybatis.jpetstore.domain.Board;
import org.mybatis.jpetstore.service.BoardService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * The Class CatalogActionBean.
 *
 * @author Eduardo Macarron
 */
@SessionScope
public class BoardActionBean extends AbstractActionBean {

    private static final long serialVersionUID = 5849523372175050635L;

    private static final String BOARDLIST = "/WEB-INF/jsp/board/BoardList.jsp";
    private static final String BOARD = "/WEB-INF/jsp/board/Board.jsp";
    private static final String NEW_BOARD = "/WEB-INF/jsp/board/NewBoardForm.jsp";
    private static final String UPDATE = "/WEB-INF/jsp/board/updateForm.jsp";

    @SpringBean
    private transient BoardService boardService;

    private int boardId;
    private Board board;
    private List<Board> boardList;

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public List<Board> getBoardList() { return boardList; }

    public void setBoardList(List<Board> boardList) { this.boardList = boardList; }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    @DefaultHandler
    public ForwardResolution viewBoard(){
        boardList = boardService.getBoardList();
        return new ForwardResolution(BOARDLIST);
    }

    public ForwardResolution viewContent(){
        board = boardService.getBoardByBnum(boardId);
        return new ForwardResolution(BOARD);
    }

    public ForwardResolution newBoardForm(){
        return new ForwardResolution(NEW_BOARD);
    }

    public ForwardResolution newBoard(){
        HttpSession session = context.getRequest().getSession();
        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");
        Account account = accountBean.getAccount();

        if(board == null || board.getTitle() == null || board.getContent() == null || board.getTitle().length() < 1 || board.getContent().length() < 1){
            setMessage("제목 또는 내용을 입력하지 않았습니다.");
            return new ForwardResolution(NEW_BOARD);
        }
        else {
            board.setUserId(account.getUsername());

            boardService.insertBoard(board);
            board = boardService.getNewBoard(account.getUsername());
            return new ForwardResolution(BOARD);
        }
    }

    public ForwardResolution deleteBoard(){
        boardService.deleteBoard(boardId);
        boardList = boardService.getBoardList();
        return new ForwardResolution(BOARDLIST);
    }

    public ForwardResolution updateBoardForm(){
        return new ForwardResolution(UPDATE);
    }

    public ForwardResolution updateBoard(){
        if(board == null || board.getTitle() == null || board.getContent() == null || board.getTitle().length() < 1 || board.getContent().length() < 1){
            setMessage("제목 또는 내용을 입력하지 않았습니다.");
            return new ForwardResolution(UPDATE);
        }
        else {
            boardService.updateBoard(board);
            board = boardService.getUpdateBoard(boardId);
            return new ForwardResolution(BOARD);
        }
    }


}