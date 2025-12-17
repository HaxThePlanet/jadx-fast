package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class yn extends a implements com.google.android.gms.internal.firebase-auth-api.mm<com.google.android.gms.internal.firebase-auth-api.yn> {

    public static final Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.yn> CREATOR;
    private static final String y;
    private String a;
    private boolean b;
    private String c;
    private boolean v;
    private com.google.android.gms.internal.firebase-auth-api.sp w;
    private List<String> x;
    static {
        yn.y = yn.class.getSimpleName();
        zn znVar = new zn();
        yn.CREATOR = znVar;
    }

    public yn() {
        super();
        sp spVar = new sp(0);
        this.w = spVar;
    }

    public yn(String string, boolean z2, String string3, boolean z4, com.google.android.gms.internal.firebase-auth-api.sp sp5, List<String> list6) {
        com.google.android.gms.internal.firebase-auth-api.sp obj1;
        int obj2;
        super();
        this.a = string;
        this.b = z2;
        this.c = string3;
        this.v = z4;
        if (sp5 == null) {
            obj1 = new sp(0);
        } else {
            obj1 = sp.j2(sp5);
        }
        this.w = obj1;
        this.x = list6;
    }

    public final List<String> j2() {
        return this.x;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i9 = 0;
        b.o(parcel, 2, this.a, i9);
        b.c(parcel, 3, this.b);
        b.o(parcel, 4, this.c, i9);
        b.c(parcel, 5, this.v);
        b.n(parcel, 6, this.w, i2, i9);
        b.q(parcel, 7, this.x, i9);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final com.google.android.gms.internal.firebase-auth-api.mm zza(String string) {
        Object spVar;
        boolean spVar2;
        int i;
        String str = "allProviders";
        JSONObject jSONObject = new JSONObject(string);
        i = 0;
        this.a = jSONObject.optString("authUri", i);
        final int i2 = 0;
        this.b = jSONObject.optBoolean("registered", i2);
        this.c = jSONObject.optString("providerId", i);
        this.v = jSONObject.optBoolean("forExistingProvider", i2);
        if (!jSONObject.has(str)) {
            spVar = new sp(i);
            this.w = spVar;
        } else {
            try {
                spVar2 = new sp(1, hq.b(jSONObject.optJSONArray(str)));
                this.w = spVar2;
                this.x = hq.b(jSONObject.optJSONArray("signinMethods"));
                return this;
                string = hq.a(th, yn.y, string);
                throw string;
            }
        }
    }
}
