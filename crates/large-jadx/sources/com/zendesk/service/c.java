package com.zendesk.service;

import f.g.e.g;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Response;

/* loaded from: classes2.dex */
public class c implements com.zendesk.service.a {

    private Throwable a;
    private Response b;
    private c(Throwable throwable) {
        super();
        this.a = throwable;
    }

    private c(Response response) {
        super();
        this.b = response;
    }

    public static com.zendesk.service.c f(Response response) {
        c cVar = new c(response);
        return cVar;
    }

    public static com.zendesk.service.c g(Throwable throwable) {
        c cVar = new c(throwable);
        return cVar;
    }

    @Override // com.zendesk.service.a
    public String a() {
        Object errorBody;
        errorBody = this.b;
        if (errorBody != null && errorBody.errorBody() != null) {
            if (errorBody.errorBody() != null) {
                return this.b.errorBody().contentType().toString();
            }
        }
        return "";
    }

    @Override // com.zendesk.service.a
    public String b() {
        Response message;
        Throwable th = this.a;
        if (th != null) {
            return th.getMessage();
        }
        StringBuilder stringBuilder = new StringBuilder();
        message = this.b;
        if (message != null) {
            if (g.c(message.message())) {
                stringBuilder.append(this.b.message());
            } else {
                stringBuilder.append(this.b.code());
            }
        }
        return stringBuilder.toString();
    }

    @Override // com.zendesk.service.a
    public boolean c() {
        Throwable th;
        int i;
        th = this.a;
        if (th != null && th instanceof IOException != null) {
            i = th instanceof IOException != null ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // com.zendesk.service.a
    public String d() {
        String string;
        Object errorBody;
        byte[] bytes;
        String str;
        errorBody = this.b;
        if (errorBody != null && errorBody.errorBody() != null) {
            if (errorBody.errorBody() != null) {
                string = new String(this.b.errorBody().bytes(), "UTF-8");
            } else {
                string = "";
            }
        } else {
        }
        return string;
    }

    @Override // com.zendesk.service.a
    public boolean e() {
        int i;
        Throwable successful;
        successful = this.b;
        if (this.a == null && successful != null && !successful.isSuccessful()) {
            successful = this.b;
            if (successful != null) {
                i = !successful.isSuccessful() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // com.zendesk.service.a
    public String getUrl() {
        Object request;
        String string;
        request = this.b;
        if (request != null && request.raw().request() != null) {
            if (request.raw().request() != null) {
                if (this.b.raw().request().url() == null) {
                    string = "";
                } else {
                    string = this.b.raw().request().url().toString();
                }
            } else {
            }
        } else {
        }
        return string;
    }

    @Override // com.zendesk.service.a
    public int m() {
        Response response = this.b;
        if (response != null) {
            return response.code();
        }
        return -1;
    }
}
