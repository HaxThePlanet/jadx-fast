package app.dogo.com.dogo_android.s.b;

import app.dogo.com.dogo_android.model.RemindersModel;
import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class j implements n {

    public final /* synthetic */ l1 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ RemindersModel c;
    public /* synthetic */ j(l1 l1Var, String str, RemindersModel remindersModel) {
        super();
        this.a = l1Var;
        this.b = str;
        this.c = remindersModel;
    }

    public final Object apply(Object object) {
        return ReminderRepository.Q(this.a, this.b, this.c, object);
    }
}
