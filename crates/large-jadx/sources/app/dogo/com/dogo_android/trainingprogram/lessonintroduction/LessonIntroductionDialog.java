package app.dogo.com.dogo_android.y.v;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.lifecycle.j0;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.viewpager2.widget.ViewPager2;
import app.dogo.com.dogo_android.h.o9;
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.u;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import m.a.b.a.d.a.b;

/* compiled from: LessonIntroductionDialog.kt */
@Metadata(d1 = "\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0019\u001a\u00020\u001aH\u0002J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0008\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0008\u0010#\u001a\u00020$H\u0016J\u0006\u0010%\u001a\u00020$J\u0008\u0010&\u001a\u00020$H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u001c\u0010\u000e\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00100\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0017\u0010\u0018\u001a\u0004\u0008\u0015\u0010\u0016¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionDialog;", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyBaseDialogFragment;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionPagerAdapter$PagerCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogProgramLessonIntroductionBinding;", "fragmentTag", "Lapp/dogo/com/dogo_android/enums/DialogTags;", "getFragmentTag", "()Lapp/dogo/com/dogo_android/enums/DialogTags;", "screenViewDescriptor", "Lapp/dogo/com/dogo_android/tracking/Screen;", "getScreenViewDescriptor", "()Lapp/dogo/com/dogo_android/tracking/Screen;", "viewModelClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "getViewModelClass", "()Ljava/lang/Class;", "viewmodel", "Lapp/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionViewModel;", "getViewmodel", "()Lapp/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionViewModel;", "viewmodel$delegate", "Lkotlin/Lazy;", "lastPage", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onItemClicked", "", "onNextClick", "showNextSlide", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c, reason: from kotlin metadata */
public final class LessonIntroductionDialog extends u implements d.a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final c.a INSTANCE = new c$a(0);
    /* renamed from: w, reason: from kotlin metadata */
    private o9 binding;
    private final h x;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionDialog$Companion;", "", "()V", "LAST_SLIDE_DETECT_NUMBER", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements kotlin.d0.c.a<e> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final e invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(LessonIntroductionViewModel.class), this.$parameters);
        }

        public b(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    public c() {
        super();
        final m.a.c.j.a aVar = null;
        this.x = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.trainingprogram.lessonintroduction.c.b(this, aVar, aVar));
    }

    /* renamed from: X1, reason: from kotlin metadata */
    private final e lastPage() {
        return (LessonIntroductionViewModel)this.x.getValue();
    }

    private final boolean Z1() {
        int itemCount;
        boolean z = false;
        int i2 = 0;
        String str = "binding";
        if (this.binding == null) {
            n.w(str);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i2;
        } else {
            if (this.binding == null) {
                n.w(str);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i2;
            } else {
                RecyclerView.h adapter = binding22.O.getAdapter();
                if (adapter == null) {
                } else {
                    itemCount = adapter.getItemCount();
                }
                int i = 1;
                if (binding2.O.getCurrentItem() == itemCount - i) {
                }
                return z;
            }
        }
    }

    private static final void a2(c cVar, View view) {
        n.f(cVar, "this$0");
        cVar.b2();
    }

    private final void c2() {
        if (this.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            final int i3 = 1;
            binding2.O.k(binding2.O.getCurrentItem() + i3, true);
            return;
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public c E1() {
        return DialogTags.LESSON_INTRODUCTION_DIALOG;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public k3 H1() {
        return S.challengeReport;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public final void b2() {
        if (Z1()) {
            lastPage().i();
            dismiss();
        } else {
            c2();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public void f() {
        b2();
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        Dialog dialog = getDialog();
        n.d(dialog);
        Window window = dialog.getWindow();
        n.d(window);
        window.setBackgroundDrawableResource(2131100375);
        o9 o9Var = o9.T(inflater, container, false);
        n.e(o9Var, "inflate(inflater, container, false)");
        this.binding = o9Var;
        int i2 = 0;
        String str3 = "binding";
        if (o9Var == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i2;
        } else {
            o9Var.M(getViewLifecycleOwner());
            if (this.binding == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i2;
            } else {
                this.binding.W(lastPage());
                if (this.binding == null) {
                    n.w(str3);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i2;
                } else {
                    this.binding.V(this);
                    if (this.binding == null) {
                        n.w(str3);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i2;
                    } else {
                        binding23.P.setOnClickListener(new app.dogo.com.dogo_android.trainingprogram.lessonintroduction.a(this));
                        if (this.binding == null) {
                            n.w(str3);
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) i2;
                        } else {
                            return this.binding.w();
                        }
                    }
                }
            }
        }
    }

    public static /* synthetic */ void Y1(c cVar, View view) {
        LessonIntroductionDialog.a2(cVar, view);
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public Class<? extends r> J1() {
        return BaseViewModel.class;
    }
}
