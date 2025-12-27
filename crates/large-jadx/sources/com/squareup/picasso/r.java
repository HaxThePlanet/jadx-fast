package com.squareup.picasso;

import android.net.NetworkInfo;
import android.net.Uri;
import java.io.IOException;
import okhttp3.CacheControl;
import okhttp3.CacheControl.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: NetworkRequestHandler.java */
/* loaded from: classes2.dex */
class r extends y {

    private final j a;
    private final a0 b;

    static class a extends IOException {
        a(String str) {
            super(str);
        }
    }

    static final class b extends IOException {

        final int code;
        final int networkPolicy;
        b(int i, int i2) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str2 = "HTTP ";
            str = str2 + i;
            super(str);
            this.code = i;
            this.networkPolicy = i2;
        }
    }
    r(j jVar, a0 a0Var) {
        super();
        this.a = jVar;
        this.b = a0Var;
    }

    private static Request j(w wVar, int i) {
        CacheControl cacheControl_Builder2 = null;
        if (i == 0) {
            i = 0;
        } else {
            if (q.isOfflineOnly(i)) {
                cacheControl_Builder2 = CacheControl.FORCE_CACHE;
            } else {
                CacheControl.Builder cacheControl_Builder = new CacheControl_Builder();
                if (!q.shouldReadFromDiskCache(i)) {
                    cacheControl_Builder.noCache();
                }
                if (!q.shouldWriteToDiskCache(i)) {
                    cacheControl_Builder.noStore();
                }
                cacheControl_Builder2 = cacheControl_Builder.build();
            }
        }
        Request.Builder builder = new Request_Builder().url(wVar.d.toString());
        if (cacheControl_Builder2 != null) {
            builder.cacheControl(cacheControl_Builder2);
        }
        return builder.build();
    }

    @Override // com.squareup.picasso.y
    public boolean c(w wVar) {
        boolean equals;
        boolean z = false;
        String scheme = wVar.d.getScheme();
        if (!"http".equals(scheme)) {
            str = "https";
            if (str.equals(scheme)) {
                int i2 = 1;
            } else {
                int i = 0;
            }
        }
        return z;
    }

    @Override // com.squareup.picasso.y
    public y.a f(w wVar, int i) throws r.b, r.a {
        long contentLength2;
        com.squareup.picasso.t.e dISK2;
        Response response = this.a.a(r.j(wVar, i));
        ResponseBody body = response.body();
        if (!response.isSuccessful()) {
            body.close();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) new r.b(response.code(), wVar.c);
        } else {
            wVar = response.cacheResponse() == null ? t.e.NETWORK : t.e.DISK;
            long contentLength = 0L;
            if (dISK2 == t.e.DISK) {
                contentLength2 = body.contentLength();
                if (contentLength2 == contentLength) {
                    body.close();
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) new r.a("Received response with 0 content-length header.");
                }
            }
            if (dISK2 == t.e.NETWORK) {
                contentLength2 = body.contentLength();
                if (contentLength2 > contentLength) {
                    this.b.f(body.contentLength());
                }
            }
            return new y.a(body.source(), dISK2);
        }
    }

    @Override // com.squareup.picasso.y
    boolean h(boolean z, NetworkInfo networkInfo) {
        boolean z2 = false;
        if (networkInfo == null || networkInfo.isConnected()) {
            int i2 = 1;
        }
        return z2;
    }

    @Override // com.squareup.picasso.y
    int e() {
        return 2;
    }

    @Override // com.squareup.picasso.y
    boolean i() {
        return true;
    }
}
