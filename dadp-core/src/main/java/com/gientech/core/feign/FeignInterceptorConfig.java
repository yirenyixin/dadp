package com.gientech.core.feign;

import com.gientech.common.MyConstants;
import com.gientech.core.security.util.JwtUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 微服务之间通过feign调用，把token带上，否则鉴权会报错
 * <p>
 * 注意：微服务调用不要用异步， @Async 这个注解
 *
 * @author 张福华
 */
@Configuration
public class FeignInterceptorConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        RequestInterceptor requestInterceptor = new RequestInterceptor() {

            @Override
            public void apply(RequestTemplate template) {
                /**
                 * 不需要token的feign。
                 * @PostMapping(value = "", headers = { MyConstants.FEIGN_NOT_TOKEN + "=true" }
                 * 2022-6-22 吴小毅 add
                 */
                if (template.headers().containsKey(MyConstants.FEIGN_NOT_TOKEN)) {
                    return;
                }
                // 使用feign访问别的微服务时，传递token,
                String token = JwtUtil.getToken();

                if (StringUtils.isNotBlank(token)) {
                    template.header(MyConstants.HEADER, token);
                }
            }
        };

        return requestInterceptor;
    }
}
