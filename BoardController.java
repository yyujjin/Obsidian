package com.vam.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vam.model.BoardVO;
import com.vam.service.BoardService;

import lombok.extern.java.Log;


@Controller
@RequestMapping("/board/*")
@Log
public class BoardController {
	 
	
	
	@Autowired
    private BoardService bservice;
	
		@GetMapping("/list")
	    // => @RequestMapping(value="list", method=RequestMethod.GET)
	    public void boardListGET(Model model) {
	        
	        log.info("게시판 목록 페이지 진입");
	        model.addAttribute("list", bservice.getList());
	    }
	    
	    @GetMapping("/enroll")
	    // => @RequestMapping(value="enroll", method=RequestMethod.GET)
	    public void boardEnrollGET() {
	        
	        log.info("게시판 등록 페이지 진입");
	        
	    }
	    
	    /* 게시판 등록 */
	    @PostMapping("/enroll")
	    public String boardEnrollPOST(BoardVO board, RedirectAttributes rttr) {
//	        System.out.println("실행됨");
	        log.info("BoardVO : " + board);
//	        System.out.println(board);
	        bservice.enroll(board); 
	        
	        rttr.addFlashAttribute("result", "enrol success");
	        
	        return "redirect:/board/list";
	        
	    }
}
