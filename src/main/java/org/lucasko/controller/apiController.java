package org.lucasko.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = { "/api" }, produces = "application/json; charset=utf-8")
public class apiController {

	@RequestMapping(value = { "/csrf/get" }, method = { RequestMethod.GET })
	public @ResponseBody String csrf(HttpServletRequest request, HttpServletResponse response) {

		// tutorial 1
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		// Spring Security will allow the Token to be included in this header
		// name
		response.setHeader("X-CSRF-HEADER", token.getHeaderName());
		// Spring Security will allow the token to be included in this parameter
		// name
		response.setHeader("X-CSRF-PARAM", token.getParameterName());
		// this is the value of the token to be included as either a header or
		// an HTTP parameter
		response.setHeader("X-CSRF-TOKEN", token.getToken());

		// tutorial 2
		JSONObject json = new JSONObject();
		json.put("_csrf", token.getToken());
		return json.toString() ;
	}

	@RequestMapping(value = { "/admin/list" }, method = { RequestMethod.GET })
	public @ResponseBody String admin() {

		JSONArray userList = new JSONArray();
		for (int i = 1; i <= 5; i++) {
			String user = "admin00" + i;
			userList.put(user);
		}
		String response = userList.toString();
		return response;
	}

	@RequestMapping(value = { "/user/list" }, method = RequestMethod.GET)
	public @ResponseBody String user() {

		JSONArray userList = new JSONArray();
		for (int i = 1; i <= 5; i++) {
			String user = "user00" + i;
			userList.put(user);
		}
		String response = userList.toString();
		return response;
	}

}
