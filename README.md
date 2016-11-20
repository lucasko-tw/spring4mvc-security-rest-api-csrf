Spring Security - Front-end + Back-end with CSRF
----------------

### Tutorial of Front-end + Back-end By Spring Security


[Spring Security : Front-end + Back-end](https://github.com/lucasko-tw/spring4mvc-security-rest-api)


### Enable csrf configuration

```XML
		<security:csrf />
```


### Generate csrf token from back-end API

```JAVA
@RequestMapping(value = { "/csrf/get" }, method = { RequestMethod.GET })

public @ResponseBody String csrf(HttpServletRequest request, HttpServletResponse response) {


	CsrfToken token = (CsrfToken) request.getAttribute("_csrf");	

	JSONObject json = new JSONObject();

	json.put("_csrf", token.getToken());

	return json.toString() ;

}

```

### To call API for getting csrf token

The request is:

	curl -i  http://localhost:8080/spring4mvc-security-rest-api-csrf/api/csrf/get



The response is:

	HTTP/1.1 200 OK
	Server: Apache-Coyote/1.1
	Access-Control-Allow-Origin: http://localhost:8080
	Access-Control-Allow-Methods: GET, POST, PUT, DELETE
	Access-Control-Allow-Headers: Authorization
	Access-Control-Max-Age: 1800
	Access-Control-Allow-Credentials: true
	Cache-Control: no-cache, no-store, max-age=0, must-revalidate
	Pragma: no-cache
	Expires: 0
	X-XSS-Protection: 1; mode=block
	X-Frame-Options: DENY
	X-Content-Type-Options: nosniff
	X-CSRF-HEADER: X-CSRF-TOKEN
	X-CSRF-PARAM: _csrf
	Set-Cookie: JSESSIONID=E528551A3AB8C58450BD54EA9D108275; Path=/spring4mvc-security-rest-api-csrf/
	X-CSRF-TOKEN: 5b3ea412-ca7c-4150-a4c3-88d6f6abdbfa
	Content-Type: application/json;charset=utf-8
	Content-Length: 48
	Date: Sun, 20 Nov 2016 08:19:52 GMT

	{"_csrf":"5b3ea412-ca7c-4150-a4c3-88d6f6abdbfa"}


Finally, you can call post api with _csrf token.

	



