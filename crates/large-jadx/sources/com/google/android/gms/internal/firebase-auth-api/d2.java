package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.Set;

/* loaded from: classes2.dex */
class d2<PrimitiveT, KeyProtoT extends com.google.android.gms.internal.firebase-auth-api.y>  implements com.google.android.gms.internal.firebase-auth-api.b2<PrimitiveT> {

    private final com.google.android.gms.internal.firebase-auth-api.j2<KeyProtoT> a;
    private final Class<PrimitiveT> b;
    public d2(com.google.android.gms.internal.firebase-auth-api.j2<KeyProtoT> j2, Class<PrimitiveT> class2) {
        boolean contains;
        super();
        if (!j2.h().contains(class2)) {
            if (!Void.class.equals(class2)) {
            } else {
            }
            Object[] arr = new Object[2];
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", j2.toString(), class2.getName()));
            throw illegalArgumentException;
        }
        this.a = j2;
        this.b = class2;
    }

    private final com.google.android.gms.internal.firebase-auth-api.c2<?, KeyProtoT> e() {
        c2 c2Var = new c2(this.a.a());
        return c2Var;
    }

    private final PrimitiveT f(KeyProtoT keyprotot) {
        if (Void.class.equals(this.b)) {
        } else {
            this.a.i(keyprotot);
            return this.a.f(keyprotot, this.b);
        }
        GeneralSecurityException obj3 = new GeneralSecurityException("Cannot create a primitive for Void");
        throw obj3;
    }

    public final PrimitiveT a(com.google.android.gms.internal.firebase-auth-api.y y) {
        String concat;
        String valueOf = String.valueOf(this.a.e().getName());
        final String str = "Expected proto of type ";
        if (valueOf.length() != 0) {
            concat = str.concat(valueOf);
        } else {
            concat = new String(str);
        }
        if (!this.a.e().isInstance(y)) {
        } else {
            return f(y);
        }
        GeneralSecurityException obj4 = new GeneralSecurityException(concat);
        throw obj4;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.b2
    public final com.google.android.gms.internal.firebase-auth-api.aa b(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        try {
            com.google.android.gms.internal.firebase-auth-api.x9 x9Var = aa.z();
            x9Var.m(this.a.g());
            x9Var.s(e().a(wq).g());
            x9Var.j(this.a.b());
            return (aa)x9Var.e();
            GeneralSecurityException generalSecurityException = new GeneralSecurityException("Unexpected proto", wq);
            throw generalSecurityException;
        }
    }

    public final PrimitiveT c(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        com.google.android.gms.internal.firebase-auth-api.j2 string;
        try {
            return f(this.a.c(wq));
            string = this.a;
            string = string.e();
            string = string.getName();
            string = String.valueOf(string);
            String str = "Failures parsing proto of type ";
            if (string.length() != 0) {
            } else {
            }
            string = str.concat(string);
            string = new String(str);
            GeneralSecurityException generalSecurityException = new GeneralSecurityException(string, wq);
            throw generalSecurityException;
        }
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.b2
    public final com.google.android.gms.internal.firebase-auth-api.y d(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        com.google.android.gms.internal.firebase-auth-api.j2 string;
        try {
            return e().a(wq);
            string = this.a;
            string = string.a();
            string = string.b();
            string = string.getName();
            string = String.valueOf(string);
            String str = "Failures parsing proto of type ";
            if (string.length() != 0) {
            } else {
            }
            string = str.concat(string);
            string = new String(str);
            GeneralSecurityException generalSecurityException = new GeneralSecurityException(string, wq);
            throw generalSecurityException;
        }
    }
}
