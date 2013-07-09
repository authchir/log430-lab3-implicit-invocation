package ca.etsmtl.log430.lab3;

public class Utils {
	public static<T> T find(Iterable<T> iterable, Predicate<T> predicate) {
		for (T t : iterable) {
			if (predicate.run(t)) {
				return t;
			}
		}
		
		return null;
	}
}
