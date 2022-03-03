package com.wiloke.shopify.connection.graphqlbuilder;


import com.wiloke.shopify.connection.dto.shopify.request.CustomerRequestDTO;
import com.wiloke.shopify.connection.dto.shopify.request.pluck.CustomerPluck;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerQueryBuilder implements GraphqlBuilderable<CustomerRequestDTO> {
    private CustomerRequestDTO customerRequestDTO;

    @Override
    public GraphqlBuilderable<CustomerRequestDTO> setRequest(CustomerRequestDTO queryable) {
        this.customerRequestDTO = queryable;
        return this;
    }


    @Override
    public String build() {
        var graphQLQueryBuilder = GraphQLQueryBuilder.query();
        List<GraphQLQueryBuilder> aField = new ArrayList<>();
        CustomerPluck[] customerPlucks = this.customerRequestDTO.getPluck() != null ? this.customerRequestDTO.getPluck() : this.customerRequestDTO.getAllPluck();

        for (var item : customerPlucks) {
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

        var handleNode = GraphQLQueryBuilder.query().object("node", aFiledQuery).build().getBuild();
        var handleEdges = GraphQLQueryBuilder.query().object("edges", handleNode).build().getBuild();

        return graphQLQueryBuilder.object("customers(first: 1) ", handleEdges).build().getQueryBuilder();
    }
}
