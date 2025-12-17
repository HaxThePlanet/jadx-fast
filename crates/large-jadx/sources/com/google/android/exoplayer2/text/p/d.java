package com.google.android.exoplayer2.text.p;

import android.text.Spannable;

/* loaded from: classes2.dex */
public final class d {
    public static void a(Spannable spannable, Object object2, int i3, int i4, int i5) {
        int i;
        Object obj;
        int spanStart;
        Object[] spans = spannable.getSpans(i3, i4, object2.getClass());
        i = 0;
        while (i < spans.length) {
            obj = spans[i];
            if (spannable.getSpanStart(obj) == i3 && spannable.getSpanEnd(obj) == i4 && spannable.getSpanFlags(obj) == i5) {
            }
            i++;
            if (spannable.getSpanEnd(obj) == i4) {
            }
            if (spannable.getSpanFlags(obj) == i5) {
            }
            spannable.removeSpan(obj);
        }
        spannable.setSpan(object2, i3, i4, i5);
    }
}
