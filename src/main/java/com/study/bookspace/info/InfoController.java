package com.study.bookspace.info;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/info")
public class InfoController {
	
	@GetMapping("/libraryIntro")
	public String libraryIntro() {
		return "content/info/library_intro";
	}

}
