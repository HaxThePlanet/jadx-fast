package app.dogo.com.dogo_android.g;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class a implements Runnable {

    public final RecyclerView a;
    public a(RecyclerView recyclerView) {
        super();
        this.a = recyclerView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n.c(this.a);
    }
}
