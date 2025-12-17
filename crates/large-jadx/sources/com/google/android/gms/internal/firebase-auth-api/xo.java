package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class xo extends a {

    public static final Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.xo> CREATOR;
    private final String a;
    private final String b;
    private final String c;
    private final long v;
    static {
        yo yoVar = new yo();
        xo.CREATOR = yoVar;
    }

    public xo(String string, String string2, String string3, long l4) {
        super();
        this.a = string;
        r.f(string2);
        this.b = string2;
        this.c = string3;
        this.v = l4;
    }

    public static com.google.android.gms.internal.firebase-auth-api.xo k2(JSONObject jSONObject) {
        int optLong;
        Object optJSONObject;
        boolean str;
        boolean z;
        int i = 0;
        if (jSONObject != null) {
            optJSONObject = "enrolledAt";
            if (!jSONObject.has(optJSONObject)) {
            } else {
                optJSONObject = jSONObject.optJSONObject(optJSONObject);
                if (optJSONObject != null) {
                    str = "seconds";
                    if (!optJSONObject.has(str)) {
                    } else {
                        optLong = optJSONObject.optLong(str, 0);
                    }
                }
            }
        }
        super(jSONObject.optString("phoneInfo", i), jSONObject.optString("mfaEnrollmentId", i), jSONObject.optString("displayName", i), optLong, optJSONObject);
        jSONObject.optString("unobfuscatedPhoneInfo");
        return xoVar2;
    }

    public static List<com.google.android.gms.internal.firebase-auth-api.xo> l2(JSONArray jSONArray) {
        int length;
        int i;
        com.google.android.gms.internal.firebase-auth-api.xo xoVar;
        if (jSONArray != null) {
            if (jSONArray.length() == 0) {
            } else {
                ArrayList arrayList = new ArrayList();
                i = 0;
                while (i < jSONArray.length()) {
                    arrayList.add(xo.k2(jSONArray.getJSONObject(i)));
                    i++;
                }
            }
            return arrayList;
        }
        ArrayList obj3 = new ArrayList();
        return obj3;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final long j2() {
        return this.v;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        int i5 = 0;
        b.o(parcel, 1, this.a, i5);
        b.o(parcel, 2, this.b, i5);
        int i4 = 3;
        b.o(parcel, i4, this.c, i5);
        b.l(parcel, 4, this.v);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzc() {
        return this.c;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzd() {
        return this.b;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zze() {
        return this.a;
    }
}
