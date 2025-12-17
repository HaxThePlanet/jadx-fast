package app.dogo.com.dogo_android.s.b;

import app.dogo.com.dogo_android.model.RemindersModel;
import i.b.l0.n;

/* loaded from: classes.dex */
public final class j implements n {

    public final app.dogo.com.dogo_android.s.b.l1 a;
    public final String b;
    public final RemindersModel c;
    public j(app.dogo.com.dogo_android.s.b.l1 l1, String string2, RemindersModel remindersModel3) {
        super();
        this.a = l1;
        this.b = string2;
        this.c = remindersModel3;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return l1.p(this.a, this.b, this.c, (List)object);
    }
}
