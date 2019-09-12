package com.fyj.pms.config;

import com.t2w.utils.captcha.configuration.Vaptcha;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author T2W
 * @version V1.0.0
 * @email tang.wangwang@qq.com
 * @date 2019-09-06 20:09
 * @name com.fyj.pms.config.EntityConfig.java
 * @see describing 需要注入到Spring容器中的实体配置类
 */
@Configuration
public class EntityConfig {

    @Bean("vaptcha")
    public Vaptcha vaptcha() {
        Vaptcha vaptcha = new Vaptcha();
        // 配置验证码的 VID 和 secretKey
        vaptcha.setId("5d6f4df6fc650e9b80225898").setSecretkey("03ac039d262c4bfe9d512013f5e74d5c");
        return vaptcha;
    }

}
