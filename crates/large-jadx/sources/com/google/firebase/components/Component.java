package com.google.firebase.components;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public final class Component<T>  {

    private final Set<com.google.firebase.components.Dependency> dependencies;
    private final com.google.firebase.components.ComponentFactory<T> factory;
    private final int instantiation;
    private final Set<Class<? super T>> providedInterfaces;
    private final Set<Class<?>> publishedEvents;
    private final int type;

    public static class Builder {

        private final Set<com.google.firebase.components.Dependency> dependencies;
        private com.google.firebase.components.ComponentFactory<T> factory;
        private int instantiation;
        private final Set<Class<? super T>> providedInterfaces;
        private Set<Class<?>> publishedEvents;
        private int type;
        @SafeVarargs
        private Builder(Class<T> class, Class<? super T>... class2Arr2) {
            HashSet hashSet;
            int i;
            super();
            hashSet = new HashSet();
            this.providedInterfaces = hashSet;
            HashSet hashSet2 = new HashSet();
            this.dependencies = hashSet2;
            i = 0;
            this.instantiation = i;
            this.type = i;
            HashSet hashSet3 = new HashSet();
            this.publishedEvents = hashSet3;
            String str = "Null interface";
            Preconditions.checkNotNull(class, str);
            hashSet.add(class);
            while (i < class2Arr2.length) {
                Preconditions.checkNotNull(class2Arr2[i], str);
                i++;
            }
            Collections.addAll(this.providedInterfaces, class2Arr2);
        }

        Builder(Class class, Class[] class2Arr2, com.google.firebase.components.Component.1 component$13) {
            super(class, class2Arr2);
        }

        static com.google.firebase.components.Component.Builder access$100(com.google.firebase.components.Component.Builder component$Builder) {
            return builder.intoSet();
        }

        private com.google.firebase.components.Component.Builder<T> intoSet() {
            this.type = 1;
            return this;
        }

        private com.google.firebase.components.Component.Builder<T> setInstantiation(int i) {
            int i2;
            i2 = this.instantiation == 0 ? 1 : 0;
            Preconditions.checkState(i2, "Instantiation type has already been set.");
            this.instantiation = i;
            return this;
        }

        private void validateInterface(Class<?> class) {
            Preconditions.checkArgument(obj2 ^= 1, "Components are not allowed to depend on interfaces they themselves provide.");
        }

        public com.google.firebase.components.Component.Builder<T> add(com.google.firebase.components.Dependency dependency) {
            Preconditions.checkNotNull(dependency, "Null dependency");
            validateInterface(dependency.getInterface());
            this.dependencies.add(dependency);
            return this;
        }

        public com.google.firebase.components.Component.Builder<T> alwaysEager() {
            return setInstantiation(1);
        }

        public com.google.firebase.components.Component<T> build() {
            int i;
            i = this.factory != null ? 1 : 0;
            Preconditions.checkState(i, "Missing required property: factory.");
            HashSet hashSet = new HashSet(this.providedInterfaces);
            HashSet hashSet2 = new HashSet(this.dependencies);
            super(hashSet, hashSet2, this.instantiation, this.type, this.factory, this.publishedEvents, 0);
            return component;
        }

        public com.google.firebase.components.Component.Builder<T> eagerInDefaultApp() {
            return setInstantiation(2);
        }

        public com.google.firebase.components.Component.Builder<T> factory(com.google.firebase.components.ComponentFactory<T> componentFactory) {
            this.factory = (ComponentFactory)Preconditions.checkNotNull(componentFactory, "Null factory");
            return this;
        }

        public com.google.firebase.components.Component.Builder<T> publishes(Class<?> class) {
            this.publishedEvents.add(class);
            return this;
        }
    }
    private Component(Set<Class<? super T>> set, Set<com.google.firebase.components.Dependency> set2, int i3, int i4, com.google.firebase.components.ComponentFactory<T> componentFactory5, Set<Class<?>> set6) {
        super();
        this.providedInterfaces = Collections.unmodifiableSet(set);
        this.dependencies = Collections.unmodifiableSet(set2);
        this.instantiation = i3;
        this.type = i4;
        this.factory = componentFactory5;
        this.publishedEvents = Collections.unmodifiableSet(set6);
    }

    Component(Set set, Set set2, int i3, int i4, com.google.firebase.components.ComponentFactory componentFactory5, Set set6, com.google.firebase.components.Component.1 component$17) {
        super(set, set2, i3, i4, componentFactory5, set6);
    }

    static Object a(Object object, com.google.firebase.components.ComponentContainer componentContainer2) {
        return object;
    }

    static Object b(Object object, com.google.firebase.components.ComponentContainer componentContainer2) {
        return object;
    }

    public static <T> com.google.firebase.components.Component.Builder<T> builder(Class<T> class) {
        Component.Builder builder = new Component.Builder(class, new Class[0], 0);
        return builder;
    }

    @SafeVarargs
    public static <T> com.google.firebase.components.Component.Builder<T> builder(Class<T> class, Class<? super T>... class2Arr2) {
        Component.Builder builder = new Component.Builder(class, class2Arr2, 0);
        return builder;
    }

    static Object c(Object object, com.google.firebase.components.ComponentContainer componentContainer2) {
        return object;
    }

    public static <T> com.google.firebase.components.Component<T> intoSet(T t, Class<T> class2) {
        a aVar = new a(t);
        return Component.intoSetBuilder(class2).factory(aVar).build();
    }

    public static <T> com.google.firebase.components.Component.Builder<T> intoSetBuilder(Class<T> class) {
        return Component.Builder.access$100(Component.builder(class));
    }

    @Deprecated
    public static <T> com.google.firebase.components.Component<T> of(Class<T> class, T t2) {
        b bVar = new b(t2);
        return Component.builder(class).factory(bVar).build();
    }

    @SafeVarargs
    public static <T> com.google.firebase.components.Component<T> of(T t, Class<T> class2, Class<? super T>... class3Arr3) {
        c obj2 = new c(t);
        return Component.builder(class2, class3Arr3).factory(obj2).build();
    }

    public Set<com.google.firebase.components.Dependency> getDependencies() {
        return this.dependencies;
    }

    public com.google.firebase.components.ComponentFactory<T> getFactory() {
        return this.factory;
    }

    public Set<Class<? super T>> getProvidedInterfaces() {
        return this.providedInterfaces;
    }

    public Set<Class<?>> getPublishedEvents() {
        return this.publishedEvents;
    }

    public boolean isAlwaysEager() {
        int i;
        if (this.instantiation == 1) {
        } else {
            i = 0;
        }
        return i;
    }

    public boolean isEagerInDefaultApp() {
        int i;
        i = this.instantiation == 2 ? 1 : 0;
        return i;
    }

    public boolean isLazy() {
        int i;
        i = this.instantiation == 0 ? 1 : 0;
        return i;
    }

    public boolean isValue() {
        int i;
        i = this.type == 0 ? 1 : 0;
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Component<");
        stringBuilder.append(Arrays.toString(this.providedInterfaces.toArray()));
        stringBuilder.append(">{");
        stringBuilder.append(this.instantiation);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", deps=");
        stringBuilder.append(Arrays.toString(this.dependencies.toArray()));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
