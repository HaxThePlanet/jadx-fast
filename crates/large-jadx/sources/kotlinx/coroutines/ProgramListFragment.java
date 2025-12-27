package app.dogo.com.dogo_android.y.y;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.sf;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.y.z.f;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import m.a.b.a.d.a.b;

/* compiled from: ProgramListFragment.kt */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00152\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentProgramListBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListScreen;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onComingSoonItemSelect", "", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onItemSelected", "onRecommendedItemSelect", "onViewCreated", "view", "openProgram", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: f, reason: from kotlin metadata */
public final class ProgramListFragment extends Fragment implements e.a {

    /* renamed from: a, reason: from kotlin metadata */
    private sf binding;
    private final h b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements kotlin.d0.c.a<h> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final h invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(ProgramListViewModel.class), this.$parameters);
        }

        public a(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }
    public f() {
        super();
        final m.a.c.j.a aVar2 = null;
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new kotlinx.coroutines.f.a(this, aVar2, aVar2));
    }

    private final g B1() {
        return (ProgramListScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final h C1() {
        return (ProgramListViewModel)this.b.getValue();
    }

    private static final void E1(f fVar, View view) {
        n.f(fVar, "this$0");
        final androidx.fragment.app.e activity = fVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* renamed from: F1, reason: from kotlin metadata */
    private final void onComingSoonItemSelect(ProgramDescriptionItem item) {
        int i = 1;
        app.dogo.com.dogo_android.y.w.n programLessonsListScreen;
        String str;
        ProgramDescriptionItem.State nOT_STARTED2;
        if (!item.getShouldOpenProgramOverview()) {
            if (item.getProgramState() != ProgramDescriptionItem_State.NOT_STARTED) {
                if (item.getProgramState() != ProgramDescriptionItem_State.RECOMMENDED) {
                    if (item.getProgramState() == ProgramDescriptionItem_State.RECOMMENDED_BIG) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                }
            }
            boolean z2 = false;
            int i2 = 8;
            kotlin.d0.d.g gVar = null;
            programLessonsListScreen = new ProgramLessonsListScreen(i, item.getId(), B1().component1(), z2, B1().getFragmentParentReturnTag(), i2, gVar);
        } else {
            String r0 = B1().component1() ? "library" : "dashboard";
            boolean z3 = false;
            int i3 = 16;
            kotlin.d0.d.g gVar2 = null;
            ProgramOverviewScreen programOverviewScreen = new ProgramOverviewScreen(item.getId(), item.getCardBackgroundColor(), item.getOverviewItem(), B1().component1(), false, B1().getFragmentParentReturnTag(), (B1().component1() ? "library" : "dashboard"), 16, null);
        }
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), programLessonsListScreen);
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: R0, reason: from kotlin metadata */
    public void onItemSelected(ProgramDescriptionItem item) {
        n.f(item, "item");
        C1().n(item.getId());
        app.dogo.com.dogo_android.y.j specialProgramOverviewScreen = item.getSpecialProgramOverviewScreen("library");
        if (specialProgramOverviewScreen != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), specialProgramOverviewScreen);
        } else {
            onComingSoonItemSelect(item);
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: b, reason: from kotlin metadata */
    public void onRecommendedItemSelect(ProgramDescriptionItem item) {
        n.f(item, "item");
        C1().m(item.getId());
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.f1.d0(activity, 2131887129);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        sf sfVar = sf.T(inflater, container, false);
        n.e(sfVar, "inflate(inflater, container, false)");
        this.binding = sfVar;
        int i = 0;
        String str3 = "binding";
        if (sfVar == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            sfVar.M(getViewLifecycleOwner());
            if (this.binding == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.W(C1());
                if (this.binding == null) {
                    n.w(str3);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    this.binding.V(this);
                    if (this.binding == null) {
                        n.w(str3);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        return this.binding.w();
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        int i;
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        i = 0;
        view = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : i;
        if (i != 0) {
            i.p0();
        }
        if (this.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            binding2.Q.setNavigationOnClickListener(new kotlinx.coroutines.d(this));
            C1().l();
            return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: x1, reason: from kotlin metadata */
    public void openProgram(ProgramDescriptionItem item) {
        n.f(item, "item");
        C1().o(item.getId());
        onComingSoonItemSelect(item);
    }


    /* renamed from: D1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(f view, View savedInstanceState) {
        ProgramListFragment.E1(view, savedInstanceState);
    }
}
