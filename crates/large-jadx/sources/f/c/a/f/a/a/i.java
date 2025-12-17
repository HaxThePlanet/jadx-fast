package f.c.a.f.a.a;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import com.google.android.play.core.common.a;

/* loaded from: classes2.dex */
final class i implements a {

    final Activity a;
    i(f.c.a.f.a.a.j j, Activity activity2) {
        this.a = activity2;
        super();
    }

    @Override // com.google.android.play.core.common.a
    public final void a(IntentSender intentSender, int i2, Intent intent3, int i4, int i5, int i6, Bundle bundle7) {
        this.a.startIntentSenderForResult(intentSender, i2, intent3, i4, i5, i6, bundle7);
    }
}
