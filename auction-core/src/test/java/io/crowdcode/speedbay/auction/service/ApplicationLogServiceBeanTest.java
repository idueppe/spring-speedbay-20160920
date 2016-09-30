package io.crowdcode.speedbay.auction.service;

import io.crowdcode.speedbay.auction.config.ApplicationLogConfiguration;
import io.crowdcode.speedbay.auction.model.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationLogConfiguration.class})
public class ApplicationLogServiceBeanTest {

    @Autowired
    private ApplicationLogService service;

    @Test
    // SQL Statements vor dem Test laufen lassen
    @Sql(statements = "DELETE FROM Application_Log")
    public void testApplicationLogging() throws Exception {
        service.log("JUNIT TEST %s", "LOG");
        List<Message> messages = service
                .lastLogs(Duration.of(5, ChronoUnit.SECONDS));
        messages.forEach(System.out::println);
        assertThat(messages, contains(hasProperty("message", is("JUNIT TEST LOG"))));
    }
}