package com.example.draw.config;

import com.example.draw.config.security.CustomizeAccessDeniedHandler;
import com.example.draw.config.security.CustomizeAuthenticationEntryPoint;
import com.example.draw.config.security.CustomizeSessionInformationExpiredStrategy;
import com.example.draw.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

// 分别是标识该类是配置类、开启 Security 服务
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService userDetailService;

    @Autowired
    CustomizeAccessDeniedHandler customizeAccessDeniedHandler;

    @Autowired
    CustomizeAuthenticationEntryPoint customizeAuthenticationEntryPoint;

    @Autowired
    CustomizeSessionInformationExpiredStrategy sessionInformationExpiredStrategy;

    @Resource
    private SessionRegistry sessionRegistry;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    @Bean
    //注入authenticationManager
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                // 放行登录接口、swagger-ui目录
                .antMatchers("/userAccount/**",
                        "/v2/api-docs", "/swagger-resources/configuration/ui",
                "/swagger-resources", "/swagger-resources/configuration/security",
                "/swagger-ui.html", "/webjars/**").permitAll()
                // 为其它接口设置权限
                .antMatchers("/user/**").hasAuthority("user")
                .anyRequest().authenticated()
                //禁用baisc和form认证，在AuthController中自己实现认证逻辑
                .and()
                .httpBasic().disable()
                .formLogin().disable()
                .csrf().disable()
                .logout().disable()
                .exceptionHandling()
                .accessDeniedHandler(customizeAccessDeniedHandler)  // 权限拒绝处理逻辑
                .authenticationEntryPoint(customizeAuthenticationEntryPoint)    // 匿名用户访问无权限资源时的异常处理
        ;

                // session管理
                http.sessionManagement()
                .maximumSessions(1)//同一账号同时登录最大用户数
                .sessionRegistry(sessionRegistry)
                .maxSessionsPreventsLogin(true)
                .expiredSessionStrategy(sessionInformationExpiredStrategy);
    }
}
