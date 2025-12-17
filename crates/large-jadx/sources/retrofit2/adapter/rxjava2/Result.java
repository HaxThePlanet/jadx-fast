package retrofit2.adapter.rxjava2;

import java.util.Objects;
import retrofit2.Response;

/* loaded from: classes3.dex */
public final class Result<T>  {

    private final Throwable error;
    private final Response<T> response;
    private Result(Response<T> response, Throwable throwable2) {
        super();
        this.response = response;
        this.error = throwable2;
    }

    public static <T> retrofit2.adapter.rxjava2.Result<T> error(Throwable throwable) {
        Objects.requireNonNull(throwable, "error == null");
        Result result = new Result(0, throwable);
        return result;
    }

    public static <T> retrofit2.adapter.rxjava2.Result<T> response(Response<T> response) {
        Objects.requireNonNull(response, "response == null");
        Result result = new Result(response, 0);
        return result;
    }

    public Throwable error() {
        return this.error;
    }

    public boolean isError() {
        int i;
        i = this.error != null ? 1 : 0;
        return i;
    }

    public Response<T> response() {
        return this.response;
    }
}
