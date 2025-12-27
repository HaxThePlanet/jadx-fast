package app.dogo.com.dogo_android.t.g0;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class d implements View.OnClickListener {

    public final /* synthetic */ j a;
    public final /* synthetic */ j.c b;
    public /* synthetic */ d(j jVar, j.c cVar) {
        super();
        this.a = jVar;
        this.b = cVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        FaqRecyclerViewAdapter_QuestionHolder.b(this.a, this.b, view);
    }
}
