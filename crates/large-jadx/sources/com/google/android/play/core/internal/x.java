package com.google.android.play.core.internal;

import android.content.res.AssetManager;
import f.c.a.f.a.d.b;
import java.io.File;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes2.dex */
public final class x {

    private XmlPullParser a;
    public x(b b) {
        super();
    }

    public final long a() {
        XmlPullParser equals;
        XmlPullParserException xmlPullParserException;
        int arr;
        if (this.a == null) {
        }
        XmlPullParserException xmlPullParserException2 = new XmlPullParserException("Manifest file needs to be loaded before parsing.");
        throw xmlPullParserException2;
    }

    public final void b(AssetManager assetManager, File file2) {
        this.a = assetManager.openXmlResourceParser(b.c(assetManager, file2), "AndroidManifest.xml");
    }
}
