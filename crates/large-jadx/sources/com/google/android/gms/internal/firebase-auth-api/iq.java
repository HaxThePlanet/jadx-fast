package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public abstract class iq<MessageType extends com.google.android.gms.internal.firebase-auth-api.jq<MessageType, BuilderType>, BuilderType extends com.google.android.gms.internal.firebase-auth-api.iq<MessageType, BuilderType>>  implements com.google.android.gms.internal.firebase-auth-api.x {
    protected abstract BuilderType a(MessageType messagetype);

    @Override // com.google.android.gms.internal.firebase-auth-api.x
    public final com.google.android.gms.internal.firebase-auth-api.x s1(com.google.android.gms.internal.firebase-auth-api.y y) {
        if (!p().getClass().isInstance(y)) {
        } else {
            a((jq)y);
            return this;
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        throw obj2;
    }
}
