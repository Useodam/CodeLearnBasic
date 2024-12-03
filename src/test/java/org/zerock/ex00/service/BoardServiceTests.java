package org.zerock.ex00.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.ex00.domain.BoardVO;
import org.zerock.ex00.mappers.BoardMapper;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class BoardServiceTests {

    @Autowired
    BoardService boardService;
    private BoardMapper boardMapper;

    @Test
    public void testList(){
       log.info(boardService.list());
    }

    public BoardVO get(Long bno){
        return boardMapper.select(bno);
    }

    public boolean modify(BoardVO boardVO){
        return boardMapper.update(boardVO) == 1;
    }

    public boolean remove(Long bno){
        return true;
    }
}
