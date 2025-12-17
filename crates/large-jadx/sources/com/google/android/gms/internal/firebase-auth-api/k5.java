package com.google.android.gms.internal.firebase-auth-api;

import android.content.Context;
import android.os.Build.VERSION;
import android.security.keystore.KeyGenParameterSpec.Builder;
import android.util.Log;
import java.io.FileNotFoundException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.ProviderException;
import javax.crypto.KeyGenerator;

/* loaded from: classes2.dex */
public final class k5 {

    private com.google.android.gms.internal.firebase-auth-api.m2 a = null;
    private String b = null;
    private com.google.android.gms.internal.firebase-auth-api.u1 c = null;
    private com.google.android.gms.internal.firebase-auth-api.e2 d = null;
    private com.google.android.gms.internal.firebase-auth-api.l2 e;
    private com.google.android.gms.internal.firebase-auth-api.p5 f = null;
    public k5() {
        super();
        final int i = 0;
    }

    static com.google.android.gms.internal.firebase-auth-api.u1 a(com.google.android.gms.internal.firebase-auth-api.k5 k5) {
        return k5.c;
    }

    static com.google.android.gms.internal.firebase-auth-api.l2 b(com.google.android.gms.internal.firebase-auth-api.k5 k5) {
        return k5.e;
    }

    static com.google.android.gms.internal.firebase-auth-api.m2 c(com.google.android.gms.internal.firebase-auth-api.k5 k5) {
        return k5.a;
    }

    private final com.google.android.gms.internal.firebase-auth-api.u1 h() {
        android.security.keystore.KeyGenParameterSpec build;
        KeyGenerator instance;
        String[] strArr;
        int i;
        o5 o5Var = new o5();
        final String str6 = "cannot use Android Keystore, it'll be disabled";
        if (Build.VERSION.SDK_INT >= 23 && !o5Var.b(this.b)) {
            o5Var = new o5();
            str6 = "cannot use Android Keystore, it'll be disabled";
            if (!o5Var.b(this.b)) {
                String str8 = this.b;
                o5 o5Var2 = new o5();
                if (o5Var2.b(str8)) {
                } else {
                    instance = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                    KeyGenParameterSpec.Builder builder = new KeyGenParameterSpec.Builder(ed.a("android-keystore://", str8), 3);
                    instance.init(builder.setKeySize(256).setBlockModes(/* result */).setEncryptionPaddings(/* result */).build());
                    instance.generateKey();
                }
                Object[] arr = new Object[1];
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("cannot generate a new key %s because it already exists; please delete it with deleteKey() and try again", str8));
                throw illegalArgumentException;
            }
            return o5Var.zza(this.b);
        }
        Log.w(l5.b(), "Android Keystore requires at least Android M");
        return null;
    }

    private final com.google.android.gms.internal.firebase-auth-api.l2 i() {
        com.google.android.gms.internal.firebase-auth-api.u1 u1Var;
        String str;
        String str2;
        u1Var = this.c;
        if (u1Var != null) {
            return l2.f(k2.i(this.f, u1Var));
        }
        return l2.f(w1.b(this.f));
    }

    @Deprecated
    public final com.google.android.gms.internal.firebase-auth-api.k5 d(com.google.android.gms.internal.firebase-auth-api.fa fa) {
        int i;
        int i2 = l5.d;
        com.google.android.gms.internal.firebase-auth-api.hb zza = hb.zza;
        int obj7 = fa.C().ordinal();
        final int i3 = 3;
        final int i4 = 2;
        final int i5 = 1;
        if (obj7 != i5) {
            if (obj7 != i4) {
                if (obj7 != i3) {
                    if (obj7 != 4) {
                    } else {
                    }
                    obj7 = new IllegalArgumentException("Unknown output prefix type");
                    throw obj7;
                }
                i = i3;
            } else {
                i = i4;
            }
        } else {
            i = i5;
        }
        this.d = e2.e(fa.E(), fa.D().B(), i);
        return this;
    }

    public final com.google.android.gms.internal.firebase-auth-api.k5 e(String string) {
        if (!string.startsWith("android-keystore://")) {
        } else {
            this.b = string;
            return this;
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("key URI must start with android-keystore://");
        throw obj2;
    }

    public final com.google.android.gms.internal.firebase-auth-api.k5 f(Context context, String string2, String string3) {
        if (context == null) {
        } else {
            String obj3 = "GenericIdpKeyset";
            p5 p5Var = new p5(context, obj3, string3);
            this.f = p5Var;
            q5 q5Var = new q5(context, obj3, string3);
            this.a = q5Var;
            return this;
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("need an Android context");
        throw obj2;
    }

    public final com.google.android.gms.internal.firebase-auth-api.l5 g() {
        Object str2;
        String str3;
        String str;
        com.google.android.gms.internal.firebase-auth-api.u1 u1Var;
        synchronized (this) {
            try {
                this.c = h();
                str3 = l5.b();
                str = "keyset not found, will generate a new one";
                Log.i(str3, str, th);
                Throwable th = this.d;
                if (th == null) {
                } else {
                }
                th = l2.e();
                str3 = this.d;
                th.c(str3);
                str3 = th.b();
                str3 = str3.d();
                str = null;
                str3 = str3.A(str);
                str3 = str3.z();
                th.d(str3);
                str3 = this.c;
                if (str3 != null) {
                } else {
                }
                str3 = th.b();
                str = this.a;
                str3.g(str, this.c);
                str3 = th.b();
                str = this.a;
                w1.a(str3, str);
                this.e = i();
                l5 l5Var = new l5(this, 0);
                return l5Var;
                str3 = "cannot read or generate keyset";
                th = new GeneralSecurityException(str3);
                throw th;
                throw th;
            } catch (java.io.FileNotFoundException fileNotFound) {
            } catch (Throwable th1) {
            }
        }
    }
}
