package org.noname.charfrequencyproject.entity.common;

public record Result<T>(boolean isSuccess, T result, Error error) {
}
