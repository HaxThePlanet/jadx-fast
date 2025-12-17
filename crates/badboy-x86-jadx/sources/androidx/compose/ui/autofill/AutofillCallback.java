package androidx.compose.ui.autofill;

import android.util.Log;
import android.view.View;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillManager.AutofillCallback;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Á\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0008H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u000cH\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u000cH\u0007¨\u0006\u000e", d2 = {"Landroidx/compose/ui/autofill/AutofillCallback;", "Landroid/view/autofill/AutofillManager$AutofillCallback;", "()V", "onAutofillEvent", "", "view", "Landroid/view/View;", "virtualId", "", "event", "register", "autofill", "Landroidx/compose/ui/autofill/AndroidAutofill;", "unregister", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AutofillCallback extends AutofillManager.AutofillCallback {

    public static final int $stable;
    public static final androidx.compose.ui.autofill.AutofillCallback INSTANCE;
    static {
        AutofillCallback autofillCallback = new AutofillCallback();
        AutofillCallback.INSTANCE = autofillCallback;
    }

    @Override // android.view.autofill.AutofillManager$AutofillCallback
    public void onAutofillEvent(View view, int virtualId, int event) {
        String str;
        super.onAutofillEvent(view, virtualId, event);
        switch (event) {
            case 1:
                str = "Autofill popup was shown.";
                break;
            case 2:
                str = "Autofill popup was hidden.";
                break;
            case 3:
                str = "Autofill popup isn't shown because autofill is not available.\n\nDid you set up autofill?\n1. Go to Settings > System > Languages&input > Advanced > Autofill Service\n2. Pick a service\n\nDid you add an account?\n1. Go to Settings > System > Languages&input > Advanced\n2. Click on the settings icon next to the Autofill Service\n3. Add your account";
                break;
            default:
                str = "Unknown status event.";
        }
        Log.d("Autofill Status", str);
    }

    @Override // android.view.autofill.AutofillManager$AutofillCallback
    public final void register(androidx.compose.ui.autofill.AndroidAutofill autofill) {
        autofill.getAutofillManager().registerCallback((AutofillManager.AutofillCallback)this);
    }

    @Override // android.view.autofill.AutofillManager$AutofillCallback
    public final void unregister(androidx.compose.ui.autofill.AndroidAutofill autofill) {
        autofill.getAutofillManager().unregisterCallback((AutofillManager.AutofillCallback)this);
    }
}
