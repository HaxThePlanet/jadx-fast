package com.google.android.gms.internal.firebase-auth-api;

import android.util.Log;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class o5 implements com.google.android.gms.internal.firebase-auth-api.n2 {

    private static final String b = "o5";
    private KeyStore a;
    static {
    }

    public o5() {
        n5 n5Var = new n5();
        super();
        this.a = n5Var.a;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.n2
    public final boolean a(String string) {
        int obj2;
        synchronized (this) {
            try {
                obj2 = 1;
                return obj2;
                obj2 = 0;
                throw string;
            }
        }
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.n2
    final boolean b(String string) {
        return this.a.containsAlias(ed.a("android-keystore://", string));
        synchronized (this) {
            return this.a.containsAlias(ed.a("android-keystore://", string));
        }
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.n2
    public final com.google.android.gms.internal.firebase-auth-api.u1 zza(String string) {
        m5 m5Var = new m5(ed.a("android-keystore://", string), this.a);
        byte[] obj4 = cd.a(10);
        byte[] bArr = new byte[0];
        synchronized (this) {
            try {
                return m5Var;
                obj4 = new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
                throw obj4;
                throw string;
            }
        }
    }
}
