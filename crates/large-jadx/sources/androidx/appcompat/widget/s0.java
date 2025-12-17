package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class s0 extends androidx.appcompat.widget.k0 {

    private final WeakReference<Context> b;
    public s0(Context context, Resources resources2) {
        super(resources2);
        WeakReference obj2 = new WeakReference(context);
        this.b = obj2;
    }

    @Override // androidx.appcompat.widget.k0
    public Drawable getDrawable(int i) {
        androidx.appcompat.widget.j0 j0Var;
        final Drawable drawable = super.getDrawable(i);
        Object obj = this.b.get();
        if (drawable != null && (Context)obj != null) {
            if ((Context)obj != null) {
                j0.h().x((Context)obj, i, drawable);
            }
        }
        return drawable;
    }
}
