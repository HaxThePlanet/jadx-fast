package kotlin.a0;

import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.n;
import kotlin.w;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001aJ\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c\u001a3\u0010\u000e\u001a\u0002H\u000f\"\u0008\u0008\u0000\u0010\u000f*\u00020\u0010*\u0008\u0012\u0004\u0012\u0002H\u000f0\u00112\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\u000f0\u000cH\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u0014", d2 = {"thread", "Ljava/lang/Thread;", "start", "", "isDaemon", "contextClassLoader", "Ljava/lang/ClassLoader;", "name", "", "priority", "", "block", "Lkotlin/Function0;", "", "getOrSet", "T", "", "Ljava/lang/ThreadLocal;", "default", "(Ljava/lang/ThreadLocal;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
public final class a {

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"kotlin/concurrent/ThreadsKt$thread$thread$1", "Ljava/lang/Thread;", "run", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class a extends Thread {

        final a a;
        a(a a) {
            this.a = a;
            super();
        }

        @Override // java.lang.Thread
        public void run() {
            this.a.invoke();
        }
    }
    public static final Thread a(boolean z, boolean z2, java.lang.ClassLoader classLoader3, String string4, int i5, a<w> a6) {
        int obj2;
        n.f(a6, "block");
        a.a aVar = new a.a(a6);
        if (z2 != 0) {
            aVar.setDaemon(true);
        }
        if (i5 > 0) {
            aVar.setPriority(i5);
        }
        if (string4 != null) {
            aVar.setName(string4);
        }
        if (classLoader3 != null) {
            aVar.setContextClassLoader(classLoader3);
        }
        if (z) {
            aVar.start();
        }
        return aVar;
    }

    public static Thread b(boolean z, boolean z2, java.lang.ClassLoader classLoader3, String string4, int i5, a a6, int i7, Object object8) {
        int i2;
        int i;
        int obj6;
        int obj7;
        int obj10;
        if (i7 & 1 != 0) {
            obj6 = 1;
        }
        if (i7 & 2 != 0) {
            obj7 = 0;
        }
        obj7 = 0;
        i2 = i7 & 4 != 0 ? obj7 : classLoader3;
        i = i7 & 8 != 0 ? obj7 : string4;
        if (i7 & 16 != 0) {
            obj10 = -1;
        }
        return a.a(obj6, obj7, i2, i, obj10, a6);
    }
}
