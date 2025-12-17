package androidx.compose.ui.tooling;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0014J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Landroidx/compose/ui/tooling/PreviewActivity;", "Landroidx/activity/ComponentActivity;", "()V", "TAG", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setComposableContent", "composableFqn", "setParameterizedContent", "className", "methodName", "parameterProvider", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PreviewActivity extends ComponentActivity {

    public static final int $stable;
    private final String TAG;
    static {
    }

    public PreviewActivity() {
        super();
        this.TAG = "PreviewActivity";
    }

    private final void setComposableContent(String composableFqn) {
        StringBuilder stringBuilder = new StringBuilder();
        Log.d(this.TAG, stringBuilder.append("PreviewActivity has composable ").append(composableFqn).toString());
        int i = 46;
        int i2 = 0;
        int i4 = 2;
        final String substringBeforeLast$default = StringsKt.substringBeforeLast$default(composableFqn, i, i2, i4, i2);
        String substringAfterLast$default = StringsKt.substringAfterLast$default(composableFqn, i, i2, i4, i2);
        String stringExtra = getIntent().getStringExtra("parameterProviderClassName");
        if (stringExtra != null) {
            int i3 = 0;
            setParameterizedContent(substringBeforeLast$default, substringAfterLast$default, stringExtra);
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        Log.d(this.TAG, stringBuilder2.append("Previewing '").append(substringAfterLast$default).append("' without a parameter provider.").toString());
        PreviewActivity.setComposableContent.2 anon = new PreviewActivity.setComposableContent.2(substringBeforeLast$default, substringAfterLast$default);
        final int i6 = 1;
        ComponentActivityKt.setContent$default((ComponentActivity)this, i2, (Function2)ComposableLambdaKt.composableLambdaInstance(-840626948, i6, anon), i6, i2);
    }

    private final void setParameterizedContent(String className, String methodName, String parameterProvider) {
        Object obj;
        androidx.compose.runtime.internal.ComposableLambda composableLambdaInstance;
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        Log.d(this.TAG, stringBuilder.append("Previewing '").append(methodName).append("' with parameter provider: '").append(parameterProvider).append('\'').toString());
        Object[] previewProviderParameters = PreviewUtils_androidKt.getPreviewProviderParameters(PreviewUtils_androidKt.asPreviewProviderClass(parameterProvider), getIntent().getIntExtra("parameterProviderIndex", -1));
        int i3 = 0;
        int i5 = 1;
        if (previewProviderParameters.length > i5) {
            PreviewActivity.setParameterizedContent.1 anon = new PreviewActivity.setParameterizedContent.1(previewProviderParameters, className, methodName);
            ComponentActivityKt.setContent$default((ComponentActivity)this, i3, (Function2)ComposableLambdaKt.composableLambdaInstance(-861939235, i5, anon), i5, i3);
        } else {
            PreviewActivity.setParameterizedContent.2 anon2 = new PreviewActivity.setParameterizedContent.2(className, methodName, previewProviderParameters);
            ComponentActivityKt.setContent$default((ComponentActivity)this, i3, (Function2)ComposableLambdaKt.composableLambdaInstance(-1901447514, i5, anon2), i5, i3);
        }
    }

    @Override // androidx.activity.ComponentActivity
    protected void onCreate(Bundle savedInstanceState) {
        Object stringExtra;
        String str;
        super.onCreate(savedInstanceState);
        if (flags &= 2 == 0) {
            Log.d(this.TAG, "Application is not debuggable. Compose Preview not allowed.");
            finish();
        }
        stringExtra = getIntent();
        stringExtra = stringExtra.getStringExtra("composable");
        if (stringExtra != null && stringExtra != null) {
            stringExtra = stringExtra.getStringExtra("composable");
            if (stringExtra != null) {
                str = 0;
                setComposableContent(stringExtra);
            }
        }
    }
}
