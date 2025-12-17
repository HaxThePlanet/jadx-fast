package com.google.firebase.inappmessaging.dagger.internal;

import j.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class SetFactory<T>  implements com.google.firebase.inappmessaging.dagger.internal.Factory<Set<T>> {

    private static final com.google.firebase.inappmessaging.dagger.internal.Factory<Set<Object>> EMPTY_FACTORY;
    private final List<a<Collection<T>>> collectionProviders;
    private final List<a<T>> individualProviders;

    public static final class Builder {

        static final boolean $assertionsDisabled;
        private final List<a<Collection<T>>> collectionProviders;
        private final List<a<T>> individualProviders;
        static {
        }

        private Builder(int i, int i2) {
            super();
            this.individualProviders = DaggerCollections.presizedList(i);
            this.collectionProviders = DaggerCollections.presizedList(i2);
        }

        Builder(int i, int i2, com.google.firebase.inappmessaging.dagger.internal.SetFactory.1 setFactory$13) {
            super(i, i2);
        }

        public com.google.firebase.inappmessaging.dagger.internal.SetFactory.Builder<T> addCollectionProvider(a<? extends Collection<? extends T>> a) {
            this.collectionProviders.add(a);
            return this;
        }

        public com.google.firebase.inappmessaging.dagger.internal.SetFactory.Builder<T> addProvider(a<? extends T> a) {
            this.individualProviders.add(a);
            return this;
        }

        public com.google.firebase.inappmessaging.dagger.internal.SetFactory<T> build() {
            SetFactory setFactory = new SetFactory(this.individualProviders, this.collectionProviders, 0);
            return setFactory;
        }
    }
    static {
        SetFactory.EMPTY_FACTORY = InstanceFactory.create(Collections.emptySet());
    }

    private SetFactory(List<a<T>> list, List<a<Collection<T>>> list2) {
        super();
        this.individualProviders = list;
        this.collectionProviders = list2;
    }

    SetFactory(List list, List list2, com.google.firebase.inappmessaging.dagger.internal.SetFactory.1 setFactory$13) {
        super(list, list2);
    }

    public static <T> com.google.firebase.inappmessaging.dagger.internal.SetFactory.Builder<T> builder(int i, int i2) {
        SetFactory.Builder builder = new SetFactory.Builder(i, i2, 0);
        return builder;
    }

    public static <T> com.google.firebase.inappmessaging.dagger.internal.Factory<Set<T>> empty() {
        return SetFactory.EMPTY_FACTORY;
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }

    public Set<T> get() {
        int size2;
        int i;
        int i2;
        int iterator;
        Object checkNotNull;
        int size;
        size2 = this.individualProviders.size();
        ArrayList arrayList = new ArrayList(this.collectionProviders.size());
        i = 0;
        i2 = i;
        while (i2 < this.collectionProviders.size()) {
            checkNotNull = (a)this.collectionProviders.get(i2).get();
            size2 += size;
            arrayList.add(checkNotNull);
            i2++;
        }
        java.util.HashSet hashSetWithExpectedSize = DaggerCollections.newHashSetWithExpectedSize(size2);
        iterator = i;
        while (iterator < this.individualProviders.size()) {
            hashSetWithExpectedSize.add(Preconditions.checkNotNull((a)this.individualProviders.get(iterator).get()));
            iterator++;
        }
        while (i < arrayList.size()) {
            iterator = (Collection)arrayList.get(i).iterator();
            for (Object next : iterator) {
                hashSetWithExpectedSize.add(Preconditions.checkNotNull(next));
            }
            i++;
            hashSetWithExpectedSize.add(Preconditions.checkNotNull(iterator.next()));
        }
        return Collections.unmodifiableSet(hashSetWithExpectedSize);
    }
}
