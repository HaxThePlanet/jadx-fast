package app.dogo.com.dogo_android.i;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.cb;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import m.a.b.a.d.a.b;

/* compiled from: DebugFeatureEnablerFragment.kt */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0018\u0010!\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\"H\u0016J\u0008\u0010#\u001a\u00020\u0011H\u0016J\u001e\u0010$\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u000c\u0010%\u001a\u0008\u0012\u0004\u0012\u00020\u00160&H\u0016J\u0018\u0010'\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020(H\u0016J\u0018\u0010)\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u001a\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u001a2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006,", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureEnablerFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDebugFeatureEnablerDialogBinding;", "screenKey", "Lapp/dogo/com/dogo_android/debug/DebugFeatureEnablerScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/debug/DebugFeatureEnablerScreen;", "viewModel", "Lapp/dogo/com/dogo_android/debug/DebugFeatureEnablerViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/debug/DebugFeatureEnablerViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onAttach", "", "context", "Landroid/content/Context;", "onBooleanUpdate", "key", "", "value", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDoubleUpdate", "", "onInvalidValue", "onJsonArrayTap", "selectionList", "", "onLongUpdate", "", "onStringUpdate", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: j0, reason: from kotlin metadata */
public final class DebugFeatureEnablerFragment extends Fragment implements n0.b {

    /* renamed from: a, reason: from kotlin metadata */
    private final h binding;
    private cb b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements kotlin.d0.c.a<l0> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final l0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(DebugFeatureEnablerViewModel.class), this.$parameters);
        }

        public a(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }
    public j0() {
        super();
        final m.a.c.j.a aVar2 = null;
        this.binding = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.debug.j0.a(this, aVar2, aVar2));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    private final l0 onInvalidValue() {
        return (DebugFeatureEnablerViewModel)this.binding.getValue();
    }

    /* renamed from: E1, reason: from kotlin metadata */
    private static final void onJsonArrayTap(j0 key, String selectionList) {
        n.f(key, "this$0");
        key.onInvalidValue().updateList();
    }

    /* renamed from: F1, reason: from kotlin metadata */
    private static final void onLongUpdate(j0 key, View value) {
        n.f(key, "this$0");
        key.requireActivity().getSupportFragmentManager().Z0();
    }

    @Override // androidx.fragment.app.Fragment
    public void I() throws android.content.res.Resources.NotFoundException {
        Toast.makeText(getContext(), "invalid value", 1).show();
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: K0, reason: from kotlin metadata */
    public void onStringUpdate(String key, String value) {
        n.f(key, "key");
        n.f(value, "value");
        onInvalidValue().updateFeature(key, value);
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: S, reason: from kotlin metadata */
    public void onViewCreated(String view, double savedInstanceState) {
        n.f(view, "key");
        onInvalidValue().updateFeature(view, Double.valueOf(savedInstanceState));
    }

    @Override // androidx.fragment.app.Fragment
    public void d1(String str, List<String> list) {
        int i = 0;
        androidx.fragment.app.d str2;
        n.f(str, "key");
        n.f(list, "selectionList");
        e activity = getActivity();
        i = 0;
        if (activity == null) {
        } else {
            str2 = app.dogo.com.dogo_android.util.extensionfunction.g1.showEntryReportDialog(activity, new JsonArrayEditScreen(str, list));
        }
        if (str2 instanceof JsonArrayEditDialog) {
        }
        if (i != 0) {
            i.C1(new app.dogo.com.dogo_android.debug.x(this));
        }
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
        cb cbVar = cb.T(inflater, container, false);
        n.e(cbVar, "inflate(inflater, container, false)");
        this.b = cbVar;
        int i = 0;
        String str4 = "binding";
        if (cbVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            cbVar.W(onInvalidValue());
            if (this.b == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.b.V(this);
                if (this.b == null) {
                    n.w(str4);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    this.b.M(getViewLifecycleOwner());
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
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        if (this.b == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            cbVar.O.setNavigationOnClickListener(new app.dogo.com.dogo_android.debug.w(this));
            return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void r1(String str, boolean z) {
        n.f(str, "key");
        onInvalidValue().updateFeature(str, Boolean.valueOf(z));
    }

    @Override // androidx.fragment.app.Fragment
    public void v0(String str, long j) {
        n.f(str, "key");
        onInvalidValue().updateFeature(str, Long.valueOf(j));
    }


    /* renamed from: C1, reason: from kotlin metadata */
    public static /* synthetic */ void onBooleanUpdate(j0 key, View value) {
        DebugFeatureEnablerFragment.onLongUpdate(key, value);
    }

    /* renamed from: D1, reason: from kotlin metadata */
    public static /* synthetic */ void onDoubleUpdate(j0 key, String value) {
        DebugFeatureEnablerFragment.onJsonArrayTap(key, value);
    }
}
