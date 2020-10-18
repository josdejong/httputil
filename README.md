httputil
========

Easily perform HTTP requests in Java

HttpUtil is a single class containing methods to conveniently perform HTTP 
requests. HttpUtil only uses regular java io and net functionality and does 
not depend on external libraries. 
The class contains methods to perform a get, post, put, and delete request,
and supports posting forms. Optionally, one can provide headers.

## Usage

Insert the class [HttpUtil.java](https://raw.github.com/josdejong/httputil/master/src/com/almende/util/HttpUtil.java) in your project.

Next, the HttpUtil methods can called statically. An GET request looks like:

    String res = HttpUtil.get("http://www.google.com");

## Examples

    // GET
    String res = HttpUtil.get("http://www.google.com");
    
    // POST
    String res = HttpUtil.post("http://sendmedata.com", "This is the data");
    
    //POST JSON
    String json = "{\"firstname\":\"Joe\",\"lastname\":\"Smith\",\"age\":\"28\"}";
    String res = HttpUtil.postJson("http://sendmedata.com", json);
    
    // POST FORM
    Map<String, String> params = new HashMap<String, String>();
    params.put("firstname", "Joe");
    params.put("lastname", "Smith");
    params.put("age", "28");
    String res = HttpUtil.postForm("http://site.com/newuser", params);
    
    // append query parameters to url
    String url = "http://mydatabase.com/users";
    Map<String, String> params = new HashMap<String, String>();
    params.put("orderby", "name");
    params.put("limit", "10");
    String fullUrl = HttpUtil.appendQueryParams(url, params);
    // fullUrl = "http://mydatabase.com/user?orderby=name&limit=10"

## API

HttpUtil contains the following static methods:

    String get(String url)
    String get(String url, Map<String, String> headers)
    
    String post(String url, String body)
    String post(String url, String body, Map<String, String> headers)
    
    String postJson(String url, String jsonStr)
    
    String postForm(String url, Map<String, String> params)
    String postForm(String url, Map<String, String> params, Map<String, String> headers)
    
    String put(String url, String body)
    String put(String url, String body, Map<String, String> headers)
    
    String delete(String url)
    String delete(String url, Map<String, String> headers)
        
    fetch(String method, String url, String body,	Map<String, String> headers)
    
    String appendQueryParams(String url, Map<String, String> params)
    String removeQueryParams(String url)
    Map<String, String> getQueryParams(String url)
