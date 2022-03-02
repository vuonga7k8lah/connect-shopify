package com.wiloke.shopify.connection.routes;

import com.wiloke.shopify.connection.datafetcher.ShopDataFetcher;
import com.wiloke.shopify.connection.utils.APIUtil;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.servlet.GraphQLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Component
@RestController
public class ShopGraphQLController {
    @Value("classpath:shopinfo.graphql")
    Resource resource;
    private GraphQL graphQL;
    private HttpServletRequest httpServletRequest;

    @Autowired
    private ShopDataFetcher shopDataFetcher;

    @PostConstruct
    public void loadSchema() throws IOException {
        File schemaFile = this.resource.getFile();

        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = this.buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, wiring);
        this.graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        /*
         * This dataFetcher first argument i.e "shop" this name
         * should be same with the field which u declare in your shop.graphqls
         * in typeQuery section and one more things these 2 field name should be
         * same which we are sending as part of request query from postman for
         * Example : { shop{pass required field } }
         */
        return RuntimeWiring
                .newRuntimeWiring()
                .type("Query",
                        typeWiring -> typeWiring.dataFetcher("shop", shopDataFetcher)
                )
                .build();
    }

    /* Get List of Movie with all the fields */
    @PostMapping(APIUtil.SHOP_GRAPHQL_INFO_ENDPOINT)
    public ResponseEntity<Object> getAllMovies(@RequestBody String query, HttpServletRequest headers) {
        GraphQLContext context = new GraphQLContext(headers);
        ExecutionInput executionInput = ExecutionInput.newExecutionInput()
                .query(query)
                .context(context)
                .build();
        ExecutionResult result = graphQL.execute(executionInput);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
