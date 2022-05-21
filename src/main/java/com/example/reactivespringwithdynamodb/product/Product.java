package com.example.reactivespringwithdynamodb.product;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "Product")
public class Product {

    @DynamoDBHashKey(attributeName = "Id")
    @DynamoDBAutoGeneratedKey
    private Long id;

    @DynamoDBAttribute(attributeName = "Name")
    private String name;

    @DynamoDBAttribute(attributeName = "UnitPrice")
    private Double unitPrice;

    @DynamoDBAttribute(attributeName = "AvailableUnit")
    private Integer availableUnit;

    @DynamoDBAttribute(attributeName = "DiscountPercentage")
    private Double discountPercentage;
}
