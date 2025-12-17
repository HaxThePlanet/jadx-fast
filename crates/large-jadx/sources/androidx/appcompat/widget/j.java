package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/* loaded from: classes.dex */
class j {
    static InputConnection a(InputConnection inputConnection, EditorInfo editorInfo2, View view3) {
        java.lang.CharSequence hintText;
        Object obj3;
        if (inputConnection != null && editorInfo2.hintText == null) {
            if (editorInfo2.hintText == null) {
                obj3 = view3.getParent();
                while (obj3 instanceof View != null) {
                    if (obj3 instanceof a1 != null) {
                        break;
                    } else {
                    }
                    obj3 = obj3.getParent();
                }
            }
        }
        return inputConnection;
    }
}
