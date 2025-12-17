package d.a.n;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

/* loaded from: classes.dex */
public class a implements TransformationMethod {

    private Locale a;
    public a(Context context) {
        super();
        this.a = obj1.locale;
    }

    @Override // android.text.method.TransformationMethod
    public java.lang.CharSequence getTransformation(java.lang.CharSequence charSequence, View view2) {
        String obj1;
        Locale obj2;
        if (charSequence != null) {
            obj1 = charSequence.toString().toUpperCase(this.a);
        } else {
            obj1 = 0;
        }
        return obj1;
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, java.lang.CharSequence charSequence2, boolean z3, int i4, Rect rect5) {
    }
}
