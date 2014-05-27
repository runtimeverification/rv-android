package com.example.myapp;
import android.media.MediaPlayer;
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

final class SetOnPreparedListenerMonitor_Set extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractMonitorSet<SetOnPreparedListenerMonitor> {
	boolean skipEvent = false;

	SetOnPreparedListenerMonitor_Set(){
		this.size = 0;
		this.elements = new SetOnPreparedListenerMonitor[4];
	}
	final void event_setOnPreparedListener() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			SetOnPreparedListenerMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final SetOnPreparedListenerMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_setOnPreparedListener();
				if(monitorfinalMonitor.Prop_1_Category_violation) {
					monitorfinalMonitor.Prop_1_handler_violation();
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
	final void event_start(MediaPlayer m) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			SetOnPreparedListenerMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final SetOnPreparedListenerMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_start(m);
				if(monitorfinalMonitor.Prop_1_Category_violation) {
					monitorfinalMonitor.Prop_1_handler_violation();
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

class SetOnPreparedListenerMonitor extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractAtomicMonitor implements Cloneable, com.runtimeverification.rvmonitor.java.rt.RVMObject {
	protected Object clone() {
		try {
			SetOnPreparedListenerMonitor ret = (SetOnPreparedListenerMonitor) super.clone();
			return ret;
		}
		catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}
	MediaPlayer toFix;

	static android.app.Activity RVM_activity;
	static void setActivity(android.app.Activity a) {
		RVM_activity = a;
	}

	boolean skipEvent = false;

	static final int Prop_1_transition_setOnPreparedListener[] = {2, 3, 2, 3};;
	static final int Prop_1_transition_start[] = {1, 3, 2, 3};;

	volatile boolean Prop_1_Category_violation = false;

	private final AtomicInteger pairValue;

	SetOnPreparedListenerMonitor() {
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

	final void Prop_1_event_setOnPreparedListener() {

		int nextstate = this.handleEvent(0, Prop_1_transition_setOnPreparedListener) ;
		this.Prop_1_Category_violation = nextstate == 1;

	}

	final void Prop_1_event_start(MediaPlayer m) {
		{
			toFix = m;
		}

		int nextstate = this.handleEvent(1, Prop_1_transition_start) ;
		this.Prop_1_Category_violation = nextstate == 1;

	}

	final void Prop_1_handler_violation (){
		{
			AlertDialog.Builder builder = new AlertDialog.Builder(this.RVM_activity);
			builder.setMessage("Media player called without setting the prepared listener, setting listener....");
			builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

				public void onClick(DialogInterface dialog, int id) {
					toFix.setOnPreparedListener(new OnPreparedListener() {

						@Override
						public void onPrepared(MediaPlayer mp) {
							mp.start();
						}
						});
					}
					});
					builder.create().show();
					skipEvent = true;
				}

			}

			final void reset() {
				this.pairValue.set(this.calculatePairValue(-1, 0) ) ;

				Prop_1_Category_violation = false;
			}

			@Override
			protected final void terminateInternal(int idnum) {
				int lastEvent = this.getLastEvent();

				switch(idnum){
				}
				switch(lastEvent) {
					case -1:
					return;
					case 0:
					//setOnPreparedListener
					return;
					case 1:
					//start
					return;
				}
				return;
			}

			public static int getNumberOfEvents() {
				return 2;
			}

			public static int getNumberOfStates() {
				return 4;
			}

		}

		public final class SetOnPreparedListenerRuntimeMonitor implements com.runtimeverification.rvmonitor.java.rt.RVMObject {
			public static boolean skipEvent = false;
			private static com.runtimeverification.rvmonitor.java.rt.map.RVMMapManager SetOnPreparedListenerMapManager;
			static {
				SetOnPreparedListenerMapManager = new com.runtimeverification.rvmonitor.java.rt.map.RVMMapManager();
				SetOnPreparedListenerMapManager.start();
			}

			// Declarations for the Lock
			static final ReentrantLock SetOnPreparedListener_RVMLock = new ReentrantLock();
			static final Condition SetOnPreparedListener_RVMLock_cond = SetOnPreparedListener_RVMLock.newCondition();

			private static boolean SetOnPreparedListener_activated = false;

			// Declarations for Indexing Trees
			private static final SetOnPreparedListenerMonitor SetOnPreparedListener__Map = new SetOnPreparedListenerMonitor() ;

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

			public static final void setOnPreparedListenerEvent() {
				SetOnPreparedListener_activated = true;
				while (!SetOnPreparedListener_RVMLock.tryLock()) {
					Thread.yield();
				}

				SetOnPreparedListenerMonitor matchedEntry = null;
				{
					// FindOrCreateEntry
					matchedEntry = SetOnPreparedListener__Map;
				}
				// D(X) main:1
				if ((matchedEntry == null) ) {
					// D(X) main:4
					SetOnPreparedListenerMonitor created = new SetOnPreparedListenerMonitor() ;
					matchedEntry = created;
				}
				// D(X) main:8--9
				final SetOnPreparedListenerMonitor matchedEntryfinalMonitor = matchedEntry;
				matchedEntry.Prop_1_event_setOnPreparedListener();
				if(matchedEntryfinalMonitor.Prop_1_Category_violation) {
					matchedEntryfinalMonitor.Prop_1_handler_violation();
				}
				skipEvent |= matchedEntryfinalMonitor.skipEvent;
				matchedEntryfinalMonitor.skipEvent = false;

				SetOnPreparedListener_RVMLock.unlock();
			}

			public static final void startEvent(MediaPlayer m) {
				SetOnPreparedListener_activated = true;
				while (!SetOnPreparedListener_RVMLock.tryLock()) {
					Thread.yield();
				}

				SetOnPreparedListenerMonitor matchedEntry = null;
				{
					// FindOrCreateEntry
					matchedEntry = SetOnPreparedListener__Map;
				}
				// D(X) main:1
				if ((matchedEntry == null) ) {
					// D(X) main:4
					SetOnPreparedListenerMonitor created = new SetOnPreparedListenerMonitor() ;
					matchedEntry = created;
				}
				// D(X) main:8--9
				final SetOnPreparedListenerMonitor matchedEntryfinalMonitor = matchedEntry;
				matchedEntry.Prop_1_event_start(m);
				if(matchedEntryfinalMonitor.Prop_1_Category_violation) {
					matchedEntryfinalMonitor.Prop_1_handler_violation();
				}
				skipEvent |= matchedEntryfinalMonitor.skipEvent;
				matchedEntryfinalMonitor.skipEvent = false;

				SetOnPreparedListener_RVMLock.unlock();
			}

			public static void onCreateActivity(Activity a) {
				SetOnPreparedListenerMonitor.RVM_activity = a;
			}

		}
