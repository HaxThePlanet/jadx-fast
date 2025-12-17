package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087@\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\u0008\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\u0008\u000c\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\u0008\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\u0008\u0014\u0010\u0015J/\u0010\u0016\u001a\u00020\u00172\u001d\u0010\u0018\u001a\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u001a\u0012\u0004\u0012\u00020\u00170\u0019¢\u0006\u0002\u0008\u001bH\u0086\u0008¢\u0006\u0004\u0008\u001c\u0010\u001dR\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0007\u0010\u0008\u0088\u0001\u0003\u0092\u0001\u00020\u0004¨\u0006\u001e", d2 = {"Landroidx/compose/runtime/SkippableUpdater;", "T", "", "composer", "Landroidx/compose/runtime/Composer;", "constructor-impl", "(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;", "getComposer$annotations", "()V", "equals", "", "other", "equals-impl", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Landroidx/compose/runtime/Composer;)I", "toString", "", "toString-impl", "(Landroidx/compose/runtime/Composer;)Ljava/lang/String;", "update", "", "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/Updater;", "Lkotlin/ExtensionFunctionType;", "update-impl", "(Landroidx/compose/runtime/Composer;Lkotlin/jvm/functions/Function1;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class SkippableUpdater<T>  {

    private final androidx.compose.runtime.Composer composer;
    private SkippableUpdater(androidx.compose.runtime.Composer composer) {
        super();
        this.composer = composer;
    }

    public static final androidx.compose.runtime.SkippableUpdater box-impl(androidx.compose.runtime.Composer composer) {
        SkippableUpdater skippableUpdater = new SkippableUpdater(composer);
        return skippableUpdater;
    }

    public static <T> androidx.compose.runtime.Composer constructor-impl(androidx.compose.runtime.Composer composer) {
        return composer;
    }

    public static boolean equals-impl(androidx.compose.runtime.Composer composer, Object object2) {
        final int i2 = 0;
        if (!object2 instanceof SkippableUpdater) {
            return i2;
        }
        if (!Intrinsics.areEqual(composer, (SkippableUpdater)object2.unbox-impl())) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(androidx.compose.runtime.Composer composer, androidx.compose.runtime.Composer composer2) {
        return Intrinsics.areEqual(composer, composer2);
    }

    public static void getComposer$annotations() {
    }

    public static int hashCode-impl(androidx.compose.runtime.Composer composer) {
        return composer.hashCode();
    }

    public static String toString-impl(androidx.compose.runtime.Composer composer) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("SkippableUpdater(composer=").append(composer).append(')').toString();
    }

    public static final void update-impl(androidx.compose.runtime.Composer arg0, Function1<? super androidx.compose.runtime.Updater<T>, Unit> block) {
        final int i = 0;
        arg0.startReplaceableGroup(509942095);
        block.invoke(Updater.box-impl(Updater.constructor-impl(arg0)));
        arg0.endReplaceableGroup();
    }

    public boolean equals(Object object) {
        return SkippableUpdater.equals-impl(this.composer, object);
    }

    public int hashCode() {
        return SkippableUpdater.hashCode-impl(this.composer);
    }

    public String toString() {
        return SkippableUpdater.toString-impl(this.composer);
    }

    public final androidx.compose.runtime.Composer unbox-impl() {
        return this.composer;
    }
}
