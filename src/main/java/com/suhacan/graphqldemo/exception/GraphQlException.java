package com.suhacan.graphqldemo.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

@Component
public class GraphQlException extends DataFetcherExceptionResolverAdapter {

    protected GraphQLError toGraphQLError(Throwable exception, DataFetchingEnvironment environment) {
        if (exception instanceof UserNotFoundException)
            return toGraphQLError(exception);
        return super.resolveToSingleError(exception, environment);
    }

    private GraphQLError toGraphQLError(Throwable exception) {
     return GraphqlErrorBuilder.newError()
             .message(exception.getMessage())
             .errorType(ErrorType.DataFetchingException)
             .build();
    }
}
