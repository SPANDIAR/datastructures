package com.spandiar.spring.cachelearnings.dao;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.spandiar.spring.cachelearnings.model.Book;

@Repository
public class BookRepo {

	@Cacheable("bookDetails")
	public Book getBookDetail(String bookId) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Book book = new Book(bookId, "Book Name", "Book Author");
		return book;

	}

	@CacheEvict("bookDetails")
	public String evictCache(String bookId) {
		
		return "cache evicted for " + bookId;
		
	}

}
