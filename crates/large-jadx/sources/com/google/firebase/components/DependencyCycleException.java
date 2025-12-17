package com.google.firebase.components;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class DependencyCycleException extends com.google.firebase.components.DependencyException {

    private final List<com.google.firebase.components.Component<?>> componentsInCycle;
    public DependencyCycleException(List<com.google.firebase.components.Component<?>> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Dependency cycle detected: ");
        stringBuilder.append(Arrays.toString(list.toArray()));
        super(stringBuilder.toString());
        this.componentsInCycle = list;
    }

    public List<com.google.firebase.components.Component<?>> getComponentsInCycle() {
        return this.componentsInCycle;
    }
}
