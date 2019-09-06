package com.fyj.pms.configure;

import com.t2w.utils.captcha.configuration.Vaptcha;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author T2W
 * @version V1.0.0
 * @email tang.wangwang@qq.com
 * @date 2019-09-06 20:09
 * @name com.fyj.pms.configure.ParameterConfiguration.java
 * @see describing
 */
@Configuration
public class ParameterConfiguration {

    @Bean("vaptcha")
    public Vaptcha vaptcha() {
        Vaptcha vaptcha = new Vaptcha();
        vaptcha.setId("5d6f4df6fc650e9b80225898").setSecretkey("03ac039d262c4bfe9d512013f5e74d5c");
        return vaptcha;
    }

}
