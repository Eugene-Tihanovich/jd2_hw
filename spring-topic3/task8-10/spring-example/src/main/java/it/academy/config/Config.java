package it.academy.config;

import it.academy.pojos.Car;
import it.academy.pojos.Engine;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;


@ComponentScan(value = "it.academy.pojos", useDefaultFilters = false, includeFilters =
        {@ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE, classes = {Car.class, Engine.class})})
public class Config {

}