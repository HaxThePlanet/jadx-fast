package com.github.ksoichiro.android.observablescrollview;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: ObservableRecyclerView.java */
/* loaded from: classes.dex */
public class ObservableRecyclerView extends RecyclerView {

    private static int q1 = 22;
    private int d1;
    private int e1 = -1;
    private int f1;
    private int g1;
    private int h1;
    private SparseIntArray i1;
    private a j1;
    private b k1;
    private boolean l1;
    private boolean m1;
    private boolean n1;
    private MotionEvent o1;
    private ViewGroup p1;

    class a implements Runnable {

        final /* synthetic */ ViewGroup a;
        final /* synthetic */ MotionEvent b;
        a(ViewGroup viewGroup, MotionEvent motionEvent) {
            this.a = viewGroup;
            this.b = motionEvent;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.dispatchTouchEvent(this.b);
        }
    }

    static class b implements Parcelable {

        public static final Parcelable.Creator<ObservableRecyclerView.b> CREATOR = new ObservableRecyclerView$b$b<>();
        public static final ObservableRecyclerView.b z = new ObservableRecyclerView$b$a();
        int a;
        int b;
        int c;
        int v;
        int w;
        SparseIntArray x;
        Parcelable y;

        /* synthetic */ b(Parcel parcel, ObservableRecyclerView.a aVar) {
            this(parcel);
        }

        public Parcelable a() {
            return this.y;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            int size = 0;
            int valueAt;
            parcel.writeParcelable(this.y, i);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.v);
            parcel.writeInt(this.w);
            size = 0;
            if (this.x == null) {
            } else {
                size = this.x.size();
            }
            parcel.writeInt(size);
            if (this.v > 0) {
                while (this.y < this.v) {
                    parcel.writeInt(this.x.keyAt(size));
                    parcel.writeInt(this.x.valueAt(size));
                    size = size + 1;
                }
            }
        }

        /* synthetic */ b(ObservableRecyclerView.a aVar) {
            this();
        }

        private b() {
            super();
            this.b = -1;
            this.y = null;
        }

        b(Parcelable parcelable) {
            int i = 0;
            super();
            this.b = -1;
            if (parcelable == ObservableRecyclerView.b.z) {
                i = 0;
            }
            this.y = i;
        }

        private b(Parcel parcel) {
            com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView.b bVar;
            int i = 0;
            int _int;
            int _int2;
            SparseIntArray sparseIntArray;
            super();
            this.b = -1;
            if (parcel.readParcelable(RecyclerView.class.getClassLoader()) == null) {
                bVar = ObservableRecyclerView.b.z;
            }
            this.y = bVar;
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            this.v = parcel.readInt();
            this.w = parcel.readInt();
            this.x = new SparseIntArray();
            int _int8 = parcel.readInt();
            if (_int8 > 0) {
                i = 0;
                while (i < _int8) {
                    this.x.put(parcel.readInt(), parcel.readInt());
                    i = i + 1;
                }
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }
    }
    public ObservableRecyclerView(Context context, AttributeSet set) {
        super(context, set);
        H1();
    }

    private void G1() {
        View view = null;
        try {
            super.g0(view);
        } catch (java.lang.NoSuchMethodError unused) {
            ObservableRecyclerView.q1 = 21;
        }
    }

    private void H1() {
        this.i1 = new SparseIntArray();
        G1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public int g0(View view) {
        if (22 <= ObservableRecyclerView.q1) {
            return super.g0(view);
        }
        return i0(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public int getCurrentScrollY() {
        return this.h1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onRestoreInstanceState(Parcelable parcelable) {
        this.d1 = parcelable.a;
        this.e1 = parcelable.b;
        this.f1 = parcelable.c;
        this.g1 = parcelable.v;
        this.h1 = parcelable.w;
        this.i1 = parcelable.x;
        super.onRestoreInstanceState(parcelable.a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public Parcelable onSaveInstanceState() {
        final com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView.b bVar = new ObservableRecyclerView.b(super.onSaveInstanceState());
        bVar.a = this.d1;
        bVar.b = this.e1;
        bVar.c = this.f1;
        bVar.v = this.g1;
        bVar.w = this.h1;
        bVar.x = this.i1;
        return bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        int i22;
        int i5;
        int height;
        SparseIntArray sparseIntArray;
        int indexOfKey;
        int i6;
        com.github.ksoichiro.android.observablescrollview.b dOWN2;
        int height2;
        super.onScrollChanged(i, i2, i3, i4);
        if (this.j1 != null && this.getChildCount() > 0) {
            i5 = 0;
            i22 = g0(getChildAt(i5));
            height2 = 1;
            while (i22 <= g0(getChildAt(getChildCount() - height2))) {
                View childAt2 = getChildAt(i5);
                this.i1.put(i22, i5);
                i22 = i22 + 1;
                i5 = i5 + 1;
            }
            View childAt = getChildAt(i5);
            if (childAt != null && this.d1 < i22) {
                if (i22 - i5 != height2) {
                    height2 = i22 - 1;
                    while (height2 > this.d1) {
                        i5 = i5 + i5;
                        height2 = height2 - 1;
                    }
                } else {
                }
                i5 = this.e1 + i5;
                this.f1 += i5;
                this.e1 = childAt.getHeight();
                if (this.e1 < 0) {
                    this.e1 = i5;
                }
                height2 = this.f1 - childAt.getTop();
                this.h1 = height2;
                this.d1 = i22;
                this.j1.c(height2, this.l1, this.m1);
                if (this.l1) {
                    this.l1 = false;
                }
                if (this.g1 < this.h1) {
                    this.k1 = b.UP;
                } else {
                    if (this.h1 < this.g1) {
                        this.k1 = b.DOWN;
                    } else {
                        this.k1 = b.STOP;
                    }
                }
                this.g1 = this.h1;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f = 0;
        ViewGroup viewGroup;
        int cmp = 2;
        Object obj;
        if (this.j1 != null) {
            int actionMasked = motionEvent.getActionMasked();
            int i = 1;
            int i2 = 0;
            if (actionMasked == i || actionMasked != 2) {
                this.n1 = false;
                this.m1 = false;
                this.j1.a(this.k1);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setScrollViewCallbacks(a aVar) {
        this.j1 = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setTouchInterceptionViewGroup(ViewGroup viewGroup) {
        this.p1 = viewGroup;
    }

}
