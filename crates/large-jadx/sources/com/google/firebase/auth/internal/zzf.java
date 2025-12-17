package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.firebase-auth-api.nm;
import com.google.android.gms.internal.firebase-auth-api.ql;
import com.google.android.gms.internal.firebase-auth-api.un;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.android.gms.tasks.m;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import f.c.a.d.c.c;
import f.c.a.d.c.f;
import java.io.UnsupportedEncodingException;

/* loaded from: classes2.dex */
public final class zzf {

    private static final String zza = "zzf";
    private static final com.google.firebase.auth.internal.zzf zzb;
    static {
        zzf zzf = new zzf();
        zzf.zzb = zzf;
    }

    public static com.google.firebase.auth.internal.zzf zzb() {
        return zzf.zzb;
    }

    static String zzc() {
        return zzf.zza;
    }

    static void zzd(com.google.firebase.auth.internal.zzf zzf, FirebaseAuth firebaseAuth2, com.google.firebase.auth.internal.zzbm zzbm3, Activity activity4, k k5) {
        zzf.zze(firebaseAuth2, zzbm3, activity4, k5);
    }

    private final void zze(FirebaseAuth firebaseAuth, com.google.firebase.auth.internal.zzbm zzbm2, Activity activity3, k<com.google.firebase.auth.internal.zze> k4) {
        boolean intent;
        String str2;
        boolean tenantId;
        String str3;
        String str;
        j obj4;
        int obj5;
        Object obj6;
        zzbm2.zzg(firebaseAuth.getApp().getApplicationContext(), firebaseAuth);
        r.j(activity3);
        obj5 = new k();
        if (!zzax.zza().zzg(activity3, obj5)) {
            obj4 = new Status(17057, "reCAPTCHA flow already in progress");
            obj4 = m.d(ql.a(obj4));
        } else {
            intent = new Intent("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
            intent.setClass(activity3, RecaptchaActivity.class);
            intent.setPackage(activity3.getPackageName());
            intent.putExtra("com.google.firebase.auth.KEY_API_KEY", firebaseAuth.getApp().getOptions().getApiKey());
            if (!TextUtils.isEmpty(firebaseAuth.getTenantId())) {
                intent.putExtra("com.google.firebase.auth.KEY_TENANT_ID", firebaseAuth.getTenantId());
            }
            intent.putExtra("com.google.firebase.auth.internal.CLIENT_VERSION", nm.a().b());
            intent.putExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME", firebaseAuth.getApp().getName());
            activity3.startActivity(intent);
            obj4 = obj5.a();
        }
        obj5 = new zzd(this, k4);
        obj5 = new zzc(this, k4);
        obj4.addOnSuccessListener(obj5).addOnFailureListener(obj5);
    }

    public final j<com.google.firebase.auth.internal.zze> zza(FirebaseAuth firebaseAuth, String string2, Activity activity3, boolean z4) {
        Object firebaseAuthSettings;
        int bArr;
        j str;
        String string;
        boolean successful;
        int length;
        com.google.firebase.auth.internal.zzbm zzbm;
        Activity activity;
        k kVar;
        k kVar2;
        j obj11;
        Object obj12;
        f obj14;
        firebaseAuthSettings = firebaseAuth.getFirebaseAuthSettings();
        bArr = 0;
        if (z4) {
            obj14 = c.a(firebaseAuth.getApp().getApplicationContext());
        } else {
            obj14 = bArr;
        }
        final com.google.firebase.auth.internal.zzbm zzbm3 = zzbm.zzc();
        if (!un.g(firebaseAuth.getApp())) {
            if ((zzw)firebaseAuthSettings.zze()) {
                obj11 = new zze(bArr, bArr);
                obj11 = m.e(obj11);
            } else {
                kVar2 = new k();
                str = zzbm3.zzb();
                if (str != null) {
                    if (str.isSuccessful()) {
                        obj11 = new zze(bArr, (String)str.getResult());
                        obj11 = m.e(obj11);
                    } else {
                        bArr = zzf.zza;
                        String valueOf = String.valueOf(str.getException().getMessage());
                        successful = "Error in previous reCAPTCHA flow: ";
                        if (valueOf.length() != 0) {
                            string = successful.concat(valueOf);
                        } else {
                            string = new String(successful);
                        }
                        Log.e(bArr, string);
                        Log.e(bArr, "Continuing with application verification as normal");
                        if (obj14 != null && !firebaseAuthSettings.zzc()) {
                            if (!firebaseAuthSettings.zzc()) {
                                bArr = new byte[0];
                                if (string2 != null) {
                                    bArr = string2.getBytes("UTF-8");
                                }
                                successful = this;
                                super(successful, kVar2, firebaseAuth, zzbm3, activity3);
                                super(successful, firebaseAuth, zzbm3, activity3, kVar2);
                                obj14.b(bArr, firebaseAuth.getApp().getOptions().getApiKey()).addOnSuccessListener(obj14).addOnFailureListener(obj14);
                            } else {
                                zze(firebaseAuth, zzbm3, activity3, kVar2);
                            }
                        } else {
                        }
                        obj11 = kVar2.a();
                    }
                } else {
                }
            }
        } else {
        }
        return obj11;
    }
}
