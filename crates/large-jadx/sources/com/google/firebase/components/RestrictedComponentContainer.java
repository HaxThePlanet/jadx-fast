package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
final class RestrictedComponentContainer extends com.google.firebase.components.AbstractComponentContainer {

    private final Set<Class<?>> allowedDeferredInterfaces;
    private final Set<Class<?>> allowedDirectInterfaces;
    private final Set<Class<?>> allowedProviderInterfaces;
    private final Set<Class<?>> allowedPublishedEvents;
    private final Set<Class<?>> allowedSetDirectInterfaces;
    private final Set<Class<?>> allowedSetProviderInterfaces;
    private final com.google.firebase.components.ComponentContainer delegateContainer;

    private static class RestrictedPublisher implements Publisher {

        private final Set<Class<?>> allowedPublishedEvents;
        private final Publisher delegate;
        public RestrictedPublisher(Set<Class<?>> set, Publisher publisher2) {
            super();
            this.allowedPublishedEvents = set;
            this.delegate = publisher2;
        }

        public void publish(Event<?> event) {
            if (!this.allowedPublishedEvents.contains(event.getType())) {
            } else {
                this.delegate.publish(event);
            }
            Object[] arr = new Object[1];
            DependencyException dependencyException = new DependencyException(String.format("Attempting to publish an undeclared event %s.", event));
            throw dependencyException;
        }
    }
    RestrictedComponentContainer(com.google.firebase.components.Component<?> component, com.google.firebase.components.ComponentContainer componentContainer2) {
        boolean empty;
        Class interface;
        boolean deferred;
        super();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        Iterator iterator = component.getDependencies().iterator();
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            if ((Dependency)next2.isDirectInjection()) {
            } else {
            }
            if (next2.isDeferred()) {
            } else {
            }
            if (next2.isSet()) {
            } else {
            }
            hashSet2.add(next2.getInterface());
            hashSet5.add(next2.getInterface());
            hashSet3.add(next2.getInterface());
            if (next2.isSet()) {
            } else {
            }
            hashSet.add(next2.getInterface());
            hashSet4.add(next2.getInterface());
        }
        if (!component.getPublishedEvents().isEmpty()) {
            hashSet.add(Publisher.class);
        }
        this.allowedDirectInterfaces = Collections.unmodifiableSet(hashSet);
        this.allowedProviderInterfaces = Collections.unmodifiableSet(hashSet2);
        this.allowedDeferredInterfaces = Collections.unmodifiableSet(hashSet3);
        this.allowedSetDirectInterfaces = Collections.unmodifiableSet(hashSet4);
        this.allowedSetProviderInterfaces = Collections.unmodifiableSet(hashSet5);
        this.allowedPublishedEvents = component.getPublishedEvents();
        this.delegateContainer = componentContainer2;
    }

    public <T> T get(Class<T> class) {
        if (!this.allowedDirectInterfaces.contains(class)) {
        } else {
            Object obj = this.delegateContainer.get(class);
            if (!class.equals(Publisher.class)) {
                return obj;
            }
            RestrictedComponentContainer.RestrictedPublisher obj4 = new RestrictedComponentContainer.RestrictedPublisher(this.allowedPublishedEvents, (Publisher)obj);
            return obj4;
        }
        Object[] arr = new Object[1];
        DependencyException dependencyException = new DependencyException(String.format("Attempting to request an undeclared dependency %s.", class));
        throw dependencyException;
    }

    public <T> Deferred<T> getDeferred(Class<T> class) {
        if (!this.allowedDeferredInterfaces.contains(class)) {
        } else {
            return this.delegateContainer.getDeferred(class);
        }
        Object[] arr = new Object[1];
        DependencyException dependencyException = new DependencyException(String.format("Attempting to request an undeclared dependency Deferred<%s>.", class));
        throw dependencyException;
    }

    public <T> Provider<T> getProvider(Class<T> class) {
        if (!this.allowedProviderInterfaces.contains(class)) {
        } else {
            return this.delegateContainer.getProvider(class);
        }
        Object[] arr = new Object[1];
        DependencyException dependencyException = new DependencyException(String.format("Attempting to request an undeclared dependency Provider<%s>.", class));
        throw dependencyException;
    }

    public <T> Set<T> setOf(Class<T> class) {
        if (!this.allowedSetDirectInterfaces.contains(class)) {
        } else {
            return this.delegateContainer.setOf(class);
        }
        Object[] arr = new Object[1];
        DependencyException dependencyException = new DependencyException(String.format("Attempting to request an undeclared dependency Set<%s>.", class));
        throw dependencyException;
    }

    public <T> Provider<Set<T>> setOfProvider(Class<T> class) {
        if (!this.allowedSetProviderInterfaces.contains(class)) {
        } else {
            return this.delegateContainer.setOfProvider(class);
        }
        Object[] arr = new Object[1];
        DependencyException dependencyException = new DependencyException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", class));
        throw dependencyException;
    }
}
