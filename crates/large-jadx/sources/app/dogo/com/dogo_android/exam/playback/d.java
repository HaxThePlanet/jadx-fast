package app.dogo.com.dogo_android.exam.j;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class d implements View.OnClickListener {

    public final /* synthetic */ g a;
    public /* synthetic */ d(g gVar) {
        super();
        this.a = gVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ExamPlaybackFragment.W1(this.a, view);
    }
}
