package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.internal.g;
import com.google.android.gms.common.b;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {

    protected int a = 0;
    public GoogleApiActivity() {
        super();
        final int i = 0;
    }

    public static Intent a(Context context, PendingIntent pendingIntent2, int i3, boolean z4) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent2);
        intent.putExtra("failing_client_id", i3);
        intent.putExtra("notify_manager", z4);
        return intent;
    }

    private final void b() {
        String bVar;
        String str2;
        Throwable th;
        String str;
        Bundle extras = getIntent().getExtras();
        String str5 = "GoogleApiActivity";
        if (extras == null) {
            Log.e(str5, "Activity started without extras");
            finish();
        }
        Object obj = extras.get("pending_intent");
        Object obj2 = extras.get("error_code");
        if ((PendingIntent)obj == null && (Integer)obj2 != null) {
            if ((Integer)obj2 != null) {
            }
            Log.e(str5, "Activity started without resolution");
            finish();
        }
        final int i2 = 1;
        if ((PendingIntent)obj != null) {
            this.startIntentSenderForResult((PendingIntent)obj.getIntentSender(), 1, 0, 0, 0, 0);
            this.a = i2;
        }
        r.j((Integer)obj2);
        e.o().p(this, (Integer)obj2.intValue(), 2, this);
        this.a = i2;
    }

    @Override // android.app.Activity
    protected final void onActivityResult(int i, int i2, Intent intent3) {
        int intent;
        int str;
        String str2;
        int obj4;
        int obj5;
        Intent obj6;
        super.onActivityResult(i, i2, intent3);
        intent = 0;
        str = 1;
        if (i == str) {
            this.a = intent;
            setResult(i2, intent3);
            if (getIntent().getBooleanExtra("notify_manager", str)) {
                obj4 = g.n(this);
                obj6 = -1;
                if (i2 != obj6) {
                    if (i2 != 0) {
                    } else {
                        obj5 = new b(13, 0);
                        obj4.B(obj5, getIntent().getIntExtra("failing_client_id", obj6));
                    }
                } else {
                    obj4.t();
                }
            }
        } else {
            if (i == 2) {
                this.a = intent;
                setResult(i2, intent3);
            }
        }
        finish();
    }

    @Override // android.app.Activity
    public final void onCancel(DialogInterface dialogInterface) {
        final int obj1 = 0;
        this.a = obj1;
        setResult(obj1);
        finish();
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        String str;
        Bundle obj2;
        super.onCreate(bundle);
        if (bundle != null) {
            this.a = bundle.getInt("resolution");
        }
        if (this.a != 1) {
            b();
        }
    }

    @Override // android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.a);
        super.onSaveInstanceState(bundle);
    }
}
