package app.dogo.com.dogo_android.s.a;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class a implements n {

    public final app.dogo.com.dogo_android.s.a.d2 a;
    public final String b;
    public a(app.dogo.com.dogo_android.s.a.d2 d2, String string2) {
        super();
        this.a = d2;
        this.b = string2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return d2.g(this.a, this.b, (AcceptDogInviteResponse)object);
    }
}
