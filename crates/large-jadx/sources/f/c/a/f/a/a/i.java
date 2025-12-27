package f.c.a.f.a.a;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import com.google.android.play.core.common.a;

/* compiled from: com.google.android.play:core@@1.10.2 */
/* loaded from: classes2.dex */
final class i implements a {

    final /* synthetic */ Activity a;
    public final void a(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws android.content.IntentSender.SendIntentException {
        this.a.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    i(j jVar, Activity activity) {
        this.a = activity;
        super();
    }
}
