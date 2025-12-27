package app.dogo.com.dogo_android.y.r;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
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
import androidx.activity.e;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import androidx.lifecycle.r;
import app.dogo.com.dogo_android.h.gd;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import kotlin.Metadata;
import kotlin.b0.k.a.f;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.h;
import kotlin.m;
import kotlin.q;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.x0;

/* compiled from: FirstExamUnlockedFragment.kt */
@Metadata(d1 = "\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\u0018\u0000 32\u00020\u0001:\u00013B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0008\u0010\u0015\u001a\u00020\u0016H\u0002J\u0008\u0010\u0017\u001a\u00020\u0010H\u0002J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\"\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0016J$\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&2\u0008\u0010'\u001a\u0004\u0018\u00010(2\u0008\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001a\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00122\u0008\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0008\u0010-\u001a\u00020\u0010H\u0002J\u0008\u0010.\u001a\u00020\u0010H\u0002J#\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u00122\u0008\u0008\u0002\u00101\u001a\u00020\u0016H\u0082@ø\u0001\u0000¢\u0006\u0002\u00102R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000c\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u00064", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/firstexamunlocked/FirstExamUnlockedFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentFirstExamUnlcokedBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/firstexamunlocked/FirstExamUnlockedScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/firstexamunlocked/FirstExamUnlockedScreen;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/firstexamunlocked/FirstExamUnlockedViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/firstexamunlocked/FirstExamUnlockedViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "animateChatMessageHiding", "", "itemToRemove", "Landroid/view/View;", "newTopItem", "(Landroid/view/View;Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkIfChatShouldBeCondensed", "", "goToExamList", "goToNextScreen", "appScreen", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "recordVideo", "startChatAnimation", "startFadeInAnimation", "animatedItem", "lastItemLoaded", "(Landroid/view/View;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c, reason: from kotlin metadata */
public final class FirstExamUnlockedFragment extends Fragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final c.a INSTANCE = new c$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private gd binding;
    private final h b;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0006\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/firstexamunlocked/FirstExamUnlockedFragment$Companion;", "", "()V", "FONT_SIZE_LIMIT", "", "FONT_SIZE_THRESHOLD", "SCREEN_HEIGHT_THRESHOLD", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(kotlin.d0.d.g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.firstexamunlocked.FirstExamUnlockedFragment", f = "FirstExamUnlockedFragment.kt", l = 130, m = "animateChatMessageHiding")
    static final class b extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        b(kotlin.b0.d<? super c.b> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            View view = null;
            return c.this.onActivityResult(view, view, this);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends kotlin.d0.d.p implements l<androidx.activity.d, kotlin.w> {
        @Override // kotlin.d0.d.p
        public final void a(androidx.activity.d dVar) {
            n.f(dVar, "$this$addCallback");
            app.dogo.com.dogo_android.y.j jVar = c.this.I1().b();
            if (jVar != null) {
                c.this.L1(jVar);
            } else {
                androidx.fragment.app.e activity = c.this.getActivity();
                if (activity != null) {
                    app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragmentSmooth(activity);
                }
            }
        }

        c() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends kotlin.d0.d.p implements kotlin.d0.c.a<e> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final e invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(FirstExamUnlockedViewModel.class), this.$parameters);
        }

        public d(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.firstexamunlocked.FirstExamUnlockedFragment", f = "FirstExamUnlockedFragment.kt", l = 116, m = "startFadeInAnimation")
    static final class f extends kotlin.b0.k.a.d {

        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        f(kotlin.b0.d<? super c.f> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return c.this.onCreateView(0, 0, this);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends kotlin.d0.d.p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            Object[] arr = new Object[2];
            return org.koin.core.parameter.b.b(new Object[] { c.this.I1().g(), c.this.I1().e() });
        }

        g() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.firstexamunlocked.FirstExamUnlockedFragment$startChatAnimation$1", f = "FirstExamUnlockedFragment.kt", l = {91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 105}, m = "invokeSuspend")
    static final class e extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, kotlin.b0.d<? super kotlin.w>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            TextView textView;
            TextView textView3;
            TextView textView5;
            TextView textView8;
            TextView textView9;
            int i = 1;
            TextView textView10;
            boolean z5;
            boolean z3 = false;
            boolean z4 = false;
            int i2 = 10;
            int i3 = 7;
            kotlin.b0.d dVar;
            int i5;
            int i6 = 2;
            int i8 = 13;
            int i7 = 2;
            int i9 = 2;
            Object obj10 = null;
            Object obj11;
            int i10;
            final Object object2 = this;
            final Object obj19 = b.d();
            final String str4 = "binding.fourthChat";
            final String str5 = "binding.firstChat";
            final int i22 = 1500;
            final String str6 = "binding.thirdChat";
            final String str7 = "binding.secondChat";
            final int i23 = 3000;
            i = 1;
            final int i24 = 0;
            final String str8 = "binding";
            switch (object2.label) {
                case 0:
                    q.b(object);
                    object2.label = i;
                    return obj19;
                case 1:
                    q.b(object);
                    break;
                case 2:
                    q.b(object);
                    object2.label = 3;
                    return obj19;
                case 3:
                    q.b(object);
                    gd goToNextScreen6 = object2.this$0.binding;
                    n.e(goToNextScreen6.V, str7);
                    z4 = false;
                    i9 = 2;
                    object2.label = 4;
                    return obj19;
                case 4:
                    q.b(object);
                    object2.label = 5;
                    return obj19;
                case 5:
                    q.b(object);
                    gd goToNextScreen7 = object2.this$0.binding;
                    n.e(goToNextScreen7.X, str6);
                    boolean z = false;
                    i6 = 2;
                    object2.label = 6;
                    return obj19;
                case 6:
                    q.b(object);
                    gd goToNextScreen2 = object2.this$0.binding;
                    n.e(goToNextScreen2.R, str5);
                    gd goToNextScreen11 = object2.this$0.binding;
                    n.e(goToNextScreen11.V, str7);
                    i3 = 7;
                    object2.label = 7;
                    return obj19;
                case 7:
                    q.b(object);
                    object2.label = 8;
                    return obj19;
                case 8:
                    q.b(object);
                    gd goToNextScreen3 = object2.this$0.binding;
                    n.e(goToNextScreen3.S, str4);
                    boolean z2 = false;
                    i5 = 2;
                    obj10 = null;
                    object2.label = 9;
                    return obj19;
                case 9:
                    q.b(object);
                    gd goToNextScreen9 = object2.this$0.binding;
                    n.e(goToNextScreen9.V, str7);
                    gd goToNextScreen12 = object2.this$0.binding;
                    n.e(goToNextScreen12.X, str6);
                    i2 = 10;
                    object2.label = 10;
                    return obj19;
                case 10:
                    q.b(object);
                    object2.label = 11;
                    return obj19;
                case 11:
                    q.b(object);
                    gd goToNextScreen10 = object2.this$0.binding;
                    n.e(goToNextScreen10.Q, "binding.fifthChat");
                    object2.label = 12;
                    return obj19;
                case 12:
                    q.b(object);
                    gd goToNextScreen5 = object2.this$0.binding;
                    n.e(goToNextScreen5.X, str6);
                    gd goToNextScreen13 = object2.this$0.binding;
                    n.e(goToNextScreen13.S, str4);
                    i8 = 13;
                    object2.label = 13;
                    return obj19;
                case 13:
                    q.b(object);
                    gd goToNextScreen = object2.this$0.binding;
                    goToNextScreen.P.setVisibility(0);
                    gd goToNextScreen8 = object2.this$0.binding;
                    n.e(goToNextScreen8.U, "binding.recordVideoCard");
                    int i4 = 14;
                    object2.label = 14;
                    return obj19;
                case 14:
                    q.b(object);
                    return w.a;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            gd goToNextScreen4 = object2.this$0.binding;
            if (goToNextScreen4 == null) {
                n.w(str8);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i24;
            } else {
                n.e(goToNextScreen4.R, str5);
                z3 = false;
                i7 = 2;
                i10 = 0;
                object2.label = 2;
                if (FirstExamUnlockedFragment.T1(object2.this$0, goToNextScreen4.R, z3, this, i7, i10) == obj19) {
                    return obj19;
                }
            }
        }

        e(kotlin.b0.d<? super c.e> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super kotlin.w> dVar) {
            return (app.dogo.com.dogo_android.trainingprogram.firstexamunlocked.c.e)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<kotlin.w> create(Object object, kotlin.b0.d<?> dVar) {
            return new app.dogo.com.dogo_android.trainingprogram.firstexamunlocked.c.e(c.this, dVar);
        }
    }

    public c() {
        super();
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.trainingprogram.firstexamunlocked.c.d(this, null, new app.dogo.com.dogo_android.trainingprogram.firstexamunlocked.c.g(this)));
    }

    public static final /* synthetic */ Object B1(c cVar, View view, View view2, kotlin.b0.d dVar) {
        return cVar.onActivityResult(view, view2, dVar);
    }

    /* renamed from: C1, reason: from kotlin metadata */
    public static final /* synthetic */ gd goToNextScreen(c appScreen) {
        return appScreen.binding;
    }

    /* renamed from: D1, reason: from kotlin metadata */
    public static final /* synthetic */ d onAttach(c context) {
        return context.I1();
    }

    /* renamed from: E1, reason: from kotlin metadata */
    /* suspend */ public static final /* synthetic */ void animateChatMessageHiding(c itemToRemove, app.dogo.com.dogo_android.y.j newTopItem) {
        itemToRemove.L1(newTopItem);
    }

    public static final /* synthetic */ Object F1(c cVar, View view, boolean z, kotlin.b0.d dVar) {
        return cVar.onCreateView(view, z, dVar);
    }

    /* renamed from: G1, reason: from kotlin metadata */
    private final Object onActivityResult(View requestCode, View resultCode, kotlin.b0.d<? super kotlin.w> data) throws android.content.res.Resources.NotFoundException {
        Object data2;
        int label2;
        int i2 = -2147483648;
        int i3;
        Object obj;
        Object requestCode3;
        z = data instanceof app.dogo.com.dogo_android.trainingprogram.firstexamunlocked.c.b;
        if (data instanceof app.dogo.com.dogo_android.trainingprogram.firstexamunlocked.c.b) {
            data2 = data;
            i2 = Integer.MIN_VALUE;
            i3 = label2 & i2;
            if (label2 & i2 != 0) {
                data2.label -= i2;
            } else {
                app.dogo.com.dogo_android.y.r.c.b bVar = new app.dogo.com.dogo_android.trainingprogram.firstexamunlocked.c.b(this, data);
            }
        }
        Object obj2 = b.d();
        int i10 = 1;
        if (data2.label != 0) {
            if (data2.label != i10) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(data2.result);
                obj.setVisibility(8);
                int i = 0;
                str = "binding";
                if (data2.binding == null) {
                    n.w(str);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    new d().g(binding24.T);
                    androidx.constraintlayout.widget.d requestCode2 = new d();
                    if (data2.binding == null) {
                        n.w(str);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        requestCode2.g(binding25.T);
                        int i6 = 3;
                        if (data2.binding == null) {
                            n.w(str);
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) i;
                        } else {
                            int i8 = 4;
                            int i9 = 2131165620;
                            requestCode2.i(requestCode3.getId(), 3, binding2.W.getId(), i8, data2.getResources().getDimensionPixelSize(i9));
                            if (data2.binding == null) {
                                n.w(str);
                                /* Dexterity WARN: Type inference failed for thrown value */
                                throw (Throwable) i;
                            } else {
                                TransitionManager.beginDelayedTransition(binding22.T);
                                if (data2.binding == null) {
                                    n.w(str);
                                    /* Dexterity WARN: Type inference failed for thrown value */
                                    throw (Throwable) i;
                                } else {
                                    requestCode2.c(binding23.T);
                                    return w.a;
                                }
                            }
                        }
                    }
                }
            }
        }
        q.b(data2.result);
        if (checkIfChatShouldBeCondensed()) {
            int label22 = 2130772006;
            requestCode.startAnimation(AnimationUtils.loadAnimation(requireContext(), label22));
            int i4 = 400;
            data2.L$0 = this;
            data2.L$1 = requestCode;
            data2.L$2 = resultCode;
            data2.label = i10;
            if (kotlinx.coroutines.internal.x0.a(i4, data2) == obj2) {
                return obj2;
            }
            app.dogo.com.dogo_android.y.r.c requestCode4 = this;
        }
    }

    /* renamed from: H1, reason: from kotlin metadata */
    private final boolean checkIfChatShouldBeCondensed() {
        boolean z = false;
        double d = 4591870180066957722L;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        requireActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i3 = 1800;
        if (displayMetrics.heightPixels > i3) {
            double abs = Math.abs((double)getResources().getConfiguration().fontScale - 1.1d);
            d = 0.1d;
            if (abs > 0.1d) {
                int i2 = 1;
            } else {
                int i = 0;
            }
        }
        return z;
    }

    private final d I1() {
        return (FirstExamUnlockedScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final e J1() {
        return (FirstExamUnlockedViewModel)this.b.getValue();
    }

    private final void K1() {
        String fragmentReturnTag = null;
        String fragmentReturnTag2;
        boolean z = false;
        int i = 4;
        Object obj = null;
        app.dogo.com.dogo_android.y.j jVar = I1().b();
        if (jVar == null) {
            int i3 = 0;
        } else {
            fragmentReturnTag = jVar.getTag();
        }
        if (fragmentReturnTag == null) {
            fragmentReturnTag = I1().getFragmentReturnTag();
        }
        if (jVar != null) {
            androidx.fragment.app.e activity = getActivity();
            if (activity != null) {
                z = false;
                i = 4;
                obj = null;
                app.dogo.com.dogo_android.util.extensionfunction.g1.f(activity, I1().getFragmentReturnTag(), jVar, z, i, obj);
            }
        }
        androidx.fragment.app.e activity2 = getActivity();
        if (activity2 != null) {
            boolean z2 = false;
            int i2 = 8;
            kotlin.d0.d.g gVar = null;
            str = "lesson_exam_unlocked";
            LessonExamListScreen lessonExamListScreen = new LessonExamListScreen(I1().f(), fragmentReturnTag, str, z2, i2, gVar);
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity2, lessonExamListScreen);
        }
    }

    private final void L1(app.dogo.com.dogo_android.y.j jVar) {
        if (I1().a()) {
            androidx.fragment.app.e activity = getActivity();
            if (activity != null) {
                boolean z = false;
                int i = 4;
                Object obj = null;
                app.dogo.com.dogo_android.util.extensionfunction.g1.f(activity, I1().getFragmentReturnTag(), jVar, z, i, obj);
            }
        } else {
            androidx.fragment.app.e activity2 = getActivity();
            if (activity2 != null) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity2, jVar);
            }
        }
    }

    private static final void O1(c cVar, View view) {
        n.f(cVar, "this$0");
        final androidx.fragment.app.e activity = cVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void P1(c cVar, View view) {
        n.f(cVar, "this$0");
        cVar.J1().i();
        cVar.Q1();
    }

    private final void Q1() {
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.s0(activity, J1().getExam(), I1().f());
        }
    }

    private final void R1() {
        final kotlin.b0.d dVar = null;
        kotlinx.coroutines.internal.k.d(r.a(this), dVar, null, new app.dogo.com.dogo_android.trainingprogram.firstexamunlocked.c.e(this, dVar), 3, null);
    }

    /* renamed from: S1, reason: from kotlin metadata */
    private final Object onCreateView(View inflater, boolean container, kotlin.b0.d<? super kotlin.w> savedInstanceState) throws android.content.res.Resources.NotFoundException {
        Object savedInstanceState2;
        int label2;
        int i = -2147483648;
        int i2;
        Object obj;
        boolean z2;
        z = savedInstanceState instanceof app.dogo.com.dogo_android.trainingprogram.firstexamunlocked.c.f;
        if (savedInstanceState instanceof app.dogo.com.dogo_android.trainingprogram.firstexamunlocked.c.f) {
            savedInstanceState2 = savedInstanceState;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                savedInstanceState2.label -= i;
            } else {
                app.dogo.com.dogo_android.y.r.c.f fVar = new app.dogo.com.dogo_android.trainingprogram.firstexamunlocked.c.f(this, savedInstanceState);
            }
        }
        Object obj2 = b.d();
        int i5 = 0;
        final String str = "binding";
        final int i6 = 0;
        final int i7 = 1;
        if (savedInstanceState2.label != 0) {
            if (savedInstanceState2.label != i7) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(savedInstanceState2.result);
                if (!savedInstanceState2.Z$0 && obj.binding != null) {
                    binding2.O.setVisibility(i6);
                }
                return w.a;
            }
        }
        q.b(savedInstanceState2.result);
        if (this.binding == null) {
            n.w(str);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i5;
        } else {
            binding22.O.setVisibility(8);
            int label22 = 2130772003;
            inflater.startAnimation(AnimationUtils.loadAnimation(requireContext(), label22));
            inflater.setVisibility(i6);
            int i3 = 400;
            savedInstanceState2.L$0 = this;
            savedInstanceState2.Z$0 = container;
            savedInstanceState2.label = i7;
            if (kotlinx.coroutines.internal.x0.a(i3, savedInstanceState2) == obj2) {
                return obj2;
            }
            app.dogo.com.dogo_android.y.r.c inflater2 = this;
        }
    }

    static /* synthetic */ Object T1(c cVar, View view, boolean z, kotlin.b0.d dVar, int i, Object object) {
        if (i & 2 != 0) {
            i = 0;
        }
        return cVar.onCreateView(view, z, dVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 11102 && i2 == -1) {
            K1();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        androidx.fragment.app.e activity = null;
        n.f(context, "context");
        Navigator r0 = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : 0;
        if (activity != null) {
            activity.F();
        }
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        n.f(layoutInflater, "inflater");
        gd gdVar = gd.T(layoutInflater, viewGroup, false);
        n.e(gdVar, "inflate(inflater, container, false)");
        this.binding = gdVar;
        int i = 0;
        String str4 = "binding";
        if (gdVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            gdVar.W(J1());
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
                    this.binding.V(I1().g());
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
    public void onViewCreated(View view, Bundle bundle) throws b {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        n.e(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
        e.b(onBackPressedDispatcher, getViewLifecycleOwner(), false, new app.dogo.com.dogo_android.trainingprogram.firstexamunlocked.c.c(this), 2, null);
        int i4 = 0;
        String str2 = "binding";
        if (this.binding == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i4;
        } else {
            binding2.P.setOnClickListener(new app.dogo.com.dogo_android.trainingprogram.firstexamunlocked.a(this));
            if (this.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i4;
            } else {
                binding22.U.setOnClickListener(new app.dogo.com.dogo_android.trainingprogram.firstexamunlocked.b(this));
                R1();
                return;
            }
        }
    }

    /* renamed from: M1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(c view, View savedInstanceState) {
        FirstExamUnlockedFragment.O1(view, savedInstanceState);
    }

    /* renamed from: N1, reason: from kotlin metadata */
    /* suspend */ public static /* synthetic */ void startFadeInAnimation(c animatedItem, View lastItemLoaded) {
        FirstExamUnlockedFragment.P1(animatedItem, lastItemLoaded);
    }
}
