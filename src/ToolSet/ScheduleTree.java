package ToolSet;

/*
 * Copyright 2007 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author ycoppel@google.com (Yohann Coppel)
 * 
 * @param <T>
 *          Object's type in the tree.
 */
public class ScheduleTree {
	private List<ScheduleTree> leafs;
	private ScheduleWrapper schedule;

	public ScheduleTree(ScheduleWrapper schedule) {
		this.schedule = schedule;
		this.leafs = new ArrayList<ScheduleTree>();
	}

	public ScheduleTree addLeaf(ScheduleWrapper leaf) {
		ScheduleTree t = new ScheduleTree(leaf);
		leafs.add(t);
		return t;
	}

	public boolean isLeaf() {
		return this.leafs.size() == 0;
	}

	public Collection<ScheduleTree> getSubTrees() {
		return leafs;
	}

	@Override
	public String toString() {
		return printTree(0);
	}

	private static final int indent = 2;

	private String printTree(int increment) {
		String s = "";
		String inc = "";
		for (int i = 0; i < increment; ++i) {
			inc = inc + " ";
		}
		s = inc + schedule;
		for (ScheduleTree child : leafs) {
			s += "\n" + child.printTree(increment + indent);
		}
		return s;
	}
}