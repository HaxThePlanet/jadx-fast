package app.dogo.com.dogo_android.inappmessaging;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import kotlin.Metadata;
import kotlin.k0.l;

/* compiled from: OneTenRadioGroup.kt */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u001b\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u0011\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0008\u001a\u00020\tJ\u0010\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0001\u0010\n\u001a\u00020\t¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/inappmessaging/OneTenRadioGroup;", "Landroid/widget/RadioGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "getRating", "", "viewId", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class OneTenRadioGroup extends RadioGroup {
    public OneTenRadioGroup(Context context, AttributeSet set) {
        super(context, set);
    }

    @Override // android.widget.RadioGroup
    /* renamed from: a, reason: from kotlin metadata */
    public final int getRating(int viewId) {
        int value = 0;
        android.view.View viewById = findViewById(viewId);
        value = 0;
        if (viewById != null) {
            java.lang.CharSequence text = viewById.getText();
            if (text != null) {
                String object = text.toString();
                if (object != null) {
                    Integer num = l.m(object);
                    if (num != null) {
                        value = num.intValue();
                    }
                }
            }
        }
        return value;
    }

    @Override // android.widget.RadioGroup
    public final int getRating() {
        int value = 0;
        android.view.View viewById = findViewById(getCheckedRadioButtonId());
        value = 0;
        if (viewById != null) {
            java.lang.CharSequence text = viewById.getText();
            if (text != null) {
                String object = text.toString();
                if (object != null) {
                    Integer num = l.m(object);
                    if (num != null) {
                        value = num.intValue();
                    }
                }
            }
        }
        return value;
    }
}
