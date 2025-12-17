package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.ListView;
import androidx.appcompat.view.menu.p;

/* loaded from: classes.dex */
public abstract class d0 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    private final int[] A;
    private final float a;
    private final int b;
    private final int c;
    final View v;
    private Runnable w;
    private Runnable x;
    private boolean y;
    private int z;

    private class a implements Runnable {

        final androidx.appcompat.widget.d0 a;
        a(androidx.appcompat.widget.d0 d0) {
            this.a = d0;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            ViewParent parent = d0Var.v.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    private class b implements Runnable {

        final androidx.appcompat.widget.d0 a;
        b(androidx.appcompat.widget.d0 d0) {
            this.a = d0;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.e();
        }
    }
    public d0(View view) {
        super();
        final int i = 2;
        this.A = new int[i];
        this.v = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.a = (float)obj3;
        int obj3 = ViewConfiguration.getTapTimeout();
        this.b = obj3;
        this.c = obj3 /= i;
    }

    private void a() {
        View view;
        Runnable runnable = this.x;
        if (runnable != null) {
            this.v.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.w;
        if (runnable2 != null) {
            this.v.removeCallbacks(runnable2);
        }
    }

    private boolean f(MotionEvent motionEvent) {
        View view;
        p pVar;
        int i;
        boolean noHistory;
        MotionEvent obj5;
        pVar = b();
        if (pVar != null) {
            if (!pVar.b()) {
            } else {
                pVar = pVar.k();
                if ((b0)pVar != null) {
                    if (!(b0)pVar.isShown()) {
                    } else {
                        noHistory = MotionEvent.obtainNoHistory(motionEvent);
                        i(this.v, noHistory);
                        j(pVar, noHistory);
                        noHistory.recycle();
                        obj5 = motionEvent.getActionMasked();
                        pVar = 1;
                        if (obj5 != pVar && obj5 != 3) {
                            obj5 = obj5 != 3 ? pVar : i;
                        } else {
                        }
                        if (pVar.e(noHistory, this.z) && obj5 != null) {
                            if (obj5 != null) {
                                i = pVar;
                            }
                        }
                    }
                }
            }
        }
        return i;
    }

    private boolean g(MotionEvent motionEvent) {
        int actionMasked;
        long i;
        int i2;
        Runnable obj6;
        final View view = this.v;
        final int i5 = 0;
        if (!view.isEnabled()) {
            return i5;
        }
        actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            i = 1;
            if (actionMasked != i) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                    } else {
                        a();
                    }
                } else {
                    actionMasked = motionEvent.findPointerIndex(this.z);
                    if (actionMasked >= 0 && !d0.h(view, motionEvent.getX(actionMasked), motionEvent.getY(actionMasked), this.a)) {
                        if (!d0.h(view, motionEvent.getX(actionMasked), motionEvent.getY(actionMasked), this.a)) {
                            a();
                            view.getParent().requestDisallowInterceptTouchEvent(i);
                            return i;
                        }
                    }
                }
            } else {
            }
        } else {
            this.z = motionEvent.getPointerId(i5);
            if (this.w == null) {
                obj6 = new d0.a(this);
                this.w = obj6;
            }
            view.postDelayed(this.w, (long)i3);
            if (this.x == null) {
                obj6 = new d0.b(this);
                this.x = obj6;
            }
            view.postDelayed(this.x, (long)actionMasked);
        }
        return i5;
    }

    private static boolean h(View view, float f2, float f3, float f4) {
        int cmp;
        int left;
        int obj2;
        int obj3;
        cmp = -f4;
        if (Float.compare(f2, cmp) >= 0 && Float.compare(f3, cmp) >= 0 && Float.compare(f2, cmp) < 0 && Float.compare(f3, obj2) < 0) {
            if (Float.compare(f3, cmp) >= 0) {
                if (Float.compare(f2, cmp) < 0) {
                    obj2 = Float.compare(f3, obj2) < 0 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    private boolean i(View view, MotionEvent motionEvent2) {
        int[] iArr = this.A;
        view.getLocationOnScreen(iArr);
        final int i2 = 1;
        motionEvent2.offsetLocation((float)obj3, (float)i);
        return i2;
    }

    private boolean j(View view, MotionEvent motionEvent2) {
        int[] iArr = this.A;
        view.getLocationOnScreen(iArr);
        final int i3 = 1;
        motionEvent2.offsetLocation((float)obj3, (float)i2);
        return i3;
    }

    @Override // android.view.View$OnTouchListener
    public abstract p b();

    @Override // android.view.View$OnTouchListener
    protected abstract boolean c();

    @Override // android.view.View$OnTouchListener
    protected boolean d() {
        boolean z;
        p pVar = b();
        if (pVar != null && pVar.b()) {
            if (pVar.b()) {
                pVar.dismiss();
            }
        }
        return 1;
    }

    @Override // android.view.View$OnTouchListener
    void e() {
        boolean longClickable;
        int i3;
        long l;
        long uptimeMillis;
        int i2;
        int i;
        int i5;
        int i4;
        a();
        final View view = this.v;
        if (view.isEnabled()) {
            if (view.isLongClickable()) {
            } else {
                if (!c()) {
                }
                i3 = 1;
                view.getParent().requestDisallowInterceptTouchEvent(i3);
                uptimeMillis = SystemClock.uptimeMillis();
                longClickable = MotionEvent.obtain(uptimeMillis, obj4, uptimeMillis, obj6, 3, 0);
                view.onTouchEvent(longClickable);
                longClickable.recycle();
                this.y = i3;
            }
        }
    }

    @Override // android.view.View$OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent2) {
        int i3;
        MotionEvent obtain;
        long view2;
        long uptimeMillis;
        int i2;
        int i;
        int i5;
        int i4;
        boolean obj12;
        final boolean obj11 = this.y;
        i3 = 1;
        final int i6 = 0;
        if (obj11 != null) {
            if (!f(motionEvent2)) {
                if (!d()) {
                    obj12 = i3;
                } else {
                    obj12 = i6;
                }
            } else {
            }
        } else {
            if (g(motionEvent2) && c()) {
                obj12 = c() ? i3 : i6;
            } else {
            }
            if (obj12 != null) {
                uptimeMillis = SystemClock.uptimeMillis();
                obtain = MotionEvent.obtain(uptimeMillis, obj3, uptimeMillis, obj5, 3, 0);
                this.v.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.y = obj12;
        if (obj12 == null) {
            if (obj11 != null) {
            } else {
                i3 = i6;
            }
        }
        return i3;
    }

    @Override // android.view.View$OnTouchListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View$OnTouchListener
    public void onViewDetachedFromWindow(View view) {
        View view2;
        this.y = false;
        this.z = -1;
        Runnable obj2 = this.w;
        if (obj2 != null) {
            this.v.removeCallbacks(obj2);
        }
    }
}
