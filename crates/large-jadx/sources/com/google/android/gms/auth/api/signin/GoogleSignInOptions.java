package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.auth.api.signin.internal.a;
import com.google.android.gms.auth.api.signin.internal.b;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class GoogleSignInOptions extends a implements a.d, ReflectedParcelable {

    public static final Parcelable.Creator<com.google.android.gms.auth.api.signin.GoogleSignInOptions> CREATOR;
    public static final com.google.android.gms.auth.api.signin.GoogleSignInOptions D;
    public static final Scope E;
    public static final Scope F;
    public static final Scope G;
    public static final Scope H;
    public static final Scope I;
    private static Comparator<Scope> J;
    private ArrayList<a> A;
    private String B;
    private Map<Integer, a> C;
    final int a;
    private final ArrayList<Scope> b;
    private Account c;
    private boolean v;
    private final boolean w;
    private final boolean x;
    private String y;
    private String z;

    public static final class a {

        private Set<Scope> a;
        private boolean b;
        private boolean c;
        private boolean d;
        private String e;
        private Account f;
        private String g;
        private Map<Integer, a> h;
        private String i;
        public a() {
            super();
            HashSet hashSet = new HashSet();
            this.a = hashSet;
            HashMap hashMap = new HashMap();
            this.h = hashMap;
        }

        public a(com.google.android.gms.auth.api.signin.GoogleSignInOptions googleSignInOptions) {
            super();
            HashSet hashSet = new HashSet();
            this.a = hashSet;
            HashMap hashMap = new HashMap();
            this.h = hashMap;
            r.j(googleSignInOptions);
            HashSet hashSet2 = new HashSet(GoogleSignInOptions.s2(googleSignInOptions));
            this.a = hashSet2;
            this.b = GoogleSignInOptions.t2(googleSignInOptions);
            this.c = GoogleSignInOptions.u2(googleSignInOptions);
            this.d = GoogleSignInOptions.v2(googleSignInOptions);
            this.e = GoogleSignInOptions.w2(googleSignInOptions);
            this.f = GoogleSignInOptions.x2(googleSignInOptions);
            this.g = GoogleSignInOptions.y2(googleSignInOptions);
            this.h = GoogleSignInOptions.A2(GoogleSignInOptions.z2(googleSignInOptions));
            this.i = GoogleSignInOptions.B2(googleSignInOptions);
        }

        private final String h(String string) {
            String equals;
            int i;
            r.f(string);
            equals = this.e;
            i = 1;
            if (equals != null) {
                if (equals.equals(string)) {
                } else {
                    i = 0;
                }
            }
            r.b(i, "two different server client ids provided");
            return string;
        }

        public com.google.android.gms.auth.api.signin.GoogleSignInOptions a() {
            boolean contains;
            boolean empty;
            Scope scope;
            scope = GoogleSignInOptions.H;
            if (this.a.contains(GoogleSignInOptions.I) && this.a.contains(scope)) {
                scope = GoogleSignInOptions.H;
                if (this.a.contains(scope)) {
                    this.a.remove(scope);
                }
            }
            if (this.d) {
                if (this.f != null) {
                    if (!this.a.isEmpty()) {
                        c();
                    }
                } else {
                }
            }
            ArrayList arrayList = new ArrayList(this.a);
            super(3, arrayList, this.f, this.d, this.b, this.c, this.e, this.g, this.h, this.i, 0);
            return googleSignInOptions;
        }

        public com.google.android.gms.auth.api.signin.GoogleSignInOptions.a b() {
            this.a.add(GoogleSignInOptions.F);
            return this;
        }

        public com.google.android.gms.auth.api.signin.GoogleSignInOptions.a c() {
            this.a.add(GoogleSignInOptions.G);
            return this;
        }

        public com.google.android.gms.auth.api.signin.GoogleSignInOptions.a d(String string) {
            this.d = true;
            h(string);
            this.e = string;
            return this;
        }

        public com.google.android.gms.auth.api.signin.GoogleSignInOptions.a e() {
            this.a.add(GoogleSignInOptions.E);
            return this;
        }

        public com.google.android.gms.auth.api.signin.GoogleSignInOptions.a f(Scope scope, Scope... scope2Arr2) {
            this.a.add(scope);
            this.a.addAll(Arrays.asList(scope2Arr2));
            return this;
        }

        public com.google.android.gms.auth.api.signin.GoogleSignInOptions.a g(String string) {
            this.i = string;
            return this;
        }
    }
    static {
        Scope scope = new Scope("profile");
        GoogleSignInOptions.E = scope;
        Scope scope2 = new Scope("email");
        GoogleSignInOptions.F = scope2;
        Scope scope3 = new Scope("openid");
        GoogleSignInOptions.G = scope3;
        Scope scope4 = new Scope("https://www.googleapis.com/auth/games_lite");
        GoogleSignInOptions.H = scope4;
        Scope scope5 = new Scope("https://www.googleapis.com/auth/games");
        GoogleSignInOptions.I = scope5;
        GoogleSignInOptions.a aVar = new GoogleSignInOptions.a();
        aVar.c();
        aVar.e();
        GoogleSignInOptions.D = aVar.a();
        GoogleSignInOptions.a aVar2 = new GoogleSignInOptions.a();
        aVar2.f(scope4, new Scope[0]);
        aVar2.a();
        g gVar = new g();
        GoogleSignInOptions.CREATOR = gVar;
        f fVar = new f();
        GoogleSignInOptions.J = fVar;
    }

    GoogleSignInOptions(int i, ArrayList<Scope> arrayList2, Account account3, boolean z4, boolean z5, boolean z6, String string7, String string8, ArrayList<a> arrayList9, String string10) {
        super(i, arrayList2, account3, z4, z5, z6, string7, string8, GoogleSignInOptions.C2(arrayList9), string10);
    }

    private GoogleSignInOptions(int i, ArrayList<Scope> arrayList2, Account account3, boolean z4, boolean z5, boolean z6, String string7, String string8, Map<Integer, a> map9, String string10) {
        super();
        this.a = i;
        this.b = arrayList2;
        this.c = account3;
        this.v = z4;
        this.w = z5;
        this.x = z6;
        this.y = string7;
        this.z = string8;
        ArrayList obj1 = new ArrayList(map9.values());
        this.A = obj1;
        this.C = map9;
        this.B = string10;
    }

    GoogleSignInOptions(int i, ArrayList arrayList2, Account account3, boolean z4, boolean z5, boolean z6, String string7, String string8, Map map9, String string10, com.google.android.gms.auth.api.signin.f f11) {
        super(3, arrayList2, account3, z4, z5, z6, string7, string8, map9, string10);
    }

    static Map A2(List list) {
        return GoogleSignInOptions.C2(list);
    }

    static String B2(com.google.android.gms.auth.api.signin.GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.B;
    }

    private static Map<Integer, a> C2(List<a> list) {
        Object next;
        Integer valueOf;
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        final Iterator obj3 = list.iterator();
        for (a next : obj3) {
            hashMap.put(Integer.valueOf(next.j2()), next);
        }
        return hashMap;
    }

    public static com.google.android.gms.auth.api.signin.GoogleSignInOptions q2(String string) {
        int optString3;
        String optString2;
        String optString;
        Account account;
        int str2;
        Scope scope;
        String string2;
        Account account2;
        String str;
        optString3 = 0;
        if (TextUtils.isEmpty(string)) {
            return optString3;
        }
        JSONObject jSONObject = new JSONObject(string);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        str2 = 0;
        while (str2 < jSONArray.length()) {
            scope = new Scope(jSONArray.getString(str2));
            hashSet.add(scope);
            str2++;
        }
        String str8 = "accountName";
        if (jSONObject.has(str8)) {
            optString = jSONObject.optString(str8);
        } else {
            optString = optString3;
        }
        if (!TextUtils.isEmpty(optString)) {
            account = new Account(optString, "com.google");
            account2 = account;
        } else {
            account2 = optString3;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        optString2 = "serverClientId";
        if (jSONObject.has(optString2)) {
            str = optString2;
        } else {
            str = optString3;
        }
        String str6 = "hostedDomain";
        if (jSONObject.has(str6)) {
            optString3 = jSONObject.optString(str6);
        }
        HashMap hashMap = new HashMap();
        super(3, arrayList, account2, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), str, optString3, hashMap, 0);
        return googleSignInOptions;
    }

    static ArrayList s2(com.google.android.gms.auth.api.signin.GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.b;
    }

    static boolean t2(com.google.android.gms.auth.api.signin.GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.w;
    }

    static boolean u2(com.google.android.gms.auth.api.signin.GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.x;
    }

    static boolean v2(com.google.android.gms.auth.api.signin.GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.v;
    }

    static String w2(com.google.android.gms.auth.api.signin.GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.y;
    }

    static Account x2(com.google.android.gms.auth.api.signin.GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.c;
    }

    static String y2(com.google.android.gms.auth.api.signin.GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.z;
    }

    static ArrayList z2(com.google.android.gms.auth.api.signin.GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.A;
    }

    public Account b1() {
        return this.c;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public boolean equals(Object object) {
        boolean equals;
        Object size;
        Object obj4;
        final int i = 0;
        if (object == null) {
            return i;
        }
        if (this.A.size() <= 0) {
            if (object.A.size() > 0) {
                try {
                    if (this.b.size() == (GoogleSignInOptions)object.l2().size()) {
                    }
                    if (!this.b.containsAll(object.l2())) {
                    } else {
                    }
                    Account account = this.c;
                    if (account == null) {
                    } else {
                    }
                    if (object.b1() == null) {
                    }
                    if (account.equals(object.b1())) {
                    }
                    if (TextUtils.isEmpty(this.y)) {
                    } else {
                    }
                    if (TextUtils.isEmpty(object.m2())) {
                    }
                    if (!this.y.equals(object.m2())) {
                    } else {
                    }
                    if (this.x == object.n2() && this.v == object.o2() && this.w == object.p2() && TextUtils.equals(this.B, object.k2())) {
                    }
                    if (this.v == object.o2()) {
                    }
                    if (this.w == object.p2()) {
                    }
                    if (TextUtils.equals(this.B, object.k2())) {
                    }
                    return 1;
                    return i;
                }
            } else {
            }
        }
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public int hashCode() {
        int i;
        String str;
        ArrayList arrayList = new ArrayList();
        ArrayList list = this.b;
        i = 0;
        while (i < list.size()) {
            arrayList.add((Scope)list.get(i).j2());
            i++;
        }
        Collections.sort(arrayList);
        b bVar = new b();
        bVar.a(arrayList);
        bVar.a(this.c);
        bVar.a(this.y);
        bVar.c(this.x);
        bVar.c(this.v);
        bVar.c(this.w);
        bVar.a(this.B);
        return bVar.b();
    }

    public ArrayList<a> j2() {
        return this.A;
    }

    public String k2() {
        return this.B;
    }

    public ArrayList<Scope> l2() {
        ArrayList arrayList = new ArrayList(this.b);
        return arrayList;
    }

    public String m2() {
        return this.y;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public boolean n2() {
        return this.x;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public boolean o2() {
        return this.v;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public boolean p2() {
        return this.w;
    }

    public final String r2() {
        Object name;
        boolean empty;
        boolean empty2;
        String str;
        boolean z;
        Comparator comparator;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Collections.sort(this.b, GoogleSignInOptions.J);
        Iterator iterator = this.b.iterator();
        for (Scope next2 : iterator) {
            jSONArray.put(next2.j2());
        }
        jSONObject.put("scopes", jSONArray);
        name = this.c;
        if (name != null) {
            jSONObject.put("accountName", name.name);
        }
        try {
            jSONObject.put("idTokenRequested", this.v);
            jSONObject.put("forceCodeForRefreshToken", this.x);
            jSONObject.put("serverAuthRequested", this.w);
            if (!TextUtils.isEmpty(this.y)) {
            }
            jSONObject.put("serverClientId", this.y);
            if (!TextUtils.isEmpty(this.z)) {
            }
            jSONObject.put("hostedDomain", this.z);
            return jSONObject.toString();
            RuntimeException runtimeException = new RuntimeException(th);
            throw runtimeException;
        }
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public void writeToParcel(Parcel parcel, int i2) {
        b.j(parcel, 1, this.a);
        final int i14 = 0;
        b.s(parcel, 2, l2(), i14);
        b.n(parcel, 3, b1(), i2, i14);
        b.c(parcel, 4, o2());
        b.c(parcel, 5, p2());
        b.c(parcel, 6, n2());
        b.o(parcel, 7, m2(), i14);
        b.o(parcel, 8, this.z, i14);
        b.s(parcel, 9, j2(), i14);
        b.o(parcel, 10, k2(), i14);
        b.b(parcel, b.a(parcel));
    }
}
