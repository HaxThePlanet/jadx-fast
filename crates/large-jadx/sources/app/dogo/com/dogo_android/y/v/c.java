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
@Metadata(d1 = "\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0019\u001a\u00020\u001aH\u0002J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0008\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0008\u0010#\u001a\u00020$H\u0016J\u0006\u0010%\u001a\u00020$J\u0008\u0010&\u001a\u00020$H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u001c\u0010\u000e\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00100\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0017\u0010\u0018\u001a\u0004\u0008\u0015\u0010\u0016¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionDialog;", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyBaseDialogFragment;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionPagerAdapter$PagerCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogProgramLessonIntroductionBinding;", "fragmentTag", "Lapp/dogo/com/dogo_android/enums/DialogTags;", "getFragmentTag", "()Lapp/dogo/com/dogo_android/enums/DialogTags;", "screenViewDescriptor", "Lapp/dogo/com/dogo_android/tracking/Screen;", "getScreenViewDescriptor", "()Lapp/dogo/com/dogo_android/tracking/Screen;", "viewModelClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "getViewModelClass", "()Ljava/lang/Class;", "viewmodel", "Lapp/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionViewModel;", "getViewmodel", "()Lapp/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionViewModel;", "viewmodel$delegate", "Lkotlin/Lazy;", "lastPage", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onItemClicked", "", "onNextClick", "showNextSlide", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c extends u implements app.dogo.com.dogo_android.y.v.d.a {

    public static final app.dogo.com.dogo_android.y.v.c.a Companion;
    private o9 w;
    private final h x;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionDialog$Companion;", "", "()V", "LAST_SLIDE_DETECT_NUMBER", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements a<app.dogo.com.dogo_android.y.v.e> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public b(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.y.v.e invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(e.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
        c.a aVar = new c.a(0);
        c.Companion = aVar;
    }

    public c() {
        super();
        final int i = 0;
        c.b bVar = new c.b(this, i, i);
        this.x = j.a(m.SYNCHRONIZED, bVar);
    }

    private final app.dogo.com.dogo_android.y.v.e X1() {
        return (e)this.x.getValue();
    }

    public static void Y1(app.dogo.com.dogo_android.y.v.c c, View view2) {
        c.a2(c, view2);
    }

    private final boolean Z1() {
        int itemCount;
        int i;
        o9 o9Var = this.w;
        int i2 = 0;
        String str = "binding";
        if (o9Var == null) {
        } else {
            o9 o9Var2 = this.w;
            if (o9Var2 == null) {
            } else {
                RecyclerView.h adapter = o9Var2.O.getAdapter();
                if (adapter == null) {
                    itemCount = i;
                } else {
                    itemCount = adapter.getItemCount();
                }
                int i4 = 1;
                if (o9Var.O.getCurrentItem() == itemCount -= i4) {
                    i = i4;
                }
                return i;
            }
            n.w(str);
            throw i2;
        }
        n.w(str);
        throw i2;
    }

    private static final void a2(app.dogo.com.dogo_android.y.v.c c, View view2) {
        n.f(c, "this$0");
        c.b2();
    }

    private final void c2() {
        o9 o9Var = this.w;
        if (o9Var == null) {
        } else {
            ViewPager2 view = o9Var.O;
            final int i3 = 1;
            view.k(currentItem += i3, i3);
        }
        n.w("binding");
        throw 0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public c E1() {
        return c.LESSON_INTRODUCTION_DIALOG;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public k3 H1() {
        return j3.H0;
    }

    public Class<? extends r> J1() {
        return r.class;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public final void b2() {
        app.dogo.com.dogo_android.y.v.e z;
        if (Z1()) {
            X1().i();
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
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        Dialog obj4 = getDialog();
        n.d(obj4);
        obj4 = obj4.getWindow();
        n.d(obj4);
        obj4.setBackgroundDrawableResource(2131100375);
        o9 obj2 = o9.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.w = obj2;
        int obj3 = 0;
        obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.M(getViewLifecycleOwner());
            obj2 = this.w;
            if (obj2 == null) {
            } else {
                obj2.W(X1());
                obj2 = this.w;
                if (obj2 == null) {
                } else {
                    obj2.V(this);
                    obj2 = this.w;
                    if (obj2 == null) {
                    } else {
                        a aVar = new a(this);
                        obj2.P.setOnClickListener(aVar);
                        obj2 = this.w;
                        if (obj2 == null) {
                        } else {
                            return obj2.w();
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
}
