package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewStructure;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0007¨\u0006\t", d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAssistHelperMethodsO;", "", "()V", "setClassName", "", "structure", "Landroid/view/ViewStructure;", "view", "Landroid/view/View;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class AndroidComposeViewAssistHelperMethodsO {

    public static final androidx.compose.ui.platform.AndroidComposeViewAssistHelperMethodsO INSTANCE;
    static {
        AndroidComposeViewAssistHelperMethodsO androidComposeViewAssistHelperMethodsO = new AndroidComposeViewAssistHelperMethodsO();
        AndroidComposeViewAssistHelperMethodsO.INSTANCE = androidComposeViewAssistHelperMethodsO;
    }

    public final void setClassName(ViewStructure structure, View view) {
        structure.setClassName(view.getAccessibilityClassName().toString());
    }
}
