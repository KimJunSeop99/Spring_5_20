package com.example.taegyungsite.service;

import com.example.taegyungsite.model.Board2Dto;
import com.example.taegyungsite.model.BoardDto;

import java.util.List;

/**
 * packageName : com.example.taegyungsite.service
 * fileName : BoardService
 * author : ds
 * date : 2022-05-18
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-18         ds          최초 생성
 */
public interface Board2Service {

//    게시판에 insert 하는 서비스
    boolean registerBoard(Board2Dto params);

//    상세 목록을 확인하는 서비스 ( Select : 1건 )
    Board2Dto getBoardDetail(Long inx);

//    게시판의 글 목록을 가져오는 서비스 ( Select : 전체 글목록 )
    public List<Board2Dto> getBoardAllList();

//    페이징 처리를 위한 서비스
    public List<Board2Dto> getBoardList(Board2Dto params);

//    게시판 글을 삭제하는 서비스 ( Update ) : delete_YN = 'Y' 수정
    public boolean deleteBoard(Long inx);
}











