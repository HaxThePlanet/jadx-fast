package d.h.l;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public final class d {

    private final d.h.l.d.a a;

    interface a {
        public abstract boolean a(MotionEvent motionEvent);
    }

    static class b implements d.h.l.d.a {

        private static final int v;
        private static final int w;
        private int a;
        private int b;
        private int c;
        private int d;
        private final Handler e;
        final GestureDetector.OnGestureListener f;
        GestureDetector.OnDoubleTapListener g;
        boolean h;
        boolean i;
        private boolean j;
        private boolean k;
        private boolean l;
        MotionEvent m;
        private MotionEvent n;
        private boolean o;
        private float p;
        private float q;
        private float r;
        private float s;
        private boolean t;
        private VelocityTracker u;
        static {
            d.b.v = ViewConfiguration.getTapTimeout();
            d.b.w = ViewConfiguration.getDoubleTapTimeout();
        }

        b(Context context, GestureDetector.OnGestureListener gestureDetector$OnGestureListener2, Handler handler3) {
            d.h.l.d.b.a aVar;
            Handler obj4;
            super();
            if (handler3 != null) {
                aVar = new d.b.a(this, handler3);
                this.e = aVar;
            } else {
                obj4 = new d.b.a(this);
                this.e = obj4;
            }
            this.f = onGestureListener2;
            if (onGestureListener2 instanceof GestureDetector.OnDoubleTapListener != null) {
                g((GestureDetector.OnDoubleTapListener)onGestureListener2);
            }
            e(context);
        }

        private void b() {
            this.e.removeMessages(1);
            this.e.removeMessages(2);
            this.e.removeMessages(3);
            this.u.recycle();
            this.u = 0;
            int i2 = 0;
            this.o = i2;
            this.h = i2;
            this.k = i2;
            this.l = i2;
            this.i = i2;
            if (this.j) {
                this.j = i2;
            }
        }

        private void c() {
            this.e.removeMessages(1);
            this.e.removeMessages(2);
            this.e.removeMessages(3);
            int i = 0;
            this.o = i;
            this.k = i;
            this.l = i;
            this.i = i;
            if (this.j) {
                this.j = i;
            }
        }

        private void e(Context context) {
            if (context == null) {
            } else {
                if (this.f == null) {
                } else {
                    this.t = true;
                    ViewConfiguration obj4 = ViewConfiguration.get(context);
                    int scaledTouchSlop = obj4.getScaledTouchSlop();
                    int scaledDoubleTapSlop = obj4.getScaledDoubleTapSlop();
                    this.c = obj4.getScaledMinimumFlingVelocity();
                    this.d = obj4.getScaledMaximumFlingVelocity();
                    this.a = scaledTouchSlop *= scaledTouchSlop;
                    this.b = scaledDoubleTapSlop *= scaledDoubleTapSlop;
                }
                obj4 = new IllegalArgumentException("OnGestureListener must not be null");
                throw obj4;
            }
            obj4 = new IllegalArgumentException("Context must not be null");
            throw obj4;
        }

        private boolean f(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            int i;
            i = 0;
            if (!this.l) {
                return i;
            }
            if (Long.compare(i3, l) > 0) {
                return i;
            }
            obj8 -= i2;
            obj7 -= obj9;
            if (obj8 += obj7 < this.b) {
                i = 1;
            }
            return i;
        }

        @Override // d.h.l.d$a
        public boolean a(MotionEvent motionEvent) {
            Handler actionIndex2;
            VelocityTracker velocityTracker;
            Object num;
            boolean messages;
            VelocityTracker obtain;
            MotionEvent onDoubleTapEvent;
            float onSingleTapUp;
            boolean z;
            int xVelocity;
            boolean longPressTimeout;
            int i3;
            int i2;
            int i4;
            int actionIndex;
            GestureDetector.OnGestureListener cmp;
            float pointerCount;
            MotionEvent i8;
            int i;
            int i6;
            int i5;
            int i7;
            float f;
            boolean obj13;
            if (this.u == null) {
                this.u = VelocityTracker.obtain();
            }
            this.u.addMovement(motionEvent);
            action &= 255;
            onDoubleTapEvent = 6;
            xVelocity = 1;
            longPressTimeout = 0;
            i3 = actionIndex2 == onDoubleTapEvent ? xVelocity : longPressTimeout;
            if (i3 != 0) {
                actionIndex = motionEvent.getActionIndex();
            } else {
                actionIndex = -1;
            }
            pointerCount = motionEvent.getPointerCount();
            i8 = 0;
            i = longPressTimeout;
            i7 = i6;
            while (i < pointerCount) {
                if (actionIndex == i) {
                } else {
                }
                i6 += f13;
                i7 += f;
                i++;
            }
            i2 = i3 != 0 ? pointerCount + -1 : pointerCount;
            float f7 = (float)i2;
            i6 /= f7;
            i7 /= f7;
            i4 = 2;
            cmp = 3;
            if (actionIndex2 != 0) {
                i = 1000;
                if (actionIndex2 != xVelocity) {
                    if (actionIndex2 != i4) {
                        if (actionIndex2 != cmp) {
                            if (actionIndex2 != 5) {
                                if (actionIndex2 != onDoubleTapEvent) {
                                } else {
                                    this.p = i5;
                                    this.r = i5;
                                    this.q = i26;
                                    this.s = i26;
                                    this.u.computeCurrentVelocity(i, (float)i10);
                                    actionIndex2 = motionEvent.getActionIndex();
                                    int pointerId = motionEvent.getPointerId(actionIndex2);
                                    i4 = longPressTimeout;
                                    while (i4 < pointerCount) {
                                        if (i4 != actionIndex2) {
                                            break;
                                        } else {
                                        }
                                        int pointerId3 = motionEvent.getPointerId(i4);
                                        if (Float.compare(i, i8) < 0) {
                                            break;
                                        } else {
                                        }
                                        i4++;
                                    }
                                }
                            } else {
                                this.p = i5;
                                this.r = i5;
                                this.q = i26;
                                this.s = i26;
                                c();
                            }
                        } else {
                            b();
                        }
                    } else {
                        if (this.j) {
                        } else {
                            f2 -= i5;
                            f3 -= i26;
                            if (this.o) {
                                longPressTimeout |= obj13;
                            } else {
                                if (this.k) {
                                    int i18 = (int)i17;
                                    int i23 = (int)i22;
                                    i19 += i24;
                                    if (pointerCount > this.a) {
                                        obj13 = this.f.onScroll(this.m, motionEvent, actionIndex2, onDoubleTapEvent);
                                        this.p = i5;
                                        this.q = i26;
                                        this.k = longPressTimeout;
                                        this.e.removeMessages(cmp);
                                        this.e.removeMessages(xVelocity);
                                        this.e.removeMessages(i4);
                                    } else {
                                        obj13 = longPressTimeout;
                                    }
                                    if (pointerCount > this.a) {
                                        this.l = longPressTimeout;
                                    }
                                    longPressTimeout = obj13;
                                } else {
                                    i4 = 1065353216;
                                    if (Float.compare(f5, i4) < 0) {
                                        if (Float.compare(f6, i4) >= 0) {
                                            longPressTimeout = this.f.onScroll(this.m, motionEvent, actionIndex2, onDoubleTapEvent);
                                            this.p = i5;
                                            this.q = i26;
                                        }
                                    } else {
                                    }
                                }
                            }
                        }
                    }
                } else {
                    this.h = longPressTimeout;
                    if (this.o) {
                        obj13 |= longPressTimeout;
                    } else {
                        if (this.j) {
                            this.e.removeMessages(cmp);
                            this.j = longPressTimeout;
                            obj13 = longPressTimeout;
                        } else {
                            if (this.k) {
                                cmp = this.g;
                                if (this.i && cmp != null) {
                                    cmp = this.g;
                                    if (cmp != null) {
                                        cmp.onSingleTapConfirmed(motionEvent);
                                    }
                                }
                                obj13 = onSingleTapUp;
                            } else {
                                VelocityTracker velocityTracker4 = this.u;
                                int pointerId2 = motionEvent.getPointerId(longPressTimeout);
                                velocityTracker4.computeCurrentVelocity(i, (float)i16);
                                pointerCount = velocityTracker4.getYVelocity(pointerId2);
                                onSingleTapUp = velocityTracker4.getXVelocity(pointerId2);
                                if (Float.compare(f8, i8) <= 0) {
                                    if (Float.compare(f9, i8) > 0) {
                                        obj13 = this.f.onFling(this.m, motionEvent, onSingleTapUp, pointerCount);
                                    } else {
                                    }
                                } else {
                                }
                            }
                        }
                    }
                    onDoubleTapEvent = this.n;
                    if (onDoubleTapEvent != null) {
                        onDoubleTapEvent.recycle();
                    }
                    this.n = MotionEvent.obtain(motionEvent);
                    velocityTracker = this.u;
                    if (velocityTracker != null) {
                        velocityTracker.recycle();
                        this.u = 0;
                    }
                    this.o = longPressTimeout;
                    this.i = longPressTimeout;
                    this.e.removeMessages(xVelocity);
                    this.e.removeMessages(i4);
                }
            } else {
                if (this.g != null) {
                    messages = this.e.hasMessages(cmp);
                    if (messages) {
                        this.e.removeMessages(cmp);
                    }
                    MotionEvent motionEvent2 = this.m;
                    pointerCount = this.n;
                    if (motionEvent2 != null && pointerCount != null && messages && f(motionEvent2, pointerCount, motionEvent)) {
                        pointerCount = this.n;
                        if (pointerCount != null) {
                            if (messages) {
                                if (f(motionEvent2, pointerCount, motionEvent)) {
                                    this.o = xVelocity;
                                    i9 |= onDoubleTapEvent;
                                } else {
                                    this.e.sendEmptyMessageDelayed(cmp, (long)onDoubleTapEvent);
                                    actionIndex2 = longPressTimeout;
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
                this.p = i5;
                this.r = i5;
                this.q = i26;
                this.s = i26;
                MotionEvent motionEvent4 = this.m;
                if (motionEvent4 != null) {
                    motionEvent4.recycle();
                }
                this.m = MotionEvent.obtain(motionEvent);
                this.k = xVelocity;
                this.l = xVelocity;
                this.h = xVelocity;
                this.j = longPressTimeout;
                this.i = longPressTimeout;
                if (this.t) {
                    this.e.removeMessages(i4);
                    this.e.sendEmptyMessageAtTime(i4, i15 += i8);
                }
                this.e.sendEmptyMessageAtTime(xVelocity, downTime += cmp);
                longPressTimeout = actionIndex2 | obj13;
            }
            return longPressTimeout;
        }

        @Override // d.h.l.d$a
        void d() {
            this.e.removeMessages(3);
            this.i = false;
            this.j = true;
            this.f.onLongPress(this.m);
        }

        @Override // d.h.l.d$a
        public void g(GestureDetector.OnDoubleTapListener gestureDetector$OnDoubleTapListener) {
            this.g = onDoubleTapListener;
        }
    }

    static class c implements d.h.l.d.a {

        private final GestureDetector a;
        c(Context context, GestureDetector.OnGestureListener gestureDetector$OnGestureListener2, Handler handler3) {
            super();
            GestureDetector gestureDetector = new GestureDetector(context, onGestureListener2, handler3);
            this.a = gestureDetector;
        }

        @Override // d.h.l.d$a
        public boolean a(MotionEvent motionEvent) {
            return this.a.onTouchEvent(motionEvent);
        }
    }
    public d(Context context, GestureDetector.OnGestureListener gestureDetector$OnGestureListener2) {
        super(context, onGestureListener2, 0);
    }

    public d(Context context, GestureDetector.OnGestureListener gestureDetector$OnGestureListener2, Handler handler3) {
        Object cVar;
        super();
        if (Build.VERSION.SDK_INT > 17) {
            cVar = new d.c(context, onGestureListener2, handler3);
            this.a = cVar;
        } else {
            cVar = new d.b(context, onGestureListener2, handler3);
            this.a = cVar;
        }
    }

    public boolean a(MotionEvent motionEvent) {
        return this.a.a(motionEvent);
    }
}
