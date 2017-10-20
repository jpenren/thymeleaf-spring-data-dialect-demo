package io.github.jpenren.demo;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
class DemoController {
	
	private final UserRepository userRepository;
	
	public DemoController(UserRepository repo) {
		this.userRepository = repo;
	}

	@GetMapping
	public String list(ModelMap model, Pageable pageable){
		model.addAttribute("page", userRepository.findAll(pageable));
		
		return "index";
	}

}
