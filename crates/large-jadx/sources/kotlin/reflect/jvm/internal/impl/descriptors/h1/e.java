package kotlin.reflect.jvm.internal.impl.descriptors.h1;

import java.util.Objects;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public enum e {

    FIELD(false, true, false),
    PROPERTY_GETTER(false),
    PROPERTY_SETTER("FILE"),
    CONSTRUCTOR_PARAMETER(true),
    SETTER_PARAMETER(true),
    PROPERTY_DELEGATE_FIELD(2);

    private final String renderName;
    @Override // java.lang.Enum
    public final String getRenderName() {
        return this.renderName;
    }
}
