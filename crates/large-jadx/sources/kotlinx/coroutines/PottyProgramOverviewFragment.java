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
import app.dogo.com.dogo_android.u.m.y.f;
import app.dogo.com.dogo_android.u.n.p.i;
import app.dogo.com.dogo_android.u.n.q.k;
import app.dogo.com.dogo_android.u.n.r.g;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.p;
import kotlin.m;
import m.a.b.a.d.a.b;

/* compiled from: PottyProgramOverviewFragment.kt */
@Metadata(d1 = "\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0008\u0010\"\u001a\u0004\u0018\u00010#2\u0008\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0008\u0010&\u001a\u00020\u0011H\u0016J\u0010\u0010'\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001cH\u0016J\u0010\u0010,\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*H\u0016J\u0008\u0010-\u001a\u00020\u0011H\u0016J\u0010\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020\u00112\u0006\u00102\u001a\u000203H\u0016J\u001a\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u001f2\u0008\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u00067", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/PottyProgramOverviewFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/specialprograms/potty/PottyOverviewCallbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentPottyProgramOverviewBinding;", "screenKey", "Lapp/dogo/com/dogo_android/specialprograms/potty/PottyProgramOverviewScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/specialprograms/potty/PottyProgramOverviewScreen;", "viewModel", "Lapp/dogo/com/dogo_android/specialprograms/potty/PottyProgramOverviewViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/specialprograms/potty/PottyProgramOverviewViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onArticleSelected", "", "article", "Lapp/dogo/com/dogo_android/repository/domain/ArticleWithStatus;", "onAttach", "context", "Landroid/content/Context;", "onCalendarSelected", "action", "", "onCheckmarkButtonSelected", "checkmarked", "", "onCheckmarkCardSelected", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onNewReminderSelection", "onReadHowSelected", "onReminderEnableToggle", "item", "Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "newState", "onReminderSelected", "onResume", "onReviewCertificateSelected", "certificateData", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateData;", "onScheduleSelected", "pottyProgress", "Lapp/dogo/com/dogo_android/repository/domain/PottyProgramProgress;", "onTrackerSelected", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: l, reason: from kotlin metadata */
public final class PottyProgramOverviewFragment extends Fragment implements k {

    /* renamed from: a, reason: from kotlin metadata */
    private af binding;
    private final kotlin.h b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements kotlin.d0.c.a<n> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final n invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(PottyProgramOverviewViewModel.class), this.$parameters);
        }

        public a(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }
    public l() {
        super();
        final m.a.c.j.a aVar2 = null;
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new kotlinx.coroutines.l.a(this, aVar2, aVar2));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    private final m onNewReminderSelection() {
        return (PottyProgramOverviewScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final n C1() {
        return (PottyProgramOverviewViewModel)this.b.getValue();
    }

    private static final void I1(l lVar, View view) {
        n.f(lVar, "this$0");
        final androidx.fragment.app.e activity = lVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void J1(l lVar, View view) {
        n.f(lVar, "this$0");
        lVar.C1().q();
    }

    private static final void K1(l lVar, View view) {
        n.f(lVar, "this$0");
        lVar.C1().C();
    }

    private static final void L1(l lVar, View view, int i, int i2, int i3, int i4) {
        Object lVar2 = lVar;
        n.f(lVar, "this$0");
        i = 0;
        String str4 = "binding";
        if (lVar2.binding == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            n.e(binding2.U, "binding.programTitle");
            if (lVar2.binding == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                String str3 = "binding.topAppBar";
                n.e(binding22.Y, str3);
                if (lVar2.binding == null) {
                    n.w(str4);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    final String str7 = "binding.toolbarSpacer";
                    n.e(binding26.W, str7);
                    if (lVar2.binding == null) {
                        n.w(str4);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        n.e(binding27.X, "binding.toolbarTitle");
                        app.dogo.com.dogo_android.specialprograms.biting.n.setupSpecialProgramOverviewTitleScrollAnimation(binding2.U, binding22.Y, binding26.W, binding27.X, i2, i4);
                        if (lVar2.binding == null) {
                            n.w(str4);
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) i;
                        } else {
                            n.e(binding24.T, "binding.programIconBackground");
                            if (lVar2.binding == null) {
                                n.w(str4);
                                /* Dexterity WARN: Type inference failed for thrown value */
                                throw (Throwable) i;
                            } else {
                                n.e(binding25.Y, "binding.topAppBar");
                                if (lVar2.binding == null) {
                                    n.w(str4);
                                    /* Dexterity WARN: Type inference failed for thrown value */
                                    throw (Throwable) i;
                                } else {
                                    n.e(binding23.W, "binding.toolbarSpacer");
                                    app.dogo.com.dogo_android.specialprograms.biting.n.b(lVar, frameLayout2, materialToolbar, binding23.W, null, i2, i4);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static final void M1(l lVar, Boolean boolean) {
        n.f(lVar, "this$0");
        str = "isFirstTimeCertificateUnlocked";
        n.e(boolean, str);
        if (boolean.booleanValue()) {
            lVar.C1().w();
            int i = 0;
            str2 = "binding";
            if (lVar.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                n.e(binding23.R, "binding.orderedCards");
                if (lVar.binding == null) {
                    n.w(str2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    str3 = "binding.konfetti";
                    n.e(binding2.Q, str3);
                    if (lVar.binding == null) {
                        n.w(str2);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        str = "binding.scrollView";
                        n.e(binding22.V, str);
                        app.dogo.com.dogo_android.util.extensionfunction.k1.h(binding23.R, binding2.Q, binding22.V);
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: B, reason: from kotlin metadata */
    public void onArticleSelected(String article) {
        n.f(article, "action");
        C1().B(article);
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new PottyTrackerOverviewScreen(onNewReminderSelection().getTag()));
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: F0, reason: from kotlin metadata */
    public void onAttach(PottyProgramProgress context) {
        n.f(context, "pottyProgress");
        C1().y(context.getCleanDaysStreak());
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            str = "potty_overview";
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new DogLogCalendarScreen(str, onNewReminderSelection().getTag()));
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: H, reason: from kotlin metadata */
    public void onCalendarSelected(SpecialProgramOverviewItem.CertificateData action) {
        n.f(action, "certificateData");
        C1().z();
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new SpecialProgramCertificateScreen(action, "id_potty_program", "potty_overview", onNewReminderSelection().getTag()));
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: N, reason: from kotlin metadata */
    public void onCheckmarkButtonSelected(TrickItem checkmarked) {
        kotlinx.coroutines.k.a.a(this, checkmarked);
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: O, reason: from kotlin metadata */
    public void onCheckmarkCardSelected(String action) {
        n.f(action, "action");
        C1().B(action);
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            str = "potty_overview";
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new DogLogCalendarScreen(str, onNewReminderSelection().getTag()));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void S0() {
        C1().enrollToProgramEnrollment();
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            int i = 1;
            PottyRemindersItem pottyRemindersItem = null;
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new PottyProgramReminderScreen(pottyRemindersItem, i, pottyRemindersItem));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void Y() {
        kotlinx.coroutines.k.a.c(this);
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: Y0, reason: from kotlin metadata */
    public void onReadHowSelected(boolean action) {
        i dogLogCalendarScreen;
        int i = 2;
        String str;
        String str2 = null;
        String str5;
        action = action ? "add_checkmarked" : "add_empty";
        this.C1().B((action ? "add_checkmarked" : "add_empty"));
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            i = 2;
            str = "potty_overview";
            str2 = null;
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new DogLogCalendarScreen(str, str2, i, str2));
        }
        androidx.fragment.app.e activity2 = getActivity();
        if (activity2 != null) {
            String str3 = null;
            String str4 = null;
            int i2 = 30;
            kotlin.d0.d.g gVar = null;
            DogLogEditScreen dogLogEditScreen = new DogLogEditScreen("potty_overview", null, null, str3, str4, i2, gVar);
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity2, dogLogEditScreen);
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: g1, reason: from kotlin metadata */
    public void onReminderSelected(String item) {
        kotlinx.coroutines.k.a.e(this, item);
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: i1, reason: from kotlin metadata */
    public void onReviewCertificateSelected(ArticleWithStatus certificateData) {
        n.f(certificateData, "article");
        C1().x(certificateData.getArticle().getArticleId());
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            boolean z = true;
            str = "potty_overview";
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new ArticleDetailsScreen(certificateData.getArticle(), str, z));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void k1(PottyRemindersItem pottyRemindersItem, boolean z) {
        n.f(pottyRemindersItem, "item");
        C1().D(pottyRemindersItem.getReminderId(), z);
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
        af afVar = af.T(inflater, container, false);
        n.e(afVar, "inflate(inflater, container, false)");
        this.binding = afVar;
        int i = 0;
        String str4 = "binding";
        if (afVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            afVar.W(C1());
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
                        View view = this.binding.w();
                        n.e(view, "binding.root");
                        return view;
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        C1().u();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) throws d {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        int i = 0;
        String str2 = "binding";
        if (this.binding == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            binding2.Y.setOnClickListener(new kotlinx.coroutines.f(this));
            if (this.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                binding22.O.setOnClickListener(new kotlinx.coroutines.b(this));
                if (this.binding == null) {
                    n.w(str2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    binding23.Z.setOnClickListener(new kotlinx.coroutines.e(this));
                    if (this.binding == null) {
                        n.w(str2);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        binding24.V.setOnScrollChangeListener(new kotlinx.coroutines.d(this));
                        androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
                        n.e(viewLifecycleOwner, "viewLifecycleOwner");
                        C1().r().observe(viewLifecycleOwner, new kotlinx.coroutines.c(this));
                        return;
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: p0, reason: from kotlin metadata */
    public void onScheduleSelected(TrickItem pottyProgress) {
        kotlinx.coroutines.k.a.d(this, pottyProgress);
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: u1, reason: from kotlin metadata */
    public void onTrackerSelected(String pottyProgress) {
        app.dogo.com.dogo_android.u.n.n nVar;
        int i = 2;
        String str2;
        String str3 = null;
        n.f(pottyProgress, "action");
        C1().B(pottyProgress);
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            i = 2;
            str2 = "potty_overview";
            str3 = null;
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new DogLogCalendarScreen(str2, str3, i, str3));
        }
        androidx.fragment.app.e activity2 = getActivity();
        if (activity2 != null) {
            Long l = null;
            app.dogo.com.dogo_android.k.e eVar = null;
            String str4 = null;
            String str5 = null;
            int i2 = 30;
            kotlin.d0.d.g gVar = null;
            str = "potty_overview";
            DogLogEditScreen dogLogEditScreen = new DogLogEditScreen(str, l, eVar, str4, str5, i2, gVar);
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity2, dogLogEditScreen);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void w(boolean z) {
        kotlinx.coroutines.k.a.b(this, z);
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(PottyRemindersItem pottyRemindersItem) {
        n.f(pottyRemindersItem, "item");
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new PottyProgramReminderScreen(pottyRemindersItem));
        }
    }


    /* renamed from: D1, reason: from kotlin metadata */
    public static /* synthetic */ void onReminderEnableToggle(l item, View newState) {
        PottyProgramOverviewFragment.J1(item, newState);
    }

    /* renamed from: E1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(l view, Boolean savedInstanceState) {
        PottyProgramOverviewFragment.M1(view, savedInstanceState);
    }

    public static /* synthetic */ void F1(l lVar, View view, int i, int i2, int i3, int i4) {
        PottyProgramOverviewFragment.L1(lVar, view, i, i2, i3, i4);
    }

    public static /* synthetic */ void G1(l lVar, View view) {
        PottyProgramOverviewFragment.K1(lVar, view);
    }

    public static /* synthetic */ void H1(l lVar, View view) {
        PottyProgramOverviewFragment.I1(lVar, view);
    }
}
