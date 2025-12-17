package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;

/* loaded from: classes2.dex */
public class ChildKey implements Comparable<com.google.firebase.database.snapshot.ChildKey> {

    private static final com.google.firebase.database.snapshot.ChildKey INFO_CHILD_KEY = null;
    private static final com.google.firebase.database.snapshot.ChildKey MAX_KEY = null;
    public static final String MAX_KEY_NAME = "[MAX_KEY]";
    private static final com.google.firebase.database.snapshot.ChildKey MIN_KEY = null;
    public static final String MIN_KEY_NAME = "[MIN_NAME]";
    private static final com.google.firebase.database.snapshot.ChildKey PRIORITY_CHILD_KEY;
    private final String key;

    private static class IntegerChildKey extends com.google.firebase.database.snapshot.ChildKey {

        private final int intValue;
        IntegerChildKey(String string, int i2) {
            super(string, 0);
            this.intValue = i2;
        }

        @Override // com.google.firebase.database.snapshot.ChildKey
        public int compareTo(Object object) {
            return super.compareTo((ChildKey)object);
        }

        @Override // com.google.firebase.database.snapshot.ChildKey
        protected int intValue() {
            return this.intValue;
        }

        @Override // com.google.firebase.database.snapshot.ChildKey
        protected boolean isInt() {
            return 1;
        }

        @Override // com.google.firebase.database.snapshot.ChildKey
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("IntegerChildName(\"");
            stringBuilder.append(ChildKey.access$100(this));
            stringBuilder.append("\")");
            return stringBuilder.toString();
        }
    }
    static {
        ChildKey childKey = new ChildKey("[MIN_NAME]");
        ChildKey.MIN_KEY = childKey;
        ChildKey childKey2 = new ChildKey("[MAX_KEY]");
        ChildKey.MAX_KEY = childKey2;
        ChildKey childKey3 = new ChildKey(".priority");
        ChildKey.PRIORITY_CHILD_KEY = childKey3;
        ChildKey childKey4 = new ChildKey(".info");
        ChildKey.INFO_CHILD_KEY = childKey4;
    }

    private ChildKey(String string) {
        super();
        this.key = string;
    }

    ChildKey(String string, com.google.firebase.database.snapshot.ChildKey.1 childKey$12) {
        super(string);
    }

    static String access$100(com.google.firebase.database.snapshot.ChildKey childKey) {
        return childKey.key;
    }

    public static com.google.firebase.database.snapshot.ChildKey fromString(String string) {
        Integer tryParseInt = Utilities.tryParseInt(string);
        if (tryParseInt != null) {
            ChildKey.IntegerChildKey integerChildKey = new ChildKey.IntegerChildKey(string, tryParseInt.intValue());
            return integerChildKey;
        }
        if (string.equals(".priority")) {
            return ChildKey.PRIORITY_CHILD_KEY;
        }
        Utilities.hardAssert(contains ^= 1);
        ChildKey childKey = new ChildKey(string);
        return childKey;
    }

    public static com.google.firebase.database.snapshot.ChildKey getInfoKey() {
        return ChildKey.INFO_CHILD_KEY;
    }

    public static com.google.firebase.database.snapshot.ChildKey getMaxName() {
        return ChildKey.MAX_KEY;
    }

    public static com.google.firebase.database.snapshot.ChildKey getMinName() {
        return ChildKey.MIN_KEY;
    }

    public static com.google.firebase.database.snapshot.ChildKey getPriorityKey() {
        return ChildKey.PRIORITY_CHILD_KEY;
    }

    @Override // java.lang.Comparable
    public String asString() {
        return this.key;
    }

    @Override // java.lang.Comparable
    public int compareTo(com.google.firebase.database.snapshot.ChildKey childKey) {
        int compareInts;
        boolean equals2;
        boolean equals;
        String str;
        Object obj5;
        if (this == childKey) {
            return 0;
        }
        String str2 = "[MIN_NAME]";
        final int i2 = -1;
        if (!this.key.equals(str2)) {
            str = "[MAX_KEY]";
            if (childKey.key.equals(str)) {
            } else {
                int i = 1;
                if (!childKey.key.equals(str2)) {
                    if (this.key.equals(str)) {
                    } else {
                        if (isInt() && childKey.isInt() && Utilities.compareInts(intValue(), childKey.intValue()) == 0) {
                            if (childKey.isInt()) {
                                if (Utilities.compareInts(intValue(), childKey.intValue()) == 0) {
                                    compareInts = Utilities.compareInts(this.key.length(), childKey.key.length());
                                }
                                return compareInts;
                            }
                            return i2;
                        }
                        if (childKey.isInt()) {
                            return i;
                        }
                    }
                    return this.key.compareTo(childKey.key);
                }
            }
            return i;
        }
        return i2;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object object) {
        return compareTo((ChildKey)object);
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        if (!object instanceof ChildKey) {
            return 0;
        }
        if (this == object) {
            return 1;
        }
        return this.key.equals(object.key);
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        return this.key.hashCode();
    }

    @Override // java.lang.Comparable
    protected int intValue() {
        return 0;
    }

    @Override // java.lang.Comparable
    protected boolean isInt() {
        return 0;
    }

    @Override // java.lang.Comparable
    public boolean isPriorityChildName() {
        return equals(ChildKey.PRIORITY_CHILD_KEY);
    }

    @Override // java.lang.Comparable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChildKey(\"");
        stringBuilder.append(this.key);
        stringBuilder.append("\")");
        return stringBuilder.toString();
    }
}
