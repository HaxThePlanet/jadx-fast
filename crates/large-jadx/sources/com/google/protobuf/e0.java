package com.google.protobuf;

/* loaded from: classes2.dex */
public enum e0 {

    VOID(/* unknown */, false, false),
    DOUBLE(field_16, /* unknown */, /* unknown */),
    STRING(/* unknown */, /* unknown */, "");

    private final Class<?> boxedType;
    private final Object defaultDefault;
    private final Class<?> type;
    public Class<?> getBoxedType() {
        return this.boxedType;
    }

    @Override // java.lang.Enum
    public Object getDefaultDefault() {
        return this.defaultDefault;
    }

    public Class<?> getType() {
        return this.type;
    }

    public boolean isValidType(Class<?> class) {
        return this.type.isAssignableFrom(class);
    }
}
