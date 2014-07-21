import java.io.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.*;
import java.lang.ref.*;
import org.aspectj.lang.*;
import android.app.AlertDialog;
import android.app.Activity;
import android.content.DialogInterface;
import android.util.Log;
import android.database.CursorWrapper;

public aspect Closeable_MultipleCloseMonitorAspect {
    public Closeable_MultipleCloseMonitorAspect() {}

    void around (Closeable c): (call(* Closeable+.close(..)) && target(c)) {
      Closeable_MultipleCloseRuntimeMonitor.closeEvent(c);
      if (!Closeable_MultipleCloseRuntimeMonitor.skipEvent) {
          proceed(c);
      }
    }

}
