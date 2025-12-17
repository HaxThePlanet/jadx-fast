package com.airbnb.lottie.v.k;

import com.airbnb.lottie.f;
import com.airbnb.lottie.t.b.c;
import com.airbnb.lottie.t.b.l;
import com.airbnb.lottie.v.l.a;
import com.airbnb.lottie.y.d;

/* loaded from: classes.dex */
public class h implements com.airbnb.lottie.v.k.b {

    private final String a;
    private final com.airbnb.lottie.v.k.h.a b;
    private final boolean c;

    public static enum a {

        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;
        public static com.airbnb.lottie.v.k.h.a forId(int i) {
            if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return h.a.MERGE;
                            }
                            return h.a.EXCLUDE_INTERSECTIONS;
                        }
                        return h.a.INTERSECT;
                    }
                    return h.a.SUBTRACT;
                }
                return h.a.ADD;
            }
            return h.a.MERGE;
        }
    }
    public h(String string, com.airbnb.lottie.v.k.h.a h$a2, boolean z3) {
        super();
        this.a = string;
        this.b = a2;
        this.c = z3;
    }

    @Override // com.airbnb.lottie.v.k.b
    public c a(f f, a a2) {
        if (!f.m()) {
            d.c("Animation contains merge paths but they are disabled.");
            return null;
        }
        l obj1 = new l(this);
        return obj1;
    }

    @Override // com.airbnb.lottie.v.k.b
    public com.airbnb.lottie.v.k.h.a b() {
        return this.b;
    }

    @Override // com.airbnb.lottie.v.k.b
    public String c() {
        return this.a;
    }

    @Override // com.airbnb.lottie.v.k.b
    public boolean d() {
        return this.c;
    }

    @Override // com.airbnb.lottie.v.k.b
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MergePaths{mode=");
        stringBuilder.append(this.b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
