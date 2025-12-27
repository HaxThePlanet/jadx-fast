package com.zendesk.service;

import f.g.e.f;

/* compiled from: ZendeskException.java */
/* loaded from: classes2.dex */
public class ZendeskException extends Exception {

    private final a errorResponse;
    @Override // java.lang.Exception
    public String toString() {
        String str;
        if (this.errorResponse == null) {
            str = "null";
        } else {
            str = this.errorResponse.b();
        }
        Object[] arr = new Object[3];
        return String.format("ZendeskException{details=%s,errorResponse=%s,cause=%s}", new Object[] { super.toString(), str, f.b(getCause()) });
    }
}
