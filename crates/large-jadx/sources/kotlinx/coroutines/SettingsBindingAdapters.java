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

/* compiled from: SettingsBindingAdapters.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002JP\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0010\u0010\u0006\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0008\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0007¨\u0006\u0013", d2 = {"Lapp/dogo/com/dogo_android/settings/SettingsBindingAdapters;", "", "()V", "setupSettings", "", "Landroid/view/View;", "reminder", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/model/RemindersModel;", "checkBox", "Landroidx/appcompat/widget/SwitchCompat;", "extraBlock", "reminderTime", "Landroid/widget/TextView;", "callback", "Lapp/dogo/com/dogo_android/settings/SettingsCallback;", "loadingIndicator", "Lcom/google/android/material/progressindicator/CircularProgressIndicator;", "retryText", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: a0, reason: from kotlin metadata */
public final class SettingsBindingAdapters {
    public static final void c(View view, y<RemindersModel> yVar, SwitchCompat switchCompat, View view2, TextView textView, b0 b0Var, CircularProgressIndicator circularProgressIndicator, TextView textView2) {
        boolean active = false;
        boolean active2;
        int i;
        Object obj;
        n.f(view, "<this>");
        n.f(switchCompat, "checkBox");
        n.f(view2, "extraBlock");
        n.f(textView, "reminderTime");
        n.f(circularProgressIndicator, "loadingIndicator");
        n.f(textView2, "retryText");
        i = 0;
        i = 8;
        if (yVar instanceof LoadResult_Success) {
            yVar22 = yVar;
            Object component12 = yVar22.component1();
            if (component12 == null) {
            } else {
                active2 = component12.isActive();
            }
            int r3 = i;
            view2.setVisibility(i);
            switchCompat.setVisibility(i);
            Object component13 = yVar22.component1();
            if (component13 != null) {
                active = component13.isActive();
            }
            switchCompat.setChecked(active);
            circularProgressIndicator.setVisibility(i);
            textView2.setVisibility(i);
            Object component1 = yVar22.component1();
            String str7 = "";
            if (component1 != null) {
                String switchCompat32 = component1.getTime();
                if (switchCompat32 != null) {
                }
            }
            textView.setText(obj);
            view.setOnClickListener(new kotlinx.coroutines.a(b0Var, yVar));
        } else {
            z2 = yVar instanceof LoadResult_Loading;
            if (yVar instanceof oadResult_Loading) {
                switchCompat.setVisibility(i);
                circularProgressIndicator.setVisibility(i);
                textView2.setVisibility(i);
            } else {
                z = yVar instanceof LoadResult_Error;
                if (yVar instanceof oadResult_Error) {
                    view2.setVisibility(i);
                    switchCompat.setVisibility(i);
                    circularProgressIndicator.setVisibility(i);
                    textView2.setVisibility(i);
                    view.setOnClickListener(new kotlinx.coroutines.b(b0Var));
                }
            }
        }
    }

    private static final void d(b0 b0Var, y yVar, View view) {
        if (b0Var != null) {
            b0Var.W((RemindersModel)yVar.component1());
        }
    }

    private static final void e(b0 b0Var, View view) {
        if (b0Var != null) {
            b0Var.N0();
        }
    }


    public static /* synthetic */ void a(b0 b0Var, y yVar, View view) {
        SettingsBindingAdapters.d(b0Var, yVar, view);
    }

    public static /* synthetic */ void b(b0 b0Var, View view) {
        SettingsBindingAdapters.e(b0Var, view);
    }
}
