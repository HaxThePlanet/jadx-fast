package kotlin.d0.d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class e0 {

    private final ArrayList<Object> a;
    public e0(int i) {
        super();
        ArrayList arrayList = new ArrayList(i);
        this.a = arrayList;
    }

    public void a(Object object) {
        this.a.add(object);
    }

    public void b(Object object) {
        int length;
        boolean z;
        boolean next;
        int next2;
        int length2;
        Object obj4;
        if (object == null) {
        }
        if (object instanceof Object[]) {
            if (object.length > 0) {
                ArrayList list = this.a;
                list.ensureCapacity(size += length2);
                Collections.addAll(this.a, (Object[])object);
            }
        } else {
            if (object instanceof Collection != null) {
                this.a.addAll((Collection)object);
            } else {
                if (object instanceof Iterable) {
                    obj4 = (Iterable)object.iterator();
                    for (Object next : obj4) {
                        this.a.add(next);
                    }
                } else {
                    if (!object instanceof Iterator) {
                    } else {
                        for (Object next2 : object) {
                            this.a.add(next2);
                        }
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Don't know how to spread ");
        stringBuilder.append(object.getClass());
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(stringBuilder.toString());
        throw unsupportedOperationException;
    }

    public int c() {
        return this.a.size();
    }

    public Object[] d(Object[] objectArr) {
        return this.a.toArray(objectArr);
    }
}
