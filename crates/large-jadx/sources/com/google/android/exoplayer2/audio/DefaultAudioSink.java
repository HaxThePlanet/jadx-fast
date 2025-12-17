package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.media.AudioFormat;
import android.media.AudioFormat.Builder;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.AudioTrack.Builder;
import android.media.AudioTrack.StreamEventCallback;
import android.media.PlaybackParams;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.util.z;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class DefaultAudioSink implements com.google.android.exoplayer2.audio.AudioSink {

    public static boolean a0 = false;
    private long A;
    private long B;
    private long C;
    private int D;
    private boolean E;
    private boolean F;
    private long G;
    private float H = 1f;
    private com.google.android.exoplayer2.audio.AudioProcessor[] I;
    private ByteBuffer[] J;
    private ByteBuffer K;
    private int L;
    private ByteBuffer M;
    private byte[] N;
    private int O;
    private int P = -1;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private int U = 0;
    private com.google.android.exoplayer2.audio.v V;
    private boolean W;
    private long X;
    private boolean Y;
    private boolean Z;
    private final com.google.android.exoplayer2.audio.q a;
    private final com.google.android.exoplayer2.audio.DefaultAudioSink.b b;
    private final boolean c = false;
    private final com.google.android.exoplayer2.audio.x d;
    private final com.google.android.exoplayer2.audio.h0 e;
    private final com.google.android.exoplayer2.audio.AudioProcessor[] f;
    private final com.google.android.exoplayer2.audio.AudioProcessor[] g;
    private final ConditionVariable h;
    private final com.google.android.exoplayer2.audio.u i;
    private final ArrayDeque<com.google.android.exoplayer2.audio.DefaultAudioSink.e> j;
    private final boolean k = false;
    private final int l = 0;
    private com.google.android.exoplayer2.audio.DefaultAudioSink.h m;
    private final com.google.android.exoplayer2.audio.DefaultAudioSink.f<com.google.android.exoplayer2.audio.AudioSink.InitializationException> n;
    private final com.google.android.exoplayer2.audio.DefaultAudioSink.f<com.google.android.exoplayer2.audio.AudioSink.WriteException> o;
    private com.google.android.exoplayer2.audio.AudioSink.a p;
    private com.google.android.exoplayer2.audio.DefaultAudioSink.c q;
    private com.google.android.exoplayer2.audio.DefaultAudioSink.c r;
    private AudioTrack s;
    private com.google.android.exoplayer2.audio.p t = 1065353216;
    private com.google.android.exoplayer2.audio.DefaultAudioSink.e u;
    private com.google.android.exoplayer2.audio.DefaultAudioSink.e v;
    private u1 w = null;
    private ByteBuffer x;
    private int y;
    private long z;

    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        private InvalidAudioTrackTimestampException(String string) {
            super(string);
        }

        InvalidAudioTrackTimestampException(String string, com.google.android.exoplayer2.audio.DefaultAudioSink.a defaultAudioSink$a2) {
            super(string);
        }
    }

    class a extends Thread {

        final AudioTrack a;
        final com.google.android.exoplayer2.audio.DefaultAudioSink b;
        a(com.google.android.exoplayer2.audio.DefaultAudioSink defaultAudioSink, String string2, AudioTrack audioTrack3) {
            this.b = defaultAudioSink;
            this.a = audioTrack3;
            super(string2);
        }

        @Override // java.lang.Thread
        public void run() {
            try {
                this.a.flush();
                this.a.release();
                DefaultAudioSink.y(this.b).open();
                com.google.android.exoplayer2.audio.DefaultAudioSink defaultAudioSink2 = this.b;
                defaultAudioSink2 = DefaultAudioSink.y(defaultAudioSink2);
                defaultAudioSink2.open();
                throw th;
            }
        }
    }

    public interface b {
        public abstract u1 a(u1 u1);

        public abstract long b(long l);

        public abstract long c();

        public abstract boolean d(boolean z);

        public abstract com.google.android.exoplayer2.audio.AudioProcessor[] e();
    }

    private static final class c {

        public final i1 a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final com.google.android.exoplayer2.audio.AudioProcessor[] i;
        public c(i1 i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z9, com.google.android.exoplayer2.audio.AudioProcessor[] audioProcessor10Arr10) {
            super();
            this.a = i1;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.i = audioProcessor10Arr10;
            this.h = c(i8, z9);
        }

        private int c(int i, boolean z2) {
            int obj1;
            if (i != 0) {
                return i;
            }
            obj1 = this.c;
            int obj2 = 1;
            if (obj1 != null && obj1 != obj2) {
                obj2 = 1;
                if (obj1 != obj2) {
                    obj2 = 2;
                    if (obj1 != obj2) {
                    } else {
                        return l(250000);
                    }
                    obj1 = new IllegalStateException();
                    throw obj1;
                }
                return l(50000000);
            }
            obj1 = z2 ? 1090519040 : 1065353216;
            return m(obj1);
        }

        private AudioTrack d(boolean z, com.google.android.exoplayer2.audio.p p2, int i3) {
            final int i = p0.a;
            if (i >= 29) {
                return f(z, p2, i3);
            }
            if (i >= 21) {
                return e(z, p2, i3);
            }
            return g(p2, i3);
        }

        private AudioTrack e(boolean z, com.google.android.exoplayer2.audio.p p2, int i3) {
            super(DefaultAudioSink.c.j(p2, z), DefaultAudioSink.a(this.e, this.f, this.g), this.h, 1, i3);
            return audioTrack2;
        }

        private AudioTrack f(boolean z, com.google.android.exoplayer2.audio.p p2, int i3) {
            int obj5;
            obj5 = new AudioTrack.Builder();
            obj5 = 1;
            if (this.c == obj5) {
            } else {
                obj5 = 0;
            }
            return obj5.setAudioAttributes(DefaultAudioSink.c.j(p2, z)).setAudioFormat(DefaultAudioSink.a(this.e, this.f, this.g)).setTransferMode(obj5).setBufferSizeInBytes(this.h).setSessionId(i3).setOffloadedPlayback(obj5).build();
        }

        private AudioTrack g(com.google.android.exoplayer2.audio.p p, int i2) {
            final int i = p0.W(p.c);
            if (i2 == 0) {
                super(i, this.e, this.f, this.g, this.h, 1);
                return obj9;
            }
            super(i, this.e, this.f, this.g, this.h, 1, i2);
            return obj9;
        }

        private static AudioAttributes j(com.google.android.exoplayer2.audio.p p, boolean z2) {
            if (z2) {
                return DefaultAudioSink.c.k();
            }
            return p.a();
        }

        private static AudioAttributes k() {
            AudioAttributes.Builder builder = new AudioAttributes.Builder();
            return builder.setContentType(3).setFlags(16).setUsage(1).build();
        }

        private int l(long l) {
            int i;
            if (this.g == 5) {
                i *= 2;
            }
            return (int)obj4;
        }

        private int m(float f) {
            int round;
            int i;
            int minBufferSize = AudioTrack.getMinBufferSize(this.e, this.f, this.g);
            i = minBufferSize != -2 ? 1 : 0;
            g.f(i);
            if (Float.compare(f, i8) != 0) {
                round = Math.round(f2 *= f);
            }
            return round;
        }

        public AudioTrack a(boolean z, com.google.android.exoplayer2.audio.p p2, int i3) {
            try {
                AudioTrack obj9 = d(z, p2, i3);
                final int state = obj9.getState();
                if (state != 1) {
                } else {
                }
                return obj9;
                obj9.release();
                super(state, this.e, this.f, this.h, this.a, o(), 0);
                throw obj9;
            } catch (Exception e) {
            }
            super(0, this.e, this.f, this.h, this.a, o(), z);
            throw z;
        }

        public boolean b(com.google.android.exoplayer2.audio.DefaultAudioSink.c defaultAudioSink$c) {
            int i;
            int i2;
            int obj3;
            if (c.c == this.c && c.g == this.g && c.e == this.e && c.f == this.f && c.d == this.d) {
                if (c.g == this.g) {
                    if (c.e == this.e) {
                        if (c.f == this.f) {
                            obj3 = c.d == this.d ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return obj3;
        }

        public long h(long l) {
            return obj3 /= i2;
        }

        public long i(long l) {
            return obj3 /= l2;
        }

        public long n(long l) {
            return obj3 /= l2;
        }

        public boolean o() {
            int i;
            if (this.c == 1) {
            } else {
                i = 0;
            }
            return i;
        }
    }

    private static final class e {

        public final u1 a;
        public final boolean b;
        public final long c;
        public final long d;
        private e(u1 u1, boolean z2, long l3, long l4) {
            super();
            this.a = u1;
            this.b = z2;
            this.c = l3;
            this.d = obj5;
        }

        e(u1 u1, boolean z2, long l3, long l4, com.google.android.exoplayer2.audio.DefaultAudioSink.a defaultAudioSink$a5) {
            super(u1, z2, l3, l4, a5, obj6);
        }
    }

    private static final class f {

        private final long a;
        private T b;
        private long c;
        public f(long l) {
            super();
            this.a = l;
        }

        public void a() {
            this.b = 0;
        }

        public void b(T t) {
            Exception exc;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.b == null) {
                this.b = t;
                this.c = l += elapsedRealtime;
            }
            if (Long.compare(elapsedRealtime, l2) >= 0) {
                Exception exc2 = this.b;
                if (exc2 == t) {
                } else {
                    exc2.addSuppressed(t);
                }
                a();
                throw this.b;
            }
        }
    }

    private final class h {

        private final Handler a;
        private final AudioTrack.StreamEventCallback b;
        final com.google.android.exoplayer2.audio.DefaultAudioSink c;
        public h(com.google.android.exoplayer2.audio.DefaultAudioSink defaultAudioSink) {
            this.c = defaultAudioSink;
            super();
            Handler handler = new Handler();
            this.a = handler;
            DefaultAudioSink.h.a aVar = new DefaultAudioSink.h.a(this, defaultAudioSink);
            this.b = aVar;
        }

        public void a(AudioTrack audioTrack) {
            Handler handler = this.a;
            Objects.requireNonNull(handler);
            l lVar = new l(handler);
            audioTrack.registerStreamEventCallback(lVar, this.b);
        }

        public void b(AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.b);
            this.a.removeCallbacksAndMessages(0);
        }
    }

    public static class d implements com.google.android.exoplayer2.audio.DefaultAudioSink.b {

        private final com.google.android.exoplayer2.audio.AudioProcessor[] a;
        private final com.google.android.exoplayer2.audio.e0 b;
        private final com.google.android.exoplayer2.audio.g0 c;
        public d(com.google.android.exoplayer2.audio.AudioProcessor... audioProcessorArr) {
            e0 e0Var = new e0();
            g0 g0Var = new g0();
            super(audioProcessorArr, e0Var, g0Var);
        }

        public d(com.google.android.exoplayer2.audio.AudioProcessor[] audioProcessorArr, com.google.android.exoplayer2.audio.e0 e02, com.google.android.exoplayer2.audio.g0 g03) {
            super();
            com.google.android.exoplayer2.audio.AudioProcessor[] arr = new AudioProcessor[length += 2];
            this.a = arr;
            final int i2 = 0;
            System.arraycopy(audioProcessorArr, i2, arr, i2, audioProcessorArr.length);
            this.b = e02;
            this.c = g03;
            arr[audioProcessorArr.length] = e02;
            arr[obj4++] = g03;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink$b
        public u1 a(u1 u1) {
            this.c.i(u1.a);
            this.c.h(u1.b);
            return u1;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink$b
        public long b(long l) {
            return this.c.g(l);
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink$b
        public long c() {
            return this.b.p();
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink$b
        public boolean d(boolean z) {
            this.b.v(z);
            return z;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink$b
        public com.google.android.exoplayer2.audio.AudioProcessor[] e() {
            return this.a;
        }
    }

    private final class g implements com.google.android.exoplayer2.audio.u.a {

        final com.google.android.exoplayer2.audio.DefaultAudioSink a;
        private g(com.google.android.exoplayer2.audio.DefaultAudioSink defaultAudioSink) {
            this.a = defaultAudioSink;
            super();
        }

        g(com.google.android.exoplayer2.audio.DefaultAudioSink defaultAudioSink, com.google.android.exoplayer2.audio.DefaultAudioSink.a defaultAudioSink$a2) {
            super(defaultAudioSink);
        }

        @Override // com.google.android.exoplayer2.audio.u$a
        public void a(int i, long l2) {
            Object aVar;
            long l;
            com.google.android.exoplayer2.audio.AudioSink.a aVar2;
            int i2;
            long l3;
            int i3;
            if (DefaultAudioSink.A(this.a) != null) {
                DefaultAudioSink.A(this.a).c(i, l2, obj7);
            }
        }

        @Override // com.google.android.exoplayer2.audio.u$a
        public void b(long l) {
            com.google.android.exoplayer2.audio.AudioSink.a aVar;
            if (DefaultAudioSink.A(this.a) != null) {
                DefaultAudioSink.A(this.a).b(l);
            }
        }

        @Override // com.google.android.exoplayer2.audio.u$a
        public void c(long l) {
            StringBuilder stringBuilder = new StringBuilder(61);
            stringBuilder.append("Ignoring impossibly large audio latency: ");
            stringBuilder.append(l);
            v.h("DefaultAudioSink", stringBuilder.toString());
        }

        @Override // com.google.android.exoplayer2.audio.u$a
        public void d(long l, long l2, long l3, long l4) {
            StringBuilder stringBuilder = new StringBuilder(182);
            stringBuilder.append("Spurious audio timestamp (frame position mismatch): ");
            stringBuilder.append(l);
            String obj7 = ", ";
            stringBuilder.append(obj7);
            stringBuilder.append(l3);
            stringBuilder.append(obj7);
            stringBuilder.append(obj11);
            stringBuilder.append(obj7);
            stringBuilder.append(obj13);
            stringBuilder.append(obj7);
            stringBuilder.append(DefaultAudioSink.C(this.a));
            stringBuilder.append(obj7);
            stringBuilder.append(DefaultAudioSink.D(this.a));
            obj7 = stringBuilder.toString();
            if (DefaultAudioSink.a0) {
            } else {
                v.h("DefaultAudioSink", obj7);
            }
            DefaultAudioSink.InvalidAudioTrackTimestampException obj8 = new DefaultAudioSink.InvalidAudioTrackTimestampException(obj7, 0);
            throw obj8;
        }

        @Override // com.google.android.exoplayer2.audio.u$a
        public void e(long l, long l2, long l3, long l4) {
            StringBuilder stringBuilder = new StringBuilder(180);
            stringBuilder.append("Spurious audio timestamp (system clock mismatch): ");
            stringBuilder.append(l);
            String obj7 = ", ";
            stringBuilder.append(obj7);
            stringBuilder.append(l3);
            stringBuilder.append(obj7);
            stringBuilder.append(obj11);
            stringBuilder.append(obj7);
            stringBuilder.append(obj13);
            stringBuilder.append(obj7);
            stringBuilder.append(DefaultAudioSink.C(this.a));
            stringBuilder.append(obj7);
            stringBuilder.append(DefaultAudioSink.D(this.a));
            obj7 = stringBuilder.toString();
            if (DefaultAudioSink.a0) {
            } else {
                v.h("DefaultAudioSink", obj7);
            }
            DefaultAudioSink.InvalidAudioTrackTimestampException obj8 = new DefaultAudioSink.InvalidAudioTrackTimestampException(obj7, 0);
            throw obj8;
        }
    }
    static {
    }

    public DefaultAudioSink(com.google.android.exoplayer2.audio.q q, com.google.android.exoplayer2.audio.DefaultAudioSink.b defaultAudioSink$b2, boolean z3, boolean z4, int i5) {
        super();
        this.a = q;
        g.e(b2);
        this.b = (DefaultAudioSink.b)b2;
        int obj11 = p0.a;
        final int i = 1;
        final int i2 = 0;
        if (obj11 >= 21 && z3) {
            int obj13 = z3 ? i : obj13;
        }
        obj13 = i2;
        if (obj11 >= 23 && z4) {
            obj13 = z4 ? i : obj13;
        }
        obj13 = i2;
        if (obj11 >= 29) {
        }
        int obj15 = i2;
        obj11 = new ConditionVariable(i);
        this.h = obj11;
        obj13 = new DefaultAudioSink.g(this, 0);
        obj11 = new u(obj13);
        this.i = obj11;
        obj11 = new x();
        this.d = obj11;
        obj13 = new h0();
        this.e = obj13;
        ArrayList obj14 = new ArrayList();
        obj15 = new w[3];
        d0 d0Var = new d0();
        obj15[i2] = d0Var;
        obj15[i] = obj11;
        obj15[2] = obj13;
        Collections.addAll(obj14, obj15);
        Collections.addAll(obj14, b2.e());
        this.f = (AudioProcessor[])obj14.toArray(new AudioProcessor[i2]);
        obj11 = new AudioProcessor[i];
        z obj12 = new z();
        obj11[i2] = obj12;
        this.g = obj11;
        obj11 = 1065353216;
        obj11 = p.f;
        obj11 = new v(i2, 0);
        this.V = obj11;
        super(u1.d, 0, 0, obj6, 0, obj8, 0);
        this.v = obj11;
        obj11 = -1;
        this.I = new AudioProcessor[i2];
        this.J = new ByteBuffer[i2];
        obj11 = new ArrayDeque();
        this.j = obj11;
        obj12 = 100;
        obj11 = new DefaultAudioSink.f(obj12, obj13);
        this.n = obj11;
        obj11 = new DefaultAudioSink.f(obj12, obj13);
        this.o = obj11;
    }

    static com.google.android.exoplayer2.audio.AudioSink.a A(com.google.android.exoplayer2.audio.DefaultAudioSink defaultAudioSink) {
        return defaultAudioSink.p;
    }

    static boolean B(com.google.android.exoplayer2.audio.DefaultAudioSink defaultAudioSink) {
        return defaultAudioSink.S;
    }

    static long C(com.google.android.exoplayer2.audio.DefaultAudioSink defaultAudioSink) {
        return defaultAudioSink.U();
    }

    static long D(com.google.android.exoplayer2.audio.DefaultAudioSink defaultAudioSink) {
        return defaultAudioSink.V();
    }

    static long E(com.google.android.exoplayer2.audio.DefaultAudioSink defaultAudioSink) {
        return defaultAudioSink.X;
    }

    private void F(long l) {
        u1 u1Var;
        int i;
        u1 u1Var2;
        if (n0()) {
            u1Var = this.b.a(M());
        } else {
            u1Var = u1.d;
        }
        if (n0()) {
            i = this.b.d(T());
        } else {
            i = 0;
        }
        super(u1Var, i, Math.max(0, obj4), obj5, this.r.i(V()), obj7, 0);
        this.j.add(eVar2);
        m0();
        com.google.android.exoplayer2.audio.AudioSink.a obj12 = this.p;
        if (obj12 != null) {
            obj12.a(i);
        }
    }

    private long G(long l) {
        boolean empty;
        while (!this.j.isEmpty()) {
            if (Long.compare(l, l4) >= 0) {
            }
            this.v = (DefaultAudioSink.e)this.j.remove();
        }
        com.google.android.exoplayer2.audio.DefaultAudioSink.e eVar = this.v;
        int i3 = l - l5;
        if (eVar.a.equals(u1.d)) {
            return obj5 += i3;
        }
        if (this.j.isEmpty()) {
            return l3 += obj5;
        }
        Object first = this.j.getFirst();
        return l2 -= obj5;
    }

    private long H(long l) {
        return l += l2;
    }

    private AudioTrack I() {
        com.google.android.exoplayer2.audio.AudioSink.a aVar;
        try {
            com.google.android.exoplayer2.audio.DefaultAudioSink.c cVar = this.r;
            g.e(cVar);
            return (DefaultAudioSink.c)cVar.a(this.W, this.t, this.U);
            c0();
            aVar = this.p;
            if (aVar == null) {
            } else {
            }
            aVar.t(th);
            throw th;
        }
    }

    private boolean J() {
        int i2;
        ByteBuffer byteBuffer;
        int i;
        com.google.android.exoplayer2.audio.AudioProcessor audioProcessor;
        com.google.android.exoplayer2.audio.AudioProcessor[] objArr;
        int length;
        long l;
        final int i4 = -1;
        final int i5 = 1;
        final int i6 = 0;
        if (this.P == i4) {
            this.P = i6;
            i2 = i5;
        } else {
            i2 = i6;
        }
        int i7 = this.P;
        objArr = this.I;
        l = -9223372036854775807L;
        if (i7 < objArr.length) {
        }
        byteBuffer = this.M;
        q0(byteBuffer, l);
        if (byteBuffer != null && this.M != null) {
            q0(byteBuffer, l);
            if (this.M != null) {
                return i6;
            }
        }
        this.P = i4;
        return i5;
    }

    private void K() {
        int i;
        ByteBuffer byteBuffer;
        ByteBuffer[] objArr;
        i = 0;
        com.google.android.exoplayer2.audio.AudioProcessor[] objArr2 = this.I;
        for (Object audioProcessor : obj1) {
            audioProcessor.flush();
            this.J[i] = audioProcessor.b();
            objArr2 = this.I;
        }
    }

    private static AudioFormat L(int i, int i2, int i3) {
        AudioFormat.Builder builder = new AudioFormat.Builder();
        return builder.setSampleRate(i).setChannelMask(i2).setEncoding(i3).build();
    }

    private u1 M() {
        return eVar.a;
    }

    private static int N(int i) {
        int equals;
        int i2;
        int str;
        int obj2;
        equals = p0.a;
        if (equals <= 28) {
            if (i == 7) {
                obj2 = 8;
            } else {
                if (i != 3 && i != 4) {
                    if (i != 4) {
                        if (i == 5) {
                            obj2 = 6;
                        }
                    } else {
                    }
                } else {
                }
            }
        }
        if (equals <= 26 && "fugu".equals(p0.b) && obj2 == 1) {
            if ("fugu".equals(p0.b)) {
                if (obj2 == 1) {
                    obj2 = 2;
                }
            }
        }
        return p0.C(obj2);
    }

    private static Pair<Integer, Integer> O(i1 i1, com.google.android.exoplayer2.audio.q q2) {
        int i2;
        int i;
        int z;
        int i4;
        int i3;
        Object obj7;
        int obj8;
        final int i5 = 0;
        if (q2 == 0) {
            return i5;
        }
        String str = i1.D;
        g.e(str);
        i2 = z.f((String)str, i1.A);
        final int i6 = 7;
        final int i7 = 8;
        i3 = 6;
        final int i8 = 18;
        if (i2 != 5 && i2 != i3 && i2 != i8 && i2 != 17 && i2 != i6 && i2 != i7) {
            if (i2 != i3) {
                if (i2 != i8) {
                    if (i2 != 17) {
                        if (i2 != i6) {
                            if (i2 != i7) {
                                if (i2 == 14) {
                                    i = 1;
                                } else {
                                    i = 0;
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (i == 0) {
            return i5;
        }
        if (i2 == i8 && !q2.f(i8)) {
            if (!q2.f(i8)) {
                i2 = i3;
            } else {
                if (i2 == i7 && !q2.f(i7)) {
                    if (!q2.f(i7)) {
                        i2 = i6;
                    }
                }
            }
        } else {
        }
        if (!q2.f(i2)) {
            return i5;
        }
        if (i2 == i8) {
            if (p0.a >= 29 && DefaultAudioSink.Q(i8, i1.R) == 0) {
                if (DefaultAudioSink.Q(i8, i1.R) == 0) {
                    v.h("DefaultAudioSink", "E-AC3 JOC encoding supported but no channel count supported");
                    return i5;
                }
            }
        } else {
            if (i1.Q > q2.e()) {
                return i5;
            }
        }
        obj7 = DefaultAudioSink.N(i3);
        if (obj7 == null) {
            return i5;
        }
        return Pair.create(Integer.valueOf(i2), Integer.valueOf(obj7));
    }

    private static int P(int i, ByteBuffer byteBuffer2) {
        int obj2;
        int i2 = 1024;
        int i4 = -1;
        switch (i) {
            case 5:
                return n.d(byteBuffer2);
            case 6:
                return y.e(byteBuffer2);
            case 7:
                obj2 = b0.m(p0.D(byteBuffer2, byteBuffer2.position()));
                return obj2;
                obj2 = new IllegalArgumentException();
                throw obj2;
            case 8:
                return i2;
            case 9:
                return 2048;
            case 10:
                StringBuilder stringBuilder = new StringBuilder(38);
                stringBuilder.append("Unexpected audio encoding: ");
                stringBuilder.append(i);
                IllegalStateException obj3 = new IllegalStateException(stringBuilder.toString());
                throw obj3;
            case 11:
                obj2 = n.a(byteBuffer2);
                obj2 *= 16;
                return obj2;
            case 12:
                return 512;
            case 13:
                return i2;
            default:
                return o.c(byteBuffer2);
        }
        obj2 = 0;
    }

    private static int Q(int i, int i2) {
        int i3;
        boolean directPlaybackSupported;
        int i4;
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        i3 = 8;
        while (i3 > 0) {
            AudioFormat.Builder builder2 = new AudioFormat.Builder();
            i3--;
        }
        return 0;
    }

    private static int R(int i) {
        switch (i) {
            case 5:
                return 80000;
            case 6:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            case 13:
                IllegalArgumentException obj0 = new IllegalArgumentException();
                throw obj0;
            case 14:
                return 3062500;
            case 15:
                return 8000;
            case 16:
                return 256000;
            default:
                return 336000;
        }
    }

    private com.google.android.exoplayer2.audio.DefaultAudioSink.e S() {
        Object last;
        if (this.u != null) {
        } else {
            if (!this.j.isEmpty()) {
                last = this.j.getLast();
            } else {
                last = this.v;
            }
        }
        return last;
    }

    private long U() {
        int cVar;
        int i;
        long l;
        cVar = this.r;
        if (cVar.c == 0) {
            l2 /= l;
        } else {
            i = this.A;
        }
        return i;
    }

    private long V() {
        int cVar;
        int i;
        long l;
        cVar = this.r;
        if (cVar.c == 0) {
            l2 /= l;
        } else {
            i = this.C;
        }
        return i;
    }

    private void W() {
        boolean z;
        int i;
        int i3;
        com.google.android.exoplayer2.audio.u uVar;
        int i4;
        int i2;
        this.h.block();
        AudioTrack audioTrack = I();
        this.s = audioTrack;
        f0(this.s);
        if (DefaultAudioSink.a0(audioTrack) && this.l != 3) {
            f0(this.s);
            if (this.l != 3) {
                i1 i1Var = cVar2.a;
                this.s.setOffloadDelayPadding(i1Var.T, i1Var.U);
            }
        }
        this.U = this.s.getAudioSessionId();
        com.google.android.exoplayer2.audio.DefaultAudioSink.c cVar = this.r;
        final int i10 = 1;
        i2 = cVar.c == 2 ? i10 : 0;
        this.i.t(this.s, i2, cVar.g, cVar.d, cVar.h);
        j0();
        i = vVar.a;
        if (i != 0) {
            this.s.attachAuxEffect(i);
            this.s.setAuxEffectSendLevel(vVar2.b);
        }
        this.F = i10;
    }

    private static boolean X(int i) {
        int i2;
        int obj2;
        if (p0.a >= 24) {
            if (i != -6) {
                obj2 = i == -32 ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    private boolean Y() {
        int i;
        i = this.s != null ? 1 : 0;
        return i;
    }

    private static boolean Z() {
        int startsWith;
        int i;
        int str;
        if (p0.a >= 30 && p0.d.startsWith("Pixel")) {
            i = p0.d.startsWith("Pixel") ? 1 : 0;
        } else {
        }
        return i;
    }

    static AudioFormat a(int i, int i2, int i3) {
        return DefaultAudioSink.L(i, i2, i3);
    }

    private static boolean a0(AudioTrack audioTrack) {
        boolean obj2;
        if (p0.a >= 29 && audioTrack.isOffloadedPlayback()) {
            obj2 = audioTrack.isOffloadedPlayback() ? 1 : 0;
        } else {
        }
        return obj2;
    }

    private static boolean b0(i1 i1, com.google.android.exoplayer2.audio.q q2) {
        int obj0;
        obj0 = DefaultAudioSink.O(i1, q2) != null ? 1 : 0;
        return obj0;
    }

    private void c0() {
        if (!this.r.o()) {
        }
        this.Y = true;
    }

    private void d0() {
        boolean z;
        long l;
        if (!this.R) {
            this.R = true;
            this.i.h(V());
            this.s.stop();
            this.y = 0;
        }
    }

    private void e0(long l) {
        int i;
        ByteBuffer remaining2;
        int remaining;
        ByteBuffer[] objArr;
        int length = objArr2.length;
        i = length;
        while (i >= 0) {
            if (i > 0) {
            } else {
            }
            if (this.K != null) {
            } else {
            }
            remaining2 = AudioProcessor.a;
            com.google.android.exoplayer2.audio.AudioProcessor audioProcessor = this.I[i];
            if (i > this.P) {
            }
            ByteBuffer byteBuffer = audioProcessor.b();
            this.J[i] = byteBuffer;
            i--;
            i++;
            audioProcessor.d(remaining2);
            q0(remaining2, l);
            remaining2 = this.J[i + -1];
        }
    }

    static int f(int i) {
        return DefaultAudioSink.R(i);
    }

    private void f0(AudioTrack audioTrack) {
        com.google.android.exoplayer2.audio.DefaultAudioSink.h hVar;
        if (this.m == null) {
            hVar = new DefaultAudioSink.h(this);
            this.m = hVar;
        }
        this.m.a(audioTrack);
    }

    private void g0() {
        int i = 0;
        this.z = i;
        this.A = i;
        this.B = i;
        this.C = i;
        final int i4 = 0;
        this.Z = i4;
        this.D = i4;
        super(M(), T(), 0, obj7, 0, obj9, 0);
        this.v = eVar2;
        this.G = i;
        int i2 = 0;
        this.u = i2;
        this.j.clear();
        this.K = i2;
        this.L = i4;
        this.M = i2;
        this.R = i4;
        this.Q = i4;
        this.P = -1;
        this.x = i2;
        this.y = i4;
        this.e.n();
        K();
    }

    private void h0(u1 u1, boolean z2) {
        boolean eVar;
        boolean equals;
        u1 u1Var;
        boolean z;
        long l;
        long l2;
        int i;
        boolean obj10;
        eVar = S();
        if (u1.equals(eVar.a)) {
            if (z2 != eVar.b) {
                super(u1, z2, -9223372036854775807L, obj5, -9223372036854775807L, obj7, 0);
                if (Y()) {
                    this.u = eVar;
                } else {
                    this.v = eVar;
                }
            }
        } else {
        }
    }

    private void i0(u1 u1) {
        AudioTrack audioTrack;
        boolean z;
        float f;
        String str;
        PlaybackParams obj3;
        if (Y()) {
            PlaybackParams playbackParams = new PlaybackParams();
            this.s.setPlaybackParams(playbackParams.allowDefaults().setSpeed(u1.a).setPitch(u1.b).setAudioFallbackMode(2));
            obj3 = new u1(this.s.getPlaybackParams().getSpeed(), this.s.getPlaybackParams().getPitch());
            this.i.u(obj3.a);
        }
        this.w = obj3;
    }

    private void j0() {
        boolean z;
        float f;
        if (!Y()) {
        } else {
            if (p0.a >= 21) {
                DefaultAudioSink.k0(this.s, this.H);
            } else {
                DefaultAudioSink.l0(this.s, this.H);
            }
        }
    }

    private static void k0(AudioTrack audioTrack, float f2) {
        audioTrack.setVolume(f2);
    }

    private static void l0(AudioTrack audioTrack, float f2) {
        audioTrack.setStereoVolume(f2, f2);
    }

    private void m0() {
        int i;
        com.google.android.exoplayer2.audio.AudioProcessor audioProcessor;
        boolean z;
        com.google.android.exoplayer2.audio.AudioProcessor[] objArr = cVar.i;
        ArrayList arrayList = new ArrayList();
        i = 0;
        while (i < objArr.length) {
            audioProcessor = objArr[i];
            if (audioProcessor.a()) {
            } else {
            }
            audioProcessor.flush();
            i++;
            arrayList.add(audioProcessor);
        }
        int size = arrayList.size();
        this.I = (AudioProcessor[])arrayList.toArray(new AudioProcessor[size]);
        this.J = new ByteBuffer[size];
        K();
    }

    private boolean n0() {
        int i;
        boolean equals;
        String str;
        if (!this.W && "audio/raw".equals(i1Var.D) && !o0(i1Var2.S)) {
            if ("audio/raw".equals(i1Var.D)) {
                i = !o0(i1Var2.S) ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    private boolean o0(int i) {
        int obj2;
        if (this.c && p0.f0(i)) {
            obj2 = p0.f0(i) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    private boolean p0(i1 i1, com.google.android.exoplayer2.audio.p p2) {
        int i;
        int obj5;
        int obj6;
        final int i4 = 0;
        if (p0.a >= 29) {
            if (this.l == 0) {
            } else {
                String str = i1.D;
                g.e(str);
                int i2 = z.f((String)str, i1.A);
                if (i2 == 0) {
                    return i4;
                }
                int i7 = p0.C(i1.Q);
                if (i7 == 0) {
                    return i4;
                }
                if (!AudioManager.isOffloadedPlaybackSupported(DefaultAudioSink.L(i1.R, i7, i2), p2.a())) {
                    return i4;
                }
                int i3 = 1;
                if (i1.T == 0) {
                    if (i1.U != 0) {
                        obj5 = i3;
                    } else {
                        obj5 = i4;
                    }
                } else {
                }
                obj6 = this.l == i3 ? i3 : i4;
                if (obj5 != null && obj6 != null && !DefaultAudioSink.Z()) {
                    if (obj6 != null) {
                        if (!DefaultAudioSink.Z()) {
                            return i4;
                        }
                    }
                }
            }
            return i3;
        }
        return i4;
    }

    private void q0(ByteBuffer byteBuffer, long l2) {
        int remaining;
        int remaining2;
        int i;
        int i3;
        int position;
        int i2;
        long elapsedRealtime;
        int bArr2;
        byte[] bArr;
        Object obj;
        AudioTrack audioTrack;
        ByteBuffer byteBuffer2;
        int i4;
        long l;
        ByteBuffer obj13;
        int obj14;
        AudioTrack obj15;
        if (!byteBuffer.hasRemaining()) {
        }
        ByteBuffer byteBuffer3 = this.M;
        i = 21;
        i3 = 1;
        final int i6 = 0;
        if (byteBuffer3 != null) {
            remaining = byteBuffer3 == byteBuffer ? i3 : i6;
            g.a(remaining);
        } else {
            this.M = byteBuffer;
            if (p0.a < i) {
                remaining = byteBuffer.remaining();
                bArr2 = this.N;
                if (bArr2 != null) {
                    if (bArr2.length < remaining) {
                        this.N = new byte[remaining];
                    }
                } else {
                }
                byteBuffer.get(this.N, i6, remaining);
                byteBuffer.position(byteBuffer.position());
                this.O = i6;
            }
        }
        remaining2 = byteBuffer.remaining();
        if (p0.a < i) {
            obj14 = this.i.c(this.B);
            if (obj14 > 0) {
                obj14 = this.s.write(this.N, this.O, Math.min(remaining2, obj14));
                if (obj14 > 0) {
                    this.O = obj15 += obj14;
                    byteBuffer.position(obj15 += obj14);
                }
            } else {
                obj14 = i6;
            }
        } else {
            if (this.W) {
                i = Long.compare(l2, i2) != 0 ? i3 : i6;
                g.f(i);
                obj14 = this.s0(this.s, byteBuffer, remaining2, l2);
            } else {
                obj14 = DefaultAudioSink.r0(this.s, byteBuffer, remaining2);
            }
        }
        this.X = SystemClock.elapsedRealtime();
        obj13 = DefaultAudioSink.X(obj14);
        if (obj14 < 0 && obj13 != null) {
            obj13 = DefaultAudioSink.X(obj14);
            if (obj13 != null) {
                c0();
            }
            obj15 = new AudioSink.WriteException(obj14, cVar.a, obj13);
            obj13 = this.p;
            if (obj13 != null) {
                obj13.t(obj15);
            }
            if (obj15.isRecoverable) {
            } else {
                this.o.b(obj15);
            }
            throw obj15;
        }
        this.o.a();
        elapsedRealtime = this.C;
        if (DefaultAudioSink.a0(this.s) && Long.compare(elapsedRealtime, obj) > 0) {
            elapsedRealtime = this.C;
            if (Long.compare(elapsedRealtime, obj) > 0) {
                this.Z = i6;
            }
            if (this.S && this.p != null && obj14 < remaining2 && !this.Z) {
                if (this.p != null) {
                    if (obj14 < remaining2) {
                        if (!this.Z) {
                            this.p.d(this.i.e(elapsedRealtime));
                        }
                    }
                }
            }
        }
        obj15 = obj15.c;
        if (obj15 == null) {
            this.B = l3 += obj;
        }
        if (obj14 == remaining2 && obj15 != null) {
            if (obj15 != null) {
                if (byteBuffer == this.K) {
                } else {
                    i3 = i6;
                }
                g.f(i3);
                this.C = obj13 += remaining2;
            }
            this.M = 0;
        }
    }

    private static int r0(AudioTrack audioTrack, ByteBuffer byteBuffer2, int i3) {
        return audioTrack.write(byteBuffer2, i3, 1);
    }

    private int s0(AudioTrack audioTrack, ByteBuffer byteBuffer2, int i3, long l4) {
        ByteBuffer byteBuffer;
        int i4;
        int i2;
        int i;
        int obj14;
        int obj15;
        final int i7 = 1000;
        if (p0.a >= 26) {
            return audioTrack.write(byteBuffer2, i3, 1, l4 * i7);
        }
        if (this.x == null) {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            this.x = allocate;
            allocate.order(ByteOrder.BIG_ENDIAN);
            this.x.putInt(1431633921);
        }
        int i8 = 0;
        if (this.y == 0) {
            this.x.putInt(4, i3);
            this.x.putLong(8, l4 *= i7);
            this.x.position(i8);
            this.y = i3;
        }
        obj14 = this.x.remaining();
        obj15 = audioTrack.write(this.x, obj14, 1);
        if (obj14 > 0 && obj15 < 0) {
            obj15 = audioTrack.write(this.x, obj14, 1);
            if (obj15 < 0) {
                this.y = i8;
                return obj15;
            }
            if (obj15 < obj14) {
                return i8;
            }
        }
        int obj11 = DefaultAudioSink.r0(audioTrack, byteBuffer2, i3);
        if (obj11 < 0) {
            this.y = i8;
            return obj11;
        }
        this.y = obj12 -= obj11;
        return obj11;
    }

    static ConditionVariable y(com.google.android.exoplayer2.audio.DefaultAudioSink defaultAudioSink) {
        return defaultAudioSink.h;
    }

    static AudioTrack z(com.google.android.exoplayer2.audio.DefaultAudioSink defaultAudioSink) {
        return defaultAudioSink.s;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean T() {
        return eVar.b;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean b(i1 i1) {
        int obj1;
        obj1 = t(i1) != 0 ? 1 : 0;
        return obj1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean c() {
        boolean z;
        int i;
        if (Y()) {
            if (this.Q && !j()) {
                if (!j()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void d() {
        boolean z;
        this.S = false;
        if (Y() && this.i.q()) {
            if (this.i.q()) {
                this.s.pause();
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public u1 e() {
        u1 u1Var;
        if (this.k) {
            u1Var = this.w;
        } else {
            u1Var = M();
        }
        return u1Var;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void flush() {
        boolean z2;
        boolean z3;
        boolean z;
        Object aVar;
        String str;
        int i;
        int i2;
        g0();
        if (Y() && this.i.j()) {
            g0();
            if (this.i.j()) {
                this.s.pause();
            }
            if (DefaultAudioSink.a0(this.s)) {
                z = this.m;
                g.e(z);
                (DefaultAudioSink.h)z.b(this.s);
            }
            int i3 = 0;
            this.s = i3;
            if (p0.a < 21 && !this.T) {
                if (!this.T) {
                    this.U = 0;
                }
            }
            com.google.android.exoplayer2.audio.DefaultAudioSink.c cVar = this.q;
            if (cVar != null) {
                this.r = cVar;
                this.q = i3;
            }
            this.i.r();
            this.h.close();
            aVar = new DefaultAudioSink.a(this, "ExoPlayer:AudioTrackReleaseThread", this.s);
            aVar.start();
        }
        this.o.a();
        this.n.a();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void g(float f) {
        if (Float.compare(f2, f) != 0) {
            this.H = f;
            j0();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void h(u1 u1) {
        float f;
        boolean obj5;
        final int i = 1036831949;
        final int i2 = 1090519040;
        u1 u1Var = new u1(p0.o(u1.a, i, i2), p0.o(u1.b, i, i2));
        if (this.k && p0.a >= 23) {
            if (p0.a >= 23) {
                i0(u1Var);
            } else {
                h0(u1Var, T());
            }
        } else {
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void i() {
        boolean z;
        if (!this.Q && Y() && J()) {
            if (Y()) {
                if (J()) {
                    d0();
                    this.Q = true;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean j() {
        boolean z;
        int i;
        long l;
        if (Y() && this.i.i(V())) {
            i = this.i.i(V()) ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void k(int i) {
        int obj2;
        if (this.U != i) {
            this.U = i;
            obj2 = i != 0 ? 1 : 0;
            this.T = obj2;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long l(boolean z) {
        boolean z2;
        if (Y() && this.F) {
            if (this.F) {
            }
            return H(G(Math.min(this.i.d(z), obj1)));
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void m() {
        boolean z;
        if (this.W) {
            this.W = false;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void n(com.google.android.exoplayer2.audio.p p) {
        if (this.t.equals(p)) {
        }
        this.t = p;
        if (this.W) {
        }
        flush();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void o() {
        this.E = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void p() {
        int i;
        final int i3 = 1;
        i = p0.a >= 21 ? i3 : 0;
        g.f(i);
        g.f(this.T);
        if (!this.W) {
            this.W = i3;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void q() {
        boolean z;
        this.S = true;
        if (Y()) {
            this.i.v();
            this.s.play();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean r(ByteBuffer byteBuffer, long l2, int i3) {
        int i2;
        boolean cVar;
        boolean z2;
        boolean z;
        ByteBuffer remaining;
        int i6;
        com.google.android.exoplayer2.audio.DefaultAudioSink.c cVar3;
        com.google.android.exoplayer2.audio.DefaultAudioSink.e eVar;
        boolean cmp2;
        boolean z3;
        com.google.android.exoplayer2.audio.DefaultAudioSink.c cVar2;
        int cmp;
        int i4;
        long l3;
        long l4;
        int i5;
        int i;
        long unexpectedDiscontinuityException;
        long l;
        final Object obj = this;
        ByteBuffer byteBuffer2 = byteBuffer;
        long l5 = l2;
        final int i7 = obj21;
        ByteBuffer byteBuffer4 = obj.K;
        final int i11 = 1;
        final int i12 = 0;
        if (byteBuffer4 != null) {
            if (byteBuffer2 == byteBuffer4) {
                i2 = i11;
            } else {
                i2 = i12;
            }
        } else {
        }
        g.a(i2);
        final int i13 = 0;
        if (obj.q != null && !J()) {
            if (!J()) {
                return i12;
            }
            if (!obj.q.b(obj.r)) {
                d0();
                if (j()) {
                    return i12;
                }
                flush();
            } else {
                obj.r = obj.q;
                obj.q = i13;
                if (DefaultAudioSink.a0(obj.s) && obj.l != 3) {
                    if (obj.l != 3) {
                        obj.s.setOffloadEndOfStream();
                        i1 i1Var = cVar8.a;
                        obj.s.setOffloadDelayPadding(i1Var.T, i1Var.U);
                        obj.Z = i11;
                    }
                }
            }
            obj.F(l5);
        }
        if (!Y()) {
            W();
        }
        obj.n.a();
        cmp = 0;
        obj.G = Math.max(cmp, i4);
        obj.E = i12;
        obj.F = i12;
        if (obj.F && obj.k && p0.a >= 23) {
            obj.G = Math.max(cmp, i4);
            obj.E = i12;
            obj.F = i12;
            if (obj.k) {
                if (p0.a >= 23) {
                    obj.i0(obj.w);
                }
            }
            obj.F(l5);
            if (obj.S) {
                q();
            }
        }
        if (!obj.i.l(V())) {
            return i12;
        }
        if (obj.K == null) {
            i6 = byteBuffer.order() == ByteOrder.LITTLE_ENDIAN ? i11 : i12;
            g.a(i6);
            if (!byteBuffer.hasRemaining()) {
                return i11;
            }
            cVar3 = obj.r;
            cVar3 = DefaultAudioSink.P(cVar3.g, byteBuffer2);
            obj.D = cVar3;
            if (cVar3.c != 0 && obj.D == 0 && cVar3 == 0) {
                if (obj.D == 0) {
                    cVar3 = DefaultAudioSink.P(cVar3.g, byteBuffer2);
                    obj.D = cVar3;
                    if (cVar3 == 0) {
                        return i11;
                    }
                }
            }
            if (obj.u != null && !J()) {
                if (!J()) {
                    return i12;
                }
                obj.F(l5);
                obj.u = i13;
            }
            l9 += unexpectedDiscontinuityException;
            if (!obj.E && Long.compare(unexpectedDiscontinuityException, l) > 0) {
                if (Long.compare(unexpectedDiscontinuityException, l) > 0) {
                    unexpectedDiscontinuityException = new AudioSink.UnexpectedDiscontinuityException(l5, obj3, i, obj12);
                    obj.p.t(unexpectedDiscontinuityException);
                    obj.E = i11;
                }
            }
            if (obj.E && !J()) {
                if (!J()) {
                    return i12;
                }
                i = l5 - i;
                obj.G = l11 += i;
                obj.E = i12;
                obj.F(l5);
                z3 = obj.p;
                if (z3 != null && Long.compare(i, cmp) != 0) {
                    if (Long.compare(i, cmp) != 0) {
                        z3.e();
                    }
                }
            }
            if (cVar7.c == 0) {
                obj.z = l8 += l4;
            } else {
                obj.A = l7 += l4;
            }
            obj.K = byteBuffer2;
            obj.L = i7;
        }
        obj.e0(l5);
        if (!obj.K.hasRemaining()) {
            obj.K = i13;
            obj.L = i12;
            return i11;
        }
        if (obj.i.k(V())) {
            v.h("DefaultAudioSink", "Resetting stalled audio track");
            flush();
            return i11;
        }
        return i12;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        int i;
        int i2;
        com.google.android.exoplayer2.audio.AudioProcessor audioProcessor;
        flush();
        com.google.android.exoplayer2.audio.AudioProcessor[] objArr = this.f;
        final int i3 = 0;
        i = i3;
        while (i < objArr.length) {
            objArr[i].reset();
            i++;
        }
        com.google.android.exoplayer2.audio.AudioProcessor[] objArr2 = this.g;
        i2 = i3;
        while (i2 < objArr2.length) {
            objArr2[i2].reset();
            i2++;
        }
        this.S = i3;
        this.Y = i3;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void s(com.google.android.exoplayer2.audio.AudioSink.a audioSink$a) {
        this.p = a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public int t(i1 i1) {
        boolean z2;
        boolean z;
        int i3 = 0;
        int i4 = 2;
        if ("audio/raw".equals(i1.D) && !p0.g0(i1.S)) {
            if (!p0.g0(i1.S)) {
                StringBuilder stringBuilder = new StringBuilder(33);
                stringBuilder.append("Invalid PCM encoding: ");
                stringBuilder.append(i1.S);
                v.h("DefaultAudioSink", stringBuilder.toString());
                return i3;
            }
            int obj4 = i1.S;
            if (obj4 != i4 && this.c && obj4 == 4) {
                if (this.c) {
                    if (obj4 == 4) {
                    }
                }
                return 1;
            }
            return i4;
        }
        if (!this.Y && p0(i1, this.t)) {
            if (p0(i1, this.t)) {
                return i4;
            }
        }
        if (DefaultAudioSink.b0(i1, this.a)) {
            return i4;
        }
        return i3;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void u(i1 i1, int i2, int[] i3Arr3) {
        int i8;
        int i9;
        int i12;
        int i11;
        com.google.android.exoplayer2.audio.AudioProcessor.a aVar;
        int i5;
        int[] iArr;
        int i6;
        int i13;
        int i7;
        int i4;
        int i3;
        int i;
        int i14;
        com.google.android.exoplayer2.audio.AudioProcessor.a aVar2;
        com.google.android.exoplayer2.audio.AudioProcessor[] objArr;
        int i10;
        final Object obj = this;
        Object obj2 = i1;
        i9 = -1;
        int i19 = 0;
        if ("audio/raw".equals(obj2.D)) {
            g.a(p0.g0(obj2.S));
            i8 = p0.U(obj2.S, obj2.Q);
            i9 = o0(obj2.S) ? obj.g : obj.f;
            obj.e.o(obj2.T, obj2.U);
            if (p0.a < 21 && obj2.Q == 8 && i3Arr3 == null) {
                if (obj2.Q == 8) {
                    if (i3Arr3 == null) {
                        i11 = 6;
                        i7 = i19;
                        while (i7 < i11) {
                            new int[i11][i7] = i7;
                            i7++;
                        }
                    } else {
                        iArr = i3Arr3;
                    }
                } else {
                }
            } else {
            }
            obj.d.m(iArr);
            aVar = new AudioProcessor.a(obj2.R, obj2.Q, obj2.S);
            i4 = i19;
            while (i4 < i9.length) {
                com.google.android.exoplayer2.audio.AudioProcessor audioProcessor = i9[i4];
                if (audioProcessor.a() != 0) {
                }
                i4++;
                aVar = aVar2;
            }
            int i31 = aVar.c;
            i13 = aVar.a;
            i3 = p0.C(aVar.b);
            objArr = i9;
            i14 = i31;
            i5 = i24;
            i12 = i19;
            String str3 = ") for: ";
            if (i14 == 0) {
            } else {
                if (i3 == 0) {
                } else {
                    obj.Y = i19;
                    super(i1, i8, i12, i5, i13, i3, i14, i2, obj.k, objArr);
                    if (Y()) {
                        obj.q = cVar2;
                    } else {
                        obj.r = cVar2;
                    }
                }
                String valueOf2 = String.valueOf(i1);
                StringBuilder stringBuilder2 = new StringBuilder(length2 += 54);
                stringBuilder2.append("Invalid output channel config (mode=");
                stringBuilder2.append(i12);
                stringBuilder2.append(str3);
                stringBuilder2.append(valueOf2);
                AudioSink.ConfigurationException configurationException = new AudioSink.ConfigurationException(stringBuilder2.toString(), obj2);
                throw configurationException;
            }
            String valueOf3 = String.valueOf(i1);
            StringBuilder stringBuilder3 = new StringBuilder(length3 += 48);
            stringBuilder3.append("Invalid output encoding (mode=");
            stringBuilder3.append(i12);
            stringBuilder3.append(str3);
            stringBuilder3.append(valueOf3);
            AudioSink.ConfigurationException configurationException2 = new AudioSink.ConfigurationException(stringBuilder3.toString(), obj2);
            throw configurationException2;
        } else {
            com.google.android.exoplayer2.audio.AudioProcessor[] arr = new AudioProcessor[i19];
            int i22 = obj2.R;
            if (p0(obj2, obj.t)) {
                String str7 = obj2.D;
                g.e(str7);
                objArr = arr;
                i14 = i28;
                i5 = i8;
                i13 = i22;
                i12 = i35;
                i3 = i10;
            } else {
                Pair pair = DefaultAudioSink.O(obj2, obj.a);
                if (pair == null) {
                } else {
                    objArr = arr;
                    i14 = intValue2;
                    i3 = intValue;
                    i13 = i22;
                    i12 = i27;
                    i5 = i8;
                }
            }
        }
        String valueOf = String.valueOf(i1);
        StringBuilder stringBuilder = new StringBuilder(length += 37);
        stringBuilder.append("Unable to configure passthrough for: ");
        stringBuilder.append(valueOf);
        AudioSink.ConfigurationException configurationException3 = new AudioSink.ConfigurationException(stringBuilder.toString(), obj2);
        throw configurationException3;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void v() {
        boolean z;
        int i;
        if (p0.a < 25) {
            flush();
        }
        this.o.a();
        this.n.a();
        if (!Y()) {
        }
        g0();
        if (this.i.j()) {
            this.s.pause();
        }
        this.s.flush();
        this.i.r();
        com.google.android.exoplayer2.audio.DefaultAudioSink.c cVar = this.r;
        final int i9 = 1;
        i = cVar.c == 2 ? i9 : 0;
        this.i.t(this.s, i, cVar.g, cVar.d, cVar.h);
        this.F = i9;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void w(boolean z) {
        h0(M(), z);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void x(com.google.android.exoplayer2.audio.v v) {
        int i;
        int i2;
        if (this.V.equals(v)) {
        }
        i = v.a;
        final AudioTrack audioTrack = this.s;
        if (audioTrack != null && vVar2.a != i) {
            if (vVar2.a != i) {
                audioTrack.attachAuxEffect(i);
            }
            if (i != 0) {
                this.s.setAuxEffectSendLevel(v.b);
            }
        }
        this.V = v;
    }
}
