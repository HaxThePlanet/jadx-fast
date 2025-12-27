package d.a.n;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

/* compiled from: AllCapsTransformationMethod.java */
/* loaded from: classes.dex */
public class a implements TransformationMethod {

    private Locale a;
    public a(Context context) {
        super();
        this.a = context.getResources().getConfiguration().locale;
    }

    public java.lang.CharSequence getTransformation(java.lang.CharSequence charSequence, View view) {
        String str = null;
        if (charSequence != null) {
            str = charSequence.toString().toUpperCase(this.a);
        } else {
            int i = 0;
        }
        return str;
    }

    public void onFocusChanged(View view, java.lang.CharSequence charSequence, boolean z, int i, Rect rect) {
    }
}
