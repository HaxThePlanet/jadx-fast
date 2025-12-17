package com.google.android.material.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* loaded from: classes2.dex */
public class b {

    private static final java.lang.ThreadLocal<Matrix> a;
    private static final java.lang.ThreadLocal<RectF> b;
    static {
        ThreadLocal threadLocal = new ThreadLocal();
        b.a = threadLocal;
        ThreadLocal threadLocal2 = new ThreadLocal();
        b.b = threadLocal2;
    }

    public static void a(ViewGroup viewGroup, View view2, Rect rect3) {
        final int i = 0;
        rect3.set(i, i, view2.getWidth(), view2.getHeight());
        b.c(viewGroup, view2, rect3);
    }

    private static void b(ViewParent viewParent, View view2, Matrix matrix3) {
        ViewParent parent;
        ViewParent obj2;
        parent = view2.getParent();
        if (parent instanceof View != null && parent != viewParent) {
            if (parent != viewParent) {
                b.b(viewParent, (View)parent, matrix3);
                matrix3.preTranslate((float)obj2, (float)i);
            }
        }
        matrix3.preTranslate((float)obj2, (float)top);
        if (!view2.getMatrix().isIdentity()) {
            matrix3.preConcat(view2.getMatrix());
        }
    }

    public static void c(ViewGroup viewGroup, View view2, Rect rect3) {
        Object matrix;
        Object obj4;
        java.lang.ThreadLocal threadLocal = b.a;
        matrix = threadLocal.get();
        if ((Matrix)matrix == null) {
            matrix = new Matrix();
            threadLocal.set(matrix);
        } else {
            (Matrix)matrix.reset();
        }
        b.b(viewGroup, view2, matrix);
        java.lang.ThreadLocal obj3 = b.b;
        if ((RectF)obj3.get() == null) {
            obj4 = new RectF();
            obj3.set(obj4);
        }
        obj4.set(rect3);
        matrix.mapRect(obj4);
        int i = 1056964608;
        rect3.set((int)obj3, (int)i2, (int)i4, (int)obj4);
    }
}
