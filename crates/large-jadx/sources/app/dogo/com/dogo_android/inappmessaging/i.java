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
import com.zendesk.service.a;
import com.zendesk.service.f;
import f.c.a.e.s.b;
import f.d.a.a;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.y.p;
import m.a.b.a.d.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;
import n.a.a;
import zendesk.support.CreateRequest;
import zendesk.support.CustomField;
import zendesk.support.ProviderStore;
import zendesk.support.Request;
import zendesk.support.RequestProvider;
import zendesk.support.Support;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\u000cJ\u0010\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u000c2\u0006\u0010\u001b\u001a\u00020\u00132\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0008\u0010\u001c\u001a\u00020\u000cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/inappmessaging/InAppFeedbackFragmentDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentInnAppFeedbackBinding;", "viewModel", "Lapp/dogo/com/dogo_android/inappmessaging/InAppFeedbackViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/inappmessaging/InAppFeedbackViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "closeDialog", "", "createZendeskTicket", "zendeskInfo", "Lapp/dogo/com/dogo_android/repository/domain/ZendeskConfigurationInfo;", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "showLogin", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i extends d {

    private md a;
    private final h b;

    @Metadata(d1 = "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t", d2 = {"app/dogo/com/dogo_android/inappmessaging/InAppFeedbackFragmentDialog$createZendeskTicket$1", "Lcom/zendesk/service/ZendeskCallback;", "Lzendesk/support/Request;", "onError", "", "error", "Lcom/zendesk/service/ErrorResponse;", "onSuccess", "request", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends f<Request> {

        final app.dogo.com.dogo_android.inappmessaging.i a;
        a(app.dogo.com.dogo_android.inappmessaging.i i) {
            this.a = i;
            super();
        }

        @Override // com.zendesk.service.f
        public void onError(a a) {
            a.c(n.o("Couldn't create Zendesk support ticket ", a), new Object[0]);
        }

        @Override // com.zendesk.service.f
        public void onSuccess(Object object) {
            onSuccess((Request)object);
        }

        @Override // com.zendesk.service.f
        public void onSuccess(Request request) {
            i.B1(this.a).s();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements a<app.dogo.com.dogo_android.inappmessaging.k> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public b(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.inappmessaging.k invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(k.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements a<a> {

        final app.dogo.com.dogo_android.inappmessaging.i this$0;
        c(app.dogo.com.dogo_android.inappmessaging.i i) {
            this.this$0 = i;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            app.dogo.com.dogo_android.y.j jVar = k1.a(this.this$0);
            Object[] arr = new Object[4];
            return b.b(Integer.valueOf((j)jVar.d()), jVar.c(), jVar.b(), jVar.a());
        }
    }
    static {
    }

    public i() {
        super();
        i.c cVar = new i.c(this);
        i.b bVar = new i.b(this, 0, cVar);
        this.b = j.a(m.SYNCHRONIZED, bVar);
    }

    public static final app.dogo.com.dogo_android.inappmessaging.k B1(app.dogo.com.dogo_android.inappmessaging.i i) {
        return i.E1();
    }

    private final void D1(ZendeskConfigurationInfo zendeskConfigurationInfo) {
        Object aVar;
        DogProfile dogProfile;
        String str;
        DogProfile dogProfile2;
        InAppFeedbackExtras trickId;
        Object obj14;
        dogProfile = zendeskConfigurationInfo.getDogProfile();
        str = "";
        if (dogProfile == null) {
            dogProfile = str;
        } else {
        }
        CustomField customField = new CustomField(Long.valueOf(360014716920L), dogProfile);
        CustomField customField2 = new CustomField(Long.valueOf(360014696679L), zendeskConfigurationInfo.getDogPremiumStatus());
        CustomField customField3 = new CustomField(Long.valueOf(360014718880L), zendeskConfigurationInfo.getUserId());
        dogProfile2 = zendeskConfigurationInfo.getDogProfile();
        if (dogProfile2 == null) {
            dogProfile2 = str;
        } else {
        }
        CustomField customField4 = new CustomField(Long.valueOf(360018672760L), dogProfile2);
        CustomField customField5 = new CustomField(Long.valueOf(360014719180L), "Android");
        CustomField customField6 = new CustomField(Long.valueOf(360014746620L), "7.22.1");
        trickId = E1().m();
        if (trickId == null) {
            trickId = str;
        } else {
        }
        CustomField customField7 = new CustomField(Long.valueOf(360019863339L), trickId);
        CustomField customField8 = new CustomField(Long.valueOf(360020343919L), zendeskConfigurationInfo.getDogAge());
        obj14 = zendeskConfigurationInfo.getDogProfile();
        if (obj14 == null) {
        } else {
            obj14 = obj14.getBreedId();
            if (obj14 == null) {
            } else {
                str = obj14;
            }
        }
        CustomField customField9 = new CustomField(Long.valueOf(360020343899L), str);
        obj14 = Support.INSTANCE.provider();
        if (obj14 == null) {
            obj14 = 0;
        } else {
            obj14 = obj14.requestProvider();
        }
        CreateRequest createRequest = new CreateRequest();
        createRequest.setTags(p.j(/* result */));
        createRequest.setSubject(E1().n().getCampaignName());
        createRequest.setDescription((String)E1().o().getValue());
        CustomField[] arr = new CustomField[9];
        createRequest.setCustomFields(p.j(customField, customField2, customField3, customField4, customField5, customField6, customField7, customField8, customField9));
        if (obj14 == null) {
        } else {
            aVar = new i.a(this);
            obj14.createRequest(createRequest, aVar);
        }
    }

    private final app.dogo.com.dogo_android.inappmessaging.k E1() {
        return (k)this.b.getValue();
    }

    public static void F1(app.dogo.com.dogo_android.inappmessaging.i i, Boolean boolean2) {
        i.L1(i, boolean2);
    }

    public static void G1(app.dogo.com.dogo_android.inappmessaging.i i, DialogInterface dialogInterface2, int i3) {
        i.P1(i, dialogInterface2, i3);
    }

    public static void H1(app.dogo.com.dogo_android.inappmessaging.i i, View view2) {
        i.K1(i, view2);
    }

    public static void I1(app.dogo.com.dogo_android.inappmessaging.i i, ZendeskConfigurationInfo zendeskConfigurationInfo2) {
        i.M1(i, zendeskConfigurationInfo2);
    }

    public static void J1(app.dogo.com.dogo_android.inappmessaging.i i, DialogInterface dialogInterface2, int i3) {
        i.O1(i, dialogInterface2, i3);
    }

    private static final void K1(app.dogo.com.dogo_android.inappmessaging.i i, View view2) {
        n.f(i, "this$0");
        i.dismiss();
    }

    private static final void L1(app.dogo.com.dogo_android.inappmessaging.i i, Boolean boolean2) {
        n.f(i, "this$0");
        final androidx.lifecycle.q viewLifecycleOwner = i.getViewLifecycleOwner();
        n.e(viewLifecycleOwner, "viewLifecycleOwner");
        d dVar = new d(i);
        i.E1().l().observe(viewLifecycleOwner, dVar);
        if (i.E1().q()) {
            i.N1();
        } else {
            i.C1();
        }
    }

    private static final void M1(app.dogo.com.dogo_android.inappmessaging.i i, ZendeskConfigurationInfo zendeskConfigurationInfo2) {
        n.f(i, "this$0");
        n.e(zendeskConfigurationInfo2, "it");
        i.D1(zendeskConfigurationInfo2);
    }

    private final void N1() {
        b bVar = new b(requireActivity());
        e eVar = new e(this);
        b bVar6 = new b(this);
        bVar.w(2131886499).D(2131886838, eVar).y(2131886677, bVar6).t(false).o();
    }

    private static final void O1(app.dogo.com.dogo_android.inappmessaging.i i, DialogInterface dialogInterface2, int i3) {
        int i2;
        String str;
        int i5;
        int i6;
        int i4;
        n.f(i, "this$0");
        final androidx.fragment.app.e activity = i.getActivity();
        if (activity == null) {
        } else {
            g1.H(activity, 0, "in_app_feedback_message", 0, 5, 0);
        }
        i.C1();
    }

    private static final void P1(app.dogo.com.dogo_android.inappmessaging.i i, DialogInterface dialogInterface2, int i3) {
        n.f(i, "this$0");
        i.C1();
    }

    @Override // androidx.fragment.app.d
    public final void C1() {
        dismiss();
        Toast.makeText(requireActivity().getApplicationContext(), 2131886767, 0).show();
    }

    @Override // androidx.fragment.app.d
    public int getTheme() {
        return 2131952268;
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        md obj2 = md.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.V(E1());
            obj2 = this.a;
            if (obj2 == null) {
            } else {
                obj2.M(getViewLifecycleOwner());
                obj2 = this.a;
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

    @Override // androidx.fragment.app.d
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        md obj2 = this.a;
        if (obj2 == null) {
        } else {
            c obj3 = new c(this);
            obj2.Q.setOnClickListener(obj3);
            obj3 = getViewLifecycleOwner();
            n.e(obj3, "viewLifecycleOwner");
            a aVar = new a(this);
            E1().k().observe(obj3, aVar);
        }
        n.w("binding");
        throw 0;
    }
}
