package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;

/* loaded from: classes2.dex */
public final class UdpDataSource extends com.google.android.exoplayer2.upstream.h {

    private final int e;
    private final byte[] f;
    private final DatagramPacket g;
    private Uri h;
    private DatagramSocket i;
    private MulticastSocket j;
    private InetAddress k;
    private InetSocketAddress l;
    private boolean m;
    private int n;

    public static final class UdpDataSourceException extends com.google.android.exoplayer2.upstream.DataSourceException {
        public UdpDataSourceException(Throwable throwable, int i2) {
            super(throwable, i2);
        }
    }
    public UdpDataSource() {
        super(2000);
    }

    public UdpDataSource(int i) {
        super(i, 8000);
    }

    public UdpDataSource(int i, int i2) {
        super(1);
        this.e = i2;
        final byte[] obj4 = new byte[i];
        this.f = obj4;
        DatagramPacket datagramPacket = new DatagramPacket(obj4, 0, i);
        this.g = datagramPacket;
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public long c(com.google.android.exoplayer2.upstream.n n) {
        Object datagramSocket;
        Object obj;
        Uri uri = n.a;
        this.h = uri;
        p(n);
        this.k = InetAddress.getByName(uri.getHost());
        InetSocketAddress inetSocketAddress = new InetSocketAddress(this.k, this.h.getPort());
        this.l = inetSocketAddress;
        if (this.k.isMulticastAddress()) {
            MulticastSocket multicastSocket = new MulticastSocket(this.l);
            this.j = multicastSocket;
            multicastSocket.joinGroup(this.k);
            this.i = this.j;
        } else {
            datagramSocket = new DatagramSocket(this.l);
            this.i = datagramSocket;
        }
        this.i.setSoTimeout(this.e);
        this.m = true;
        q(n);
        return -1;
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public void close() {
        InetAddress inetAddress;
        int i = 0;
        this.h = i;
        MulticastSocket socket = this.j;
        if (socket != null) {
            socket.leaveGroup(this.k);
            this.j = i;
        }
        DatagramSocket socket2 = this.i;
        if (socket2 != null) {
            socket2.close();
            this.i = i;
        }
        this.k = i;
        this.l = i;
        int i2 = 0;
        this.n = i2;
        if (this.m) {
            this.m = i2;
            o();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public Uri l() {
        return this.h;
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public int read(byte[] bArr, int i2, int i3) {
        int length;
        DatagramPacket datagramPacket;
        if (i3 == 0) {
            return 0;
        }
        if (this.n == 0) {
            this.i.receive(this.g);
            length = this.g.getLength();
            this.n = length;
            n(length);
        }
        int i4 = this.n;
        final int obj5 = Math.min(i4, i3);
        System.arraycopy(this.f, length2 -= i4, bArr, i2, obj5);
        this.n = obj3 -= obj5;
        return obj5;
    }
}
