package com.facebook.e0.r.g;

import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import com.facebook.internal.g0.i.a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.k0.a;
import kotlin.k0.h;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0008\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u000c\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\rH\u0007¨\u0006\u000e", d2 = {"Lcom/facebook/appevents/codeless/internal/SensitiveUserDataUtils;", "", "()V", "isCreditCard", "", "view", "Landroid/widget/TextView;", "isEmail", "isPassword", "isPersonName", "isPhoneNumber", "isPostalAddress", "isSensitiveUserData", "Landroid/view/View;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class d {

    public static final com.facebook.e0.r.g.d a;
    static {
        d dVar = new d();
        d.a = dVar;
    }

    private final boolean a(TextView textView) {
        int length;
        int i;
        int i6;
        int i4;
        int i3;
        int i2;
        int i5;
        boolean digit;
        i = 0;
        if (a.d(this)) {
            return i;
        }
        h hVar = new h("\\s");
        String obj8 = hVar.e(f.k(textView), "");
        length = obj8.length();
        if (length >= 12) {
            if (length > 19) {
            } else {
                i6 = 1;
                length -= i6;
                i2 = i4;
                while (length >= 0) {
                    char charAt = obj8.charAt(length);
                    i5 *= 2;
                    if (i2 != 0 && i5 > 9) {
                    }
                    i4 += i5;
                    i2 ^= 1;
                    length--;
                    i5 *= 2;
                    if (i5 > 9) {
                    }
                    i7 += i6;
                }
                if (i4 %= 10 == 0) {
                    i = i6;
                }
            }
        }
        return i;
    }

    private final boolean b(TextView textView) {
        int eMAIL_ADDRESS;
        int matches;
        int i;
        Object obj5;
        matches = 0;
        if (a.d(this)) {
            return matches;
        }
        if (textView.getInputType() == 32) {
            return 1;
        }
        obj5 = f.k(textView);
        if (obj5 != null) {
            if (obj5.length() == 0) {
            } else {
                i = matches;
            }
            try {
                if (i != 0) {
                } else {
                }
                matches = Patterns.EMAIL_ADDRESS.matcher(obj5).matches();
                return matches;
                a.b(textView, this);
                return obj1;
            }
        }
    }

    private final boolean c(TextView textView) {
        if (a.d(this)) {
            return 0;
        }
        if (textView.getInputType() == 128) {
            return 1;
        }
        return obj4 instanceof PasswordTransformationMethod;
    }

    private final boolean d(TextView textView) {
        int i;
        if (a.d(this)) {
            return 0;
        }
        if (textView.getInputType() == 96) {
            i = 1;
        }
        return i;
    }

    private final boolean e(TextView textView) {
        int i;
        if (a.d(this)) {
            return 0;
        }
        if (textView.getInputType() == 3) {
            i = 1;
        }
        return i;
    }

    private final boolean f(TextView textView) {
        int i;
        if (a.d(this)) {
            return 0;
        }
        if (textView.getInputType() == 112) {
            i = 1;
        }
        return i;
    }

    public static final boolean g(View view) {
        boolean dVar;
        int i;
        boolean z;
        Object obj4;
        if (a.d(d.class)) {
            return 0;
        }
        if (view instanceof TextView != null) {
            dVar = d.a;
            if (!dVar.c((TextView)view) && !dVar.a((TextView)view) && !dVar.d((TextView)view) && !dVar.f((TextView)view) && !dVar.e((TextView)view)) {
                if (!dVar.a((TextView)view)) {
                    if (!dVar.d((TextView)view)) {
                        if (!dVar.f((TextView)view)) {
                            if (!dVar.e((TextView)view)) {
                                if (dVar.b((TextView)view)) {
                                    i = 1;
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        }
        try {
            return i;
            a.b(view, obj0);
            return obj2;
        }
    }
}
