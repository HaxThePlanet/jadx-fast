package com.google.android.exoplayer2.mediacodec;

import android.app.ApplicationExitInfo;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodec.CryptoException;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.decoder.b;
import com.google.android.exoplayer2.decoder.d;
import com.google.android.exoplayer2.decoder.e;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.c0;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.j1;
import com.google.android.exoplayer2.u0;
import com.google.android.exoplayer2.util.a0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.n0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.w0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: classes2.dex */
public abstract class MediaCodecRenderer extends u0 {

    private static final byte[] Y0;
    private boolean A0;
    private boolean B0;
    private boolean C0;
    private final com.google.android.exoplayer2.mediacodec.q.b D;
    private boolean D0;
    private final com.google.android.exoplayer2.mediacodec.s E;
    private int E0 = 0;
    private final boolean F;
    private int F0 = 0;
    private final float G;
    private int G0 = 0;
    private final DecoderInputBuffer H;
    private boolean H0;
    private final DecoderInputBuffer I;
    private boolean I0;
    private final DecoderInputBuffer J;
    private boolean J0;
    private final com.google.android.exoplayer2.mediacodec.o K;
    private long K0 = -9223372036854775807L;
    private final l0<i1> L;
    private long L0 = -9223372036854775807L;
    private final ArrayList<Long> M;
    private boolean M0;
    private final MediaCodec.BufferInfo N;
    private boolean N0;
    private final long[] O;
    private boolean O0;
    private final long[] P;
    private boolean P0;
    private final long[] Q;
    private boolean Q0;
    private i1 R;
    private boolean R0;
    private i1 S;
    private boolean S0;
    private DrmSession T;
    private ExoPlaybackException T0;
    private DrmSession U;
    protected d U0;
    private MediaCrypto V;
    private long V0 = -9223372036854775807L;
    private boolean W;
    private long W0 = -9223372036854775807L;
    private long X = -9223372036854775807L;
    private int X0;
    private float Y = 1f;
    private float Z = 1f;
    private com.google.android.exoplayer2.mediacodec.q a0;
    private i1 b0;
    private MediaFormat c0;
    private boolean d0;
    private float e0 = -1f;
    private ArrayDeque<com.google.android.exoplayer2.mediacodec.r> f0;
    private com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException g0;
    private com.google.android.exoplayer2.mediacodec.r h0;
    private int i0 = 0;
    private boolean j0;
    private boolean k0;
    private boolean l0;
    private boolean m0;
    private boolean n0;
    private boolean o0;
    private boolean p0;
    private boolean q0;
    private boolean r0;
    private boolean s0;
    private com.google.android.exoplayer2.mediacodec.p t0;
    private long u0 = -9223372036854775807L;
    private int v0 = -1;
    private int w0 = -1;
    private ByteBuffer x0;
    private boolean y0;
    private boolean z0;

    public static class DecoderInitializationException extends Exception {

        public final com.google.android.exoplayer2.mediacodec.r codecInfo;
        public final String diagnosticInfo;
        public final com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException fallbackDecoderInitializationException;
        public final String mimeType;
        public final boolean secureDecoderRequired;
        public DecoderInitializationException(i1 i1, Throwable throwable2, boolean z3, int i4) {
            final String valueOf = String.valueOf(i1);
            StringBuilder stringBuilder = new StringBuilder(length += 36);
            stringBuilder.append("Decoder init failed: [");
            stringBuilder.append(i4);
            stringBuilder.append("], ");
            stringBuilder.append(valueOf);
            super(stringBuilder.toString(), throwable2, i1.D, z3, 0, MediaCodecRenderer.DecoderInitializationException.b(i4), 0);
        }

        public DecoderInitializationException(i1 i1, Throwable throwable2, boolean z3, com.google.android.exoplayer2.mediacodec.r r4) {
            String str;
            String str2 = r4.a;
            String valueOf = String.valueOf(i1);
            StringBuilder stringBuilder = new StringBuilder(i2 += length2);
            stringBuilder.append("Decoder init failed: ");
            stringBuilder.append(str2);
            stringBuilder.append(", ");
            stringBuilder.append(valueOf);
            if (p0.a >= 21) {
                str = MediaCodecRenderer.DecoderInitializationException.d(throwable2);
            } else {
                str = 0;
            }
            super(stringBuilder.toString(), throwable2, i1.D, z3, r4, str, 0);
        }

        private DecoderInitializationException(String string, Throwable throwable2, String string3, boolean z4, com.google.android.exoplayer2.mediacodec.r r5, String string6, com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException mediaCodecRenderer$DecoderInitializationException7) {
            super(string, throwable2);
            this.mimeType = string3;
            this.secureDecoderRequired = z4;
            this.codecInfo = r5;
            this.diagnosticInfo = string6;
            this.fallbackDecoderInitializationException = decoderInitializationException7;
        }

        static com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException a(com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException mediaCodecRenderer$DecoderInitializationException, com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException mediaCodecRenderer$DecoderInitializationException2) {
            return decoderInitializationException.c(decoderInitializationException2);
        }

        private static String b(int i) {
            String str;
            str = i < 0 ? "neg_" : "";
            StringBuilder stringBuilder = new StringBuilder(length += 71);
            stringBuilder.append("com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_");
            stringBuilder.append(str);
            stringBuilder.append(Math.abs(i));
            return stringBuilder.toString();
        }

        private com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException c(com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException mediaCodecRenderer$DecoderInitializationException) {
            super(getMessage(), getCause(), this.mimeType, this.secureDecoderRequired, this.codecInfo, this.diagnosticInfo, decoderInitializationException);
            return decoderInitializationException2;
        }

        private static String d(Throwable throwable) {
            if (throwable instanceof MediaCodec.CodecException != null) {
                return (MediaCodec.CodecException)throwable.getDiagnosticInfo();
            }
            return null;
        }
    }
    static {
        byte[] bArr = new byte[38];
        bArr = new byte[]{
            0, 0, 1, 103, 66, -64, 11, -38, 37, -112,
            0, 0, 1, 104, -50, 15, 19, 32, 0, 0,
            1, 101, -120, -124, 13, -50, 113, 24, -96, 0,
            47, -65, 28, 49, -61, 39, 93, 120
        };
        MediaCodecRenderer.Y0 = bArr;
    }

    public MediaCodecRenderer(int i, com.google.android.exoplayer2.mediacodec.q.b q$b2, com.google.android.exoplayer2.mediacodec.s s3, boolean z4, float f5) {
        super(i);
        this.D = b2;
        g.e(s3);
        this.E = (s)s3;
        this.F = z4;
        this.G = f5;
        this.H = DecoderInputBuffer.w();
        final int obj3 = 0;
        DecoderInputBuffer obj2 = new DecoderInputBuffer(obj3);
        this.I = obj2;
        obj2 = new DecoderInputBuffer(2);
        this.J = obj2;
        obj2 = new o();
        this.K = obj2;
        l0 obj4 = new l0();
        this.L = obj4;
        obj4 = new ArrayList();
        this.M = obj4;
        obj4 = new MediaCodec.BufferInfo();
        this.N = obj4;
        obj4 = 1065353216;
        obj4 = -9223372036854775807L;
        int obj6 = 10;
        this.O = new long[obj6];
        this.P = new long[obj6];
        this.Q = new long[obj6];
        obj2.t(obj3);
        obj2.c.order(ByteOrder.nativeOrder());
        obj2 = -1082130432;
        obj2 = -1;
    }

    private boolean E0() {
        int i;
        i = this.w0 >= 0 ? 1 : 0;
        return i;
    }

    private void F0(i1 i1) {
        String equals;
        com.google.android.exoplayer2.mediacodec.o obj3;
        f0();
        obj3 = i1.D;
        final int i = 1;
        if (!"audio/mp4a-latm".equals(obj3) && !"audio/mpeg".equals(obj3) && !"audio/opus".equals(obj3)) {
            if (!"audio/mpeg".equals(obj3)) {
                if (!"audio/opus".equals(obj3)) {
                    this.K.E(i);
                } else {
                    this.K.E(32);
                }
            } else {
            }
        } else {
        }
        this.A0 = i;
    }

    private void G0(com.google.android.exoplayer2.mediacodec.r r, MediaCrypto mediaCrypto2) {
        com.google.android.exoplayer2.mediacodec.q.b bVar;
        boolean z;
        int i4;
        int i;
        int i3;
        int i2;
        int i5;
        i1 i1Var;
        i1[] objArr;
        String concat;
        boolean z2;
        String valueOf;
        int length;
        boolean obj11;
        com.google.android.exoplayer2.mediacodec.q obj12;
        final String str = r.a;
        int i6 = p0.a;
        i2 = 23;
        if (i6 < i2) {
            i5 = i;
        } else {
            i5 = w0(this.Z, this.R, H());
        }
        int cmp = Float.compare(i5, f2);
        if (cmp <= 0) {
        } else {
            i = i5;
        }
        String str2 = "createCodec:";
        valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            concat = str2.concat(valueOf);
        } else {
            valueOf = new String(str2);
            concat = valueOf;
        }
        n0.a(concat);
        obj12 = A0(r, this.R, mediaCrypto2, i);
        if (this.Q0 && i6 >= i2) {
            if (i6 >= i2) {
                bVar = new l.b(i(), this.R0, this.S0);
                obj12 = bVar.b(obj12);
            } else {
                obj12 = this.D.a(obj12);
            }
        } else {
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        this.a0 = obj12;
        this.h0 = r;
        this.e0 = i;
        this.b0 = this.R;
        this.i0 = V(str);
        this.j0 = MediaCodecRenderer.W(str, this.b0);
        this.k0 = MediaCodecRenderer.b0(str);
        this.l0 = MediaCodecRenderer.d0(str);
        this.m0 = MediaCodecRenderer.Y(str);
        this.n0 = MediaCodecRenderer.Z(str);
        this.o0 = MediaCodecRenderer.X(str);
        this.p0 = MediaCodecRenderer.c0(str, this.b0);
        int i8 = 1;
        if (!MediaCodecRenderer.a0(r)) {
            if (v0()) {
                i4 = i8;
            } else {
                i4 = i3;
            }
        } else {
        }
        this.s0 = i4;
        this.D0 = i8;
        this.E0 = i8;
        if (obj12.b() && this.i0 != 0) {
            this.D0 = i8;
            this.E0 = i8;
            if (this.i0 != 0) {
                i3 = i8;
            }
            this.q0 = i3;
        }
        if ("c2.android.mp3.decoder".equals(r.a)) {
            obj11 = new p();
            this.t0 = obj11;
        }
        if (getState() == 2) {
            this.u0 = obj11 += length;
        }
        obj11 = this.U0;
        obj11.a = obj12 += i8;
        this.P0(str, elapsedRealtime2, i8);
    }

    private boolean H0(long l) {
        int i;
        int cmp;
        final int i2 = 0;
        i = i2;
        while (i < this.M.size()) {
            i++;
        }
        return i2;
    }

    private static boolean I0(java.lang.IllegalStateException illegalStateException) {
        int i2;
        int length;
        int i;
        java.lang.StackTraceElement[] obj3;
        if (p0.a >= 21 && MediaCodecRenderer.J0(illegalStateException)) {
            if (MediaCodecRenderer.J0(illegalStateException)) {
                return 1;
            }
        }
        obj3 = illegalStateException.getStackTrace();
        int i4 = 0;
        if (obj3.length > 0 && obj3[i4].getClassName().equals("android.media.MediaCodec")) {
            if (obj3[i4].getClassName().equals("android.media.MediaCodec")) {
            } else {
                i = i4;
            }
        } else {
        }
        return i;
    }

    private static boolean J0(java.lang.IllegalStateException illegalStateException) {
        return illegalStateException instanceof MediaCodec.CodecException;
    }

    private static boolean K0(java.lang.IllegalStateException illegalStateException) {
        if (illegalStateException instanceof MediaCodec.CodecException != null) {
            return (MediaCodec.CodecException)illegalStateException.isRecoverable();
        }
        return 0;
    }

    private void M0(MediaCrypto mediaCrypto, boolean z2) {
        Object queue;
        boolean peekFirst;
        int arrayDeque;
        boolean decoderInitializationException;
        final int i = 0;
        if (this.f0 == null) {
            queue = s0(z2);
            arrayDeque = new ArrayDeque();
            this.f0 = arrayDeque;
            if (this.F) {
                arrayDeque.addAll(queue);
            } else {
                if (!queue.isEmpty()) {
                    this.f0.add((r)queue.get(0));
                }
            }
            try {
                this.g0 = i;
                arrayDeque = -49998;
                MediaCodecRenderer.DecoderInitializationException empty = new MediaCodecRenderer.DecoderInitializationException(this.R, mediaCrypto, z2, arrayDeque);
                throw empty;
                if (this.f0.isEmpty()) {
                }
                while (this.a0 == null) {
                    peekFirst = this.f0.peekFirst();
                    G0(peekFirst, mediaCrypto);
                }
                peekFirst = this.f0.peekFirst();
                if (m1((r)peekFirst) == 0) {
                } else {
                }
                G0(peekFirst, mediaCrypto);
                decoderInitializationException = String.valueOf(empty);
                String str = String.valueOf(decoderInitializationException);
                str = str.length();
                str += 30;
                StringBuilder stringBuilder = new StringBuilder(str);
                str = "Failed to initialize decoder: ";
                stringBuilder.append(str);
                stringBuilder.append(decoderInitializationException);
                decoderInitializationException = stringBuilder.toString();
                str = "MediaCodecRenderer";
                v.i(str, decoderInitializationException, arrayDeque);
                decoderInitializationException = this.f0;
                decoderInitializationException.removeFirst();
                str = this.R;
                decoderInitializationException = new MediaCodecRenderer.DecoderInitializationException(str, arrayDeque, z2, empty);
                O0(decoderInitializationException);
                empty = this.g0;
                if (empty == null) {
                } else {
                }
                this.g0 = decoderInitializationException;
                empty = this.g0;
                empty = MediaCodecRenderer.DecoderInitializationException.a(empty, decoderInitializationException);
                this.g0 = empty;
                empty = this.f0;
                empty = empty.isEmpty();
                if (empty != null) {
                } else {
                }
                mediaCrypto = this.g0;
                throw mediaCrypto;
                this.f0 = i;
                MediaCodecRenderer.DecoderInitializationException obj7 = new MediaCodecRenderer.DecoderInitializationException(this.R, i, z2, -49999);
                throw obj7;
            } catch (Exception e) {
            }
        }
    }

    private boolean N0(c0 c0, i1 i12) {
        if (c0.c) {
            return 0;
        }
        MediaCrypto mediaCrypto = new MediaCrypto(c0.a, c0.b);
        mediaCrypto.release();
        return mediaCrypto.requiresSecureDecoderComponent(i12.D);
    }

    private void S() {
        DecoderInputBuffer buf;
        boolean z;
        DecoderInputBuffer buf2;
        int i;
        final int i4 = 1;
        g.f(m0 ^= i4);
        j1 j1Var = F();
        this.J.j();
        this.J.j();
        int i6 = 0;
        int i5 = Q(j1Var, this.J, i6);
        while (i5 != -5) {
            if (this.O0) {
            }
            this.J.u();
            this.J.j();
            i6 = 0;
            i5 = Q(j1Var, this.J, i6);
            z = this.R;
            g.e(z);
            this.S = z;
            S0(z, 0);
            this.O0 = i6;
        }
        R0(j1Var);
    }

    private boolean T(long l, long l2) {
        int i8;
        long l3;
        boolean z6;
        boolean z4;
        boolean z2;
        boolean z;
        com.google.android.exoplayer2.mediacodec.q qVar;
        int i2;
        ByteBuffer byteBuffer;
        int i3;
        int i4;
        int i5;
        long l4;
        boolean z5;
        boolean i7;
        i1 i6;
        int i;
        boolean z3;
        i1 i1Var;
        final Object obj2 = this;
        g.f(n0 ^= i6);
        com.google.android.exoplayer2.mediacodec.o oVar2 = obj2.K;
        l3 = l;
        if (obj2.K.D() && this.X0(l3, obj2, obj21, obj4, 0, oVar2.c, obj2.w0, 0, oVar2.C(), obj2.K.A(), obj11)) {
            oVar2 = obj2.K;
            l3 = l;
            if (this.X0(l3, obj2, obj21, obj4, 0, oVar2.c, obj2.w0, 0, oVar2.C(), obj2.K.A(), obj11)) {
                obj2.T0(obj2.K.B());
                obj2.K.j();
                i8 = 0;
                if (obj2.M0) {
                    obj2.N0 = true;
                    return i8;
                }
                int i12 = 1;
                if (obj2.B0) {
                    g.f(obj2.K.y(obj2.J));
                    obj2.B0 = i8;
                }
                if (obj2.C0 && obj2.K.D()) {
                    if (obj2.K.D()) {
                        return i12;
                    }
                    f0();
                    obj2.C0 = i8;
                    L0();
                    if (!obj2.A0) {
                        return i8;
                    }
                }
                S();
                if (obj2.K.D()) {
                    obj2.K.u();
                }
                if (!obj2.K.D() && !obj2.M0) {
                    if (!obj2.M0) {
                        if (obj2.C0) {
                            i = i12;
                        } else {
                            i = i8;
                        }
                    } else {
                    }
                } else {
                }
                return i;
            }
            return 0;
        }
        i8 = i7;
    }

    private int V(String string) {
        int equals;
        String startsWith;
        boolean startsWith2;
        Object obj4;
        equals = p0.a;
        startsWith = p0.d;
        if (equals <= 25 && "OMX.Exynos.avc.dec.secure".equals(string) && !startsWith.startsWith("SM-T585") && !startsWith.startsWith("SM-A510") && !startsWith.startsWith("SM-A520") && startsWith.startsWith("SM-J700")) {
            if ("OMX.Exynos.avc.dec.secure".equals(string)) {
                startsWith = p0.d;
                if (!startsWith.startsWith("SM-T585")) {
                    if (!startsWith.startsWith("SM-A510")) {
                        if (!startsWith.startsWith("SM-A520")) {
                            if (startsWith.startsWith("SM-J700")) {
                            }
                        }
                    }
                }
                return 2;
            }
        }
        if (equals < 24) {
            if (!"OMX.Nvidia.h264.decode".equals(string)) {
                obj4 = p0.b;
                if ("OMX.Nvidia.h264.decode.secure".equals(string) && !"flounder".equals(obj4) && !"flounder_lte".equals(obj4) && !"grouper".equals(obj4) && "tilapia".equals(obj4)) {
                    obj4 = p0.b;
                    if (!"flounder".equals(obj4)) {
                        if (!"flounder_lte".equals(obj4)) {
                            if (!"grouper".equals(obj4)) {
                                if ("tilapia".equals(obj4)) {
                                }
                            }
                        }
                    }
                }
            } else {
            }
            return 1;
        }
        return 0;
    }

    private static boolean W(String string, i1 i12) {
        int obj2;
        Object obj3;
        if (p0.a < 21 && i12.F.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(string)) {
            if (i12.F.isEmpty()) {
                obj2 = "OMX.MTK.VIDEO.DECODER.AVC".equals(string) ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    private void W0() {
        int i;
        final int g0 = this.G0;
        final int i2 = 1;
        if (g0 != i2) {
            if (g0 != 2) {
                if (g0 != 3) {
                    this.N0 = i2;
                    c1();
                } else {
                    a1();
                }
            } else {
                p0();
                r1();
            }
        } else {
            p0();
        }
    }

    private static boolean X(String string) {
        int startsWith;
        int obj2;
        if (p0.a < 21 && "OMX.SEC.mp3.dec".equals(string) && "samsung".equals(p0.c)) {
            if ("OMX.SEC.mp3.dec".equals(string)) {
                if ("samsung".equals(p0.c)) {
                    obj2 = p0.b;
                    if (!obj2.startsWith("baffin") && !obj2.startsWith("grand") && !obj2.startsWith("fortuna") && !obj2.startsWith("gprimelte") && !obj2.startsWith("j2y18lte")) {
                        if (!obj2.startsWith("grand")) {
                            if (!obj2.startsWith("fortuna")) {
                                if (!obj2.startsWith("gprimelte")) {
                                    if (!obj2.startsWith("j2y18lte")) {
                                        obj2 = obj2.startsWith("ms01") ? 1 : 0;
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
            } else {
            }
        } else {
        }
        return obj2;
    }

    private static boolean Y(String string) {
        boolean equals2;
        boolean equals;
        Object obj2;
        equals2 = p0.a;
        if (equals2 <= 23) {
            if (!"OMX.google.vorbis.decoder".equals(string)) {
                if (equals2 <= 19) {
                    equals2 = p0.b;
                    if (!"hb2000".equals(equals2)) {
                        if ("stvm8".equals(equals2)) {
                            if (!"OMX.amlogic.avc.decoder.awesome".equals(string)) {
                                obj2 = "OMX.amlogic.avc.decoder.awesome.secure".equals(string) ? 1 : 0;
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
        return obj2;
    }

    private void Y0() {
        int integer;
        boolean str;
        int i;
        final int i2 = 1;
        this.J0 = i2;
        MediaFormat mediaFormat = this.a0.d();
        i = 32;
        if (this.i0 != 0 && mediaFormat.getInteger("width") == i && mediaFormat.getInteger("height") == i) {
            i = 32;
            if (mediaFormat.getInteger("width") == i) {
                if (mediaFormat.getInteger("height") == i) {
                    this.r0 = i2;
                }
            }
        }
        if (this.p0) {
            mediaFormat.setInteger("channel-count", i2);
        }
        this.c0 = mediaFormat;
        this.d0 = i2;
    }

    private static boolean Z(String string) {
        int str;
        Object obj2;
        if (p0.a == 21 && "OMX.google.aac.decoder".equals(string)) {
            obj2 = "OMX.google.aac.decoder".equals(string) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    private boolean Z0(int i) {
        int obj4;
        j1 j1Var = F();
        this.H.j();
        obj4 = Q(j1Var, this.H, i |= 4);
        int i3 = 1;
        if (obj4 == -5) {
            R0(j1Var);
            return i3;
        }
        if (obj4 == -4 && this.H.p()) {
            if (this.H.p()) {
                this.M0 = i3;
                W0();
            }
        }
        return 0;
    }

    private static boolean a0(com.google.android.exoplayer2.mediacodec.r r) {
        String equals3;
        int equals2;
        boolean equals;
        Object obj3;
        equals3 = r.a;
        equals2 = p0.a;
        if (equals2 <= 25) {
            if (!"OMX.rk.video_decoder.avc".equals(equals3)) {
                if (equals2 <= 17) {
                    if (!"OMX.allwinner.video.decoder.avc".equals(equals3)) {
                        if (equals2 <= 29) {
                            if (!"OMX.broadcom.video_decoder.tunnel".equals(equals3) && !"OMX.broadcom.video_decoder.tunnel.secure".equals(equals3)) {
                                if (!"OMX.broadcom.video_decoder.tunnel.secure".equals(equals3)) {
                                    if ("Amazon".equals(p0.c) && "AFTS".equals(p0.d) && r.f) {
                                        if ("AFTS".equals(p0.d)) {
                                            obj3 = r.f ? 1 : 0;
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
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    private void a1() {
        b1();
        L0();
    }

    private static boolean b0(String string) {
        int startsWith;
        int equals;
        int obj2;
        startsWith = p0.a;
        equals = 18;
        if (startsWith >= equals) {
            if (startsWith == equals) {
                if (!"OMX.SEC.avc.dec".equals(string) && !"OMX.SEC.avc.dec.secure".equals(string)) {
                    if (!"OMX.SEC.avc.dec.secure".equals(string)) {
                        if (startsWith == 19 && p0.d.startsWith("SM-G800")) {
                            if (p0.d.startsWith("SM-G800")) {
                                if (!"OMX.Exynos.avc.dec".equals(string)) {
                                    if ("OMX.Exynos.avc.dec.secure".equals(string)) {
                                        obj2 = 1;
                                    } else {
                                        obj2 = 0;
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
        } else {
        }
        return obj2;
    }

    private static boolean c0(String string, i1 i12) {
        int i;
        boolean obj3;
        Object obj4;
        if (p0.a <= 18 && i12.Q == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(string)) {
            if (i12.Q == 1) {
                if ("OMX.MTK.AUDIO.DECODER.MP3".equals(string)) {
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private static boolean d0(String string) {
        int str;
        Object obj2;
        if (p0.a == 29 && "c2.android.aac.decoder".equals(string)) {
            obj2 = "c2.android.aac.decoder".equals(string) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    private void f0() {
        final int i = 0;
        this.C0 = i;
        this.K.j();
        this.J.j();
        this.B0 = i;
        this.A0 = i;
    }

    private void f1() {
        this.v0 = -1;
        buf.c = 0;
    }

    private boolean g0() {
        boolean z;
        final int i3 = 1;
        this.F0 = i3;
        if (this.H0 && !this.k0 && this.m0) {
            this.F0 = i3;
            if (!this.k0) {
                if (this.m0) {
                }
                this.G0 = i3;
            }
            this.G0 = 3;
            return 0;
        }
        return i3;
    }

    private void g1() {
        this.w0 = -1;
        this.x0 = 0;
    }

    private void h0() {
        int i;
        if (this.H0) {
            this.F0 = 1;
            this.G0 = 3;
        } else {
            a1();
        }
    }

    private void h1(DrmSession drmSession) {
        DrmSession.c(this.T, drmSession);
        this.T = drmSession;
    }

    private boolean i0() {
        boolean z;
        boolean z2;
        final int i3 = 1;
        this.F0 = i3;
        if (this.H0 && !this.k0 && this.m0) {
            this.F0 = i3;
            if (!this.k0) {
                if (this.m0) {
                }
                this.G0 = 2;
                return i3;
            }
            this.G0 = 3;
            return 0;
        }
        r1();
    }

    private boolean j0(long l, long l2) {
        int i2;
        boolean z4;
        ByteBuffer byteBuffer;
        boolean z5;
        int z6;
        boolean z3;
        boolean z8;
        boolean z;
        MediaCodec.BufferInfo buf;
        int i5;
        MediaCodec.BufferInfo buf2;
        com.google.android.exoplayer2.mediacodec.q size2;
        long l3;
        int size;
        long presentationTimeUs2;
        int cmp;
        com.google.android.exoplayer2.mediacodec.q qVar2;
        com.google.android.exoplayer2.mediacodec.q qVar;
        ByteBuffer byteBuffer2;
        int i4;
        int flags;
        int i;
        long presentationTimeUs;
        boolean z7;
        boolean z2;
        i1 i1Var;
        i1 i1Var2;
        Object obj4;
        int i3;
        final Object obj3 = this;
        final int i7 = 1;
        int i6 = 0;
        if (!E0()) {
            if (obj3.n0 && obj3.I0) {
                if (obj3.I0) {
                    i2 = obj3.a0.h(obj3.N);
                } else {
                    i2 = obj3.a0.h(obj3.N);
                }
            } else {
            }
            if (i2 < 0 && i2 == -2) {
                if (i2 == -2) {
                    Y0();
                    return i7;
                }
                if (obj3.s0) {
                    if (!obj3.M0) {
                        if (obj3.F0 == 2) {
                            W0();
                        }
                    } else {
                    }
                }
                return i6;
            }
            if (obj3.r0) {
                obj3.r0 = i6;
                obj3.a0.j(i2, i6);
                return i7;
            }
            buf2 = obj3.N;
            if (buf2.size == 0 && flags4 &= 4 != 0) {
                try {
                    if (flags4 &= 4 != 0) {
                    }
                    W0();
                    return i6;
                    obj3.w0 = i2;
                    byteBuffer = obj3.a0.o(i2);
                    obj3.x0 = byteBuffer;
                    if (byteBuffer != null) {
                    }
                    byteBuffer.position(buf8.offset);
                    MediaCodec.BufferInfo buf9 = obj3.N;
                    obj3.x0.limit(offset2 += size2);
                    z5 = obj3.N;
                    size2 = obj3.K0;
                } catch (java.lang.IllegalStateException ise) {
                }
                obj3.y0 = obj3.H0(buf3.presentationTimeUs);
                presentationTimeUs2 = buf10.presentationTimeUs;
                z6 = Long.compare(l0, presentationTimeUs2) == 0 ? i7 : i6;
                obj3.z0 = z6;
                obj3.s1(presentationTimeUs2);
            }
        }
        if (obj3.n0 && obj3.I0) {
            if (obj3.I0) {
                MediaCodec.BufferInfo buf4 = obj3.N;
                i3 = i6;
                z8 = this.X0(l, presentationTimeUs2, obj22, obj4, obj3.a0, obj3.x0, obj3.w0, buf4.flags, true, buf4.presentationTimeUs, obj11);
            } else {
                i3 = i6;
                MediaCodec.BufferInfo buf7 = obj3.N;
                z8 = this.X0(l, presentationTimeUs2, obj22, obj4, obj3.a0, obj3.x0, obj3.w0, buf7.flags, true, buf7.presentationTimeUs, obj11);
            }
        } else {
        }
        if (z8) {
            obj3.T0(buf5.presentationTimeUs);
            i1Var = flags2 &= 4 != 0 ? i7 : i3;
            g1();
            if (i1Var == 0) {
                return i7;
            }
            W0();
        }
        return i3;
    }

    private boolean k0(com.google.android.exoplayer2.mediacodec.r r, i1 i12, DrmSession drmSession3, DrmSession drmSession4) {
        UUID uuid;
        int i;
        boolean obj5;
        boolean obj7;
        final int i2 = 0;
        if (drmSession3 == drmSession4) {
            return i2;
        }
        final int i3 = 1;
        if (drmSession4 != null) {
            if (drmSession3 == null) {
            } else {
                if (p0.a < 23) {
                    return i3;
                }
                uuid = w0.e;
                if (!uuid.equals(drmSession3.d())) {
                    if (uuid.equals(drmSession4.d())) {
                    } else {
                        obj7 = z0(drmSession4);
                        if (obj7 == null) {
                            return i3;
                        }
                        if (!r.f && N0(obj7, i12)) {
                            if (N0(obj7, i12)) {
                                return i3;
                            }
                        }
                    }
                    return i2;
                }
            }
        }
        return i3;
    }

    private void k1(DrmSession drmSession) {
        DrmSession.c(this.U, drmSession);
        this.U = drmSession;
    }

    private boolean l1(long l) {
        int cmp;
        int obj5;
        if (Long.compare(l2, l3) != 0) {
            if (Long.compare(cmp, obj5) < 0) {
                obj5 = 1;
            } else {
                obj5 = 0;
            }
        } else {
        }
        return obj5;
    }

    private boolean o0() {
        Object qVar;
        int i8;
        int i4;
        int i5;
        boolean position;
        Object buf;
        boolean z;
        boolean z4;
        boolean z5;
        Object obj;
        int i17;
        int i14;
        int i7;
        com.google.android.exoplayer2.mediacodec.q size;
        int z6;
        boolean z3;
        long valueOf;
        int i11;
        int i15;
        int i12;
        boolean z2;
        int i2;
        com.google.android.exoplayer2.mediacodec.p pVar;
        int i;
        int i9;
        com.google.android.exoplayer2.mediacodec.q qVar2;
        int i6;
        int i16;
        int i13;
        int i10;
        int limit;
        int i3;
        qVar = this.a0;
        int i19 = 0;
        i7 = 2;
        if (qVar != null && this.F0 != i7) {
            i7 = 2;
            if (this.F0 != i7) {
                if (this.M0) {
                } else {
                    int i18 = qVar.g();
                    this.v0 = i18;
                    if (this.v0 < 0 && i18 < 0) {
                        i18 = qVar.g();
                        this.v0 = i18;
                        if (i18 < 0) {
                            return i19;
                        }
                        i14.c = this.a0.l(i18);
                        this.I.j();
                    }
                    int i22 = 1;
                    if (this.F0 == i22) {
                        if (this.s0) {
                        } else {
                            this.I0 = i22;
                            this.a0.n(this.v0, 0, 0, 0, obj9);
                            f1();
                        }
                        this.F0 = i7;
                        return i19;
                    }
                    if (this.q0) {
                        this.q0 = i19;
                        byte[] y0 = MediaCodecRenderer.Y0;
                        buf11.c.put(y0);
                        this.a0.n(this.v0, 0, y0.length, 0, obj8);
                        f1();
                        this.H0 = i22;
                        return i22;
                    }
                    if (this.E0 == i22) {
                        i8 = i19;
                        while (i8 < i1Var2.F.size()) {
                            buf16.c.put((byte[])i1Var3.F.get(i8));
                            i8++;
                        }
                        this.E0 = i7;
                    }
                    j1 j1Var = F();
                    i15 = Q(j1Var, this.I, i19);
                    if (j()) {
                        this.L0 = this.K0;
                    }
                    if (i15 == -3) {
                        return i19;
                    }
                    if (i15 == -5 && this.E0 == i7) {
                        if (this.E0 == i7) {
                            this.I.j();
                            this.E0 = i22;
                        }
                        R0(j1Var);
                        return i22;
                    }
                    if (this.I.p() && this.E0 == i7) {
                        if (this.E0 == i7) {
                            this.I.j();
                            this.E0 = i22;
                        }
                        this.M0 = i22;
                        if (!this.H0) {
                            W0();
                            return i19;
                        }
                        if (this.s0) {
                        } else {
                            this.I0 = i22;
                            this.a0.n(this.v0, 0, 0, 0, obj8);
                            f1();
                        }
                        return i19;
                    }
                    this.I.j();
                    if (!this.H0 && !this.I.q() && this.E0 == i7) {
                        if (!this.I.q()) {
                            this.I.j();
                            if (this.E0 == i7) {
                                this.E0 = i22;
                            }
                            return i22;
                        }
                    }
                    boolean z10 = this.I.v();
                    if (z10) {
                        buf14.b.b(buf2.c.position());
                    }
                    a0.b(buf8.c);
                    if (this.j0 && !z10 && buf9.c.position() == 0) {
                        if (!z10) {
                            a0.b(buf8.c);
                            if (buf9.c.position() == 0) {
                                return i22;
                            }
                            this.j0 = i19;
                        }
                    }
                    buf = this.I;
                    valueOf = buf.w;
                    pVar = this.t0;
                    if (pVar != null) {
                        valueOf = pVar.d(this.R, buf);
                        this.K0 = Math.max(this.K0, obj7);
                    }
                    final long l2 = valueOf;
                    if (this.I.o()) {
                        this.M.add(Long.valueOf(l2));
                    }
                    if (this.O0) {
                        this.L.a(l2, obj13);
                        this.O0 = i19;
                    }
                    this.K0 = Math.max(this.K0, i15);
                    this.I.u();
                    if (this.I.n()) {
                        D0(this.I);
                    }
                    V0(this.I);
                    if (z10) {
                        this.a0.c(this.v0, 0, obj.b, l2, obj13);
                    } else {
                        this.a0.n(this.v0, 0, buf7.c.limit(), l2, obj13);
                    }
                }
                f1();
                this.H0 = i22;
                this.E0 = i19;
                d u0 = this.U0;
                u0.c = i20 += i22;
                return i22;
            }
        }
        return i19;
    }

    private void p0() {
        try {
            this.a0.flush();
            d1();
            d1();
            throw th;
        }
    }

    protected static boolean p1(i1 i1) {
        Class<c0> obj;
        int obj1;
        obj1 = i1.W;
        if (obj1 != null) {
            if (c0.class.equals(obj1)) {
                obj1 = 1;
            } else {
                obj1 = 0;
            }
        } else {
        }
        return obj1;
    }

    private boolean q1(i1 i1) {
        int cmp;
        com.google.android.exoplayer2.mediacodec.q bundle;
        int i;
        int cmp2;
        i1 obj5;
        final int i3 = 1;
        if (p0.a < 23) {
            return i3;
        }
        if (this.a0 != null && this.G0 != 3) {
            if (this.G0 != 3) {
                if (getState() == 0) {
                } else {
                    obj5 = w0(this.Z, i1, H());
                    float f2 = this.e0;
                    if (Float.compare(f2, obj5) == 0) {
                        return i3;
                    }
                    int i4 = -1082130432;
                    if (Float.compare(obj5, i4) == 0) {
                        h0();
                        return 0;
                    }
                    if (Float.compare(f2, i4) == 0 && Float.compare(obj5, f3) > 0) {
                        if (Float.compare(obj5, f3) > 0) {
                        }
                        return i3;
                    }
                    bundle = new Bundle();
                    bundle.putFloat("operating-rate", obj5);
                    this.a0.e(bundle);
                    this.e0 = obj5;
                }
            }
        }
        return i3;
    }

    private void r1() {
        try {
            this.V.setMediaDrmSession(c0Var.b);
            h1(this.U);
            int i = 0;
            this.F0 = i;
            this.G0 = i;
            Throwable th = C(th, this.R, 6006);
            throw th;
        }
    }

    private List<com.google.android.exoplayer2.mediacodec.r> s0(boolean z) {
        List list;
        boolean empty;
        String str;
        StringBuilder stringBuilder;
        boolean obj5;
        list = y0(this.E, this.R, false);
        if (y0(this.E, this.R, z).isEmpty() && z && !list.isEmpty()) {
            if (z) {
                list = y0(this.E, this.R, false);
                if (!list.isEmpty()) {
                    obj5 = obj5.D;
                    String valueOf = String.valueOf(list);
                    stringBuilder = new StringBuilder(i += length2);
                    stringBuilder.append("Drm session requires secure decoder for ");
                    stringBuilder.append(obj5);
                    stringBuilder.append(", but no secure decoder available. Trying to proceed with ");
                    stringBuilder.append(valueOf);
                    stringBuilder.append(".");
                    v.h("MediaCodecRenderer", stringBuilder.toString());
                }
            }
        }
        return list;
    }

    private c0 z0(DrmSession drmSession) {
        boolean z;
        com.google.android.exoplayer2.drm.a0 obj4 = drmSession.g();
        if (obj4 != null) {
            if (!obj4 instanceof c0) {
            } else {
            }
            obj4 = String.valueOf(obj4);
            StringBuilder stringBuilder = new StringBuilder(length += 42);
            stringBuilder.append("Expecting FrameworkMediaCrypto but found: ");
            stringBuilder.append(obj4);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw C(illegalArgumentException, this.R, 6001);
        }
        return (c0)obj4;
    }

    @Override // com.google.android.exoplayer2.u0
    protected abstract com.google.android.exoplayer2.mediacodec.q.a A0(com.google.android.exoplayer2.mediacodec.r r, i1 i12, MediaCrypto mediaCrypto3, float f4);

    @Override // com.google.android.exoplayer2.u0
    protected final long B0() {
        return this.W0;
    }

    @Override // com.google.android.exoplayer2.u0
    protected float C0() {
        return this.Y;
    }

    @Override // com.google.android.exoplayer2.u0
    protected void D0(DecoderInputBuffer decoderInputBuffer) {
    }

    @Override // com.google.android.exoplayer2.u0
    protected void J() {
        this.R = 0;
        long l = -9223372036854775807L;
        this.V0 = l;
        this.W0 = l;
        this.X0 = 0;
        r0();
    }

    @Override // com.google.android.exoplayer2.u0
    protected void K(boolean z, boolean z2) {
        d obj1 = new d();
        this.U0 = obj1;
    }

    @Override // com.google.android.exoplayer2.u0
    protected void L(long l, boolean z2) {
        long[] lArr;
        long l2;
        boolean obj5;
        final int obj4 = 0;
        this.M0 = obj4;
        this.N0 = obj4;
        this.P0 = obj4;
        if (this.A0) {
            this.K.j();
            this.J.j();
            this.B0 = obj4;
        } else {
            q0();
        }
        final int obj6 = 1;
        if (this.L.l() > 0) {
            this.O0 = obj6;
        }
        this.L.c();
        obj5 = this.X0;
        if (obj5 != null) {
            this.W0 = this.P[obj5 + -1];
            this.V0 = this.O[obj5 -= obj6];
            this.X0 = obj4;
        }
    }

    @Override // com.google.android.exoplayer2.u0
    protected final void L0() {
        i1 qVar;
        String requiresSecureDecoderComponent;
        DrmSession drmSession;
        int mediaCrypto;
        int i;
        UUID uuid;
        byte[] bArr;
        if (this.a0 == null && !this.A0) {
            if (!this.A0) {
                qVar = this.R;
                if (qVar == null) {
                } else {
                    if (this.U == null && n1(qVar)) {
                        if (n1(qVar)) {
                            F0(this.R);
                        }
                    }
                    h1(this.U);
                    drmSession = this.T;
                    i = 1;
                    drmSession = z0(drmSession);
                    if (drmSession != null && this.V == null && drmSession == null && this.T.getError() != null) {
                        i = 1;
                        if (this.V == null) {
                            drmSession = z0(drmSession);
                            if (drmSession == null) {
                                if (this.T.getError() != null) {
                                }
                            }
                            mediaCrypto = new MediaCrypto(drmSession.a, drmSession.b);
                            this.V = mediaCrypto;
                            if (!drmSession.c && mediaCrypto.requiresSecureDecoderComponent(i1Var.D)) {
                                requiresSecureDecoderComponent = mediaCrypto.requiresSecureDecoderComponent(requiresSecureDecoderComponent) ? i : 0;
                            } else {
                            }
                            this.W = requiresSecureDecoderComponent;
                        }
                        if (c0.d) {
                            requiresSecureDecoderComponent = this.T.getState();
                            if (requiresSecureDecoderComponent == i) {
                            } else {
                                if (requiresSecureDecoderComponent != 4) {
                                }
                            }
                            com.google.android.exoplayer2.drm.DrmSession.DrmSessionException error = this.T.getError();
                            g.e(error);
                            throw C((DrmSession.DrmSessionException)error, this.R, error.errorCode);
                        }
                    }
                }
                M0(this.V, this.W);
            }
        }
    }

    @Override // com.google.android.exoplayer2.u0
    protected void M() {
        f0();
        b1();
        k1(0);
    }

    @Override // com.google.android.exoplayer2.u0
    protected void N() {
    }

    @Override // com.google.android.exoplayer2.u0
    protected void O() {
    }

    @Override // com.google.android.exoplayer2.u0
    protected abstract void O0(Exception exception);

    @Override // com.google.android.exoplayer2.u0
    protected void P(i1[] i1Arr, long l2, long l3) {
        int i;
        int i2;
        long[] str;
        int l4;
        int length;
        long l;
        long[] obj7;
        long obj8;
        l4 = -9223372036854775807L;
        i = 1;
        if (Long.compare(w0, l4) == 0) {
            if (Long.compare(l, l4) == 0) {
            } else {
                i = 0;
            }
            g.f(i);
            this.V0 = l2;
            this.W0 = obj10;
        } else {
            obj7 = this.X0;
            str = this.P;
            if (obj7 == str.length) {
                StringBuilder stringBuilder = new StringBuilder(65);
                stringBuilder.append("Too many stream changes, so dropping offset: ");
                stringBuilder.append(str[obj7 -= i]);
                v.h("MediaCodecRenderer", stringBuilder.toString());
            } else {
                this.X0 = obj7 += i;
            }
            int x0 = this.X0;
            this.O[x0 + -1] = l2;
            this.P[x0 + -1] = obj10;
            this.Q[x0 -= i] = this.K0;
        }
    }

    @Override // com.google.android.exoplayer2.u0
    protected abstract void P0(String string, long l2, long l3);

    @Override // com.google.android.exoplayer2.u0
    protected abstract void Q0(String string);

    @Override // com.google.android.exoplayer2.u0
    protected e R0(j1 j1) {
        int i3;
        int i5;
        int i;
        int i7;
        DrmSession drmSession;
        int i2;
        int i4;
        int i6;
        int i8;
        com.google.android.exoplayer2.mediacodec.q obj12;
        i3 = 1;
        this.O0 = i3;
        i1 i1Var = j1.b;
        g.e(i1Var);
        final i1 i1Var3 = i1Var;
        if (i1Var3.D == null) {
        } else {
            k1(j1.a);
            this.R = (i1)i1Var3;
            int i10 = 0;
            if (this.A0) {
                this.C0 = i3;
                return i10;
            }
            obj12 = this.a0;
            if (obj12 == null) {
                this.f0 = i10;
                L0();
                return i10;
            }
            com.google.android.exoplayer2.mediacodec.r rVar = this.h0;
            final i1 i1Var2 = this.b0;
            if (k0(rVar, i1Var3, this.T, this.U)) {
                h0();
                super(rVar.a, i1Var2, i1Var3, 0, 128);
                return obj12;
            }
            int i12 = 0;
            i = this.U != this.T ? i3 : i12;
            if (i != 0) {
                if (p0.a >= 23) {
                    i7 = i3;
                } else {
                    i7 = i12;
                }
            } else {
            }
            g.f(i7);
            e eVar3 = U(rVar, i1Var2, i1Var3);
            i4 = eVar3.d;
            final int i15 = 3;
            final int i16 = 2;
            if (i4 != 0) {
                if (i4 != i3) {
                    if (i4 != i16) {
                        if (i4 != i15) {
                        } else {
                            if (!q1(i1Var3)) {
                                i6 = i8;
                            } else {
                                this.b0 = i1Var3;
                                if (i != 0 && !i0()) {
                                    if (!i0()) {
                                        i6 = i16;
                                    } else {
                                        i6 = i12;
                                    }
                                } else {
                                }
                            }
                        }
                        obj12 = new IllegalStateException();
                        throw obj12;
                    }
                    if (!q1(i1Var3)) {
                    } else {
                        this.D0 = i3;
                        this.E0 = i3;
                        i4 = this.i0;
                        if (i4 != i16) {
                            if (i4 == i3 && i1Var3.I == i1Var2.I && i1Var3.J == i1Var2.J) {
                                if (i1Var3.I == i1Var2.I) {
                                    if (i1Var3.J == i1Var2.J) {
                                    } else {
                                        i3 = i12;
                                    }
                                } else {
                                }
                            } else {
                            }
                        }
                        this.q0 = i3;
                        this.b0 = i1Var3;
                        if (i != 0 && !i0()) {
                            if (!i0()) {
                            } else {
                            }
                        } else {
                        }
                    }
                } else {
                    if (!q1(i1Var3)) {
                    } else {
                        this.b0 = i1Var3;
                        if (i != 0) {
                            if (!i0()) {
                            } else {
                            }
                        } else {
                            if (!g0()) {
                            } else {
                            }
                        }
                    }
                }
            } else {
                h0();
            }
            if (eVar3.d != 0 && this.a0 == obj12 && this.G0 == i15) {
                if (this.a0 == obj12) {
                    if (this.G0 == i15) {
                    }
                }
                super(rVar.a, i1Var2, i1Var3, 0, i6);
                return obj12;
            }
            return eVar3;
        }
        obj12 = new IllegalArgumentException();
        throw C(obj12, i1Var3, 4005);
    }

    @Override // com.google.android.exoplayer2.u0
    protected abstract void S0(i1 i1, MediaFormat mediaFormat2);

    @Override // com.google.android.exoplayer2.u0
    protected void T0(long l) {
        int cmp;
        int i;
        long l2;
        int x0 = this.X0;
        while (x0 != 0) {
            i = 0;
            if (Long.compare(l, l2) >= 0) {
            }
            long[] lArr4 = this.O;
            this.V0 = lArr4[i];
            this.W0 = this.P[i];
            x0--;
            this.X0 = i2;
            int i3 = 1;
            System.arraycopy(lArr4, i3, lArr4, i, i2);
            long[] lArr = this.P;
            System.arraycopy(lArr, i3, lArr, i, this.X0);
            long[] lArr2 = this.Q;
            System.arraycopy(lArr2, i3, lArr2, i, this.X0);
            U0();
            x0 = this.X0;
        }
    }

    @Override // com.google.android.exoplayer2.u0
    protected abstract e U(com.google.android.exoplayer2.mediacodec.r r, i1 i12, i1 i13);

    @Override // com.google.android.exoplayer2.u0
    protected void U0() {
    }

    @Override // com.google.android.exoplayer2.u0
    protected abstract void V0(DecoderInputBuffer decoderInputBuffer);

    @Override // com.google.android.exoplayer2.u0
    protected abstract boolean X0(long l, long l2, com.google.android.exoplayer2.mediacodec.q q3, ByteBuffer byteBuffer4, int i5, int i6, int i7, long l8, boolean z9, boolean z10, i1 i111);

    @Override // com.google.android.exoplayer2.u0
    public boolean a() {
        int i;
        i1 cmp;
        long l;
        if (this.R != null) {
            if (!I() && !E0()) {
                if (!E0()) {
                    if (Long.compare(l2, l) != 0 && Long.compare(elapsedRealtime, l) < 0) {
                        i = Long.compare(elapsedRealtime, l) < 0 ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.u0
    public final int b(i1 i1) {
        try {
            return o1(this.E, i1);
            i1 = C(th, i1, 4002);
            throw i1;
        }
    }

    @Override // com.google.android.exoplayer2.u0
    protected void b1() {
        Throwable th;
        Object qVar;
        MediaCrypto mediaCrypto;
        final int i = 0;
        qVar = this.a0;
        if (qVar != null) {
            try {
                qVar.a();
                d u0 = this.U0;
                u0.b = i2++;
                Q0(rVar.a);
                this.a0 = i;
                MediaCrypto mediaCrypto2 = this.V;
                if (mediaCrypto2 != null) {
                }
                mediaCrypto2.release();
                this.V = i;
                h1(i);
                e1();
                this.V = obj0;
                h1(obj0);
                e1();
                throw th;
                this.a0 = obj0;
                mediaCrypto = this.V;
                if (mediaCrypto == null) {
                } else {
                }
                mediaCrypto.release();
                this.V = obj0;
                h1(obj0);
                e1();
                throw th;
                this.V = obj0;
                h1(obj0);
                e1();
                throw th;
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.google.android.exoplayer2.u0
    public boolean c() {
        return this.N0;
    }

    @Override // com.google.android.exoplayer2.u0
    protected void c1() {
    }

    @Override // com.google.android.exoplayer2.u0
    protected void d1() {
        f1();
        g1();
        long l = -9223372036854775807L;
        this.u0 = l;
        final int i = 0;
        this.I0 = i;
        this.H0 = i;
        this.q0 = i;
        this.r0 = i;
        this.y0 = i;
        this.z0 = i;
        this.M.clear();
        this.K0 = l;
        this.L0 = l;
        com.google.android.exoplayer2.mediacodec.p pVar = this.t0;
        if (pVar != null) {
            pVar.c();
        }
        this.F0 = i;
        this.G0 = i;
        this.E0 = this.D0;
    }

    @Override // com.google.android.exoplayer2.u0
    protected com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException e0(Throwable throwable, com.google.android.exoplayer2.mediacodec.r r2) {
        MediaCodecDecoderException mediaCodecDecoderException = new MediaCodecDecoderException(throwable, r2);
        return mediaCodecDecoderException;
    }

    @Override // com.google.android.exoplayer2.u0
    protected void e1() {
        d1();
        int i = 0;
        this.T0 = i;
        this.t0 = i;
        this.f0 = i;
        this.h0 = i;
        this.b0 = i;
        this.c0 = i;
        int i2 = 0;
        this.d0 = i2;
        this.J0 = i2;
        this.e0 = -1082130432;
        this.i0 = i2;
        this.j0 = i2;
        this.k0 = i2;
        this.l0 = i2;
        this.m0 = i2;
        this.n0 = i2;
        this.o0 = i2;
        this.p0 = i2;
        this.s0 = i2;
        this.D0 = i2;
        this.E0 = i2;
        this.W = i2;
    }

    @Override // com.google.android.exoplayer2.u0
    protected final void i1() {
        this.P0 = true;
    }

    @Override // com.google.android.exoplayer2.u0
    protected final void j1(ExoPlaybackException exoPlaybackException) {
        this.T0 = exoPlaybackException;
    }

    @Override // com.google.android.exoplayer2.u0
    public void l0(boolean z) {
        this.Q0 = z;
    }

    @Override // com.google.android.exoplayer2.u0
    public void m0(boolean z) {
        this.R0 = z;
    }

    @Override // com.google.android.exoplayer2.u0
    protected boolean m1(com.google.android.exoplayer2.mediacodec.r r) {
        return 1;
    }

    @Override // com.google.android.exoplayer2.u0
    public void n0(boolean z) {
        this.S0 = z;
    }

    @Override // com.google.android.exoplayer2.u0
    protected boolean n1(i1 i1) {
        return 0;
    }

    @Override // com.google.android.exoplayer2.u0
    protected abstract int o1(com.google.android.exoplayer2.mediacodec.s s, i1 i12);

    @Override // com.google.android.exoplayer2.u0
    public void p(float f, float f2) {
        this.Y = f;
        this.Z = f2;
        q1(this.b0);
    }

    @Override // com.google.android.exoplayer2.u0
    protected final boolean q0() {
        final boolean z = r0();
        if (z) {
            L0();
        }
        return z;
    }

    @Override // com.google.android.exoplayer2.u0
    protected boolean r0() {
        boolean z;
        final int i2 = 0;
        if (this.a0 == null) {
            return i2;
        }
        if (this.G0 != 3 && !this.k0) {
            if (!this.k0) {
                if (this.l0) {
                    if (this.J0 && this.m0 && this.I0) {
                        if (this.m0) {
                            if (this.I0) {
                            }
                        }
                    }
                } else {
                }
                p0();
                return i2;
            }
        }
        b1();
        return 1;
    }

    @Override // com.google.android.exoplayer2.u0
    protected final void s1(long l) {
        Object l0Var;
        Object obj2;
        boolean obj3;
        if ((i1)this.L.j(l) == null && this.d0) {
            if (this.d0) {
                obj2 = this.L.i();
            }
        }
        obj3 = 0;
        obj2 = obj2 != null ? 1 : obj3;
        if (obj2 == null) {
            if (this.d0 && this.S != null) {
                if (this.S != null) {
                    S0(this.S, this.c0);
                    this.d0 = obj3;
                }
            }
        } else {
        }
    }

    @Override // com.google.android.exoplayer2.u0
    public final int t() {
        return 8;
    }

    @Override // com.google.android.exoplayer2.u0
    protected final com.google.android.exoplayer2.mediacodec.q t0() {
        return this.a0;
    }

    @Override // com.google.android.exoplayer2.u0
    public void u(long l, long l2) {
        boolean z;
        i1 i1Var;
        String elapsedRealtime;
        boolean str;
        long obj6;
        d obj8;
        int obj9;
        if (this.P0) {
            this.P0 = false;
            W0();
        }
        ExoPlaybackException t0 = this.T0;
        if (t0 != null) {
        } else {
            if (this.N0) {
                c1();
            }
            if (this.R == null && !Z0(2)) {
                if (!Z0(2)) {
                }
            }
            L0();
            if (this.A0) {
                n0.a("bypassRender");
                while (T(l, l2) != null) {
                }
                n0.c();
            } else {
                if (this.a0 != null) {
                    elapsedRealtime = SystemClock.elapsedRealtime();
                    n0.a("drainAndFeed");
                    try {
                        while (j0(l, l2)) {
                            if (l1(elapsedRealtime) != null) {
                            }
                        }
                        if (l1(elapsedRealtime) != null) {
                        }
                        while (o0()) {
                            if (l1(elapsedRealtime) != 0) {
                            }
                        }
                        if (l1(elapsedRealtime) != 0) {
                        }
                        n0.c();
                        obj8 = this.U0;
                        obj8.d = obj9 += obj6;
                        Z0(1);
                        this.U0.c();
                        l2 = MediaCodecRenderer.I0(l);
                        if (l2 == 0) {
                        } else {
                        }
                        O0(l);
                        l2 = p0.a;
                        obj8 = 21;
                        l2 = MediaCodecRenderer.K0(l);
                        if (l2 >= obj8 && l2 != 0) {
                        }
                        l2 = MediaCodecRenderer.K0(l);
                        if (l2 != 0) {
                        }
                        z = obj0;
                        if (!z) {
                        } else {
                        }
                        b1();
                        l2 = u0();
                        l = e0(l, l2);
                        l2 = this.R;
                        obj8 = 4003;
                        l = D(l, l2, z, obj8);
                        throw l;
                        throw l;
                        this.T0 = 0;
                        throw t0;
                    }
                } else {
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.u0
    protected final com.google.android.exoplayer2.mediacodec.r u0() {
        return this.h0;
    }

    @Override // com.google.android.exoplayer2.u0
    protected boolean v0() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.u0
    protected abstract float w0(float f, i1 i12, i1[] i13Arr3);

    @Override // com.google.android.exoplayer2.u0
    protected final MediaFormat x0() {
        return this.c0;
    }

    protected abstract List<com.google.android.exoplayer2.mediacodec.r> y0(com.google.android.exoplayer2.mediacodec.s s, i1 i12, boolean z3);
}
