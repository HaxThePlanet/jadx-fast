package zendesk.core;

import f.g.c.a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;

/* loaded from: classes3.dex */
class CachingInterceptor implements Interceptor {

    private static final String LOG_TAG = "CachingInterceptor";
    private final zendesk.core.BaseStorage cache;
    private final Map<String, Lock> locks;
    CachingInterceptor(zendesk.core.BaseStorage baseStorage) {
        super();
        HashMap hashMap = new HashMap();
        this.locks = hashMap;
        this.cache = baseStorage;
    }

    private Response createResponse(int i, Request request2, ResponseBody responseBody3) {
        String str2;
        String str;
        ResponseBody obj6;
        Response.Builder builder = new Response.Builder();
        if (responseBody3 != null) {
            builder.body(responseBody3);
        } else {
            a.k("CachingInterceptor", "Response body is null", new Object[0]);
        }
        return builder.code(i).message(request2.method()).request(request2).protocol(Protocol.HTTP_1_1).build();
    }

    private Response loadData(String string, Interceptor.Chain interceptor$Chain2) {
        Object[] contentType;
        Object obj;
        Class<ResponseBody> proceed;
        int bytes;
        Object cache;
        boolean successful;
        ResponseBody obj6;
        if ((ResponseBody)this.cache.get(string, ResponseBody.class) == null) {
            int i = 1;
            Object[] arr = new Object[i];
            bytes = 0;
            arr[bytes] = string;
            cache = "CachingInterceptor";
            a.b(cache, "Response not cached, loading it from the network. | %s", arr);
            proceed = chain2.proceed(chain2.request());
            if (proceed.isSuccessful()) {
                contentType = proceed.body().contentType();
                bytes = proceed.body().bytes();
                this.cache.put(string, ResponseBody.create(contentType, bytes));
                obj6 = ResponseBody.create(contentType, bytes);
            } else {
                contentType = new Object[i];
                contentType[bytes] = string;
                a.b(cache, "Unable to load data from network. | %s", contentType);
                obj6 = proceed.body();
            }
            obj = obj6;
            obj6 = proceed.code();
        } else {
            obj6 = 200;
        }
        return createResponse(obj6, chain2.request(), obj);
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain interceptor$Chain) {
        Object reentrantLock;
        Map locks;
        String string = chain.request().url().toString();
        final Map locks2 = this.locks;
        synchronized (locks2) {
            reentrantLock = this.locks.get(string);
            reentrantLock.lock();
            reentrantLock.unlock();
            return loadData(string, chain);
        }
    }
}
