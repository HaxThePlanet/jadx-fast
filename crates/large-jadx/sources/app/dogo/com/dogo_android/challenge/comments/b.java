package app.dogo.com.dogo_android.d.b;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class b implements View.OnKeyListener {

    public final /* synthetic */ v a;
    public /* synthetic */ b(v vVar) {
        super();
        this.a = vVar;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        return ChallengeCommentsDialog.s2(this.a, view, i, keyEvent);
    }
}
