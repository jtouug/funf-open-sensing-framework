/**
 * Funf: Open Sensing Framework
 * Copyright (C) 2010-2011 Nadav Aharony, Wei Pan, Alex Pentland. 
 * Acknowledgments: Alan Gardner
 * Contact: nadav@media.mit.edu
 * 
 * This file is part of Funf.
 * 
 * Funf is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 3 of 
 * the License, or (at your option) any later version. 
 * 
 * Funf is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public 
 * License along with Funf. If not, see <http://www.gnu.org/licenses/>.
 */
package edu.mit.media.funf.probe.builtin;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Parcelable;
import edu.mit.media.funf.probe.Probe.Parameter.Builtin;

public class SMSProbeTest extends ProbeTestCase<SMSProbe> {

	public SMSProbeTest() {
		super(SMSProbe.class);
	}
	
	public void testData() {
		Bundle params = new Bundle();
		params.putLong(Parameter.Builtin.PERIOD.name, 0L);
		startProbe(params);
		Bundle data = getData(10);
		ArrayList<Parcelable> messages = data.getParcelableArrayList(SMSProbe.MESSAGES);
		assertNotNull(messages);
		assertTrue(messages.size() > 0);
		
		// Running again should return an empty result
		startProbe(params);
		data = getData(10);
		messages = data.getParcelableArrayList(SMSProbe.MESSAGES);
		assertNotNull(messages);
		assertTrue(messages.isEmpty());
	}

}
