package org.noname.charfrequencyproject.entity.common;

public record Result<T>(boolean isSuccess, T result, Error error) {
    public static <T> Result<T> ok(T result) {
        return new Result<>(true, result, null);
    }

    public static <T> Result<T> error(Error error) {
        return new Result<>(false, null, error);
    }
}
