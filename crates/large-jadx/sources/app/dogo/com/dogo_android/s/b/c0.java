package app.dogo.com.dogo_android.s.b;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class c0 implements n {

    public final app.dogo.com.dogo_android.s.b.o1 a;
    public final String b;
    public c0(app.dogo.com.dogo_android.s.b.o1 o1, String string2) {
        super();
        this.a = o1;
        this.b = string2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return o1.w(this.a, this.b, (GetTrickKnowledgeResponse)object);
    }
}
