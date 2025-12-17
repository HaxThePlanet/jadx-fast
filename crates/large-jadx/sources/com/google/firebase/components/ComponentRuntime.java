package com.google.firebase.components;

import android.util.Log;
import com.google.firebase.dynamicloading.ComponentLoader;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class ComponentRuntime extends com.google.firebase.components.AbstractComponentContainer implements ComponentLoader {

    private static final Provider<Set<Object>> EMPTY_PROVIDER;
    private final Map<com.google.firebase.components.Component<?>, Provider<?>> components;
    private final AtomicReference<Boolean> eagerComponentsInitializedWith;
    private final com.google.firebase.components.EventBus eventBus;
    private final Map<Class<?>, Provider<?>> lazyInstanceMap;
    private final Map<Class<?>, com.google.firebase.components.LazySet<?>> lazySetMap;
    private final List<Provider<com.google.firebase.components.ComponentRegistrar>> unprocessedRegistrarProviders;

    public static final class Builder {

        private final List<com.google.firebase.components.Component<?>> additionalComponents;
        private final Executor defaultExecutor;
        private final List<Provider<com.google.firebase.components.ComponentRegistrar>> lazyRegistrars;
        Builder(Executor executor) {
            super();
            ArrayList arrayList = new ArrayList();
            this.lazyRegistrars = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.additionalComponents = arrayList2;
            this.defaultExecutor = executor;
        }

        static com.google.firebase.components.ComponentRegistrar a(com.google.firebase.components.ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }

        public com.google.firebase.components.ComponentRuntime.Builder addComponent(com.google.firebase.components.Component<?> component) {
            this.additionalComponents.add(component);
            return this;
        }

        public com.google.firebase.components.ComponentRuntime.Builder addComponentRegistrar(com.google.firebase.components.ComponentRegistrar componentRegistrar) {
            g gVar = new g(componentRegistrar);
            this.lazyRegistrars.add(gVar);
            return this;
        }

        public com.google.firebase.components.ComponentRuntime.Builder addLazyComponentRegistrars(Collection<Provider<com.google.firebase.components.ComponentRegistrar>> collection) {
            this.lazyRegistrars.addAll(collection);
            return this;
        }

        public com.google.firebase.components.ComponentRuntime build() {
            ComponentRuntime componentRuntime = new ComponentRuntime(this.defaultExecutor, this.lazyRegistrars, this.additionalComponents, 0);
            return componentRuntime;
        }
    }
    static {
        ComponentRuntime.EMPTY_PROVIDER = k.a;
    }

    private ComponentRuntime(Executor executor, Iterable<Provider<com.google.firebase.components.ComponentRegistrar>> iterable2, Collection<com.google.firebase.components.Component<?>> collection3) {
        com.google.firebase.components.Component next;
        super();
        HashMap hashMap = new HashMap();
        this.components = hashMap;
        HashMap hashMap2 = new HashMap();
        this.lazyInstanceMap = hashMap2;
        HashMap hashMap3 = new HashMap();
        this.lazySetMap = hashMap3;
        AtomicReference atomicReference = new AtomicReference();
        this.eagerComponentsInitializedWith = atomicReference;
        EventBus eventBus = new EventBus(executor);
        this.eventBus = eventBus;
        ArrayList obj7 = new ArrayList();
        Class[] arr2 = new Class[2];
        final int i3 = 0;
        arr2[i3] = Subscriber.class;
        arr2[1] = Publisher.class;
        obj7.add(Component.of(eventBus, EventBus.class, arr2));
        obj7.add(Component.of(this, ComponentLoader.class, new Class[i3]));
        final Iterator obj9 = collection3.iterator();
        while (obj9.hasNext()) {
            next = obj9.next();
            if ((Component)next != null) {
            }
            obj7.add((Component)next);
        }
        this.unprocessedRegistrarProviders = ComponentRuntime.iterableToList(iterable2);
        discoverComponents(obj7);
    }

    ComponentRuntime(Executor executor, Iterable iterable2, Collection collection3, com.google.firebase.components.ComponentRuntime.1 componentRuntime$14) {
        super(executor, iterable2, collection3);
    }

    @Deprecated
    public ComponentRuntime(Executor executor, Iterable<com.google.firebase.components.ComponentRegistrar> iterable2, com.google.firebase.components.Component<?>... component3Arr3) {
        super(executor, ComponentRuntime.toProviders(iterable2), Arrays.asList(component3Arr3));
    }

    private Object a(com.google.firebase.components.Component component) {
        RestrictedComponentContainer restrictedComponentContainer = new RestrictedComponentContainer(component, this);
        return component.getFactory().create(restrictedComponentContainer);
    }

    public static com.google.firebase.components.ComponentRuntime.Builder builder(Executor executor) {
        ComponentRuntime.Builder builder = new ComponentRuntime.Builder(executor);
        return builder;
    }

    static void c(com.google.firebase.components.OptionalProvider optionalProvider, Provider provider2) {
        optionalProvider.set(provider2);
    }

    static void d(com.google.firebase.components.LazySet lazySet, Provider provider2) {
        lazySet.add(provider2);
    }

    private void discoverComponents(List<com.google.firebase.components.Component<?>> list) {
        ArrayList arrayList2;
        ArrayList arrayList;
        Object components;
        Set keySet;
        String lazy;
        String components2;
        arrayList2 = new ArrayList();
        Iterator iterator = this.unprocessedRegistrarProviders.iterator();
        synchronized (this) {
            while (iterator.hasNext()) {
                components = (Provider)iterator.next().get();
                if ((ComponentRegistrar)components != null) {
                }
                list.addAll((ComponentRegistrar)components.getComponents());
                iterator.remove();
            }
            if (this.components.isEmpty()) {
                try {
                    CycleDetector.detect(list);
                    arrayList = new ArrayList(this.components.keySet());
                    arrayList.addAll(list);
                    CycleDetector.detect(arrayList);
                    Iterator iterator2 = list.iterator();
                    for (Component keySet : iterator2) {
                        e eVar = new e(this, keySet);
                        lazy = new Lazy(eVar);
                        this.components.put(keySet, lazy);
                    }
                    keySet = iterator2.next();
                    eVar = new e(this, (Component)keySet);
                    lazy = new Lazy(eVar);
                    this.components.put(keySet, lazy);
                    arrayList2.addAll(processInstanceComponents(list));
                    arrayList2.addAll(processSetComponents());
                    processDependencies();
                    Iterator obj6 = arrayList2.iterator();
                    for (Runnable arrayList2 : obj6) {
                        arrayList2.run();
                    }
                    (Runnable)obj6.next().run();
                    maybeInitializeEagerComponents();
                    throw list;
                } catch (com.google.firebase.components.InvalidRegistrarException invalidRegistrar) {
                } catch (Throwable th1) {
                }
            } else {
            }
        }
    }

    private void doInitializeEagerComponents(Map<com.google.firebase.components.Component<?>, Provider<?>> map, boolean z2) {
        Object value;
        boolean eagerInDefaultApp;
        boolean alwaysEager;
        Iterator obj4 = map.entrySet().iterator();
        while (obj4.hasNext()) {
            Object next2 = obj4.next();
            eagerInDefaultApp = (Map.Entry)next2.getKey();
            if (!(Component)eagerInDefaultApp.isAlwaysEager()) {
            } else {
            }
            (Provider)next2.getValue().get();
            if (eagerInDefaultApp.isEagerInDefaultApp() && z2) {
            }
            if (z2) {
            }
        }
        this.eventBus.enablePublishingAndFlushPending();
    }

    static com.google.firebase.components.ComponentRegistrar e(com.google.firebase.components.ComponentRegistrar componentRegistrar) {
        return componentRegistrar;
    }

    private static <T> List<T> iterableToList(Iterable<T> iterable) {
        Object next;
        ArrayList arrayList = new ArrayList();
        final Iterator obj2 = iterable.iterator();
        for (Object next : obj2) {
            arrayList.add(next);
        }
        return arrayList;
    }

    private void maybeInitializeEagerComponents() {
        Object booleanValue;
        Map components;
        booleanValue = this.eagerComponentsInitializedWith.get();
        if ((Boolean)booleanValue != null) {
            doInitializeEagerComponents(this.components, (Boolean)booleanValue.booleanValue());
        }
    }

    private void processDependencies() {
        Object next;
        Iterator iterator;
        boolean interface;
        boolean lazyInstanceMap;
        boolean set;
        Class collection;
        Iterator iterator2 = this.components.keySet().iterator();
        for (Component next : iterator2) {
            iterator = next.getDependencies().iterator();
            for (Dependency interface : iterator) {
                if (!interface.isSet()) {
                }
                this.lazyInstanceMap.put(interface.getInterface(), OptionalProvider.empty());
                this.lazySetMap.put(interface.getInterface(), LazySet.fromCollection(Collections.emptySet()));
            }
            interface = iterator.next();
            if (!interface.isSet()) {
            }
            this.lazyInstanceMap.put(interface.getInterface(), OptionalProvider.empty());
            this.lazySetMap.put(interface.getInterface(), LazySet.fromCollection(Collections.emptySet()));
        }
    }

    private List<Runnable> processInstanceComponents(List<com.google.firebase.components.Component<?>> list) {
        Object iterator;
        boolean value;
        boolean next;
        Map lazyInstanceMap;
        ArrayList arrayList = new ArrayList();
        final Iterator obj6 = list.iterator();
        while (obj6.hasNext()) {
            iterator = obj6.next();
            if (!(Component)iterator.isValue()) {
            } else {
            }
            value = this.components.get(iterator);
            iterator = iterator.getProvidedInterfaces().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (!this.lazyInstanceMap.containsKey((Class)next)) {
                } else {
                }
                lazyInstanceMap = new i((OptionalProvider)(Provider)this.lazyInstanceMap.get(next), (Provider)value);
                arrayList.add(lazyInstanceMap);
                this.lazyInstanceMap.put(next, value);
            }
            next = iterator.next();
            if (!this.lazyInstanceMap.containsKey((Class)next)) {
            } else {
            }
            lazyInstanceMap = new i((OptionalProvider)(Provider)this.lazyInstanceMap.get(next), value);
            arrayList.add(lazyInstanceMap);
            this.lazyInstanceMap.put(next, value);
        }
        return arrayList;
    }

    private List<Runnable> processSetComponents() {
        Iterator collection;
        Object value;
        boolean lazySetMap;
        Object iterator;
        Object next;
        boolean hVar;
        boolean hashSet;
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        collection = this.components.entrySet().iterator();
        while (collection.hasNext()) {
            value = collection.next();
            iterator = (Map.Entry)value.getKey();
            if ((Component)iterator.isValue()) {
            } else {
            }
            iterator = iterator.getProvidedInterfaces().iterator();
            while (iterator.hasNext()) {
                Object next4 = iterator.next();
                if (!hashMap.containsKey((Class)next4)) {
                }
                (Set)hashMap.get(next4).add((Provider)value.getValue());
                hashSet = new HashSet();
                hashMap.put(next4, hashSet);
            }
            next4 = iterator.next();
            if (!hashMap.containsKey((Class)next4)) {
            }
            (Set)hashMap.get(next4).add(value);
            hashSet = new HashSet();
            hashMap.put(next4, hashSet);
        }
        Iterator iterator2 = hashMap.entrySet().iterator();
        while (iterator2.hasNext()) {
            Object next3 = iterator2.next();
            if (!this.lazySetMap.containsKey((Map.Entry)next3.getKey())) {
            } else {
            }
            collection = (Set)next3.getValue().iterator();
            for (Provider next : collection) {
                hVar = new h((LazySet)this.lazySetMap.get(next3.getKey()), next);
                arrayList.add(hVar);
            }
            hVar = new h(lazySetMap, (Provider)collection.next());
            arrayList.add(hVar);
            this.lazySetMap.put((Class)next3.getKey(), LazySet.fromCollection((Collection)next3.getValue()));
        }
        return arrayList;
    }

    private static Iterable<Provider<com.google.firebase.components.ComponentRegistrar>> toProviders(Iterable<com.google.firebase.components.ComponentRegistrar> iterable) {
        Object next;
        com.google.firebase.components.f fVar;
        ArrayList arrayList = new ArrayList();
        final Iterator obj3 = iterable.iterator();
        for (ComponentRegistrar next : obj3) {
            fVar = new f(next);
            arrayList.add(fVar);
        }
        return arrayList;
    }

    @Override // com.google.firebase.components.AbstractComponentContainer
    public Object b(com.google.firebase.components.Component component) {
        return a(component);
    }

    @Override // com.google.firebase.components.AbstractComponentContainer
    public void discoverComponents() {
        synchronized (this) {
            try {
                ArrayList arrayList = new ArrayList();
                discoverComponents(arrayList);
                throw th;
            }
        }
    }

    @Override // com.google.firebase.components.AbstractComponentContainer
    public Object get(Class class) {
        return super.get(class);
    }

    public <T> Deferred<T> getDeferred(Class<T> class) {
        Provider obj2 = getProvider(class);
        if (obj2 == null) {
            return OptionalProvider.empty();
        }
        if (obj2 instanceof OptionalProvider != null) {
            return (OptionalProvider)obj2;
        }
        return OptionalProvider.of(obj2);
    }

    public <T> Provider<T> getProvider(Class<T> class) {
        Preconditions.checkNotNull(class, "Null interface requested.");
        return (Provider)this.lazyInstanceMap.get(class);
        synchronized (this) {
            Preconditions.checkNotNull(class, "Null interface requested.");
            return (Provider)this.lazyInstanceMap.get(class);
        }
    }

    @Override // com.google.firebase.components.AbstractComponentContainer
    public void initializeAllComponentsForTests() {
        Object next;
        Iterator iterator = this.components.values().iterator();
        for (Provider next : iterator) {
            next.get();
        }
    }

    @Override // com.google.firebase.components.AbstractComponentContainer
    public void initializeEagerComponents(boolean z) {
        if (!this.eagerComponentsInitializedWith.compareAndSet(0, Boolean.valueOf(z))) {
        }
        HashMap hashMap = new HashMap(this.components);
        doInitializeEagerComponents(hashMap, z);
        return;
        synchronized (this) {
            hashMap = new HashMap(this.components);
            doInitializeEagerComponents(hashMap, z);
        }
    }

    @Override // com.google.firebase.components.AbstractComponentContainer
    public Set setOf(Class class) {
        return super.setOf(class);
    }

    public <T> Provider<Set<T>> setOfProvider(Class<T> class) {
        Object obj2 = this.lazySetMap.get(class);
        synchronized (this) {
            try {
                return (LazySet)obj2;
                return ComponentRuntime.EMPTY_PROVIDER;
                throw class;
            }
        }
    }
}
