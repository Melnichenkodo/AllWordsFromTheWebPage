package State;

/**
 * Created by 12032016 on 05.03.2017.
 */
public class InsideTagState implements State {

    private HtmlAnalyzer analyzer;

    InsideTagState(HtmlAnalyzer analyzer) {

        this.analyzer = analyzer;
    }

    public void analyze(char letter) {
        switch (letter) {
            case '\"':
                analyzer.setState(analyzer.getAttributeState());
                break;
            case '>':
                analyzer.setState(analyzer.getNotWordState());
                break;
            default:
                break;
        }

    }
}
