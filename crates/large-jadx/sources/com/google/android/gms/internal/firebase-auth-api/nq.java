package com.google.android.gms.internal.firebase-auth-api;

import java.util.List;

/* loaded from: classes2.dex */
final class nq {
    static int a(byte[] bArr, int i2, com.google.android.gms.internal.firebase-auth-api.mq mq3) {
        int obj3 = nq.j(bArr, i2, mq3);
        final int i = mq3.a;
        if (i < 0) {
        } else {
            if (i > length -= obj3) {
            } else {
                if (i == 0) {
                    mq3.c = wq.a;
                    return obj3;
                }
                mq3.c = wq.w(bArr, obj3, i);
                return obj3 += i;
            }
            throw zzaae.i();
        }
        throw zzaae.f();
    }

    static int b(byte[] bArr, int i2) {
        return obj2 |= i4;
    }

    static int c(com.google.android.gms.internal.firebase-auth-api.l0 l0, byte[] b2Arr2, int i3, int i4, int i5, com.google.android.gms.internal.firebase-auth-api.mq mq6) {
        final Object obj2 = (c0)l0.a();
        l0.c(obj2);
        mq6.c = obj2;
        return l0.I(obj2, b2Arr2, i3, i4, i5, mq6);
    }

    static int d(com.google.android.gms.internal.firebase-auth-api.l0 l0, byte[] b2Arr2, int i3, int i4, com.google.android.gms.internal.firebase-auth-api.mq mq5) {
        int i;
        byte obj8;
        int obj9;
        obj8 = b2Arr2[i3];
        if (obj8 < 0) {
            i = nq.k(obj8, b2Arr2, i3 + 1, mq5);
            obj8 = mq5.a;
        }
        final int i2 = i;
        if (obj8 < 0) {
        } else {
            if (obj8 > i4 -= i2) {
            } else {
                obj9 = l0.a();
                obj8 += i2;
                l0.i(obj9, b2Arr2, i2, obj8, mq5);
                l0.c(obj9);
                mq5.c = obj9;
                return obj8;
            }
        }
        throw zzaae.i();
    }

    static int e(com.google.android.gms.internal.firebase-auth-api.l0<?> l0, int i2, byte[] b3Arr3, int i4, int i5, com.google.android.gms.internal.firebase-auth-api.d<?> d6, com.google.android.gms.internal.firebase-auth-api.mq mq7) {
        Object obj;
        int i;
        int obj5;
        obj5 = nq.d(l0, b3Arr3, i4, i5, mq7);
        d6.add(mq7.c);
        while (obj5 < i5) {
            if (i2 != mq7.a) {
                break;
            } else {
            }
            obj5 = nq.d(l0, b3Arr3, nq.j(b3Arr3, obj5, mq7), i5, mq7);
            d6.add(mq7.c);
        }
        return obj5;
    }

    static int f(byte[] bArr, int i2, com.google.android.gms.internal.firebase-auth-api.d<?> d3, com.google.android.gms.internal.firebase-auth-api.mq mq4) {
        int i;
        int obj3;
        i3 += obj3;
        while (obj3 < i4) {
            obj3 = nq.j(bArr, obj3, mq4);
            (yr)d3.g(mq4.a);
        }
        if (obj3 != i4) {
        } else {
            return obj3;
        }
        throw zzaae.i();
    }

    static int g(byte[] bArr, int i2, com.google.android.gms.internal.firebase-auth-api.mq mq3) {
        int obj4 = nq.j(bArr, i2, mq3);
        final int i = mq3.a;
        if (i < 0) {
        } else {
            if (i == 0) {
                mq3.c = "";
                return obj4;
            }
            String string = new String(bArr, obj4, i, e.a);
            mq3.c = string;
            return obj4 += i;
        }
        throw zzaae.f();
    }

    static int h(byte[] bArr, int i2, com.google.android.gms.internal.firebase-auth-api.mq mq3) {
        int obj2 = nq.j(bArr, i2, mq3);
        final int i = mq3.a;
        if (i < 0) {
        } else {
            if (i == 0) {
                mq3.c = "";
                return obj2;
            }
            mq3.c = o1.d(bArr, obj2, i);
            return obj2 += i;
        }
        throw zzaae.f();
    }

    static int i(int i, byte[] b2Arr2, int i3, int i4, com.google.android.gms.internal.firebase-auth-api.a1 a15, com.google.android.gms.internal.firebase-auth-api.mq mq6) {
        int i7;
        byte[] bArr;
        int i5;
        int i6;
        com.google.android.gms.internal.firebase-auth-api.a1 a1Var;
        com.google.android.gms.internal.firebase-auth-api.mq mqVar;
        int i2;
        com.google.android.gms.internal.firebase-auth-api.wq obj10;
        int obj11;
        if (i >>> 3 == 0) {
        } else {
            int i9 = i & 7;
            int i12 = 1;
            if (i9 != 0 && i9 != i12 && i9 != 2 && i9 != 3) {
                i12 = 1;
                if (i9 != i12) {
                    if (i9 != 2) {
                        if (i9 != 3) {
                            if (i9 != 5) {
                            } else {
                                a15.h(i, Integer.valueOf(nq.b(b2Arr2, i3)));
                                return i3 += 4;
                            }
                            throw zzaae.c();
                        }
                        i10 |= 4;
                        final com.google.android.gms.internal.firebase-auth-api.a1 a1Var2 = a1.e();
                        i7 = 0;
                        while (obj11 < i4) {
                            i5 = nq.j(b2Arr2, obj11, mq6);
                            obj11 = mq6.a;
                            if (obj11 == i11) {
                                break;
                            } else {
                            }
                            i7 = obj11;
                            obj11 = i2;
                        }
                        if (obj11 > i4) {
                        } else {
                            if (i7 != i11) {
                            } else {
                                a15.h(i, a1Var2);
                                return obj11;
                            }
                        }
                        throw zzaae.g();
                    }
                    obj11 = nq.j(b2Arr2, i3, mq6);
                    int obj12 = mq6.a;
                    if (obj12 < 0) {
                    } else {
                        if (obj12 > obj14 -= obj11) {
                        } else {
                            if (obj12 == null) {
                                a15.h(i, wq.a);
                            } else {
                                a15.h(i, wq.w(b2Arr2, obj11, obj12));
                            }
                            return obj11 += obj12;
                        }
                        throw zzaae.i();
                    }
                    throw zzaae.f();
                }
                a15.h(i, Long.valueOf(nq.n(b2Arr2, i3)));
                return i3 += 8;
            }
            a15.h(i, Long.valueOf(mq6.b));
            return nq.m(b2Arr2, i3, mq6);
        }
        throw zzaae.c();
    }

    static int j(byte[] bArr, int i2, com.google.android.gms.internal.firebase-auth-api.mq mq3) {
        final int i = i2 + 1;
        final byte obj2 = bArr[i2];
        if (obj2 >= 0) {
            mq3.a = obj2;
            return i;
        }
        return nq.k(obj2, bArr, i, mq3);
    }

    static int k(int i, byte[] b2Arr2, int i3, com.google.android.gms.internal.firebase-auth-api.mq mq4) {
        int i2;
        int obj3;
        i &= 127;
        int i4 = i3 + 1;
        obj3 = b2Arr2[i3];
        if (obj3 >= 0) {
            mq4.a = obj1 |= obj2;
            return i4;
        }
        obj1 |= obj3;
        obj3 = i4 + 1;
        byte b = b2Arr2[i4];
        if (b >= 0) {
            mq4.a = obj1 |= obj2;
            return obj3;
        }
        obj1 |= i6;
        int i7 = obj3 + 1;
        obj3 = b2Arr2[obj3];
        if (obj3 >= 0) {
            mq4.a = obj1 |= obj2;
            return i7;
        }
        obj1 |= obj3;
        byte b2 = b2Arr2[i7];
        if (b2 >= 0) {
            mq4.a = obj1 |= obj2;
            return i7 + 1;
        }
        i2 = obj3 + 1;
        while (b2Arr2[obj3] < 0) {
            obj3 = i2;
            i2 = obj3 + 1;
        }
        mq4.a = obj1 |= i2;
        return i2;
    }

    static int l(int i, byte[] b2Arr2, int i3, int i4, com.google.android.gms.internal.firebase-auth-api.d<?> d5, com.google.android.gms.internal.firebase-auth-api.mq mq6) {
        int i5;
        int i2;
        int obj4;
        obj4 = nq.j(b2Arr2, i3, mq6);
        (yr)d5.g(mq6.a);
        while (obj4 < i4) {
            if (i != mq6.a) {
                break;
            } else {
            }
            obj4 = nq.j(b2Arr2, nq.j(b2Arr2, obj4, mq6), mq6);
            d5.g(mq6.a);
        }
        return obj4;
    }

    static int m(byte[] bArr, int i2, com.google.android.gms.internal.firebase-auth-api.mq mq3) {
        byte b;
        int i5;
        int i4;
        int i;
        int i6;
        int i3;
        int obj10;
        int i7 = i2 + 1;
        long l = (long)obj10;
        if (Long.compare(l, i10) < 0) {
            obj10 = i7 + 1;
            final int i14 = 7;
            i9 |= i13;
            i4 = i14;
            while (b < 0) {
                obj10 = bArr[obj10];
                i5 |= i6;
                b = obj10;
                obj10 = i3;
            }
            mq3.b = i5;
            return obj10;
        }
        mq3.b = l;
        return i7;
    }

    static long n(byte[] bArr, int i2) {
        int i9 = 255;
        return obj7 |= i8;
    }
}
