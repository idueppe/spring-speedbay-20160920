package io.crowdcode.speedbay.auction.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Configuration
@ComponentScan
@Import(BusinessLogicAnnotationConfiguration.class)
public class MessageServiceAnnotationConfiguration {
}
