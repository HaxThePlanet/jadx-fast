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

/* compiled from: CarouselEffectTransformer.kt */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/goodexamples/CarouselEffectTransformer;", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "context", "Landroid/content/Context;", "(Landroidx/viewpager2/widget/ViewPager2;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "transformPage", "", "view", "Landroid/view/View;", "position", "", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: a, reason: from kotlin metadata */
public final class CarouselEffectTransformer implements ViewPager2.k {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final a.a INSTANCE = new a$a(0);
    private final ViewPager2 a;
    /* renamed from: b, reason: from kotlin metadata */
    private final Context viewPager;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/goodexamples/CarouselEffectTransformer$Companion;", "", "()V", "HORIZONTAL_OFFSET_COEFFICIENT", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
    public a(ViewPager2 viewPager2, Context context) {
        n.f(viewPager2, "viewPager");
        n.f(context, "context");
        super();
        this.a = viewPager2;
        this.viewPager = context;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public void transformPage(View view, float position) throws android.content.res.Resources.NotFoundException {
        n.f(view, "view");
        float f8 = (float)(view.getLeft() - this.a.getScrollX()) + (view.getMeasuredWidth() / 2) - (this.a.getMeasuredWidth() / 2) * 0.38f / (float)this.a.getMeasuredWidth();
        float f3 = (float)1 - Math.abs(f8);
        if (this.a > 0) {
            view.setScaleX(f3);
            view.setScaleY(f3);
            int i = 2131165436;
            view.setTranslationX((float)(-this.viewPager.getResources().getDimensionPixelSize(i) * 3) * f8);
        }
        u.s0(view, f3);
    }

}
