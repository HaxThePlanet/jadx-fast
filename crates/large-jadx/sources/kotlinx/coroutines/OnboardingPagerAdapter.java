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

/* compiled from: OnboardingPagerAdapter.kt */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003\u0014\u0015\u0016B\u001b\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0008\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\nH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000c\u001a\u00020\nH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingPagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/welcome_v2/OnboardingPagerAdapter$BaseViewHolder;", "slides", "", "Lapp/dogo/com/dogo_android/repository/domain/WelcomeSlide;", "callback", "Lapp/dogo/com/dogo_android/util/listeners/ViewPagerListener;", "(Ljava/util/List;Lapp/dogo/com/dogo_android/util/listeners/ViewPagerListener;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "BaseViewHolder", "SlideType", "SliderViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h0, reason: from kotlin metadata */
public final class OnboardingPagerAdapter extends RecyclerView.h<h0.a> {

    /* renamed from: a, reason: from kotlin metadata */
    private final List<WelcomeSlide> callback;
    /* renamed from: b, reason: from kotlin metadata */
    private final b slides;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingPagerAdapter$SlideType;", "", "(Ljava/lang/String;I)V", "SLIDE", "EMPTY", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum b {

        EMPTY,
        SLIDE;
        private static final /* synthetic */ h0.b[] $values() {
            app.dogo.com.dogo_android.welcome_v2.h0.b[] arr = new h0.b[2];
            return new h0.b[] { OnboardingPagerAdapter_SlideType.SLIDE, OnboardingPagerAdapter_SlideType.EMPTY };
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class d {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[OnboardingPagerAdapter_SlideType.values().length];
            iArr[OnboardingPagerAdapter_SlideType.SLIDE.ordinal()] = 1;
            iArr[OnboardingPagerAdapter_SlideType.EMPTY.ordinal()] = 2;
            kotlinx.coroutines.h0.d.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0096\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingPagerAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Lapp/dogo/com/dogo_android/welcome_v2/OnboardingPagerAdapter;Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public class a extends RecyclerView.e0 {

        /* renamed from: a, reason: from kotlin metadata */
        private final ViewDataBinding bind;
        final /* synthetic */ h0 b;
        public a(ViewDataBinding viewDataBinding) {
            n.f(h0Var, "this$0");
            n.f(viewDataBinding, "bind");
            this.b = h0Var;
            super(viewDataBinding.w());
            this.bind = viewDataBinding;
            final android.view.View view2 = viewDataBinding.w();
            n.e(view2, "bind.root");
            app.dogo.com.dogo_android.util.extensionfunction.j1.C0(this, view2, h0Var.slides);
        }
    }

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingPagerAdapter$SliderViewHolder;", "Lapp/dogo/com/dogo_android/welcome_v2/OnboardingPagerAdapter$BaseViewHolder;", "Lapp/dogo/com/dogo_android/welcome_v2/OnboardingPagerAdapter;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellWelcomeSlideBinding;", "(Lapp/dogo/com/dogo_android/welcome_v2/OnboardingPagerAdapter;Lapp/dogo/com/dogo_android/databinding/CellWelcomeSlideBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellWelcomeSlideBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class c extends h0.a {

        private final y7 c;
        public c(y7 y7Var) {
            n.f(h0Var, "this$0");
            n.f(y7Var, "binding");
            super(h0Var, y7Var);
            this.c = y7Var;
        }

        @Override // app.dogo.com.dogo_android.welcome_v2.h0$a
        public final y7 a() {
            return this.c;
        }
    }
    public h0(List<WelcomeSlide> list, b bVar) {
        n.f(list, "slides");
        n.f(bVar, "callback");
        super();
        this.callback = list;
        this.slides = bVar;
    }

    /* renamed from: f, reason: from kotlin metadata */
    public static final /* synthetic */ b getItemViewType(h0 position) {
        return position.slides;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: g, reason: from kotlin metadata */
    public void onBindViewHolder(h0.a holder, int position) {
        n.f(holder, "holder");
        z = holder instanceof OnboardingPagerAdapter_SliderViewHolder;
        if (holder instanceof OnboardingPagerAdapter_SliderViewHolder) {
            holder.a().V((WelcomeSlide)this.callback.get(position));
            holder.a().p();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.callback.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        app.dogo.com.dogo_android.welcome_v2.h0.b sLIDE2;
        i = p.i(this.callback) >= i ? OnboardingPagerAdapter_SlideType.SLIDE : OnboardingPagerAdapter_SlideType.EMPTY;
        return (p.i(this.callback) >= i ? OnboardingPagerAdapter_SlideType.SLIDE : OnboardingPagerAdapter_SlideType.EMPTY);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public h0.a onCreateViewHolder(ViewGroup parent, int viewType) throws NoWhenBranchMatchedException {
        app.dogo.com.dogo_android.welcome_v2.h0.a onboardingPagerAdapter_BaseViewHolder;
        n.f(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        int i2 = kotlinx.coroutines.h0.d.a[OnboardingPagerAdapter_SlideType.values()[viewType].ordinal()];
        int i = 1;
        final String str2 = "inflate(inflater, parent, false)";
        final boolean z = false;
        if (i2 != 1) {
            i = 2;
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                sc scVar = sc.T(from, parent, z);
                n.e(scVar, str2);
                onboardingPagerAdapter_BaseViewHolder = new OnboardingPagerAdapter_BaseViewHolder(this, scVar);
                return onboardingPagerAdapter_BaseViewHolder;
            }
        }
        y7 y7Var = y7.T(from, parent, z);
        n.e(y7Var, str2);
        app.dogo.com.dogo_android.welcome_v2.h0.c onboardingPagerAdapter_SliderViewHolder = new OnboardingPagerAdapter_SliderViewHolder(this, y7Var);
    }
}
