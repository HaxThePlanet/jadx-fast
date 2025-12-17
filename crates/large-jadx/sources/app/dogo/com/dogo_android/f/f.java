package app.dogo.com.dogo_android.f;

import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.repository.domain.RecentlyViewedTricks;

/* loaded from: classes.dex */
public final class f implements Runnable {

    public final RecyclerView a;
    public final RecentlyViewedTricks b;
    public f(RecyclerView recyclerView, RecentlyViewedTricks recentlyViewedTricks2) {
        super();
        this.a = recyclerView;
        this.b = recentlyViewedTricks2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.k(this.a, this.b);
    }
}
