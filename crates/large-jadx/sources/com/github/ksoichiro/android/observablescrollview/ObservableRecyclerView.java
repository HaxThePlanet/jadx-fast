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

/* loaded from: classes.dex */
public class ObservableRecyclerView extends RecyclerView {

    private static int q1 = 22;
    private int d1;
    private int e1 = -1;
    private int f1;
    private int g1;
    private int h1;
    private SparseIntArray i1;
    private com.github.ksoichiro.android.observablescrollview.a j1;
    private com.github.ksoichiro.android.observablescrollview.b k1;
    private boolean l1;
    private boolean m1;
    private boolean n1;
    private MotionEvent o1;
    private ViewGroup p1;

    class a implements Runnable {

        final ViewGroup a;
        final MotionEvent b;
        a(com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView observableRecyclerView, ViewGroup viewGroup2, MotionEvent motionEvent3) {
            this.a = viewGroup2;
            this.b = motionEvent3;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.dispatchTouchEvent(this.b);
        }
    }

    static class b implements Parcelable {

        public static final Parcelable.Creator<com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView.b> CREATOR;
        public static final com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView.b z;
        int a;
        int b;
        int c;
        int v;
        int w;
        SparseIntArray x;
        Parcelable y;
        static {
            ObservableRecyclerView.b.a aVar = new ObservableRecyclerView.b.a();
            ObservableRecyclerView.b.z = aVar;
            ObservableRecyclerView.b.b bVar = new ObservableRecyclerView.b.b();
            ObservableRecyclerView.b.CREATOR = bVar;
        }

        private b() {
            super();
            this.b = -1;
            this.y = 0;
        }

        private b(Parcel parcel) {
            Parcelable parcelable;
            int i;
            int int2;
            int int;
            SparseIntArray sparseIntArray;
            super();
            this.b = -1;
            if (parcel.readParcelable(RecyclerView.class.getClassLoader()) != null) {
            } else {
                parcelable = ObservableRecyclerView.b.z;
            }
            this.y = parcelable;
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            this.v = parcel.readInt();
            this.w = parcel.readInt();
            SparseIntArray sparseIntArray2 = new SparseIntArray();
            this.x = sparseIntArray2;
            int int8 = parcel.readInt();
            if (int8 > 0) {
                i = 0;
                while (i < int8) {
                    this.x.put(parcel.readInt(), parcel.readInt());
                    i++;
                }
            }
        }

        b(Parcel parcel, com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView.a observableRecyclerView$a2) {
            super(parcel);
        }

        b(Parcelable parcelable) {
            com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView.b obj2;
            super();
            this.b = -1;
            if (parcelable != ObservableRecyclerView.b.z) {
            } else {
                obj2 = 0;
            }
            this.y = obj2;
        }

        b(com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView.a observableRecyclerView$a) {
            super();
        }

        @Override // android.os.Parcelable
        public Parcelable a() {
            return this.y;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            int i;
            int valueAt;
            int obj4;
            parcel.writeParcelable(this.y, i2);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.v);
            parcel.writeInt(this.w);
            obj4 = this.x;
            if (obj4 == null) {
                obj4 = i;
            } else {
                obj4 = obj4.size();
            }
            parcel.writeInt(obj4);
            if (obj4 > 0) {
            }
        }
    }
    static {
    }

    public ObservableRecyclerView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        final int obj1 = -1;
        H1();
    }

    private void G1() {
        int i;
        super.g0(0);
    }

    private void H1() {
        SparseIntArray sparseIntArray = new SparseIntArray();
        this.i1 = sparseIntArray;
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
        com.github.ksoichiro.android.observablescrollview.a actionMasked;
        if (this.j1 != null) {
            if (motionEvent.getActionMasked() != 0) {
            } else {
                int i = 1;
                this.m1 = i;
                this.l1 = i;
                this.j1.b();
            }
        }
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
        super.onRestoreInstanceState((ObservableRecyclerView.b)parcelable.a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public Parcelable onSaveInstanceState() {
        ObservableRecyclerView.b bVar = new ObservableRecyclerView.b(super.onSaveInstanceState());
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
        int i6;
        int i5;
        int height3;
        int height;
        int height2;
        SparseIntArray indexOfKey;
        int i7;
        com.github.ksoichiro.android.observablescrollview.a obj6;
        int obj7;
        int obj8;
        int obj9;
        super.onScrollChanged(i, i2, i3, i4);
        if (this.j1 != null && getChildCount() > 0) {
            if (getChildCount() > 0) {
                obj6 = 0;
                obj7 = g0(getChildAt(obj6));
                obj9 = 1;
                height3 = obj6;
                i6 = obj7;
                while (i6 <= g0(getChildAt(obj8 -= obj9))) {
                    View childAt = getChildAt(height3);
                    if (childAt != null) {
                    } else {
                    }
                    height2 = obj6;
                    this.i1.put(i6, height2);
                    i6++;
                    height3++;
                    if (this.i1.indexOfKey(i6) >= 0) {
                    } else {
                    }
                    height2 = childAt.getHeight();
                    if (childAt.getHeight() != this.i1.get(i6)) {
                    } else {
                    }
                }
                obj8 = getChildAt(obj6);
                if (obj8 != null) {
                    i5 = this.d1;
                    if (i5 < obj7) {
                        if (obj7 - i5 != obj9) {
                            obj9 = obj7 + -1;
                            i5 = obj6;
                            while (obj9 > this.d1) {
                                if (this.i1.indexOfKey(obj9) > 0) {
                                } else {
                                }
                                height3 = obj8.getHeight();
                                i5 += height3;
                                obj9--;
                                height3 = this.i1.get(obj9);
                            }
                        } else {
                            i5 = obj6;
                        }
                        this.f1 = obj9 += height3;
                        this.e1 = obj8.getHeight();
                    } else {
                        if (obj7 < i5) {
                            if (i5 - obj7 != obj9) {
                                i5 -= obj9;
                                obj9 = obj6;
                                while (i5 > obj7) {
                                    if (this.i1.indexOfKey(i5) > 0) {
                                    } else {
                                    }
                                    height = obj8.getHeight();
                                    obj9 += height;
                                    i5--;
                                    height = this.i1.get(i5);
                                }
                            } else {
                                obj9 = obj6;
                            }
                            this.f1 = i9 -= height3;
                            this.e1 = obj8.getHeight();
                        } else {
                            if (obj7 == null) {
                                this.e1 = obj8.getHeight();
                                this.f1 = obj6;
                            }
                        }
                    }
                    if (this.e1 < 0) {
                        this.e1 = obj6;
                    }
                    obj9 -= obj8;
                    this.h1 = obj9;
                    this.d1 = obj7;
                    this.j1.c(obj9, this.l1, this.m1);
                    if (this.l1) {
                        this.l1 = obj6;
                    }
                    obj6 = this.g1;
                    obj7 = this.h1;
                    if (obj6 < obj7) {
                        this.k1 = b.UP;
                    } else {
                        if (obj7 < obj6) {
                            this.k1 = b.DOWN;
                        } else {
                            this.k1 = b.STOP;
                        }
                    }
                    this.g1 = obj7;
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.github.ksoichiro.android.observablescrollview.a actionMasked;
        int i;
        int i2;
        int cmp;
        Object parent;
        int i3;
        Object parent2;
        float f;
        int scrollY;
        if (this.j1 != null) {
            actionMasked = motionEvent.getActionMasked();
            i = 1;
            i2 = 0;
            if (actionMasked != i) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                    } else {
                        this.n1 = i2;
                        this.m1 = i2;
                        this.j1.a(this.k1);
                    }
                } else {
                    if (this.o1 == null) {
                        this.o1 = motionEvent;
                    }
                    this.o1 = MotionEvent.obtainNoHistory(motionEvent);
                    actionMasked = 0;
                    if (Float.compare(i5, actionMasked) <= 0 && this.n1) {
                        if (this.n1) {
                            return i2;
                        }
                        if (this.p1 == null) {
                            parent = getParent();
                        }
                        parent2 = this;
                        i3 = actionMasked;
                        while (parent2 != null) {
                            if (parent2 != parent) {
                            }
                            actionMasked += f5;
                            i3 += f;
                            parent2 = parent2.getParent();
                        }
                        MotionEvent noHistory2 = MotionEvent.obtainNoHistory(motionEvent);
                        noHistory2.offsetLocation(actionMasked, i3);
                        if (parent.onInterceptTouchEvent(noHistory2)) {
                            this.n1 = i;
                            noHistory2.setAction(i2);
                            ObservableRecyclerView.a obj9 = new ObservableRecyclerView.a(this, parent, noHistory2);
                            post(obj9);
                            return i2;
                        }
                        return super.onTouchEvent(motionEvent);
                    }
                }
            } else {
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setScrollViewCallbacks(com.github.ksoichiro.android.observablescrollview.a a) {
        this.j1 = a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setTouchInterceptionViewGroup(ViewGroup viewGroup) {
        this.p1 = viewGroup;
    }
}
