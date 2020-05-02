package com.jg.products.examples;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/beans")
public class CustomBeanController {

    private final CustomBean customBean1;
    private final CustomBean customBean2;

    /**
     * Call value of the first {@link CustomBean}.
     * @return The {@link CustomBean} string value.
     */
    @GetMapping("/1")
    public String getBean1() {
        return customBean1.toString();
    }

    /**
     * Call value of the second {@link CustomBean}.
     * @return The {@link CustomBean} string value.
     */
    @GetMapping("/2")
    public String getBean2() {
        return customBean2.toString();
    }

    /**
     * CustomBean Class.
     */
    @Data
    public static class CustomBean {
        private final UUID uuid = UUID.randomUUID();

        public String toString() {
            return uuid.toString();
        }
    }

    @Configuration
    public static class CustomBeanConfig {

        /**
         * {@link Scope} defines whether the Bean is to be a Singleton (Default) or a Prototype (new instance per call).
         * @return The created Bean instance.
         */
        @Bean
        @Scope(value = SCOPE_PROTOTYPE)
        public CustomBean customBean() {
            return new CustomBean();
        }

    }
}
