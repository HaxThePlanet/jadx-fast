package m.a.a.b.b;

import android.app.Application;
import android.content.Context;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;

/* compiled from: ModuleExt.kt */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"ERROR_MSG", "", "androidApplication", "Landroid/app/Application;", "Lorg/koin/core/scope/Scope;", "androidContext", "Landroid/content/Context;", "koin-android_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    public static final Application a(m.a.c.l.a aVar) throws m.a.a.a.a {
        n.f(aVar, "<this>");
        try {
            final m.a.c.j.a aVar2 = null;
        } catch (Exception unused) {
            aVar = new MissingAndroidContextException("Can't resolve Application instance. Please use androidContext() function in your KoinApplication configuration.");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) aVar;
        }
        return (Application)aVar.c(c0.b(Application.class), aVar2, aVar2);
    }

    public static final Context b(m.a.c.l.a aVar) throws m.a.a.a.a {
        n.f(aVar, "<this>");
        try {
            final m.a.c.j.a aVar2 = null;
        } catch (Exception unused) {
            aVar = new MissingAndroidContextException("Can't resolve Context instance. Please use androidContext() function in your KoinApplication configuration.");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) aVar;
        }
        return (Context)aVar.getOrNull(c0.b(Context.class), aVar2, aVar2);
    }
}
