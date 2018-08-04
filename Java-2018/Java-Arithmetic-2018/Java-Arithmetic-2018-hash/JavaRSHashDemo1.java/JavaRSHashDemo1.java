// JavaRSHashDemo1.java

class JavaRSHashDemo1{
	public static void main(String[] args){
		String[] A_strKeys = {"C", "C++", "Java", "C#", "Python", "Go", "Scala", "vb.net", "JavaScript", "PHP", "Perl", "Ruby"};
		int nCount = A_strKeys.length;

		for(int i = 0; i < nCount; i++){
			int nHash = RSHash(A_strKeys[i]);
			System.out.println( String.format("%-10d %-15s %12d %3d", i, A_strKeys[i], nHash, nHash % 31) );
		}
	}

	public static int RSHash(String s){
		int n = s.length();
		int b = 378551;
		int a = 63689;
		int nHash = 0;
		for(int i = 0; i < n; i++){
			nHash = nHash * a + s.charAt(i);
			a = a * b;
		}
		return nHash & 0x7fffffff;
	}
}

/*
0          C                         67   5
1          C++               1535458403   7
2          Java              1675714860   2
3          C#                 431117552  25
4          Python             481257876  19
5          Go                 232492024  22
6          Scala             1047644580  14
7          vb.net             550038443  18
8          JavaScript         711855001  17
9          PHP               1664999048  22
10         Perl               340008717   4
11         Ruby               677893036   9
*/
