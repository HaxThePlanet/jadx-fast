package app.dogo.com.dogo_android.inbox;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.d;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.f;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.t;
import app.dogo.com.dogo_android.util.t.a;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: CustomIterableInboxActivity.kt */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0014J\u0008\u0010\t\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u00020\u00062\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/inbox/CustomIterableInboxActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/ActivityCustomInboxBinding;", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class CustomIterableInboxActivity extends d {

    /* renamed from: a, reason: from kotlin metadata */
    private app.dogo.com.dogo_android.h.a binding;
    private static final void j(CustomIterableInboxActivity list, View view) {
        n.f(list, "this$0");
        list.onBackPressed();
    }

    @Override // androidx.appcompat.app.d
    protected void attachBaseContext(Context newBase) {
        n.f(newBase, "newBase");
        t.a iNSTANCE2 = MyContextWrapper.INSTANCE;
        final Context resources2 = iNSTANCE2.updateResources(newBase, LocaleService.getLanguageFromLocaleString(App.INSTANCE.l().W()));
        super.attachBaseContext(resources2);
        android.content.res.Resources resources = getResources();
        n.e(resources, "resources");
        iNSTANCE2.updateResourcesUpTo25Api(resources, resources2);
        a.b(this);
    }

    @Override // androidx.appcompat.app.d
    public void onBackPressed() {
        finish();
    }

    @Override // androidx.appcompat.app.d
    protected void onCreate(Bundle savedInstanceState) throws b {
        super.onCreate(savedInstanceState);
        androidx.databinding.ViewDataBinding viewDataBinding = f.g(this, 2131558428);
        n.e(viewDataBinding, "setContentView(this, R.layout.activity_custom_inbox)");
        this.binding = viewDataBinding;
        if (viewDataBinding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            viewDataBinding.O.setNavigationOnClickListener(new a(this));
            if (savedInstanceState == null) {
                String string = getString(2131886897);
                n.e(string, "getString(R.string.mobile_inbox_no_message_title)");
                String string2 = getString(2131886896);
                n.e(string2, "getString(R.string.mobile_inbox_no_message_body)");
                com.iterable.iterableapi.ui.inbox.a aVar = null;
                int i = 0;
                int i2 = 12;
                kotlin.d0.d.g gVar = null;
                MobileInboxScreen savedInstanceState2 = new MobileInboxScreen(string, string2, aVar, i, i2, gVar);
                app.dogo.com.dogo_android.util.extensionfunction.g1.n(this, savedInstanceState2);
            }
            return;
        }
    }

    public static /* synthetic */ void i(CustomIterableInboxActivity list, View view) {
        CustomIterableInboxActivity.j(list, view);
    }
}
