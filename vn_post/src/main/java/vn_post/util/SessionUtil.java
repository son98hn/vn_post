package vn_post.util;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
	
	private static SessionUtil sessionUtil = null;
	
	public static SessionUtil getInstance() {
		if(sessionUtil == null ) {
			sessionUtil = new SessionUtil();
		}
		return sessionUtil;
	}
	
	public void putValue(HttpServletRequest request, String key, Object value) {
		 request.getSession().setAttribute(key, value);
	}
	
//	chưa biết  lấy dữ liệu ra kiểu gì nên đê object ép kiểu thành kiểu dữ liệu mong muốn
	public Object getValue(HttpServletRequest request, String key) {
		return request.getSession().getAttribute(key);
	}
	
	public void removeValue(HttpServletRequest request, String key) {
		request.getSession().removeAttribute(key);
	}
}
