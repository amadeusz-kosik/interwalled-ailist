package me.kosik.interwalled.ailist.data;

public record Interval<T>(
        String key,
        long from,
        long to,
        T value
) {}
