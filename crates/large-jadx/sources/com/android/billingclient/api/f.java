package com.android.billingclient.api;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class f {

    private boolean a;
    private String b;
    private String c;
    private String d;
    private int e = 0;
    private ArrayList<com.android.billingclient.api.SkuDetails> f;
    private boolean g;

    public static class a {

        private String a;
        private String b;
        private String c;
        private int d = 0;
        private ArrayList<com.android.billingclient.api.SkuDetails> e;
        private boolean f;
        a(com.android.billingclient.api.u u) {
            super();
            final int obj1 = 0;
        }

        public com.android.billingclient.api.f a() {
            ArrayList empty;
            int size;
            int i;
            int i3;
            int size2;
            int i4;
            int i2;
            String equals2;
            Object equals;
            boolean equals3;
            empty = this.e;
            if (empty == null) {
            } else {
                if (empty.isEmpty()) {
                } else {
                    ArrayList list = this.e;
                    int i8 = 0;
                    i = i8;
                    while (i < list.size()) {
                        i = i3;
                    }
                    int i5 = 1;
                    if (this.e.size() > i5) {
                        Object obj = this.e.get(i8);
                        i = (SkuDetails)obj.q();
                        ArrayList list6 = this.e;
                        i2 = i8;
                        equals2 = "play_pass_subs";
                        while (i2 < list6.size()) {
                            equals = list6.get(i2);
                            i2++;
                            equals2 = "play_pass_subs";
                        }
                        i3 = this.e;
                        i4 = i8;
                        while (i4 < i3.size()) {
                            equals = i3.get(i4);
                            i4++;
                        }
                    }
                    f fVar = new f(0);
                    f.n(fVar, i5 ^= empty2);
                    f.e(fVar, this.a);
                    f.f(fVar, this.c);
                    f.g(fVar, this.b);
                    f.c(fVar, this.d);
                    f.k(fVar, this.e);
                    f.m(fVar, this.f);
                    return fVar;
                }
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("SkuDetails must be provided.");
            throw illegalArgumentException;
        }

        public com.android.billingclient.api.f.a b(String string) {
            this.a = string;
            return this;
        }

        public com.android.billingclient.api.f.a c(com.android.billingclient.api.SkuDetails skuDetails) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(skuDetails);
            this.e = arrayList;
            return this;
        }

        public com.android.billingclient.api.f.a d(com.android.billingclient.api.f.b f$b) {
            this.b = b.a();
            this.d = b.b();
            return this;
        }
    }

    public static class b {

        private String a;
        private int b = 0;
        b(com.android.billingclient.api.u u) {
            super();
            final int obj1 = 0;
        }

        public static com.android.billingclient.api.f.b.a c() {
            f.b.a aVar = new f.b.a(0);
            return aVar;
        }

        static int d(com.android.billingclient.api.f.b f$b, int i2) {
            b.b = i2;
            return i2;
        }

        static String e(com.android.billingclient.api.f.b f$b, String string2) {
            b.a = string2;
            return string2;
        }

        String a() {
            return this.a;
        }

        int b() {
            return this.b;
        }
    }
    f(com.android.billingclient.api.u u) {
        super();
        final int obj1 = 0;
    }

    public static com.android.billingclient.api.f.a b() {
        f.a aVar = new f.a(0);
        return aVar;
    }

    static int c(com.android.billingclient.api.f f, int i2) {
        f.e = i2;
        return i2;
    }

    static String e(com.android.billingclient.api.f f, String string2) {
        f.b = string2;
        return string2;
    }

    static String f(com.android.billingclient.api.f f, String string2) {
        f.d = string2;
        return string2;
    }

    static String g(com.android.billingclient.api.f f, String string2) {
        f.c = string2;
        return string2;
    }

    static ArrayList k(com.android.billingclient.api.f f, ArrayList arrayList2) {
        f.f = arrayList2;
        return arrayList2;
    }

    static boolean m(com.android.billingclient.api.f f, boolean z2) {
        f.g = z2;
        return z2;
    }

    static boolean n(com.android.billingclient.api.f f, boolean z2) {
        f.a = z2;
        return z2;
    }

    public boolean a() {
        return this.g;
    }

    public final int d() {
        return this.e;
    }

    public final String h() {
        return this.b;
    }

    public final String i() {
        return this.d;
    }

    public final String j() {
        return this.c;
    }

    public final ArrayList<com.android.billingclient.api.SkuDetails> l() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f);
        return arrayList;
    }

    final boolean o() {
        boolean z;
        if (!this.g && this.b == null && this.d == null && this.e == 0 && this.a) {
            if (this.b == null) {
                if (this.d == null) {
                    if (this.e == 0) {
                        if (this.a) {
                        }
                        return 0;
                    }
                }
            }
        }
        return 1;
    }
}
