package com.kshpart.www.springboot.config.auth;

import com.kshpart.www.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // Spring Security 설정 활성화.
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .headers().frameOptions().disable()// h2-database 화면 쓰기 위해서 disable 함.

                .and()
                    .authorizeRequests()//URL별 권한관리를 설정하는 옵션 시작점. 이게 있어야 antMatchers 사용 가능.
                    .antMatchers("/", "/css/**", "/images/**","/js/**","/h2-console/**","/profile").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())// 권한관리 대상 지정 옵션.
                    .anyRequest().authenticated() // 설정값 이외의 나머지 URL들을 나타냄.

                .and()
                    .logout()
                        .logoutSuccessUrl("/") //로그아웃 기능에 대한 여러 설정의 시작점.
                .and()
                    .oauth2Login()
                        .userInfoEndpoint()//성공이후
                            .userService(customOAuth2UserService);

    }
}
