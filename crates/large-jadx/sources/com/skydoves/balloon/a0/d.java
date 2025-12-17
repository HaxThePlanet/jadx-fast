package com.skydoves.balloon.a0;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;
import com.skydoves.balloon.m;
import com.skydoves.balloon.vectortext.VectorTextView;
import com.skydoves.balloon.vectortext.a;
import com.skydoves.balloon.y;
import d.a.k.a.a;
import d.h.j.b;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.n;
import kotlin.w;

/* loaded from: classes2.dex */
public final class d {
    public static final void a(TextView textView, a a2) {
        int valueOf2;
        Object resources3;
        int i;
        Resources resources;
        int valueOf;
        Resources resources2;
        int drawable4;
        Context context;
        int drawable;
        Context context4;
        int drawable3;
        Context context2;
        android.graphics.drawable.Drawable drawable2;
        Context context3;
        Integer obj10;
        n.f(textView, "$this$applyDrawable");
        n.f(a2, "vectorTextViewParams");
        final String str3 = "context";
        i = 0;
        if (a2.l() != null) {
        } else {
            Integer num2 = a2.k();
            if (num2 != null) {
                Context context7 = textView.getContext();
                n.e(context7, str3);
                valueOf2 = Integer.valueOf(context7.getResources().getDimensionPixelSize(num2.intValue()));
            } else {
                valueOf2 = i;
            }
        }
        if (valueOf2 != 0) {
        } else {
            Integer num = a2.n();
            if (num != null) {
                Context context6 = textView.getContext();
                n.e(context6, str3);
                valueOf2 = Integer.valueOf(context6.getResources().getDimensionPixelSize(num.intValue()));
            } else {
                valueOf2 = i;
            }
        }
        if (a2.m() != null) {
        } else {
            Integer num4 = a2.p();
            if (num4 != null) {
                Context context8 = textView.getContext();
                n.e(context8, str3);
                valueOf = Integer.valueOf(context8.getResources().getDimensionPixelSize(num4.intValue()));
            } else {
                valueOf = i;
            }
        }
        if (valueOf != 0) {
        } else {
            Integer num5 = a2.n();
            if (num5 != null) {
                Context context9 = textView.getContext();
                n.e(context9, str3);
                valueOf = Integer.valueOf(context9.getResources().getDimensionPixelSize(num5.intValue()));
            } else {
                valueOf = i;
            }
        }
        if (a2.g() != null) {
        } else {
            Integer num6 = a2.h();
            if (num6 != null) {
                drawable4 = a.d(textView.getContext(), num6.intValue());
            } else {
                drawable4 = i;
            }
        }
        context = textView.getContext();
        n.e(context, str3);
        drawable4 = b.f(drawable4, context, valueOf, valueOf2);
        if (drawable4 != null && drawable4 != null) {
            context = textView.getContext();
            n.e(context, str3);
            drawable4 = b.f(drawable4, context, valueOf, valueOf2);
            if (drawable4 != null) {
                b.g(drawable4, a2.o());
            } else {
                drawable4 = i;
            }
        } else {
        }
        if (a2.e() != null) {
        } else {
            Integer num7 = a2.f();
            if (num7 != null) {
                drawable = a.d(textView.getContext(), num7.intValue());
            } else {
                drawable = i;
            }
        }
        context4 = textView.getContext();
        n.e(context4, str3);
        drawable = b.f(drawable, context4, valueOf, valueOf2);
        if (drawable != null && drawable != null) {
            context4 = textView.getContext();
            n.e(context4, str3);
            drawable = b.f(drawable, context4, valueOf, valueOf2);
            if (drawable != null) {
                b.g(drawable, a2.o());
            } else {
                drawable = i;
            }
        } else {
        }
        if (a2.c() != null) {
        } else {
            Integer num8 = a2.d();
            if (num8 != null) {
                drawable3 = a.d(textView.getContext(), num8.intValue());
            } else {
                drawable3 = i;
            }
        }
        context2 = textView.getContext();
        n.e(context2, str3);
        drawable3 = b.f(drawable3, context2, valueOf, valueOf2);
        if (drawable3 != null && drawable3 != null) {
            context2 = textView.getContext();
            n.e(context2, str3);
            drawable3 = b.f(drawable3, context2, valueOf, valueOf2);
            if (drawable3 != null) {
                b.g(drawable3, a2.o());
            } else {
                drawable3 = i;
            }
        } else {
        }
        if (a2.i() != null) {
        } else {
            Integer num9 = a2.j();
            if (num9 != null) {
                drawable2 = a.d(textView.getContext(), num9.intValue());
            } else {
                drawable2 = i;
            }
        }
        context3 = textView.getContext();
        n.e(context3, str3);
        valueOf2 = b.f(drawable2, context3, valueOf, valueOf2);
        if (drawable2 != null && valueOf2 != null) {
            context3 = textView.getContext();
            n.e(context3, str3);
            valueOf2 = b.f(drawable2, context3, valueOf, valueOf2);
            if (valueOf2 != null) {
                b.g(valueOf2, a2.o());
                i = valueOf2;
            }
        }
        if (a2.q()) {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable, i, drawable4, drawable3);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable4, i, drawable, drawable3);
        }
        resources3 = a2.a();
        if (resources3 != null) {
            textView.setCompoundDrawablePadding(resources3.intValue());
        } else {
            obj10 = a2.b();
            if (obj10 != null) {
                Context context5 = textView.getContext();
                n.e(context5, str3);
                textView.setCompoundDrawablePadding(context5.getResources().getDimensionPixelSize(obj10.intValue()));
            }
        }
    }

    public static final void b(VectorTextView vectorTextView, m m2) {
        int i11;
        Object drawable;
        int valueOf2;
        Integer i12;
        a aVar;
        int i3;
        int i16;
        int i4;
        int i17;
        int i13;
        int i14;
        int i9;
        int i15;
        int i8;
        int i18;
        Integer valueOf3;
        Integer valueOf;
        Integer valueOf4;
        int i7;
        int i5;
        int i2;
        int i10;
        int i19;
        int i;
        int i6;
        a aVar2;
        final Object obj = vectorTextView;
        n.f(obj, "$this$applyIconForm");
        n.f(m2, "iconForm");
        if (m2.a() != null) {
            i3 = Integer.valueOf(m2.c()).intValue() != Integer.MIN_VALUE ? 1 : 0;
            if (i3 != 0) {
            } else {
                valueOf2 = 0;
            }
            aVar2 = aVar4;
            super(0, 0, 0, 0, 0, 0, 0, 0, 0, Integer.valueOf(m2.f()), Integer.valueOf(m2.g()), Integer.valueOf(m2.e()), 0, valueOf2, 0, 0, 0, 119295, 0);
            switch (i12) {
                case 1:
                    aVar = aVar2;
                    aVar.v(m2.a());
                    aVar.w(m2.b());
                    break;
                case 2:
                    aVar = aVar2;
                    aVar.x(m2.a());
                    aVar.y(m2.b());
                    break;
                case 3:
                    aVar = aVar2;
                    aVar.r(m2.a());
                    aVar.s(m2.b());
                    break;
                case 4:
                    aVar = aVar2;
                    aVar.t(m2.a());
                    aVar.u(m2.b());
                    break;
                default:
                    aVar = aVar2;
            }
            drawable = w.a;
            obj.setDrawableTextViewParams(aVar);
        }
    }

    public static final void c(TextView textView, y y2) {
        Object charSequence;
        android.graphics.Typeface typeface;
        int i;
        n.f(textView, "$this$applyTextForm");
        n.f(y2, "textForm");
        boolean z = y2.e();
        if (z == 1) {
            charSequence = d.d(y2.b().toString());
            textView.setText(charSequence);
            textView.setTextSize(y2.f());
            textView.setGravity(y2.d());
            textView.setTextColor(y2.c());
            typeface = y2.h();
            if (typeface != null) {
                textView.setTypeface(typeface);
            } else {
                textView.setTypeface(textView.getTypeface(), y2.g());
            }
            final android.text.method.MovementMethod obj3 = y2.a();
            if (obj3 != null) {
                textView.setMovementMethod(obj3);
            }
        } else {
            if (z) {
            } else {
                charSequence = y2.b();
            }
        }
        NoWhenBranchMatchedException obj2 = new NoWhenBranchMatchedException();
        throw obj2;
    }

    private static final Spanned d(String string) {
        Spanned obj3;
        final int i = 0;
        if (Build.VERSION.SDK_INT >= 24) {
            obj3 = Html.fromHtml(string, i);
        } else {
            obj3 = b.a(string, i);
        }
        return obj3;
    }
}
