package androidx.lifecycle;

import java.io.Closeable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class e0 {

    private final Map<String, Object> mBagOfTags;
    private volatile boolean mCleared = false;
    public e0() {
        super();
        HashMap hashMap = new HashMap();
        this.mBagOfTags = hashMap;
        int i = 0;
    }

    private static void closeWithRuntimeException(Object object) {
        if (object instanceof Closeable) {
            (Closeable)object.close();
        }
    }

    final void clear() {
        Object iterator;
        Object next;
        this.mCleared = true;
        Map mBagOfTags = this.mBagOfTags;
        if (mBagOfTags != null) {
            iterator = this.mBagOfTags.values().iterator();
            synchronized (mBagOfTags) {
                for (Object next : iterator) {
                    e0.closeWithRuntimeException(next);
                }
            }
        }
        onCleared();
    }

    <T> T getTag(String string) {
        final Map mBagOfTags = this.mBagOfTags;
        if (mBagOfTags == null) {
            return 0;
        }
        return this.mBagOfTags.get(string);
        synchronized (mBagOfTags) {
            return this.mBagOfTags.get(string);
        }
    }

    protected void onCleared() {
    }

    <T> T setTagIfAbsent(String string, T t2) {
        Map mBagOfTags;
        Object obj5;
        final Map mBagOfTags2 = this.mBagOfTags;
        Object obj = this.mBagOfTags.get(string);
        synchronized (mBagOfTags2) {
            this.mBagOfTags.put(string, t2);
            if (obj == null) {
            } else {
                obj5 = obj;
            }
            if (this.mCleared) {
                e0.closeWithRuntimeException(obj5);
            }
            return obj5;
        }
        try {
            obj5 = obj;
            if (this.mCleared) {
            }
            e0.closeWithRuntimeException(obj5);
            return obj5;
            throw string;
        }
    }
}
