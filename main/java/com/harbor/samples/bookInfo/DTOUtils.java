package com.harbor.samples.bookInfo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harbor.samples.bookInfo.models.Book;
import com.harbor.samples.bookInfo.models.BookDTO;
import com.harbor.samples.bookInfo.models.Review;
import com.harbor.samples.bookInfo.models.ReviewDTO;
import com.harbor.samples.bookInfo.models.User;
import com.harbor.samples.bookInfo.models.UserDTO;

@Service
public class DTOUtils {

	@Autowired
	private ModelMapper modelMapper;

	public Book convertToBook(BookDTO bookDTO) {
		Book book = modelMapper.map(bookDTO, Book.class);
		return book;
	}

	public User convertToUser(UserDTO userDTO) {
		User user = modelMapper.map(userDTO, User.class);
		return user;
	}

	public Review convertToReview(ReviewDTO reviewDTO) {
		Review review = modelMapper.map(reviewDTO, Review.class);
		return review;
	}

	public BookDTO convertToBookDTO(Book book) {
		BookDTO bookDto = modelMapper.map(book, BookDTO.class);
		return bookDto;
	}

	public UserDTO convertToUserDTO(User user) {
		UserDTO userDto = modelMapper.map(user, UserDTO.class);
		return userDto;
	}

	public ReviewDTO convertToReviewDTO(Review review) {
		ReviewDTO reviewDto = modelMapper.map(review, ReviewDTO.class);
		return reviewDto;
	}

}
