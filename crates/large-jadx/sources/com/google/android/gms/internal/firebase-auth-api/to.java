package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.util.e;
import com.google.android.gms.common.util.h;
import com.google.android.gms.common.util.n;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class to extends a implements com.google.android.gms.internal.firebase-auth-api.mm<com.google.android.gms.internal.firebase-auth-api.to> {

    public static final Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.to> CREATOR;
    private static final String x;
    private String a;
    private String b;
    private Long c;
    private String v;
    private Long w;
    static {
        to.x = to.class.getSimpleName();
        uo uoVar = new uo();
        to.CREATOR = uoVar;
    }

    public to() {
        super();
        this.w = Long.valueOf(System.currentTimeMillis());
    }

    public to(String string, String string2, Long long3, String string4) {
        super(string, string2, long3, string4, Long.valueOf(System.currentTimeMillis()));
    }

    to(String string, String string2, Long long3, String string4, Long long5) {
        super();
        this.a = string;
        this.b = string2;
        this.c = long3;
        this.v = string4;
        this.w = long5;
    }

    public static com.google.android.gms.internal.firebase-auth-api.to l2(String string) {
        try {
            JSONObject jSONObject = new JSONObject(string);
            to obj5 = new to();
            final int i = 0;
            obj5.a = jSONObject.optString("refresh_token", i);
            obj5.b = jSONObject.optString("access_token", i);
            obj5.c = Long.valueOf(jSONObject.optLong("expires_in"));
            obj5.v = jSONObject.optString("token_type", i);
            String str6 = "issued_at";
            obj5.w = Long.valueOf(jSONObject.optLong(str6));
            return obj5;
            String zzll = to.x;
            Log.d(zzll, "Failed to read GetTokenResponse from JSONObject");
            zzll = new zzll(string);
            throw zzll;
        }
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final long j2() {
        Long num = this.c;
        if (num == null) {
            return 0;
        }
        return num.longValue();
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final long k2() {
        return this.w.longValue();
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void m2(String string) {
        r.f(string);
        this.a = string;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final boolean n2() {
        if (Long.compare(i5, i) < 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i7 = 0;
        b.o(parcel, 2, this.a, i7);
        int i3 = 3;
        b.o(parcel, i3, this.b, i7);
        b.m(parcel, 4, Long.valueOf(j2()), i7);
        int i5 = 5;
        b.o(parcel, i5, this.v, i7);
        b.m(parcel, 6, Long.valueOf(this.w.longValue()), i7);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final com.google.android.gms.internal.firebase-auth-api.mm zza(String string) {
        try {
            JSONObject jSONObject = new JSONObject(string);
            this.a = n.a(jSONObject.optString("refresh_token"));
            this.b = n.a(jSONObject.optString("access_token"));
            final int i = 0;
            this.c = Long.valueOf(jSONObject.optLong("expires_in", i));
            String str8 = "token_type";
            this.v = n.a(jSONObject.optString(str8));
            this.w = Long.valueOf(System.currentTimeMillis());
            return this;
            string = hq.a(th, to.x, string);
            throw string;
        }
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zze() {
        return this.b;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzf() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzg() {
        return this.v;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzh() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("refresh_token", this.a);
        jSONObject.put("access_token", this.b);
        jSONObject.put("expires_in", this.c);
        jSONObject.put("token_type", this.v);
        jSONObject.put("issued_at", this.w);
        return jSONObject.toString();
    }
}
