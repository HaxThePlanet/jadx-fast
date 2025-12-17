package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.i;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0010\n\u0002\u0010\u0015\n\u0002\u0008\t\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\u0008\"\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J \u0010\u0008\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0086\u0002¢\u0006\u0004\u0008\u0008\u0010\tJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0086\u0002¢\u0006\u0004\u0008\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\u0008\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0005¢\u0006\u0004\u0008\u0014\u0010\u0010J\u0015\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\u0008\u0015\u0010\u000eJ\u0015\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\u0008\u0016\u0010\u000eJ\u0015\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019R\u0016\u0010\u0008\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0008\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001c\u0010\u001dR\u0013\u0010\u001f\u001a\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u0010R\u0013\u0010!\u001a\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\u0008 \u0010\u0010¨\u0006$", d2 = {"Lokhttp3/internal/http2/Settings;", "", "Lkotlin/w;", "clear", "()V", "", "id", "value", "set", "(II)Lokhttp3/internal/http2/Settings;", "", "isSet", "(I)Z", "get", "(I)I", "size", "()I", "defaultValue", "getEnablePush", "(Z)Z", "getMaxConcurrentStreams", "getMaxFrameSize", "getMaxHeaderListSize", "other", "merge", "(Lokhttp3/internal/http2/Settings;)V", "I", "", "values", "[I", "getHeaderTableSize", "headerTableSize", "getInitialWindowSize", "initialWindowSize", "<init>", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Settings {

    public static final int COUNT = 10;
    public static final okhttp3.internal.http2.Settings.Companion Companion = null;
    public static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
    public static final int ENABLE_PUSH = 2;
    public static final int HEADER_TABLE_SIZE = 1;
    public static final int INITIAL_WINDOW_SIZE = 7;
    public static final int MAX_CONCURRENT_STREAMS = 4;
    public static final int MAX_FRAME_SIZE = 5;
    public static final int MAX_HEADER_LIST_SIZE = 6;
    private int set;
    private final int[] values;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u000c\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u000c\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0007\u0010\u0004R\u0016\u0010\u0008\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0008\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u000b\u0010\u0004¨\u0006\u000e", d2 = {"Lokhttp3/internal/http2/Settings$Companion;", "", "", "COUNT", "I", "DEFAULT_INITIAL_WINDOW_SIZE", "ENABLE_PUSH", "HEADER_TABLE_SIZE", "INITIAL_WINDOW_SIZE", "MAX_CONCURRENT_STREAMS", "MAX_FRAME_SIZE", "MAX_HEADER_LIST_SIZE", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }
    }
    static {
        Settings.Companion companion = new Settings.Companion(0);
        Settings.Companion = companion;
    }

    public Settings() {
        super();
        this.values = new int[10];
    }

    public final void clear() {
        this.set = 0;
        i.m(this.values, 0, 0, 0, 6, 0);
    }

    public final int get(int i) {
        return this.values[i];
    }

    public final boolean getEnablePush(boolean z) {
        int i;
        int obj3;
        final int i2 = 1;
        if (set &= 4 != 0) {
            obj3 = this.values[2] == i2 ? i2 : 0;
        }
        return obj3;
    }

    public final int getHeaderTableSize() {
        int i2;
        int i;
        if (set &= 2 != 0) {
            i2 = this.values[1];
        } else {
            i2 = -1;
        }
        return i2;
    }

    public final int getInitialWindowSize() {
        int i2;
        int i;
        if (set &= 128 != 0) {
            i2 = this.values[7];
        } else {
            i2 = 65535;
        }
        return i2;
    }

    public final int getMaxConcurrentStreams() {
        int i;
        int i2;
        if (set &= 16 != 0) {
            i = this.values[4];
        } else {
            i = Integer.MAX_VALUE;
        }
        return i;
    }

    public final int getMaxFrameSize(int i) {
        int i2;
        int obj2;
        if (set &= 32 != 0) {
            obj2 = this.values[5];
        }
        return obj2;
    }

    public final int getMaxHeaderListSize(int i) {
        int i2;
        int obj2;
        if (set &= 64 != 0) {
            obj2 = this.values[6];
        }
        return obj2;
    }

    public final boolean isSet(int i) {
        int i2;
        if (obj3 &= set != null) {
        } else {
            i2 = 0;
        }
        return i2;
    }

    public final void merge(okhttp3.internal.http2.Settings settings) {
        int i;
        boolean set;
        n.f(settings, "other");
        i = 0;
        while (i < 10) {
            if (!settings.isSet(i)) {
            } else {
            }
            set(i, settings.get(i));
            i++;
        }
    }

    public final okhttp3.internal.http2.Settings set(int i, int i2) {
        int[] values;
        int length;
        int set;
        if (i >= 0) {
            values = this.values;
            if (i >= values.length) {
            } else {
                this.set = i4 |= set;
                values[i] = i2;
            }
        }
        return this;
    }

    public final int size() {
        return Integer.bitCount(this.set);
    }
}
