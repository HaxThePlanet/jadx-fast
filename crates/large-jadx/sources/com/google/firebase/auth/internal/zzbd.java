package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.d;
import com.google.android.gms.common.util.e;
import com.google.android.gms.common.util.h;
import com.google.android.gms.internal.firebase-auth-api.ql;
import com.google.android.gms.internal.firebase-auth-api.up;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.zze;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzbd {

    static final long zza = 3600000L;
    private static final List<String> zzb;
    private static final com.google.firebase.auth.internal.zzbd zzc;
    private j<AuthResult> zzd;
    private j<String> zze;
    private long zzf = 0;
    static {
        ArrayList arrayList = new ArrayList(Arrays.asList(/* result */));
        zzbd.zzb = arrayList;
        zzbd zzbd = new zzbd();
        zzbd.zzc = zzbd;
    }

    private zzbd() {
        super();
        final int i = 0;
    }

    public static com.google.firebase.auth.internal.zzbd zzc() {
        return zzbd.zzc;
    }

    private static final void zzf(SharedPreferences sharedPreferences) {
        Object next;
        final SharedPreferences.Editor obj2 = sharedPreferences.edit();
        Iterator iterator = zzbd.zzb.iterator();
        for (String next : iterator) {
            obj2.remove(next);
        }
        obj2.commit();
    }

    public final j<AuthResult> zza() {
        if (Long.compare(i, zza) < 0) {
            return this.zzd;
        }
        return 0;
    }

    public final j<String> zzb() {
        if (Long.compare(i, zza) < 0) {
            return this.zze;
        }
        return 0;
    }

    public final void zzd(Context context) {
        r.j(context);
        zzbd.zzf(context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
        this.zzd = 0;
        this.zzf = 0;
    }

    public final void zze(FirebaseAuth firebaseAuth) {
        com.google.android.gms.common.internal.safeparcel.c cVar;
        boolean string2;
        boolean contains;
        boolean currentUser;
        String str2;
        String long;
        String string;
        int str;
        int i;
        Object obj13;
        r.j(firebaseAuth);
        SharedPreferences sharedPreferences = firebaseAuth.getApp().getApplicationContext().getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0);
        long = "";
        if (!firebaseAuth.getApp().getName().equals(sharedPreferences.getString("firebaseAppName", long))) {
        }
        String str5 = "verifyAssertionRequest";
        final int i4 = -1;
        String str9 = "operation";
        int i5 = 0;
        String str11 = "timestamp";
        final int i8 = 0;
        cVar = d.c(sharedPreferences.getString(str5, long), up.CREATOR);
        string = sharedPreferences.getString(str9, long);
        String string6 = sharedPreferences.getString("tenantId", i8);
        String string5 = sharedPreferences.getString("firebaseUserUid", long);
        this.zzf = sharedPreferences.getLong(str11, i5);
        if (sharedPreferences.contains(str5) && string6 != null) {
            cVar = d.c(sharedPreferences.getString(str5, long), up.CREATOR);
            string = sharedPreferences.getString(str9, long);
            string6 = sharedPreferences.getString("tenantId", i8);
            string5 = sharedPreferences.getString("firebaseUserUid", long);
            this.zzf = sharedPreferences.getLong(str11, i5);
            if (string6 != null) {
                firebaseAuth.setTenantId(string6);
                (up)(up)cVar.n2(string6);
            }
            str = string.hashCode();
            final int i6 = 2;
            int i7 = 1;
            if (str != -98509410) {
                if (str != 175006864) {
                    if (str != 1450464913) {
                        currentUser = i4;
                    } else {
                        if (string.equals("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN")) {
                        } else {
                        }
                    }
                } else {
                    if (string.equals("com.google.firebase.auth.internal.NONGMSCORE_LINK")) {
                        currentUser = i7;
                    } else {
                    }
                }
            } else {
                if (string.equals("com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE")) {
                    currentUser = i6;
                } else {
                }
            }
            if (currentUser != 0) {
                if (currentUser != i7) {
                    if (currentUser != i6) {
                        this.zzd = i8;
                    } else {
                        if (firebaseAuth.getCurrentUser().getUid().equals(string5)) {
                            this.zzd = firebaseAuth.zzf(firebaseAuth.getCurrentUser(), zze.zzb(cVar));
                        } else {
                            this.zzd = i8;
                        }
                    }
                } else {
                    if (firebaseAuth.getCurrentUser().getUid().equals(string5)) {
                        this.zzd = firebaseAuth.zzd(firebaseAuth.getCurrentUser(), zze.zzb(cVar));
                    } else {
                        this.zzd = i8;
                    }
                }
            } else {
                this.zzd = firebaseAuth.signInWithCredential(zze.zzb(cVar));
            }
            zzbd.zzf(sharedPreferences);
        }
        obj13 = "recaptchaToken";
        if (sharedPreferences.contains(obj13)) {
            string2 = sharedPreferences.getString(str9, long);
            this.zzf = sharedPreferences.getLong(str11, i5);
            if (string2.hashCode() != -214796028) {
                currentUser = i4;
            } else {
                if (string2.equals("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA")) {
                } else {
                }
            }
            if (currentUser != 0) {
                this.zze = i8;
            } else {
                this.zze = m.e(sharedPreferences.getString(obj13, long));
            }
            zzbd.zzf(sharedPreferences);
        }
        obj13 = "statusCode";
        if (sharedPreferences.contains(obj13)) {
            currentUser = new Status(sharedPreferences.getInt(obj13, 17062), sharedPreferences.getString("statusMessage", long));
            this.zzf = sharedPreferences.getLong(str11, i5);
            zzbd.zzf(sharedPreferences);
            this.zzd = m.d(ql.a(currentUser));
        }
    }
}
