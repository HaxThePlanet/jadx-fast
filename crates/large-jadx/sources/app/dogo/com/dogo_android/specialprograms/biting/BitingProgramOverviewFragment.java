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
import app.dogo.com.dogo_android.n.m.n.b;
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
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import m.a.b.a.d.a.b;

/* compiled from: BitingProgramOverviewFragment.kt */
@Metadata(d1 = "\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0008\u0010#\u001a\u0004\u0018\u00010$2\u0008\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)H\u0016J\u0008\u0010*\u001a\u00020\u0016H\u0016J\u0008\u0010+\u001a\u00020\u0016H\u0016J\u0010\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001a\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u00020 2\u0008\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u000204H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u000f\u001a\u0004\u0008\u0012\u0010\u0013¨\u00065", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/biting/BitingProgramOverviewFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/specialprograms/biting/BitingOverviewCallbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentBitingProgramOverviewBinding;", "screenKey", "Lapp/dogo/com/dogo_android/specialprograms/biting/BitingProgramOverviewScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/specialprograms/biting/BitingProgramOverviewScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/specialprograms/biting/BitingProgramOverviewViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/specialprograms/biting/BitingProgramOverviewViewModel;", "viewModel$delegate", "onArticleSelected", "", "article", "Lapp/dogo/com/dogo_android/repository/domain/ArticleWithStatus;", "onAttach", "context", "Landroid/content/Context;", "onCoreTrickSelected", "item", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onHelpCardSelected", "isUserPremium", "", "onLockedTrickSelected", "onResume", "onReviewCertificateSelected", "certificateData", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateData;", "onVariationTrickSelected", "onViewCreated", "view", "programDescriptionClicked", "description", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: m, reason: from kotlin metadata */
public final class BitingProgramOverviewFragment extends Fragment implements l {

    /* renamed from: a, reason: from kotlin metadata */
    private y9 binding;
    private final kotlin.h b;
    private final kotlin.h c;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends kotlin.d0.d.p implements kotlin.d0.c.a<app.dogo.com.dogo_android.view.dailytraining.l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final app.dogo.com.dogo_android.view.dailytraining.l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(SessionViewModel.class), this.$parameters);
        }

        public a(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends kotlin.d0.d.p implements kotlin.d0.c.a<p> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final p invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(BitingProgramOverviewViewModel.class), this.$parameters);
        }

        public b(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }
    public m() {
        super();
        final m.a.c.j.a aVar2 = null;
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.specialprograms.biting.m.b(this, aVar2, aVar2));
        this.c = j.a(LazyThreadSafetyMode.NONE, new app.dogo.com.dogo_android.specialprograms.biting.m.a(this, aVar2, aVar2));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    private final o onLockedTrickSelected() {
        return (BitingProgramOverviewScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final p C1() {
        return (BitingProgramOverviewViewModel)this.b.getValue();
    }

    private static final void J1(m mVar, View view) {
        n.f(mVar, "this$0");
        final androidx.fragment.app.e activity = mVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void K1(m mVar, View view) {
        n.f(mVar, "this$0");
        mVar.C1().enrollToProgramEnrollment();
    }

    private static final void L1(m mVar, View view) {
        n.f(mVar, "this$0");
        mVar.C1().z();
    }

    private static final void M1(m mVar, View view) {
        n.f(mVar, "this$0");
        mVar.C1().z();
    }

    private static final void N1(m mVar, View view, int i, int i2, int i3, int i4) {
        Object mVar2 = mVar;
        n.f(mVar, "this$0");
        i = 0;
        String str4 = "binding";
        if (mVar2.binding == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            n.e(binding2.V, "binding.programTitle");
            if (mVar2.binding == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                String str3 = "binding.topAppBar";
                n.e(binding22.b0, str3);
                if (mVar2.binding == null) {
                    n.w(str4);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    final String str7 = "binding.toolbarSpacer";
                    n.e(binding27.Z, str7);
                    if (mVar2.binding == null) {
                        n.w(str4);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        n.e(binding28.a0, "binding.toolbarTitle");
                        app.dogo.com.dogo_android.specialprograms.biting.n.setupSpecialProgramOverviewTitleScrollAnimation(binding2.V, binding22.b0, binding27.Z, binding28.a0, i2, i4);
                        if (mVar2.binding == null) {
                            n.w(str4);
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) i;
                        } else {
                            n.e(binding25.U, "binding.programIconBackground");
                            if (mVar2.binding == null) {
                                n.w(str4);
                                /* Dexterity WARN: Type inference failed for thrown value */
                                throw (Throwable) i;
                            } else {
                                n.e(binding26.b0, "binding.topAppBar");
                                if (mVar2.binding == null) {
                                    n.w(str4);
                                    /* Dexterity WARN: Type inference failed for thrown value */
                                    throw (Throwable) i;
                                } else {
                                    n.e(binding23.Z, "binding.toolbarSpacer");
                                    if (mVar2.binding == null) {
                                        n.w(str4);
                                        /* Dexterity WARN: Type inference failed for thrown value */
                                        throw (Throwable) i;
                                    } else {
                                        app.dogo.com.dogo_android.specialprograms.biting.n.b(mVar, frameLayout, materialToolbar, frameLayout3, binding24.e0, i2, i4);
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

    private static final void O1(m mVar, p.a aVar) {
        n.f(mVar, "this$0");
        if (aVar == BitingProgramOverviewViewModel_CertificateUnlockState.FRESH_UNLOCK) {
            int i = 0;
            str = "binding";
            if (mVar.binding == null) {
                n.w(str);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                n.e(binding23.R, "binding.orderedCards");
                if (mVar.binding == null) {
                    n.w(str);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    str2 = "binding.konfetti";
                    n.e(binding2.Q, str2);
                    if (mVar.binding == null) {
                        n.w(str);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        n.e(binding22.Y, "binding.scrollView");
                        app.dogo.com.dogo_android.util.extensionfunction.k1.h(binding23.R, binding2.Q, binding22.Y);
                    }
                }
            }
        }
    }

    private final app.dogo.com.dogo_android.view.dailytraining.l getSharedViewModel() {
        return (SessionViewModel)this.c.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: B, reason: from kotlin metadata */
    public void onArticleSelected(String article) {
        app.dogo.com.dogo_android.specialprograms.biting.l.a.e(this, article);
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: F0, reason: from kotlin metadata */
    public void onAttach(PottyProgramProgress context) {
        app.dogo.com.dogo_android.specialprograms.biting.l.a.h(this, context);
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: H, reason: from kotlin metadata */
    public void onCoreTrickSelected(SpecialProgramOverviewItem.CertificateData item) {
        n.f(item, "certificateData");
        i = !item.isCertificateUnlocked();
        C1().v(i);
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            str = "id_nipping_program";
            str2 = "biting_overview";
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new SpecialProgramCertificateScreen(item, str, str2, onLockedTrickSelected().getTag()));
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: N, reason: from kotlin metadata */
    public void onHelpCardSelected(TrickItem isUserPremium) {
        n.f(isUserPremium, "item");
        Object value = getSharedViewModel().E().getValue();
        if (value != null) {
            C1().w(isUserPremium.getId());
            z = value instanceof LoadResult_Success;
            if (value instanceof oadResult_Success) {
                String str5 = "";
                int i = 0;
                boolean z2 = false;
                boolean z3 = false;
                int i2 = 24;
                kotlin.d0.d.g gVar = null;
                TrickDetailsPlan_ProgramPlan isUserPremium2 = new TrickDetailsPlan_ProgramPlan(p.b(isUserPremium), new ProgramSaveInfo("id_nipping_program", str5, str5, (DogProfile)value.component1().getId()), i, z2, z3, i2, gVar);
                str2 = "biting_overview";
                app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new TrickDetailsScreen(isUserPremium2, onLockedTrickSelected().getTag(), onLockedTrickSelected().getTag(), str2));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: O, reason: from kotlin metadata */
    public void onReviewCertificateSelected(String certificateData) {
        app.dogo.com.dogo_android.specialprograms.biting.l.a.a(this, certificateData);
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void S0() {
        app.dogo.com.dogo_android.specialprograms.biting.l.a.d(this);
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void Y() {
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            int i = 2131886587;
            app.dogo.com.dogo_android.util.extensionfunction.g1.g0(activity, i);
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: Y0, reason: from kotlin metadata */
    public void onVariationTrickSelected(boolean item) {
        app.dogo.com.dogo_android.specialprograms.biting.l.a.b(this, item);
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: g1, reason: from kotlin metadata */
    public void programDescriptionClicked(String description) {
        n.f(description, "description");
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            str = "id_nipping_program";
            str2 = "biting_overview";
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new ProgramDescriptionScreen(description, str, str2));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void i1(ArticleWithStatus articleWithStatus) {
        n.f(articleWithStatus, "article");
        C1().u(articleWithStatus.getArticle().getArticleId());
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            boolean z = true;
            str = "biting_overview";
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new ArticleDetailsScreen(articleWithStatus.getArticle(), str, z));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void k1(PottyRemindersItem pottyRemindersItem, boolean z) {
        app.dogo.com.dogo_android.specialprograms.biting.l.a.f(this, pottyRemindersItem, z);
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
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
        y9 y9Var = y9.T(inflater, container, false);
        n.e(y9Var, "inflate(inflater, container, false)");
        this.binding = y9Var;
        int i = 0;
        String str5 = "binding";
        if (y9Var == null) {
            n.w(str5);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            y9Var.X(C1());
            if (this.binding == null) {
                n.w(str5);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.V(this);
                if (this.binding == null) {
                    n.w(str5);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    this.binding.W(Boolean.valueOf(getSharedViewModel().N()));
                    if (this.binding == null) {
                        n.w(str5);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        this.binding.M(getViewLifecycleOwner());
                        if (this.binding == null) {
                            n.w(str5);
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
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        C1().s();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) throws f {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        int i = 0;
        String str2 = "binding";
        if (this.binding == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            binding2.b0.setNavigationOnClickListener(new app.dogo.com.dogo_android.specialprograms.biting.d(this));
            if (this.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                binding22.O.setOnClickListener(new app.dogo.com.dogo_android.specialprograms.biting.c(this));
                if (this.binding == null) {
                    n.w(str2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    binding23.c0.setOnClickListener(new app.dogo.com.dogo_android.specialprograms.biting.b(this));
                    if (this.binding == null) {
                        n.w(str2);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        binding24.c0.setOnClickListener(new app.dogo.com.dogo_android.specialprograms.biting.a(this));
                        if (this.binding == null) {
                            n.w(str2);
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) i;
                        } else {
                            binding25.Y.setOnScrollChangeListener(new app.dogo.com.dogo_android.specialprograms.biting.f(this));
                            androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
                            n.e(viewLifecycleOwner, "viewLifecycleOwner");
                            C1().p().observe(viewLifecycleOwner, new app.dogo.com.dogo_android.specialprograms.biting.e(this));
                            getSharedViewModel().g0();
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void p0(TrickItem trickItem) {
        n.f(trickItem, "item");
        Object value = getSharedViewModel().E().getValue();
        if (value != null) {
            C1().y(trickItem.getId(), trickItem.getVariationId());
            z = value instanceof LoadResult_Success;
            if (value instanceof oadResult_Success) {
                String str4 = "";
                int i = 0;
                boolean z2 = false;
                boolean z3 = false;
                int i2 = 28;
                kotlin.d0.d.g gVar = null;
                TrickDetailsPlan_ProgramPlan trickDetailsPlan_ProgramPlan = new TrickDetailsPlan_ProgramPlan(p.b(trickItem), new ProgramSaveInfo("id_nipping_program", str4, str4, (DogProfile)value.component1().getId()), i, z2, z3, i2, gVar);
                variationId = "variation_training";
                app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new TrickBigTimerScreen(trickDetailsPlan_ProgramPlan, onLockedTrickSelected().getTag(), onLockedTrickSelected().getTag(), variationId));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void u1(String str) {
        app.dogo.com.dogo_android.specialprograms.biting.l.a.c(this, str);
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void w(boolean z) throws UnlockHelplineScreen {
        boolean z3;
        C1().x();
        if (C1().t(z)) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new UnlockHelplineScreen("biting_overview", onLockedTrickSelected().getTag()));
            return;
        } else {
            Object obj = null;
            if (this.binding != null) {
                this.binding.W(Boolean.FALSE);
                int i = 1;
                boolean z2 = false;
                z = C1().r() > 0 ? i : z2;
                SessionViewModel.c0(this.getSharedViewModel(), z2, (C1().r() > 0 ? i : z2), i, obj);
            }
        }
        n.w("binding");
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) obj;
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(PottyRemindersItem pottyRemindersItem) {
        app.dogo.com.dogo_android.specialprograms.biting.l.a.g(this, pottyRemindersItem);
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }


    /* renamed from: D1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(m view, View savedInstanceState) {
        BitingProgramOverviewFragment.M1(view, savedInstanceState);
    }

    public static /* synthetic */ void E1(m mVar, View view) {
        BitingProgramOverviewFragment.L1(mVar, view);
    }

    public static /* synthetic */ void F1(m mVar, View view) {
        BitingProgramOverviewFragment.K1(mVar, view);
    }

    public static /* synthetic */ void G1(m mVar, View view) {
        BitingProgramOverviewFragment.J1(mVar, view);
    }

    public static /* synthetic */ void H1(m mVar, p.a aVar) {
        BitingProgramOverviewFragment.O1(mVar, aVar);
    }

    public static /* synthetic */ void I1(m mVar, View view, int i, int i2, int i3, int i4) {
        BitingProgramOverviewFragment.N1(mVar, view, i, i2, i3, i4);
    }
}
