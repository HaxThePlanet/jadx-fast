package androidx.core.app;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.Window;
import android.view.Window.OnFrameMetricsAvailableListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class g {

    private androidx.core.app.g.b a;

    private static class b {
        public void a(Activity activity) {
        }

        public SparseIntArray[] b() {
            return null;
        }
    }

    private static class a extends androidx.core.app.g.b {

        private static HandlerThread e;
        private static Handler f;
        int a;
        SparseIntArray[] b;
        private ArrayList<WeakReference<Activity>> c;
        Window.OnFrameMetricsAvailableListener d;
        static {
        }

        a(int i) {
            super();
            this.b = new SparseIntArray[9];
            ArrayList arrayList = new ArrayList();
            this.c = arrayList;
            g.a.a aVar = new g.a.a(this);
            this.d = aVar;
            this.a = i;
        }

        @Override // androidx.core.app.g$b
        public void a(Activity activity) {
            Object handler;
            int i2;
            android.os.Looper looper;
            Object sparseIntArray;
            int i;
            if (g.a.e == null) {
                HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
                g.a.e = handlerThread;
                handlerThread.start();
                handler = new Handler(g.a.e.getLooper());
                g.a.f = handler;
            }
            i2 = 0;
            while (i2 <= 8) {
                looper = this.b;
                if (looper[i2] == null && i4 &= i != 0) {
                }
                i2++;
                if (i4 &= i != 0) {
                }
                sparseIntArray = new SparseIntArray();
                looper[i2] = sparseIntArray;
            }
            activity.getWindow().addOnFrameMetricsAvailableListener(this.d, g.a.f);
            WeakReference weakReference = new WeakReference(activity);
            this.c.add(weakReference);
        }

        @Override // androidx.core.app.g$b
        public SparseIntArray[] b() {
            this.b = new SparseIntArray[9];
            return this.b;
        }

        @Override // androidx.core.app.g$b
        void c(SparseIntArray sparseIntArray, long l2) {
            int i3;
            int i;
            int i2;
            int obj6;
            i3 = (int)i6;
            if (sparseIntArray != null && Long.compare(l2, i) >= 0) {
                i3 = (int)i6;
                if (Long.compare(l2, i) >= 0) {
                    sparseIntArray.put(i3, obj6++);
                }
            }
        }
    }
    public g() {
        super(1);
    }

    public g(int i) {
        androidx.core.app.g.a sDK_INT;
        int obj3;
        super();
        if (Build.VERSION.SDK_INT >= 24) {
            sDK_INT = new g.a(i);
            this.a = sDK_INT;
        } else {
            obj3 = new g.b();
            this.a = obj3;
        }
    }

    public void a(Activity activity) {
        this.a.a(activity);
    }

    public SparseIntArray[] b() {
        return this.a.b();
    }
}
