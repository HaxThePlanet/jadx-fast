package app.dogo.com.dogo_android.e;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.ka;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.view.dailytraining.ClickerSoundMaterialButton;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import m.a.b.a.d.a.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u000c2\u0006\u0010\u001c\u001a\u00020\u00102\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/clicker/ClickerFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentClickerBinding;", "viewModel", "Lapp/dogo/com/dogo_android/clicker/ClickerViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/clicker/ClickerViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i extends Fragment {

    private ka a;
    private final h b;

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0008", d2 = {"app/dogo/com/dogo_android/clicker/ClickerFragment$onViewCreated$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Animation.AnimationListener {

        final app.dogo.com.dogo_android.e.i a;
        a(app.dogo.com.dogo_android.e.i i) {
            this.a = i;
            super();
        }

        @Override // android.view.animation.Animation$AnimationListener
        public void onAnimationEnd(Animation animation) {
            n.f(animation, "animation");
            ka obj2 = i.B1(this.a);
            if (obj2 == null) {
            } else {
                obj2.Q.setVisibility(8);
            }
            n.w("binding");
            throw 0;
        }

        @Override // android.view.animation.Animation$AnimationListener
        public void onAnimationRepeat(Animation animation) {
            n.f(animation, "animation");
        }

        @Override // android.view.animation.Animation$AnimationListener
        public void onAnimationStart(Animation animation) {
            n.f(animation, "animation");
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements a<app.dogo.com.dogo_android.e.r> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public b(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.e.r invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(r.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
    }

    public i() {
        super();
        final int i = 0;
        i.b bVar = new i.b(this, i, i);
        this.b = j.a(m.SYNCHRONIZED, bVar);
    }

    public static final ka B1(app.dogo.com.dogo_android.e.i i) {
        return i.a;
    }

    private final app.dogo.com.dogo_android.e.r C1() {
        return (r)this.b.getValue();
    }

    public static void D1(app.dogo.com.dogo_android.e.i i, View view2) {
        i.G1(i, view2);
    }

    public static void E1(app.dogo.com.dogo_android.e.i i, View view2) {
        i.H1(i, view2);
    }

    public static boolean F1(app.dogo.com.dogo_android.e.i i, MenuItem menuItem2) {
        return i.I1(i, menuItem2);
    }

    private static final void G1(app.dogo.com.dogo_android.e.i i, View view2) {
        n.f(i, "this$0");
        i.C1().h();
        ka obj4 = i.a;
        final int i2 = 0;
        final String str = "binding";
        if (obj4 == null) {
        } else {
            obj4.Q.setVisibility(0);
            obj4 = AnimationUtils.loadAnimation(i.requireContext(), 2130772023);
            i.a aVar = new i.a(i);
            obj4.setAnimationListener(aVar);
            ka obj3 = i.a;
            if (obj3 == null) {
            } else {
                obj3.Q.startAnimation(obj4);
            }
            n.w(str);
            throw i2;
        }
        n.w(str);
        throw i2;
    }

    private static final void H1(app.dogo.com.dogo_android.e.i i, View view2) {
        n.f(i, "this$0");
        final androidx.fragment.app.e obj0 = i.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final boolean I1(app.dogo.com.dogo_android.e.i i, MenuItem menuItem2) {
        n.f(i, "this$0");
        n.f(menuItem2, "menuItem");
        return i.onOptionsItemSelected(menuItem2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        androidx.fragment.app.e obj2;
        n.f(context, "context");
        super.onAttach(context);
        if (obj2 instanceof a0) {
        } else {
            obj2 = 0;
        }
        if (obj2 == null) {
        } else {
            obj2.F();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        ka obj1 = ka.T(layoutInflater, viewGroup2, false);
        n.e(obj1, "inflate(inflater, container, false)");
        this.a = obj1;
        if (obj1 == null) {
        } else {
            return obj1.w();
        }
        n.w("binding");
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId;
        int i;
        int onOptionsItemSelected;
        Object obj4;
        n.f(menuItem, "item");
        itemId = menuItem.getItemId();
        onOptionsItemSelected = 1;
        if (itemId != 2131361862) {
            if (itemId != 2131361869) {
                onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
            } else {
                obj4 = getActivity();
                if (obj4 == null) {
                } else {
                    itemId = new m();
                    g1.X(obj4, itemId);
                }
            }
        } else {
            obj4 = getActivity();
            if (obj4 == null) {
            } else {
                itemId = new q();
                g1.n(obj4, itemId);
            }
        }
        return onOptionsItemSelected;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        ka obj3 = this.a;
        int obj4 = 0;
        String str2 = "binding";
        if (obj3 == null) {
        } else {
            a aVar = new a(this);
            obj3.O.setOnClickListener(aVar);
            obj3 = this.a;
            if (obj3 == null) {
            } else {
                b bVar = new b(this);
                obj3.R.setNavigationOnClickListener(bVar);
                obj3 = this.a;
                if (obj3 == null) {
                } else {
                    obj4 = new c(this);
                    obj3.R.setOnMenuItemClickListener(obj4);
                }
                n.w(str2);
                throw obj4;
            }
            n.w(str2);
            throw obj4;
        }
        n.w(str2);
        throw obj4;
    }
}
