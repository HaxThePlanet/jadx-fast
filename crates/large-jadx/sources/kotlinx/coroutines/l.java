package app.dogo.com.dogo_android.y.o;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class l implements View.OnClickListener {

    public final /* synthetic */ u a;
    public /* synthetic */ l(u uVar) {
        super();
        this.a = uVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        LessonExamListAdapter_ProgressHolder.b(this.a, view);
    }
}
