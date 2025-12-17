package com.facebook.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookException;
import com.facebook.a;
import com.facebook.common.d;
import com.facebook.g;
import com.facebook.internal.b0;
import com.facebook.internal.c0;
import com.facebook.internal.d.c;
import com.facebook.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class l implements Parcelable {

    public static final Parcelable.Creator<com.facebook.login.l> CREATOR;
    Map<String, String> A;
    private com.facebook.login.o B;
    private int C = 0;
    private int D = 0;
    com.facebook.login.q[] a;
    int b = -1;
    Fragment c;
    com.facebook.login.l.c v;
    com.facebook.login.l.b w;
    boolean x;
    com.facebook.login.l.d y;
    Map<String, String> z;

    static class a implements Parcelable.Creator<com.facebook.login.l> {
        @Override // android.os.Parcelable$Creator
        public com.facebook.login.l a(Parcel parcel) {
            l lVar = new l(parcel);
            return lVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.facebook.login.l[] b(int i) {
            return new l[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return b(i);
        }
    }

    interface b {
        public abstract void a();

        public abstract void b();
    }

    public interface c {
        public abstract void a(com.facebook.login.l.e l$e);
    }

    public static class d implements Parcelable {

        public static final Parcelable.Creator<com.facebook.login.l.d> CREATOR;
        private String A;
        private String B;
        private boolean C;
        private final com.facebook.login.s D;
        private boolean E;
        private boolean F;
        private String G;
        private final com.facebook.login.k a;
        private Set<String> b;
        private final com.facebook.login.c c;
        private final String v;
        private String w;
        private boolean x;
        private String y;
        private String z;
        static {
            l.d.a aVar = new l.d.a();
            l.d.CREATOR = aVar;
        }

        private d(Parcel parcel) {
            int i3;
            com.facebook.login.k valueOf2;
            com.facebook.login.c valueOf3;
            int i4;
            int i;
            int i2;
            int valueOf;
            super();
            i3 = 0;
            this.x = i3;
            this.E = i3;
            this.F = i3;
            String string = parcel.readString();
            valueOf = 0;
            if (string != null) {
                valueOf2 = k.valueOf(string);
            } else {
                valueOf2 = valueOf;
            }
            this.a = valueOf2;
            ArrayList arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            HashSet hashSet = new HashSet(arrayList);
            this.b = hashSet;
            String string2 = parcel.readString();
            if (string2 != null) {
                valueOf3 = c.valueOf(string2);
            } else {
                valueOf3 = valueOf;
            }
            this.c = valueOf3;
            this.v = parcel.readString();
            this.w = parcel.readString();
            int i5 = 1;
            i4 = parcel.readByte() != 0 ? i5 : i3;
            this.x = i4;
            this.y = parcel.readString();
            this.z = parcel.readString();
            this.A = parcel.readString();
            this.B = parcel.readString();
            i = parcel.readByte() != 0 ? i5 : i3;
            this.C = i;
            String string9 = parcel.readString();
            if (string9 != null) {
                valueOf = s.valueOf(string9);
            }
            this.D = valueOf;
            i2 = parcel.readByte() != 0 ? i5 : i3;
            this.E = i2;
            i3 = parcel.readByte() != 0 ? i5 : i3;
            this.F = i3;
            this.G = parcel.readString();
        }

        d(Parcel parcel, com.facebook.login.l.a l$a2) {
            super(parcel);
        }

        d(com.facebook.login.k k, Set<String> set2, com.facebook.login.c c3, String string4, String string5, String string6, com.facebook.login.s s7, String string8) {
            boolean obj2;
            HashSet obj3;
            super();
            final int i = 0;
            this.x = i;
            this.E = i;
            this.F = i;
            this.a = k;
            if (set2 != null) {
            } else {
                obj3 = new HashSet();
            }
            this.b = obj3;
            this.c = c3;
            this.z = string4;
            this.v = string5;
            this.w = string6;
            this.D = s7;
            if (b0.W(string8)) {
                this.G = UUID.randomUUID().toString();
            } else {
                this.G = string8;
            }
        }

        @Override // android.os.Parcelable
        String a() {
            return this.v;
        }

        @Override // android.os.Parcelable
        String b() {
            return this.w;
        }

        @Override // android.os.Parcelable
        String c() {
            return this.z;
        }

        @Override // android.os.Parcelable
        com.facebook.login.c d() {
            return this.c;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        String e() {
            return this.A;
        }

        @Override // android.os.Parcelable
        String f() {
            return this.y;
        }

        @Override // android.os.Parcelable
        com.facebook.login.k g() {
            return this.a;
        }

        @Override // android.os.Parcelable
        com.facebook.login.s h() {
            return this.D;
        }

        @Override // android.os.Parcelable
        public String i() {
            return this.B;
        }

        @Override // android.os.Parcelable
        public String j() {
            return this.G;
        }

        Set<String> k() {
            return this.b;
        }

        @Override // android.os.Parcelable
        public boolean l() {
            return this.C;
        }

        @Override // android.os.Parcelable
        boolean m() {
            boolean z;
            Iterator iterator = this.b.iterator();
            for (String next2 : iterator) {
            }
            return 0;
        }

        @Override // android.os.Parcelable
        boolean n() {
            return this.E;
        }

        @Override // android.os.Parcelable
        boolean o() {
            int i;
            i = this.D == s.INSTAGRAM ? 1 : 0;
            return i;
        }

        @Override // android.os.Parcelable
        boolean p() {
            return this.x;
        }

        @Override // android.os.Parcelable
        void q(boolean z) {
            this.E = z;
        }

        @Override // android.os.Parcelable
        public void r(String string) {
            this.B = string;
        }

        void s(Set<String> set) {
            c0.j(set, "permissions");
            this.b = set;
        }

        @Override // android.os.Parcelable
        void t(boolean z) {
            this.x = z;
        }

        @Override // android.os.Parcelable
        public void u(boolean z) {
            this.C = z;
        }

        @Override // android.os.Parcelable
        void v(boolean z) {
            this.F = z;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            int name;
            int obj4;
            obj4 = this.a;
            name = 0;
            if (obj4 != null) {
                obj4 = obj4.name();
            } else {
                obj4 = name;
            }
            parcel.writeString(obj4);
            obj4 = new ArrayList(this.b);
            parcel.writeStringList(obj4);
            obj4 = this.c;
            if (obj4 != null) {
                obj4 = obj4.name();
            } else {
                obj4 = name;
            }
            parcel.writeString(obj4);
            parcel.writeString(this.v);
            parcel.writeString(this.w);
            parcel.writeByte((byte)obj4);
            parcel.writeString(this.y);
            parcel.writeString(this.z);
            parcel.writeString(this.A);
            parcel.writeString(this.B);
            parcel.writeByte((byte)obj4);
            obj4 = this.D;
            if (obj4 != null) {
                name = obj4.name();
            }
            parcel.writeString(name);
            parcel.writeByte((byte)obj4);
            parcel.writeByte((byte)obj4);
            parcel.writeString(this.G);
        }

        @Override // android.os.Parcelable
        boolean x() {
            return this.F;
        }
    }

    public static class e implements Parcelable {

        public static final Parcelable.Creator<com.facebook.login.l.e> CREATOR;
        final com.facebook.login.l.e.b a;
        final a b;
        final g c;
        final String v;
        final String w;
        final com.facebook.login.l.d x;
        public Map<String, String> y;
        public Map<String, String> z;
        static {
            l.e.a aVar = new l.e.a();
            l.e.CREATOR = aVar;
        }

        private e(Parcel parcel) {
            super();
            this.a = l.e.b.valueOf(parcel.readString());
            this.b = (a)parcel.readParcelable(a.class.getClassLoader());
            this.c = (g)parcel.readParcelable(g.class.getClassLoader());
            this.v = parcel.readString();
            this.w = parcel.readString();
            this.x = (l.d)parcel.readParcelable(l.d.class.getClassLoader());
            this.y = b0.n0(parcel);
            this.z = b0.n0(parcel);
        }

        e(Parcel parcel, com.facebook.login.l.a l$a2) {
            super(parcel);
        }

        e(com.facebook.login.l.d l$d, com.facebook.login.l.e.b l$e$b2, a a3, g g4, String string5, String string6) {
            super();
            c0.j(b2, "code");
            this.x = d;
            this.b = a3;
            this.c = g4;
            this.v = string5;
            this.a = b2;
            this.w = string6;
        }

        e(com.facebook.login.l.d l$d, com.facebook.login.l.e.b l$e$b2, a a3, String string4, String string5) {
            super(d, b2, a3, 0, string4, string5);
        }

        static com.facebook.login.l.e a(com.facebook.login.l.d l$d, String string2) {
            super(d, l.e.b.CANCEL, 0, string2, 0);
            return eVar2;
        }

        static com.facebook.login.l.e b(com.facebook.login.l.d l$d, a a2, g g3) {
            super(d, l.e.b.SUCCESS, a2, g3, 0, 0);
            return eVar2;
        }

        static com.facebook.login.l.e c(com.facebook.login.l.d l$d, String string2, String string3) {
            return l.e.d(d, string2, string3, 0);
        }

        static com.facebook.login.l.e d(com.facebook.login.l.d l$d, String string2, String string3, String string4) {
            String[] strArr = new String[2];
            super(d, l.e.b.ERROR, 0, TextUtils.join(": ", b0.d(string2, string3)), string4);
            return obj7;
        }

        static com.facebook.login.l.e e(com.facebook.login.l.d l$d, a a2) {
            super(d, l.e.b.SUCCESS, a2, 0, 0);
            return eVar2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.a.name());
            parcel.writeParcelable(this.b, i2);
            parcel.writeParcelable(this.c, i2);
            parcel.writeString(this.v);
            parcel.writeString(this.w);
            parcel.writeParcelable(this.x, i2);
            b0.z0(parcel, this.y);
            b0.z0(parcel, this.z);
        }
    }
    static {
        l.a aVar = new l.a();
        l.CREATOR = aVar;
    }

    public l(Parcel parcel) {
        int i;
        com.facebook.login.q[] arr;
        Parcelable parcelable;
        super();
        int i2 = -1;
        i = 0;
        Parcelable[] parcelableArray = parcel.readParcelableArray(q.class.getClassLoader());
        this.a = new q[parcelableArray.length];
        for (Object parcelable : obj1) {
            com.facebook.login.q[] objArr = this.a;
            objArr[i] = (q)parcelable;
            objArr[i].m(this);
        }
        this.b = parcel.readInt();
        this.y = (l.d)parcel.readParcelable(l.d.class.getClassLoader());
        this.z = b0.n0(parcel);
        this.A = b0.n0(parcel);
    }

    public l(Fragment fragment) {
        super();
        int i = -1;
        int i2 = 0;
        this.c = fragment;
    }

    private void a(String string, String string2, boolean z3) {
        Object hashMap;
        boolean key;
        String obj3;
        StringBuilder obj4;
        if (this.z == null) {
            hashMap = new HashMap();
            this.z = hashMap;
        }
        if (this.z.containsKey(string) && z3 != null) {
            if (z3 != null) {
                obj4 = new StringBuilder();
                obj4.append((String)this.z.get(string));
                obj4.append(",");
                obj4.append(string2);
                obj3 = obj4.toString();
            }
        }
        this.z.put(string, obj3);
    }

    private void h() {
        f(l.e.c(this.y, "Login attempt failed.", 0));
    }

    static String k() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("init", System.currentTimeMillis());
        return jSONObject.toString();
    }

    private com.facebook.login.o o() {
        boolean oVar;
        Object obj;
        String str;
        oVar = this.B;
        if (oVar != null) {
            if (!oVar.b().equals(this.y.a())) {
                oVar = new o(i(), this.y.a());
                this.B = oVar;
            }
        } else {
        }
        return this.B;
    }

    public static int p() {
        return d.c.Login.toRequestCode();
    }

    private void r(String string, com.facebook.login.l.e l$e2, Map<String, String> map3) {
        this.s(string, e2.a.getLoggingValue(), e2.v, e2.w, map3);
    }

    private void s(String string, String string2, String string3, String string4, Map<String, String> map5) {
        com.facebook.login.l.d dVar;
        String str;
        com.facebook.login.o oVar;
        String str7;
        String str6;
        String str3;
        String str2;
        String str5;
        Map map;
        String str4;
        com.facebook.login.o obj12;
        String obj13;
        if (this.y == null) {
            o().j("fb_mobile_login_method_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", string);
        } else {
            if (this.y.n()) {
                str = "foa_mobile_login_method_complete";
            }
            o().c(this.y.b(), string, string2, string3, string4, map5, str);
        }
    }

    private void v(com.facebook.login.l.e l$e) {
        final com.facebook.login.l.c cVar = this.v;
        if (cVar != null) {
            cVar.a(e);
        }
    }

    @Override // android.os.Parcelable
    void A(com.facebook.login.l.c l$c) {
        this.v = c;
    }

    @Override // android.os.Parcelable
    void B(com.facebook.login.l.d l$d) {
        if (!n()) {
            b(d);
        }
    }

    @Override // android.os.Parcelable
    boolean C() {
        String str;
        boolean z;
        int i;
        Object str3;
        String str2;
        String str4;
        String str5;
        com.facebook.login.q qVar = j();
        i = 0;
        if (qVar.j() && !d()) {
            if (!d()) {
                a("no_internet_permission", "1", i);
                return i;
            }
        }
        int i2 = qVar.o(this.y);
        this.C = i;
        final int i3 = 1;
        if (i2 > 0) {
            str4 = this.y.n() ? "foa_mobile_login_method_start" : "fb_mobile_login_method_start";
            o().e(this.y.b(), qVar.h(), str4);
            this.D = i2;
        } else {
            str5 = this.y.n() ? "foa_mobile_login_method_not_tried" : "fb_mobile_login_method_not_tried";
            o().d(this.y.b(), qVar.h(), str5);
            a("not_tried", qVar.h(), i3);
        }
        if (i2 > 0) {
            i = i3;
        }
        return i;
    }

    @Override // android.os.Parcelable
    void D() {
        int i;
        com.facebook.login.q[] objArr;
        Object obj;
        String str;
        String str2;
        int i3;
        int i2;
        Map map;
        if (this.b >= 0) {
            this.s(j().h(), "skipped", 0, 0, j().g());
        }
        objArr = this.a;
        while (objArr != null) {
            obj = this.b;
            this.b = obj++;
            objArr = this.a;
        }
        if (this.y != null) {
            h();
        }
    }

    @Override // android.os.Parcelable
    void F(com.facebook.login.l.e l$e) {
        Object str;
        a equals;
        a aVar;
        Object aVar2;
        com.facebook.login.l.e obj3;
        if (e.b == null) {
        } else {
            equals = a.d();
            aVar2 = e.b;
            if (equals != null && aVar2 != null && equals.n().equals(aVar2.n())) {
                if (aVar2 != null) {
                    if (equals.n().equals(aVar2.n())) {
                        obj3 = l.e.b(this.y, e.b, e.c);
                    } else {
                        obj3 = l.e.c(this.y, "User logged in as different Facebook user.", 0);
                    }
                } else {
                }
            } else {
            }
            f(obj3);
        }
        obj3 = new FacebookException("Can't validate without a token");
        throw obj3;
    }

    @Override // android.os.Parcelable
    void b(com.facebook.login.l.d l$d) {
        boolean z;
        if (d == null) {
        }
        if (this.y != null) {
        } else {
            if (a.o() && !d()) {
                if (!d()) {
                }
            }
            this.y = d;
            this.a = m(d);
            D();
        }
        FacebookException obj2 = new FacebookException("Attempted to authorize while a request is pending.");
        throw obj2;
    }

    @Override // android.os.Parcelable
    void c() {
        int i;
        if (this.b >= 0) {
            j().b();
        }
    }

    @Override // android.os.Parcelable
    boolean d() {
        int i3 = 1;
        if (this.x) {
            return i3;
        }
        if (e("android.permission.INTERNET") != 0) {
            e eVar = i();
            f(l.e.c(this.y, eVar.getString(d.c), eVar.getString(d.b)));
            return 0;
        }
        this.x = i3;
        return i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    int e(String string) {
        return i().checkCallingOrSelfPermission(string);
    }

    @Override // android.os.Parcelable
    void f(com.facebook.login.l.e l$e) {
        Object qVar;
        String str;
        qVar = j();
        if (qVar != null) {
            r(qVar.h(), e, qVar.g());
        }
        Map map = this.z;
        if (map != null) {
            e.y = map;
        }
        Map map2 = this.A;
        if (map2 != null) {
            e.z = map2;
        }
        int i = 0;
        this.a = i;
        this.b = -1;
        this.y = i;
        this.z = i;
        int i2 = 0;
        this.C = i2;
        this.D = i2;
        v(e);
    }

    @Override // android.os.Parcelable
    void g(com.facebook.login.l.e l$e) {
        a aVar;
        if (e.b != null && a.o()) {
            if (a.o()) {
                F(e);
            } else {
                f(e);
            }
        } else {
        }
    }

    @Override // android.os.Parcelable
    e i() {
        return this.c.getActivity();
    }

    @Override // android.os.Parcelable
    com.facebook.login.q j() {
        int i = this.b;
        if (i >= 0) {
            return this.a[i];
        }
        return null;
    }

    @Override // android.os.Parcelable
    public Fragment l() {
        return this.c;
    }

    @Override // android.os.Parcelable
    protected com.facebook.login.q[] m(com.facebook.login.l.d l$d) {
        boolean allowsInstagramAppAuth;
        boolean allowsCustomTabAuth;
        boolean allowsWebViewAuth;
        boolean allowsGetTokenAuth;
        boolean allowsKatanaAuth;
        boolean obj4;
        ArrayList arrayList = new ArrayList();
        final com.facebook.login.k kVar = d.g();
        if (d.o()) {
            if (!o.q && kVar.allowsInstagramAppAuth()) {
                if (kVar.allowsInstagramAppAuth()) {
                    allowsInstagramAppAuth = new i(this);
                    arrayList.add(allowsInstagramAppAuth);
                }
            }
        } else {
            if (kVar.allowsGetTokenAuth()) {
                allowsGetTokenAuth = new h(this);
                arrayList.add(allowsGetTokenAuth);
            }
            if (!o.q && kVar.allowsKatanaAuth()) {
                if (kVar.allowsKatanaAuth()) {
                    allowsKatanaAuth = new j(this);
                    arrayList.add(allowsKatanaAuth);
                }
            }
            if (!o.q && kVar.allowsFacebookLiteAuth()) {
                if (kVar.allowsFacebookLiteAuth()) {
                    allowsInstagramAppAuth = new f(this);
                    arrayList.add(allowsInstagramAppAuth);
                }
            }
        }
        if (kVar.allowsCustomTabAuth()) {
            allowsCustomTabAuth = new a(this);
            arrayList.add(allowsCustomTabAuth);
        }
        if (kVar.allowsWebViewAuth()) {
            allowsWebViewAuth = new y(this);
            arrayList.add(allowsWebViewAuth);
        }
        if (!d.o() && kVar.allowsDeviceAuth()) {
            if (kVar.allowsDeviceAuth()) {
                obj4 = new e(this);
                arrayList.add(obj4);
            }
        }
        obj4 = new q[arrayList.size()];
        arrayList.toArray(obj4);
        return obj4;
    }

    @Override // android.os.Parcelable
    boolean n() {
        com.facebook.login.l.d dVar;
        int i;
        if (this.y != null && this.b >= 0) {
            i = this.b >= 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // android.os.Parcelable
    public com.facebook.login.l.d q() {
        return this.y;
    }

    @Override // android.os.Parcelable
    void t() {
        final com.facebook.login.l.b bVar = this.w;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // android.os.Parcelable
    void u() {
        final com.facebook.login.l.b bVar = this.w;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelableArray(this.a, i2);
        parcel.writeInt(this.b);
        parcel.writeParcelable(this.y, i2);
        b0.z0(parcel, this.z);
        b0.z0(parcel, this.A);
    }

    @Override // android.os.Parcelable
    public boolean x(int i, int i2, Intent intent3) {
        com.facebook.login.l.d booleanExtra;
        int i3;
        this.C = i4++;
        final int i6 = 0;
        if (this.y != null && intent3 != null && intent3.getBooleanExtra(CustomTabMainActivity.A, i6)) {
            if (intent3 != null) {
                if (intent3.getBooleanExtra(CustomTabMainActivity.A, i6)) {
                    D();
                    return i6;
                }
            }
            if (j().n() && intent3 == null && this.C >= this.D) {
                if (intent3 == null) {
                    if (this.C >= this.D) {
                    }
                }
            }
            return j().k(i, i2, intent3);
        }
        return i6;
    }

    @Override // android.os.Parcelable
    void y(com.facebook.login.l.b l$b) {
        this.w = b;
    }

    @Override // android.os.Parcelable
    void z(Fragment fragment) {
        if (this.c != null) {
        } else {
            this.c = fragment;
        }
        FacebookException obj2 = new FacebookException("Can't set fragment once it is already set.");
        throw obj2;
    }
}
