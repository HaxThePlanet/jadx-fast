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
import androidx.core.content.a;
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
import app.dogo.com.dogo_android.u.n.p.l.h;
import app.dogo.com.dogo_android.u.n.p.m.d;
import app.dogo.com.dogo_android.u.n.q.k;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.util.h0.n1;
import com.skydoves.balloon.Balloon;
import f.d.a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.w;
import kotlin.y.p;
import m.a.b.a.d.a.b;
import m.a.c.j.a;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0008\u0010\u0010\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0008\u0010\u001f\u001a\u00020\rH\u0016J\u0008\u0010 \u001a\u00020\rH\u0016J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#H\u0016J\u0016\u0010$\u001a\u00020\r2\u000c\u0010%\u001a\u0008\u0012\u0004\u0012\u00020'0&H\u0016J\u001a\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u00152\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0008\u0010*\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\n\u0010\u000b\u001a\u0004\u0008\u0008\u0010\t¨\u0006+", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/CalendarCallbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogLogCalanderBinding;", "viewModel", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "enableScreen", "", "state", "", "highlightSelectionLayout", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onEmptyCellClicked", "eventTimeMs", "", "onStart", "onStop", "onTagSelected", "type", "Lapp/dogo/com/dogo_android/enums/DogLogTypes;", "onTagsClicked", "selectedTags", "", "Lapp/dogo/com/dogo_android/repository/domain/DogLog;", "onViewCreated", "view", "removeSelectionLayout", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class h extends Fragment implements app.dogo.com.dogo_android.u.n.p.f {

    private kc a;
    private final h b;

    @Metadata(d1 = "\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0007H\u0016¨\u0006\t", d2 = {"app/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarFragment$onStart$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends RecyclerView.u {

        final app.dogo.com.dogo_android.u.n.p.h a;
        a(app.dogo.com.dogo_android.u.n.p.h h) {
            this.a = h;
            super();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$u
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            int i;
            int i4;
            String str;
            int obj5;
            int obj6;
            boolean obj7;
            n.f(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            int i5 = 0;
            if (obj6 instanceof g) {
            } else {
                obj6 = i5;
            }
            if (obj5 instanceof LinearLayoutManager != null) {
            } else {
                obj5 = i5;
            }
            if (obj6 != null && obj5 != null) {
                if (obj5 != null) {
                    obj5 = obj5.v2();
                    obj7 = obj6.g(obj5);
                    i = 1;
                    obj5 = obj6.g(obj5 += i);
                    obj6 = 0;
                    if (obj7 == null) {
                        i4 = obj6;
                    } else {
                    }
                    str = "binding";
                    if (i4 == 0) {
                        if (obj5 == null) {
                            i = obj6;
                        } else {
                        }
                        if (i != 0) {
                        } else {
                            obj5 = h.B1(this.a);
                            if (obj5 == null) {
                            } else {
                                if (obj5.U.T() == null && obj7 != null) {
                                    if (obj7 != null) {
                                        obj5 = h.B1(this.a);
                                        if (obj5 == null) {
                                        } else {
                                            obj5.U.U(Integer.valueOf(obj7.d()));
                                        }
                                        n.w(str);
                                        throw i5;
                                    }
                                }
                            }
                        }
                        n.w(str);
                        throw i5;
                    }
                    obj5 = h.B1(this.a);
                    if (obj5 == null) {
                    } else {
                        obj5 = obj5.U.T();
                        n.d(obj7);
                        if (obj5 == null) {
                            obj5 = h.B1(this.a);
                            if (obj5 == null) {
                            } else {
                                obj5.U.U(Integer.valueOf(obj7.d()));
                            }
                            n.w(str);
                            throw i5;
                        } else {
                            if (obj5.intValue() != obj7.d()) {
                            }
                        }
                    }
                    n.w(str);
                    throw i5;
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", "Landroid/view/View;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<View, w> {

        final app.dogo.com.dogo_android.u.n.p.h this$0;
        b(app.dogo.com.dogo_android.u.n.p.h h) {
            this.this$0 = h;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(View view) {
            n.f(view, "it");
            h.C1(this.this$0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((View)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements a<w> {

        final app.dogo.com.dogo_android.u.n.p.h this$0;
        c(app.dogo.com.dogo_android.u.n.p.h h) {
            this.this$0 = h;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            h.D1(this.this$0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements a<app.dogo.com.dogo_android.u.n.p.j> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public d(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.u.n.p.j invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(j.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
    }

    public h() {
        super();
        final int i = 0;
        h.d dVar = new h.d(this, i, i);
        this.b = j.a(m.SYNCHRONIZED, dVar);
    }

    public static final kc B1(app.dogo.com.dogo_android.u.n.p.h h) {
        return h.a;
    }

    public static final void C1(app.dogo.com.dogo_android.u.n.p.h h) {
        h.G1();
    }

    public static final void D1(app.dogo.com.dogo_android.u.n.p.h h) {
        h.L1();
    }

    private final void E1(boolean z) {
        View view;
        int window;
        int i;
        androidx.fragment.app.e obj4;
        kc kcVar = this.a;
        if (kcVar == null) {
        } else {
            i = z ? 8 : 0;
            kcVar.W.setVisibility(i);
            if (z) {
                obj4 = getActivity();
                if (obj4 == null) {
                } else {
                    window = obj4.getWindow();
                }
                if (window == null) {
                } else {
                    window.setStatusBarColor(a.d(requireContext(), 2131100379));
                }
            } else {
                obj4 = getActivity();
                if (obj4 == null) {
                } else {
                    window = obj4.getWindow();
                }
                if (window == null) {
                } else {
                    window.setStatusBarColor(a.d(requireContext(), 2131100333));
                }
            }
        }
        n.w("binding");
        throw 0;
    }

    private final app.dogo.com.dogo_android.u.n.p.j F1() {
        return (j)this.b.getValue();
    }

    private final void G1() {
        E1(false);
        kc kcVar = this.a;
        String str = "binding";
        int i2 = 0;
        if (kcVar == null) {
        } else {
            kcVar.T.setOutlineProvider(i2);
            kc kcVar2 = this.a;
            if (kcVar2 == null) {
            } else {
                kcVar2.T.setElevation(requireContext().getResources().getDimension(2131165629));
            }
            n.w(str);
            throw i2;
        }
        n.w(str);
        throw i2;
    }

    public static void H1(app.dogo.com.dogo_android.u.n.p.h h, Boolean boolean2) {
        h.K1(h, boolean2);
    }

    public static void I1(app.dogo.com.dogo_android.u.n.p.h h, View view2) {
        h.J1(h, view2);
    }

    private static final void J1(app.dogo.com.dogo_android.u.n.p.h h, View view2) {
        n.f(h, "this$0");
        final androidx.fragment.app.e obj0 = h.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void K1(app.dogo.com.dogo_android.u.n.p.h h, Boolean boolean2) {
        String str;
        int i;
        Object obj2;
        boolean obj3;
        n.f(h, "this$0");
        n.e(boolean2, "it");
        if (boolean2.booleanValue()) {
            obj2 = h.getActivity();
            if (obj2 == null) {
            } else {
                i = 0;
                obj3 = new k(i, 1, i);
                g1.n(obj2, obj3);
            }
        }
    }

    private final void L1() {
        E1(true);
        kc kcVar = this.a;
        int i2 = 0;
        final String str = "binding";
        if (kcVar == null) {
        } else {
            kcVar.T.setOutlineProvider(ViewOutlineProvider.BOUNDS);
            kc kcVar2 = this.a;
            if (kcVar2 == null) {
            } else {
                kcVar2.T.setElevation(0);
            }
            n.w(str);
            throw i2;
        }
        n.w(str);
        throw i2;
    }

    public void G0(List<DogLog> list) {
        Object activity;
        h dVar;
        String str;
        Long valueOf;
        e type;
        String logId;
        int i;
        int i2;
        int i3;
        h hVar;
        Object obj11;
        n.f(list, "selectedTags");
        if (list.isEmpty()) {
            a.f("Empty tag list selected", new Object[0]);
        } else {
            if (list.size() == 1) {
                activity = getActivity();
                if (activity == null) {
                } else {
                    super("", Long.valueOf((DogLog)p.X(list).getEventTimeMs()), (DogLog)p.X(list).getType(), (DogLog)p.X(list).getLogId(), 0, 16, 0);
                    g1.n(activity, hVar);
                }
            } else {
                activity = getActivity();
                if (activity == null) {
                } else {
                    dVar = new d(list);
                    g1.X(activity, dVar);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void O0(long l) {
        h hVar2;
        String str;
        Long valueOf;
        int i5;
        int i3;
        int i;
        int i4;
        int i2;
        h hVar;
        final androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            super("calendar", Long.valueOf(l), 0, 0, 0, 28, 0);
            g1.n(activity, hVar);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void Q0(e e) {
        h hVar;
        String str;
        int i;
        Object obj;
        int i5;
        int i4;
        int i3;
        int i2;
        h hVar2;
        n.f(e, "type");
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            super("calendar", 0, e, 0, 0, 26, 0);
            g1.n(activity, hVar2);
        }
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
        kc obj2 = kc.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.W(F1());
            obj2 = this.a;
            if (obj2 == null) {
            } else {
                obj2.V(this);
                obj2 = this.a;
                if (obj2 == null) {
                } else {
                    obj2.M(getViewLifecycleOwner());
                    obj2 = this.a;
                    if (obj2 == null) {
                    } else {
                        obj2 = obj2.Q;
                        n.e(obj2, "binding.root");
                        return obj2;
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
    public void onStart() {
        super.onStart();
        kc kcVar = this.a;
        if (kcVar == null) {
        } else {
            h.a aVar = new h.a(this);
            kcVar.P.l(aVar);
        }
        n.w("binding");
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        kc kcVar = this.a;
        if (kcVar == null) {
        } else {
            kcVar.P.u();
        }
        n.w("binding");
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        boolean obj4;
        Object obj5;
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        obj4 = this.a;
        obj5 = "binding";
        int i = 0;
        if (obj4 == null) {
        } else {
            c cVar = new c(this);
            obj4.V.setNavigationOnClickListener(cVar);
            F1().s((i)k1.a(this).getSource());
            j.q(F1(), false, 1, i);
            if (F1().u()) {
                obj4 = this.a;
                if (obj4 == null) {
                } else {
                    obj4 = obj4.T;
                    n.e(obj4, "binding.tagsLayout");
                    obj4 = n1.f(this, obj4, F1());
                    obj5 = new h.b(this);
                    obj4.r0(obj5);
                    obj5 = new h.c(this);
                    obj4.p0(obj5);
                }
                n.w(obj5);
                throw i;
            }
            obj5 = getViewLifecycleOwner();
            n.e(obj5, "viewLifecycleOwner");
            b bVar = new b(this);
            F1().n().observe(obj5, bVar);
        }
        n.w(obj5);
        throw i;
    }
}
