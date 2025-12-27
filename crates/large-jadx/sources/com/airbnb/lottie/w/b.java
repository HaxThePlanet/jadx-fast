package com.airbnb.lottie.w;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: DefaultLottieNetworkFetcher.java */
/* loaded from: classes.dex */
public class b implements f {
    public d a(String str) throws java.net.MalformedURLException, java.io.IOException, java.net.ProtocolException {
        Object instrument = FirebasePerfUrlConnection.instrument(new URL(str).openConnection());
        instrument.setRequestMethod("GET");
        instrument.connect();
        return new a(instrument);
    }
}
