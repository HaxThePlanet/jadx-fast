package androidx.compose.ui.autofill;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.autofill.AutofillManager;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0014", d2 = {"Landroidx/compose/ui/autofill/AndroidAutofill;", "Landroidx/compose/ui/autofill/Autofill;", "view", "Landroid/view/View;", "autofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "(Landroid/view/View;Landroidx/compose/ui/autofill/AutofillTree;)V", "autofillManager", "Landroid/view/autofill/AutofillManager;", "getAutofillManager", "()Landroid/view/autofill/AutofillManager;", "getAutofillTree", "()Landroidx/compose/ui/autofill/AutofillTree;", "getView", "()Landroid/view/View;", "cancelAutofillForNode", "", "autofillNode", "Landroidx/compose/ui/autofill/AutofillNode;", "requestAutofillForNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidAutofill implements androidx.compose.ui.autofill.Autofill {

    public static final int $stable = 8;
    private final AutofillManager autofillManager;
    private final androidx.compose.ui.autofill.AutofillTree autofillTree;
    private final View view;
    static {
        final int i = 8;
    }

    public AndroidAutofill(View view, androidx.compose.ui.autofill.AutofillTree autofillTree) {
        super();
        this.view = view;
        this.autofillTree = autofillTree;
        Object systemService = this.view.getContext().getSystemService(AutofillManager.class);
        if ((AutofillManager)systemService == null) {
        } else {
            this.autofillManager = (AutofillManager)systemService;
            this.view.setImportantForAutofill(1);
        }
        IllegalStateException illegalStateException = new IllegalStateException("Autofill service could not be located.".toString());
        throw illegalStateException;
    }

    @Override // androidx.compose.ui.autofill.Autofill
    public void cancelAutofillForNode(androidx.compose.ui.autofill.AutofillNode autofillNode) {
        this.autofillManager.notifyViewExited(this.view, autofillNode.getId());
    }

    @Override // androidx.compose.ui.autofill.Autofill
    public final AutofillManager getAutofillManager() {
        return this.autofillManager;
    }

    @Override // androidx.compose.ui.autofill.Autofill
    public final androidx.compose.ui.autofill.AutofillTree getAutofillTree() {
        return this.autofillTree;
    }

    @Override // androidx.compose.ui.autofill.Autofill
    public final View getView() {
        return this.view;
    }

    @Override // androidx.compose.ui.autofill.Autofill
    public void requestAutofillForNode(androidx.compose.ui.autofill.AutofillNode autofillNode) {
        Rect boundingBox = autofillNode.getBoundingBox();
        if (boundingBox == null) {
        } else {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            final int i4 = 0;
            Rect rect = new Rect(Math.round(boundingBox.getLeft()), Math.round(boundingBox.getTop()), Math.round(boundingBox.getRight()), Math.round(boundingBox.getBottom()));
            this.autofillManager.notifyViewEntered(this.view, autofillNode.getId(), rect);
        }
        IllegalStateException boundingBox2 = new IllegalStateException("requestAutofill called before onChildPositioned()".toString());
        throw boundingBox2;
    }
}
