package nl.dionsegijn.konfetti.e;

import kotlin.d0.d.g;

/* compiled from: ConfettiConfig.kt */
/* loaded from: classes3.dex */
public final class a {

    private boolean a;
    private long b;
    private boolean c;
    private boolean d;
    private long e;
    public a(boolean z, long j, boolean z2, boolean z3, long j2) {
        super();
        this.a = z;
        this.b = j;
        this.c = z2;
        this.d = z3;
        this.e = j2;
    }

    public final boolean a() {
        return this.d;
    }

    public final long b() {
        return this.e;
    }

    public final boolean c() {
        return this.a;
    }

    public final boolean d() {
        return this.c;
    }

    public final long e() {
        return this.b;
    }

    public final void f(boolean z) {
        this.a = z;
    }

    public final void g(long j) {
        this.b = j;
    }

    public /* synthetic */ a(boolean z, long j, boolean z2, boolean z3, long j2, int i, g gVar) {
        boolean j52;
        int j22 = 2000;
        int i62 = 0;
        int z32;
        i = i & 1 != 0 ? 0 : i;
        if (i & 2 != 0) {
            j22 = 2000;
        }
        z32 = 1;
        gVar = i & 4 != 0 ? z32 : z2;
        int r2 = i & 8 != 0 ? z32 : z3;
        i62 = i & 16 != 0 ? 0 : i62;
        this(i, j22, z3, z32, j52, i62, z32);
    }

    public a() {
        this(false, 0L, z, false, 0L, 0, gVar, 31, 0);
    }

    public boolean equals(Object object) {
        if (this != object) {
            z = object instanceof a;
            return false;
        }
        return true;
    }

    public int hashCode() {
        boolean z;
        boolean z2 = true;
        boolean z3;
        int i = 1;
        if (this.a) {
        }
        final int i12 = 32;
        if (this.c) {
        }
        if (!(this.d)) {
        }
        return (z * 31) + (int)(l3 ^ (l3 >>> i12)) * 31 + z3 * 31 + z2 * 31 + (int)(l ^ (l >>> 32L));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ConfettiConfig(fadeOut=";
        String str3 = ", timeToLive=";
        String str4 = ", rotate=";
        String str5 = ", accelerate=";
        String str6 = ", delay=";
        String str7 = ")";
        str = str2 + this.a + str3 + this.b + str4 + this.c + str5 + this.d + str6 + this.e + str7;
        return str;
    }
}
