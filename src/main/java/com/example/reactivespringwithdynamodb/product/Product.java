package com.example.reactivespringwithdynamodb.product;

import lombok.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamoDbBean
public class Product {

    @Getter(onMethod_ = {
            @DynamoDbPartitionKey,
            @DynamoDbAttribute("Id")
    })
    private String id;

    @Getter(onMethod_ = {
            @DynamoDbSortKey,
            @DynamoDbAttribute("Name")
    })
    private String name;

    @Getter(onMethod_ = @DynamoDbAttribute("UnitPrice"))
    private Double unitPrice;

    @Getter(onMethod_ = @DynamoDbAttribute("AvailableUnit"))
    private Integer availableUnit;

    @Getter(onMethod_ = @DynamoDbAttribute("DiscountPercentage"))
    private Double discountPercentage;
}
