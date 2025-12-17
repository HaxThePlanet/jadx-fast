package app.dogo.com.dogo_android.u.m;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.y9;
import app.dogo.com.dogo_android.n.k.l;
import app.dogo.com.dogo_android.n.m.n.b;
import app.dogo.com.dogo_android.n.m.s.h;
import app.dogo.com.dogo_android.n.m.u.m;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.repository.domain.ArticleWithStatus;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgress;
import app.dogo.com.dogo_android.repository.domain.PottyRemindersItem;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.subscription.contactus.UnlockHelplineScreen;
import app.dogo.com.dogo_android.u.g;
import app.dogo.com.dogo_android.u.m.y.f;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.y.j;
import f.d.a.a;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.y.p;
import m.a.b.a.d.a.a;
import m.a.b.a.d.a.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0008\u0010#\u001a\u0004\u0018\u00010$2\u0008\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)H\u0016J\u0008\u0010*\u001a\u00020\u0016H\u0016J\u0008\u0010+\u001a\u00020\u0016H\u0016J\u0010\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001a\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u00020 2\u0008\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u000204H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u000f\u001a\u0004\u0008\u0012\u0010\u0013¨\u00065", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/biting/BitingProgramOverviewFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/specialprograms/biting/BitingOverviewCallbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentBitingProgramOverviewBinding;", "screenKey", "Lapp/dogo/com/dogo_android/specialprograms/biting/BitingProgramOverviewScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/specialprograms/biting/BitingProgramOverviewScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/specialprograms/biting/BitingProgramOverviewViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/specialprograms/biting/BitingProgramOverviewViewModel;", "viewModel$delegate", "onArticleSelected", "", "article", "Lapp/dogo/com/dogo_android/repository/domain/ArticleWithStatus;", "onAttach", "context", "Landroid/content/Context;", "onCoreTrickSelected", "item", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onHelpCardSelected", "isUserPremium", "", "onLockedTrickSelected", "onResume", "onReviewCertificateSelected", "certificateData", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateData;", "onVariationTrickSelected", "onViewCreated", "view", "programDescriptionClicked", "description", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class m extends Fragment implements app.dogo.com.dogo_android.u.m.l {

    private y9 a;
    private final h b;
    private final h c;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements a<l> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public a(Fragment fragment, a a2, a a3) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(l.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements a<app.dogo.com.dogo_android.u.m.p> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public b(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.u.m.p invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(p.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
    }

    public m() {
        super();
        final int i = 0;
        m.b bVar = new m.b(this, i, i);
        this.b = j.a(m.SYNCHRONIZED, bVar);
        m.a aVar = new m.a(this, i, i);
        this.c = j.a(m.NONE, aVar);
    }

    private final app.dogo.com.dogo_android.u.m.o B1() {
        return (o)k1.a(this);
    }

    private final app.dogo.com.dogo_android.u.m.p C1() {
        return (p)this.b.getValue();
    }

    public static void D1(app.dogo.com.dogo_android.u.m.m m, View view2) {
        m.M1(m, view2);
    }

    public static void E1(app.dogo.com.dogo_android.u.m.m m, View view2) {
        m.L1(m, view2);
    }

    public static void F1(app.dogo.com.dogo_android.u.m.m m, View view2) {
        m.K1(m, view2);
    }

    public static void G1(app.dogo.com.dogo_android.u.m.m m, View view2) {
        m.J1(m, view2);
    }

    public static void H1(app.dogo.com.dogo_android.u.m.m m, app.dogo.com.dogo_android.u.m.p.a p$a2) {
        m.O1(m, a2);
    }

    public static void I1(app.dogo.com.dogo_android.u.m.m m, View view2, int i3, int i4, int i5, int i6) {
        m.N1(m, view2, i3, i4, i5, i6);
    }

    private static final void J1(app.dogo.com.dogo_android.u.m.m m, View view2) {
        n.f(m, "this$0");
        final androidx.fragment.app.e obj0 = m.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void K1(app.dogo.com.dogo_android.u.m.m m, View view2) {
        n.f(m, "this$0");
        m.C1().o();
    }

    private static final void L1(app.dogo.com.dogo_android.u.m.m m, View view2) {
        n.f(m, "this$0");
        m.C1().z();
    }

    private static final void M1(app.dogo.com.dogo_android.u.m.m m, View view2) {
        n.f(m, "this$0");
        m.C1().z();
    }

    private static final void N1(app.dogo.com.dogo_android.u.m.m m, View view2, int i3, int i4, int i5, int i6) {
        Object obj = m;
        n.f(m, "this$0");
        y9 y9Var = obj.a;
        int i = 0;
        String str4 = "binding";
        if (y9Var == null) {
        } else {
            android.widget.TextView view = y9Var.V;
            n.e(view, "binding.programTitle");
            y9 y9Var2 = obj.a;
            if (y9Var2 == null) {
            } else {
                com.google.android.material.appbar.MaterialToolbar materialToolbar2 = y9Var2.b0;
                String str3 = "binding.topAppBar";
                n.e(materialToolbar2, str3);
                y9 y9Var7 = obj.a;
                if (y9Var7 == null) {
                } else {
                    FrameLayout frameLayout4 = y9Var7.Z;
                    final String str7 = "binding.toolbarSpacer";
                    n.e(frameLayout4, str7);
                    y9 y9Var8 = obj.a;
                    if (y9Var8 == null) {
                    } else {
                        android.widget.TextView view4 = y9Var8.a0;
                        n.e(view4, "binding.toolbarTitle");
                        n.a(view, materialToolbar2, frameLayout4, view4, i4, i6);
                        y9 y9Var5 = obj.a;
                        if (y9Var5 == null) {
                        } else {
                            FrameLayout frameLayout3 = y9Var5.U;
                            n.e(frameLayout3, "binding.programIconBackground");
                            y9 y9Var6 = obj.a;
                            if (y9Var6 == null) {
                            } else {
                                com.google.android.material.appbar.MaterialToolbar materialToolbar3 = y9Var6.b0;
                                n.e(materialToolbar3, str3);
                                y9 y9Var3 = obj.a;
                                if (y9Var3 == null) {
                                } else {
                                    FrameLayout frameLayout5 = y9Var3.Z;
                                    n.e(frameLayout5, str7);
                                    y9 y9Var4 = obj.a;
                                    if (y9Var4 == null) {
                                    } else {
                                        n.b(m, frameLayout3, materialToolbar3, frameLayout5, y9Var4.e0, i4, i6);
                                    }
                                    n.w(str4);
                                    throw i;
                                }
                                n.w(str4);
                                throw i;
                            }
                            n.w(str4);
                            throw i;
                        }
                        n.w(str4);
                        throw i;
                    }
                    n.w(str4);
                    throw i;
                }
                n.w(str4);
                throw i;
            }
            n.w(str4);
            throw i;
        }
        n.w(str4);
        throw i;
    }

    private static final void O1(app.dogo.com.dogo_android.u.m.m m, app.dogo.com.dogo_android.u.m.p.a p$a2) {
        Object fRESH_UNLOCK;
        String str2;
        nl.dionsegijn.konfetti.KonfettiView view;
        String str;
        Object obj4;
        Object obj5;
        n.f(m, "this$0");
        if (a2 == p.a.FRESH_UNLOCK) {
            obj5 = m.a;
            int i = 0;
            str2 = "binding";
            if (obj5 == null) {
            } else {
                obj5 = obj5.R;
                n.e(obj5, "binding.orderedCards");
                y9 y9Var = m.a;
                if (y9Var == null) {
                } else {
                    view = y9Var.Q;
                    n.e(view, "binding.konfetti");
                    obj4 = m.a;
                    if (obj4 == null) {
                    } else {
                        obj4 = obj4.Y;
                        n.e(obj4, "binding.scrollView");
                        k1.h(obj5, view, obj4);
                    }
                    n.w(str2);
                    throw i;
                }
                n.w(str2);
                throw i;
            }
            n.w(str2);
            throw i;
        }
    }

    private final l getSharedViewModel() {
        return (l)this.c.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void B(String string) {
        l.a.e(this, string);
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void F0(PottyProgramProgress pottyProgramProgress) {
        l.a.h(this, pottyProgramProgress);
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void H(SpecialProgramOverviewItem.CertificateData specialProgramOverviewItem$CertificateData) {
        int fVar;
        String tag;
        String str2;
        String str;
        n.f(certificateData, "certificateData");
        C1().v(certificateUnlocked ^= 1);
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            fVar = new f(certificateData, "id_nipping_program", "biting_overview", B1().getTag());
            g1.n(activity, fVar);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void N(TrickItem trickItem) {
        Object value;
        boolean activity;
        Object mVar;
        String tag;
        String str;
        ProgramSaveInfo programSaveInfo;
        int i5;
        int i2;
        int i3;
        int i4;
        int i;
        Object obj12;
        n.f(trickItem, "item");
        value = getSharedViewModel().E().getValue();
        if ((y)value == null) {
        } else {
            C1().w(trickItem.getId());
            if (value instanceof y.c) {
                String str4 = "";
                programSaveInfo = new ProgramSaveInfo("id_nipping_program", str4, str4, (DogProfile)(y.c)(y)value.a().getId());
                super(p.b(trickItem), programSaveInfo, 0, 0, 0, 24, 0);
                mVar = new m(obj12, B1().getTag(), B1().getTag(), "biting_overview");
                g1.n(getActivity(), mVar);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void O(String string) {
        l.a.a(this, string);
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void S0() {
        l.a.d(this);
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void Y() {
        int i;
        final androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            g1.g0(activity, 2131886587);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void Y0(boolean z) {
        l.a.b(this, z);
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void g1(String string) {
        g gVar;
        String str;
        String str2;
        n.f(string, "description");
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            gVar = new g(string, "id_nipping_program", "biting_overview");
            g1.n(activity, gVar);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void i1(ArticleWithStatus articleWithStatus) {
        Object articleId;
        int i;
        String str;
        Object obj5;
        n.f(articleWithStatus, "article");
        C1().u(articleWithStatus.getArticle().getArticleId());
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            articleId = new l(articleWithStatus.getArticle(), "biting_overview", 1);
            g1.n(activity, articleId);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void k1(PottyRemindersItem pottyRemindersItem, boolean z2) {
        l.a.f(this, pottyRemindersItem, z2);
        throw 0;
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
        y9 obj2 = y9.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.X(C1());
            obj2 = this.a;
            if (obj2 == null) {
            } else {
                obj2.V(this);
                obj2 = this.a;
                if (obj2 == null) {
                } else {
                    obj2.W(Boolean.valueOf(getSharedViewModel().N()));
                    obj2 = this.a;
                    if (obj2 == null) {
                    } else {
                        obj2.M(getViewLifecycleOwner());
                        obj2 = this.a;
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
        n.w(obj4);
        throw obj3;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        C1().s();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        y9 obj3 = this.a;
        int obj4 = 0;
        String str2 = "binding";
        if (obj3 == null) {
        } else {
            d dVar = new d(this);
            obj3.b0.setNavigationOnClickListener(dVar);
            obj3 = this.a;
            if (obj3 == null) {
            } else {
                c cVar = new c(this);
                obj3.O.setOnClickListener(cVar);
                obj3 = this.a;
                if (obj3 == null) {
                } else {
                    b bVar = new b(this);
                    obj3.c0.setOnClickListener(bVar);
                    obj3 = this.a;
                    if (obj3 == null) {
                    } else {
                        a aVar = new a(this);
                        obj3.c0.setOnClickListener(aVar);
                        obj3 = this.a;
                        if (obj3 == null) {
                        } else {
                            obj4 = new f(this);
                            obj3.Y.setOnScrollChangeListener(obj4);
                            obj4 = getViewLifecycleOwner();
                            n.e(obj4, "viewLifecycleOwner");
                            e eVar = new e(this);
                            C1().p().observe(obj4, eVar);
                            getSharedViewModel().g0();
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
            n.w(str2);
            throw obj4;
        }
        n.w(str2);
        throw obj4;
    }

    @Override // androidx.fragment.app.Fragment
    public void p0(TrickItem trickItem) {
        Object value;
        boolean activity;
        Object hVar;
        String variationId;
        java.util.List list;
        ProgramSaveInfo programSaveInfo;
        int i;
        int i4;
        int i5;
        int i2;
        int i3;
        n.b bVar;
        Object obj13;
        n.f(trickItem, "item");
        value = getSharedViewModel().E().getValue();
        if ((y)value == null) {
        } else {
            C1().y(trickItem.getId(), trickItem.getVariationId());
            if (value instanceof y.c) {
                String str3 = "";
                programSaveInfo = new ProgramSaveInfo("id_nipping_program", str3, str3, (DogProfile)(y.c)(y)value.a().getId());
                super(p.b(trickItem), programSaveInfo, 0, 0, 0, 28, 0);
                hVar = new h(bVar, B1().getTag(), B1().getTag(), "variation_training");
                g1.n(getActivity(), hVar);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void u1(String string) {
        l.a.c(this, string);
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void w(boolean z) {
        int unlockHelplineScreen;
        int tag;
        int str;
        l sharedViewModel;
        int obj5;
        C1().x();
        if (C1().t(z)) {
            unlockHelplineScreen = new UnlockHelplineScreen("biting_overview", B1().getTag());
            g1.n(getActivity(), unlockHelplineScreen);
        } else {
            obj5 = this.a;
            unlockHelplineScreen = 0;
            if (obj5 == null) {
            } else {
                obj5.W(Boolean.FALSE);
                tag = 1;
                str = 0;
                obj5 = C1().r() > 0 ? tag : str;
                l.c0(getSharedViewModel(), str, obj5, tag, unlockHelplineScreen);
            }
        }
        n.w("binding");
        throw unlockHelplineScreen;
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(PottyRemindersItem pottyRemindersItem) {
        l.a.g(this, pottyRemindersItem);
        throw 0;
    }
}
