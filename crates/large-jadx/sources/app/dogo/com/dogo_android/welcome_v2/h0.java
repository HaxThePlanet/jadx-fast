package app.dogo.com.dogo_android.welcome_v2;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.sc;
import app.dogo.com.dogo_android.h.y7;
import app.dogo.com.dogo_android.repository.domain.WelcomeSlide;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.l0.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003\u0014\u0015\u0016B\u001b\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0008\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\nH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000c\u001a\u00020\nH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingPagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/welcome_v2/OnboardingPagerAdapter$BaseViewHolder;", "slides", "", "Lapp/dogo/com/dogo_android/repository/domain/WelcomeSlide;", "callback", "Lapp/dogo/com/dogo_android/util/listeners/ViewPagerListener;", "(Ljava/util/List;Lapp/dogo/com/dogo_android/util/listeners/ViewPagerListener;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "BaseViewHolder", "SlideType", "SliderViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class h0 extends RecyclerView.h<app.dogo.com.dogo_android.welcome_v2.h0.a> {

    private final List<WelcomeSlide> a;
    private final b b;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingPagerAdapter$SlideType;", "", "(Ljava/lang/String;I)V", "SLIDE", "EMPTY", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum b {

        SLIDE,
        EMPTY;
        private static final app.dogo.com.dogo_android.welcome_v2.h0.b[] $values() {
            app.dogo.com.dogo_android.welcome_v2.h0.b[] arr = new h0.b[2];
            return arr;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class d {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[h0.b.SLIDE.ordinal()] = 1;
            iArr[h0.b.EMPTY.ordinal()] = 2;
            h0.d.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0096\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingPagerAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Lapp/dogo/com/dogo_android/welcome_v2/OnboardingPagerAdapter;Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public class a extends RecyclerView.e0 {

        private final ViewDataBinding a;
        final app.dogo.com.dogo_android.welcome_v2.h0 b;
        public a(app.dogo.com.dogo_android.welcome_v2.h0 h0, ViewDataBinding viewDataBinding2) {
            n.f(h0, "this$0");
            n.f(viewDataBinding2, "bind");
            this.b = h0;
            super(viewDataBinding2.w());
            this.a = viewDataBinding2;
            final android.view.View obj3 = viewDataBinding2.w();
            n.e(obj3, "bind.root");
            j1.C0(this, obj3, h0.f(h0));
        }
    }

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingPagerAdapter$SliderViewHolder;", "Lapp/dogo/com/dogo_android/welcome_v2/OnboardingPagerAdapter$BaseViewHolder;", "Lapp/dogo/com/dogo_android/welcome_v2/OnboardingPagerAdapter;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellWelcomeSlideBinding;", "(Lapp/dogo/com/dogo_android/welcome_v2/OnboardingPagerAdapter;Lapp/dogo/com/dogo_android/databinding/CellWelcomeSlideBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellWelcomeSlideBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class c extends app.dogo.com.dogo_android.welcome_v2.h0.a {

        private final y7 c;
        public c(app.dogo.com.dogo_android.welcome_v2.h0 h0, y7 y72) {
            n.f(h0, "this$0");
            n.f(y72, "binding");
            super(h0, y72);
            this.c = y72;
        }

        @Override // app.dogo.com.dogo_android.welcome_v2.h0$a
        public final y7 a() {
            return this.c;
        }
    }
    public h0(List<WelcomeSlide> list, b b2) {
        n.f(list, "slides");
        n.f(b2, "callback");
        super();
        this.a = list;
        this.b = b2;
    }

    public static final b f(app.dogo.com.dogo_android.welcome_v2.h0 h0) {
        return h0.b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void g(app.dogo.com.dogo_android.welcome_v2.h0.a h0$a, int i2) {
        boolean z;
        List list;
        Object obj3;
        int obj4;
        n.f(a, "holder");
        if (a instanceof h0.c) {
            (h0.c)a.a().V((WelcomeSlide)this.a.get(i2));
            a.a().p();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return size++;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        app.dogo.com.dogo_android.welcome_v2.h0.b obj2;
        obj2 = p.i(this.a) >= i ? h0.b.SLIDE : h0.b.EMPTY;
        return obj2.ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.welcome_v2.h0.a h(ViewGroup viewGroup, int i2) {
        int i;
        ViewDataBinding obj5;
        app.dogo.com.dogo_android.welcome_v2.h0.a obj6;
        n.f(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        obj6 = h0.d.a[h0.b.values()[i2].ordinal()];
        final String str2 = "inflate(inflater, parent, false)";
        final int i3 = 0;
        if (obj6 != 1) {
            if (obj6 != 2) {
            } else {
                obj5 = sc.T(from, viewGroup, i3);
                n.e(obj5, str2);
                obj6 = new h0.a(this, obj5);
                return obj6;
            }
            obj5 = new NoWhenBranchMatchedException();
            throw obj5;
        }
        obj5 = y7.T(from, viewGroup, i3);
        n.e(obj5, str2);
        obj6 = new h0.c(this, obj5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        g((h0.a)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return h(viewGroup, i2);
    }
}
