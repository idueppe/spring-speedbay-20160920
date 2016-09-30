package io.crowdcode.speedbay.auction.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Configuration
@ComponentScan(
        basePackages = {"io.crowdcode.speedbay.auction"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,
                pattern = ".*ApplicationLog.*"

        )
)
//@ComponentScan
@Import(BusinessLogicConfiguration.class)
public class MessageServiceAnnotationConfiguration {
}
