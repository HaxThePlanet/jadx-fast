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

/* compiled from: GestureDetectorCompat.java */
/* loaded from: classes.dex */
public final class d {

    private final d.a a;

    interface a {
        boolean a(MotionEvent motionEvent);
    }

    static class b implements d.a {

        private static final int v = 0;
        private static final int w = 0;
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

        b(Context context, GestureDetector.OnGestureListener list, Handler handler) {
            super();
            if (handler != null) {
                this.e = new d.b.a(this, handler);
            } else {
                this.e = new d.b.a(this);
            }
            this.f = list;
            if (list instanceof GestureDetector.OnDoubleTapListener) {
                g(list);
            }
            e(context);
        }

        private void b() {
            this.e.removeMessages(1);
            this.e.removeMessages(2);
            this.e.removeMessages(3);
            this.u.recycle();
            this.u = null;
            boolean z = false;
            this.o = z;
            this.h = z;
            this.k = z;
            this.l = z;
            this.i = z;
            if (this.j) {
                this.j = z;
            }
        }

        private void c() {
            this.e.removeMessages(1);
            this.e.removeMessages(2);
            this.e.removeMessages(3);
            boolean z = false;
            this.o = z;
            this.k = z;
            this.l = z;
            this.i = z;
            if (this.j) {
                this.j = z;
            }
        }

        private void e(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            } else {
                if (this.f == null) {
                    throw new IllegalArgumentException("OnGestureListener must not be null");
                } else {
                    this.t = true;
                    ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                    int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                    int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                    this.c = viewConfiguration.getScaledMinimumFlingVelocity();
                    this.d = viewConfiguration.getScaledMaximumFlingVelocity();
                    this.a = scaledTouchSlop * scaledTouchSlop;
                    this.b = scaledDoubleTapSlop * scaledDoubleTapSlop;
                    return;
                }
            }
        }

        private boolean f(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            boolean z = false;
            z = false;
            if (!this.l) {
                return false;
            }
            long l = motionEvent3.getEventTime() - motionEvent2.getEventTime();
            long l2 = (long)d.b.w;
            if (l > l2) {
                return false;
            }
            int i9 = (int)motionEvent.getX() - (int)motionEvent3.getX();
            int i4 = (int)motionEvent.getY() - (int)motionEvent3.getY();
            if ((i9 * i9) + (i4 * i4) < this.b) {
                int i2 = 1;
            }
            return z;
        }

        public boolean a(MotionEvent motionEvent) {
            Handler handler;
            int longPressTimeout;
            MotionEvent motionEvent2;
            float xVelocity;
            int i = 6;
            boolean motionEvent3 = false;
            int pointerCount;
            int actionIndex = -1;
            GestureDetector.OnGestureListener onGestureListener;
            boolean z2;
            int cmp = 3;
            float yVelocity;
            MotionEvent motionEvent4;
            float f2 = 0;
            int i2;
            int i3;
            float f3;
            float f4;
            if (this.u == null) {
                this.u = VelocityTracker.obtain();
            }
            this.u.addMovement(motionEvent);
            int i4 = motionEvent.getAction() & 255;
            i = 6;
            longPressTimeout = 1;
            longPressTimeout = 0;
            int r4 = longPressTimeout;
            if (longPressTimeout != 0) {
                actionIndex = motionEvent.getActionIndex();
            } else {
                actionIndex = -1;
            }
            pointerCount = motionEvent.getPointerCount();
            f2 = 0.0f;
            while (longPressTimeout < pointerCount) {
                longPressTimeout = longPressTimeout + 1;
            }
            r4 = longPressTimeout != 0 ? pointerCount - 1 : pointerCount;
            r4 = (float)(longPressTimeout != 0 ? pointerCount - 1 : pointerCount);
            f3 = i3 / (longPressTimeout != 0 ? pointerCount - 1 : pointerCount);
            i3 /= r4;
            longPressTimeout = 2;
            cmp = 3;
            if (i4 == 0) {
                if (this.g != null) {
                    boolean messages = this.e.hasMessages(cmp);
                    if (messages) {
                        this.e.removeMessages(cmp);
                    }
                    if (this.m == null || this.n == null || !messages || !this.f(this.m, this.n, motionEvent)) {
                        this.e.sendEmptyMessageDelayed(cmp, (long)d.b.w);
                    } else {
                        this.o = true;
                        longPressTimeout = (this.g.onDoubleTap(this.m) | longPressTimeout) | this.g.onDoubleTapEvent(motionEvent);
                    }
                }
                this.p = f3;
                this.r = f3;
                this.q = f21;
                this.s = f21;
                if (this.m != null) {
                    this.m.recycle();
                }
                this.m = MotionEvent.obtain(motionEvent);
                this.k = true;
                this.l = true;
                this.h = true;
                this.j = false;
                this.i = false;
                if (this.t) {
                    this.e.removeMessages(longPressTimeout);
                    this.e.sendEmptyMessageAtTime(longPressTimeout, (this.m.getDownTime() + (long)d.b.v) + (long)ViewConfiguration.getLongPressTimeout());
                }
                this.e.sendEmptyMessageAtTime(longPressTimeout, this.m.getDownTime() + (long)d.b.v);
                int i9 = longPressTimeout | this.f.onDown(motionEvent);
            } else {
                longPressTimeout = 1000;
                if (this.g == longPressTimeout) {
                    this.h = false;
                    if (this.o) {
                        int i20 = this.g.onDoubleTapEvent(motionEvent) | longPressTimeout;
                    } else {
                        if (this.j) {
                            this.e.removeMessages(cmp);
                            this.j = false;
                        } else {
                            if (this.k) {
                                if (this.i && this.g != null) {
                                    this.g.onSingleTapConfirmed(motionEvent);
                                }
                            } else {
                                int pointerId2 = motionEvent.getPointerId(longPressTimeout);
                                this.u.computeCurrentVelocity(longPressTimeout, (float)this.d);
                                yVelocity = this.u.getYVelocity(pointerId2);
                                xVelocity = this.u.getXVelocity(pointerId2);
                                float abs3 = Math.abs(yVelocity);
                                f2 = (float)this.c;
                                if (abs3 <= this.c) {
                                    float abs4 = Math.abs(xVelocity);
                                    f2 = (float)this.c;
                                    if (abs4 > this.c) {
                                        motionEvent3 = this.f.onFling(this.m, motionEvent, xVelocity, yVelocity);
                                    }
                                }
                            }
                        }
                    }
                    if (this.n != null) {
                        this.n.recycle();
                    }
                    this.n = MotionEvent.obtain(motionEvent);
                    if (this.u != null) {
                        this.u.recycle();
                        VelocityTracker velocityTracker = null;
                        this.u = velocityTracker;
                    }
                    this.o = false;
                    this.i = false;
                    this.e.removeMessages(longPressTimeout);
                    this.e.removeMessages(longPressTimeout);
                } else {
                    if (this.e != longPressTimeout) {
                        if (this.e == cmp) {
                            b();
                        } else {
                            longPressTimeout = 5;
                            if (this.e == 5) {
                                this.p = f3;
                                this.r = f3;
                                this.q = f21;
                                this.s = f21;
                                c();
                            } else {
                                if (this.e == i) {
                                    this.p = f3;
                                    this.r = f3;
                                    this.q = f21;
                                    this.s = f21;
                                    this.u.computeCurrentVelocity(longPressTimeout, (float)this.d);
                                    int actionIndex2 = motionEvent.getActionIndex();
                                    int pointerId = motionEvent.getPointerId(actionIndex2);
                                    while (this.u < this.n) {
                                        if (this.u != this.e) {
                                            int pointerId3 = motionEvent.getPointerId(longPressTimeout);
                                            float f18 = (this.u.getXVelocity(pointerId3) * this.u.getXVelocity(pointerId)) + (this.u.getYVelocity(pointerId3) * this.u.getYVelocity(pointerId));
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        if (!(this.j)) {
                            float f = this.p - f3;
                            float f7 = this.q - f21;
                            if (this.o) {
                                longPressTimeout |= motionEvent3;
                            } else {
                                if (this.k) {
                                    int i13 = (int)(f3 - this.r);
                                    int i18 = (int)(f21 - this.s);
                                    int i15 = (i13 * i13) + (i18 * i18);
                                    if (this.r > this.a) {
                                        boolean onScroll = this.f.onScroll(this.m, motionEvent, f, f7);
                                        this.p = f3;
                                        this.q = f21;
                                        this.k = false;
                                        this.e.removeMessages(cmp);
                                        this.e.removeMessages(longPressTimeout);
                                        this.e.removeMessages(longPressTimeout);
                                    } else {
                                    }
                                    if (this.r > this.a) {
                                        this.l = false;
                                    }
                                } else {
                                    float abs = Math.abs(f);
                                    float f10 = 1f;
                                    if (abs < f10) {
                                        float abs2 = Math.abs(f7);
                                        if (abs2 >= f10) {
                                            motionEvent3 = this.f.onScroll(this.m, motionEvent, f, f7);
                                            this.p = f3;
                                            this.q = f21;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return motionEvent3;
        }

        void d() {
            this.e.removeMessages(3);
            this.i = false;
            this.j = true;
            this.f.onLongPress(this.m);
        }

        public void g(GestureDetector.OnDoubleTapListener list) {
            this.g = list;
        }
    }

    static class c implements d.a {

        private final GestureDetector a = new GestureDetector();
        c(Context context, GestureDetector.OnGestureListener list, Handler handler) {
            super();
            final GestureDetector gestureDetector = new GestureDetector(context, list, handler);
        }

        public boolean a(MotionEvent motionEvent) {
            return this.a.onTouchEvent(motionEvent);
        }
    }
    public d(Context context, GestureDetector.OnGestureListener list) {
        this(context, list, null);
    }

    public boolean a(MotionEvent motionEvent) {
        return this.a.a(motionEvent);
    }

    public d(Context context, GestureDetector.OnGestureListener list, Handler handler) {
        super();
        if (Build.VERSION.SDK_INT > 17) {
            this.a = new d.c(context, list, handler);
        } else {
            this.a = new d.b(context, list, handler);
        }
    }
}
