package androidx.compose.material3;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008g\u0018\u00002\u00020\u0001R&\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0001\u0010\u0002\u001a\u00020\u00038g@fX¦\u000e¢\u0006\u000c\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u0018\u0010\t\u001a\u00020\nX¦\u000e¢\u0006\u000c\u001a\u0004\u0008\t\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\u0018\u0010\u000e\u001a\u00020\nX¦\u000e¢\u0006\u000c\u001a\u0004\u0008\u000e\u0010\u000b\"\u0004\u0008\u000f\u0010\rR&\u0010\u0010\u001a\u00020\u00032\u0008\u0008\u0001\u0010\u0002\u001a\u00020\u00038g@fX¦\u000e¢\u0006\u000c\u001a\u0004\u0008\u0011\u0010\u0006\"\u0004\u0008\u0012\u0010\u0008R\u001e\u0010\u0013\u001a\u00020\u0014X¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008\u0015\u0010\u0006\"\u0004\u0008\u0016\u0010\u0008ø\u0001\u0002\u0082\u0002\u0011\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!\n\u0004\u0008!0\u0001¨\u0006\u0017À\u0006\u0001", d2 = {"Landroidx/compose/material3/TimePickerState;", "", "<set-?>", "", "hour", "getHour", "()I", "setHour", "(I)V", "is24hour", "", "()Z", "set24hour", "(Z)V", "isAfternoon", "setAfternoon", "minute", "getMinute", "setMinute", "selection", "Landroidx/compose/material3/TimePickerSelectionMode;", "getSelection-yecRtBI", "setSelection-6_8s6DQ", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface TimePickerState {
    public abstract int getHour();

    public abstract int getMinute();

    public abstract int getSelection-yecRtBI();

    public abstract boolean is24hour();

    public abstract boolean isAfternoon();

    public abstract void set24hour(boolean z);

    public abstract void setAfternoon(boolean z);

    public abstract void setHour(int i);

    public abstract void setMinute(int i);

    public abstract void setSelection-6_8s6DQ(int i);
}
