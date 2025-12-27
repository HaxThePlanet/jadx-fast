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

/* compiled from: ClickerWidgetProvider.kt */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0002J\u0008\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0008H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0008H\u0016J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u000cH\u0016J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/widget/ClickerWidgetProvider;", "Landroid/appwidget/AppWidgetProvider;", "()V", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "getPendingSelfIntent", "Landroid/app/PendingIntent;", "context", "Landroid/content/Context;", "action", "", "allWidgetIds", "", "isClickTimeoutOver", "", "onDisabled", "", "onEnabled", "onReceive", "intent", "Landroid/content/Intent;", "onUpdate", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "updateClickerViewButtonState", "remoteViews", "Landroid/widget/RemoteViews;", "isButtonPressed", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ClickerWidgetProvider extends AppWidgetProvider {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final ClickerWidgetProvider.a INSTANCE = new ClickerWidgetProvider$a(0);
    private static boolean b;
    private static long c;
    /* renamed from: a, reason: from kotlin metadata */
    private final o3 tracker;

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/widget/ClickerWidgetProvider$Companion;", "", "()V", "DEFAULT_CLICK_TIMEOUT_MS", "", "WIDGET_BUTTON", "", "buttonPressedState", "", "lastClickTimeMs", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
    public ClickerWidgetProvider() {
        super();
        this.tracker = App.INSTANCE.r();
    }

    /* renamed from: a, reason: from kotlin metadata */
    private final PendingIntent getPendingSelfIntent(Context context, String action, int[] allWidgetIds) {
        final Intent intent = new Intent(context, ClickerWidgetProvider.class);
        intent.setAction(action);
        intent.putExtra("android.appwidget.action.APPWIDGET_UPDATE", allWidgetIds);
        final PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 67108864);
        n.e(broadcast, "getBroadcast(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)");
        return broadcast;
    }

    /* renamed from: b, reason: from kotlin metadata */
    private final boolean isClickTimeoutOver() {
        boolean z = true;
        long l = System.currentTimeMillis() - ClickerWidgetProvider.c;
        int r0 = l > 500 ? 1 : 0;
        return (l > 500 ? 1 : 0);
    }

    private static final void d(ClickerWidgetProvider clickerWidgetProvider, Context context, AppWidgetManager appWidgetManager, ComponentName componentName, MediaPlayer mediaPlayer) {
        n.f(clickerWidgetProvider, "this$0");
        n.f(context, "$context");
        n.f(componentName, "$componentName");
        n.f(mediaPlayer, "mp");
        ClickerWidgetProvider.b = false;
        n.e(appWidgetManager, "appWidgetManager");
        final int[] appWidgetIds = appWidgetManager.getAppWidgetIds(componentName);
        n.e(appWidgetIds, "appWidgetManager.getAppWidgetIds(componentName)");
        clickerWidgetProvider.onUpdate(context, appWidgetManager, appWidgetIds);
        mediaPlayer.release();
    }

    /* renamed from: e, reason: from kotlin metadata */
    private final void onReceive(RemoteViews context, boolean intent) {
        final int i2 = 2131363024;
        final int i3 = 2131362186;
        if (intent != null) {
            context.setImageViewResource(i3, 2131231335);
            int i = 0;
            context.setViewVisibility(i2, i);
        } else {
            context.setImageViewResource(i3, 2131231334);
            i = 4;
            context.setViewVisibility(i2, i);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDisabled(Context context) {
        int i = 1;
        n.f(context, "context");
        int[] appWidgetIds = AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, ClickerWidgetProvider.class.getName()));
        str = "appWidgetIds";
        n.e(appWidgetIds, str);
        context = appWidgetIds.length == 0 ? 1 : 0;
        if (appWidgetIds.length != 0) {
            this.tracker.c(E_Widget.b);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(Context context) {
        n.f(context, "context");
        ClickerWidgetProvider.b = false;
        this.tracker.c(E_Widget.c);
        super.onEnabled(context);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onReceive(Context context, Intent intent) {
        app.dogo.com.dogo_android.w.t2 t2Var;
        i clickerSoundPlayer;
        app.dogo.com.dogo_android.widget.a aVar;
        n.f(context, "context");
        n.f(intent, "intent");
        super.onReceive(context, intent);
        str = "dogo.app.widget.WIDGET_BUTTON";
        if (n.b(str, intent.getAction())) {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            ComponentName componentName = new ComponentName(context, ClickerWidgetProvider.class);
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(componentName);
            if (!ClickerWidgetProvider.b || this.isClickTimeoutOver()) {
                ClickerWidgetProvider.b = true;
                ClickerWidgetProvider.c = System.currentTimeMillis();
                clickerSoundPlayer = new ClickerSoundPlayer(context, this.tracker);
                clickerSoundPlayer.setSound(App.INSTANCE.l().R(), new a(this, context, appWidgetManager, componentName));
                clickerSoundPlayer.click();
                this.tracker.logEvent(E_Widget.a);
            }
            n.e(appWidgetManager, "appWidgetManager");
            str = "appWidgetIds";
            n.e(appWidgetIds, str);
            onUpdate(context, appWidgetManager, appWidgetIds);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] allWidgetIds) {
        n.f(context, "context");
        n.f(appWidgetManager, "appWidgetManager");
        n.f(allWidgetIds, "allWidgetIds");
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), 2131558566);
        onReceive(remoteViews, ClickerWidgetProvider.b);
        remoteViews.setOnClickPendingIntent(2131362186, getPendingSelfIntent(context, "dogo.app.widget.WIDGET_BUTTON", allWidgetIds));
        appWidgetManager.updateAppWidget(allWidgetIds, remoteViews);
    }


    public static /* synthetic */ void c(ClickerWidgetProvider clickerWidgetProvider, Context context, AppWidgetManager appWidgetManager, ComponentName componentName, MediaPlayer mediaPlayer) {
        ClickerWidgetProvider.d(clickerWidgetProvider, context, appWidgetManager, componentName, mediaPlayer);
    }
}
