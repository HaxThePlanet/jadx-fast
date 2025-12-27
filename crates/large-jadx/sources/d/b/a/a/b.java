package d.b.a.a;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DefaultTaskExecutor.java */
/* loaded from: classes.dex */
public class b extends c {

    private final Object a = new Object();
    private final ExecutorService b;
    private volatile Handler c;

    class a implements ThreadFactory {

        private final AtomicInteger a = new AtomicInteger(0);
        a() {
            super();
            final AtomicInteger atomicInteger = new AtomicInteger(0);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            final Thread thread = new Thread(runnable);
            Object[] arr = new Object[1];
            thread.setName(String.format("arch_disk_io_%d", new Object[] { Integer.valueOf(this.a.getAndIncrement()) }));
            return thread;
        }
    }
    public b() {
        super();
        Object object = new Object();
        this.b = Executors.newFixedThreadPool(4, new b.a(this));
    }

    private static Handler d(Looper looper) {
        int sDK_INT2 = Build.VERSION.SDK_INT;
        if (Build.VERSION.SDK_INT >= 28) {
            return Handler.createAsync(looper);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            try {
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
            } catch (java.lang.reflect.InvocationTargetException unused) {
                return new Handler(looper);
            } catch (java.lang.IllegalAccessException | java.lang.InstantiationException | java.lang.NoSuchMethodException unused) {
                return new Handler(looper);
            }
            return (Handler)Handler.class.getDeclaredConstructor(arr2).newInstance(arr);
        }
    }

    @Override // d.b.a.a.c
    public void a(Runnable runnable) {
        this.b.execute(runnable);
    }

    @Override // d.b.a.a.c
    public boolean b() {
        boolean z = true;
        int r0 = Looper.getMainLooper().getThread() == Thread.currentThread() ? 1 : 0;
        return (Looper.getMainLooper().getThread() == Thread.currentThread() ? 1 : 0);
    }

    @Override // d.b.a.a.c
    public void c(Runnable runnable) {
        Handler handler2;
        if (this.c == null) {
            synchronized (obj2) {
                try {
                    if (this.c == null) {
                        this.c = b.d(Looper.getMainLooper());
                    }
                } catch (Throwable th) {
                }
            }
        }
        this.c.post(th);
    }
}
