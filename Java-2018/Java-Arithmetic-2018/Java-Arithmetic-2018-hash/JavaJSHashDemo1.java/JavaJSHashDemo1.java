// JavaJSHashDemo1.java

class JavaJSHashDemo1{
	public static void main(String[] args){
		String[] A_strKeys = {"C", "C++", "Java", "C#", "Python", "Go", "Scala", "vb.net", "JavaScript", "PHP", "Perl", "Ruby"};
		int nCount = A_strKeys.length;

		for(int i = 0; i < nCount; i++){
			int nHash = JSHash(A_strKeys[i]);
			System.out.println( String.format("%-10d %-15s %12d %3d", i, A_strKeys[i], nHash, nHash % 31) );
		}
	}

	public static int JSHash(String s){
		int nHash = 1315423911;
		int n = s.length();
		for(int i = 0; i < n; i++){
			nHash ^= ((nHash << 5) + s.charAt(i) + (nHash >> 2));
		}
		return nHash & 0x7fffffff;
	}
}

