package com.wzero.security.authorize;

import com.wzero.security.model.CommonConstants;
import com.wzero.security.properties.SecurityProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.AuthorizedUrl;

/**
 * @ClassName MyAuthorizeConfigProvider
 * @Description 授权配置 提供程序
 * @Author WJJ
 * @Date 2020/08/02 21:25
 * @Version 1.0
 */
public class MyAuthorizeConfigProvider implements AuthorizeConfigProvider {
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry urlRegistry) {
        ((AuthorizedUrl)urlRegistry.antMatchers(
                "/**/*.js", "/**/*.css", "/**/*.jpg", "/**/*.png", "/**/*.gif",
                CommonConstants.DEFAULT_UNAUTHENTICATION_URL,
                CommonConstants.DEFAULT_LOGIN_MOBILE_URL,
                CommonConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
                this.securityProperties.getBrowser().getSignInPage(),
                this.securityProperties.getBrowser().getSignUpUrl(),
                this.securityProperties.getBrowser().getSession().getSessionInvalidUrl()
        )).permitAll();
        if (StringUtils.isNotBlank(securityProperties.getBrowser().getSignOutUrl())) {
            ((AuthorizedUrl)urlRegistry.antMatchers(securityProperties.getBrowser().getSignOutUrl())).permitAll();
        }
        return false;
    }
}