package State;

/**
 * Created by 12032016 on 05.03.2017.
 */
public class WordState implements State {

    private final String VALID_LETTERS = "0123456789abcdefghijklmnopqrstuvwxyzабвгдеёжзийклмнопрстуфхцчшщъыьэюяєїі'-";
    private final String END_WORD_LETTERS = " ;,.;=/\\";
    private final String NEW_TAG_SYMBOL = "<";

    private HtmlAnalyzer analyzer;

    WordState(HtmlAnalyzer analyzer) {

        this.analyzer = analyzer;
    }

    public void analyze(char letter) {
        if (VALID_LETTERS.contains(Character.toString(letter))) {
            analyzer.addLetterToWord(letter);
        } else if (NEW_TAG_SYMBOL.contains(Character.toString(letter))) {
            analyzer.addCurrentWordToResult();
            analyzer.setState(analyzer.getOpenTagState());
        } else if (END_WORD_LETTERS.contains(Character.toString(letter))) {
            analyzer.addCurrentWordToResult();
            analyzer.setState(analyzer.getNotWordState());
        }
    }
}
