package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.util.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class GoogleSignInAccount extends a implements ReflectedParcelable {

    public static final Parcelable.Creator<com.google.android.gms.auth.api.signin.GoogleSignInAccount> CREATOR;
    private String A;
    List<Scope> B;
    private String C;
    private String D;
    private Set<Scope> E;
    final int a;
    private String b;
    private String c;
    private String v;
    private String w;
    private Uri x;
    private String y;
    private long z;
    static {
        e eVar = new e();
        GoogleSignInAccount.CREATOR = eVar;
        h.b();
    }

    GoogleSignInAccount(int i, String string2, String string3, String string4, String string5, Uri uri6, String string7, long l8, String string9, List<Scope> list10, String string11, String string12) {
        super();
        HashSet hashSet = new HashSet();
        this.E = hashSet;
        this.a = i;
        this.b = string2;
        this.c = string3;
        this.v = string4;
        this.w = string5;
        this.x = uri6;
        this.y = string7;
        this.z = l8;
        this.A = list10;
        this.B = string11;
        this.C = string12;
        this.D = obj14;
    }

    public static com.google.android.gms.auth.api.signin.GoogleSignInAccount o2(String string) {
        int optString6;
        String optString5;
        int i;
        String optString;
        Scope scope;
        String optString2;
        String string2;
        String optString4;
        Uri uri;
        int optString3;
        Object obj13;
        optString6 = 0;
        if (TextUtils.isEmpty(string)) {
            return optString6;
        }
        JSONObject jSONObject = new JSONObject(string);
        obj13 = jSONObject.optString("photoUrl");
        if (!TextUtils.isEmpty(obj13)) {
            uri = obj13;
        } else {
            uri = optString6;
        }
        HashSet hashSet = new HashSet();
        obj13 = jSONObject.getJSONArray("grantedScopes");
        i = 0;
        while (i < obj13.length()) {
            scope = new Scope(obj13.getString(i));
            hashSet.add(scope);
            i++;
        }
        String str5 = "tokenId";
        if (jSONObject.has(str5)) {
            optString5 = jSONObject.optString(str5);
        } else {
            optString5 = optString6;
        }
        String str7 = "email";
        if (jSONObject.has(str7)) {
            optString = jSONObject.optString(str7);
        } else {
            optString = optString6;
        }
        String str9 = "displayName";
        if (jSONObject.has(str9)) {
            optString2 = jSONObject.optString(str9);
        } else {
            optString2 = optString6;
        }
        String str11 = "givenName";
        if (jSONObject.has(str11)) {
            optString4 = jSONObject.optString(str11);
        } else {
            optString4 = optString6;
        }
        String str12 = "familyName";
        if (jSONObject.has(str12)) {
            optString3 = jSONObject.optString(str12);
        } else {
            optString3 = optString6;
        }
        obj13 = GoogleSignInAccount.p2(jSONObject.optString("id"), optString5, optString, optString2, optString4, optString3, uri, Long.valueOf(Long.parseLong(jSONObject.getString("expirationTime"))), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        String str3 = "serverAuthCode";
        if (jSONObject.has(str3)) {
            optString6 = jSONObject.optString(str3);
        }
        obj13.y = optString6;
        return obj13;
    }

    public static com.google.android.gms.auth.api.signin.GoogleSignInAccount p2(String string, String string2, String string3, String string4, String string5, String string6, Uri uri7, Long long8, String string9, Set<Scope> set10) {
        r.f(string9);
        r.j(set10);
        ArrayList arrayList = new ArrayList((Collection)set10);
        super(3, string, string2, string3, string4, uri7, 0, long8.longValue(), obj9, string9, arrayList, string5, string6);
        return googleSignInAccount2;
    }

    public Account b1() {
        String str = this.v;
        if (str == null) {
            return null;
        }
        Account account = new Account(str, "com.google");
        return account;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public boolean equals(Object object) {
        boolean equals;
        Object obj5;
        final int i = 0;
        if (object == null) {
            return i;
        }
        final int i2 = 1;
        if (object == this) {
            return i2;
        }
        if (!object instanceof GoogleSignInAccount) {
            return i;
        }
        if (object.A.equals(this.A) && (GoogleSignInAccount)object.m2().equals(m2())) {
            if (object.m2().equals(m2())) {
                return i2;
            }
        }
        return i;
    }

    public String getDisplayName() {
        return this.w;
    }

    public String getEmail() {
        return this.v;
    }

    public String getIdToken() {
        return this.c;
    }

    public Uri getPhotoUrl() {
        return this.x;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public int hashCode() {
        return i3 += i5;
    }

    public String j2() {
        return this.D;
    }

    public String k2() {
        return this.C;
    }

    public String l2() {
        return this.b;
    }

    public Set<Scope> m2() {
        HashSet hashSet = new HashSet(this.B);
        hashSet.addAll(this.E);
        return hashSet;
    }

    public String n2() {
        return this.y;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String q2() {
        return this.A;
    }

    public final String r2() {
        String str2;
        String idToken;
        String email;
        String displayName2;
        String str;
        String str4;
        Object photoUrl;
        String str5;
        String displayName;
        int i;
        String str3;
        JSONObject jSONObject = new JSONObject();
        if (l2() != null) {
            jSONObject.put("id", l2());
        }
        if (getIdToken() != null) {
            jSONObject.put("tokenId", getIdToken());
        }
        if (getEmail() != null) {
            try {
                jSONObject.put("email", getEmail());
                if (getDisplayName() != null) {
                }
                jSONObject.put("displayName", getDisplayName());
                if (k2() != null) {
                }
                jSONObject.put("givenName", k2());
                if (j2() != null) {
                }
                jSONObject.put("familyName", j2());
                photoUrl = getPhotoUrl();
                if (photoUrl != null) {
                }
                jSONObject.put("photoUrl", photoUrl.toString());
                String str8 = "serverAuthCode";
                if (n2() != null) {
                }
                jSONObject.put(str8, n2());
                jSONObject.put("expirationTime", this.z);
                jSONObject.put("obfuscatedIdentifier", this.A);
                JSONArray jSONArray = new JSONArray();
                List list = this.B;
                Object[] array = list.toArray(new Scope[list.size()]);
                Arrays.sort((Scope[])array, d.a);
                i = 0;
                while (i < array.length) {
                    jSONArray.put(array[i].j2());
                    i++;
                }
                jSONArray.put(array[i].j2());
                i++;
                jSONObject.put("grantedScopes", jSONArray);
                jSONObject.remove(str8);
                return jSONObject.toString();
                RuntimeException runtimeException = new RuntimeException(th);
                throw runtimeException;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public void writeToParcel(Parcel parcel, int i2) {
        b.j(parcel, 1, this.a);
        final int i15 = 0;
        b.o(parcel, 2, l2(), i15);
        b.o(parcel, 3, getIdToken(), i15);
        b.o(parcel, 4, getEmail(), i15);
        b.o(parcel, 5, getDisplayName(), i15);
        int i14 = 6;
        b.n(parcel, i14, getPhotoUrl(), i2, i15);
        b.o(parcel, 7, n2(), i15);
        b.l(parcel, 8, this.z);
        b.o(parcel, 9, this.A, i15);
        b.s(parcel, 10, this.B, i15);
        b.o(parcel, 11, k2(), i15);
        b.o(parcel, 12, j2(), i15);
        b.b(parcel, b.a(parcel));
    }
}
