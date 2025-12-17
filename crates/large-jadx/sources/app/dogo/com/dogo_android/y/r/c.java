package app.dogo.com.dogo_android.y.r;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.d;
import androidx.activity.e;
import androidx.constraintlayout.widget.d;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import androidx.lifecycle.r;
import app.dogo.com.dogo_android.h.gd;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.g;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.y.j;
import app.dogo.com.dogo_android.y.o.w;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.c.p;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.x0;
import m.a.b.a.d.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\u0018\u0000 32\u00020\u0001:\u00013B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0008\u0010\u0015\u001a\u00020\u0016H\u0002J\u0008\u0010\u0017\u001a\u00020\u0010H\u0002J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\"\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0016J$\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&2\u0008\u0010'\u001a\u0004\u0018\u00010(2\u0008\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001a\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00122\u0008\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0008\u0010-\u001a\u00020\u0010H\u0002J\u0008\u0010.\u001a\u00020\u0010H\u0002J#\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u00122\u0008\u0008\u0002\u00101\u001a\u00020\u0016H\u0082@ø\u0001\u0000¢\u0006\u0002\u00102R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000c\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u00064", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/firstexamunlocked/FirstExamUnlockedFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentFirstExamUnlcokedBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/firstexamunlocked/FirstExamUnlockedScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/firstexamunlocked/FirstExamUnlockedScreen;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/firstexamunlocked/FirstExamUnlockedViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/firstexamunlocked/FirstExamUnlockedViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "animateChatMessageHiding", "", "itemToRemove", "Landroid/view/View;", "newTopItem", "(Landroid/view/View;Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkIfChatShouldBeCondensed", "", "goToExamList", "goToNextScreen", "appScreen", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "recordVideo", "startChatAnimation", "startFadeInAnimation", "animatedItem", "lastItemLoaded", "(Landroid/view/View;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c extends Fragment {

    public static final app.dogo.com.dogo_android.y.r.c.a Companion;
    private gd a;
    private final h b;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0006\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/firstexamunlocked/FirstExamUnlockedFragment$Companion;", "", "()V", "FONT_SIZE_LIMIT", "", "FONT_SIZE_THRESHOLD", "SCREEN_HEIGHT_THRESHOLD", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.firstexamunlocked.FirstExamUnlockedFragment", f = "FirstExamUnlockedFragment.kt", l = 130, m = "animateChatMessageHiding")
    static final class b extends d {

        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        Object result;
        final app.dogo.com.dogo_android.y.r.c this$0;
        b(app.dogo.com.dogo_android.y.r.c c, d<? super app.dogo.com.dogo_android.y.r.c.b> d2) {
            this.this$0 = c;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            int i2 = 0;
            return c.B1(this.this$0, i2, i2, this);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements l<d, w> {

        final app.dogo.com.dogo_android.y.r.c this$0;
        c(app.dogo.com.dogo_android.y.r.c c) {
            this.this$0 = c;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(d d) {
            Object obj2;
            n.f(d, "$this$addCallback");
            obj2 = c.D1(this.this$0).b();
            app.dogo.com.dogo_android.y.r.c this$0 = this.this$0;
            if (obj2 != null) {
                c.E1(this$0, obj2);
            } else {
                obj2 = this$0.getActivity();
                if (obj2 == null) {
                } else {
                    g1.O(obj2);
                }
            }
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((d)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements a<app.dogo.com.dogo_android.y.r.e> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public d(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.y.r.e invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(e.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.firstexamunlocked.FirstExamUnlockedFragment", f = "FirstExamUnlockedFragment.kt", l = 116, m = "startFadeInAnimation")
    static final class f extends d {

        Object L$0;
        boolean Z$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.y.r.c this$0;
        f(app.dogo.com.dogo_android.y.r.c c, d<? super app.dogo.com.dogo_android.y.r.c.f> d2) {
            this.this$0 = c;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj3 |= i;
            return c.F1(this.this$0, 0, false, this);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends p implements a<a> {

        final app.dogo.com.dogo_android.y.r.c this$0;
        g(app.dogo.com.dogo_android.y.r.c c) {
            this.this$0 = c;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[2];
            return b.b(c.D1(this.this$0).g(), c.D1(this.this$0).e());
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.firstexamunlocked.FirstExamUnlockedFragment$startChatAnimation$1", f = "FirstExamUnlockedFragment.kt", l = {91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 105}, m = "invokeSuspend")
    static final class e extends k implements p<m0, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.y.r.c this$0;
        e(app.dogo.com.dogo_android.y.r.c c, d<? super app.dogo.com.dogo_android.y.r.c.e> d2) {
            this.this$0 = c;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (c.e)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            c.e obj2 = new c.e(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int label;
            TextView view;
            int i3;
            d dVar;
            int i;
            int i5;
            int i4;
            final Object obj = this;
            final Object obj2 = b.d();
            final String str4 = "binding.fourthChat";
            final String str5 = "binding.firstChat";
            final int i16 = 1500;
            final String str6 = "binding.thirdChat";
            final String str7 = "binding.secondChat";
            final int i17 = 3000;
            i5 = 1;
            final int i18 = 0;
            final String str8 = "binding";
            switch (label) {
                case 0:
                    q.b(object);
                    obj.label = i5;
                    return obj2;
                case 1:
                    q.b(object);
                    break;
                case 2:
                    q.b(object);
                    obj.label = 3;
                    return obj2;
                    app.dogo.com.dogo_android.y.r.c this$05 = obj.this$0;
                    gd gdVar6 = c.C1(this$05);
                    view = gdVar6.V;
                    n.e(view, str7);
                    obj.label = 4;
                    return obj2;
                    obj.label = 5;
                    return obj2;
                    app.dogo.com.dogo_android.y.r.c this$06 = obj.this$0;
                    gd gdVar7 = c.C1(this$06);
                    view = gdVar7.X;
                    n.e(view, str6);
                    obj.label = 6;
                    return obj2;
                    app.dogo.com.dogo_android.y.r.c this$0 = obj.this$0;
                    gd gdVar2 = c.C1(this$0);
                    view = gdVar2.R;
                    n.e(view, str5);
                    gd gdVar11 = c.C1(obj.this$0);
                    i3 = gdVar11.V;
                    n.e(i3, str7);
                    obj.label = 7;
                    return obj2;
                    obj.label = 8;
                    return obj2;
                    app.dogo.com.dogo_android.y.r.c this$02 = obj.this$0;
                    gd gdVar3 = c.C1(this$02);
                    view = gdVar3.S;
                    n.e(view, str4);
                    obj.label = 9;
                    return obj2;
                    app.dogo.com.dogo_android.y.r.c this$09 = obj.this$0;
                    gd gdVar9 = c.C1(this$09);
                    view = gdVar9.V;
                    n.e(view, str7);
                    gd gdVar12 = c.C1(obj.this$0);
                    i3 = gdVar12.X;
                    n.e(i3, str6);
                    obj.label = 10;
                    return obj2;
                    obj.label = 11;
                    return obj2;
                    app.dogo.com.dogo_android.y.r.c this$010 = obj.this$0;
                    gd gdVar10 = c.C1(this$010);
                    view = gdVar10.Q;
                    n.e(view, "binding.fifthChat");
                    obj.label = 12;
                    return obj2;
                    app.dogo.com.dogo_android.y.r.c this$04 = obj.this$0;
                    gd gdVar5 = c.C1(this$04);
                    view = gdVar5.X;
                    n.e(view, str6);
                    gd gdVar13 = c.C1(obj.this$0);
                    dVar = gdVar13.S;
                    n.e(dVar, str4);
                    obj.label = 13;
                    return obj2;
                    gd gdVar = c.C1(obj.this$0);
                    gdVar.P.setVisibility(0);
                    app.dogo.com.dogo_android.y.r.c this$08 = obj.this$0;
                    gd gdVar8 = c.C1(this$08);
                    view = gdVar8.U;
                    n.e(view, "binding.recordVideoCard");
                    obj.label = 14;
                    return obj2;
                    return w.a;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                case 3:
                    q.b(object);
                    this$05 = obj.this$0;
                    gdVar6 = c.C1(this$05);
                    view = gdVar6.V;
                    n.e(view, str7);
                    obj.label = 4;
                    return obj2;
                    obj.label = 5;
                    return obj2;
                    this$06 = obj.this$0;
                    gdVar7 = c.C1(this$06);
                    view = gdVar7.X;
                    n.e(view, str6);
                    obj.label = 6;
                    return obj2;
                    this$0 = obj.this$0;
                    gdVar2 = c.C1(this$0);
                    view = gdVar2.R;
                    n.e(view, str5);
                    gdVar11 = c.C1(obj.this$0);
                    i3 = gdVar11.V;
                    n.e(i3, str7);
                    obj.label = 7;
                    return obj2;
                    obj.label = 8;
                    return obj2;
                    this$02 = obj.this$0;
                    gdVar3 = c.C1(this$02);
                    view = gdVar3.S;
                    n.e(view, str4);
                    obj.label = 9;
                    return obj2;
                    this$09 = obj.this$0;
                    gdVar9 = c.C1(this$09);
                    view = gdVar9.V;
                    n.e(view, str7);
                    gdVar12 = c.C1(obj.this$0);
                    i3 = gdVar12.X;
                    n.e(i3, str6);
                    obj.label = 10;
                    return obj2;
                    obj.label = 11;
                    return obj2;
                    this$010 = obj.this$0;
                    gdVar10 = c.C1(this$010);
                    view = gdVar10.Q;
                    n.e(view, "binding.fifthChat");
                    obj.label = 12;
                    return obj2;
                    this$04 = obj.this$0;
                    gdVar5 = c.C1(this$04);
                    view = gdVar5.X;
                    n.e(view, str6);
                    gdVar13 = c.C1(obj.this$0);
                    dVar = gdVar13.S;
                    n.e(dVar, str4);
                    obj.label = 13;
                    return obj2;
                    gdVar = c.C1(obj.this$0);
                    gdVar.P.setVisibility(0);
                    this$08 = obj.this$0;
                    gdVar8 = c.C1(this$08);
                    view = gdVar8.U;
                    n.e(view, "binding.recordVideoCard");
                    obj.label = 14;
                    return obj2;
                    return w.a;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                case 4:
                    q.b(object);
                    obj.label = 5;
                    return obj2;
                    this$06 = obj.this$0;
                    gdVar7 = c.C1(this$06);
                    view = gdVar7.X;
                    n.e(view, str6);
                    obj.label = 6;
                    return obj2;
                    this$0 = obj.this$0;
                    gdVar2 = c.C1(this$0);
                    view = gdVar2.R;
                    n.e(view, str5);
                    gdVar11 = c.C1(obj.this$0);
                    i3 = gdVar11.V;
                    n.e(i3, str7);
                    obj.label = 7;
                    return obj2;
                    obj.label = 8;
                    return obj2;
                    this$02 = obj.this$0;
                    gdVar3 = c.C1(this$02);
                    view = gdVar3.S;
                    n.e(view, str4);
                    obj.label = 9;
                    return obj2;
                    this$09 = obj.this$0;
                    gdVar9 = c.C1(this$09);
                    view = gdVar9.V;
                    n.e(view, str7);
                    gdVar12 = c.C1(obj.this$0);
                    i3 = gdVar12.X;
                    n.e(i3, str6);
                    obj.label = 10;
                    return obj2;
                    obj.label = 11;
                    return obj2;
                    this$010 = obj.this$0;
                    gdVar10 = c.C1(this$010);
                    view = gdVar10.Q;
                    n.e(view, "binding.fifthChat");
                    obj.label = 12;
                    return obj2;
                    this$04 = obj.this$0;
                    gdVar5 = c.C1(this$04);
                    view = gdVar5.X;
                    n.e(view, str6);
                    gdVar13 = c.C1(obj.this$0);
                    dVar = gdVar13.S;
                    n.e(dVar, str4);
                    obj.label = 13;
                    return obj2;
                    gdVar = c.C1(obj.this$0);
                    gdVar.P.setVisibility(0);
                    this$08 = obj.this$0;
                    gdVar8 = c.C1(this$08);
                    view = gdVar8.U;
                    n.e(view, "binding.recordVideoCard");
                    obj.label = 14;
                    return obj2;
                    return w.a;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                case 5:
                    q.b(object);
                    this$06 = obj.this$0;
                    gdVar7 = c.C1(this$06);
                    view = gdVar7.X;
                    n.e(view, str6);
                    obj.label = 6;
                    return obj2;
                    this$0 = obj.this$0;
                    gdVar2 = c.C1(this$0);
                    view = gdVar2.R;
                    n.e(view, str5);
                    gdVar11 = c.C1(obj.this$0);
                    i3 = gdVar11.V;
                    n.e(i3, str7);
                    obj.label = 7;
                    return obj2;
                    obj.label = 8;
                    return obj2;
                    this$02 = obj.this$0;
                    gdVar3 = c.C1(this$02);
                    view = gdVar3.S;
                    n.e(view, str4);
                    obj.label = 9;
                    return obj2;
                    this$09 = obj.this$0;
                    gdVar9 = c.C1(this$09);
                    view = gdVar9.V;
                    n.e(view, str7);
                    gdVar12 = c.C1(obj.this$0);
                    i3 = gdVar12.X;
                    n.e(i3, str6);
                    obj.label = 10;
                    return obj2;
                    obj.label = 11;
                    return obj2;
                    this$010 = obj.this$0;
                    gdVar10 = c.C1(this$010);
                    view = gdVar10.Q;
                    n.e(view, "binding.fifthChat");
                    obj.label = 12;
                    return obj2;
                    this$04 = obj.this$0;
                    gdVar5 = c.C1(this$04);
                    view = gdVar5.X;
                    n.e(view, str6);
                    gdVar13 = c.C1(obj.this$0);
                    dVar = gdVar13.S;
                    n.e(dVar, str4);
                    obj.label = 13;
                    return obj2;
                    gdVar = c.C1(obj.this$0);
                    gdVar.P.setVisibility(0);
                    this$08 = obj.this$0;
                    gdVar8 = c.C1(this$08);
                    view = gdVar8.U;
                    n.e(view, "binding.recordVideoCard");
                    obj.label = 14;
                    return obj2;
                    return w.a;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                case 6:
                    q.b(object);
                    this$0 = obj.this$0;
                    gdVar2 = c.C1(this$0);
                    view = gdVar2.R;
                    n.e(view, str5);
                    gdVar11 = c.C1(obj.this$0);
                    i3 = gdVar11.V;
                    n.e(i3, str7);
                    obj.label = 7;
                    return obj2;
                    obj.label = 8;
                    return obj2;
                    this$02 = obj.this$0;
                    gdVar3 = c.C1(this$02);
                    view = gdVar3.S;
                    n.e(view, str4);
                    obj.label = 9;
                    return obj2;
                    this$09 = obj.this$0;
                    gdVar9 = c.C1(this$09);
                    view = gdVar9.V;
                    n.e(view, str7);
                    gdVar12 = c.C1(obj.this$0);
                    i3 = gdVar12.X;
                    n.e(i3, str6);
                    obj.label = 10;
                    return obj2;
                    obj.label = 11;
                    return obj2;
                    this$010 = obj.this$0;
                    gdVar10 = c.C1(this$010);
                    view = gdVar10.Q;
                    n.e(view, "binding.fifthChat");
                    obj.label = 12;
                    return obj2;
                    this$04 = obj.this$0;
                    gdVar5 = c.C1(this$04);
                    view = gdVar5.X;
                    n.e(view, str6);
                    gdVar13 = c.C1(obj.this$0);
                    dVar = gdVar13.S;
                    n.e(dVar, str4);
                    obj.label = 13;
                    return obj2;
                    gdVar = c.C1(obj.this$0);
                    gdVar.P.setVisibility(0);
                    this$08 = obj.this$0;
                    gdVar8 = c.C1(this$08);
                    view = gdVar8.U;
                    n.e(view, "binding.recordVideoCard");
                    obj.label = 14;
                    return obj2;
                    return w.a;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                case 7:
                    q.b(object);
                    obj.label = 8;
                    return obj2;
                    this$02 = obj.this$0;
                    gdVar3 = c.C1(this$02);
                    view = gdVar3.S;
                    n.e(view, str4);
                    obj.label = 9;
                    return obj2;
                    this$09 = obj.this$0;
                    gdVar9 = c.C1(this$09);
                    view = gdVar9.V;
                    n.e(view, str7);
                    gdVar12 = c.C1(obj.this$0);
                    i3 = gdVar12.X;
                    n.e(i3, str6);
                    obj.label = 10;
                    return obj2;
                    obj.label = 11;
                    return obj2;
                    this$010 = obj.this$0;
                    gdVar10 = c.C1(this$010);
                    view = gdVar10.Q;
                    n.e(view, "binding.fifthChat");
                    obj.label = 12;
                    return obj2;
                    this$04 = obj.this$0;
                    gdVar5 = c.C1(this$04);
                    view = gdVar5.X;
                    n.e(view, str6);
                    gdVar13 = c.C1(obj.this$0);
                    dVar = gdVar13.S;
                    n.e(dVar, str4);
                    obj.label = 13;
                    return obj2;
                    gdVar = c.C1(obj.this$0);
                    gdVar.P.setVisibility(0);
                    this$08 = obj.this$0;
                    gdVar8 = c.C1(this$08);
                    view = gdVar8.U;
                    n.e(view, "binding.recordVideoCard");
                    obj.label = 14;
                    return obj2;
                    return w.a;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                case 8:
                    q.b(object);
                    this$02 = obj.this$0;
                    gdVar3 = c.C1(this$02);
                    view = gdVar3.S;
                    n.e(view, str4);
                    obj.label = 9;
                    return obj2;
                    this$09 = obj.this$0;
                    gdVar9 = c.C1(this$09);
                    view = gdVar9.V;
                    n.e(view, str7);
                    gdVar12 = c.C1(obj.this$0);
                    i3 = gdVar12.X;
                    n.e(i3, str6);
                    obj.label = 10;
                    return obj2;
                    obj.label = 11;
                    return obj2;
                    this$010 = obj.this$0;
                    gdVar10 = c.C1(this$010);
                    view = gdVar10.Q;
                    n.e(view, "binding.fifthChat");
                    obj.label = 12;
                    return obj2;
                    this$04 = obj.this$0;
                    gdVar5 = c.C1(this$04);
                    view = gdVar5.X;
                    n.e(view, str6);
                    gdVar13 = c.C1(obj.this$0);
                    dVar = gdVar13.S;
                    n.e(dVar, str4);
                    obj.label = 13;
                    return obj2;
                    gdVar = c.C1(obj.this$0);
                    gdVar.P.setVisibility(0);
                    this$08 = obj.this$0;
                    gdVar8 = c.C1(this$08);
                    view = gdVar8.U;
                    n.e(view, "binding.recordVideoCard");
                    obj.label = 14;
                    return obj2;
                    return w.a;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                case 9:
                    q.b(object);
                    this$09 = obj.this$0;
                    gdVar9 = c.C1(this$09);
                    view = gdVar9.V;
                    n.e(view, str7);
                    gdVar12 = c.C1(obj.this$0);
                    i3 = gdVar12.X;
                    n.e(i3, str6);
                    obj.label = 10;
                    return obj2;
                    obj.label = 11;
                    return obj2;
                    this$010 = obj.this$0;
                    gdVar10 = c.C1(this$010);
                    view = gdVar10.Q;
                    n.e(view, "binding.fifthChat");
                    obj.label = 12;
                    return obj2;
                    this$04 = obj.this$0;
                    gdVar5 = c.C1(this$04);
                    view = gdVar5.X;
                    n.e(view, str6);
                    gdVar13 = c.C1(obj.this$0);
                    dVar = gdVar13.S;
                    n.e(dVar, str4);
                    obj.label = 13;
                    return obj2;
                    gdVar = c.C1(obj.this$0);
                    gdVar.P.setVisibility(0);
                    this$08 = obj.this$0;
                    gdVar8 = c.C1(this$08);
                    view = gdVar8.U;
                    n.e(view, "binding.recordVideoCard");
                    obj.label = 14;
                    return obj2;
                    return w.a;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                case 10:
                    q.b(object);
                    obj.label = 11;
                    return obj2;
                    this$010 = obj.this$0;
                    gdVar10 = c.C1(this$010);
                    view = gdVar10.Q;
                    n.e(view, "binding.fifthChat");
                    obj.label = 12;
                    return obj2;
                    this$04 = obj.this$0;
                    gdVar5 = c.C1(this$04);
                    view = gdVar5.X;
                    n.e(view, str6);
                    gdVar13 = c.C1(obj.this$0);
                    dVar = gdVar13.S;
                    n.e(dVar, str4);
                    obj.label = 13;
                    return obj2;
                    gdVar = c.C1(obj.this$0);
                    gdVar.P.setVisibility(0);
                    this$08 = obj.this$0;
                    gdVar8 = c.C1(this$08);
                    view = gdVar8.U;
                    n.e(view, "binding.recordVideoCard");
                    obj.label = 14;
                    return obj2;
                    return w.a;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                case 11:
                    q.b(object);
                    this$010 = obj.this$0;
                    gdVar10 = c.C1(this$010);
                    view = gdVar10.Q;
                    n.e(view, "binding.fifthChat");
                    obj.label = 12;
                    return obj2;
                    this$04 = obj.this$0;
                    gdVar5 = c.C1(this$04);
                    view = gdVar5.X;
                    n.e(view, str6);
                    gdVar13 = c.C1(obj.this$0);
                    dVar = gdVar13.S;
                    n.e(dVar, str4);
                    obj.label = 13;
                    return obj2;
                    gdVar = c.C1(obj.this$0);
                    gdVar.P.setVisibility(0);
                    this$08 = obj.this$0;
                    gdVar8 = c.C1(this$08);
                    view = gdVar8.U;
                    n.e(view, "binding.recordVideoCard");
                    obj.label = 14;
                    return obj2;
                    return w.a;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                case 12:
                    q.b(object);
                    i3 = i5;
                    this$04 = obj.this$0;
                    gdVar5 = c.C1(this$04);
                    view = gdVar5.X;
                    n.e(view, str6);
                    gdVar13 = c.C1(obj.this$0);
                    dVar = gdVar13.S;
                    n.e(dVar, str4);
                    obj.label = 13;
                    return obj2;
                    gdVar = c.C1(obj.this$0);
                    gdVar.P.setVisibility(0);
                    this$08 = obj.this$0;
                    gdVar8 = c.C1(this$08);
                    view = gdVar8.U;
                    n.e(view, "binding.recordVideoCard");
                    obj.label = 14;
                    return obj2;
                    return w.a;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                case 13:
                    q.b(object);
                    i3 = i5;
                    gdVar = c.C1(obj.this$0);
                    gdVar.P.setVisibility(0);
                    this$08 = obj.this$0;
                    gdVar8 = c.C1(this$08);
                    view = gdVar8.U;
                    n.e(view, "binding.recordVideoCard");
                    obj.label = 14;
                    return obj2;
                    return w.a;
                    n.w(str8);
                    throw i18;
                    n.w(str8);
                    throw i18;
                case 14:
                    q.b(object);
                    return w.a;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw illegalStateException;
            }
            app.dogo.com.dogo_android.y.r.c this$03 = obj.this$0;
            gd gdVar4 = c.C1(this$03);
            if (gdVar4 == null) {
            } else {
                view = gdVar4.R;
                n.e(view, str5);
                obj.label = 2;
                if (c.T1(this$03, view, false, this, 2, 0) == obj2) {
                    return obj2;
                }
            }
            n.w(str8);
            throw i18;
        }
    }
    static {
        c.a aVar = new c.a(0);
        c.Companion = aVar;
    }

    public c() {
        super();
        c.g gVar = new c.g(this);
        c.d dVar = new c.d(this, 0, gVar);
        this.b = j.a(m.SYNCHRONIZED, dVar);
    }

    public static final Object B1(app.dogo.com.dogo_android.y.r.c c, View view2, View view3, d d4) {
        return c.G1(view2, view3, d4);
    }

    public static final gd C1(app.dogo.com.dogo_android.y.r.c c) {
        return c.a;
    }

    public static final app.dogo.com.dogo_android.y.r.d D1(app.dogo.com.dogo_android.y.r.c c) {
        return c.I1();
    }

    public static final void E1(app.dogo.com.dogo_android.y.r.c c, j j2) {
        c.L1(j2);
    }

    public static final Object F1(app.dogo.com.dogo_android.y.r.c c, View view2, boolean z3, d d4) {
        return c.S1(view2, z3, d4);
    }

    private final Object G1(View view, View view2, d<? super w> d3) {
        boolean bVar;
        int label2;
        int obj;
        int i7;
        int label;
        int i4;
        d i;
        int i5;
        int i6;
        int i3;
        int i2;
        int dimensionPixelSize;
        Object obj10;
        Object obj11;
        Object obj12;
        bVar = d3;
        label2 = bVar.label;
        i7 = Integer.MIN_VALUE;
        if (d3 instanceof c.b && label2 & i7 != 0) {
            bVar = d3;
            label2 = bVar.label;
            i7 = Integer.MIN_VALUE;
            if (label2 & i7 != 0) {
                bVar.label = label2 -= i7;
            } else {
                bVar = new c.b(this, d3);
            }
        } else {
        }
        obj12 = bVar.result;
        obj = b.d();
        label = bVar.label;
        i = 1;
        if (label != 0) {
            if (label != i) {
            } else {
                obj11 = obj10;
                obj10 = bVar.L$1;
                bVar = bVar.L$0;
                q.b(obj12);
                obj10.setVisibility(8);
                obj10 = new d();
                obj12 = bVar.a;
                obj = 0;
                label = "binding";
                if (obj12 == null) {
                } else {
                    obj10.g(obj12.T);
                    obj10 = new d();
                    obj12 = bVar.a;
                    if (obj12 == null) {
                    } else {
                        obj10.g(obj12.T);
                        obj11 = bVar.a;
                        if (obj11 == null) {
                        } else {
                            obj10.i(obj11.getId(), 3, obj11.W.getId(), 4, bVar.getResources().getDimensionPixelSize(2131165620));
                            obj11 = bVar.a;
                            if (obj11 == null) {
                            } else {
                                TransitionManager.beginDelayedTransition(obj11.T);
                                obj11 = bVar.a;
                                if (obj11 == null) {
                                } else {
                                    obj10.c(obj11.T);
                                    return w.a;
                                }
                                n.w(label);
                                throw obj;
                            }
                            n.w(label);
                            throw obj;
                        }
                        n.w(label);
                        throw obj;
                    }
                    n.w(label);
                    throw obj;
                }
                n.w(label);
                throw obj;
            }
            obj10 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj10;
        }
        q.b(obj12);
        view.startAnimation(AnimationUtils.loadAnimation(requireContext(), 2130772006));
        bVar.L$0 = this;
        bVar.L$1 = view;
        bVar.L$2 = view2;
        bVar.label = i;
        if (H1() && x0.a(400, obj5) == obj) {
            view.startAnimation(AnimationUtils.loadAnimation(requireContext(), 2130772006));
            bVar.L$0 = this;
            bVar.L$1 = view;
            bVar.L$2 = view2;
            bVar.label = i;
            if (x0.a(400, obj5) == obj) {
                return obj;
            }
            bVar = this;
        }
    }

    private final boolean H1() {
        int i;
        int heightPixels;
        long l;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        requireActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i3 = 1800;
        if (displayMetrics.heightPixels > i3) {
            if (Double.compare(d2, l) > 0) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private final app.dogo.com.dogo_android.y.r.d I1() {
        return (d)k1.a(this);
    }

    private final app.dogo.com.dogo_android.y.r.e J1() {
        return (e)this.b.getValue();
    }

    private final void K1() {
        String fragmentReturnTag2;
        androidx.fragment.app.e activity;
        String fragmentReturnTag;
        j jVar;
        int i4;
        int i3;
        int i;
        String str;
        int i5;
        int i6;
        int i2;
        jVar = I1().b();
        if (jVar == null) {
            fragmentReturnTag2 = 0;
        } else {
            fragmentReturnTag2 = jVar.getTag();
        }
        if (fragmentReturnTag2 == null) {
            fragmentReturnTag2 = I1().getFragmentReturnTag();
        }
        if (jVar != null) {
            activity = getActivity();
            if (activity == null) {
            } else {
                g1.f(activity, I1().getFragmentReturnTag(), jVar, false, 4, 0);
            }
        }
        androidx.fragment.app.e activity2 = getActivity();
        if (activity2 == null) {
        } else {
            super(I1().f(), fragmentReturnTag2, "lesson_exam_unlocked", 0, 8, 0);
            g1.n(activity2, fragmentReturnTag);
        }
    }

    private final void L1(j j) {
        app.dogo.com.dogo_android.y.r.d activity;
        androidx.fragment.app.e activity2;
        String fragmentReturnTag;
        j jVar;
        int i;
        int i2;
        int i3;
        if (I1().a()) {
            activity2 = getActivity();
            if (activity2 == null) {
            } else {
                g1.f(activity2, I1().getFragmentReturnTag(), j, false, 4, 0);
            }
        } else {
            activity = getActivity();
            if (activity == null) {
            } else {
                g1.n(activity, j);
            }
        }
    }

    public static void M1(app.dogo.com.dogo_android.y.r.c c, View view2) {
        c.O1(c, view2);
    }

    public static void N1(app.dogo.com.dogo_android.y.r.c c, View view2) {
        c.P1(c, view2);
    }

    private static final void O1(app.dogo.com.dogo_android.y.r.c c, View view2) {
        n.f(c, "this$0");
        final androidx.fragment.app.e obj0 = c.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void P1(app.dogo.com.dogo_android.y.r.c c, View view2) {
        n.f(c, "this$0");
        c.J1().i();
        c.Q1();
    }

    private final void Q1() {
        app.dogo.com.dogo_android.model.Exam exam;
        app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo;
        final androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            g1.s0(activity, J1().h(), I1().f());
        }
    }

    private final void R1() {
        final int i = 0;
        c.e eVar = new c.e(this, i);
        k.d(r.a(this), i, 0, eVar, 3, 0);
    }

    private final Object S1(View view, boolean z2, d<? super w> d3) {
        boolean fVar;
        int label2;
        int i;
        int label;
        int i3;
        int i2;
        Object obj10;
        boolean obj11;
        Object obj12;
        fVar = d3;
        label2 = fVar.label;
        i = Integer.MIN_VALUE;
        if (d3 instanceof c.f && label2 & i != 0) {
            fVar = d3;
            label2 = fVar.label;
            i = Integer.MIN_VALUE;
            if (label2 & i != 0) {
                fVar.label = label2 -= i;
            } else {
                fVar = new c.f(this, d3);
            }
        } else {
        }
        obj12 = fVar.result;
        Object obj = b.d();
        label = fVar.label;
        int i5 = 0;
        final String str = "binding";
        final int i6 = 0;
        final int i7 = 1;
        if (label != 0) {
            if (label != i7) {
            } else {
                obj11 = fVar.Z$0;
                obj10 = fVar.L$0;
                q.b(obj12);
                if (obj11 == null) {
                    obj10 = obj10.a;
                    if (obj10 == null) {
                    } else {
                        obj10.O.setVisibility(i6);
                    }
                    n.w(str);
                    throw i5;
                }
                return w.a;
            }
            obj10 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj10;
        }
        q.b(obj12);
        obj12 = this.a;
        if (obj12 == null) {
        } else {
            obj12.O.setVisibility(8);
            view.startAnimation(AnimationUtils.loadAnimation(requireContext(), 2130772003));
            view.setVisibility(i6);
            fVar.L$0 = this;
            fVar.Z$0 = z2;
            fVar.label = i7;
            if (x0.a(400, obj8) == obj) {
                return obj;
            }
            obj10 = this;
        }
        n.w(str);
        throw i5;
    }

    static Object T1(app.dogo.com.dogo_android.y.r.c c, View view2, boolean z3, d d4, int i5, Object object6) {
        int obj2;
        if (i5 &= 2 != 0) {
            obj2 = 0;
        }
        return c.S1(view2, obj2, d4);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent3) {
        int obj1;
        super.onActivityResult(i, i2, intent3);
        if (i == 11102) {
            if (i2 == -1) {
                K1();
            } else {
                obj1 = getActivity();
                if (obj1 == null) {
                } else {
                    obj1.onBackPressed();
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        androidx.fragment.app.e activity;
        n.f(context, "context");
        if (activity instanceof a0) {
        } else {
            activity = 0;
        }
        if (activity == null) {
        } else {
            activity.F();
        }
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        gd obj2 = gd.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.W(J1());
            obj2 = this.a;
            if (obj2 == null) {
            } else {
                obj2.M(getViewLifecycleOwner());
                obj2 = this.a;
                if (obj2 == null) {
                } else {
                    obj2.V(I1().g());
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
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        n.e(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
        c.c cVar = new c.c(this);
        e.b(onBackPressedDispatcher, getViewLifecycleOwner(), false, cVar, 2, 0);
        gd obj7 = this.a;
        int obj8 = 0;
        String str2 = "binding";
        if (obj7 == null) {
        } else {
            a aVar = new a(this);
            obj7.P.setOnClickListener(aVar);
            obj7 = this.a;
            if (obj7 == null) {
            } else {
                obj8 = new b(this);
                obj7.U.setOnClickListener(obj8);
                R1();
            }
            n.w(str2);
            throw obj8;
        }
        n.w(str2);
        throw obj8;
    }
}
