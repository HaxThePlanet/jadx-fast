package app.dogo.com.dogo_android.s.b;

import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class w implements n {

    public final /* synthetic */ l1 a;
    public final /* synthetic */ String b;
    public /* synthetic */ w(l1 l1Var, String str) {
        super();
        this.a = l1Var;
        this.b = str;
    }

    public final Object apply(Object object) {
        return ReminderRepository.T(this.a, this.b, object);
    }
}
