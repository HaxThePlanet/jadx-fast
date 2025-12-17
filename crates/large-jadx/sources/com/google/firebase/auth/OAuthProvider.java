package com.google.firebase.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.firebase-auth-api.nm;
import com.google.android.gms.internal.firebase-auth-api.un;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public class OAuthProvider extends com.google.firebase.auth.FederatedAuthProvider {

    private final Bundle zza;

    public static class Builder {

        final Bundle zza;
        private final com.google.firebase.auth.FirebaseAuth zzb;
        private final Bundle zzc;
        Builder(String string, com.google.firebase.auth.FirebaseAuth firebaseAuth2, com.google.firebase.auth.zzab zzab3) {
            super();
            Bundle obj6 = new Bundle();
            this.zza = obj6;
            Bundle bundle = new Bundle();
            this.zzc = bundle;
            this.zzb = firebaseAuth2;
            obj6.putString("com.google.firebase.auth.KEY_API_KEY", firebaseAuth2.getApp().getOptions().getApiKey());
            obj6.putString("com.google.firebase.auth.KEY_PROVIDER_ID", string);
            obj6.putBundle("com.google.firebase.auth.KEY_PROVIDER_CUSTOM_PARAMS", bundle);
            obj6.putString("com.google.firebase.auth.internal.CLIENT_VERSION", nm.a().b());
            obj6.putString("com.google.firebase.auth.KEY_TENANT_ID", firebaseAuth2.getTenantId());
            obj6.putString("com.google.firebase.auth.KEY_FIREBASE_APP_NAME", firebaseAuth2.getApp().getName());
        }

        public com.google.firebase.auth.OAuthProvider.Builder addCustomParameter(String string, String string2) {
            this.zzc.putString(string, string2);
            return this;
        }

        public com.google.firebase.auth.OAuthProvider.Builder addCustomParameters(Map<String, String> map) {
            Object value;
            Bundle zzc;
            Object key;
            Iterator obj4 = map.entrySet().iterator();
            for (Map.Entry next2 : obj4) {
                this.zzc.putString((String)next2.getKey(), (String)next2.getValue());
            }
            return this;
        }

        public com.google.firebase.auth.OAuthProvider build() {
            OAuthProvider oAuthProvider = new OAuthProvider(this.zza, 0);
            return oAuthProvider;
        }

        public List<String> getScopes() {
            ArrayList stringArrayList = this.zza.getStringArrayList("com.google.firebase.auth.KEY_PROVIDER_SCOPES");
            if (stringArrayList != null) {
                return stringArrayList;
            }
            return Collections.emptyList();
        }

        public com.google.firebase.auth.OAuthProvider.Builder setScopes(List<String> list) {
            ArrayList arrayList = new ArrayList(list);
            this.zza.putStringArrayList("com.google.firebase.auth.KEY_PROVIDER_SCOPES", arrayList);
            return this;
        }
    }

    public static class CredentialBuilder {

        private final String zza;
        private String zzb;
        private String zzc;
        private String zzd;
        CredentialBuilder(String string, com.google.firebase.auth.zzab zzab2) {
            super();
            this.zza = string;
        }

        public com.google.firebase.auth.AuthCredential build() {
            boolean empty;
            String zza = this.zza;
            final String zzb = this.zzb;
            final String zzc = this.zzc;
            android.os.Parcelable.Creator cREATOR = zze.CREATOR;
            r.g(zza, "Must specify a non-empty providerId");
            if (TextUtils.isEmpty(zzb)) {
                if (TextUtils.isEmpty(zzc)) {
                } else {
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Must specify an idToken or an accessToken.");
                throw illegalArgumentException;
            }
            super(zza, zzb, zzc, 0, 0, 0, this.zzd);
            return zze2;
        }

        public String getAccessToken() {
            return this.zzc;
        }

        public String getIdToken() {
            return this.zzb;
        }

        public com.google.firebase.auth.OAuthProvider.CredentialBuilder setAccessToken(String string) {
            this.zzc = string;
            return this;
        }

        public com.google.firebase.auth.OAuthProvider.CredentialBuilder setIdToken(String string) {
            this.zzb = string;
            return this;
        }

        public com.google.firebase.auth.OAuthProvider.CredentialBuilder setIdTokenWithRawNonce(String string, String string2) {
            this.zzb = string;
            this.zzd = string2;
            return this;
        }
    }
    OAuthProvider(Bundle bundle, com.google.firebase.auth.zzab zzab2) {
        super();
        this.zza = bundle;
    }

    @Deprecated
    public static com.google.firebase.auth.AuthCredential getCredential(String string, String string2, String string3) {
        final int i = 0;
        return zze.zzc(string, string2, string3, i, i);
    }

    public static com.google.firebase.auth.OAuthProvider.Builder newBuilder(String string) {
        return OAuthProvider.newBuilder(string, FirebaseAuth.getInstance());
    }

    public static com.google.firebase.auth.OAuthProvider.Builder newBuilder(String string, com.google.firebase.auth.FirebaseAuth firebaseAuth2) {
        boolean equals;
        r.f(string);
        r.j(firebaseAuth2);
        if ("facebook.com".equals(string)) {
            if (!un.g(firebaseAuth2.getApp())) {
            } else {
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("Sign in with Facebook is not supported via this method; the Facebook TOS dictate that you must use the Facebook Android SDK for Facebook login.");
            throw obj2;
        }
        OAuthProvider.Builder builder = new OAuthProvider.Builder(string, firebaseAuth2, 0);
        return builder;
    }

    public static com.google.firebase.auth.OAuthProvider.CredentialBuilder newCredentialBuilder(String string) {
        r.f(string);
        OAuthProvider.CredentialBuilder credentialBuilder = new OAuthProvider.CredentialBuilder(string, 0);
        return credentialBuilder;
    }

    @Override // com.google.firebase.auth.FederatedAuthProvider
    public String getProviderId() {
        return this.zza.getString("com.google.firebase.auth.KEY_PROVIDER_ID");
    }

    @Override // com.google.firebase.auth.FederatedAuthProvider
    public final void zza(Activity activity) {
        Intent intent = new Intent("com.google.firebase.auth.internal.NONGMSCORE_LINK");
        intent.setClass(activity, GenericIdpActivity.class);
        intent.setPackage(activity.getPackageName());
        intent.putExtras(this.zza);
        activity.startActivity(intent);
    }

    @Override // com.google.firebase.auth.FederatedAuthProvider
    public final void zzb(Activity activity) {
        Intent intent = new Intent("com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE");
        intent.setClass(activity, GenericIdpActivity.class);
        intent.setPackage(activity.getPackageName());
        intent.putExtras(this.zza);
        activity.startActivity(intent);
    }

    @Override // com.google.firebase.auth.FederatedAuthProvider
    public final void zzc(Activity activity) {
        Intent intent = new Intent("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN");
        intent.setClass(activity, GenericIdpActivity.class);
        intent.setPackage(activity.getPackageName());
        intent.putExtras(this.zza);
        activity.startActivity(intent);
    }
}
