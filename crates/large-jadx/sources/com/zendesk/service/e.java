package com.zendesk.service;

import f.g.c.a;

/* compiled from: SafeZendeskCallback.java */
/* loaded from: classes2.dex */
public class e<T> extends f<T> {

    private boolean a = false;
    private final f<T> b;
    public e(f<T> fVar) {
        super();
        this.b = fVar;
    }

    public static <T> e<T> a(f<T> fVar) {
        return new e(fVar);
    }

    @Override // com.zendesk.service.f
    public void cancel() {
        this.a = true;
    }

    @Override // com.zendesk.service.f
    public void onError(a aVar) {
        if (this.a || this.b == null) {
            str = "SafeZendeskCallback";
            a.c(str, aVar);
        } else {
            this.b.onError(aVar);
        }
    }

    @Override // com.zendesk.service.f
    public void onSuccess(T t) {
        if (this.a || this.b == null) {
            str = "SafeZendeskCallback";
            str2 = "Operation was a success but callback is null or was cancelled";
            a.k(str, str2, new Object[0]);
        } else {
            this.b.onSuccess(t);
        }
    }
}
