package xyz.martinfejes.functions;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import xyz.martinfejes.models.Todo;

/**
 * Azure Functions with HTTP Trigger.
 */
public class TodoService {
    private List<Todo> todoList = new ArrayList();

//    TodoService() {
//        todoList.addAll(List.of(new Todo(1L, "todo 1"), new Todo(2L, "todo 2")));
//    }
    /**
     * This function listens at endpoint "/api/TodoService". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/TodoService
     * 2. curl {your host}/api/TodoService?name=HTTP%20Query
     */
    @FunctionName("TodoService")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", methods = {HttpMethod.GET, HttpMethod.POST}, authLevel = AuthorizationLevel.FUNCTION) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger in TodoService processed a request.");

        todoList.addAll(List.of(new Todo(1L, "todo 1"), new Todo(2L, "todo 2")));

        return request.createResponseBuilder(HttpStatus.OK).body(todoList).build();
    }
}
