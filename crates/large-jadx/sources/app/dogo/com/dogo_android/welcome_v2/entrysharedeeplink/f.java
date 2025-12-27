package app.dogo.com.dogo_android.welcome_v2.w0;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class f implements View.OnKeyListener {

    public final /* synthetic */ i a;
    public /* synthetic */ f(i iVar) {
        super();
        this.a = iVar;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        return OnboardingChallengeEntryFragment.S1(this.a, view, i, keyEvent);
    }
}
