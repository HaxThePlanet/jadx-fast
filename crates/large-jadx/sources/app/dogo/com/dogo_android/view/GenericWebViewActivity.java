package app.dogo.com.dogo_android.view;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.d;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.f;
import androidx.fragment.app.e;
import app.dogo.com.dogo_android.h.o;
import app.dogo.com.dogo_android.util.h0.g1;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0014J\u0008\u0010\r\u001a\u00020\nH\u0014J\u0008\u0010\u000e\u001a\u00020\nH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/view/GenericWebViewActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/ActivityWebviewBinding;", "screenKey", "Lapp/dogo/com/dogo_android/view/GenericWebViewScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/view/GenericWebViewScreen;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GenericWebViewActivity extends d {

    private o a;
    private final app.dogo.com.dogo_android.view.l i() {
        return (l)g1.l(this);
    }

    public static void j(app.dogo.com.dogo_android.view.GenericWebViewActivity genericWebViewActivity, View view2) {
        GenericWebViewActivity.k(genericWebViewActivity, view2);
    }

    private static final void k(app.dogo.com.dogo_android.view.GenericWebViewActivity genericWebViewActivity, View view2) {
        n.f(genericWebViewActivity, "this$0");
        genericWebViewActivity.onBackPressed();
    }

    @Override // androidx.appcompat.app.d
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        androidx.databinding.ViewDataBinding obj4 = f.g(this, 2131558435);
        n.e(obj4, "setContentView(this, R.layout.activity_webview)");
        this.a = (o)obj4;
        int i = 0;
        final String str2 = "binding";
        if (obj4 == null) {
        } else {
            obj4.T(i().a());
            obj4 = this.a;
            if (obj4 == null) {
            } else {
                obj4.U(i().b());
                obj4 = this.a;
                if (obj4 == null) {
                } else {
                    a aVar = new a(this);
                    obj4.O.setNavigationOnClickListener(aVar);
                }
                n.w(str2);
                throw i;
            }
            n.w(str2);
            throw i;
        }
        n.w(str2);
        throw i;
    }

    @Override // androidx.appcompat.app.d
    protected void onPause() {
        super.onPause();
        o oVar = this.a;
        if (oVar == null) {
        } else {
            oVar.P.onPause();
        }
        n.w("binding");
        throw 0;
    }

    @Override // androidx.appcompat.app.d
    protected void onResume() {
        super.onResume();
        o oVar = this.a;
        if (oVar == null) {
        } else {
            oVar.P.onResume();
        }
        n.w("binding");
        throw 0;
    }
}
