package com.google.firebase.components;

/* loaded from: classes2.dex */
public final class Dependency {

    private final Class<?> anInterface;
    private final int injection;
    private final int type;
    private Dependency(Class<?> class, int i2, int i3) {
        super();
        this.anInterface = (Class)Preconditions.checkNotNull(class, "Null dependency anInterface.");
        this.type = i2;
        this.injection = i3;
    }

    public static com.google.firebase.components.Dependency deferred(Class<?> class) {
        Dependency dependency = new Dependency(class, 0, 2);
        return dependency;
    }

    private static String describeInjection(int i) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                if (i != 2) {
                } else {
                    return "deferred";
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported injection: ");
                stringBuilder.append(i);
                AssertionError assertionError = new AssertionError(stringBuilder.toString());
                throw assertionError;
            }
            return "provider";
        }
        return "direct";
    }

    @Deprecated
    public static com.google.firebase.components.Dependency optional(Class<?> class) {
        final int i = 0;
        Dependency dependency = new Dependency(class, i, i);
        return dependency;
    }

    public static com.google.firebase.components.Dependency optionalProvider(Class<?> class) {
        Dependency dependency = new Dependency(class, 0, 1);
        return dependency;
    }

    public static com.google.firebase.components.Dependency required(Class<?> class) {
        Dependency dependency = new Dependency(class, 1, 0);
        return dependency;
    }

    public static com.google.firebase.components.Dependency requiredProvider(Class<?> class) {
        final int i = 1;
        Dependency dependency = new Dependency(class, i, i);
        return dependency;
    }

    public static com.google.firebase.components.Dependency setOf(Class<?> class) {
        Dependency dependency = new Dependency(class, 2, 0);
        return dependency;
    }

    public static com.google.firebase.components.Dependency setOfProvider(Class<?> class) {
        Dependency dependency = new Dependency(class, 2, 1);
        return dependency;
    }

    public boolean equals(Object object) {
        boolean anInterface;
        int i;
        Class anInterface2;
        Object obj4;
        i = 0;
        if (object instanceof Dependency && this.anInterface == object.anInterface && this.type == object.type && this.injection == object.injection) {
            if (this.anInterface == object.anInterface) {
                if (this.type == object.type) {
                    if (this.injection == object.injection) {
                        i = 1;
                    }
                }
            }
        }
        return i;
    }

    public Class<?> getInterface() {
        return this.anInterface;
    }

    public int hashCode() {
        int i7 = 1000003;
        return i5 ^= injection;
    }

    public boolean isDeferred() {
        int i;
        i = this.injection == 2 ? 1 : 0;
        return i;
    }

    public boolean isDirectInjection() {
        int i;
        i = this.injection == 0 ? 1 : 0;
        return i;
    }

    public boolean isRequired() {
        int i;
        if (this.type == 1) {
        } else {
            i = 0;
        }
        return i;
    }

    public boolean isSet() {
        int i;
        i = this.type == 2 ? 1 : 0;
        return i;
    }

    public String toString() {
        String str;
        StringBuilder stringBuilder = new StringBuilder("Dependency{anInterface=");
        stringBuilder.append(this.anInterface);
        stringBuilder.append(", type=");
        int type = this.type;
        str = type == 1 ? "required" : type == null ? "optional" : "set";
        stringBuilder.append(str);
        stringBuilder.append(", injection=");
        stringBuilder.append(Dependency.describeInjection(this.injection));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
