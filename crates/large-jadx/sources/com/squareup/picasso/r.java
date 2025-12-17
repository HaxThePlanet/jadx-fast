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

/* loaded from: classes2.dex */
class r extends com.squareup.picasso.y {

    private final com.squareup.picasso.j a;
    private final com.squareup.picasso.a0 b;

    static class a extends IOException {
        a(String string) {
            super(string);
        }
    }

    static final class b extends IOException {

        final int code;
        final int networkPolicy;
        b(int i, int i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("HTTP ");
            stringBuilder.append(i);
            super(stringBuilder.toString());
            this.code = i;
            this.networkPolicy = i2;
        }
    }
    r(com.squareup.picasso.j j, com.squareup.picasso.a0 a02) {
        super();
        this.a = j;
        this.b = a02;
    }

    private static Request j(com.squareup.picasso.w w, int i2) {
        CacheControl.Builder offlineOnly;
        boolean readFromDiskCache;
        CacheControl obj3;
        if (i2 != 0) {
            if (q.isOfflineOnly(i2)) {
                obj3 = CacheControl.FORCE_CACHE;
            } else {
                offlineOnly = new CacheControl.Builder();
                if (!q.shouldReadFromDiskCache(i2)) {
                    offlineOnly.noCache();
                }
                if (!q.shouldWriteToDiskCache(i2)) {
                    offlineOnly.noStore();
                }
                obj3 = offlineOnly.build();
            }
        } else {
            obj3 = 0;
        }
        Request.Builder builder = new Request.Builder();
        Request.Builder obj2 = builder.url(w.d.toString());
        if (obj3 != null) {
            obj2.cacheControl(obj3);
        }
        return obj2.build();
    }

    @Override // com.squareup.picasso.y
    public boolean c(com.squareup.picasso.w w) {
        String equals;
        int obj2;
        obj2 = w.d.getScheme();
        if (!"http".equals(obj2)) {
            if ("https".equals(obj2)) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    @Override // com.squareup.picasso.y
    int e() {
        return 2;
    }

    @Override // com.squareup.picasso.y
    public com.squareup.picasso.y.a f(com.squareup.picasso.w w, int i2) {
        int contentLength2;
        long contentLength;
        com.squareup.picasso.t.e obj6;
        com.squareup.picasso.t.e obj7;
        obj7 = this.a.a(r.j(w, i2));
        ResponseBody body = obj7.body();
        if (!obj7.isSuccessful()) {
        } else {
            obj6 = obj7.cacheResponse() == null ? t.e.NETWORK : t.e.DISK;
            contentLength2 = 0;
            if (obj6 == t.e.DISK) {
                if (Long.compare(contentLength, contentLength2) == 0) {
                } else {
                }
                body.close();
                obj6 = new r.a("Received response with 0 content-length header.");
                throw obj6;
            }
            if (obj6 == t.e.NETWORK && Long.compare(contentLength, contentLength2) > 0) {
                if (Long.compare(contentLength, contentLength2) > 0) {
                    this.b.f(body.contentLength());
                }
            }
            obj7 = new y.a(body.source(), obj6);
            return obj7;
        }
        body.close();
        r.b bVar = new r.b(obj7.code(), w.c);
        throw bVar;
    }

    @Override // com.squareup.picasso.y
    boolean h(boolean z, NetworkInfo networkInfo2) {
        int obj1;
        if (networkInfo2 != null) {
            if (networkInfo2.isConnected()) {
                obj1 = 1;
            } else {
                obj1 = 0;
            }
        } else {
        }
        return obj1;
    }

    @Override // com.squareup.picasso.y
    boolean i() {
        return 1;
    }
}
