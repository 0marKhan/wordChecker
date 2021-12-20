import java.util.Vector;

public class word{
	Vector<String> words = new Vector<String>();
	Vector freq = new Vector();
	void addWord(String w)	//adding word to vector
	{
		words.add(w) ;
		freq.add(1) ;
	}
	int getFreq(String s)	//finds frequency of word at certain index of vector
	{
		int tmp = (int) freq.elementAt(words.indexOf(s)) ;
		return tmp ;
	}
	void display()
	{
		System.out.println(words);
		System.out.println(freq);
	}
	void incFreq(String s)	//gets index of word, finds its frequency and change its value
	{
		int i = words.indexOf(s) ;
		int j = (int) freq.elementAt(i) ;
		j++;
		freq.set(i,j) ;
	}
	boolean search(String s)	//checking if vector equals word to search
	{
		for(int i=0;i<words.size();i++)
		{
			if(s.equals(words.elementAt(i)))
			{
				return false ;
			}
		}
		return true ;
	}
	public int wordfound(String str,Vector<String> V) {	//checking vectors for word
		int count=0;
		for(int i=0;i<V.size();i++) {
			if((str.compareToIgnoreCase(V.elementAt(i)))==0) {
				count++;
			}
		}
		return count;
	}
}
