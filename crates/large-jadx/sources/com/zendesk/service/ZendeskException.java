package com.zendesk.service;

import f.g.e.f;

/* loaded from: classes2.dex */
public class ZendeskException extends Exception {

    private final com.zendesk.service.a errorResponse;
    @Override // java.lang.Exception
    public String toString() {
        String str;
        com.zendesk.service.a errorResponse = this.errorResponse;
        if (errorResponse == null) {
            str = "null";
        } else {
            str = errorResponse.b();
        }
        Object[] arr = new Object[3];
        return String.format("ZendeskException{details=%s,errorResponse=%s,cause=%s}", super.toString(), str, f.b(getCause()));
    }
}
