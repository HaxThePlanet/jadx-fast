package d.j.b;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes.dex */
class b {

    public interface a {
        public abstract void a(T t, Rect rect2);
    }

    public interface b {
        public abstract V a(T t, int i2);

        public abstract int b(T t);
    }

    private static class c implements Comparator<T> {

        private final Rect a;
        private final Rect b;
        private final boolean c;
        private final d.j.b.b.a<T> v;
        c(boolean z, d.j.b.b.a<T> b$a2) {
            super();
            Rect rect = new Rect();
            this.a = rect;
            Rect rect2 = new Rect();
            this.b = rect2;
            this.c = z;
            this.v = a2;
        }

        public int compare(T t, T t2) {
            int i;
            final Rect rect = this.a;
            final Rect rect2 = this.b;
            this.v.a(t, rect);
            this.v.a(t2, rect2);
            int obj5 = rect.top;
            int obj6 = rect2.top;
            i = -1;
            if (obj5 < obj6) {
                return i;
            }
            final int i2 = 1;
            if (obj5 > obj6) {
                return i2;
            }
            obj5 = rect.left;
            obj6 = rect2.left;
            if (obj5 < obj6 && this.c) {
                if (this.c) {
                    i = i2;
                }
                return i;
            }
            if (obj5 > obj6) {
                if (this.c) {
                } else {
                    i = i2;
                }
                return i;
            }
            obj5 = rect.bottom;
            obj6 = rect2.bottom;
            if (obj5 < obj6) {
                return i;
            }
            if (obj5 > obj6) {
                return i2;
            }
            obj5 = rect.right;
            obj6 = rect2.right;
            if (obj5 < obj6 && this.c) {
                if (this.c) {
                    i = i2;
                }
                return i;
            }
            if (obj5 > obj6) {
                if (this.c) {
                } else {
                    i = i2;
                }
                return i;
            }
            return 0;
        }
    }
    private static boolean a(int i, Rect rect2, Rect rect3, Rect rect4) {
        int i2;
        int i3;
        if (!b.b(i, rect2, rect4)) {
            if (!b.b(i, rect2, rect3)) {
            } else {
                int i4 = 1;
                if (!b.j(i, rect2, rect4)) {
                    return i4;
                }
                if (i != 17) {
                    if (i == 66) {
                    } else {
                        if (b.k(i, rect2, rect3) < b.m(i, rect2, rect4)) {
                            i3 = i4;
                        }
                    }
                    return i3;
                }
            }
            return i4;
        }
        return 0;
    }

    private static boolean b(int i, Rect rect2, Rect rect3) {
        int i3;
        int i2;
        int i4;
        int obj3;
        Object obj4;
        i4 = 1;
        final int i5 = 0;
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                    } else {
                        if (rect3.right >= rect2.left && rect3.left <= rect2.right) {
                            if (rect3.left <= rect2.right) {
                            } else {
                                i4 = i5;
                            }
                        } else {
                        }
                    }
                    obj3 = new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    throw obj3;
                }
            } else {
            }
            return i4;
        }
        if (rect3.bottom >= rect2.top && rect3.top <= rect2.bottom) {
            if (rect3.top <= rect2.bottom) {
            } else {
                i4 = i5;
            }
        } else {
        }
        return i4;
    }

    public static <L, T> T c(L l, d.j.b.b.b<L, T> b$b2, d.j.b.b.a<T> b$a3, T t4, Rect rect5, int i6) {
        int i;
        int i2;
        int i3;
        Object obj;
        boolean z;
        Rect rect = new Rect(rect5);
        i3 = 0;
        if (i6 != 17) {
            if (i6 != 33) {
                if (i6 != 66) {
                    if (i6 != 130) {
                    } else {
                        rect.offset(i3, -i9);
                    }
                    IllegalArgumentException obj7 = new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    throw obj7;
                }
                rect.offset(-i10, i3);
            } else {
                rect.offset(i3, height++);
            }
        } else {
            rect.offset(width2++, i3);
        }
        i2 = 0;
        Rect rect2 = new Rect();
        while (i3 < b2.b(l)) {
            obj = b2.a(l, i3);
            if (obj == t4) {
            } else {
            }
            a3.a(obj, rect2);
            if (b.h(i6, rect5, rect2, rect)) {
            }
            i3++;
            rect.set(rect2);
            i2 = obj;
        }
        return i2;
    }

    public static <L, T> T d(L l, d.j.b.b.b<L, T> b$b2, d.j.b.b.a<T> b$a3, T t4, int i5, boolean z6, boolean z7) {
        int i;
        Object obj;
        final int i2 = b2.b(l);
        ArrayList arrayList = new ArrayList(i2);
        i = 0;
        while (i < i2) {
            arrayList.add(b2.a(l, i));
            i++;
        }
        b.c obj4 = new b.c(z6, a3);
        Collections.sort(arrayList, obj4);
        if (i5 != 1) {
            if (i5 != 2) {
            } else {
                return b.e(t4, arrayList, z7);
            }
            obj4 = new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
            throw obj4;
        }
        return b.f(t4, arrayList, z7);
    }

    private static <T> T e(T t, ArrayList<T> arrayList2, boolean z3) {
        int obj1;
        final int size = arrayList2.size();
        if (t == null) {
            obj1 = -1;
        } else {
            obj1 = arrayList2.lastIndexOf(t);
        }
        obj1++;
        if (obj1 < size) {
            return arrayList2.get(obj1);
        }
        if (z3 && size > 0) {
            if (size > 0) {
                return arrayList2.get(0);
            }
        }
        return 0;
    }

    private static <T> T f(T t, ArrayList<T> arrayList2, boolean z3) {
        int obj1;
        int size = arrayList2.size();
        if (t == null) {
            obj1 = size;
        } else {
            obj1 = arrayList2.indexOf(t);
        }
        obj1--;
        if (obj1 >= 0) {
            return arrayList2.get(obj1);
        }
        if (z3 && size > 0) {
            if (size > 0) {
                return arrayList2.get(size--);
            }
        }
        return 0;
    }

    private static int g(int i, int i2) {
        return i4 += obj2;
    }

    private static boolean h(int i, Rect rect2, Rect rect3, Rect rect4) {
        int i2;
        i2 = 0;
        if (!b.i(rect2, rect3, i)) {
            return i2;
        }
        final int i5 = 1;
        if (!b.i(rect2, rect4, i)) {
            return i5;
        }
        if (b.a(i, rect2, rect3, rect4)) {
            return i5;
        }
        if (b.a(i, rect2, rect4, rect3)) {
            return i2;
        }
        if (b.g(b.k(i, rect2, rect3), b.o(i, rect2, rect3)) < b.g(b.k(i, rect2, rect4), b.o(i, rect2, rect4))) {
            i2 = i5;
        }
        return i2;
    }

    private static boolean i(Rect rect, Rect rect2, int i3) {
        int i;
        int obj3;
        int obj4;
        int obj5;
        i = 1;
        final int i7 = 0;
        if (i3 != 17 && i3 != 33 && i3 != 66) {
            if (i3 != 33) {
                if (i3 != 66) {
                    if (i3 != 130) {
                    } else {
                        int top = rect2.top;
                        if (rect.top >= top) {
                            if (rect.bottom <= top && rect.bottom < rect2.bottom) {
                                if (rect.bottom < rect2.bottom) {
                                } else {
                                    i = i7;
                                }
                            } else {
                            }
                        } else {
                        }
                        return i;
                    }
                    obj3 = new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    throw obj3;
                }
                int left = rect2.left;
                if (rect.left >= left) {
                    if (rect.right <= left && rect.right < rect2.right) {
                        if (rect.right < rect2.right) {
                        } else {
                            i = i7;
                        }
                    } else {
                    }
                } else {
                }
                return i;
            }
            int bottom = rect2.bottom;
            if (rect.bottom <= bottom) {
                if (rect.top >= bottom && rect.top > rect2.top) {
                    if (rect.top > rect2.top) {
                    } else {
                        i = i7;
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        int right = rect2.right;
        if (rect.right <= right) {
            if (rect.left >= right && rect.left > rect2.left) {
                if (rect.left > rect2.left) {
                } else {
                    i = i7;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private static boolean j(int i, Rect rect2, Rect rect3) {
        int i2;
        i2 = 1;
        final int i7 = 0;
        if (i != 17 && i != 33 && i != 66) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                    } else {
                        if (rect2.bottom <= rect3.top) {
                        } else {
                            i2 = i7;
                        }
                        return i2;
                    }
                    IllegalArgumentException obj3 = new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    throw obj3;
                }
                if (rect2.right <= rect3.left) {
                } else {
                    i2 = i7;
                }
                return i2;
            }
            if (rect2.top >= rect3.bottom) {
            } else {
                i2 = i7;
            }
            return i2;
        }
        if (rect2.left >= rect3.right) {
        } else {
            i2 = i7;
        }
        return i2;
    }

    private static int k(int i, Rect rect2, Rect rect3) {
        return Math.max(0, b.l(i, rect2, rect3));
    }

    private static int l(int i, Rect rect2, Rect rect3) {
        int i2;
        int obj1;
        int obj2;
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                    } else {
                        obj1 = rect3.top;
                        obj2 = rect2.bottom;
                    }
                    obj1 = new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    throw obj1;
                } else {
                    obj1 = rect3.left;
                    obj2 = rect2.right;
                }
            } else {
                obj1 = rect2.top;
                obj2 = rect3.bottom;
            }
        } else {
            obj1 = rect2.left;
            obj2 = rect3.right;
        }
        return obj1 -= obj2;
    }

    private static int m(int i, Rect rect2, Rect rect3) {
        return Math.max(1, b.n(i, rect2, rect3));
    }

    private static int n(int i, Rect rect2, Rect rect3) {
        int i2;
        int obj1;
        int obj2;
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                    } else {
                        obj1 = rect3.bottom;
                        obj2 = rect2.bottom;
                    }
                    obj1 = new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    throw obj1;
                } else {
                    obj1 = rect3.right;
                    obj2 = rect2.right;
                }
            } else {
                obj1 = rect2.top;
                obj2 = rect3.top;
            }
        } else {
            obj1 = rect2.left;
            obj2 = rect3.left;
        }
        return obj1 -= obj2;
    }

    private static int o(int i, Rect rect2, Rect rect3) {
        int i3;
        int i2;
        if (i != 17 && i != 33 && i != 66) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                    } else {
                    }
                    IllegalArgumentException obj1 = new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    throw obj1;
                }
            }
            return Math.abs(obj1 -= obj2);
        }
        return Math.abs(obj1 -= obj2);
    }
}
