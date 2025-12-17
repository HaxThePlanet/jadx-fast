package com.google.android.gms.internal.firebase-auth-api;

import java.io.OutputStream;

/* loaded from: classes2.dex */
public abstract class jq<MessageType extends com.google.android.gms.internal.firebase-auth-api.jq<MessageType, BuilderType>, BuilderType extends com.google.android.gms.internal.firebase-auth-api.iq<MessageType, BuilderType>>  implements com.google.android.gms.internal.firebase-auth-api.y {

    protected int zza = 0;
    public jq() {
        super();
        final int i = 0;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.y
    int a() {
        throw 0;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.y
    void b(int i) {
        throw 0;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.y
    public final void c(OutputStream outputStream) {
        final com.google.android.gms.internal.firebase-auth-api.gr obj2 = gr.i(outputStream, gr.c(o()));
        r(obj2);
        obj2.m();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.y
    public final com.google.android.gms.internal.firebase-auth-api.wq g() {
        try {
            com.google.android.gms.internal.firebase-auth-api.wq wqVar = wq.a;
            byte[] bArr = new byte[o()];
            com.google.android.gms.internal.firebase-auth-api.gr grVar = gr.h(bArr);
            r(grVar);
            grVar.j();
            vq vqVar = new vq(bArr);
            return vqVar;
            Class string = getClass();
            string = string.getName();
            String str = String.valueOf(string);
            str = str.length();
            str += 72;
            StringBuilder stringBuilder = new StringBuilder(str);
            str = "Serializing ";
            stringBuilder.append(str);
            stringBuilder.append(string);
            string = " to a ByteString threw an IOException (should never happen).";
            stringBuilder.append(string);
            string = stringBuilder.toString();
            RuntimeException runtimeException = new RuntimeException(string, th);
            throw runtimeException;
        }
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.y
    public final byte[] k() {
        try {
            byte[] bArr = new byte[o()];
            final com.google.android.gms.internal.firebase-auth-api.gr grVar = gr.h(bArr);
            r(grVar);
            grVar.j();
            return bArr;
            Class string = getClass();
            string = string.getName();
            String str = String.valueOf(string);
            str = str.length();
            str += 72;
            StringBuilder stringBuilder = new StringBuilder(str);
            str = "Serializing ";
            stringBuilder.append(str);
            stringBuilder.append(string);
            string = " to a byte array threw an IOException (should never happen).";
            stringBuilder.append(string);
            string = stringBuilder.toString();
            RuntimeException runtimeException = new RuntimeException(string, th);
            throw runtimeException;
        }
    }
}
