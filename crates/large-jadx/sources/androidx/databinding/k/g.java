package androidx.databinding.k;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import androidx.databinding.g;
import androidx.databinding.library.baseAdapters.a;

/* loaded from: classes.dex */
public class g {

    static class a implements TextWatcher {

        final androidx.databinding.k.g.c a;
        final androidx.databinding.k.g.d b;
        final g c;
        final androidx.databinding.k.g.b v;
        a(androidx.databinding.k.g.c g$c, androidx.databinding.k.g.d g$d2, g g3, androidx.databinding.k.g.b g$b4) {
            this.a = c;
            this.b = d2;
            this.c = g3;
            this.v = b4;
            super();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            final androidx.databinding.k.g.b bVar = this.v;
            if (bVar != null) {
                bVar.afterTextChanged(editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(java.lang.CharSequence charSequence, int i2, int i3, int i4) {
            final androidx.databinding.k.g.c cVar = this.a;
            if (cVar != null) {
                cVar.beforeTextChanged(charSequence, i2, i3, i4);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(java.lang.CharSequence charSequence, int i2, int i3, int i4) {
            final androidx.databinding.k.g.d dVar = this.b;
            if (dVar != null) {
                dVar.onTextChanged(charSequence, i2, i3, i4);
            }
            final g obj2 = this.c;
            if (obj2 != null) {
                obj2.a();
            }
        }
    }

    public interface b {
        public abstract void afterTextChanged(Editable editable);
    }

    public interface c {
        public abstract void beforeTextChanged(java.lang.CharSequence charSequence, int i2, int i3, int i4);
    }

    public interface d {
        public abstract void onTextChanged(java.lang.CharSequence charSequence, int i2, int i3, int i4);
    }
    public static String a(TextView textView) {
        return textView.getText().toString();
    }

    private static boolean b(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
        int i;
        int i3;
        int i2;
        char charAt;
        char charAt2;
        final int i4 = 0;
        final int i5 = 1;
        i = charSequence == null ? i5 : i4;
        i3 = charSequence2 == null ? i5 : i4;
        if (i != i3) {
            return i5;
        }
        if (charSequence == null) {
            return i4;
        }
        int length = charSequence.length();
        if (length != charSequence2.length()) {
            return i5;
        }
        i2 = i4;
        while (i2 < length) {
            i2++;
        }
        return i4;
    }

    public static void c(TextView textView, java.lang.CharSequence charSequence2) {
        java.lang.CharSequence equals;
        int length;
        equals = textView.getText();
        if (charSequence2 != equals) {
            if (charSequence2 == null && equals.length() == 0) {
                if (equals.length() == 0) {
                } else {
                    if (charSequence2 instanceof Spanned) {
                        if (charSequence2.equals(equals)) {
                        }
                    } else {
                        if (!g.b(charSequence2, equals)) {
                        }
                    }
                    textView.setText(charSequence2);
                }
            } else {
            }
        }
    }

    public static void d(TextView textView, float f2) {
        textView.setTextSize(0, f2);
    }

    public static void e(TextView textView, androidx.databinding.k.g.c g$c2, androidx.databinding.k.g.d g$d3, androidx.databinding.k.g.b g$b4, g g5) {
        androidx.databinding.k.g.a aVar;
        androidx.databinding.k.g.a obj2;
        if (c2 == null && b4 == null && d3 == null && g5 == null) {
            if (b4 == null) {
                if (d3 == null) {
                    if (g5 == null) {
                        obj2 = 0;
                    } else {
                        aVar = new g.a(c2, d3, g5, b4);
                        obj2 = aVar;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        Object obj3 = e.b(textView, obj2, a.b);
        if ((TextWatcher)obj3 != null) {
            textView.removeTextChangedListener((TextWatcher)obj3);
        }
        if (obj2 != null) {
            textView.addTextChangedListener(obj2);
        }
    }
}
