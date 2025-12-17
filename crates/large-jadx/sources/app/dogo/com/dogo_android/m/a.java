package app.dogo.com.dogo_android.m;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2.k;
import d.h.l.u;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/goodexamples/CarouselEffectTransformer;", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "context", "Landroid/content/Context;", "(Landroidx/viewpager2/widget/ViewPager2;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "transformPage", "", "view", "Landroid/view/View;", "position", "", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class a implements ViewPager2.k {

    public static final app.dogo.com.dogo_android.m.a.a Companion;
    private final ViewPager2 a;
    private final Context b;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/goodexamples/CarouselEffectTransformer$Companion;", "", "()V", "HORIZONTAL_OFFSET_COEFFICIENT", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }
    static {
        a.a aVar = new a.a(0);
        a.Companion = aVar;
    }

    public a(ViewPager2 viewPager2, Context context2) {
        n.f(viewPager2, "viewPager");
        n.f(context2, "context");
        super();
        this.a = viewPager2;
        this.b = context2;
    }

    @Override // androidx.viewpager2.widget.ViewPager2$k
    public void a(View view, float f2) {
        int cmp;
        int i;
        n.f(view, "view");
        obj5 /= f;
        f3 -= f4;
        if (Float.compare(i6, i7) > 0) {
            view.setScaleX(i6);
            view.setScaleY(i6);
            view.setTranslationX(f5 *= obj5);
        }
        u.s0(view, i6);
    }
}
