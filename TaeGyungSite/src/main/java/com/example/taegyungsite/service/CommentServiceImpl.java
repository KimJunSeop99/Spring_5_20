package com.example.taegyungsite.service;

import com.example.taegyungsite.dao.CommentDao;
import com.example.taegyungsite.model.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * packageName : com.example.taegyungsite.service
 * fileName : CommentServiceImpl
 * author : ds
 * date : 2022-05-20
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-05-20         ds          최초 생성
 */
@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentDao commentDao; // 객체 정의 (null > 스프링 객체)

    @Override
    public boolean registerComment(CommentDto params) {
        int queryResult = 0;
        // 댓글 새 글쓰기 : idx(댓글번호)가 null 새 글쓰기가 됨
        if (params.getIdx() == null) {
            queryResult = commentDao.insertComment(params);
        } else {
            // idx(댓글번호)가 null이 아니라면 현재 등록된 댓글을 수정
            queryResult = commentDao.updateComment(params);
        }
        return (queryResult == 1) ? true : false;
    }
    // 댓글 삭제 서비스 구현
    @Override
    public boolean deleteComment(Long idx) {
        int queryResult = 0;

        // TB_COMMENT 테이블에 idx(댓글번호) 데이터가 있는지 확인
        CommentDto comment = commentDao.selectCommentDetail(idx);
        // comment에 null이 아니면 댓글번호가 있음 + Delete_YN = 'N' 데이터만 삭제진행
        if ( comment != null && "N".equals(comment.getDeleteYn())) {
            queryResult = commentDao.deleteComment(idx);
        }
        // queryResult는 sql문이 정상수행되면 1, 아니면 1이 아닌값
        return (queryResult == 1) ? true : false;
    }

    @Override
    public List<CommentDto> getCommentList(CommentDto params) {
        List<CommentDto> commentList = Collections.emptyList(); // 빈값으로 초기화

        // 댓글 테이블에 데이터가 있는지 없는지 먼저 확인
        // 조건 : 게시물번호가 있어야 댓글이 존재함
        // 참조무결성 체크
        int commentTotalCount = commentDao.selectCommentTotalCount(params);

        if (commentTotalCount > 0) {
            commentList = commentDao.selectCommentList(params);
        }
        return commentList;
    }

    // 댓글 상세조회 서비스 구현
    @Override
    public CommentDto getCommentDetail(Long idx) {

        CommentDto commentDto = commentDao.selectCommentDetail(idx);

        return commentDto;
    }
}
