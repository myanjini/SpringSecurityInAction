package com.ssia.model;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ssia.entities.User;

public class CustomUserDetails implements UserDetails {

	private final User user;
	
	public CustomUserDetails(User user) {
		this.user = user;
	}

	public final User getUser() {
		return user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return user.getAuthorities().stream()
				// 사용자의 데이터베이스에서 찾은 각 권한 이름을 SimpleGrantedAuthority에 매핑
				.map(a -> new SimpleGrantedAuthority(a.getName()))
				// 목록에서 SimpleGrantedAuthority의 모든 인스턴스를 수집하고 반환
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
