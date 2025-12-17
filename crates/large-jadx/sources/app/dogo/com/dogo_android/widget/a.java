package app.dogo.com.dogo_android.widget;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

/* loaded from: classes.dex */
public final class a implements MediaPlayer.OnCompletionListener {

    public final app.dogo.com.dogo_android.widget.ClickerWidgetProvider a;
    public final Context b;
    public final AppWidgetManager c;
    public final ComponentName d;
    public a(app.dogo.com.dogo_android.widget.ClickerWidgetProvider clickerWidgetProvider, Context context2, AppWidgetManager appWidgetManager3, ComponentName componentName4) {
        super();
        this.a = clickerWidgetProvider;
        this.b = context2;
        this.c = appWidgetManager3;
        this.d = componentName4;
    }

    @Override // android.media.MediaPlayer$OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        ClickerWidgetProvider.c(this.a, this.b, this.c, this.d, mediaPlayer);
    }
}
