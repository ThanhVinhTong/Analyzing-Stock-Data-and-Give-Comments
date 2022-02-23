package sentence;

import java.util.ArrayList;

public class Sentence {
	private ArrayList<String> sentence = new ArrayList<String>();

	public Sentence() {
	}

	public ArrayList<String> getSentence() {
		return sentence;
	}

	public void setSentence(ArrayList<String> sentence) {
		for (String i:sentence) {
			this.sentence.add(i);
		}
	}
}
