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
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.d;
import com.google.android.gms.common.util.a;
import com.google.android.gms.common.util.e;
import com.google.android.gms.common.util.h;
import com.google.android.gms.common.util.j;
import com.google.android.gms.internal.firebase-auth-api.r5;
import com.google.android.gms.internal.firebase-auth-api.tl;
import com.google.android.gms.internal.firebase-auth-api.u8;
import com.google.android.gms.internal.firebase-auth-api.ul;
import com.google.android.gms.internal.firebase-auth-api.un;
import com.google.android.gms.internal.firebase-auth-api.up;
import com.google.android.gms.internal.firebase-auth-api.vl;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import d.c.b.c;
import d.c.b.c.a;
import d.q.a.a;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class GenericIdpActivity extends e implements vl {

    private static long zzb;
    private static final com.google.firebase.auth.internal.zzbm zzc;
    private final Executor zzd;
    private boolean zze = false;
    static {
        GenericIdpActivity.zzc = zzbm.zzc();
    }

    public GenericIdpActivity() {
        super();
        this.zzd = u8.a().e(1);
        int i = 0;
    }

    private final void zzh() {
        com.google.firebase.auth.internal.zzbm zzc;
        Object aVar;
        GenericIdpActivity.zzb = 0;
        this.zze = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (!a.b(this).d(intent)) {
            GenericIdpActivity.zzc.zzf(this, zzai.zza("WEB_CONTEXT_CANCELED"));
        } else {
            GenericIdpActivity.zzc.zzd(this);
        }
        finish();
    }

    private final void zzi(Status status) {
        com.google.firebase.auth.internal.zzbm zzc;
        Object applicationContext;
        Object obj3;
        GenericIdpActivity.zzb = 0;
        this.zze = false;
        Intent intent = new Intent();
        zzbl.zzc(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (!a.b(this).d(intent)) {
            GenericIdpActivity.zzc.zzf(getApplicationContext(), status);
        } else {
            GenericIdpActivity.zzc.zzd(this);
        }
        finish();
    }

    @Override // androidx.fragment.app.e
    protected final void onCreate(Bundle bundle) {
        long currentTimeMillis;
        boolean equals;
        String obj8;
        super.onCreate(bundle);
        String action = getIntent().getAction();
        final String str6 = "GenericIdpActivity";
        if (!"com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(action) && !"com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(action) && !"com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(action) && !"android.intent.action.VIEW".equals(action)) {
            if (!"com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(action)) {
                if (!"com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(action)) {
                    if (!"android.intent.action.VIEW".equals(action)) {
                        obj8 = String.valueOf(action);
                        String str = "Could not do operation - unknown action: ";
                        if (obj8.length() != 0) {
                            obj8 = str.concat(obj8);
                        } else {
                            obj8 = new String(str);
                        }
                        Log.e(str6, obj8);
                        zzh();
                    }
                }
            }
        }
        currentTimeMillis = h.b().currentTimeMillis();
        if (Long.compare(i, i2) < 0) {
            Log.e(str6, "Could not start operation - already in progress");
        }
        GenericIdpActivity.zzb = currentTimeMillis;
        if (bundle != null) {
            this.zze = bundle.getBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN");
        }
    }

    @Override // androidx.fragment.app.e
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // androidx.fragment.app.e
    protected final void onResume() {
        Object packageName;
        boolean booleanExtra;
        Object str2;
        String concat;
        Uri build;
        SharedPreferences.Editor edit;
        long currentTimeMillis;
        Uri.Builder upon;
        Object tlVar;
        String stringExtra;
        boolean intent;
        String persistenceKey;
        boolean equals;
        Object str;
        boolean extra;
        StringBuilder stringBuilder;
        super.onResume();
        int i = 1;
        upon = 0;
        Intent intent3 = getIntent();
        String str13 = "firebaseError";
        if ("android.intent.action.VIEW".equals(getIntent().getAction()) && intent3.hasExtra(str13)) {
            intent3 = getIntent();
            str13 = "firebaseError";
            if (intent3.hasExtra(str13)) {
                zzi(zzbl.zzb(intent3.getStringExtra(str13)));
            }
            String str14 = "link";
            extra = "eventId";
            com.google.firebase.auth.internal.zzi zzi = zzj.zzb().zza(this, getPackageName(), intent3.getStringExtra(extra));
            if (intent3.hasExtra(str14) && intent3.hasExtra(extra) && zzi == null) {
                extra = "eventId";
                if (intent3.hasExtra(extra)) {
                    zzi = zzj.zzb().zza(this, getPackageName(), intent3.getStringExtra(extra));
                    if (zzi == null) {
                        zzh();
                    }
                    if (intent3.getBooleanExtra("encryptionEnabled", i)) {
                        stringExtra = zzk.zza(getApplicationContext(), FirebaseApp.getInstance(zzi.zza()).getPersistenceKey()).zzb(intent3.getStringExtra(str14));
                    }
                    up upVar = new up(zzi, stringExtra);
                    String str15 = zzi.zze();
                    currentTimeMillis = zzi.zzb();
                    upVar.n2(str15);
                    if (!"com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(currentTimeMillis) && !"com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(currentTimeMillis)) {
                        if (!"com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(currentTimeMillis)) {
                            if ("com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(currentTimeMillis)) {
                            } else {
                                String str6 = "unsupported operation: ";
                                if (currentTimeMillis.length() != 0) {
                                    concat = str6.concat(currentTimeMillis);
                                } else {
                                    currentTimeMillis = new String(str6);
                                    concat = currentTimeMillis;
                                }
                            }
                            Log.e("GenericIdpActivity", concat);
                            zzh();
                        }
                    }
                    GenericIdpActivity.zzb = 0;
                    this.zze = upon;
                    Intent intent4 = new Intent();
                    d.e(upVar, intent4, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST");
                    intent4.putExtra("com.google.firebase.auth.internal.OPERATION", currentTimeMillis);
                    intent4.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
                    if (!a.b(this).d(intent4)) {
                        edit = getApplicationContext().getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", upon).edit();
                        upon = "verifyAssertionRequest";
                        edit.putString(upon, d.f(upVar));
                        edit.putString("operation", currentTimeMillis);
                        edit.putString("tenantId", str15);
                        edit.putLong("timestamp", h.b().currentTimeMillis());
                        edit.commit();
                    } else {
                        GenericIdpActivity.zzc.zzd(this);
                    }
                    finish();
                }
            }
            zzh();
        }
        if (!this.zze) {
            packageName = getPackageName();
            String lowerCase = j.b(a.a(this, packageName)).toLowerCase(Locale.US);
            FirebaseApp instance = FirebaseApp.getInstance(getIntent().getStringExtra("com.google.firebase.auth.KEY_FIREBASE_APP_NAME"));
            if (!un.g(instance)) {
                tlVar = new tl(packageName, lowerCase, getIntent(), this);
                tlVar.executeOnExecutor(this.zzd, new Void[upon]);
            } else {
                zzf(zzg(Uri.parse(un.a(instance.getOptions().getApiKey())).buildUpon(), getIntent(), packageName, lowerCase).build(), packageName);
            }
            this.zze = i;
        }
        zzh();
    }

    @Override // androidx.fragment.app.e
    protected final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN", this.zze);
    }

    @Override // androidx.fragment.app.e
    public final Context zza() {
        return getApplicationContext();
    }

    @Override // androidx.fragment.app.e
    public final Uri.Builder zzb(Intent intent, String string2, String string3) {
        Uri.Builder builder = new Uri.Builder();
        return zzg(builder.scheme("https").appendPath("__").appendPath("auth").appendPath("handler"), intent, string2, string3);
    }

    @Override // androidx.fragment.app.e
    public final String zzc(String string) {
        return un.b(string);
    }

    @Override // androidx.fragment.app.e
    public final HttpURLConnection zzd(URL uRL) {
        try {
            return (HttpURLConnection)uRL.openConnection();
            uRL = "GenericIdpActivity";
            Log.e(uRL, "Error generating URL connection");
            uRL = null;
            return uRL;
        }
    }

    @Override // androidx.fragment.app.e
    public final void zze(String string, Status status2) {
        if (status2 == null) {
            zzh();
        }
        zzi(status2);
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
        Log.e("GenericIdpActivity", "Device cannot resolve intent for: android.intent.action.VIEW");
        zze(string2, 0);
    }

    @Override // androidx.fragment.app.e
    public final Uri.Builder zzg(Uri.Builder uri$Builder, Intent intent2, String string3, String string4) {
        String concat;
        boolean empty4;
        boolean empty;
        boolean empty3;
        Object stringArrayListExtra;
        Bundle bundleExtra;
        String str2;
        boolean jSONObject;
        Iterator iterator;
        boolean next;
        String string;
        boolean empty2;
        String str;
        int i;
        final vl vlVar = this;
        Object obj = builder;
        Object obj2 = intent2;
        String stringExtra3 = obj2.getStringExtra("com.google.firebase.auth.KEY_PROVIDER_ID");
        final String stringExtra4 = obj2.getStringExtra("com.google.firebase.auth.KEY_TENANT_ID");
        final String stringExtra5 = obj2.getStringExtra("com.google.firebase.auth.KEY_FIREBASE_APP_NAME");
        stringArrayListExtra = obj2.getStringArrayListExtra("com.google.firebase.auth.KEY_PROVIDER_SCOPES");
        final int i2 = 0;
        if (stringArrayListExtra != null && !stringArrayListExtra.isEmpty()) {
            if (!stringArrayListExtra.isEmpty()) {
                i = stringArrayListExtra;
            } else {
                i = i2;
            }
        } else {
        }
        bundleExtra = obj2.getBundleExtra("com.google.firebase.auth.KEY_PROVIDER_CUSTOM_PARAMS");
        if (bundleExtra == null) {
            str = i2;
        } else {
            jSONObject = new JSONObject();
            iterator = bundleExtra.keySet().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                string = bundleExtra.getString((String)next);
                if (!TextUtils.isEmpty(string)) {
                }
                jSONObject.put(next, string);
            }
            str = bundleExtra;
        }
        String string5 = UUID.randomUUID().toString();
        String str34 = ul.a(vlVar, UUID.randomUUID().toString());
        String str40 = str;
        final int i3 = i;
        zzj.zzb().zzd(getApplicationContext(), string3, string5, str34, intent2.getAction(), stringExtra3, stringExtra4, stringExtra5);
        str2 = zzk.zza(getApplicationContext(), FirebaseApp.getInstance(stringExtra5).getPersistenceKey()).zzc();
        if (TextUtils.isEmpty(str2)) {
            Log.e("GenericIdpActivity", "Could not generate an encryption key for Generic IDP - cancelling flow.");
            vlVar.zzi(zzai.zza("Failed to generate/retrieve public encryption key for Generic IDP flow."));
            return i2;
        }
        String str14 = obj23;
        if (str14 == null) {
            return i2;
        }
        String valueOf = String.valueOf(obj2.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION"));
        String str30 = "X";
        if (valueOf.length() != 0) {
            concat = str30.concat(valueOf);
        } else {
            concat = new String(str30);
        }
        obj.appendQueryParameter("eid", "p").appendQueryParameter("v", concat).appendQueryParameter("authType", "signInWithRedirect").appendQueryParameter("apiKey", obj2.getStringExtra("com.google.firebase.auth.KEY_API_KEY")).appendQueryParameter("providerId", stringExtra3).appendQueryParameter("sessionId", str14).appendQueryParameter("eventId", string5).appendQueryParameter("apn", string3).appendQueryParameter("sha1Cert", string4).appendQueryParameter("publicKey", str2);
        if (!TextUtils.isEmpty(i3)) {
            obj.appendQueryParameter("scopes", i3);
        }
        if (!TextUtils.isEmpty(str40)) {
            obj.appendQueryParameter("customParameters", str40);
        }
        if (!TextUtils.isEmpty(stringExtra4)) {
            obj.appendQueryParameter("tid", stringExtra4);
        }
        return obj;
    }
}
