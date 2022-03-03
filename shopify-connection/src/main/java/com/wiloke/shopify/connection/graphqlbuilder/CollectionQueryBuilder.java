package com.wiloke.shopify.connection.graphqlbuilder;

import com.wiloke.shopify.connection.dto.shopify.request.CollectionRequestDTO;
import com.wiloke.shopify.connection.dto.shopify.request.pluck.CollectionPluck;
import org.springframework.stereotype.Component;

@Component
public class CollectionQueryBuilder implements GraphqlBuilderable<CollectionRequestDTO> {
    private CollectionRequestDTO collectionRequestDTO;
    private String fieldQuery;

    @Override
    public GraphqlBuilderable<CollectionRequestDTO> setRequest(CollectionRequestDTO queryable) {
        this.collectionRequestDTO = queryable;
        return this;
    }

    @Override
    public String build() {
        var graphQLQueryBuilder = GraphQLQueryBuilder.query();
        CollectionPluck[] collectionPlucks = this.collectionRequestDTO.getPluck() != null ? this.collectionRequestDTO.getPluck() : this.collectionRequestDTO.getAllPluck();

        for (var item : collectionPlucks) {
            if (item.getSubQuery() == null) {
                if (item.getField() != null) { // Trả về giá trị mặc định
                    graphQLQueryBuilder.field(item.getField()).build();
                }
            } else {
                graphQLQueryBuilder.object(item.getField(), item.getSubQuery()).build();
            }
        }
        if (this.collectionRequestDTO.getId() == null) {
            var graphQLQuery = graphQLQueryBuilder.getBuild();
            var handleNode = GraphQLQueryBuilder.query().object("node", graphQLQuery).build().getBuild();
            var handleEdges = GraphQLQueryBuilder.query().object("edges", handleNode).build().getBuild();
            if (collectionRequestDTO.getHandles() == null) {
                fieldQuery = "collections(first: 10)";
            } else {
                fieldQuery = "collections(first: 10 ,query:\"" + collectionRequestDTO.getHandles().replaceAll(",", " OR ") + "\" )";
            }
            return graphQLQueryBuilder.object(fieldQuery, handleEdges).build().getQueryBuilder();
        }


        return graphQLQueryBuilder.topWrapper(" collection(id: \"" + this.collectionRequestDTO.getId() + "\")").getQueryBuilder();
    }
}
