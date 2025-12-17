package androidx.savedstate;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000c\n\u0002\u0008\u0003\n\u0002\u0010\r\n\u0002\u0008\u0003\n\u0002\u0010\u0006\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010 \n\u0002\u0008\u000b\n\u0002\u0010\u0018\n\u0002\u0008\u0003\n\u0002\u0010\u0019\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0008\u0003\n\u0002\u0010\u0013\n\u0002\u0008\u0003\n\u0002\u0010\u0014\n\u0002\u0008\u0003\n\u0002\u0010\u0015\n\u0002\u0008\u0003\n\u0002\u0010\u0016\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0019\u0008\u0087@\u0018\u00002\u00020\u0001B\u0015\u0008\u0001\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\u0008\u0005\u0010\u0006J\u001d\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c¢\u0006\u0004\u0008\r\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0010¢\u0006\u0004\u0008\u0011\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0014¢\u0006\u0004\u0008\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0018¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u001d\u0010\u001b\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u001c¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u001d\u0010\u001f\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020 ¢\u0006\u0004\u0008!\u0010\"J\u001d\u0010#\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020$¢\u0006\u0004\u0008%\u0010&J\u001d\u0010'\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020(¢\u0006\u0004\u0008)\u0010*J\u0015\u0010+\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008,\u0010-J'\u0010.\u001a\u00020\u0008\"\u0008\u0008\u0000\u0010/*\u0002002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u0002H/¢\u0006\u0004\u00081\u00102J'\u00103\u001a\u00020\u0008\"\u0008\u0008\u0000\u0010/*\u0002042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u0002H/¢\u0006\u0004\u00085\u00106J\u001d\u00107\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u000208¢\u0006\u0004\u00089\u0010:J\u001d\u0010;\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020<¢\u0006\u0004\u0008=\u0010>J\u001d\u0010?\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\u0008@\u0010AJ#\u0010B\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020$0C¢\u0006\u0004\u0008D\u0010EJ#\u0010F\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00180C¢\u0006\u0004\u0008G\u0010EJ'\u0010H\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\u000c\u0012\u0008\u0012\u00060\u0003j\u0002`\u00040C¢\u0006\u0004\u0008I\u0010EJ#\u0010J\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\n0C¢\u0006\u0004\u0008K\u0010EJ-\u0010L\u001a\u00020\u0008\"\u0008\u0008\u0000\u0010/*\u0002002\u0006\u0010\t\u001a\u00020\n2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H/0C¢\u0006\u0004\u0008M\u0010EJ\u001d\u0010N\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020O¢\u0006\u0004\u0008P\u0010QJ\u001d\u0010R\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020S¢\u0006\u0004\u0008T\u0010UJ#\u0010V\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00180W¢\u0006\u0004\u0008X\u0010YJ\u001d\u0010Z\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020[¢\u0006\u0004\u0008\\\u0010]J\u001d\u0010^\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020_¢\u0006\u0004\u0008`\u0010aJ\u001d\u0010b\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020c¢\u0006\u0004\u0008d\u0010eJ\u001d\u0010f\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020g¢\u0006\u0004\u0008h\u0010iJ'\u0010j\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\u000c\u0012\u0008\u0012\u00060\u0003j\u0002`\u00040W¢\u0006\u0004\u0008k\u0010lJ#\u0010m\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\n0W¢\u0006\u0004\u0008n\u0010oJ-\u0010p\u001a\u00020\u0008\"\u0008\u0008\u0000\u0010/*\u0002002\u0006\u0010\t\u001a\u00020\n2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H/0W¢\u0006\u0004\u0008q\u0010rJ-\u0010s\u001a\u00020\u0008\"\u0008\u0008\u0000\u0010/*\u0002002\u0006\u0010\t\u001a\u00020\n2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H/0t¢\u0006\u0004\u0008u\u0010vJ!\u0010w\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\u0008x\u0010yJ\u0019\u0010z\u001a\u00020\u00082\n\u0010{\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\u0008|\u0010}J\u0015\u0010~\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008\u007f\u0010-J\u0010\u0010\u0080\u0001\u001a\u00020\u0008¢\u0006\u0006\u0008\u0081\u0001\u0010\u0082\u0001J\u001e\u0010\u0083\u0001\u001a\u00020\u00102\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0006\u0008\u0085\u0001\u0010\u0086\u0001J\u0013\u0010\u0087\u0001\u001a\u00020$HÖ\u0001¢\u0006\u0006\u0008\u0088\u0001\u0010\u0089\u0001J\u0013\u0010\u008a\u0001\u001a\u00020\nHÖ\u0001¢\u0006\u0006\u0008\u008b\u0001\u0010\u008c\u0001R\u0012\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00060\u0003j\u0002`\u0004¨\u0006\u008d\u0001", d2 = {"Landroidx/savedstate/SavedStateWriter;", "", "source", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "constructor-impl", "(Landroid/os/Bundle;)Landroid/os/Bundle;", "putBinder", "", "key", "", "value", "Landroid/os/IBinder;", "putBinder-impl", "(Landroid/os/Bundle;Ljava/lang/String;Landroid/os/IBinder;)V", "putBoolean", "", "putBoolean-impl", "(Landroid/os/Bundle;Ljava/lang/String;Z)V", "putChar", "", "putChar-impl", "(Landroid/os/Bundle;Ljava/lang/String;C)V", "putCharSequence", "", "putCharSequence-impl", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/CharSequence;)V", "putDouble", "", "putDouble-impl", "(Landroid/os/Bundle;Ljava/lang/String;D)V", "putFloat", "", "putFloat-impl", "(Landroid/os/Bundle;Ljava/lang/String;F)V", "putInt", "", "putInt-impl", "(Landroid/os/Bundle;Ljava/lang/String;I)V", "putLong", "", "putLong-impl", "(Landroid/os/Bundle;Ljava/lang/String;J)V", "putNull", "putNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)V", "putParcelable", "T", "Landroid/os/Parcelable;", "putParcelable-impl", "(Landroid/os/Bundle;Ljava/lang/String;Landroid/os/Parcelable;)V", "putJavaSerializable", "Ljava/io/Serializable;", "putJavaSerializable-impl", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/io/Serializable;)V", "putSize", "Landroid/util/Size;", "putSize-impl", "(Landroid/os/Bundle;Ljava/lang/String;Landroid/util/Size;)V", "putSizeF", "Landroid/util/SizeF;", "putSizeF-impl", "(Landroid/os/Bundle;Ljava/lang/String;Landroid/util/SizeF;)V", "putString", "putString-impl", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)V", "putIntList", "", "putIntList-impl", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/util/List;)V", "putCharSequenceList", "putCharSequenceList-impl", "putSavedStateList", "putSavedStateList-impl", "putStringList", "putStringList-impl", "putParcelableList", "putParcelableList-impl", "putBooleanArray", "", "putBooleanArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[Z)V", "putCharArray", "", "putCharArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[C)V", "putCharSequenceArray", "", "putCharSequenceArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[Ljava/lang/CharSequence;)V", "putDoubleArray", "", "putDoubleArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[D)V", "putFloatArray", "", "putFloatArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[F)V", "putIntArray", "", "putIntArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[I)V", "putLongArray", "", "putLongArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[J)V", "putSavedStateArray", "putSavedStateArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[Landroid/os/Bundle;)V", "putStringArray", "putStringArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[Ljava/lang/String;)V", "putParcelableArray", "putParcelableArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[Landroid/os/Parcelable;)V", "putSparseParcelableArray", "Landroid/util/SparseArray;", "putSparseParcelableArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;Landroid/util/SparseArray;)V", "putSavedState", "putSavedState-impl", "(Landroid/os/Bundle;Ljava/lang/String;Landroid/os/Bundle;)V", "putAll", "from", "putAll-impl", "(Landroid/os/Bundle;Landroid/os/Bundle;)V", "remove", "remove-impl", "clear", "clear-impl", "(Landroid/os/Bundle;)V", "equals", "other", "equals-impl", "(Landroid/os/Bundle;Ljava/lang/Object;)Z", "hashCode", "hashCode-impl", "(Landroid/os/Bundle;)I", "toString", "toString-impl", "(Landroid/os/Bundle;)Ljava/lang/String;", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class SavedStateWriter {

    private final Bundle source;
    private SavedStateWriter(Bundle source) {
        super();
        this.source = source;
    }

    public static final androidx.savedstate.SavedStateWriter box-impl(Bundle bundle) {
        SavedStateWriter savedStateWriter = new SavedStateWriter(bundle);
        return savedStateWriter;
    }

    public static final void clear-impl(Bundle arg0) {
        arg0.clear();
    }

    public static Bundle constructor-impl(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "source");
        return bundle;
    }

    public static boolean equals-impl(Bundle bundle, Object object2) {
        final int i2 = 0;
        if (!object2 instanceof SavedStateWriter) {
            return i2;
        }
        if (!Intrinsics.areEqual(bundle, (SavedStateWriter)object2.unbox-impl())) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(Bundle bundle, Bundle bundle2) {
        return Intrinsics.areEqual(bundle, bundle2);
    }

    public static int hashCode-impl(Bundle bundle) {
        return bundle.hashCode();
    }

    public static final void putAll-impl(Bundle arg0, Bundle from) {
        Intrinsics.checkNotNullParameter(from, "from");
        arg0.putAll(from);
    }

    public static final void putBinder-impl(Bundle arg0, String key, IBinder value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        arg0.putBinder(key, value);
    }

    public static final void putBoolean-impl(Bundle arg0, String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        arg0.putBoolean(key, value);
    }

    public static final void putBooleanArray-impl(Bundle arg0, String key, boolean[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        arg0.putBooleanArray(key, value);
    }

    public static final void putChar-impl(Bundle arg0, String key, char value) {
        Intrinsics.checkNotNullParameter(key, "key");
        arg0.putChar(key, value);
    }

    public static final void putCharArray-impl(Bundle arg0, String key, char[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        arg0.putCharArray(key, value);
    }

    public static final void putCharSequence-impl(Bundle arg0, String key, java.lang.CharSequence value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        arg0.putCharSequence(key, value);
    }

    public static final void putCharSequenceArray-impl(Bundle arg0, String key, java.lang.CharSequence[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        arg0.putCharSequenceArray(key, value);
    }

    public static final void putCharSequenceList-impl(Bundle arg0, String key, List<? extends java.lang.CharSequence> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        arg0.putCharSequenceArrayList(key, SavedStateWriterKt.toArrayListUnsafe((Collection)value));
    }

    public static final void putDouble-impl(Bundle arg0, String key, double value) {
        Intrinsics.checkNotNullParameter(key, "key");
        arg0.putDouble(key, value);
    }

    public static final void putDoubleArray-impl(Bundle arg0, String key, double[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        arg0.putDoubleArray(key, value);
    }

    public static final void putFloat-impl(Bundle arg0, String key, float value) {
        Intrinsics.checkNotNullParameter(key, "key");
        arg0.putFloat(key, value);
    }

    public static final void putFloatArray-impl(Bundle arg0, String key, float[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        arg0.putFloatArray(key, value);
    }

    public static final void putInt-impl(Bundle arg0, String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        arg0.putInt(key, value);
    }

    public static final void putIntArray-impl(Bundle arg0, String key, int[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        arg0.putIntArray(key, value);
    }

    public static final void putIntList-impl(Bundle arg0, String key, List<Integer> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        arg0.putIntegerArrayList(key, SavedStateWriterKt.toArrayListUnsafe((Collection)value));
    }

    public static final <T extends java.io.Serializable> void putJavaSerializable-impl(Bundle arg0, String key, T value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        arg0.putSerializable(key, value);
    }

    public static final void putLong-impl(Bundle arg0, String key, long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        arg0.putLong(key, value);
    }

    public static final void putLongArray-impl(Bundle arg0, String key, long[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        arg0.putLongArray(key, value);
    }

    public static final void putNull-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        arg0.putString(key, 0);
    }

    public static final <T extends android.os.Parcelable> void putParcelable-impl(Bundle arg0, String key, T value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        arg0.putParcelable(key, value);
    }

    public static final <T extends android.os.Parcelable> void putParcelableArray-impl(Bundle arg0, String key, T[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        arg0.putParcelableArray(key, value);
    }

    public static final <T extends android.os.Parcelable> void putParcelableList-impl(Bundle arg0, String key, List<? extends T> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        arg0.putParcelableArrayList(key, SavedStateWriterKt.toArrayListUnsafe((Collection)value));
    }

    public static final void putSavedState-impl(Bundle arg0, String key, Bundle value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        arg0.putBundle(key, value);
    }

    public static final void putSavedStateArray-impl(Bundle arg0, String key, Bundle[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        SavedStateWriter.putParcelableArray-impl(arg0, key, (Parcelable[])value);
    }

    public static final void putSavedStateList-impl(Bundle arg0, String key, List<Bundle> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        SavedStateWriter.putParcelableList-impl(arg0, key, value);
    }

    public static final void putSize-impl(Bundle arg0, String key, Size value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        arg0.putSize(key, value);
    }

    public static final void putSizeF-impl(Bundle arg0, String key, SizeF value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        arg0.putSizeF(key, value);
    }

    public static final <T extends android.os.Parcelable> void putSparseParcelableArray-impl(Bundle arg0, String key, SparseArray<T> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        arg0.putSparseParcelableArray(key, value);
    }

    public static final void putString-impl(Bundle arg0, String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        arg0.putString(key, value);
    }

    public static final void putStringArray-impl(Bundle arg0, String key, String[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        arg0.putStringArray(key, value);
    }

    public static final void putStringList-impl(Bundle arg0, String key, List<String> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        arg0.putStringArrayList(key, SavedStateWriterKt.toArrayListUnsafe((Collection)value));
    }

    public static final void remove-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        arg0.remove(key);
    }

    public static String toString-impl(Bundle bundle) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("SavedStateWriter(source=").append(bundle).append(')').toString();
    }

    public boolean equals(Object object) {
        return SavedStateWriter.equals-impl(this.source, object);
    }

    public int hashCode() {
        return SavedStateWriter.hashCode-impl(this.source);
    }

    public String toString() {
        return SavedStateWriter.toString-impl(this.source);
    }

    public final Bundle unbox-impl() {
        return this.source;
    }
}
