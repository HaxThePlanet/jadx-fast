package io.grpc;

import com.google.common.base.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: ManagedChannelRegistry.java */
/* loaded from: classes2.dex */
public final class ManagedChannelRegistry {

    private static final Logger c;
    private static ManagedChannelRegistry d;
    private final LinkedHashSet<ManagedChannelProvider> a = new LinkedHashSet<>();
    private List<ManagedChannelProvider> b;

    public static final class ProviderNotFoundException extends RuntimeException {

        private static final long serialVersionUID = 1L;
    }

    class a implements Comparator<ManagedChannelProvider> {
        a() {
            super();
        }

        public int a(ManagedChannelProvider managedChannelProvider, ManagedChannelProvider managedChannelProvider2) {
            return managedChannelProvider.c() - managedChannelProvider2.c();
        }
    }

    private static final class b implements c1.b<ManagedChannelProvider> {
        private b() {
            super();
        }

        public int c(ManagedChannelProvider managedChannelProvider) {
            return managedChannelProvider.c();
        }

        public boolean d(ManagedChannelProvider managedChannelProvider) {
            return managedChannelProvider.b();
        }

        /* synthetic */ b(ManagedChannelRegistry.a aVar) {
            this();
        }
    }
    static {
        ManagedChannelRegistry.c = Logger.getLogger(ManagedChannelRegistry.class.getName());
    }

    public ManagedChannelRegistry() {
        super();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.b = Collections.emptyList();
    }

    private synchronized void a(ManagedChannelProvider managedChannelProvider) {
        n.e(managedChannelProvider.b(), "isAvailable() returned false");
        this.a.add(managedChannelProvider);
    }

    public static synchronized ManagedChannelRegistry b() {
        java.lang.ClassLoader classLoader;
        io.grpc.ManagedChannelRegistry.b bVar;
        io.grpc.ManagedChannelRegistry.a aVar = null;
        obj = ManagedChannelProvider.class;
        final Class<io.grpc.ManagedChannelRegistry> obj3 = ManagedChannelRegistry.class;
        if (ManagedChannelRegistry.d == null) {
            aVar = null;
            ManagedChannelRegistry.d = new ManagedChannelRegistry();
            Iterator it = c1.e(obj, ManagedChannelRegistry.c(), obj.getClassLoader(), new ManagedChannelRegistry.b(aVar)).iterator();
            while (it.hasNext()) {
                io.grpc.ManagedChannelRegistry managedChannelRegistry2 = it.next();
                StringBuilder stringBuilder = new StringBuilder();
                Object str = "Service loader found ";
                obj5 = str + managedChannelRegistry2;
                ManagedChannelRegistry.c.fine(obj5);
            }
            ManagedChannelRegistry.d.f();
        }
        return ManagedChannelRegistry.d;
    }

    static List<Class<?>> c() {
        Logger obj2;
        Level obj4;
        String obj6;
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(Class.forName("io.grpc.k1.f"));
        } catch (java.lang.ClassNotFoundException classNotFound) {
            Logger logger = ManagedChannelRegistry.c;
            Level fINE2 = Level.FINE;
            String str3 = "Unable to find NettyChannelProvider";
            logger.log(fINE2, str3, classNotFound);
        }
        try {
            arrayList.add(Class.forName("io.grpc.netty.NettyChannelProvider"));
        } catch (java.lang.ClassNotFoundException classNotFound) {
            logger = ManagedChannelRegistry.c;
            fINE2 = Level.FINE;
            str3 = "Unable to find NettyChannelProvider";
            logger.log(fINE2, str3, classNotFound);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private synchronized void f() {
        ArrayList arrayList = new ArrayList(this.a);
        Collections.sort(arrayList, Collections.reverseOrder(new ManagedChannelRegistry.a(this)));
        this.b = Collections.unmodifiableList(arrayList);
    }

    ManagedChannelProvider d() {
        int i = 0;
        List list = e();
        if (list.isEmpty()) {
            i = 0;
        } else {
            Object item = list.get(0);
        }
        return i;
    }

    synchronized List<ManagedChannelProvider> e() {
        return this.b;
    }
}
