package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* loaded from: classes.dex */
public abstract class g {
    @Deprecated
    public androidx.fragment.app.Fragment b(Context context, String string2, Bundle bundle3) {
        return Fragment.instantiate(context, string2, bundle3);
    }

    public abstract View c(int i);

    public abstract boolean d();
}
