package com.airbnb.lottie.v.k;

import com.airbnb.lottie.f;
import com.airbnb.lottie.t.b.c;
import com.airbnb.lottie.t.b.s;
import com.airbnb.lottie.v.j.b;
import com.airbnb.lottie.v.l.a;

/* loaded from: classes.dex */
public class q implements com.airbnb.lottie.v.k.b {

    private final String a;
    private final com.airbnb.lottie.v.k.q.a b;
    private final b c;
    private final b d;
    private final b e;
    private final boolean f;

    public static enum a {

        SIMULTANEOUSLY,
        INDIVIDUALLY;
        public static com.airbnb.lottie.v.k.q.a forId(int i) {
            if (i != 1) {
                if (i != 2) {
                } else {
                    return q.a.INDIVIDUALLY;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown trim path type ");
                stringBuilder.append(i);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                throw illegalArgumentException;
            }
            return q.a.SIMULTANEOUSLY;
        }
    }
    public q(String string, com.airbnb.lottie.v.k.q.a q$a2, b b3, b b4, b b5, boolean z6) {
        super();
        this.a = string;
        this.b = a2;
        this.c = b3;
        this.d = b4;
        this.e = b5;
        this.f = z6;
    }

    @Override // com.airbnb.lottie.v.k.b
    public c a(f f, a a2) {
        s obj1 = new s(a2, this);
        return obj1;
    }

    @Override // com.airbnb.lottie.v.k.b
    public b b() {
        return this.d;
    }

    @Override // com.airbnb.lottie.v.k.b
    public String c() {
        return this.a;
    }

    @Override // com.airbnb.lottie.v.k.b
    public b d() {
        return this.e;
    }

    @Override // com.airbnb.lottie.v.k.b
    public b e() {
        return this.c;
    }

    @Override // com.airbnb.lottie.v.k.b
    public com.airbnb.lottie.v.k.q.a f() {
        return this.b;
    }

    @Override // com.airbnb.lottie.v.k.b
    public boolean g() {
        return this.f;
    }

    @Override // com.airbnb.lottie.v.k.b
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Trim Path: {start: ");
        stringBuilder.append(this.c);
        stringBuilder.append(", end: ");
        stringBuilder.append(this.d);
        stringBuilder.append(", offset: ");
        stringBuilder.append(this.e);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
