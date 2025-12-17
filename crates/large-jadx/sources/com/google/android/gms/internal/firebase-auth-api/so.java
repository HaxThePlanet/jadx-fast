package com.google.android.gms.internal.firebase-auth-api;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class so implements com.google.android.gms.internal.firebase-auth-api.mm<com.google.android.gms.internal.firebase-auth-api.so> {

    private static final String b = "so";
    private List<String> a;
    static {
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final com.google.android.gms.internal.firebase-auth-api.so a(String string) {
        int str;
        List length;
        String string2;
        try {
            JSONObject jSONObject = new JSONObject(string);
            ArrayList arrayList = new ArrayList();
            this.a = arrayList;
            JSONArray optJSONArray = jSONObject.optJSONArray("authorizedDomains");
            if (optJSONArray != null) {
            }
            str = 0;
            while (str < optJSONArray.length()) {
                this.a.add(optJSONArray.getString(str));
                str++;
            }
            this.a.add(optJSONArray.getString(str));
            str++;
            return this;
            string = hq.a(th, so.b, string);
            throw string;
        }
    }

    public final List<String> b() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final com.google.android.gms.internal.firebase-auth-api.mm zza(String string) {
        a(string);
        return this;
    }
}
