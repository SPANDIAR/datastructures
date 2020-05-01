package com.spandiar.spring.cachelearnings.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spandiar.spring.cachelearnings.dao.BookRepo;
import com.spandiar.spring.cachelearnings.model.Book;



@RestController
@RequestMapping("books")
public class AppController {
	
	Logger logger = LoggerFactory.getLogger(AppController.class);
	
	@Autowired
	BookRepo bookRepo;
	
	@GetMapping("/bookdetails/{id}")
	public Book getBookNameFromId(@PathVariable("id") final String bookId) {
		
		StopWatch watch = new StopWatch(bookId);
		
		watch.start();
		Book bookDetail = bookRepo.getBookDetail(bookId);
		watch.stop();
		logger.info("BookId is " + bookId + " Time taken: " + watch.getLastTaskTimeMillis());
		return bookDetail;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/evictcache/{id}")
	public String evictCache(@PathVariable("id") final String bookId) {
		
		return bookRepo.evictCache(bookId);
	}

}
