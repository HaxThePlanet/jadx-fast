package kotlin.internal;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0005\u0008\u0081\u0081\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005¨\u0006\u0006", d2 = {"Lkotlin/internal/RequireKotlinVersionKind;", "", "(Ljava/lang/String;I)V", "LANGUAGE_VERSION", "COMPILER_VERSION", "API_VERSION", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum RequireKotlinVersionKind {

    LANGUAGE_VERSION,
    COMPILER_VERSION,
    API_VERSION;
    private static final kotlin.internal.RequireKotlinVersionKind[] $values() {
        return /* result */;
    }

    public static EnumEntries<kotlin.internal.RequireKotlinVersionKind> getEntries() {
        return RequireKotlinVersionKind.$ENTRIES;
    }
}
