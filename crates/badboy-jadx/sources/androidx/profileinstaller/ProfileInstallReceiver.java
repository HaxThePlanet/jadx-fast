package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;

/* loaded from: classes5.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {

    public static final String ACTION_BENCHMARK_OPERATION = "androidx.profileinstaller.action.BENCHMARK_OPERATION";
    public static final String ACTION_INSTALL_PROFILE = "androidx.profileinstaller.action.INSTALL_PROFILE";
    public static final String ACTION_SAVE_PROFILE = "androidx.profileinstaller.action.SAVE_PROFILE";
    public static final String ACTION_SKIP_FILE = "androidx.profileinstaller.action.SKIP_FILE";
    private static final String EXTRA_BENCHMARK_OPERATION = "EXTRA_BENCHMARK_OPERATION";
    private static final String EXTRA_BENCHMARK_OPERATION_DROP_SHADER_CACHE = "DROP_SHADER_CACHE";
    private static final String EXTRA_SKIP_FILE_OPERATION = "EXTRA_SKIP_FILE_OPERATION";
    private static final String EXTRA_SKIP_FILE_OPERATION_DELETE = "DELETE_SKIP_FILE";
    private static final String EXTRA_SKIP_FILE_OPERATION_WRITE = "WRITE_SKIP_FILE";

    class ResultDiagnostics implements androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback {

        final androidx.profileinstaller.ProfileInstallReceiver this$0;
        ResultDiagnostics(androidx.profileinstaller.ProfileInstallReceiver this$0) {
            this.this$0 = this$0;
            super();
        }

        @Override // androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback
        public void onDiagnosticReceived(int code, Object data) {
            ProfileInstaller.LOG_DIAGNOSTICS.onDiagnosticReceived(code, data);
        }

        @Override // androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback
        public void onResultReceived(int code, Object data) {
            ProfileInstaller.LOG_DIAGNOSTICS.onResultReceived(code, data);
            this.this$0.setResultCode(code);
        }
    }
    static void saveProfile(androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback callback) {
        Process.sendSignal(Process.myPid(), 10);
        callback.onResultReceived(12, 0);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        androidx.profileinstaller.ProfileInstallReceiver$$ExternalSyntheticLambda0 resultDiagnostics;
        Object resultDiagnostics4;
        androidx.profileinstaller.ProfileInstallReceiver$$ExternalSyntheticLambda0 resultDiagnostics3;
        androidx.profileinstaller.ProfileInstallReceiver.ResultDiagnostics resultDiagnostics2;
        int i;
        if (intent == null) {
        }
        final String action = intent.getAction();
        if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action) != null) {
            resultDiagnostics = new ProfileInstallReceiver$$ExternalSyntheticLambda0();
            resultDiagnostics4 = new ProfileInstallReceiver.ResultDiagnostics(this);
            ProfileInstaller.writeProfile(context, resultDiagnostics, resultDiagnostics4, true);
        } else {
            if ("androidx.profileinstaller.action.SKIP_FILE".equals(action) != null) {
                resultDiagnostics = intent.getExtras();
                if (resultDiagnostics != null) {
                    resultDiagnostics4 = resultDiagnostics.getString("EXTRA_SKIP_FILE_OPERATION");
                    if ("WRITE_SKIP_FILE".equals(resultDiagnostics4) != null) {
                        resultDiagnostics3 = new ProfileInstallReceiver$$ExternalSyntheticLambda0();
                        resultDiagnostics2 = new ProfileInstallReceiver.ResultDiagnostics(this);
                        ProfileInstaller.writeSkipFile(context, resultDiagnostics3, resultDiagnostics2);
                    } else {
                        if ("DELETE_SKIP_FILE".equals(resultDiagnostics4) != null) {
                            resultDiagnostics3 = new ProfileInstallReceiver$$ExternalSyntheticLambda0();
                            resultDiagnostics2 = new ProfileInstallReceiver.ResultDiagnostics(this);
                            ProfileInstaller.deleteSkipFile(context, resultDiagnostics3, resultDiagnostics2);
                        }
                    }
                }
            } else {
                if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(action) != null) {
                    resultDiagnostics = new ProfileInstallReceiver.ResultDiagnostics(this);
                    ProfileInstallReceiver.saveProfile(resultDiagnostics);
                } else {
                    resultDiagnostics = intent.getExtras();
                    if ("androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) != null && resultDiagnostics != null) {
                        resultDiagnostics = intent.getExtras();
                        if (resultDiagnostics != null) {
                            resultDiagnostics3 = new ProfileInstallReceiver.ResultDiagnostics(this);
                            if ("DROP_SHADER_CACHE".equals(resultDiagnostics.getString("EXTRA_BENCHMARK_OPERATION"))) {
                                BenchmarkOperation.dropShaderCache(context, resultDiagnostics3);
                            } else {
                                resultDiagnostics3.onResultReceived(16, 0);
                            }
                        }
                    }
                }
            }
        }
    }
}
