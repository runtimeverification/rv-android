package me.guillaumin.android.osmtracker.monitors;
import java.io.*;
import android.util.Log;
import android.media.MediaPlayer.OnPreparedListener;
import android.app.AlertDialog;
import android.app.Activity;
import android.content.DialogInterface;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.*;
import java.lang.ref.*;
import com.runtimeverification.rvmonitor.java.rt.*;
import com.runtimeverification.rvmonitor.java.rt.ref.*;
import com.runtimeverification.rvmonitor.java.rt.table.*;
import com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractIndexingTree;
import com.runtimeverification.rvmonitor.java.rt.tablebase.SetEventDelegator;
import com.runtimeverification.rvmonitor.java.rt.tablebase.TableAdopter.Tuple2;
import com.runtimeverification.rvmonitor.java.rt.tablebase.TableAdopter.Tuple3;
import com.runtimeverification.rvmonitor.java.rt.tablebase.IDisableHolder;
import com.runtimeverification.rvmonitor.java.rt.tablebase.IMonitor;
import com.runtimeverification.rvmonitor.java.rt.tablebase.DisableHolder;
import com.runtimeverification.rvmonitor.java.rt.tablebase.TerminatedMonitorCleaner;
import java.util.concurrent.atomic.AtomicInteger;

final class Closeable_MultipleCloseMonitor_Set extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractMonitorSet<Closeable_MultipleCloseMonitor> {
	boolean skipEvent = false;

	Closeable_MultipleCloseMonitor_Set(){
		this.size = 0;
		this.elements = new Closeable_MultipleCloseMonitor[4];
	}
	final void event_close(Closeable c) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			Closeable_MultipleCloseMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final Closeable_MultipleCloseMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_close(c);
				if(monitorfinalMonitor.Prop_1_Category_match) {
					monitorfinalMonitor.Prop_1_handler_match();
				}
				skipEvent |= monitorfinalMonitor.skipEvent;
				monitorfinalMonitor.skipEvent = false;
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
}

class Closeable_MultipleCloseMonitor extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractAtomicMonitor implements Cloneable, com.runtimeverification.rvmonitor.java.rt.RVMObject {
	protected Object clone() {
		try {
			Closeable_MultipleCloseMonitor ret = (Closeable_MultipleCloseMonitor) super.clone();
			return ret;
		}
		catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

	static android.app.Activity RVM_activity;
	static void setActivity(android.app.Activity a) {
		RVM_activity = a;
	}

	boolean skipEvent = false;

	static final int Prop_1_transition_close[] = {1, 2, 2, 3};;

	volatile boolean Prop_1_Category_match = false;

	private final AtomicInteger pairValue;

	Closeable_MultipleCloseMonitor() {
		this.pairValue = new AtomicInteger(this.calculatePairValue(-1, 0) ) ;

	}

	@Override public final int getState() {
		return this.getState(this.pairValue.get() ) ;
	}
	@Override public final int getLastEvent() {
		return this.getLastEvent(this.pairValue.get() ) ;
	}
	private final int getState(int pairValue) {
		return (pairValue & 3) ;
	}
	private final int getLastEvent(int pairValue) {
		return (pairValue >> 2) ;
	}
	private final int calculatePairValue(int lastEvent, int state) {
		return (((lastEvent + 1) << 2) | state) ;
	}

	private final int handleEvent(int eventId, int[] table) {
		int nextstate;
		while (true) {
			int oldpairvalue = this.pairValue.get() ;
			int oldstate = this.getState(oldpairvalue) ;
			nextstate = table [ oldstate ];
			int nextpairvalue = this.calculatePairValue(eventId, nextstate) ;
			if (this.pairValue.compareAndSet(oldpairvalue, nextpairvalue) ) {
				break;
			}
		}
		return nextstate;
	}

	final void Prop_1_event_close(Closeable c) {
		{
			Log.v("RV-MONITOR", "Closeable stream closed! Hashcode " + c.hashCode() + ", class: " + c.getClass());
		}

		int nextstate = this.handleEvent(0, Prop_1_transition_close) ;
		this.Prop_1_Category_match = nextstate == 2;

	}

	final void Prop_1_handler_match (){
		{
			Log.v("RV-MONITOR", "Severe: Multiple close detected.  Recovering.");
			if (this.RVM_activity != null) {
				AlertDialog.Builder builder = new AlertDialog.Builder(this.RVM_activity);
				builder.setMessage("Closeable stream closed too many times!  Skipping second close.");
				builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int id) {
					}
					});
					builder.create().show();
				}
				skipEvent = true;
			}

		}

		final void reset() {
			this.pairValue.set(this.calculatePairValue(-1, 0) ) ;

			Prop_1_Category_match = false;
		}

		// RVMRef_c was suppressed to reduce memory overhead

		//alive_parameters_0 = [Closeable c]
		boolean alive_parameters_0 = true;

		@Override
		protected final void terminateInternal(int idnum) {
			int lastEvent = this.getLastEvent();

			switch(idnum){
				case 0:
				alive_parameters_0 = false;
				break;
			}
			switch(lastEvent) {
				case -1:
				return;
				case 0:
				//close
				//alive_c
				if(!(alive_parameters_0)){
					RVM_terminated = true;
					return;
				}
				break;

			}
			return;
		}

		public static int getNumberOfEvents() {
			return 1;
		}

		public static int getNumberOfStates() {
			return 4;
		}

	}

	public final class Closeable_MultipleCloseRuntimeMonitor implements com.runtimeverification.rvmonitor.java.rt.RVMObject {
		public static boolean skipEvent = false;
		private static com.runtimeverification.rvmonitor.java.rt.map.RVMMapManager Closeable_MultipleCloseMapManager;
		static {
			Closeable_MultipleCloseMapManager = new com.runtimeverification.rvmonitor.java.rt.map.RVMMapManager();
			Closeable_MultipleCloseMapManager.start();
		}

		// Declarations for the Lock
		static final ReentrantLock Closeable_MultipleClose_RVMLock = new ReentrantLock();
		static final Condition Closeable_MultipleClose_RVMLock_cond = Closeable_MultipleClose_RVMLock.newCondition();

		private static boolean Closeable_MultipleClose_activated = false;

		// Declarations for Indexing Trees
		private static Object Closeable_MultipleClose_c_Map_cachekey_c;
		private static Closeable_MultipleCloseMonitor Closeable_MultipleClose_c_Map_cachevalue;
		private static final MapOfMonitor<Closeable_MultipleCloseMonitor> Closeable_MultipleClose_c_Map = new MapOfMonitor<Closeable_MultipleCloseMonitor>(0) ;

		public static int cleanUp() {
			int collected = 0;
			// indexing trees
			collected += Closeable_MultipleClose_c_Map.cleanUpUnnecessaryMappings();
			return collected;
		}

		// Removing terminated monitors from partitioned sets
		static {
			TerminatedMonitorCleaner.start() ;
		}
		// Setting the behavior of the runtime library according to the compile-time option
		static {
			RuntimeOption.enableFineGrainedLock(false) ;
		}

		public static final void closeEvent(Closeable c) {
			Closeable_MultipleClose_activated = true;
			while (!Closeable_MultipleClose_RVMLock.tryLock()) {
				Thread.yield();
			}

			CachedWeakReference wr_c = null;
			MapOfMonitor<Closeable_MultipleCloseMonitor> matchedLastMap = null;
			Closeable_MultipleCloseMonitor matchedEntry = null;
			boolean cachehit = false;
			if ((c == Closeable_MultipleClose_c_Map_cachekey_c) ) {
				matchedEntry = Closeable_MultipleClose_c_Map_cachevalue;
				cachehit = true;
			}
			else {
				wr_c = new CachedWeakReference(c) ;
				{
					// FindOrCreateEntry
					MapOfMonitor<Closeable_MultipleCloseMonitor> itmdMap = Closeable_MultipleClose_c_Map;
					matchedLastMap = itmdMap;
					Closeable_MultipleCloseMonitor node_c = Closeable_MultipleClose_c_Map.getNodeEquivalent(wr_c) ;
					matchedEntry = node_c;
				}
			}
			// D(X) main:1
			if ((matchedEntry == null) ) {
				if ((wr_c == null) ) {
					wr_c = new CachedWeakReference(c) ;
				}
				// D(X) main:4
				Closeable_MultipleCloseMonitor created = new Closeable_MultipleCloseMonitor() ;
				matchedEntry = created;
				matchedLastMap.putNode(wr_c, created) ;
			}
			// D(X) main:8--9
			final Closeable_MultipleCloseMonitor matchedEntryfinalMonitor = matchedEntry;
			matchedEntry.Prop_1_event_close(c);
			if(matchedEntryfinalMonitor.Prop_1_Category_match) {
				matchedEntryfinalMonitor.Prop_1_handler_match();
			}
			skipEvent |= matchedEntryfinalMonitor.skipEvent;
			matchedEntryfinalMonitor.skipEvent = false;

			if ((cachehit == false) ) {
				Closeable_MultipleClose_c_Map_cachekey_c = c;
				Closeable_MultipleClose_c_Map_cachevalue = matchedEntry;
			}

			Closeable_MultipleClose_RVMLock.unlock();
		}

		public static void onCreateActivity(Activity a) {
			Closeable_MultipleCloseMonitor.RVM_activity = a;
		}

	}
