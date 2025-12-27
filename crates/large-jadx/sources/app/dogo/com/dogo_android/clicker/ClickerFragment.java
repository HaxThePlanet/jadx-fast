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
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import m.a.b.a.d.a.b;

/* compiled from: ClickerFragment.kt */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u000c2\u0006\u0010\u001c\u001a\u00020\u00102\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/clicker/ClickerFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentClickerBinding;", "viewModel", "Lapp/dogo/com/dogo_android/clicker/ClickerViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/clicker/ClickerViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i, reason: from kotlin metadata */
public final class ClickerFragment extends Fragment {

    /* renamed from: a, reason: from kotlin metadata */
    private ka binding;
    private final h b;

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0008", d2 = {"app/dogo/com/dogo_android/clicker/ClickerFragment$onViewCreated$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Animation.AnimationListener {

        final /* synthetic */ i a;
        a() {
            this.a = iVar;
            super();
        }

        public void onAnimationEnd(Animation animation) {
            n.f(animation, "animation");
            ka onAttach = this.a.binding;
            if (onAttach == null) {
                n.w("binding");
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) 0;
            } else {
                onAttach.Q.setVisibility(8);
                return;
            }
        }

        public void onAnimationRepeat(Animation animation) {
            n.f(animation, "animation");
        }

        public void onAnimationStart(Animation animation) {
            n.f(animation, "animation");
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements kotlin.d0.c.a<r> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final r invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(ClickerViewModel.class), this.$parameters);
        }

        public b(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }
    public i() {
        super();
        final m.a.c.j.a aVar = null;
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.clicker.i.b(this, aVar, aVar));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ ka onAttach(i context) {
        return context.binding;
    }

    private final r C1() {
        return (ClickerViewModel)this.b.getValue();
    }

    private static final void G1(i iVar, View view) throws android.content.res.Resources.NotFoundException {
        n.f(iVar, "this$0");
        iVar.C1().trackClickerClicked();
        final int i = 0;
        final String str = "binding";
        if (iVar.binding == null) {
            n.w(str);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            binding22.Q.setVisibility(0);
            Animation animation = AnimationUtils.loadAnimation(iVar.requireContext(), 2130772023);
            animation.setAnimationListener(new ClickerFragment_onViewCreated_1_1(iVar));
            if (iVar.binding == null) {
                n.w(str);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                binding2.Q.startAnimation(animation);
                return;
            }
        }
    }

    private static final void H1(i iVar, View view) {
        n.f(iVar, "this$0");
        final androidx.fragment.app.e activity = iVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final boolean I1(i iVar, MenuItem menuItem) {
        n.f(iVar, "this$0");
        n.f(menuItem, "menuItem");
        return iVar.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        androidx.fragment.app.e activity = null;
        n.f(context, "context");
        super.onAttach(context);
        context = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : 0;
        if (activity != null) {
            activity.F();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        ka kaVar = ka.T(inflater, container, false);
        n.e(kaVar, "inflate(inflater, container, false)");
        this.binding = kaVar;
        if (kaVar == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            return kaVar.w();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean onOptionsItemSelected = true;
        n.f(item, "item");
        int itemId = item.getItemId();
        int i = 2131361862;
        int i2 = 1;
        if (itemId != 2131361862) {
            i = 2131361869;
            if (itemId != 2131361869) {
                onOptionsItemSelected = super.onOptionsItemSelected(item);
            } else {
                androidx.fragment.app.e activity = getActivity();
                if (activity != null) {
                    app.dogo.com.dogo_android.util.extensionfunction.g1.showEntryReportDialog(activity, new ClickerSelectScreen());
                }
            }
        } else {
            activity = getActivity();
            if (activity != null) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new ClickerUserHelpScreen());
            }
        }
        return onOptionsItemSelected;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) throws c {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        int i = 0;
        String str2 = "binding";
        if (this.binding == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            binding2.O.setOnClickListener(new app.dogo.com.dogo_android.clicker.a(this));
            if (this.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                binding22.R.setNavigationOnClickListener(new app.dogo.com.dogo_android.clicker.b(this));
                if (this.binding == null) {
                    n.w(str2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    binding23.R.setOnMenuItemClickListener(new app.dogo.com.dogo_android.clicker.c(this));
                    return;
                }
            }
        }
    }


    /* renamed from: D1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(i view, View savedInstanceState) {
        ClickerFragment.G1(view, savedInstanceState);
    }

    public static /* synthetic */ void E1(i iVar, View view) {
        ClickerFragment.H1(iVar, view);
    }

    public static /* synthetic */ boolean F1(i iVar, MenuItem menuItem) {
        return ClickerFragment.I1(iVar, menuItem);
    }
}
