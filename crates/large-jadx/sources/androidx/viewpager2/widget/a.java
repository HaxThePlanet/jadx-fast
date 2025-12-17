package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.p;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes.dex */
final class a {

    private static final ViewGroup.MarginLayoutParams b;
    private LinearLayoutManager a;

    class a implements Comparator<int[]> {
        a(androidx.viewpager2.widget.a a) {
            super();
        }

        @Override // java.util.Comparator
        public int a(int[] iArr, int[] i2Arr2) {
            final int i = 0;
            return obj2 -= obj3;
        }

        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return a((int[])object, (int[])object2);
        }
    }
    static {
        int i = -1;
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(i, i);
        a.b = marginLayoutParams;
        int i2 = 0;
        marginLayoutParams.setMargins(i2, i2, i2, i2);
    }

    a(LinearLayoutManager linearLayoutManager) {
        super();
        this.a = linearLayoutManager;
    }

    private boolean a() {
        int i2;
        int i3;
        int i6;
        int i;
        int i4;
        int bottom;
        int bottomMargin;
        Object layoutParams;
        Object obj;
        int i5;
        int left;
        int leftMargin;
        i2 = this.a.g0();
        int i8 = 1;
        if (i2 == 0) {
            return i8;
        }
        final int i12 = 0;
        i3 = this.a.J2() == 0 ? i8 : i12;
        int i13 = 2;
        int[] iArr = new int[i13];
        iArr[i8] = i13;
        iArr[i12] = i2;
        Object instance = Array.newInstance(int.class, iArr);
        i = i12;
        while (i < i2) {
            View view = this.a.f0(i);
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            } else {
            }
            layoutParams = a.b;
            if (i3 != 0) {
            } else {
            }
            left = view.getTop();
            leftMargin = layoutParams.topMargin;
            (int[][])instance[i][i12] = left -= leftMargin;
            if (i3 != 0) {
            } else {
            }
            bottom = view.getBottom();
            bottomMargin = layoutParams.bottomMargin;
            instance[i][i8] = bottom += bottomMargin;
            i++;
            bottom = view.getRight();
            bottomMargin = layoutParams.rightMargin;
            left = view.getLeft();
            leftMargin = layoutParams.leftMargin;
        }
        a.a aVar = new a.a(this);
        Arrays.sort(instance, aVar);
        i6 = i8;
        while (i6 < i2) {
            i6++;
        }
        if (instance[i12][i12] <= 0 && instance[i2 -= i8][i8] < i10 -= i15) {
            if (instance[i2 -= i8][i8] < i10 -= i15) {
            }
            return i8;
        }
        return i12;
    }

    private boolean b() {
        int i;
        boolean z;
        final int i4 = 0;
        i = i4;
        while (i < this.a.g0()) {
            i++;
        }
        return i4;
    }

    private static boolean c(View view) {
        boolean childCount;
        LayoutTransition layoutTransition;
        int i2;
        int i;
        boolean z;
        final int i3 = 0;
        layoutTransition = (ViewGroup)view.getLayoutTransition();
        i2 = 1;
        if (view instanceof ViewGroup && layoutTransition != null && layoutTransition.isChangingLayout()) {
            layoutTransition = (ViewGroup)view.getLayoutTransition();
            i2 = 1;
            if (layoutTransition != null) {
                if (layoutTransition.isChangingLayout()) {
                    return i2;
                }
            }
            i = i3;
            while (i < view.getChildCount()) {
                i++;
            }
        }
        return i3;
    }

    boolean d() {
        int z;
        int i;
        if (a()) {
            if (this.a.g0() <= 1 && b()) {
                if (b()) {
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }
}
