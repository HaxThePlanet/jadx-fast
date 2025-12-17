package com.facebook.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.view.autofill.AutofillManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.FacebookException;
import com.facebook.a;
import com.facebook.a.c;
import com.facebook.e0.p;
import com.facebook.internal.g0.i.a;
import com.facebook.n;
import com.facebook.o;
import com.facebook.p;
import com.facebook.p.b;
import com.facebook.p.c;
import com.facebook.s;
import com.facebook.t;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.n;
import kotlin.k0.d;
import kotlin.k0.h;
import kotlin.k0.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Ð\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u000c\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0006\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0015\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u001e\n\u0002\u0008\u0005\n\u0002\u0010\"\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0003\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0014\u0008Æ\u0002\u0018\u00002\u00020\u0001:\u0008ð\u0001ñ\u0001ò\u0001ó\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J*\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020-2\u0008\u0010.\u001a\u0004\u0018\u00010\u00042\u0006\u0010/\u001a\u000200H\u0002J \u00101\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020-2\u0006\u0010/\u001a\u000200H\u0002J'\u00102\u001a\u00020 \"\u0004\u0008\u0000\u001032\u0008\u00104\u001a\u0004\u0018\u0001H32\u0008\u00105\u001a\u0004\u0018\u0001H3H\u0007¢\u0006\u0002\u00106J7\u00107\u001a\u0012\u0012\u0004\u0012\u0002H308j\u0008\u0012\u0004\u0012\u0002H3`9\"\u0004\u0008\u0000\u001032\u0012\u0010:\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H30;\"\u0002H3H\u0007¢\u0006\u0002\u0010<J-\u0010=\u001a\u0008\u0012\u0004\u0012\u0002H30>\"\u0004\u0008\u0000\u001032\u0012\u0010?\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H30;\"\u0002H3H\u0007¢\u0006\u0002\u0010@J\u0012\u0010A\u001a\u0004\u0018\u00010\u001a2\u0006\u0010B\u001a\u00020\u0004H\u0007J&\u0010C\u001a\u00020D2\u0008\u0010E\u001a\u0004\u0018\u00010\u00042\u0008\u0010F\u001a\u0004\u0018\u00010\u00042\u0008\u0010G\u001a\u0004\u0018\u00010HH\u0007J\u0008\u0010I\u001a\u00020*H\u0007J\u0018\u0010J\u001a\u00020*2\u0006\u0010/\u001a\u0002002\u0006\u0010K\u001a\u00020\u0004H\u0002J\u0010\u0010L\u001a\u00020*2\u0006\u0010/\u001a\u000200H\u0007J\u0012\u0010M\u001a\u00020*2\u0008\u0010N\u001a\u0004\u0018\u00010OH\u0007J\u001e\u0010P\u001a\u0004\u0018\u00010\u00042\u0008\u0010Q\u001a\u0004\u0018\u00010\u00042\u0008\u0010R\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010S\u001a\u00020\u00132\u0006\u0010T\u001a\u00020UH\u0002J\u0016\u0010V\u001a\u0008\u0012\u0004\u0012\u00020\u00040>2\u0006\u0010W\u001a\u00020XH\u0007J\u001c\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010Z2\u0006\u0010[\u001a\u00020\u001aH\u0007J\u001c\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040Z2\u0006\u0010[\u001a\u00020\u001aH\u0007J\u001a\u0010]\u001a\u00020\u00062\u0008\u0010^\u001a\u0004\u0018\u00010_2\u0006\u0010`\u001a\u00020aH\u0007J\u0012\u0010b\u001a\u00020*2\u0008\u0010c\u001a\u0004\u0018\u00010dH\u0007J\u0012\u0010e\u001a\u00020*2\u0008\u0010f\u001a\u0004\u0018\u00010gH\u0007J\u0008\u0010h\u001a\u00020 H\u0002J4\u0010i\u001a\n\u0012\u0004\u0012\u0002H3\u0018\u00010>\"\u0004\u0008\u0000\u001032\u000e\u0010j\u001a\n\u0012\u0004\u0012\u0002H3\u0018\u00010>2\u000c\u0010k\u001a\u0008\u0012\u0004\u0012\u0002H30lH\u0007J\u0010\u0010m\u001a\u00020\u00042\u0006\u0010n\u001a\u00020\u0006H\u0007J\u0012\u0010o\u001a\u00020\u00042\u0008\u0010/\u001a\u0004\u0018\u000100H\u0007J\u0010\u0010p\u001a\u00020\u00042\u0006\u0010/\u001a\u000200H\u0007J\n\u0010q\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010r\u001a\u0004\u0018\u00010s2\u0008\u0010t\u001a\u0004\u0018\u00010H2\u0008\u0010u\u001a\u0004\u0018\u00010\u00042\u0006\u0010v\u001a\u00020sH\u0007J\u0010\u0010w\u001a\u00020\u00132\u0006\u0010x\u001a\u00020DH\u0007J\n\u0010y\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010z\u001a\u00020\u00042\u0008\u0010{\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010|\u001a\u00020}2\u0006\u0010B\u001a\u00020\u0004H\u0002J\u0019\u0010~\u001a\u00020*2\u0006\u0010B\u001a\u00020\u00042\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0007J\u0013\u0010\u0081\u0001\u001a\u00020\u00042\u0008\u0010/\u001a\u0004\u0018\u000100H\u0007JL\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u00012\u000c\u0010\u0084\u0001\u001a\u0007\u0012\u0002\u0008\u00030\u0085\u00012\u0007\u0010\u0086\u0001\u001a\u00020\u00042!\u0010\u0087\u0001\u001a\u0011\u0012\r\u0008\u0001\u0012\t\u0012\u0002\u0008\u0003\u0018\u00010\u0085\u00010;\"\t\u0012\u0002\u0008\u0003\u0018\u00010\u0085\u0001H\u0007¢\u0006\u0003\u0010\u0088\u0001JG\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u00012\u0007\u0010\u0089\u0001\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00020\u00042!\u0010\u0087\u0001\u001a\u0011\u0012\r\u0008\u0001\u0012\t\u0012\u0002\u0008\u0003\u0018\u00010\u0085\u00010;\"\t\u0012\u0002\u0008\u0003\u0018\u00010\u0085\u0001H\u0007¢\u0006\u0003\u0010\u008a\u0001J\u0014\u0010\u008b\u0001\u001a\u00020\u00042\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0004H\u0002J(\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010[\u001a\u00020\u001a2\u0008\u0010u\u001a\u0004\u0018\u00010\u00042\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J\u0016\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010DH\u0007J\u0013\u0010\u0091\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u0093\u0001\u001a\u00020\u001aH\u0007J\u001d\u0010\u0094\u0001\u001a\u00020 2\u0008\u00104\u001a\u0004\u0018\u00010\u001a2\u0008\u00105\u001a\u0004\u0018\u00010\u001aH\u0007J\u001c\u0010\u0095\u0001\u001a\u00020\u00042\u0008\u0010\u0096\u0001\u001a\u00030\u0097\u00012\u0007\u0010T\u001a\u00030\u0098\u0001H\u0002J;\u0010\u0099\u0001\u001a\u0014\u0012\u0004\u0012\u0002H30\u009a\u0001j\t\u0012\u0004\u0012\u0002H3`\u009b\u0001\"\u0004\u0008\u0000\u001032\u0012\u0010:\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H30;\"\u0002H3H\u0007¢\u0006\u0003\u0010\u009c\u0001J\u001d\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u009e\u0001\u001a\u00020\u00042\u0007\u0010T\u001a\u00030\u0098\u0001H\u0002J\u001c\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u009e\u0001\u001a\u00020\u00042\u0006\u0010u\u001a\u00020\u0004H\u0002J$\u0010\u009f\u0001\u001a\u0005\u0018\u00010 \u00012\n\u0010¡\u0001\u001a\u0005\u0018\u00010 \u00012\n\u0010¢\u0001\u001a\u0005\u0018\u00010 \u0001H\u0007J?\u0010£\u0001\u001a\u0004\u0018\u00010\u00012\t\u0010¤\u0001\u001a\u0004\u0018\u00010\u00012\u0008\u0010¥\u0001\u001a\u00030\u0083\u00012\u0017\u0010¦\u0001\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00010;\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0003\u0010§\u0001J\u0011\u0010¨\u0001\u001a\u00020 2\u0006\u0010/\u001a\u000200H\u0007J\u0011\u0010©\u0001\u001a\u00020 2\u0006\u0010/\u001a\u000200H\u0007J\u0014\u0010ª\u0001\u001a\u00020 2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010DH\u0007J\u0015\u0010«\u0001\u001a\u00020 2\n\u0010¬\u0001\u001a\u0005\u0018\u00010­\u0001H\u0007J\u0014\u0010®\u0001\u001a\u00020 2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010DH\u0007J\u0011\u0010¯\u0001\u001a\u00020 2\u0006\u0010/\u001a\u000200H\u0002J\u0013\u0010°\u0001\u001a\u00020 2\u0008\u0010Q\u001a\u0004\u0018\u00010\u0004H\u0007J!\u0010°\u0001\u001a\u00020 \"\u0004\u0008\u0000\u001032\u0010\u0010±\u0001\u001a\u000b\u0012\u0004\u0012\u0002H3\u0018\u00010²\u0001H\u0007J3\u0010³\u0001\u001a\u00020 \"\u0004\u0008\u0000\u001032\u0010\u0010´\u0001\u001a\u000b\u0012\u0004\u0012\u0002H3\u0018\u00010²\u00012\u0010\u0010µ\u0001\u001a\u000b\u0012\u0004\u0012\u0002H3\u0018\u00010²\u0001H\u0007J\u0014\u0010¶\u0001\u001a\u00020 2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010DH\u0007J\u0018\u0010·\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040¸\u00012\u0006\u0010W\u001a\u00020XH\u0007J\u0017\u0010¹\u0001\u001a\u0008\u0012\u0004\u0012\u00020\u00040>2\u0006\u0010W\u001a\u00020XH\u0007J\u001e\u0010º\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040Z2\u0007\u0010»\u0001\u001a\u00020\u0004H\u0007J'\u0010¼\u0001\u001a\u00020*2\t\u0010½\u0001\u001a\u0004\u0018\u00010\u00042\u0011\u0010¾\u0001\u001a\u000c\u0018\u00010¿\u0001j\u0005\u0018\u0001`À\u0001H\u0007J\u001f\u0010¼\u0001\u001a\u00020*2\t\u0010½\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010Á\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J+\u0010¼\u0001\u001a\u00020*2\t\u0010½\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010Á\u0001\u001a\u0004\u0018\u00010\u00042\n\u0010Â\u0001\u001a\u0005\u0018\u00010Ã\u0001H\u0007JF\u0010Ä\u0001\u001a\u000b\u0012\u0005\u0012\u0003HÅ\u0001\u0018\u00010>\"\u0004\u0008\u0000\u00103\"\u0005\u0008\u0001\u0010Å\u00012\u000e\u0010j\u001a\n\u0012\u0004\u0012\u0002H3\u0018\u00010>2\u0015\u0010Æ\u0001\u001a\u0010\u0012\u0004\u0012\u0002H3\u0012\u0005\u0012\u0003HÅ\u00010Ç\u0001H\u0007J\"\u0010È\u0001\u001a\u00020\u00042\u0017\u0010Ä\u0001\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040ZH\u0007J\u0013\u0010É\u0001\u001a\u0004\u0018\u00010\u00042\u0006\u0010u\u001a\u00020\u0004H\u0007J\u0011\u0010Ê\u0001\u001a\u00020 2\u0006\u0010/\u001a\u000200H\u0007J\u0014\u0010Ë\u0001\u001a\u00020H2\t\u0010Ì\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J.\u0010Í\u0001\u001a\u00020*2\u0006\u00105\u001a\u00020H2\u0008\u0010u\u001a\u0004\u0018\u00010\u00042\u0011\u0010Î\u0001\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010>H\u0007J&\u0010Ï\u0001\u001a\u00020 2\u0006\u0010t\u001a\u00020H2\u0008\u0010u\u001a\u0004\u0018\u00010\u00042\t\u0010Ð\u0001\u001a\u0004\u0018\u00010\u0001H\u0007J&\u0010Ñ\u0001\u001a\u00020*2\u0006\u00105\u001a\u00020H2\u0008\u0010u\u001a\u0004\u0018\u00010\u00042\t\u0010Ð\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010Ò\u0001\u001a\u00020*2\u0006\u00105\u001a\u00020H2\u0008\u0010u\u001a\u0004\u0018\u00010\u00042\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010DH\u0007J\u0013\u0010Ó\u0001\u001a\u00020\u00042\u0008\u0010^\u001a\u0004\u0018\u00010_H\u0007J%\u0010Ô\u0001\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010Z2\u0008\u0010Õ\u0001\u001a\u00030Ö\u0001H\u0007J\t\u0010×\u0001\u001a\u00020*H\u0002J\t\u0010Ø\u0001\u001a\u00020\u0006H\u0002J\u0012\u0010Ù\u0001\u001a\u00020*2\u0007\u0010Ú\u0001\u001a\u000200H\u0002J\u0012\u0010Û\u0001\u001a\u00020*2\u0007\u0010Ú\u0001\u001a\u000200H\u0002J\t\u0010Ü\u0001\u001a\u00020*H\u0002J\t\u0010Ý\u0001\u001a\u00020*H\u0002J\u0015\u0010Þ\u0001\u001a\u00020*2\n\u0010ß\u0001\u001a\u0005\u0018\u00010à\u0001H\u0007J\u001f\u0010á\u0001\u001a\u00020\u00042\t\u0010â\u0001\u001a\u0004\u0018\u00010\u001a2\t\u0010ã\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J6\u0010ä\u0001\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001a2\u0008\u0010,\u001a\u0004\u0018\u00010-2\u0008\u0010.\u001a\u0004\u0018\u00010\u00042\u0007\u0010å\u0001\u001a\u00020 2\u0006\u0010/\u001a\u000200H\u0007J\u001a\u0010æ\u0001\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001a2\u0007\u0010Ú\u0001\u001a\u000200H\u0007J\u0014\u0010ç\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010T\u001a\u00030\u0098\u0001H\u0007J\u0013\u0010ç\u0001\u001a\u0004\u0018\u00010\u00042\u0006\u0010u\u001a\u00020\u0004H\u0007J\u0016\u0010è\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010T\u001a\u0005\u0018\u00010\u0098\u0001H\u0007J\u0015\u0010è\u0001\u001a\u0004\u0018\u00010\u00042\u0008\u0010u\u001a\u0004\u0018\u00010\u0004H\u0007J\u001d\u0010é\u0001\u001a\u00020 2\u0008\u00104\u001a\u0004\u0018\u00010\u00042\u0008\u00105\u001a\u0004\u0018\u00010\u0004H\u0007J!\u0010ê\u0001\u001a\u0004\u0018\u00010X2\t\u0010â\u0001\u001a\u0004\u0018\u00010\u001a2\t\u0010ë\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J!\u0010ì\u0001\u001a\u0004\u0018\u00010\u001a2\t\u0010â\u0001\u001a\u0004\u0018\u00010\u001a2\t\u0010ë\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J0\u0010í\u0001\u001a\t\u0012\u0004\u0012\u0002H30²\u0001\"\u0004\u0008\u0000\u001032\u0012\u0010:\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H30;\"\u0002H3H\u0007¢\u0006\u0003\u0010î\u0001J.\u0010ï\u0001\u001a\u00020*2\u0008\u0010Õ\u0001\u001a\u00030Ö\u00012\u0019\u0010Ä\u0001\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010ZH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00168G¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a8G¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008!\u0010\u0002\u001a\u0004\u0008\u001f\u0010\"R\u0011\u0010#\u001a\u00020 8G¢\u0006\u0006\u001a\u0004\u0008#\u0010\"R\u000e\u0010$\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010%\u001a\u0004\u0018\u00010\u00168G¢\u0006\u0006\u001a\u0004\u0008&\u0010\u0018R\u000e\u0010'\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006ô\u0001", d2 = {"Lcom/facebook/internal/Utility;", "", "()V", "ARC_DEVICE_PATTERN", "", "DEFAULT_STREAM_BUFFER_SIZE", "", "EXTRA_APP_EVENTS_INFO_FORMAT_VERSION", "FACEBOOK_PROFILE_FIELDS", "HASH_ALGORITHM_MD5", "HASH_ALGORITHM_SHA1", "HASH_ALGORITHM_SHA256", "INSTAGRAM_PROFILE_FIELDS", "LOG_TAG", "NO_CARRIER", "REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS", "URL_SCHEME", "UTF8", "availableExternalStorageGB", "", "carrierName", "currentLocale", "Ljava/util/Locale;", "getCurrentLocale", "()Ljava/util/Locale;", "dataProcessingOptions", "Lorg/json/JSONObject;", "getDataProcessingOptions", "()Lorg/json/JSONObject;", "deviceTimeZoneName", "deviceTimezoneAbbreviation", "isAutoAppLinkSetup", "", "isAutoAppLinkSetup$annotations", "()Z", "isDataProcessingRestricted", "numCPUCores", "resourceLocale", "getResourceLocale", "timestampOfLastCheck", "totalExternalStorageGB", "appendAnonIdUnderCompliance", "", "params", "attributionIdentifiers", "Lcom/facebook/internal/AttributionIdentifiers;", "anonymousAppDeviceGUID", "context", "Landroid/content/Context;", "appendAttributionIdUnderCompliance", "areObjectsEqual", "T", "a", "b", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "arrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "ts", "", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "asListNoNulls", "", "array", "([Ljava/lang/Object;)Ljava/util/List;", "awaitGetGraphMeRequestWithCache", "accessToken", "buildUri", "Landroid/net/Uri;", "authority", "path", "parameters", "Landroid/os/Bundle;", "clearCaches", "clearCookiesForDomain", "domain", "clearFacebookCookies", "closeQuietly", "closeable", "Ljava/io/Closeable;", "coerceValueIfNullOrEmpty", "s", "valueIfNullOrEmpty", "convertBytesToGB", "bytes", "", "convertJSONArrayToList", "jsonArray", "Lorg/json/JSONArray;", "convertJSONObjectToHashMap", "", "jsonObject", "convertJSONObjectToStringMap", "copyAndCloseInputStream", "inputStream", "Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "deleteDirectory", "directoryOrFile", "Ljava/io/File;", "disconnectQuietly", "connection", "Ljava/net/URLConnection;", "externalStorageExists", "filter", "target", "predicate", "Lcom/facebook/internal/Utility$Predicate;", "generateRandomString", "length", "getActivityName", "getAppName", "getAppVersion", "getBundleLongAsDate", "Ljava/util/Date;", "bundle", "key", "dateBase", "getContentSize", "contentUri", "getCurrentTokenDomainWithDefault", "getGraphDomainFromTokenDomain", "tokenGraphDomain", "getGraphMeRequestWithCache", "Lcom/facebook/GraphRequest;", "getGraphMeRequestWithCacheAsync", "callback", "Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", "getMetadataApplicationId", "getMethodQuietly", "Ljava/lang/reflect/Method;", "clazz", "Ljava/lang/Class;", "methodName", "parameterTypes", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "className", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "getProfileFieldsForGraphDomain", "graphDomain", "getStringPropertyAsJSON", "nonJSONPropertyKey", "getUriString", "uri", "handlePermissionResponse", "Lcom/facebook/internal/Utility$PermissionsLists;", "result", "hasSameId", "hashBytes", "hash", "Ljava/security/MessageDigest;", "", "hashSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "([Ljava/lang/Object;)Ljava/util/HashSet;", "hashWithAlgorithm", "algorithm", "intersectRanges", "", "range1", "range2", "invokeMethodQuietly", "receiver", "method", "args", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "isAutofillAvailable", "isChromeOS", "isContentUri", "isCurrentAccessToken", "token", "Lcom/facebook/AccessToken;", "isFileUri", "isGooglePlayServicesAvailable", "isNullOrEmpty", "c", "", "isSubset", "subset", "superset", "isWebUri", "jsonArrayToSet", "", "jsonArrayToStringList", "jsonStrToMap", "str", "logd", "tag", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "t", "", "map", "K", "mapper", "Lcom/facebook/internal/Utility$Mapper;", "mapToJsonStr", "md5hash", "mustFixWindowParamsForAutofill", "parseUrlQueryString", "queryString", "putCommaSeparatedStringList", "list", "putJSONValueInBundle", "value", "putNonEmptyString", "putUri", "readStreamToString", "readStringMapFromParcel", "parcel", "Landroid/os/Parcel;", "refreshAvailableExternalStorage", "refreshBestGuessNumberOfCPUCores", "refreshCarrierName", "appContext", "refreshPeriodicExtendedDeviceInfo", "refreshTimezone", "refreshTotalExternalStorage", "runOnNonUiThread", "runnable", "Ljava/lang/Runnable;", "safeGetStringFromResponse", "response", "propertyName", "setAppEventAttributionParameters", "limitEventUsage", "setAppEventExtendedDeviceInfoParameters", "sha1hash", "sha256hash", "stringsEqualOrEmpty", "tryGetJSONArrayFromResponse", "propertyKey", "tryGetJSONObjectFromResponse", "unmodifiableCollection", "([Ljava/lang/Object;)Ljava/util/Collection;", "writeStringMapToParcel", "GraphMeRequestWithCacheCallback", "Mapper", "PermissionsLists", "Predicate", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class b0 {

    private static int a = 0;
    private static long b = -1L;
    private static long c = -1L;
    private static long d = -1L;
    private static String e = "";
    private static String f = "";
    private static String g = "NoCarrier";
    public static final com.facebook.internal.b0 h;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H&¨\u0006\t", d2 = {"Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", "", "onFailure", "", "error", "Lcom/facebook/FacebookException;", "onSuccess", "userInfo", "Lorg/json/JSONObject;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface a {
        public abstract void a(JSONObject jSONObject);

        public abstract void b(FacebookException facebookException);
    }

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u000c\u0018\u00002\u00020\u0001B/\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0007R \u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR \u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\t\"\u0004\u0008\r\u0010\u000bR \u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\t\"\u0004\u0008\u000f\u0010\u000b¨\u0006\u0010", d2 = {"Lcom/facebook/internal/Utility$PermissionsLists;", "", "grantedPermissions", "", "", "declinedPermissions", "expiredPermissions", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getDeclinedPermissions", "()Ljava/util/List;", "setDeclinedPermissions", "(Ljava/util/List;)V", "getExpiredPermissions", "setExpiredPermissions", "getGrantedPermissions", "setGrantedPermissions", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class b {

        private List<String> a;
        private List<String> b;
        private List<String> c;
        public b(List<String> list, List<String> list2, List<String> list3) {
            n.f(list, "grantedPermissions");
            n.f(list2, "declinedPermissions");
            n.f(list3, "expiredPermissions");
            super();
            this.a = list;
            this.b = list2;
            this.c = list3;
        }

        public final List<String> a() {
            return this.b;
        }

        public final List<String> b() {
            return this.c;
        }

        public final List<String> c() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\u0008\u0007", d2 = {"<anonymous>", "", "dir", "Ljava/io/File;", "kotlin.jvm.PlatformType", "fileName", "", "accept"}, k = 3, mv = {1, 5, 1})
    static final class d implements FilenameFilter {

        public static final com.facebook.internal.b0.d a;
        static {
            b0.d dVar = new b0.d();
            b0.d.a = dVar;
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String string2) {
            return Pattern.matches("cpu[0-9]+", string2);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\u0008\u0004", d2 = {"<anonymous>", "", "response", "Lcom/facebook/GraphResponse;", "onCompleted"}, k = 3, mv = {1, 5, 1})
    static final class c implements p.b {

        final com.facebook.internal.b0.a a;
        final String b;
        c(com.facebook.internal.b0.a b0$a, String string2) {
            this.a = a;
            this.b = string2;
            super();
        }

        @Override // com.facebook.p$b
        public final void b(s s) {
            com.facebook.internal.b0.a aVar;
            JSONObject jSONObject;
            Object obj3;
            n.f(s, "response");
            if (s.b() != null) {
                this.a.b(s.b().e());
            } else {
                jSONObject = s.d();
                if (jSONObject == null) {
                } else {
                    y.b(this.b, jSONObject);
                    this.a.a(s.d());
                }
            }
            obj3 = new IllegalStateException("Required value was null.".toString());
            throw obj3;
        }
    }
    static {
        b0 b0Var = new b0();
        b0.h = b0Var;
    }

    public static final String A(String string) {
        String str;
        String str2;
        int str3;
        int i;
        int i3;
        int i2;
        boolean obj6;
        str = o.o();
        if (string == null) {
            return str;
        }
        str2 = string.hashCode();
        if (str2 != -1253231569) {
            if (str2 != 28903346) {
            } else {
                if (string.equals("instagram")) {
                    str = l.G(str, "facebook.com", "instagram.com", false, 4, 0);
                }
            }
        } else {
            if (string.equals("gaming")) {
                str = l.G(str, "facebook.com", "fb.gg", false, 4, 0);
            }
        }
        return str;
    }

    private final p B(String string) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", G(y()));
        bundle.putString("access_token", string);
        int i = 0;
        p obj4 = p.t.w(i, i);
        obj4.F(bundle);
        obj4.E(t.GET);
        return obj4;
    }

    public static final void C(String string, com.facebook.internal.b0.a b0$a2) {
        n.f(string, "accessToken");
        n.f(a2, "callback");
        JSONObject jSONObject = y.a(string);
        if (jSONObject != null) {
            a2.a(jSONObject);
        }
        b0.c cVar = new b0.c(a2, string);
        final p obj1 = b0.h.B(string);
        obj1.B(cVar);
        obj1.j();
    }

    public static final String D(Context context) {
        c0.j(context, "context");
        return o.g();
    }

    public static final Method E(Class<?> class, String string2, Class<?>... class3Arr3) {
        Method obj1;
        n.f(class, "clazz");
        n.f(string2, "methodName");
        n.f(class3Arr3, "parameterTypes");
        obj1 = class.getMethod(string2, (Class[])Arrays.copyOf(class3Arr3, class3Arr3.length));
        return obj1;
    }

    public static final Method F(String string, String string2, Class<?>... class3Arr3) {
        Method obj1;
        n.f(string, "className");
        n.f(string2, "methodName");
        n.f(class3Arr3, "parameterTypes");
        obj1 = Class.forName(string);
        n.e(obj1, "Class.forName(className)");
        obj1 = b0.E(obj1, string2, (Class[])Arrays.copyOf(class3Arr3, class3Arr3.length));
        return obj1;
    }

    private final String G(String string) {
        String obj2;
        obj2 = n.b(string, "instagram") ? "id,name,profile_picture" : "id,name,first_name,middle_name,last_name";
        return obj2;
    }

    public static final Locale H() {
        Locale locale;
        try {
            Resources resources = o.f().getResources();
            n.e(resources, "FacebookSdk.getApplicationContext().resources");
            locale = configuration.locale;
            int i = 0;
            return locale;
        }
    }

    public static final Object I(JSONObject jSONObject, String string2, String string3) {
        Object obj1;
        String obj2;
        n.f(jSONObject, "jsonObject");
        obj1 = jSONObject.opt(string2);
        if (obj1 != null && obj1 instanceof String != null) {
            if (obj1 instanceof String != null) {
                obj2 = new JSONTokener((String)obj1);
                obj1 = obj2.nextValue();
            }
        }
        if (obj1 != null && obj1 instanceof JSONObject == null && obj1 instanceof JSONArray == null) {
            if (obj1 instanceof JSONObject == null) {
                if (obj1 instanceof JSONArray == null) {
                    if (string3 == null) {
                    } else {
                        obj2 = new JSONObject();
                        obj2.putOpt(string3, obj1);
                        obj1 = obj2;
                    }
                    obj1 = new FacebookException("Got an unexpected non-JSON object.");
                    throw obj1;
                }
            }
        }
        return obj1;
    }

    public static final com.facebook.internal.b0.b J(JSONObject jSONObject) {
        int i;
        JSONObject optJSONObject;
        String optString;
        String str;
        n.f(jSONObject, "result");
        JSONArray obj8 = jSONObject.getJSONObject("permissions").getJSONArray("data");
        ArrayList arrayList = new ArrayList(obj8.length());
        ArrayList arrayList2 = new ArrayList(obj8.length());
        ArrayList arrayList3 = new ArrayList(obj8.length());
        i = 0;
        while (i < obj8.length()) {
            optJSONObject = obj8.optJSONObject(i);
            optString = optJSONObject.optString("permission");
            if (optString != null) {
            }
            i++;
            if (n.b(optString, "installed")) {
            } else {
            }
            optJSONObject = optJSONObject.optString("status");
            if (optJSONObject != null) {
            }
            if (n.b(optJSONObject, "granted")) {
            } else {
            }
            if (n.b(optJSONObject, "declined")) {
            } else {
            }
            if (n.b(optJSONObject, "expired")) {
            }
            arrayList3.add(optString);
            arrayList2.add(optString);
            arrayList.add(optString);
        }
        obj8 = new b0.b(arrayList, arrayList2, arrayList3);
        return obj8;
    }

    private final String K(MessageDigest messageDigest, byte[] b2Arr2) {
        int i;
        String hexString;
        String hexString2;
        messageDigest.update(b2Arr2);
        byte[] obj6 = messageDigest.digest();
        StringBuilder obj7 = new StringBuilder();
        final int i2 = 0;
        i = i2;
        while (i < obj6.length) {
            byte b = obj6[i];
            obj7.append(Integer.toHexString(i5 &= 15));
            obj7.append(Integer.toHexString(i3 &= 15));
            i++;
        }
        obj6 = obj7.toString();
        n.e(obj6, "builder.toString()");
        return obj6;
    }

    private final String L(String string, String string2) {
        Objects.requireNonNull(string2, "null cannot be cast to non-null type java.lang.String");
        final byte[] obj4 = string2.getBytes(d.a);
        n.e(obj4, "(this as java.lang.String).getBytes(charset)");
        return M(string, obj4);
    }

    private final String M(String string, byte[] b2Arr2) {
        try {
            MessageDigest obj2 = MessageDigest.getInstance(string);
            n.e(obj2, "hash");
            return K(obj2, b2Arr2);
            string = null;
            return string;
        }
    }

    public static final Object N(Object object, Method method2, Object... object3Arr3) {
        n.f(method2, "method");
        n.f(object3Arr3, "args");
        int i = 0;
        return method2.invoke(object, Arrays.copyOf(object3Arr3, object3Arr3.length));
    }

    public static final boolean O() {
        PackageManager packageManager;
        final int i = 0;
        Intent intent = new Intent("android.intent.action.VIEW");
        f0 f0Var = f0.a;
        final int i2 = 1;
        Object[] arr = new Object[i2];
        arr[i] = o.g();
        String format = String.format("fb%s://applinks", Arrays.copyOf(arr, i2));
        n.e(format, "java.lang.String.format(format, *args)");
        intent.setData(Uri.parse(format));
        Context context = o.f();
        Iterator iterator = context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
        try {
            for (ResolveInfo next2 : iterator) {
            }
            if (n.b(packageName, activityInfo.packageName) != null) {
            } else {
            }
            return i2;
            return i;
        }
    }

    public static final boolean P(Context context) {
        Class<AutofillManager> autofillSupported;
        int i;
        Object obj3;
        n.f(context, "context");
        if (Build.VERSION.SDK_INT < 26) {
            return 0;
        }
        obj3 = context.getSystemService(AutofillManager.class);
        if (obj3 != null && (AutofillManager)obj3.isAutofillSupported() && obj3.isEnabled()) {
            if (obj3.isAutofillSupported()) {
                if (obj3.isEnabled()) {
                    i = 1;
                }
            }
        }
        return i;
    }

    public static final boolean Q(Context context) {
        String sDK_INT;
        int str;
        boolean obj2;
        n.f(context, "context");
        if (Build.VERSION.SDK_INT >= 27) {
            obj2 = context.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        } else {
            obj2 = Build.DEVICE;
            n.e(obj2, "Build.DEVICE");
            sDK_INT = new h(".+_cheets|cheets_.+");
            if (obj2 != null && sDK_INT.d(obj2)) {
                n.e(obj2, "Build.DEVICE");
                sDK_INT = new h(".+_cheets|cheets_.+");
                obj2 = sDK_INT.d(obj2) ? 1 : 0;
            } else {
            }
        }
        return obj2;
    }

    public static final boolean R(Uri uri) {
        int i;
        String str;
        boolean obj2;
        if (uri != null && l.x("content", uri.getScheme(), true)) {
            if (l.x("content", uri.getScheme(), i)) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public static final boolean S(a a) {
        a aVar;
        Object obj1;
        if (a != null && n.b(a, a.H.e())) {
            obj1 = n.b(a, a.H.e()) ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static final boolean T() {
        Object jSONArray;
        int length;
        int i;
        boolean z;
        String str;
        final int i3 = 0;
        if (a.d(b0.class)) {
            return i3;
        }
        jSONArray = b0.z();
        if (jSONArray != null) {
            jSONArray = jSONArray.getJSONArray("data_processing_options");
            i = i3;
            while (i < jSONArray.length()) {
                String string = jSONArray.getString(i);
                n.e(string, "options.getString(i)");
                String lowerCase = string.toLowerCase();
                n.e(lowerCase, "(this as java.lang.String).toLowerCase()");
                i++;
            }
        }
        try {
            return i3;
            a.b(th, obj0);
            return obj2;
        } catch (Exception e) {
        } catch (Throwable th1) {
        }
    }

    public static final boolean U(Uri uri) {
        int i;
        String str;
        boolean obj2;
        if (uri != null && l.x("file", uri.getScheme(), true) != null) {
            if (l.x("file", uri.getScheme(), i) != null) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private final boolean V(Context context) {
        int i;
        boolean valueOf;
        Object obj6;
        i = 1;
        Class[] arr = new Class[i];
        final int i3 = 0;
        arr[i3] = Context.class;
        Method method = b0.F("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", arr);
        if (method != null) {
            Object[] arr2 = new Object[i];
            arr2[i3] = context;
            obj6 = b0.N(0, method, arr2);
            if (obj6 instanceof Integer && obj6 ^= i == 0) {
                if (obj6 ^= i == 0) {
                } else {
                    i = i3;
                }
            } else {
            }
            return i;
        }
        return i3;
    }

    public static final boolean W(String string) {
        int i;
        int obj2;
        final int i2 = 1;
        if (string != null) {
            obj2 = string.length() == 0 ? i2 : i;
            if (obj2 != null) {
                i = i2;
            }
        } else {
        }
        return i;
    }

    public static final <T> boolean X(Collection<? extends T> collection) {
        int obj0;
        if (collection != null) {
            if (collection.isEmpty()) {
                obj0 = 1;
            } else {
                obj0 = 0;
            }
        } else {
        }
        return obj0;
    }

    public static final boolean Y(Uri uri) {
        int i;
        String str2;
        String str;
        boolean obj3;
        i = 1;
        if (uri != null) {
            if (!l.x("http", uri.getScheme(), i) && !l.x("https", uri.getScheme(), i)) {
                if (!l.x("https", uri.getScheme(), i)) {
                    if (l.x("fbstaging", uri.getScheme(), i)) {
                    } else {
                        i = 0;
                    }
                }
            }
        } else {
        }
        return i;
    }

    public static final Set<String> Z(JSONArray jSONArray) {
        int i;
        String string;
        String str;
        n.f(jSONArray, "jsonArray");
        HashSet hashSet = new HashSet();
        i = 0;
        while (i < jSONArray.length()) {
            string = jSONArray.getString(i);
            n.e(string, "jsonArray.getString(i)");
            hashSet.add(string);
            i++;
        }
        return hashSet;
    }

    private final void a(JSONObject jSONObject, com.facebook.internal.a a2, String string3, Context context4) {
        boolean obj5;
        boolean obj7;
        final String str = "anon_id";
        if (Build.VERSION.SDK_INT >= 31 && V(context4)) {
            if (V(context4)) {
                if (!a2.l()) {
                    jSONObject.put(str, string3);
                }
            } else {
                jSONObject.put(str, string3);
            }
        } else {
        }
    }

    public static final List<String> a0(JSONArray jSONArray) {
        int i;
        String string;
        n.f(jSONArray, "jsonArray");
        ArrayList arrayList = new ArrayList();
        i = 0;
        while (i < jSONArray.length()) {
            arrayList.add(jSONArray.getString(i));
            i++;
        }
        return arrayList;
    }

    private final void b(JSONObject jSONObject, com.facebook.internal.a a2, Context context3) {
        String obj5;
        boolean obj6;
        final String str = "attribution";
        if (Build.VERSION.SDK_INT >= 31 && V(context3)) {
            if (V(context3)) {
                if (!a2.l()) {
                    jSONObject.put(str, a2.j());
                }
            } else {
                jSONObject.put(str, a2.j());
            }
        } else {
        }
    }

    public static final Map<String, String> b0(String string) {
        int hashMap;
        JSONObject jSONObject;
        boolean next;
        String string2;
        String str;
        HashMap obj5;
        n.f(string, "str");
        hashMap = string.length() == 0 ? 1 : 0;
        if (hashMap != null) {
            obj5 = new HashMap();
        } else {
            hashMap = new HashMap();
            jSONObject = new JSONObject(string);
            obj5 = jSONObject.keys();
            for (String next : obj5) {
                n.e(next, "key");
                string2 = jSONObject.getString(next);
                n.e(string2, "jsonObject.getString(key)");
                hashMap.put(next, string2);
            }
            obj5 = hashMap;
        }
        return obj5;
    }

    public static final <T> boolean c(T t, T t2) {
        int obj0;
        if (t == null) {
            obj0 = t2 == null ? 1 : 0;
        } else {
            obj0 = n.b(t, t2);
        }
        return obj0;
    }

    public static final void c0(String string, Exception exception2) {
        boolean stringBuilder;
        String str;
        String obj3;
        if (o.v() && string != null && exception2 != null) {
            if (string != null) {
                if (exception2 != null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(exception2.getClass().getSimpleName());
                    stringBuilder.append(": ");
                    stringBuilder.append(exception2.getMessage());
                    Log.d(string, stringBuilder.toString());
                }
            }
        }
    }

    public static final <T> List<T> d(T... tArr) {
        int i;
        Object obj;
        n.f(tArr, "array");
        ArrayList arrayList = new ArrayList();
        i = 0;
        while (i < tArr.length) {
            obj = tArr[i];
            if (obj != null) {
            }
            i++;
            arrayList.add(obj);
        }
        return arrayList;
    }

    public static final void d0(String string, String string2) {
        if (o.v() && string != null && string2 != null) {
            if (string != null) {
                if (string2 != null) {
                    Log.d(string, string2);
                }
            }
        }
    }

    public static final JSONObject e(String string) {
        int obj1;
        n.f(string, "accessToken");
        JSONObject jSONObject = y.a(string);
        if (jSONObject != null) {
            return jSONObject;
        }
        obj1 = b0.h.B(string).i();
        if (obj1.b() != null) {
            obj1 = 0;
        } else {
            obj1 = obj1.d();
        }
        return obj1;
    }

    public static final void e0(String string, String string2, Throwable throwable3) {
        boolean z;
        if (o.v() && !b0.W(string)) {
            if (!b0.W(string)) {
                Log.d(string, string2, throwable3);
            }
        }
    }

    public static final Uri f(String string, String string2, Bundle bundle3) {
        String str;
        boolean z;
        Object obj3;
        String obj4;
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        builder.authority(string);
        builder.path(string2);
        if (bundle3 != null) {
            obj3 = bundle3.keySet().iterator();
            while (obj3.hasNext()) {
                obj4 = obj3.next();
                str = bundle3.get((String)obj4);
                if (str instanceof String != null) {
                }
                builder.appendQueryParameter(obj4, (String)str);
            }
        }
        obj3 = builder.build();
        n.e(obj3, "builder.build()");
        return obj3;
    }

    public static final String f0(Map<String, String> map) {
        boolean jSONObject;
        String str;
        boolean value;
        Object key;
        Object obj4;
        n.f(map, "map");
        str = "";
        if (map.isEmpty()) {
        } else {
            jSONObject = new JSONObject();
            obj4 = map.entrySet().iterator();
            for (Map.Entry next : obj4) {
                jSONObject.put((String)next.getKey(), (String)next.getValue());
            }
            n.e(jSONObject.toString(), "try {\n        val jsonOb…ion) {\n        \"\"\n      }");
        }
        return str;
    }

    private final void g(Context context, String string2) {
        String cookie;
        int i;
        String str;
        int length;
        int i2;
        int string;
        int stringBuilder;
        int i9;
        int i6;
        int i5;
        int i4;
        int i3;
        int i7;
        int i10;
        int i8;
        CookieSyncManager.createInstance(context).sync();
        CookieManager obj14 = CookieManager.getInstance();
        cookie = obj14.getCookie(string2);
        if (cookie != null) {
            i = 0;
            cookie = l.E0(cookie, /* result */, false, 0, 6, 0).toArray(new String[i]);
            str = "null cannot be cast to non-null type kotlin.Array<T>";
            Objects.requireNonNull(cookie, str);
            i2 = i;
            while (i2 < cookie.length) {
                string = l.E0((String[])cookie[i2], /* result */, false, 0, 6, 0).toArray(new String[i]);
                Objects.requireNonNull(string, str);
                if (string.length > 0) {
                }
                i2++;
                stringBuilder = new StringBuilder();
                Object obj2 = (String[])string[i];
                i5 = 1;
                length2 -= i5;
                i3 = i4;
                while (i4 <= i6) {
                    if (i3 == 0) {
                    } else {
                    }
                    i10 = i6;
                    if (n.h(obj2.charAt(i10), 32) <= 0) {
                    } else {
                    }
                    i7 = i;
                    if (i3 != 0) {
                        break loop_5;
                    } else {
                    }
                    if (i7 == 0) {
                        break loop_5;
                    } else {
                    }
                    i6--;
                    if (i7 == 0) {
                    } else {
                    }
                    i4++;
                    i3 = i5;
                    i7 = i5;
                    i10 = i4;
                }
                stringBuilder.append(obj2.subSequence(i4, i6++).toString());
                stringBuilder.append("=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
                obj14.setCookie(string2, stringBuilder.toString());
                if (i3 == 0) {
                } else {
                }
                i10 = i6;
                if (n.h(obj2.charAt(i10), 32) <= 0) {
                } else {
                }
                i7 = i;
                if (i3 == 0) {
                } else {
                }
                if (i7 == 0) {
                } else {
                }
                i6--;
                if (i7 == 0) {
                } else {
                }
                i4++;
                i3 = i5;
                i7 = i5;
                i10 = i4;
            }
            obj14.removeExpiredCookie();
        }
    }

    public static final String g0(String string) {
        n.f(string, "key");
        return b0.h.L("MD5", string);
    }

    public static final void h(Context context) {
        n.f(context, "context");
        com.facebook.internal.b0 b0Var = b0.h;
        b0Var.g(context, "facebook.com");
        b0Var.g(context, ".facebook.com");
        b0Var.g(context, "https://facebook.com");
        b0Var.g(context, "https://.facebook.com");
    }

    public static final boolean h0(Context context) {
        n.f(context, "context");
        return b0.P(context);
    }

    public static final void i(Closeable closeable) {
        if (closeable != null) {
            closeable.close();
        }
        try {
        }
    }

    public static final Bundle i0(String string) {
        boolean z;
        String str2;
        int length2;
        int i;
        Throwable decode;
        String length;
        int i2;
        String str;
        int i4;
        int i3;
        String obj11;
        Bundle bundle = new Bundle();
        if (!b0.W(string)) {
            if (string == null) {
            } else {
                z = 0;
                obj11 = l.E0(string, /* result */, false, 0, 6, 0).toArray(new String[z]);
                str2 = "null cannot be cast to non-null type kotlin.Array<T>";
                Objects.requireNonNull(obj11, str2);
                i = z;
                while (i < obj11.length) {
                    decode = l.E0((String[])obj11[i], /* result */, false, 0, 6, 0).toArray(new String[z]);
                    Objects.requireNonNull(decode, str2);
                    str = "UTF-8";
                    i4 = 1;
                    if (decode.length == 2) {
                    } else {
                    }
                    if (decode.length == i4) {
                    }
                    i++;
                    bundle.putString(URLDecoder.decode((String[])decode[z], str), "");
                    bundle.putString(URLDecoder.decode(decode[z], str), URLDecoder.decode(decode[i4], str));
                    b0.c0("FacebookSDK", decode);
                }
            }
            obj11 = new IllegalStateException("Required value was null.".toString());
            throw obj11;
        }
        return bundle;
    }

    public static final String j(String string, String string2) {
        String obj1;
        if (b0.W(string)) {
            obj1 = string2;
        }
        return obj1;
    }

    public static final boolean j0(Bundle bundle, String string2, Object object3) {
        String doubleValue;
        Object obj4;
        n.f(bundle, "bundle");
        if (object3 == null) {
            bundle.remove(string2);
            return 1;
        } else {
            if (object3 instanceof Boolean) {
                bundle.putBoolean(string2, (Boolean)object3.booleanValue());
            } else {
                if (object3 instanceof boolean[]) {
                    bundle.putBooleanArray(string2, (boolean[])object3);
                } else {
                    if (object3 instanceof Double) {
                        bundle.putDouble(string2, (Number)object3.doubleValue());
                    } else {
                        if (object3 instanceof double[]) {
                            bundle.putDoubleArray(string2, (double[])object3);
                        } else {
                            if (object3 instanceof Integer) {
                                bundle.putInt(string2, (Number)object3.intValue());
                            } else {
                                if (object3 instanceof int[]) {
                                    bundle.putIntArray(string2, (int[])object3);
                                } else {
                                    if (object3 instanceof Long) {
                                        bundle.putLong(string2, (Number)object3.longValue());
                                    } else {
                                        if (object3 instanceof long[]) {
                                            bundle.putLongArray(string2, (long[])object3);
                                        } else {
                                            if (object3 instanceof String != null) {
                                                bundle.putString(string2, (String)object3);
                                            } else {
                                                if (object3 instanceof JSONArray != null) {
                                                    bundle.putString(string2, object3.toString());
                                                } else {
                                                    if (object3 instanceof JSONObject != null) {
                                                        bundle.putString(string2, object3.toString());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    private final long k(double d) {
        return Math.round(d /= l);
    }

    public static final void k0(Bundle bundle, String string2, String string3) {
        n.f(bundle, "b");
        if (!b0.W(string3)) {
            bundle.putString(string2, string3);
        }
    }

    public static final List<String> l(JSONArray jSONArray) {
        ArrayList arrayList;
        int i;
        String string;
        String str;
        n.f(jSONArray, "jsonArray");
        arrayList = new ArrayList();
        i = 0;
        while (i < jSONArray.length()) {
            string = jSONArray.getString(i);
            n.e(string, "jsonArray.getString(i)");
            arrayList.add(string);
            i++;
        }
        return arrayList;
    }

    public static final void l0(Bundle bundle, String string2, Uri uri3) {
        String obj3;
        n.f(bundle, "b");
        if (uri3 != null) {
            b0.k0(bundle, string2, uri3.toString());
        }
    }

    public static final Map<String, Object> m(JSONObject jSONObject) {
        int i;
        int length;
        String string;
        Object obj;
        String str;
        n.f(jSONObject, "jsonObject");
        HashMap hashMap = new HashMap();
        final JSONArray names = jSONObject.names();
        if (names != null) {
            i = 0;
            while (i < names.length()) {
                string = names.getString(i);
                n.e(string, "keys.getString(i)");
                obj = jSONObject.get(string);
                if (obj instanceof JSONObject != null) {
                }
                n.e(obj, "value");
                hashMap.put(string, obj);
                i++;
                obj = b0.m((JSONObject)obj);
            }
        }
        return hashMap;
    }

    public static final String m0(InputStream inputStream) {
        Throwable th2;
        int read;
        int i;
        Throwable th;
        int i2 = 0;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        InputStreamReader obj6 = new InputStreamReader(bufferedInputStream);
        StringBuilder stringBuilder = new StringBuilder();
        char[] cArr = new char[2048];
        try {
            read = obj6.read(cArr);
            while (read != -1) {
                stringBuilder.append(cArr, 0, read);
                read = obj6.read(cArr);
            }
            stringBuilder.append(cArr, 0, read);
            String string = stringBuilder.toString();
            n.e(string, "stringBuilder.toString()");
            b0.i(bufferedInputStream);
            b0.i(obj6);
            return string;
            Throwable th3 = inputStream;
            inputStream = th;
        } catch (Throwable th) {
        }
        b0.i(th2);
        b0.i(inputStream);
        throw th3;
    }

    public static final Map<String, String> n(JSONObject jSONObject) {
        Object next;
        String optString;
        String str;
        n.f(jSONObject, "jsonObject");
        HashMap hashMap = new HashMap();
        final Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            next = keys.next();
            optString = jSONObject.optString((String)next);
            if (optString != null) {
            }
            n.e(next, "key");
            hashMap.put(next, optString);
        }
        return hashMap;
    }

    public static final Map<String, String> n0(Parcel parcel) {
        int i;
        String string;
        String string2;
        n.f(parcel, "parcel");
        int int = parcel.readInt();
        if (int < 0) {
            return 0;
        }
        HashMap hashMap = new HashMap();
        i = 0;
        while (i < int) {
            hashMap.put(parcel.readString(), parcel.readString());
            i++;
        }
        return hashMap;
    }

    public static final int o(InputStream inputStream, OutputStream outputStream2) {
        int i2;
        int read;
        int i;
        n.f(outputStream2, "outputStream");
        int i3 = 0;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] bArr = new byte[8192];
        final int i5 = 0;
        i2 = i5;
        read = bufferedInputStream.read(bArr);
        while (read != -1) {
            outputStream2.write(bArr, i5, read);
            i2 += read;
            read = bufferedInputStream.read(bArr);
        }
        bufferedInputStream.close();
        if (inputStream != null) {
            inputStream.close();
        }
        return i2;
    }

    private final void o0() {
        boolean z;
        StatFs statFs;
        int i;
        try {
            if (q()) {
            }
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            n.e(externalStorageDirectory, "path");
            statFs = new StatFs(externalStorageDirectory.getPath());
            b0.d = l3 *= z;
            b0.d = k((double)l);
        }
    }

    public static final void p(URLConnection uRLConnection) {
        boolean z;
        if (uRLConnection != null && uRLConnection instanceof HttpURLConnection) {
            if (uRLConnection instanceof HttpURLConnection) {
                (HttpURLConnection)uRLConnection.disconnect();
            }
        }
    }

    private final int p0() {
        File[] listFiles;
        int i;
        com.facebook.internal.b0.d dVar;
        int i2 = b0.a;
        if (i2 > 0) {
            return i2;
        }
        File file = new File("/sys/devices/system/cpu/");
        listFiles = file.listFiles(b0.d.a);
        if (listFiles != null) {
            b0.a = listFiles.length;
        }
        if (b0.a <= 0) {
            try {
                b0.a = Math.max(Runtime.getRuntime().availableProcessors(), 1);
                return b0.a;
            }
        }
    }

    private final boolean q() {
        return n.b("mounted", Environment.getExternalStorageState());
    }

    private final void q0(Context context) {
        boolean str;
        String obj3;
        if (n.b(b0.g, "NoCarrier")) {
            obj3 = context.getSystemService("phone");
            if (obj3 == null) {
            } else {
                obj3 = (TelephonyManager)obj3.getNetworkOperatorName();
                n.e(obj3, "telephonyManager.networkOperatorName");
                b0.g = obj3;
            }
            obj3 = new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
            throw obj3;
        }
    }

    public static final String r(int i) {
        Random random = new Random();
        BigInteger bigInteger = new BigInteger(i *= 5, random);
        String obj2 = bigInteger.toString(32);
        n.e(obj2, "BigInteger(length * 5, r).toString(32)");
        return obj2;
    }

    private final void r0(Context context) {
        int currentTimeMillis;
        long i;
        if (Long.compare(l, i) != 0) {
            if (Long.compare(i2, i) >= 0) {
                b0.b = System.currentTimeMillis();
                s0();
                q0(context);
                t0();
                o0();
            }
        } else {
        }
    }

    public static final String s(Context context) {
        Object applicationContext;
        String obj1;
        if (context == null) {
            obj1 = "null";
        } else {
            if (context == context.getApplicationContext()) {
                obj1 = "unknown";
            } else {
                n.e(context.getClass().getSimpleName(), "context.javaClass.simpleName");
            }
        }
        return obj1;
    }

    private final void s0() {
        try {
            TimeZone default = TimeZone.getDefault();
            Date date = new Date();
            String displayName = default.getDisplayName(default.inDaylightTime(date), 0);
            n.e(displayName, "tz.getDisplayName(tz.inD…(Date()), TimeZone.SHORT)");
            b0.e = displayName;
            n.e(default, "tz");
            String iD = default.getID();
            n.e(iD, "tz.id");
            b0.f = iD;
        }
    }

    public static final String t(Context context) {
        Object applicationInfo;
        String obj2;
        n.f(context, "context");
        String str2 = o.h();
        if (str2 != null) {
            return str2;
        }
        applicationInfo = context.getApplicationInfo();
        final int labelRes = applicationInfo.labelRes;
        if (labelRes == 0) {
            obj2 = applicationInfo.nonLocalizedLabel.toString();
        } else {
            n.e(context.getString(labelRes), "context.getString(stringId)");
        }
        return obj2;
    }

    private final void t0() {
        boolean z;
        StatFs statFs;
        int i;
        try {
            if (q()) {
            }
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            n.e(externalStorageDirectory, "path");
            statFs = new StatFs(externalStorageDirectory.getPath());
            b0.c = l3 *= z;
            b0.c = k((double)l);
        }
    }

    public static final String u() {
        Object packageInfo;
        String packageName;
        int i;
        packageInfo = o.f();
        packageInfo = packageInfo.getPackageManager().getPackageInfo(packageInfo.getPackageName(), 0);
        if (packageInfo != null && packageInfo != null) {
            packageInfo = packageInfo.getPackageManager().getPackageInfo(packageInfo.getPackageName(), 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
        }
        return null;
    }

    public static final void u0(Runnable runnable) {
        try {
            o.n().execute(runnable);
        }
    }

    public static final Date v(Bundle bundle, String string2, Date date3) {
        int date;
        int i2;
        int i;
        long obj5;
        boolean obj6;
        n.f(date3, "dateBase");
        int i3 = 0;
        if (bundle == null) {
            return i3;
        }
        obj5 = bundle.get(string2);
        if (obj5 instanceof Long) {
            obj5 = (Number)obj5.longValue();
            if (Long.compare(obj5, i4) == 0) {
                obj5 = new Date(Long.MAX_VALUE, date3);
            } else {
                date = new Date(time += obj5, obj2);
                obj5 = date;
            }
            return obj5;
        } else {
            if (obj5 instanceof String != null) {
                obj5 = Long.parseLong((String)obj5);
            }
        }
        return i3;
    }

    public static final void v0(JSONObject jSONObject, com.facebook.internal.a a2, String string3, boolean z4, Context context5) {
        boolean str;
        int i;
        Object obj4;
        Object obj5;
        boolean obj6;
        n.f(jSONObject, "params");
        n.f(context5, "context");
        com.facebook.internal.l.b serviceUpdateCompliance = l.b.ServiceUpdateCompliance;
        if (!l.g(serviceUpdateCompliance)) {
            jSONObject.put("anon_id", string3);
        }
        i = 1;
        jSONObject.put("application_tracking_enabled", z4 ^= i);
        jSONObject.put("advertiser_id_collection_enabled", o.e());
        if (a2 != null && l.g(serviceUpdateCompliance)) {
            if (l.g(serviceUpdateCompliance)) {
                b0.h.a(jSONObject, a2, string3, context5);
            }
            if (a2.j() != null) {
                if (l.g(serviceUpdateCompliance)) {
                    b0.h.b(jSONObject, a2, context5);
                } else {
                    jSONObject.put("attribution", a2.j());
                }
            }
            if (a2.h() != null) {
                jSONObject.put("advertiser_id", a2.h());
                jSONObject.put("advertiser_tracking_enabled", obj5 ^= i);
            }
            if (!a2.l()) {
                obj5 = p.d();
                if (obj5.length() == 0) {
                } else {
                    i = 0;
                }
                if (i == 0) {
                    jSONObject.put("ud", obj5);
                }
            }
            if (a2.i() != null) {
                jSONObject.put("installer_package", a2.i());
            }
        }
    }

    public static final long w(Uri uri) {
        n.f(uri, "contentUri");
        int i = 0;
        Cursor query = o.f().getContentResolver().query(uri, 0, 0, 0, 0);
        if (query == null) {
            return 0;
        }
        query.moveToFirst();
        query.close();
        return query.getLong(query.getColumnIndex("_size"));
    }

    public static final void w0(JSONObject jSONObject, Context context2) {
        Locale locale;
        boolean widthPixels;
        int i;
        int i2;
        String versionName;
        int defaultDisplay;
        Object obj8;
        n.f(jSONObject, "params");
        n.f(context2, "appContext");
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("a2");
        b0.h.r0(context2);
        String packageName = context2.getPackageName();
        i = 0;
        int i3 = -1;
        android.content.pm.PackageInfo packageInfo = context2.getPackageManager().getPackageInfo(packageName, i);
        if (packageInfo != null) {
            versionName = packageInfo.versionName;
            jSONArray.put(packageName);
            jSONArray.put(packageInfo.versionCode);
            jSONArray.put(versionName);
            jSONArray.put(Build.VERSION.RELEASE);
            jSONArray.put(Build.MODEL);
            Resources resources = context2.getResources();
            n.e(resources, "appContext.resources");
            locale = configuration.locale;
            StringBuilder stringBuilder = new StringBuilder();
            n.e(locale, "locale");
            stringBuilder.append(locale.getLanguage());
            String str13 = "_";
            stringBuilder.append(str13);
            stringBuilder.append(locale.getCountry());
            jSONArray.put(stringBuilder.toString());
            jSONArray.put(b0.e);
            jSONArray.put(b0.g);
            i2 = 0;
            defaultDisplay = 0;
            if (Build.VERSION.SDK_INT >= 17) {
                if (obj8 instanceof DisplayManager == null) {
                    obj8 = defaultDisplay;
                }
                if ((DisplayManager)obj8 != null) {
                    defaultDisplay = (DisplayManager)obj8.getDisplay(i);
                }
            } else {
                if (obj8 instanceof WindowManager == null) {
                    obj8 = defaultDisplay;
                }
                if ((WindowManager)obj8 != null) {
                    defaultDisplay = (WindowManager)obj8.getDefaultDisplay();
                }
            }
            if (defaultDisplay != 0) {
                obj8 = new DisplayMetrics();
                defaultDisplay.getMetrics(obj8);
                i2 = (double)obj8;
                obj8 = heightPixels;
                i = widthPixels;
            } else {
                obj8 = i;
            }
            jSONArray.put(i);
            jSONArray.put(obj8);
            obj8 = new DecimalFormat("#.##");
            jSONArray.put(obj8.format(i2));
            jSONArray.put(b0.h.p0());
            jSONArray.put(b0.c);
            jSONArray.put(b0.d);
            jSONArray.put(b0.f);
            jSONObject.put("extinfo", jSONArray.toString());
        }
    }

    public static final Locale x() {
        Locale default;
        String str;
        if (b0.H() != null) {
        } else {
            n.e(Locale.getDefault(), "Locale.getDefault()");
        }
        return default;
    }

    public static final String x0(byte[] bArr) {
        n.f(bArr, "bytes");
        return b0.h.M("SHA-1", bArr);
    }

    private final String y() {
        String str;
        String str2;
        a aVar = a.H.e();
        if (aVar != null && aVar.i() != null) {
            if (aVar.i() != null) {
                str = aVar.i();
            } else {
                str = "facebook";
            }
        } else {
        }
        return str;
    }

    public static final String y0(String string) {
        com.facebook.internal.b0 b0Var;
        String str;
        int obj2;
        if (string == null) {
            obj2 = 0;
        } else {
            obj2 = b0.h.L("SHA-256", string);
        }
        return obj2;
    }

    public static final JSONObject z() {
        final int i = 0;
        if (a.d(b0.class)) {
            return i;
        }
        String string = o.f().getSharedPreferences("com.facebook.sdk.DataProcessingOptions", 0).getString("data_processing_options", i);
        if (string != null) {
            JSONObject jSONObject = new JSONObject(string);
            return jSONObject;
        }
        return i;
    }

    public static final void z0(Parcel parcel, Map<String, String> map2) {
        String next;
        int value;
        Object key;
        int obj3;
        n.f(parcel, "parcel");
        if (map2 == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(map2.size());
            obj3 = map2.entrySet().iterator();
            for (Map.Entry next2 : obj3) {
                parcel.writeString((String)next2.getKey());
                parcel.writeString((String)next2.getValue());
            }
        }
    }
}
