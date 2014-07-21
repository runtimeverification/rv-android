import java.io.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.*;
import java.lang.ref.*;
import org.aspectj.lang.*;
import android.app.AlertDialog;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Context;
import android.util.Log;

public aspect GetSystemServiceMonitorAspect {
    public GetSystemServiceMonitorAspect() {}

    before (Activity a): (execution(void Activity+.onCreate(..) ) && this(a)) {
      GetSystemServiceRuntimeMonitor.onCreateActivity(a);
    }

    Object around (String s): (call(Object getSystemService(String)) && args(s)) {
        if (s.equals(Context.LOCATION_SERVICE)) { GetSystemServiceRuntimeMonitor.getLocationServiceEvent(); }
        if (s.equals(Context.TEXT_SERVICES_MANAGER_SERVICE)) { GetSystemServiceRuntimeMonitor.getTextServiceEvent(); }
        if (s.equals(Context.TELEPHONY_SERVICE)) { GetSystemServiceRuntimeMonitor.getTelephonyServiceEvent(); }
        if (s.equals(Context.NOTIFICATION_SERVICE)) { GetSystemServiceRuntimeMonitor.getNotificationServiceEvent(); }
        if (s.equals(Context.STORAGE_SERVICE)) { GetSystemServiceRuntimeMonitor.getStorageServiceEvent(); }
        return proceed(s);
    }

}
