package app.dogo.com.dogo_android.d.c;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import app.dogo.com.dogo_android.h.cn;
import app.dogo.com.dogo_android.h.ia;
import app.dogo.com.dogo_android.k.i;
import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.model.ChallengeNotificationModel;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.b0;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.w;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.n0.k;
import app.dogo.com.dogo_android.util.n0.v;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import h.a.b.b.p;
import h.a.b.b.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.j;
import kotlin.m;

/* compiled from: ChallengeNotificationCenterFragmentLegacy.kt */
@Metadata(d1 = "\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\u0018\u0000 ;2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001;B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\u000e\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u0018H\u0014J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u001e0\u001dH\u0016J\u0008\u0010\u001f\u001a\u00020 H\u0016J\u001a\u0010!\u001a\u00020\u00122\u0008\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%H\u0016J\u0008\u0010&\u001a\u00020 H\u0016J$\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0008\u0010+\u001a\u0004\u0018\u00010,2\u0008\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0018\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020.H\u0014J\u0018\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020(2\u0006\u00104\u001a\u00020%H\u0016J\u0018\u00105\u001a\u00020\u00122\u0006\u00104\u001a\u00020%2\u0006\u00106\u001a\u00020%H\u0016J\u0008\u00107\u001a\u00020\u0012H\u0016J\u0008\u00108\u001a\u00020\u0012H\u0016J\u0008\u00109\u001a\u00020\u0012H\u0002J\u0008\u0010:\u001a\u00020\u0012H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\u000c8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\r\u0010\u000e¨\u0006<", d2 = {"Lapp/dogo/com/dogo_android/challenge/notificationcenter/ChallengeNotificationCenterFragmentLegacy;", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyBaseNavFragment;", "Leu/davidea/flexibleadapter/FlexibleAdapter$OnItemClickListener;", "Leu/davidea/flexibleadapter/FlexibleAdapter$OnItemSwipeListener;", "()V", "adapter", "Lapp/dogo/com/dogo_android/challenge/notificationcenter/ChallengeNotificationListAdapter;", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentChallengeNotificationCenterBinding;", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "vm", "Lapp/dogo/com/dogo_android/challenge/notificationcenter/ChallengeNotificationCenterViewModel;", "getVm", "()Lapp/dogo/com/dogo_android/challenge/notificationcenter/ChallengeNotificationCenterViewModel;", "vm$delegate", "Lkotlin/Lazy;", "changeListType", "", "listType", "Lapp/dogo/com/dogo_android/challenge/notificationcenter/ChallengeNotificationCenterViewModel$ListType;", "getFragmentTag", "Lapp/dogo/com/dogo_android/enums/TagGlue;", "getMessagingFilters", "", "Lapp/dogo/com/dogo_android/enums/FragmentMessageAction;", "getScreenViewDescriptor", "Lapp/dogo/com/dogo_android/tracking/Screen;", "getViewModelClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "hasParent", "", "onActionStateChanged", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "actionState", "", "onBackPressed", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDataReceived", "action", "message", "onItemClick", "view", "position", "onItemSwipe", "direction", "onStart", "onStop", "setupObservers", "setupRecycleView", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g, reason: from kotlin metadata */
public final class ChallengeNotificationCenterFragmentLegacy extends w implements b.p, b.s {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final g.a INSTANCE = new g$a(0);
    /* renamed from: A, reason: from kotlin metadata */
    private LinearLayoutManager adapter;
    /* renamed from: x, reason: from kotlin metadata */
    private ia binding;
    /* renamed from: y, reason: from kotlin metadata */
    private i linearLayoutManager;
    private final kotlin.h z;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/challenge/notificationcenter/ChallengeNotificationCenterFragmentLegacy$Companion;", "", "()V", "SHOW_BACK_ARROW", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(kotlin.d0.d.g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/challenge/notificationcenter/ChallengeNotificationCenterFragmentLegacy$setupRecycleView$1", "Lapp/dogo/com/dogo_android/util/recycle_views/EndlessRecyclerOnScrollListener;", "onLoadMore", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends k {

        final /* synthetic */ g d;
        c() {
            this.d = gVar;
            super(5);
        }

        @Override // app.dogo.com.dogo_android.util.n0.k
        /* renamed from: a, reason: from kotlin metadata */
        public void onLoadMore() {
            app.dogo.com.dogo_android.d.c.i changeListType = this.d.linearLayoutManager;
            if (changeListType == null) {
                n.w("adapter");
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) 0;
            } else {
                changeListType.x();
                this.d.getFragmentTag().k();
                return;
            }
        }
    }

    @Metadata(d1 = "\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0008\u0010\u0006\u001a\u00020\u0003H\u0016J\u0008\u0010\u0007\u001a\u00020\u0008H\u0016J\u0008\u0010\t\u001a\u00020\nH\u0016J\u0008\u0010\u000b\u001a\u00020\nH\u0016J\u0008\u0010\u000c\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011", d2 = {"app/dogo/com/dogo_android/challenge/notificationcenter/ChallengeNotificationCenterFragmentLegacy$onCreateView$1", "Lapp/dogo/com/dogo_android/util/interfaces/TopBarManager;", "getBackArrowColorRes", "", "view", "Landroid/view/View;", "getPopUpMenu", "getTitle", "", "isBackVisible", "", "isMoreActionVisible", "onBack", "", "onMenuItemClick", "item", "Landroid/view/MenuItem;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends app.dogo.com.dogo_android.util.k0.g {

        final /* synthetic */ g a;
        b() {
            this.a = gVar;
            super();
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public int getBackArrowColorRes(View view) throws android.content.res.Resources.NotFoundException {
            n.f(view, "view");
            return this.a.getResources().getColor(2131099840, null);
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public String getTitle() {
            String string = this.a.getString(this.a.getFragmentTag().p().getStringRes());
            n.e(string, "getString(vm.listType.stringRes)");
            return string;
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public boolean isBackVisible() {
            int i;
            app.dogo.com.dogo_android.d.c.h.b uNFOLLOWED2;
            Object str;
            boolean z = true;
            i = 1;
            z = false;
            if (this.a.getFragmentTag().p() != ChallengeNotificationCenterViewModel_ListType.UNFOLLOWED) {
                Bundle arguments = this.a.getArguments();
                boolean r0 = z;
                if (this.a == 0) {
                }
            }
            return z;
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public boolean isMoreActionVisible() {
            boolean z = true;
            int r0 = this.a.getFragmentTag().p() == ChallengeNotificationCenterViewModel_ListType.FOLLOWED ? 1 : 0;
            return (this.a.getFragmentTag().p() == ChallengeNotificationCenterViewModel_ListType.FOLLOWED ? 1 : 0);
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public void onBack() {
            if (this.a.getFragmentTag().p() == ChallengeNotificationCenterViewModel_ListType.UNFOLLOWED) {
                this.a.e2(ChallengeNotificationCenterViewModel_ListType.FOLLOWED);
            } else {
                androidx.fragment.app.e activity = this.a.getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                }
            }
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public boolean onMenuItemClick(MenuItem item) {
            n.f(item, "item");
            if (item.getItemId() == R.id.archive) {
                this.a.e2(ChallengeNotificationCenterViewModel_ListType.UNFOLLOWED);
                return true;
            }
            return false;
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public int getPopUpMenu() {
            return R.menu.notifcation_tab;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements kotlin.d0.c.a<h> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final h invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(ChallengeNotificationCenterViewModel.class), this.$parameters);
        }

        public d(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    public g() {
        super();
        final m.a.c.j.a aVar = null;
        this.z = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.challenge.notificationcenter.g.d(this, aVar, aVar));
    }

    /* renamed from: b2, reason: from kotlin metadata */
    public static final /* synthetic */ void onActionStateChanged(g viewHolder, h.b actionState) {
        viewHolder.e2(actionState);
    }

    /* renamed from: c2, reason: from kotlin metadata */
    public static final /* synthetic */ i changeListType(g listType) {
        return listType.linearLayoutManager;
    }

    public static final /* synthetic */ h d2(g gVar) {
        return gVar.getFragmentTag();
    }

    private final void e2(h.b bVar) {
        final String str = "adapter";
        final int i = 0;
        if (this.linearLayoutManager == null) {
            n.w(str);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            this.linearLayoutManager.addLoadingCell();
            if (this.linearLayoutManager == null) {
                n.w(str);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.linearLayoutManager.x();
                getFragmentTag().changeListType(bVar);
                if (bVar == ChallengeNotificationCenterViewModel_ListType.FOLLOWED) {
                    if (this.linearLayoutManager == null) {
                        n.w(str);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        boolean z = true;
                        this.linearLayoutManager.removeItems(z);
                        if (this.binding == null) {
                            n.w("binding");
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) i;
                        } else {
                            app.dogo.com.dogo_android.util.k0.g gVar = binding2.Q.T();
                            if (gVar != null) {
                                gVar.notifyChange();
                            }
                            return;
                        }
                    }
                }
                if (this.linearLayoutManager == null) {
                    n.w(str);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    z = false;
                    this.linearLayoutManager.removeItems(z);
                }
            }
        }
    }

    /* renamed from: f2, reason: from kotlin metadata */
    private final h getFragmentTag() {
        return (ChallengeNotificationCenterViewModel)this.z.getValue();
    }

    private static final void l2(g gVar, b0 b0Var, View view) {
        n.f(gVar, "this$0");
        gVar.getFragmentTag().updateFollowState((ChallengeNotificationItem)b0Var.getId(), true);
        if (gVar.linearLayoutManager == null) {
            n.w("adapter");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            gVar.linearLayoutManager.b(b0Var);
            return;
        }
    }

    private final void m2() {
        getFragmentTag().q().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.challenge.notificationcenter.e(this));
        getFragmentTag().r().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.challenge.notificationcenter.b(this));
        getFragmentTag().s().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.challenge.notificationcenter.c(this));
        getFragmentTag().m().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.challenge.notificationcenter.d(this));
    }

    private static final void n2(g gVar, List list) {
        n.f(gVar, "this$0");
        if (list != null && gVar.linearLayoutManager != null) {
            gVar.linearLayoutManager.updateItem(list);
        }
    }

    private static final void o2(g gVar, List list) {
        int i;
        boolean z = true;
        str = "this$0";
        n.f(gVar, str);
        if (list != null) {
            i = 0;
            int r0 = i;
            int i2 = 0;
            if (gVar.adapter != null) {
                if (gVar.binding == null) {
                    n.w("binding");
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i2;
                } else {
                    binding2.P.q1(i);
                }
            }
            str2 = "adapter";
            if (gVar.linearLayoutManager == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i2;
            } else {
                gVar.linearLayoutManager.addItems(list);
                if (gVar.linearLayoutManager == null) {
                    n.w(str2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i2;
                } else {
                    if (gVar.linearLayoutManager.n() > 0) {
                    }
                    gVar.getFragmentTag().z(z);
                }
            }
        }
    }

    private static final void p2(g gVar, List list) {
        boolean z = false;
        str = "this$0";
        n.f(gVar, str);
        if (list != null) {
            int i = 0;
            str2 = "adapter";
            if (gVar.linearLayoutManager == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                gVar.linearLayoutManager.removeItemAt(list);
                if (gVar.linearLayoutManager == null) {
                    n.w(str2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    gVar = gVar.linearLayoutManager.n() <= 0 ? 1 : 0;
                    gVar.getFragmentTag().z((gVar.linearLayoutManager.n() <= 0 ? 1 : 0));
                }
            }
        }
    }

    private static final void q2(g gVar, Boolean boolean) {
        boolean z = false;
        str = "this$0";
        n.f(gVar, str);
        if (boolean != null) {
            int i = 0;
            str2 = "adapter";
            if (gVar.linearLayoutManager == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                gVar.linearLayoutManager.z();
                if (gVar.linearLayoutManager == null) {
                    n.w(str2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    gVar = gVar.linearLayoutManager.n() <= 0 ? 1 : 0;
                    gVar.getFragmentTag().z((gVar.linearLayoutManager.n() <= 0 ? 1 : 0));
                }
            }
        }
    }

    private final void r2() {
        app.dogo.com.dogo_android.util.k0.f fVar = F1();
        n.e(fVar, "navAdapterInterface");
        this.linearLayoutManager = new ChallengeNotificationListAdapter(new ArrayList(), fVar, D1());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.adapter = linearLayoutManager;
        String str = "binding";
        int i4 = 0;
        if (this.binding == null) {
            n.w(str);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i4;
        } else {
            binding23.P.setLayoutManager(linearLayoutManager);
            if (this.binding == null) {
                n.w(str);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i4;
            } else {
                final String str3 = "adapter";
                if (this.linearLayoutManager == null) {
                    n.w(str3);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i4;
                } else {
                    binding2.P.setAdapter(this.linearLayoutManager.k());
                    if (this.binding == null) {
                        n.w(str);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i4;
                    } else {
                        binding22.P.l(new ChallengeNotificationCenterFragmentLegacy_setupRecycleView_1(this));
                        if (this.linearLayoutManager == null) {
                            n.w(str3);
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) i4;
                        } else {
                            this.linearLayoutManager.removeItems(true);
                            if (this.linearLayoutManager == null) {
                                n.w(str3);
                                /* Dexterity WARN: Type inference failed for thrown value */
                                throw (Throwable) i4;
                            } else {
                                this.linearLayoutManager.o().G(4);
                                if (this.linearLayoutManager == null) {
                                    n.w(str3);
                                    /* Dexterity WARN: Type inference failed for thrown value */
                                    throw (Throwable) i4;
                                } else {
                                    this.linearLayoutManager.o().H(0.35f);
                                    if (this.linearLayoutManager == null) {
                                        n.w(str3);
                                        /* Dexterity WARN: Type inference failed for thrown value */
                                        throw (Throwable) i4;
                                    } else {
                                        this.linearLayoutManager.addListener(this);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public q D1() {
        return FragmentTags.CHALLENGE_NOTIFICATION_CENTER_FRAGMENT;
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    protected Set<app.dogo.com.dogo_android.k.h> E1() {
        final HashSet hashSet = new HashSet();
        hashSet.add(FragmentMessageAction.MESSAGE_ACTION_NEW_COMMENT_POSTED);
        return hashSet;
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public k3 H1() {
        return S.dailyReminderOld;
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public boolean V1() {
        if (getFragmentTag().p() == ChallengeNotificationCenterViewModel_ListType.UNFOLLOWED) {
            e2(ChallengeNotificationCenterViewModel_ListType.FOLLOWED);
            return true;
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    protected void W1(app.dogo.com.dogo_android.k.h hVar, Bundle bundle) {
        n.f(hVar, "action");
        n.f(bundle, "message");
        if (hVar == FragmentMessageAction.MESSAGE_ACTION_NEW_COMMENT_POSTED) {
            String string = bundle.getString("id");
            if (string != null) {
                if (getFragmentTag().p() == ChallengeNotificationCenterViewModel_ListType.UNFOLLOWED) {
                    if (this.linearLayoutManager == null) {
                        n.w("adapter");
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) 0;
                    } else {
                        this.linearLayoutManager.removeItemById(string);
                    }
                }
                getFragmentTag().addToTemporaryIgnoreList(string);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public void n0(int i, int i2) {
        boolean z2 = false;
        int i3 = 0;
        string = "adapter";
        if (this.linearLayoutManager == null) {
            n.w(string);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i3;
        } else {
            b0 i22 = this.linearLayoutManager.m(i);
            z = i22 instanceof ChallengeNotificationItem;
            if (i22 instanceof ChallengeNotificationItem) {
                z2 = false;
                getFragmentTag().updateFollowState((ChallengeNotificationItem)i22.getId(), z2);
                if (this.linearLayoutManager == null) {
                    n.w(string);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i3;
                } else {
                    this.linearLayoutManager.removeItem(i);
                    if (this.linearLayoutManager == null) {
                        n.w(string);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i3;
                    } else {
                        if (this.linearLayoutManager.n() <= 0) {
                            int i7 = 1;
                        }
                        getFragmentTag().z(z2);
                        a0 a0Var = G1();
                        if (a0Var != null) {
                            String string2 = getString(2131886711);
                            n.e(string2, "getString(R.string.general_unfollowed)");
                            a0Var.switchFullscreenFragment(string2, getString(2131886710), 10000, new app.dogo.com.dogo_android.challenge.notificationcenter.a(this, i22));
                        }
                    }
                }
            }
            return;
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        n.f(layoutInflater, "inflater");
        ia iaVar = ia.T(layoutInflater, viewGroup, false);
        n.e(iaVar, "inflate(inflater, container, false)");
        this.binding = iaVar;
        int i = 0;
        String str4 = "binding";
        if (iaVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            iaVar.V(getFragmentTag());
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
                    binding22.Q.U(new ChallengeNotificationCenterFragmentLegacy_onCreateView_1(this));
                    r2();
                    m2();
                    if (this.binding == null) {
                        n.w(str4);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        View view = this.binding.w();
                        n.e(view, "binding.root");
                        return view;
                    }
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public void onStart() {
        boolean z = false;
        super.onStart();
        getFragmentTag().k();
        if (this.linearLayoutManager == null) {
            n.w("adapter");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            int r1 = this.linearLayoutManager.n() <= 0 ? 1 : 0;
            getFragmentTag().z((this.linearLayoutManager.n() <= 0 ? 1 : 0));
            return;
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public void onStop() {
        super.onStop();
        getFragmentTag().w();
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public boolean x(View view, int i) {
        n.f(view, "view");
        if (this.linearLayoutManager == null) {
            n.w("adapter");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            b0 b0Var = this.linearLayoutManager.m(i);
            z = b0Var instanceof ChallengeNotificationItem;
            if (b0Var instanceof ChallengeNotificationItem) {
                if (getFragmentTag().t()) {
                    getFragmentTag().markNotificationAsViewed(b0Var.getId());
                    if (view.getId() == 2131362404) {
                        if (b0Var.h().q()) {
                            ChallengeNotificationModel challengeNotificationModel2 = b0Var.i();
                            a0 a0Var2 = G1();
                            if (a0Var2 != null) {
                                a0Var2.o0(challengeNotificationModel2.getEntryId(), challengeNotificationModel2.getChallengeId());
                            }
                        }
                    }
                }
            }
            return false;
        }
    }

    /* renamed from: g2, reason: from kotlin metadata */
    public static /* synthetic */ void onCreateView(g inflater, b0 container, View savedInstanceState) {
        ChallengeNotificationCenterFragmentLegacy.l2(inflater, container, savedInstanceState);
    }

    /* renamed from: h2, reason: from kotlin metadata */
    public static /* synthetic */ void onDataReceived(g action, List message) {
        ChallengeNotificationCenterFragmentLegacy.o2(action, message);
    }

    /* renamed from: i2, reason: from kotlin metadata */
    public static /* synthetic */ void onItemClick(g view, List position) {
        ChallengeNotificationCenterFragmentLegacy.p2(view, position);
    }

    /* renamed from: j2, reason: from kotlin metadata */
    public static /* synthetic */ void onItemSwipe(g position, Boolean direction) {
        ChallengeNotificationCenterFragmentLegacy.q2(position, direction);
    }

    public static /* synthetic */ void k2(g gVar, List list) {
        ChallengeNotificationCenterFragmentLegacy.n2(gVar, list);
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public Class<? extends r> K1() {
        return BaseViewModel.class;
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public boolean L1() {
        return true;
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public void e(RecyclerView.e0 e0Var, int i) {
    }
}
