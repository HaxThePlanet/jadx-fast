package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.internal.r;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class kp implements com.google.android.gms.internal.firebase-auth-api.lm {

    private String A;
    private String a;
    private String b;
    private String c;
    private String v;
    private String w;
    private String x;
    private final com.google.android.gms.internal.firebase-auth-api.sp y;
    private final com.google.android.gms.internal.firebase-auth-api.sp z;
    public kp() {
        super();
        final int i = 0;
        sp spVar = new sp(i);
        this.y = spVar;
        sp spVar2 = new sp(i);
        this.z = spVar2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final com.google.android.gms.internal.firebase-auth-api.kp a(String string) {
        r.f(string);
        this.z.k2().add(string);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final com.google.android.gms.internal.firebase-auth-api.kp b(String string) {
        String str;
        Object obj2;
        if (string == null) {
            this.y.k2().add("DISPLAY_NAME");
        } else {
            this.b = string;
        }
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final com.google.android.gms.internal.firebase-auth-api.kp c(String string) {
        String str;
        Object obj2;
        if (string == null) {
            this.y.k2().add("EMAIL");
        } else {
            this.c = string;
        }
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final com.google.android.gms.internal.firebase-auth-api.kp d(String string) {
        r.f(string);
        this.a = string;
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final com.google.android.gms.internal.firebase-auth-api.kp e(String string) {
        r.f(string);
        this.w = string;
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final com.google.android.gms.internal.firebase-auth-api.kp f(String string) {
        String str;
        Object obj2;
        if (string == null) {
            this.y.k2().add("PASSWORD");
        } else {
            this.v = string;
        }
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final com.google.android.gms.internal.firebase-auth-api.kp g(String string) {
        String str;
        Object obj2;
        if (string == null) {
            this.y.k2().add("PHOTO_URL");
        } else {
            this.x = string;
        }
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final com.google.android.gms.internal.firebase-auth-api.kp h(String string) {
        this.A = string;
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final String i() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final String j() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final String k() {
        return this.v;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final String l() {
        return this.x;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final boolean m(String string) {
        r.f(string);
        return this.y.k2().contains(string);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final String zza() {
        boolean empty;
        Object jSONArray2;
        int str;
        int i4;
        JSONArray jSONArray;
        int i6;
        int size;
        int i2;
        int i3;
        boolean equals;
        String str2;
        int i;
        int i5;
        JSONObject jSONObject = new JSONObject();
        str = 1;
        jSONObject.put("returnSecureToken", str);
        i4 = 0;
        if (!this.z.k2().isEmpty()) {
            List list2 = this.z.k2();
            jSONArray = new JSONArray();
            i6 = i4;
            while (i6 < list2.size()) {
                jSONArray.put(list2.get(i6));
                i6++;
            }
            jSONObject.put("deleteProvider", jSONArray);
        }
        jSONArray2 = this.y.k2();
        int size2 = jSONArray2.size();
        int[] iArr = new int[size2];
        i2 = i4;
        while (i2 < jSONArray2.size()) {
            equals = jSONArray2.get(i2);
            i = 3;
            i5 = 2;
            i3 = -1;
            if (i3 != 0) {
            } else {
            }
            i5 = str;
            iArr[i2] = i5;
            i2++;
            if (i3 != str) {
            }
            if (i3 != i5) {
            } else {
            }
            i5 = 5;
            if (i3 != i) {
            } else {
            }
            i5 = 4;
            i5 = i4;
            if (equals.equals("PASSWORD")) {
            } else {
            }
            i3 = i5;
            if (equals.equals("PHOTO_URL")) {
            } else {
            }
            i3 = i;
            if (equals.equals("EMAIL")) {
            } else {
            }
            i3 = i4;
            if (equals.equals("DISPLAY_NAME")) {
            } else {
            }
            i3 = str;
        }
        if (size2 > 0) {
            jSONArray2 = new JSONArray();
            while (i4 < size2) {
                jSONArray2.put(iArr[i4]);
                i4++;
            }
            jSONObject.put("deleteAttribute", jSONArray2);
        }
        String str4 = this.a;
        if (str4 != null) {
            jSONObject.put("idToken", str4);
        }
        String str5 = this.c;
        if (str5 != null) {
            jSONObject.put("email", str5);
        }
        String str6 = this.v;
        if (str6 != null) {
            jSONObject.put("password", str6);
        }
        String str7 = this.b;
        if (str7 != null) {
            jSONObject.put("displayName", str7);
        }
        String str8 = this.x;
        if (str8 != null) {
            jSONObject.put("photoUrl", str8);
        }
        String str9 = this.w;
        if (str9 != null) {
            jSONObject.put("oobCode", str9);
        }
        String str10 = this.A;
        if (str10 != null) {
            jSONObject.put("tenantId", str10);
        }
        return jSONObject.toString();
    }
}
