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

/* compiled from: OkHttp3Downloader.java */
/* loaded from: classes2.dex */
public final class s implements j {

    final Call.Factory a;
    public s(Context context) {
        this(f0.e(context));
    }

    public Response a(Request request) {
        return FirebasePerfOkHttpClient.execute(this.a.newCall(request));
    }

    public s(File file) {
        this(file, f0.a(file), obj);
    }

    public s(File file, long j) {
        this(new OkHttpClient_Builder().cache(new Cache(file, j, r5)).build());
    }

    public s(OkHttpClient okHttpClient) {
        super();
        this.a = okHttpClient;
        okHttpClient.cache();
    }
}
