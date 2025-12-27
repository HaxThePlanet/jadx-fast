package app.dogo.com.dogo_android.inappmessaging;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.c.a;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.md;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.InAppFeedbackExtras;
import app.dogo.com.dogo_android.repository.domain.InAppMessageDataHolder;
import app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import com.zendesk.service.f;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import zendesk.support.CreateRequest;
import zendesk.support.CustomField;
import zendesk.support.ProviderStore;
import zendesk.support.Request;
import zendesk.support.RequestProvider;
import zendesk.support.Support;

/* compiled from: InAppFeedbackFragmentDialog.kt */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\u000cJ\u0010\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u000c2\u0006\u0010\u001b\u001a\u00020\u00132\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0008\u0010\u001c\u001a\u00020\u000cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/inappmessaging/InAppFeedbackFragmentDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentInnAppFeedbackBinding;", "viewModel", "Lapp/dogo/com/dogo_android/inappmessaging/InAppFeedbackViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/inappmessaging/InAppFeedbackViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "closeDialog", "", "createZendeskTicket", "zendeskInfo", "Lapp/dogo/com/dogo_android/repository/domain/ZendeskConfigurationInfo;", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "showLogin", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i, reason: from kotlin metadata */
public final class InAppFeedbackFragmentDialog extends d {

    /* renamed from: a, reason: from kotlin metadata */
    private md binding;
    private final h b;

    @Metadata(d1 = "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t", d2 = {"app/dogo/com/dogo_android/inappmessaging/InAppFeedbackFragmentDialog$createZendeskTicket$1", "Lcom/zendesk/service/ZendeskCallback;", "Lzendesk/support/Request;", "onError", "", "error", "Lcom/zendesk/service/ErrorResponse;", "onSuccess", "request", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends f<Request> {

        final /* synthetic */ i a;
        a() {
            this.a = iVar;
            super();
        }

        @Override // com.zendesk.service.f
        public void onError(com.zendesk.service.a error) {
            a.c(n.o("Couldn't create Zendesk support ticket ", error), new Object[0]);
        }

        @Override // com.zendesk.service.f
        public void onSuccess(Request request) {
            this.a.closeDialog().s();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends kotlin.d0.d.p implements kotlin.d0.c.a<k> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final k invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(InAppFeedbackViewModel.class), this.$parameters);
        }

        public b(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends kotlin.d0.d.p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            app.dogo.com.dogo_android.y.j jVar = app.dogo.com.dogo_android.util.extensionfunction.k1.a(i.this);
            Object[] arr = new Object[4];
            return org.koin.core.parameter.b.b(new Object[] { Integer.valueOf(jVar.d()), jVar.c(), jVar.b(), jVar.createFragment() });
        }

        c() {
            super(0);
        }
    }
    public i() {
        super();
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new i.b(this, null, new i.c(this)));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ k createZendeskTicket(i zendeskInfo) {
        return zendeskInfo.closeDialog();
    }

    private final void D1(ZendeskConfigurationInfo zendeskConfigurationInfo) {
        String zendeskConfigurationInfo2;
        Object obj;
        int i = 0;
        DogProfile dogProfile = zendeskConfigurationInfo.getDogProfile();
        zendeskConfigurationInfo2 = "";
        long l2 = zendeskConfigurationInfo2;
        CustomField customField = new CustomField(Long.valueOf(360014716920L), zendeskConfigurationInfo2);
        DogProfile dogProfile2 = zendeskConfigurationInfo.getDogProfile();
        long l7 = zendeskConfigurationInfo2;
        CustomField customField4 = new CustomField(Long.valueOf(360018672760L, l7), zendeskConfigurationInfo2);
        InAppFeedbackExtras inAppFeedbackExtras = this.closeDialog().m();
        long l13 = zendeskConfigurationInfo2;
        CustomField customField7 = new CustomField(Long.valueOf(360019863339L, l13), zendeskConfigurationInfo2);
        DogProfile dogProfile3 = zendeskConfigurationInfo.getDogProfile();
        if (dogProfile3 != null) {
            zendeskConfigurationInfo2 = dogProfile3.getBreedId();
            if (zendeskConfigurationInfo2 != null) {
            }
        }
        CustomField customField9 = new CustomField(Long.valueOf(360020343899L, l17), zendeskConfigurationInfo2);
        ProviderStore provider = Support.INSTANCE.provider();
        if (provider == null) {
            i = 0;
        } else {
            RequestProvider requestProvider = provider.requestProvider();
        }
        CreateRequest createRequest = new CreateRequest();
        createRequest.setTags(p.j(new String[] { "nps_feedback", "android", "mobile" }));
        createRequest.setSubject(closeDialog().n().getCampaignName());
        createRequest.setDescription((String)closeDialog().o().getValue());
        CustomField[] arr = new CustomField[9];
        createRequest.setCustomFields(p.j(new CustomField[] { customField, new CustomField(Long.valueOf(360014696679L, l5), zendeskConfigurationInfo.getDogPremiumStatus()), new CustomField(Long.valueOf(360014718880L, l5), zendeskConfigurationInfo.getUserId()), customField4, new CustomField(Long.valueOf(360014719180L, l9), "Android"), new CustomField(Long.valueOf(360014746620L, l11), "7.22.1"), customField7, new CustomField(Long.valueOf(360020343919L, l15), zendeskConfigurationInfo.getDogAge()), customField9 }));
        if (Support.INSTANCE != null) {
            i.createRequest(createRequest, new InAppFeedbackFragmentDialog_createZendeskTicket_1(this));
        }
    }

    /* renamed from: E1, reason: from kotlin metadata */
    private final k closeDialog() {
        return (InAppFeedbackViewModel)this.b.getValue();
    }

    private static final void K1(i iVar, View view) {
        n.f(iVar, "this$0");
        iVar.dismiss();
    }

    private static final void L1(i iVar, Boolean boolean) {
        n.f(iVar, "this$0");
        final androidx.lifecycle.q viewLifecycleOwner = iVar.getViewLifecycleOwner();
        n.e(viewLifecycleOwner, "viewLifecycleOwner");
        iVar.closeDialog().l().observe(viewLifecycleOwner, new d(iVar));
        if (iVar.closeDialog().q()) {
            iVar.N1();
        } else {
            iVar.C1();
        }
    }

    private static final void M1(i iVar, ZendeskConfigurationInfo zendeskConfigurationInfo) {
        n.f(iVar, "this$0");
        n.e(zendeskConfigurationInfo, "it");
        iVar.D1(zendeskConfigurationInfo);
    }

    private final void N1() {
        new b(requireActivity()).w(2131886499).D(2131886838, new e(this)).y(2131886677, new b(this)).t(false).o();
    }

    private static final void O1(i iVar, DialogInterface dialogInterface, int i) {
        n.f(iVar, "this$0");
        final androidx.fragment.app.e activity = iVar.getActivity();
        if (activity != null) {
            i = 0;
            ZendeskConfigurationInfo zendeskConfigurationInfo = null;
            int i2 = 5;
            Object obj = null;
            str = "in_app_feedback_message";
            app.dogo.com.dogo_android.util.extensionfunction.g1.H(activity, i, str, zendeskConfigurationInfo, i2, obj);
        }
        iVar.C1();
    }

    private static final void P1(i iVar, DialogInterface dialogInterface, int i) {
        n.f(iVar, "this$0");
        iVar.C1();
    }

    @Override // androidx.fragment.app.d
    public final void C1() throws android.content.res.Resources.NotFoundException {
        dismiss();
        Toast.makeText(requireActivity().getApplicationContext(), 2131886767, 0).show();
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        n.f(layoutInflater, "inflater");
        md mdVar = md.T(layoutInflater, viewGroup, false);
        n.e(mdVar, "inflate(inflater, container, false)");
        this.binding = mdVar;
        int i = 0;
        String str3 = "binding";
        if (mdVar == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            mdVar.V(closeDialog());
            if (this.binding == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.M(getViewLifecycleOwner());
                if (this.binding == null) {
                    n.w(str3);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    return this.binding.w();
                }
            }
        }
    }

    @Override // androidx.fragment.app.d
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        if (this.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            binding2.Q.setOnClickListener(new c(this));
            androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
            n.e(viewLifecycleOwner, "viewLifecycleOwner");
            closeDialog().k().observe(viewLifecycleOwner, new a(this));
            return;
        }
    }


    /* renamed from: F1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(i view, Boolean savedInstanceState) {
        InAppFeedbackFragmentDialog.L1(view, savedInstanceState);
    }

    /* renamed from: G1, reason: from kotlin metadata */
    public static /* synthetic */ void onCreateView(i inflater, DialogInterface container, int savedInstanceState) {
        InAppFeedbackFragmentDialog.P1(inflater, container, savedInstanceState);
    }

    public static /* synthetic */ void H1(i iVar, View view) {
        InAppFeedbackFragmentDialog.K1(iVar, view);
    }

    public static /* synthetic */ void I1(i iVar, ZendeskConfigurationInfo zendeskConfigurationInfo) {
        InAppFeedbackFragmentDialog.M1(iVar, zendeskConfigurationInfo);
    }

    public static /* synthetic */ void J1(i iVar, DialogInterface dialogInterface, int i) {
        InAppFeedbackFragmentDialog.O1(iVar, dialogInterface, i);
    }

    @Override // androidx.fragment.app.d
    public int getTheme() {
        return R.style.RoundedCornersDialog;
    }
}
