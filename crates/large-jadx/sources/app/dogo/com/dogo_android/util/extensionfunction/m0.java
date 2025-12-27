package app.dogo.com.dogo_android.util.h0;

import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class m0 implements Runnable {

    public final /* synthetic */ RecyclerView a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ NestedScrollView v;
    public final /* synthetic */ int w;
    public /* synthetic */ m0(RecyclerView recyclerView, int i, int i2, NestedScrollView nestedScrollView, int i3) {
        super();
        this.a = recyclerView;
        this.b = i;
        this.c = i2;
        this.v = nestedScrollView;
        this.w = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        app.dogo.com.dogo_android.util.extensionfunction.j1.z0(this.a, this.b, this.c, this.v, this.w);
    }
}
