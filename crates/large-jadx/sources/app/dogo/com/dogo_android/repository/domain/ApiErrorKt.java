package app.dogo.com.dogo_android.repository.domain;

import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.d0.d.n;
import okhttp3.ResponseBody;
import retrofit2.HttpException;
import retrofit2.Response;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000c\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003", d2 = {"toApiError", "Lapp/dogo/com/dogo_android/repository/domain/ApiError;", "Lretrofit2/HttpException;", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ApiErrorKt {
    public static final app.dogo.com.dogo_android.repository.domain.ApiError toApiError(HttpException httpException) {
        int i;
        Class<app.dogo.com.dogo_android.repository.domain.ApiError> obj;
        Object obj2;
        n.f(httpException, "<this>");
        obj2 = httpException.response();
        i = 0;
        if (obj2 == null) {
        } else {
            obj2 = obj2.errorBody();
            if (obj2 == null) {
            } else {
                obj2 = obj2.string();
                if (obj2 == null) {
                } else {
                    Gson gson = new Gson();
                    i = obj2;
                }
            }
        }
        return i;
    }
}
