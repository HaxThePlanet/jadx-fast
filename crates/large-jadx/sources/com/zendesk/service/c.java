package com.zendesk.service;

import f.g.e.g;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.ResponseBody;

/* compiled from: RetrofitErrorResponse.java */
/* loaded from: classes2.dex */
public class c implements a {

    private Throwable a;
    private retrofit2.Response b;
    private c(Throwable th) {
        super();
        this.a = th;
    }

    public static c f(retrofit2.Response response) {
        return new c(response);
    }

    public static c g(Throwable th) {
        return new c(th);
    }

    public String a() {
        if (this.b != null && this.b.errorBody() != null) {
            return this.b.errorBody().contentType().toString();
        }
        return "";
    }

    public String b() {
        if (this.a != null) {
            return this.a.getMessage();
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (this.b != null) {
            if (g.c(this.b.message())) {
                stringBuilder.append(this.b.message());
            } else {
                stringBuilder.append(this.b.code());
            }
        }
        return stringBuilder.toString();
    }

    public boolean c() {
        boolean z2 = false;
        if (this.a != null) {
            int r0 = th instanceof IOException ? 1 : 0;
        }
        return (th instanceof IOException ? 1 : 0);
    }

    public String d() {
        String string;
        if (this.b != null && this.b.errorBody() != null) {
            try {
                str = "UTF-8";
                string = new String(this.b.errorBody().bytes(), str);
            } catch (java.io.UnsupportedEncodingException unused) {
                throw new AssertionError("UTF-8 must be supported");
            } catch (java.io.IOException unused) {
                string = "";
            }
        }
        return string;
    }

    public boolean e() {
        boolean z = true;
        int r0 = this.a == null && this.b != null && !this.b.isSuccessful() ? 1 : 0;
        return (this.a == null && this.b != null && !this.b.isSuccessful() ? 1 : 0);
    }

    public String getUrl() {
        String httpUrl;
        if (this.b != null) {
            if (this.b.raw().request() != null) {
                if (this.b.raw().request().url() == null) {
                    httpUrl = "";
                } else {
                    httpUrl = this.b.raw().request().url().toString();
                }
            }
        }
        return httpUrl;
    }

    public int m() {
        if (this.b != null) {
            return this.b.code();
        }
        return -1;
    }

    private c(retrofit2.Response response) {
        super();
        this.b = response;
    }
}
