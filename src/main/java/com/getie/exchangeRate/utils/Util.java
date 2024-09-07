package com.getie.exchangeRate.utils;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.stream.Stream;

import static java.time.temporal.ChronoUnit.DAYS;

public class Util {
    private Util() {
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null || propertyName.equals("id"))
                .toArray(String[]::new);
    }



    public static long getDurationBetweenInDates(LocalDate startDate, LocalDate endDate) {
        return DAYS.between(startDate, endDate);
    }

    public static BigDecimal getDailyIncrementForEoy(double noOfDays, LocalDate effectiveDate) {
        return BigDecimal.valueOf(noOfDays / 365);
    }



}
