package app.dogo.com.dogo_android.s.b;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class f implements n {

    public final app.dogo.com.dogo_android.s.b.f1 a;
    public final String b;
    public f(app.dogo.com.dogo_android.s.b.f1 f1, String string2) {
        super();
        this.a = f1;
        this.b = string2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return f1.g(this.a, this.b, (DogLogResponse)object);
    }
}
