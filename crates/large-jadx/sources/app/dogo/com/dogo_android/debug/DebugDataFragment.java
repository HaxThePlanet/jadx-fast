package app.dogo.com.dogo_android.i;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.c.a;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.a7;
import app.dogo.com.dogo_android.h.ab;
import app.dogo.com.dogo_android.h.y6;
import app.dogo.com.dogo_android.r.k;
import app.dogo.com.dogo_android.repository.domain.InAppMessageDataHolder;
import app.dogo.com.dogo_android.repository.domain.ProgramQuestion;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay.StreakStatus;
import app.dogo.com.dogo_android.service.q2.a;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.y.b0.d;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.w;

/* compiled from: DebugDataFragment.kt */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J$\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0008\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u00102\u0008\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0008\u0010%\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006&", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugDataFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDebugDataDialogBinding;", "screenKey", "Lapp/dogo/com/dogo_android/debug/DebugDataScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/debug/DebugDataScreen;", "viewModel", "Lapp/dogo/com/dogo_android/debug/DebugDataFragmentViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/debug/DebugDataFragmentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "buildSimpleButtonView", "Landroid/view/View;", "buttonText", "", "labelText", "listener", "Landroid/view/View$OnClickListener;", "buildSimpleTextView", "text", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupUserInfoList", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g0, reason: from kotlin metadata */
public final class DebugDataFragment extends Fragment {

    /* renamed from: a, reason: from kotlin metadata */
    private final kotlin.h binding;
    private ab b;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends kotlin.d0.d.p implements l<String, w> {
        @Override // kotlin.d0.d.p
        public final void a(String str) {
            n.f(str, "it");
            try {
                g0.this.F1().saveCoupon(Long.parseLong(str), "red");
            } catch (Exception unused) {
                str = g0.this.getActivity();
            }
        }

        a() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends kotlin.d0.d.p implements l<String, w> {
        @Override // kotlin.d0.d.p
        public final void a(String str) {
            n.f(str, "it");
            try {
                g0.this.F1().saveCoupon(Long.parseLong(str), "pink");
            } catch (Exception unused) {
                str = g0.this.getActivity();
            }
        }

        b() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends kotlin.d0.d.p implements kotlin.d0.c.a<h0> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final h0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(DebugDataFragmentViewModel.class), this.$parameters);
        }

        public c(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }
    public g0() {
        super();
        final m.a.c.j.a aVar = null;
        this.binding = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.debug.g0.c(this, aVar, aVar));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ h0 buildSimpleTextView(g0 text) {
        return text.F1();
    }

    /* renamed from: C1, reason: from kotlin metadata */
    private final View buildSimpleButtonView(String buttonText, String labelText, View.OnClickListener listener) {
        y6 y6Var = y6.T(getLayoutInflater());
        n.e(y6Var, "inflate(layoutInflater)");
        y6Var.O.setText(buttonText);
        y6Var.P.setText(labelText);
        y6Var.O.setOnClickListener(listener);
        View view = y6Var.w();
        n.e(view, "binding.root");
        return view;
    }

    /* renamed from: D1, reason: from kotlin metadata */
    private final View onAttach(String context) {
        a7 a7Var = a7.T(getLayoutInflater());
        n.e(a7Var, "inflate(layoutInflater)");
        a7Var.O.setText(context);
        a7Var.O.setTextIsSelectable(true);
        View view = a7Var.w();
        n.e(view, "binding.root");
        return view;
    }

    /* renamed from: E1, reason: from kotlin metadata */
    private final i0 setupUserInfoList() {
        return (DebugDataScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final h0 F1() {
        return (DebugDataFragmentViewModel)this.binding.getValue();
    }

    private static final void c2(g0 g0Var, Boolean boolean) {
        n.f(g0Var, "this$0");
        g0Var.e2();
    }

    private static final void d2(g0 g0Var, View view) {
        n.f(g0Var, "this$0");
        g0Var.requireActivity().getSupportFragmentManager().Z0();
    }

    private final void e2() {
        final int i = 0;
        final String str3 = "binding";
        if (this.b == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            abVar.O.removeAllViews();
            if (this.b == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                str2 = "";
                abVar2.O.addView(buildSimpleButtonView("Feature Enabler", str2, new app.dogo.com.dogo_android.debug.s(this)));
                if (this.b == null) {
                    n.w(str3);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    abVar3.O.addView(buildSimpleButtonView("Time metrics not achieved", str2, new app.dogo.com.dogo_android.debug.i(this)));
                    if (this.b == null) {
                        n.w(str3);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        abVar4.O.addView(buildSimpleButtonView("Force User-Premium", n.o("User premium is : ", Boolean.valueOf(F1().p())), new app.dogo.com.dogo_android.debug.n(this)));
                        if (this.b == null) {
                            n.w(str3);
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) i;
                        } else {
                            abVar5.O.addView(buildSimpleButtonView("Force User-dog-premium", n.o("User dog premium is : ", Boolean.valueOf(F1().o())), new app.dogo.com.dogo_android.debug.p(this)));
                            if (this.b == null) {
                                n.w(str3);
                                /* Dexterity WARN: Type inference failed for thrown value */
                                throw (Throwable) i;
                            } else {
                                abVar6.O.addView(buildSimpleButtonView("Force User-resubscribe", n.o("User resubscribe is : ", Boolean.valueOf(F1().q())), new app.dogo.com.dogo_android.debug.o(this)));
                                if (this.b == null) {
                                    n.w(str3);
                                    /* Dexterity WARN: Type inference failed for thrown value */
                                    throw (Throwable) i;
                                } else {
                                    abVar7.O.addView(buildSimpleButtonView("Toggle-Ambassador", n.o("Ambassador is : ", Boolean.valueOf(F1().n())), new app.dogo.com.dogo_android.debug.q(this)));
                                    if (this.b == null) {
                                        n.w(str3);
                                        /* Dexterity WARN: Type inference failed for thrown value */
                                        throw (Throwable) i;
                                    } else {
                                        abVar8.O.addView(buildSimpleButtonView("CameraX", str2, new app.dogo.com.dogo_android.debug.f(this)));
                                        if (this.b == null) {
                                            n.w(str3);
                                            /* Dexterity WARN: Type inference failed for thrown value */
                                            throw (Throwable) i;
                                        } else {
                                            abVar9.O.addView(buildSimpleButtonView("Lesson introduction", str2, new app.dogo.com.dogo_android.debug.j(this)));
                                            if (this.b == null) {
                                                n.w(str3);
                                                /* Dexterity WARN: Type inference failed for thrown value */
                                                throw (Throwable) i;
                                            } else {
                                                abVar10.O.addView(buildSimpleButtonView("Start inAppFeedBack", str2, new app.dogo.com.dogo_android.debug.b(this)));
                                                if (this.b == null) {
                                                    n.w(str3);
                                                    /* Dexterity WARN: Type inference failed for thrown value */
                                                    throw (Throwable) i;
                                                } else {
                                                    abVar11.O.addView(buildSimpleButtonView("In app review", str2, new app.dogo.com.dogo_android.debug.t(this)));
                                                    if (this.b == null) {
                                                        n.w(str3);
                                                        /* Dexterity WARN: Type inference failed for thrown value */
                                                        throw (Throwable) i;
                                                    } else {
                                                        abVar12.O.addView(buildSimpleButtonView("Restart App", str2, new app.dogo.com.dogo_android.debug.h(this)));
                                                        if (this.b == null) {
                                                            n.w(str3);
                                                            /* Dexterity WARN: Type inference failed for thrown value */
                                                            throw (Throwable) i;
                                                        } else {
                                                            abVar13.O.addView(buildSimpleButtonView("Reset used coupons", str2, new app.dogo.com.dogo_android.debug.d(this)));
                                                            if (this.b == null) {
                                                                n.w(str3);
                                                                /* Dexterity WARN: Type inference failed for thrown value */
                                                                throw (Throwable) i;
                                                            } else {
                                                                abVar14.O.addView(buildSimpleButtonView("Set first open source", str2, new app.dogo.com.dogo_android.debug.g(this)));
                                                                if (this.b == null) {
                                                                    n.w(str3);
                                                                    /* Dexterity WARN: Type inference failed for thrown value */
                                                                    throw (Throwable) i;
                                                                } else {
                                                                    abVar15.O.addView(buildSimpleButtonView("ClearDebugOverrides", str2, new app.dogo.com.dogo_android.debug.c(this)));
                                                                    if (this.b == null) {
                                                                        n.w(str3);
                                                                        /* Dexterity WARN: Type inference failed for thrown value */
                                                                        throw (Throwable) i;
                                                                    } else {
                                                                        abVar16.O.addView(buildSimpleButtonView("Mock question explanation html", str2, new app.dogo.com.dogo_android.debug.e(this)));
                                                                        if (this.b == null) {
                                                                            n.w(str3);
                                                                            /* Dexterity WARN: Type inference failed for thrown value */
                                                                            throw (Throwable) i;
                                                                        } else {
                                                                            abVar17.O.addView(buildSimpleButtonView("AddChristmasCoupon", str2, new app.dogo.com.dogo_android.debug.u(this)));
                                                                            if (this.b == null) {
                                                                                n.w(str3);
                                                                                /* Dexterity WARN: Type inference failed for thrown value */
                                                                                throw (Throwable) i;
                                                                            } else {
                                                                                abVar18.O.addView(buildSimpleButtonView("AddNewYearsCoupon", str2, new app.dogo.com.dogo_android.debug.k(this)));
                                                                                if (this.b == null) {
                                                                                    n.w(str3);
                                                                                    /* Dexterity WARN: Type inference failed for thrown value */
                                                                                    throw (Throwable) i;
                                                                                } else {
                                                                                    abVar19.O.addView(buildSimpleButtonView("NoTimeReminder", str2, new app.dogo.com.dogo_android.debug.a(this)));
                                                                                    if (this.b == null) {
                                                                                        n.w(str3);
                                                                                        /* Dexterity WARN: Type inference failed for thrown value */
                                                                                        throw (Throwable) i;
                                                                                    } else {
                                                                                        str = "TestStreakComplete";
                                                                                        abVar20.O.addView(buildSimpleButtonView(str, str2, new app.dogo.com.dogo_android.debug.r(this)));
                                                                                        Iterator it = F1().m().entrySet().iterator();
                                                                                        while (it.hasNext()) {
                                                                                            Object item = it.next();
                                                                                            Object key = item.getKey();
                                                                                            Object value = item.getValue();
                                                                                            if (this.b == null) {
                                                                                                n.w(str3);
                                                                                                /* Dexterity WARN: Type inference failed for thrown value */
                                                                                                throw (Throwable) i;
                                                                                            }
                                                                                        }
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
    }

    private static final void f2(g0 g0Var, View view) {
        n.f(g0Var, "this$0");
        e activity = g0Var.getActivity();
        if (activity != null) {
            String string2 = g0Var.getString(2131886762);
            n.e(string2, "getString(R.string.in_app_rate_us_text)");
            String string = g0Var.getString(2131886759);
            n.e(string, "getString(R.string.in_app_nps_score_subheader)");
            app.dogo.com.dogo_android.repository.domain.InAppFeedbackExtras inAppFeedbackExtras = null;
            app.dogo.com.dogo_android.repository.domain.ExamHistorySaveInfo examHistorySaveInfo = null;
            int i = 6;
            kotlin.d0.d.g gVar = null;
            InAppOneTenScreen inAppOneTenScreen = new InAppOneTenScreen(new InAppMessageDataHolder(string2, string, "1", "Name"), inAppFeedbackExtras, examHistorySaveInfo, i, gVar);
            app.dogo.com.dogo_android.util.extensionfunction.g1.showEntryReportDialog(activity, inAppOneTenScreen);
        }
    }

    private static final void g2(g0 g0Var, View view) {
        n.f(g0Var, "this$0");
        final e requireActivity = g0Var.requireActivity();
        n.e(requireActivity, "requireActivity()");
        app.dogo.com.dogo_android.util.extensionfunction.g1.showEntryReportDialog(requireActivity, new RatePromptV2Screen(RateItService_RateSource.UNDEFINED.getTag()));
    }

    private static final void h2(g0 g0Var, View view) {
        n.f(g0Var, "this$0");
        g0Var.requireActivity().finish();
        g0Var.requireActivity().startActivity(new Intent(g0Var.requireContext(), SplashActivity.class));
    }

    private static final void i2(g0 g0Var, View view) {
        n.f(g0Var, "this$0");
        g0Var.F1().r();
    }

    private static final void j2(g0 g0Var, View view) {
        n.f(g0Var, "this$0");
        EditText editText = new EditText(g0Var.requireContext());
        new b(g0Var.requireContext(), 2131952089).x("Set new open source").J(editText).E("Ok", new app.dogo.com.dogo_android.debug.l(g0Var, editText)).o();
    }

    private static final void k2(g0 g0Var, EditText editText, DialogInterface dialogInterface, int i) {
        n.f(g0Var, "this$0");
        n.f(editText, "$editText");
        g0Var.F1().t(editText.getText().toString());
    }

    private static final void l2(g0 g0Var, View view) {
        n.f(g0Var, "this$0");
        g0Var.F1().clearDebugOverrides();
    }

    private static final void m2(g0 g0Var, View view) {
        n.f(g0Var, "this$0");
        String str5 = "";
        final String str = null;
        ProgramQuestion programQuestion = new ProgramQuestion(str, "The question", "", "<h1>The heading title</h><br/><h2>Smaller heading title</h2><br/><p>Some text about the correct answer</p><br/><ul><li>first line</li><li>second line</li></ul><br/><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin quis maximus sem. Fusce est lorem, pulvinar vel dictum a, finibus at sapien. In in tortor ac risus sodales gravida at molestie neque porttitor ac. Vestibulum vitae lorem vel orci placerat viverra. Ut vehicula ex sed ipsum finibus, eu aliquam risus hendrerit.\nMorbi porta, orci non lobortis eleifend, felis tortor scelerisque neque, vitae tempus risus dui quis magna. Sed facilisis id elit non iaculis. Aenean eget commodo erat, sed faucibus odio. Nullam tortor nulla, lacinia non velit id, rutrum pulvinar nisl. Maecenas est nulla, rhoncus vitae eros vel, cursus pellentesque ipsum. Fusce quis lectus in est interdum cursus sed eu ex. Aliquam vitae gravida ipsum. Curabitur fringilla vestibulum dolor, id sollicitudin urna fringilla quis.\nProin leo urna, convallis egestas scelerisque eget, sagittis at est. Phasellus eleifend nisl sit amet augue tristique, vestibulum imperdiet magna. Praesent malesuada sodales ultrices. Morbi velit sem, sodales quis orci sed.</p>", p.b("The correct answer"), 0, null, 65, null);
        ProgramQuestionCorrectAnswerScreen g0Var2 = new ProgramQuestionCorrectAnswerScreen(programQuestion, new ProgramSaveInfo(str5, str5, str5, str5), g0Var.setupUserInfoList().getTag(), false, str, 24, null);
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(g0Var.requireActivity(), g0Var2);
    }

    private static final void n2(g0 g0Var, View view) {
        n.f(g0Var, "this$0");
        e activity = g0Var.getActivity();
        if (activity != null) {
            str = "Enter coupon duration in milliseconds";
            app.dogo.com.dogo_android.util.extensionfunction.f1.Z(activity, str, new app.dogo.com.dogo_android.debug.g0.a(g0Var));
        }
    }

    private static final void o2(g0 g0Var, View view) {
        n.f(g0Var, "this$0");
        e activity = g0Var.getActivity();
        if (activity != null) {
            str = "Enter coupon duration in milliseconds";
            app.dogo.com.dogo_android.util.extensionfunction.f1.Z(activity, str, new app.dogo.com.dogo_android.debug.g0.b(g0Var));
        }
    }

    private static final void p2(g0 g0Var, View view) {
        n.f(g0Var, "this$0");
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(g0Var.getActivity(), new DebugFeatureEnablerScreen());
    }

    private static final void q2(g0 g0Var, View view) {
        str3 = "this$0";
        n.f(g0Var, str3);
        final e activity = g0Var.getActivity();
        if (activity != null) {
            int i = 2;
            str = "";
            String str2 = null;
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new TrainingReminderScreen(str, str2, i, str2));
        }
    }

    private static final void r2(g0 g0Var, View view) {
        n.f(g0Var, "this$0");
        TrainingTimeMetrics_TrainingTimeDay trainingTimeMetrics_TrainingTimeDay = new TrainingTimeMetrics_TrainingTimeDay(true, 544, 80, "2002-11-11", "", TrainingTimeMetrics_TrainingTimeDay_StreakStatus.ACTIVE);
        TrainingTimeMetrics trainingTimeMetrics = new TrainingTimeMetrics(p.b(trainingTimeMetrics_TrainingTimeDay), 6, 0, false, false, false, 60, null);
        String str3 = "";
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(g0Var.getActivity(), new TrainingMetricsStreakCompletedScreen(trainingTimeMetrics, "Bobby", str3, str3));
    }

    private static final void s2(g0 g0Var, View view) {
        n.f(g0Var, "this$0");
        TrainingTimeMetrics_TrainingTimeDay trainingTimeMetrics_TrainingTimeDay = new TrainingTimeMetrics_TrainingTimeDay(true, 160, 180, "", "", TrainingTimeMetrics_TrainingTimeDay_StreakStatus.ACTIVE);
        TrainingTimeMetrics trainingTimeMetrics = new TrainingTimeMetrics(p.b(trainingTimeMetrics_TrainingTimeDay), 0, 0, false, false, false, 62, null);
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(g0Var.getActivity(), new GoalNotAchievedScreen("simple_trick_list", p.b(3), trainingTimeMetrics, ""));
    }

    private static final void t2(g0 g0Var, View view) {
        n.f(g0Var, "this$0");
        g0Var.F1().w();
    }

    private static final void u2(g0 g0Var, View view) {
        n.f(g0Var, "this$0");
        g0Var.F1().v();
    }

    private static final void v2(g0 g0Var, View view) {
        n.f(g0Var, "this$0");
        g0Var.F1().x();
    }

    private static final void w2(g0 g0Var, View view) {
        n.f(g0Var, "this$0");
        g0Var.F1().u();
    }

    private static final void x2(g0 g0Var, View view) {
        n.f(g0Var, "this$0");
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(g0Var.getActivity(), new RecordVideoScreen());
    }

    private static final void y2(g0 g0Var, View view) {
        n.f(g0Var, "this$0");
        final Bundle bundle = null;
        app.dogo.com.dogo_android.util.extensionfunction.k1.f(g0Var, DialogTags.LESSON_INTRODUCTION_DIALOG, bundle, 2, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        e activity = null;
        n.f(context, "context");
        Navigator r0 = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : 0;
        if (activity != null) {
            activity.F();
        }
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        ab abVar = ab.T(inflater, container, false);
        n.e(abVar, "inflate(inflater, container, false)");
        this.b = abVar;
        int i = 0;
        String str4 = "binding";
        if (abVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            abVar.V(F1());
            e2();
            if (this.b == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                View view = this.b.w();
                n.e(view, "binding.root");
                return view;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        F1().l().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.debug.m(this));
        if (this.b == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            abVar.P.setNavigationOnClickListener(new app.dogo.com.dogo_android.debug.v(this));
            return;
        }
    }


    /* renamed from: G1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(g0 view, View savedInstanceState) {
        DebugDataFragment.q2(view, savedInstanceState);
    }

    public static /* synthetic */ void H1(g0 g0Var, View view) {
        DebugDataFragment.f2(g0Var, view);
    }

    public static /* synthetic */ void I1(g0 g0Var, View view) {
        DebugDataFragment.l2(g0Var, view);
    }

    public static /* synthetic */ void J1(g0 g0Var, View view) {
        DebugDataFragment.i2(g0Var, view);
    }

    public static /* synthetic */ void K1(g0 g0Var, View view) {
        DebugDataFragment.m2(g0Var, view);
    }

    public static /* synthetic */ void L1(g0 g0Var, View view) {
        DebugDataFragment.x2(g0Var, view);
    }

    public static /* synthetic */ void M1(g0 g0Var, View view) {
        DebugDataFragment.j2(g0Var, view);
    }

    public static /* synthetic */ void N1(g0 g0Var, View view) {
        DebugDataFragment.h2(g0Var, view);
    }

    public static /* synthetic */ void O1(g0 g0Var, View view) {
        DebugDataFragment.s2(g0Var, view);
    }

    public static /* synthetic */ void P1(g0 g0Var, View view) {
        DebugDataFragment.y2(g0Var, view);
    }

    public static /* synthetic */ void Q1(g0 g0Var, View view) {
        DebugDataFragment.o2(g0Var, view);
    }

    public static /* synthetic */ void R1(g0 g0Var, EditText editText, DialogInterface dialogInterface, int i) {
        DebugDataFragment.k2(g0Var, editText, dialogInterface, i);
    }

    public static /* synthetic */ void S1(g0 g0Var, Boolean boolean) {
        DebugDataFragment.c2(g0Var, boolean);
    }

    public static /* synthetic */ void T1(g0 g0Var, View view) {
        DebugDataFragment.t2(g0Var, view);
    }

    public static /* synthetic */ void U1(g0 g0Var, View view) {
        DebugDataFragment.v2(g0Var, view);
    }

    public static /* synthetic */ void V1(g0 g0Var, View view) {
        DebugDataFragment.u2(g0Var, view);
    }

    public static /* synthetic */ void W1(g0 g0Var, View view) {
        DebugDataFragment.w2(g0Var, view);
    }

    public static /* synthetic */ void X1(g0 g0Var, View view) {
        DebugDataFragment.r2(g0Var, view);
    }

    public static /* synthetic */ void Y1(g0 g0Var, View view) {
        DebugDataFragment.p2(g0Var, view);
    }

    public static /* synthetic */ void Z1(g0 g0Var, View view) {
        DebugDataFragment.g2(g0Var, view);
    }

    public static /* synthetic */ void a2(g0 g0Var, View view) {
        DebugDataFragment.n2(g0Var, view);
    }

    public static /* synthetic */ void b2(g0 g0Var, View view) {
        DebugDataFragment.d2(g0Var, view);
    }
}
