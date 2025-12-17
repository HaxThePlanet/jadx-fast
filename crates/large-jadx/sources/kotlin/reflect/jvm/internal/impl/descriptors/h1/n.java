package kotlin.reflect.jvm.internal.impl.descriptors.h1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.u;
import kotlin.y.i;
import kotlin.y.j0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public enum n {

    CLASS("class", false, 2, false),
    TYPE_PARAMETER(false, 2),
    LOCAL_VARIABLE("annotation class", false, 2, false),
    CONSTRUCTOR(false, 2, false, false),
    TYPE(false, 2),
    EXPRESSION("class", 2),
    FILE(2, 2),
    TYPEALIAS("class", 2),
    TYPE_PROJECTION(2, 2),
    STAR_PROJECTION("class", 2),
    PROPERTY_PARAMETER(2, 2),
    CLASS_ONLY("class", 2),
    OBJECT(2, 2),
    COMPANION_OBJECT("class", 2),
    INTERFACE(2, 2),
    ENUM_CLASS("class", 2),
    ENUM_ENTRY(2, 2),
    LOCAL_CLASS("class", 2),
    LOCAL_FUNCTION(2, 2),
    MEMBER_FUNCTION("class", 2),
    TOP_LEVEL_FUNCTION(2, 2),
    MEMBER_PROPERTY("class", 2),
    MEMBER_PROPERTY_WITH_BACKING_FIELD(2, 2),
    MEMBER_PROPERTY_WITH_DELEGATE("class", 2),
    MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE(2, 2),
    TOP_LEVEL_PROPERTY("class", 2),
    TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD(2, 2),
    TOP_LEVEL_PROPERTY_WITH_DELEGATE("class", 2),
    TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE(2, 2),
    INITIALIZER("class", 2),
    DESTRUCTURING_DECLARATION(2, 2),
    LAMBDA_EXPRESSION("class", 2),
    ANONYMOUS_FUNCTION(2, 2),
    OBJECT_LITERAL("class", 2);

    private final String description;
    private final boolean isDefault;

    public static final class a {
        public a(g g) {
            super();
        }
    }
    @Override // java.lang.Enum
    public final boolean isDefault() {
        return this.isDefault;
    }
}
