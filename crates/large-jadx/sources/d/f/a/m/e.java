package d.f.a.m;

import d.f.a.b;
import d.f.a.c;
import d.f.a.d;
import d.f.a.i;
import d.f.a.l.a;
import d.f.a.m.m.c;
import d.f.a.m.m.l;
import d.f.a.m.m.n;
import d.f.a.m.m.p;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class e {

    public static float t0 = 0.5f;
    public float A = 1f;
    int B = -1;
    float C = 1f;
    private int[] D;
    private float E = 0f;
    private boolean F = false;
    private boolean G;
    private boolean H = false;
    private int I = 0;
    private int J = 0;
    public d.f.a.m.d K;
    public d.f.a.m.d L;
    public d.f.a.m.d M;
    public d.f.a.m.d N;
    public d.f.a.m.d O;
    d.f.a.m.d P;
    d.f.a.m.d Q;
    public d.f.a.m.d R;
    public d.f.a.m.d[] S;
    protected ArrayList<d.f.a.m.d> T;
    private boolean[] U;
    public d.f.a.m.e.b[] V;
    public d.f.a.m.e W = null;
    int X = 0;
    int Y = 0;
    public float Z = 0f;
    public boolean a = false;
    protected int a0 = -1;
    public c b;
    protected int b0 = 0;
    public c c;
    protected int c0 = 0;
    public l d = null;
    int d0 = 0;
    public n e = null;
    protected int e0;
    public boolean[] f;
    protected int f0;
    private boolean g = true;
    float g0 = 0f;
    private boolean h = false;
    float h0 = 0f;
    private boolean i = true;
    private Object i0;
    private int j = -1;
    private int j0 = 0;
    private int k = -1;
    private String k0 = null;
    private boolean l = false;
    private String l0 = null;
    private boolean m = false;
    int m0 = 0;
    private boolean n = false;
    int n0 = 0;
    private boolean o = false;
    public float[] o0;
    public int p = -1;
    protected d.f.a.m.e[] p0;
    public int q = -1;
    protected d.f.a.m.e[] q0;
    private int r = 0;
    public int r0 = -1;
    public int s = 0;
    public int s0 = -1;
    public int t = 0;
    public int[] u;
    public int v = 0;
    public int w = 0;
    public float x = 1f;
    public int y = 0;
    public int z = 0;

    static class a {

        static final int[] a;
        static final int[] b;
        static {
            int[] iArr = new int[values.length];
            e.a.b = iArr;
            int i2 = 1;
            iArr[e.b.FIXED.ordinal()] = i2;
            int i = 2;
            e.a.b[e.b.WRAP_CONTENT.ordinal()] = i;
            int i3 = 3;
            e.a.b[e.b.MATCH_PARENT.ordinal()] = i3;
            int i9 = 4;
            e.a.b[e.b.MATCH_CONSTRAINT.ordinal()] = i9;
            int[] iArr13 = new int[values2.length];
            e.a.a = iArr13;
            iArr13[d.b.LEFT.ordinal()] = i2;
            e.a.a[d.b.TOP.ordinal()] = i;
            e.a.a[d.b.RIGHT.ordinal()] = i3;
            e.a.a[d.b.BOTTOM.ordinal()] = i9;
            e.a.a[d.b.BASELINE.ordinal()] = 5;
            e.a.a[d.b.CENTER.ordinal()] = 6;
            e.a.a[d.b.CENTER_X.ordinal()] = 7;
            e.a.a[d.b.CENTER_Y.ordinal()] = 8;
            e.a.a[d.b.NONE.ordinal()] = 9;
        }
    }

    public static enum b {

        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT;
    }
    static {
    }

    public e() {
        super();
        final int i = 0;
        final int i2 = 0;
        int i3 = 2;
        boolean[] zArr = new boolean[i3];
        zArr = new byte[]{1, 1};
        this.f = zArr;
        int i4 = 1;
        final int i5 = -1;
        a aVar = new a(this);
        this.u = new int[i3];
        int i6 = 1065353216;
        int[] iArr2 = new int[i3];
        iArr2 = new int[]{2147483647, 2147483647};
        this.D = iArr2;
        int i7 = 0;
        d dVar = new d(this, d.b.LEFT);
        this.K = dVar;
        d dVar2 = new d(this, d.b.TOP);
        this.L = dVar2;
        d dVar3 = new d(this, d.b.RIGHT);
        this.M = dVar3;
        d dVar4 = new d(this, d.b.BOTTOM);
        this.N = dVar4;
        d dVar5 = new d(this, d.b.BASELINE);
        this.O = dVar5;
        d dVar6 = new d(this, d.b.CENTER_X);
        this.P = dVar6;
        d dVar7 = new d(this, d.b.CENTER_Y);
        this.Q = dVar7;
        d dVar8 = new d(this, d.b.CENTER);
        this.R = dVar8;
        d.f.a.m.d[] arr4 = new d[6];
        arr4[i] = dVar;
        arr4[i4] = dVar3;
        arr4[i3] = dVar2;
        arr4[3] = dVar4;
        arr4[4] = dVar5;
        arr4[5] = dVar8;
        this.S = arr4;
        ArrayList arrayList = new ArrayList();
        this.T = arrayList;
        this.U = new boolean[i3];
        d.f.a.m.e.b[] arr3 = new e.b[i3];
        d.f.a.m.e.b fIXED = e.b.FIXED;
        arr3[i] = fIXED;
        arr3[i4] = fIXED;
        this.V = arr3;
        float f = e.t0;
        float[] fArr = new float[i3];
        fArr = new int[]{-1082130432, -1082130432};
        this.o0 = fArr;
        d.f.a.m.e[] arr2 = new e[i3];
        arr2[i] = i2;
        arr2[i4] = i2;
        this.p0 = arr2;
        d.f.a.m.e[] arr = new e[i3];
        arr[i] = i2;
        arr[i4] = i2;
        this.q0 = arr;
        d();
    }

    private boolean a0(int i) {
        d.f.a.m.d dVar2;
        int i2;
        d.f.a.m.d dVar;
        int obj5;
        i *= 2;
        final d.f.a.m.d[] objArr = this.S;
        obj5 += i2;
        if (dVar3.f != null && dVar5.f != objArr[obj5] && dVar6.f != null && dVar8.f == objArr[obj5]) {
            if (dVar5.f != objArr[obj5]) {
                obj5 += i2;
                if (dVar6.f != null) {
                    if (dVar8.f == objArr[obj5]) {
                    } else {
                        i2 = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i2;
    }

    private void d() {
        this.T.add(this.K);
        this.T.add(this.L);
        this.T.add(this.M);
        this.T.add(this.N);
        this.T.add(this.P);
        this.T.add(this.Q);
        this.T.add(this.R);
        this.T.add(this.O);
    }

    private void i(d d, boolean z2, boolean z3, boolean z4, boolean z5, i i6, i i7, d.f.a.m.e.b e$b8, boolean z9, d.f.a.m.d d10, d.f.a.m.d d11, int i12, int i13, int i14, int i15, float f16, boolean z17, boolean z18, boolean z19, boolean z20, boolean z21, int i22, int i23, int i24, int i25, float f26, boolean z27) {
        int i16;
        int i39;
        int i44;
        i iVar10;
        int i35;
        d.f.a.m.e eVar;
        i iVar4;
        int i38;
        d.f.a.m.e eVar5;
        int i40;
        int i18;
        int i53;
        int i;
        i iVar3;
        i iVar5;
        int i30;
        i iVar11;
        d.f.a.m.d.b bVar;
        int i9;
        Object eVar2;
        i iVar6;
        int i21;
        i iVar14;
        int i41;
        int i51;
        boolean z10;
        int i42;
        int i52;
        int i5;
        int i32;
        d.f.a.e eVar3;
        boolean z13;
        boolean z11;
        boolean cmp;
        int i28;
        int i8;
        int i20;
        int mATCH_CONSTRAINT;
        i iVar7;
        i iVar13;
        boolean z6;
        i iVar12;
        int i49;
        boolean z7;
        d.f.a.m.e z;
        d.f.a.m.d.b bOTTOM;
        int bOTTOM2;
        i iVar2;
        int i17;
        int i54;
        int i47;
        int i36;
        i iVar9;
        i iVar8;
        int i27;
        boolean z8;
        int i34;
        int i33;
        int i19;
        int ordinal;
        d.f.a.m.e eVar4;
        i iVar;
        int i48;
        int i50;
        int i3;
        boolean z12;
        int i43;
        int i29;
        int i37;
        int i26;
        int i2;
        int i10;
        int i11;
        int i45;
        int i4;
        int i31;
        int i46;
        int obj40;
        int obj46;
        final Object obj = this;
        final i iVar18 = d;
        i49 = i6;
        i iVar19 = i7;
        int i89 = i14;
        int i55 = i15;
        int i61 = i23;
        i30 = i24;
        i41 = i25;
        iVar12 = iVar18.q(d10);
        iVar13 = iVar18.q(d11);
        iVar7 = iVar18.q(d10.i());
        i iVar17 = iVar18.q(d11.i());
        if (d.w() != null) {
            eVar3 = d.w();
            eVar3.w = l += i27;
        }
        z7 = d10.n();
        z = d11.n();
        z8 = obj.R.n();
        z13 = z ? z7 + 1 : z7;
        if (z8) {
            z13++;
        }
        i34 = z17 ? 3 : i22;
        int i62 = e.a.b[b8.ordinal()];
        if (i62 != 1 && i62 != 2 && i62 != 3) {
            if (i62 != 2) {
                if (i62 != 3) {
                    i54 = 4;
                    if (i62 != i54) {
                        i38 = i34;
                        i33 = 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        int i86 = -1;
        if (obj.j != i86 && z2) {
            if (z2) {
                obj.j = i86;
                iVar = iVar17;
                i33 = 0;
            } else {
                i47 = i13;
                iVar = iVar17;
            }
        } else {
        }
        int i78 = obj.k;
        if (i78 != i86 && !z2) {
            if (!z2) {
                obj.k = i86;
                i47 = i78;
                i33 = 0;
            }
        }
        int i87 = 8;
        if (obj.j0 == i87) {
            i47 = 0;
            i33 = 0;
        }
        if (z27) {
            if (!z7 && !z && !z8) {
                if (!z) {
                    if (!z8) {
                        iVar18.f(iVar12, i12);
                    } else {
                        if (z7 && !z) {
                            if (!z) {
                                iVar18.e(iVar12, iVar7, d10.e(), i87);
                            }
                        }
                    }
                } else {
                }
            } else {
            }
        }
        if (i33 == 0) {
            if (z9 != 0) {
                iVar18.e(iVar13, iVar12, 0, 3);
                i8 = 8;
                if (i89 > 0) {
                    iVar18.h(iVar13, iVar12, i89, i8);
                }
                if (i55 < Integer.MAX_VALUE) {
                    iVar18.j(iVar13, iVar12, i55, i8);
                }
            } else {
                i17 = 0;
                iVar18.e(iVar13, iVar12, i47, i87);
            }
            i36 = z5;
            z12 = z13;
            iVar2 = iVar7;
            iVar10 = iVar13;
            iVar8 = iVar;
            i48 = i30;
        } else {
            bOTTOM2 = 0;
            if (z13 != 2 && !z17) {
                if (!z17) {
                    if (i38 != 1) {
                        if (i38 == 0) {
                            if (i41 > 0) {
                                i44 = Math.min(i41, Math.max(i30, i47));
                            }
                            iVar18.e(iVar13, iVar12, i44, 8);
                            i36 = z5;
                            z12 = z13;
                            iVar10 = iVar13;
                            i33 = bOTTOM2;
                            iVar8 = iVar;
                            i48 = i30;
                            iVar2 = iVar7;
                        } else {
                            int i56 = -2;
                            i8 = i30 == i56 ? i47 : i30;
                            i39 = i41 == i56 ? i47 : i41;
                            if (i47 > 0 && i38 != 1) {
                                if (i38 != 1) {
                                    i47 = bOTTOM2;
                                }
                            }
                            if (i8 > 0) {
                                iVar18.h(iVar13, iVar12, i8, 8);
                                i47 = Math.max(i47, i8);
                            }
                            if (i39 > 0) {
                                if (z3 != 0 && i38 == 1) {
                                    i9 = i38 == 1 ? bOTTOM2 : 1;
                                } else {
                                }
                                if (i9 != 0) {
                                    iVar18.j(iVar13, iVar12, i39, 8);
                                } else {
                                    i30 = 8;
                                }
                                i47 = Math.min(i47, i39);
                            } else {
                                i30 = 8;
                            }
                            if (i38 == 1) {
                                if (z3 != 0) {
                                    iVar18.e(iVar13, iVar12, i47, i30);
                                    i21 = 5;
                                } else {
                                    if (z19) {
                                        iVar18.e(iVar13, iVar12, i47, 5);
                                        iVar18.j(iVar13, iVar12, i47, i30);
                                    } else {
                                        iVar18.e(iVar13, iVar12, i47, 5);
                                        iVar18.j(iVar13, iVar12, i47, i30);
                                    }
                                }
                                i36 = z5;
                                i41 = i39;
                                z12 = z13;
                                iVar2 = iVar7;
                                iVar10 = iVar13;
                                iVar8 = iVar;
                                i48 = i8;
                            } else {
                                int i75 = 5;
                                if (i38 == 2) {
                                    d.f.a.m.d.b tOP = d.b.TOP;
                                    if (d10.j() != tOP) {
                                        if (d10.j() == d.b.BOTTOM) {
                                            iVar11 = iVar18.q(obj.W.m(tOP));
                                            iVar14 = iVar18.q(obj.W.m(d.b.BOTTOM));
                                        } else {
                                            iVar11 = iVar18.q(obj.W.m(d.b.LEFT));
                                            iVar14 = iVar18.q(obj.W.m(d.b.RIGHT));
                                        }
                                    } else {
                                    }
                                    b bVar2 = d.r();
                                    i26 = 5;
                                    iVar8 = iVar;
                                    i48 = i8;
                                    iVar2 = iVar7;
                                    z12 = z14;
                                    iVar10 = iVar13;
                                    bVar2.k(iVar13, iVar12, iVar14, iVar11, f26);
                                    iVar18.d(bVar2);
                                    if (z3 != 0) {
                                        i33 = 0;
                                    }
                                    i36 = z5;
                                    i41 = obj40;
                                } else {
                                    z12 = z13;
                                    iVar2 = iVar7;
                                    iVar10 = iVar13;
                                    iVar8 = iVar;
                                    i48 = i8;
                                    i41 = obj40;
                                    i36 = 1;
                                }
                            }
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        }
        if (z27) {
            if (z19) {
                iVar6 = i7;
                iVar5 = iVar10;
                obj46 = i36;
                cmp = z12;
                i32 = 0;
                mATCH_CONSTRAINT = 2;
                iVar4 = i6;
                iVar9 = iVar12;
                if (cmp < mATCH_CONSTRAINT && z3 != 0 && obj46 != null) {
                    if (z3 != 0) {
                        if (obj46 != null) {
                            iVar18.h(iVar9, iVar4, i32, 8);
                            if (!z2) {
                                if (dVar2.f == null) {
                                    iVar2 = 1;
                                } else {
                                    iVar2 = i32;
                                }
                            } else {
                            }
                            iVar4 = dVar.f;
                            if (!z2 && iVar4 != null) {
                                iVar4 = dVar.f;
                                if (iVar4 != null) {
                                    iVar4 = iVar4.d;
                                    iVar4 = iVar4.V;
                                    mATCH_CONSTRAINT = e.b.MATCH_CONSTRAINT;
                                    cmp = 1;
                                    if (Float.compare(f, mATCH_CONSTRAINT) != 0 && iVar4[i32] == mATCH_CONSTRAINT && iVar4[cmp] == mATCH_CONSTRAINT) {
                                        iVar4 = iVar4.V;
                                        mATCH_CONSTRAINT = e.b.MATCH_CONSTRAINT;
                                        if (iVar4[i32] == mATCH_CONSTRAINT) {
                                            cmp = 1;
                                            iVar9 = iVar4[cmp] == mATCH_CONSTRAINT ? cmp : i32;
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                    iVar9 = iVar2;
                                }
                            } else {
                            }
                            if (iVar9 != 0) {
                                iVar18.h(iVar6, iVar5, i32, 8);
                            }
                        }
                    }
                }
            } else {
                if (!z7 && !z && !z8) {
                    if (!z) {
                        if (!z8) {
                            iVar3 = iVar10;
                            obj46 = i36;
                            iVar10 = 5;
                            i5 = 0;
                            i37 = z3;
                            i20 = iVar10;
                        } else {
                            if (z7 && !z) {
                                if (!z) {
                                    if (z3 != 0 && eVar5 instanceof a) {
                                        iVar2 = eVar5 instanceof a ? 8 : 5;
                                    } else {
                                    }
                                    i37 = z3;
                                    iVar3 = iVar10;
                                    i5 = iVar13;
                                    i20 = iVar2;
                                    obj46 = i36;
                                } else {
                                    iVar7 = d10;
                                    iVar13 = 0;
                                    if (!z7 && z) {
                                        if (z) {
                                            iVar18.e(iVar10, iVar8, -i69, 8);
                                            if (z3 != 0) {
                                                i38 = obj.W;
                                                if (obj.h && iVar12.y && i38 != null) {
                                                    if (iVar12.y) {
                                                        i38 = obj.W;
                                                        if (i38 != null) {
                                                            if (z2) {
                                                                (f)i38.q1(iVar7);
                                                            } else {
                                                                i38.v1(iVar7);
                                                            }
                                                            iVar3 = iVar10;
                                                            i5 = iVar13;
                                                            obj46 = i36;
                                                            iVar10 = 5;
                                                        } else {
                                                            int i70 = 5;
                                                            iVar18.h(iVar12, i6, iVar13, i70);
                                                            i5 = iVar13;
                                                            obj46 = i36;
                                                            iVar3 = iVar10;
                                                            iVar10 = i46;
                                                        }
                                                    } else {
                                                    }
                                                } else {
                                                }
                                            } else {
                                            }
                                        } else {
                                            if (z7 && z) {
                                                if (z) {
                                                    z7 = dVar6.d;
                                                    Object obj2 = d11;
                                                    int i71 = 2;
                                                    z13 = dVar13.d;
                                                    eVar2 = I();
                                                    z8 = 6;
                                                    if (i33 != 0) {
                                                        if (i38 == 0) {
                                                            if (i41 == 0 && i48 == 0) {
                                                                if (i48 == 0) {
                                                                    if (iVar2.y && iVar8.y) {
                                                                        if (iVar8.y) {
                                                                            int i73 = 8;
                                                                            iVar18.e(iVar12, iVar2, d10.e(), i73);
                                                                            iVar18.e(iVar10, iVar8, -i64, i73);
                                                                        }
                                                                    }
                                                                    i26 = i50;
                                                                    i51 = 8;
                                                                    i19 = 8;
                                                                    i43 = 1;
                                                                } else {
                                                                    i43 = iVar13;
                                                                    i51 = 5;
                                                                    i19 = 5;
                                                                    i50 = 1;
                                                                    i26 = 1;
                                                                }
                                                            } else {
                                                            }
                                                            if (!z7 instanceof a) {
                                                                if (z13 instanceof a) {
                                                                    iVar13 = i7;
                                                                    ordinal = i38;
                                                                    i53 = z8;
                                                                    i2 = i43;
                                                                    i29 = i50;
                                                                    i3 = 4;
                                                                } else {
                                                                    iVar13 = i7;
                                                                    i2 = i43;
                                                                    i29 = i50;
                                                                    i3 = i19;
                                                                    ordinal = i38;
                                                                    i53 = z8;
                                                                }
                                                            } else {
                                                            }
                                                        } else {
                                                        }
                                                    } else {
                                                        ordinal = i38;
                                                        d.c(iVar12, iVar2, d10.e(), f16, iVar8, iVar10, d11.e(), 8);
                                                        if (iVar2.y && iVar8.y && z3 != 0 && i36 != 0) {
                                                            if (iVar8.y) {
                                                                d.c(iVar12, iVar2, d10.e(), f16, iVar8, iVar10, d11.e(), 8);
                                                                if (z3 != 0) {
                                                                    if (i36 != 0) {
                                                                        if (obj2.f != null) {
                                                                            iVar2 = d11.e();
                                                                            iVar13 = i7;
                                                                        } else {
                                                                            iVar13 = i7;
                                                                            iVar2 = 0;
                                                                        }
                                                                        if (iVar8 != iVar13) {
                                                                            iVar18.h(iVar13, iVar10, iVar2, 5);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        iVar13 = i7;
                                                        i53 = z8;
                                                        i51 = 5;
                                                        i3 = 4;
                                                        i29 = 1;
                                                        i26 = 1;
                                                        i2 = 0;
                                                    }
                                                    if (i26 != 0 && iVar2 == iVar8 && z7 != eVar2) {
                                                        if (iVar2 == iVar8) {
                                                            i10 = z7 != eVar2 ? 0 : 1;
                                                        } else {
                                                        }
                                                    } else {
                                                    }
                                                    if (i29 != 0) {
                                                        if (i33 == 0 && !z18 && !z20 && iVar2 == i6 && iVar8 == iVar13) {
                                                            if (!z18) {
                                                                if (!z20) {
                                                                    if (iVar2 == i6) {
                                                                        if (iVar8 == iVar13) {
                                                                            i37 = 0;
                                                                            i11 = 8;
                                                                            i45 = 8;
                                                                            i4 = 0;
                                                                        } else {
                                                                            i37 = z3;
                                                                            i45 = i53;
                                                                            i4 = i10;
                                                                            i11 = i51;
                                                                        }
                                                                    } else {
                                                                    }
                                                                } else {
                                                                }
                                                            } else {
                                                            }
                                                        } else {
                                                        }
                                                        int i85 = ordinal;
                                                        obj46 = i36;
                                                        z = z13;
                                                        eVar4 = eVar10;
                                                        i36 = iVar12;
                                                        d.c(iVar12, iVar2, d10.e(), f16, iVar8, iVar10, d11.e(), i45);
                                                        i51 = i11;
                                                        i10 = i4;
                                                    } else {
                                                        obj40 = iVar10;
                                                        eVar4 = eVar2;
                                                        z = z13;
                                                        obj46 = i36;
                                                        i36 = iVar12;
                                                        i37 = z3;
                                                    }
                                                    if (obj.j0 == 8 && !d11.l()) {
                                                        if (!d11.l()) {
                                                        }
                                                    }
                                                    if (i26 != 0) {
                                                        if (i37 != 0 && iVar2 != iVar8 && i33 == 0) {
                                                            if (iVar2 != iVar8) {
                                                                if (i33 == 0) {
                                                                    if (!z7 instanceof a) {
                                                                        if (z instanceof a) {
                                                                            i51 = z8;
                                                                        }
                                                                    } else {
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        iVar18.h(i36, iVar2, d10.e(), i51);
                                                        iVar18.j(obj40, iVar8, -i60, i51);
                                                    } else {
                                                        iVar3 = obj40;
                                                    }
                                                    if (i37 != 0 && z21 && !z7 instanceof a && !z instanceof a) {
                                                        if (z21) {
                                                            if (!z7 instanceof a) {
                                                                if (!z instanceof a) {
                                                                    if (z != eVar4) {
                                                                        i51 = i30;
                                                                        i10 = 1;
                                                                    } else {
                                                                        i30 = i3;
                                                                    }
                                                                } else {
                                                                    eVar = eVar4;
                                                                }
                                                            } else {
                                                            }
                                                        } else {
                                                        }
                                                    } else {
                                                    }
                                                    if (i10 != 0 && i2 != 0) {
                                                        if (i2 != 0) {
                                                            if (z20) {
                                                                if (z4) {
                                                                    if (z7 != eVar) {
                                                                        if (z == eVar) {
                                                                            i8 = z8;
                                                                        } else {
                                                                            i8 = i30;
                                                                        }
                                                                    } else {
                                                                    }
                                                                    if (!z7 instanceof g) {
                                                                        if (z instanceof g) {
                                                                            i8 = 5;
                                                                        }
                                                                    } else {
                                                                    }
                                                                    if (!z7 instanceof a) {
                                                                        if (z instanceof a) {
                                                                            i8 = 5;
                                                                        }
                                                                    } else {
                                                                    }
                                                                    if (z20) {
                                                                        i8 = 5;
                                                                    }
                                                                    i30 = Math.max(i8, i30);
                                                                }
                                                            } else {
                                                            }
                                                        }
                                                        i30 = Math.min(i51, i30);
                                                        if (i37 != 0 && z17 && !z20) {
                                                            i30 = Math.min(i51, i30);
                                                            if (z17) {
                                                                if (!z20) {
                                                                    if (z7 != eVar) {
                                                                        if (z == eVar) {
                                                                            i30 = 4;
                                                                        }
                                                                    } else {
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        iVar18.e(i36, iVar2, d10.e(), i30);
                                                        iVar18.e(iVar3, iVar8, -i58, i30);
                                                    }
                                                    if (i37 != 0) {
                                                        eVar = i6;
                                                        if (eVar == iVar2) {
                                                            i30 = d10.e();
                                                        } else {
                                                            i30 = 0;
                                                        }
                                                        if (iVar2 != eVar) {
                                                            iVar18.h(i36, eVar, i30, 5);
                                                        } else {
                                                            i52 = 5;
                                                        }
                                                    } else {
                                                    }
                                                    if (i37 != 0 && i33 != 0) {
                                                        if (i33 != 0) {
                                                            if (i14 == 0 && i48 == 0) {
                                                                if (i48 == 0) {
                                                                    if (i33 != 0 && ordinal == 3) {
                                                                        if (ordinal == 3) {
                                                                            iVar18.h(iVar3, i36, 0, 8);
                                                                        } else {
                                                                            iVar18.h(iVar3, i36, 0, i52);
                                                                        }
                                                                    } else {
                                                                    }
                                                                } else {
                                                                    i5 = 0;
                                                                }
                                                            } else {
                                                            }
                                                        } else {
                                                            iVar10 = i52;
                                                        }
                                                    } else {
                                                    }
                                                } else {
                                                }
                                            } else {
                                            }
                                        }
                                    } else {
                                    }
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                } else {
                }
                if (i37 != 0 && obj46 != null) {
                    if (obj46 != null) {
                        iVar10 = d11;
                        if (iVar10.f != null) {
                            iVar2 = d11.e();
                            i30 = i7;
                        } else {
                            i30 = i7;
                            iVar2 = i5;
                        }
                        i5 = obj.W;
                        if (iVar8 != i30 && obj.h && iVar3.y && i5 != null) {
                            if (obj.h) {
                                if (iVar3.y) {
                                    i5 = obj.W;
                                    if (i5 != null) {
                                        if (z2) {
                                            (f)i5.p1(iVar10);
                                        } else {
                                            i5.u1(iVar10);
                                        }
                                    }
                                }
                            }
                            iVar18.h(i30, iVar3, iVar2, i20);
                        }
                    }
                }
            }
        }
        iVar6 = i7;
        iVar5 = iVar10;
        obj46 = i36;
        i32 = 0;
        iVar4 = i6;
        iVar9 = iVar12;
        cmp = z12;
        mATCH_CONSTRAINT = 2;
    }

    public int A() {
        return this.I;
    }

    public void A0(int i, int i2, int i3, int i4) {
        d.f.a.m.e.b bVar;
        int mATCH_CONSTRAINT;
        d.f.a.m.e.b fIXED;
        d.f.a.m.e.b[] obj4;
        int obj5;
        int obj6;
        int obj7;
        this.b0 = i;
        this.c0 = i2;
        obj5 = 0;
        if (this.j0 == 8) {
            this.X = obj5;
            this.Y = obj5;
        }
        obj4 = this.V;
        fIXED = e.b.FIXED;
        bVar = this.X;
        if (obj4[obj5] == fIXED && i3 -= i < bVar) {
            bVar = this.X;
            if (i3 -= i < bVar) {
                obj6 = bVar;
            }
        }
        mATCH_CONSTRAINT = 1;
        fIXED = this.Y;
        if (obj4[mATCH_CONSTRAINT] == fIXED && i4 -= i2 < fIXED) {
            fIXED = this.Y;
            if (i4 -= i2 < fIXED) {
                obj7 = fIXED;
            }
        }
        this.X = obj6;
        this.Y = obj7;
        int i6 = this.f0;
        if (obj7 < i6) {
            this.Y = i6;
        }
        int i7 = this.e0;
        if (obj6 < i7) {
            this.X = i7;
        }
        int i8 = this.w;
        if (i8 > 0 && obj4[obj5] == e.b.MATCH_CONSTRAINT) {
            if (obj4[obj5] == e.b.MATCH_CONSTRAINT) {
                this.X = Math.min(this.X, i8);
            }
        }
        obj4 = this.z;
        if (obj4 > 0 && this.V[mATCH_CONSTRAINT] == e.b.MATCH_CONSTRAINT) {
            if (this.V[mATCH_CONSTRAINT] == e.b.MATCH_CONSTRAINT) {
                this.Y = Math.min(this.Y, obj4);
            }
        }
        obj4 = this.X;
        if (obj6 != obj4) {
            this.j = obj4;
        }
        obj4 = this.Y;
        if (obj7 != obj4) {
            this.k = obj4;
        }
    }

    public int B() {
        return this.J;
    }

    public void B0(boolean z) {
        this.F = z;
    }

    public int C(int i) {
        if (i == 0) {
            return R();
        }
        if (i == 1) {
            return v();
        }
        return 0;
    }

    public void C0(int i) {
        this.Y = i;
        final int i2 = this.f0;
        if (i < i2) {
            this.Y = i2;
        }
    }

    public int D() {
        return this.D[1];
    }

    public void D0(float f) {
        this.g0 = f;
    }

    public int E() {
        return this.D[0];
    }

    public void E0(int i) {
        this.m0 = i;
    }

    public int F() {
        return this.f0;
    }

    public void F0(int i, int i2) {
        this.b0 = i;
        i2 -= i;
        this.X = obj2;
        final int obj1 = this.e0;
        if (obj2 < obj1) {
            this.X = obj1;
        }
    }

    public int G() {
        return this.e0;
    }

    public void G0(d.f.a.m.e.b e$b) {
        this.V[0] = b;
    }

    public d.f.a.m.e H(int i) {
        d.f.a.m.d dVar2;
        d.f.a.m.d dVar;
        d.f.a.m.d obj3;
        if (i == 0) {
            obj3 = this.M;
            dVar2 = obj3.f;
            if (dVar2 != null && dVar2.f == obj3) {
                if (dVar2.f == obj3) {
                    return dVar2.d;
                }
            }
        } else {
            obj3 = this.N;
            dVar2 = obj3.f;
            if (i == 1 && dVar2 != null && dVar2.f == obj3) {
                obj3 = this.N;
                dVar2 = obj3.f;
                if (dVar2 != null) {
                    if (dVar2.f == obj3) {
                        return dVar2.d;
                    }
                }
            }
        }
        return null;
    }

    public void H0(int i, int i2, int i3, float f4) {
        int obj1;
        int obj2;
        int obj3;
        this.s = i;
        this.v = i2;
        if (i3 == Integer.MAX_VALUE) {
            obj3 = 0;
        }
        this.w = obj3;
        this.x = f4;
        if (Float.compare(f4, obj2) > 0 && Float.compare(f4, obj2) < 0 && i == 0) {
            if (Float.compare(f4, obj2) < 0) {
                if (i == 0) {
                    this.s = 2;
                }
            }
        }
    }

    public d.f.a.m.e I() {
        return this.W;
    }

    public void I0(float f) {
        this.o0[0] = f;
    }

    public d.f.a.m.e J(int i) {
        d.f.a.m.d dVar;
        d.f.a.m.d dVar2;
        d.f.a.m.d obj3;
        if (i == 0) {
            obj3 = this.K;
            dVar = obj3.f;
            if (dVar != null && dVar.f == obj3) {
                if (dVar.f == obj3) {
                    return dVar.d;
                }
            }
        } else {
            obj3 = this.L;
            dVar = obj3.f;
            if (i == 1 && dVar != null && dVar.f == obj3) {
                obj3 = this.L;
                dVar = obj3.f;
                if (dVar != null) {
                    if (dVar.f == obj3) {
                        return dVar.d;
                    }
                }
            }
        }
        return null;
    }

    protected void J0(int i, boolean z2) {
        this.U[i] = z2;
    }

    public int K() {
        return i += i3;
    }

    public void K0(boolean z) {
        this.G = z;
    }

    public p L(int i) {
        if (i == 0) {
            return this.d;
        }
        if (i == 1) {
            return this.e;
        }
        return null;
    }

    public void L0(boolean z) {
        this.H = z;
    }

    public float M() {
        return this.h0;
    }

    public void M0(int i, int i2) {
        this.I = i;
        this.J = i2;
        P0(false);
    }

    public int N() {
        return this.n0;
    }

    public void N0(int i) {
        this.D[1] = i;
    }

    public d.f.a.m.e.b O() {
        return this.V[1];
    }

    public void O0(int i) {
        this.D[0] = i;
    }

    public int P() {
        d.f.a.m.d dVar;
        d.f.a.m.d dVar2;
        int i;
        if (this.K != null) {
            i += dVar;
        }
        if (this.M != null) {
            i += dVar2;
        }
        return i;
    }

    public void P0(boolean z) {
        this.g = z;
    }

    public int Q() {
        return this.j0;
    }

    public void Q0(int i) {
        int obj1;
        if (i < 0) {
            this.f0 = 0;
        } else {
            this.f0 = i;
        }
    }

    public int R() {
        if (this.j0 == 8) {
            return 0;
        }
        return this.X;
    }

    public void R0(int i) {
        int obj1;
        if (i < 0) {
            this.e0 = 0;
        } else {
            this.e0 = i;
        }
    }

    public int S() {
        boolean z;
        d.f.a.m.e eVar = this.W;
        if (eVar != null && eVar instanceof f) {
            if (eVar instanceof f) {
                return c0 += i3;
            }
        }
        return this.b0;
    }

    public void S0(int i, int i2) {
        this.b0 = i;
        this.c0 = i2;
    }

    public int T() {
        boolean z;
        d.f.a.m.e eVar = this.W;
        if (eVar != null && eVar instanceof f) {
            if (eVar instanceof f) {
                return d0 += i3;
            }
        }
        return this.c0;
    }

    public void T0(d.f.a.m.e e) {
        this.W = e;
    }

    public boolean U() {
        return this.F;
    }

    public void U0(float f) {
        this.h0 = f;
    }

    public boolean V(int i) {
        int i5;
        int i3;
        int i4;
        int i2;
        int obj5;
        final int i6 = 2;
        i5 = 1;
        final int i7 = 0;
        if (i == 0) {
            obj5 = obj5.f != null ? i5 : i7;
            i2 = dVar5.f != null ? i5 : i7;
            if (obj5 += i2 < i6) {
            } else {
                i5 = i7;
            }
            return i5;
        }
        obj5 = obj5.f != null ? i5 : i7;
        i3 = dVar.f != null ? i5 : i7;
        i4 = dVar3.f != null ? i5 : i7;
        if (obj5 += i4 < i6) {
        } else {
            i5 = i7;
        }
        return i5;
    }

    public void V0(int i) {
        this.n0 = i;
    }

    public boolean W() {
        int i;
        boolean z;
        final int i3 = 0;
        i = i3;
        while (i < this.T.size()) {
            i++;
        }
        return i3;
    }

    public void W0(int i, int i2) {
        this.c0 = i;
        i2 -= i;
        this.Y = obj2;
        final int obj1 = this.f0;
        if (obj2 < obj1) {
            this.Y = obj1;
        }
    }

    public boolean X() {
        int i;
        int i2;
        final int i3 = -1;
        if (this.j == i3) {
            if (this.k != i3) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public void X0(d.f.a.m.e.b e$b) {
        this.V[1] = b;
    }

    public boolean Y(int i, int i2) {
        int i3;
        d.f.a.m.d obj5;
        i3 = 1;
        final int i4 = 0;
        if (i == 0) {
            obj5 = obj5.f;
            obj5 = obj5.f;
            if (obj5 != null && obj5.m() && obj5 != null && obj5.m()) {
                if (obj5.m()) {
                    obj5 = obj5.f;
                    if (obj5 != null) {
                        if (obj5.m()) {
                            if (obj5 -= i10 >= i2) {
                            } else {
                                i3 = i4;
                            }
                            return i3;
                        }
                    }
                }
            }
        } else {
            obj5 = obj5.f;
            obj5 = obj5.f;
            if (obj5 != null && obj5.m() && obj5 != null && obj5.m()) {
                if (obj5.m()) {
                    obj5 = obj5.f;
                    if (obj5 != null) {
                        if (obj5.m()) {
                            if (obj5 -= i7 >= i2) {
                            } else {
                                i3 = i4;
                            }
                            return i3;
                        }
                    }
                }
            }
        }
        return i4;
    }

    public void Y0(int i, int i2, int i3, float f4) {
        int obj1;
        int obj2;
        int obj3;
        this.t = i;
        this.y = i2;
        if (i3 == Integer.MAX_VALUE) {
            obj3 = 0;
        }
        this.z = obj3;
        this.A = f4;
        if (Float.compare(f4, obj2) > 0 && Float.compare(f4, obj2) < 0 && i == 0) {
            if (Float.compare(f4, obj2) < 0) {
                if (i == 0) {
                    this.t = 2;
                }
            }
        }
    }

    public void Z(d.f.a.m.d.b d$b, d.f.a.m.e e2, d.f.a.m.d.b d$b3, int i4, int i5) {
        m(b).a(e2.m(b3), i4, i5, true);
    }

    public void Z0(float f) {
        this.o0[1] = f;
    }

    public void a1(int i) {
        this.j0 = i;
    }

    public boolean b0() {
        return this.n;
    }

    public void b1(int i) {
        this.X = i;
        final int i2 = this.e0;
        if (i < i2) {
            this.X = i2;
        }
    }

    public boolean c0(int i) {
        return this.U[i];
    }

    public void c1(int i) {
        int i2;
        if (i >= 0 && i <= 3) {
            if (i <= 3) {
                this.r = i;
            }
        }
    }

    public boolean d0() {
        d.f.a.m.d dVar;
        d.f.a.m.d dVar2;
        dVar = this.K;
        dVar2 = dVar.f;
        if (dVar2 != null) {
            dVar = this.M;
            dVar2 = dVar.f;
            if (dVar2.f != dVar && dVar2 != null && dVar2.f == dVar) {
                dVar = this.M;
                dVar2 = dVar.f;
                if (dVar2 != null) {
                    if (dVar2.f == dVar) {
                    }
                }
            }
            return 1;
        } else {
        }
        return 0;
    }

    public void d1(int i) {
        this.b0 = i;
    }

    public void e(d.f.a.m.f f, d d2, HashSet<d.f.a.m.e> hashSet3, int i4, boolean z5) {
        boolean next;
        d.f.a.m.e eVar;
        d.f.a.m.f fVar;
        d dVar;
        HashSet set;
        int i2;
        int i;
        boolean obj12;
        if (z5 && !hashSet3.contains(this)) {
            if (!hashSet3.contains(this)) {
            }
            j.a(f, d2, this);
            hashSet3.remove(this);
            g(d2, f.J1(64));
        }
        if (i4 == 0) {
            obj12 = this.K.c();
            if (obj12 != null) {
                obj12 = obj12.iterator();
                for (d next : obj12) {
                    next.d.e(f, d2, hashSet3, i4, true);
                }
            }
            obj12 = this.M.c();
            if (obj12 != null) {
                obj12 = obj12.iterator();
                for (d next : obj12) {
                    next.d.e(f, d2, hashSet3, i4, true);
                }
            }
        } else {
            obj12 = this.L.c();
            if (obj12 != null) {
                obj12 = obj12.iterator();
                for (d next : obj12) {
                    next.d.e(f, d2, hashSet3, i4, true);
                }
            }
            obj12 = this.N.c();
            if (obj12 != null) {
                obj12 = obj12.iterator();
                for (d next : obj12) {
                    next.d.e(f, d2, hashSet3, i4, true);
                }
            }
            obj12 = this.O.c();
            if (obj12 != null) {
                obj12 = obj12.iterator();
                for (d next : obj12) {
                    next.d.e(f, d2, hashSet3, i4, true);
                }
            }
        }
    }

    public boolean e0() {
        return this.G;
    }

    public void e1(int i) {
        this.c0 = i;
    }

    boolean f() {
        int i;
        boolean z;
        if (!this instanceof k) {
            if (this instanceof g) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public boolean f0() {
        d.f.a.m.d dVar;
        d.f.a.m.d dVar2;
        dVar = this.L;
        dVar2 = dVar.f;
        if (dVar2 != null) {
            dVar = this.N;
            dVar2 = dVar.f;
            if (dVar2.f != dVar && dVar2 != null && dVar2.f == dVar) {
                dVar = this.N;
                dVar2 = dVar.f;
                if (dVar2 != null) {
                    if (dVar2.f == dVar) {
                    }
                }
            }
            return 1;
        } else {
        }
        return 0;
    }

    public void f1(boolean z, boolean z2, boolean z3, boolean z4) {
        int obj4;
        int obj5;
        int obj6;
        obj5 = 1065353216;
        final int i = 0;
        final int i2 = -1;
        final int i3 = 1;
        if (this.B == i2) {
            if (z3 != 0 && !z4) {
                if (!z4) {
                    this.B = i;
                } else {
                    this.B = i3;
                    if (z3 == 0 && z4 && this.a0 == i2) {
                        if (z4) {
                            this.B = i3;
                            if (this.a0 == i2) {
                                this.C = obj5 / obj4;
                            }
                        }
                    }
                }
            } else {
            }
        }
        if (this.B == 0) {
            if (this.L.n()) {
                if (!this.N.n()) {
                    this.B = i3;
                } else {
                    if (this.B == i3) {
                        if (this.K.n()) {
                            if (!this.M.n()) {
                                this.B = i;
                            }
                        } else {
                        }
                    }
                }
            } else {
            }
        } else {
        }
        if (this.B == i2) {
            if (this.L.n() && this.N.n() && this.K.n()) {
                if (this.N.n()) {
                    if (this.K.n()) {
                        if (!this.M.n()) {
                            if (this.L.n() && this.N.n()) {
                                if (this.N.n()) {
                                    this.B = i;
                                } else {
                                    if (this.K.n() && this.M.n()) {
                                        if (this.M.n()) {
                                            this.C = obj5 / obj4;
                                            this.B = i3;
                                        }
                                    }
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        }
        if (this.B == i2) {
            obj4 = this.v;
            if (obj4 > 0 && this.y == 0) {
                if (this.y == 0) {
                    this.B = i;
                } else {
                    if (obj4 == null && this.y > 0) {
                        if (this.y > 0) {
                            this.C = obj5 /= obj4;
                            this.B = i3;
                        }
                    }
                }
            } else {
            }
        }
    }

    public void g(d d, boolean z2) {
        d.f.a.m.e eVar3;
        int i20;
        boolean z6;
        boolean z;
        d.f.a.m.e eVar4;
        boolean eVar;
        int i34;
        int i32;
        d.f.a.m.e.b bVar;
        d.f.a.m.e i16;
        Object eVar2;
        Object eVar7;
        int i39;
        boolean z5;
        d.f.a.m.e.b bVar6;
        Object eVar6;
        Object eVar5;
        int i44;
        int i5;
        int i26;
        int i3;
        int i28;
        int i11;
        d.f.a.m.m.f i33;
        i iVar13;
        int i17;
        int i49;
        int i7;
        int i45;
        int i22;
        int i38;
        int wRAP_CONTENT2;
        int i46;
        int i2;
        int bVar2;
        int i9;
        int i12;
        d.f.a.m.e.b mATCH_CONSTRAINT;
        int i43;
        int i48;
        int i42;
        int i40;
        int i24;
        Object obj;
        int i8;
        int i10;
        float f3;
        int i41;
        int i36;
        int i;
        int i37;
        int i21;
        int iVar5;
        i iVar12;
        int iVar2;
        int i27;
        i iVar6;
        d.f.a.m.e.b bVar3;
        d.f.a.m.e.b wRAP_CONTENT;
        d.f.a.m.e.b bVar5;
        Object obj3;
        Object obj2;
        int i6;
        float f4;
        int i19;
        int i23;
        boolean z7;
        int i25;
        int i47;
        boolean z4;
        int i15;
        int cmp;
        int i13;
        float f2;
        i iVar10;
        boolean z3;
        boolean z8;
        i iVar14;
        i iVar3;
        i iVar9;
        i iVar4;
        i iVar7;
        i iVar15;
        int i30;
        int i31;
        int i4;
        int i50;
        int i18;
        float f;
        int i51;
        int i35;
        int i29;
        d.f.a.m.d dVar;
        int i14;
        d.f.a.m.e.b bVar4;
        i iVar11;
        i iVar;
        i iVar8;
        d.f.a.m.e.b bVar7;
        obj3 = this;
        bVar3 = d;
        iVar2 = bVar3.q(obj3.K);
        iVar5 = bVar3.q(obj3.M);
        i iVar19 = bVar3.q(obj3.L);
        i iVar17 = bVar3.q(obj3.N);
        i iVar16 = bVar3.q(obj3.O);
        eVar3 = obj3.W;
        i48 = 1;
        int i90 = 0;
        if (eVar3 != null) {
            if (eVar3 != null && eVar3.V[i90] == e.b.WRAP_CONTENT) {
                i17 = eVar3.V[i90] == e.b.WRAP_CONTENT ? i48 : i90;
            } else {
            }
            if (eVar3 != null && eVar3.V[i48] == e.b.WRAP_CONTENT) {
                eVar3 = eVar3.V[i48] == e.b.WRAP_CONTENT ? i48 : i90;
            } else {
            }
            wRAP_CONTENT2 = obj3.r;
            if (wRAP_CONTENT2 != i48) {
                if (wRAP_CONTENT2 != 2) {
                    if (wRAP_CONTENT2 != 3) {
                        i12 = eVar3;
                        i9 = i17;
                    } else {
                        i12 = i9;
                    }
                } else {
                    i12 = eVar3;
                    i9 = i90;
                }
            } else {
                i9 = i17;
                i12 = i90;
            }
        } else {
        }
        int i88 = 8;
        i20 = obj3.U;
        if (obj3.j0 == i88 && !W() && !i20[i90] && !i20[i48]) {
            if (!W()) {
                i20 = obj3.U;
                if (!i20[i90]) {
                    if (!i20[i48]) {
                    }
                }
            }
        }
        z6 = obj3.l;
        i49 = 5;
        if (!z6) {
            bVar3.f(iVar2, obj3.b0);
            bVar3.f(iVar5, i53 += i8);
            z6 = obj3.W;
            if (obj3.m && z6 && i9 != 0 && z6 != null) {
                if (z6) {
                    bVar3.f(iVar2, obj3.b0);
                    bVar3.f(iVar5, i53 += i8);
                    if (i9 != 0) {
                        z6 = obj3.W;
                        if (z6 != null) {
                            if (obj3.i) {
                                (f)z6.q1(obj3.K);
                                z6.p1(obj3.M);
                            } else {
                                bVar3.h(bVar3.q(z6.M), iVar5, i90, i49);
                            }
                        }
                    }
                }
                bVar3.f(iVar19, obj3.c0);
                bVar3.f(iVar17, i55 += i8);
                if (obj3.m && obj3.O.l()) {
                    bVar3.f(iVar19, obj3.c0);
                    bVar3.f(iVar17, i55 += i8);
                    if (obj3.O.l()) {
                        bVar3.f(iVar16, i57 += i8);
                    }
                    z = obj3.W;
                    if (i12 != 0 && z != null) {
                        z = obj3.W;
                        if (z != null) {
                            if (obj3.i) {
                                (f)z.v1(obj3.L);
                                z.u1(obj3.N);
                            } else {
                                bVar3.h(bVar3.q(z.N), iVar17, i90, i49);
                            }
                        }
                    }
                }
                if (obj3.l && obj3.m) {
                    if (obj3.m) {
                        obj3.l = i90;
                        obj3.m = i90;
                    }
                }
            }
        } else {
        }
        d.f.a.e eVar8 = d.x;
        i19 = 1;
        if (eVar8 != null) {
            eVar8.y = l3 += i19;
        }
        i5 = obj3.d;
        i49 = obj3.e;
        i8 = i5.h;
        if (z2 && i5 != null && i49 != null && i8.j && fVar10.j && fVar11.j && fVar12.j && eVar8 != null) {
            i5 = obj3.d;
            if (i5 != null) {
                i49 = obj3.e;
                if (i49 != null) {
                    i8 = i5.h;
                    if (i8.j) {
                        if (fVar10.j) {
                            if (fVar11.j) {
                                if (fVar12.j) {
                                    if (eVar8 != null) {
                                        eVar8.r = l += i19;
                                    }
                                    bVar3.f(iVar2, i8.g);
                                    bVar3.f(iVar5, fVar.g);
                                    bVar3.f(iVar19, fVar2.g);
                                    bVar3.f(iVar17, fVar3.g);
                                    bVar3.f(iVar16, fVar4.g);
                                    if (obj3.W != null && i9 != 0 && obj3.f[i90] && !d0()) {
                                        if (i9 != 0) {
                                            if (obj3.f[i90]) {
                                                if (!d0()) {
                                                    bVar3.h(bVar3.q(eVar10.M), iVar5, i90, i88);
                                                }
                                            }
                                        }
                                        if (i12 != 0 && obj3.f[1] && !f0()) {
                                            if (obj3.f[1]) {
                                                if (!f0()) {
                                                    bVar3.h(bVar3.q(eVar9.N), iVar17, i90, i88);
                                                }
                                            }
                                        }
                                    }
                                    obj3.l = i90;
                                    obj3.m = i90;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (eVar8 != null) {
            eVar8.s = l2 += i19;
        }
        if (obj3.W != null) {
            if (obj3.a0(i90)) {
                (f)obj3.W.m1(obj3, i90);
                eVar = 1;
            } else {
                eVar = d0();
            }
            int i76 = 1;
            if (obj3.a0(i76)) {
                (f)obj3.W.m1(obj3, i76);
                i5 = 1;
            } else {
                i5 = f0();
            }
            if (!eVar && i9 != 0 && obj3.j0 != i88 && dVar27.f == null && dVar28.f == null) {
                if (i9 != 0) {
                    if (obj3.j0 != i88) {
                        if (dVar27.f == null) {
                            if (dVar28.f == null) {
                                bVar3.h(bVar3.q(eVar13.M), iVar5, i90, 1);
                            }
                        }
                    }
                }
            }
            if (!i5 && i12 != 0 && obj3.j0 != i88 && dVar30.f == null && dVar31.f == null && obj3.O == null) {
                if (i12 != 0) {
                    if (obj3.j0 != i88) {
                        if (dVar30.f == null) {
                            if (dVar31.f == null) {
                                if (obj3.O == null) {
                                    bVar3.h(bVar3.q(eVar14.N), iVar17, i90, 1);
                                }
                            }
                        }
                    }
                }
            }
            z8 = eVar;
            z3 = i5;
        } else {
            z8 = z3;
        }
        int i63 = obj3.X;
        if (i63 < obj3.e0) {
        } else {
            i26 = i63;
        }
        i7 = obj3.Y;
        if (i7 < obj3.f0) {
        } else {
            i42 = i7;
        }
        d.f.a.m.e.b[] objArr7 = obj3.V;
        mATCH_CONSTRAINT = e.b.MATCH_CONSTRAINT;
        int i99 = i26;
        i46 = objArr7[i90] != mATCH_CONSTRAINT ? 1 : 0;
        i15 = i42;
        i3 = objArr7[1] != mATCH_CONSTRAINT ? 1 : 0;
        i40 = obj3.a0;
        obj3.B = i40;
        iVar10 = iVar16;
        f3 = obj3.Z;
        obj3.C = f3;
        i iVar23 = iVar17;
        i36 = obj3.s;
        i iVar24 = iVar19;
        i37 = obj3.t;
        i13 = 4;
        iVar9 = iVar5;
        if (Float.compare(f3, i100) > 0) {
            iVar7 = iVar2;
            if (obj3.j0 != 8) {
                if (objArr7[0] == mATCH_CONSTRAINT && i36 == 0) {
                    if (i36 == 0) {
                        i36 = 3;
                    }
                }
                int i92 = 1;
                if (objArr7[i92] == mATCH_CONSTRAINT && i37 == 0) {
                    if (i37 == 0) {
                        i37 = 3;
                    }
                }
                if (objArr7[0] == mATCH_CONSTRAINT && objArr7[i92] == mATCH_CONSTRAINT) {
                    if (objArr7[i92] == mATCH_CONSTRAINT) {
                        iVar5 = 3;
                        if (i36 == iVar5 && i37 == iVar5) {
                            if (i37 == iVar5) {
                                obj3.f1(i9, i12, i46, i3);
                                i34 = 0;
                                i50 = i36;
                                i4 = i37;
                                i28 = i99;
                                i31 = i15;
                                i30 = 1;
                            } else {
                                int i77 = 0;
                                if (objArr7[i77] == mATCH_CONSTRAINT && i36 == iVar5) {
                                    if (i36 == iVar5) {
                                        obj3.B = i77;
                                        i28 = (int)f3;
                                        i7 = 1;
                                        if (objArr7[i7] != mATCH_CONSTRAINT) {
                                            i4 = i37;
                                            i31 = i15;
                                            i50 = i13;
                                            i34 = 0;
                                            i30 = 0;
                                        } else {
                                            i30 = i7;
                                            i50 = i36;
                                            i4 = i37;
                                            i31 = i15;
                                            i34 = 0;
                                        }
                                    } else {
                                        i46 = objArr7;
                                        i7 = 1;
                                        if (i46[i7] == mATCH_CONSTRAINT && i37 == 3) {
                                            if (i37 == 3) {
                                                obj3.B = i7;
                                                if (i40 == -1) {
                                                    obj3.C = i79 /= f3;
                                                }
                                                i40 = (int)i78;
                                                i34 = 0;
                                                if (i46[i34] != mATCH_CONSTRAINT) {
                                                    i30 = i34;
                                                    i31 = i40;
                                                    i50 = i36;
                                                    i28 = i99;
                                                    i4 = i13;
                                                } else {
                                                    i31 = i40;
                                                    i50 = i36;
                                                    i4 = i37;
                                                    i28 = i99;
                                                }
                                            } else {
                                            }
                                        } else {
                                        }
                                    }
                                } else {
                                }
                            }
                        } else {
                        }
                    } else {
                        iVar5 = 3;
                    }
                } else {
                }
            } else {
                i30 = i34;
                i50 = i36;
                i4 = i37;
                i28 = i99;
                i31 = i15;
            }
        } else {
            iVar7 = iVar2;
        }
        int[] iArr = obj3.u;
        iArr[i34] = i50;
        iArr[1] = i4;
        if (i30 != 0) {
            i32 = obj3.B;
            if (i32 != 0) {
                i25 = i32 == -1 ? 1 : 0;
            } else {
            }
        } else {
            i45 = -1;
        }
        if (i30 != 0) {
            i32 = obj3.B;
            if (i32 != 1) {
                i18 = i32 == i45 ? 1 : 0;
            } else {
            }
        } else {
        }
        wRAP_CONTENT = e.b.WRAP_CONTENT;
        if (obj3.V[0] == wRAP_CONTENT && obj3 instanceof f) {
            i41 = obj3 instanceof f ? 1 : 0;
        } else {
        }
        i27 = i41 != 0 ? 0 : i28;
        final int i101 = z10 ^ 1;
        boolean[] zArr3 = obj3.U;
        final int i102 = 0;
        if (obj3.p != 2 && !obj3.l) {
            if (!obj3.l) {
                i16 = obj3.d;
                i33 = i16.h;
                if (z2 && i16 != null && i33.j) {
                    i16 = obj3.d;
                    if (i16 != null) {
                        i33 = i16.h;
                        if (i33.j) {
                            if (!fVar5.j) {
                                d.f.a.m.e.b bVar16 = d;
                                int i89 = 8;
                                eVar2 = obj3.W;
                                if (eVar2 != null) {
                                    i40 = eVar2;
                                } else {
                                    i40 = i102;
                                }
                                eVar7 = obj3.W;
                                if (eVar7 != null) {
                                    i6 = eVar7;
                                } else {
                                    i6 = i102;
                                }
                                int i94 = 0;
                                d.f.a.m.e.b[] objArr2 = obj3.V;
                                int i98 = 1;
                                i29 = objArr2[i98] == mATCH_CONSTRAINT ? i98 : i94;
                                i51 = i9;
                                i14 = i12;
                                bVar4 = mATCH_CONSTRAINT;
                                iVar11 = iVar10;
                                iVar = iVar23;
                                iVar8 = iVar24;
                                iVar14 = iVar21;
                                iVar3 = iVar22;
                                bVar7 = wRAP_CONTENT;
                                this.i(d, true, i9, i12, obj3.f[i94], i6, i40, objArr2[i94], i41, obj3.K, obj3.M, obj3.b0, i27, obj3.e0, obj3.D[i94], obj3.g0, i25, i29, z8, z3, zArr3[0], i50, i4, obj3.v, obj3.w, obj3.x, i101);
                            } else {
                                if (z2) {
                                    iVar5 = d;
                                    i37 = iVar7;
                                    iVar5.f(i37, i33.g);
                                    i36 = iVar9;
                                    iVar5.f(i36, fVar6.g);
                                    i33 = 0;
                                    if (obj3.W != null && i9 != 0 && obj3.f[i33] && !d0()) {
                                        if (i9 != 0) {
                                            i33 = 0;
                                            if (obj3.f[i33]) {
                                                if (!d0()) {
                                                    iVar5.h(iVar5.q(eVar12.M), i36, i33, 8);
                                                }
                                            }
                                        }
                                    }
                                    i51 = i9;
                                    i14 = i12;
                                    bVar4 = mATCH_CONSTRAINT;
                                    bVar7 = wRAP_CONTENT;
                                    iVar11 = iVar10;
                                    iVar = iVar23;
                                    iVar8 = iVar24;
                                    iVar14 = i36;
                                    iVar3 = i37;
                                } else {
                                    iVar5 = d;
                                    i51 = i9;
                                    i14 = i12;
                                    bVar4 = mATCH_CONSTRAINT;
                                    bVar7 = wRAP_CONTENT;
                                    iVar11 = iVar10;
                                    iVar = iVar23;
                                    iVar8 = iVar24;
                                    iVar14 = iVar9;
                                    iVar3 = iVar7;
                                }
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
        if (z2) {
            obj2 = this;
            i16 = obj2.e;
            i33 = i16.h;
            if (i16 != null && i33.j && fVar7.j) {
                i33 = i16.h;
                if (i33.j) {
                    if (fVar7.j) {
                        bVar5 = d;
                        bVar5.f(iVar8, i33.g);
                        iVar12 = iVar;
                        bVar5.f(iVar12, fVar8.g);
                        bVar5.f(iVar11, fVar9.g);
                        i16 = obj2.W;
                        if (i16 != null && !z3 && i14 != 0) {
                            if (!z3) {
                                if (i14 != 0) {
                                    if (obj2.f[1]) {
                                        bVar5.h(bVar5.q(i16.N), iVar12, 0, 8);
                                    } else {
                                        i38 = 8;
                                        i = 0;
                                    }
                                } else {
                                    i38 = 8;
                                    i = 0;
                                    i21 = 1;
                                }
                            } else {
                            }
                        } else {
                        }
                        i24 = i;
                    } else {
                        bVar5 = d;
                        iVar13 = iVar11;
                        iVar12 = iVar;
                        iVar6 = iVar8;
                        i38 = 8;
                        i = 0;
                        i21 = 1;
                        i24 = i21;
                    }
                } else {
                }
            } else {
            }
        } else {
            i38 = 8;
            i = 0;
            i21 = 1;
            obj2 = this;
            bVar5 = d;
            iVar13 = iVar11;
            iVar12 = iVar;
            iVar6 = iVar8;
        }
        i43 = obj2.q == 2 ? i : i24;
        if (i43 != 0 && !obj2.m) {
            if (!obj2.m) {
                if (obj2.V[i21] == bVar7 && obj2 instanceof f) {
                    i41 = obj2 instanceof f ? i21 : i;
                } else {
                }
                if (i41 != 0) {
                    i31 = i;
                }
                eVar6 = obj2.W;
                if (eVar6 != null) {
                    i24 = eVar6;
                } else {
                    i24 = i102;
                }
                eVar5 = obj2.W;
                if (eVar5 != null) {
                    i43 = eVar5;
                } else {
                    i43 = i102;
                }
                if (obj2.d0 <= 0) {
                    if (obj2.j0 == i38) {
                        d.f.a.m.d dVar21 = obj2.O;
                        if (dVar21.f != null) {
                            bVar5.e(iVar13, iVar6, n(), i38);
                            bVar5.e(iVar13, bVar5.q(dVar22.f), obj2.O.e(), i38);
                            if (i14 != 0) {
                                bVar5.h(i24, bVar5.q(obj2.N), i, 5);
                            }
                            iVar10 = i;
                        } else {
                            if (obj2.j0 == i38) {
                                bVar5.e(iVar13, iVar6, dVar21.e(), i38);
                            } else {
                                bVar5.e(iVar13, iVar6, n(), i38);
                            }
                            iVar10 = i101;
                        }
                    } else {
                    }
                } else {
                }
                d.f.a.m.e.b[] objArr4 = obj2.V;
                int i95 = 0;
                i23 = objArr4[i95] == bVar4 ? 1 : i95;
                iVar4 = iVar12;
                iVar15 = iVar6;
                this.i(d, false, i14, i51, obj2.f[i21], i43, i24, objArr4[i21], i41, obj2.L, obj2.N, obj2.c0, i31, obj2.f0, obj2.D[i21], obj2.h0, i18, i23, z3, z8, zArr3[1], i4, i50, obj2.y, obj2.z, obj2.A, iVar10);
            } else {
                iVar4 = iVar12;
                iVar15 = iVar6;
            }
        } else {
        }
        if (i30 != 0) {
            obj = this;
            if (obj.B == 1) {
                d.k(iVar4, iVar15, iVar14, iVar3, obj.C, 8);
            } else {
                d.k(iVar14, iVar3, iVar4, iVar15, obj.C, 8);
            }
        } else {
            obj = this;
        }
        if (obj.R.n()) {
            int i86 = 1119092736;
            d.b(obj, obj.R.i().g(), (float)radians, obj.R.e());
        }
        int i71 = 0;
        obj.l = i71;
        obj.m = i71;
    }

    public boolean g0() {
        return this.H;
    }

    public void g1(boolean z, boolean z2) {
        int i8;
        int i5;
        int i7;
        int fIXED;
        int i;
        int i2;
        int i6;
        int i4;
        int i3;
        d.f.a.m.e.b obj8;
        int obj9;
        z &= z3;
        z2 &= z4;
        l lVar2 = this.d;
        i7 = fVar2.g;
        n nVar2 = this.e;
        i6 = fVar4.g;
        i8 = fVar.g;
        i = fVar3.g;
        final int i10 = 0;
        i4 = Integer.MIN_VALUE;
        i3 = Integer.MAX_VALUE;
        if (i8 - i7 >= 0 && i - i6 >= 0 && i7 != i4 && i7 != i3 && i6 != i4 && i6 != i3 && i8 != i4 && i8 != i3 && i != i4) {
            if (i - i6 >= 0) {
                i4 = Integer.MIN_VALUE;
                if (i7 != i4) {
                    i3 = Integer.MAX_VALUE;
                    if (i7 != i3) {
                        if (i6 != i4) {
                            if (i6 != i3) {
                                if (i8 != i4) {
                                    if (i8 != i3) {
                                        if (i != i4) {
                                            if (i == i3) {
                                                i6 = i;
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
        } else {
        }
        if (obj8 != null) {
            this.b0 = i7;
        }
        if (obj9 != null) {
            this.c0 = i6;
        }
        if (this.j0 == 8) {
            this.X = i10;
            this.Y = i10;
        }
        obj8 = this.X;
        if (obj8 != null && this.V[i10] == e.b.FIXED && i8 -= i7 < obj8) {
            if (this.V[i10] == e.b.FIXED) {
                obj8 = this.X;
                if (i8 -= i7 < obj8) {
                    i5 = obj8;
                }
            }
            this.X = i5;
            obj8 = this.e0;
            if (i5 < obj8) {
                this.X = obj8;
            }
        }
        obj8 = this.Y;
        if (obj9 != null && this.V[1] == e.b.FIXED && i -= i6 < obj8) {
            if (this.V[1] == e.b.FIXED) {
                obj8 = this.Y;
                if (i -= i6 < obj8) {
                    i2 = obj8;
                }
            }
            this.Y = i2;
            obj8 = this.f0;
            if (i2 < obj8) {
                this.Y = obj8;
            }
        }
    }

    public boolean h() {
        int i;
        i = this.j0 != 8 ? 1 : 0;
        return i;
    }

    public boolean h0() {
        boolean z;
        int i2;
        int i;
        if (this.g && this.j0 != 8) {
            i2 = this.j0 != 8 ? 1 : 0;
        } else {
        }
        return i2;
    }

    public void h1(d d, boolean z2) {
        int i4;
        int i2;
        int i3;
        Object dVar;
        int i;
        d.f.a.m.m.f fVar;
        boolean z;
        int obj7;
        Object obj8;
        i4 = d.x(this.K);
        i2 = d.x(this.L);
        i3 = d.x(this.M);
        obj7 = d.x(this.N);
        dVar = this.d;
        fVar = dVar.h;
        dVar = dVar.i;
        if (z2 != null && dVar != null && fVar.j && dVar.j) {
            dVar = this.d;
            if (dVar != null) {
                fVar = dVar.h;
                if (fVar.j) {
                    dVar = dVar.i;
                    if (dVar.j) {
                        i4 = fVar.g;
                        i3 = dVar.g;
                    }
                }
            }
        }
        obj8 = this.e;
        dVar = obj8.h;
        obj8 = obj8.i;
        if (z2 != null && obj8 != null && dVar.j && obj8.j) {
            obj8 = this.e;
            if (obj8 != null) {
                dVar = obj8.h;
                if (dVar.j) {
                    obj8 = obj8.i;
                    if (obj8.j) {
                        i2 = dVar.g;
                        obj7 = obj8.g;
                    }
                }
            }
        }
        obj8 = Integer.MIN_VALUE;
        i = Integer.MAX_VALUE;
        if (i3 - i4 >= 0 && obj7 - i2 >= 0 && i4 != obj8 && i4 != i && i2 != obj8 && i2 != i && i3 != obj8 && i3 != i && obj7 != obj8) {
            if (obj7 - i2 >= 0) {
                obj8 = Integer.MIN_VALUE;
                if (i4 != obj8) {
                    i = Integer.MAX_VALUE;
                    if (i4 != i) {
                        if (i2 != obj8) {
                            if (i2 != i) {
                                if (i3 != obj8) {
                                    if (i3 != i) {
                                        if (obj7 != obj8) {
                                            if (obj7 == i) {
                                                i3 = i2;
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
        } else {
        }
        A0(i4, i2, i3, obj7);
    }

    public boolean i0() {
        boolean z;
        int i;
        if (!this.l) {
            if (this.K.m() && this.M.m()) {
                if (this.M.m()) {
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

    public void j(d.f.a.m.e e, float f2, int i3) {
        final d.f.a.m.d.b cENTER = d.b.CENTER;
        this.Z(cENTER, e, cENTER, i3, 0);
        this.E = f2;
    }

    public boolean j0() {
        boolean z;
        int i;
        if (!this.m) {
            if (this.L.m() && this.N.m()) {
                if (this.N.m()) {
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

    public void k(d d) {
        int i;
        d.q(this.K);
        d.q(this.L);
        d.q(this.M);
        d.q(this.N);
        if (this.d0 > 0) {
            d.q(this.O);
        }
    }

    public boolean k0() {
        return this.o;
    }

    public void l() {
        l lVar;
        n nVar;
        if (this.d == null) {
            lVar = new l(this);
            this.d = lVar;
        }
        if (this.e == null) {
            nVar = new n(this);
            this.e = nVar;
        }
    }

    public void l0() {
        this.n = true;
    }

    public d.f.a.m.d m(d.f.a.m.d.b d$b) {
        switch (i) {
            case 1:
                return this.K;
            case 2:
                return this.L;
            case 3:
                return this.M;
            case 4:
                return this.N;
            case 5:
                return this.O;
            case 6:
                return this.R;
            case 7:
                return this.P;
            case 8:
                return this.Q;
            case 9:
                return null;
            default:
                AssertionError assertionError = new AssertionError(b.name());
                throw assertionError;
        }
    }

    public void m0() {
        this.o = true;
    }

    public int n() {
        return this.d0;
    }

    public boolean n0() {
        d.f.a.m.e.b[] objArr;
        int i;
        objArr = this.V;
        final d.f.a.m.e.b mATCH_CONSTRAINT = e.b.MATCH_CONSTRAINT;
        final int i2 = 1;
        if (objArr[0] == mATCH_CONSTRAINT && objArr[i2] == mATCH_CONSTRAINT) {
            if (objArr[i2] == mATCH_CONSTRAINT) {
                i = i2;
            }
        }
        return i;
    }

    public float o(int i) {
        if (i == 0) {
            return this.g0;
        }
        if (i == 1) {
            return this.h0;
        }
        return -1082130432;
    }

    public void o0() {
        this.K.p();
        this.L.p();
        this.M.p();
        this.N.p();
        this.O.p();
        this.P.p();
        this.Q.p();
        this.R.p();
        int i = 0;
        this.W = i;
        int i3 = 0;
        this.E = i3;
        final int i5 = 0;
        this.X = i5;
        this.Y = i5;
        this.Z = i3;
        int i4 = -1;
        this.a0 = i4;
        this.b0 = i5;
        this.c0 = i5;
        this.d0 = i5;
        this.e0 = i5;
        this.f0 = i5;
        float f = e.t0;
        this.g0 = f;
        this.h0 = f;
        d.f.a.m.e.b[] objArr = this.V;
        final d.f.a.m.e.b fIXED = e.b.FIXED;
        objArr[i5] = fIXED;
        final int i8 = 1;
        objArr[i8] = fIXED;
        this.i0 = i;
        this.j0 = i5;
        this.l0 = i;
        this.m0 = i5;
        this.n0 = i5;
        float[] fArr = this.o0;
        int i6 = -1082130432;
        fArr[i5] = i6;
        fArr[i8] = i6;
        this.p = i4;
        this.q = i4;
        int[] iArr = this.D;
        int i7 = Integer.MAX_VALUE;
        iArr[i5] = i7;
        iArr[i8] = i7;
        this.s = i5;
        this.t = i5;
        int i2 = 1065353216;
        this.x = i2;
        this.A = i2;
        this.w = i7;
        this.z = i7;
        this.v = i5;
        this.y = i5;
        this.B = i4;
        this.C = i2;
        boolean[] zArr = this.f;
        zArr[i5] = i8;
        zArr[i8] = i8;
        this.H = i5;
        boolean[] zArr2 = this.U;
        zArr2[i5] = i5;
        zArr2[i8] = i5;
        this.g = i8;
        int[] iArr2 = this.u;
        iArr2[i5] = i5;
        iArr2[i8] = i5;
        this.j = i4;
        this.k = i4;
    }

    public int p() {
        return i += i3;
    }

    public void p0() {
        int i;
        Object obj;
        i = 0;
        this.l = i;
        this.m = i;
        this.n = i;
        this.o = i;
        while (i < this.T.size()) {
            (d)this.T.get(i).q();
            i++;
        }
    }

    public Object q() {
        return this.i0;
    }

    public void q0(c c) {
        this.K.r(c);
        this.L.r(c);
        this.M.r(c);
        this.N.r(c);
        this.O.r(c);
        this.R.r(c);
        this.P.r(c);
        this.Q.r(c);
    }

    public String r() {
        return this.k0;
    }

    public void r0(int i) {
        int obj1;
        this.d0 = i;
        obj1 = i > 0 ? 1 : 0;
        this.F = obj1;
    }

    public d.f.a.m.e.b s(int i) {
        if (i == 0) {
            return y();
        }
        if (i == 1) {
            return O();
        }
        return null;
    }

    public void s0(Object object) {
        this.i0 = object;
    }

    public float t() {
        return this.Z;
    }

    public void t0(String string) {
        this.k0 = string;
    }

    public String toString() {
        String string2;
        Object stringBuilder;
        String string;
        String str;
        StringBuilder stringBuilder2 = new StringBuilder();
        final String str8 = " ";
        if (this.l0 != null) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("type: ");
            stringBuilder3.append(this.l0);
            stringBuilder3.append(str8);
            string2 = stringBuilder3.toString();
        } else {
            string2 = string;
        }
        stringBuilder2.append(string2);
        if (this.k0 != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("id: ");
            stringBuilder.append(this.k0);
            stringBuilder.append(str8);
            string = stringBuilder.toString();
        }
        stringBuilder2.append(string);
        stringBuilder2.append("(");
        stringBuilder2.append(this.b0);
        stringBuilder2.append(", ");
        stringBuilder2.append(this.c0);
        stringBuilder2.append(") - (");
        stringBuilder2.append(this.X);
        stringBuilder2.append(" x ");
        stringBuilder2.append(this.Y);
        stringBuilder2.append(")");
        return stringBuilder2.toString();
    }

    public int u() {
        return this.a0;
    }

    public void u0(String string) {
        int length2;
        int i;
        float substring2;
        int length;
        int indexOf;
        int equalsIgnoreCase2;
        int substring;
        boolean equalsIgnoreCase;
        float obj9;
        int i2 = 0;
        if (string != null) {
            if (string.length() == 0) {
            } else {
                i = -1;
                length = string.length();
                int indexOf2 = string.indexOf(44);
                equalsIgnoreCase2 = 0;
                final int i6 = 1;
                if (indexOf2 > 0 && indexOf2 < length + -1) {
                    if (indexOf2 < length + -1) {
                        substring = string.substring(equalsIgnoreCase2, indexOf2);
                        if (substring.equalsIgnoreCase("W")) {
                            i = equalsIgnoreCase2;
                        } else {
                            if (substring.equalsIgnoreCase("H")) {
                                i = i6;
                            }
                        }
                        equalsIgnoreCase2 = indexOf2 + 1;
                    }
                }
                indexOf = string.indexOf(58);
                if (indexOf >= 0 && indexOf < length -= i6) {
                    if (indexOf < length -= i6) {
                        substring2 = string.substring(equalsIgnoreCase2, indexOf);
                        obj9 = string.substring(indexOf += i6);
                        substring2 = Float.parseFloat(substring2);
                        obj9 = Float.parseFloat(obj9);
                        if (substring2.length() > 0 && obj9.length() > 0 && Float.compare(substring2, i2) > 0 && Float.compare(obj9, i2) > 0) {
                            if (obj9.length() > 0) {
                                substring2 = Float.parseFloat(substring2);
                                obj9 = Float.parseFloat(obj9);
                                if (Float.compare(substring2, i2) > 0) {
                                    if (Float.compare(obj9, i2) > 0) {
                                        if (i == i6) {
                                            obj9 = Math.abs(obj9 /= substring2);
                                        } else {
                                            obj9 = Math.abs(substring2 /= obj9);
                                        }
                                    } else {
                                        obj9 = i2;
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                        obj9 = string.substring(equalsIgnoreCase2);
                        if (obj9.length() > 0) {
                            obj9 = Float.parseFloat(obj9);
                        } else {
                        }
                    }
                } else {
                }
                if (Float.compare(obj9, i2) > 0) {
                    this.Z = obj9;
                    this.a0 = i;
                }
            }
        }
        this.Z = i2;
    }

    public int v() {
        if (this.j0 == 8) {
            return 0;
        }
        return this.Y;
    }

    public void v0(int i) {
        if (!this.F) {
        }
        int i3 = i - i2;
        this.c0 = i3;
        this.L.s(i3);
        this.N.s(i4 += i3);
        this.O.s(i);
        this.m = true;
    }

    public float w() {
        return this.g0;
    }

    public void w0(int i, int i2) {
        if (this.l) {
        }
        this.K.s(i);
        this.M.s(i2);
        this.b0 = i;
        this.X = i2 -= i;
        this.l = true;
    }

    public int x() {
        return this.m0;
    }

    public void x0(int i) {
        this.K.s(i);
        this.b0 = i;
    }

    public d.f.a.m.e.b y() {
        return this.V[0];
    }

    public void y0(int i) {
        this.L.s(i);
        this.c0 = i;
    }

    public int z() {
        d.f.a.m.d dVar;
        d.f.a.m.d dVar2;
        int i;
        dVar = this.K;
        if (dVar != null) {
            i += dVar;
        }
        dVar2 = this.M;
        if (dVar2 != null) {
            i += dVar2;
        }
        return i;
    }

    public void z0(int i, int i2) {
        d.f.a.m.d dVar;
        int obj2;
        boolean obj3;
        if (this.m) {
        }
        this.L.s(i);
        this.N.s(i2);
        this.c0 = i;
        this.Y = i2 -= i;
        if (this.F) {
            this.O.s(i += dVar);
        }
        this.m = true;
    }
}
