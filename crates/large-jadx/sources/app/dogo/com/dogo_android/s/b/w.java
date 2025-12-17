package app.dogo.com.dogo_android.s.b;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class w implements n {

    public final app.dogo.com.dogo_android.s.b.l1 a;
    public final String b;
    public w(app.dogo.com.dogo_android.s.b.l1 l1, String string2) {
        super();
        this.a = l1;
        this.b = string2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return l1.C(this.a, this.b, (ReminderResponse)object);
    }
}
