package androidx.compose.ui.tooling;

import androidx.compose.ui.tooling.data.Group;
import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a4\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006H\u0002\u001a3\u0010\u0008\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0014\u0010\u000b\u001a\u0010\u0012\n\u0008\u0001\u0012\u0006\u0012\u0002\u0008\u00030\r\u0018\u00010\u000c2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\u0010\u0010\u001a\u0014\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0008\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0002\u001a\u001a\u0010\u0013\u001a\u0010\u0012\n\u0008\u0001\u0012\u0006\u0012\u0002\u0008\u00030\r\u0018\u00010\u000c*\u00020\u0014H\u0000\u001a&\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005H\u0000\u001a\"\u0010\u0016\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005H\u0000\u001a)\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t*\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00182\u0006\u0010\u0019\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u001a¨\u0006\u001b", d2 = {"findGroupsThatMatchPredicate", "", "Landroidx/compose/ui/tooling/data/Group;", "root", "predicate", "Lkotlin/Function1;", "", "findOnlyFirst", "getPreviewProviderParameters", "", "", "parameterProviderClass", "Ljava/lang/Class;", "Landroidx/compose/ui/tooling/preview/PreviewParameterProvider;", "parameterProviderIndex", "", "(Ljava/lang/Class;I)[Ljava/lang/Object;", "unwrapIfInline", "classToCheck", "asPreviewProviderClass", "", "findAll", "firstOrNull", "toArray", "Lkotlin/sequences/Sequence;", "size", "(Lkotlin/sequences/Sequence;I)[Ljava/lang/Object;", "ui-tooling_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PreviewUtils_androidKt {
    public static final Class<? extends PreviewParameterProvider<?>> asPreviewProviderClass(String $this$asPreviewProviderClass) {
        int i;
        i = 0;
        final Class forName = Class.forName($this$asPreviewProviderClass);
        if (forName instanceof Class) {
            i = forName;
        }
        try {
            return i;
            StringBuilder string = new StringBuilder();
            String str = "Unable to find PreviewProvider '";
            string = string.append(str);
            string = string.append($this$asPreviewProviderClass);
            str = 39;
            string = string.append(str);
            string = string.toString();
            str = th;
            PreviewLogger.Companion.logError$ui_tooling_release(string, (Throwable)str);
            return obj0;
        }
    }

    public static final List<Group> findAll(Group $this$findAll, Function1<? super Group, Boolean> predicate) {
        return PreviewUtils_androidKt.findGroupsThatMatchPredicate$default($this$findAll, predicate, false, 4, 0);
    }

    private static final List<Group> findGroupsThatMatchPredicate(Group root, Function1<? super Group, Boolean> predicate, boolean findOnlyFirst) {
        int last;
        Collection children;
        ArrayList arrayList = new ArrayList();
        Group[] arr = new Group[1];
        List mutableListOf = CollectionsKt.mutableListOf(root);
        while (!(Collection)mutableListOf.isEmpty()) {
            last = CollectionsKt.removeLast(mutableListOf);
            mutableListOf.addAll(last.getChildren());
            (List)arrayList.add(last);
        }
        return arrayList;
    }

    static List findGroupsThatMatchPredicate$default(Group group, Function1 function12, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 4 != 0) {
            obj2 = 0;
        }
        return PreviewUtils_androidKt.findGroupsThatMatchPredicate(group, function12, obj2);
    }

    public static final Group firstOrNull(Group $this$firstOrNull, Function1<? super Group, Boolean> predicate) {
        return (Group)CollectionsKt.firstOrNull(PreviewUtils_androidKt.findGroupsThatMatchPredicate($this$firstOrNull, predicate, true));
    }

    public static final Object[] getPreviewProviderParameters(Class<? extends PreviewParameterProvider<?>> parameterProviderClass, int parameterProviderIndex) {
        int single$iv;
        int found$iv;
        int i4;
        int i3;
        int i;
        Constructor next;
        Constructor constructor;
        int i2;
        int unwrapIfInline;
        int i5 = 0;
        if (parameterProviderClass != null) {
            Constructor[] constructors = parameterProviderClass.getConstructors();
            int i8 = 0;
            single$iv = 0;
            found$iv = 0;
            i4 = i5;
            i3 = 0;
            i = 1;
            while (i4 < constructors.length) {
                next = constructors[i4];
                i2 = 0;
                if (parameterTypes.length == 0) {
                } else {
                }
                unwrapIfInline = i5;
                i4++;
                i3 = 0;
                i = 1;
                single$iv = next;
                found$iv = 1;
                unwrapIfInline = i;
            }
            if (found$iv == 0) {
                single$iv = i3;
            } else {
            }
            if (single$iv == 0) {
            } else {
                int i9 = 0;
                single$iv.setAccessible(i);
                Object instance = single$iv.newInstance(new Object[i5]);
                Intrinsics.checkNotNull(instance, "null cannot be cast to non-null type androidx.compose.ui.tooling.preview.PreviewParameterProvider<*>");
                if (parameterProviderIndex < 0) {
                    return PreviewUtils_androidKt.toArray((PreviewParameterProvider)instance.getValues(), instance.getCount());
                }
                List listOf = CollectionsKt.listOf(SequencesKt.elementAt(instance.getValues(), parameterProviderIndex));
                int i11 = 0;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)listOf, 10));
                int i13 = 0;
                Iterator iterator = listOf.iterator();
                for (Object next : iterator) {
                    i2 = 0;
                    (Collection)arrayList.add(PreviewUtils_androidKt.unwrapIfInline(next));
                }
                int i10 = 0;
                return (Collection)(List)arrayList.toArray(new Object[i5]);
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("PreviewParameterProvider constructor can not have parameters");
            throw illegalArgumentException;
        }
        int i7 = 0;
        return new Object[i5];
    }

    private static final Object[] toArray(Sequence<? extends Object> $this$toArray, int size) {
        int i;
        Object next;
        final Object[] arr = new Object[size];
        i = 0;
        while (i < size) {
            arr[i] = $this$toArray.iterator().next();
            i++;
        }
        return arr;
    }

    private static final Object unwrapIfInline(Object classToCheck) {
        int $this$any$iv;
        int i3;
        int length;
        int i;
        int i2;
        int i4;
        java.lang.annotation.Annotation it2;
        boolean it;
        int type;
        if (classToCheck != null) {
            java.lang.annotation.Annotation[] annotations = classToCheck.getClass().getAnnotations();
            i3 = 0;
            i = 0;
            i2 = i;
            i4 = 1;
            while (i2 < annotations.length) {
                type = 0;
                i2++;
                i4 = 1;
            }
            $this$any$iv = i;
            if ($this$any$iv != 0) {
                Field[] declaredFields = classToCheck.getClass().getDeclaredFields();
                int i5 = 0;
                while (i < declaredFields.length) {
                    i2 = declaredFields[i];
                    it = false;
                    i++;
                }
                NoSuchElementException noSuchElementException = new NoSuchElementException("Array contains no element matching the predicate.");
                throw noSuchElementException;
            }
        }
        return classToCheck;
    }
}
