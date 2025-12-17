package app.dogo.com.dogo_android.u.n;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.activity.ComponentActivity;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.af;
import app.dogo.com.dogo_android.n.k.l;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.repository.domain.ArticleWithStatus;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgress;
import app.dogo.com.dogo_android.repository.domain.PottyRemindersItem;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.u.m.n;
import app.dogo.com.dogo_android.u.m.y.f;
import app.dogo.com.dogo_android.u.n.p.i;
import app.dogo.com.dogo_android.u.n.p.l.h;
import app.dogo.com.dogo_android.u.n.q.k;
import app.dogo.com.dogo_android.u.n.r.g;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
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
import m.a.b.a.d.a.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0008\u0010\"\u001a\u0004\u0018\u00010#2\u0008\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0008\u0010&\u001a\u00020\u0011H\u0016J\u0010\u0010'\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001cH\u0016J\u0010\u0010,\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*H\u0016J\u0008\u0010-\u001a\u00020\u0011H\u0016J\u0010\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020\u00112\u0006\u00102\u001a\u000203H\u0016J\u001a\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u001f2\u0008\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u00067", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/PottyProgramOverviewFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/specialprograms/potty/PottyOverviewCallbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentPottyProgramOverviewBinding;", "screenKey", "Lapp/dogo/com/dogo_android/specialprograms/potty/PottyProgramOverviewScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/specialprograms/potty/PottyProgramOverviewScreen;", "viewModel", "Lapp/dogo/com/dogo_android/specialprograms/potty/PottyProgramOverviewViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/specialprograms/potty/PottyProgramOverviewViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onArticleSelected", "", "article", "Lapp/dogo/com/dogo_android/repository/domain/ArticleWithStatus;", "onAttach", "context", "Landroid/content/Context;", "onCalendarSelected", "action", "", "onCheckmarkButtonSelected", "checkmarked", "", "onCheckmarkCardSelected", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onNewReminderSelection", "onReadHowSelected", "onReminderEnableToggle", "item", "Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "newState", "onReminderSelected", "onResume", "onReviewCertificateSelected", "certificateData", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateData;", "onScheduleSelected", "pottyProgress", "Lapp/dogo/com/dogo_android/repository/domain/PottyProgramProgress;", "onTrackerSelected", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class l extends Fragment implements app.dogo.com.dogo_android.u.n.k {

    private af a;
    private final h b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements a<app.dogo.com.dogo_android.u.n.n> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public a(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.u.n.n invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(n.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
    }

    public l() {
        super();
        final int i = 0;
        l.a aVar = new l.a(this, i, i);
        this.b = j.a(m.SYNCHRONIZED, aVar);
    }

    private final app.dogo.com.dogo_android.u.n.m B1() {
        return (m)k1.a(this);
    }

    private final app.dogo.com.dogo_android.u.n.n C1() {
        return (n)this.b.getValue();
    }

    public static void D1(app.dogo.com.dogo_android.u.n.l l, View view2) {
        l.J1(l, view2);
    }

    public static void E1(app.dogo.com.dogo_android.u.n.l l, Boolean boolean2) {
        l.M1(l, boolean2);
    }

    public static void F1(app.dogo.com.dogo_android.u.n.l l, View view2, int i3, int i4, int i5, int i6) {
        l.L1(l, view2, i3, i4, i5, i6);
    }

    public static void G1(app.dogo.com.dogo_android.u.n.l l, View view2) {
        l.K1(l, view2);
    }

    public static void H1(app.dogo.com.dogo_android.u.n.l l, View view2) {
        l.I1(l, view2);
    }

    private static final void I1(app.dogo.com.dogo_android.u.n.l l, View view2) {
        n.f(l, "this$0");
        final androidx.fragment.app.e obj0 = l.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void J1(app.dogo.com.dogo_android.u.n.l l, View view2) {
        n.f(l, "this$0");
        l.C1().q();
    }

    private static final void K1(app.dogo.com.dogo_android.u.n.l l, View view2) {
        n.f(l, "this$0");
        l.C1().C();
    }

    private static final void L1(app.dogo.com.dogo_android.u.n.l l, View view2, int i3, int i4, int i5, int i6) {
        Object obj = l;
        n.f(l, "this$0");
        af afVar = obj.a;
        int i = 0;
        String str4 = "binding";
        if (afVar == null) {
        } else {
            android.widget.TextView view = afVar.U;
            n.e(view, "binding.programTitle");
            af afVar2 = obj.a;
            if (afVar2 == null) {
            } else {
                com.google.android.material.appbar.MaterialToolbar materialToolbar2 = afVar2.Y;
                String str3 = "binding.topAppBar";
                n.e(materialToolbar2, str3);
                af afVar6 = obj.a;
                if (afVar6 == null) {
                } else {
                    FrameLayout frameLayout4 = afVar6.W;
                    final String str7 = "binding.toolbarSpacer";
                    n.e(frameLayout4, str7);
                    af afVar7 = obj.a;
                    if (afVar7 == null) {
                    } else {
                        android.widget.TextView view3 = afVar7.X;
                        n.e(view3, "binding.toolbarTitle");
                        n.a(view, materialToolbar2, frameLayout4, view3, i4, i6);
                        af afVar4 = obj.a;
                        if (afVar4 == null) {
                        } else {
                            FrameLayout frameLayout3 = afVar4.T;
                            n.e(frameLayout3, "binding.programIconBackground");
                            af afVar5 = obj.a;
                            if (afVar5 == null) {
                            } else {
                                com.google.android.material.appbar.MaterialToolbar materialToolbar3 = afVar5.Y;
                                n.e(materialToolbar3, str3);
                                af afVar3 = obj.a;
                                if (afVar3 == null) {
                                } else {
                                    FrameLayout frameLayout2 = afVar3.W;
                                    n.e(frameLayout2, str7);
                                    n.b(l, frameLayout3, materialToolbar3, frameLayout2, 0, i4, i6);
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

    private static final void M1(app.dogo.com.dogo_android.u.n.l l, Boolean boolean2) {
        String str2;
        String str3;
        nl.dionsegijn.konfetti.KonfettiView view;
        String str;
        Object obj4;
        boolean obj5;
        n.f(l, "this$0");
        n.e(boolean2, "isFirstTimeCertificateUnlocked");
        if (boolean2.booleanValue()) {
            l.C1().w();
            obj5 = l.a;
            int i = 0;
            str3 = "binding";
            if (obj5 == null) {
            } else {
                obj5 = obj5.R;
                n.e(obj5, "binding.orderedCards");
                af afVar = l.a;
                if (afVar == null) {
                } else {
                    view = afVar.Q;
                    n.e(view, "binding.konfetti");
                    obj4 = l.a;
                    if (obj4 == null) {
                    } else {
                        obj4 = obj4.V;
                        n.e(obj4, "binding.scrollView");
                        k1.h(obj5, view, obj4);
                    }
                    n.w(str3);
                    throw i;
                }
                n.w(str3);
                throw i;
            }
            n.w(str3);
            throw i;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void B(String string) {
        Object gVar;
        String tag;
        n.f(string, "action");
        C1().B(string);
        final androidx.fragment.app.e obj3 = getActivity();
        if (obj3 == null) {
        } else {
            gVar = new g(B1().getTag());
            g1.n(obj3, gVar);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void F0(PottyProgramProgress pottyProgramProgress) {
        Object iVar;
        String tag;
        String str;
        n.f(pottyProgramProgress, "pottyProgress");
        C1().y(pottyProgramProgress.getCleanDaysStreak());
        androidx.fragment.app.e obj4 = getActivity();
        if (obj4 == null) {
        } else {
            iVar = new i("potty_overview", B1().getTag());
            g1.n(obj4, iVar);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void H(SpecialProgramOverviewItem.CertificateData specialProgramOverviewItem$CertificateData) {
        n.f(certificateData, "certificateData");
        C1().z();
        f fVar = new f(certificateData, "id_potty_program", "potty_overview", B1().getTag());
        g1.n(getActivity(), fVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void N(TrickItem trickItem) {
        k.a.a(this, trickItem);
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void O(String string) {
        Object iVar;
        String tag;
        String str;
        n.f(string, "action");
        C1().B(string);
        final androidx.fragment.app.e obj4 = getActivity();
        if (obj4 == null) {
        } else {
            iVar = new i("potty_overview", B1().getTag());
            g1.n(obj4, iVar);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void S0() {
        k kVar;
        int i;
        int i2;
        C1().A();
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            i2 = 0;
            kVar = new k(i2, 1, i2);
            g1.n(activity, kVar);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void Y() {
        k.a.c(this);
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void Y0(boolean z) {
        Object iVar;
        int str;
        String str2;
        int i;
        int i3;
        int i4;
        int i2;
        int i5;
        h hVar;
        String obj10;
        obj10 = z ? "add_checkmarked" : "add_empty";
        C1().B(obj10);
        obj10 = getActivity();
        if (obj10 == null) {
        } else {
            i = 0;
            iVar = new i("potty_overview", i, 2, i);
            g1.n(obj10, iVar);
        }
        obj10 = getActivity();
        if (obj10 == null) {
        } else {
            super("potty_overview", 0, 0, 0, 0, 30, 0);
            g1.n(obj10, hVar);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void g1(String string) {
        k.a.e(this, string);
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void i1(ArticleWithStatus articleWithStatus) {
        Object articleId;
        int i;
        String str;
        Object obj5;
        n.f(articleWithStatus, "article");
        C1().x(articleWithStatus.getArticle().getArticleId());
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            articleId = new l(articleWithStatus.getArticle(), "potty_overview", 1);
            g1.n(activity, articleId);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void k1(PottyRemindersItem pottyRemindersItem, boolean z2) {
        n.f(pottyRemindersItem, "item");
        C1().D(pottyRemindersItem.getReminderId(), z2);
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
        af obj2 = af.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        String obj4 = "binding";
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

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        C1().u();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        af obj3 = this.a;
        int obj4 = 0;
        String str2 = "binding";
        if (obj3 == null) {
        } else {
            f fVar = new f(this);
            obj3.Y.setOnClickListener(fVar);
            obj3 = this.a;
            if (obj3 == null) {
            } else {
                b bVar = new b(this);
                obj3.O.setOnClickListener(bVar);
                obj3 = this.a;
                if (obj3 == null) {
                } else {
                    e eVar = new e(this);
                    obj3.Z.setOnClickListener(eVar);
                    obj3 = this.a;
                    if (obj3 == null) {
                    } else {
                        obj4 = new d(this);
                        obj3.V.setOnScrollChangeListener(obj4);
                        obj4 = getViewLifecycleOwner();
                        n.e(obj4, "viewLifecycleOwner");
                        c cVar = new c(this);
                        C1().r().observe(obj4, cVar);
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
        k.a.d(this, trickItem);
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void u1(String string) {
        Object iVar;
        int str;
        String str2;
        int i4;
        int i3;
        int i5;
        int i2;
        int i;
        h hVar;
        n.f(string, "action");
        C1().B(string);
        androidx.fragment.app.e obj10 = getActivity();
        if (obj10 == null) {
        } else {
            i4 = 0;
            iVar = new i("potty_overview", i4, 2, i4);
            g1.n(obj10, iVar);
        }
        obj10 = getActivity();
        if (obj10 == null) {
        } else {
            super("potty_overview", 0, 0, 0, 0, 30, 0);
            g1.n(obj10, hVar);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void w(boolean z) {
        k.a.b(this, z);
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(PottyRemindersItem pottyRemindersItem) {
        k kVar;
        n.f(pottyRemindersItem, "item");
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            kVar = new k(pottyRemindersItem);
            g1.n(activity, kVar);
        }
    }
}
