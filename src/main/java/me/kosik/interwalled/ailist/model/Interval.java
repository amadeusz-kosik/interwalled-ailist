package me.kosik.interwalled.ailist.model;

import java.util.Objects;

public record Interval<T>(
        String key,
        long from,
        long to,
        T value
) {

    public static boolean overlaps(final Interval<?> lhs, final Interval<?> rhs) {
        return Objects.equals(lhs.key(), rhs.key()) && lhs.to() >= rhs.from() && rhs.to() >= lhs.from();
    }
}
