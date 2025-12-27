package app.dogo.com.dogo_android.widget;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements MediaPlayer.OnCompletionListener {

    public final /* synthetic */ ClickerWidgetProvider a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ AppWidgetManager c;
    public final /* synthetic */ ComponentName d;
    public /* synthetic */ a(ClickerWidgetProvider clickerWidgetProvider, Context context, AppWidgetManager appWidgetManager, ComponentName componentName) {
        super();
        this.a = clickerWidgetProvider;
        this.b = context;
        this.c = appWidgetManager;
        this.d = componentName;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        ClickerWidgetProvider.d(this.a, this.b, this.c, this.d, mediaPlayer);
    }
}
