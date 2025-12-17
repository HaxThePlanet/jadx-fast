package app.dogo.com.dogo_android.util;

import androidx.fragment.app.d;
import androidx.fragment.app.n;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/util/AppDialogScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "()V", "showDialog", "Landroidx/fragment/app/DialogFragment;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "name", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class e extends j {
    @Override // app.dogo.com.dogo_android.y.j
    public final d showDialog(n n, String string2) {
        int fragment;
        boolean z;
        int i;
        n.f(n, "fragmentManager");
        n.f(string2, "name");
        if (fragment instanceof d) {
        } else {
            fragment = i;
        }
        androidx.fragment.app.Fragment fragment2 = newFragment();
        if (fragment == null && fragment2 instanceof d) {
            fragment2 = newFragment();
            if (fragment2 instanceof d) {
                i = fragment2;
            }
            if (i == 0) {
            } else {
                i.show(n, string2);
            }
            fragment = i;
        }
        return fragment;
    }
}
