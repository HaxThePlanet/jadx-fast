package retrofit2;

import java.util.Objects;

/* loaded from: classes3.dex */
public class HttpException extends RuntimeException {

    private final int code;
    private final String message;
    private final transient retrofit2.Response<?> response;
    public HttpException(retrofit2.Response<?> response) {
        super(HttpException.getMessage(response));
        this.code = response.code();
        this.message = response.message();
        this.response = response;
    }

    private static String getMessage(retrofit2.Response<?> response) {
        Objects.requireNonNull(response, "response == null");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HTTP ");
        stringBuilder.append(response.code());
        stringBuilder.append(" ");
        stringBuilder.append(response.message());
        return stringBuilder.toString();
    }

    @Override // java.lang.RuntimeException
    public int code() {
        return this.code;
    }

    @Override // java.lang.RuntimeException
    public String message() {
        return this.message;
    }

    public retrofit2.Response<?> response() {
        return this.response;
    }
}
