package com.googlecode.mp4parser.boxes.mp4.a;

import android.accounts.Account;
import f.b.a.c;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
@g(objectTypeIndication = 64, tags = 5)
public class a extends com.googlecode.mp4parser.boxes.mp4.a.b {

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
        final com.googlecode.mp4parser.boxes.mp4.a.a b;
        public a(com.googlecode.mp4parser.boxes.mp4.a.a a, int i2, com.googlecode.mp4parser.boxes.mp4.a.c c3) {
            int i;
            int i4;
            int i3;
            boolean obj4;
            int obj5;
            this.b = a;
            super();
            c3.b();
            c3.b();
            c3.b();
            c3.b();
            obj4 = c3.b();
            this.a = obj4;
            if (obj4 != null) {
                c3.b();
                c3.b();
                a(i2, c3);
            }
            obj4 = 4;
            while (c3.a(obj4) == 0) {
                obj4 = c3.a(obj4);
                i = 8;
                if (obj4 == 15) {
                } else {
                }
                obj5 = i4;
                if (obj5 == 255) {
                }
                while (i4 >= obj4) {
                    c3.a(i);
                    i4++;
                }
                c3.a(i);
                i4++;
                obj4 = 4;
                obj4 += obj5;
                obj4 += obj5;
            }
        }

        public void a(int i, com.googlecode.mp4parser.boxes.mp4.a.c c2) {
            int i2;
            com.googlecode.mp4parser.boxes.mp4.a.a.b bVar;
            com.googlecode.mp4parser.boxes.mp4.a.a aVar;
            int obj4;
            switch (i) {
                case 1:
                    obj4 = 1;
                    break;
                case 2:
                    obj4 = 2;
                    break;
                case 3:
                    obj4 = 3;
                    break;
                case 4:
                    obj4 = 4;
                    break;
                default:
                    obj4 = i2;
            }
            while (i2 >= obj4) {
                bVar = new a.b(this.b, c2);
                i2++;
            }
        }
    }

    public class b {

        public boolean a;
        public boolean b;
        public b(com.googlecode.mp4parser.boxes.mp4.a.a a, com.googlecode.mp4parser.boxes.mp4.a.c c2) {
            super();
            c2.b();
            int obj2 = 4;
            c2.a(obj2);
            c2.a(obj2);
            c2.a(3);
            obj2 = 2;
            c2.a(obj2);
            this.a = c2.b();
            this.b = c2.b();
            if (this.a) {
                c2.a(obj2);
                c2.b();
                c2.a(obj2);
            }
            if (this.b) {
                c2.a(obj2);
                c2.a(obj2);
                c2.b();
            }
            c2.b();
        }
    }
    static {
        HashMap hashMap = new HashMap();
        a.X = hashMap;
        HashMap hashMap2 = new HashMap();
        a.Y = hashMap2;
        a.X.put(0, 96000);
        Integer valueOf2 = 1;
        a.X.put(valueOf2, 88200);
        Integer valueOf28 = 2;
        a.X.put(valueOf28, 64000);
        Integer valueOf37 = 3;
        a.X.put(valueOf37, 48000);
        Integer valueOf39 = 4;
        a.X.put(valueOf39, 44100);
        Integer valueOf41 = 5;
        a.X.put(valueOf41, 32000);
        Integer valueOf43 = 6;
        a.X.put(valueOf43, 24000);
        Integer valueOf45 = 7;
        a.X.put(valueOf45, 22050);
        Integer valueOf47 = 8;
        a.X.put(valueOf47, 16000);
        Integer valueOf49 = 9;
        a.X.put(valueOf49, 12000);
        Integer valueOf51 = 10;
        a.X.put(valueOf51, 11025);
        Integer valueOf53 = 11;
        a.X.put(valueOf53, 8000);
        a.Y.put(valueOf2, "AAC main");
        a.Y.put(valueOf28, "AAC LC");
        a.Y.put(valueOf37, "AAC SSR");
        a.Y.put(valueOf39, "AAC LTP");
        a.Y.put(valueOf41, "SBR");
        a.Y.put(valueOf43, "AAC Scalable");
        a.Y.put(valueOf45, "TwinVQ");
        a.Y.put(valueOf47, "CELP");
        a.Y.put(valueOf49, "HVXC");
        String str9 = "(reserved)";
        a.Y.put(valueOf51, str9);
        a.Y.put(valueOf53, str9);
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
        int i = -1;
        this.a = 5;
    }

    private int g() {
        int i;
        int i3;
        int i2;
        int i4;
        int i9 = 1;
        i = this.w == i9 ? 16 : 2;
        if (this.h == 0) {
        } else {
            i2 = this.d;
            final int i13 = 20;
            if (i2 != 6) {
                if (i2 == i13) {
                    i3 += 3;
                }
            } else {
            }
            if (this.y == i9 && i2 == 22) {
                if (i2 == 22) {
                    i6 += 11;
                }
                if (i2 != 17 && i2 != 19 && i2 != i13) {
                    if (i2 != 19) {
                        if (i2 != i13) {
                            if (i2 == 23) {
                                i8 += i9;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
                i3 += i9;
                if (this.F == i9) {
                } else {
                }
                RuntimeException runtimeException = new RuntimeException("Not implemented");
                throw runtimeException;
            }
            return i3;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("can't parse program_config_element yet");
        throw unsupportedOperationException;
    }

    private int h(com.googlecode.mp4parser.boxes.mp4.a.c c) {
        int i;
        int obj3;
        if (c.a(5) == 31) {
            i = obj3 + 32;
        }
        return i;
    }

    private void i(int i, int i2, int i3, com.googlecode.mp4parser.boxes.mp4.a.c c4) {
        int obj1;
        obj1 = 1;
        this.K = c4.a(obj1);
        this.L = c4.a(2);
        int obj2 = c4.a(obj1);
        this.M = obj2;
        if (obj2 == obj1) {
            this.N = c4.a(obj1);
        }
    }

    private void j(int i, int i2, int i3, com.googlecode.mp4parser.boxes.mp4.a.c c4) {
        int i4;
        int obj3;
        int obj2 = 1;
        this.v = c4.a(obj2);
        i4 = c4.a(obj2);
        this.w = i4;
        if (i4 == obj2) {
            this.x = c4.a(14);
        }
        this.y = c4.a(obj2);
        if (i2 == 0) {
        } else {
            int i8 = 20;
            if (i3 != 6) {
                if (i3 == i8) {
                    this.z = c4.a(3);
                }
            } else {
            }
            if (this.y == obj2 && i3 == 22) {
                if (i3 == 22) {
                    this.A = c4.a(5);
                    this.B = c4.a(11);
                }
                if (i3 != 17 && i3 != 19 && i3 != i8) {
                    if (i3 != 19) {
                        if (i3 != i8) {
                            if (i3 == 23) {
                                this.C = c4.b();
                                this.D = c4.b();
                                this.E = c4.b();
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
                obj3 = c4.a(obj2);
                this.F = obj3;
                if (obj3 == obj2) {
                } else {
                }
                obj2 = new RuntimeException("not yet implemented");
                throw obj2;
            }
            this.G = obj2;
        }
        obj2 = new UnsupportedOperationException("can't parse program_config_element yet");
        throw obj2;
    }

    private void k(int i, int i2, int i3, com.googlecode.mp4parser.boxes.mp4.a.c c4) {
        this.O = c4.a(1);
        this.P = c4.a(8);
        this.Q = c4.a(4);
        this.R = c4.a(12);
        this.S = c4.a(2);
    }

    private void l(int i, int i2, int i3, com.googlecode.mp4parser.boxes.mp4.a.c c4) {
        int obj1;
        obj1 = 1;
        final int obj2 = c4.a(obj1);
        this.T = obj2;
        if (obj2 == obj1) {
            this.U = c4.a(2);
        }
    }

    private void m(int i, int i2, int i3, com.googlecode.mp4parser.boxes.mp4.a.c c4) {
        int i5 = c4.a(2);
        this.I = i5;
        final int i7 = 1;
        if (i5 != i7) {
            i(i, i2, i3, c4);
        }
        if (this.I != 0) {
            k(i, i2, i3, c4);
        }
        this.J = c4.a(i7);
        this.V = i7;
    }

    private void n(int i, int i2, int i3, com.googlecode.mp4parser.boxes.mp4.a.c c4) {
        final int i4 = 1;
        final int i5 = c4.a(i4);
        this.H = i5;
        if (i5 == i4) {
            m(i, i2, i3, c4);
        } else {
            l(i, i2, i3, c4);
        }
    }

    private ByteBuffer p() {
        int i2;
        int i5;
        int i6;
        int i7;
        int i3;
        int i8;
        boolean z;
        int i4;
        int i9;
        int i;
        ByteBuffer wrap = ByteBuffer.wrap(new byte[a()]);
        d dVar = new d(wrap);
        q(this.e, dVar);
        final int i25 = 4;
        dVar.a(this.f, i25);
        final int i26 = 24;
        final int i27 = 15;
        if (this.f == i27) {
            dVar.a(this.g, i26);
        }
        dVar.a(this.h, i25);
        i6 = this.d;
        final int i28 = 22;
        int i29 = 29;
        i = 1;
        final int i30 = 5;
        if (i6 != i30) {
            this.i = i30;
            this.j = i;
            if (i6 == i29 && i6 == i29) {
                this.i = i30;
                this.j = i;
                if (i6 == i29) {
                    this.k = i;
                }
                dVar.a(this.l, i25);
                if (this.l == i27) {
                    dVar.a(this.m, i26);
                }
                q(this.d, dVar);
                if (this.d == i28) {
                    dVar.a(this.n, i25);
                }
            }
        } else {
        }
        switch (i19) {
            case 1:
                r(dVar);
                break;
            case 2:
                break;
            case 3:
                UnsupportedOperationException unsupportedOperationException13 = new UnsupportedOperationException("can't write CelpSpecificConfig yet");
                throw unsupportedOperationException13;
            case 4:
                UnsupportedOperationException unsupportedOperationException2 = new UnsupportedOperationException("can't write HvxcSpecificConfig yet");
                throw unsupportedOperationException2;
            case 5:
                UnsupportedOperationException unsupportedOperationException8 = new UnsupportedOperationException("can't write TTSSpecificConfig yet");
                throw unsupportedOperationException8;
            case 6:
                UnsupportedOperationException unsupportedOperationException12 = new UnsupportedOperationException("can't write StructuredAudioSpecificConfig yet");
                throw unsupportedOperationException12;
            case 7:
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("can't write ErrorResilientCelpSpecificConfig yet");
                throw unsupportedOperationException;
            case 8:
                UnsupportedOperationException unsupportedOperationException7 = new UnsupportedOperationException("can't write ErrorResilientHvxcSpecificConfig yet");
                throw unsupportedOperationException7;
            case 9:
                UnsupportedOperationException unsupportedOperationException11 = new UnsupportedOperationException("can't write parseParametricSpecificConfig yet");
                throw unsupportedOperationException11;
            case 10:
                UnsupportedOperationException unsupportedOperationException16 = new UnsupportedOperationException("can't write SSCSpecificConfig yet");
                throw unsupportedOperationException16;
            case 11:
                dVar.a(this.o, i);
                UnsupportedOperationException unsupportedOperationException6 = new UnsupportedOperationException("can't write SpatialSpecificConfig yet");
                throw unsupportedOperationException6;
            case 12:
                UnsupportedOperationException unsupportedOperationException10 = new UnsupportedOperationException("can't write MPEG_1_2_SpecificConfig yet");
                throw unsupportedOperationException10;
            case 13:
                UnsupportedOperationException unsupportedOperationException15 = new UnsupportedOperationException("can't write DSTSpecificConfig yet");
                throw unsupportedOperationException15;
            case 14:
                dVar.a(this.p, i30);
                UnsupportedOperationException unsupportedOperationException5 = new UnsupportedOperationException("can't write ALSSpecificConfig yet");
                throw unsupportedOperationException5;
            case 15:
                UnsupportedOperationException unsupportedOperationException9 = new UnsupportedOperationException("can't write SLSSpecificConfig yet");
                throw unsupportedOperationException9;
            case 16:
                UnsupportedOperationException unsupportedOperationException14 = new UnsupportedOperationException("can't write ELDSpecificConfig yet");
                throw unsupportedOperationException14;
            default:
                UnsupportedOperationException unsupportedOperationException4 = new UnsupportedOperationException("can't parse SymbolicMusicSpecificConfig yet");
                throw unsupportedOperationException4;
        }
        i7 = this.d;
        if (i7 != 17 && i7 != 39) {
            if (i7 != 39) {
                if (/* condition */) {
                    i9 = 2;
                    dVar.a(this.q, i9);
                    i7 = this.q;
                    if (i7 == i9) {
                    } else {
                        i9 = 3;
                        if (i7 == i9) {
                        } else {
                            if (i7 == i9) {
                                dVar.a(this.r, i);
                                if (this.r == 0) {
                                } else {
                                }
                                RuntimeException runtimeException = new RuntimeException("not implemented");
                                throw runtimeException;
                            }
                            i3 = this.u;
                            i9 = 11;
                            dVar.a(i3, i9);
                            q(this.i, dVar);
                            dVar.b(this.j);
                            dVar.a(this.l, i25);
                            if (i3 >= 0 && this.u == 695 && this.i == i30 && this.j && this.l == i27) {
                                i9 = 11;
                                dVar.a(i3, i9);
                                if (this.u == 695) {
                                    q(this.i, dVar);
                                    if (this.i == i30) {
                                        dVar.b(this.j);
                                        if (this.j) {
                                            dVar.a(this.l, i25);
                                            if (this.l == i27) {
                                                dVar.a(this.m, i26);
                                            }
                                            i8 = this.t;
                                            dVar.a(i8, i9);
                                            if (i8 >= 0 && this.s == 1352) {
                                                dVar.a(i8, i9);
                                                if (this.s == 1352) {
                                                    dVar.b(this.k);
                                                }
                                            }
                                        }
                                    }
                                    dVar.b(this.j);
                                    dVar.a(this.l, i25);
                                    if (this.i == i28 && this.j && this.l == i27) {
                                        dVar.b(this.j);
                                        if (this.j) {
                                            dVar.a(this.l, i25);
                                            if (this.l == i27) {
                                                dVar.a(this.m, i26);
                                            }
                                        }
                                        dVar.a(this.n, i25);
                                    }
                                }
                            }
                        }
                    }
                } else {
                }
                return (ByteBuffer)wrap.rewind();
            } else {
            }
        } else {
        }
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("can't parse ErrorProtectionSpecificConfig yet");
        throw unsupportedOperationException3;
    }

    private void q(int i, com.googlecode.mp4parser.boxes.mp4.a.d d2) {
        int i2;
        int i3;
        int obj4;
        i2 = 5;
        final int i4 = 32;
        if (i >= i4) {
            d2.a(31, i2);
            d2.a(i -= i4, 6);
        } else {
            d2.a(i, i2);
        }
    }

    private void r(com.googlecode.mp4parser.boxes.mp4.a.d d) {
        int i2;
        int i8;
        int i5;
        int i7;
        int i;
        int i3;
        int i6;
        int i4;
        int obj5;
        final int i14 = 1;
        d.a(this.v, i14);
        d.a(this.w, i14);
        if (this.w == i14) {
            d.a(this.x, 14);
        }
        d.a(this.y, i14);
        if (this.h == 0) {
        } else {
            i8 = this.d;
            final int i16 = 20;
            if (i8 != 6) {
                if (i8 == i16) {
                    d.a(this.z, 3);
                }
            } else {
            }
            if (this.y == i14 && this.d == 22) {
                if (this.d == 22) {
                    d.a(this.A, 5);
                    d.a(this.B, 11);
                }
                i = this.d;
                if (i != 17 && i != 19 && i != i16) {
                    if (i != 19) {
                        if (i != i16) {
                            if (i == 23) {
                                d.b(this.C);
                                d.b(this.D);
                                d.b(this.E);
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
                d.a(this.F, i14);
                if (this.F == i14) {
                } else {
                }
                obj5 = new RuntimeException("not yet implemented");
                throw obj5;
            }
        }
        obj5 = new UnsupportedOperationException("can't parse program_config_element yet");
        throw obj5;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    int a() {
        int i5;
        int i;
        int i6;
        int i7;
        int i3;
        int i9;
        boolean z;
        int i8;
        int i2;
        int i4;
        i3 = 30;
        i9 = 5;
        i5 = this.e > i3 ? 11 : i9;
        final int i16 = 15;
        if (this.f == i16) {
            i += 24;
        }
        int i15 = this.d;
        if (i15 != i9) {
            if (i15 == 29 && this.l == i16) {
                if (this.l == i16) {
                    i6 += 24;
                }
            }
        } else {
        }
        int i17 = 22;
        if (i15 == i17) {
            i6 += 4;
        }
        if (this.G) {
            i6 += z;
        }
        i8 = this.u;
        i8 = this.i;
        if (i8 >= 0 && i8 == 695 && i8 > i3) {
            if (i8 == 695) {
                i8 = this.i;
                if (i8 > i3) {
                    i6 += 6;
                }
                if (i8 == i9 && this.j && this.l == i16) {
                    if (this.j) {
                        if (this.l == i16) {
                            i6 += 24;
                        }
                        i3 = this.t;
                        if (i3 >= 0 && i3 == 1352) {
                            if (i3 == 1352) {
                                i6++;
                            }
                        }
                    }
                }
                if (i8 == i17 && this.j && this.l == i16) {
                    if (this.j) {
                        if (this.l == i16) {
                            i7 += 24;
                        }
                    }
                    i7 += 4;
                }
            }
        }
        return (int)ceil;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public void e(ByteBuffer byteBuffer) {
        int i7;
        int i5;
        int i6;
        int aVar;
        int i8;
        int i9;
        int i10;
        int i11;
        int i4;
        int i;
        int i2;
        com.googlecode.mp4parser.boxes.mp4.a.c obj10;
        ByteBuffer slice = byteBuffer.slice();
        slice.limit(this.b);
        byteBuffer.position(position += i18);
        obj10 = new byte[this.b];
        this.W = obj10;
        slice.get(obj10);
        slice.rewind();
        obj10 = new c(slice);
        int i12 = h(obj10);
        this.d = i12;
        this.e = i12;
        int i13 = 4;
        i7 = obj10.a(i13);
        this.f = i7;
        int i19 = 24;
        final int i20 = 15;
        if (i7 == i20) {
            this.g = obj10.a(i19);
        }
        this.h = obj10.a(i13);
        int i17 = this.d;
        final int i21 = 22;
        i10 = 29;
        i = 1;
        final int i22 = 5;
        if (i17 != i22) {
            if (i17 == i10) {
                this.i = i22;
                this.j = i;
                if (i17 == i10) {
                    this.k = i;
                }
                i5 = obj10.a(i13);
                this.l = i5;
                if (i5 == i20) {
                    this.m = obj10.a(i19);
                }
                i6 = h(obj10);
                this.d = i6;
                if (i6 == i21) {
                    this.n = obj10.a(i13);
                }
            } else {
                this.i = 0;
            }
        } else {
        }
        aVar = this.d;
        switch (aVar) {
            case 1:
                j(this.f, this.h, aVar, obj10);
                break;
            case 2:
                break;
            case 3:
                obj10 = new UnsupportedOperationException("can't parse CelpSpecificConfig yet");
                throw obj10;
            case 4:
                obj10 = new UnsupportedOperationException("can't parse HvxcSpecificConfig yet");
                throw obj10;
            case 5:
                obj10 = new UnsupportedOperationException("can't parse TTSSpecificConfig yet");
                throw obj10;
            case 6:
                obj10 = new UnsupportedOperationException("can't parse StructuredAudioSpecificConfig yet");
                throw obj10;
            case 7:
                obj10 = new UnsupportedOperationException("can't parse ErrorResilientCelpSpecificConfig yet");
                throw obj10;
            case 8:
                obj10 = new UnsupportedOperationException("can't parse ErrorResilientHvxcSpecificConfig yet");
                throw obj10;
            case 9:
                n(this.f, this.h, aVar, obj10);
                break;
            case 10:
                obj10 = new UnsupportedOperationException("can't parse SSCSpecificConfig yet");
                throw obj10;
            case 11:
                this.o = obj10.a(i);
                obj10 = new UnsupportedOperationException("can't parse SpatialSpecificConfig yet");
                throw obj10;
            case 12:
                obj10 = new UnsupportedOperationException("can't parse MPEG_1_2_SpecificConfig yet");
                throw obj10;
            case 13:
                obj10 = new UnsupportedOperationException("can't parse DSTSpecificConfig yet");
                throw obj10;
            case 14:
                this.p = obj10.a(i22);
                obj10 = new UnsupportedOperationException("can't parse ALSSpecificConfig yet");
                throw obj10;
            case 15:
                obj10 = new UnsupportedOperationException("can't parse SLSSpecificConfig yet");
                throw obj10;
            case 16:
                aVar = new a.a(this, this.h, obj10);
                break;
            default:
                obj10 = new UnsupportedOperationException("can't parse SymbolicMusicSpecificConfig yet");
                throw obj10;
        }
        i8 = this.d;
        if (i8 != 17 && i8 != 39) {
            if (i8 != 39) {
                if (/* condition */) {
                    i8 = 2;
                    i11 = obj10.a(i8);
                    this.q = i11;
                    if (i11 == i8) {
                    } else {
                        i8 = 3;
                        if (i11 == i8) {
                        } else {
                            if (i11 == i8) {
                                i8 = obj10.a(i);
                                this.r = i8;
                                if (i8 == 0) {
                                } else {
                                }
                                obj10 = new RuntimeException("not implemented");
                                throw obj10;
                            }
                            i9 = 11;
                            i11 = obj10.a(i9);
                            this.s = i11;
                            this.u = i11;
                            i11 = h(obj10);
                            this.i = i11;
                            i11 = obj10.b();
                            this.j = i11;
                            i4 = obj10.a(i13);
                            this.l = i4;
                            if (this.i != i22 && obj10.c() >= 16 && i11 == 695 && i11 == i22 && i11 && i4 == i20) {
                                if (obj10.c() >= 16) {
                                    i9 = 11;
                                    i11 = obj10.a(i9);
                                    this.s = i11;
                                    this.u = i11;
                                    if (i11 == 695) {
                                        i11 = h(obj10);
                                        this.i = i11;
                                        if (i11 == i22) {
                                            i11 = obj10.b();
                                            this.j = i11;
                                            if (i11) {
                                                i4 = obj10.a(i13);
                                                this.l = i4;
                                                if (i4 == i20) {
                                                    this.m = obj10.a(i19);
                                                }
                                                i9 = obj10.a(i9);
                                                this.s = i9;
                                                this.t = i9;
                                                if (obj10.c() >= 12 && i9 == 1352) {
                                                    i9 = obj10.a(i9);
                                                    this.s = i9;
                                                    this.t = i9;
                                                    if (i9 == 1352) {
                                                        this.k = obj10.b();
                                                    }
                                                }
                                            }
                                        }
                                        i9 = obj10.b();
                                        this.j = i9;
                                        i9 = obj10.a(i13);
                                        this.l = i9;
                                        if (this.i == i21 && i9 && i9 == i20) {
                                            i9 = obj10.b();
                                            this.j = i9;
                                            if (i9) {
                                                i9 = obj10.a(i13);
                                                this.l = i9;
                                                if (i9 == i20) {
                                                    this.m = obj10.a(i19);
                                                }
                                            }
                                            this.n = obj10.a(i13);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        obj10 = new UnsupportedOperationException("can't parse ErrorProtectionSpecificConfig yet");
        throw obj10;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public boolean equals(Object object) {
        Class<com.googlecode.mp4parser.boxes.mp4.a.a> obj;
        Class class;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (a.class != object.getClass()) {
            } else {
                if (this.D != object.D) {
                    return i2;
                }
                if (this.C != object.C) {
                    return i2;
                }
                if (this.E != object.E) {
                    return i2;
                }
                if (this.d != object.d) {
                    return i2;
                }
                if (this.h != object.h) {
                    return i2;
                }
                if (this.x != object.x) {
                    return i2;
                }
                if (this.w != object.w) {
                    return i2;
                }
                if (this.r != object.r) {
                    return i2;
                }
                if (this.q != object.q) {
                    return i2;
                }
                if (this.M != object.M) {
                    return i2;
                }
                if (this.i != object.i) {
                    return i2;
                }
                if (this.n != object.n) {
                    return i2;
                }
                if (this.y != object.y) {
                    return i2;
                }
                if (this.F != object.F) {
                    return i2;
                }
                if (this.m != object.m) {
                    return i2;
                }
                if (this.l != object.l) {
                    return i2;
                }
                if (this.p != object.p) {
                    return i2;
                }
                if (this.v != object.v) {
                    return i2;
                }
                if (this.G != object.G) {
                    return i2;
                }
                if (this.S != object.S) {
                    return i2;
                }
                if (this.T != object.T) {
                    return i2;
                }
                if (this.U != object.U) {
                    return i2;
                }
                if (this.R != object.R) {
                    return i2;
                }
                if (this.P != object.P) {
                    return i2;
                }
                if (this.O != object.O) {
                    return i2;
                }
                if (this.Q != object.Q) {
                    return i2;
                }
                if (this.L != object.L) {
                    return i2;
                }
                if (this.K != object.K) {
                    return i2;
                }
                if (this.H != object.H) {
                    return i2;
                }
                if (this.z != object.z) {
                    return i2;
                }
                if (this.B != object.B) {
                    return i2;
                }
                if (this.A != object.A) {
                    return i2;
                }
                if (this.J != object.J) {
                    return i2;
                }
                if (this.I != object.I) {
                    return i2;
                }
                if (this.V != object.V) {
                    return i2;
                }
                if (this.k != object.k) {
                    return i2;
                }
                if (this.o != object.o) {
                    return i2;
                }
                if (this.g != object.g) {
                    return i2;
                }
                if (this.f != object.f) {
                    return i2;
                }
                if (this.j != object.j) {
                    return i2;
                }
                if (this.s != object.s) {
                    return i2;
                }
                if (this.N != object.N) {
                    return i2;
                }
                if (!Arrays.equals(this.W, object.W)) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public int hashCode() {
        int i;
        byte[] bArr = this.W;
        if (bArr != null) {
            i = Arrays.hashCode(bArr);
        } else {
            i = 0;
        }
        return i84 += z7;
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
        String str;
        boolean z2;
        boolean z;
        int valueOf;
        Integer valueOf2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AudioSpecificConfig");
        stringBuilder.append("{configBytes=");
        stringBuilder.append(c.a(this.W));
        stringBuilder.append(", audioObjectType=");
        stringBuilder.append(this.d);
        str = " (";
        stringBuilder.append(str);
        stringBuilder.append((String)a.Y.get(Integer.valueOf(this.d)));
        String str34 = ")";
        stringBuilder.append(str34);
        stringBuilder.append(", samplingFrequencyIndex=");
        stringBuilder.append(this.f);
        stringBuilder.append(str);
        stringBuilder.append(a.X.get(Integer.valueOf(this.f)));
        stringBuilder.append(str34);
        stringBuilder.append(", samplingFrequency=");
        stringBuilder.append(this.g);
        stringBuilder.append(", channelConfiguration=");
        stringBuilder.append(this.h);
        if (this.i > 0) {
            stringBuilder.append(", extensionAudioObjectType=");
            stringBuilder.append(this.i);
            stringBuilder.append(str);
            stringBuilder.append((String)a.Y.get(Integer.valueOf(this.i)));
            stringBuilder.append(str34);
            stringBuilder.append(", sbrPresentFlag=");
            stringBuilder.append(this.j);
            stringBuilder.append(", psPresentFlag=");
            stringBuilder.append(this.k);
            stringBuilder.append(", extensionSamplingFrequencyIndex=");
            stringBuilder.append(this.l);
            stringBuilder.append(str);
            stringBuilder.append(a.X.get(Integer.valueOf(this.l)));
            stringBuilder.append(str34);
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
