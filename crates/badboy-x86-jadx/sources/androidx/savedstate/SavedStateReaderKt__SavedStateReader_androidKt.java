package androidx.savedstate;

import android.os.Bundle;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0008\u0002\u001a!\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0002\u0008\u0005\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0002\u0008\u0008\u001a3\u0010\t\u001a\u00020\n*\u00060\u0002j\u0002`\u00032\n\u0010\u000b\u001a\u00060\u000cj\u0002`\r2\u0010\u0010\u000e\u001a\u000c\u0012\u0008\u0012\u00060\u0002j\u0002`\u00030\u000fH\u0002¢\u0006\u0002\u0008\u0010¨\u0006\u0011", d2 = {"contentDeepEquals", "", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "other", "contentDeepEquals$SavedStateReaderKt__SavedStateReader_androidKt", "contentDeepHashCode", "", "contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt", "contentDeepToString", "", "result", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "processed", "", "contentDeepToString$SavedStateReaderKt__SavedStateReader_androidKt", "savedstate_release"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "androidx/savedstate/SavedStateReaderKt")
final class SavedStateReaderKt__SavedStateReader_androidKt {
    public static final boolean access$contentDeepEquals(Bundle $receiver, Bundle other) {
        return SavedStateReaderKt__SavedStateReader_androidKt.contentDeepEquals$SavedStateReaderKt__SavedStateReader_androidKt($receiver, other);
    }

    public static final int access$contentDeepHashCode(Bundle $receiver) {
        return SavedStateReaderKt__SavedStateReader_androidKt.contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt($receiver);
    }

    public static final void access$contentDeepToString(Bundle $receiver, StringBuilder result, List processed) {
        SavedStateReaderKt__SavedStateReader_androidKt.contentDeepToString$SavedStateReaderKt__SavedStateReader_androidKt($receiver, result, processed);
    }

    private static final boolean contentDeepEquals$SavedStateReaderKt__SavedStateReader_androidKt(Bundle $this$contentDeepEquals, Bundle other) {
        int size;
        Object obj2;
        Object obj;
        boolean contentDeepEquals$SavedStateReaderKt__SavedStateReader_androidKt;
        boolean z5;
        boolean z9;
        boolean z10;
        boolean z3;
        boolean z2;
        boolean z6;
        boolean z4;
        boolean z8;
        boolean z7;
        boolean z;
        Object obj3;
        final int i = 1;
        if ($this$contentDeepEquals == other) {
            return i;
        }
        final int i2 = 0;
        if ($this$contentDeepEquals.size() != other.size()) {
            return i2;
        }
        Iterator iterator = $this$contentDeepEquals.keySet().iterator();
        for (String size : iterator) {
            obj2 = $this$contentDeepEquals.get(size);
            obj = other.get(size);
        }
        return i;
    }

    private static final int contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt(Bundle $this$contentDeepHashCode) {
        int result;
        Object next;
        int i;
        int contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt;
        result = 1;
        Iterator iterator = $this$contentDeepHashCode.keySet().iterator();
        while (iterator.hasNext()) {
            Object obj = $this$contentDeepHashCode.get((String)iterator.next());
            if (obj instanceof Bundle != null) {
            } else {
            }
            if (obj instanceof Object[]) {
            } else {
            }
            if (obj instanceof byte[]) {
            } else {
            }
            if (obj instanceof short[]) {
            } else {
            }
            if (obj instanceof int[]) {
            } else {
            }
            if (obj instanceof long[]) {
            } else {
            }
            if (obj instanceof float[]) {
            } else {
            }
            if (obj instanceof double[]) {
            } else {
            }
            if (obj instanceof char[]) {
            } else {
            }
            if (obj instanceof boolean[]) {
            } else {
            }
            if (obj != null) {
            } else {
            }
            contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt = 0;
            result = i + contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt;
            contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt = obj.hashCode();
            contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt = Arrays.hashCode((boolean[])obj);
            contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt = Arrays.hashCode((char[])obj);
            contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt = Arrays.hashCode((double[])obj);
            contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt = Arrays.hashCode((float[])obj);
            contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt = Arrays.hashCode((long[])obj);
            contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt = Arrays.hashCode((int[])obj);
            contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt = Arrays.hashCode((short[])obj);
            contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt = Arrays.hashCode((byte[])obj);
            contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt = ArraysKt.contentDeepHashCode((Object[])obj);
            contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt = SavedStateReaderKt__SavedStateReader_androidKt.contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt((Bundle)obj);
        }
        return result;
    }

    private static final void contentDeepToString$SavedStateReaderKt__SavedStateReader_androidKt(Bundle $this$contentDeepToString, StringBuilder result, List<Bundle> processed) {
        int i;
        int i2;
        Object next;
        Object str2;
        Unit contentDeepToString;
        String str;
        if (processed.contains($this$contentDeepToString)) {
            result.append("[...]");
        }
        (Collection)processed.add($this$contentDeepToString);
        result.append('[');
        Iterator iterator = (Iterable)$this$contentDeepToString.keySet().iterator();
        i = 0;
        while (iterator.hasNext()) {
            i++;
            next = iterator.next();
            if (i != 0) {
            }
            StringBuilder stringBuilder = new StringBuilder();
            result.append(stringBuilder.append((String)next).append('=').toString());
            str2 = $this$contentDeepToString.get(next);
            if (str2 == null) {
            } else {
            }
            if (str2 instanceof Bundle != null) {
            } else {
            }
            if (str2 instanceof Object[]) {
            } else {
            }
            str = "toString(...)";
            if (str2 instanceof byte[]) {
            } else {
            }
            if (str2 instanceof short[]) {
            } else {
            }
            if (str2 instanceof int[]) {
            } else {
            }
            if (str2 instanceof long[]) {
            } else {
            }
            if (str2 instanceof float[]) {
            } else {
            }
            if (str2 instanceof double[]) {
            } else {
            }
            if (str2 instanceof char[]) {
            } else {
            }
            if (str2 instanceof boolean[]) {
            } else {
            }
            result.append(str2.toString());
            contentDeepToString = Arrays.toString((boolean[])str2);
            Intrinsics.checkNotNullExpressionValue(contentDeepToString, str);
            result.append(contentDeepToString);
            contentDeepToString = Arrays.toString((char[])str2);
            Intrinsics.checkNotNullExpressionValue(contentDeepToString, str);
            result.append(contentDeepToString);
            contentDeepToString = Arrays.toString((double[])str2);
            Intrinsics.checkNotNullExpressionValue(contentDeepToString, str);
            result.append(contentDeepToString);
            contentDeepToString = Arrays.toString((float[])str2);
            Intrinsics.checkNotNullExpressionValue(contentDeepToString, str);
            result.append(contentDeepToString);
            contentDeepToString = Arrays.toString((long[])str2);
            Intrinsics.checkNotNullExpressionValue(contentDeepToString, str);
            result.append(contentDeepToString);
            contentDeepToString = Arrays.toString((int[])str2);
            Intrinsics.checkNotNullExpressionValue(contentDeepToString, str);
            result.append(contentDeepToString);
            contentDeepToString = Arrays.toString((short[])str2);
            Intrinsics.checkNotNullExpressionValue(contentDeepToString, str);
            result.append(contentDeepToString);
            contentDeepToString = Arrays.toString((byte[])str2);
            Intrinsics.checkNotNullExpressionValue(contentDeepToString, str);
            result.append(contentDeepToString);
            result.append(ArraysKt.contentDeepToString((Object[])str2));
            SavedStateReaderKt__SavedStateReader_androidKt.contentDeepToString$SavedStateReaderKt__SavedStateReader_androidKt((Bundle)str2, result, processed);
            contentDeepToString = Unit.INSTANCE;
            result.append("null");
            result.append(", ");
        }
        result.append(']');
        processed.remove(CollectionsKt.getLastIndex(processed));
    }
}
