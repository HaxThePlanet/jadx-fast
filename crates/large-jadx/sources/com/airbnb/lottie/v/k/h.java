package com.airbnb.lottie.v.k;

import com.airbnb.lottie.f;
import com.airbnb.lottie.t.b.c;
import com.airbnb.lottie.t.b.l;
import com.airbnb.lottie.v.l.a;
import com.airbnb.lottie.y.d;

/* compiled from: MergePaths.java */
/* loaded from: classes.dex */
public class h implements b {

    private final String a;
    private final h.a b;
    private final boolean c;

    public enum a {

        ADD,
        EXCLUDE_INTERSECTIONS,
        INTERSECT,
        MERGE,
        SUBTRACT;
        public static h.a forId(int i) {
            if (i != 1 && i != 2) {
                if (i != 3 && i != 4) {
                    if (i != 5) {
                        return h.a.MERGE;
                    }
                    return h.a.EXCLUDE_INTERSECTIONS;
                }
                return h.a.SUBTRACT;
            }
            return h.a.MERGE;
        }
    }
    public h(String str, h.a aVar, boolean z) {
        super();
        this.a = str;
        this.b = aVar;
        this.c = z;
    }

    public c a(f fVar, a aVar) {
        if (!fVar.m()) {
            d.c("Animation contains merge paths but they are disabled.");
            return null;
        }
        return new l(this);
    }

    public h.a b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public boolean d() {
        return this.c;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "MergePaths{mode=";
        str = str2 + this.b + 125;
        return str;
    }
}
