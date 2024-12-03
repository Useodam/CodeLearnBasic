package org.zerock.ex00.mappers;

import org.zerock.ex00.domain.BoardVO;

import java.util.List;

public interface BoardMapper {

    List<BoardVO> getList();

    Long insert(BoardVO board);

    BoardVO select(Long bno);

    int update(BoardVO boardVO);
}
