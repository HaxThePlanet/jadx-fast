package d.u;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ViewGroupOverlayApi14.java */
/* loaded from: classes.dex */
class x extends c0 implements z {
    x(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    static x g(ViewGroup viewGroup) {
        return (x)c0.e(viewGroup);
    }

    @Override // d.u.c0
    public void c(View view) {
        this.a.b(view);
    }

    @Override // d.u.c0
    public void d(View view) {
        this.a.g(view);
    }
}
