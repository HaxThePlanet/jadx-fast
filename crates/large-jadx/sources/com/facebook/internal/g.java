package com.facebook.internal;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import com.facebook.FacebookException;
import com.facebook.o;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\u0008\u000bJ\u001c\u0010\u000c\u001a\u00020\n2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\n2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\n2\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0017\u001a\u00020\u00042\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\u0008\u0010\u0018\u001a\u00020\nH\u0016J\u0008\u0010\u0019\u001a\u00020\nH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008¨\u0006\u001b", d2 = {"Lcom/facebook/internal/FacebookDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "innerDialog", "Landroid/app/Dialog;", "getInnerDialog", "()Landroid/app/Dialog;", "setInnerDialog", "(Landroid/app/Dialog;)V", "initDialog", "", "initDialog$facebook_common_release", "onCompleteWebDialog", "values", "Landroid/os/Bundle;", "error", "Lcom/facebook/FacebookException;", "onCompleteWebFallbackDialog", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "onCreateDialog", "onDestroyView", "onResume", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class g extends d {

    private Dialog a;

    @Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\u0008\u0006", d2 = {"<anonymous>", "", "values", "Landroid/os/Bundle;", "error", "Lcom/facebook/FacebookException;", "onComplete"}, k = 3, mv = {1, 5, 1})
    static final class a implements com.facebook.internal.d0.e {

        final com.facebook.internal.g a;
        a(com.facebook.internal.g g) {
            this.a = g;
            super();
        }

        @Override // com.facebook.internal.d0$e
        public final void a(Bundle bundle, FacebookException facebookException2) {
            g.B1(this.a, bundle, facebookException2);
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\u0008\u0006", d2 = {"<anonymous>", "", "values", "Landroid/os/Bundle;", "<anonymous parameter 1>", "Lcom/facebook/FacebookException;", "onComplete"}, k = 3, mv = {1, 5, 1})
    static final class b implements com.facebook.internal.d0.e {

        final com.facebook.internal.g a;
        b(com.facebook.internal.g g) {
            this.a = g;
            super();
        }

        @Override // com.facebook.internal.d0$e
        public final void a(Bundle bundle, FacebookException facebookException2) {
            g.C1(this.a, bundle);
        }
    }
    static {
    }

    public static final void B1(com.facebook.internal.g g, Bundle bundle2, FacebookException facebookException3) {
        g.E1(bundle2, facebookException3);
    }

    public static final void C1(com.facebook.internal.g g, Bundle bundle2) {
        g.F1(bundle2);
    }

    private final void E1(Bundle bundle, FacebookException facebookException2) {
        Intent intent;
        String str;
        Object obj4;
        int obj5;
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            n.e(activity, "activity ?: return");
            intent = activity.getIntent();
            n.e(intent, "fragmentActivity.intent");
            obj5 = facebookException2 == null ? -1 : 0;
            activity.setResult(obj5, w.o(intent, bundle, facebookException2));
            activity.finish();
        }
    }

    private final void F1(Bundle bundle) {
        Intent intent;
        Bundle obj3;
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            n.e(activity, "activity ?: return");
            intent = new Intent();
            if (bundle != null) {
            } else {
                obj3 = new Bundle();
            }
            intent.putExtras(obj3);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }

    @Override // androidx.fragment.app.d
    public final void D1() {
        com.facebook.internal.d0 activity;
        Object bVar;
        com.facebook.internal.k.a string;
        boolean boolean;
        String str2;
        String str;
        int string2;
        if (this.a != null) {
        }
        activity = getActivity();
        if (activity != null) {
            n.e(activity, "activity ?: return");
            Intent intent = activity.getIntent();
            n.e(intent, "intent");
            Bundle bundle = w.w(intent);
            int i2 = 0;
            if (bundle != null) {
                boolean = bundle.getBoolean("is_fallback", i2);
            } else {
                boolean = i2;
            }
            str2 = "FacebookDialogFragment";
            str = "null cannot be cast to non-null type kotlin.String";
            if (!boolean) {
                if (bundle != null) {
                    string = bundle.getString("action");
                } else {
                    string = string2;
                }
                if (bundle != null) {
                    string2 = bundle.getBundle("params");
                }
                if (b0.W(string)) {
                    b0.d0(str2, "Cannot start a WebDialog with an empty/missing 'actionName'");
                    activity.finish();
                }
                Objects.requireNonNull(string, str);
                bVar = new d0.a(activity, string, string2);
                g.a aVar = new g.a(this);
                bVar.h(aVar);
                activity = bVar.a();
            } else {
                if (bundle != null) {
                    string2 = bundle.getString("url");
                }
                if (b0.W(string2)) {
                    b0.d0(str2, "Cannot start a fallback WebDialog with an empty/missing 'url'");
                    activity.finish();
                }
                f0 f0Var = f0.a;
                int i = 1;
                boolean = new Object[i];
                boolean[i2] = o.g();
                String format = String.format("fb%s://bridge/", Arrays.copyOf(boolean, i));
                n.e(format, "java.lang.String.format(format, *args)");
                Objects.requireNonNull(string2, str);
                bVar = new g.b(this);
                k.K.a(activity, string2, format).w(bVar);
            }
            this.a = activity;
        }
    }

    @Override // androidx.fragment.app.d
    public final void G1(Dialog dialog) {
        this.a = dialog;
    }

    @Override // androidx.fragment.app.d
    public void onConfigurationChanged(Configuration configuration) {
        String str;
        boolean obj2;
        n.f(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        if (obj2 instanceof d0 && isResumed()) {
            if (isResumed()) {
                obj2 = this.a;
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type com.facebook.internal.WebDialog");
                (d0)obj2.s();
            }
        }
    }

    @Override // androidx.fragment.app.d
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        D1();
    }

    @Override // androidx.fragment.app.d
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.a;
        if (dialog == null) {
            int i = 0;
            E1(i, i);
            setShowsDialog(false);
            Dialog obj2 = super.onCreateDialog(bundle);
            n.e(obj2, "super.onCreateDialog(savedInstanceState)");
            return obj2;
        }
        Objects.requireNonNull(dialog, "null cannot be cast to non-null type android.app.Dialog");
        return dialog;
    }

    @Override // androidx.fragment.app.d
    public void onDestroyView() {
        boolean retainInstance;
        final Dialog dialog = getDialog();
        if (dialog != null && getRetainInstance()) {
            if (getRetainInstance()) {
                dialog.setDismissMessage(0);
            }
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.d
    public void onResume() {
        boolean str;
        super.onResume();
        final Dialog dialog = this.a;
        if (dialog instanceof d0) {
            Objects.requireNonNull(dialog, "null cannot be cast to non-null type com.facebook.internal.WebDialog");
            (d0)dialog.s();
        }
    }
}
