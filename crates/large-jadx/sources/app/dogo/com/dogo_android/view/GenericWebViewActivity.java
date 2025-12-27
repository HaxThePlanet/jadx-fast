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

/* compiled from: GenericWebViewActivity.kt */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0014J\u0008\u0010\r\u001a\u00020\nH\u0014J\u0008\u0010\u000e\u001a\u00020\nH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/view/GenericWebViewActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/ActivityWebviewBinding;", "screenKey", "Lapp/dogo/com/dogo_android/view/GenericWebViewScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/view/GenericWebViewScreen;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class GenericWebViewActivity extends d {

    /* renamed from: a, reason: from kotlin metadata */
    private o binding;
    /* renamed from: i, reason: from kotlin metadata */
    private final l onPause() {
        return (GenericWebViewScreen)app.dogo.com.dogo_android.util.extensionfunction.g1.l(this);
    }

    private static final void k(GenericWebViewActivity genericWebViewActivity, View view) {
        n.f(genericWebViewActivity, "this$0");
        genericWebViewActivity.onBackPressed();
    }

    @Override // androidx.appcompat.app.d
    protected void onCreate(Bundle savedInstanceState) throws a {
        super.onCreate(savedInstanceState);
        androidx.databinding.ViewDataBinding viewDataBinding = f.g(this, 2131558435);
        n.e(viewDataBinding, "setContentView(this, R.layout.activity_webview)");
        this.binding = viewDataBinding;
        int i = 0;
        final String str2 = "binding";
        if (viewDataBinding == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            viewDataBinding.T(onPause().component1());
            if (this.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.U(onPause().b());
                if (this.binding == null) {
                    n.w(str2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    binding22.O.setNavigationOnClickListener(new a(this));
                    return;
                }
            }
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onPause() {
        super.onPause();
        if (this.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            binding2.P.onPause();
            return;
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onResume() {
        super.onResume();
        if (this.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            binding2.P.onResume();
            return;
        }
    }

    public static /* synthetic */ void j(GenericWebViewActivity genericWebViewActivity, View view) {
        GenericWebViewActivity.k(genericWebViewActivity, view);
    }
}
