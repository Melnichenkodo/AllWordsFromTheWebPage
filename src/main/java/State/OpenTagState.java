package State;

/**
 * Created by 12032016 on 05.03.2017.
 */
public class OpenTagState implements State {

    //    private final String SCRIPT_TAG_LETTERS = "script";
    private final char[] SCRIPT_TAG_LETTERS = {'s', 'c', 'r', 'i', 'p', 't'};
    int scriptIndex = 0;

    private final char[] STYLE_TAG_LETTERS = {'s', 't', 'y', 'l', 'e'};
    int styleIndex = 0;

    private final String VALID_LETTERS = "/!abcdefghijklmnopqrstuvwxyz";

    private HtmlAnalyzer analyzer;

    OpenTagState(HtmlAnalyzer analyzer) {

        this.analyzer = analyzer;
    }

    public void analyze(char letter) {


        if (SCRIPT_TAG_LETTERS[scriptIndex] == letter ||
                STYLE_TAG_LETTERS[styleIndex] == letter) {

            if (SCRIPT_TAG_LETTERS[scriptIndex] == letter) {
                if (scriptIndex == 5) {
                    analyzer.setState(analyzer.getScriptState());
                    scriptIndex = 0;
                } else {
                    scriptIndex += 1;
                }
            } else {
                scriptIndex = 0;
            }
            if (STYLE_TAG_LETTERS[styleIndex] == letter) {
                if (styleIndex == 4) {
                    analyzer.setState(analyzer.getStyleState());
                    styleIndex = 0;
                } else {
                    styleIndex += 1;
                }
            } else {
                styleIndex = 0;
            }
        } else {
            if (VALID_LETTERS.contains(Character.toString(letter))) {
                scriptIndex = 0;
                styleIndex = 0;
                analyzer.setState(analyzer.getInsideTagState());
            } else {
                scriptIndex = 0;
                styleIndex = 0;
                analyzer.setState(analyzer.getNotWordState());
            }
        }
    }
}

