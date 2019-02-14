package aspire.tech.web.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedditController {

	@RequestMapping(value ="/")
	public String Index() {
		return "index";
	}
}
