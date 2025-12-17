package d.b.a.a;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class b extends d.b.a.a.c {

    private final Object a;
    private final ExecutorService b;
    private volatile Handler c;

    class a implements ThreadFactory {

        private final AtomicInteger a;
        a(d.b.a.a.b b) {
            super();
            AtomicInteger obj2 = new AtomicInteger(0);
            this.a = obj2;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            Object[] obj4 = new Object[1];
            thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.a.getAndIncrement())));
            return thread;
        }
    }
    public b() {
        super();
        Object object = new Object();
        this.a = object;
        b.a aVar = new b.a(this);
        this.b = Executors.newFixedThreadPool(4, aVar);
    }

    private static Handler d(Looper looper) {
        int sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 28) {
            return Handler.createAsync(looper);
        }
        if (sDK_INT >= 16) {
            int i3 = 3;
            Class[] arr2 = new Class[i3];
            final int i5 = 0;
            arr2[i5] = Looper.class;
            final int i6 = 1;
            arr2[i6] = Handler.Callback.class;
            final int i7 = 2;
            arr2[i7] = Boolean.TYPE;
            Object[] arr = new Object[i3];
            arr[i5] = looper;
            arr[i6] = 0;
            arr[i7] = Boolean.TRUE;
            return (Handler)Handler.class.getDeclaredConstructor(arr2).newInstance(arr);
        }
        Handler handler2 = new Handler(looper);
        return handler2;
    }

    @Override // d.b.a.a.c
    public void a(Runnable runnable) {
        this.b.execute(runnable);
    }

    @Override // d.b.a.a.c
    public boolean b() {
        int i;
        i = Looper.getMainLooper().getThread() == Thread.currentThread() ? 1 : 0;
        return i;
    }

    @Override // d.b.a.a.c
    public void c(Runnable runnable) {
        Object handler2;
        Handler handler;
        handler2 = this.a;
        if (this.c == null && this.c == null) {
            handler2 = this.a;
            synchronized (handler2) {
                this.c = b.d(Looper.getMainLooper());
            }
        }
        this.c.post(runnable);
    }
}
