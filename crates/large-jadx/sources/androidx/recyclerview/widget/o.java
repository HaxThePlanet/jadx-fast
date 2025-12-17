package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: classes.dex */
class o {

    boolean a = true;
    int b;
    int c;
    int d;
    int e;
    int f = 0;
    int g = 0;
    boolean h;
    boolean i;
    o() {
        super();
        int i = 1;
        int i2 = 0;
    }

    boolean a(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        int obj2;
        final int i = this.c;
        if (i >= 0 && i < b0.c()) {
            obj2 = i < b0.c() ? 1 : 0;
        } else {
        }
        return obj2;
    }

    View b(androidx.recyclerview.widget.RecyclerView.w recyclerView$w) {
        this.c = i2 += i4;
        return w.o(this.c);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LayoutState{mAvailable=");
        stringBuilder.append(this.b);
        stringBuilder.append(", mCurrentPosition=");
        stringBuilder.append(this.c);
        stringBuilder.append(", mItemDirection=");
        stringBuilder.append(this.d);
        stringBuilder.append(", mLayoutDirection=");
        stringBuilder.append(this.e);
        stringBuilder.append(", mStartLine=");
        stringBuilder.append(this.f);
        stringBuilder.append(", mEndLine=");
        stringBuilder.append(this.g);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
