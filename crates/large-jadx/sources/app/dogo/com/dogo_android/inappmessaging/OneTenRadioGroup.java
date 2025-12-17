package app.dogo.com.dogo_android.inappmessaging;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import kotlin.Metadata;
import kotlin.k0.l;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u001b\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u0011\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0008\u001a\u00020\tJ\u0010\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0001\u0010\n\u001a\u00020\t¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/inappmessaging/OneTenRadioGroup;", "Landroid/widget/RadioGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "getRating", "", "viewId", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class OneTenRadioGroup extends RadioGroup {
    public OneTenRadioGroup(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
    }

    @Override // android.widget.RadioGroup
    public final int a(int i) {
        int intValue;
        Object obj2;
        obj2 = findViewById(i);
        intValue = 0;
        if ((RadioButton)obj2 == null) {
        } else {
            obj2 = (RadioButton)obj2.getText();
            if (obj2 == null) {
            } else {
                obj2 = obj2.toString();
                if (obj2 == null) {
                } else {
                    obj2 = l.m(obj2);
                    if (obj2 == null) {
                    } else {
                        intValue = obj2.intValue();
                    }
                }
            }
        }
        return intValue;
    }

    @Override // android.widget.RadioGroup
    public final int getRating() {
        Object viewById;
        int intValue;
        viewById = findViewById(getCheckedRadioButtonId());
        intValue = 0;
        if ((RadioButton)viewById == null) {
        } else {
            viewById = (RadioButton)viewById.getText();
            if (viewById == null) {
            } else {
                viewById = viewById.toString();
                if (viewById == null) {
                } else {
                    viewById = l.m(viewById);
                    if (viewById == null) {
                    } else {
                        intValue = viewById.intValue();
                    }
                }
            }
        }
        return intValue;
    }
}
