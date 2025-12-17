package com.squareup.picasso;

import android.content.Context;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import java.io.File;
import okhttp3.Cache;
import okhttp3.Call.Factory;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes2.dex */
public final class s implements com.squareup.picasso.j {

    final Call.Factory a;
    public s(Context context) {
        super(f0.e(context));
    }

    public s(File file) {
        super(file, f0.a(file), obj1);
    }

    public s(File file, long l2) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        Cache cache = new Cache(file, l2, obj5);
        super(builder.cache(cache).build());
    }

    public s(OkHttpClient okHttpClient) {
        super();
        this.a = okHttpClient;
        okHttpClient.cache();
    }

    @Override // com.squareup.picasso.j
    public Response a(Request request) {
        return FirebasePerfOkHttpClient.execute(this.a.newCall(request));
    }
}
