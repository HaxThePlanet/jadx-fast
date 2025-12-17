package com.airbnb.lottie.w;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes.dex */
public class b implements com.airbnb.lottie.w.f {
    @Override // com.airbnb.lottie.w.f
    public com.airbnb.lottie.w.d a(String string) {
        URL url = new URL(string);
        Object obj2 = FirebasePerfUrlConnection.instrument(url.openConnection());
        (HttpURLConnection)(URLConnection)obj2.setRequestMethod("GET");
        obj2.connect();
        a aVar = new a(obj2);
        return aVar;
    }
}
