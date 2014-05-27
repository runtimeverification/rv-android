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

final class GetSystemServiceMonitor_Set extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractMonitorSet<GetSystemServiceMonitor> {

	GetSystemServiceMonitor_Set(){
		this.size = 0;
		this.elements = new GetSystemServiceMonitor[4];
	}
	final void event_getLocationService() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			GetSystemServiceMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final GetSystemServiceMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_getLocationService();
				if(monitorfinalMonitor.Prop_1_Category_match) {
					monitorfinalMonitor.Prop_1_handler_match();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_getTextService() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			GetSystemServiceMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final GetSystemServiceMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_getTextService();
				if(monitorfinalMonitor.Prop_1_Category_match) {
					monitorfinalMonitor.Prop_1_handler_match();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_getTelephonyService() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			GetSystemServiceMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final GetSystemServiceMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_getTelephonyService();
				if(monitorfinalMonitor.Prop_1_Category_match) {
					monitorfinalMonitor.Prop_1_handler_match();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_getNotificationService() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			GetSystemServiceMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final GetSystemServiceMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_getNotificationService();
				if(monitorfinalMonitor.Prop_1_Category_match) {
					monitorfinalMonitor.Prop_1_handler_match();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_getStorageService() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			GetSystemServiceMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final GetSystemServiceMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_getStorageService();
				if(monitorfinalMonitor.Prop_1_Category_match) {
					monitorfinalMonitor.Prop_1_handler_match();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
}

interface IGetSystemServiceMonitor extends IMonitor, IDisableHolder {
}

class GetSystemServiceDisableHolder extends DisableHolder implements IGetSystemServiceMonitor {
	GetSystemServiceDisableHolder(long tau) {
		super(tau);
	}

	@Override
	public final boolean isTerminated() {
		return false;
	}

	@Override
	public int getLastEvent() {
		return -1;
	}

	@Override
	public int getState() {
		return -1;
	}

}

class GetSystemServiceMonitor extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractSynchronizedMonitor implements Cloneable, com.runtimeverification.rvmonitor.java.rt.RVMObject, IGetSystemServiceMonitor {
	protected Object clone() {
		try {
			GetSystemServiceMonitor ret = (GetSystemServiceMonitor) super.clone();
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

	int Prop_1_state;
	static final int Prop_1_transition_getLocationService[] = {1, 1, 3, 3};;
	static final int Prop_1_transition_getTextService[] = {1, 1, 3, 3};;
	static final int Prop_1_transition_getTelephonyService[] = {1, 1, 3, 3};;
	static final int Prop_1_transition_getNotificationService[] = {3, 3, 3, 3};;
	static final int Prop_1_transition_getStorageService[] = {3, 2, 3, 3};;

	boolean Prop_1_Category_match = false;

	GetSystemServiceMonitor(long tau) {
		this.tau = tau;
		Prop_1_state = 0;

	}

	@Override
	public final int getState() {
		return Prop_1_state;
	}

	private final long tau;
	private long disable = -1;

	@Override
	public final long getTau() {
		return this.tau;
	}

	@Override
	public final long getDisable() {
		return this.disable;
	}

	@Override
	public final void setDisable(long value) {
		this.disable = value;
	}

	final void Prop_1_event_getLocationService() {
		{
			Log.v("RV-MONITOR", "App is grabbing location service!");
		}
		RVM_lastevent = 0;

		Prop_1_state = Prop_1_transition_getLocationService[Prop_1_state];
		Prop_1_Category_match = Prop_1_state == 2;
	}

	final void Prop_1_event_getTextService() {
		{
			Log.v("RV-MONITOR", "App is grabbing SMS service!");
		}
		RVM_lastevent = 1;

		Prop_1_state = Prop_1_transition_getTextService[Prop_1_state];
		Prop_1_Category_match = Prop_1_state == 2;
	}

	final void Prop_1_event_getTelephonyService() {
		{
			Log.v("RV-MONITOR", "App is grabbing telephony service!");
		}
		RVM_lastevent = 2;

		Prop_1_state = Prop_1_transition_getTelephonyService[Prop_1_state];
		Prop_1_Category_match = Prop_1_state == 2;
	}

	final void Prop_1_event_getNotificationService() {
		{
			Log.v("RV-MONITOR", "App is grabbing notification service!");
		}
		RVM_lastevent = 3;

		Prop_1_state = Prop_1_transition_getNotificationService[Prop_1_state];
		Prop_1_Category_match = Prop_1_state == 2;
	}

	final void Prop_1_event_getStorageService() {
		{
			Log.v("RV-MONITOR", "App is grabbing storage service!");
		}
		RVM_lastevent = 4;

		Prop_1_state = Prop_1_transition_getStorageService[Prop_1_state];
		Prop_1_Category_match = Prop_1_state == 2;
	}

	final void Prop_1_handler_match (){
		{
			Log.v("RV-MONITOR", "Possible data exfiltration risk! Storage service accessed after telephony, location, or text service.");
			if (this.RVM_activity != null) {
				AlertDialog.Builder builder = new AlertDialog.Builder(this.RVM_activity);
				builder.setMessage("Possible data exfiltration event: storage service accessed by application after telephony, SMS, or location.");
				builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int id) {
					}
					});
					builder.create().show();
				}
			}

		}

		final void reset() {
			RVM_lastevent = -1;
			Prop_1_state = 0;
			Prop_1_Category_match = false;
		}

		// RVMRef_x was suppressed to reduce memory overhead

		@Override
		protected final void terminateInternal(int idnum) {
			switch(idnum){
				case 0:
				break;
			}
			switch(RVM_lastevent) {
				case -1:
				return;
				case 0:
				//getLocationService
				return;
				case 1:
				//getTextService
				return;
				case 2:
				//getTelephonyService
				return;
				case 3:
				//getNotificationService
				return;
				case 4:
				//getStorageService
				return;
			}
			return;
		}

		public static int getNumberOfEvents() {
			return 5;
		}

		public static int getNumberOfStates() {
			return 4;
		}

	}

	public final class GetSystemServiceRuntimeMonitor implements com.runtimeverification.rvmonitor.java.rt.RVMObject {
		private static com.runtimeverification.rvmonitor.java.rt.map.RVMMapManager GetSystemServiceMapManager;
		static {
			GetSystemServiceMapManager = new com.runtimeverification.rvmonitor.java.rt.map.RVMMapManager();
			GetSystemServiceMapManager.start();
		}

		// Declarations for the Lock
		static final ReentrantLock GetSystemService_RVMLock = new ReentrantLock();
		static final Condition GetSystemService_RVMLock_cond = GetSystemService_RVMLock.newCondition();

		// Declarations for Timestamps
		private static long GetSystemService_timestamp = 1;

		private static boolean GetSystemService_activated = false;

		// Declarations for Indexing Trees
		private static final Tuple2<GetSystemServiceMonitor_Set, GetSystemServiceMonitor> GetSystemService__Map = new Tuple2<GetSystemServiceMonitor_Set, GetSystemServiceMonitor>(new GetSystemServiceMonitor_Set() , null) ;

		public static int cleanUp() {
			int collected = 0;
			// indexing trees
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

		public static final void getLocationServiceEvent() {
			GetSystemService_activated = true;
			while (!GetSystemService_RVMLock.tryLock()) {
				Thread.yield();
			}

			Tuple2<GetSystemServiceMonitor_Set, GetSystemServiceMonitor> matchedEntry = null;
			{
				// FindOrCreateEntry
				matchedEntry = GetSystemService__Map;
			}
			// D(X) main:1
			GetSystemServiceMonitor matchedLeaf = matchedEntry.getValue2() ;
			if ((matchedLeaf == null) ) {
				if ((matchedLeaf == null) ) {
					// D(X) main:4
					GetSystemServiceMonitor created = new GetSystemServiceMonitor(GetSystemService_timestamp++) ;
					matchedEntry.setValue2(created) ;
					GetSystemServiceMonitor_Set enclosingSet = matchedEntry.getValue1() ;
					enclosingSet.add(created) ;
				}
				// D(X) main:6
				GetSystemServiceMonitor disableUpdatedLeaf = matchedEntry.getValue2() ;
				disableUpdatedLeaf.setDisable(GetSystemService_timestamp++) ;
			}
			// D(X) main:8--9
			GetSystemServiceMonitor_Set stateTransitionedSet = matchedEntry.getValue1() ;
			stateTransitionedSet.event_getLocationService();

			GetSystemService_RVMLock.unlock();
		}

		public static final void getTextServiceEvent() {
			GetSystemService_activated = true;
			while (!GetSystemService_RVMLock.tryLock()) {
				Thread.yield();
			}

			Tuple2<GetSystemServiceMonitor_Set, GetSystemServiceMonitor> matchedEntry = null;
			{
				// FindOrCreateEntry
				matchedEntry = GetSystemService__Map;
			}
			// D(X) main:1
			GetSystemServiceMonitor matchedLeaf = matchedEntry.getValue2() ;
			if ((matchedLeaf == null) ) {
				if ((matchedLeaf == null) ) {
					// D(X) main:4
					GetSystemServiceMonitor created = new GetSystemServiceMonitor(GetSystemService_timestamp++) ;
					matchedEntry.setValue2(created) ;
					GetSystemServiceMonitor_Set enclosingSet = matchedEntry.getValue1() ;
					enclosingSet.add(created) ;
				}
				// D(X) main:6
				GetSystemServiceMonitor disableUpdatedLeaf = matchedEntry.getValue2() ;
				disableUpdatedLeaf.setDisable(GetSystemService_timestamp++) ;
			}
			// D(X) main:8--9
			GetSystemServiceMonitor_Set stateTransitionedSet = matchedEntry.getValue1() ;
			stateTransitionedSet.event_getTextService();

			GetSystemService_RVMLock.unlock();
		}

		public static final void getTelephonyServiceEvent() {
			GetSystemService_activated = true;
			while (!GetSystemService_RVMLock.tryLock()) {
				Thread.yield();
			}

			Tuple2<GetSystemServiceMonitor_Set, GetSystemServiceMonitor> matchedEntry = null;
			{
				// FindOrCreateEntry
				matchedEntry = GetSystemService__Map;
			}
			// D(X) main:1
			GetSystemServiceMonitor matchedLeaf = matchedEntry.getValue2() ;
			if ((matchedLeaf == null) ) {
				if ((matchedLeaf == null) ) {
					// D(X) main:4
					GetSystemServiceMonitor created = new GetSystemServiceMonitor(GetSystemService_timestamp++) ;
					matchedEntry.setValue2(created) ;
					GetSystemServiceMonitor_Set enclosingSet = matchedEntry.getValue1() ;
					enclosingSet.add(created) ;
				}
				// D(X) main:6
				GetSystemServiceMonitor disableUpdatedLeaf = matchedEntry.getValue2() ;
				disableUpdatedLeaf.setDisable(GetSystemService_timestamp++) ;
			}
			// D(X) main:8--9
			GetSystemServiceMonitor_Set stateTransitionedSet = matchedEntry.getValue1() ;
			stateTransitionedSet.event_getTelephonyService();

			GetSystemService_RVMLock.unlock();
		}

		public static final void getNotificationServiceEvent() {
			GetSystemService_activated = true;
			while (!GetSystemService_RVMLock.tryLock()) {
				Thread.yield();
			}

			Tuple2<GetSystemServiceMonitor_Set, GetSystemServiceMonitor> matchedEntry = null;
			{
				// FindOrCreateEntry
				matchedEntry = GetSystemService__Map;
			}
			// D(X) main:1
			GetSystemServiceMonitor matchedLeaf = matchedEntry.getValue2() ;
			if ((matchedLeaf == null) ) {
				if ((matchedLeaf == null) ) {
					// D(X) main:4
					GetSystemServiceMonitor created = new GetSystemServiceMonitor(GetSystemService_timestamp++) ;
					matchedEntry.setValue2(created) ;
					GetSystemServiceMonitor_Set enclosingSet = matchedEntry.getValue1() ;
					enclosingSet.add(created) ;
				}
				// D(X) main:6
				GetSystemServiceMonitor disableUpdatedLeaf = matchedEntry.getValue2() ;
				disableUpdatedLeaf.setDisable(GetSystemService_timestamp++) ;
			}
			// D(X) main:8--9
			GetSystemServiceMonitor_Set stateTransitionedSet = matchedEntry.getValue1() ;
			stateTransitionedSet.event_getNotificationService();

			GetSystemService_RVMLock.unlock();
		}

		public static final void getStorageServiceEvent() {
			GetSystemService_activated = true;
			while (!GetSystemService_RVMLock.tryLock()) {
				Thread.yield();
			}

			Tuple2<GetSystemServiceMonitor_Set, GetSystemServiceMonitor> matchedEntry = null;
			{
				// FindOrCreateEntry
				matchedEntry = GetSystemService__Map;
			}
			// D(X) main:1
			GetSystemServiceMonitor matchedLeaf = matchedEntry.getValue2() ;
			if ((matchedLeaf == null) ) {
				if ((matchedLeaf == null) ) {
					// D(X) main:4
					GetSystemServiceMonitor created = new GetSystemServiceMonitor(GetSystemService_timestamp++) ;
					matchedEntry.setValue2(created) ;
					GetSystemServiceMonitor_Set enclosingSet = matchedEntry.getValue1() ;
					enclosingSet.add(created) ;
				}
				// D(X) main:6
				GetSystemServiceMonitor disableUpdatedLeaf = matchedEntry.getValue2() ;
				disableUpdatedLeaf.setDisable(GetSystemService_timestamp++) ;
			}
			// D(X) main:8--9
			GetSystemServiceMonitor_Set stateTransitionedSet = matchedEntry.getValue1() ;
			stateTransitionedSet.event_getStorageService();

			GetSystemService_RVMLock.unlock();
		}

		public static void onCreateActivity(Activity a) {
			GetSystemServiceMonitor.RVM_activity = a;
		}

	}
