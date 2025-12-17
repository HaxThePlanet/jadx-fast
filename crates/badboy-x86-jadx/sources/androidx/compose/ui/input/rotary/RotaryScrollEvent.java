package androidx.compose.ui.input.rotary;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B'\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0014\u001a\u00020\u0008H\u0016J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000b¨\u0006\u0017", d2 = {"Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "", "verticalScrollPixels", "", "horizontalScrollPixels", "uptimeMillis", "", "inputDeviceId", "", "(FFJI)V", "getHorizontalScrollPixels", "()F", "getInputDeviceId", "()I", "getUptimeMillis", "()J", "getVerticalScrollPixels", "equals", "", "other", "hashCode", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RotaryScrollEvent {

    public static final int $stable;
    private final float horizontalScrollPixels;
    private final int inputDeviceId;
    private final long uptimeMillis;
    private final float verticalScrollPixels;
    static {
    }

    public RotaryScrollEvent(float verticalScrollPixels, float horizontalScrollPixels, long uptimeMillis, int inputDeviceId) {
        super();
        this.verticalScrollPixels = verticalScrollPixels;
        this.horizontalScrollPixels = horizontalScrollPixels;
        this.uptimeMillis = uptimeMillis;
        this.inputDeviceId = obj5;
    }

    public boolean equals(Object other) {
        int inputDeviceId;
        int i;
        int i2;
        int horizontalScrollPixels;
        long uptimeMillis;
        i = 0;
        if (other instanceof RotaryScrollEvent) {
            i2 = 1;
            inputDeviceId = Float.compare(verticalScrollPixels, verticalScrollPixels2) == 0 ? i2 : i;
            if (inputDeviceId != 0) {
                inputDeviceId = Float.compare(horizontalScrollPixels2, horizontalScrollPixels) == 0 ? i2 : i;
                if (inputDeviceId != 0 && Long.compare(horizontalScrollPixels, uptimeMillis) == 0 && obj4.inputDeviceId == this.inputDeviceId) {
                    if (Long.compare(horizontalScrollPixels, uptimeMillis) == 0) {
                        if (obj4.inputDeviceId == this.inputDeviceId) {
                            i = i2;
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public final float getHorizontalScrollPixels() {
        return this.horizontalScrollPixels;
    }

    public final int getInputDeviceId() {
        return this.inputDeviceId;
    }

    public final long getUptimeMillis() {
        return this.uptimeMillis;
    }

    public final float getVerticalScrollPixels() {
        return this.verticalScrollPixels;
    }

    public int hashCode() {
        int i = 0;
        int i4 = 0;
        int i5 = 0;
        int i2 = 0;
        int i3 = 0;
        return i10 += i14;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("RotaryScrollEvent(verticalScrollPixels=").append(this.verticalScrollPixels).append(",horizontalScrollPixels=").append(this.horizontalScrollPixels).append(",uptimeMillis=").append(this.uptimeMillis).append(",deviceId=").append(this.inputDeviceId).append(')').toString();
    }
}
