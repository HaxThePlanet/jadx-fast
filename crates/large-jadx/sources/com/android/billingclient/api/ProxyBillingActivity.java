package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import f.c.a.d.b.i.a;

/* loaded from: classes.dex */
public class ProxyBillingActivity extends Activity {

    private ResultReceiver a;
    private boolean b;
    private final Intent a() {
        Intent intent = new Intent("com.android.vending.billing.PURCHASES_UPDATED");
        intent.setPackage(getApplicationContext().getPackageName());
        return intent;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent3) {
        int stringBuilder;
        String str;
        Intent obj5;
        Object obj6;
        Object obj7;
        super.onActivityResult(i, i2, intent3);
        final int i3 = 0;
        final String str2 = "ProxyBillingActivity";
        if (i == 100) {
            obj5 = a.g(intent3, str2).b();
            stringBuilder = -1;
            if (i2 == stringBuilder) {
                if (obj5 != null) {
                    obj6 = stringBuilder;
                    stringBuilder = new StringBuilder(85);
                    stringBuilder.append("Activity finished with resultCode ");
                    stringBuilder.append(obj6);
                    stringBuilder.append(" and billing's responseCode: ");
                    stringBuilder.append(obj5);
                    a.k(str2, stringBuilder.toString());
                } else {
                    obj5 = i3;
                }
            } else {
            }
            obj6 = this.a;
            if (obj6 != null) {
                if (intent3 == null) {
                    obj7 = 0;
                } else {
                    obj7 = intent3.getExtras();
                }
                obj6.send(obj5, obj7);
            } else {
                obj5 = a();
                if (intent3 != null) {
                    if (intent3.getExtras() != null) {
                        obj5.putExtras(intent3.getExtras());
                    } else {
                        a.k(str2, "Got null bundle!");
                        obj5.putExtra("RESPONSE_CODE", 6);
                        obj5.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                    }
                }
                sendBroadcast(obj5);
            }
        } else {
            obj6 = new StringBuilder(69);
            obj6.append("Got onActivityResult with wrong requestCode: ");
            obj6.append(i);
            obj6.append("; skipping...");
            a.k(str2, obj6.toString());
        }
        this.b = i3;
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        String str2;
        Object parcelableExtra;
        String str;
        Object intent;
        Object obj13;
        super.onCreate(bundle);
        parcelableExtra = "result_receiver";
        String str3 = "ProxyBillingActivity";
        if (bundle == null) {
            a.j(str3, "Launching Play Store billing flow");
            intent = "BUY_INTENT";
            if (getIntent().hasExtra(intent)) {
                obj13 = getIntent().getParcelableExtra(intent);
            } else {
                intent = "SUBS_MANAGEMENT_INTENT";
                if (getIntent().hasExtra(intent)) {
                    obj13 = getIntent().getParcelableExtra(intent);
                    this.a = (ResultReceiver)getIntent().getParcelableExtra(parcelableExtra);
                } else {
                    obj13 = i3;
                }
            }
            this.b = true;
            Intent intent2 = new Intent();
            this.startIntentSenderForResult(obj13.getIntentSender(), 100, intent2, 0, 0, 0);
        }
        a.j(str3, "Launching Play Store billing flow from savedInstanceState");
        this.b = bundle.getBoolean("send_cancelled_broadcast_if_finished", false);
        if (bundle.containsKey(parcelableExtra)) {
            this.a = (ResultReceiver)bundle.getParcelable(parcelableExtra);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (!isFinishing()) {
        }
        if (!this.b) {
        }
        Intent intent = a();
        intent.putExtra("RESPONSE_CODE", 1);
        intent.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
        sendBroadcast(intent);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        String str;
        ResultReceiver resultReceiver = this.a;
        if (resultReceiver != null) {
            bundle.putParcelable("result_receiver", resultReceiver);
        }
        bundle.putBoolean("send_cancelled_broadcast_if_finished", this.b);
    }
}
