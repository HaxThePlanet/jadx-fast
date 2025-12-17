package app.dogo.com.dogo_android.inbox;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.d;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.f;
import app.dogo.com.dogo_android.h.a;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.t;
import app.dogo.com.dogo_android.util.t.a;
import f.c.a.f.a.d.a;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0014J\u0008\u0010\t\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u00020\u00062\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/inbox/CustomIterableInboxActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/ActivityCustomInboxBinding;", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CustomIterableInboxActivity extends d {

    private a a;
    public static void i(app.dogo.com.dogo_android.inbox.CustomIterableInboxActivity customIterableInboxActivity, View view2) {
        CustomIterableInboxActivity.j(customIterableInboxActivity, view2);
    }

    private static final void j(app.dogo.com.dogo_android.inbox.CustomIterableInboxActivity customIterableInboxActivity, View view2) {
        n.f(customIterableInboxActivity, "this$0");
        customIterableInboxActivity.onBackPressed();
    }

    @Override // androidx.appcompat.app.d
    protected void attachBaseContext(Context context) {
        n.f(context, "newBase");
        t.a companion = t.Companion;
        final Context obj4 = companion.b(context, n2.b(App.Companion.l().W()));
        super.attachBaseContext(obj4);
        android.content.res.Resources resources = getResources();
        n.e(resources, "resources");
        companion.c(resources, obj4);
        a.b(this);
    }

    @Override // androidx.appcompat.app.d
    public void onBackPressed() {
        finish();
    }

    @Override // androidx.appcompat.app.d
    protected void onCreate(Bundle bundle) {
        Object str;
        app.dogo.com.dogo_android.inbox.b bVar;
        String string2;
        String string;
        int i4;
        int i3;
        int i2;
        int i;
        Object obj10;
        super.onCreate(bundle);
        androidx.databinding.ViewDataBinding view = f.g(this, 2131558428);
        n.e(view, "setContentView(this, R.layout.activity_custom_inbox)");
        this.a = (a)view;
        if (view == null) {
        } else {
            a aVar = new a(this);
            view.O.setNavigationOnClickListener(aVar);
            if (bundle == null) {
                string2 = getString(2131886897);
                n.e(string2, "getString(R.string.mobile_inbox_no_message_title)");
                string = getString(2131886896);
                n.e(string, "getString(R.string.mobile_inbox_no_message_body)");
                super(string2, string, 0, 0, 12, 0);
                g1.n(this, obj10);
            }
        }
        n.w("binding");
        throw 0;
    }
}
