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

import android.os.Bundle;
import edu.mit.media.funf.Utils;
import edu.mit.media.funf.probe.Probe.Parameter.Builtin;
import edu.mit.media.funf.probe.builtin.ProbeKeys.BaseProbeKeys;

public class CellProbeTest extends ProbeTestCase<CellProbe> {

	public CellProbeTest() {
		super(CellProbe.class);
	}
	
	public void testProbe() {
		Bundle params = new Bundle();
		params.putLong(Parameter.Builtin.PERIOD.name, 0L);
		startProbe(params);
		Bundle data = getData(5);
		assertNotNull(data.get(BaseProbeKeys.TIMESTAMP));
		System.out.println(Utils.join(Utils.getValues(data).keySet(), ", "));
	}

}
