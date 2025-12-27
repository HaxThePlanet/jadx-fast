package app.dogo.com.dogo_android.t.h0;

import com.google.android.play.core.tasks.b;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class f implements b {

    public final /* synthetic */ l a;
    public /* synthetic */ f(l lVar) {
        super();
        this.a = lVar;
    }

    public final void onFailure(Exception exc) {
        LanguageSelectViewModel.w(this.a, exc);
    }
}
