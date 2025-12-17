package kotlin.i0.z.e.m0.h;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.i;
import kotlin.y.p;

/* loaded from: classes3.dex */
public enum e {

    VISIBILITY(true),
    MODALITY(true),
    OVERRIDE(true),
    ANNOTATIONS(false),
    INNER(true),
    MEMBER_KIND(true),
    DATA(true),
    INLINE(true),
    EXPECT(true),
    ACTUAL(true),
    CONST(true),
    LATEINIT(true),
    FUN(true),
    VALUE(true);

    private final boolean includeByDefault;

    public static final class a {
        public a(g g) {
            super();
        }
    }
    @Override // java.lang.Enum
    public final boolean getIncludeByDefault() {
        return this.includeByDefault;
    }
}
