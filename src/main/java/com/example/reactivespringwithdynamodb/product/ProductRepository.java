package com.example.reactivespringwithdynamodb.product;

import com.example.reactivespringwithdynamodb.util.DynamoDbRepository;
import com.example.reactivespringwithdynamodb.util.EntityTable;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.enhanced.dynamodb.Key;

import java.util.Optional;

import static java.util.Optional.ofNullable;

@Component
public class ProductRepository extends DynamoDbRepository<Product, String> {
    public Optional<Product> findProductByIdAndName(String id, String sortKey) {
        return ofNullable(
                getTable().getItem(Key.builder().partitionValue(id).sortValue(sortKey).build())
        );
    }

    @Override
    protected EntityTable<Product> entityTable() {
        return new EntityTable<>("Product", Product.class);
    }
}
