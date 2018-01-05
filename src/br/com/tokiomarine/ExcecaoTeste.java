package br.com.tokiomarine;

public class ExcecaoTeste {

	public static void main(String[] args) {
		System.out.println(outroMetodo("5") + outroMetodo("0"));
	}

	private static String outroMetodo(String v) {
		String r = v;
		try {
			ummetodo(v);
		} catch (IllegalArgumentException e) {
			r = e.getMessage();
		} catch (Exception e) {
			return "2";
		} finally {
			if (r.equals(v)) {
				r = "3";
			}
		}
		return r;
	}

	private static void ummetodo(String v) {
		if (v.equals("0"))
			throw new IllegalArgumentException("4");
	}

}
