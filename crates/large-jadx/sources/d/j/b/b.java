package d.j.b;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: FocusStrategy.java */
/* loaded from: classes.dex */
class b {

    public interface a<T> {
        void a(T t, Rect rect);
    }

    public interface b<T, V> {
        V a(T t, int i);

        int b(T t);
    }

    private static class c<T> implements Comparator<T> {

        private final Rect a = new Rect();
        private final Rect b = new Rect();
        private final boolean c;
        private final b.a<T> v;
        c(boolean z, b.a<T> aVar) {
            super();
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            this.c = z;
            this.v = aVar;
        }

        @Override // java.util.Comparator
        public int compare(T t, T t2) {
            int i = -1;
            this.v.a(t, this.a);
            this.v.a(t2, this.b);
            i = -1;
            if (rect.top < rect2.top) {
                return i;
            }
            i = 1;
            if (rect.top > rect2.top) {
                return i;
            }
            if (rect.left < rect2.left && this.c) {
                return i;
            }
            if (rect.left > rect2.left) {
                if (!(this.c)) {
                }
                return i;
            }
            if (rect.bottom < rect2.bottom) {
                return i;
            }
            if (rect.bottom > rect2.bottom) {
                return i;
            }
            if (rect.right < rect2.right && this.c) {
                return i;
            }
            if (rect.right > rect2.right && this.c) {
                return i;
            }
            return 0;
        }
    }
    private static boolean a(int i, Rect rect, Rect rect2, Rect rect3) {
        boolean z = false;
        z = false;
        return false;
    }

    private static boolean b(int i, Rect rect, Rect rect2) {
        boolean z = true;
        boolean z2 = true;
        int bottom2;
        int right2;
        int bottom22;
        int right22;
        int i2 = 17;
        int i5 = 1;
        final int i4 = 0;
        if (i != 17) {
            int i3 = 33;
            i2 = 66;
            if (!(i == 33 || i != 66)) {
                i3 = 130;
                if (i != 130) {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
            } else {
                if (rect2.right >= rect.left) {
                    if (rect2.left > rect.right) {
                    }
                }
            }
            return z2;
        }
        if (rect2.bottom >= rect.top) {
            if (rect2.top > rect.bottom) {
            }
        }
        return z;
    }

    public static <L, T> T c(L l, b.b<L, T> bVar, b.a<T> aVar, T t, Rect rect, int i) {
        int i2 = 0;
        int i3 = 0;
        boolean z;
        rect = new Rect(rect);
        i3 = 0;
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    } else {
                        i = -(rect.height() + 1);
                        rect.offset(i3, i);
                    }
                }
                i = -(rect.width() + 1);
                rect.offset(i, i3);
            } else {
                i = rect.height() + 1;
                rect.offset(i3, i);
            }
        } else {
            i = rect.width() + 1;
            rect.offset(i, i3);
        }
        i2 = 0;
        final Rect rect2 = new Rect();
        while (i3 < bVar.b(l)) {
            Object obj = bVar.a(l, i3);
            i3 = i3 + 1;
        }
        return i2;
    }

    public static <L, T> T d(L l, b.b<L, T> bVar, b.a<T> aVar, T t, int i, boolean z, boolean z2) {
        final int i2 = bVar.b(l);
        final ArrayList arrayList = new ArrayList(i2);
        i = 0;
        while (i < i2) {
            arrayList.add(bVar.a(l, i));
            i = i + 1;
        }
        Collections.sort(arrayList, new b.c(z, aVar));
        if (i != 1 && i == 2) {
            return b.e(t, arrayList, z2);
        }
        return b.f(t, arrayList, z2);
    }

    private static <T> T e(T t, ArrayList<T> arrayList, boolean z) {
        int lastIndexOf = -1;
        final int size = arrayList.size();
        if (t == null) {
            lastIndexOf = -1;
        } else {
            lastIndexOf = arrayList.lastIndexOf(t);
        }
        lastIndexOf++;
        if (i < size) {
            return arrayList.get(i);
        }
        if (z && size > 0) {
            return arrayList.get(0);
        }
        return null;
    }

    private static <T> T f(T t, ArrayList<T> arrayList, boolean z) {
        int indexOf;
        indexOf = arrayList.size();
        if (t == null) {
        } else {
            indexOf = arrayList.indexOf(t);
        }
        indexOf--;
        if (i2 >= 0) {
            return arrayList.get(i2);
        }
        if (z && indexOf > 0) {
            return arrayList.get(indexOf - 1);
        }
        return null;
    }

    private static boolean h(int i, Rect rect, Rect rect2, Rect rect3) {
        boolean z = false;
        z = false;
        if (!b.i(rect, rect2, i)) {
            return false;
        }
        final int i2 = 1;
        if (!b.i(rect, rect3, i)) {
            return true;
        }
        if (b.a(i, rect, rect2, rect3)) {
            return true;
        }
        if (b.a(i, rect, rect3, rect2)) {
            return false;
        }
        if (b.g(b.k(i, rect, rect2), b.o(i, rect, rect2)) < b.g(b.k(i, rect, rect3), b.o(i, rect, rect3))) {
        }
        return z;
    }

    private static boolean i(Rect rect, Rect rect2, int i) {
        boolean z = true;
        boolean z2 = true;
        boolean z3 = true;
        boolean z4 = true;
        int bottom2;
        int right2;
        int top2;
        int left2;
        int bottom22;
        int right22;
        int top22;
        int left22;
        int top23;
        int left23;
        int bottom23;
        int right23;
        int i7 = 1;
        i = 0;
        if (i != 17 && i != 33 && i != 66) {
            if (i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            } else {
                if (rect.top < rect2.top || rect.bottom <= rect2.top) {
                    if (rect.bottom >= rect2.bottom) {
                    }
                }
                return z;
            }
        }
        if (rect.right > rect2.right || rect.left >= rect2.right) {
            if (rect.left <= rect2.left) {
            }
        }
        return z4;
    }

    private static boolean j(int i, Rect rect, Rect rect2) {
        boolean z = true;
        boolean z2 = true;
        boolean z3 = true;
        boolean z4 = true;
        int i7 = 1;
        final int i2 = 0;
        if (i != 17 && i != 33 && i != 66) {
            if (i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            } else {
                if (rect.bottom > rect2.top) {
                }
                return z3;
            }
        }
        if (rect.left < rect2.right) {
        }
        return z;
    }

    private static int k(int i, Rect rect, Rect rect2) {
        return Math.max(0, b.l(i, rect, rect2));
    }

    private static int l(int i, Rect rect, Rect rect2) {
        int left2;
        int right2;
        int i2 = 17;
        if (i != 17) {
            i2 = 33;
            if (i != 33) {
                i2 = 66;
                if (i != 66) {
                    i2 = 130;
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return left2 - right2;
    }

    private static int m(int i, Rect rect, Rect rect2) {
        return Math.max(1, b.n(i, rect, rect2));
    }

    private static int n(int i, Rect rect, Rect rect2) {
        int left2;
        int left22;
        int i2 = 17;
        if (i != 17) {
            i2 = 33;
            if (i != 33) {
                i2 = 66;
                if (i != 66) {
                    i2 = 130;
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return left2 - left22;
    }

    private static int o(int i, Rect rect, Rect rect2) {
        int i2 = 17;
        if (i != 17 && i != 33 && i != 66 && i == 130) {
            return Math.abs((rect.left + (rect.width() / 2)) - (rect2.left + (rect2.width() / 2)));
        }
        return Math.abs((rect.top + (rect.height() / 2)) - (rect2.top + (rect2.height() / 2)));
    }

    private static int g(int i, int i2) {
        return (i * 13) * i + (i2 * i2);
    }
}
