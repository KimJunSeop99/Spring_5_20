package com.example.taegyungsite.service;

import com.example.taegyungsite.dao.Board2Dao;
import com.example.taegyungsite.dao.BoardDao;
import com.example.taegyungsite.model.Board2Dto;
import com.example.taegyungsite.model.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * packageName : com.example.taegyungsite.service
 * fileName : BoardServiceImpl
 * author : ds
 * date : 2022-05-18
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-18         ds          최초 생성
 */
// @Service : 스프링에 객체로 생성되는 어노테이션
@Service
public class Board2ServiceImpl implements Board2Service {

//   @Autowired : 아래 멤버변수에 스프링객체가 들어감
    @Autowired
    private Board2Dao board2Dao; // 객체 정의 ( 스프링객체 )

//    게시판에 Idx(글번호)가 없으면 insert 문 실행 (사용자가 새글쓰기 버튼을 클릭 )
//    글번호가 있으면 update문 실행( 사용자가 글목록 버튼을 클릭 + 수정버튼 클릭 )
    @Override
    public boolean registerBoard(Board2Dto params) {

//        insert 또는 update 결과를 저장하는 변수
//        위의 sql문이 정상수행되면 : 1 아니면 다른 값
        int queryResult = 0;

        System.out.println(" Service params : " + params);
        if(params.getIdx() == null) {
//            새글 쓰기 ( insert 문 실행 )
            System.out.println(" Service params 2 : " + params);
            queryResult = board2Dao.insertBoard(params);
        } else {
//            상세 목록에서 글 수정 ( update 문 실행 )
            queryResult = board2Dao.updateBoard(params);
        }

        return (queryResult == 1) ? true : false;
    }

    @Override
    public Board2Dto getBoardDetail(Long idx) {
//        글번호(idx)에 해당하는 상세 목록 보기 ( select 문 실행 : 1건 )
        return board2Dao.selectBoardDetail(idx);
    }

//    전체 게시물 select 하는 서비스
    @Override
    public List<Board2Dto> getBoardAllList() {
        List<Board2Dto> boardList = Collections.emptyList();

//        select( 전체 게시물 ) 문 실행
        boardList = board2Dao.selectBoardAllList();

        return boardList;
    }

//    게시판 번호를 받아서 게시물을 삭제하는 서비스
    @Override
    public boolean deleteBoard(Long idx) {

        int queryResult = 0;

//        게시물이 있는지 확인 하는 절차 ( Select : 1건 )
//        게시물이 있으면 board != null
        Board2Dto board = board2Dao.selectBoardDetail(idx);

//        Delete_Yn : "N" 일때만 + board != null 아닐때 삭제를 진행
        if(board != null && "N".equals(board.getDeleteYn())) {
//            게시물 삭제 서비스 ( 하지만 내부적으로 진짜 삭제는 안함 )
            queryResult = board2Dao.deleteBoard(idx);
        }

        return (queryResult == 1) ? true : false;
    }

//    게시판 페이징 처리를 위한 서비스 구현
    @Override
    public List<Board2Dto> getBoardList(Board2Dto params) {
        List<Board2Dto> board2Dto = Collections.emptyList();

//        DB params에 해당하는 데이터가 있는지 먼저 확인
        int boardTotalCount = board2Dao.selectBoardTotalCount(params);

        if( boardTotalCount > 0 ) {
//            페이징 처리 서비스 호출
            board2Dto = board2Dao.selectBoardList(params);
        }

        return board2Dto;
    }
}









