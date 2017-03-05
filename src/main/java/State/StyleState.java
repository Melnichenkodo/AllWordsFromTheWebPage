package State;

/**
 * Created by 12032016 on 05.03.2017.
 */
public class StyleState implements State {

    private final char[] STYLE_END_TAG_LETTERS = {'<', '/', 's', 't', 'y', 'l', 'e', '>'};
    private int styleEndIndex = 0;

    private HtmlAnalyzer analyzer;

    StyleState(HtmlAnalyzer analyzer) {

        this.analyzer = analyzer;
    }

    public void analyze(char letter) {
        if (STYLE_END_TAG_LETTERS[styleEndIndex] == letter) {
            if (styleEndIndex == 7) {
                analyzer.setState(analyzer.getNotWordState());
                styleEndIndex = 0;
            } else {
                styleEndIndex += 1;
            }
        }
    }
}
