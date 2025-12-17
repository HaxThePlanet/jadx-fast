package androidx.databinding;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import androidx.databinding.l.a;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j;
import androidx.lifecycle.j.b;
import androidx.lifecycle.j.c;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes.dex */
public abstract class ViewDataBinding extends androidx.databinding.a {

    static int H = 0;
    private static final int I = 8;
    private static final boolean J = false;
    private static final androidx.databinding.ViewDataBinding.f K;
    private static final androidx.databinding.ViewDataBinding.f L;
    private static final ReferenceQueue<androidx.databinding.ViewDataBinding> M;
    private static final View.OnAttachStateChangeListener N = null;
    private final Choreographer.FrameCallback A;
    private Handler B;
    protected final androidx.databinding.e C;
    private androidx.databinding.ViewDataBinding D;
    private q E;
    private androidx.databinding.ViewDataBinding.OnStartListener F;
    private boolean G;
    private final Runnable a;
    private boolean b;
    private boolean c;
    private androidx.databinding.ViewDataBinding.j[] v;
    private final View w;
    private androidx.databinding.c<Object, androidx.databinding.ViewDataBinding, Void> x;
    private boolean y;
    private Choreographer z;

    static class c implements View.OnAttachStateChangeListener {
        @Override // android.view.View$OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            ViewDataBinding.d(ViewDataBinding.s(view)).run();
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View$OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    class d implements Runnable {

        final androidx.databinding.ViewDataBinding a;
        d(androidx.databinding.ViewDataBinding viewDataBinding) {
            this.a = viewDataBinding;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            int attachedToWindow;
            ViewDataBinding.e(this.a, false);
            ViewDataBinding.f();
            synchronized (this) {
                ViewDataBinding.e(this.a, false);
                ViewDataBinding.f();
            }
            try {
                if (!ViewDataBinding.g(this.a).isAttachedToWindow()) {
                }
                ViewDataBinding.g(this.a).removeOnAttachStateChangeListener(ViewDataBinding.h());
                ViewDataBinding.g(this.a).addOnAttachStateChangeListener(ViewDataBinding.h());
                this.a.p();
                throw th;
            }
        }
    }

    class e implements Choreographer.FrameCallback {

        final androidx.databinding.ViewDataBinding a;
        e(androidx.databinding.ViewDataBinding viewDataBinding) {
            this.a = viewDataBinding;
            super();
        }

        @Override // android.view.Choreographer$FrameCallback
        public void doFrame(long l) {
            ViewDataBinding.d(this.a).run();
        }
    }

    private interface f {
        public abstract androidx.databinding.ViewDataBinding.j a(androidx.databinding.ViewDataBinding viewDataBinding, int i2);
    }

    protected static class g {

        public final String[][] a;
        public final int[][] b;
        public final int[][] c;
        public g(int i) {
            super();
            this.a = new String[i];
            this.b = new int[i];
            this.c = new int[i];
        }

        public void a(int i, String[] string2Arr2, int[] i3Arr3, int[] i4Arr4) {
            this.a[i] = string2Arr2;
            this.b[i] = i3Arr3;
            this.c[i] = i4Arr4;
        }
    }

    private interface i {
        public abstract void a(q q);

        public abstract void b(T t);

        public abstract void c(T t);
    }

    private static class j extends WeakReference<androidx.databinding.ViewDataBinding> {

        private final androidx.databinding.ViewDataBinding.i<T> a;
        protected final int b;
        private T c;
        public j(androidx.databinding.ViewDataBinding viewDataBinding, int i2, androidx.databinding.ViewDataBinding.i<T> viewDataBinding$i3) {
            super(viewDataBinding, ViewDataBinding.i());
            this.b = i2;
            this.a = i3;
        }

        @Override // java.lang.ref.WeakReference
        protected androidx.databinding.ViewDataBinding a() {
            final Object obj = get();
            if ((ViewDataBinding)obj == null) {
                e();
            }
            return (ViewDataBinding)obj;
        }

        public T b() {
            return this.c;
        }

        @Override // java.lang.ref.WeakReference
        public void c(q q) {
            this.a.a(q);
        }

        public void d(T t) {
            androidx.databinding.ViewDataBinding.i view;
            e();
            this.c = t;
            if (t != null) {
                this.a.c(t);
            }
        }

        @Override // java.lang.ref.WeakReference
        public boolean e() {
            int i;
            androidx.databinding.ViewDataBinding.i view;
            Object obj = this.c;
            if (obj != null) {
                this.a.b(obj);
                i = 1;
            } else {
                i = 0;
            }
            this.c = 0;
            return i;
        }
    }

    static class OnStartListener implements p {

        final WeakReference<androidx.databinding.ViewDataBinding> a;
        private OnStartListener(androidx.databinding.ViewDataBinding viewDataBinding) {
            super();
            WeakReference weakReference = new WeakReference(viewDataBinding);
            this.a = weakReference;
        }

        OnStartListener(androidx.databinding.ViewDataBinding viewDataBinding, androidx.databinding.ViewDataBinding.a viewDataBinding$a2) {
            super(viewDataBinding);
        }

        @z(j$b.ON_START)
        public void onStart() {
            Object obj = this.a.get();
            if ((ViewDataBinding)obj != null) {
                (ViewDataBinding)obj.p();
            }
        }
    }

    static class a implements androidx.databinding.ViewDataBinding.f {
        @Override // androidx.databinding.ViewDataBinding$f
        public androidx.databinding.ViewDataBinding.j a(androidx.databinding.ViewDataBinding viewDataBinding, int i2) {
            ViewDataBinding.k kVar = new ViewDataBinding.k(viewDataBinding, i2);
            return kVar.f();
        }
    }

    static class b implements androidx.databinding.ViewDataBinding.f {
        @Override // androidx.databinding.ViewDataBinding$f
        public androidx.databinding.ViewDataBinding.j a(androidx.databinding.ViewDataBinding viewDataBinding, int i2) {
            ViewDataBinding.h hVar = new ViewDataBinding.h(viewDataBinding, i2);
            return hVar.e();
        }
    }

    private static class h implements y, androidx.databinding.ViewDataBinding.i<LiveData<?>> {

        final androidx.databinding.ViewDataBinding.j<LiveData<?>> a;
        q b;
        public h(androidx.databinding.ViewDataBinding viewDataBinding, int i2) {
            super();
            ViewDataBinding.j jVar = new ViewDataBinding.j(viewDataBinding, i2, this);
            this.a = jVar;
        }

        @Override // androidx.lifecycle.y
        public void a(q q) {
            q qVar;
            Object obj = this.a.b();
            if ((LiveData)obj != null && this.b != null) {
                if (this.b != null) {
                    (LiveData)obj.removeObserver(this);
                }
                if (q != null) {
                    obj.observe(q, this);
                }
            }
            this.b = q;
        }

        @Override // androidx.lifecycle.y
        public void b(Object object) {
            f((LiveData)object);
        }

        @Override // androidx.lifecycle.y
        public void c(Object object) {
            d((LiveData)object);
        }

        public void d(LiveData<?> liveData) {
            final q qVar = this.b;
            if (qVar != null) {
                liveData.observe(qVar, this);
            }
        }

        public androidx.databinding.ViewDataBinding.j<LiveData<?>> e() {
            return this.a;
        }

        public void f(LiveData<?> liveData) {
            liveData.removeObserver(this);
        }

        @Override // androidx.lifecycle.y
        public void onChanged(Object object) {
            Object obj;
            int i2;
            int i;
            androidx.databinding.ViewDataBinding obj4 = this.a.a();
            if (obj4 != null) {
                androidx.databinding.ViewDataBinding.j view = this.a;
                ViewDataBinding.j(obj4, view.b, view.b(), 0);
            }
        }
    }

    private static class k extends androidx.databinding.h.a implements androidx.databinding.ViewDataBinding.i<androidx.databinding.h> {

        final androidx.databinding.ViewDataBinding.j<androidx.databinding.h> a;
        public k(androidx.databinding.ViewDataBinding viewDataBinding, int i2) {
            super();
            ViewDataBinding.j jVar = new ViewDataBinding.j(viewDataBinding, i2, this);
            this.a = jVar;
        }

        @Override // androidx.databinding.h$a
        public void a(q q) {
        }

        @Override // androidx.databinding.h$a
        public void b(Object object) {
            g((h)object);
        }

        @Override // androidx.databinding.h$a
        public void c(Object object) {
            e((h)object);
        }

        @Override // androidx.databinding.h$a
        public void d(androidx.databinding.h h, int i2) {
            androidx.databinding.ViewDataBinding view2 = this.a.a();
            if (view2 == null) {
            }
            if ((h)this.a.b() != h) {
            }
            ViewDataBinding.j(view2, view4.b, h, i2);
        }

        @Override // androidx.databinding.h$a
        public void e(androidx.databinding.h h) {
            h.addOnPropertyChangedCallback(this);
        }

        public androidx.databinding.ViewDataBinding.j<androidx.databinding.h> f() {
            return this.a;
        }

        @Override // androidx.databinding.h$a
        public void g(androidx.databinding.h h) {
            h.removeOnPropertyChangedCallback(this);
        }
    }
    static {
        int cVar;
        int sDK_INT = Build.VERSION.SDK_INT;
        ViewDataBinding.H = sDK_INT;
        if (sDK_INT >= 16) {
            int i2 = 1;
        }
        int i3 = 0;
        ViewDataBinding.a aVar = new ViewDataBinding.a();
        ViewDataBinding.K = aVar;
        ViewDataBinding.b bVar = new ViewDataBinding.b();
        ViewDataBinding.L = bVar;
        ReferenceQueue referenceQueue = new ReferenceQueue();
        ViewDataBinding.M = referenceQueue;
        if (sDK_INT < 19) {
            cVar = 0;
        } else {
            cVar = new ViewDataBinding.c();
            ViewDataBinding.N = cVar;
        }
    }

    protected ViewDataBinding(androidx.databinding.e e, View view2, int i3) {
        Object obj2;
        Object obj3;
        super();
        ViewDataBinding.d dVar = new ViewDataBinding.d(this);
        this.a = dVar;
        int i = 0;
        this.b = i;
        this.c = i;
        this.C = e;
        this.v = new ViewDataBinding.j[i3];
        this.w = view2;
        if (Looper.myLooper() == null) {
        } else {
            if (ViewDataBinding.J) {
                this.z = Choreographer.getInstance();
                obj2 = new ViewDataBinding.e(this);
                this.A = obj2;
            } else {
                this.A = 0;
                obj2 = new Handler(Looper.myLooper());
                this.B = obj2;
            }
        }
        obj2 = new IllegalStateException("DataBinding must be created in view's UI Thread");
        throw obj2;
    }

    protected ViewDataBinding(Object object, View view2, int i3) {
        super(ViewDataBinding.l(object), view2, i3);
    }

    private static boolean B(String string, int i2) {
        boolean digit;
        int obj4;
        final int length = string.length();
        final int i = 0;
        if (length == i2) {
            return i;
        }
        while (obj4 < length) {
            obj4++;
        }
        return 1;
    }

    private static void C(androidx.databinding.e e, View view2, Object[] object3Arr3, androidx.databinding.ViewDataBinding.g viewDataBinding$g4, SparseIntArray sparseIntArray5, boolean z6) {
        Object obj2;
        int i3;
        Object tag2;
        boolean z;
        int childAt;
        int tag;
        int lastIndexOf;
        boolean startsWith2;
        boolean startsWith;
        int i4;
        int i5;
        int i8;
        int i7;
        int i;
        int i6;
        Object obj;
        int childCount;
        View[] arr;
        int i2;
        final androidx.databinding.e eVar = e;
        obj2 = view2;
        final androidx.databinding.ViewDataBinding.g view3 = g4;
        final SparseIntArray sparseIntArray = sparseIntArray5;
        if (ViewDataBinding.s(view2) != null) {
        }
        if (tag2 instanceof String != null) {
        } else {
            tag2 = 0;
        }
        final String str3 = "layout";
        childAt = -1;
        i7 = 1;
        if (z6 && tag2 != null && tag2.startsWith(str3)) {
            if (tag2 != null) {
                if (tag2.startsWith(str3)) {
                    lastIndexOf = tag2.lastIndexOf(95);
                    lastIndexOf += i7;
                    if (lastIndexOf > 0 && ViewDataBinding.B(tag2, lastIndexOf)) {
                        lastIndexOf += i7;
                        if (ViewDataBinding.B(tag2, lastIndexOf)) {
                            tag2 = ViewDataBinding.F(tag2, lastIndexOf);
                            if (object3Arr3[tag2] == null) {
                                object3Arr3[tag2] = obj2;
                            }
                            if (view3 == null) {
                                tag2 = childAt;
                            }
                            tag = i7;
                        } else {
                            tag2 = childAt;
                            tag = 0;
                        }
                    } else {
                    }
                    i6 = tag2;
                } else {
                    if (tag2 != null && tag2.startsWith("binding_")) {
                        if (tag2.startsWith("binding_")) {
                            tag2 = ViewDataBinding.F(tag2, ViewDataBinding.I);
                            if (object3Arr3[tag2] == null) {
                                object3Arr3[tag2] = obj2;
                            }
                            if (view3 == null) {
                                tag2 = childAt;
                            }
                            i6 = tag2;
                            tag = i7;
                        } else {
                            i6 = childAt;
                            tag = 0;
                        }
                    } else {
                    }
                }
            } else {
            }
        } else {
        }
        tag2 = view2.getId();
        tag2 = sparseIntArray.get(tag2, childAt);
        if (tag == 0 && tag2 > 0 && sparseIntArray != null && tag2 >= 0 && object3Arr3[tag2] == null) {
            tag2 = view2.getId();
            if (tag2 > 0) {
                if (sparseIntArray != null) {
                    tag2 = sparseIntArray.get(tag2, childAt);
                    if (tag2 >= 0) {
                        if (object3Arr3[tag2] == null) {
                            object3Arr3[tag2] = obj2;
                        }
                    }
                }
            }
        }
        if (obj2 instanceof ViewGroup) {
            obj = obj2;
            obj2 = 0;
            z = 0;
            while (obj2 < (ViewGroup)obj.getChildCount()) {
                childAt = obj.getChildAt(obj2);
                tag = childAt.getTag();
                tag = ViewDataBinding.q(tag, z, view3, i6);
                if (i6 >= 0 && tag3 instanceof String != null && (String)tag.endsWith("_0") && tag.startsWith(str3) && tag.indexOf(47) > 0 && tag >= 0) {
                } else {
                }
                i5 = obj2;
                i = z;
                i3 = 0;
                if (i3 == 0) {
                }
                i7 = i9;
                obj2 = i11;
                z = i2;
                ViewDataBinding.C(e, childAt, object3Arr3, g4, sparseIntArray5, false);
                if (tag3 instanceof String != null) {
                } else {
                }
                tag = childAt.getTag();
                if ((String)tag.endsWith("_0")) {
                } else {
                }
                if (tag.startsWith(str3)) {
                } else {
                }
                if (tag.indexOf(47) > 0) {
                } else {
                }
                tag = ViewDataBinding.q(tag, z, view3, i6);
                if (tag >= 0) {
                } else {
                }
                z = tag + 1;
                startsWith = view3.b[i6][tag];
                int i12 = view3.c[i6][tag];
                i4 = ViewDataBinding.r(obj, obj2);
                if (i4 == obj2) {
                } else {
                }
                i16 += i7;
                arr = new View[i17];
                i8 = 0;
                while (i8 < i17) {
                    arr[i8] = obj.getChildAt(obj2 + i8);
                    i8++;
                    i7 = 1;
                }
                object3Arr3[startsWith] = f.b(eVar, arr, i12);
                i5 = i10;
                i = z;
                i3 = 1;
                arr[i8] = obj.getChildAt(obj2 + i8);
                i8++;
                i7 = 1;
                object3Arr3[startsWith] = f.a(eVar, childAt, i12);
                i5 = obj2;
                i3 = i7;
                i = z;
            }
        }
    }

    protected static Object[] D(androidx.databinding.e e, View view2, int i3, androidx.databinding.ViewDataBinding.g viewDataBinding$g4, SparseIntArray sparseIntArray5) {
        final Object[] obj8 = new Object[i3];
        ViewDataBinding.C(e, view2, obj8, g4, sparseIntArray5, true);
        return obj8;
    }

    private static int F(String string, int i2) {
        int i3;
        int i;
        int obj4;
        i3 = 0;
        while (obj4 < string.length()) {
            i4 += i;
            obj4++;
        }
        return i3;
    }

    private static void G() {
        boolean z;
        java.lang.ref.Reference poll = ViewDataBinding.M.poll();
        while (poll != null) {
            if (poll instanceof ViewDataBinding.j) {
            }
            poll = ViewDataBinding.M.poll();
            (ViewDataBinding.j)poll.e();
        }
    }

    protected static int J(Integer integer) {
        int obj0;
        if (integer == null) {
            obj0 = 0;
        } else {
            obj0 = integer.intValue();
        }
        return obj0;
    }

    protected static boolean K(Boolean boolean) {
        int obj0;
        if (boolean == null) {
            obj0 = 0;
        } else {
            obj0 = boolean.booleanValue();
        }
        return obj0;
    }

    private boolean S(int i, Object object2, androidx.databinding.ViewDataBinding.f viewDataBinding$f3) {
        if (object2 == null) {
            return P(i);
        }
        androidx.databinding.ViewDataBinding.j view = this.v[i];
        final int i2 = 1;
        if (view == null) {
            H(i, object2, f3);
            return i2;
        }
        if (view.b() == object2) {
            return 0;
        }
        P(i);
        H(i, object2, f3);
        return i2;
    }

    static Runnable d(androidx.databinding.ViewDataBinding viewDataBinding) {
        return viewDataBinding.a;
    }

    static boolean e(androidx.databinding.ViewDataBinding viewDataBinding, boolean z2) {
        viewDataBinding.b = z2;
        return z2;
    }

    static void f() {
        ViewDataBinding.G();
    }

    static View g(androidx.databinding.ViewDataBinding viewDataBinding) {
        return viewDataBinding.w;
    }

    static View.OnAttachStateChangeListener h() {
        return ViewDataBinding.N;
    }

    static ReferenceQueue i() {
        return ViewDataBinding.M;
    }

    static void j(androidx.databinding.ViewDataBinding viewDataBinding, int i2, Object object3, int i4) {
        viewDataBinding.x(i2, object3, i4);
    }

    protected static androidx.databinding.ViewDataBinding k(Object object, View view2, int i3) {
        return f.a(ViewDataBinding.l(object), view2, i3);
    }

    private static androidx.databinding.e l(Object object) {
        if (object == null) {
            return null;
        }
        if (!object instanceof e) {
        } else {
            return (e)object;
        }
        IllegalArgumentException obj1 = new IllegalArgumentException("The provided bindingComponent parameter must be an instance of DataBindingComponent. See  https://issuetracker.google.com/issues/116541301 for details of why this parameter is not defined as DataBindingComponent");
        throw obj1;
    }

    private void n() {
        int i;
        boolean z;
        androidx.databinding.c cVar;
        if (this.y) {
            I();
        }
        if (!y()) {
        }
        i = 1;
        this.y = i;
        final int i2 = 0;
        this.c = i2;
        cVar = this.x;
        final int i3 = 0;
        cVar.d(this, i, i3);
        if (cVar != null && this.c) {
            cVar.d(this, i, i3);
            if (this.c) {
                this.x.d(this, 2, i3);
            }
        }
        m();
        z = this.x;
        if (!this.c && z != null) {
            m();
            z = this.x;
            if (z != null) {
                z.d(this, 3, i3);
            }
        }
        this.y = i2;
    }

    protected static void o(androidx.databinding.ViewDataBinding viewDataBinding) {
        viewDataBinding.n();
    }

    private static int q(String string, int i2, androidx.databinding.ViewDataBinding.g viewDataBinding$g3, int i4) {
        int equals;
        int obj3;
        String[] obj4 = g3.a[i4];
        while (obj3 < obj4.length) {
            obj3++;
        }
        return -1;
    }

    private static int r(ViewGroup viewGroup, int i2) {
        int i;
        Object tag;
        boolean startsWith;
        int length;
        int obj9;
        Object tag2 = viewGroup.getChildAt(i2).getTag();
        String substring = tag2.substring(0, length2--);
        i = i2 + 1;
        while (i < viewGroup.getChildCount()) {
            View childAt2 = viewGroup.getChildAt(i);
            if (tag3 instanceof String != null) {
            } else {
            }
            tag = 0;
            i++;
            if (ViewDataBinding.B(tag, substring.length())) {
            }
            obj9 = i;
            tag = childAt2.getTag();
        }
        return obj9;
    }

    static androidx.databinding.ViewDataBinding s(View view) {
        if (view != null) {
            return (ViewDataBinding)view.getTag(a.a);
        }
        return null;
    }

    public static int t() {
        return ViewDataBinding.H;
    }

    protected static int u(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return view.getContext().getColor(i2);
        }
        return view.getResources().getColor(i2);
    }

    protected static <T> T v(List<T> list, int i2) {
        int size;
        if (list != null && i2 >= 0 && i2 >= list.size()) {
            if (i2 >= 0) {
                if (i2 >= list.size()) {
                }
                return list.get(i2);
            }
        }
        return 0;
    }

    private void x(int i, Object object2, int i3) {
        if (this.G) {
        }
        if (E(i, object2, i3)) {
            I();
        }
    }

    protected static <T extends androidx.databinding.ViewDataBinding> T z(LayoutInflater layoutInflater, int i2, ViewGroup viewGroup3, boolean z4, Object object5) {
        return f.f(layoutInflater, i2, viewGroup3, z4, ViewDataBinding.l(object5));
    }

    @Override // androidx.databinding.a
    public abstract void A();

    @Override // androidx.databinding.a
    protected abstract boolean E(int i, Object object2, int i3);

    @Override // androidx.databinding.a
    protected void H(int i, Object object2, androidx.databinding.ViewDataBinding.f viewDataBinding$f3) {
        androidx.databinding.ViewDataBinding.j view;
        int obj2;
        androidx.databinding.ViewDataBinding.j[] obj4;
        if (object2 == null) {
        }
        view = f3.a(this, i);
        this.v[i] = view;
        obj2 = this.E;
        if (this.v[i] == null && obj2 != null) {
            view = f3.a(this, i);
            this.v[i] = view;
            obj2 = this.E;
            if (obj2 != null) {
                view.c(obj2);
            }
        }
        view.d(object2);
    }

    @Override // androidx.databinding.a
    protected void I() {
        Object view;
        q atLeast;
        Object sTARTED;
        view = this.D;
        if (view != null) {
            view.I();
        } else {
            atLeast = this.E;
            if (atLeast != null && !atLeast.getLifecycle().b().isAtLeast(j.c.STARTED)) {
                if (!atLeast.getLifecycle().b().isAtLeast(j.c.STARTED)) {
                }
            }
            synchronized (this) {
            }
            this.z.postFrameCallback(this.A);
        }
    }

    @Override // androidx.databinding.a
    protected void L(androidx.databinding.ViewDataBinding viewDataBinding) {
        if (viewDataBinding != null) {
            viewDataBinding.D = this;
        }
    }

    @Override // androidx.databinding.a
    public void M(q q) {
        Object lifecycle;
        androidx.databinding.ViewDataBinding.OnStartListener onStartListener;
        androidx.databinding.ViewDataBinding.OnStartListener list;
        int i;
        androidx.databinding.ViewDataBinding.j view;
        lifecycle = this.E;
        if (lifecycle == q) {
        }
        if (lifecycle != null) {
            lifecycle.getLifecycle().c(this.F);
        }
        this.E = q;
        if (q != null && this.F == null) {
            if (this.F == null) {
                onStartListener = new ViewDataBinding.OnStartListener(this, 0);
                this.F = onStartListener;
            }
            q.getLifecycle().a(this.F);
        }
        androidx.databinding.ViewDataBinding.j[] objArr = this.v;
        i = 0;
        while (i < objArr.length) {
            view = objArr[i];
            if (view != null) {
            }
            i++;
            view.c(q);
        }
    }

    @Override // androidx.databinding.a
    protected void N(View view) {
        view.setTag(a.a, this);
    }

    @Override // androidx.databinding.a
    public abstract boolean O(int i, Object object2);

    @Override // androidx.databinding.a
    protected boolean P(int i) {
        androidx.databinding.ViewDataBinding.j obj2 = this.v[i];
        if (obj2 != null) {
            return obj2.e();
        }
        return 0;
    }

    protected boolean Q(int i, LiveData<?> liveData2) {
        this.G = true;
        this.G = false;
        return S(i, liveData2, ViewDataBinding.L);
    }

    @Override // androidx.databinding.a
    protected boolean R(int i, androidx.databinding.h h2) {
        return S(i, h2, ViewDataBinding.K);
    }

    @Override // androidx.databinding.a
    protected abstract void m();

    @Override // androidx.databinding.a
    public void p() {
        final androidx.databinding.ViewDataBinding view = this.D;
        if (view == null) {
            n();
        } else {
            view.p();
        }
    }

    @Override // androidx.databinding.a
    public View w() {
        return this.w;
    }

    @Override // androidx.databinding.a
    public abstract boolean y();
}
