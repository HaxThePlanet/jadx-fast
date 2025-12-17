package f.c.a.f.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.internal.h;
import f.c.a.f.a.c.d;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public final class g extends d<InstallState> {
    public g(Context context) {
        h hVar = new h("AppUpdateListenerRegistry");
        IntentFilter intentFilter = new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS");
        super(hVar, intentFilter, context);
    }

    @Override // f.c.a.f.a.c.d
    protected final void a(Context context, Intent intent2) {
        Object[] arr;
        String str;
        Object[] arr2;
        Bundle extras;
        String str2 = "package.name";
        int i = 1;
        final int i2 = 0;
        if (!context.getPackageName().equals(intent2.getStringExtra(str2))) {
            Object[] arr4 = new Object[i];
            arr4[i2] = intent2.getStringExtra(str2);
            this.a.a("ListenerRegistryBroadcastReceiver received broadcast for third party app: %s", arr4);
        }
        this.a.a("List of extras in received intent:", new Object[i2]);
        Iterator obj7 = intent2.getExtras().keySet().iterator();
        for (String next2 : obj7) {
            arr2 = new Object[2];
            arr2[i2] = next2;
            arr2[i] = intent2.getExtras().get(next2);
            this.a.a("Key: %s; value: %s", arr2);
        }
        obj7 = InstallState.f(intent2, this.a);
        Object[] arr3 = new Object[i];
        arr3[i2] = obj7;
        this.a.a("ListenerRegistryBroadcastReceiver.onReceive: %s", arr3);
        f(obj7);
    }
}
