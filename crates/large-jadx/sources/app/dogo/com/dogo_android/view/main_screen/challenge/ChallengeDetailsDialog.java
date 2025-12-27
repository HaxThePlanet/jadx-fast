package app.dogo.com.dogo_android.view.main_screen.j;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.a0.g.f.d0;
import app.dogo.com.dogo_android.h.g8;
import app.dogo.com.dogo_android.h.o0;
import app.dogo.com.dogo_android.h.um;
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.u;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.w.c1;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import app.dogo.com.dogo_android.w.l3;
import app.dogo.com.dogo_android.w.o3;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import m.a.b.a.d.a.b;

/* compiled from: ChallengeDetailsDialog.kt */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0018\u001a\u00020\u000fH\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0008\u0010!\u001a\u0004\u0018\u00010\"2\u0008\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0008\u0010%\u001a\u00020\u001aH\u0002J\u0008\u0010&\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u001e\u0010\r\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u000f0\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0016\u0010\u0017\u001a\u0004\u0008\u0014\u0010\u0015¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/view/main_screen/challenge/ChallengeDetailsDialog;", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyBaseDialogFragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogChallengeDetailsBinding;", "fragmentTag", "Lapp/dogo/com/dogo_android/enums/DialogTags;", "getFragmentTag", "()Lapp/dogo/com/dogo_android/enums/DialogTags;", "screenViewDescriptor", "Lapp/dogo/com/dogo_android/tracking/Screen;", "getScreenViewDescriptor", "()Lapp/dogo/com/dogo_android/tracking/Screen;", "viewModelClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "getViewModelClass", "()Ljava/lang/Class;", "viewModelDi", "Lapp/dogo/com/dogo_android/viewmodel/main_screen/challenge/ChallengeDetailsViewModel;", "getViewModelDi", "()Lapp/dogo/com/dogo_android/viewmodel/main_screen/challenge/ChallengeDetailsViewModel;", "viewModelDi$delegate", "Lkotlin/Lazy;", "getBaseViewModel", "onCancel", "", "dialog", "Landroid/content/DialogInterface;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setupFabHideTrigger", "setupScrollTrigger", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h0, reason: from kotlin metadata */
public final class ChallengeDetailsDialog extends u {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final h0.a INSTANCE = new h0$a(0);
    /* renamed from: w, reason: from kotlin metadata */
    private g8 binding;
    private final h x;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/view/main_screen/challenge/ChallengeDetailsDialog$Companion;", "", "()V", "SCROLL_TO_BOTTOM", "", "SCROLL_TO_PRIZE", "SCROLL_TO_RULES", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements kotlin.d0.c.a<d0> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final d0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(ChallengeDetailsViewModel.class), this.$parameters);
        }

        public b(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    public h0() {
        super();
        final m.a.c.j.a aVar = null;
        this.x = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.view.main_screen.challenge.h0.b(this, aVar, aVar));
    }

    /* renamed from: X1, reason: from kotlin metadata */
    private final d0 getBaseViewModel() {
        return (ChallengeDetailsViewModel)this.x.getValue();
    }

    private static final void f2(h0 h0Var, View view) {
        n.f(h0Var, "this$0");
        h0Var.getBaseViewModel().a0();
        final a0 a0Var = h0Var.G1();
        n.d(a0Var);
        a0Var.r(DialogTags.CHALLENGE_DETAILS_DIALOG);
    }

    private static final void g2(h0 h0Var) {
        n.f(h0Var, "this$0");
        h0Var.getBaseViewModel().z(h0Var.getArguments());
    }

    private static final void h2(h0 h0Var, y yVar) {
        n.f(h0Var, "this$0");
        z = yVar instanceof LoadResult_Success;
    }

    private final void i2() {
        getBaseViewModel().G().observe(this, new app.dogo.com.dogo_android.view.main_screen.challenge.d(this));
    }

    private static final void j2(h0 h0Var, Boolean boolean) {
        int i = 1;
        boolean booleanValue;
        app.dogo.com.dogo_android.view.main_screen.j.e eVar;
        str = "this$0";
        n.f(h0Var, str);
        if (boolean != null) {
            int i2 = 0;
            str2 = "binding";
            if (h0Var.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i2;
            } else {
                int r0 = binding2.R.getVisibility() == 0 ? 1 : 0;
                long l = 200L;
                if (boolean.booleanValue() && binding2.R == 0 && h0Var.getBaseViewModel().Q()) {
                    h0Var.getBaseViewModel().e0();
                    if (h0Var.binding == null) {
                        n.w(str2);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i2;
                    } else {
                        float f2 = 1f;
                        binding22.R.animate().setDuration(l).scaleX(f2).scaleY(f2).withStartAction(new app.dogo.com.dogo_android.view.main_screen.challenge.e(h0Var)).start();
                    }
                }
                if (!boolean.booleanValue() && h0Var.binding != 0 && h0Var.binding != null) {
                    float f = 0.0f;
                    binding23.R.animate().setDuration(l).scaleX(f).scaleY(f).withEndAction(new app.dogo.com.dogo_android.view.main_screen.challenge.g(h0Var)).start();
                }
            }
        }
    }

    private static final void k2(h0 h0Var) {
        n.f(h0Var, "this$0");
        if (h0Var.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            binding2.R.setVisibility(0);
            return;
        }
    }

    private static final void l2(h0 h0Var) {
        n.f(h0Var, "this$0");
        if (h0Var.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            binding2.R.setVisibility(8);
            return;
        }
    }

    private final void m2() {
        getBaseViewModel().N().observe(this, new app.dogo.com.dogo_android.view.main_screen.challenge.b(this));
    }

    private static final void n2(h0 h0Var, Integer integer) throws android.content.res.Resources.NotFoundException {
        int value2;
        n.f(h0Var, "this$0");
        int i3 = 0;
        final String str2 = "binding";
        if (integer != null) {
            if (integer.intValue() == 0 && h0Var.binding != null) {
                binding24.W.fullScroll(130);
                if (h0Var.binding == null) {
                    n.w(str2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i3;
                } else {
                    binding25.Q.clearAnimation();
                    if (h0Var.binding == null) {
                        n.w(str2);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i3;
                    } else {
                        int i = 2130772025;
                        if (h0Var.binding == null) {
                            n.w(str2);
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) i3;
                        } else {
                            binding23.Q.startAnimation(AnimationUtils.loadAnimation(binding26.Q.getContext(), i));
                            return;
                        }
                    }
                }
            }
        }
        i = 1;
        int i2 = 0;
        if (h0Var.binding != null) {
            if (integer.intValue() == 1 && h0Var.binding != null) {
                if (h0Var.binding == null) {
                    n.w(str2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i3;
                } else {
                    binding2.W.smoothScrollTo(i2, binding2.V.w().getTop());
                }
            }
        }
        i = 2;
        if (h0Var.binding != null) {
            if (integer.intValue() == 2 && h0Var.binding != null) {
                if (h0Var.binding == null) {
                    n.w(str2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i3;
                } else {
                    binding22.W.smoothScrollTo(i2, binding22.X.getTop());
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public r D1() {
        return getBaseViewModel();
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public c E1() {
        return DialogTags.CHALLENGE_DETAILS_DIALOG;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public void onCancel(DialogInterface dialogInterface) {
        str = "dialog";
        n.f(dialogInterface, str);
        super.onCancel(dialogInterface);
        getBaseViewModel().a0();
        a0 a0Var = G1();
        if (a0Var != null) {
            a0Var.r(DialogTags.CHALLENGE_DETAILS_DIALOG);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        g8 g8Var = g8.T(inflater, container, false);
        n.e(g8Var, "inflate(inflater, container, false)");
        this.binding = g8Var;
        if (!getBaseViewModel().f0(getArguments())) {
            dismissAllowingStateLoss();
        }
        int i = 0;
        String str7 = "binding";
        if (this.binding == null) {
            n.w(str7);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            this.binding.M(getViewLifecycleOwner());
            if (this.binding == null) {
                n.w(str7);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.W(getBaseViewModel());
                if (this.binding == null) {
                    n.w(str7);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    binding23.Z.T(getBaseViewModel());
                    if (this.binding == null) {
                        n.w(str7);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        this.binding.V(G1());
                        if (this.binding == null) {
                            n.w(str7);
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) i;
                        } else {
                            binding25.V.T(getBaseViewModel().M());
                            if (this.binding == null) {
                                n.w(str7);
                                /* Dexterity WARN: Type inference failed for thrown value */
                                throw (Throwable) i;
                            } else {
                                binding26.T.T(getBaseViewModel().K());
                                if (this.binding == null) {
                                    n.w(str7);
                                    /* Dexterity WARN: Type inference failed for thrown value */
                                    throw (Throwable) i;
                                } else {
                                    binding27.U.T(getBaseViewModel().L());
                                    if (this.binding == null) {
                                        n.w(str7);
                                        /* Dexterity WARN: Type inference failed for thrown value */
                                        throw (Throwable) i;
                                    } else {
                                        binding28.Y.setNavigationOnClickListener(new app.dogo.com.dogo_android.view.main_screen.challenge.c(this));
                                        m2();
                                        i2();
                                        if (this.binding == null) {
                                            n.w(str7);
                                            /* Dexterity WARN: Type inference failed for thrown value */
                                            throw (Throwable) i;
                                        } else {
                                            binding29.W.post(new app.dogo.com.dogo_android.view.main_screen.challenge.a(this));
                                            getBaseViewModel().B();
                                            if (getBaseViewModel().D() != null) {
                                                androidx.fragment.app.e requireActivity = requireActivity();
                                                n.e(requireActivity, "requireActivity()");
                                                this.messageBroadcaster.logScreenView(requireActivity, S.dailyWorkoutScreen.b(new EP_ChallengeId(), getBaseViewModel().D()));
                                            }
                                            getBaseViewModel().J().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.view.main_screen.challenge.f(this));
                                            if (this.binding == null) {
                                                n.w(str7);
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
                    }
                }
            }
        }
    }

    /* renamed from: Y1, reason: from kotlin metadata */
    public static /* synthetic */ void onCancel(h0 dialog) {
        ChallengeDetailsDialog.g2(dialog);
    }

    public static /* synthetic */ void Z1(h0 h0Var, Integer integer) {
        ChallengeDetailsDialog.n2(h0Var, integer);
    }

    public static /* synthetic */ void a2(h0 h0Var, View view) {
        ChallengeDetailsDialog.f2(h0Var, view);
    }

    public static /* synthetic */ void b2(h0 h0Var, Boolean boolean) {
        ChallengeDetailsDialog.j2(h0Var, boolean);
    }

    public static /* synthetic */ void c2(h0 h0Var) {
        ChallengeDetailsDialog.k2(h0Var);
    }

    public static /* synthetic */ void d2(h0 h0Var, y yVar) {
        ChallengeDetailsDialog.h2(h0Var, yVar);
    }

    public static /* synthetic */ void e2(h0 h0Var) {
        ChallengeDetailsDialog.l2(h0Var);
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public k3 H1() {
        return null;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public Class<? extends r> J1() {
        return BaseViewModel.class;
    }
}
