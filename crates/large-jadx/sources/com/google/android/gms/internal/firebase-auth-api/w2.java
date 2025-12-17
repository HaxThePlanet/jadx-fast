package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public final class w2<PrimitiveT, KeyProtoT extends com.google.android.gms.internal.firebase-auth-api.y, PublicKeyProtoT extends com.google.android.gms.internal.firebase-auth-api.y>  extends com.google.android.gms.internal.firebase-auth-api.d2<PrimitiveT, KeyProtoT> implements com.google.android.gms.internal.firebase-auth-api.b2 {

    private final com.google.android.gms.internal.firebase-auth-api.j2<PublicKeyProtoT> c;
    public w2(com.google.android.gms.internal.firebase-auth-api.x2<KeyProtoT, PublicKeyProtoT> x2, com.google.android.gms.internal.firebase-auth-api.j2<PublicKeyProtoT> j22, Class<PrimitiveT> class3) {
        super(x2, class3);
        this.c = j22;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.d2
    public final com.google.android.gms.internal.firebase-auth-api.aa g(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        try {
            com.google.android.gms.internal.firebase-auth-api.y8 obj3 = y8.C(wq, lr.a());
            x4.l(obj3);
            obj3 = obj3.D();
            this.c.i(obj3);
            com.google.android.gms.internal.firebase-auth-api.x9 x9Var = aa.z();
            x9Var.m("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey");
            x9Var.s(obj3.g());
            x9Var.j(z9.zzd);
            return (aa)x9Var.e();
            GeneralSecurityException generalSecurityException = new GeneralSecurityException("expected serialized proto of type ", wq);
            throw generalSecurityException;
        }
    }
}
