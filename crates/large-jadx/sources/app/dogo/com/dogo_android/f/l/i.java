package app.dogo.com.dogo_android.f.l;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.a;
import app.dogo.com.dogo_android.h.a8;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.w;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB/\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ \u0010\u000c\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0008\u0010\u0012\u001a\u00020\u0004H\u0016J\u0006\u0010\u0013\u001a\u00020\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0018\u0010\u0018\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "callback", "Lkotlin/Function1;", "", "", "onSessionFinished", "Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutAdapter$OnSessionFinished;", "trickList", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "(Lkotlin/jvm/functions/Function1;Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutAdapter$OnSessionFinished;Ljava/util/List;)V", "destroyItem", "container", "Landroid/view/ViewGroup;", "position", "objectView", "", "getCount", "getCountWithoutOffset", "getPageTitle", "", "getPageWidth", "", "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "reachedEmptyViewPlace", "Companion", "OnSessionFinished", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i extends a {

    public static final app.dogo.com.dogo_android.f.l.i.a Companion;
    private final l<Integer, w> c;
    private final app.dogo.com.dogo_android.f.l.i.b d;
    private final List<TrickItem> e;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutAdapter$Companion;", "", "()V", "EMPTY_CARD_COUNT_OFFSET", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004", d2 = {"Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutAdapter$OnSessionFinished;", "", "finished", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface b {
        public abstract void m1();
    }
    static {
        i.a aVar = new i.a(0);
        i.Companion = aVar;
    }

    public i(l<? super Integer, w> l, app.dogo.com.dogo_android.f.l.i.b i$b2, List<TrickItem> list3) {
        n.f(l, "callback");
        n.f(b2, "onSessionFinished");
        n.f(list3, "trickList");
        super();
        this.c = l;
        this.d = b2;
        this.e = list3;
    }

    private static final void u(app.dogo.com.dogo_android.f.l.i i, int i2, View view3) {
        n.f(i, "this$0");
        i.c.invoke(Integer.valueOf(i2));
    }

    public static void v(app.dogo.com.dogo_android.f.l.i i, int i2, View view3) {
        i.u(i, i2, view3);
    }

    private final boolean w(int i) {
        int obj2;
        obj2 = i > p.i(this.e) ? 1 : 0;
        return obj2;
    }

    @Override // androidx.viewpager.widget.a
    public void a(ViewGroup viewGroup, int i2, Object object3) {
        n.f(viewGroup, "container");
        n.f(object3, "objectView");
        viewGroup.removeView((View)object3);
    }

    @Override // androidx.viewpager.widget.a
    public int d() {
        return size += 2;
    }

    @Override // androidx.viewpager.widget.a
    public java.lang.CharSequence f(int i) {
        int obj2;
        obj2 = p.a0(this.e, i);
        if ((TrickItem)obj2 == null) {
            obj2 = 0;
        } else {
            obj2 = (TrickItem)obj2.getId();
        }
        return obj2;
    }

    @Override // androidx.viewpager.widget.a
    public float g(int i) {
        return 1059481190;
    }

    @Override // androidx.viewpager.widget.a
    public Object h(ViewGroup viewGroup, int i2) {
        Object obj4;
        int obj5;
        n.f(viewGroup, "container");
        a8 a8Var = a8.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(a8Var, "inflate(inflater, container, false)");
        View view = a8Var.w();
        n.e(view, "binding.root");
        viewGroup.addView(view);
        obj4 = new a(this, i2);
        view.setOnClickListener(obj4);
        if (w(i2)) {
            a8Var.O.setVisibility(4);
        } else {
            a8Var.V((TrickItem)this.e.get(i2));
        }
        return view;
    }

    @Override // androidx.viewpager.widget.a
    public boolean i(View view, Object object2) {
        int obj2;
        n.f(view, "view");
        n.f(object2, "objectView");
        obj2 = view == object2 ? 1 : 0;
        return obj2;
    }

    @Override // androidx.viewpager.widget.a
    public final int t() {
        return this.e.size();
    }
}
