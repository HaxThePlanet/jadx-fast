package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import d.q.a.a;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00082\u0008\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0012\u0010\u000c\u001a\u00020\u00062\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0008\u0010\u000f\u001a\u00020\u0006H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Lcom/facebook/CustomTabActivity;", "Landroid/app/Activity;", "()V", "closeReceiver", "Landroid/content/BroadcastReceiver;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class CustomTabActivity extends Activity {

    public static final String b;
    public static final String c;
    private BroadcastReceiver a;

    @Metadata(d1 = "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0008", d2 = {"com/facebook/CustomTabActivity$onActivityResult$closeReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public static final class a extends BroadcastReceiver {

        final com.facebook.CustomTabActivity a;
        a(com.facebook.CustomTabActivity customTabActivity) {
            this.a = customTabActivity;
            super();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent2) {
            n.f(context, "context");
            n.f(intent2, "intent");
            this.a.finish();
        }
    }
    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CustomTabActivity.class.getSimpleName());
        stringBuilder.append(".action_customTabRedirect");
        CustomTabActivity.b = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(CustomTabActivity.class.getSimpleName());
        stringBuilder2.append(".action_destroy");
        CustomTabActivity.c = stringBuilder2.toString();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent3) {
        String str;
        int obj2;
        int obj3;
        Object obj4;
        super.onActivityResult(i, i2, intent3);
        if (i2 == 0) {
            obj2 = new Intent(CustomTabActivity.b);
            obj4 = getIntent();
            n.e(obj4, "intent");
            obj2.putExtra(CustomTabMainActivity.x, obj4.getDataString());
            a.b(this).d(obj2);
            obj2 = new CustomTabActivity.a(this);
            obj4 = new IntentFilter(CustomTabActivity.c);
            a.b(this).c(obj2, obj4);
            this.a = obj2;
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent obj4 = new Intent(this, CustomTabMainActivity.class);
        obj4.setAction(CustomTabActivity.b);
        Intent intent = getIntent();
        n.e(intent, "getIntent()");
        obj4.putExtra(CustomTabMainActivity.x, intent.getDataString());
        obj4.addFlags(603979776);
        startActivityForResult(obj4, 2);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        a aVar;
        final BroadcastReceiver broadcastReceiver = this.a;
        if (broadcastReceiver != null) {
            a.b(this).e(broadcastReceiver);
        }
        super.onDestroy();
    }
}
