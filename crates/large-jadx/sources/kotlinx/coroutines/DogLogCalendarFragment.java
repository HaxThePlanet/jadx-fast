package app.dogo.com.dogo_android.u.n.p;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.u;
import app.dogo.com.dogo_android.h.kc;
import app.dogo.com.dogo_android.h.ol;
import app.dogo.com.dogo_android.k.e;
import app.dogo.com.dogo_android.repository.domain.DogLog;
import app.dogo.com.dogo_android.u.n.p.m.d;
import app.dogo.com.dogo_android.u.n.q.k;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.util.h0.n1;
import com.skydoves.balloon.Balloon;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.j;
import kotlin.m;
import kotlin.w;
import m.a.b.a.d.a.b;

/* compiled from: DogLogCalendarFragment.kt */
@Metadata(d1 = "\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0008\u0010\u0010\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0008\u0010\u001f\u001a\u00020\rH\u0016J\u0008\u0010 \u001a\u00020\rH\u0016J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#H\u0016J\u0016\u0010$\u001a\u00020\r2\u000c\u0010%\u001a\u0008\u0012\u0004\u0012\u00020'0&H\u0016J\u001a\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u00152\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0008\u0010*\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\n\u0010\u000b\u001a\u0004\u0008\u0008\u0010\t¨\u0006+", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/CalendarCallbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogLogCalanderBinding;", "viewModel", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "enableScreen", "", "state", "", "highlightSelectionLayout", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onEmptyCellClicked", "eventTimeMs", "", "onStart", "onStop", "onTagSelected", "type", "Lapp/dogo/com/dogo_android/enums/DogLogTypes;", "onTagsClicked", "selectedTags", "", "Lapp/dogo/com/dogo_android/repository/domain/DogLog;", "onViewCreated", "view", "removeSelectionLayout", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h, reason: from kotlin metadata */
public final class DogLogCalendarFragment extends Fragment implements f {

    /* renamed from: a, reason: from kotlin metadata */
    private kc binding;
    private final kotlin.h b;

    @Metadata(d1 = "\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0007H\u0016¨\u0006\t", d2 = {"app/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarFragment$onStart$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends RecyclerView.u {

        final /* synthetic */ h a;
        a() {
            this.a = hVar;
            super();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$u
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            int dx2 = 1;
            app.dogo.com.dogo_android.u.n.p.g.a aVar;
            int i2;
            n.f(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx, dy);
            dx2 = 0;
            dx = recyclerView.getAdapter() instanceof DogLogCalendarAdapter ? (DogLogCalendarAdapter)recyclerView.getAdapter() : dx2;
            z = recyclerView.getLayoutManager() instanceof LinearLayoutManager;
            recyclerView = recyclerView.getLayoutManager() instanceof inearLayoutManager ? (inearLayoutManager)recyclerView.getLayoutManager() : dx2;
            if (dx2 != 0 && dx2 != 0) {
                int i3 = dx2.v2();
                app.dogo.com.dogo_android.u.n.p.g.a aVar2 = dx2.g(i3);
                dx2 = 1;
                aVar = dx2.g(i3 + dx2);
                dx2 = 0;
                int r2 = dx2;
                str = "binding";
                if (dx2 == 0) {
                    int r1 = dx2;
                    if (dx2 == 0) {
                        kc enableScreen3 = this.a.binding;
                        if (enableScreen3 != null) {
                            if (enableScreen3.U.T() == null && aVar2 != null) {
                                kc enableScreen4 = this.a.binding;
                                if (enableScreen4 == null) {
                                    n.w(str);
                                    /* Dexterity WARN: Type inference failed for thrown value */
                                    throw (Throwable) dx2;
                                } else {
                                    enableScreen4.U.U(Integer.valueOf(aVar2.d()));
                                }
                            }
                        }
                    }
                    n.w(str);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) dx2;
                }
                kc enableScreen = this.a.binding;
                if (enableScreen == null) {
                    n.w(str);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) dx2;
                } else {
                    Integer num = enableScreen.U.T();
                    n.d(aVar2);
                    if (num == null) {
                        kc enableScreen2 = this.a.binding;
                        if (enableScreen2 == null) {
                            n.w(str);
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) dx2;
                        } else {
                            enableScreen2.U.U(Integer.valueOf(aVar2.d()));
                        }
                    }
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", "Landroid/view/View;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends kotlin.d0.d.p implements l<View, w> {
        @Override // kotlin.d0.d.p
        public final void a(View view) {
            n.f(view, "it");
            h.this.G1();
        }

        b() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends kotlin.d0.d.p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            h.this.L1();
        }

        c() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends kotlin.d0.d.p implements kotlin.d0.c.a<j> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final j invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(DogLogCalendarViewModel.class), this.$parameters);
        }

        public d(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }
    public h() {
        super();
        final m.a.c.j.a aVar = null;
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new kotlinx.coroutines.h.d(this, aVar, aVar));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ kc enableScreen(h state) {
        return state.binding;
    }

    /* renamed from: C1, reason: from kotlin metadata */
    public static final /* synthetic */ void onAttach(h context) {
        context.G1();
    }

    /* renamed from: D1, reason: from kotlin metadata */
    public static final /* synthetic */ void onEmptyCellClicked(h eventTimeMs) {
        eventTimeMs.L1();
    }

    /* renamed from: E1, reason: from kotlin metadata */
    private final void onTagSelected(boolean type) {
        int i = 0;
        int i2 = 0;
        i = 0;
        if (this.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            int r2 = type != null ? 8 : 0;
            binding2.W.setVisibility((type != null ? 8 : 0));
            if (type != null) {
                androidx.fragment.app.e activity = getActivity();
                if (activity != null) {
                    Window window2 = activity.getWindow();
                }
                if (i != 0) {
                    i.setStatusBarColor(a.d(requireContext(), 2131100379));
                }
            } else {
                activity = getActivity();
                if (activity != null) {
                    Window window = activity.getWindow();
                }
                if (i != 0) {
                    i.setStatusBarColor(a.d(requireContext(), 2131100333));
                }
            }
            return;
        }
    }

    /* renamed from: F1, reason: from kotlin metadata */
    private final j highlightSelectionLayout() {
        return (DogLogCalendarViewModel)this.b.getValue();
    }

    private final void G1() throws android.content.res.Resources.NotFoundException {
        onTagSelected(false);
        String str = "binding";
        ViewOutlineProvider viewOutlineProvider = null;
        if (this.binding == null) {
            n.w(str);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) viewOutlineProvider;
        } else {
            binding2.T.setOutlineProvider(viewOutlineProvider);
            if (this.binding == null) {
                n.w(str);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) viewOutlineProvider;
            } else {
                binding22.T.setElevation(requireContext().getResources().getDimension(2131165629));
                return;
            }
        }
    }

    private static final void J1(h hVar, View view) {
        n.f(hVar, "this$0");
        final androidx.fragment.app.e activity = hVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void K1(h hVar, Boolean boolean) {
        n.f(hVar, "this$0");
        str = "it";
        n.e(boolean, str);
    }

    private final void L1() {
        onTagSelected(true);
        int i2 = 0;
        final String str = "binding";
        if (this.binding == null) {
            n.w(str);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i2;
        } else {
            binding2.T.setOutlineProvider(ViewOutlineProvider.BOUNDS);
            if (this.binding == null) {
                n.w(str);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i2;
            } else {
                binding22.T.setElevation(0.0f);
                return;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: G0, reason: from kotlin metadata */
    public void onTagsClicked(List<DogLog> selectedTags) {
        n.f(selectedTags, "selectedTags");
        if (selectedTags.isEmpty()) {
            a.f("Empty tag list selected", new Object[0]);
        } else {
            if (selectedTags.size() == 1) {
                androidx.fragment.app.e activity = getActivity();
                if (activity != null) {
                    String str2 = null;
                    int i = 16;
                    kotlin.d0.d.g gVar = null;
                    str = "";
                    DogLogEditScreen dogLogEditScreen = new DogLogEditScreen(str, Long.valueOf((DogLog)p.X(selectedTags).getEventTimeMs()), (DogLog)p.X(selectedTags).getType(), (DogLog)p.X(selectedTags).getLogId(), str2, i, gVar);
                    app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, dogLogEditScreen);
                }
            } else {
                activity = getActivity();
                if (activity != null) {
                    app.dogo.com.dogo_android.util.extensionfunction.g1.showEntryReportDialog(activity, new DogLogSelectScreen(selectedTags));
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void O0(long j) {
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            e eVar = null;
            String str2 = null;
            String str3 = null;
            int i = 28;
            kotlin.d0.d.g gVar = null;
            str = "calendar";
            DogLogEditScreen dogLogEditScreen = new DogLogEditScreen(str, Long.valueOf(j), eVar, str2, str3, i, gVar);
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, dogLogEditScreen);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void Q0(e eVar) {
        n.f(eVar, "type");
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            Long l = null;
            String str2 = null;
            String str3 = null;
            int i = 26;
            kotlin.d0.d.g gVar = null;
            str = "calendar";
            DogLogEditScreen dogLogEditScreen = new DogLogEditScreen(str, l, eVar, str2, str3, i, gVar);
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, dogLogEditScreen);
        }
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
        kc kcVar = kc.T(inflater, container, false);
        n.e(kcVar, "inflate(inflater, container, false)");
        this.binding = kcVar;
        int i = 0;
        String str4 = "binding";
        if (kcVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            kcVar.W(highlightSelectionLayout());
            if (this.binding == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.V(this);
                if (this.binding == null) {
                    n.w(str4);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    this.binding.M(getViewLifecycleOwner());
                    if (this.binding == null) {
                        n.w(str4);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        n.e(binding23.Q, "binding.root");
                        return binding23.Q;
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            binding2.P.l(new DogLogCalendarFragment_onStart_1(this));
            return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            binding2.P.u();
            return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) throws b {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        str = "binding";
        Object obj = null;
        if (this.binding == null) {
            n.w(str);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) obj;
        } else {
            binding2.V.setNavigationOnClickListener(new kotlinx.coroutines.c(this));
            highlightSelectionLayout().s((DogLogCalendarScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this).getSource());
            DogLogCalendarViewModel.q(highlightSelectionLayout(), false, 1, obj);
            if (highlightSelectionLayout().u() && this.binding != null) {
                n.e(binding22.T, "binding.tagsLayout");
                Balloon balloon = app.dogo.com.dogo_android.util.extensionfunction.n1.f(this, binding22.T, highlightSelectionLayout());
                balloon.r0(new kotlinx.coroutines.h.b(this));
                balloon.p0(new kotlinx.coroutines.h.c(this));
            }
            androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
            n.e(viewLifecycleOwner, "viewLifecycleOwner");
            highlightSelectionLayout().n().observe(viewLifecycleOwner, new kotlinx.coroutines.b(this));
            return;
        }
    }


    /* renamed from: H1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(h view, Boolean savedInstanceState) {
        DogLogCalendarFragment.K1(view, savedInstanceState);
    }

    public static /* synthetic */ void I1(h hVar, View view) {
        DogLogCalendarFragment.J1(hVar, view);
    }
}
