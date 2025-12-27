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
import app.dogo.com.dogo_android.h.kg;
import app.dogo.com.dogo_android.i.i0;
import app.dogo.com.dogo_android.model.RemindersModel;
import app.dogo.com.dogo_android.o.d;
import app.dogo.com.dogo_android.repository.domain.SettingsResults;
import app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanScreen;
import app.dogo.com.dogo_android.subscription.redeemcoupon.RedeemCodeScreen;
import app.dogo.com.dogo_android.t.h0.k;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.p;
import kotlin.m;
import kotlin.w;
import zendesk.support.guide.HelpCenterActivity;
import zendesk.support.guide.HelpCenterConfiguration.Builder;

/* compiled from: SettingsFragment.kt */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0015\u001a\u00020\u0016H\u0002J\"\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0008\u0010!\u001a\u0004\u0018\u00010\"2\u0008\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0008\u0010%\u001a\u00020\u0016H\u0016J\u0008\u0010&\u001a\u00020\u0016H\u0016J\u001a\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u001e2\u0008\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020+H\u0002J\u0008\u0010,\u001a\u00020\u0016H\u0002J\u0012\u0010-\u001a\u00020\u00162\u0008\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0008\u00100\u001a\u00020\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u000f\u001a\u0004\u0008\u0012\u0010\u0013¨\u00062", d2 = {"Lapp/dogo/com/dogo_android/settings/SettingsFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/settings/SettingsCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentSettingsBinding;", "screenKey", "Lapp/dogo/com/dogo_android/settings/SettingsScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/settings/SettingsScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/settings/SettingsViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/settings/SettingsViewModel;", "viewModel$delegate", "callSubscriptionDialog", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onStart", "onViewCreated", "view", "openInviteShare", "friendsLink", "", "openPlaystoreAccount", "toggleTrainingReminder", "remindersModel", "Lapp/dogo/com/dogo_android/model/RemindersModel;", "trainingReminderRetry", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c0, reason: from kotlin metadata */
public final class SettingsFragment extends Fragment implements b0 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final c0.a INSTANCE = new c0$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private kg binding;
    private final kotlin.h b;
    private final kotlin.h c;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\t\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/settings/SettingsFragment$Companion;", "", "()V", "LOGIN_IN_REQUEST_CODE_FOR_ZENDESK", "", "TRICK_ID_FIELD_ID", "", "ZENDESK_APP_VERSION_FIELD_ID", "ZENDESK_BREED_ID_FIELD_ID", "ZENDESK_DOG_AGE_FIELD_ID", "ZENDESK_DOG_ID_FIELD_ID", "ZENDESK_DOG_NAME_FIELD_ID", "ZENDESK_DOG_PREMIUM_FIELD_ID", "ZENDESK_PLATFORM_FIELD_ID", "ZENDESK_USER_ID_FIELD_ID", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            c0.this.F1().b0();
        }

        b() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements kotlin.d0.c.a<l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(SessionViewModel.class), this.$parameters);
        }

        public c(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements kotlin.d0.c.a<f0> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final f0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(SettingsViewModel.class), this.$parameters);
        }

        public d(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    public c0() {
        super();
        final m.a.c.j.a aVar = null;
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new kotlinx.coroutines.c0.d(this, aVar, aVar));
        this.c = j.a(LazyThreadSafetyMode.NONE, new kotlinx.coroutines.c0.c(this, aVar, aVar));
    }

    /* renamed from: A2, reason: from kotlin metadata */
    private static final void onViewCreated(c0 view, Boolean savedInstanceState) {
        str = "this$0";
        n.f(view, str);
        final androidx.fragment.app.e activity = view.getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new FaqListScreen());
        }
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ f0 openInviteShare(c0 friendsLink) {
        return friendsLink.F1();
    }

    /* renamed from: B2, reason: from kotlin metadata */
    private final void toggleTrainingReminder(String remindersModel) throws android.content.res.Resources.NotFoundException {
        Intent chooser = new Intent();
        chooser.setAction("android.intent.action.SEND");
        String string = getResources().getString(2131886783);
        n.e(string, "resources.getString(R.string.invite_friends_text)");
        StringBuilder stringBuilder = new StringBuilder();
        str4 = string + 32 + remindersModel;
        str = "android.intent.extra.TEXT";
        chooser.putExtra(str, str4);
        chooser.setType("text/plain");
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            str = "...";
            activity.startActivity(Intent.createChooser(chooser, str));
        }
    }

    /* renamed from: C1, reason: from kotlin metadata */
    private final void callSubscriptionDialog() throws android.content.res.Resources.NotFoundException {
        new b(requireContext()).x(getResources().getString(2131887309)).E(getResources().getString(2131887317), new kotlinx.coroutines.n(this)).y(2131886677, null).o();
    }

    private final void C2() throws android.content.res.Resources.NotFoundException {
        Resources string;
        int str3;
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/account/subscriptions")));
        } catch (android.content.ActivityNotFoundException activityNotFound) {
            androidx.fragment.app.e activity = getActivity();
        }
    }

    /* renamed from: D1, reason: from kotlin metadata */
    private static final void onActivityResult(c0 requestCode, DialogInterface resultCode, int data) {
        n.f(requestCode, "this$0");
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(requestCode.getActivity(), SessionViewModel.H(requestCode.getSharedViewModel(), "settings", requestCode.E1().getTag(), false, null, 12, null));
    }

    private final d0 E1() {
        return (SettingsScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final f0 F1() {
        return (SettingsViewModel)this.b.getValue();
    }

    private static final void e2(c0 c0Var, Boolean boolean) {
        n.f(c0Var, "this$0");
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(c0Var.getActivity(), new ClickerScreen("settings"));
    }

    private static final void f2(c0 c0Var, Boolean boolean) {
        str = "this$0";
        n.f(c0Var, str);
        final androidx.fragment.app.e activity = c0Var.getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.g0(activity, 2131886693);
        }
    }

    private static final void g2(c0 c0Var, Boolean boolean) {
        n.f(c0Var, "this$0");
        HelpCenterActivity.builder().show(c0Var.requireActivity(), new a[0]);
    }

    private final l getSharedViewModel() {
        return (SessionViewModel)this.c.getValue();
    }

    private static final void h2(c0 c0Var, Boolean boolean) {
        n.f(c0Var, "this$0");
        final androidx.fragment.app.e activity = c0Var.getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.getMissingPermissions(activity);
        }
    }

    private static final void i2(c0 c0Var, Boolean boolean) {
        n.f(c0Var, "this$0");
        final androidx.fragment.app.e activity = c0Var.getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.clearBackstackAndGoToFragment(activity);
        }
    }

    private static final void j2(c0 c0Var, Boolean boolean) {
        n.f(c0Var, "this$0");
        final androidx.fragment.app.e activity = c0Var.getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.getActivityConfig(activity);
        }
    }

    private static final void k2(c0 c0Var, String str) {
        n.f(c0Var, "this$0");
        n.e(str, "friendsLink");
        c0Var.toggleTrainingReminder(str);
    }

    private static final void l2(c0 c0Var, Boolean boolean) {
        n.f(c0Var, "this$0");
        final androidx.fragment.app.e activity = c0Var.getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.anyPermissionsIgnored(activity);
        }
    }

    private static final void m2(c0 c0Var, Boolean boolean) {
        str = "this$0";
        n.f(c0Var, str);
        final androidx.fragment.app.e activity = c0Var.getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new DebugDataScreen());
        }
    }

    private static final void n2(c0 c0Var, Boolean boolean) {
        n.f(c0Var, "this$0");
        androidx.fragment.app.e activity = c0Var.getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.f1.showSimpleCancelableDialog(activity, new kotlinx.coroutines.c0.b(c0Var));
        }
    }

    private static final void o2(c0 c0Var, Boolean boolean) {
        n.f(c0Var, "this$0");
        final androidx.fragment.app.e activity = c0Var.getActivity();
        if (activity != null) {
            int i = 0;
            app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo zendeskConfigurationInfo = null;
            int i2 = 5;
            Object obj = null;
            str = "settings";
            app.dogo.com.dogo_android.util.extensionfunction.g1.H(activity, i, str, zendeskConfigurationInfo, i2, obj);
        }
    }

    private static final void p2(c0 c0Var, Boolean boolean) {
        n.f(c0Var, "this$0");
        c0Var.getSharedViewModel().openZendeskScreen(c0Var.F1().Q(), false);
    }

    private static final void q2(c0 c0Var, SettingsResults set) {
        n.f(c0Var, "this$0");
        if (set.getPremium()) {
            c0Var.C2();
        } else {
            c0Var.callSubscriptionDialog();
        }
    }

    private static final void r2(c0 c0Var, y yVar) {
        n.f(c0Var, "this$0");
        z = yVar instanceof LoadResult_Loading;
        if (!(yVar instanceof oadResult_Loading)) {
            if (!(yVar instanceof LoadResult_Error)) {
                nVar = kotlinx.coroutines.OnboardingActivity.class;
                androidx.fragment.app.e activity2 = c0Var.getActivity();
                if (activity2 != null) {
                    activity2.startActivity(new Intent(c0Var.requireContext(), nVar));
                }
                androidx.fragment.app.e activity3 = c0Var.getActivity();
                if (activity3 != null) {
                    activity3.finish();
                }
            } else {
                a.d(yVar.component1());
                androidx.fragment.app.e activity = c0Var.getActivity();
                if (activity != null) {
                    android.content.Context requireContext2 = c0Var.requireContext();
                    str = "requireContext()";
                    n.e(requireContext2, str);
                    app.dogo.com.dogo_android.util.extensionfunction.g1.i0(activity, BindingAdapters.a.i(yVar.component1(), requireContext2));
                }
            }
        }
    }

    private static final void s2(c0 c0Var, y yVar) {
        n.f(c0Var, "this$0");
        z = yVar instanceof LoadResult_Success;
        if (yVar instanceof oadResult_Success) {
            if ((Boolean)yVar.component1().booleanValue()) {
                androidx.fragment.app.e activity = c0Var.getActivity();
                if (activity != null) {
                    app.dogo.com.dogo_android.util.extensionfunction.g1.g0(activity, 2131887148);
                }
            } else {
                activity = c0Var.getActivity();
                if (activity != null) {
                    app.dogo.com.dogo_android.util.extensionfunction.g1.g0(activity, 2131887237);
                }
            }
        } else {
            z = yVar instanceof LoadResult_Error;
            if (yVar instanceof oadResult_Error) {
                a.d(yVar.component1());
                androidx.fragment.app.e activity2 = c0Var.getActivity();
                if (activity2 != null) {
                    android.content.Context requireContext = c0Var.requireContext();
                    str = "requireContext()";
                    n.e(requireContext, str);
                    app.dogo.com.dogo_android.util.extensionfunction.g1.i0(activity2, BindingAdapters.a.i(yVar.component1(), requireContext));
                }
            }
        }
    }

    private static final void t2(c0 c0Var, y yVar) {
        n.f(c0Var, "this$0");
        if (!(yVar instanceof LoadResult_Loading)) {
            c0Var.F1().e0();
        }
    }

    private static final void u2(c0 c0Var, Boolean boolean) {
        n.f(c0Var, "this$0");
        n.e(boolean, "it");
        if (boolean.booleanValue()) {
            c0Var.F1().restorePurchase();
        } else {
            androidx.fragment.app.e activity = c0Var.getActivity();
            if (activity != null) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.g0(activity, 2131886953);
            }
        }
    }

    private static final void v2(c0 c0Var, Boolean boolean) {
        n.f(c0Var, "this$0");
        SubscriptionPlanScreen subscriptionPlanScreen = new SubscriptionPlanScreen("settings", c0Var.E1().getTag(), true, null, 8, null);
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(c0Var.getActivity(), subscriptionPlanScreen);
    }

    private static final void w2(c0 c0Var, Boolean boolean) {
        str = "this$0";
        n.f(c0Var, str);
        final androidx.fragment.app.e activity = c0Var.getActivity();
        if (activity != null) {
            boolean z = false;
            int i = 1;
            g gVar = null;
            app.dogo.com.dogo_android.util.extensionfunction.g1.showEntryReportDialog(activity, new LanguageSelectScreen(z, i, gVar));
        }
    }

    private static final void x2(c0 c0Var, Boolean boolean) {
        n.f(c0Var, "this$0");
        androidx.fragment.app.e activity = c0Var.getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.showEntryReportDialog(activity, new RedeemCodeScreen(c0Var.E1().getTag()));
        }
    }

    private static final void y2(c0 c0Var, Boolean boolean) {
        n.f(c0Var, "this$0");
        androidx.fragment.app.e activity = c0Var.getActivity();
        if (activity != null) {
            int i = 2;
            String str = null;
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new TrainingReminderWithTimeScreen(c0Var.E1().getTag(), str, i, str));
        }
    }

    private static final void z2(c0 c0Var, Boolean boolean) {
        n.f(c0Var, "this$0");
        str = "it";
        n.e(boolean, str);
        if (boolean.booleanValue()) {
            androidx.fragment.app.e requireActivity = c0Var.requireActivity();
            str = "requireActivity()";
            n.e(requireActivity, str);
            c0Var.F1().W(requireActivity);
        } else {
            requireActivity = c0Var.getActivity();
            if (requireActivity != null) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.goToZendeskScreenAndLog(requireActivity);
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
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        int i4 = -1;
        int i3 = 7001;
        if (i == 7001 && i2 == i4) {
            F1().e0();
        }
        int i5 = 10000;
        if (i == i5 && i2 == i4 && this.F1().i0()) {
            str = "settings";
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new NewsletterBenefitsScreen(str));
        }
        if (i == i5 && i2 == 0) {
            F1().m0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        n.f(layoutInflater, "inflater");
        kg kgVar = kg.T(layoutInflater, viewGroup, false);
        n.e(kgVar, "inflate(inflater, container, false)");
        this.binding = kgVar;
        int i = 0;
        String str4 = "binding";
        if (kgVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            kgVar.X(F1());
            if (this.binding == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.W(getSharedViewModel());
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
                        this.binding.V(this);
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
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        F1().X();
        F1().Y();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        androidx.fragment.app.e activity = null;
        super.onStart();
        Navigator r0 = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : 0;
        if (activity != null) {
            activity.p0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
        String str2 = "viewLifecycleOwner";
        n.e(viewLifecycleOwner, str2);
        F1().w().observe(viewLifecycleOwner, new kotlinx.coroutines.x(this));
        androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner2, str2);
        F1().N().observe(viewLifecycleOwner2, new kotlinx.coroutines.o(this));
        androidx.lifecycle.q viewLifecycleOwner3 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner3, str2);
        F1().O().observe(viewLifecycleOwner3, new kotlinx.coroutines.p(this));
        androidx.lifecycle.q viewLifecycleOwner4 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner4, str2);
        F1().L().observe(viewLifecycleOwner4, new kotlinx.coroutines.e(this));
        androidx.lifecycle.q viewLifecycleOwner5 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner5, str2);
        F1().I().observe(viewLifecycleOwner5, new kotlinx.coroutines.r(this));
        androidx.lifecycle.q viewLifecycleOwner6 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner6, str2);
        F1().E().observe(viewLifecycleOwner6, new kotlinx.coroutines.s(this));
        androidx.lifecycle.q viewLifecycleOwner7 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner7, str2);
        F1().G().observe(viewLifecycleOwner7, new kotlinx.coroutines.y(this));
        androidx.lifecycle.q viewLifecycleOwner8 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner8, str2);
        F1().H().observe(viewLifecycleOwner8, new kotlinx.coroutines.m(this));
        androidx.lifecycle.q viewLifecycleOwner9 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner9, str2);
        F1().F().observe(viewLifecycleOwner9, new kotlinx.coroutines.c(this));
        androidx.lifecycle.q viewLifecycleOwner10 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner10, str2);
        F1().A().observe(viewLifecycleOwner10, new kotlinx.coroutines.u(this));
        androidx.lifecycle.q viewLifecycleOwner11 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner11, str2);
        F1().B().observe(viewLifecycleOwner11, new kotlinx.coroutines.h(this));
        androidx.lifecycle.q viewLifecycleOwner12 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner12, str2);
        F1().K().observe(viewLifecycleOwner12, new kotlinx.coroutines.i(this));
        androidx.lifecycle.q viewLifecycleOwner13 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner13, str2);
        F1().J().observe(viewLifecycleOwner13, new kotlinx.coroutines.k(this));
        androidx.lifecycle.q viewLifecycleOwner14 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner14, str2);
        F1().z().observe(viewLifecycleOwner14, new kotlinx.coroutines.t(this));
        androidx.lifecycle.q viewLifecycleOwner15 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner15, str2);
        F1().D().observe(viewLifecycleOwner15, new kotlinx.coroutines.w(this));
        androidx.lifecycle.q viewLifecycleOwner16 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner16, str2);
        F1().C().observe(viewLifecycleOwner16, new kotlinx.coroutines.j(this));
        androidx.lifecycle.q viewLifecycleOwner17 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner17, str2);
        F1().y().observe(viewLifecycleOwner17, new kotlinx.coroutines.q(this));
        androidx.lifecycle.q viewLifecycleOwner18 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner18, str2);
        F1().u().observe(viewLifecycleOwner18, new kotlinx.coroutines.l(this));
        androidx.lifecycle.q viewLifecycleOwner19 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner19, str2);
        F1().v().observe(viewLifecycleOwner19, new kotlinx.coroutines.f(this));
        androidx.lifecycle.q viewLifecycleOwner20 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner20, str2);
        F1().x().observe(viewLifecycleOwner20, new kotlinx.coroutines.d(this));
        androidx.lifecycle.q viewLifecycleOwner21 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner21, str2);
        F1().t().observe(viewLifecycleOwner21, new kotlinx.coroutines.v(this));
        androidx.lifecycle.q viewLifecycleOwner22 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner22, str2);
        F1().isPurchaseRestored().observe(viewLifecycleOwner22, new kotlinx.coroutines.g(this));
        F1().M().observe(getViewLifecycleOwner(), new kotlinx.coroutines.z(this));
    }

    public static /* synthetic */ void G1(c0 c0Var, Boolean boolean) {
        SettingsFragment.z2(c0Var, boolean);
    }

    public static /* synthetic */ void H1(c0 c0Var, Boolean boolean) {
        SettingsFragment.p2(c0Var, boolean);
    }

    public static /* synthetic */ void I1(c0 c0Var, Boolean boolean) {
        SettingsFragment.u2(c0Var, boolean);
    }

    public static /* synthetic */ void J1(c0 c0Var, Boolean boolean) {
        SettingsFragment.o2(c0Var, boolean);
    }

    public static /* synthetic */ void K1(c0 c0Var, y yVar) {
        SettingsFragment.s2(c0Var, yVar);
    }

    public static /* synthetic */ void L1(c0 c0Var, Boolean boolean) {
        SettingsFragment.g2(c0Var, boolean);
    }

    public static /* synthetic */ void M1(c0 c0Var, Boolean boolean) {
        SettingsFragment.h2(c0Var, boolean);
    }

    public static /* synthetic */ void N1(c0 c0Var, Boolean boolean) {
        SettingsFragment.l2(c0Var, boolean);
    }

    public static /* synthetic */ void O1(c0 c0Var, Boolean boolean) {
        SettingsFragment.i2(c0Var, boolean);
    }

    public static /* synthetic */ void P1(c0 c0Var, Boolean boolean) {
        SettingsFragment.n2(c0Var, boolean);
    }

    public static /* synthetic */ void Q1(c0 c0Var, Boolean boolean) {
        SettingsFragment.y2(c0Var, boolean);
    }

    /* renamed from: R1, reason: from kotlin metadata */
    public static /* synthetic */ void onCreateView(c0 inflater, DialogInterface container, int savedInstanceState) {
        SettingsFragment.onActivityResult(inflater, container, savedInstanceState);
    }

    public static /* synthetic */ void S1(c0 c0Var, Boolean boolean) {
        SettingsFragment.f2(c0Var, boolean);
    }

    public static /* synthetic */ void T1(c0 c0Var, SettingsResults set) {
        SettingsFragment.q2(c0Var, set);
    }

    public static /* synthetic */ void U1(c0 c0Var, Boolean boolean) {
        SettingsFragment.m2(c0Var, boolean);
    }

    public static /* synthetic */ void V1(c0 c0Var, Boolean boolean) {
        SettingsFragment.v2(c0Var, boolean);
    }

    public static /* synthetic */ void W1(c0 c0Var, Boolean boolean) {
        SettingsFragment.w2(c0Var, boolean);
    }

    public static /* synthetic */ void X1(c0 c0Var, Boolean boolean) {
        SettingsFragment.j2(c0Var, boolean);
    }

    public static /* synthetic */ void Y1(c0 c0Var, Boolean boolean) {
        SettingsFragment.onViewCreated(c0Var, boolean);
    }

    public static /* synthetic */ void Z1(c0 c0Var, y yVar) {
        SettingsFragment.r2(c0Var, yVar);
    }

    public static /* synthetic */ void a2(c0 c0Var, String str) {
        SettingsFragment.k2(c0Var, str);
    }

    public static /* synthetic */ void b2(c0 c0Var, Boolean boolean) {
        SettingsFragment.e2(c0Var, boolean);
    }

    public static /* synthetic */ void c2(c0 c0Var, Boolean boolean) {
        SettingsFragment.x2(c0Var, boolean);
    }

    public static /* synthetic */ void d2(c0 c0Var, y yVar) {
        SettingsFragment.t2(c0Var, yVar);
    }
}
