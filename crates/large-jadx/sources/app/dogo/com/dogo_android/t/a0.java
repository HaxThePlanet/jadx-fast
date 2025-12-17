package app.dogo.com.dogo_android.t;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import app.dogo.com.dogo_android.model.RemindersModel;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.c;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002JP\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0010\u0010\u0006\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0008\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0007¨\u0006\u0013", d2 = {"Lapp/dogo/com/dogo_android/settings/SettingsBindingAdapters;", "", "()V", "setupSettings", "", "Landroid/view/View;", "reminder", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/model/RemindersModel;", "checkBox", "Landroidx/appcompat/widget/SwitchCompat;", "extraBlock", "reminderTime", "Landroid/widget/TextView;", "callback", "Lapp/dogo/com/dogo_android/settings/SettingsCallback;", "loadingIndicator", "Lcom/google/android/material/progressindicator/CircularProgressIndicator;", "retryText", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class a0 {
    static {
    }

    public static void a(app.dogo.com.dogo_android.t.b0 b0, y y2, View view3) {
        a0.d(b0, y2, view3);
    }

    public static void b(app.dogo.com.dogo_android.t.b0 b0, View view2) {
        a0.e(b0, view2);
    }

    public static final void c(View view, y<RemindersModel> y2, SwitchCompat switchCompat3, View view4, TextView textView5, app.dogo.com.dogo_android.t.b0 b06, CircularProgressIndicator circularProgressIndicator7, TextView textView8) {
        Object obj;
        boolean active2;
        int i;
        boolean active;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        n.f(view, "<this>");
        n.f(switchCompat3, "checkBox");
        n.f(view4, "extraBlock");
        n.f(textView5, "reminderTime");
        n.f(circularProgressIndicator7, "loadingIndicator");
        n.f(textView8, "retryText");
        active2 = 0;
        final int i2 = 8;
        if (y2 instanceof y.c) {
            obj = y2;
            Object obj2 = (y.c)obj.a();
            if ((RemindersModel)obj2 == null) {
                active = active2;
            } else {
                active = (RemindersModel)obj2.isActive();
            }
            i = active ? active2 : i2;
            view4.setVisibility(i);
            switchCompat3.setVisibility(active2);
            obj7 = obj.a();
            if ((RemindersModel)obj7 == null) {
            } else {
                active2 = (RemindersModel)obj7.isActive();
            }
            switchCompat3.setChecked(active2);
            circularProgressIndicator7.setVisibility(i2);
            textView8.setVisibility(i2);
            obj6 = obj.a();
            obj7 = "";
            if ((RemindersModel)obj6 == null) {
            } else {
                obj6 = (RemindersModel)obj6.getTime();
                if (obj6 == null) {
                } else {
                    obj7 = obj6;
                }
            }
            textView5.setText(obj7);
            obj6 = new a(b06, y2);
            view.setOnClickListener(obj6);
        } else {
            if (y2 instanceof y.b) {
                switchCompat3.setVisibility(i2);
                circularProgressIndicator7.setVisibility(active2);
                textView8.setVisibility(i2);
            } else {
                if (y2 instanceof y.a) {
                    view4.setVisibility(i2);
                    switchCompat3.setVisibility(i2);
                    circularProgressIndicator7.setVisibility(i2);
                    textView8.setVisibility(active2);
                    obj5 = new b(b06);
                    view.setOnClickListener(obj5);
                }
            }
        }
    }

    private static final void d(app.dogo.com.dogo_android.t.b0 b0, y y2, View view3) {
        Object obj1;
        if (b0 == null) {
        } else {
            b0.W((RemindersModel)(y.c)y2.a());
        }
    }

    private static final void e(app.dogo.com.dogo_android.t.b0 b0, View view2) {
        if (b0 == null) {
        } else {
            b0.N0();
        }
    }
}
