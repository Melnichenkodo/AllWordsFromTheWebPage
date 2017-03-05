package State;

/**
 * Created by 12032016 on 05.03.2017.
 */
public class AttributeState implements State {

    private HtmlAnalyzer analyzer;

    AttributeState(HtmlAnalyzer analyzer) {

        this.analyzer = analyzer;
    }

    public void analyze(char letter) {
        switch (letter) {
            case '\"':
                analyzer.setState(analyzer.getInsideTagState());
                break;
            default:
                break;
        }

    }
}
