package app.dogo.com.dogo_android.y;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import app.dogo.com.dogo_android.repository.domain.ProgramTasks;
import app.dogo.com.dogo_android.y.c0.g;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final /* synthetic */ ProgramTasks a;
    public final /* synthetic */ ViewGroup b;
    public final /* synthetic */ int c;
    public final /* synthetic */ g v;
    public /* synthetic */ a(ProgramTasks programTasks, ViewGroup viewGroup, int i, g gVar) {
        super();
        this.a = programTasks;
        this.b = viewGroup;
        this.c = i;
        this.v = gVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ProgramBindingAdapters.d(this.a, this.b, this.c, this.v, view);
    }
}
