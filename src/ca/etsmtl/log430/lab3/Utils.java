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
	
	public static<T> boolean contains(Iterable<T> iterable, final T value) {
		return null != find(iterable, new Predicate<T>() {
			@Override
			public boolean run(T t) {
				return t == value;
			}
		});
	}
}
