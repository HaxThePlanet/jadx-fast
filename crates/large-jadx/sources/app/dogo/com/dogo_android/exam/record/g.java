package app.dogo.com.dogo_android.exam.k;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class g implements View.OnClickListener {

    public final /* synthetic */ i a;
    public /* synthetic */ g(i iVar) {
        super();
        this.a = iVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ExamRecordFragment.o2(this.a, view);
    }
}
