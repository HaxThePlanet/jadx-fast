package com.google.firebase.firestore.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class ResourcePath extends com.google.firebase.firestore.model.BasePath<com.google.firebase.firestore.model.ResourcePath> {

    public static final com.google.firebase.firestore.model.ResourcePath EMPTY;
    static {
        ResourcePath resourcePath = new ResourcePath(Collections.emptyList());
        ResourcePath.EMPTY = resourcePath;
    }

    private ResourcePath(List<String> list) {
        super(list);
    }

    public static com.google.firebase.firestore.model.ResourcePath fromSegments(List<String> list) {
        boolean resourcePath;
        com.google.firebase.firestore.model.ResourcePath obj1;
        if (list.isEmpty()) {
            obj1 = ResourcePath.EMPTY;
        } else {
            resourcePath = new ResourcePath(list);
            obj1 = resourcePath;
        }
        return obj1;
    }

    public static com.google.firebase.firestore.model.ResourcePath fromString(String string) {
        int i;
        String str;
        boolean empty;
        if (string.contains("//")) {
        } else {
            String[] obj5 = string.split("/");
            ArrayList arrayList = new ArrayList(obj5.length);
            i = 0;
            while (i < obj5.length) {
                str = obj5[i];
                if (!str.isEmpty()) {
                }
                i++;
                arrayList.add(str);
            }
            obj5 = new ResourcePath(arrayList);
            return obj5;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid path (");
        stringBuilder.append(string);
        stringBuilder.append("). Paths must not contain // in them.");
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    @Override // com.google.firebase.firestore.model.BasePath
    public String canonicalString() {
        int i;
        Object obj;
        int size;
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < this.segments.size()) {
            if (i > 0) {
            }
            stringBuilder.append((String)this.segments.get(i));
            i++;
            stringBuilder.append("/");
        }
        return stringBuilder.toString();
    }

    @Override // com.google.firebase.firestore.model.BasePath
    com.google.firebase.firestore.model.BasePath createPathWithSegments(List list) {
        return createPathWithSegments(list);
    }

    com.google.firebase.firestore.model.ResourcePath createPathWithSegments(List<String> list) {
        ResourcePath resourcePath = new ResourcePath(list);
        return resourcePath;
    }
}
