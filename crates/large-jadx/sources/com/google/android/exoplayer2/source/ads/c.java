package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.v0;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class c {

    public static final com.google.android.exoplayer2.source.ads.c g;
    private static final com.google.android.exoplayer2.source.ads.c.a h;
    public static final v0<com.google.android.exoplayer2.source.ads.c> i;
    public final Object a;
    public final int b;
    public final long c;
    public final long d;
    public final int e;
    private final com.google.android.exoplayer2.source.ads.c.a[] f;

    public static final class a {

        public static final v0<com.google.android.exoplayer2.source.ads.c.a> h;
        public final long a;
        public final int b;
        public final Uri[] c;
        public final int[] d;
        public final long[] e;
        public final long f;
        public final boolean g;
        static {
            c.a.h = a.a;
        }

        public a(long l) {
            final int i = 0;
            super(l, obj3, -1, new int[i], new Uri[i], new long[i], 0, obj9, 0);
        }

        private a(long l, int i2, int[] i3Arr3, Uri[] uri4Arr4, long[] l5Arr5, long l6, boolean z7) {
            int i;
            super();
            i = uri4Arr4.length == l5Arr5.length ? 1 : 0;
            g.a(i);
            this.a = l;
            this.b = i3Arr3;
            this.d = uri4Arr4;
            this.c = l5Arr5;
            this.e = l6;
            this.f = z7;
            this.g = obj11;
        }

        private static long[] a(long[] lArr, int i2) {
            final int length = lArr.length;
            final int obj4 = Math.max(i2, length);
            final long[] obj3 = Arrays.copyOf(lArr, obj4);
            Arrays.fill(obj3, length, obj4, -9223372036854775807L);
            return obj3;
        }

        private static int[] b(int[] iArr, int i2) {
            final int length = iArr.length;
            final int obj3 = Math.max(i2, length);
            final int[] obj2 = Arrays.copyOf(iArr, obj3);
            Arrays.fill(obj2, length, obj3, 0);
            return obj2;
        }

        public int c() {
            return d(-1);
        }

        public int d(int i) {
            int i2;
            int length;
            int obj4;
            final int i3 = 1;
            i += i3;
            i2 = this.d;
            while (obj4 < i2.length) {
                if (!this.g) {
                    break;
                }
                if (i2[obj4] != 0) {
                    break;
                }
                if (i2[obj4] == i3) {
                    break;
                } else {
                }
                obj4++;
                i2 = this.d;
            }
            return obj4;
        }

        public boolean e() {
            int i;
            int i3;
            int i2;
            final int i6 = 1;
            if (this.b == -1) {
                return i6;
            }
            int i5 = 0;
            i = i5;
            while (i < this.b) {
                i3 = this.d;
                i++;
            }
            return i5;
        }

        public boolean equals(Object object) {
            int i;
            boolean equals;
            Class<com.google.android.exoplayer2.source.ads.c.a> obj;
            long[] class;
            long l;
            boolean obj7;
            if (this == object) {
                return 1;
            }
            final int i2 = 0;
            if (object != null) {
                if (c.a.class != object.getClass()) {
                } else {
                    if (Long.compare(l2, l) == 0 && this.b == object.b && Arrays.equals(this.c, object.c) && Arrays.equals(this.d, object.d) && Arrays.equals(this.e, object.e) && Long.compare(l3, l) == 0 && this.g == object.g) {
                        if (this.b == object.b) {
                            if (Arrays.equals(this.c, object.c)) {
                                if (Arrays.equals(this.d, object.d)) {
                                    if (Arrays.equals(this.e, object.e)) {
                                        if (Long.compare(l3, l) == 0) {
                                            if (this.g == object.g) {
                                            } else {
                                                i = i2;
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
                }
                return i;
            }
            return i2;
        }

        public boolean f() {
            int i3;
            int i;
            int i2;
            if (this.b != -1) {
                if (c() < this.b) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
            } else {
            }
            return i3;
        }

        public com.google.android.exoplayer2.source.ads.c.a g(int i) {
            super(this.a, obj3, i, c.a.b(this.d, i), (Uri[])Arrays.copyOf(this.c, i), c.a.a(this.e, i), this.f, obj9, this.g);
            return aVar;
        }

        public int hashCode() {
            long l = this.a;
            int i21 = 32;
            long l2 = this.f;
            return i12 += z;
        }
    }
    static {
        final int i5 = 0;
        final com.google.android.exoplayer2.source.ads.c.a[] arr = new c.a[i5];
        super(0, arr, 0, obj4, -9223372036854775807L, obj6, 0);
        c.g = cVar2;
        c.a aVar = new c.a(0, arr);
        c.h = aVar.g(i5);
        c.i = b.a;
    }

    private c(Object object, com.google.android.exoplayer2.source.ads.c.a[] c$a2Arr2, long l3, long l4, int i5) {
        super();
        this.a = object;
        this.c = l3;
        this.d = i5;
        this.b = obj1 += obj7;
        this.f = a2Arr2;
        this.e = obj7;
    }

    private boolean d(long l, long l2, int i3) {
        int i;
        long obj7;
        long l3 = Long.MIN_VALUE;
        if (Long.compare(l, l3) == 0) {
            return 0;
        }
        final long l5 = obj11.a;
        int i2 = 1;
        if (Long.compare(l5, l3) == 0) {
            if (Long.compare(i3, l4) != 0) {
                if (Long.compare(l, i3) < 0) {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        if (Long.compare(l, l5) < 0) {
            i = i2;
        }
        return i;
    }

    public com.google.android.exoplayer2.source.ads.c.a a(int i) {
        com.google.android.exoplayer2.source.ads.c.a[] objArr;
        com.google.android.exoplayer2.source.ads.c.a obj3;
        final int i2 = this.e;
        if (i < i2) {
            obj3 = c.h;
        } else {
            obj3 = this.f[i -= i2];
        }
        return obj3;
    }

    public int b(long l, long l2) {
        int cmp;
        int i;
        long l3;
        long obj7;
        long obj9;
        int obj10;
        final long l4 = Long.MIN_VALUE;
        i = -1;
        if (Long.compare(l, l4) != 0) {
            if (Long.compare(obj9, l3) != 0 && Long.compare(l, obj9) >= 0) {
                if (Long.compare(l, obj9) >= 0) {
                } else {
                    obj9 = this.e;
                    while (obj9 < this.b) {
                        if (Long.compare(l3, l4) != 0) {
                        } else {
                        }
                        if (!a(obj9).f()) {
                        }
                        obj9++;
                        if (Long.compare(l3, l) > 0) {
                        } else {
                        }
                    }
                    if (obj9 < this.b) {
                        i = obj9;
                    }
                }
            } else {
            }
        }
        return i;
    }

    public int c(long l, long l2) {
        int i;
        boolean z;
        long l3;
        int i2;
        int i3;
        boolean obj8;
        i4--;
        while (i >= 0) {
            if (this.d(l, obj3, obj10)) {
            }
            i--;
        }
        if (i >= 0 && a(i).e()) {
            if (a(i).e()) {
            } else {
                i = -1;
            }
        } else {
        }
        return i;
    }

    public boolean equals(Object object) {
        int i;
        boolean cmp;
        Class<com.google.android.exoplayer2.source.ads.c> obj;
        Object obj2;
        Class class;
        long l;
        Object obj7;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (c.class != object.getClass()) {
            } else {
                if (p0.b(this.a, object.a) && this.b == object.b && Long.compare(l2, l) == 0 && Long.compare(l3, l) == 0 && this.e == object.e && Arrays.equals(this.f, object.f)) {
                    if (this.b == object.b) {
                        if (Long.compare(l2, l) == 0) {
                            if (Long.compare(l3, l) == 0) {
                                if (this.e == object.e) {
                                    if (Arrays.equals(this.f, object.f)) {
                                    } else {
                                        i = i2;
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
            }
            return i;
        }
        return i2;
    }

    public int hashCode() {
        int i;
        Object obj = this.a;
        if (obj == null) {
            i = 0;
        } else {
            i = obj.hashCode();
        }
        return i11 += i16;
    }

    public String toString() {
        int i4;
        int i2;
        int i5;
        String str2;
        int length;
        long l;
        int i3;
        String str;
        int i;
        int i6;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AdPlaybackState(adsId=");
        stringBuilder.append(this.a);
        stringBuilder.append(", adResumePositionUs=");
        stringBuilder.append(this.c);
        stringBuilder.append(", adGroups=[");
        int i7 = 0;
        i4 = i7;
        str2 = "])";
        for (Object aVar : obj3) {
            stringBuilder.append("adGroup(timeUs=");
            stringBuilder.append(aVar.a);
            stringBuilder.append(", ads=[");
            i5 = i7;
            str = ", ";
            i = 1;
            while (i5 < iArr.length) {
                stringBuilder.append("ad(state=");
                int i8 = aVar3.d[i5];
                if (i8 != 0) {
                } else {
                }
                stringBuilder.append('_');
                stringBuilder.append(", durationUs=");
                stringBuilder.append(aVar4.e[i5]);
                stringBuilder.append(')');
                if (i5 < length4 -= i) {
                }
                i5++;
                str = ", ";
                i = 1;
                stringBuilder.append(str);
                if (i8 != i) {
                } else {
                }
                stringBuilder.append('R');
                if (i8 != 2) {
                } else {
                }
                stringBuilder.append('S');
                if (i8 != 3) {
                } else {
                }
                stringBuilder.append('P');
                if (i8 != 4) {
                } else {
                }
                stringBuilder.append('!');
                stringBuilder.append('?');
            }
            stringBuilder.append(str2);
            if (i4 < length3 -= i) {
            }
            str2 = "])";
            stringBuilder.append(str);
            stringBuilder.append("ad(state=");
            i8 = aVar3.d[i5];
            if (i8 != 0) {
            } else {
            }
            stringBuilder.append('_');
            stringBuilder.append(", durationUs=");
            stringBuilder.append(aVar4.e[i5]);
            stringBuilder.append(')');
            if (i5 < length4 -= i) {
            }
            i5++;
            stringBuilder.append(str);
            if (i8 != i) {
            } else {
            }
            stringBuilder.append('R');
            if (i8 != 2) {
            } else {
            }
            stringBuilder.append('S');
            if (i8 != 3) {
            } else {
            }
            stringBuilder.append('P');
            if (i8 != 4) {
            } else {
            }
            stringBuilder.append('!');
            stringBuilder.append('?');
        }
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }
}
