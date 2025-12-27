package com.skydoves.balloon.a0;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;
import com.skydoves.balloon.m;
import com.skydoves.balloon.vectortext.VectorTextView;
import com.skydoves.balloon.y;
import d.h.j.b;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.n;
import kotlin.w;

/* compiled from: TextViewExtension.kt */
/* loaded from: classes2.dex */
public final class d {
    public static final /* synthetic */ void a(TextView textView, com.skydoves.balloon.vectortext.a aVar) throws android.content.res.Resources.NotFoundException {
        int i;
        Integer num;
        android.graphics.drawable.Drawable drawable = null;
        Resources resources;
        Integer num3;
        Resources resources2;
        android.graphics.drawable.Drawable drawable2;
        Context context;
        android.graphics.drawable.Drawable drawable3;
        Context context2;
        android.graphics.drawable.Drawable drawable4;
        Context context3;
        android.graphics.drawable.Drawable drawable5;
        Context context4;
        n.f(textView, "$this$applyDrawable");
        n.f(aVar, "vectorTextViewParams");
        final String str3 = "context";
        i = 0;
        if (aVar.l() == null) {
            Integer num8 = aVar.k();
            if (num8 != null) {
                Context context7 = textView.getContext();
                n.e(context7, str3);
                Integer num9 = Integer.valueOf(context7.getResources().getDimensionPixelSize(num8.intValue()));
            } else {
            }
        }
        if (i == 0) {
            Integer num7 = aVar.n();
            if (num7 != null) {
                Context context6 = textView.getContext();
                n.e(context6, str3);
                num = Integer.valueOf(context6.getResources().getDimensionPixelSize(num7.intValue()));
            } else {
            }
        }
        if (aVar.m() == null) {
            Integer num12 = aVar.p();
            if (num12 != null) {
                Context context8 = textView.getContext();
                n.e(context8, str3);
                Integer num13 = Integer.valueOf(context8.getResources().getDimensionPixelSize(num12.intValue()));
            } else {
            }
        }
        if (i == 0) {
            Integer num14 = aVar.n();
            if (num14 != null) {
                Context context9 = textView.getContext();
                n.e(context9, str3);
                num3 = Integer.valueOf(context9.getResources().getDimensionPixelSize(num14.intValue()));
            } else {
            }
        }
        if (aVar.g() == null) {
            Integer num15 = aVar.h();
            if (num15 != null) {
                drawable2 = a.d(textView.getContext(), num15.intValue());
            } else {
            }
        }
        if (drawable2 != null) {
            context = textView.getContext();
            n.e(context, str3);
            drawable2 = b.f(drawable2, context, num3, num);
            if (drawable2 != null) {
                b.g(drawable2, aVar.o());
            } else {
            }
        }
        if (aVar.e() == null) {
            Integer num16 = aVar.f();
            if (num16 != null) {
                drawable3 = a.d(textView.getContext(), num16.intValue());
            } else {
            }
        }
        if (drawable3 != null) {
            context2 = textView.getContext();
            n.e(context2, str3);
            drawable3 = b.f(drawable3, context2, num3, num);
            if (drawable3 != null) {
                b.g(drawable3, aVar.o());
            } else {
            }
        }
        if (aVar.c() == null) {
            Integer num19 = aVar.d();
            if (num19 != null) {
                drawable4 = a.d(textView.getContext(), num19.intValue());
            } else {
            }
        }
        if (drawable4 != null) {
            context3 = textView.getContext();
            n.e(context3, str3);
            drawable4 = b.f(drawable4, context3, num3, num);
            if (drawable4 != null) {
                b.g(drawable4, aVar.o());
            } else {
            }
        }
        if (aVar.i() == null) {
            Integer num20 = aVar.j();
            if (num20 != null) {
                drawable5 = a.d(textView.getContext(), num20.intValue());
            } else {
            }
        }
        if (drawable5 != null && drawable != null) {
            b.g(drawable, aVar.o());
        }
        if (aVar.q()) {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable3, drawable, drawable2, drawable4);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, drawable, drawable3, drawable4);
        }
        Integer num2 = aVar.a();
        if (num2 != null) {
            textView.setCompoundDrawablePadding(num2.intValue());
        } else {
            Integer num5 = aVar.b();
            if (num5 != null) {
                Context context5 = textView.getContext();
                n.e(context5, str3);
                textView.setCompoundDrawablePadding(context5.getResources().getDimensionPixelSize(num5.intValue()));
            }
        }
    }

    public static final /* synthetic */ void b(VectorTextView vectorTextView, m mVar) {
        int i = 0;
        int i2 = 0;
        com.skydoves.balloon.vectortext.a aVar;
        final Object vectorTextView2 = vectorTextView;
        n.f(vectorTextView2, "$this$applyIconForm");
        n.f(mVar, "iconForm");
        if (mVar.a() != null) {
            Integer num2 = null;
            Integer num3 = null;
            Integer num4 = null;
            Integer num5 = null;
            android.graphics.drawable.Drawable drawable2 = null;
            android.graphics.drawable.Drawable drawable3 = null;
            android.graphics.drawable.Drawable drawable4 = null;
            android.graphics.drawable.Drawable drawable5 = null;
            Integer num9 = null;
            int r3 = Integer.valueOf(mVar.c()).intValue() != -2147483648 ? 1 : 0;
            if (i2 == 0) {
                i = 0;
            }
            Integer num11 = null;
            Integer num12 = null;
            Integer num13 = null;
            int i3 = 119295;
            kotlin.d0.d.g gVar = null;
            boolean z = false;
            aVar = new a(null, null, null, null, null, null, null, null, z, Integer.valueOf(mVar.f()), Integer.valueOf(mVar.g()), Integer.valueOf(mVar.e()), null, i, num11, num12, num13, i3, gVar);
            switch (c.a[mVar.d().ordinal()]) {
                case 1: /* ordinal */
                    aVar.v(mVar.a());
                    aVar.w(mVar.b());
                    break;
                case 2: /* ordinal */
                    aVar.x(mVar.a());
                    aVar.y(mVar.b());
                    break;
                case 3: /* ordinal */
                    aVar.r(mVar.a());
                    aVar.s(mVar.b());
                    break;
                case 4: /* ordinal */
                    aVar.t(mVar.a());
                    aVar.u(mVar.b());
                    break;
                default:
            }
            w wVar = w.a;
            vectorTextView2.setDrawableTextViewParams(aVar);
        }
    }

    public static final /* synthetic */ void c(TextView textView, y yVar) throws NoWhenBranchMatchedException {
        java.lang.CharSequence charSequence;
        n.f(textView, "$this$applyTextForm");
        n.f(yVar, "textForm");
        boolean z = yVar.e();
        int i = 1;
        if (z) {
            Spanned spanned = d.d(yVar.b().toString());
            textView.setText(charSequence);
            textView.setTextSize(yVar.f());
            textView.setGravity(yVar.d());
            textView.setTextColor(yVar.c());
            android.graphics.Typeface typeface = yVar.h();
            if (typeface != null) {
                textView.setTypeface(typeface);
            } else {
                textView.setTypeface(textView.getTypeface(), yVar.g());
            }
            final android.text.method.MovementMethod movementMethod = yVar.a();
            if (movementMethod != null) {
                textView.setMovementMethod(movementMethod);
            }
            return;
        } else {
            if (!z) {
                charSequence = yVar.b();
            }
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final Spanned d(String str) {
        Spanned html;
        final int i = 0;
        if (Build.VERSION.SDK_INT >= 24) {
            html = Html.fromHtml(str, i);
        } else {
            html = b.a(str, i);
        }
        return html;
    }
}
