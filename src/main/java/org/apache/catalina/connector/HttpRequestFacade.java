package org.apache.catalina.connector;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.HttpRequest;
import org.apache.catalina.session.StandardSessionFacade;

/**
 * Facade class that wraps a Catalina-internal <b>HttpRequest</b> object. All
 * methods are delegated to the wrapped request.
 *
 * @author Remy Maucherat
 * @version $Revision: 1.2 $ $Date: 2001/07/22 20:25:06 $
 */

public final class HttpRequestFacade extends RequestFacade implements HttpServletRequest {

	// ----------------------------------------------------------- Constructors

	/**
	 * Construct a wrapper for the specified request.
	 *
	 * @param request
	 *            The request to be wrapped
	 */
	public HttpRequestFacade(HttpRequest request) {
		super(request);
	}

	// --------------------------------------------- HttpServletRequest Methods

	public String getAuthType() {
		return ((HttpServletRequest) request).getAuthType();
	}

	public Cookie[] getCookies() {
		return ((HttpServletRequest) request).getCookies();
	}

	public long getDateHeader(String name) {
		return ((HttpServletRequest) request).getDateHeader(name);
	}

	public String getHeader(String name) {
		return ((HttpServletRequest) request).getHeader(name);
	}

	public Enumeration getHeaders(String name) {
		return ((HttpServletRequest) request).getHeaders(name);
	}

	public Enumeration getHeaderNames() {
		return ((HttpServletRequest) request).getHeaderNames();
	}

	public int getIntHeader(String name) {
		return ((HttpServletRequest) request).getIntHeader(name);
	}

	public String getMethod() {
		return ((HttpServletRequest) request).getMethod();
	}

	public String getPathInfo() {
		return ((HttpServletRequest) request).getPathInfo();
	}

	public String getPathTranslated() {
		return ((HttpServletRequest) request).getPathTranslated();
	}

	public String getContextPath() {
		return ((HttpServletRequest) request).getContextPath();
	}

	public String getQueryString() {
		return ((HttpServletRequest) request).getQueryString();
	}

	public String getRemoteUser() {
		return ((HttpServletRequest) request).getRemoteUser();
	}

	public boolean isUserInRole(String role) {
		return ((HttpServletRequest) request).isUserInRole(role);
	}

	public java.security.Principal getUserPrincipal() {
		return ((HttpServletRequest) request).getUserPrincipal();
	}

	public String getRequestedSessionId() {
		return ((HttpServletRequest) request).getRequestedSessionId();
	}

	public String getRequestURI() {
		return ((HttpServletRequest) request).getRequestURI();
	}

	public StringBuffer getRequestURL() {
		return ((HttpServletRequest) request).getRequestURL();
	}

	public String getServletPath() {
		return ((HttpServletRequest) request).getServletPath();
	}

	public HttpSession getSession(boolean create) {
		HttpSession session = ((HttpServletRequest) request).getSession(create);
		if (session == null)
			return null;
		else
			return new StandardSessionFacade(session);
	}

	public HttpSession getSession() {
		return getSession(true);
	}

	public boolean isRequestedSessionIdValid() {
		return ((HttpServletRequest) request).isRequestedSessionIdValid();
	}

	public boolean isRequestedSessionIdFromCookie() {
		return ((HttpServletRequest) request).isRequestedSessionIdFromCookie();
	}

	public boolean isRequestedSessionIdFromURL() {
		return ((HttpServletRequest) request).isRequestedSessionIdFromURL();
	}

	public boolean isRequestedSessionIdFromUrl() {
		return ((HttpServletRequest) request).isRequestedSessionIdFromURL();
	}

	public long getContentLengthLong() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getRemotePort() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getLocalName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLocalAddr() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getLocalPort() {
		// TODO Auto-generated method stub
		return 0;
	}

	public ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isAsyncStarted() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isAsyncSupported() {
		// TODO Auto-generated method stub
		return false;
	}

	public String changeSessionId() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		return false;
	}

	public void login(String username, String password) throws ServletException {
		// TODO Auto-generated method stub

	}

	public void logout() throws ServletException {
		// TODO Auto-generated method stub

	}
}
