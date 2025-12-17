package com.zendesk.service;

import f.g.c.a;

/* loaded from: classes2.dex */
public class e<T>  extends com.zendesk.service.f<T> {

    private boolean a = false;
    private final com.zendesk.service.f<T> b;
    public e(com.zendesk.service.f<T> f) {
        super();
        this.b = f;
        final int obj1 = 0;
    }

    public static <T> com.zendesk.service.e<T> a(com.zendesk.service.f<T> f) {
        e eVar = new e(f);
        return eVar;
    }

    @Override // com.zendesk.service.f
    public void cancel() {
        this.a = true;
    }

    @Override // com.zendesk.service.f
    public void onError(com.zendesk.service.a a) {
        boolean str;
        str = this.b;
        if (!this.a && str != null) {
            str = this.b;
            if (str != null) {
                str.onError(a);
            } else {
                a.c("SafeZendeskCallback", a);
            }
        } else {
        }
    }

    public void onSuccess(T t) {
        boolean str2;
        String str;
        Object[] obj3;
        str2 = this.b;
        if (!this.a && str2 != null) {
            str2 = this.b;
            if (str2 != null) {
                str2.onSuccess(t);
            } else {
                a.k("SafeZendeskCallback", "Operation was a success but callback is null or was cancelled", new Object[0]);
            }
        } else {
        }
    }
}
