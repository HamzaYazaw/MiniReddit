package aspire.tech.web.test.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import aspire.tech.web.test.entites.Product;
import aspire.tech.web.test.entites.User;
import aspire.tech.web.test.repositories.ProductRepository;

@Controller
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping(value="/products")
	public String getProducts(ModelMap model) {
		return "product";
	}
	
	@GetMapping(value="/products/{productId}")
	public String getProduct(@PathVariable Long productId, ModelMap model, HttpServletResponse response) throws IOException {
		Optional <Product> productOpt =  productRepository.findById(productId);
		if (productOpt.isPresent()) {
			Product product = productOpt.get();
			model.put("product", product);
		} else {
//			Product product = new Product();
//			model.put("product", product);
			
			response.sendError(HttpStatus.NOT_FOUND.value(), "Product with " + productId + " was not found!");
			return "product";
		}
		return "product";
	}
	
	@PostMapping(value="/products")
	public String createProduct(@AuthenticationPrincipal User user) {
		Product product = new Product();
		product.setPublished(false);
		product.setUser(user);
		
		product = productRepository.save(product);
		return "redirect:/products/"+product.getId();
	}
}
