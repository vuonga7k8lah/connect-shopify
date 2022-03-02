package com.wiloke.shopify.connection.graphqlbuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GraphQLQueryBuilder {
    private String query;
    private String lastQuery;

    public static GraphQLQueryBuilder query() {
        return (new GraphQLQueryBuilder());
    }

    public GraphQLQueryBuilder topWrapper(String field) {
        this.query = field + " { \n\t\t" + this.query + " \n\t}";

        return this;
    }

    public String objects(List<GraphQLQueryBuilder> aSubQuery) {
        return aSubQuery.stream().map(item -> item.build().getBuild()).collect(Collectors.joining(",\n\t\t"));
    }

    public String objects(GraphQLQueryBuilder... SubQuery) {
        return Arrays.stream(SubQuery).map(item -> item.build().getBuild()).collect(Collectors.joining(",\n\t\t"));
    }

    public GraphQLQueryBuilder object(String field, String... insideQuery) {

        var parseInsideQuery = String.join(",\n\t\t", insideQuery);
        this.lastQuery = field + " { \n\t\t" + parseInsideQuery + " \n\t}";
        return this;
    }

    public GraphQLQueryBuilder object(String field, List<String> insideQuery) {

        var parseInsideQuery = String.join(",\n\t\t", insideQuery);
        this.lastQuery = field + " { \n\t\t" + parseInsideQuery + " \n\t}";
        return this;
    }

    public GraphQLQueryBuilder field(String field) {
        if (this.lastQuery != null) {
            this.lastQuery = field + "\t{\n\t" + this.lastQuery + "\n\t}";
        } else {
            this.lastQuery = field;
        }
        return this;
    }

    public void reset() {
        this.lastQuery = null;
    }

    public String getQueryBuilder() {
        var finalQuery = "query { \n\t" + this.query + " \n} ";
        this.reset();
        return finalQuery;
    }

    public GraphQLQueryBuilder build() {
        if (this.query == null) {
            this.query = this.lastQuery;
        } else {
            this.query = this.query + ", \n\t" + this.lastQuery;
        }

        this.lastQuery = null;
        return this;
    }

    public String getBuild() {
        var response = this.query;
        this.query = null;
        return response;
    }
}
