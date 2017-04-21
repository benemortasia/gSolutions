package googleAnswer;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Answer {

	/*
	 * input: abccbaabccba | output: 2 | {abccba} x 2
	 * 
	 * input: abcabcabcabc | output: 4 | {abc} x 4
	 * 
	 * -- Returns the maximum number of equal parts
	 * -- Can not have a remainder
	 * -- Less than 200 characters in length
	 * 
	 * e.g.,
	 * input: abaaaba
	 * Character sequences:
	 * -> [a, ab, aba, abaa, abaaa, abaaab, abaaaba]
	 * Occurrences of each sequence within original string:
	 * -> [5, 2, 2, 1, 1, 1, 1]
	 * index(2) looks good because to the left is equal, to the right is smaller.
	 * -> index(2) -> {aba}
	 * However, {aba}{aba} leaves an a, So it can't be {aba}.
	 * {a} certainly won't work as there are still b's left.
	 * {ab} certainly won't work as there are still a's left.
	 * The only answer it can be is the string itself, {abaaaba}.
	 */
	public static void main(String[] args) {
		// final String s = new String("abccbaabccba");
		// final String s = new String("abcabcabcabc");
		final String s = new String("aaaaaaaaaa");
		System.out.println("Answer: " + answer(s));
	}

	public static int answer(String s) {
		System.out.println("String is: " + s);

		// no cake :(
		if (s.isEmpty() || !(Character.isAlphabetic(s.charAt(0))))
			return 0;
		else if (s.length() == 1) // one character means only one part lol
			return 1;
		else {
			// make sure it's less than 200 characters
			s = s.substring(0, Math.min(s.length(), 199));

			// need to retain order of sequences (small to big)
			final LinkedList<String> list = new LinkedList<String>();

			// also need to somehow assign counts to each sequence...
			// <String, Integer> -> <sequence, count> works
			final Map<String, Integer> occ = new LinkedHashMap<String, Integer>();

			// count number of occurrences for each sequence
			// get and return a max value for those occurrences
			// also need an index for checking sequences in s
			int count = 0;
			// int max = 0;
			int index = 0;

			// add each unique sequence to the set
			for (int i = 1; i < s.length() + 1; ++i) {
				list.add(s.substring(0, i));
			} // end for()

			// only one character

			// put() all sequences into Map
			for (final String seq : list) {
				System.out.println("Sequence detected: " + seq);
				index = 0;

				while (index != -1)
				{
					index = s.indexOf(seq, index);

					if(index != -1)
					{
						++count;
						index += seq.length();
						continue;
					} // end if()
					System.out.println("Count of sequence: " + seq + " = " + count);
					occ.put(seq, count);
					count = 0;
				} // end while()

			} // end for each seq in list

			// we have one character. just return the whole string
			if (occ.values().size() == 1)
				return s.length();

			// occ = [a, ab, abc, abcc, abccb, abccba, abccbaa, abccbaab, abccbaabc, abccbaabcc, abccbaabccb, abccbaabccba]
			// occ = [4, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1];
			System.out.println("Occurrences: " + occ.values());

			// TODO
			// Take the rightmost count which is both:
			// equal to left count and greater than right count
			// check the sequence corresponding to that count against original String s
			// if no remaining chars
			// return max;
			// else
			// return 1;

			for (final int c : occ.values()) {

			} // end for each count in values

			return 1;
		} // end else
	} // end answer()
} // end class Answer