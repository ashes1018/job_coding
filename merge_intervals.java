package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
	
	
public class merge_intervals {
	
	class Interval {
	     int start;
	     int end;
	     Interval() { start = 0; end = 0; }
	     Interval(int s, int e) { start = s; end = e; }
		}
	
	class IntervalComparator implements Comparator<Interval>{
		public int compare(Interval i1, Interval i2) {
			return i1.start-i2.start;
		}
	}
	
	public List<Interval> merge(List<Interval> intervals) {
		if(intervals == null || intervals.size() <= 1){
			return intervals;
		}
		Collections.sort(intervals,new IntervalComparator());
		ArrayList<Interval> res = new ArrayList<>();
		Interval prev = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);
			if(prev.end >= cur.start){
				Interval merged = new Interval(prev.start, Math.max(prev.end, cur.end));
				prev = merged;
			}else{
				res.add(prev);
				prev = cur;
			}
		}
		res.add(prev);
		return res;		
    }
	
	public static void main(String[] args) {
		 List<Interval> cur = new ArrayList<Interval>();
		 Interval a = new Interval();
		 
		 
	}

}
