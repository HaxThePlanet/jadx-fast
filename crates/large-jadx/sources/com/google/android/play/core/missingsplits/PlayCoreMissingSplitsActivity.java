package com.google.android.play.core.missingsplits;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.h1;

/* loaded from: classes2.dex */
public class PlayCoreMissingSplitsActivity extends Activity implements DialogInterface.OnClickListener {
    private final String a() {
        return getApplicationInfo().loadLabel(getPackageManager()).toString();
    }

    private final void b(String string) {
        StringBuilder stringBuilder = new StringBuilder(length += 66);
        stringBuilder.append("market://details?id=");
        stringBuilder.append(string);
        stringBuilder.append("&referrer=utm_source%3Dplay.core.missingsplits");
        Intent intent = new Intent("android.intent.action.VIEW");
        startActivity(intent.setData(Uri.parse(stringBuilder.toString())).setPackage("com.android.vending"));
    }

    @Override // android.app.Activity
    public final void onClick(DialogInterface dialogInterface, int i2) {
        int obj1;
        if (i2 != -1) {
        } else {
            b(getPackageName());
        }
        finish();
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        Object message;
        String str;
        int i;
        StringBuilder stringBuilder;
        super.onCreate(bundle);
        AlertDialog.Builder obj5 = new AlertDialog.Builder(this);
        obj5 = obj5.setTitle("Installation failed").setCancelable(false).setNeutralButton("Close", this);
        str = "The app ";
        if (h1.b(this)) {
            String str4 = a();
            stringBuilder = new StringBuilder(length += 91);
            stringBuilder.append(str);
            stringBuilder.append(str4);
            stringBuilder.append(" is missing required components and must be reinstalled from the Google Play Store.");
            obj5.setMessage(stringBuilder.toString()).setPositiveButton("Reinstall", this);
        } else {
            String str6 = a();
            stringBuilder = new StringBuilder(length2 += 87);
            stringBuilder.append(str);
            stringBuilder.append(str6);
            stringBuilder.append(" is missing required components and must be reinstalled from an official store.");
            obj5.setMessage(stringBuilder.toString());
        }
        obj5.create().show();
    }
}
