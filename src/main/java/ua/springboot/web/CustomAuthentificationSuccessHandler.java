package ua.springboot.web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.Getter;
import lombok.Setter;

@Configuration
@Getter @Setter
public class CustomAuthentificationSuccessHandler 
        implements AuthenticationSuccessHandler {

	private final String ADMIN_PAGE = "/admin/board";
	private final String USER_PAGE = "/visitor/profile";
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest reguest, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		handle(reguest, response, authentication);
		clearAthenticationAttributes(reguest);
		
	}
	
	public void handle(HttpServletRequest reguest, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
        String targetUrl = determinateTargetUrl(authentication);
		
		if(response.isCommitted()) {
			return;
		}
		
		redirectStrategy.sendRedirect(reguest, response, targetUrl);
	}
	
	private String determinateTargetUrl(Authentication authentication) {
		boolean isAdmin = false;
		boolean isUser = false;
		
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		
		for(GrantedAuthority grantedAuthority : authorities) {
			if(grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
				isAdmin = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
				isUser = true;
				break;
			}
		}
		
		if(isAdmin) {
			return ADMIN_PAGE;
		} else if(isUser) {
			return USER_PAGE;
		}
		
		return null;
		
	}
	
	
	private void clearAthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}
	
}
