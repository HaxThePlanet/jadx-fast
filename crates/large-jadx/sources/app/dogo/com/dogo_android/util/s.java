package app.dogo.com.dogo_android.util;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.d;
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.u;
import app.dogo.com.dogo_android.w.k3;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u001e\u0010\u000b\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\r0\u000c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/util/LoadingSpinnerDialog;", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyBaseDialogFragment;", "()V", "fragmentTag", "Lapp/dogo/com/dogo_android/enums/DialogTags;", "getFragmentTag", "()Lapp/dogo/com/dogo_android/enums/DialogTags;", "screenViewDescriptor", "Lapp/dogo/com/dogo_android/tracking/Screen;", "getScreenViewDescriptor", "()Lapp/dogo/com/dogo_android/tracking/Screen;", "viewModelClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "getViewModelClass", "()Ljava/lang/Class;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class s extends u {
    @Override // app.dogo.com.dogo_android.util.e0.u
    public c E1() {
        return c.LOADING_DIALOG_FRAGMENT;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public k3 H1() {
        return null;
    }

    public Class<? extends r> J1() {
        return r.class;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        final int i = 0;
        setCancelable(i);
        return layoutInflater.inflate(2131558682, viewGroup2, i);
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public void onResume() {
        boolean dialog;
        super.onResume();
        dialog = G1();
        if (dialog != null) {
            if (!dialog.J()) {
                dialog = getDialog();
                n.d(dialog);
                dialog.dismiss();
            }
        } else {
        }
    }
}
