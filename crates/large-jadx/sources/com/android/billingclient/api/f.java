package com.android.billingclient.api;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public class f {

    private boolean a;
    private String b;
    private String c;
    private String d;
    private int e = 0;
    private ArrayList<SkuDetails> f;
    private boolean g;

    public static class a {

        private String a;
        private String b;
        private String c;
        private int d = 0;
        private ArrayList<SkuDetails> e;
        private boolean f;
        public f a() {
            int i;
            String str;
            Object item;
            boolean equals;
            if (this.e == null) {
                throw new IllegalArgumentException("SkuDetails must be provided.");
            } else {
                if (!this.e.isEmpty()) {
                    i = 0;
                    while (i < this.e.size()) {
                        i = i + 1;
                        if ((SkuDetails)this.e.get(i) == null) {
                            throw new IllegalArgumentException("SKU cannot be null.");
                        }
                    }
                    int i2 = 1;
                    if (this.e.size() > i2) {
                        Object item2 = this.e.get(i);
                        String str11 = item2.q();
                        str = "play_pass_subs";
                        while (i < this.e.size()) {
                            item = this.e.get(i);
                            if (!str11.equals(str)) {
                            }
                        }
                        while (i < this.e.size()) {
                            item = this.e.get(i);
                            if (!str11.equals(str)) {
                            }
                        }
                    }
                    com.android.billingclient.api.f fVar = new f(null);
                    fVar.a = i2 ^ (SkuDetails)this.e.get(i).t().isEmpty();
                    fVar.b = this.a;
                    fVar.d = this.c;
                    fVar.c = this.b;
                    fVar.e = this.d;
                    fVar.f = this.e;
                    fVar.g = this.f;
                    return fVar;
                }
            }
        }

        public f.a c(SkuDetails skuDetails) {
            final ArrayList arrayList = new ArrayList();
            arrayList.add(skuDetails);
            this.e = arrayList;
            return this;
        }

        public f.a d(f.b bVar) {
            this.b = bVar.a();
            this.d = bVar.b();
            return this;
        }

        /* synthetic */ a(u uVar) {
            super();
        }

        public f.a b(String str) {
            this.a = str;
            return this;
        }
    }

    public static class b {

        private String a;
        private int b = 0;
        public static f.b.a c() {
            return new f.b.a(null);
        }

        /* synthetic */ b(u uVar) {
            super();
        }

        static /* synthetic */ int d(f.b bVar, int i) {
            bVar.b = i;
            return i;
        }

        static /* synthetic */ String e(f.b bVar, String str) {
            bVar.a = str;
            return str;
        }

        String a() {
            return this.a;
        }

        int b() {
            return this.b;
        }
    }
    public static f.a b() {
        return new f.a(null);
    }

    public final ArrayList<SkuDetails> l() {
        final ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f);
        return arrayList;
    }

    /* synthetic */ f(u uVar) {
        super();
    }

    static /* synthetic */ int c(f fVar, int i) {
        fVar.e = i;
        return i;
    }

    static /* synthetic */ String e(f fVar, String str) {
        fVar.b = str;
        return str;
    }

    static /* synthetic */ String f(f fVar, String str) {
        fVar.d = str;
        return str;
    }

    static /* synthetic */ String g(f fVar, String str) {
        fVar.c = str;
        return str;
    }

    static /* synthetic */ ArrayList k(f fVar, ArrayList list) {
        fVar.f = list;
        return list;
    }

    static /* synthetic */ boolean m(f fVar, boolean z) {
        fVar.g = z;
        return z;
    }

    static /* synthetic */ boolean n(f fVar, boolean z) {
        fVar.a = z;
        return z;
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

    final boolean o() {
        return true;
    }
}
