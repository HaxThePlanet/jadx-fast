package app.dogo.com.dogo_android.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.RemoteViews;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.i;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.r0;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0002J\u0008\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0008H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0008H\u0016J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u000cH\u0016J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/widget/ClickerWidgetProvider;", "Landroid/appwidget/AppWidgetProvider;", "()V", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "getPendingSelfIntent", "Landroid/app/PendingIntent;", "context", "Landroid/content/Context;", "action", "", "allWidgetIds", "", "isClickTimeoutOver", "", "onDisabled", "", "onEnabled", "onReceive", "intent", "Landroid/content/Intent;", "onUpdate", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "updateClickerViewButtonState", "remoteViews", "Landroid/widget/RemoteViews;", "isButtonPressed", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ClickerWidgetProvider extends AppWidgetProvider {

    public static final app.dogo.com.dogo_android.widget.ClickerWidgetProvider.a Companion;
    private static boolean b;
    private static long c;
    private final o3 a;

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/widget/ClickerWidgetProvider$Companion;", "", "()V", "DEFAULT_CLICK_TIMEOUT_MS", "", "WIDGET_BUTTON", "", "buttonPressedState", "", "lastClickTimeMs", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }
    static {
        ClickerWidgetProvider.a aVar = new ClickerWidgetProvider.a(0);
        ClickerWidgetProvider.Companion = aVar;
    }

    public ClickerWidgetProvider() {
        super();
        this.a = App.Companion.r();
    }

    private final PendingIntent a(Context context, String string2, int[] i3Arr3) {
        Intent intent = new Intent(context, ClickerWidgetProvider.class);
        intent.setAction(string2);
        intent.putExtra("android.appwidget.action.APPWIDGET_UPDATE", i3Arr3);
        final PendingIntent obj3 = PendingIntent.getBroadcast(context, 0, intent, 67108864);
        n.e(obj3, "getBroadcast(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)");
        return obj3;
    }

    private final boolean b() {
        int i;
        i = Long.compare(i2, i3) > 0 ? 1 : 0;
        return i;
    }

    public static void c(app.dogo.com.dogo_android.widget.ClickerWidgetProvider clickerWidgetProvider, Context context2, AppWidgetManager appWidgetManager3, ComponentName componentName4, MediaPlayer mediaPlayer5) {
        ClickerWidgetProvider.d(clickerWidgetProvider, context2, appWidgetManager3, componentName4, mediaPlayer5);
    }

    private static final void d(app.dogo.com.dogo_android.widget.ClickerWidgetProvider clickerWidgetProvider, Context context2, AppWidgetManager appWidgetManager3, ComponentName componentName4, MediaPlayer mediaPlayer5) {
        n.f(clickerWidgetProvider, "this$0");
        n.f(context2, "$context");
        n.f(componentName4, "$componentName");
        n.f(mediaPlayer5, "mp");
        ClickerWidgetProvider.b = false;
        n.e(appWidgetManager3, "appWidgetManager");
        final int[] obj4 = appWidgetManager3.getAppWidgetIds(componentName4);
        n.e(obj4, "appWidgetManager.getAppWidgetIds(componentName)");
        clickerWidgetProvider.onUpdate(context2, appWidgetManager3, obj4);
        mediaPlayer5.release();
    }

    private final void e(RemoteViews remoteViews, boolean z2) {
        int obj4;
        final int i = 2131363024;
        final int i2 = 2131362186;
        if (z2) {
            remoteViews.setImageViewResource(i2, 2131231335);
            remoteViews.setViewVisibility(i, 0);
        } else {
            remoteViews.setImageViewResource(i2, 2131231334);
            remoteViews.setViewVisibility(i, 4);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDisabled(Context context) {
        Object str;
        int obj4;
        n.f(context, "context");
        ComponentName componentName = new ComponentName(context, ClickerWidgetProvider.class.getName());
        obj4 = AppWidgetManager.getInstance(context).getAppWidgetIds(componentName);
        n.e(obj4, "appWidgetIds");
        obj4 = obj4.length == 0 ? 1 : 0;
        if (obj4 != null) {
            this.a.c(r0.b);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(Context context) {
        n.f(context, "context");
        ClickerWidgetProvider.b = false;
        this.a.c(r0.c);
        super.onEnabled(context);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onReceive(Context context, Intent intent2) {
        Object componentName;
        String str;
        int[] appWidgetIds;
        boolean z;
        i iVar;
        app.dogo.com.dogo_android.widget.a aVar;
        boolean obj7;
        n.f(context, "context");
        n.f(intent2, "intent");
        super.onReceive(context, intent2);
        if (n.b("dogo.app.widget.WIDGET_BUTTON", intent2.getAction())) {
            obj7 = AppWidgetManager.getInstance(context);
            componentName = new ComponentName(context, ClickerWidgetProvider.class);
            appWidgetIds = obj7.getAppWidgetIds(componentName);
            if (ClickerWidgetProvider.b) {
                if (b()) {
                    ClickerWidgetProvider.b = true;
                    ClickerWidgetProvider.c = System.currentTimeMillis();
                    iVar = new i(context, this.a);
                    aVar = new a(this, context, obj7, componentName);
                    iVar.l(App.Companion.l().R(), aVar);
                    iVar.a();
                    this.a.c(r0.a);
                }
            } else {
            }
            n.e(obj7, "appWidgetManager");
            n.e(appWidgetIds, "appWidgetIds");
            onUpdate(context, obj7, appWidgetIds);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager2, int[] i3Arr3) {
        n.f(context, "context");
        n.f(appWidgetManager2, "appWidgetManager");
        n.f(i3Arr3, "allWidgetIds");
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), 2131558566);
        e(remoteViews, ClickerWidgetProvider.b);
        remoteViews.setOnClickPendingIntent(2131362186, a(context, "dogo.app.widget.WIDGET_BUTTON", i3Arr3));
        appWidgetManager2.updateAppWidget(i3Arr3, remoteViews);
    }
}
