package app.dogo.com.dogo_android.view.compat;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0008\u0010\u000b\u001a\u00020\u000cH\u0016¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/view/compat/FocusedBorderTextInput;", "Lcom/google/android/material/textfield/TextInputLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "invalidate", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FocusedBorderTextInput extends TextInputLayout {
    public FocusedBorderTextInput(Context context, AttributeSet attributeSet2) {
        n.f(context, "context");
        super(context, attributeSet2);
    }

    @Override // com.google.android.material.textfield.TextInputLayout
    public void invalidate() {
        int i;
        if (hasFocus()) {
            setBoxBackgroundColorResource(2131100375);
        } else {
            setBoxBackgroundColorResource(2131099683);
        }
        super.invalidate();
    }
}
