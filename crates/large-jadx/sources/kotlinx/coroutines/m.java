package app.dogo.com.dogo_android.y.o;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class m implements View.OnClickListener {

    public final /* synthetic */ u a;
    public final /* synthetic */ u.i b;
    public /* synthetic */ m(u uVar, u.i iVar) {
        super();
        this.a = uVar;
        this.b = iVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        LessonExamListAdapter_ReadyHolder.b(this.a, this.b, view);
    }
}
