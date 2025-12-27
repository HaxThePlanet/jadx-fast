package app.dogo.com.dogo_android.y.o;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class k implements View.OnClickListener {

    public final /* synthetic */ u a;
    public final /* synthetic */ u.g b;
    public /* synthetic */ k(u uVar, u.g gVar) {
        super();
        this.a = uVar;
        this.b = gVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        LessonExamListAdapter_PremiumLockedHolder.b(this.a, this.b, view);
    }
}
