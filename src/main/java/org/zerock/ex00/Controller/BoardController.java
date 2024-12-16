package org.zerock.ex00.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.ex00.domain.BoardVO;
import org.zerock.ex00.service.BoardService;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    //list 1번째 개발
    @GetMapping("/list")
    public void list(Model model){
        log.info("list----------------->");

        List<BoardVO> list = boardService.list();

        log.info(list);

        model.addAttribute("list", list);
    }

//    @GetMapping("/read/{bno}")
//    public String read(@PathVariable(name = "bno") Long bno, Model model){
//        log.info("bno : " + bno);
//        BoardVO boardVO = boardService.get(bno);
//        model.addAttribute("board", boardVO);
//        return "/board/read";
//    }
//
//    @GetMapping("/modify/{bno}")
//    public String modify(@PathVariable(name = "bno") Long bno, Model model){
//        log.info("bno : " + bno);
//        BoardVO boardVO = boardService.get(bno);
//        model.addAttribute("board", boardVO);
//        return "/board/modify";
//    }

    @GetMapping({"/{job}/{bno}", "/{job}/{bno}"})
    public String read(
            @PathVariable(name = "job") String job,
            @PathVariable(name = "bno") Long bno, Model model){

        log.info("bno : " + bno);
        log.info("job : " + job);

        if(!(job.equals("read") || job.equals("modify"))){
            throw new RuntimeException("BadRequest job");
        }

        BoardVO boardVO = boardService.get(bno);
        model.addAttribute("vo", boardVO);
        return "/board/"+job;
    }

    @GetMapping("/register")
    public void register(){
    }

    @PostMapping("/register")
    public String registerPoster(BoardVO boardVO, RedirectAttributes rttr){

        log.info("boardVo : " + boardVO);
        rttr.addFlashAttribute("Result", 123L);

        return "redirect:/board/list";
    }

    @PostMapping("/remove/{bno")
    public String remove(
            @PathVariable(name = "bno") Long bno,
            RedirectAttributes rttr){

        BoardVO boardVO = new BoardVO();
        boardVO.setBno(bno);
        boardVO.setTitle("해당 글은 삭제되었습니다");
        boardVO.setContent("해당 글은 삭제되었습니다");
        boardVO.setWriter("unknown");

        boardService.modify(boardVO);

        rttr.addFlashAttribute("result", boardVO.getBno());

        return "redirect:/board/list";
    }

    @PostMapping("/modify/{bno")
    public String modify(
            @PathVariable(name = "bno") Long bno,
            BoardVO boardVO){

        boardVO.setBno(bno);

        boardService.modify(boardVO);


        return "redirect:/board/read/" + bno;
    }

}
