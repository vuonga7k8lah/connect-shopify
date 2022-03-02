package com.wiloke.shopify.connection.graphqlbuilder;

import com.wiloke.shopify.connection.dto.shopify.request.CollectionRequestDTO;
import com.wiloke.shopify.connection.dto.shopify.request.OrderRequestDTO;
import com.wiloke.shopify.connection.dto.shopify.request.ProductRequestDTO;
import com.wiloke.shopify.connection.dto.shopify.request.pluck.OrderPluck;
import com.wiloke.shopify.connection.dto.shopify.request.pluck.ProductPluck;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderQueryBuilder implements GraphqlBuilderable<OrderRequestDTO> {
    private OrderRequestDTO orderRequestDTO;

    @Override
    public GraphqlBuilderable<OrderRequestDTO> setRequest(OrderRequestDTO queryable) {
        this.orderRequestDTO = queryable;
        return this;
    }


    @Override
    public String build() {
        var graphQLQueryBuilder = GraphQLQueryBuilder.query();
        List<GraphQLQueryBuilder> aField = new ArrayList<>();
        OrderPluck[] orderPlucks = this.orderRequestDTO.getPluck() != null ? this.orderRequestDTO.getPluck() : this.orderRequestDTO.getAllPluck();

        for (var item : orderPlucks) {
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

        var handleNodeOrders = GraphQLQueryBuilder.query().object("node", aFiledQuery).build().getBuild();
        var handleEdgesOrders = GraphQLQueryBuilder.query().object("edges", handleNodeOrders).build().getBuild();
        var ordersQuery = GraphQLQueryBuilder.query().object(" orders(first: 2)", handleEdgesOrders).build().getBuild();

        var handleNodeCustomers = GraphQLQueryBuilder.query().object("node", ordersQuery).build().getBuild();
        var handleEdgesCustomers = GraphQLQueryBuilder.query().object("edges", handleNodeCustomers).build().getBuild();

        return graphQLQueryBuilder.object("customers(first: 20)", handleEdgesCustomers).build().getQueryBuilder();
    }
}
