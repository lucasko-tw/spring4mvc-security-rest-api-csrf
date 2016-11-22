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
	Set-Cookie: JSESSIONID=2EC4C8E47EE49DF5BBA4764EDE5B5AC0; Path=/spring4mvc-security-rest-api-csrf/
	X-CSRF-TOKEN: ffa9430d-1cd9-49b5-b36f-60c5097bf99f
	Content-Type: application/json;charset=utf-8
	Content-Length: 48
	Date: Tue, 22 Nov 2016 14:31:33 GMT

	{"_csrf":"ffa9430d-1cd9-49b5-b36f-60c5097bf99f"}

You will obtain a _cstf value, and this csrf token is just only for JSESSION this time.



### Go get data from admin API

1. set JSESSIONID
2. set _csrf


The request is:


	curl -i -X POST --cookie JSESSIONID=2EC4C8E47EE49DF5BBA4764EDE5B5AC0  -d _csrf=ffa9430d-1cd9-49b5-b36f-60c5097bf99f -d username=admin -d password=P@ssw0rd   http://localhost:8080/spring4mvc-security-rest-api-csrf/login



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
	Set-Cookie: JSESSIONID=F6FEECFB7F4BCD4DC3FE243BFD32F177; Path=/spring4mvc-security-rest-api-csrf/
	Content-Length: 65
	Date: Tue, 22 Nov 2016 14:32:21 GMT









