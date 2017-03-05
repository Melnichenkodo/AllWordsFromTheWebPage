import State.HtmlAnalyzer;

import java.util.List;

/**
 * Created by 12032016 on 05.03.2017.
 */
public class HtmlParser {

    public HtmlParser() {

    }

    static List findHtmlTags(StringBuilder htmlDocument) {

        HtmlAnalyzer analyzer = new HtmlAnalyzer();

        for (int i = 0; i < htmlDocument.length(); i++) {
            analyzer.analyze(htmlDocument.charAt(i));
        }

        return analyzer.getResult();
    }
}
