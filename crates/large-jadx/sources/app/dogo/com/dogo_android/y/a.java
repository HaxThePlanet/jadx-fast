package app.dogo.com.dogo_android.y;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import app.dogo.com.dogo_android.repository.domain.ProgramTasks;
import app.dogo.com.dogo_android.y.c0.g;

/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final ProgramTasks a;
    public final ViewGroup b;
    public final int c;
    public final g v;
    public a(ProgramTasks programTasks, ViewGroup viewGroup2, int i3, g g4) {
        super();
        this.a = programTasks;
        this.b = viewGroup2;
        this.c = i3;
        this.v = g4;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        l.l(this.a, this.b, this.c, this.v, view);
    }
}
