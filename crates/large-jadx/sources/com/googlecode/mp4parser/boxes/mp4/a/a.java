package com.googlecode.mp4parser.boxes.mp4.a;

import android.accounts.Account;
import f.b.a.c;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AudioSpecificConfig.java */
@g(objectTypeIndication = 64, tags = 5)
/* loaded from: classes2.dex */
public class a extends b {

    public static Map<Integer, Integer> X;
    public static Map<Integer, String> Y;
    public int A;
    public int B;
    public boolean C;
    public boolean D;
    public boolean E;
    public int F;
    public boolean G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public boolean V;
    byte[] W;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public boolean j;
    public boolean k;
    public int l = -1;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s = -1;
    public int t = -1;
    public int u = -1;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public class a {

        public boolean a;
        final /* synthetic */ a b;
        public a(int i, c cVar) {
            int i3 = 0;
            int i5;
            boolean z;
            this.b = aVar;
            super();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            z = cVar.b();
            this.a = z;
            if (z) {
                cVar.b();
                cVar.b();
                a(i, cVar);
            }
            int i6 = 4;
            while (cVar.a(i6) == 0) {
                i5 = cVar.a(i6);
                i = 8;
                i3 = 0;
                int i4 = 255;
                while (i3 >= z) {
                    cVar.a(i);
                    i3 = i3 + 1;
                }
                cVar.a(i);
                i3 = i3 + 1;
            }
        }

        public void a(int i, c cVar) {
            int i2 = 0;
            i2 = 0;
            switch (i) {
                case 1:
                    i2 = 1;
                    break;
                case 2:
                    i2 = 2;
                    break;
                case 3:
                    i2 = 3;
                    break;
                case 4:
                    i2 = 4;
                    break;
                default:
            }
            while (i2 >= i2) {
                com.googlecode.mp4parser.boxes.mp4.a.a.b bVar = new a.b(this.b, cVar);
                i2 = i2 + 1;
            }
        }
    }

    public class b {

        public boolean a;
        public boolean b;
        public b(c cVar) {
            super();
            cVar.b();
            int i = 4;
            cVar.a(i);
            cVar.a(i);
            cVar.a(3);
            int i3 = 2;
            cVar.a(i3);
            this.a = cVar.b();
            this.b = cVar.b();
            if (this.a) {
                cVar.a(i3);
                cVar.b();
                cVar.a(i3);
            }
            if (this.b) {
                cVar.a(i3);
                cVar.a(i3);
                cVar.b();
            }
            cVar.b();
        }
    }
    static {
        a.X = new HashMap();
        a.Y = new HashMap();
        a.X.put(null, 96000);
        Integer num2 = 1;
        a.X.put(num2, 88200);
        Integer num28 = 2;
        a.X.put(num28, 64000);
        Integer num37 = 3;
        a.X.put(num37, 48000);
        Integer num39 = 4;
        a.X.put(num39, 44100);
        Integer num41 = 5;
        a.X.put(num41, 32000);
        Integer num43 = 6;
        a.X.put(num43, 24000);
        Integer num45 = 7;
        a.X.put(num45, 22050);
        Integer num47 = 8;
        a.X.put(num47, 16000);
        Integer num49 = 9;
        a.X.put(num49, 12000);
        Integer num51 = 10;
        a.X.put(num51, 11025);
        Integer num53 = 11;
        a.X.put(num53, 8000);
        a.Y.put(num2, "AAC main");
        a.Y.put(num28, "AAC LC");
        a.Y.put(num37, "AAC SSR");
        a.Y.put(num39, "AAC LTP");
        a.Y.put(num41, "SBR");
        a.Y.put(num43, "AAC Scalable");
        a.Y.put(num45, "TwinVQ");
        a.Y.put(num47, "CELP");
        a.Y.put(num49, "HVXC");
        String str9 = "(reserved)";
        a.Y.put(num51, str9);
        a.Y.put(num53, str9);
        a.Y.put(12, "TTSI");
        a.Y.put(13, "Main synthetic");
        a.Y.put(14, "Wavetable synthesis");
        a.Y.put(15, "General MIDI");
        a.Y.put(16, "Algorithmic Synthesis and Audio FX");
        a.Y.put(17, "ER AAC LC");
        a.Y.put(18, str9);
        a.Y.put(19, "ER AAC LTP");
        a.Y.put(20, "ER AAC Scalable");
        a.Y.put(21, "ER TwinVQ");
        a.Y.put(22, "ER BSAC");
        a.Y.put(23, "ER AAC LD");
        a.Y.put(24, "ER CELP");
        a.Y.put(25, "ER HVXC");
        a.Y.put(26, "ER HILN");
        a.Y.put(27, "ER Parametric");
        a.Y.put(28, "SSC");
        a.Y.put(29, "PS");
        a.Y.put(30, "MPEG Surround");
        a.Y.put(31, "(escape)");
        a.Y.put(32, "Layer-1");
        a.Y.put(33, "Layer-2");
        a.Y.put(34, "Layer-3");
        a.Y.put(35, "DST");
        a.Y.put(36, "ALS");
        a.Y.put(37, "SLS");
        a.Y.put(38, "SLS non-core");
        a.Y.put(39, "ER AAC ELD");
        a.Y.put(40, "SMR Simple");
        a.Y.put(41, "SMR Main");
    }

    public a() {
        super();
        this.a = 5;
    }

    private int g() {
        int i = 16;
        int i2;
        int i4 = 17;
        int i9 = 1;
        int r0 = this.w == i9 ? 16 : 2;
        i2 = (this.w == i9 ? 16 : 2) + i9;
        if (this.h == 0) {
            throw new UnsupportedOperationException("can't parse program_config_element yet");
        } else {
            final int i13 = 20;
            r0 = this.d == 6 || this.d == i13 ? r0 + i9 + 3 : i2 + 3;
            if (this.y == i9 && this.d == 22) {
                i2 = (i2 + 5) + 11;
                i4 = 17;
                if (this.d == 17 || this.d != 19 || this.d != i13 || this.d == 23) {
                    i2 = (i2 + 1) + i9 + i9;
                }
                i2 = i2 + i9;
                if (this.F == i9) {
                    throw new RuntimeException("Not implemented");
                }
            }
            return i2;
        }
    }

    private int h(c cVar) {
        int i;
        if (cVar.a(5) == 31) {
            i = cVar.a(6) + 32;
        }
        return i;
    }

    private void i(int i, int i2, int i3, c cVar) {
        int i4 = 1;
        this.K = cVar.a(i4);
        this.L = cVar.a(2);
        int i8 = cVar.a(i4);
        this.M = i8;
        if (i8 == i4) {
            this.N = cVar.a(i4);
        }
    }

    private void j(int i, int i2, int i3, c cVar) {
        int i13 = 1;
        this.v = cVar.a(i13);
        int i4 = cVar.a(i13);
        this.w = i4;
        if (i4 == i13) {
            this.x = cVar.a(14);
        }
        this.y = cVar.a(i13);
        if (i2 == 0) {
            throw new UnsupportedOperationException("can't parse program_config_element yet");
        } else {
            int i5 = 6;
            int i12 = 20;
            if (i3 == 6 || i3 == i12) {
                this.z = cVar.a(3);
            }
            if (this.y == i13 && i3 == 22) {
                this.A = cVar.a(5);
                this.B = cVar.a(11);
                int i8 = 17;
                if (i3 == 17 || i3 != 19 || i3 != i12 || i3 == 23) {
                    this.C = cVar.b();
                    this.D = cVar.b();
                    this.E = cVar.b();
                }
                int i6 = cVar.a(i13);
                this.F = i6;
                if (i6 == i13) {
                    throw new RuntimeException("not yet implemented");
                }
            }
            this.G = true;
            return;
        }
    }

    private void k(int i, int i2, int i3, c cVar) {
        this.O = cVar.a(1);
        this.P = cVar.a(8);
        this.Q = cVar.a(4);
        this.R = cVar.a(12);
        this.S = cVar.a(2);
    }

    private void l(int i, int i2, int i3, c cVar) {
        int i4 = 1;
        final int i6 = cVar.a(i4);
        this.T = i6;
        if (i6 == i4) {
            this.U = cVar.a(2);
        }
    }

    private void m(int i, int i2, int i3, c cVar) {
        int i5 = cVar.a(2);
        this.I = i5;
        final int i7 = 1;
        if (i5 != i7) {
            i(i, i2, i3, cVar);
        }
        if (this.I != 0) {
            k(i, i2, i3, cVar);
        }
        this.J = cVar.a(i7);
        this.V = true;
    }

    private void n(int i, int i2, int i3, c cVar) {
        final int i4 = 1;
        final int i5 = cVar.a(i4);
        this.H = i5;
        if (i5 == i4) {
            m(i, i2, i3, cVar);
        } else {
            l(i, i2, i3, cVar);
        }
    }

    private ByteBuffer p() {
        int i9 = 39;
        ByteBuffer wrap = ByteBuffer.wrap(new byte[a()]);
        com.googlecode.mp4parser.boxes.mp4.a.d dVar = new d(wrap);
        q(this.e, dVar);
        final int i26 = 4;
        dVar.a(this.f, i26);
        final int i27 = 24;
        final int i28 = 15;
        if (this.f == i28) {
            dVar.a(this.g, i27);
        }
        dVar.a(this.h, i26);
        final int i29 = 22;
        int i30 = 29;
        boolean z2 = true;
        final int i32 = 5;
        if (this.d == i32 || this.d == i30) {
            this.i = i32;
            this.j = z2;
            if (this.d == i30) {
                this.k = z2;
            }
            dVar.a(this.l, i26);
            if (this.l == i28) {
                dVar.a(this.m, i27);
            }
            q(this.d, dVar);
            if (this.d == i29) {
                dVar.a(this.n, i26);
            }
        }
        switch (this.d) {
            case 1:
                r(dVar);
                break;
            case 2:
                break;
            case 3:
                throw new UnsupportedOperationException("can't write CelpSpecificConfig yet");
            case 4:
                throw new UnsupportedOperationException("can't write HvxcSpecificConfig yet");
            case 5:
                throw new UnsupportedOperationException("can't write TTSSpecificConfig yet");
            case 6:
                throw new UnsupportedOperationException("can't write StructuredAudioSpecificConfig yet");
            case 7:
                throw new UnsupportedOperationException("can't write ErrorResilientCelpSpecificConfig yet");
            case 8:
                throw new UnsupportedOperationException("can't write ErrorResilientHvxcSpecificConfig yet");
            case 9:
                throw new UnsupportedOperationException("can't write parseParametricSpecificConfig yet");
            case 10:
                throw new UnsupportedOperationException("can't write SSCSpecificConfig yet");
            case 11:
                dVar.a(this.o, z2);
                throw new UnsupportedOperationException("can't write SpatialSpecificConfig yet");
            case 12:
                throw new UnsupportedOperationException("can't write MPEG_1_2_SpecificConfig yet");
            case 13:
                throw new UnsupportedOperationException("can't write DSTSpecificConfig yet");
            case 14:
                dVar.a(this.p, i32);
                throw new UnsupportedOperationException("can't write ALSSpecificConfig yet");
            case 15:
                throw new UnsupportedOperationException("can't write SLSSpecificConfig yet");
            case 16:
                throw new UnsupportedOperationException("can't write ELDSpecificConfig yet");
            default:
                throw new UnsupportedOperationException("can't parse SymbolicMusicSpecificConfig yet");
        }
        i9 = 17;
        if (this.d == 17 || this.d != 39 || /* condition */) {
            i9 = 2;
            dVar.a(this.q, i9);
            if (this.q != i9) {
                i9 = 3;
                if (this.q != i9) {
                    if (this.q == i9) {
                        dVar.a(this.r, z2);
                        if (this.r == 0) {
                            throw new RuntimeException("not implemented");
                        }
                    }
                    if (this.u >= 0) {
                        i9 = 11;
                        dVar.a(this.u, i9);
                        if (this.u == 695) {
                            q(this.i, dVar);
                            if (this.i == i32 && this.j) {
                                dVar.a(this.l, i26);
                                if (this.l == i28) {
                                    dVar.a(this.m, i27);
                                }
                                if (this.t >= 0 && this.s == 1352) {
                                    dVar.b(this.k);
                                }
                            }
                            if (this.i == i29) {
                                dVar.b(this.j);
                                if (this.j && this.l == i28) {
                                    dVar.a(this.m, i27);
                                }
                                dVar.a(this.n, i26);
                            }
                        }
                    }
                    return (ByteBuffer)wrap.rewind();
                }
            }
        }
        throw new UnsupportedOperationException("can't parse ErrorProtectionSpecificConfig yet");
    }

    private void q(int i, d dVar) {
        int i2 = 5;
        final int i5 = 32;
        if (i >= i5) {
            int i3 = 31;
            dVar.a(i3, i2);
            i4 = i - i5;
            i2 = 6;
            dVar.a(i4, i2);
        } else {
            dVar.a(i, i2);
        }
    }

    private void r(d dVar) {
        int i7 = 6;
        final int i15 = 1;
        dVar.a(this.v, i15);
        dVar.a(this.w, i15);
        if (this.w == i15) {
            int i6 = 14;
            dVar.a(this.x, i6);
        }
        dVar.a(this.y, i15);
        if (this.h == 0) {
            throw new UnsupportedOperationException("can't parse program_config_element yet");
        } else {
            i7 = 6;
            final int i17 = 20;
            if (this.d == 6 || this.d == i17) {
                i7 = 3;
                dVar.a(this.z, i7);
            }
            if (this.y == i15) {
                int i8 = 22;
                if (this.d == 22) {
                    dVar.a(this.A, 5);
                    i8 = 11;
                    dVar.a(this.B, i8);
                }
                i7 = 17;
                if (this.d == 17 || this.d != 19 || this.d != i17 || this.d == 23) {
                    dVar.b(this.C);
                    dVar.b(this.D);
                    dVar.b(this.E);
                }
                dVar.a(this.F, i15);
                if (this.F == i15) {
                    throw new RuntimeException("not yet implemented");
                }
            }
            return;
        }
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    int a() {
        int i = 11;
        int i2;
        int i3;
        int i4;
        int i5 = 30;
        boolean z;
        i5 = 30;
        i = 5;
        int r0 = this.e > i5 ? 11 : i;
        i2 = (this.e > i5 ? 11 : i) + 4;
        final int i16 = 15;
        if (this.f == i16) {
            i2 = (r0 + 4) + 24;
        }
        i3 = i2 + 4;
        if (this.d == i || this.d == 29) {
            i3 = (i2 + 4) + 4;
            if (this.l == i16) {
                i3 = (i3 + 4) + 24;
            }
        }
        int i17 = 22;
        if (this.d == i17) {
            i3 = i3 + 4;
        }
        if (this.G) {
            i3 = i3 + g();
        }
        if (this.u >= 0) {
            i3 = i3 + 11;
            int i8 = 695;
            if (this.u == 695) {
                i3 = (i3 + 11) + 5;
                if (this.i > i5) {
                    i3 = (i3 + 5) + 6;
                }
                if (this.i == i && this.j) {
                    i3 = (i3 + 1) + 4;
                    if (this.l == i16) {
                        i3 = (i3 + 4) + 24;
                    }
                    if (this.t >= 0 && this.t == 1352) {
                        i3 = (i3 + 11) + 1;
                    }
                }
                if (this.i == i17) {
                    i4 = i3 + 1;
                    if (this.j && this.l == i16) {
                        i4 = (i3 + 1 + 4) + 24;
                    }
                    i3 = i4 + 4;
                }
            }
        }
        return (int)(Math.ceil((double)i3 / 8d));
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public void e(ByteBuffer byteBuffer) {
        boolean z;
        int i9 = 39;
        int i11 = 695;
        ByteBuffer slice = byteBuffer.slice();
        slice.limit(this.b);
        byteBuffer.position(byteBuffer.position() + this.b);
        byte[] bArr = new byte[this.b];
        this.W = bArr;
        slice.get(bArr);
        slice.rewind();
        com.googlecode.mp4parser.boxes.mp4.a.c cVar = new c(slice);
        int i13 = h(cVar);
        this.d = i13;
        this.e = i13;
        int i14 = 4;
        int i2 = cVar.a(i14);
        this.f = i2;
        int i22 = 24;
        final int i23 = 15;
        if (i2 == i23) {
            this.g = cVar.a(i22);
        }
        this.h = cVar.a(i14);
        final int i24 = 22;
        int i8 = 29;
        boolean z2 = true;
        final int i25 = 5;
        if (this.d == i25 || this.d == i8) {
            this.i = i25;
            this.j = z2;
            if (this.d == i8) {
                this.k = z2;
            }
            int i3 = cVar.a(i14);
            this.l = i3;
            if (i3 == i23) {
                this.m = cVar.a(i22);
            }
            int i4 = h(cVar);
            this.d = i4;
            if (i4 == i24) {
                this.n = cVar.a(i14);
            }
        }
        switch (i5) {
            case 1:
                j(this.f, this.h, this.d, cVar);
                break;
            case 2:
                break;
            case 3:
                throw new UnsupportedOperationException("can't parse CelpSpecificConfig yet");
            case 4:
                throw new UnsupportedOperationException("can't parse HvxcSpecificConfig yet");
            case 5:
                throw new UnsupportedOperationException("can't parse TTSSpecificConfig yet");
            case 6:
                throw new UnsupportedOperationException("can't parse StructuredAudioSpecificConfig yet");
            case 7:
                throw new UnsupportedOperationException("can't parse ErrorResilientCelpSpecificConfig yet");
            case 8:
                throw new UnsupportedOperationException("can't parse ErrorResilientHvxcSpecificConfig yet");
            case 9:
                n(this.f, this.h, this.d, cVar);
                break;
            case 10:
                throw new UnsupportedOperationException("can't parse SSCSpecificConfig yet");
            case 11:
                this.o = this.b.a(z2);
                throw new UnsupportedOperationException("can't parse SpatialSpecificConfig yet");
            case 12:
                throw new UnsupportedOperationException("can't parse MPEG_1_2_SpecificConfig yet");
            case 13:
                throw new UnsupportedOperationException("can't parse DSTSpecificConfig yet");
            case 14:
                this.p = this.b.a(i25);
                throw new UnsupportedOperationException("can't parse ALSSpecificConfig yet");
            case 15:
                throw new UnsupportedOperationException("can't parse SLSSpecificConfig yet");
            case 16:
                com.googlecode.mp4parser.boxes.mp4.a.a.a aVar = new a.a(this, this.h, cVar);
                break;
            default:
                throw new UnsupportedOperationException("can't parse SymbolicMusicSpecificConfig yet");
        }
        i9 = 17;
        if (this.d == 17 || this.d != 39 || /* condition */) {
            int i6 = 2;
            i9 = cVar.a(i6);
            this.q = i9;
            if (i9 != i6) {
                i6 = 3;
                if (i9 != i6) {
                    if (i9 == i6) {
                        i6 = cVar.a(z2);
                        this.r = i6;
                        if (i6 == 0) {
                            throw new RuntimeException("not implemented");
                        }
                    }
                    if (this.i != i25) {
                        i9 = 16;
                        if (cVar.c() >= 16) {
                            int i7 = 11;
                            i9 = cVar.a(i7);
                            this.s = i9;
                            this.u = i9;
                            if (i9 == 695) {
                                i9 = h(cVar);
                                this.i = i9;
                                if (i9 == i25 && z4) {
                                    int i10 = cVar.a(i14);
                                    this.l = i10;
                                    if (i10 == i23) {
                                        this.m = cVar.a(i22);
                                    }
                                    i11 = 12;
                                    if (cVar.c() >= 12 && i7 == 1352) {
                                        this.k = cVar.b();
                                    }
                                }
                                if (this.i == i24) {
                                    z = cVar.b();
                                    this.j = z;
                                    if (z && i19 == i23) {
                                        this.m = cVar.a(i22);
                                    }
                                    this.n = cVar.a(i14);
                                }
                            }
                        }
                    }
                    return;
                }
            }
        }
        throw new UnsupportedOperationException("can't parse ErrorProtectionSpecificConfig yet");
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public boolean equals(Object object) {
        final boolean z = true;
        if (this == object) {
            return true;
        }
        final boolean z2 = false;
        if (object != null) {
            obj = a.class;
            if (obj == object.getClass()) {
                if (this.D != object.D) {
                    return false;
                }
                if (this.C != object.C) {
                    return false;
                }
                if (this.E != object.E) {
                    return false;
                }
                if (this.d != object.d) {
                    return false;
                }
                if (this.h != object.h) {
                    return false;
                }
                if (this.x != object.x) {
                    return false;
                }
                if (this.w != object.w) {
                    return false;
                }
                if (this.r != object.r) {
                    return false;
                }
                if (this.q != object.q) {
                    return false;
                }
                if (this.M != object.M) {
                    return false;
                }
                if (this.i != object.i) {
                    return false;
                }
                if (this.n != object.n) {
                    return false;
                }
                if (this.y != object.y) {
                    return false;
                }
                if (this.F != object.F) {
                    return false;
                }
                if (this.m != object.m) {
                    return false;
                }
                if (this.l != object.l) {
                    return false;
                }
                if (this.p != object.p) {
                    return false;
                }
                if (this.v != object.v) {
                    return false;
                }
                if (this.G != object.G) {
                    return false;
                }
                if (this.S != object.S) {
                    return false;
                }
                if (this.T != object.T) {
                    return false;
                }
                if (this.U != object.U) {
                    return false;
                }
                if (this.R != object.R) {
                    return false;
                }
                if (this.P != object.P) {
                    return false;
                }
                if (this.O != object.O) {
                    return false;
                }
                if (this.Q != object.Q) {
                    return false;
                }
                if (this.L != object.L) {
                    return false;
                }
                if (this.K != object.K) {
                    return false;
                }
                if (this.H != object.H) {
                    return false;
                }
                if (this.z != object.z) {
                    return false;
                }
                if (this.B != object.B) {
                    return false;
                }
                if (this.A != object.A) {
                    return false;
                }
                if (this.J != object.J) {
                    return false;
                }
                if (this.I != object.I) {
                    return false;
                }
                if (this.V != object.V) {
                    return false;
                }
                if (this.k != object.k) {
                    return false;
                }
                if (this.o != object.o) {
                    return false;
                }
                if (this.g != object.g) {
                    return false;
                }
                if (this.f != object.f) {
                    return false;
                }
                if (this.j != object.j) {
                    return false;
                }
                if (this.s != object.s) {
                    return false;
                }
                if (this.N != object.N) {
                    return false;
                }
                return !Arrays.equals(this.W, object.W) ? z2 : z;
            }
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public int hashCode() {
        int i = 0;
        if (this.W != null) {
            i = Arrays.hashCode(this.W);
        } else {
            i = 0;
        }
        return (i * 31) + this.d * 31 + this.f * 31 + this.g * 31 + this.h * 31 + this.i * 31 + this.j * 31 + this.k * 31 + this.l * 31 + this.m * 31 + this.n * 31 + this.o * 31 + this.p * 31 + this.q * 31 + this.r * 31 + this.s * 31 + this.v * 31 + this.w * 31 + this.x * 31 + this.y * 31 + this.z * 31 + this.A * 31 + this.B * 31 + this.C * 31 + this.D * 31 + this.E * 31 + this.F * 31 + this.G * 31 + this.H * 31 + this.I * 31 + this.J * 31 + this.K * 31 + this.L * 31 + this.M * 31 + this.N * 31 + this.O * 31 + this.P * 31 + this.Q * 31 + this.R * 31 + this.S * 31 + this.T * 31 + this.U * 31 + this.V;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public ByteBuffer o() {
        ByteBuffer allocate = ByteBuffer.allocate(b());
        g.j(allocate, this.a);
        f(allocate, a());
        allocate.put(p());
        return (ByteBuffer)allocate.rewind();
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AudioSpecificConfig");
        stringBuilder.append("{configBytes=");
        stringBuilder.append(c.a(this.W));
        stringBuilder.append(", audioObjectType=");
        stringBuilder.append(this.d);
        str = " (";
        stringBuilder.append(str);
        stringBuilder.append((String)a.Y.get(Integer.valueOf(this.d)));
        String str35 = ")";
        stringBuilder.append(str35);
        stringBuilder.append(", samplingFrequencyIndex=");
        stringBuilder.append(this.f);
        stringBuilder.append(str);
        stringBuilder.append(a.X.get(Integer.valueOf(this.f)));
        stringBuilder.append(str35);
        stringBuilder.append(", samplingFrequency=");
        stringBuilder.append(this.g);
        stringBuilder.append(", channelConfiguration=");
        stringBuilder.append(this.h);
        if (this.i > 0) {
            stringBuilder.append(", extensionAudioObjectType=");
            stringBuilder.append(this.i);
            stringBuilder.append(str);
            stringBuilder.append((String)a.Y.get(Integer.valueOf(this.i)));
            stringBuilder.append(str35);
            stringBuilder.append(", sbrPresentFlag=");
            stringBuilder.append(this.j);
            stringBuilder.append(", psPresentFlag=");
            stringBuilder.append(this.k);
            stringBuilder.append(", extensionSamplingFrequencyIndex=");
            stringBuilder.append(this.l);
            stringBuilder.append(str);
            stringBuilder.append(a.X.get(Integer.valueOf(this.l)));
            stringBuilder.append(str35);
            stringBuilder.append(", extensionSamplingFrequency=");
            stringBuilder.append(this.m);
            stringBuilder.append(", extensionChannelConfiguration=");
            stringBuilder.append(this.n);
        }
        stringBuilder.append(", syncExtensionType=");
        stringBuilder.append(this.s);
        if (this.G) {
            stringBuilder.append(", frameLengthFlag=");
            stringBuilder.append(this.v);
            stringBuilder.append(", dependsOnCoreCoder=");
            stringBuilder.append(this.w);
            stringBuilder.append(", coreCoderDelay=");
            stringBuilder.append(this.x);
            stringBuilder.append(", extensionFlag=");
            stringBuilder.append(this.y);
            stringBuilder.append(", layerNr=");
            stringBuilder.append(this.z);
            stringBuilder.append(", numOfSubFrame=");
            stringBuilder.append(this.A);
            stringBuilder.append(", layer_length=");
            stringBuilder.append(this.B);
            stringBuilder.append(", aacSectionDataResilienceFlag=");
            stringBuilder.append(this.C);
            stringBuilder.append(", aacScalefactorDataResilienceFlag=");
            stringBuilder.append(this.D);
            stringBuilder.append(", aacSpectralDataResilienceFlag=");
            stringBuilder.append(this.E);
            stringBuilder.append(", extensionFlag3=");
            stringBuilder.append(this.F);
        }
        if (this.V) {
            stringBuilder.append(", isBaseLayer=");
            stringBuilder.append(this.H);
            stringBuilder.append(", paraMode=");
            stringBuilder.append(this.I);
            stringBuilder.append(", paraExtensionFlag=");
            stringBuilder.append(this.J);
            stringBuilder.append(", hvxcVarMode=");
            stringBuilder.append(this.K);
            stringBuilder.append(", hvxcRateMode=");
            stringBuilder.append(this.L);
            stringBuilder.append(", erHvxcExtensionFlag=");
            stringBuilder.append(this.M);
            stringBuilder.append(", var_ScalableFlag=");
            stringBuilder.append(this.N);
            stringBuilder.append(", hilnQuantMode=");
            stringBuilder.append(this.O);
            stringBuilder.append(", hilnMaxNumLine=");
            stringBuilder.append(this.P);
            stringBuilder.append(", hilnSampleRateCode=");
            stringBuilder.append(this.Q);
            stringBuilder.append(", hilnFrameLength=");
            stringBuilder.append(this.R);
            stringBuilder.append(", hilnContMode=");
            stringBuilder.append(this.S);
            stringBuilder.append(", hilnEnhaLayer=");
            stringBuilder.append(this.T);
            stringBuilder.append(", hilnEnhaQuantMode=");
            stringBuilder.append(this.U);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
