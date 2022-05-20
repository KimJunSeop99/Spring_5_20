package com.example.taegyungsite.service;

import com.example.taegyungsite.model.CommentDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.taegyungsite.service
 * fileName : CommentService
 * author : ds
 * date : 2022-05-20
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-05-20         ds          최초 생성
 */
public interface CommentService{
    // 댓글 등록 서비스
    public boolean registerComment(CommentDto params);

    // 댓글 삭제 서비스
    public boolean deleteComment(Long idx);

    // 댓글 목록 조회 서비스 ( 여러건 select )
    public List<CommentDto> getCommentList(CommentDto params);

    // 댓글 상세 조회 서비스 ( 1건 select )
    public CommentDto getCommentDetail(Long idx);
}
