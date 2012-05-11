package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.almende.util.HttpUtil;

public class Test {
	public static void main (String[] args) {
		try {
			// GET request
			String url1 = "http://www.google.com";
			String resp1 = HttpUtil.get(url1);
			System.out.println("GET " + url1);
			System.out.println(resp1);
			System.out.println();
			
			// Append query parameters to url
			String url = "http://mydatabase.com/users";
			Map<String, String> params = new HashMap<String, String>();
			params.put("orderby", "name");
			params.put("limit", "10");
			params.put("query", "string with spaces & / chars");
			String fullUrl = HttpUtil.appendQueryParams(url, params);
			System.out.println("fullUrl=" + fullUrl);
			System.out.println();
			
			// Extract query parameters from url
			Map<String, String> params2 = HttpUtil.getQueryParams(fullUrl);
			for (String param : params2.keySet()) {
				System.out.println(param + ":" + params2.get(param));
			}
			System.out.println();
			
			// Extract url without query parameters
			System.out.println(HttpUtil.removeQueryParams(fullUrl));
			System.out.println();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
