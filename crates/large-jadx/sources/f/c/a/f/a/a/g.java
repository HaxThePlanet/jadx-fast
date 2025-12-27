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

/* compiled from: com.google.android.play:core@@1.10.2 */
/* loaded from: classes2.dex */
public final class g extends d<InstallState> {
    public g(Context context) throws android.content.IntentFilter.MalformedMimeTypeException {
        super(new h("AppUpdateListenerRegistry"), new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS"), context);
    }

    @Override // f.c.a.f.a.c.d
    protected final void a(Context context, Intent intent) {
        String str2 = "package.name";
        int i = 1;
        final int i2 = 0;
        if (!context.getPackageName().equals(intent.getStringExtra(str2))) {
            Object[] arr4 = new Object[i];
            this.a.a("ListenerRegistryBroadcastReceiver received broadcast for third party app: %s", intent.getStringExtra("package.name"));
            return;
        }
        str = "List of extras in received intent:";
        this.a.a(str, new Object[i2]);
        Iterator it = intent.getExtras().keySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            Object[] arr2 = new Object[2];
            this.a.a("Key: %s; value: %s", item, intent.getExtras().get(item));
        }
        InstallState installState = InstallState.f(intent, this.a);
        Object[] arr3 = new Object[i];
        this.a.a("ListenerRegistryBroadcastReceiver.onReceive: %s", installState);
        f(installState);
    }
}
