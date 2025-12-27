package io.grpc;

import com.google.common.base.n;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: EquivalentAddressGroup.java */
/* loaded from: classes2.dex */
public final class y {

    public static final a.c<String> d;
    private final List<SocketAddress> a;
    private final a b;
    private final int c;
    static {
        y.d = a.c.a("io.grpc.EquivalentAddressGroup.authorityOverride");
    }

    public y(List<SocketAddress> list) {
        this(list, a.b);
    }

    public List<SocketAddress> a() {
        return this.a;
    }

    public a b() {
        return this.b;
    }

    public boolean equals(Object object) {
        int i;
        i = 0;
        if (!(object instanceof y)) {
            return false;
        }
        if (this.a.size() != object.a.size()) {
            return false;
        }
        while (this.a < this.a.size()) {
            if (!(SocketAddress)this.a.get(i).equals(object.a.get(i))) {
                return false;
            }
        }
        if (!this.b.equals(object.b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.c;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "[";
        String str3 = "/";
        String str4 = "]";
        str = str2 + this.a + str3 + this.b + str4;
        return str;
    }

    public y(List<SocketAddress> list, a aVar) {
        super();
        n.e(!list.isEmpty(), "addrs is empty");
        List unmodifiable = Collections.unmodifiableList(new ArrayList(list));
        this.a = unmodifiable;
        n.p(aVar, "attrs");
        this.b = aVar;
        this.c = unmodifiable.hashCode();
    }

    public y(SocketAddress socketAddress) {
        this(socketAddress, a.b);
    }

    public y(SocketAddress socketAddress, a aVar) {
        this(Collections.singletonList(socketAddress), aVar);
    }
}
