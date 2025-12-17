package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.e;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.l.a;
import com.google.android.gms.common.util.a;
import com.google.android.gms.common.util.e;
import com.google.android.gms.common.util.h;
import com.google.android.gms.common.util.j;
import com.google.android.gms.internal.firebase-auth-api.qm;
import com.google.android.gms.internal.firebase-auth-api.r5;
import com.google.android.gms.internal.firebase-auth-api.tl;
import com.google.android.gms.internal.firebase-auth-api.u8;
import com.google.android.gms.internal.firebase-auth-api.un;
import com.google.android.gms.internal.firebase-auth-api.vl;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import d.c.b.c;
import d.c.b.c.a;
import d.q.a.a;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class RecaptchaActivity extends e implements vl {

    private static final String zzb;
    private static final ExecutorService zzc;
    private static long zzd;
    private static final com.google.firebase.auth.internal.zzbm zze;
    private boolean zzf = false;
    static {
        RecaptchaActivity.zzb = RecaptchaActivity.class.getSimpleName();
        RecaptchaActivity.zzc = u8.a().e(2);
        RecaptchaActivity.zzd = 0;
        RecaptchaActivity.zze = zzbm.zzc();
    }

    public RecaptchaActivity() {
        super();
        final int i = 0;
    }

    private final void zzg() {
        RecaptchaActivity.zzd = 0;
        this.zzf = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        a.b(this).d(intent);
        RecaptchaActivity.zze.zzd(this);
        finish();
    }

    private final void zzh(Status status) {
        RecaptchaActivity.zzd = 0;
        this.zzf = false;
        Intent intent = new Intent();
        zzbl.zzc(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        a.b(this).d(intent);
        RecaptchaActivity.zze.zzd(this);
        finish();
    }

    @Override // androidx.fragment.app.e
    protected final void onCreate(Bundle bundle) {
        long currentTimeMillis;
        String concat;
        boolean equals;
        Bundle obj7;
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if (!"com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA".equals(action) && !"android.intent.action.VIEW".equals(action)) {
            if (!"android.intent.action.VIEW".equals(action)) {
                String valueOf = String.valueOf(action);
                String str4 = "Could not do operation - unknown action: ";
                if (valueOf.length() != 0) {
                    concat = str4.concat(valueOf);
                } else {
                    concat = new String(str4);
                }
                Log.e(RecaptchaActivity.zzb, concat);
                zzg();
            }
        }
        currentTimeMillis = h.b().currentTimeMillis();
        if (Long.compare(i, i2) < 0) {
            Log.e(RecaptchaActivity.zzb, "Could not start operation - already in progress");
        }
        RecaptchaActivity.zzd = currentTimeMillis;
        if (bundle != null) {
            this.zzf = bundle.getBoolean("com.google.firebase.auth.internal.KEY_ALREADY_STARTED_RECAPTCHA_FLOW");
        }
    }

    @Override // androidx.fragment.app.e
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // androidx.fragment.app.e
    protected final void onResume() {
        boolean booleanExtra;
        com.google.firebase.auth.internal.zzbm currentTimeMillis;
        int persistenceKey;
        Void[] arr;
        int edit;
        String lowerCase;
        String stringExtra;
        boolean str2;
        tl tlVar;
        Object str;
        boolean extra;
        Intent intent;
        boolean empty;
        boolean length;
        StringBuilder stringBuilder;
        Object applicationContext;
        super.onResume();
        persistenceKey = 1;
        edit = 0;
        Intent intent3 = getIntent();
        String str7 = "firebaseError";
        if ("android.intent.action.VIEW".equals(getIntent().getAction()) && intent3.hasExtra(str7)) {
            intent3 = getIntent();
            str7 = "firebaseError";
            if (intent3.hasExtra(str7)) {
                zzh(zzbl.zzb(intent3.getStringExtra(str7)));
            }
            String str8 = "link";
            extra = "eventId";
            String str10 = zzj.zzb().zzc(getApplicationContext(), getPackageName(), intent3.getStringExtra(extra));
            if (intent3.hasExtra(str8) && intent3.hasExtra(extra) && TextUtils.isEmpty(str10)) {
                extra = "eventId";
                if (intent3.hasExtra(extra)) {
                    str10 = zzj.zzb().zzc(getApplicationContext(), getPackageName(), intent3.getStringExtra(extra));
                    if (TextUtils.isEmpty(str10)) {
                        Log.e(RecaptchaActivity.zzb, "Failed to find registration for this event - failing to prevent session injection.");
                        zzh(zzai.zza("Failed to find registration for this reCAPTCHA event"));
                    }
                    if (intent3.getBooleanExtra("encryptionEnabled", persistenceKey)) {
                        stringExtra = zzk.zza(getApplicationContext(), FirebaseApp.getInstance(str10).getPersistenceKey()).zzb(intent3.getStringExtra(str8));
                    }
                    String str5 = "recaptchaToken";
                    String queryParameter = Uri.parse(stringExtra).getQueryParameter(str5);
                    RecaptchaActivity.zzd = 0;
                    this.zzf = edit;
                    Intent intent4 = new Intent();
                    intent4.putExtra("com.google.firebase.auth.internal.RECAPTCHA_TOKEN", queryParameter);
                    String str16 = "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA";
                    intent4.putExtra("com.google.firebase.auth.internal.OPERATION", str16);
                    intent4.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
                    if (!a.b(this).d(intent4)) {
                        edit = getApplicationContext().getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", edit).edit();
                        edit.putString(str5, queryParameter);
                        edit.putString("operation", str16);
                        edit.putLong("timestamp", h.b().currentTimeMillis());
                        edit.commit();
                    } else {
                        RecaptchaActivity.zze.zzd(this);
                    }
                    finish();
                }
            }
            zzg();
        }
        if (!this.zzf) {
            String packageName = getPackageName();
            tlVar = new tl(packageName, j.b(a.a(this, packageName)).toLowerCase(Locale.US), getIntent(), this);
            tlVar.executeOnExecutor(RecaptchaActivity.zzc, new Void[edit]);
            this.zzf = persistenceKey;
        }
        zzg();
    }

    @Override // androidx.fragment.app.e
    protected final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_ALREADY_STARTED_RECAPTCHA_FLOW", this.zzf);
    }

    @Override // androidx.fragment.app.e
    public final Context zza() {
        return getApplicationContext();
    }

    @Override // androidx.fragment.app.e
    public final Uri.Builder zzb(Intent intent, String string2, String string3) {
        String string;
        String languageCode;
        String string4 = UUID.randomUUID().toString();
        String obj12 = intent.getStringExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME");
        final FirebaseApp instance = FirebaseApp.getInstance(obj12);
        final FirebaseAuth instance2 = FirebaseAuth.getInstance(instance);
        zzj.zzb().zze(getApplicationContext(), string2, string4, "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA", obj12);
        String str11 = zzk.zza(getApplicationContext(), instance.getPersistenceKey()).zzc();
        if (TextUtils.isEmpty(str11)) {
            Log.e(RecaptchaActivity.zzb, "Could not generate an encryption key for reCAPTCHA - cancelling flow.");
            zzh(zzai.zza("Failed to generate/retrieve public encryption key for reCAPTCHA flow."));
            return null;
        }
        if (!TextUtils.isEmpty(instance2.getLanguageCode())) {
            languageCode = instance2.getLanguageCode();
        } else {
            languageCode = qm.a();
        }
        Uri.Builder builder = new Uri.Builder();
        String valueOf = String.valueOf(intent.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION"));
        String str6 = "X";
        if (valueOf.length() != 0) {
            string = str6.concat(valueOf);
        } else {
            string = new String(str6);
        }
        return builder.scheme("https").appendPath("__").appendPath("auth").appendPath("handler").appendQueryParameter("apiKey", intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY")).appendQueryParameter("authType", "verifyApp").appendQueryParameter("apn", string2).appendQueryParameter("hl", languageCode).appendQueryParameter("eventId", string4).appendQueryParameter("v", string).appendQueryParameter("eid", "p").appendQueryParameter("appName", obj12).appendQueryParameter("sha1Cert", string3).appendQueryParameter("publicKey", str11);
    }

    @Override // androidx.fragment.app.e
    public final String zzc(String string) {
        return un.b(string);
    }

    @Override // androidx.fragment.app.e
    public final HttpURLConnection zzd(URL uRL) {
        try {
            return (HttpURLConnection)uRL.openConnection();
            uRL = vl.g;
            int arr = 0;
            arr = new Object[arr];
            uRL.c("Error generating connection", arr);
            uRL = null;
            return uRL;
        }
    }

    @Override // androidx.fragment.app.e
    public final void zze(String string, Status status2) {
        if (status2 == null) {
            zzg();
        }
        zzh(status2);
    }

    @Override // androidx.fragment.app.e
    public final void zzf(Uri uri, String string2) {
        List intentServices;
        final String str2 = "android.intent.action.VIEW";
        Intent intent = new Intent(str2);
        int i2 = 0;
        Intent intent5 = new Intent("android.support.customtabs.action.CustomTabsService");
        intentServices = getPackageManager().queryIntentServices(intent5, i2);
        int i = 268435456;
        int i3 = 1073741824;
        if (getPackageManager().resolveActivity(intent, i2) != null && intentServices != null && !intentServices.isEmpty()) {
            intent5 = new Intent("android.support.customtabs.action.CustomTabsService");
            intentServices = getPackageManager().queryIntentServices(intent5, i2);
            i = 268435456;
            i3 = 1073741824;
            if (intentServices != null) {
                if (!intentServices.isEmpty()) {
                    c.a obj7 = new c.a();
                    obj7 = obj7.a();
                    obj7.a.addFlags(i3);
                    obj7.a.addFlags(i);
                    obj7.a(this, uri);
                }
            }
            Intent intent2 = new Intent(str2, uri);
            intent2.putExtra("com.android.browser.application_id", string2);
            intent2.addFlags(i3);
            intent2.addFlags(i);
            startActivity(intent2);
        }
        Log.e(RecaptchaActivity.zzb, "Device cannot resolve intent for: android.intent.action.VIEW");
        zze(string2, 0);
    }
}
