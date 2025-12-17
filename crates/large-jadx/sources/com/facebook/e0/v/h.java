package com.facebook.e0.v;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.facebook.o;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u0000 &2\u00020\u0001:\u0001&B%\u0008\u0007\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020$R \u0010\u0008\u001a\u0004\u0018\u00010\u00038FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\u0008\u0017\u0010\n\"\u0004\u0008\u0018\u0010\u000cR\u0011\u0010\u0019\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u001bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\u0008\u001c\u0010\nR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001f\u0010 \"\u0004\u0008!\u0010\"¨\u0006'", d2 = {"Lcom/facebook/appevents/internal/SessionInfo;", "", "sessionStartTime", "", "sessionLastEventTime", "sessionId", "Ljava/util/UUID;", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/util/UUID;)V", "diskRestoreTime", "getDiskRestoreTime", "()Ljava/lang/Long;", "setDiskRestoreTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "<set-?>", "", "interruptionCount", "getInterruptionCount", "()I", "getSessionId", "()Ljava/util/UUID;", "setSessionId", "(Ljava/util/UUID;)V", "getSessionLastEventTime", "setSessionLastEventTime", "sessionLength", "getSessionLength", "()J", "getSessionStartTime", "sourceApplicationInfo", "Lcom/facebook/appevents/internal/SourceApplicationInfo;", "getSourceApplicationInfo", "()Lcom/facebook/appevents/internal/SourceApplicationInfo;", "setSourceApplicationInfo", "(Lcom/facebook/appevents/internal/SourceApplicationInfo;)V", "incrementInterruptionCount", "", "writeSessionToDisk", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class h {

    public static final com.facebook.e0.v.h.a g;
    private int a;
    private Long b;
    private com.facebook.e0.v.j c;
    private final Long d;
    private Long e;
    private UUID f;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0008\u001a\u00020\tH\u0007J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Lcom/facebook/appevents/internal/SessionInfo$Companion;", "", "()V", "INTERRUPTION_COUNT_KEY", "", "LAST_SESSION_INFO_END_KEY", "LAST_SESSION_INFO_START_KEY", "SESSION_ID_KEY", "clearSavedSessionFromDisk", "", "getStoredSessionInfo", "Lcom/facebook/appevents/internal/SessionInfo;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public final void a() {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(o.f()).edit();
            edit.remove("com.facebook.appevents.SessionInfo.sessionStartTime");
            edit.remove("com.facebook.appevents.SessionInfo.sessionEndTime");
            edit.remove("com.facebook.appevents.SessionInfo.interruptionCount");
            edit.remove("com.facebook.appevents.SessionInfo.sessionId");
            edit.apply();
            j.c.a();
        }

        public final com.facebook.e0.v.h b() {
            int cmp;
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(o.f());
            cmp = 0;
            long long = defaultSharedPreferences.getLong("com.facebook.appevents.SessionInfo.sessionStartTime", cmp);
            final long long2 = defaultSharedPreferences.getLong("com.facebook.appevents.SessionInfo.sessionEndTime", cmp);
            final int i2 = 0;
            String string2 = defaultSharedPreferences.getString("com.facebook.appevents.SessionInfo.sessionId", i2);
            if (Long.compare(long, cmp) != 0 && Long.compare(long2, cmp) != 0 && string2 == null) {
                if (Long.compare(long2, cmp) != 0) {
                    if (string2 == null) {
                    }
                    super(Long.valueOf(long), Long.valueOf(long2), 0, 4, 0);
                    String str5 = "com.facebook.appevents.SessionInfo.interruptionCount";
                    h.a(hVar, defaultSharedPreferences.getInt(str5, 0));
                    hVar.l(j.c.b());
                    hVar.i(Long.valueOf(System.currentTimeMillis()));
                    UUID string = UUID.fromString(string2);
                    n.e(string, "UUID.fromString(sessionIDStr)");
                    hVar.j(string);
                    return hVar;
                }
            }
            return i2;
        }
    }
    static {
        h.a aVar = new h.a(0);
        h.g = aVar;
    }

    public h(Long long, Long long2, UUID uUID3) {
        n.f(uUID3, "sessionId");
        super();
        this.d = long;
        this.e = long2;
        this.f = uUID3;
    }

    public h(Long long, Long long2, UUID uUID3, int i4, g g5) {
        UUID obj3;
        int obj4;
        if (i4 &= 4 != 0) {
            n.e(UUID.randomUUID(), "UUID.randomUUID()");
        }
        super(long, long2, obj3);
    }

    public static final void a(com.facebook.e0.v.h h, int i2) {
        h.a = i2;
    }

    public final Long b() {
        long longValue;
        Long num = this.b;
        if (num != null) {
            longValue = num.longValue();
        } else {
            longValue = 0;
        }
        return Long.valueOf(longValue);
    }

    public final int c() {
        return this.a;
    }

    public final UUID d() {
        return this.f;
    }

    public final Long e() {
        return this.e;
    }

    public final long f() {
        int i;
        Long num;
        long longValue;
        if (this.d != null) {
            num = this.e;
            if (num == null) {
            } else {
                if (num == null) {
                } else {
                    longValue2 -= longValue;
                    return i;
                }
            }
            IllegalStateException illegalStateException = new IllegalStateException("Required value was null.".toString());
            throw illegalStateException;
        }
        i = 0;
    }

    public final com.facebook.e0.v.j g() {
        return this.c;
    }

    public final void h() {
        this.a = i++;
    }

    public final void i(Long long) {
        this.b = long;
    }

    public final void j(UUID uUID) {
        n.f(uUID, "<set-?>");
        this.f = uUID;
    }

    public final void k(Long long) {
        this.e = long;
    }

    public final void l(com.facebook.e0.v.j j) {
        this.c = j;
    }

    public final void m() {
        int longValue;
        int longValue2;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(o.f()).edit();
        Long num = this.d;
        if (num != null) {
            longValue2 = num.longValue();
        } else {
            longValue2 = longValue;
        }
        edit.putLong("com.facebook.appevents.SessionInfo.sessionStartTime", longValue2);
        Long num2 = this.e;
        if (num2 != null) {
            longValue = num2.longValue();
        }
        edit.putLong("com.facebook.appevents.SessionInfo.sessionEndTime", longValue);
        edit.putInt("com.facebook.appevents.SessionInfo.interruptionCount", this.a);
        edit.putString("com.facebook.appevents.SessionInfo.sessionId", this.f.toString());
        edit.apply();
        com.facebook.e0.v.j jVar = this.c;
        if (jVar != null && jVar != null) {
            if (jVar != null) {
                jVar.a();
            }
        }
    }
}
