package com.google.android.gms.dynamite;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.g;
import com.google.android.gms.dynamic.b;
import dalvik.system.DelegateLastClassLoader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public final class DynamiteModule {

    public static final com.google.android.gms.dynamite.DynamiteModule.a b = null;
    public static final com.google.android.gms.dynamite.DynamiteModule.a c = null;
    private static Boolean d = null;
    private static String e = null;
    private static int f = -1;
    private static final java.lang.ThreadLocal<com.google.android.gms.dynamite.f> g;
    private static final java.lang.ThreadLocal<Long> h;
    private static final com.google.android.gms.dynamite.h i;
    private static com.google.android.gms.dynamite.j j;
    private static com.google.android.gms.dynamite.k k;
    private final Context a;

    public static class DynamiteLoaderClassLoader {

        public static java.lang.ClassLoader sClassLoader;
    }

    public static class LoadingException extends Exception {
        LoadingException(String string, com.google.android.gms.dynamite.b b2) {
            super(string);
        }

        LoadingException(String string, Throwable throwable2, com.google.android.gms.dynamite.b b3) {
            super(string, throwable2);
        }
    }

    public interface a {
        public abstract com.google.android.gms.dynamite.i a(Context context, String string2, com.google.android.gms.dynamite.h h3);
    }
    static {
        ThreadLocal threadLocal = new ThreadLocal();
        DynamiteModule.g = threadLocal;
        b bVar = new b();
        DynamiteModule.h = bVar;
        c cVar = new c();
        DynamiteModule.i = cVar;
        d dVar = new d();
        DynamiteModule.b = dVar;
        e eVar = new e();
        DynamiteModule.c = eVar;
    }

    private DynamiteModule(Context context) {
        super();
        r.j(context);
        this.a = context;
    }

    public static int a(Context context, String string2) {
        int stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder(length += 61);
        stringBuilder2.append("com.google.android.gms.dynamite.descriptors.");
        stringBuilder2.append(string2);
        stringBuilder2.append(".");
        stringBuilder2.append("ModuleDescriptor");
        Class obj5 = context.getApplicationContext().getClassLoader().loadClass(stringBuilder2.toString());
        Field declaredField = obj5.getDeclaredField("MODULE_ID");
        int i5 = 0;
        if (!p.a(declaredField.get(i5), string2)) {
            obj5 = String.valueOf(declaredField.get(i5));
            StringBuilder stringBuilder3 = new StringBuilder(i3 += length3);
            stringBuilder3.append("Module descriptor id '");
            stringBuilder3.append(obj5);
            stringBuilder3.append("' didn't match expected id '");
            stringBuilder3.append(string2);
            stringBuilder3.append("'");
            Log.e("DynamiteModule", stringBuilder3.toString());
            return 0;
        }
        return obj5.getDeclaredField("MODULE_VERSION").getInt(i5);
    }

    public static int c(Context context, String string2) {
        return DynamiteModule.f(context, string2, false);
    }

    public static com.google.android.gms.dynamite.DynamiteModule e(Context context, com.google.android.gms.dynamite.DynamiteModule.a dynamiteModule$a2, String string3) {
        Context context2;
        Long valueOf;
        com.google.android.gms.dynamite.DynamiteModule.LoadingException valueOf3;
        Long valueOf2;
        com.google.android.gms.dynamic.a aVar3;
        com.google.android.gms.dynamic.a aVar2;
        Object obj;
        String str2;
        com.google.android.gms.dynamic.a aVar;
        com.google.android.gms.dynamic.a aVar4;
        com.google.android.gms.dynamite.DynamiteModule dynamiteModule;
        int i3;
        Object str5;
        String str3;
        StringBuilder stringBuilder;
        int i;
        String str;
        Object str4;
        boolean applicationContext;
        int i2;
        int length;
        Context context3 = context;
        String str20 = string3;
        Class<com.google.android.gms.dynamite.DynamiteModule> obj2 = DynamiteModule.class;
        java.lang.ThreadLocal threadLocal = DynamiteModule.g;
        final Object obj5 = threadLocal.get();
        f fVar = new f(0);
        threadLocal.set(fVar);
        final java.lang.ThreadLocal threadLocal2 = DynamiteModule.h;
        long longValue = (Long)threadLocal2.get().longValue();
        threadLocal2.set(Long.valueOf(SystemClock.elapsedRealtime()));
        com.google.android.gms.dynamite.i iVar = a2.a(context3, str20, DynamiteModule.i);
        stringBuilder = new StringBuilder(i31 + length);
        stringBuilder.append("Considering local module ");
        stringBuilder.append(str20);
        stringBuilder.append(":");
        stringBuilder.append(iVar.a);
        stringBuilder.append(" and remote module ");
        stringBuilder.append(str20);
        stringBuilder.append(":");
        stringBuilder.append(iVar.b);
        Log.i("DynamiteModule", stringBuilder.toString());
        int i25 = iVar.c;
        if (i25 == 0) {
        } else {
            str3 = -1;
            if (i25 == str3 && iVar.a != 0) {
                if (iVar.a == 0) {
                } else {
                    stringBuilder = 1;
                    if (i25 == stringBuilder && iVar.b != 0) {
                        if (iVar.b == 0) {
                        } else {
                            if (i25 == str3) {
                                if (Long.compare(longValue, i6) == 0) {
                                    threadLocal2.remove();
                                } else {
                                    threadLocal2.set(Long.valueOf(longValue));
                                }
                                Cursor cursor2 = fVar.a;
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                threadLocal.set((f)obj5);
                                return DynamiteModule.i(context3, str20);
                            }
                            if (i25 != stringBuilder) {
                            } else {
                                int i26 = iVar.b;
                                Boolean bool = DynamiteModule.d;
                                synchronized (obj2) {
                                    i26 = iVar.b;
                                    bool = DynamiteModule.d;
                                }
                                i = 2;
                                if (bool.booleanValue()) {
                                    StringBuilder stringBuilder5 = new StringBuilder(length + 51);
                                    stringBuilder5.append("Selected remote version of ");
                                    stringBuilder5.append(str20);
                                    stringBuilder5.append(", version >= ");
                                    stringBuilder5.append(i26);
                                    Log.i("DynamiteModule", stringBuilder5.toString());
                                    str5 = DynamiteModule.k;
                                    synchronized (obj2) {
                                        stringBuilder5 = new StringBuilder(length + 51);
                                        stringBuilder5.append("Selected remote version of ");
                                        stringBuilder5.append(str20);
                                        stringBuilder5.append(", version >= ");
                                        stringBuilder5.append(i26);
                                        Log.i("DynamiteModule", stringBuilder5.toString());
                                        str5 = DynamiteModule.k;
                                    }
                                    Object obj7 = threadLocal.get();
                                    if ((f)obj7 == null) {
                                    } else {
                                        if (obj7.a == null) {
                                        } else {
                                            applicationContext = context.getApplicationContext();
                                            str = obj7.a;
                                            b.p2(0);
                                            synchronized (obj2) {
                                                i = 1;
                                                if (Boolean.valueOf(i).booleanValue()) {
                                                } else {
                                                    Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                                    aVar2 = str5.p2(b.p2(applicationContext), str20, i26, b.p2(str));
                                                }
                                                obj = b.n(aVar2);
                                                if ((Context)obj == null) {
                                                } else {
                                                    dynamiteModule = new DynamiteModule((Context)obj);
                                                    if (Long.compare(longValue, i4) == 0) {
                                                        threadLocal2.remove();
                                                    } else {
                                                        threadLocal2.set(Long.valueOf(longValue));
                                                    }
                                                    Cursor cursor = fVar.a;
                                                    if (cursor != null) {
                                                        cursor.close();
                                                    }
                                                    threadLocal.set(obj5);
                                                    return dynamiteModule;
                                                }
                                                DynamiteModule.LoadingException loadingException8 = new DynamiteModule.LoadingException("Failed to get module context", 0);
                                                throw loadingException8;
                                            }
                                            Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                            aVar2 = str5.q2(b.p2(applicationContext), str20, i26, b.p2(str));
                                        }
                                    }
                                    DynamiteModule.LoadingException loadingException7 = new DynamiteModule.LoadingException("No result cursor", 0);
                                    throw loadingException7;
                                }
                                StringBuilder stringBuilder4 = new StringBuilder(length2 += 51);
                                stringBuilder4.append("Selected remote version of ");
                                stringBuilder4.append(str20);
                                stringBuilder4.append(", version >= ");
                                stringBuilder4.append(i26);
                                Log.i("DynamiteModule", stringBuilder4.toString());
                                com.google.android.gms.dynamite.j jVar = DynamiteModule.k(context);
                                if (jVar == null) {
                                } else {
                                    int i16 = jVar.t2();
                                    if (i16 >= 3) {
                                        Object obj3 = threadLocal.get();
                                        if ((f)obj3 == null) {
                                        } else {
                                            aVar3 = jVar.v2(b.p2(context), str20, i26, b.p2(obj3.a));
                                            if (b.n(aVar3) == null) {
                                            } else {
                                                dynamiteModule = new DynamiteModule((Context)b.n(aVar3));
                                            }
                                            DynamiteModule.LoadingException loadingException5 = new DynamiteModule.LoadingException("Failed to load remote module.", 0);
                                            throw loadingException5;
                                        }
                                        DynamiteModule.LoadingException loadingException4 = new DynamiteModule.LoadingException("No cached result cursor holder", 0);
                                        throw loadingException4;
                                    }
                                    if (i16 == i) {
                                        try {
                                            Log.w("DynamiteModule", "IDynamite loader version = 2");
                                            aVar3 = jVar.r2(b.p2(context), str20, i26);
                                            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                            aVar3 = jVar.p2(b.p2(context), str20, i26);
                                            if (b.n(aVar3) == null) {
                                            } else {
                                            }
                                            dynamiteModule = new DynamiteModule((Context)b.n(aVar3));
                                            if (Long.compare(longValue, i4) == 0) {
                                            } else {
                                            }
                                            threadLocal2.remove();
                                            threadLocal2.set(Long.valueOf(longValue));
                                            cursor = fVar.a;
                                            if (cursor != null) {
                                            }
                                            cursor.close();
                                            threadLocal.set(obj5);
                                            return dynamiteModule;
                                            loadingException5 = new DynamiteModule.LoadingException("Failed to load remote module.", 0);
                                            throw loadingException5;
                                            DynamiteModule.LoadingException loadingException3 = new DynamiteModule.LoadingException("Failed to create IDynamiteLoader.", 0);
                                            throw loadingException3;
                                            DynamiteModule.LoadingException loadingException2 = new DynamiteModule.LoadingException("Failed to determine which loading route to use.", 0);
                                            throw loadingException2;
                                            throw th;
                                            g.a(context2, th);
                                            str2 = "Failed to load remote module.";
                                            i3 = 0;
                                            valueOf3 = new DynamiteModule.LoadingException(str2, th, i3);
                                            throw valueOf3;
                                            throw th;
                                            str2 = "Failed to load remote module.";
                                            i3 = 0;
                                            valueOf3 = new DynamiteModule.LoadingException(str2, th, i3);
                                            throw valueOf3;
                                            valueOf3 = "DynamiteModule";
                                            str2 = "Failed to load remote module: ";
                                            i3 = th.getMessage();
                                            i3 = String.valueOf(i3);
                                            if (i3.length() != 0) {
                                            } else {
                                            }
                                            str2 = str2.concat(i3);
                                            i3 = new String(str2);
                                            str2 = i3;
                                            Log.w(valueOf3, str2);
                                            valueOf3 = obj13.a;
                                            if (valueOf3 == null) {
                                            } else {
                                            }
                                            i3 = 0;
                                            str2 = new g(valueOf3, i3);
                                            valueOf3 = a2;
                                            valueOf3 = valueOf3.a(context2, str19, str2);
                                            valueOf3 = valueOf3.c;
                                            str2 = -1;
                                            if (valueOf3 != str2) {
                                            } else {
                                            }
                                            Throwable th = DynamiteModule.i(context2, str19);
                                            context2 = null;
                                            context2 = Long.compare(obj9, context2);
                                            if (context2 == null) {
                                            } else {
                                            }
                                            context2 = DynamiteModule.h;
                                            context2.remove();
                                            context2 = DynamiteModule.h;
                                            valueOf3 = Long.valueOf(obj9);
                                            context2.set(valueOf3);
                                            context2 = obj6.a;
                                            if (context2 != null) {
                                            }
                                            context2.close();
                                            context2 = DynamiteModule.g;
                                            context2.set(obj5);
                                            return th;
                                            valueOf3 = "Remote load failed. No local fallback found.";
                                            String str19 = null;
                                            context2 = new DynamiteModule.LoadingException(valueOf3, th, str19);
                                            throw context2;
                                            StringBuilder stringBuilder2 = new StringBuilder(47);
                                            stringBuilder2.append("VersionPolicy returned invalid code:");
                                            stringBuilder2.append(0);
                                            DynamiteModule.LoadingException loadingException = new DynamiteModule.LoadingException(stringBuilder2.toString(), 0);
                                            throw loadingException;
                                            StringBuilder stringBuilder3 = new StringBuilder(91);
                                            stringBuilder3.append("No acceptable module found. Local version is ");
                                            stringBuilder3.append(iVar.a);
                                            stringBuilder3.append(" and remote version is ");
                                            stringBuilder3.append(iVar.b);
                                            stringBuilder3.append(".");
                                            DynamiteModule.LoadingException loadingException9 = new DynamiteModule.LoadingException(stringBuilder3.toString(), 0);
                                            throw loadingException9;
                                            context2 = null;
                                            context2 = Long.compare(obj9, context2);
                                            if (context2 == null) {
                                            } else {
                                            }
                                            context2 = DynamiteModule.h;
                                            context2.remove();
                                            context2 = DynamiteModule.h;
                                            valueOf3 = Long.valueOf(obj9);
                                            context2.set(valueOf3);
                                            context2 = obj6.a;
                                            if (context2 == null) {
                                            } else {
                                            }
                                            context2.close();
                                            context2 = DynamiteModule.g;
                                            context2.set(obj5);
                                            throw th;
                                        } catch (com.google.android.gms.dynamite.DynamiteModule.LoadingException loading) {
                                        } catch (Throwable th1) {
                                        }
                                    } else {
                                    }
                                }
                            }
                        }
                    } else {
                    }
                }
            } else {
            }
        }
    }

    public static int f(Context context, String string2, boolean z3) {
        boolean booleanValue;
        Boolean fALSE;
        Boolean fALSE2;
        int i;
        Object obj;
        int i2;
        Class declaringClass;
        Object systemClassLoader;
        Object delegateLastClassLoader;
        String empty;
        Object stringBuilder;
        String str;
        boolean z;
        java.lang.ClassLoader systemClassLoader2;
        long longValue;
        Object obj10;
        boolean obj11;
        Class<com.google.android.gms.dynamite.DynamiteModule> obj2 = DynamiteModule.class;
        i2 = 0;
        synchronized (obj2) {
            Field declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteModule.DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
            declaringClass = declaredField.getDeclaringClass();
            systemClassLoader = declaredField.get(i2);
            synchronized (declaringClass) {
                if ((ClassLoader)systemClassLoader == ClassLoader.getSystemClassLoader()) {
                    try {
                        fALSE2 = Boolean.FALSE;
                        DynamiteModule.j((ClassLoader)systemClassLoader);
                        fALSE2 = Boolean.TRUE;
                    } catch (com.google.android.gms.dynamite.DynamiteModule.LoadingException loading) {
                        obj.close();
                        throw z3;
                    } catch (Throwable th1) {
                    }
                } else {
                }
            }
        }
        DynamiteModule.d = fALSE2;
    }

    private static int g(Context context, String string2, boolean z3) {
        Cursor i;
        long columnIndex;
        String obj9;
        String obj10;
        String obj11;
        obj9 = "api_force_staging";
        if (1 != z3) {
            try {
                obj9 = str3;
                obj11 = new Uri.Builder();
                obj9 = context.getContentResolver().query(obj11.scheme("content").authority("com.google.android.gms.chimera").path(obj9).appendPath(string2).appendQueryParameter("requestStartTime", String.valueOf((Long)DynamiteModule.h.get().longValue())).build(), 0, 0, 0, 0);
                if (obj9 == null) {
                } else {
                }
                if (!obj9.moveToFirst()) {
                } else {
                }
                obj10 = obj9.getInt(0);
                if (obj10 > 0) {
                } else {
                }
                obj11 = DynamiteModule.class;
                DynamiteModule.e = obj9.getString(2);
                columnIndex = obj9.getColumnIndex("loaderVersion");
                if (columnIndex >= 0) {
                }
                DynamiteModule.f = obj9.getInt(columnIndex);
                if (DynamiteModule.h(obj9)) {
                } else {
                }
                throw string2;
                i = obj9;
                if (i != null) {
                }
                i.close();
                return obj10;
                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                obj10 = new DynamiteModule.LoadingException("Failed to connect to dynamite module ContentResolver.", 0);
                throw obj10;
                string2 = context;
                string2 = context;
                context = th;
                z3 = string2 instanceof DynamiteModule.LoadingException;
                if (z3 != 0) {
                }
                throw string2;
                z3 = new DynamiteModule.LoadingException("V2 version check failed", string2, th);
                throw z3;
                Throwable th = context;
                if (th == null) {
                } else {
                }
                th.close();
                throw string2;
            } catch (Exception e) {
            } catch (Throwable th1) {
            }
        }
    }

    private static boolean h(Cursor cursor) {
        Cursor cursor2;
        Object obj = DynamiteModule.g.get();
        if ((f)obj != null && obj.a == null) {
            if (obj.a == null) {
                obj.a = cursor;
                return 1;
            }
        }
        return 0;
    }

    private static com.google.android.gms.dynamite.DynamiteModule i(Context context, String string2) {
        String obj3;
        obj3 = String.valueOf(string2);
        final String str2 = "Selected local version of ";
        if (obj3.length() != 0) {
            obj3 = str2.concat(obj3);
        } else {
            obj3 = new String(str2);
        }
        Log.i("DynamiteModule", obj3);
        obj3 = new DynamiteModule(context.getApplicationContext());
        return obj3;
    }

    private static void j(java.lang.ClassLoader classLoader) {
        int localInterface;
        Class[] arr;
        int i2 = 0;
        Object obj3 = classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[i2]).newInstance(new Object[i2]);
        if ((IBinder)obj3 == null) {
            try {
                localInterface = i;
                if (localInterface instanceof k) {
                } else {
                }
                localInterface = new k(obj3);
                DynamiteModule.k = localInterface;
                DynamiteModule.LoadingException loadingException = new DynamiteModule.LoadingException("Failed to instantiate dynamite loader", classLoader, obj0);
                throw loadingException;
            }
        } else {
        }
    }

    private static com.google.android.gms.dynamite.j k(Context context) {
        int localInterface;
        int i;
        Object obj5;
        final Class<com.google.android.gms.dynamite.DynamiteModule> obj = DynamiteModule.class;
        com.google.android.gms.dynamite.j jVar = DynamiteModule.j;
        synchronized (obj) {
            return jVar;
        }
    }

    public Context b() {
        return this.a;
    }

    public IBinder d(String string) {
        try {
            return (IBinder)this.a.getClassLoader().loadClass(string).newInstance();
            string = String.valueOf(string);
            String str = "Failed to instantiate module class: ";
            if (string.length() != 0) {
            } else {
            }
            string = str.concat(string);
            string = new String(str);
            str = null;
            DynamiteModule.LoadingException loadingException = new DynamiteModule.LoadingException(string, th, str);
            throw loadingException;
        }
    }
}
