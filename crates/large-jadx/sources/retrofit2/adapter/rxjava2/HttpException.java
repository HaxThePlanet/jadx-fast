package retrofit2.adapter.rxjava2;

import retrofit2.HttpException;
import retrofit2.Response;

/* loaded from: classes3.dex */
@Deprecated
public final class HttpException extends HttpException {
    public HttpException(Response<?> response) {
        super(response);
    }
}
