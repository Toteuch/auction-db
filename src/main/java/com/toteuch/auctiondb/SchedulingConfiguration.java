package com.toteuch.auctiondb;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@ConditionalOnProperty(value = "auctiondb.jobs.enabled", matchIfMissing = true, havingValue = "true")
public class SchedulingConfiguration {

}
