package kotlin.enums;

import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0003\u001a!\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0010\u0008\u0000\u0010\u0002\u0018\u0001*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\u0008\u001a2\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0001\"\u000e\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00032\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00040\u00070\u0006H\u0001\u001a1\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0001\"\u000e\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00032\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0007H\u0001¢\u0006\u0002\u0010\t¨\u0006\n", d2 = {"enumEntries", "Lkotlin/enums/EnumEntries;", "T", "", "E", "entriesProvider", "Lkotlin/Function0;", "", "entries", "([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class EnumEntriesKt {
    public static final <T extends Enum<T>> kotlin.enums.EnumEntries<T> enumEntries() {
        final int i = 0;
        final int i2 = 0;
        NotImplementedError notImplementedError = new NotImplementedError(i2, 1, i2);
        throw notImplementedError;
    }

    public static final <E extends Enum<E>> kotlin.enums.EnumEntries<E> enumEntries(Function0<E[]> entriesProvider) {
        Intrinsics.checkNotNullParameter(entriesProvider, "entriesProvider");
        EnumEntriesList enumEntriesList = new EnumEntriesList((Enum[])entriesProvider.invoke());
        return (EnumEntries)enumEntriesList;
    }

    public static final <E extends Enum<E>> kotlin.enums.EnumEntries<E> enumEntries(E[] entries) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        EnumEntriesList enumEntriesList = new EnumEntriesList(entries);
        return (EnumEntries)enumEntriesList;
    }
}
