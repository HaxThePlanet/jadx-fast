package com.google.firebase.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
class CycleDetector {

    private static class ComponentNode {

        private final com.google.firebase.components.Component<?> component;
        private final Set<com.google.firebase.components.CycleDetector.ComponentNode> dependencies;
        private final Set<com.google.firebase.components.CycleDetector.ComponentNode> dependents;
        ComponentNode(com.google.firebase.components.Component<?> component) {
            super();
            HashSet hashSet = new HashSet();
            this.dependencies = hashSet;
            HashSet hashSet2 = new HashSet();
            this.dependents = hashSet2;
            this.component = component;
        }

        void addDependency(com.google.firebase.components.CycleDetector.ComponentNode cycleDetector$ComponentNode) {
            this.dependencies.add(componentNode);
        }

        void addDependent(com.google.firebase.components.CycleDetector.ComponentNode cycleDetector$ComponentNode) {
            this.dependents.add(componentNode);
        }

        com.google.firebase.components.Component<?> getComponent() {
            return this.component;
        }

        Set<com.google.firebase.components.CycleDetector.ComponentNode> getDependencies() {
            return this.dependencies;
        }

        boolean isLeaf() {
            return this.dependencies.isEmpty();
        }

        boolean isRoot() {
            return this.dependents.isEmpty();
        }

        void removeDependent(com.google.firebase.components.CycleDetector.ComponentNode cycleDetector$ComponentNode) {
            this.dependents.remove(componentNode);
        }
    }

    private static class Dep {

        private final Class<?> anInterface;
        private final boolean set;
        private Dep(Class<?> class, boolean z2) {
            super();
            this.anInterface = class;
            this.set = z2;
        }

        Dep(Class class, boolean z2, com.google.firebase.components.CycleDetector.1 cycleDetector$13) {
            super(class, z2);
        }

        static boolean access$100(com.google.firebase.components.CycleDetector.Dep cycleDetector$Dep) {
            return dep.set;
        }

        public boolean equals(Object object) {
            boolean equals;
            int i;
            Class anInterface;
            Object obj4;
            i = 0;
            if (object instanceof CycleDetector.Dep && object.anInterface.equals(this.anInterface) && object.set == this.set) {
                if (object.anInterface.equals(this.anInterface)) {
                    if (object.set == this.set) {
                        i = 1;
                    }
                }
            }
            return i;
        }

        public int hashCode() {
            int i5 = 1000003;
            return i3 ^= i6;
        }
    }
    static void detect(List<com.google.firebase.components.Component<?>> list) {
        Set component;
        int root2;
        Object next;
        Iterator iterator;
        boolean next2;
        boolean root;
        Set graph = CycleDetector.toGraph(list);
        component = CycleDetector.getRoots(graph);
        root2 = 0;
        while (!component.isEmpty()) {
            next = component.iterator().next();
            component.remove((CycleDetector.ComponentNode)next);
            root2++;
            iterator = next.getDependencies().iterator();
            while (iterator.hasNext()) {
                next2 = iterator.next();
                (CycleDetector.ComponentNode)next2.removeDependent(next);
                if (next2.isRoot()) {
                }
                component.add(next2);
            }
            next2 = iterator.next();
            (CycleDetector.ComponentNode)next2.removeDependent(next);
            if (next2.isRoot()) {
            }
            component.add(next2);
        }
        if (root2 == list.size()) {
        }
        ArrayList obj7 = new ArrayList();
        Iterator iterator2 = graph.iterator();
        while (iterator2.hasNext()) {
            component = iterator2.next();
            if ((CycleDetector.ComponentNode)component.isRoot() == 0 && component.isLeaf() == 0) {
            }
            if (component.isLeaf() == 0) {
            }
            obj7.add(component.getComponent());
        }
        DependencyCycleException dependencyCycleException = new DependencyCycleException(obj7);
        throw dependencyCycleException;
    }

    private static Set<com.google.firebase.components.CycleDetector.ComponentNode> getRoots(Set<com.google.firebase.components.CycleDetector.ComponentNode> set) {
        Object next;
        boolean root;
        HashSet hashSet = new HashSet();
        final Iterator obj3 = set.iterator();
        while (obj3.hasNext()) {
            next = obj3.next();
            if ((CycleDetector.ComponentNode)next.isRoot()) {
            }
            hashSet.add(next);
        }
        return hashSet;
    }

    private static Set<com.google.firebase.components.CycleDetector.ComponentNode> toGraph(List<com.google.firebase.components.Component<?>> list) {
        int size;
        boolean iterator;
        boolean next;
        int i2;
        com.google.firebase.components.CycleDetector.ComponentNode componentNode;
        Iterator iterator2;
        boolean iterator3;
        com.google.firebase.components.CycleDetector.Dep directInjection;
        Object interface;
        boolean hashSet;
        int i;
        boolean empty;
        HashMap hashMap = new HashMap(list.size());
        Iterator obj10 = list.iterator();
        i2 = 0;
        for (Component size : obj10) {
            componentNode = new CycleDetector.ComponentNode(size);
            iterator2 = size.getProvidedInterfaces().iterator();
            while (iterator2.hasNext()) {
                iterator3 = iterator2.next();
                i = 1;
                directInjection = new CycleDetector.Dep((Class)iterator3, value ^= i, i2);
                if (!hashMap.containsKey(directInjection)) {
                }
                interface = hashMap.get(directInjection);
                interface.add(componentNode);
                hashSet = new HashSet();
                hashMap.put(directInjection, hashSet);
            }
            i2 = 0;
            iterator3 = iterator2.next();
            i = 1;
            directInjection = new CycleDetector.Dep((Class)iterator3, value ^= i, i2);
            if (!hashMap.containsKey(directInjection)) {
            }
            interface = hashMap.get(directInjection);
            interface.add(componentNode);
            hashSet = new HashSet();
            hashMap.put(directInjection, hashSet);
        }
        obj10 = hashMap.values().iterator();
        for (Set next3 : obj10) {
            iterator = next3.iterator();
            for (CycleDetector.ComponentNode componentNode : iterator) {
                iterator2 = componentNode.getComponent().getDependencies().iterator();
                while (iterator2.hasNext()) {
                    iterator3 = iterator2.next();
                    if (!(Dependency)iterator3.isDirectInjection()) {
                    } else {
                    }
                    directInjection = new CycleDetector.Dep(iterator3.getInterface(), iterator3.isSet(), i2);
                    iterator3 = hashMap.get(directInjection);
                    if ((Set)iterator3 == null) {
                    } else {
                    }
                    iterator3 = (Set)iterator3.iterator();
                    for (CycleDetector.ComponentNode directInjection : iterator3) {
                        componentNode.addDependency(directInjection);
                        directInjection.addDependent(componentNode);
                    }
                    directInjection = iterator3.next();
                    componentNode.addDependency((CycleDetector.ComponentNode)directInjection);
                    directInjection.addDependent(componentNode);
                }
                iterator3 = iterator2.next();
                if (!(Dependency)iterator3.isDirectInjection()) {
                } else {
                }
                directInjection = new CycleDetector.Dep(iterator3.getInterface(), iterator3.isSet(), i2);
                iterator3 = hashMap.get(directInjection);
                if ((Set)iterator3 == null) {
                } else {
                }
                iterator3 = (Set)iterator3.iterator();
                for (CycleDetector.ComponentNode directInjection : iterator3) {
                    componentNode.addDependency(directInjection);
                    directInjection.addDependent(componentNode);
                }
                directInjection = iterator3.next();
                componentNode.addDependency((CycleDetector.ComponentNode)directInjection);
                directInjection.addDependent(componentNode);
            }
            componentNode = iterator.next();
            iterator2 = (CycleDetector.ComponentNode)componentNode.getComponent().getDependencies().iterator();
            while (iterator2.hasNext()) {
                iterator3 = iterator2.next();
                if (!(Dependency)iterator3.isDirectInjection()) {
                } else {
                }
                directInjection = new CycleDetector.Dep(iterator3.getInterface(), iterator3.isSet(), i2);
                iterator3 = hashMap.get(directInjection);
                if ((Set)iterator3 == null) {
                } else {
                }
                iterator3 = (Set)iterator3.iterator();
                for (CycleDetector.ComponentNode directInjection : iterator3) {
                    componentNode.addDependency(directInjection);
                    directInjection.addDependent(componentNode);
                }
                directInjection = iterator3.next();
                componentNode.addDependency((CycleDetector.ComponentNode)directInjection);
                directInjection.addDependent(componentNode);
            }
            iterator3 = iterator2.next();
            if (!(Dependency)iterator3.isDirectInjection()) {
            } else {
            }
            directInjection = new CycleDetector.Dep(iterator3.getInterface(), iterator3.isSet(), i2);
            iterator3 = hashMap.get(directInjection);
            if ((Set)iterator3 == null) {
            } else {
            }
            iterator3 = (Set)iterator3.iterator();
            for (CycleDetector.ComponentNode directInjection : iterator3) {
                componentNode.addDependency(directInjection);
                directInjection.addDependent(componentNode);
            }
            directInjection = iterator3.next();
            componentNode.addDependency((CycleDetector.ComponentNode)directInjection);
            directInjection.addDependent(componentNode);
        }
        obj10 = new HashSet();
        Iterator iterator4 = hashMap.values().iterator();
        for (Set next : iterator4) {
            obj10.addAll(next);
        }
        return obj10;
    }
}
