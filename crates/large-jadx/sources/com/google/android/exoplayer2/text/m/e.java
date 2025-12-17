package com.google.android.exoplayer2.text.m;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.decoder.f.a;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.text.g;
import com.google.android.exoplayer2.text.i;
import com.google.android.exoplayer2.text.j;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

/* loaded from: classes2.dex */
abstract class e implements g {

    private final ArrayDeque<com.google.android.exoplayer2.text.m.e.b> a;
    private final ArrayDeque<j> b;
    private final PriorityQueue<com.google.android.exoplayer2.text.m.e.b> c;
    private com.google.android.exoplayer2.text.m.e.b d;
    private long e;
    private long f;

    static class a {
    }

    private static final class b extends i implements Comparable<com.google.android.exoplayer2.text.m.e.b> {

        private long B;
        b(com.google.android.exoplayer2.text.m.e.a e$a) {
            super();
        }

        static long y(com.google.android.exoplayer2.text.m.e.b e$b, long l2) {
            b.B = l2;
            return l2;
        }

        @Override // com.google.android.exoplayer2.text.i
        public int compareTo(Object object) {
            return z((e.b)object);
        }

        @Override // com.google.android.exoplayer2.text.i
        public int z(com.google.android.exoplayer2.text.m.e.b e$b) {
            int i2;
            int i;
            int cmp;
            Object obj9;
            i = 1;
            final int i3 = -1;
            if (p() != b.p()) {
                if (p()) {
                } else {
                    i = i3;
                }
                return i;
            }
            int i4 = 0;
            if (Long.compare(i2, i4) == 0 && Long.compare(i2, i4) == 0) {
                if (Long.compare(i2, i4) == 0) {
                    return 0;
                }
            }
            if (Long.compare(i2, i4) > 0) {
            } else {
                i = i3;
            }
            return i;
        }
    }

    private static final class c extends j {

        private f.a<com.google.android.exoplayer2.text.m.e.c> x;
        public c(f.a<com.google.android.exoplayer2.text.m.e.c> f$a) {
            super();
            this.x = a;
        }

        @Override // com.google.android.exoplayer2.text.j
        public final void s() {
            this.x.a(this);
        }
    }
    public e() {
        int i3;
        int i;
        ArrayDeque arrayDeque;
        ArrayDeque queue;
        int cVar;
        com.google.android.exoplayer2.text.m.e.b bVar;
        int i2;
        super();
        ArrayDeque arrayDeque2 = new ArrayDeque();
        this.a = arrayDeque2;
        i = i3;
        while (i < 10) {
            bVar = new e.b(0);
            this.a.add(bVar);
            i++;
        }
        arrayDeque = new ArrayDeque();
        this.b = arrayDeque;
        while (i3 < 2) {
            bVar = new b(this);
            cVar = new e.c(bVar);
            this.b.add(cVar);
            i3++;
        }
        PriorityQueue priorityQueue = new PriorityQueue();
        this.c = priorityQueue;
    }

    private void n(com.google.android.exoplayer2.text.m.e.b e$b) {
        b.j();
        this.a.add(b);
    }

    @Override // com.google.android.exoplayer2.text.g
    public void a() {
    }

    @Override // com.google.android.exoplayer2.text.g
    public void b(long l) {
        this.e = l;
    }

    @Override // com.google.android.exoplayer2.text.g
    public Object c() {
        return i();
    }

    @Override // com.google.android.exoplayer2.text.g
    public Object d() {
        return h();
    }

    @Override // com.google.android.exoplayer2.text.g
    public void e(Object object) {
        m((i)object);
    }

    @Override // com.google.android.exoplayer2.text.g
    protected abstract f f();

    @Override // com.google.android.exoplayer2.text.g
    public void flush() {
        int poll;
        com.google.android.exoplayer2.text.m.e.b bVar;
        poll = 0;
        this.f = poll;
        this.e = poll;
        while (!this.c.isEmpty()) {
            poll = this.c.poll();
            p0.i((e.b)poll);
            n((e.b)poll);
        }
        bVar = this.d;
        if (bVar != null) {
            n(bVar);
            this.d = 0;
        }
    }

    @Override // com.google.android.exoplayer2.text.g
    protected abstract void g(i i);

    @Override // com.google.android.exoplayer2.text.g
    public i h() {
        int i;
        i = this.d == null ? 1 : 0;
        g.f(i);
        if (this.a.isEmpty()) {
            return null;
        }
        Object pollFirst = this.a.pollFirst();
        this.d = (e.b)pollFirst;
        return pollFirst;
    }

    @Override // com.google.android.exoplayer2.text.g
    public j i() {
        boolean empty2;
        boolean empty;
        boolean z;
        long l;
        int i = 0;
        if (this.b.isEmpty()) {
            return i;
        }
        while (!this.c.isEmpty()) {
            Object peek = this.c.peek();
            p0.i((e.b)peek);
            empty2 = this.c.poll();
            p0.i((e.b)empty2);
            g(empty2);
            n(empty2);
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.text.g
    protected final j j() {
        return (j)this.b.pollFirst();
    }

    @Override // com.google.android.exoplayer2.text.g
    protected final long k() {
        return this.e;
    }

    @Override // com.google.android.exoplayer2.text.g
    protected abstract boolean l();

    @Override // com.google.android.exoplayer2.text.g
    public void m(i i) {
        int i2;
        PriorityQueue z;
        int i3;
        i2 = i == this.d ? 1 : 0;
        g.a(i2);
        if ((e.b)i.o()) {
            n(i);
        } else {
            long l = this.f;
            this.f = i4 += l;
            e.b.y(i, l);
            this.c.add(i);
        }
        this.d = 0;
    }

    @Override // com.google.android.exoplayer2.text.g
    protected void o(j j) {
        j.j();
        this.b.add(j);
    }
}
