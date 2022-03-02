package com.wiloke.shopify.connection;

import com.wiloke.shopify.connection.graphqlbuilder.GraphQLQueryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopifyConnectionApplication {

    private static GraphQLQueryBuilder field;
    private static GraphQLQueryBuilder query;
    private static GraphQLQueryBuilder query1;

    public static void main(String[] args) {
//        query = GraphQLQueryBuilder.query();
//        query1 = GraphQLQueryBuilder.query();
//        var queryString = GraphQLQueryBuilder.query()
//                .objects(
//                        GraphQLQueryBuilder.query().object(
//                                "collections(first: 10)",
//                                GraphQLQueryBuilder.query().object(
//                                        "edges",
//                                        GraphQLQueryBuilder.query().objects(
//                                                GraphQLQueryBuilder.query().field("cursors"),
//                                                GraphQLQueryBuilder.query().object(
//                                                        "node",
//                                                        GraphQLQueryBuilder.query().objects(
//                                                                query.field("availablePublicationCount"),
//                                                                query1.field("description")
//                                                        )
//                                                )
//                                        )
//                                ).build().getBuild()
//                        ),
//                        GraphQLQueryBuilder.query().object(
//                                "product(id: 10)",
//                                GraphQLQueryBuilder.query().objects(
//                                        GraphQLQueryBuilder.query().field("id"),
//                                        GraphQLQueryBuilder.query().object(
//                                                "images(sortKey: CREATED_AT)",
//                                                GraphQLQueryBuilder.query().object(
//                                                        "edges",
//                                                        GraphQLQueryBuilder.query().objects(
//                                                                GraphQLQueryBuilder.query().field("cursor"),
//                                                                GraphQLQueryBuilder.query().object(
//                                                                        "node",
//                                                                        GraphQLQueryBuilder.query().objects(
//                                                                                GraphQLQueryBuilder.query().field("altText"),
//                                                                                GraphQLQueryBuilder.query().field("height"),
//                                                                                GraphQLQueryBuilder.query().field("id")
//                                                                        )
//                                                                )
//                                                        )
//                                                ).build().getBuild()
//                                        )
//                                )
//                        )
//                );getBuild

        //System.out.println("queryString:" + queryString);
        SpringApplication.run(ShopifyConnectionApplication.class, args);
    }

}
