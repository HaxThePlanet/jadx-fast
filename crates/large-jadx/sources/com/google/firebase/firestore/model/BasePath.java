package com.google.firebase.firestore.model;

import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Util;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class BasePath<B extends com.google.firebase.firestore.model.BasePath<B>>  implements Comparable<B> {

    final List<String> segments;
    BasePath(List<String> list) {
        super();
        this.segments = list;
    }

    public B append(B b) {
        ArrayList arrayList = new ArrayList(this.segments);
        arrayList.addAll(b.segments);
        return createPathWithSegments(arrayList);
    }

    public B append(String string) {
        ArrayList arrayList = new ArrayList(this.segments);
        arrayList.add(string);
        return createPathWithSegments(arrayList);
    }

    @Override // java.lang.Comparable
    public abstract String canonicalString();

    public int compareTo(B b) {
        int i;
        int compareTo;
        String segment;
        final int length = length();
        final int length2 = b.length();
        i = 0;
        while (i < length) {
            compareTo = getSegment(i).compareTo(b.getSegment(i));
            i++;
        }
        return Util.compareIntegers(length, length2);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object object) {
        return compareTo((BasePath)object);
    }

    abstract B createPathWithSegments(List<String> list);

    @Override // java.lang.Comparable
    public final boolean equals(Object object) {
        int i;
        Object obj3;
        if (this == object) {
            return 1;
        }
        if (object instanceof BasePath != null && compareTo((BasePath)object) == 0) {
            if (compareTo((BasePath)object) == 0) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // java.lang.Comparable
    public String getFirstSegment() {
        return (String)this.segments.get(0);
    }

    @Override // java.lang.Comparable
    public String getLastSegment() {
        return (String)this.segments.get(length--);
    }

    @Override // java.lang.Comparable
    public String getSegment(int i) {
        return (String)this.segments.get(i);
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        int i5 = 37;
        return i3 += i6;
    }

    @Override // java.lang.Comparable
    public boolean isEmpty() {
        int i;
        i = length() == 0 ? 1 : 0;
        return i;
    }

    public boolean isImmediateParentOf(B b) {
        int i;
        int length;
        String segment;
        final int i3 = 1;
        final int i4 = 0;
        if (length2 += i3 != b.length()) {
            return i4;
        }
        i = i4;
        while (i < length()) {
            i++;
        }
        return i3;
    }

    public boolean isPrefixOf(B b) {
        int i;
        int length;
        String segment;
        final int i2 = 0;
        if (length() > b.length()) {
            return i2;
        }
        i = i2;
        while (i < length()) {
            i++;
        }
        return 1;
    }

    public B keepFirst(int i) {
        return createPathWithSegments(this.segments.subList(0, i));
    }

    @Override // java.lang.Comparable
    public int length() {
        return this.segments.size();
    }

    public B popFirst() {
        return popFirst(1);
    }

    public B popFirst(int i) {
        int i2;
        final int length = length();
        int i3 = 1;
        int i4 = 0;
        i2 = length >= i ? i3 : i4;
        Object[] arr = new Object[2];
        arr[i4] = Integer.valueOf(i);
        arr[i3] = Integer.valueOf(length);
        Assert.hardAssert(i2, "Can't call popFirst with count > length() (%d > %d)", arr);
        return createPathWithSegments(this.segments.subList(i, length));
    }

    public B popLast() {
        return createPathWithSegments(this.segments.subList(0, length--));
    }

    @Override // java.lang.Comparable
    public String toString() {
        return canonicalString();
    }
}
