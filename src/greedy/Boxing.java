package greedy;

import java.util.ArrayList;

public class Boxing {
	
	public static void main(String[] args){
		int[] a = {29000, 29005};
		int[] b = {30000, 35000};
		int[] c = {29815, 180000};
		int[] d = {29999, 31000};
		int[] e = {3000, 30500};
		Boxing boxer = new Boxing();
		System.out.println(boxer.maxCredit(a,b,c,d,e));
	}
	
	public int maxCredit(int[] a, int[] b, int[] c, int[] d, int[] e){
		return maxCredit(getList(a), getList(b), getList(c), getList(d), getList(e));
	}
	
	public int maxCredit(ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c, ArrayList<Integer> d, ArrayList<Integer> e){
		int credit = 0;
		while(stillExist(a,b,c,d,e) >= 3){
			ArrayList<Integer> minList = getMinFirstElementList(a,b,c,d,e);
			int min = minList.get(0);
			int[] interval = {min, min};
			if(takeCredit(interval,a,b,c,d,e)){
				credit++;
				removeRelatedElement(interval,a,b,c,d,e);
			}else{
				interval[1] = min++;
				if(takeCredit(interval,a,b,c,d,e)){
					credit++;
					removeRelatedElement(interval,a,b,c,d,e);
				}else 
					minList.remove(0);
			}
		}
		return credit;
	}
	
	private void removeRelatedElement(int[] interval, ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c, ArrayList<Integer> d, ArrayList<Integer> e) {
		if(interval[0] == interval[1]){
			if(a.size() > 0){
				if(a.get(0) == interval[0]) a.remove(0);
			}
			if(b.size() > 0){
				if(b.get(0) == interval[0]) b.remove(0);
			}
			if(c.size() > 0){
				if(c.get(0) == interval[0]) c.remove(0);
			}
			if(d.size() > 0){
				if(d.get(0) == interval[0]) d.remove(0);
			}
			if(e.size() > 0){
				if(e.get(0) == interval[0]) e.remove(0);
			}
		}else{
			if(a.size() > 0){
				if(a.get(0) >= interval[0] && a.get(0) <= interval[1]) a.remove(0);		
			}
			if(b.size() > 0){
				if(b.get(0) >= interval[0] && b.get(0) <= interval[1]) b.remove(0);		
			}
			if(c.size() > 0){
				if(c.get(0) >= interval[0] && c.get(0) <= interval[1]) c.remove(0);		
			}
			if(d.size() > 0){
				if(d.get(0) >= interval[0] && d.get(0) <= interval[1]) d.remove(0);		
			}
			if(e.size() > 0){
				if(e.get(0) >= interval[0] && e.get(0) <= interval[1]) e.remove(0);		
			}
		}	
	}

	public boolean takeCredit(int[] interval, ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c, ArrayList<Integer> d, ArrayList<Integer> e){
		
		if(interval[0] == interval[1]){
			int count = 0;
			if(a.size() > 0){
				if(a.get(0) == interval[0]) count++;
			}
			if(b.size() > 0){
				if(b.get(0) == interval[0]) count++;
			}
			if(c.size() > 0){
				if(c.get(0) == interval[0]) count++;
			}
			if(d.size() > 0){
				if(d.get(0) == interval[0]) count++;
			}
			if(e.size() > 0){
				if(e.get(0) == interval[0]) count++;
			}
			if(count >= 3) return true;
		}else{
			int count = 0;
			if(a.size() > 0){
				if(a.get(0) >= interval[0] && a.get(0) <= interval[1]) count++;
			}
			if(b.size() > 0){
				if(b.get(0) >= interval[0] && b.get(0) <= interval[1]) count++;
			}
			if(c.size() > 0){
				if(c.get(0) >= interval[0] && c.get(0) <= interval[1]) count++;
			}
			if(d.size() > 0){
				if(d.get(0) >= interval[0] && d.get(0) <= interval[1]) count++;
			}
			if(e.size() > 0){
				if(e.get(0) >= interval[0] && e.get(0) <= interval[1]) count++;
			}
			if(count >= 3) return true;
		}
		return false;
	}
	
	public ArrayList<Integer> getMinFirstElementList(ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c, ArrayList<Integer> d, ArrayList<Integer> e){
		ArrayList<Integer> min = new ArrayList<Integer>();
		min.add(Integer.MAX_VALUE);
		if(a.size() > 0){
			if(a.get(0) < min.get(0)) min = a;
		}
		if(b.size() > 0){
			if(b.get(0) < min.get(0)) min = b;
		}
		if(c.size() > 0){
			if(c.get(0) < min.get(0)) min = c;
		}
		if(d.size() > 0){
			if(d.get(0) < min.get(0)) min = d;
		}
		if(e.size() > 0){
			if(e.get(0) < min.get(0)) min = e;
		}	
		return min;
	}
	
	public int stillExist(ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c, ArrayList<Integer> d, ArrayList<Integer> e){
		int count = 0;
		if(a.size() > 0) count++;
		if(b.size() > 0) count++;
		if(c.size() > 0) count++;
		if(d.size() > 0) count++;
		if(e.size() > 0) count++;
		return count;
	}
	
	public ArrayList<Integer> getList(int[] a){
		ArrayList<Integer> A = new ArrayList<Integer>();
		for(int i: a){
			A.add(i);
		}
		return A;
	}

}
