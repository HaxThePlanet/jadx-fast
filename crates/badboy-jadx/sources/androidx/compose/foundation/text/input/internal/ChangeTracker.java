package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.TextFieldBuffer.ChangeList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0008\u0000\u0018\u00002\u00020\u0001:\u0001 B\u0011\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0003J*\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0006\u0010\u0012\u001a\u00020\rJ\u001d\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0016\u0010\u0017J\u001d\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0019\u0010\u0017J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016J\u001e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tR\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0008\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000b\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006!", d2 = {"Landroidx/compose/foundation/text/input/internal/ChangeTracker;", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "initialChanges", "(Landroidx/compose/foundation/text/input/internal/ChangeTracker;)V", "_changes", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/text/input/internal/ChangeTracker$Change;", "_changesTemp", "changeCount", "", "getChangeCount", "()I", "appendNewChange", "", "mergedOverlappingChange", "preMin", "preMax", "postDelta", "clearChanges", "getOriginalRange", "Landroidx/compose/ui/text/TextRange;", "changeIndex", "getOriginalRange--jx7JFs", "(I)J", "getRange", "getRange--jx7JFs", "toString", "", "trackChange", "preStart", "preEnd", "postLength", "Change", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ChangeTracker implements TextFieldBuffer.ChangeList {

    public static final int $stable = 8;
    private MutableVector<androidx.compose.foundation.text.input.internal.ChangeTracker.Change> _changes;
    private MutableVector<androidx.compose.foundation.text.input.internal.ChangeTracker.Change> _changesTemp;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0014\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0008\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\t\"\u0004\u0008\r\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\t\"\u0004\u0008\u000f\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0010\u0010\t\"\u0004\u0008\u0011\u0010\u000b¨\u0006\u001d", d2 = {"Landroidx/compose/foundation/text/input/internal/ChangeTracker$Change;", "", "preStart", "", "preEnd", "originalStart", "originalEnd", "(IIII)V", "getOriginalEnd", "()I", "setOriginalEnd", "(I)V", "getOriginalStart", "setOriginalStart", "getPreEnd", "setPreEnd", "getPreStart", "setPreStart", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Change {

        private int originalEnd;
        private int originalStart;
        private int preEnd;
        private int preStart;
        public Change(int preStart, int preEnd, int originalStart, int originalEnd) {
            super();
            this.preStart = preStart;
            this.preEnd = preEnd;
            this.originalStart = originalStart;
            this.originalEnd = originalEnd;
        }

        public static androidx.compose.foundation.text.input.internal.ChangeTracker.Change copy$default(androidx.compose.foundation.text.input.internal.ChangeTracker.Change changeTracker$Change, int i2, int i3, int i4, int i5, int i6, Object object7) {
            int obj1;
            int obj2;
            int obj3;
            int obj4;
            if (i6 & 1 != 0) {
                obj1 = change.preStart;
            }
            if (i6 & 2 != 0) {
                obj2 = change.preEnd;
            }
            if (i6 & 4 != 0) {
                obj3 = change.originalStart;
            }
            if (i6 &= 8 != 0) {
                obj4 = change.originalEnd;
            }
            return change.copy(obj1, obj2, obj3, obj4);
        }

        public final int component1() {
            return this.preStart;
        }

        public final int component2() {
            return this.preEnd;
        }

        public final int component3() {
            return this.originalStart;
        }

        public final int component4() {
            return this.originalEnd;
        }

        public final androidx.compose.foundation.text.input.internal.ChangeTracker.Change copy(int i, int i2, int i3, int i4) {
            ChangeTracker.Change change = new ChangeTracker.Change(i, i2, i3, i4);
            return change;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof ChangeTracker.Change) {
                return i2;
            }
            Object obj = object;
            if (this.preStart != obj.preStart) {
                return i2;
            }
            if (this.preEnd != obj.preEnd) {
                return i2;
            }
            if (this.originalStart != obj.originalStart) {
                return i2;
            }
            if (this.originalEnd != obj.originalEnd) {
                return i2;
            }
            return i;
        }

        public final int getOriginalEnd() {
            return this.originalEnd;
        }

        public final int getOriginalStart() {
            return this.originalStart;
        }

        public final int getPreEnd() {
            return this.preEnd;
        }

        public final int getPreStart() {
            return this.preStart;
        }

        public int hashCode() {
            return i6 += i10;
        }

        public final void setOriginalEnd(int <set-?>) {
            this.originalEnd = <set-?>;
        }

        public final void setOriginalStart(int <set-?>) {
            this.originalStart = <set-?>;
        }

        public final void setPreEnd(int <set-?>) {
            this.preEnd = <set-?>;
        }

        public final void setPreStart(int <set-?>) {
            this.preStart = <set-?>;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("Change(preStart=").append(this.preStart).append(", preEnd=").append(this.preEnd).append(", originalStart=").append(this.originalStart).append(", originalEnd=").append(this.originalEnd).append(')').toString();
        }
    }
    static {
        final int i = 8;
    }

    public ChangeTracker() {
        final int i = 0;
        super(i, 1, i);
    }

    public ChangeTracker(androidx.compose.foundation.text.input.internal.ChangeTracker initialChanges) {
        int _changes;
        int i4;
        int size;
        int i$iv;
        androidx.compose.foundation.text.input.internal.ChangeTracker.Change[] content;
        int i;
        int i3;
        MutableVector _changes2;
        androidx.compose.foundation.text.input.internal.ChangeTracker.Change change;
        int i2;
        int preEnd;
        int originalStart;
        int originalEnd;
        super();
        int i5 = 0;
        int i7 = 0;
        i = 0;
        MutableVector mutableVector = new MutableVector(new ChangeTracker.Change[16], i);
        this._changes = mutableVector;
        _changes = 0;
        size = 0;
        i$iv = new MutableVector(new ChangeTracker.Change[16], i);
        this._changesTemp = i$iv;
        _changes = initialChanges._changes;
        i4 = 0;
        size = _changes.getSize();
        if (initialChanges != null && _changes != null && size > 0) {
            _changes = initialChanges._changes;
            if (_changes != null) {
                i4 = 0;
                size = _changes.getSize();
                if (size > 0) {
                    i$iv = 0;
                    i = _changes.getContent()[i$iv];
                    i3 = 0;
                    change = new ChangeTracker.Change((ChangeTracker.Change)i.getPreStart(), i.getPreEnd(), i.getOriginalStart(), i.getOriginalEnd());
                    i2 = 0;
                    this._changes.add(change);
                    while (i$iv++ >= size) {
                        i = content[i$iv];
                        i3 = 0;
                        change = new ChangeTracker.Change((ChangeTracker.Change)i.getPreStart(), i.getPreEnd(), i.getOriginalStart(), i.getOriginalEnd());
                        i2 = 0;
                        this._changes.add(change);
                    }
                }
            }
        }
    }

    public ChangeTracker(androidx.compose.foundation.text.input.internal.ChangeTracker changeTracker, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    private final void appendNewChange(androidx.compose.foundation.text.input.internal.ChangeTracker.Change mergedOverlappingChange, int preMin, int preMax, int postDelta) {
        int it;
        int i;
        int i2;
        int preEnd;
        int originalEnd;
        int originalEnd2;
        androidx.compose.foundation.text.input.internal.ChangeTracker.Change newChange;
        int i3;
        if (this._changesTemp.isEmpty()) {
            it = 0;
        } else {
            Object last = this._changesTemp.last();
            i = 0;
            it = originalEnd - originalEnd2;
        }
        i2 = 0;
        if (mergedOverlappingChange == null) {
            originalEnd = preMin - it;
            newChange = new ChangeTracker.Change(preMin, preMax + postDelta, originalEnd, i6 += originalEnd);
        } else {
            newChange = mergedOverlappingChange;
            if (newChange.getPreStart() > preMin) {
                newChange.setPreStart(preMin);
                newChange.setOriginalStart(preMin);
            }
            if (preMax > newChange.getPreEnd()) {
                preEnd3 -= originalEnd;
                newChange.setPreEnd(preMax);
                newChange.setOriginalEnd(preMax - preEnd);
                it = preEnd;
            }
            newChange.setPreEnd(preEnd2 += postDelta);
        }
        int i5 = 0;
        this._changesTemp.add(newChange);
    }

    @Override // androidx.compose.foundation.text.input.TextFieldBuffer$ChangeList
    public final void clearChanges() {
        this._changes.clear();
    }

    @Override // androidx.compose.foundation.text.input.TextFieldBuffer$ChangeList
    public int getChangeCount() {
        return this._changes.getSize();
    }

    @Override // androidx.compose.foundation.text.input.TextFieldBuffer$ChangeList
    public long getOriginalRange--jx7JFs(int changeIndex) {
        int i = 0;
        Object this_$iv = this._changes.getContent()[changeIndex];
        int i2 = 0;
        return TextRangeKt.TextRange((ChangeTracker.Change)this_$iv.getOriginalStart(), this_$iv.getOriginalEnd());
    }

    @Override // androidx.compose.foundation.text.input.TextFieldBuffer$ChangeList
    public long getRange--jx7JFs(int changeIndex) {
        int i = 0;
        Object this_$iv = this._changes.getContent()[changeIndex];
        int i2 = 0;
        return TextRangeKt.TextRange((ChangeTracker.Change)this_$iv.getPreStart(), this_$iv.getPreEnd());
    }

    @Override // androidx.compose.foundation.text.input.TextFieldBuffer$ChangeList
    public String toString() {
        int i$iv;
        Object[] content;
        Object obj;
        int i;
        int i3;
        int str;
        int i2;
        int preStart;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder sb = stringBuilder;
        final int i4 = 0;
        sb.append("ChangeList(changes=[");
        MutableVector _changes = this._changes;
        final int i5 = 0;
        final int size = _changes.getSize();
        if (size > 0) {
            i$iv = 0;
            obj = _changes.getContent()[i$iv];
            i3 = 0;
            StringBuilder stringBuilder2 = new StringBuilder();
            int i7 = 44;
            sb.append(stringBuilder2.append('(').append((ChangeTracker.Change)obj.getOriginalStart()).append(i7).append(obj.getOriginalEnd()).append(")->(").append(obj.getPreStart()).append(i7).append(obj.getPreEnd()).append(')').toString());
            do {
                obj = content[i$iv];
                i3 = 0;
                stringBuilder2 = new StringBuilder();
                i7 = 44;
                sb.append(stringBuilder2.append('(').append((ChangeTracker.Change)obj.getOriginalStart()).append(i7).append(obj.getOriginalEnd()).append(")->(").append(obj.getPreStart()).append(i7).append(obj.getPreEnd()).append(')').toString());
                if (i$iv++ < size) {
                }
                sb.append(", ");
            } while (i$iv < changeCount--);
        }
        sb.append("])");
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // androidx.compose.foundation.text.input.TextFieldBuffer$ChangeList
    public final void trackChange(int preStart, int preEnd, int postLength) {
        int i;
        int recordedNewChange;
        int mergedOverlappingChange;
        Object this_$iv;
        int _changesTemp;
        int preStart2;
        int i3;
        int i2;
        if (preStart == preEnd && postLength == 0) {
            if (postLength == 0) {
            }
        }
        final int i4 = Math.min(preStart, preEnd);
        final int i5 = Math.max(preStart, preEnd);
        i = 0;
        recordedNewChange = 0;
        int i7 = postLength - i6;
        mergedOverlappingChange = 0;
        while (i < this._changes.getSize()) {
            int i8 = 0;
            this_$iv = this._changes.getContent()[i];
            int preStart3 = (ChangeTracker.Change)this_$iv.getPreStart();
            i2 = 0;
            if (i4 <= preStart3 && preStart3 <= i5) {
            } else {
            }
            _changesTemp = i2;
            if (_changesTemp == 0) {
            } else {
            }
            if (mergedOverlappingChange == 0) {
            } else {
            }
            mergedOverlappingChange.setPreEnd(this_$iv.getPreEnd());
            mergedOverlappingChange.setOriginalEnd(this_$iv.getOriginalEnd());
            i++;
            mergedOverlappingChange = this_$iv;
            _changesTemp = this_$iv.getPreEnd();
            if (i4 <= _changesTemp && _changesTemp <= i5) {
            } else {
            }
            i3 = i2;
            if (i3 != 0) {
            } else {
            }
            if (this_$iv.getPreStart() > i5 && recordedNewChange == 0) {
            }
            if (recordedNewChange != 0) {
            }
            i3 = 0;
            this._changesTemp.add(this_$iv);
            i++;
            this_$iv.setPreStart(preStart4 += i7);
            this_$iv.setPreEnd(preEnd3 += i7);
            if (recordedNewChange == 0) {
            }
            appendNewChange(mergedOverlappingChange, i4, i5, i7);
            recordedNewChange = 1;
            if (_changesTemp <= i5) {
            } else {
            }
            if (preStart3 <= i5) {
            } else {
            }
            _changesTemp = i3;
        }
        if (recordedNewChange == 0) {
            appendNewChange(mergedOverlappingChange, i4, i5, i7);
        }
        this._changes = this._changesTemp;
        this._changesTemp = this._changes;
        this._changesTemp.clear();
    }
}
