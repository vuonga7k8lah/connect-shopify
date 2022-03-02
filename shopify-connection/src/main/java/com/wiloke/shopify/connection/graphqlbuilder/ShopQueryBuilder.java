package com.wiloke.shopify.connection.graphqlbuilder;

import com.wiloke.shopify.connection.dto.shopify.request.ShopRequestDTO;
import com.wiloke.shopify.connection.dto.shopify.request.pluck.ShopInfoPluck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class ShopQueryBuilder implements GraphqlBuilderable<ShopRequestDTO> {
    private ShopRequestDTO shopQueryDTO;

    @Override
    public GraphqlBuilderable<ShopRequestDTO> setRequest(ShopRequestDTO queryable) {
        this.shopQueryDTO = queryable;
        return this;
    }


    @Override
    public String build() {
        var graphQLQueryBuilder = GraphQLQueryBuilder.query();
        List<GraphQLQueryBuilder> aField = new ArrayList<>();
        ShopInfoPluck[] shopInfoPluck = this.shopQueryDTO.getPluck() != null ? this.shopQueryDTO.getPluck() : this.shopQueryDTO.getAllPluck();

        for (var item : shopInfoPluck) {
            if (item.getSubQuery() == null) {
                if (item.getHasEdges()) {
                    aField.add(GraphQLQueryBuilder.query().field(item.getField() + "{\n" +
                            "      edges {\n" +
                            "        node\n" +
                            "        cursor\n" +
                            "           }" +
                            "      }"
                    ));
                } else {
                    aField.add(GraphQLQueryBuilder.query().field(item.getField()));
                }
            } else {

                List<GraphQLQueryBuilder> aSubQueryItem = new ArrayList<>();
                for (var subQuery : item.getSubQuery().split(",")) {
                    aSubQueryItem.add(GraphQLQueryBuilder.query().field(subQuery));
                }
                if (!item.getHasEdges()) {
                    aField.add(GraphQLQueryBuilder.query().object(
                            item.getField(),
                            GraphQLQueryBuilder.query().objects(aSubQueryItem)
                    ));
                } else {
                    var query1 = GraphQLQueryBuilder.query();
                    List<GraphQLQueryBuilder> aSubQueryItemEdges = new ArrayList<>();
                    aSubQueryItemEdges.add(query1.object(
                            "node",
                            GraphQLQueryBuilder.query().objects(aSubQueryItem)
                    ));
                    query1.field("edges");
                    aField.add(GraphQLQueryBuilder.query().object(
                            item.getField(),
                            query1.build().getBuild()
                    ));
                }
            }
        }
        var aFiledQuery = aField.stream().map(field -> GraphQLQueryBuilder.query().objects(field)).collect(Collectors.toList());
        //  System.out.println(graphQLQueryBuilder.object("shop", aFiledQuery).build().getQueryBuilder());
        return graphQLQueryBuilder.object("shop", aFiledQuery).build().getQueryBuilder();
    }
}
