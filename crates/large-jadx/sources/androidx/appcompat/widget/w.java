package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import d.a.j;
import d.h.l.u;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
class w {

    private static final RectF l;
    private static ConcurrentHashMap<String, Method> m;
    private static ConcurrentHashMap<String, Field> n;
    private int a = 0;
    private boolean b = false;
    private float c = -1f;
    private float d = -1f;
    private float e = -1f;
    private int[] f;
    private boolean g = false;
    private TextPaint h;
    private final TextView i;
    private final Context j;
    private final androidx.appcompat.widget.w.c k;

    private static class c {
        void a(StaticLayout.Builder staticLayout$Builder, TextView textView2) {
        }

        boolean b(TextView textView) {
            return (Boolean)w.r(textView, "getHorizontallyScrolling", Boolean.FALSE).booleanValue();
        }
    }

    private static class a extends androidx.appcompat.widget.w.c {
        @Override // androidx.appcompat.widget.w$c
        void a(StaticLayout.Builder staticLayout$Builder, TextView textView2) {
            builder.setTextDirection((TextDirectionHeuristic)w.r(textView2, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    private static class b extends androidx.appcompat.widget.w.a {
        @Override // androidx.appcompat.widget.w$a
        void a(StaticLayout.Builder staticLayout$Builder, TextView textView2) {
            builder.setTextDirection(textView2.getTextDirectionHeuristic());
        }

        @Override // androidx.appcompat.widget.w$a
        boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }
    static {
        RectF rectF = new RectF();
        w.l = rectF;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        w.m = concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        w.n = concurrentHashMap2;
    }

    w(TextView textView) {
        int i;
        androidx.appcompat.widget.w.c obj3;
        super();
        int i3 = -1082130432;
        this.f = new int[0];
        this.i = textView;
        this.j = textView.getContext();
        obj3 = Build.VERSION.SDK_INT;
        if (obj3 >= 29) {
            obj3 = new w.b();
            this.k = obj3;
        } else {
            if (obj3 >= 23) {
                obj3 = new w.a();
                this.k = obj3;
            } else {
                obj3 = new w.c();
                this.k = obj3;
            }
        }
    }

    private void A(TypedArray typedArray) {
        int i;
        int dimensionPixelSize;
        int[] obj5;
        final int length = typedArray.length();
        final int[] iArr = new int[length];
        if (length > 0) {
            i = 0;
            while (i < length) {
                iArr[i] = typedArray.getDimensionPixelSize(i, -1);
                i++;
            }
            this.f = c(iArr);
            B();
        }
    }

    private boolean B() {
        int[] iArr;
        int length;
        int i2;
        int i;
        iArr = this.f;
        length = iArr.length;
        i2 = 0;
        final int i5 = 1;
        i = length > 0 ? i5 : i2;
        this.g = i;
        if (i != 0) {
            this.a = i5;
            this.d = (float)i4;
            this.e = (float)i3;
            this.c = -1082130432;
        }
        return i;
    }

    private boolean C(int i, RectF rectF2) {
        java.lang.CharSequence length;
        Object transformationMethod;
        int maxLines;
        TextView view;
        int lineCount;
        transformationMethod = this.i.getTransformationMethod();
        transformationMethod = transformationMethod.getTransformation(this.i.getText(), this.i);
        if (transformationMethod != null && transformationMethod != null) {
            transformationMethod = transformationMethod.getTransformation(length, this.i);
            if (transformationMethod != null) {
                length = transformationMethod;
            }
        }
        lineCount = -1;
        if (Build.VERSION.SDK_INT >= 16) {
            maxLines = this.i.getMaxLines();
        } else {
            maxLines = lineCount;
        }
        q(i);
        StaticLayout obj6 = e(length, (Layout.Alignment)w.r(this.i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF2.right), maxLines);
        int i4 = 0;
        int i5 = 1;
        if (maxLines != lineCount && obj6.getLineCount() <= maxLines && obj6.getLineEnd(lineCount2 -= i5) != length.length()) {
            if (obj6.getLineCount() <= maxLines) {
                if (obj6.getLineEnd(lineCount2 -= i5) != length.length()) {
                }
            }
            return i4;
        }
        if (Float.compare(obj6, obj7) > 0) {
            return i4;
        }
        return i5;
    }

    private boolean D() {
        return z ^= 1;
    }

    private void E(float f, float f2, float f3) {
        int i = 0;
        final String str4 = "px) is less or equal to (0px)";
        if (Float.compare(f, i) <= 0) {
        } else {
            if (Float.compare(f2, f) <= 0) {
            } else {
                if (Float.compare(f3, i) <= 0) {
                } else {
                    this.a = 1;
                    this.d = f;
                    this.e = f2;
                    this.c = f3;
                    this.g = false;
                }
                StringBuilder obj5 = new StringBuilder();
                obj5.append("The auto-size step granularity (");
                obj5.append(f3);
                obj5.append(str4);
                IllegalArgumentException obj4 = new IllegalArgumentException(obj5.toString());
                throw obj4;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Maximum auto-size text size (");
            stringBuilder.append(f2);
            stringBuilder.append("px) is less or equal to minimum auto-size text size (");
            stringBuilder.append(f);
            stringBuilder.append("px)");
            IllegalArgumentException obj6 = new IllegalArgumentException(stringBuilder.toString());
            throw obj6;
        }
        obj6 = new StringBuilder();
        obj6.append("Minimum auto-size text size (");
        obj6.append(f);
        obj6.append(str4);
        obj5 = new IllegalArgumentException(obj6.toString());
        throw obj5;
    }

    private static <T> T a(Object object, String string2, T t3) {
        try {
            final Field field = w.o(string2);
            if (field == null) {
            }
            return t3;
            return field.get(object);
            StringBuilder str = new StringBuilder();
            str.append("Failed to access TextView#");
            str.append(string2);
            string2 = " member";
            str.append(string2);
            string2 = str.toString();
            str = "ACTVAutoSizeHelper";
            Log.w(str, string2, object);
            return t3;
        }
    }

    private int[] c(int[] iArr) {
        int i2;
        int i;
        int intValue;
        int valueOf;
        int binarySearch;
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        i = i2;
        while (i < length) {
            valueOf = iArr[i];
            if (valueOf > 0 && Collections.binarySearch(arrayList, Integer.valueOf(valueOf)) < 0) {
            }
            i++;
            if (Collections.binarySearch(arrayList, Integer.valueOf(valueOf)) < 0) {
            }
            arrayList.add(Integer.valueOf(valueOf));
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        final int obj7 = arrayList.size();
        int[] iArr2 = new int[obj7];
        while (i2 < obj7) {
            iArr2[i2] = (Integer)arrayList.get(i2).intValue();
            i2++;
        }
        return iArr2;
    }

    private void d() {
        final int i = 0;
        this.a = i;
        int i2 = -1082130432;
        this.d = i2;
        this.e = i2;
        this.c = i2;
        this.f = new int[i];
        this.b = i;
    }

    private StaticLayout f(java.lang.CharSequence charSequence, Layout.Alignment layout$Alignment2, int i3, int i4) {
        androidx.appcompat.widget.w.c obj5;
        TextView obj6;
        int obj7;
        StaticLayout.Builder obj4 = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.h, i3);
        if (i4 == -1) {
            obj7 = Integer.MAX_VALUE;
        }
        obj4.setAlignment(alignment2).setLineSpacing(this.i.getLineSpacingExtra(), this.i.getLineSpacingMultiplier()).setIncludePad(this.i.getIncludeFontPadding()).setBreakStrategy(this.i.getBreakStrategy()).setHyphenationFrequency(this.i.getHyphenationFrequency()).setMaxLines(obj7);
        this.k.a(obj4, this.i);
        return obj4.build();
    }

    private StaticLayout g(java.lang.CharSequence charSequence, Layout.Alignment layout$Alignment2, int i3) {
        super(charSequence, this.h, i3, alignment2, (Float)w.a(this.i, "mSpacingMult", 1f).floatValue(), (Float)w.a(this.i, "mSpacingAdd", 0f).floatValue(), (Boolean)w.a(this.i, "mIncludePad", Boolean.TRUE).booleanValue());
        return staticLayout;
    }

    private StaticLayout h(java.lang.CharSequence charSequence, Layout.Alignment layout$Alignment2, int i3) {
        super(charSequence, this.h, i3, alignment2, this.i.getLineSpacingMultiplier(), this.i.getLineSpacingExtra(), this.i.getIncludeFontPadding());
        return staticLayout;
    }

    private int i(RectF rectF) {
        int i2;
        int i;
        int i4;
        int i3;
        boolean z;
        int i5;
        int length = iArr.length;
        if (length == 0) {
        } else {
            i = 0;
            length -= i4;
            while (/* condition */) {
                while (i <= i2) {
                    i6 /= 2;
                    if (C(this.f[i7], rectF)) {
                        break loop_3;
                    } else {
                    }
                    i2 = i3;
                }
                i6 /= 2;
                if (C(this.f[i7], rectF)) {
                } else {
                }
                i2 = i3;
                i7++;
                i3 = i;
                i = i5;
            }
            return this.f[i3];
        }
        IllegalStateException obj6 = new IllegalStateException("No available text sizes to choose from.");
        throw obj6;
    }

    private static Field o(String string) {
        Object declaredField;
        Object str;
        try {
            declaredField = TextView.class.getDeclaredField(string);
            if ((Field)w.n.get(string) == null && declaredField != null) {
            }
            declaredField = TextView.class.getDeclaredField(string);
            if (declaredField != null) {
            }
            declaredField.setAccessible(true);
            w.n.put(string, declaredField);
            return declaredField;
            str = new StringBuilder();
            str.append("Failed to access TextView#");
            str.append(string);
            string = " member";
            str.append(string);
            string = str.toString();
            str = "ACTVAutoSizeHelper";
            Log.w(str, string, th);
            string = null;
            return string;
        }
    }

    private static Method p(String string) {
        Object declaredMethod;
        Object str;
        try {
            declaredMethod = TextView.class.getDeclaredMethod(string, new Class[0]);
            if ((Method)w.m.get(string) == null && declaredMethod != null) {
            }
            declaredMethod = TextView.class.getDeclaredMethod(string, new Class[0]);
            if (declaredMethod != null) {
            }
            declaredMethod.setAccessible(true);
            w.m.put(string, declaredMethod);
            return declaredMethod;
            str = new StringBuilder();
            str.append("Failed to retrieve TextView#");
            str.append(string);
            string = "() method";
            str.append(string);
            string = str.toString();
            str = "ACTVAutoSizeHelper";
            Log.w(str, string, th);
            string = null;
            return string;
        }
    }

    static <T> T r(Object object, String string2, T t3) {
        int i;
        Method method;
        Object[] arr;
        String str;
        Object obj4;
        String obj5;
        return w.p(string2).invoke(object, new Object[0]);
    }

    private void x(float f) {
        Method layout;
        int str2;
        Object str;
        int obj4;
        if (Float.compare(f, textSize) != 0) {
            this.i.getPaint().setTextSize(f);
            str2 = 0;
            if (Build.VERSION.SDK_INT >= 18) {
                obj4 = this.i.isInLayout();
            } else {
                obj4 = str2;
            }
            this.b = str2;
            layout = w.p("nullLayouts");
            if (this.i.getLayout() != null && layout != null) {
                this.b = str2;
                layout = w.p("nullLayouts");
                if (layout != null) {
                    layout.invoke(this.i, new Object[str2]);
                }
                if (obj4 == null) {
                    this.i.requestLayout();
                } else {
                    this.i.forceLayout();
                }
                this.i.invalidate();
            }
        }
    }

    private boolean z() {
        boolean length;
        int i2;
        int i3;
        int[] iArr;
        double round;
        int i;
        float f;
        i3 = 1;
        if (D() && this.a == i3) {
            i3 = 1;
            if (this.a == i3) {
                if (this.g) {
                    if (iArr2.length == 0) {
                        i6 += i3;
                        iArr = new int[i7];
                        while (i2 < i7) {
                            iArr[i2] = Math.round(f5 += i);
                            i2++;
                        }
                        this.f = c(iArr);
                    }
                } else {
                }
                this.b = i3;
            } else {
                this.b = false;
            }
        } else {
        }
        return this.b;
    }

    void b() {
        int measuredHeight;
        boolean z;
        TextView totalPaddingRight;
        int cmp;
        int compoundPaddingTop;
        if (!s()) {
        }
        if (this.b && this.i.getMeasuredHeight() > 0) {
            if (this.i.getMeasuredHeight() > 0) {
                if (this.i.getMeasuredWidth() <= 0) {
                } else {
                    if (this.k.b(this.i)) {
                        measuredHeight = 1048576;
                    } else {
                        i2 -= totalPaddingRight;
                    }
                    i4 -= compoundPaddingTop;
                    if (measuredHeight > 0 && cmp <= 0) {
                        if (cmp <= 0) {
                        }
                        compoundPaddingTop = w.l;
                        compoundPaddingTop.setEmpty();
                        compoundPaddingTop.right = (float)measuredHeight;
                        compoundPaddingTop.bottom = (float)cmp;
                        z = (float)i;
                        synchronized (compoundPaddingTop) {
                            y(0, z);
                        }
                    }
                }
            }
        }
        this.b = true;
    }

    StaticLayout e(java.lang.CharSequence charSequence, Layout.Alignment layout$Alignment2, int i3, int i4) {
        final int sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 23) {
            return f(charSequence, alignment2, i3, i4);
        }
        if (sDK_INT >= 16) {
            return h(charSequence, alignment2, i3);
        }
        return g(charSequence, alignment2, i3);
    }

    int j() {
        return Math.round(this.e);
    }

    int k() {
        return Math.round(this.d);
    }

    int l() {
        return Math.round(this.c);
    }

    int[] m() {
        return this.f;
    }

    int n() {
        return this.a;
    }

    void q(int i) {
        TextPaint textPaint;
        textPaint = this.h;
        if (textPaint == null) {
            textPaint = new TextPaint();
            this.h = textPaint;
        } else {
            textPaint.reset();
        }
        this.h.set(this.i.getPaint());
        this.h.setTextSize((float)i);
    }

    boolean s() {
        boolean z;
        int i;
        if (D() && this.a != 0) {
            i = this.a != 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    void t(AttributeSet attributeSet, int i2) {
        boolean cmp;
        float dimension;
        int resourceId;
        boolean resources;
        int obj10;
        float obj11;
        int[] iArr = j.d0;
        final int i7 = 0;
        TypedArray styledAttributes = this.j.obtainStyledAttributes(attributeSet, iArr, i2, i7);
        TextView view = this.i;
        u.j0(view, view.getContext(), iArr, attributeSet, styledAttributes, i2, 0);
        obj10 = j.i0;
        if (styledAttributes.hasValue(obj10)) {
            this.a = styledAttributes.getInt(obj10, i7);
        }
        obj10 = j.h0;
        int i = -1082130432;
        if (styledAttributes.hasValue(obj10)) {
            obj10 = styledAttributes.getDimension(obj10, i);
        } else {
            obj10 = i;
        }
        obj11 = j.f0;
        if (styledAttributes.hasValue(obj11)) {
            obj11 = styledAttributes.getDimension(obj11, i);
        } else {
            obj11 = i;
        }
        int i3 = j.e0;
        if (styledAttributes.hasValue(i3)) {
            dimension = styledAttributes.getDimension(i3, i);
        } else {
            dimension = i;
        }
        resourceId = j.g0;
        resourceId = styledAttributes.getResourceId(resourceId, i7);
        if (styledAttributes.hasValue(resourceId) && resourceId > 0) {
            resourceId = styledAttributes.getResourceId(resourceId, i7);
            if (resourceId > 0) {
                resourceId = styledAttributes.getResources().obtainTypedArray(resourceId);
                A(resourceId);
                resourceId.recycle();
            }
        }
        styledAttributes.recycle();
        if (D()) {
            android.util.DisplayMetrics displayMetrics = this.j.getResources().getDisplayMetrics();
            resources = 2;
            if (this.a == 1 && !this.g && Float.compare(obj11, i) == 0) {
                if (!this.g) {
                    displayMetrics = this.j.getResources().getDisplayMetrics();
                    resources = 2;
                    if (Float.compare(obj11, i) == 0) {
                        obj11 = TypedValue.applyDimension(resources, 1094713344, displayMetrics);
                    }
                    if (Float.compare(dimension, i) == 0) {
                        dimension = TypedValue.applyDimension(resources, 1121976320, displayMetrics);
                    }
                    if (Float.compare(obj10, i) == 0) {
                        obj10 = 1065353216;
                    }
                    E(obj11, dimension, obj10);
                }
                z();
            }
        } else {
            this.a = i7;
        }
    }

    void u(int i, int i2, int i3, int i4) {
        boolean displayMetrics;
        boolean obj2;
        float obj3;
        float obj4;
        displayMetrics = this.j.getResources().getDisplayMetrics();
        E(TypedValue.applyDimension(i4, (float)i, displayMetrics), TypedValue.applyDimension(i4, (float)i2, displayMetrics), TypedValue.applyDimension(i4, (float)i3, displayMetrics));
        if (D() && z()) {
            displayMetrics = this.j.getResources().getDisplayMetrics();
            E(TypedValue.applyDimension(i4, (float)i, displayMetrics), TypedValue.applyDimension(i4, (float)i2, displayMetrics), TypedValue.applyDimension(i4, (float)i3, displayMetrics));
            if (z()) {
                b();
            }
        }
    }

    void v(int[] iArr, int i2) {
        boolean length;
        int i;
        int[] copyOf;
        android.util.DisplayMetrics displayMetrics;
        int round;
        int[] obj6;
        int obj7;
        length = iArr.length;
        if (D() && length > 0) {
            length = iArr.length;
            if (length > 0) {
                if (i2 == 0) {
                    copyOf = Arrays.copyOf(iArr, length);
                } else {
                    while (i < length) {
                        new int[length][i] = Math.round(TypedValue.applyDimension(i2, (float)i3, this.j.getResources().getDisplayMetrics()));
                        i++;
                    }
                }
                this.f = c(copyOf);
                if (!B()) {
                } else {
                    if (z()) {
                        b();
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("None of the preset sizes is valid: ");
                stringBuilder.append(Arrays.toString(iArr));
                obj7 = new IllegalArgumentException(stringBuilder.toString());
                throw obj7;
            }
            this.g = false;
        }
    }

    void w(int i) {
        boolean dimension;
        int i3;
        int i2;
        int obj4;
        if (D() && i != 0) {
            if (i != 0) {
                if (i != 1) {
                } else {
                    obj4 = this.j.getResources().getDisplayMetrics();
                    int i6 = 2;
                    E(TypedValue.applyDimension(i6, 1094713344, obj4), TypedValue.applyDimension(i6, 1121976320, obj4), 1065353216);
                    if (z()) {
                        b();
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown auto-size text type: ");
                stringBuilder.append(i);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                throw illegalArgumentException;
            }
            d();
        }
    }

    void y(int i, float f2) {
        Resources resources;
        Context context = this.j;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        x(TypedValue.applyDimension(i, f2, resources.getDisplayMetrics()));
    }
}
