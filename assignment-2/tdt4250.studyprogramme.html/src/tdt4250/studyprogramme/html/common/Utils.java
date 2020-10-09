package tdt4250.studyprogramme.html.common;

import java.util.ArrayList;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import java.lang.Integer;

import tdt4250.studyprogramme.Season;

public class Utils {

	public Season getSeason(Season fromSeason, int term) {
		ArrayList<Season> seasonOrder = new ArrayList<Season>();
		seasonOrder.add(Season.AUTUMN);
		seasonOrder.add(Season.SPRING);
		int offset = seasonOrder.indexOf(fromSeason) +1;
		Season season2 = seasonOrder.get((term + offset) % 2);
		
		return season2;	
	}
	
	public int termToYearNumber(int term) {
		return (int) Math.ceil((float) term / 2);
	}
	
	public EList<Integer> yearToTerm(int year) {
		BasicEList<Integer> terms = new BasicEList<Integer>();
		terms.add(year*2-1);
		terms.add(year*2);
		return terms;
	}
	
	public static String getNameID(EObject cfe) {
		String className = cfe.getClass().getName();
		String nameID = className + "#" + cfe.hashCode();
		return nameID;
	}
}
