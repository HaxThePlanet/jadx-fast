package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public class Path implements Iterable<ChildKey>, Comparable<com.google.firebase.database.core.Path> {

    private static final com.google.firebase.database.core.Path EMPTY_PATH;
    private final int end;
    private final ChildKey[] pieces;
    private final int start;
    static {
        Path path = new Path("");
        Path.EMPTY_PATH = path;
    }

    public Path(String string) {
        int i;
        int i2;
        int i5;
        int i3;
        int length2;
        int length;
        int i4;
        super();
        String[] obj8 = string.split("/", -1);
        int i7 = 0;
        i5 = i;
        while (i < obj8.length) {
            if (obj8[i].length() > 0) {
            }
            i++;
            i5++;
        }
        this.pieces = new ChildKey[i5];
        i3 = i2;
        while (i2 < obj8.length) {
            length2 = obj8[i2];
            if (length2.length() > 0) {
            }
            i2++;
            this.pieces[i3] = ChildKey.fromString(length2);
            i3 = i4;
        }
        this.start = i7;
        this.end = obj8.length;
    }

    public Path(List<String> list) {
        int i2;
        ChildKey string;
        ChildKey[] pieces;
        int i;
        super();
        this.pieces = new ChildKey[list.size()];
        Iterator iterator = list.iterator();
        final int i3 = 0;
        i2 = i3;
        for (String next2 : iterator) {
            this.pieces[i2] = ChildKey.fromString(next2);
            i2 = i;
        }
        this.start = i3;
        this.end = list.size();
    }

    public Path(ChildKey... childKeyArr) {
        int i;
        int i2;
        String str;
        super();
        this.pieces = (ChildKey[])Arrays.copyOf(childKeyArr, childKeyArr.length);
        int i3 = 0;
        this.start = i3;
        this.end = childKeyArr.length;
        i = i3;
        while (i < childKeyArr.length) {
            if (childKeyArr[i] != null) {
            } else {
            }
            i2 = i3;
            Utilities.hardAssert(i2, "Can't construct a path with a null value!");
            i++;
            i2 = 1;
        }
    }

    private Path(ChildKey[] childKeyArr, int i2, int i3) {
        super();
        this.pieces = childKeyArr;
        this.start = i2;
        this.end = i3;
    }

    static int access$000(com.google.firebase.database.core.Path path) {
        return path.start;
    }

    static int access$100(com.google.firebase.database.core.Path path) {
        return path.end;
    }

    static ChildKey[] access$200(com.google.firebase.database.core.Path path) {
        return path.pieces;
    }

    public static com.google.firebase.database.core.Path getEmptyPath() {
        return Path.EMPTY_PATH;
    }

    public static com.google.firebase.database.core.Path getRelative(com.google.firebase.database.core.Path path, com.google.firebase.database.core.Path path2) {
        ChildKey front = path.getFront();
        if (front == null) {
            return path2;
        }
        if (!front.equals(path2.getFront())) {
        } else {
            return Path.getRelative(path.popFront(), path2.popFront());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INTERNAL ERROR: ");
        stringBuilder.append(path2);
        stringBuilder.append(" is not contained in ");
        stringBuilder.append(path);
        DatabaseException databaseException = new DatabaseException(stringBuilder.toString());
        throw databaseException;
    }

    public List<String> asList() {
        String string;
        ArrayList arrayList = new ArrayList(size());
        Iterator iterator = iterator();
        for (ChildKey next2 : iterator) {
            arrayList.add(next2.asString());
        }
        return arrayList;
    }

    @Override // java.lang.Iterable
    public com.google.firebase.database.core.Path child(com.google.firebase.database.core.Path path) {
        size += size2;
        ChildKey[] arr = new ChildKey[i];
        final int i2 = 0;
        System.arraycopy(this.pieces, this.start, arr, i2, size());
        System.arraycopy(path.pieces, path.start, arr, size(), path.size());
        Path obj7 = new Path(arr, i2, i);
        return obj7;
    }

    @Override // java.lang.Iterable
    public com.google.firebase.database.core.Path child(ChildKey childKey) {
        final int size = size();
        final int i = size + 1;
        final ChildKey[] arr = new ChildKey[i];
        final int i2 = 0;
        System.arraycopy(this.pieces, this.start, arr, i2, size);
        arr[size] = childKey;
        Path obj7 = new Path(arr, i2, i);
        return obj7;
    }

    @Override // java.lang.Iterable
    public int compareTo(com.google.firebase.database.core.Path path) {
        int start2;
        int start;
        int compareTo;
        ChildKey end;
        Object obj5;
        start2 = this.start;
        start = path.start;
        int end2 = this.end;
        while (start2 < end2) {
            compareTo = this.pieces[start2].compareTo(path.pieces[start]);
            start2++;
            start++;
            end2 = this.end;
        }
        if (start2 == end2 && start == path.end) {
            if (start == path.end) {
                return 0;
            }
        }
        if (start2 == end2) {
            return -1;
        }
        return 1;
    }

    @Override // java.lang.Iterable
    public int compareTo(Object object) {
        return compareTo((Path)object);
    }

    @Override // java.lang.Iterable
    public boolean contains(com.google.firebase.database.core.Path path) {
        int start2;
        int start;
        boolean equals;
        ChildKey childKey;
        final int i = 0;
        if (size() > path.size()) {
            return i;
        }
        start2 = this.start;
        start = path.start;
        while (start2 < this.end) {
            start2++;
            start++;
        }
        return 1;
    }

    @Override // java.lang.Iterable
    public boolean equals(Object object) {
        int start;
        int start2;
        boolean equals;
        int end;
        ChildKey childKey;
        final int i2 = 0;
        if (object instanceof Path == null) {
            return i2;
        }
        int i = 1;
        if (this == object) {
            return i;
        }
        if (size() != (Path)object.size()) {
            return i2;
        }
        start = this.start;
        start2 = object.start;
        while (start < this.end) {
            start++;
            start2++;
        }
        return i;
    }

    @Override // java.lang.Iterable
    public ChildKey getBack() {
        if (!isEmpty()) {
            return this.pieces[end--];
        }
        return null;
    }

    @Override // java.lang.Iterable
    public ChildKey getFront() {
        if (isEmpty()) {
            return null;
        }
        return this.pieces[this.start];
    }

    @Override // java.lang.Iterable
    public com.google.firebase.database.core.Path getParent() {
        if (isEmpty()) {
            return null;
        }
        Path path = new Path(this.pieces, this.start, end--);
        return path;
    }

    @Override // java.lang.Iterable
    public int hashCode() {
        int start;
        int i;
        int i2;
        start = this.start;
        i = 0;
        while (start < this.end) {
            i3 += i2;
            start++;
        }
        return i;
    }

    @Override // java.lang.Iterable
    public boolean isEmpty() {
        int i;
        i = this.start >= this.end ? 1 : 0;
        return i;
    }

    public Iterator<ChildKey> iterator() {
        Path.1 anon = new Path.1(this);
        return anon;
    }

    @Override // java.lang.Iterable
    public com.google.firebase.database.core.Path popFront() {
        int start;
        if (!isEmpty()) {
            start++;
        }
        Path path = new Path(this.pieces, start, this.end);
        return path;
    }

    @Override // java.lang.Iterable
    public int size() {
        return end -= start;
    }

    @Override // java.lang.Iterable
    public String toString() {
        int start;
        String string;
        final String str = "/";
        if (isEmpty()) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        start = this.start;
        while (start < this.end) {
            stringBuilder.append(str);
            stringBuilder.append(this.pieces[start].asString());
            start++;
        }
        return stringBuilder.toString();
    }

    @Override // java.lang.Iterable
    public String wireFormat() {
        int start;
        String string;
        final String str = "/";
        if (isEmpty()) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        start = this.start;
        while (start < this.end) {
            if (start > this.start) {
            }
            stringBuilder.append(this.pieces[start].asString());
            start++;
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }
}
