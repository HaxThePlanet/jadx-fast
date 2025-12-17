package retrofit2;

import java.util.Objects;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;

/* loaded from: classes3.dex */
public final class Response<T>  {

    private final T body;
    private final ResponseBody errorBody;
    private final Response rawResponse;
    private Response(Response response, T t2, ResponseBody responseBody3) {
        super();
        this.rawResponse = response;
        this.body = t2;
        this.errorBody = responseBody3;
    }

    public static <T> retrofit2.Response<T> error(int i, ResponseBody responseBody2) {
        Objects.requireNonNull(responseBody2, "body == null");
        if (i < 400) {
        } else {
            Response.Builder builder = new Response.Builder();
            OkHttpCall.NoContentResponseBody noContentResponseBody = new OkHttpCall.NoContentResponseBody(responseBody2.contentType(), responseBody2.contentLength(), obj4);
            Request.Builder builder2 = new Request.Builder();
            return Response.error(responseBody2, builder.body(noContentResponseBody).code(i).message("Response.error()").protocol(Protocol.HTTP_1_1).request(builder2.url("http://localhost/").build()).build());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("code < 400: ");
        stringBuilder.append(i);
        IllegalArgumentException obj6 = new IllegalArgumentException(stringBuilder.toString());
        throw obj6;
    }

    public static <T> retrofit2.Response<T> error(ResponseBody responseBody, Response response2) {
        Objects.requireNonNull(responseBody, "body == null");
        Objects.requireNonNull(response2, "rawResponse == null");
        if (response2.isSuccessful()) {
        } else {
            Response response = new Response(response2, 0, responseBody);
            return response;
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("rawResponse should not be successful response");
        throw obj2;
    }

    public static <T> retrofit2.Response<T> success(int i, T t2) {
        int i2;
        if (i < 200) {
        } else {
            if (i >= 300) {
            } else {
                Response.Builder builder = new Response.Builder();
                Request.Builder builder2 = new Request.Builder();
                return Response.success(t2, builder.code(i).message("Response.success()").protocol(Protocol.HTTP_1_1).request(builder2.url("http://localhost/").build()).build());
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("code < 200 or >= 300: ");
        stringBuilder.append(i);
        IllegalArgumentException obj3 = new IllegalArgumentException(stringBuilder.toString());
        throw obj3;
    }

    public static <T> retrofit2.Response<T> success(T t) {
        Response.Builder builder = new Response.Builder();
        Request.Builder builder2 = new Request.Builder();
        return Response.success(t, builder.code(200).message("OK").protocol(Protocol.HTTP_1_1).request(builder2.url("http://localhost/").build()).build());
    }

    public static <T> retrofit2.Response<T> success(T t, Headers headers2) {
        Objects.requireNonNull(headers2, "headers == null");
        Response.Builder builder = new Response.Builder();
        Request.Builder builder2 = new Request.Builder();
        return Response.success(t, builder.code(200).message("OK").protocol(Protocol.HTTP_1_1).headers(headers2).request(builder2.url("http://localhost/").build()).build());
    }

    public static <T> retrofit2.Response<T> success(T t, Response response2) {
        Objects.requireNonNull(response2, "rawResponse == null");
        if (!response2.isSuccessful()) {
        } else {
            Response response = new Response(response2, t, 0);
            return response;
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("rawResponse must be successful response");
        throw obj2;
    }

    public T body() {
        return this.body;
    }

    public int code() {
        return this.rawResponse.code();
    }

    public ResponseBody errorBody() {
        return this.errorBody;
    }

    public Headers headers() {
        return this.rawResponse.headers();
    }

    public boolean isSuccessful() {
        return this.rawResponse.isSuccessful();
    }

    public String message() {
        return this.rawResponse.message();
    }

    public Response raw() {
        return this.rawResponse;
    }

    public String toString() {
        return this.rawResponse.toString();
    }
}
