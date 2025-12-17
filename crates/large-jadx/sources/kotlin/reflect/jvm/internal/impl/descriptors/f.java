package kotlin.reflect.jvm.internal.impl.descriptors;

/* loaded from: classes3.dex */
public enum f {

    CLASS,
    INTERFACE,
    ENUM_CLASS,
    ENUM_ENTRY,
    ANNOTATION_CLASS,
    OBJECT;
    @Override // java.lang.Enum
    public boolean isSingleton() {
        int i;
        kotlin.reflect.jvm.internal.impl.descriptors.f eNUM_ENTRY;
        if (this != f.OBJECT) {
            if (this == f.ENUM_ENTRY) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }
}
