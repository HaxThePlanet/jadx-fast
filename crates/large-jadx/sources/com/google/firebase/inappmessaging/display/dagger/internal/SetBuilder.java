package com.google.firebase.inappmessaging.display.dagger.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class SetBuilder<T>  {

    private static final String SET_CONTRIBUTIONS_CANNOT_BE_NULL = "Set contributions cannot be null";
    private final List<T> contributions;
    private SetBuilder(int i) {
        super();
        ArrayList arrayList = new ArrayList(i);
        this.contributions = arrayList;
    }

    public static <T> com.google.firebase.inappmessaging.display.dagger.internal.SetBuilder<T> newSetBuilder(int i) {
        SetBuilder setBuilder = new SetBuilder(i);
        return setBuilder;
    }

    public com.google.firebase.inappmessaging.display.dagger.internal.SetBuilder<T> add(T t) {
        this.contributions.add(Preconditions.checkNotNull(t, "Set contributions cannot be null"));
        return this;
    }

    public com.google.firebase.inappmessaging.display.dagger.internal.SetBuilder<T> addAll(Collection<? extends T> collection) {
        Object next;
        String str;
        Iterator iterator = collection.iterator();
        for (Object next : iterator) {
            Preconditions.checkNotNull(next, "Set contributions cannot be null");
        }
        this.contributions.addAll(collection);
        return this;
    }

    public Set<T> build() {
        int size = this.contributions.size();
        if (size != 0 && size != 1) {
            if (size != 1) {
                HashSet hashSet = new HashSet(this.contributions);
                return Collections.unmodifiableSet(hashSet);
            }
            return Collections.singleton(this.contributions.get(0));
        }
        return Collections.emptySet();
    }
}
