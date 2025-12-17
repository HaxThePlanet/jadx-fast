package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.util.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class bp extends a {

    public static final Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.bp> CREATOR;
    private final List<com.google.android.gms.internal.firebase-auth-api.zo> a;
    static {
        cp cpVar = new cp();
        bp.CREATOR = cpVar;
    }

    public bp() {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
    }

    bp(List<com.google.android.gms.internal.firebase-auth-api.zo> list) {
        boolean empty;
        super();
        if (list != null && !list.isEmpty()) {
            if (!list.isEmpty()) {
                this.a = Collections.unmodifiableList(list);
            }
        }
        this.a = Collections.emptyList();
    }

    public static com.google.android.gms.internal.firebase-auth-api.bp j2(JSONArray jSONArray) {
        int length;
        int i2;
        com.google.android.gms.internal.firebase-auth-api.zo zoVar3;
        com.google.android.gms.internal.firebase-auth-api.zo zoVar2;
        String str5;
        String str4;
        String str6;
        String str3;
        int i;
        String str;
        String str2;
        com.google.android.gms.internal.firebase-auth-api.zo zoVar;
        if (jSONArray != null) {
            if (jSONArray.length() == 0) {
            } else {
                ArrayList arrayList2 = new ArrayList();
                i2 = 0;
                while (i2 < jSONArray.length()) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (jSONObject == null) {
                    } else {
                    }
                    int i3 = 0;
                    super(n.a(jSONObject.optString("federatedId", i3)), n.a(jSONObject.optString("displayName", i3)), n.a(jSONObject.optString("photoUrl", i3)), n.a(jSONObject.optString("providerId", i3)), 0, n.a(jSONObject.optString("phoneNumber", i3)), n.a(jSONObject.optString("email", i3)));
                    zoVar3 = zoVar;
                    arrayList2.add(zoVar3);
                    i2++;
                    zoVar3 = new zo();
                }
            }
            bp obj12 = new bp(arrayList2);
            return obj12;
        }
        ArrayList arrayList = new ArrayList();
        obj12 = new bp(arrayList);
        return obj12;
    }

    public static com.google.android.gms.internal.firebase-auth-api.bp k2(com.google.android.gms.internal.firebase-auth-api.bp bp) {
        List list;
        final List obj2 = bp.a;
        bp bpVar = new bp();
        if (obj2 != null) {
            bpVar.a.addAll(obj2);
        }
        return bpVar;
    }

    public final List<com.google.android.gms.internal.firebase-auth-api.zo> l2() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        b.s(parcel, 2, this.a, false);
        b.b(parcel, b.a(parcel));
    }
}
