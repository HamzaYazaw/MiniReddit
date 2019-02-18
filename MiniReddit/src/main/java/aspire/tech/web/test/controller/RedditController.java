package aspire.tech.web.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedditController {

	@GetMapping(value ="/")
	public String indexPage() {
		return "index";
	}
}
