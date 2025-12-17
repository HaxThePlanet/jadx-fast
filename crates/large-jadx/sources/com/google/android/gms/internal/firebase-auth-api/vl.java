package com.google.android.gms.internal.firebase-auth-api;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.l.a;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes2.dex */
public interface vl {

    public static final a g;
    static {
        a aVar = new a("FirebaseAuth", /* result */);
        vl.g = aVar;
    }

    public abstract Context zza();

    public abstract Uri.Builder zzb(Intent intent, String string2, String string3);

    public abstract String zzc(String string);

    public abstract HttpURLConnection zzd(URL uRL);

    public abstract void zze(String string, Status status2);

    public abstract void zzf(Uri uri, String string2);
}
