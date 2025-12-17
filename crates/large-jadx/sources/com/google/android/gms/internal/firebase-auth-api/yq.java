package com.google.android.gms.internal.firebase-auth-api;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class yq extends com.google.android.gms.internal.firebase-auth-api.zq {

    private final byte[] c;
    private int d;
    private int e;
    private int f = 0;
    private int g;
    private int h = Integer.MAX_VALUE;
    yq(byte[] bArr, int i2, int i3, boolean z4, com.google.android.gms.internal.firebase-auth-api.xq xq5) {
        super(0);
        int obj2 = Integer.MAX_VALUE;
        this.c = bArr;
        this.d = i3;
        final int obj1 = 0;
    }

    private final void v() {
        i += i5;
        this.d = i2;
        int i6 = this.h;
        if (i2 > i6) {
            int i7 = i2 - i6;
            this.e = i7;
            this.d = i2 -= i7;
        }
        this.e = 0;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.zq
    public final int a() {
        return this.f;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.zq
    public final int b(int i) {
        if (i < 0) {
        } else {
            i += i2;
            if (obj2 < 0) {
            } else {
                int i3 = this.h;
                if (obj2 > i3) {
                } else {
                    this.h = obj2;
                    v();
                    return i3;
                }
                throw zzaae.i();
            }
            throw zzaae.g();
        }
        throw zzaae.f();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.zq
    public final int c() {
        if (i()) {
            int i = 0;
            this.g = i;
            return i;
        }
        int i2 = q();
        this.g = i2;
        if (i2 >>> 3 == 0) {
        } else {
            return i2;
        }
        throw zzaae.c();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.zq
    public final com.google.android.gms.internal.firebase-auth-api.wq d() {
        int i;
        int i2;
        int i3 = q();
        i2 = this.f;
        if (i3 > 0 && i3 > i5 -= i2) {
            i2 = this.f;
            if (i3 > i5 -= i2) {
            }
            this.f = i7 += i3;
            return wq.w(this.c, i2, i3);
        }
        i2 = this.f;
        if (i3 != 0 && i3 > 0 && i3 > i6 -= i2) {
            if (i3 > 0) {
                i2 = this.f;
                if (i3 > i6 -= i2) {
                }
                i3 += i2;
                this.f = i4;
                return wq.z(Arrays.copyOfRange(this.c, i2, i4));
            }
            if (i3 <= 0) {
                throw zzaae.f();
            }
            throw zzaae.i();
        }
        return wq.a;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.zq
    public final String e() {
        int i2;
        int i;
        int i3 = q();
        i = this.f;
        if (i3 > 0 && i3 > i4 -= i) {
            i = this.f;
            if (i3 > i4 -= i) {
            }
            String string = new String(this.c, i, i3, e.a);
            this.f = i5 += i3;
            return string;
        }
        if (i3 == 0) {
            return "";
        }
        if (i3 < 0) {
            throw zzaae.f();
        }
        throw zzaae.i();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.zq
    public final String f() {
        int i2;
        int i;
        int i3 = q();
        i = this.f;
        if (i3 > 0 && i3 > i4 -= i) {
            i = this.f;
            if (i3 > i4 -= i) {
            }
            this.f = i5 += i3;
            return o1.d(this.c, i, i3);
        }
        if (i3 == 0) {
            return "";
        }
        if (i3 <= 0) {
            throw zzaae.f();
        }
        throw zzaae.i();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.zq
    public final void g(int i) {
        if (this.g != i) {
        } else {
        }
        throw zzaae.b();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.zq
    public final void h(int i) {
        this.h = i;
        v();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.zq
    public final boolean i() {
        if (this.f == this.d) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.zq
    public final boolean j() {
        if (Long.compare(l, i3) != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.zq
    public final boolean k(int i) {
        int i2;
        int i4;
        int i5;
        int i3;
        int obj6;
        i2 = i & 7;
        final int i8 = 1;
        int i10 = 4;
        int i11 = 3;
        if (i2 != 0 && i2 != i8 && i2 != 2 && i2 != i11 && i2 != i10) {
            if (i2 != i8) {
                if (i2 != 2) {
                    i10 = 4;
                    i11 = 3;
                    if (i2 != i11) {
                        if (i2 != i10) {
                            if (i2 != 5) {
                            } else {
                                u(i10);
                                return i8;
                            }
                            throw zzaae.a();
                        }
                        return 0;
                    }
                    i2 = c();
                    while (i2 != 0) {
                        if (k(i2) != 0) {
                        }
                        i2 = c();
                    }
                    g(obj6 |= i10);
                    return i8;
                }
                u(q());
                return i8;
            }
            u(8);
            return i8;
        }
        int i7 = 10;
        if (obj6 -= i6 >= i7) {
        }
        while (i4 < i7) {
            i4++;
        }
        throw zzaae.e();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.zq
    public final byte o() {
        int i = this.f;
        if (i == this.d) {
        } else {
            this.f = i + 1;
            return this.c[i];
        }
        throw zzaae.i();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.zq
    public final int p() {
        int i = this.f;
        if (i6 -= i < 4) {
        } else {
            byte[] bArr = this.c;
            this.f = i + 4;
            return i4 |= i12;
        }
        throw zzaae.i();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.zq
    public final int q() {
        int i3;
        int i2;
        int i5;
        byte[] bArr;
        int i;
        int i4;
        i3 = this.f;
        i5 = this.d;
        if (i5 == i3) {
        } else {
            bArr = this.c;
            i = i3 + 1;
            i3 = bArr[i3];
            if (i3 >= 0) {
                this.f = i;
                return i3;
            }
            if (i5 -= i >= 9) {
                i5 = i + 1;
                i3 ^= i;
                if (i6 < 0) {
                    i6 ^= -128;
                } else {
                    i = i5 + 1;
                    i6 ^= i2;
                    if (i7 >= 0) {
                        i7 ^= 16256;
                        i5 = i;
                    } else {
                    }
                }
                this.f = i5;
                return i3;
            }
        }
        return (int)l;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.zq
    public final long r() {
        int i = this.f;
        int i8 = 8;
        if (i6 -= i < i8) {
        } else {
            byte[] bArr = this.c;
            this.f = i + 8;
            final int i28 = 255;
            return i4 |= i14;
        }
        throw zzaae.i();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.zq
    public final long s() {
        byte i;
        int i2;
        int i6;
        byte[] cmp2;
        int i7;
        long l2;
        int cmp;
        int i4;
        int cmp3;
        int i5;
        int i3;
        long l;
        i = this.f;
        i6 = this.d;
        if (i6 == i) {
        } else {
            cmp2 = this.c;
            cmp = i + 1;
            i = cmp2[i];
            if (i >= 0) {
                this.f = cmp;
                return (long)i;
            }
            if (i6 -= cmp >= 9) {
                i6 = cmp + 1;
                i ^= cmp;
                if (i8 < 0) {
                    i8 ^= -128;
                    i7 = (long)i;
                } else {
                }
                this.f = i6;
                return i7;
            }
        }
        return t();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.zq
    final long t() {
        int i4;
        int i;
        int i2;
        int i3;
        i4 = 0;
        i = 0;
        while (i < 64) {
            byte b = o();
            i += 7;
        }
        throw zzaae.e();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.zq
    public final void u(int i) {
        int i2;
        int i3;
        i3 = this.f;
        if (i >= 0 && i > i4 -= i3) {
            i3 = this.f;
            if (i > i4 -= i3) {
            }
            this.f = i3 += i;
        }
        if (i < 0) {
            throw zzaae.f();
        }
        throw zzaae.i();
    }
}
