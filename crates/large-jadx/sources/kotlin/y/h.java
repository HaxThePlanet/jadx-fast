package kotlin.y;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.h0.g;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u001e\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u001b\u0008\u0007\u0018\u0000 P*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001PB\u000f\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0007\u0008\u0016¢\u0006\u0002\u0010\u0006B\u0015\u0008\u0016\u0012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008¢\u0006\u0002\u0010\tJ\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00042\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008H\u0016J\u0016\u0010\u001a\u001a\u00020\u00142\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008H\u0016J\u0013\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u0008\u0010\u001e\u001a\u00020\u0017H\u0016J\u0016\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0016J\u001e\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00042\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008H\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004H\u0002J\u001d\u0010'\u001a\u00020\u00142\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00140)H\u0082\u0008J\u000b\u0010*\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010,\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0016\u0010-\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0015\u00100\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\u0016\u00102\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u0004H\u0083\u0008¢\u0006\u0002\u0010.J\u0011\u0010!\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0083\u0008JM\u00103\u001a\u00020\u00172>\u00104\u001a:\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u00086\u0012\u0008\u00087\u0012\u0004\u0008\u0008(\u000e\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u000b¢\u0006\u000c\u00086\u0012\u0008\u00087\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u001705H\u0000¢\u0006\u0002\u00088J\u0008\u00109\u001a\u00020\u0014H\u0016J\u000b\u0010:\u001a\u00028\u0000¢\u0006\u0002\u0010+J\u0015\u0010;\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\r\u0010<\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0010\u0010=\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010>\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0015\u0010?\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u0016\u0010@\u001a\u00020\u00142\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008H\u0016J\u0015\u0010A\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010.J\u000b\u0010B\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010C\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u000b\u0010D\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010E\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0016\u0010F\u001a\u00020\u00142\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008H\u0016J\u001e\u0010G\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010HJ\u0017\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u000bH\u0000¢\u0006\u0004\u0008J\u0010KJ)\u0010I\u001a\u0008\u0012\u0004\u0012\u0002HL0\u000b\"\u0004\u0008\u0001\u0010L2\u000c\u0010M\u001a\u0008\u0012\u0004\u0012\u0002HL0\u000bH\u0000¢\u0006\u0004\u0008J\u0010NJ\u0015\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u000bH\u0016¢\u0006\u0002\u0010KJ'\u0010O\u001a\u0008\u0012\u0004\u0012\u0002HL0\u000b\"\u0004\u0008\u0001\u0010L2\u000c\u0010M\u001a\u0008\u0012\u0004\u0012\u0002HL0\u000bH\u0016¢\u0006\u0002\u0010NR\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004@RX\u0096\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006Q", d2 = {"Lkotlin/collections/ArrayDeque;", "E", "Lkotlin/collections/AbstractMutableList;", "initialCapacity", "", "(I)V", "()V", "elements", "", "(Ljava/util/Collection;)V", "elementData", "", "", "[Ljava/lang/Object;", "head", "<set-?>", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "addFirst", "(Ljava/lang/Object;)V", "addLast", "clear", "contains", "copyCollectionElements", "internalIndex", "copyElements", "newCapacity", "decremented", "ensureCapacity", "minCapacity", "filterInPlace", "predicate", "Lkotlin/Function1;", "first", "()Ljava/lang/Object;", "firstOrNull", "get", "(I)Ljava/lang/Object;", "incremented", "indexOf", "(Ljava/lang/Object;)I", "internalGet", "internalStructure", "structure", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "internalStructure$kotlin_stdlib", "isEmpty", "last", "lastIndexOf", "lastOrNull", "negativeMod", "positiveMod", "remove", "removeAll", "removeAt", "removeFirst", "removeFirstOrNull", "removeLast", "removeLastOrNull", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "testToArray", "testToArray$kotlin_stdlib", "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toArray", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class h<E>  extends kotlin.y.d<E> {

    private static final Object[] v;
    public static final kotlin.y.h.a w;
    private int a;
    private Object[] b;
    private int c;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0007\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0008\u000cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\u0008\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Lkotlin/collections/ArrayDeque$Companion;", "", "()V", "defaultMinCapacity", "", "emptyElementData", "", "[Ljava/lang/Object;", "maxArraySize", "newCapacity", "oldCapacity", "minCapacity", "newCapacity$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public final int a(int i, int i2) {
            int obj3;
            if (obj3 - i2 < 0) {
                obj3 = i2;
            }
            int i5 = 2147483639;
            if (obj3 - i5 > 0) {
                obj3 = i2 > i5 ? 0x7fffffff /* Unknown resource */ : i5;
            }
            return obj3;
        }
    }
    static {
        h.a aVar = new h.a(0);
        h.w = aVar;
        h.v = new Object[0];
    }

    public h() {
        super();
        this.b = h.v;
    }

    private final int A(int i) {
        Object[] length;
        int obj3;
        length = this.b;
        if (i >= length.length) {
            i -= length;
        }
        return obj3;
    }

    public static final Object[] h(kotlin.y.h h) {
        return h.b;
    }

    public static final int i(kotlin.y.h h) {
        return h.a;
    }

    public static final int l(kotlin.y.h h, int i2) {
        return h.y(i2);
    }

    public static final int m(kotlin.y.h h, int i2) {
        return h.z(i2);
    }

    public static final int p(kotlin.y.h h, int i2) {
        return h.A(i2);
    }

    public static final void q(kotlin.y.h h, int i2) {
        h.c = i2;
    }

    private final void s(int i, Collection<? extends E> collection2) {
        Object[] next;
        Object next2;
        int obj5;
        final Iterator iterator = collection2.iterator();
        while (obj5 < objArr.length) {
            if (!iterator.hasNext()) {
                break;
            } else {
            }
            this.b[obj5] = iterator.next();
            obj5++;
        }
        obj5 = 0;
        while (obj5 < this.a) {
            if (!iterator.hasNext()) {
                break;
            } else {
            }
            this.b[obj5] = iterator.next();
            obj5++;
        }
        this.c = obj5 += obj6;
    }

    private final void t(int i) {
        final Object[] obj5 = new Object[i];
        Object[] objArr = this.b;
        final int i5 = 0;
        l.f(objArr, obj5, i5, this.a, objArr.length);
        Object[] objArr2 = this.b;
        int i4 = this.a;
        l.f(objArr2, obj5, length -= i4, i5, i4);
        this.a = i5;
        this.b = obj5;
    }

    private final int u(int i) {
        int obj1;
        if (i == 0) {
            obj1 = i.B(this.b);
        } else {
            i--;
        }
        return obj1;
    }

    private final void v(int i) {
        if (i < 0) {
        } else {
            Object[] objArr = this.b;
            if (i <= objArr.length) {
            }
            if (objArr == h.v) {
                this.b = new Object[g.b(i, 10)];
            }
            t(h.w.a(objArr.length, i));
        }
        IllegalStateException obj3 = new IllegalStateException("Deque is too big.");
        throw obj3;
    }

    private final int y(int i) {
        int obj2;
        obj2 = i == i.B(this.b) ? 0 : i + 1;
        return obj2;
    }

    private final int z(int i) {
        int length;
        int obj2;
        if (i < 0) {
            i += length;
        }
        return obj2;
    }

    public void add(int i, E e2) {
        int i3;
        int i6;
        Object[] i2;
        int i5;
        int i4;
        Object obj;
        int length;
        Object[] obj8;
        b.a.b(i, size());
        if (i == size()) {
            addLast(e2);
        }
        if (i == 0) {
            addFirst(e2);
        }
        int i11 = 1;
        v(size2 += i11);
        i3 = h.p(this, i8 += i);
        i5 = 0;
        if (i < i12 >>= i11) {
            obj8 = u(i3);
            i3 = u(this.a);
            i2 = this.a;
            if (obj8 >= i2) {
                i5 = this.b;
                i5[i3] = i5[i2];
                l.f(i5, i5, i2, i2 + 1, obj8 + 1);
            } else {
                Object[] objArr2 = this.b;
                l.f(objArr2, objArr2, i2 + -1, i2, objArr2.length);
                i2 = this.b;
                i2[length4 -= i11] = i2[i5];
                l.f(i2, i2, i5, i11, obj8 + 1);
            }
            this.b[obj8] = e2;
            this.a = i3;
        } else {
            obj8 = h.p(this, i14 += obj8);
            if (i3 < obj8) {
                i6 = this.b;
                l.f(i6, i6, i3 + 1, i3, obj8);
            } else {
                Object[] objArr = this.b;
                l.f(objArr, objArr, i11, i5, obj8);
                obj8 = this.b;
                obj8[i5] = obj8[length2 -= i11];
                l.f(obj8, obj8, i3 + 1, i3, length3 -= i11);
            }
            this.b[i3] = e2;
        }
        this.c = obj8 += i11;
    }

    public boolean add(E e) {
        addLast(e);
        return 1;
    }

    public boolean addAll(int i, Collection<? extends E> collection2) {
        Object[] i4;
        int length2;
        int i3;
        int size;
        int length3;
        int length;
        int i2;
        int obj9;
        n.f(collection2, "elements");
        b.a.b(i, size());
        length2 = 0;
        if (collection2.isEmpty()) {
            return length2;
        }
        if (i == size()) {
            return addAll(collection2);
        }
        v(size3 += size6);
        i4 = h.p(this, i6 += size4);
        i3 = h.p(this, i8 += i);
        size = collection2.size();
        final int i13 = 1;
        if (i < i11 >>= i13) {
            obj9 = this.a;
            i4 = obj9 - size;
            if (i3 >= obj9) {
                if (i4 >= 0) {
                    length2 = this.b;
                    l.f(length2, length2, i4, obj9, i3);
                } else {
                    length3 = this.b;
                    i4 += length9;
                    length10 -= i4;
                    if (i2 >= i3 - obj9) {
                        l.f(length3, length3, i4, obj9, i3);
                    } else {
                        l.f(length3, length3, i4, obj9, obj9 + i2);
                        obj9 = this.b;
                        l.f(obj9, obj9, length2, i12 += i2, i3);
                    }
                }
            } else {
                Object[] objArr2 = this.b;
                l.f(objArr2, objArr2, i4, obj9, objArr2.length);
                if (size >= i3) {
                    obj9 = this.b;
                    l.f(obj9, obj9, length7 -= size, length2, i3);
                } else {
                    obj9 = this.b;
                    l.f(obj9, obj9, length8 -= size, length2, size);
                    obj9 = this.b;
                    l.f(obj9, obj9, length2, size, i3);
                }
            }
            this.a = i4;
            s(z(i3 -= size), collection2);
        } else {
            obj9 = i3 + size;
            if (i3 < i4) {
                size += i4;
                length3 = this.b;
                if (size <= length3.length) {
                    l.f(length3, length3, obj9, i3, i4);
                } else {
                    if (obj9 >= length3.length) {
                        l.f(length3, length3, obj9 -= length2, i3, i4);
                    } else {
                        size = i4 - i10;
                        l.f(length3, length3, length2, size, i4);
                        i4 = this.b;
                        l.f(i4, i4, obj9, i3, size);
                    }
                }
            } else {
                Object[] objArr = this.b;
                l.f(objArr, objArr, size, length2, i4);
                i4 = this.b;
                if (obj9 >= i4.length) {
                    l.f(i4, i4, obj9 -= length4, i3, i4.length);
                } else {
                    l.f(i4, i4, length2, length6 -= size, i4.length);
                    i4 = this.b;
                    l.f(i4, i4, obj9, i3, length5 -= size);
                }
            }
            s(i3, collection2);
        }
        return i13;
    }

    public boolean addAll(Collection<? extends E> collection) {
        n.f(collection, "elements");
        if (collection.isEmpty()) {
            return 0;
        }
        v(size += size3);
        s(h.p(this, i3 += size2), collection);
        return 1;
    }

    public final void addFirst(E e) {
        v(size++);
        int i3 = u(this.a);
        this.a = i3;
        this.b[i3] = e;
        this.c = obj3++;
    }

    public final void addLast(E e) {
        v(size++);
        this.b[h.p(this, i3 += size2)] = e;
        this.c = obj4++;
    }

    @Override // kotlin.y.d
    public void clear() {
        int i;
        Object[] objArr;
        int length;
        int i2 = h.p(this, i3 += size);
        i = this.a;
        final int i5 = 0;
        final int i6 = 0;
        if (i < i2) {
            i.l(this.b, i6, i, i2);
        } else {
            if (empty ^= 1 != 0) {
                Object[] objArr2 = this.b;
                i.l(objArr2, i6, this.a, objArr2.length);
                i.l(this.b, i6, i5, i2);
            }
        }
        this.a = i5;
        this.c = i5;
    }

    @Override // kotlin.y.d
    public boolean contains(Object object) {
        int obj2;
        obj2 = indexOf(object) != -1 ? 1 : 0;
        return obj2;
    }

    @Override // kotlin.y.d
    public int d() {
        return this.c;
    }

    public E g(int i) {
        Object[] i2;
        Object[] objArr;
        int i4;
        int i3;
        Object obj;
        int length;
        int obj9;
        b.a.a(i, size());
        if (i == p.i(this)) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        i2 = h.p(this, i6 += i);
        final int i13 = 1;
        final int i14 = 0;
        i3 = 0;
        if (i < size2 >>= i13) {
            obj9 = this.a;
            if (i2 >= obj9) {
                i4 = this.b;
                l.f(i4, i4, obj9 + 1, obj9, i2);
            } else {
                obj9 = this.b;
                l.f(obj9, obj9, i13, i3, i2);
                obj9 = this.b;
                obj9[i3] = obj9[length2 -= i13];
                i2 = this.a;
                l.f(obj9, obj9, i2 + 1, i2, length4 -= i13);
            }
            objArr = this.a;
            this.b[objArr] = i14;
            this.a = y(objArr);
        } else {
            obj9 = h.p(this, i10 += obj9);
            if (i2 <= obj9) {
                i4 = this.b;
                l.f(i4, i4, i2, i2 + 1, obj9 + 1);
            } else {
                Object[] objArr3 = this.b;
                l.f(objArr3, objArr3, i2, i2 + 1, objArr3.length);
                i2 = this.b;
                i2[length3 -= i13] = i2[i3];
                l.f(i2, i2, i3, i13, obj9 + 1);
            }
            this.b[obj9] = i14;
        }
        this.c = obj9 -= i13;
        return h.h(this)[i2];
    }

    public E get(int i) {
        b.a.a(i, size());
        return h.h(this)[h.p(this, i2 += i)];
    }

    @Override // kotlin.y.d
    public int indexOf(Object object) {
        int i;
        int length;
        boolean z;
        int obj5;
        int i2 = h.p(this, i3 += size);
        i = this.a;
        if (i < i2) {
        } else {
            if (i >= i2) {
                while (i < objArr.length) {
                    i++;
                }
                i = 0;
                while (i < i2) {
                    i++;
                }
            }
        }
        return -1;
    }

    @Override // kotlin.y.d
    public boolean isEmpty() {
        int i;
        i = size() == 0 ? 1 : 0;
        return i;
    }

    @Override // kotlin.y.d
    public int lastIndexOf(Object object) {
        int i;
        int i3;
        int i2;
        boolean z;
        int obj4;
        i = h.p(this, i5 += size);
        i2 = this.a;
        if (i2 < i) {
            if (i-- >= i2) {
            }
        } else {
            if (i2 > i) {
                i--;
                while (i3 >= 0) {
                    i3--;
                }
                i2 = this.a;
                if (i.B(this.b) >= i2) {
                }
            }
        }
        return -1;
    }

    @Override // kotlin.y.d
    public boolean remove(Object object) {
        int obj2 = indexOf(object);
        if (obj2 == -1) {
            return 0;
        }
        remove(obj2);
        return 1;
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        int empty;
        int i5;
        int i;
        int i6;
        int i2;
        int i8;
        int length;
        int i4;
        Object obj;
        int i3;
        int i7;
        Object obj12;
        n.f(collection, "elements");
        i5 = 0;
        if (!isEmpty()) {
            i = 1;
            empty = objArr.length == 0 ? i : i5;
            if (empty != 0) {
            } else {
                empty = h.p(this, i9 += size);
                i6 = h.i(this);
                i8 = 0;
                if (h.i(this) < empty) {
                    i2 = h.i(this);
                    while (i2 < empty) {
                        length = h.h(this)[i2];
                        if (contains2 ^= i != 0) {
                        } else {
                        }
                        i5 = i;
                        i2++;
                        h.h(this)[i6] = length;
                        i6 = obj;
                    }
                    i.l(h.h(this), i8, i6, empty);
                } else {
                    i2 = h.i(this);
                    i4 = i5;
                    while (i2 < objArr3.length) {
                        obj = h.h(this)[i2];
                        h.h(this)[i2] = i8;
                        if (contains3 ^= i != 0) {
                        } else {
                        }
                        i4 = i;
                        i2++;
                        h.h(this)[i6] = obj;
                        i6 = i7;
                    }
                    i6 = h.p(this, i6);
                    while (i5 < empty) {
                        i2 = h.h(this)[i5];
                        h.h(this)[i5] = i8;
                        if (contains ^= i != 0) {
                        } else {
                        }
                        i4 = i;
                        i5++;
                        h.h(this)[i6] = i2;
                        i6 = h.l(this, i6);
                    }
                    i5 = i4;
                }
                if (i5 != 0) {
                    h.q(this, h.m(this, i6 -= obj12));
                }
            }
        }
        return i5;
    }

    public final E removeFirst() {
        if (isEmpty()) {
        } else {
            final int i4 = this.a;
            this.b[i4] = 0;
            this.a = y(i4);
            this.c = size--;
            return h.h(this)[this.a];
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("ArrayDeque is empty.");
        throw noSuchElementException;
    }

    public final E removeLast() {
        if (isEmpty()) {
        } else {
            int i2 = h.p(this, i4 += i);
            this.b[i2] = 0;
            this.c = size--;
            return h.h(this)[i2];
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("ArrayDeque is empty.");
        throw noSuchElementException;
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        int empty;
        int i6;
        int i2;
        int i;
        int i4;
        int i3;
        int contains;
        int contains3;
        Object obj;
        boolean contains2;
        int i5;
        Object obj12;
        n.f(collection, "elements");
        i6 = 0;
        if (!isEmpty()) {
            i2 = 1;
            empty = objArr.length == 0 ? i2 : i6;
            if (empty != 0) {
            } else {
                empty = h.p(this, i7 += size);
                i = h.i(this);
                i3 = 0;
                if (h.i(this) < empty) {
                    i4 = h.i(this);
                    while (i4 < empty) {
                        contains = h.h(this)[i4];
                        if (collection.contains(contains)) {
                        } else {
                        }
                        i6 = i2;
                        i4++;
                        h.h(this)[i] = contains;
                        i = obj;
                    }
                    i.l(h.h(this), i3, i, empty);
                } else {
                    i4 = h.i(this);
                    contains3 = i6;
                    while (i4 < objArr3.length) {
                        obj = h.h(this)[i4];
                        h.h(this)[i4] = i3;
                        if (collection.contains(obj)) {
                        } else {
                        }
                        contains3 = i2;
                        i4++;
                        h.h(this)[i] = obj;
                        i = i5;
                    }
                    i = h.p(this, i);
                    while (i6 < empty) {
                        i4 = h.h(this)[i6];
                        h.h(this)[i6] = i3;
                        if (collection.contains(i4)) {
                        } else {
                        }
                        contains3 = i2;
                        i6++;
                        h.h(this)[i] = i4;
                        i = h.l(this, i);
                    }
                    i6 = contains3;
                }
                if (i6 != 0) {
                    h.q(this, h.m(this, i -= obj12));
                }
            }
        }
        return i6;
    }

    public E set(int i, E e2) {
        b.a.a(i, size());
        final int obj3 = h.p(this, i2 += i);
        this.b[obj3] = e2;
        return h.h(this)[obj3];
    }

    @Override // kotlin.y.d
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    public <T> T[] toArray(T[] tArr) {
        int length2;
        int i6;
        int length;
        int i4;
        int size;
        int i5;
        int i;
        int i2;
        int i3;
        Object[] obj8;
        n.f(tArr, "array");
        if (tArr.length >= size()) {
        } else {
            obj8 = j.a(tArr, size());
        }
        Objects.requireNonNull(obj8, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        final int i9 = h.p(this, i7 += size2);
        i = this.a;
        if (i < i9) {
            i.h(this.b, obj8, 0, i, i9, 2, 0);
        } else {
            if (empty ^= 1 != 0) {
                Object[] objArr = this.b;
                i = 0;
                l.f(objArr, obj8, i, this.a, objArr.length);
                i6 = this.b;
                l.f(i6, obj8, length3 -= i5, i, i9);
            }
        }
        if (obj8.length > size()) {
            obj8[size()] = 0;
        }
        Objects.requireNonNull(obj8, "null cannot be cast to non-null type kotlin.Array<T>");
        return obj8;
    }

    public final E w() {
        int i;
        Object[] objArr;
        if (isEmpty()) {
            i = 0;
        } else {
            i = h.h(this)[this.a];
        }
        return i;
    }
}
