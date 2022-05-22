package com.example.reactivespringwithdynamodb.util;

import org.springframework.beans.factory.annotation.Autowired;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

public abstract class DynamoDbRepository<T, K> {
    @Autowired
    private DynamoDbEnhancedClient dynamoDbEnhancedClient;

    public T save(final T t) {
        this.getTable().putItem(t);
        return t;
    }

    public void deleteById(final K k) {
        // for simplicity just converting key type to string
        this.getTable().deleteItem(Key.builder().partitionValue((String)k).build());
    }

    protected DynamoDbTable<T> getTable() {
        EntityTable<T> table = entityTable();
        return dynamoDbEnhancedClient
                .table(table.getTableName(), TableSchema.fromBean(table.getEntityClass()));
    }

    abstract protected EntityTable<T> entityTable();
}
