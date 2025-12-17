package com.google.android.play.core.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.View;
import android.view.Window;

/* loaded from: classes2.dex */
public class PlayCoreDialogWrapperActivity extends Activity {

    private ResultReceiver a;
    @Override // android.app.Activity
    protected final void onActivityResult(int i, int i2, Intent intent3) {
        int obj1;
        int obj2;
        Intent obj3;
        super.onActivityResult(i, i2, intent3);
        obj1 = this.a;
        if (i == 0 && obj1 != null) {
            obj1 = this.a;
            if (obj1 != null) {
                if (i2 == -1) {
                    obj2 = new Bundle();
                    obj1.send(1, obj2);
                } else {
                    if (i2 == 0) {
                        obj2 = new Bundle();
                        obj1.send(2, obj2);
                    }
                }
            }
        }
        finish();
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        int i;
        Intent intent;
        final String str3 = "window_flags";
        int intExtra = getIntent().getIntExtra(str3, 0);
        if (intExtra != 0) {
            getWindow().getDecorView().setSystemUiVisibility(intExtra);
            intent = new Intent();
            intent.putExtra(str3, intExtra);
        } else {
            intent = 0;
        }
        super.onCreate(bundle);
        String str = "result_receiver";
        if (bundle == null) {
            this.a = (ResultReceiver)getIntent().getParcelableExtra(str);
            this.startIntentSenderForResult((PendingIntent)getIntent().getExtras().get("confirmation_intent").getIntentSender(), 0, intent, 0, 0, 0);
        }
        this.a = (ResultReceiver)bundle.getParcelable(str);
    }

    @Override // android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable("result_receiver", this.a);
    }
}
