package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes2.dex */
public final class z4 extends com.google.android.gms.internal.measurement.w8<com.google.android.gms.internal.measurement.z4, com.google.android.gms.internal.measurement.y4> implements com.google.android.gms.internal.measurement.z9 {

    public static final int zza;
    private static final com.google.android.gms.internal.measurement.z4 zze;
    private boolean zzA;
    private String zzB;
    private long zzC;
    private int zzD;
    private String zzE;
    private String zzF;
    private boolean zzG;
    private com.google.android.gms.internal.measurement.c9<com.google.android.gms.internal.measurement.l4> zzH;
    private String zzI;
    private int zzJ;
    private int zzK;
    private int zzL;
    private String zzM;
    private long zzN;
    private long zzO;
    private String zzP;
    private String zzQ;
    private int zzR;
    private String zzS;
    private com.google.android.gms.internal.measurement.d5 zzT;
    private com.google.android.gms.internal.measurement.a9 zzU;
    private long zzV;
    private long zzW;
    private String zzX;
    private String zzY;
    private int zzZ;
    private boolean zzaa;
    private String zzab;
    private boolean zzac;
    private com.google.android.gms.internal.measurement.v4 zzad;
    private int zzf;
    private int zzg;
    private int zzh;
    private com.google.android.gms.internal.measurement.c9<com.google.android.gms.internal.measurement.p4> zzi;
    private com.google.android.gms.internal.measurement.c9<com.google.android.gms.internal.measurement.j5> zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private String zzp;
    private String zzq;
    private String zzr;
    private String zzs;
    private int zzt;
    private String zzu;
    private String zzv;
    private String zzw;
    private long zzx;
    private long zzy;
    private String zzz;
    static {
        z4 z4Var = new z4();
        z4.zze = z4Var;
        w8.o(z4.class, z4Var);
    }

    private z4() {
        super();
        this.zzi = w8.k();
        this.zzj = w8.k();
        String str = "";
        this.zzp = str;
        this.zzq = str;
        this.zzr = str;
        this.zzs = str;
        this.zzu = str;
        this.zzv = str;
        this.zzw = str;
        this.zzz = str;
        this.zzB = str;
        this.zzE = str;
        this.zzF = str;
        this.zzH = w8.k();
        this.zzI = str;
        this.zzM = str;
        this.zzP = str;
        this.zzQ = str;
        this.zzS = str;
        this.zzU = w8.s();
        this.zzX = str;
        this.zzY = str;
        this.zzab = str;
    }

    static void A0(com.google.android.gms.internal.measurement.z4 z4) {
        z4.zzi = w8.k();
    }

    static void B0(com.google.android.gms.internal.measurement.z4 z4, int i2) {
        z4.Y0();
        z4.zzi.remove(i2);
    }

    static void C0(com.google.android.gms.internal.measurement.z4 z4, int i2, com.google.android.gms.internal.measurement.j5 j53) {
        j53.getClass();
        z4.Z0();
        z4.zzj.set(i2, j53);
    }

    static void D0(com.google.android.gms.internal.measurement.z4 z4, com.google.android.gms.internal.measurement.j5 j52) {
        j52.getClass();
        z4.Z0();
        z4.zzj.add(j52);
    }

    static void E0(com.google.android.gms.internal.measurement.z4 z4, int i2) {
        z4.Z0();
        z4.zzj.remove(i2);
    }

    static void F0(com.google.android.gms.internal.measurement.z4 z4, long l2) {
        z4.zzf = zzf |= 2;
        z4.zzk = l2;
    }

    static void G0(com.google.android.gms.internal.measurement.z4 z4, long l2) {
        z4.zzf = zzf |= 4;
        z4.zzl = l2;
    }

    public static com.google.android.gms.internal.measurement.y4 G1() {
        return (y4)z4.zze.p();
    }

    static void H0(com.google.android.gms.internal.measurement.z4 z4, long l2) {
        z4.zzf = zzf |= 8;
        z4.zzm = l2;
    }

    static void I0(com.google.android.gms.internal.measurement.z4 z4, long l2) {
        z4.zzf = zzf |= 16;
        z4.zzn = l2;
    }

    static com.google.android.gms.internal.measurement.z4 I1() {
        return z4.zze;
    }

    static void K0(com.google.android.gms.internal.measurement.z4 z4) {
        z4.zzf = zzf &= -17;
        z4.zzn = 0;
    }

    static void L0(com.google.android.gms.internal.measurement.z4 z4, long l2) {
        z4.zzf = zzf |= 32;
        z4.zzo = l2;
    }

    static void M(com.google.android.gms.internal.measurement.z4 z4, long l2) {
        z4.zzf = zzf |= i2;
        z4.zzO = l2;
    }

    static void M0(com.google.android.gms.internal.measurement.z4 z4) {
        z4.zzf = zzf &= -33;
        z4.zzo = 0;
    }

    static void N(com.google.android.gms.internal.measurement.z4 z4) {
        z4.zzf = zzf &= i2;
        z4.zzP = zze.zzP;
    }

    static void N0(com.google.android.gms.internal.measurement.z4 z4, String string2) {
        z4.zzf = obj1 |= 64;
        z4.zzp = "android";
    }

    static void O(com.google.android.gms.internal.measurement.z4 z4, int i2) {
        z4.zzg = zzg |= 2;
        z4.zzR = i2;
    }

    static void O0(com.google.android.gms.internal.measurement.z4 z4, String string2) {
        string2.getClass();
        z4.zzf = zzf |= 128;
        z4.zzq = string2;
    }

    static void P(com.google.android.gms.internal.measurement.z4 z4, int i2, com.google.android.gms.internal.measurement.p4 p43) {
        p43.getClass();
        z4.Y0();
        z4.zzi.set(i2, p43);
    }

    static void P0(com.google.android.gms.internal.measurement.z4 z4, String string2) {
        string2.getClass();
        z4.zzf = zzf |= 256;
        z4.zzr = string2;
    }

    static void Q(com.google.android.gms.internal.measurement.z4 z4, String string2) {
        string2.getClass();
        z4.zzg = zzg |= 4;
        z4.zzS = string2;
    }

    static void Q0(com.google.android.gms.internal.measurement.z4 z4, String string2) {
        string2.getClass();
        z4.zzf = zzf |= 512;
        z4.zzs = string2;
    }

    static void R(com.google.android.gms.internal.measurement.z4 z4, Iterable iterable2) {
        com.google.android.gms.internal.measurement.a9 zzU;
        int z;
        zzU = z4.zzU;
        if (!zzU.zzc()) {
            int size = zzU.size();
            z = size == 0 ? 10 : size + size;
            z4.zzU = zzU.M1(z);
        }
        k7.h(iterable2, z4.zzU);
    }

    static void R0(com.google.android.gms.internal.measurement.z4 z4, int i2) {
        z4.zzf = zzf |= 1024;
        z4.zzt = i2;
    }

    static void S(com.google.android.gms.internal.measurement.z4 z4, com.google.android.gms.internal.measurement.p4 p42) {
        p42.getClass();
        z4.Y0();
        z4.zzi.add(p42);
    }

    static void S0(com.google.android.gms.internal.measurement.z4 z4, String string2) {
        string2.getClass();
        z4.zzf = zzf |= 2048;
        z4.zzu = string2;
    }

    static void T(com.google.android.gms.internal.measurement.z4 z4, long l2) {
        z4.zzg = zzg |= 16;
        z4.zzV = l2;
    }

    static void T0(com.google.android.gms.internal.measurement.z4 z4, String string2) {
        string2.getClass();
        z4.zzf = zzf |= 4096;
        z4.zzv = string2;
    }

    static void U(com.google.android.gms.internal.measurement.z4 z4, long l2) {
        z4.zzg = zzg |= 32;
        z4.zzW = l2;
    }

    static void U0(com.google.android.gms.internal.measurement.z4 z4, String string2) {
        string2.getClass();
        z4.zzf = zzf |= 8192;
        z4.zzw = string2;
    }

    static void V0(com.google.android.gms.internal.measurement.z4 z4, long l2) {
        z4.zzf = zzf |= 16384;
        z4.zzx = l2;
    }

    static void W(com.google.android.gms.internal.measurement.z4 z4, String string2) {
        string2.getClass();
        z4.zzf = zzf |= i2;
        z4.zzz = string2;
    }

    static void W0(com.google.android.gms.internal.measurement.z4 z4, long l2) {
        z4.zzf = obj1 |= obj2;
        z4.zzy = 46000;
    }

    static void X(com.google.android.gms.internal.measurement.z4 z4) {
        z4.zzf = zzf &= i2;
        z4.zzz = zze.zzz;
    }

    static void Y(com.google.android.gms.internal.measurement.z4 z4, boolean z2) {
        z4.zzf = zzf |= i2;
        z4.zzA = z2;
    }

    private final void Y0() {
        com.google.android.gms.internal.measurement.c9 zzi;
        zzi = this.zzi;
        if (!zzi.zzc()) {
            this.zzi = w8.l(zzi);
        }
    }

    static void Z(com.google.android.gms.internal.measurement.z4 z4) {
        z4.zzf = zzf &= i3;
        z4.zzA = false;
    }

    private final void Z0() {
        com.google.android.gms.internal.measurement.c9 zzj;
        zzj = this.zzj;
        if (!zzj.zzc()) {
            this.zzj = w8.l(zzj);
        }
    }

    static void a0(com.google.android.gms.internal.measurement.z4 z4, String string2) {
        string2.getClass();
        z4.zzf = zzf |= i2;
        z4.zzB = string2;
    }

    static void b0(com.google.android.gms.internal.measurement.z4 z4) {
        z4.zzf = zzf &= i2;
        z4.zzB = zze.zzB;
    }

    static void c0(com.google.android.gms.internal.measurement.z4 z4, long l2) {
        z4.zzf = zzf |= i2;
        z4.zzC = l2;
    }

    static void d0(com.google.android.gms.internal.measurement.z4 z4, int i2) {
        z4.zzf = zzf |= i3;
        z4.zzD = i2;
    }

    static void e0(com.google.android.gms.internal.measurement.z4 z4, String string2) {
        z4.zzf = zzf |= i2;
        z4.zzE = string2;
    }

    static void f0(com.google.android.gms.internal.measurement.z4 z4) {
        z4.zzf = zzf &= i2;
        z4.zzE = zze.zzE;
    }

    static void g0(com.google.android.gms.internal.measurement.z4 z4, String string2) {
        string2.getClass();
        z4.zzf = zzf |= i2;
        z4.zzF = string2;
    }

    static void h0(com.google.android.gms.internal.measurement.z4 z4, boolean z2) {
        z4.zzf = zzf |= i2;
        z4.zzG = z2;
    }

    static void i0(com.google.android.gms.internal.measurement.z4 z4, Iterable iterable2) {
        com.google.android.gms.internal.measurement.c9 zzH;
        zzH = z4.zzH;
        if (!zzH.zzc()) {
            z4.zzH = w8.l(zzH);
        }
        k7.h(iterable2, z4.zzH);
    }

    static void j0(com.google.android.gms.internal.measurement.z4 z4) {
        z4.zzH = w8.k();
    }

    static void k0(com.google.android.gms.internal.measurement.z4 z4, String string2) {
        string2.getClass();
        z4.zzf = zzf |= i2;
        z4.zzI = string2;
    }

    static void l0(com.google.android.gms.internal.measurement.z4 z4, int i2) {
        z4.zzf = zzf |= i3;
        z4.zzJ = i2;
    }

    static void m0(com.google.android.gms.internal.measurement.z4 z4, int i2) {
        final int i = 1;
        z4.zzf = obj2 |= i;
        z4.zzh = i;
    }

    static void n0(com.google.android.gms.internal.measurement.z4 z4) {
        z4.zzf = zzf &= i2;
        z4.zzM = zze.zzM;
    }

    static void o0(com.google.android.gms.internal.measurement.z4 z4, long l2) {
        z4.zzf = zzf |= i2;
        z4.zzN = l2;
    }

    static void x0(com.google.android.gms.internal.measurement.z4 z4, String string2) {
        string2.getClass();
        z4.zzg = zzg |= 64;
        z4.zzX = string2;
    }

    static void y0(com.google.android.gms.internal.measurement.z4 z4, String string2) {
        z4.zzg = zzg |= 128;
        z4.zzY = string2;
    }

    static void z0(com.google.android.gms.internal.measurement.z4 z4, Iterable iterable2) {
        z4.Y0();
        k7.h(iterable2, z4.zzi);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String A() {
        return this.zzP;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final long A1() {
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String B() {
        return this.zzI;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String C() {
        return this.zzX;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final long C1() {
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String D() {
        return this.zzF;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final long D1() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String E() {
        return this.zzE;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final long E1() {
        return this.zzy;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String F() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final com.google.android.gms.internal.measurement.p4 F1(int i) {
        return (p4)this.zzi.get(i);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String G() {
        return this.zzp;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String H() {
        return this.zzz;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String I() {
        return this.zzs;
    }

    public final List<com.google.android.gms.internal.measurement.l4> J() {
        return this.zzH;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final com.google.android.gms.internal.measurement.j5 J1(int i) {
        return (j5)this.zzj.get(i);
    }

    public final List<com.google.android.gms.internal.measurement.p4> K() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String K1() {
        return this.zzS;
    }

    public final List<com.google.android.gms.internal.measurement.j5> L() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String L1() {
        return this.zzv;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String M1() {
        return this.zzB;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int V() {
        return this.zzJ;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int X0() {
        return this.zzD;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean a1() {
        if (zzf &= i4 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean b1() {
        if (zzg &= 16 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean c1() {
        if (zzf &= 8 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean d1() {
        if (zzf &= 16384 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean e1() {
        if (zzf &= i4 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean f1() {
        if (zzf &= 32 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean g1() {
        if (zzf &= 16 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean h1() {
        final int i3 = 1;
        if (zzf &= i3 != 0) {
            return i3;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean i1() {
        if (zzg &= 2 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean j1() {
        if (zzf &= i4 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean k1() {
        if (zzf &= 4 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean l1() {
        if (zzf &= 1024 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean m1() {
        if (zzf &= 2 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean n1() {
        if (zzf &= i4 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int o1() {
        return this.zzi.size();
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean p0() {
        return this.zzA;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int p1() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean q0() {
        return this.zzG;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int q1() {
        return this.zzR;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean r0() {
        if (zzf &= i4 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int r1() {
        return this.zzt;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean s0() {
        if (zzf &= i4 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int s1() {
        return this.zzj.size();
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final long t1() {
        return this.zzO;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean u0() {
        if (zzf &= i4 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final long u1() {
        return this.zzN;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    protected final Object v(int i, Object object2, Object object3) {
        i--;
        int obj7 = 1;
        int obj8 = 5;
        final int i2 = 4;
        final int i3 = 3;
        final int i4 = 2;
        obj7 = 0;
        if (obj6 != null && obj6 != i4 && obj6 != i3 && obj6 != i2 && obj6 != obj8) {
            obj8 = 5;
            i2 = 4;
            i3 = 3;
            i4 = 2;
            if (obj6 != i4) {
                if (obj6 != i3) {
                    obj7 = 0;
                    if (obj6 != i2) {
                        if (obj6 != obj8) {
                            return obj7;
                        }
                        return z4.zze;
                    }
                    y4 obj6 = new y4(obj7);
                    return obj6;
                }
                obj6 = new z4();
                return obj6;
            }
            obj6 = new Object[55];
            obj6[obj7] = "zzg";
            obj6[i4] = "zzh";
            obj6[i3] = "zzi";
            obj6[i2] = p4.class;
            obj6[obj8] = "zzj";
            obj6[6] = j5.class;
            obj6[7] = "zzk";
            obj6[8] = "zzl";
            obj6[9] = "zzm";
            obj6[10] = "zzo";
            obj6[11] = "zzp";
            obj6[12] = "zzq";
            obj6[13] = "zzr";
            obj6[14] = "zzs";
            obj6[15] = "zzt";
            obj6[16] = "zzu";
            obj6[17] = "zzv";
            obj6[18] = "zzw";
            obj6[19] = "zzx";
            obj6[20] = "zzy";
            obj6[21] = "zzz";
            obj6[22] = "zzA";
            obj6[23] = "zzB";
            obj6[24] = "zzC";
            obj6[25] = "zzD";
            obj6[26] = "zzE";
            obj6[27] = "zzF";
            obj6[28] = "zzn";
            obj6[29] = "zzG";
            obj6[30] = "zzH";
            obj6[31] = l4.class;
            obj6[32] = "zzI";
            obj6[33] = "zzJ";
            obj6[34] = "zzK";
            obj6[35] = "zzL";
            obj6[36] = "zzM";
            obj6[37] = "zzN";
            obj6[38] = "zzO";
            obj6[39] = "zzP";
            obj6[40] = "zzQ";
            obj6[41] = "zzR";
            obj6[42] = "zzS";
            obj6[43] = "zzT";
            obj6[44] = "zzU";
            obj6[45] = "zzV";
            obj6[46] = "zzW";
            obj6[47] = "zzX";
            obj6[48] = "zzY";
            obj6[49] = "zzZ";
            obj6[50] = h4.a;
            obj6[51] = "zzaa";
            obj6[52] = "zzab";
            obj6[53] = "zzac";
            obj6[54] = "zzad";
            return w8.n(z4.zze, "\u00011\u0000\u0002\u0001;1\u0000\u0004\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဂ\u0001\u0005ဂ\u0002\u0006ဂ\u0003\u0007ဂ\u0005\u0008ဈ\u0006\tဈ\u0007\nဈ\u0008\u000bဈ\t\u000cင\n\rဈ\u000b\u000eဈ\u000c\u0010ဈ\r\u0011ဂ\u000e\u0012ဂ\u000f\u0013ဈ\u0010\u0014ဇ\u0011\u0015ဈ\u0012\u0016ဂ\u0013\u0017င\u0014\u0018ဈ\u0015\u0019ဈ\u0016\u001aဂ\u0004\u001cဇ\u0017\u001d\u001b\u001eဈ\u0018\u001fင\u0019 င\u001a!င\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဈ\u001f&ဈ 'င!)ဈ\",ဉ#-\u001d.ဂ$/ဂ%2ဈ&4ဈ'5ဌ(7ဇ)9ဈ*:ဇ+;ဉ,", obj6);
        }
        return Byte.valueOf(obj7);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean v0() {
        if (zzf &= i4 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final long v1() {
        return this.zzC;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String w() {
        return this.zzu;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean w0() {
        if (zzg &= 128 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final long w1() {
        return this.zzV;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String x() {
        return this.zzw;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final long x1() {
        return this.zzm;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String y() {
        return this.zzY;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final long y1() {
        return this.zzx;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String z() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final long z1() {
        return this.zzo;
    }
}
