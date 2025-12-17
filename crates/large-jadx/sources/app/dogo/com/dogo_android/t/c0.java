package app.dogo.com.dogo_android.t;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.c.a;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.e.j;
import app.dogo.com.dogo_android.h.kg;
import app.dogo.com.dogo_android.i.i0;
import app.dogo.com.dogo_android.model.RemindersModel;
import app.dogo.com.dogo_android.o.d;
import app.dogo.com.dogo_android.r.n;
import app.dogo.com.dogo_android.repository.domain.SettingsResults;
import app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanScreen;
import app.dogo.com.dogo_android.subscription.redeemcoupon.RedeemCodeScreen;
import app.dogo.com.dogo_android.t.g0.h;
import app.dogo.com.dogo_android.t.h0.k;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.y.j;
import f.c.a.e.s.b;
import f.d.a.a;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.w;
import m.a.b.a.d.a.a;
import m.a.b.a.d.a.b;
import m.a.c.j.a;
import n.a.a;
import zendesk.support.guide.HelpCenterActivity;
import zendesk.support.guide.HelpCenterConfiguration.Builder;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0015\u001a\u00020\u0016H\u0002J\"\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0008\u0010!\u001a\u0004\u0018\u00010\"2\u0008\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0008\u0010%\u001a\u00020\u0016H\u0016J\u0008\u0010&\u001a\u00020\u0016H\u0016J\u001a\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u001e2\u0008\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020+H\u0002J\u0008\u0010,\u001a\u00020\u0016H\u0002J\u0012\u0010-\u001a\u00020\u00162\u0008\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0008\u00100\u001a\u00020\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u000f\u001a\u0004\u0008\u0012\u0010\u0013¨\u00062", d2 = {"Lapp/dogo/com/dogo_android/settings/SettingsFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/settings/SettingsCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentSettingsBinding;", "screenKey", "Lapp/dogo/com/dogo_android/settings/SettingsScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/settings/SettingsScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/settings/SettingsViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/settings/SettingsViewModel;", "viewModel$delegate", "callSubscriptionDialog", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onStart", "onViewCreated", "view", "openInviteShare", "friendsLink", "", "openPlaystoreAccount", "toggleTrainingReminder", "remindersModel", "Lapp/dogo/com/dogo_android/model/RemindersModel;", "trainingReminderRetry", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c0 extends Fragment implements app.dogo.com.dogo_android.t.b0 {

    public static final app.dogo.com.dogo_android.t.c0.a Companion;
    private kg a;
    private final h b;
    private final h c;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\t\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/settings/SettingsFragment$Companion;", "", "()V", "LOGIN_IN_REQUEST_CODE_FOR_ZENDESK", "", "TRICK_ID_FIELD_ID", "", "ZENDESK_APP_VERSION_FIELD_ID", "ZENDESK_BREED_ID_FIELD_ID", "ZENDESK_DOG_AGE_FIELD_ID", "ZENDESK_DOG_ID_FIELD_ID", "ZENDESK_DOG_NAME_FIELD_ID", "ZENDESK_DOG_PREMIUM_FIELD_ID", "ZENDESK_PLATFORM_FIELD_ID", "ZENDESK_USER_ID_FIELD_ID", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<w> {

        final app.dogo.com.dogo_android.t.c0 this$0;
        b(app.dogo.com.dogo_android.t.c0 c0) {
            this.this$0 = c0;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            c0.B1(this.this$0).b0();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements a<l> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public c(Fragment fragment, a a2, a a3) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(l.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements a<app.dogo.com.dogo_android.t.f0> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public d(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.t.f0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(f0.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
        c0.a aVar = new c0.a(0);
        c0.Companion = aVar;
    }

    public c0() {
        super();
        final int i = 0;
        c0.d dVar = new c0.d(this, i, i);
        this.b = j.a(m.SYNCHRONIZED, dVar);
        c0.c cVar = new c0.c(this, i, i);
        this.c = j.a(m.NONE, cVar);
    }

    private static final void A2(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        Object obj1;
        n.f(c0, "this$0");
        final androidx.fragment.app.e obj0 = c0.getActivity();
        if (obj0 == null) {
        } else {
            obj1 = new h();
            g1.n(obj0, obj1);
        }
    }

    public static final app.dogo.com.dogo_android.t.f0 B1(app.dogo.com.dogo_android.t.c0 c0) {
        return c0.F1();
    }

    private final void B2(String string) {
        Intent chooser;
        String str;
        chooser = new Intent();
        chooser.setAction("android.intent.action.SEND");
        String string2 = getResources().getString(2131886783);
        n.e(string2, "resources.getString(R.string.invite_friends_text)");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(' ');
        stringBuilder.append(string);
        chooser.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
        chooser.setType("text/plain");
        androidx.fragment.app.e obj4 = getActivity();
        if (obj4 == null) {
        } else {
            obj4.startActivity(Intent.createChooser(chooser, "..."));
        }
    }

    private final void C1() {
        b bVar = new b(requireContext());
        n nVar = new n(this);
        bVar.x(getResources().getString(2131887309)).E(getResources().getString(2131887317), nVar).y(2131886677, 0).o();
    }

    private final void C2() {
        Resources string;
        Uri parse;
        int str;
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/account/subscriptions"));
            startActivity(intent);
            androidx.fragment.app.e activity = getActivity();
            if (activity == null) {
            } else {
            }
            string = getResources();
            str = 2131886123;
            string = string.getString(str);
            str = "resources.getString(R.string.alert_something_failed)";
            n.e(string, str);
            g1.i0(activity, string);
            th.printStackTrace();
        }
    }

    private static final void D1(app.dogo.com.dogo_android.t.c0 c0, DialogInterface dialogInterface2, int i3) {
        n.f(c0, "this$0");
        g1.n(c0.getActivity(), l.H(c0.getSharedViewModel(), "settings", c0.E1().getTag(), false, 0, 12, 0));
    }

    private final app.dogo.com.dogo_android.t.d0 E1() {
        return (d0)k1.a(this);
    }

    private final app.dogo.com.dogo_android.t.f0 F1() {
        return (f0)this.b.getValue();
    }

    public static void G1(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        c0.z2(c0, boolean2);
    }

    public static void H1(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        c0.p2(c0, boolean2);
    }

    public static void I1(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        c0.u2(c0, boolean2);
    }

    public static void J1(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        c0.o2(c0, boolean2);
    }

    public static void K1(app.dogo.com.dogo_android.t.c0 c0, y y2) {
        c0.s2(c0, y2);
    }

    public static void L1(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        c0.g2(c0, boolean2);
    }

    public static void M1(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        c0.h2(c0, boolean2);
    }

    public static void N1(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        c0.l2(c0, boolean2);
    }

    public static void O1(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        c0.i2(c0, boolean2);
    }

    public static void P1(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        c0.n2(c0, boolean2);
    }

    public static void Q1(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        c0.y2(c0, boolean2);
    }

    public static void R1(app.dogo.com.dogo_android.t.c0 c0, DialogInterface dialogInterface2, int i3) {
        c0.D1(c0, dialogInterface2, i3);
    }

    public static void S1(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        c0.f2(c0, boolean2);
    }

    public static void T1(app.dogo.com.dogo_android.t.c0 c0, SettingsResults settingsResults2) {
        c0.q2(c0, settingsResults2);
    }

    public static void U1(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        c0.m2(c0, boolean2);
    }

    public static void V1(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        c0.v2(c0, boolean2);
    }

    public static void W1(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        c0.w2(c0, boolean2);
    }

    public static void X1(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        c0.j2(c0, boolean2);
    }

    public static void Y1(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        c0.A2(c0, boolean2);
    }

    public static void Z1(app.dogo.com.dogo_android.t.c0 c0, y y2) {
        c0.r2(c0, y2);
    }

    public static void a2(app.dogo.com.dogo_android.t.c0 c0, String string2) {
        c0.k2(c0, string2);
    }

    public static void b2(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        c0.e2(c0, boolean2);
    }

    public static void c2(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        c0.x2(c0, boolean2);
    }

    public static void d2(app.dogo.com.dogo_android.t.c0 c0, y y2) {
        c0.t2(c0, y2);
    }

    private static final void e2(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        n.f(c0, "this$0");
        j obj2 = new j("settings");
        g1.n(c0.getActivity(), obj2);
    }

    private static final void f2(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        String obj1;
        n.f(c0, "this$0");
        final androidx.fragment.app.e obj0 = c0.getActivity();
        if (obj0 == null) {
        } else {
            g1.g0(obj0, 2131886693);
        }
    }

    private static final void g2(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        n.f(c0, "this$0");
        HelpCenterActivity.builder().show(c0.requireActivity(), new a[0]);
    }

    private final l getSharedViewModel() {
        return (l)this.c.getValue();
    }

    private static final void h2(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        n.f(c0, "this$0");
        final androidx.fragment.app.e obj0 = c0.getActivity();
        if (obj0 == null) {
        } else {
            g1.M(obj0);
        }
    }

    private static final void i2(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        n.f(c0, "this$0");
        final androidx.fragment.app.e obj0 = c0.getActivity();
        if (obj0 == null) {
        } else {
            g1.L(obj0);
        }
    }

    private static final void j2(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        n.f(c0, "this$0");
        final androidx.fragment.app.e obj0 = c0.getActivity();
        if (obj0 == null) {
        } else {
            g1.J(obj0);
        }
    }

    private static final void k2(app.dogo.com.dogo_android.t.c0 c0, String string2) {
        n.f(c0, "this$0");
        n.e(string2, "friendsLink");
        c0.B2(string2);
    }

    private static final void l2(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        n.f(c0, "this$0");
        final androidx.fragment.app.e obj0 = c0.getActivity();
        if (obj0 == null) {
        } else {
            g1.K(obj0);
        }
    }

    private static final void m2(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        Object obj1;
        n.f(c0, "this$0");
        final androidx.fragment.app.e obj0 = c0.getActivity();
        if (obj0 == null) {
        } else {
            obj1 = new i0();
            g1.n(obj0, obj1);
        }
    }

    private static final void n2(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        app.dogo.com.dogo_android.t.c0.b bVar;
        n.f(c0, "this$0");
        androidx.fragment.app.e obj2 = c0.getActivity();
        if (obj2 == null) {
        } else {
            bVar = new c0.b(c0);
            f1.b0(obj2, bVar);
        }
    }

    private static final void o2(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        int i;
        String str;
        int i3;
        int i4;
        int i2;
        n.f(c0, "this$0");
        final androidx.fragment.app.e activity = c0.getActivity();
        if (activity == null) {
        } else {
            g1.H(activity, 0, "settings", 0, 5, 0);
        }
    }

    private static final void p2(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        n.f(c0, "this$0");
        c0.getSharedViewModel().openZendeskScreen(c0.F1().Q(), false);
    }

    private static final void q2(app.dogo.com.dogo_android.t.c0 c0, SettingsResults settingsResults2) {
        n.f(c0, "this$0");
        if (settingsResults2.getPremium()) {
            c0.C2();
        } else {
            c0.C1();
        }
    }

    private static final void r2(app.dogo.com.dogo_android.t.c0 c0, y y2) {
        boolean activity;
        n nVar;
        String str;
        Object obj3;
        Object obj4;
        n.f(c0, "this$0");
        if (!y2 instanceof y.b) {
            if (y2 instanceof y.a) {
                a.d((y.a)y2.a());
                activity = c0.getActivity();
                if (activity == null) {
                } else {
                    obj3 = c0.requireContext();
                    n.e(obj3, "requireContext()");
                    g1.i0(activity, n.a.i(y2.a(), obj3));
                }
            } else {
                obj4 = new Intent(c0.requireContext(), OnboardingActivity.class);
                activity = c0.getActivity();
                if (activity == null) {
                } else {
                    activity.startActivity(obj4);
                }
                obj3 = c0.getActivity();
                if (obj3 == null) {
                } else {
                    obj3.finish();
                }
            }
        }
    }

    private static final void s2(app.dogo.com.dogo_android.t.c0 c0, y y2) {
        boolean activity;
        n nVar;
        String str;
        Object obj3;
        boolean obj4;
        n.f(c0, "this$0");
        if (y2 instanceof y.c) {
            if ((Boolean)(y.c)y2.a().booleanValue()) {
                obj3 = c0.getActivity();
                if (obj3 == null) {
                } else {
                    g1.g0(obj3, 2131887148);
                }
            } else {
                obj3 = c0.getActivity();
                if (obj3 == null) {
                } else {
                    g1.g0(obj3, 2131887237);
                }
            }
        } else {
            if (y2 instanceof y.a) {
                a.d((y.a)y2.a());
                activity = c0.getActivity();
                if (activity == null) {
                } else {
                    obj3 = c0.requireContext();
                    n.e(obj3, "requireContext()");
                    g1.i0(activity, n.a.i(y2.a(), obj3));
                }
            }
        }
    }

    private static final void t2(app.dogo.com.dogo_android.t.c0 c0, y y2) {
        Object obj1;
        n.f(c0, "this$0");
        if (!y2 instanceof y.b) {
            c0.F1().e0();
        }
    }

    private static final void u2(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        Object obj1;
        boolean obj2;
        n.f(c0, "this$0");
        n.e(boolean2, "it");
        if (boolean2.booleanValue()) {
            c0.F1().restorePurchase();
        } else {
            obj1 = c0.getActivity();
            if (obj1 == null) {
            } else {
                g1.g0(obj1, 2131886953);
            }
        }
    }

    private static final void v2(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        n.f(c0, "this$0");
        super("settings", c0.E1().getTag(), 1, 0, 8, 0);
        g1.n(c0.getActivity(), subscriptionPlanScreen2);
    }

    private static final void w2(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        int i3;
        int i;
        int i2;
        Object obj4;
        n.f(c0, "this$0");
        final androidx.fragment.app.e obj3 = c0.getActivity();
        if (obj3 == null) {
        } else {
            obj4 = new k(0, 1, 0);
            g1.X(obj3, obj4);
        }
    }

    private static final void x2(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        RedeemCodeScreen redeemCodeScreen;
        Object obj1;
        n.f(c0, "this$0");
        androidx.fragment.app.e obj2 = c0.getActivity();
        if (obj2 == null) {
        } else {
            redeemCodeScreen = new RedeemCodeScreen(c0.E1().getTag());
            g1.X(obj2, redeemCodeScreen);
        }
    }

    private static final void y2(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        n nVar;
        int i;
        int i2;
        Object obj3;
        n.f(c0, "this$0");
        androidx.fragment.app.e obj4 = c0.getActivity();
        if (obj4 == null) {
        } else {
            i2 = 0;
            nVar = new n(c0.E1().getTag(), i2, 2, i2);
            g1.n(obj4, nVar);
        }
    }

    private static final void z2(app.dogo.com.dogo_android.t.c0 c0, Boolean boolean2) {
        String str;
        androidx.fragment.app.e obj1;
        app.dogo.com.dogo_android.t.f0 obj2;
        n.f(c0, "this$0");
        n.e(boolean2, "it");
        if (boolean2.booleanValue()) {
            obj1 = c0.requireActivity();
            n.e(obj1, "requireActivity()");
            c0.F1().W(obj1);
        } else {
            obj1 = c0.getActivity();
            if (obj1 == null) {
            } else {
                g1.g(obj1);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void N0() {
        F1().Y();
    }

    @Override // androidx.fragment.app.Fragment
    public void W(RemindersModel remindersModel) {
        F1().l0(remindersModel);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent3) {
        int i3;
        d dVar;
        String str;
        int obj4;
        int obj6;
        super.onActivityResult(i, i2, intent3);
        obj6 = -1;
        if (i == 7001 && i2 == obj6) {
            if (i2 == obj6) {
                F1().e0();
            }
        }
        int i4 = 10000;
        F1().e0();
        if (i == i4 && i2 == obj6 && F1().i0()) {
            if (i2 == obj6) {
                F1().e0();
                if (F1().i0()) {
                    dVar = new d("settings");
                    g1.n(getActivity(), dVar);
                }
            }
        }
        if (i == i4 && i2 == 0) {
            if (i2 == 0) {
                F1().m0();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        kg obj2 = kg.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.X(F1());
            obj2 = this.a;
            if (obj2 == null) {
            } else {
                obj2.W(getSharedViewModel());
                obj2 = this.a;
                if (obj2 == null) {
                } else {
                    obj2.M(getViewLifecycleOwner());
                    obj2 = this.a;
                    if (obj2 == null) {
                    } else {
                        obj2.V(this);
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
        n.w(obj4);
        throw obj3;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        F1().X();
        F1().Y();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        androidx.fragment.app.e activity;
        super.onStart();
        if (activity instanceof a0) {
        } else {
            activity = 0;
        }
        if (activity == null) {
        } else {
            activity.p0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        androidx.lifecycle.q obj4 = getViewLifecycleOwner();
        String str2 = "viewLifecycleOwner";
        n.e(obj4, str2);
        x xVar = new x(this);
        F1().w().observe(obj4, xVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        o oVar = new o(this);
        F1().N().observe(obj4, oVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        p pVar = new p(this);
        F1().O().observe(obj4, pVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        e eVar = new e(this);
        F1().L().observe(obj4, eVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        r rVar = new r(this);
        F1().I().observe(obj4, rVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        s sVar = new s(this);
        F1().E().observe(obj4, sVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        y yVar = new y(this);
        F1().G().observe(obj4, yVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        m mVar = new m(this);
        F1().H().observe(obj4, mVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        c cVar = new c(this);
        F1().F().observe(obj4, cVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        u uVar = new u(this);
        F1().A().observe(obj4, uVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        h hVar = new h(this);
        F1().B().observe(obj4, hVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        i iVar = new i(this);
        F1().K().observe(obj4, iVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        k kVar = new k(this);
        F1().J().observe(obj4, kVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        t tVar = new t(this);
        F1().z().observe(obj4, tVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        w wVar = new w(this);
        F1().D().observe(obj4, wVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        j jVar = new j(this);
        F1().C().observe(obj4, jVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        q qVar = new q(this);
        F1().y().observe(obj4, qVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        l lVar = new l(this);
        F1().u().observe(obj4, lVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        f fVar = new f(this);
        F1().v().observe(obj4, fVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        d dVar = new d(this);
        F1().x().observe(obj4, dVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        v vVar = new v(this);
        F1().t().observe(obj4, vVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        g gVar = new g(this);
        F1().isPurchaseRestored().observe(obj4, gVar);
        z zVar = new z(this);
        F1().M().observe(getViewLifecycleOwner(), zVar);
    }
}
