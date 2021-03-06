package com.denlaku.boot.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.denlaku.boot.base.BaseController;
import com.denlaku.boot.base.Response;
import com.denlaku.boot.base.service.UserService;
import com.denlaku.boot.base.vo.UserVO;

@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@GetMapping("/findById/{id}")
	public Response<UserVO> findById(@PathVariable("id") Long id) {
		UserVO user = null;
		try {
			user = userService.findById(id);
		} catch (Exception e) {
			String message = e.getMessage();
			logger.error(message);
			return error(message);
		}
		return success(user);
	}
}
