package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.ResultReceiver;
import f.c.a.d.b.i.a;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public class ProxyBillingActivity extends Activity {

    private ResultReceiver a;
    private boolean b;
    private final Intent a() {
        final Intent intent = new Intent("com.android.vending.billing.PURCHASES_UPDATED");
        intent.setPackage(getApplicationContext().getPackageName());
        return intent;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = -1;
        String str;
        int i4;
        ResultReceiver resultReceiver;
        String str3;
        Bundle extras = null;
        super.onActivityResult(i, i2, intent);
        final boolean z = false;
        final String str4 = "ProxyBillingActivity";
        i3 = 100;
        if (i == 100) {
            i4 = a.g(intent, str4).b();
            i3 = -1;
            if (i2 != i3 || i4 != 0) {
                StringBuilder stringBuilder = new StringBuilder(85);
                str = "Activity finished with resultCode ";
                String str9 = " and billing's responseCode: ";
                str2 = 85 + str + i3 + str9 + i4;
                a.k(str4, str2);
            } else {
            }
            if (this.a != null) {
                if (intent == null) {
                    int i7 = 0;
                } else {
                    extras = intent.getExtras();
                }
                this.a.send(i4, extras);
            } else {
                intent = a();
                if (intent != null) {
                    if (intent.getExtras() != null) {
                        intent.putExtras(intent.getExtras());
                    } else {
                        a.k(str4, "Got null bundle!");
                        intent.putExtra("RESPONSE_CODE", 6);
                        str3 = "An internal error occurred.";
                        intent.putExtra("DEBUG_MESSAGE", str3);
                    }
                }
                sendBroadcast(intent);
            }
        } else {
            StringBuilder stringBuilder2 = new StringBuilder(69);
            str3 = "Got onActivityResult with wrong requestCode: ";
            String str5 = "; skipping...";
            str6 = 69 + str3 + i + str5;
            a.k(str4, str6);
        }
        this.b = z;
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        String str3;
        String str4;
        int i;
        super.onCreate(bundle);
        str = "result_receiver";
        String str5 = "ProxyBillingActivity";
        if (bundle == null) {
            a.j(str5, "Launching Play Store billing flow");
            str2 = "BUY_INTENT";
            if (getIntent().hasExtra(str2)) {
                android.os.Parcelable parcelableExtra3 = getIntent().getParcelableExtra(str2);
            } else {
                str2 = "SUBS_MANAGEMENT_INTENT";
                if (getIntent().hasExtra(str2)) {
                    android.os.Parcelable parcelableExtra2 = getIntent().getParcelableExtra(str2);
                    this.a = (ResultReceiver)getIntent().getParcelableExtra(str);
                } else {
                    i = 0;
                }
            }
            try {
                this.b = true;
                this.startIntentSenderForResult(i.getIntentSender(), 100, new Intent(), 0, 0, 0);
            } catch (android.content.IntentSender.SendIntentException sendIntent) {
                sendIntent = String.valueOf(sendIntent);
                str3 = String.valueOf(sendIntent);
                str3 = str3.length();
                str3 += 53;
                StringBuilder stringBuilder = new StringBuilder(str3);
                str3 = "Got exception while trying to start a purchase flow: ";
                sendIntent = str3 + str3 + sendIntent;
                a.k(str4, sendIntent);
                str3 = 6;
            }
            return;
        }
        a.j(str5, "Launching Play Store billing flow from savedInstanceState");
        this.b = this.a.getBoolean("send_cancelled_broadcast_if_finished", false);
        if (this.a.containsKey(str)) {
            this.a = (ResultReceiver)this.a.getParcelable(str);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (!isFinishing()) {
            return;
        }
        if (!this.b) {
            return;
        }
        Intent intent = a();
        intent.putExtra("RESPONSE_CODE", 1);
        intent.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
        sendBroadcast(intent);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.a != null) {
            str = "result_receiver";
            bundle.putParcelable(str, this.a);
        }
        bundle.putBoolean("send_cancelled_broadcast_if_finished", this.b);
    }
}
