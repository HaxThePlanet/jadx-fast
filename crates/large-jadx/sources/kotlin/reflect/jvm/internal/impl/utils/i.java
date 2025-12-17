package kotlin.reflect.jvm.internal.impl.utils;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class i<E>  extends AbstractList<E> implements RandomAccess {

    private int a;
    private Object b;

    static class a {
    }

    private static class b implements Iterator<T> {

        private static final kotlin.reflect.jvm.internal.impl.utils.i.b a;
        static {
            i.b bVar = new i.b();
            i.b.a = bVar;
        }

        public static <T> kotlin.reflect.jvm.internal.impl.utils.i.b<T> b() {
            return i.b.a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return 0;
        }

        public T next() {
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }

        @Override // java.util.Iterator
        public void remove() {
            IllegalStateException illegalStateException = new IllegalStateException();
            throw illegalStateException;
        }
    }

    private static abstract class d implements Iterator<T> {

        private boolean a;
        d(kotlin.reflect.jvm.internal.impl.utils.i.a i$a) {
            super();
        }

        @Override // java.util.Iterator
        protected abstract void b();

        protected abstract T c();

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return z ^= 1;
        }

        public final T next() {
            if (this.a) {
            } else {
                this.a = true;
                b();
                return c();
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }
    }

    private class c extends kotlin.reflect.jvm.internal.impl.utils.i.d<E> {

        private final int b;
        final kotlin.reflect.jvm.internal.impl.utils.i c;
        public c(kotlin.reflect.jvm.internal.impl.utils.i i) {
            this.c = i;
            super(0);
            this.b = i.d(i);
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.i$d
        protected void b() {
            if (i.h(this.c) != this.b) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ModCount: ");
            stringBuilder.append(i.i(this.c));
            stringBuilder.append("; expected: ");
            stringBuilder.append(this.b);
            ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException(stringBuilder.toString());
            throw concurrentModificationException;
        }

        protected E c() {
            return i.g(this.c);
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.i$d
        public void remove() {
            b();
            this.c.clear();
        }
    }
    private static void b(int i) {
        String str2;
        int i2;
        String str3;
        String str;
        Object obj10;
        final int i3 = 7;
        final int i4 = 6;
        final int i5 = 5;
        final int i6 = 3;
        final int i7 = 2;
        if (i != i7 && i != i6 && i != i5 && i != i4 && i != i3) {
            if (i != i6) {
                if (i != i5) {
                    if (i != i4) {
                        str2 = i != i3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (i != i7 && i != i6 && i != i5 && i != i4 && i != i3) {
            if (i != i6) {
                if (i != i5) {
                    if (i != i4) {
                        i2 = i != i3 ? i6 : i7;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        Object[] arr = new Object[i2];
        str3 = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
        int i8 = 0;
        switch (i) {
            case 2:
                arr[i8] = str3;
                break;
            case 3:
                arr[i8] = "a";
                break;
            default:
                arr[i8] = "elements";
        }
        String str4 = "toArray";
        int i9 = 1;
        if (i != i7 && i != i6) {
            if (i != i6) {
                if (i != i5 && i != i4 && i != i3) {
                    if (i != i4) {
                        if (i != i3) {
                            arr[i9] = str3;
                        } else {
                            arr[i9] = str4;
                        }
                    } else {
                    }
                } else {
                }
            } else {
                arr[i9] = "iterator";
            }
        } else {
        }
        switch (i) {
            case 3:
                arr[i7] = str4;
                break;
            default:
                arr[i7] = "<init>";
        }
        String format = String.format(str2, arr);
        if (i != i7 && i != i6 && i != i5 && i != i4 && i != i3) {
            if (i != i6) {
                if (i != i5) {
                    if (i != i4) {
                        if (i != i3) {
                            obj10 = new IllegalArgumentException(format);
                        } else {
                            obj10 = new IllegalStateException(format);
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        throw obj10;
    }

    static int d(kotlin.reflect.jvm.internal.impl.utils.i i) {
        return i.modCount;
    }

    static Object g(kotlin.reflect.jvm.internal.impl.utils.i i) {
        return i.b;
    }

    static int h(kotlin.reflect.jvm.internal.impl.utils.i i) {
        return i.modCount;
    }

    static int i(kotlin.reflect.jvm.internal.impl.utils.i i) {
        return i.modCount;
    }

    public void add(int i, E e2) {
        int i4;
        int i2;
        Object[] arr;
        int i3;
        int obj6;
        Object obj7;
        if (i < 0) {
        } else {
            i4 = this.a;
            if (i > i4) {
            } else {
                int i5 = 1;
                if (i4 == 0) {
                    this.b = e2;
                } else {
                    i2 = 0;
                    if (i4 == i5 && i == 0) {
                        if (i == 0) {
                            obj6 = new Object[2];
                            obj6[i2] = e2;
                            obj6[i5] = this.b;
                            this.b = obj6;
                        } else {
                            arr = new Object[i4 + 1];
                            if (i4 == i5) {
                                arr[i2] = this.b;
                            } else {
                                i4 = this.b;
                                System.arraycopy((Object[])i4, i2, arr, i2, i);
                                System.arraycopy(i4, i, arr, i + 1, i7 -= i);
                            }
                            arr[i] = e2;
                            this.b = arr;
                        }
                    } else {
                    }
                }
                this.a = obj6 += i5;
                this.modCount = obj6 += i5;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index: ");
        stringBuilder.append(i);
        stringBuilder.append(", Size: ");
        stringBuilder.append(this.a);
        obj7 = new IndexOutOfBoundsException(stringBuilder.toString());
        throw obj7;
    }

    public boolean add(E e) {
        int arr;
        Object i2;
        int i;
        Object obj;
        int length;
        int i3;
        arr = this.a;
        final int i5 = 1;
        if (arr == 0) {
            this.b = e;
        } else {
            i2 = 2;
            i = 0;
            if (arr == i5) {
                arr = new Object[i2];
                arr[i] = this.b;
                arr[i5] = e;
                this.b = arr;
            } else {
                obj = this.b;
                length = obj.length;
                arr += i5;
                if (arr >= length && i7 += i5 < i4) {
                    arr += i5;
                    if (i7 += i5 < i4) {
                        i3 = i4;
                    }
                    arr = new Object[i3];
                    this.b = arr;
                    System.arraycopy((Object[])obj, i, arr, i, length);
                    obj = arr;
                }
                obj[this.a] = e;
            }
        }
        this.a = obj8 += i5;
        this.modCount = obj8 += i5;
        return i5;
    }

    @Override // java.util.AbstractList
    public void clear() {
        this.b = 0;
        this.a = 0;
        this.modCount = modCount++;
    }

    public E get(int i) {
        int i2;
        if (i < 0) {
        } else {
            i2 = this.a;
            if (i >= i2) {
            } else {
                if (i2 == 1) {
                    return this.b;
                }
                return (Object[])this.b[i];
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index: ");
        stringBuilder.append(i);
        stringBuilder.append(", Size: ");
        stringBuilder.append(this.a);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.toString());
        throw indexOutOfBoundsException;
    }

    public Iterator<E> iterator() {
        int i = this.a;
        final int i4 = 0;
        if (i == 0) {
            kotlin.reflect.jvm.internal.impl.utils.i.b bVar = i.b.b();
            if (bVar == null) {
            } else {
                return bVar;
            }
            i.b(2);
            throw i4;
        }
        if (i == 1) {
            i.c cVar = new i.c(this);
            return cVar;
        }
        Iterator iterator = super.iterator();
        if (iterator == null) {
        } else {
            return iterator;
        }
        i.b(3);
        throw i4;
    }

    public E remove(int i) {
        int i2;
        Object obj2;
        Object obj;
        int i3;
        Object obj7;
        if (i < 0) {
        } else {
            i2 = this.a;
            if (i >= i2) {
            } else {
                int i8 = 0;
                int i9 = 1;
                if (i2 == i9) {
                    obj7 = this.b;
                    this.b = i8;
                } else {
                    obj2 = this.b;
                    if (i2 == 2) {
                        this.b = obj2[i - 1];
                    } else {
                        i7 -= i9;
                        if (i2 > 0) {
                            System.arraycopy(obj2, i + 1, obj2, i, i2);
                        }
                        obj2[obj7 -= i9] = i8;
                    }
                    obj7 = obj;
                }
                this.a = i4 -= i9;
                this.modCount = modCount += i9;
                return obj7;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index: ");
        stringBuilder.append(i);
        stringBuilder.append(", Size: ");
        stringBuilder.append(this.a);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.toString());
        throw indexOutOfBoundsException;
    }

    public E set(int i, E e2) {
        int i2;
        int i3;
        Object obj3;
        if (i < 0) {
        } else {
            i2 = this.a;
            if (i >= i2) {
            } else {
                if (i2 == 1) {
                    obj3 = this.b;
                    this.b = e2;
                } else {
                    i2 = this.b;
                    i2[i] = e2;
                    obj3 = i3;
                }
                return obj3;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index: ");
        stringBuilder.append(i);
        stringBuilder.append(", Size: ");
        stringBuilder.append(this.a);
        IndexOutOfBoundsException obj4 = new IndexOutOfBoundsException(stringBuilder.toString());
        throw obj4;
    }

    @Override // java.util.AbstractList
    public int size() {
        return this.a;
    }

    public <T> T[] toArray(T[] tArr) {
        int i;
        int i2;
        final int i3 = 0;
        if (tArr == null) {
        } else {
            int length = tArr.length;
            i = this.a;
            i2 = 1;
            final int i5 = 0;
            if (i == i2) {
                if (length != 0) {
                    tArr[i5] = this.b;
                    int i4 = this.a;
                    if (length > i4) {
                        tArr[i4] = i3;
                    }
                    if (tArr == null) {
                    } else {
                        return tArr;
                    }
                    i.b(7);
                    throw i3;
                } else {
                    Object obj6 = Array.newInstance(tArr.getClass().getComponentType(), i2);
                    (Object[])obj6[i5] = this.b;
                    if (obj6 == null) {
                    } else {
                        return obj6;
                    }
                }
                i.b(5);
                throw i3;
            }
            if (length < i) {
                obj6 = Arrays.copyOf((Object[])this.b, i, tArr.getClass());
                if (obj6 == null) {
                } else {
                    return obj6;
                }
                i.b(6);
                throw i3;
            }
            if (i != 0) {
                System.arraycopy(this.b, i5, tArr, i5, i);
            }
        }
        i.b(4);
        throw i3;
    }
}
