package State;

/**
 * Created by 12032016 on 05.03.2017.
 */
public class NotWordState implements State {

    private final String START_WORD_LETTERS = "0123456789abcdefghijklmnopqrstuvwxyzабвгдеёжзийклмнопрстуфхцчшщъыьэюяєїі";

    private HtmlAnalyzer analyzer;

    NotWordState(HtmlAnalyzer analyzer) {
        this.analyzer = analyzer;
    }


    public void analyze(char letter) {
        if (letter == '<') {
            analyzer.setState(analyzer.getOpenTagState());
        } else if (START_WORD_LETTERS.contains(Character.toString(letter))) {
            analyzer.addLetterToWord(letter);
            analyzer.setState(analyzer.getWordState());
        }
    }
}
