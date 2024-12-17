package org.zerock.ex00.mappers;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.ex00.domain.BoardVO;
import org.zerock.ex00.domain.Criteria;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class BoardMapperTests {

    @Autowired(required = false)
    BoardMapper boardMapper;

    @Test
    public void test1() {
        log.info(boardMapper);
    }
    @Test
    public void testList(){
        boardMapper.getList().forEach(boardVO -> log.info(boardVO));
    }

    @Test
    public void testInsert(){
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("New Test");
        boardVO.setContent("New Test...");
        boardVO.setWriter("newbie");

        log.info("Count : " + boardMapper.insert(boardVO));

        //log.info("BNO : " + boardMapper.getBno());
    }

    @Test
    public void testSelect(){
        Long bno = 9L;

        log.info(boardMapper.select(bno));
    }

    @Test
    public void testUpdate(){
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("Updated Title");
        boardVO.setContent("Updated Content");
        boardVO.setBno(9L);

        int updateCount = boardMapper.update(boardVO);

        log.info("update: " + updateCount);
    }

    @Test
    public void testPage(){
        Criteria criteria = new Criteria();
        criteria.setPageNum(2);

        List<BoardVO> list = boardMapper.getPage(criteria);

        list.forEach(boardVO -> log.info(boardVO));
    }


}
