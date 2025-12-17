package app.dogo.com.dogo_android.y.z;

import android.view.ViewTreeObserver.OnScrollChangedListener;

/* loaded from: classes.dex */
public final class b implements ViewTreeObserver.OnScrollChangedListener {

    public final app.dogo.com.dogo_android.y.z.e a;
    public b(app.dogo.com.dogo_android.y.z.e e) {
        super();
        this.a = e;
    }

    @Override // android.view.ViewTreeObserver$OnScrollChangedListener
    public final void onScrollChanged() {
        e.H1(this.a);
    }
}
