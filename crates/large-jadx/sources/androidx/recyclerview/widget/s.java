package androidx.recyclerview.widget;

import java.util.List;

/* loaded from: classes.dex */
class s {

    final androidx.recyclerview.widget.s.a a;

    interface a {
        public abstract void a(androidx.recyclerview.widget.a.b a$b);

        public abstract androidx.recyclerview.widget.a.b b(int i, int i2, int i3, Object object4);
    }
    s(androidx.recyclerview.widget.s.a s$a) {
        super();
        this.a = a;
    }

    private int a(List<androidx.recyclerview.widget.a.b> list) {
        int i3;
        int i;
        int i4;
        int i2;
        final int i5 = 1;
        size -= i5;
        i = 0;
        while (i3 >= 0) {
            i = i5;
            i3--;
        }
        return -1;
    }

    private void c(List<androidx.recyclerview.widget.a.b> list, int i2, androidx.recyclerview.widget.a.b a$b3, int i4, androidx.recyclerview.widget.a.b a$b5) {
        int i;
        int i6;
        int i5;
        int i3;
        i = b3.d;
        i6 = b5.b;
        i5 = i < i6 ? -1 : 0;
        i3 = b3.b;
        if (i3 < i6) {
            i5++;
        }
        if (i6 <= i3) {
            b3.b = i3 += i6;
        }
        int i7 = b5.b;
        if (i7 <= i) {
            b3.d = i += i3;
        }
        b5.b = i7 += i5;
        list.set(i2, b5);
        list.set(i4, b3);
    }

    private void d(List<androidx.recyclerview.widget.a.b> list, int i2, int i3) {
        int i;
        List list2;
        int i4;
        int i5;
        final Object obj3 = obj;
        final Object obj4 = obj2;
        int i6 = obj4.a;
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 != 4) {
                } else {
                    this.f(list, i2, (a.b)obj3, i3, (a.b)obj4);
                }
            } else {
                this.e(list, i2, obj3, i3, obj4);
            }
        } else {
            this.c(list, i2, obj3, i3, obj4);
        }
    }

    void b(List<androidx.recyclerview.widget.a.b> list) {
        final int i = a(list);
        while (i != -1) {
            d(list, i, i + 1);
            i = a(list);
        }
    }

    void e(List<androidx.recyclerview.widget.a.b> list, int i2, androidx.recyclerview.widget.a.b a$b3, int i4, androidx.recyclerview.widget.a.b a$b5) {
        int i14;
        int i15;
        int i22;
        int i20;
        int i8;
        int i6;
        int i23;
        int i;
        int i11;
        int i18;
        int i21;
        int i13;
        int i16;
        int i5;
        int i3;
        int i25;
        int i12;
        int i9;
        int i10;
        int i17;
        int i7;
        int i24;
        int i19;
        androidx.recyclerview.widget.s.a obj10;
        i23 = b3.b;
        int i27 = b3.d;
        i5 = 0;
        i3 = 1;
        if (i23 < i27) {
            if (b5.b == i23 && b5.d == i27 - i23) {
                if (b5.d == i27 - i23) {
                    i14 = i5;
                    i5 = i3;
                } else {
                    i14 = i5;
                }
            } else {
            }
        } else {
            if (b5.b == i27 + 1 && b5.d == i23 -= i27) {
                if (b5.d == i23 -= i27) {
                    i5 = i14;
                } else {
                    i14 = i3;
                }
            } else {
            }
        }
        int i30 = b5.b;
        int i32 = 2;
        if (i27 < i30) {
            b5.b = i30 -= i3;
        } else {
            i17 = b5.d;
            b5.d = i17 -= i3;
            b3.a = i32;
            b3.d = i3;
            if (i27 < i30 += i17 && b5.d == 0) {
                b5.d = i17 -= i3;
                b3.a = i32;
                b3.d = i3;
                if (b5.d == 0) {
                    list.remove(i4);
                    this.a.a(b5);
                }
            }
        }
        i = b3.b;
        i9 = b5.b;
        if (i <= i9) {
            b5.b = i9 += i3;
        } else {
            i24 = b5.d;
            if (i < i9 + i24) {
                i7 = this.a.b(i32, i += i3, i31 -= i, 0);
                b5.d = i29 -= i3;
            }
        }
        if (i5 != 0) {
            list.set(i2, b5);
            list.remove(i4);
            this.a.a(b3);
        }
        if (i14 != 0) {
            i22 = b3.b;
            if (i7 != 0 && i22 > i7.b) {
                i22 = b3.b;
                if (i22 > i7.b) {
                    b3.b = i22 -= i18;
                }
                i14 = b3.d;
                if (i14 > i7.b) {
                    b3.d = i14 -= i;
                }
            }
            i15 = b3.b;
            if (i15 > b5.b) {
                b3.b = i15 -= i11;
            }
            i6 = b3.d;
            if (i6 > b5.b) {
                b3.d = i6 -= i16;
            }
        } else {
            i8 = b3.b;
            if (i7 != 0 && i8 >= i7.b) {
                i8 = b3.b;
                if (i8 >= i7.b) {
                    b3.b = i8 -= i13;
                }
                i14 = b3.d;
                if (i14 >= i7.b) {
                    b3.d = i14 -= i;
                }
            }
            i20 = b3.b;
            if (i20 >= b5.b) {
                b3.b = i20 -= i21;
            }
            i6 = b3.d;
            if (i6 >= b5.b) {
                b3.d = i6 -= i16;
            }
        }
        list.set(i2, b5);
        if (b3.b != b3.d) {
            list.set(i4, b3);
        } else {
            list.remove(i4);
        }
        if (i7 != 0) {
            list.add(i2, i7);
        }
    }

    void f(List<androidx.recyclerview.widget.a.b> list, int i2, androidx.recyclerview.widget.a.b a$b3, int i4, androidx.recyclerview.widget.a.b a$b5) {
        int i11;
        int i9;
        int i7;
        int i6;
        int i8;
        int i;
        int i3;
        int i10;
        int i5;
        androidx.recyclerview.widget.s.a obj11;
        int i12 = b3.d;
        int i13 = b5.b;
        final int i16 = 4;
        i8 = 1;
        if (i12 < i13) {
            b5.b = i13 -= i8;
            i11 = i6;
        } else {
            i = b5.d;
            if (i12 < i13 += i) {
                b5.d = i -= i8;
                i11 = this.a.b(i16, b3.b, i8, b5.c);
            } else {
            }
        }
        i7 = b3.b;
        i3 = b5.b;
        if (i7 <= i3) {
            b5.b = i3 += i8;
        } else {
            i10 = b5.d;
            if (i7 < i3 + i10) {
                i18 -= i7;
                i6 = this.a.b(i16, i7 += i8, i3, b5.c);
                b5.d = i15 -= i3;
            }
        }
        list.set(i4, b3);
        if (b5.d > 0) {
            list.set(i2, b5);
        } else {
            list.remove(i2);
            this.a.a(b5);
        }
        if (i11 != 0) {
            list.add(i2, i11);
        }
        if (i6 != 0) {
            list.add(i2, i6);
        }
    }
}
