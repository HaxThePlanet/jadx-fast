package app.dogo.com.dogo_android.view.main_screen.j;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.a0.g.f.e0;
import app.dogo.com.dogo_android.h.cn;
import app.dogo.com.dogo_android.h.i8;
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.u;
import app.dogo.com.dogo_android.util.exceptions.ExceptionForTaskChain;
import app.dogo.com.dogo_android.util.k0.g;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import com.theartofdev.edmodo.cropper.CropImageView.b;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.m;
import kotlin.y.q0;
import m.a.b.a.d.a.b;

/* compiled from: ChallengeEntryCreationDialog.kt */
@Metadata(d1 = "\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u001f\u001a\u00020\u0013H\u0002J\u0008\u0010 \u001a\u00020\u0016H\u0016J\"\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0008\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020*H\u0016J$\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0008\u0010/\u001a\u0004\u0018\u0001002\u0008\u00101\u001a\u0004\u0018\u000102H\u0016J\u001c\u00103\u001a\u00020\"2\u0008\u00104\u001a\u0004\u0018\u00010\u000b2\u0008\u00105\u001a\u0004\u0018\u000102H\u0014J\u0012\u00106\u001a\u00020\"2\u0008\u00107\u001a\u0004\u0018\u000108H\u0002J\u0008\u00109\u001a\u00020\"H\u0016J\u0008\u0010:\u001a\u00020\"H\u0016J\u0008\u0010;\u001a\u00020<H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001a\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00160\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u001d\u0010\u001e\u001a\u0004\u0008\u001b\u0010\u001c¨\u0006=", d2 = {"Lapp/dogo/com/dogo_android/view/main_screen/challenge/ChallengeEntryCreationDialog;", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyBaseDialogFragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogChallengeEntryCreationBinding;", "fragmentTag", "Lapp/dogo/com/dogo_android/enums/DialogTags;", "getFragmentTag", "()Lapp/dogo/com/dogo_android/enums/DialogTags;", "messagingFilters", "", "Lapp/dogo/com/dogo_android/enums/FragmentMessageAction;", "getMessagingFilters", "()Ljava/util/Set;", "screenViewDescriptor", "Lapp/dogo/com/dogo_android/tracking/Screen;", "getScreenViewDescriptor", "()Lapp/dogo/com/dogo_android/tracking/Screen;", "topBarManager", "Lapp/dogo/com/dogo_android/util/interfaces/TopBarManager;", "viewModelClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "getViewModelClass", "()Ljava/lang/Class;", "viewModelDi", "Lapp/dogo/com/dogo_android/viewmodel/main_screen/challenge/ChallengeEntryCreationViewModel;", "getViewModelDi", "()Lapp/dogo/com/dogo_android/viewmodel/main_screen/challenge/ChallengeEntryCreationViewModel;", "viewModelDi$delegate", "Lkotlin/Lazy;", "createTopBarManager", "getBaseViewModel", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDataReceived", "action", "message", "onPublishClick", "navigator", "Lapp/dogo/com/dogo_android/util/base_classes/Navigator;", "onStart", "onStop", "validatePublishRequest", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i0, reason: from kotlin metadata */
public final class ChallengeEntryCreationDialog extends u {

    /* renamed from: w, reason: from kotlin metadata */
    private i8 binding;
    private final kotlin.h x;
    private g y;

    @Metadata(d1 = "\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0008\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0008\u0010\t\u001a\u00020\u0003H\u0016J\u0008\u0010\n\u001a\u00020\u000bH\u0016J\u0008\u0010\u000c\u001a\u00020\rH\u0016J\u0008\u0010\u000e\u001a\u00020\rH\u0016¨\u0006\u000f", d2 = {"app/dogo/com/dogo_android/view/main_screen/challenge/ChallengeEntryCreationDialog$createTopBarManager$1", "Lapp/dogo/com/dogo_android/util/interfaces/TopBarManager;", "getActionName", "", "getBackgroundColorRes", "", "view", "Landroid/view/View;", "getTextColorRes", "getTitle", "isBackVisible", "", "onAction", "", "onBack", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends g {

        final /* synthetic */ i0 a;
        a() {
            this.a = i0Var;
            super();
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public String getActionName() {
            return this.a.getString(2131886312);
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public int getBackgroundColorRes(View view) throws android.content.res.Resources.NotFoundException {
            n.f(view, "view");
            return this.a.getResources().getColor(2131100378, null);
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public int getTextColorRes(View view) throws android.content.res.Resources.NotFoundException {
            n.f(view, "view");
            return this.a.getResources().getColor(2131100379, null);
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public void onAction() {
            this.a.onPublishClick(this.a.G1());
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public void onBack() {
            a0 a0Var = this.a.G1();
            n.d(a0Var);
            this.a.a2().onChangeClick(a0Var);
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public String getTitle() {
            return "";
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public boolean isBackVisible() {
            return true;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements kotlin.d0.c.a<e0> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final e0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(ChallengeEntryCreationViewModel.class), this.$parameters);
        }

        public b(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }
    public i0() {
        super();
        final m.a.c.j.a aVar = null;
        this.x = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.view.main_screen.challenge.i0.b(this, aVar, aVar));
    }

    /* renamed from: X1, reason: from kotlin metadata */
    public static final /* synthetic */ e0 onCancel(i0 dialog) {
        return dialog.a2();
    }

    /* renamed from: Y1, reason: from kotlin metadata */
    public static final /* synthetic */ void onDataReceived(i0 action, a0 message) {
        action.onPublishClick(message);
    }

    /* renamed from: Z1, reason: from kotlin metadata */
    private final g createTopBarManager() {
        return new ChallengeEntryCreationDialog_createTopBarManager_1(this);
    }

    private final e0 a2() {
        return (ChallengeEntryCreationViewModel)this.x.getValue();
    }

    private static final void e2(i0 i0Var, View view) {
        n.f(i0Var, "this$0");
        if (i0Var.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            n.e(binding2.P, "binding.editText");
            i0Var.onCreate(binding2.P);
            return;
        }
    }

    /* renamed from: f2, reason: from kotlin metadata */
    private final void onPublishClick(a0 navigator) {
        if (!i2()) {
            return;
        }
        if (a2().I()) {
            callLoadingDialog();
            a2().Q().addOnFailureListener(new app.dogo.com.dogo_android.view.main_screen.challenge.i(navigator)).addOnCompleteListener(new app.dogo.com.dogo_android.view.main_screen.challenge.h(navigator, this));
        }
    }

    private static final void g2(a0 a0Var, Exception exc) {
        a.d(exc);
        z = exc instanceof ExceptionForTaskChain;
        final int i4 = 2131886123;
        if (exc instanceof ExceptionForTaskChain) {
            int i = exc.a();
            if (i != 2) {
                if (i != 4) {
                    if (a0Var != null) {
                        a0Var.t0(i4);
                    }
                } else {
                    if (a0Var != null) {
                        i = 2131886307;
                        a0Var.t0(i);
                    }
                }
            } else {
                if (a0Var != null) {
                    i = 2131886305;
                    a0Var.t0(i);
                }
            }
        } else {
            if (a0Var != null) {
                a0Var.t0(i4);
            }
        }
    }

    /* renamed from: h2, reason: from kotlin metadata */
    private static final void onCreateView(a0 inflater, i0 container, com.google.android.gms.tasks.j savedInstanceState) {
        n.f(container, "this$0");
        if (inflater != null) {
            inflater.s();
        }
        container.dismissAllowingStateLoss();
    }

    private final boolean i2() {
        final int i7 = 0;
        if (!a2().G()) {
            onSaveInstanceState(2131886953);
            return false;
        }
        int i8 = 1;
        if (!a2().J()) {
            if (a2().D() == null) {
                onSaveInstanceState(2131886262);
            } else {
                int[] iArr = a2().E();
                int i = 2131886753;
                Object[] arr = new Object[2];
                arr[i7] = Integer.valueOf(iArr[i7]);
                arr[i8] = Integer.valueOf(iArr[i8]);
                refresh(getString(i, arr));
            }
            return false;
        }
        if (a2().F()) {
            onSaveInstanceState(2131886293);
            return false;
        }
        if (!a2().K()) {
            onSaveInstanceState(2131886693);
            return false;
        }
        if (!a2().H()) {
            a0 a0Var = G1();
            n.d(a0Var);
            a2().setArguments(a0Var);
            return false;
        }
        return true;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public r D1() {
        return a2();
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public c E1() {
        return DialogTags.CHALLENGE_ENTRY_CREATION;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    protected Set<app.dogo.com.dogo_android.k.h> F1() {
        return q0.a(FragmentMessageAction.MESSAGE_ACTION_PUBLISH_ENTRY);
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public k3 H1() {
        return S.dailyWorkoutInfoScreen;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    protected void S1(app.dogo.com.dogo_android.k.h hVar, Bundle bundle) {
        if (hVar == FragmentMessageAction.MESSAGE_ACTION_PUBLISH_ENTRY) {
            onPublishClick(G1());
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 203 && i2 == -1) {
            androidx.fragment.app.e activity = getActivity();
            z = activity instanceof Navigator;
            if (activity instanceof Navigator) {
                a2().transformRemoteErrorCodeToLocalErrorCode(d.b(intent).g());
                onAttach(activity);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public void onCancel(DialogInterface dialogInterface) {
        n.f(dialogInterface, "dialog");
        super.onCancel(dialogInterface);
        a0 a0Var = G1();
        n.d(a0Var);
        a2().onChangeClick(a0Var);
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        n.f(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            if (window != null) {
                int i = 2131230939;
                window.setBackgroundDrawableResource(i);
            }
        }
        this.y = createTopBarManager();
        i8 i8Var = i8.T(layoutInflater, viewGroup, false);
        n.e(i8Var, "inflate(inflater, container, false)");
        this.binding = i8Var;
        int i2 = 0;
        String str5 = "binding";
        if (i8Var == null) {
            n.w(str5);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i2;
        } else {
            i8Var.W(a2());
            if (this.binding == null) {
                n.w(str5);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i2;
            } else {
                this.binding.M(getViewLifecycleOwner());
                if (this.binding == null) {
                    n.w(str5);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i2;
                } else {
                    this.binding.V(G1());
                    if (this.binding == null) {
                        n.w(str5);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i2;
                    } else {
                        binding23.R.U(this.y);
                        if (this.binding == null) {
                            n.w(str5);
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) i2;
                        } else {
                            binding24.O.setOnClickListener(new app.dogo.com.dogo_android.view.main_screen.challenge.j(this));
                            Bundle requireArguments = requireArguments();
                            n.e(requireArguments, "requireArguments()");
                            if (!a2().tempSaveImage(requireArguments)) {
                                a0 a0Var2 = G1();
                                if (a0Var2 != null) {
                                    a0Var2.u();
                                }
                            }
                            if (this.binding == null) {
                                n.w(str5);
                                /* Dexterity WARN: Type inference failed for thrown value */
                                throw (Throwable) i2;
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

    @Override // app.dogo.com.dogo_android.util.e0.u
    public void onStart() {
        super.onStart();
        if (a2().B() != null) {
            a2().w();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public void onStop() {
        super.onStop();
        a2().A();
    }


    /* renamed from: b2, reason: from kotlin metadata */
    public static /* synthetic */ void onActivityResult(a0 requestCode, i0 resultCode, com.google.android.gms.tasks.j data) {
        ChallengeEntryCreationDialog.onCreateView(requestCode, resultCode, data);
    }

    public static /* synthetic */ void c2(a0 a0Var, Exception exc) {
        ChallengeEntryCreationDialog.g2(a0Var, exc);
    }

    public static /* synthetic */ void d2(i0 i0Var, View view) {
        ChallengeEntryCreationDialog.e2(i0Var, view);
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public Class<? extends r> J1() {
        return BaseViewModel.class;
    }
}
