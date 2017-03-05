package State;

/**
 * Created by 12032016 on 05.03.2017.
 */
public class ScriptState implements State {

    private final char[] SCRIPT_END_TAG_LETTERS = {'<', '/', 's', 'c', 'r', 'i', 'p', 't', '>'};

    private int scriptEndIndex = 0;

    private HtmlAnalyzer analyzer;

    ScriptState(HtmlAnalyzer analyzer) {

        this.analyzer = analyzer;
    }

    public void analyze(char letter) {
        if (SCRIPT_END_TAG_LETTERS[scriptEndIndex] == letter) {
            if (scriptEndIndex == 8) {
                analyzer.setState(analyzer.getNotWordState());
                scriptEndIndex = 0;
            } else {
                scriptEndIndex += 1;
            }
        }
    }
}
