package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static java.lang.ThreadLocal.withInitial;
import io.restassured.response.Response;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;
import java.util.HashMap;

public enum ITestContext{

    CONTEXT;

    private static String REQUEST = "REQUEST";
    private static String RESPONSE = "RESPONSE";
    private static String JSONPATH;
    private static RequestSpecification REQUEST_SPECIFICATION;
    private final ThreadLocal<Map<String, Object>> testContexts = withInitial(HashMap::new);

    public <T> T get(String name) {
        return (T) testContexts.get()
                .get(name);
    }

    public <T> T set(String name, T object) {
        testContexts.get()
                .put(name, object);
        return object;
    }

    public JsonPath getJsonPathResponse() {
        return get(JSONPATH);
    }

    public JsonPath setJsonPathResponse() {

        return set(JSONPATH,new JsonPath(RESPONSE.toString()));
    }

    public RequestSpecification getRequest(){
        return get("REQUEST_SPECIFICATION");
    }

    public Response getResponse() {
        return get(RESPONSE);
    }

    public Response setResponse(Response response) {
        return set(RESPONSE, response);
    }

    public void reset() {
        testContexts.get()
                .clear();
    }

    public RequestSpecification buildRequestV1() throws IOException {


        PrintStream stream = new PrintStream(new FileOutputStream("loggin.txt"));
        REQUEST_SPECIFICATION = new RequestSpecBuilder().
                setBaseUri(Helper.setUpEnvironment("v1"))
                .setContentType(ContentType.JSON)
                .addHeader("token","skdjfh73273$7268u2j89s")
                .addFilter(RequestLoggingFilter.logRequestTo(stream))
                .addFilter(ResponseLoggingFilter.logResponseTo(stream))
                .build();
        return set("REQUEST_SPECIFICATION",REQUEST_SPECIFICATION);
    }

    public RequestSpecification buildRequestV3() throws IOException {


        PrintStream stream = new PrintStream(new FileOutputStream("loggin.txt"));
        REQUEST_SPECIFICATION = new RequestSpecBuilder().
                setBaseUri(Helper.setUpEnvironment("v3"))
                .setContentType(ContentType.JSON)
                .addHeader("token","skdjfh73273$7268u2j89s")
                .addFilter(RequestLoggingFilter.logRequestTo(stream))
                .addFilter(ResponseLoggingFilter.logResponseTo(stream))
                .build();
        return set("REQUEST_SPECIFICATION",REQUEST_SPECIFICATION);
    }
}
