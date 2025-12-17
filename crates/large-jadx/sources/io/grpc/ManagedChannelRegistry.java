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

/* loaded from: classes2.dex */
public final class ManagedChannelRegistry {

    private static final Logger c;
    private static io.grpc.ManagedChannelRegistry d;
    private final LinkedHashSet<io.grpc.ManagedChannelProvider> a;
    private List<io.grpc.ManagedChannelProvider> b;

    public static final class ProviderNotFoundException extends RuntimeException {

        private static final long serialVersionUID = 1L;
    }

    class a implements Comparator<io.grpc.ManagedChannelProvider> {
        a(io.grpc.ManagedChannelRegistry managedChannelRegistry) {
            super();
        }

        @Override // java.util.Comparator
        public int a(io.grpc.ManagedChannelProvider managedChannelProvider, io.grpc.ManagedChannelProvider managedChannelProvider2) {
            return obj1 -= obj2;
        }

        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return a((ManagedChannelProvider)object, (ManagedChannelProvider)object2);
        }
    }

    private static final class b implements io.grpc.c1.b<io.grpc.ManagedChannelProvider> {
        b(io.grpc.ManagedChannelRegistry.a managedChannelRegistry$a) {
            super();
        }

        @Override // io.grpc.c1$b
        public boolean a(Object object) {
            return d((ManagedChannelProvider)object);
        }

        @Override // io.grpc.c1$b
        public int b(Object object) {
            return c((ManagedChannelProvider)object);
        }

        @Override // io.grpc.c1$b
        public int c(io.grpc.ManagedChannelProvider managedChannelProvider) {
            return managedChannelProvider.c();
        }

        @Override // io.grpc.c1$b
        public boolean d(io.grpc.ManagedChannelProvider managedChannelProvider) {
            return managedChannelProvider.b();
        }
    }
    static {
        ManagedChannelRegistry.c = Logger.getLogger(ManagedChannelRegistry.class.getName());
    }

    public ManagedChannelRegistry() {
        super();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.a = linkedHashSet;
        this.b = Collections.emptyList();
    }

    private void a(io.grpc.ManagedChannelProvider managedChannelProvider) {
        n.e(managedChannelProvider.b(), "isAvailable() returned false");
        this.a.add(managedChannelProvider);
        return;
        synchronized (this) {
            n.e(managedChannelProvider.b(), "isAvailable() returned false");
            this.a.add(managedChannelProvider);
        }
    }

    public static io.grpc.ManagedChannelRegistry b() {
        Class<io.grpc.ManagedChannelProvider> obj;
        io.grpc.ManagedChannelRegistry managedChannelRegistry;
        io.grpc.ManagedChannelRegistry next;
        java.lang.ClassLoader classLoader;
        io.grpc.ManagedChannelRegistry.b bVar;
        int str;
        obj = ManagedChannelProvider.class;
        final Class<io.grpc.ManagedChannelRegistry> obj2 = ManagedChannelRegistry.class;
        synchronized (obj2) {
            bVar = new ManagedChannelRegistry.b(0);
            managedChannelRegistry = new ManagedChannelRegistry();
            ManagedChannelRegistry.d = managedChannelRegistry;
            Iterator iterator = c1.e(obj, ManagedChannelRegistry.c(), obj.getClassLoader(), bVar).iterator();
            while (iterator.hasNext()) {
                managedChannelRegistry = iterator.next();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Service loader found ");
                stringBuilder.append((ManagedChannelProvider)managedChannelRegistry);
                ManagedChannelRegistry.c.fine(stringBuilder.toString());
                if (managedChannelRegistry.b() != null) {
                }
                ManagedChannelRegistry.d.a(managedChannelRegistry);
            }
            try {
                ManagedChannelRegistry.d.f();
                return ManagedChannelRegistry.d;
                throw th;
            }
        }
    }

    static List<Class<?>> c() {
        Class forName2;
        Class forName;
        Logger logger;
        Level fINE;
        String str;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Class.forName("io.grpc.k1.f"));
        arrayList.add(Class.forName("io.grpc.netty.NettyChannelProvider"));
        return Collections.unmodifiableList(arrayList);
    }

    private void f() {
        ArrayList arrayList = new ArrayList(this.a);
        ManagedChannelRegistry.a aVar = new ManagedChannelRegistry.a(this);
        Collections.sort(arrayList, Collections.reverseOrder(aVar));
        this.b = Collections.unmodifiableList(arrayList);
        return;
        synchronized (this) {
            arrayList = new ArrayList(this.a);
            aVar = new ManagedChannelRegistry.a(this);
            Collections.sort(arrayList, Collections.reverseOrder(aVar));
            this.b = Collections.unmodifiableList(arrayList);
        }
    }

    io.grpc.ManagedChannelProvider d() {
        int i;
        boolean empty;
        List list = e();
        if (list.isEmpty()) {
            i = 0;
        } else {
            i = list.get(0);
        }
        return i;
    }

    List<io.grpc.ManagedChannelProvider> e() {
        return this.b;
        synchronized (this) {
            return this.b;
        }
    }
}
