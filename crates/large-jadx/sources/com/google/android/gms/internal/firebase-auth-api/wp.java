package com.google.android.gms.internal.firebase-auth-api;

import android.text.TextUtils;
import com.google.android.gms.common.util.n;
import com.google.firebase.auth.zze;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class wp implements com.google.android.gms.internal.firebase-auth-api.mm<com.google.android.gms.internal.firebase-auth-api.wp> {

    private static final String I = "wp";
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private List<com.google.android.gms.internal.firebase-auth-api.xo> G;
    private String H;
    private boolean a;
    private String b;
    private String c;
    private long v;
    private String w;
    private String x;
    private String y;
    private boolean z;
    static {
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final long a() {
        return this.v;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final zze b() {
        boolean empty;
        if (TextUtils.isEmpty(this.A) && !TextUtils.isEmpty(this.B)) {
            if (!TextUtils.isEmpty(this.B)) {
            }
            return null;
        }
        return zze.zzc(this.x, this.B, this.A, this.E, this.C);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final String c() {
        return this.w;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final String d() {
        return this.D;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final String e() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final String f() {
        return this.H;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final String g() {
        return this.x;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final String h() {
        return this.y;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final String i() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final String j() {
        return this.F;
    }

    public final List<com.google.android.gms.internal.firebase-auth-api.xo> k() {
        return this.G;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final boolean l() {
        if (!TextUtils.isEmpty(this.H)) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final boolean m() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final boolean n() {
        return this.z;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final boolean o() {
        boolean empty;
        if (!this.a && !TextUtils.isEmpty(this.D)) {
            if (!TextUtils.isEmpty(this.D)) {
            }
            return 0;
        }
        return 1;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final com.google.android.gms.internal.firebase-auth-api.mm zza(String string) {
        try {
            JSONObject jSONObject = new JSONObject(string);
            final int i = 0;
            this.a = jSONObject.optBoolean("needConfirmation", i);
            jSONObject.optBoolean("needEmail", i);
            final int i2 = 0;
            this.b = n.a(jSONObject.optString("idToken", i2));
            this.c = n.a(jSONObject.optString("refreshToken", i2));
            this.v = jSONObject.optLong("expiresIn", 0);
            n.a(jSONObject.optString("localId", i2));
            this.w = n.a(jSONObject.optString("email", i2));
            n.a(jSONObject.optString("displayName", i2));
            n.a(jSONObject.optString("photoUrl", i2));
            this.x = n.a(jSONObject.optString("providerId", i2));
            this.y = n.a(jSONObject.optString("rawUserInfo", i2));
            this.z = jSONObject.optBoolean("isNewUser", i);
            this.A = jSONObject.optString("oauthAccessToken", i2);
            this.B = jSONObject.optString("oauthIdToken", i2);
            this.D = n.a(jSONObject.optString("errorMessage", i2));
            this.E = n.a(jSONObject.optString("pendingToken", i2));
            this.F = n.a(jSONObject.optString("tenantId", i2));
            this.G = xo.l2(jSONObject.optJSONArray("mfaInfo"));
            this.H = n.a(jSONObject.optString("mfaPendingCredential", i2));
            this.C = n.a(jSONObject.optString("oauthTokenSecret", i2));
            return this;
            string = hq.a(th, wp.I, string);
            throw string;
        }
    }
}
