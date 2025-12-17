package app.dogo.com.dogo_android.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.d0.d.n;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0006\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0008\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\u000c\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/util/ViewPagerCustomDuration;", "Landroidx/viewpager/widget/ViewPager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mScroller", "Lapp/dogo/com/dogo_android/util/ScrollerCustomDuration;", "postInitViewPager", "", "setScrollDurationFactor", "scrollFactor", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ViewPagerCustomDuration extends ViewPager {

    private app.dogo.com.dogo_android.util.y B0;
    public ViewPagerCustomDuration(Context context, AttributeSet attributeSet2) {
        n.f(context, "context");
        n.f(attributeSet2, "attrs");
        super(context, attributeSet2);
        U();
    }

    private final void U() {
        Field declaredField;
        app.dogo.com.dogo_android.util.y yVar;
        Object obj;
        try {
            declaredField = ViewPager.class.getDeclaredField("B");
            n.e(declaredField, "ViewPager::class.java.getDeclaredField(\"mScroller\")");
            int i = 1;
            declaredField.setAccessible(i);
            Field declaredField2 = ViewPager.class.getDeclaredField("z0");
            n.e(declaredField2, "ViewPager::class.java.getDeclaredField(\"sInterpolator\")");
            declaredField2.setAccessible(i);
            obj = declaredField2.get(0);
            if (obj == null) {
            } else {
            }
            yVar = new y(getContext(), (Interpolator)obj);
            this.B0 = yVar;
            declaredField.set(this, yVar);
            NullPointerException nullPointerException = new NullPointerException("null cannot be cast to non-null type android.view.animation.Interpolator");
            throw nullPointerException;
            int arr = 0;
            arr = new Object[arr];
            a.e(th, "Scroller duration change error", arr);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void setScrollDurationFactor(double d) {
        final app.dogo.com.dogo_android.util.y b0 = this.B0;
        if (b0 == null) {
        } else {
            b0.a(d);
        }
    }
}
