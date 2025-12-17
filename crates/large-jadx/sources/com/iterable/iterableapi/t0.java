package com.iterable.iterableapi;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Handler;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class t0 extends AsyncTask<com.iterable.iterableapi.l, Void, com.iterable.iterableapi.m> {

    static String c;
    int a = 0;
    com.iterable.iterableapi.l b;

    class a implements Runnable {

        final com.iterable.iterableapi.t0 a;
        final com.iterable.iterableapi.t0 b;
        a(com.iterable.iterableapi.t0 t0, com.iterable.iterableapi.t0 t02) {
            this.b = t0;
            this.a = t02;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            com.iterable.iterableapi.l[] arr = new l[1];
            this.a.execute(t0Var2.b);
        }
    }
    t0() {
        super();
        final int i = 0;
    }

    private static String a(HttpURLConnection httpURLConnection) {
        Object next;
        boolean requestProperties;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nHeaders { \n");
        Iterator iterator = httpURLConnection.getRequestProperties().keySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (t0.d((String)next)) {
            } else {
            }
            stringBuilder.append(next);
            stringBuilder.append(" : ");
            stringBuilder.append(httpURLConnection.getRequestProperties().get(next));
            stringBuilder.append("\n");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    static com.iterable.iterableapi.m c(com.iterable.iterableapi.l l) {
        Throwable th;
        com.iterable.iterableapi.l lVar;
        Object obj;
        Throwable th3;
        String str12;
        String string3;
        String string5;
        Object outputStream;
        int i3;
        String str4;
        String str;
        Throwable th2;
        String responseCode;
        int bufferedWriter;
        int i;
        int i2;
        String string2;
        String string;
        int length;
        int instrument;
        String str7;
        String str9;
        String empty2;
        int string4;
        int str6;
        BufferedReader bufferedReader;
        int str11;
        String empty;
        String str2;
        InputStreamReader inputStreamReader;
        int jSONObject;
        Iterator keys;
        java.io.InputStream errorStream;
        Throwable message;
        int i5;
        String str3;
        String str10;
        String str8;
        String str5;
        Object obj2;
        boolean next;
        int i4;
        obj = l;
        if (obj != null) {
            str7 = "IterableRequest";
            j0.h(str7, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
            empty2 = obj.b;
            if (empty2 != null && !empty2.isEmpty()) {
                str9 = !empty2.isEmpty() ? obj.b : "https://api.iterable.com/api/";
            } else {
            }
            empty = t0.c;
            if (empty != null && !empty.isEmpty()) {
                if (!empty.isEmpty()) {
                    str9 = t0.c;
                }
            }
            String str37 = "\n body : \n";
            String str38 = "Bearer ";
            str3 = "Authorization";
            str10 = "SDK-Request-Processor";
            string2 = "Sent-At";
            String str27 = "3.4.2";
            str8 = "SDK-Version";
            String str13 = "Android";
            String str20 = "SDK-Platform";
            str = "Api-Key";
            i4 = str7;
            if (obj.e == "GET") {
                StringBuilder stringBuilder7 = new StringBuilder();
                stringBuilder7.append(str9);
                stringBuilder7.append(obj.c);
                Uri.Builder upon = Uri.parse(stringBuilder7.toString()).buildUpon();
                keys = obj.d.keys();
                for (Object next2 : keys) {
                    str7 = next2;
                    upon.appendQueryParameter(str7, obj.d.getString((String)str7));
                    keys = next;
                }
                URL url = new URL(upon.build().toString());
                instrument = FirebasePerfUrlConnection.instrument(url.openConnection());
                int i11 = 10000;
                (HttpURLConnection)(URLConnection)instrument.setReadTimeout(i11);
                instrument.setConnectTimeout(i11);
                instrument.setRequestProperty(str, obj.a);
                instrument.setRequestProperty(str20, str13);
                instrument.setRequestProperty(str8, str27);
                Date date = new Date();
                instrument.setRequestProperty(string2, String.valueOf(time /= str6));
                instrument.setRequestProperty(str10, l.b().toString());
                if (obj.f != null) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str38);
                    stringBuilder2.append(obj.f);
                    instrument.setRequestProperty(str3, stringBuilder2.toString());
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("GET Request \nURI : ");
                stringBuilder.append(str9);
                stringBuilder.append(obj.c);
                stringBuilder.append(t0.a(instrument));
                stringBuilder.append(str37);
                stringBuilder.append(obj.d.toString(2));
                str2 = i4;
                j0.h(str2, stringBuilder.toString());
                str4 = str2;
            } else {
                StringBuilder stringBuilder8 = new StringBuilder();
                stringBuilder8.append(str9);
                stringBuilder8.append(obj.c);
                URL url2 = new URL(stringBuilder8.toString());
                instrument = FirebasePerfUrlConnection.instrument(url2.openConnection());
                (HttpURLConnection)(URLConnection)instrument.setDoOutput(true);
                instrument.setRequestMethod(obj.e);
                int i13 = 3000;
                instrument.setReadTimeout(i13);
                instrument.setConnectTimeout(i13);
                keys = next;
                instrument.setRequestProperty("Accept", keys);
                instrument.setRequestProperty("Content-Type", keys);
                instrument.setRequestProperty(str, obj.a);
                instrument.setRequestProperty(str20, str13);
                instrument.setRequestProperty(str8, str27);
                Date date2 = new Date();
                instrument.setRequestProperty(string2, String.valueOf(time2 /= i10));
                instrument.setRequestProperty(str10, l.b().toString());
                if (obj.f != null) {
                    try {
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append(str38);
                        stringBuilder4.append(obj.f);
                        instrument.setRequestProperty(str3, stringBuilder4.toString());
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append("POST Request \nURI : ");
                        stringBuilder3.append(str9);
                        stringBuilder3.append(obj.c);
                        stringBuilder3.append(t0.a(instrument));
                        stringBuilder3.append(str37);
                        stringBuilder3.append(obj.d.toString(2));
                        j0.h(i4, stringBuilder3.toString());
                        outputStream = instrument.getOutputStream();
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                        bufferedWriter = new BufferedWriter(outputStreamWriter);
                        bufferedWriter.write(obj.d.toString());
                        bufferedWriter.close();
                        outputStream.close();
                        j0.h(str4, "======================================");
                        responseCode = instrument.getResponseCode();
                        int i9 = 400;
                        if (responseCode < i9) {
                        } else {
                        }
                        inputStreamReader = new InputStreamReader(instrument.getInputStream());
                        bufferedReader = new BufferedReader(inputStreamReader);
                        inputStreamReader = new InputStreamReader(instrument.getErrorStream());
                        bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuffer stringBuffer = new StringBuffer();
                        errorStream = bufferedReader.readLine();
                        while (errorStream != null) {
                            stringBuffer.append(errorStream);
                            errorStream = bufferedReader.readLine();
                        }
                        stringBuffer.append(errorStream);
                    }
                    bufferedReader.close();
                    string4 = stringBuffer.toString();
                    str11 = 0;
                    jSONObject = new JSONObject(string4);
                    StringBuilder stringBuilder9 = new StringBuilder();
                    stringBuilder9.append("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nResponse from : ");
                    stringBuilder9.append(str9);
                    stringBuilder9.append(obj.c);
                    j0.h(str4, stringBuilder9.toString());
                    j0.h(str4, jSONObject.toString(2));
                    message = 0;
                    if (responseCode == 401) {
                        if (t0.f(jSONObject, "InvalidJwtPayload")) {
                            i2 = m.a(responseCode, string4, jSONObject, "JWT Authorization header error");
                        } else {
                            i2 = m.a(responseCode, string4, jSONObject, "Invalid API Key");
                        }
                    } else {
                        if (responseCode >= i9) {
                            string = "Invalid Request";
                            str11 = str5;
                            if (jSONObject != null && jSONObject.has(str11)) {
                                str11 = str5;
                                if (jSONObject.has(str11)) {
                                    string = jSONObject.getString(str11);
                                } else {
                                    if (responseCode >= 500) {
                                        string = "Internal Server Error";
                                    }
                                }
                            } else {
                            }
                            i2 = m.a(responseCode, string4, jSONObject, string);
                        } else {
                            if (responseCode == 200) {
                                if (str11 == null && string4.length() > 0) {
                                    if (string4.length() > 0) {
                                        if (message != null) {
                                            StringBuilder stringBuilder6 = new StringBuilder();
                                            stringBuilder6.append("Could not parse json: ");
                                            stringBuilder6.append(message);
                                            i2 = m.a(responseCode, string4, jSONObject, stringBuilder6.toString());
                                        } else {
                                            if (jSONObject != null) {
                                                i2 = m.b(responseCode, string4, jSONObject);
                                            } else {
                                                i2 = m.a(responseCode, string4, jSONObject, "Response is not a JSON object");
                                            }
                                        }
                                    } else {
                                        if (str11 == null && string4.length() == 0) {
                                            if (string4.length() == 0) {
                                                i2 = m.a(responseCode, string4, jSONObject, "No data received");
                                            } else {
                                                if (str11 != null) {
                                                    i2 = m.a(responseCode, string4, jSONObject, str11);
                                                } else {
                                                    i2 = 0;
                                                }
                                            }
                                        } else {
                                        }
                                    }
                                } else {
                                }
                            } else {
                                StringBuilder stringBuilder5 = new StringBuilder();
                                stringBuilder5.append("Received non-200 response: ");
                                stringBuilder5.append(responseCode);
                                i2 = m.a(responseCode, string4, jSONObject, stringBuilder5.toString());
                            }
                        }
                    }
                    if (instrument != null) {
                        try {
                            instrument.disconnect();
                        } catch (org.json.JSONException jSON) {
                            i2 = m.a(responseCode, string4, jSONObject, "No data received");
                            i2 = m.a(responseCode, string4, jSONObject, str11);
                            i2 = 0;
                            j0.h(str4, str12);
                            return i2;
                        } catch (java.io.IOException ioException1) {
                            stringBuilder6 = new StringBuilder();
                            stringBuilder6.append("Could not parse json: ");
                            stringBuilder6.append(message);
                            i2 = m.a(responseCode, string4, jSONObject, stringBuilder6.toString());
                            i2 = m.b(responseCode, string4, jSONObject);
                            i2 = m.a(responseCode, string4, jSONObject, "Response is not a JSON object");
                            i2 = m.a(responseCode, string4, jSONObject, "No data received");
                            i2 = m.a(responseCode, string4, jSONObject, str11);
                            i2 = 0;
                            stringBuilder5 = new StringBuilder();
                            stringBuilder5.append("Received non-200 response: ");
                            stringBuilder5.append(responseCode);
                            i2 = m.a(responseCode, string4, jSONObject, stringBuilder5.toString());
                            j0.h(str4, str12);
                            return i2;
                        } catch (java.lang.ArrayIndexOutOfBoundsException arrayIndexOutOfBounds2) {
                            i2 = m.a(responseCode, string4, jSONObject, "Invalid API Key");
                            j0.h(str4, str12);
                            return i2;
                        } catch (Exception e3) {
                            string4 = th;
                            t0.e(lVar, obj7, string4);
                            string4 = string4.getMessage();
                            str11 = string4;
                            string4 = 0;
                            jSONObject = new JSONObject(string4);
                            stringBuilder9 = new StringBuilder();
                            stringBuilder9.append("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nResponse from : ");
                            stringBuilder9.append(str9);
                            stringBuilder9.append(obj.c);
                            j0.h(str4, stringBuilder9.toString());
                            j0.h(str4, jSONObject.toString(2));
                            message = 0;
                            i2 = m.a(responseCode, string4, jSONObject, "JWT Authorization header error");
                            i2 = m.a(responseCode, string4, jSONObject, "Invalid API Key");
                            string = "Invalid Request";
                            str11 = str5;
                            string = jSONObject.getString(str11);
                            string = "Internal Server Error";
                            i2 = m.a(responseCode, string4, jSONObject, string);
                            stringBuilder6 = new StringBuilder();
                            stringBuilder6.append("Could not parse json: ");
                            stringBuilder6.append(message);
                            i2 = m.a(responseCode, string4, jSONObject, stringBuilder6.toString());
                            i2 = m.b(responseCode, string4, jSONObject);
                            i2 = m.a(responseCode, string4, jSONObject, "Response is not a JSON object");
                            i2 = m.a(responseCode, string4, jSONObject, "No data received");
                            i2 = m.a(responseCode, string4, jSONObject, str11);
                            i2 = 0;
                            stringBuilder5 = new StringBuilder();
                            stringBuilder5.append("Received non-200 response: ");
                            stringBuilder5.append(responseCode);
                            i2 = m.a(responseCode, string4, jSONObject, stringBuilder5.toString());
                            j0.h(str4, str12);
                            return i2;
                        } catch (Throwable th4) {
                        }
                        th2 = th;
                        try {
                            t0.e(lVar, obj7, th2);
                            lVar = th2.getMessage();
                            th2 = null;
                            i = 0;
                            lVar = m.a(th2, string4, i, lVar);
                            if (instrument != 0) {
                            }
                            th3 = th2;
                            i3 = instrument;
                            th2 = th;
                            instrument = 0;
                            string4 = 0;
                            t0.e(lVar, obj7, th2);
                            lVar = th2.getMessage();
                            th2 = null;
                            i = 0;
                            lVar = m.a(th2, string4, i, lVar);
                            if (instrument != 0) {
                            }
                            th3 = th2;
                            i3 = instrument;
                            th2 = th;
                            instrument = 0;
                            string4 = 0;
                            t0.e(lVar, obj7, th2);
                            lVar = th2.getMessage();
                            th2 = null;
                            i = 0;
                            lVar = m.a(th2, string4, i, lVar);
                            if (instrument != 0) {
                            }
                            th3 = th2;
                            i3 = instrument;
                            th2 = th;
                            instrument = 0;
                            string4 = 0;
                            t0.e(lVar, obj7, th2);
                            lVar = th2.getMessage();
                            th2 = null;
                            i = 0;
                            lVar = m.a(th2, string4, i, lVar);
                            if (instrument != 0) {
                            }
                            instrument.disconnect();
                            i = lVar;
                            j0.h(str4, str12);
                            lVar = th;
                            i = instrument;
                            if (i == 0) {
                            } else {
                            }
                            i.disconnect();
                            throw lVar;
                            i2 = 0;
                            return i2;
                        }
                    }
                }
            }
        } else {
        }
    }

    private static boolean d(String string) {
        String equals;
        int obj1;
        if (!string.equals("Api-Key")) {
            if (string.equals("Authorization")) {
                obj1 = 1;
            } else {
                obj1 = 0;
            }
        } else {
        }
        return obj1;
    }

    private static void e(com.iterable.iterableapi.l l, String string2, Exception exception3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nException occurred for : ");
        stringBuilder.append(string2);
        stringBuilder.append(l.c);
        final String obj3 = "IterableRequest";
        j0.c(obj3, stringBuilder.toString());
        j0.d(obj3, exception3.getMessage(), exception3);
    }

    private static boolean f(JSONObject jSONObject, String string2) {
        int i;
        boolean z;
        boolean obj3;
        final String str = "code";
        i = 0;
        if (jSONObject != null && jSONObject.has(str) && jSONObject.getString(str).equals(string2)) {
            if (jSONObject.has(str)) {
                if (jSONObject.getString(str).equals(string2)) {
                    i = 1;
                }
            }
        }
        return i;
    }

    @Override // android.os.AsyncTask
    protected com.iterable.iterableapi.m b(com.iterable.iterableapi.l... lArr) {
        int length;
        Object obj2;
        if (lArr != null && lArr.length > 0) {
            if (lArr.length > 0) {
                this.b = lArr[0];
            }
        }
        return t0.c(this.b);
    }

    @Override // android.os.AsyncTask
    protected Object doInBackground(Object[] objectArr) {
        return b((l[])objectArr);
    }

    @Override // android.os.AsyncTask
    protected void g(com.iterable.iterableapi.m m) {
        boolean z;
        Object uVar;
        int i4;
        int i5;
        int i;
        int str;
        int i2;
        int i3;
        boolean z2 = m.a;
        i5 = 1;
        if (!z2 && m.b >= 500) {
            str = m.b >= 500 ? i5 : 0;
        } else {
        }
        t0 obj5 = new t0();
        obj5.h(i6 += i5);
        i4 = 0;
        i2 = this.a;
        if (str != null && this.a <= 5 && i2 > 2) {
            if (this.a <= 5) {
                obj5 = new t0();
                obj5.h(i6 += i5);
                i4 = 0;
                i2 = this.a;
                if (i2 > 2) {
                    i8 *= i2;
                }
                Handler handler = new Handler();
                t0.a aVar = new t0.a(this, obj5);
                handler.postDelayed(aVar, i4);
            }
        }
        if (z2) {
            j.s().m().j();
            uVar = lVar2.i;
            if (uVar != null) {
                uVar.a(m.d);
            }
        } else {
            if (t0.f(m.d, "InvalidJwtPayload")) {
                j.s().m().i(i5);
            }
            uVar = lVar.j;
            if (uVar != null) {
                uVar.a(m.e, m.d);
            }
        }
        com.iterable.iterableapi.v vVar = lVar3.h;
        if (vVar != null) {
            vVar.a(m.c);
        }
        super.onPostExecute(m);
    }

    @Override // android.os.AsyncTask
    protected void h(int i) {
        this.a = i;
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Object object) {
        g((m)object);
    }
}
