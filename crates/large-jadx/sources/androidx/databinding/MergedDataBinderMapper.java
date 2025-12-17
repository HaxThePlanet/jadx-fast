package androidx.databinding;

import android.util.Log;
import android.view.View;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class MergedDataBinderMapper extends androidx.databinding.d {

    private Set<Class<? extends androidx.databinding.d>> a;
    private List<androidx.databinding.d> b;
    private List<String> c;
    public MergedDataBinderMapper() {
        super();
        HashSet hashSet = new HashSet();
        this.a = hashSet;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.b = copyOnWriteArrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
        this.c = copyOnWriteArrayList2;
    }

    private boolean e() {
        int i;
        Object string;
        Object forName;
        StringBuilder assignableFrom;
        final String str = "unable to add feature mapper for ";
        final String str2 = "MergedDataBinderMapper";
        Iterator iterator = this.c.iterator();
        i = 0;
        while (iterator.hasNext()) {
            string = iterator.next();
            forName = Class.forName((String)string);
            if (d.class.isAssignableFrom(forName)) {
            }
            d((d)forName.newInstance());
            this.c.remove(string);
            i = 1;
        }
        return i;
    }

    @Override // androidx.databinding.d
    public androidx.databinding.ViewDataBinding b(androidx.databinding.e e, View view2, int i3) {
        androidx.databinding.ViewDataBinding view;
        Iterator iterator = this.b.iterator();
        for (d next2 : iterator) {
            view = next2.b(e, view2, i3);
        }
        if (e()) {
            return b(e, view2, i3);
        }
        return null;
    }

    @Override // androidx.databinding.d
    public androidx.databinding.ViewDataBinding c(androidx.databinding.e e, View[] view2Arr2, int i3) {
        androidx.databinding.ViewDataBinding view;
        Iterator iterator = this.b.iterator();
        for (d next2 : iterator) {
            view = next2.c(e, view2Arr2, i3);
        }
        if (e()) {
            return c(e, view2Arr2, i3);
        }
        return null;
    }

    @Override // androidx.databinding.d
    public void d(androidx.databinding.d d) {
        List next;
        boolean next2;
        Object obj3;
        if (this.a.add(d.getClass())) {
            this.b.add(d);
            obj3 = d.a().iterator();
            for (d next : obj3) {
                d(next);
            }
        }
    }
}
