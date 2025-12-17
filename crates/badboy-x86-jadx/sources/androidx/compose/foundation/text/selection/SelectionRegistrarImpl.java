package androidx.compose.foundation.text.selection;

import androidx.collection.LongObjectMap;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008 \u0008\u0000\u0018\u0000 d2\u00020\u0001:\u0001dB\u0007\u0008\u0016¢\u0006\u0002\u0010\u0002B\u000f\u0008\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0008\u0010L\u001a\u00020\u0004H\u0016J\u0010\u0010M\u001a\u00020\r2\u0006\u0010N\u001a\u00020\u0004H\u0016J\u0010\u0010O\u001a\u00020\r2\u0006\u0010N\u001a\u00020\u0004H\u0016JB\u0010P\u001a\u00020\u001d2\u0006\u0010Q\u001a\u00020\u001e2\u0006\u0010R\u001a\u00020\u001f2\u0006\u0010S\u001a\u00020\u001f2\u0006\u0010T\u001a\u00020\u001d2\u0006\u0010U\u001a\u00020 2\u0006\u0010V\u001a\u00020\u001dH\u0016ø\u0001\u0000¢\u0006\u0004\u0008W\u0010XJ\u0008\u0010Y\u001a\u00020\rH\u0016J\u0018\u0010Z\u001a\u00020\r2\u0006\u0010N\u001a\u00020\u00042\u0006\u0010V\u001a\u00020\u001dH\u0016J2\u0010[\u001a\u00020\r2\u0006\u0010Q\u001a\u00020\u001e2\u0006\u0010\\\u001a\u00020\u001f2\u0006\u0010U\u001a\u00020 2\u0006\u0010V\u001a\u00020\u001dH\u0016ø\u0001\u0000¢\u0006\u0004\u0008]\u0010^J\u0014\u0010_\u001a\u0008\u0012\u0004\u0012\u00020\u00080<2\u0006\u0010`\u001a\u00020\u001eJ\u0010\u0010a\u001a\u00020\u00082\u0006\u0010b\u001a\u00020\u0008H\u0016J\u0010\u0010c\u001a\u00020\r2\u0006\u0010b\u001a\u00020\u0008H\u0016R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00080\nX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r\u0018\u00010\u000cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r\u0018\u00010\u000cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0016\u0010\u000f\"\u0004\u0008\u0017\u0010\u0011R(\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r\u0018\u00010\u000cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0019\u0010\u000f\"\u0004\u0008\u001a\u0010\u0011RF\u0010\u001b\u001a.\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008!\u0010\"\"\u0004\u0008#\u0010$R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010&X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008'\u0010(\"\u0004\u0008)\u0010*R.\u0010+\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r\u0018\u00010,X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008-\u0010.\"\u0004\u0008/\u00100R:\u00101\u001a\"\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\r\u0018\u000102X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00083\u00104\"\u0004\u00085\u00106R\u001a\u00107\u001a\u0008\u0012\u0004\u0012\u00020\u0008088@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u00089\u0010:R\u001a\u0010;\u001a\u0008\u0012\u0004\u0012\u00020\u00080<8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008=\u0010>R\u001a\u0010?\u001a\u00020\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008@\u0010A\"\u0004\u0008B\u0010CR7\u0010F\u001a\u0008\u0012\u0004\u0012\u00020E082\u000c\u0010D\u001a\u0008\u0012\u0004\u0012\u00020E088V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\u0008J\u0010K\u001a\u0004\u0008G\u0010:\"\u0004\u0008H\u0010I\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006e", d2 = {"Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "()V", "initialIncrementId", "", "(J)V", "_selectableMap", "Landroidx/collection/MutableLongObjectMap;", "Landroidx/compose/foundation/text/selection/Selectable;", "_selectables", "", "afterSelectableUnsubscribe", "Lkotlin/Function1;", "", "getAfterSelectableUnsubscribe$foundation_release", "()Lkotlin/jvm/functions/Function1;", "setAfterSelectableUnsubscribe$foundation_release", "(Lkotlin/jvm/functions/Function1;)V", "incrementId", "Ljava/util/concurrent/atomic/AtomicLong;", "Landroidx/compose/foundation/AtomicLong;", "onPositionChangeCallback", "getOnPositionChangeCallback$foundation_release", "setOnPositionChangeCallback$foundation_release", "onSelectableChangeCallback", "getOnSelectableChangeCallback$foundation_release", "setOnSelectableChangeCallback$foundation_release", "onSelectionUpdateCallback", "Lkotlin/Function6;", "", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "getOnSelectionUpdateCallback$foundation_release", "()Lkotlin/jvm/functions/Function6;", "setOnSelectionUpdateCallback$foundation_release", "(Lkotlin/jvm/functions/Function6;)V", "onSelectionUpdateEndCallback", "Lkotlin/Function0;", "getOnSelectionUpdateEndCallback$foundation_release", "()Lkotlin/jvm/functions/Function0;", "setOnSelectionUpdateEndCallback$foundation_release", "(Lkotlin/jvm/functions/Function0;)V", "onSelectionUpdateSelectAll", "Lkotlin/Function2;", "getOnSelectionUpdateSelectAll$foundation_release", "()Lkotlin/jvm/functions/Function2;", "setOnSelectionUpdateSelectAll$foundation_release", "(Lkotlin/jvm/functions/Function2;)V", "onSelectionUpdateStartCallback", "Lkotlin/Function4;", "getOnSelectionUpdateStartCallback$foundation_release", "()Lkotlin/jvm/functions/Function4;", "setOnSelectionUpdateStartCallback$foundation_release", "(Lkotlin/jvm/functions/Function4;)V", "selectableMap", "Landroidx/collection/LongObjectMap;", "getSelectableMap$foundation_release", "()Landroidx/collection/LongObjectMap;", "selectables", "", "getSelectables$foundation_release", "()Ljava/util/List;", "sorted", "getSorted$foundation_release", "()Z", "setSorted$foundation_release", "(Z)V", "<set-?>", "Landroidx/compose/foundation/text/selection/Selection;", "subselections", "getSubselections", "setSubselections", "(Landroidx/collection/LongObjectMap;)V", "subselections$delegate", "Landroidx/compose/runtime/MutableState;", "nextSelectableId", "notifyPositionChange", "selectableId", "notifySelectableChange", "notifySelectionUpdate", "layoutCoordinates", "newPosition", "previousPosition", "isStartHandle", "adjustment", "isInTouchMode", "notifySelectionUpdate-njBpvok", "(Landroidx/compose/ui/layout/LayoutCoordinates;JJZLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)Z", "notifySelectionUpdateEnd", "notifySelectionUpdateSelectAll", "notifySelectionUpdateStart", "startPosition", "notifySelectionUpdateStart-ubNVwUQ", "(Landroidx/compose/ui/layout/LayoutCoordinates;JLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)V", "sort", "containerLayoutCoordinates", "subscribe", "selectable", "unsubscribe", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SelectionRegistrarImpl implements androidx.compose.foundation.text.selection.SelectionRegistrar {

    public static final int $stable = 8;
    public static final androidx.compose.foundation.text.selection.SelectionRegistrarImpl.Companion Companion;
    private static final Saver<androidx.compose.foundation.text.selection.SelectionRegistrarImpl, Long> Saver;
    private final MutableLongObjectMap<androidx.compose.foundation.text.selection.Selectable> _selectableMap;
    private final List<androidx.compose.foundation.text.selection.Selectable> _selectables;
    private Function1<? super Long, Unit> afterSelectableUnsubscribe;
    private AtomicLong incrementId;
    private Function1<? super Long, Unit> onPositionChangeCallback;
    private Function1<? super Long, Unit> onSelectableChangeCallback;
    private Function6<? super Boolean, ? super LayoutCoordinates, ? super Offset, ? super Offset, ? super Boolean, ? super androidx.compose.foundation.text.selection.SelectionAdjustment, Boolean> onSelectionUpdateCallback;
    private Function0<Unit> onSelectionUpdateEndCallback;
    private Function2<? super Boolean, ? super Long, Unit> onSelectionUpdateSelectAll;
    private Function4<? super Boolean, ? super LayoutCoordinates, ? super Offset, ? super androidx.compose.foundation.text.selection.SelectionAdjustment, Unit> onSelectionUpdateStartCallback;
    private boolean sorted;
    private final MutableState subselections$delegate;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\t", d2 = {"Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;", "", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Saver<androidx.compose.foundation.text.selection.SelectionRegistrarImpl, Long> getSaver() {
            return SelectionRegistrarImpl.access$getSaver$cp();
        }
    }
    public static int $r8$lambda$dpnOI5tFKRQkFSVXxW6mS6uMcAk(Function2 function2, Object object2, Object object3) {
        return SelectionRegistrarImpl.sort$lambda$2(function2, object2, object3);
    }

    static {
        SelectionRegistrarImpl.Companion companion = new SelectionRegistrarImpl.Companion(0);
        SelectionRegistrarImpl.Companion = companion;
        int i = 8;
        SelectionRegistrarImpl.Saver = SaverKt.Saver((Function2)SelectionRegistrarImpl.Companion.Saver.1.INSTANCE, (Function1)SelectionRegistrarImpl.Companion.Saver.2.INSTANCE);
    }

    public SelectionRegistrarImpl() {
        super(1, obj1);
    }

    private SelectionRegistrarImpl(long initialIncrementId) {
        super();
        ArrayList arrayList = new ArrayList();
        this._selectables = (List)arrayList;
        this._selectableMap = LongObjectMapKt.mutableLongObjectMapOf();
        AtomicLong atomicLong = new AtomicLong(initialIncrementId, obj5);
        this.incrementId = atomicLong;
        final int i = 0;
        this.subselections$delegate = SnapshotStateKt.mutableStateOf$default(LongObjectMapKt.emptyLongObjectMap(), i, 2, i);
    }

    public SelectionRegistrarImpl(long l, DefaultConstructorMarker defaultConstructorMarker2) {
        super(l, defaultConstructorMarker2);
    }

    public static final AtomicLong access$getIncrementId$p(androidx.compose.foundation.text.selection.SelectionRegistrarImpl $this) {
        return $this.incrementId;
    }

    public static final Saver access$getSaver$cp() {
        return SelectionRegistrarImpl.Saver;
    }

    private static final int sort$lambda$2(Function2 $tmp0, Object p0, Object p1) {
        return (Number)$tmp0.invoke(p0, p1).intValue();
    }

    public final Function1<Long, Unit> getAfterSelectableUnsubscribe$foundation_release() {
        return this.afterSelectableUnsubscribe;
    }

    public final Function1<Long, Unit> getOnPositionChangeCallback$foundation_release() {
        return this.onPositionChangeCallback;
    }

    public final Function1<Long, Unit> getOnSelectableChangeCallback$foundation_release() {
        return this.onSelectableChangeCallback;
    }

    public final Function6<Boolean, LayoutCoordinates, Offset, Offset, Boolean, androidx.compose.foundation.text.selection.SelectionAdjustment, Boolean> getOnSelectionUpdateCallback$foundation_release() {
        return this.onSelectionUpdateCallback;
    }

    public final Function0<Unit> getOnSelectionUpdateEndCallback$foundation_release() {
        return this.onSelectionUpdateEndCallback;
    }

    public final Function2<Boolean, Long, Unit> getOnSelectionUpdateSelectAll$foundation_release() {
        return this.onSelectionUpdateSelectAll;
    }

    public final Function4<Boolean, LayoutCoordinates, Offset, androidx.compose.foundation.text.selection.SelectionAdjustment, Unit> getOnSelectionUpdateStartCallback$foundation_release() {
        return this.onSelectionUpdateStartCallback;
    }

    public final LongObjectMap<androidx.compose.foundation.text.selection.Selectable> getSelectableMap$foundation_release() {
        return (LongObjectMap)this._selectableMap;
    }

    public final List<androidx.compose.foundation.text.selection.Selectable> getSelectables$foundation_release() {
        return this._selectables;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public final boolean getSorted$foundation_release() {
        return this.sorted;
    }

    public LongObjectMap<androidx.compose.foundation.text.selection.Selection> getSubselections() {
        final int i = 0;
        final int i2 = 0;
        return (LongObjectMap)(State)this.subselections$delegate.getValue();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public long nextSelectableId() {
        long id;
        AtomicLong incrementId;
        id = this.incrementId.getAndIncrement();
        while (Long.compare(id, i) == 0) {
            id = this.incrementId.getAndIncrement();
        }
        return id;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void notifyPositionChange(long selectableId) {
        Long valueOf;
        this.sorted = false;
        Function1 onPositionChangeCallback = this.onPositionChangeCallback;
        if (onPositionChangeCallback != null) {
            onPositionChangeCallback.invoke(Long.valueOf(selectableId));
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void notifySelectableChange(long selectableId) {
        Long valueOf;
        final Function1 onSelectableChangeCallback = this.onSelectableChangeCallback;
        if (onSelectableChangeCallback != null) {
            onSelectableChangeCallback.invoke(Long.valueOf(selectableId));
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public boolean notifySelectionUpdate-njBpvok(LayoutCoordinates layoutCoordinates, long newPosition, long previousPosition, boolean isStartHandle, androidx.compose.foundation.text.selection.SelectionAdjustment adjustment, boolean isInTouchMode) {
        Boolean valueOf;
        Object layoutCoordinates2;
        Offset box-impl;
        Offset box-impl2;
        Boolean valueOf2;
        Object obj;
        boolean obj8;
        final Function6 onSelectionUpdateCallback = this.onSelectionUpdateCallback;
        if (onSelectionUpdateCallback != null) {
            obj8 = (Boolean)onSelectionUpdateCallback.invoke(Boolean.valueOf(obj15), layoutCoordinates, Offset.box-impl(newPosition), Offset.box-impl(isStartHandle), Boolean.valueOf(isInTouchMode), obj14).booleanValue();
        } else {
            layoutCoordinates2 = layoutCoordinates;
            obj = obj14;
            obj8 = 1;
        }
        return obj8;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void notifySelectionUpdateEnd() {
        final Function0 onSelectionUpdateEndCallback = this.onSelectionUpdateEndCallback;
        if (onSelectionUpdateEndCallback != null) {
            onSelectionUpdateEndCallback.invoke();
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void notifySelectionUpdateSelectAll(long selectableId, boolean isInTouchMode) {
        Boolean valueOf2;
        Long valueOf;
        final Function2 onSelectionUpdateSelectAll = this.onSelectionUpdateSelectAll;
        if (onSelectionUpdateSelectAll != null) {
            onSelectionUpdateSelectAll.invoke(Boolean.valueOf(obj6), Long.valueOf(selectableId));
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void notifySelectionUpdateStart-ubNVwUQ(LayoutCoordinates layoutCoordinates, long startPosition, androidx.compose.foundation.text.selection.SelectionAdjustment adjustment, boolean isInTouchMode) {
        Boolean valueOf;
        Offset box-impl;
        final Function4 onSelectionUpdateStartCallback = this.onSelectionUpdateStartCallback;
        if (onSelectionUpdateStartCallback != null) {
            onSelectionUpdateStartCallback.invoke(Boolean.valueOf(obj8), layoutCoordinates, Offset.box-impl(startPosition), isInTouchMode);
        }
    }

    public final void setAfterSelectableUnsubscribe$foundation_release(Function1<? super Long, Unit> <set-?>) {
        this.afterSelectableUnsubscribe = <set-?>;
    }

    public final void setOnPositionChangeCallback$foundation_release(Function1<? super Long, Unit> <set-?>) {
        this.onPositionChangeCallback = <set-?>;
    }

    public final void setOnSelectableChangeCallback$foundation_release(Function1<? super Long, Unit> <set-?>) {
        this.onSelectableChangeCallback = <set-?>;
    }

    public final void setOnSelectionUpdateCallback$foundation_release(Function6<? super Boolean, ? super LayoutCoordinates, ? super Offset, ? super Offset, ? super Boolean, ? super androidx.compose.foundation.text.selection.SelectionAdjustment, Boolean> <set-?>) {
        this.onSelectionUpdateCallback = <set-?>;
    }

    public final void setOnSelectionUpdateEndCallback$foundation_release(Function0<Unit> <set-?>) {
        this.onSelectionUpdateEndCallback = <set-?>;
    }

    public final void setOnSelectionUpdateSelectAll$foundation_release(Function2<? super Boolean, ? super Long, Unit> <set-?>) {
        this.onSelectionUpdateSelectAll = <set-?>;
    }

    public final void setOnSelectionUpdateStartCallback$foundation_release(Function4<? super Boolean, ? super LayoutCoordinates, ? super Offset, ? super androidx.compose.foundation.text.selection.SelectionAdjustment, Unit> <set-?>) {
        this.onSelectionUpdateStartCallback = <set-?>;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public final void setSorted$foundation_release(boolean <set-?>) {
        this.sorted = <set-?>;
    }

    public void setSubselections(LongObjectMap<androidx.compose.foundation.text.selection.Selection> <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.subselections$delegate.setValue(<set-?>);
    }

    public final List<androidx.compose.foundation.text.selection.Selectable> sort(LayoutCoordinates containerLayoutCoordinates) {
        boolean sorted;
        androidx.compose.foundation.text.selection.SelectionRegistrarImpl.sort.1 anon;
        androidx.compose.foundation.text.selection.SelectionRegistrarImpl$$ExternalSyntheticLambda0 externalSyntheticLambda0;
        if (!this.sorted) {
            anon = new SelectionRegistrarImpl.sort.1(containerLayoutCoordinates);
            externalSyntheticLambda0 = new SelectionRegistrarImpl$$ExternalSyntheticLambda0((Function2)anon);
            CollectionsKt.sortWith(this._selectables, externalSyntheticLambda0);
            this.sorted = true;
        }
        return getSelectables$foundation_release();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public androidx.compose.foundation.text.selection.Selectable subscribe(androidx.compose.foundation.text.selection.Selectable selectable) {
        int i;
        int i4 = 0;
        i = Long.compare(selectableId, i5) != 0 ? 1 : i4;
        if (i == 0) {
        } else {
            if (this._selectableMap.containsKey(selectable.getSelectableId())) {
            } else {
                this._selectableMap.set(selectable.getSelectableId(), obj3);
                this._selectables.add(selectable);
                this.sorted = i4;
                return selectable;
            }
            int i3 = 0;
            StringBuilder stringBuilder2 = new StringBuilder();
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.append("Another selectable with the id: ").append(selectable).append(".selectableId has already subscribed.").toString().toString());
            throw illegalArgumentException2;
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("The selectable contains an invalid id: ").append(selectable.getSelectableId()).toString().toString());
        throw illegalArgumentException;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void unsubscribe(androidx.compose.foundation.text.selection.Selectable selectable) {
        long selectableId;
        if (!this._selectableMap.containsKey(selectable.getSelectableId())) {
        }
        this._selectables.remove(selectable);
        this._selectableMap.remove(selectable.getSelectableId());
        Function1 afterSelectableUnsubscribe = this.afterSelectableUnsubscribe;
        if (afterSelectableUnsubscribe != null) {
            afterSelectableUnsubscribe.invoke(Long.valueOf(selectable.getSelectableId()));
        }
    }
}
