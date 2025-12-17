package app.dogo.com.dogo_android.d.c;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import app.dogo.com.dogo_android.d.c.j.a;
import app.dogo.com.dogo_android.d.c.j.b;
import app.dogo.com.dogo_android.h.cn;
import app.dogo.com.dogo_android.h.ia;
import app.dogo.com.dogo_android.k.h;
import app.dogo.com.dogo_android.k.i;
import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.model.ChallengeNotificationModel;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.b0;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.w;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.k0.g;
import app.dogo.com.dogo_android.util.n0.k;
import app.dogo.com.dogo_android.util.n0.v;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import h.a.b.b.p;
import h.a.b.b.s;
import h.a.b.g.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import m.a.b.a.d.a.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\u0018\u0000 ;2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001;B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\u000e\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u0018H\u0014J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u001e0\u001dH\u0016J\u0008\u0010\u001f\u001a\u00020 H\u0016J\u001a\u0010!\u001a\u00020\u00122\u0008\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%H\u0016J\u0008\u0010&\u001a\u00020 H\u0016J$\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0008\u0010+\u001a\u0004\u0018\u00010,2\u0008\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0018\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020.H\u0014J\u0018\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020(2\u0006\u00104\u001a\u00020%H\u0016J\u0018\u00105\u001a\u00020\u00122\u0006\u00104\u001a\u00020%2\u0006\u00106\u001a\u00020%H\u0016J\u0008\u00107\u001a\u00020\u0012H\u0016J\u0008\u00108\u001a\u00020\u0012H\u0016J\u0008\u00109\u001a\u00020\u0012H\u0002J\u0008\u0010:\u001a\u00020\u0012H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\u000c8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\r\u0010\u000e¨\u0006<", d2 = {"Lapp/dogo/com/dogo_android/challenge/notificationcenter/ChallengeNotificationCenterFragmentLegacy;", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyBaseNavFragment;", "Leu/davidea/flexibleadapter/FlexibleAdapter$OnItemClickListener;", "Leu/davidea/flexibleadapter/FlexibleAdapter$OnItemSwipeListener;", "()V", "adapter", "Lapp/dogo/com/dogo_android/challenge/notificationcenter/ChallengeNotificationListAdapter;", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentChallengeNotificationCenterBinding;", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "vm", "Lapp/dogo/com/dogo_android/challenge/notificationcenter/ChallengeNotificationCenterViewModel;", "getVm", "()Lapp/dogo/com/dogo_android/challenge/notificationcenter/ChallengeNotificationCenterViewModel;", "vm$delegate", "Lkotlin/Lazy;", "changeListType", "", "listType", "Lapp/dogo/com/dogo_android/challenge/notificationcenter/ChallengeNotificationCenterViewModel$ListType;", "getFragmentTag", "Lapp/dogo/com/dogo_android/enums/TagGlue;", "getMessagingFilters", "", "Lapp/dogo/com/dogo_android/enums/FragmentMessageAction;", "getScreenViewDescriptor", "Lapp/dogo/com/dogo_android/tracking/Screen;", "getViewModelClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "hasParent", "", "onActionStateChanged", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "actionState", "", "onBackPressed", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDataReceived", "action", "message", "onItemClick", "view", "position", "onItemSwipe", "direction", "onStart", "onStop", "setupObservers", "setupRecycleView", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class g extends w implements b.p, b.s {

    public static final app.dogo.com.dogo_android.d.c.g.a Companion;
    private LinearLayoutManager A;
    private ia x;
    private app.dogo.com.dogo_android.d.c.i y;
    private final h z;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/challenge/notificationcenter/ChallengeNotificationCenterFragmentLegacy$Companion;", "", "()V", "SHOW_BACK_ARROW", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/challenge/notificationcenter/ChallengeNotificationCenterFragmentLegacy$setupRecycleView$1", "Lapp/dogo/com/dogo_android/util/recycle_views/EndlessRecyclerOnScrollListener;", "onLoadMore", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends k {

        final app.dogo.com.dogo_android.d.c.g d;
        c(app.dogo.com.dogo_android.d.c.g g) {
            this.d = g;
            super(5);
        }

        @Override // app.dogo.com.dogo_android.util.n0.k
        public void a() {
            app.dogo.com.dogo_android.d.c.i iVar = g.c2(this.d);
            if (iVar == null) {
            } else {
                iVar.x();
                g.d2(this.d).k();
            }
            n.w("adapter");
            throw 0;
        }
    }

    @Metadata(d1 = "\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0008\u0010\u0006\u001a\u00020\u0003H\u0016J\u0008\u0010\u0007\u001a\u00020\u0008H\u0016J\u0008\u0010\t\u001a\u00020\nH\u0016J\u0008\u0010\u000b\u001a\u00020\nH\u0016J\u0008\u0010\u000c\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011", d2 = {"app/dogo/com/dogo_android/challenge/notificationcenter/ChallengeNotificationCenterFragmentLegacy$onCreateView$1", "Lapp/dogo/com/dogo_android/util/interfaces/TopBarManager;", "getBackArrowColorRes", "", "view", "Landroid/view/View;", "getPopUpMenu", "getTitle", "", "isBackVisible", "", "isMoreActionVisible", "onBack", "", "onMenuItemClick", "item", "Landroid/view/MenuItem;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends g {

        final app.dogo.com.dogo_android.d.c.g a;
        b(app.dogo.com.dogo_android.d.c.g g) {
            this.a = g;
            super();
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public int getBackArrowColorRes(View view) {
            n.f(view, "view");
            return this.a.getResources().getColor(2131099840, 0);
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public int getPopUpMenu() {
            return 2131623940;
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public String getTitle() {
            app.dogo.com.dogo_android.d.c.g gVar = this.a;
            String string = gVar.getString(g.d2(gVar).p().getStringRes());
            n.e(string, "getString(vm.listType.stringRes)");
            return string;
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public boolean isBackVisible() {
            Bundle arguments;
            int bVar;
            app.dogo.com.dogo_android.d.c.h.b uNFOLLOWED;
            int i;
            i = 1;
            final int i2 = 0;
            if (g.d2(this.a).p() != h.b.UNFOLLOWED) {
                arguments = this.a.getArguments();
                if (arguments == null) {
                    bVar = i2;
                } else {
                }
                if (bVar != 0) {
                } else {
                    i = i2;
                }
            }
            return i;
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public boolean isMoreActionVisible() {
            int i;
            i = g.d2(this.a).p() == h.b.FOLLOWED ? 1 : 0;
            return i;
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public void onBack() {
            Object activity;
            app.dogo.com.dogo_android.d.c.h.b uNFOLLOWED;
            if (g.d2(this.a).p() == h.b.UNFOLLOWED) {
                g.b2(this.a, h.b.FOLLOWED);
            } else {
                activity = this.a.getActivity();
                if (activity == null) {
                } else {
                    activity.onBackPressed();
                }
            }
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public boolean onMenuItemClick(MenuItem menuItem) {
            n.f(menuItem, "item");
            if (menuItem.getItemId() == 2131361939) {
                g.b2(this.a, h.b.UNFOLLOWED);
                return 1;
            }
            return 0;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements a<app.dogo.com.dogo_android.d.c.h> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public d(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.d.c.h invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(h.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
        g.a aVar = new g.a(0);
        g.Companion = aVar;
    }

    public g() {
        super();
        final int i = 0;
        g.d dVar = new g.d(this, i, i);
        this.z = j.a(m.SYNCHRONIZED, dVar);
    }

    public static final void b2(app.dogo.com.dogo_android.d.c.g g, app.dogo.com.dogo_android.d.c.h.b h$b2) {
        g.e2(b2);
    }

    public static final app.dogo.com.dogo_android.d.c.i c2(app.dogo.com.dogo_android.d.c.g g) {
        return g.y;
    }

    public static final app.dogo.com.dogo_android.d.c.h d2(app.dogo.com.dogo_android.d.c.g g) {
        return g.f2();
    }

    private final void e2(app.dogo.com.dogo_android.d.c.h.b h$b) {
        int i;
        app.dogo.com.dogo_android.d.c.i obj4;
        app.dogo.com.dogo_android.d.c.i iVar = this.y;
        final String str = "adapter";
        final int i2 = 0;
        if (iVar == null) {
        } else {
            iVar.g();
            app.dogo.com.dogo_android.d.c.i iVar2 = this.y;
            if (iVar2 == null) {
            } else {
                iVar2.x();
                f2().j(b);
                if (b == h.b.FOLLOWED) {
                    obj4 = this.y;
                    if (obj4 == null) {
                    } else {
                        obj4.u(true);
                        obj4 = this.x;
                        if (obj4 == null) {
                        } else {
                            obj4 = obj4.Q.T();
                            if (obj4 == null) {
                            } else {
                                obj4.notifyChange();
                            }
                        }
                        n.w("binding");
                        throw i2;
                    }
                    n.w(str);
                    throw i2;
                }
                obj4 = this.y;
                if (obj4 == null) {
                } else {
                    obj4.u(false);
                }
                n.w(str);
                throw i2;
            }
            n.w(str);
            throw i2;
        }
        n.w(str);
        throw i2;
    }

    private final app.dogo.com.dogo_android.d.c.h f2() {
        return (h)this.z.getValue();
    }

    public static void g2(app.dogo.com.dogo_android.d.c.g g, b0 b02, View view3) {
        g.l2(g, b02, view3);
    }

    public static void h2(app.dogo.com.dogo_android.d.c.g g, List list2) {
        g.o2(g, list2);
    }

    public static void i2(app.dogo.com.dogo_android.d.c.g g, List list2) {
        g.p2(g, list2);
    }

    public static void j2(app.dogo.com.dogo_android.d.c.g g, Boolean boolean2) {
        g.q2(g, boolean2);
    }

    public static void k2(app.dogo.com.dogo_android.d.c.g g, List list2) {
        g.n2(g, list2);
    }

    private static final void l2(app.dogo.com.dogo_android.d.c.g g, b0 b02, View view3) {
        n.f(g, "this$0");
        g.f2().y((a)b02.getId(), true);
        app.dogo.com.dogo_android.d.c.i obj2 = g.y;
        if (obj2 == null) {
        } else {
            obj2.b(b02);
        }
        n.w("adapter");
        throw 0;
    }

    private final void m2() {
        e eVar = new e(this);
        f2().q().observe(getViewLifecycleOwner(), eVar);
        b bVar = new b(this);
        f2().r().observe(getViewLifecycleOwner(), bVar);
        c cVar = new c(this);
        f2().s().observe(getViewLifecycleOwner(), cVar);
        d dVar = new d(this);
        f2().m().observe(getViewLifecycleOwner(), dVar);
    }

    private static final void n2(app.dogo.com.dogo_android.d.c.g g, List list2) {
        Object obj1;
        n.f(g, "this$0");
        if (list2 != null) {
            obj1 = g.y;
            if (obj1 == null) {
            } else {
                obj1.w(list2);
            }
            n.w("adapter");
            throw 0;
        }
    }

    private static final void o2(app.dogo.com.dogo_android.d.c.g g, List list2) {
        Object str2;
        LinearLayoutManager linearLayoutManager;
        int i4;
        int i;
        int i2;
        int i3;
        String str;
        Object obj5;
        Object obj6;
        n.f(g, "this$0");
        if (list2 != null) {
            linearLayoutManager = g.A;
            i2 = 0;
            if (linearLayoutManager == null) {
                i4 = i2;
            } else {
            }
            i3 = 0;
            if (i4 != 0) {
                ia iaVar = g.x;
                if (iaVar == null) {
                } else {
                    iaVar.P.q1(i2);
                }
                n.w("binding");
                throw i3;
            }
            str2 = g.y;
            str = "adapter";
            if (str2 == null) {
            } else {
                str2.c(list2);
                obj5 = g.y;
                if (obj5 == null) {
                } else {
                    if (obj5.n() <= 0) {
                    } else {
                        i = i2;
                    }
                    g.f2().z(i);
                }
                n.w(str);
                throw i3;
            }
            n.w(str);
            throw i3;
        }
    }

    private static final void p2(app.dogo.com.dogo_android.d.c.g g, List list2) {
        Object str;
        int i;
        String str2;
        Object obj3;
        Object obj4;
        n.f(g, "this$0");
        if (list2 != null) {
            str = g.y;
            i = 0;
            str2 = "adapter";
            if (str == null) {
            } else {
                str.t(list2);
                obj3 = g.y;
                if (obj3 == null) {
                } else {
                    obj3 = obj3.n() <= 0 ? 1 : 0;
                    g.f2().z(obj3);
                }
                n.w(str2);
                throw i;
            }
            n.w(str2);
            throw i;
        }
    }

    private static final void q2(app.dogo.com.dogo_android.d.c.g g, Boolean boolean2) {
        String str;
        String str2;
        Object obj2;
        app.dogo.com.dogo_android.d.c.h obj3;
        n.f(g, "this$0");
        if (boolean2 != null) {
            obj3 = g.y;
            str = 0;
            str2 = "adapter";
            if (obj3 == null) {
            } else {
                obj3.z();
                obj2 = g.y;
                if (obj2 == null) {
                } else {
                    obj2 = obj2.n() <= 0 ? 1 : 0;
                    g.f2().z(obj2);
                }
                n.w(str2);
                throw str;
            }
            n.w(str2);
            throw str;
        }
    }

    private final void r2() {
        ArrayList arrayList = new ArrayList();
        app.dogo.com.dogo_android.util.k0.f fVar = F1();
        n.e(fVar, "navAdapterInterface");
        i iVar = new i(arrayList, fVar, D1());
        this.y = iVar;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.A = linearLayoutManager;
        ia iaVar3 = this.x;
        String str = "binding";
        int i4 = 0;
        if (iaVar3 == null) {
        } else {
            iaVar3.P.setLayoutManager(linearLayoutManager);
            ia iaVar = this.x;
            if (iaVar == null) {
            } else {
                app.dogo.com.dogo_android.d.c.i iVar6 = this.y;
                final String str3 = "adapter";
                if (iVar6 == null) {
                } else {
                    iaVar.P.setAdapter(iVar6.k());
                    ia iaVar2 = this.x;
                    if (iaVar2 == null) {
                    } else {
                        g.c cVar = new g.c(this);
                        iaVar2.P.l(cVar);
                        app.dogo.com.dogo_android.d.c.i iVar2 = this.y;
                        if (iVar2 == null) {
                        } else {
                            iVar2.u(true);
                            app.dogo.com.dogo_android.d.c.i iVar3 = this.y;
                            if (iVar3 == null) {
                            } else {
                                iVar3.o().G(4);
                                app.dogo.com.dogo_android.d.c.i iVar4 = this.y;
                                if (iVar4 == null) {
                                } else {
                                    iVar4.o().H(1051931443);
                                    app.dogo.com.dogo_android.d.c.i iVar5 = this.y;
                                    if (iVar5 == null) {
                                    } else {
                                        iVar5.d(this);
                                    }
                                    n.w(str3);
                                    throw i4;
                                }
                                n.w(str3);
                                throw i4;
                            }
                            n.w(str3);
                            throw i4;
                        }
                        n.w(str3);
                        throw i4;
                    }
                    n.w(str);
                    throw i4;
                }
                n.w(str3);
                throw i4;
            }
            n.w(str);
            throw i4;
        }
        n.w(str);
        throw i4;
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public q D1() {
        return i.CHALLENGE_NOTIFICATION_CENTER_FRAGMENT;
    }

    protected Set<h> E1() {
        HashSet hashSet = new HashSet();
        hashSet.add(h.MESSAGE_ACTION_NEW_COMMENT_POSTED);
        return hashSet;
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public k3 H1() {
        return j3.M;
    }

    public Class<? extends r> K1() {
        return r.class;
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public boolean L1() {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public boolean V1() {
        if (f2().p() == h.b.UNFOLLOWED) {
            e2(h.b.FOLLOWED);
            return 1;
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    protected void W1(h h, Bundle bundle2) {
        Enum mESSAGE_ACTION_NEW_COMMENT_POSTED;
        Object obj2;
        Object obj3;
        n.f(h, "action");
        n.f(bundle2, "message");
        obj2 = bundle2.getString("id");
        if (h == h.MESSAGE_ACTION_NEW_COMMENT_POSTED && obj2 != null && f2().p() == h.b.UNFOLLOWED) {
            obj2 = bundle2.getString("id");
            if (obj2 != null) {
                if (f2().p() == h.b.UNFOLLOWED) {
                    obj3 = this.y;
                    if (obj3 == null) {
                    } else {
                        obj3.y(obj2);
                    }
                    n.w("adapter");
                    throw 0;
                }
                f2().i(obj2);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public void e(RecyclerView.e0 recyclerView$e0, int i2) {
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public void n0(int i, int i2) {
        int string2;
        String string;
        boolean z;
        Object aVar;
        int i3;
        int obj6;
        app.dogo.com.dogo_android.d.c.i obj7 = this.y;
        string2 = 0;
        string = "adapter";
        if (obj7 == null) {
        } else {
            obj7 = obj7.m(i);
            if (obj7 instanceof a) {
                f2().y((a)obj7.getId(), false);
                app.dogo.com.dogo_android.d.c.i iVar = this.y;
                if (iVar == null) {
                } else {
                    iVar.s(i);
                    z = this.y;
                    if (z == null) {
                    } else {
                        if (z.n() <= 0) {
                            i3 = 1;
                        }
                        f2().z(i3);
                        obj6 = G1();
                        if (obj6 == null) {
                        } else {
                            string2 = getString(2131886711);
                            n.e(string2, "getString(R.string.general_unfollowed)");
                            aVar = new a(this, obj7);
                            obj6.r0(string2, getString(2131886710), 10000, aVar);
                        }
                    }
                    n.w(string);
                    throw string2;
                }
                n.w(string);
                throw string2;
            }
        }
        n.w(string);
        throw string2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        ia obj2 = ia.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.x = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.V(f2());
            obj2 = this.x;
            if (obj2 == null) {
            } else {
                obj2.M(getViewLifecycleOwner());
                obj2 = this.x;
                if (obj2 == null) {
                } else {
                    g.b bVar = new g.b(this);
                    obj2.Q.U(bVar);
                    r2();
                    m2();
                    obj2 = this.x;
                    if (obj2 == null) {
                    } else {
                        obj2 = obj2.w();
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

    @Override // app.dogo.com.dogo_android.util.e0.w
    public void onStart() {
        int i;
        super.onStart();
        f2().k();
        app.dogo.com.dogo_android.d.c.i iVar = this.y;
        if (iVar == null) {
        } else {
            i = iVar.n() <= 0 ? 1 : 0;
            f2().z(i);
        }
        n.w("adapter");
        throw 0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public void onStop() {
        super.onStop();
        f2().w();
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public boolean x(View view, int i2) {
        boolean entryId;
        String str;
        int obj3;
        Object obj4;
        n.f(view, "view");
        app.dogo.com.dogo_android.d.c.i iVar = this.y;
        if (iVar == null) {
        } else {
            obj4 = iVar.m(i2);
            if (obj4 instanceof a && f2().t()) {
                if (f2().t()) {
                    f2().v((a)obj4.getId());
                    if (view.getId() == 2131362404 && obj4.h().q()) {
                        if (obj4.h().q()) {
                            obj3 = obj4.i();
                            obj4 = G1();
                            if (obj4 == null) {
                            } else {
                                obj4.o0(obj3.getEntryId(), obj3.getChallengeId());
                            }
                        } else {
                            obj3 = j1.l0(obj4.i());
                            if (obj3 != null) {
                                obj4 = G1();
                                if (obj4 == null) {
                                } else {
                                    obj4.j0(obj3);
                                }
                            }
                        }
                    } else {
                    }
                }
            }
            return 0;
        }
        n.w("adapter");
        throw 0;
    }
}
