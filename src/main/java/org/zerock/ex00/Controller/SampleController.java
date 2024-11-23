package org.zerock.ex00.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.ex00.domain.SampleDTO;
import org.zerock.ex00.domain.SampleDTOList;
import org.zerock.ex00.domain.TodoDTO;

import java.util.Arrays;

@Controller
@Log4j2
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/basic")
    public void basic(){
        log.info("basic-----------------------");
    }

    public void ex1(
            @RequestParam("name") String name,
            @RequestParam(
                    value = "age",
                    required = false,
                    defaultValue = "10") int age
    ){
        log.info("ex1----------------------");
        log.info(name);
        log.info(age);
    }

    @GetMapping("/ex1")
    public void ex1_DTO(SampleDTO sampleDTO){
        log.info("ex1_DTO----------------------");
        log.info(sampleDTO);
    }

    @GetMapping("/ex02Array")
    public String ex02Array(String[] ids){
        log.info("ex2Array----------------------");
        log.info(Arrays.toString(ids));
        return "/sample/ex2";
    }

    public void ex02Bean(SampleDTOList list){
        log.info(list);
    }

    @GetMapping("/ex03")
    public void ex03(TodoDTO todoDTO){
        log.info("===================");
        log.info(todoDTO);
    }

    public void ex04(
            @ModelAttribute("dto") SampleDTO sampleDTO,
            @ModelAttribute("page") int page,
            Model model){

        model.addAttribute("list", new String[]{"AAA","BBB","CCC"});
    }

    @GetMapping("/ex05")
    public String ex05(RedirectAttributes rttr){

        return "redirect:/sample/basic";
    }

}
