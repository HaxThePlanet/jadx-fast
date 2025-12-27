package com.airbnb.lottie.v.k;

import com.airbnb.lottie.f;
import com.airbnb.lottie.t.b.c;
import com.airbnb.lottie.t.b.s;
import com.airbnb.lottie.v.j.b;
import com.airbnb.lottie.v.l.a;

/* compiled from: ShapeTrimPath.java */
/* loaded from: classes.dex */
public class q implements b {

    private final String a;
    private final q.a b;
    private final b c;
    private final b d;
    private final b e;
    private final boolean f;

    public enum a {

        INDIVIDUALLY,
        SIMULTANEOUSLY;
        public static q.a forId(int i) {
            if (i != 1 && i == 2) {
                return q.a.INDIVIDUALLY;
            }
            return q.a.SIMULTANEOUSLY;
        }
    }
    public q(String str, q.a aVar, b bVar, b bVar2, b bVar3, boolean z) {
        super();
        this.a = str;
        this.b = aVar;
        this.c = bVar;
        this.d = bVar2;
        this.e = bVar3;
        this.f = z;
    }

    public c a(f fVar, a aVar) {
        return new s(aVar, this);
    }

    public b b() {
        return this.d;
    }

    public String c() {
        return this.a;
    }

    public b d() {
        return this.e;
    }

    public b e() {
        return this.c;
    }

    public q.a f() {
        return this.b;
    }

    public boolean g() {
        return this.f;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Trim Path: {start: ";
        String str3 = ", end: ";
        String str4 = ", offset: ";
        String str5 = "}";
        str = str2 + this.c + str3 + this.d + str4 + this.e + str5;
        return str;
    }
}
