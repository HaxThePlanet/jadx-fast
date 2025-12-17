package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes5.dex */
public class SpreadBuilder {

    private final ArrayList<Object> list;
    public SpreadBuilder(int size) {
        super();
        ArrayList arrayList = new ArrayList(size);
        this.list = arrayList;
    }

    public void add(Object element) {
        this.list.add(element);
    }

    public void addSpread(Object container) {
        Object iterator;
        int length;
        Object next;
        int list;
        int length2;
        if (container == null) {
        }
        if (container instanceof Object[]) {
            iterator = container;
            if (iterator.length > 0) {
                this.list.ensureCapacity(size += length2);
                Collections.addAll(this.list, (Object[])(Object[])iterator);
            }
        } else {
            if (container instanceof Collection != null) {
                this.list.addAll((Collection)container);
            } else {
                if (container instanceof Iterable) {
                    iterator = (Iterable)container.iterator();
                    for (Object next : iterator) {
                        this.list.add(next);
                    }
                } else {
                    if (!container instanceof Iterator) {
                    } else {
                        iterator = container;
                        for (Object list : iterator) {
                            this.list.add(list);
                        }
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(stringBuilder.append("Don't know how to spread ").append(container.getClass()).toString());
        throw unsupportedOperationException;
    }

    public int size() {
        return this.list.size();
    }

    public Object[] toArray(Object[] a) {
        return this.list.toArray(a);
    }
}
