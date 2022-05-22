package com.example.reactivespringwithdynamodb.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class EntityTable<E> {
    private final String tableName;
    private final Class<E> entityClass;
}
