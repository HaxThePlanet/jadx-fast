package app.dogo.com.dogo_android.view.compat;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\r\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J:\u0010\u0008\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0004¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/view/compat/MaxInputValidator;", "Landroid/text/InputFilter;", "max", "", "(I)V", "getMax", "()I", "setMax", "filter", "", "source", "start", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class a implements InputFilter {

    private int a;
    public a(int i) {
        super();
        this.a = i;
    }

    @Override // android.text.InputFilter
    public java.lang.CharSequence filter(java.lang.CharSequence charSequence, int i2, int i3, Spanned spanned4, int i5, int i6) {
        boolean stringBuilder;
        Object obj2;
        int obj3;
        n.f(charSequence, "source");
        n.f(spanned4, "dest");
        stringBuilder = new StringBuilder(spanned4);
        stringBuilder.replace(i5, i6, charSequence.subSequence(i2, i3).toString());
        obj2 = stringBuilder.toString();
        n.e(obj2, "builder.toString()");
        if (TextUtils.isDigitsOnly(charSequence) && Integer.parseInt(obj2) <= this.a) {
            stringBuilder = new StringBuilder(spanned4);
            stringBuilder.replace(i5, i6, charSequence.subSequence(i2, i3).toString());
            obj2 = stringBuilder.toString();
            n.e(obj2, "builder.toString()");
            if (Integer.parseInt(obj2) <= this.a) {
                return null;
            }
        }
        return "";
    }
}
