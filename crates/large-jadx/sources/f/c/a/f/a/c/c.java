package f.c.a.f.a.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.play:core@@1.10.2 */
/* loaded from: classes2.dex */
final class c extends BroadcastReceiver {

    final /* synthetic */ d a;
    /* synthetic */ c(d dVar, b bVar) {
        this.a = dVar;
        super();
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.a.a(context, intent);
    }
}
