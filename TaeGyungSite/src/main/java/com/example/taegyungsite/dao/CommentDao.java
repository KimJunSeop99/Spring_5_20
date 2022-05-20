package com.example.taegyungsite.dao;

import com.example.taegyungsite.model.CommentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * packageName : com.example.taegyungsite.dao
 * fileName : CommentDao
 * author : ds
 * date : 2022-05-20
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-05-20         ds          최초 생성
 */
@Mapper
public interface CommentDao {
    int insertComment(CommentDto params); // 댓글 추가 메소드

    CommentDto selectCommentDetail(Long idx); // 댓글 상세 메소드

    int updateComment(CommentDto params); // 댓글 수정 메소드

    int deleteComment(Long idx); // 댓글 삭제 메소드

    List<CommentDto> selectCommentList(CommentDto params); // 댓글 목록 조회 메소드

    int selectCommentTotalCount(CommentDto params); // 댓글 테이블 모든 건수 조회
}
