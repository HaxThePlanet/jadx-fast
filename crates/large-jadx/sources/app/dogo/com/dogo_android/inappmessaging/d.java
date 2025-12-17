package app.dogo.com.dogo_android.inappmessaging;

import androidx.lifecycle.y;

/* loaded from: classes.dex */
public final class d implements y {

    public final app.dogo.com.dogo_android.inappmessaging.i a;
    public d(app.dogo.com.dogo_android.inappmessaging.i i) {
        super();
        this.a = i;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        i.I1(this.a, (ZendeskConfigurationInfo)object);
    }
}
