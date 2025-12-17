package com.google.firebase.auth.internal;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.firebase-auth-api.a5;
import com.google.android.gms.internal.firebase-auth-api.f5;
import com.google.android.gms.internal.firebase-auth-api.k2;
import com.google.android.gms.internal.firebase-auth-api.k5;
import com.google.android.gms.internal.firebase-auth-api.l5;
import com.google.android.gms.internal.firebase-auth-api.v1;
import com.google.android.gms.internal.firebase-auth-api.z1;
import java.io.ByteArrayOutputStream;

/* loaded from: classes2.dex */
public final class zzk {

    private static com.google.firebase.auth.internal.zzk zza;
    private final String zzb;
    private final l5 zzc = null;
    private zzk(Context context, String string2, boolean z3) {
        super();
        this.zzb = string2;
        a5.a();
        k5 obj8 = new k5();
        final int i = 1;
        Object[] arr = new Object[i];
        final int i2 = 0;
        arr[i2] = string2;
        obj8.f(context, "GenericIdpKeyset", String.format("com.google.firebase.auth.api.crypto.%s", arr));
        obj8.d(f5.b);
        Object[] obj6 = new Object[i];
        obj6[i2] = string2;
        obj8.e(String.format("android-keystore://firebear_master_key_id.%s", obj6));
        obj6 = obj8.g();
    }

    public static com.google.firebase.auth.internal.zzk zza(Context context, String string2) {
        String equals;
        int i;
        equals = zzk.zza;
        if (equals != null) {
            equals = equals.zzb;
            if (equals != string2) {
                if (equals != null) {
                    if (!equals.equals(string2)) {
                        equals = new zzk(context, string2, 1);
                        zzk.zza = equals;
                    }
                } else {
                }
            }
        } else {
        }
        return zzk.zza;
    }

    public final String zzb(String string) {
        l5 zzc = this.zzc;
        final int i = 0;
        if (zzc != null) {
            String string2 = new String((z1)this.zzc.a().e(z1.class).a(Base64.decode(string, 8), i), "UTF-8");
            return string2;
            synchronized (zzc) {
                string2 = new String((z1)this.zzc.a().e(z1.class).a(Base64.decode(string, 8), i), "UTF-8");
                return string2;
            }
        }
        Log.e("FirebearCryptoHelper", "KeysetManager failed to initialize - unable to decrypt payload");
        return i;
    }

    public final String zzc() {
        if (this.zzc == null) {
            Log.e("FirebearCryptoHelper", "KeysetManager failed to initialize - unable to get Public key");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final l5 zzc2 = this.zzc;
        this.zzc.a().b().h(v1.c(byteArrayOutputStream));
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 8);
        synchronized (zzc2) {
            byteArrayOutputStream = new ByteArrayOutputStream();
            zzc2 = this.zzc;
            this.zzc.a().b().h(v1.c(byteArrayOutputStream));
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 8);
        }
    }
}
