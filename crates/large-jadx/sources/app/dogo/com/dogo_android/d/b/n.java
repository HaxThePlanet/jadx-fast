package app.dogo.com.dogo_android.d.b;

import com.google.android.gms.tasks.g;

/* loaded from: classes.dex */
public final class n implements g {

    public final app.dogo.com.dogo_android.d.b.x a;
    public n(app.dogo.com.dogo_android.d.b.x x) {
        super();
        this.a = x;
    }

    @Override // com.google.android.gms.tasks.g
    public final void onSuccess(Object object) {
        x.x0(this.a, (QuerySnapshot)object);
    }
}
