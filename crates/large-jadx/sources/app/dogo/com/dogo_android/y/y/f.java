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
import app.dogo.com.dogo_android.y.w.n;
import app.dogo.com.dogo_android.y.z.f;
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
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00152\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentProgramListBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListScreen;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onComingSoonItemSelect", "", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onItemSelected", "onRecommendedItemSelect", "onViewCreated", "view", "openProgram", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class f extends Fragment implements app.dogo.com.dogo_android.y.y.e.a {

    private sf a;
    private final h b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements a<app.dogo.com.dogo_android.y.y.h> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public a(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.y.y.h invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(h.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
    }

    public f() {
        super();
        final int i = 0;
        f.a aVar = new f.a(this, i, i);
        this.b = j.a(m.SYNCHRONIZED, aVar);
    }

    private final app.dogo.com.dogo_android.y.y.g B1() {
        return (g)k1.a(this);
    }

    private final app.dogo.com.dogo_android.y.y.h C1() {
        return (h)this.b.getValue();
    }

    public static void D1(app.dogo.com.dogo_android.y.y.f f, View view2) {
        f.E1(f, view2);
    }

    private static final void E1(app.dogo.com.dogo_android.y.y.f f, View view2) {
        n.f(f, "this$0");
        final androidx.fragment.app.e obj0 = f.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private final void F1(ProgramDescriptionItem programDescriptionItem) {
        int i;
        ProgramDescriptionItem.State programState;
        app.dogo.com.dogo_android.y.j nVar2;
        String str2;
        ProgramDescriptionItem.State rECOMMENDED_BIG;
        n nVar;
        int i5;
        String str4;
        boolean z2;
        int i2;
        String fragmentParentReturnTag2;
        int i8;
        int i3;
        f fVar;
        String str;
        String cardBackgroundColor;
        app.dogo.com.dogo_android.repository.domain.ProgramOverview overviewItem;
        boolean z;
        int i4;
        String fragmentParentReturnTag;
        String str3;
        int i6;
        int i7;
        if (!programDescriptionItem.getShouldOpenProgramOverview()) {
            if (programDescriptionItem.getProgramState() != ProgramDescriptionItem.State.NOT_STARTED && programDescriptionItem.getProgramState() != ProgramDescriptionItem.State.RECOMMENDED) {
                if (programDescriptionItem.getProgramState() != ProgramDescriptionItem.State.RECOMMENDED) {
                    if (programDescriptionItem.getProgramState() == ProgramDescriptionItem.State.RECOMMENDED_BIG) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                } else {
                }
            } else {
            }
            super(i, programDescriptionItem.getId(), B1().b(), 0, B1().getFragmentParentReturnTag(), 8, 0);
        } else {
            str2 = B1().b() ? "library" : "dashboard";
            super(programDescriptionItem.getId(), programDescriptionItem.getCardBackgroundColor(), programDescriptionItem.getOverviewItem(), B1().b(), 0, B1().getFragmentParentReturnTag(), str2, 16, 0);
        }
        g1.n(getActivity(), nVar2);
    }

    @Override // androidx.fragment.app.Fragment
    public void R0(ProgramDescriptionItem programDescriptionItem) {
        Object obj3;
        n.f(programDescriptionItem, "item");
        C1().n(programDescriptionItem.getId());
        app.dogo.com.dogo_android.y.j specialProgramOverviewScreen = programDescriptionItem.getSpecialProgramOverviewScreen("library");
        if (specialProgramOverviewScreen != null) {
            g1.n(getActivity(), specialProgramOverviewScreen);
        } else {
            F1(programDescriptionItem);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void b(ProgramDescriptionItem programDescriptionItem) {
        app.dogo.com.dogo_android.y.y.h hVar;
        n.f(programDescriptionItem, "item");
        C1().m(programDescriptionItem.getId());
        androidx.fragment.app.e obj2 = getActivity();
        if (obj2 == null) {
        } else {
            f1.d0(obj2, 2131887129);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        sf obj2 = sf.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.M(getViewLifecycleOwner());
            obj2 = this.a;
            if (obj2 == null) {
            } else {
                obj2.W(C1());
                obj2 = this.a;
                if (obj2 == null) {
                } else {
                    obj2.V(this);
                    obj2 = this.a;
                    if (obj2 == null) {
                    } else {
                        return obj2.w();
                    }
                    n.w(obj4);
                    throw obj3;
                }
                n.w(obj4);
                throw obj3;
            }
            n.w(obj4);
            throw obj3;
        }
        n.w(obj4);
        throw obj3;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        int obj2;
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        int i = 0;
        if (obj2 instanceof a0) {
        } else {
            obj2 = i;
        }
        if (obj2 == null) {
        } else {
            obj2.p0();
        }
        obj2 = this.a;
        if (obj2 == null) {
        } else {
            d obj3 = new d(this);
            obj2.Q.setNavigationOnClickListener(obj3);
            C1().l();
        }
        n.w("binding");
        throw i;
    }

    @Override // androidx.fragment.app.Fragment
    public void x1(ProgramDescriptionItem programDescriptionItem) {
        n.f(programDescriptionItem, "item");
        C1().o(programDescriptionItem.getId());
        F1(programDescriptionItem);
    }
}
