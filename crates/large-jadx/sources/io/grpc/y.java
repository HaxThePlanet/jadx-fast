package io.grpc;

import com.google.common.base.n;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class y {

    public static final io.grpc.a.c<String> d;
    private final List<SocketAddress> a;
    private final io.grpc.a b;
    private final int c;
    static {
        y.d = a.c.a("io.grpc.EquivalentAddressGroup.authorityOverride");
    }

    public y(SocketAddress socketAddress) {
        super(socketAddress, a.b);
    }

    public y(SocketAddress socketAddress, io.grpc.a a2) {
        super(Collections.singletonList(socketAddress), a2);
    }

    public y(List<SocketAddress> list) {
        super(list, a.b);
    }

    public y(List<SocketAddress> list, io.grpc.a a2) {
        super();
        n.e(empty ^= 1, "addrs is empty");
        ArrayList arrayList = new ArrayList(list);
        List obj3 = Collections.unmodifiableList(arrayList);
        this.a = obj3;
        n.p(a2, "attrs");
        this.b = a2;
        this.c = obj3.hashCode();
    }

    public List<SocketAddress> a() {
        return this.a;
    }

    public io.grpc.a b() {
        return this.b;
    }

    public boolean equals(Object object) {
        int i;
        int equals;
        Object obj;
        final int i2 = 0;
        if (!object instanceof y) {
            return i2;
        }
        if (this.a.size() != object.a.size()) {
            return i2;
        }
        i = i2;
        while (i < this.a.size()) {
            i++;
        }
        if (!this.b.equals(object.b)) {
            return i2;
        }
        return 1;
    }

    public int hashCode() {
        return this.c;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(this.a);
        stringBuilder.append("/");
        stringBuilder.append(this.b);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
