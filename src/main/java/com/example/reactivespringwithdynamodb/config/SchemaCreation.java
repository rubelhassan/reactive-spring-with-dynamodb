package com.example.reactivespringwithdynamodb.config;


import com.example.reactivespringwithdynamodb.product.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Component
@Slf4j
@RequiredArgsConstructor
public class SchemaCreation {
    private final DynamoDbEnhancedClient dynamoDbEnhancedClient;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            dynamoDbEnhancedClient
                    .table("Product", TableSchema.fromBean(Product.class))
                    .createTable();
            log.info("Product table creation on dynamo db is successful");
        } catch (Exception e) {
            log.error("Error creating table at DynamoDB instance", e);
        }
    }
}
