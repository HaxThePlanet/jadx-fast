package app.dogo.com.dogo_android.f;

import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.repository.domain.RecentlyViewedTricks;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class f implements Runnable {

    public final /* synthetic */ RecyclerView a;
    public final /* synthetic */ RecentlyViewedTricks b;
    public /* synthetic */ f(RecyclerView recyclerView, RecentlyViewedTricks recentlyViewedTricks) {
        super();
        this.a = recyclerView;
        this.b = recentlyViewedTricks;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TrainingBindingAdapters.p(this.a, this.b);
    }
}
