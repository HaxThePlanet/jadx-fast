package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.util.n;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ko extends a implements com.google.android.gms.internal.firebase-auth-api.mm<com.google.android.gms.internal.firebase-auth-api.ko> {

    public static final Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.ko> CREATOR;
    private static final String b;
    private com.google.android.gms.internal.firebase-auth-api.oo a;
    static {
        ko.b = ko.class.getSimpleName();
        lo loVar = new lo();
        ko.CREATOR = loVar;
    }

    ko(com.google.android.gms.internal.firebase-auth-api.oo oo) {
        com.google.android.gms.internal.firebase-auth-api.oo obj1;
        super();
        if (oo == null) {
            obj1 = new oo();
        } else {
            obj1 = oo.j2(oo);
        }
        this.a = obj1;
    }

    public final List<com.google.android.gms.internal.firebase-auth-api.mo> j2() {
        return this.a.k2();
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        b.n(parcel, 2, this.a, i2, false);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final com.google.android.gms.internal.firebase-auth-api.mm zza(String string) {
        com.google.android.gms.internal.firebase-auth-api.oo ooVar;
        Object jSONObject;
        Parcelable.Creator cREATOR;
        boolean optLong;
        int i;
        int moVar;
        com.google.android.gms.internal.firebase-auth-api.mo moVar2;
        String str4;
        String str6;
        boolean z;
        String str;
        String str2;
        com.google.android.gms.internal.firebase-auth-api.bp bpVar;
        String str5;
        String str3;
        long l2;
        long optLong2;
        long l;
        int i3;
        int i2;
        List list;
        com.google.android.gms.internal.firebase-auth-api.mo moVar3;
        int i4;
        final Object obj = this;
        String str7 = "users";
        jSONObject = new JSONObject(string);
        if (!jSONObject.has(str7)) {
            ooVar = new oo();
            obj.a = ooVar;
        } else {
            JSONArray optJSONArray = jSONObject.optJSONArray(str7);
            cREATOR = oo.CREATOR;
            if (optJSONArray != null) {
                if (optJSONArray.length() == 0) {
                    jSONObject = new ArrayList();
                    ooVar = new oo(jSONObject);
                } else {
                    jSONObject = new ArrayList(optJSONArray.length());
                    i = optLong;
                    try {
                        while (i < optJSONArray.length()) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                            if (jSONObject2 == null) {
                            } else {
                            }
                            int i6 = 0;
                            i4 = i;
                            int i5 = 0;
                            optLong2 = jSONObject2.optLong("createdAt", i5);
                            super(n.a(jSONObject2.optString("localId", i6)), n.a(jSONObject2.optString("email", i6)), jSONObject2.optBoolean("emailVerified", optLong), n.a(jSONObject2.optString("displayName", i6)), n.a(jSONObject2.optString("photoUrl", i6)), bp.j2(jSONObject2.optJSONArray("providerUserInfo")), n.a(jSONObject2.optString("rawPassword", i6)), n.a(jSONObject2.optString("phoneNumber", i6)), optLong2, optLong2, jSONObject2.optLong("lastLoginAt", i5), obj19, 0, 0, xo.l2(jSONObject2.optJSONArray("mfaInfo")));
                            moVar = moVar3;
                            jSONObject.add(moVar);
                            i = i4 + 1;
                            optLong = 0;
                            moVar = new mo();
                            i4 = i;
                        }
                        jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 == null) {
                        } else {
                        }
                        moVar = new mo();
                        i4 = i;
                        i6 = 0;
                        i4 = i;
                        i5 = 0;
                        optLong2 = jSONObject2.optLong("createdAt", i5);
                        super(n.a(jSONObject2.optString("localId", i6)), n.a(jSONObject2.optString("email", i6)), jSONObject2.optBoolean("emailVerified", optLong), n.a(jSONObject2.optString("displayName", i6)), n.a(jSONObject2.optString("photoUrl", i6)), bp.j2(jSONObject2.optJSONArray("providerUserInfo")), n.a(jSONObject2.optString("rawPassword", i6)), n.a(jSONObject2.optString("phoneNumber", i6)), optLong2, optLong2, jSONObject2.optLong("lastLoginAt", i5), obj19, 0, 0, xo.l2(jSONObject2.optJSONArray("mfaInfo")));
                        moVar = moVar3;
                        jSONObject.add(moVar);
                        i = i4 + 1;
                        optLong = 0;
                        ooVar = new oo(jSONObject);
                        jSONObject = new ArrayList();
                        ooVar = new oo(jSONObject);
                        obj.a = ooVar;
                        return obj;
                        Throwable th = hq.a(th, ko.b, obj2);
                        throw th;
                    }
                }
            } else {
            }
        }
    }
}
